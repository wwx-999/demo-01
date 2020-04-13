package com.wwx.wwx_crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wwx.wwx_crm.entity.EmpRole;
import com.wwx.wwx_crm.entity.Employee;
import com.wwx.wwx_crm.mapper.EmpRoleMapper;
import com.wwx.wwx_crm.mapper.EmployeeMapper;
import com.wwx.wwx_crm.service.EmployeeService;
import com.wwx.wwx_crm.utils.ShiroUtils;
import com.wwx.wwx_crm.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmpRoleMapper empRoleMapper;

    @Override
    public IPage<Employee> selectList(Page<Employee> page) {
        return employeeMapper.selectList(page);
    }

    @Override
    public Employee selectByName(String empName) {
        return employeeMapper.selectByName(empName);
    }

    @Override
    public Integer add(Employee employee, Integer roleId) {
        employee.setSalt(ShiroUtils.randomSalt());
        employee.setPwd(ShiroUtils.encryptPassword(employee.getPwd(),employee.getCredentialsSalt()));

        employee.setCreateTime(StringUtils.getNowTime());
        employee.setUpdateTime(employee.getCreateTime());
        employee.setIsDel(0);
        int result = employeeMapper.insert(employee);

        int empId = employee.getEmpId();
        EmpRole empRole = new EmpRole(empId,roleId);
        empRole.setCreateTime(StringUtils.getNowTime());
        empRole.setUpdateTime(empRole.getCreateTime());
        empRole.setIsDel(0);

        empRoleMapper.insert(empRole);
        return result;
    }

    @Override
    public Integer update(Employee employee,Integer roleId) {
        //判断用户是否输入密码，如果没有，获取的就是空字符串，就不修改密码
        if (!"".equals(employee.getPwd())){
            //从ShiroUtils类中随机生成盐
            employee.setSalt(ShiroUtils.randomSalt());
            employee.setPwd(ShiroUtils.encryptPassword(employee.getPwd(),employee.getCredentialsSalt()));
        }else {
            employee.setPwd(null);
        }
        employee.setUpdateTime(StringUtils.getNowTime());
        //将信息更新到数据库中
        int result = employeeMapper.updateById(employee);

        EmpRole empRole = new EmpRole(employee.getEmpId(),roleId);
        empRole.setUpdateTime(StringUtils.getNowTime());
        AbstractWrapper wrapper = new QueryWrapper();
        wrapper.eq("emp_id",employee.getEmpId());
        empRoleMapper.update(empRole,wrapper);
        return result;
    }
}
