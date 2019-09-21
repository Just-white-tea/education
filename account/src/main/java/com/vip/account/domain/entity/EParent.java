package com.vip.account.domain.entity;

import lombok.Data;

@Data
public class EParent {
    private Integer eParentId;

    private String eParentName;

    private String eParentPassword;

    private String eParentPhone;

    private Integer epIsDelete;
}