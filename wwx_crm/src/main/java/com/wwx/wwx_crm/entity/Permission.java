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
public class Permission extends BaseEntity{
    @TableId(type = IdType.AUTO)
    private Integer permId;

    private String permName;

    private String url;

    private String permission;



}