package com.wwx.wwx_crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department extends BaseEntity{

    @TableId(type = IdType.AUTO)
    private Integer deptId;

    private String deptName;




}