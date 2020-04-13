package com.wwx.wwx_crm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wwx.wwx_crm.entity.Permission;
import com.wwx.wwx_crm.mapper.PermissionMapper;
import com.wwx.wwx_crm.service.PermissionService;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
}
