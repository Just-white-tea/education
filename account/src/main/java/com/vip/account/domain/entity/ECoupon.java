package com.vip.account.domain.entity;

import lombok.Data;

@Data
public class ECoupon {
    private Integer eCouponId;

    private Double eCouponPrice;

    private Integer eParentId;

    private Integer ecoIsDelete;
}