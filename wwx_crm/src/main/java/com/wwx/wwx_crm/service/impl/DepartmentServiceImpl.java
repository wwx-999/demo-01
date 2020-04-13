package com.wwx.wwx_crm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wwx.wwx_crm.entity.Department;
import com.wwx.wwx_crm.mapper.DepartmentMapper;
import com.wwx.wwx_crm.service.DepartmentService;
import com.wwx.wwx_crm.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public IPage<Department> selectList(Page<Department> page) {
        return departmentMapper.selectList(page);
    }

    @Override
    public Integer add(Department department) {
        department.setCreateTime(StringUtils.getNowTime());
        department.setUpdateTime(StringUtils.getNowTime());
        department.setIsDel(0);
        int result = departmentMapper.insert(department);
        return result;
    }

    @Override
    public Integer update(Department department) {
        department.setUpdateTime(StringUtils.getNowTime());
        int result = departmentMapper.updateById(department);
        return result;
    }
}
