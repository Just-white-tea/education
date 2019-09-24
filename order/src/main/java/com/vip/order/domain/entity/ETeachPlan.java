package com.vip.order.domain.entity;

import lombok.Data;

@Data
public class ETeachPlan {
    private Integer eTeacherId;

    private Integer eCourseId;

    private String etpRoom;

    private String etpTeachTime;
}