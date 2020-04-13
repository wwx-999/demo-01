package com.wwx.wwx_crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {
    private String createTime;
    private String updateTime;
    private Integer isDel;
}
