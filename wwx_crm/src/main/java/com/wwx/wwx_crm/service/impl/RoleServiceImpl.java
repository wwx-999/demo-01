package com.wwx.wwx_crm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wwx.wwx_crm.entity.DeptRole;
import com.wwx.wwx_crm.entity.Role;
import com.wwx.wwx_crm.mapper.RoleMapper;
import com.wwx.wwx_crm.service.RoleService;
import com.wwx.wwx_crm.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper,Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public IPage<Role> selectList(Page<Role> page) {
        return roleMapper.selectList(page);
    }

    @Override
    public Integer add(Role role,Integer deptId) {
        role.setCreateTime(StringUtils.getNowTime());
        role.setUpdateTime(StringUtils.getNowTime());
        role.setIsDel(0);
        int result = roleMapper.insert(role);

        int roleId = role.getRoleId();
        DeptRole deptRole = new DeptRole(roleId,deptId);
        deptRole.setCreateTime(StringUtils.getNowTime());
        deptRole.setUpdateTime(deptRole.getCreateTime());
        deptRole.setIsDel(0);
        return result;
    }

    @Override
    public Integer update(Role role) {
        role.setUpdateTime(StringUtils.getNowTime());
        int result = roleMapper.updateById(role);
        return result;
    }
}
