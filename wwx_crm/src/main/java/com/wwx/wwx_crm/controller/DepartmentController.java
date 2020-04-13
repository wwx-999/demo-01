package com.wwx.wwx_crm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wwx.wwx_crm.entity.Department;
import com.wwx.wwx_crm.entity.Role;
import com.wwx.wwx_crm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/dep")
    public List<Department> roles(){
        return departmentService.list();
    }

    /**
     * 查询所有职位
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/dep/list")
    public Map getList(Integer page, Integer limit ){
        Map<String,Object> map = new HashMap<String,Object>();

        //设置mybatisPlus分页
        Page<Department> p = new Page<Department>();
        p.setSize(limit);       //设置每页记录数
        p.setCurrent(page);     //设置当前页码

        IPage<Department> iPage = departmentService.selectList(p);

        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }

    /**
     * 新增职位
     */
    @PostMapping("/dep/add")
    public Map add(Department department){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("state",departmentService.add(department));
        return result;
    }

    /**
     *  删除用户
     */
    @DeleteMapping("/dep/del/{deptId}")
    public Map del(@PathVariable Integer deptId){
        Department department = new Department();
        department.setDeptId(deptId);
        department.setIsDel(1);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",departmentService.updateById(department));
        return result;
    }

    /**
     * 修改用户
     * @param department
     * @return
     */
    @PutMapping("/dep/edit")
    public Map edit(Department department){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",departmentService.update(department));
        return result;
    }
}
