package com.wwx.wwx_crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpRole extends BaseEntity{
    private Integer empId;
    private Integer roleId;
}
