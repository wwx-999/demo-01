package com.wwx.wwx_crm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wwx.wwx_crm.entity.Role;
import com.wwx.wwx_crm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/role")
    public List<Role> roles(){
        return roleService.list();
    }

    /**
     * 查询所有职位
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/role/list")
    public Map getList(Integer page, Integer limit ){
        Map<String,Object> map = new HashMap<String,Object>();

        //设置mybatisPlus分页
        Page<Role> p = new Page<Role>();
        p.setSize(limit);       //设置每页记录数
        p.setCurrent(page);     //设置当前页码

        IPage<Role> iPage = roleService.selectList(p);

        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }

    /**
     * 新增职位
     */
    @PostMapping("/role/add")
    public Map add(Role role,Integer deptId){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("state",roleService.add(role, deptId));
        return result;
    }

    /**
     *  删除用户
     */
    @DeleteMapping("/role/del/{roleId}")
    public Map del(@PathVariable Integer roleId){
        Role role = new Role();
        role.setRoleId(roleId);
        role.setIsDel(1);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",roleService.updateById(role));
        return result;
    }

    /**
     *  修改用户
     */
    @PutMapping("/role/edit")
    public Map edit(Role role){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",roleService.update(role));
        return result;
    }
}
