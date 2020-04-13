package com.wwx.wwx_crm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wwx.wwx_crm.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper extends BaseMapper<Role> {
    IPage<Role> selectList(Page<Role> page);
}