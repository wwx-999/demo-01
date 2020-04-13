package com.wwx.wwx_crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wwx.wwx_crm.entity.Department;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentMapper extends BaseMapper<Department> {

    IPage<Department> selectList(Page<Department> page);
}