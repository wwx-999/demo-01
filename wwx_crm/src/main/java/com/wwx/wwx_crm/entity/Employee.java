package com.wwx.wwx_crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("employee")
public class Employee extends BaseEntity{
    @TableId(type = IdType.AUTO)
    private Integer empId;

    private String empName;

    private String pwd;

    private String salt;

    private Integer age;

    private String sex;

    private String phone;

    private String address;


    /**
     * 密码盐. 重新对盐重新进行了定义，用户名+salt，这样就更加不容易被破解
     * @return
     */
    public String getCredentialsSalt(){
        return this.empName+this.salt;
    }

    @TableField(exist = false)
    private List<Role> roleList;

}