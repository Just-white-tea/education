package com.vip.order.domain.entity;

import lombok.Data;

@Data
public class EOrder {
    private Integer eOrderId;

    private Integer eTeacherId;

    private Integer eCampusId;

    private Integer eParentId;

    private Double eOrderPrice;

    private Integer eCouponId;

    private Integer eoState;

    private Integer eCourseId;
}