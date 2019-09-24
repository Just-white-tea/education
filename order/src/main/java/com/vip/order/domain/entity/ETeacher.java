package com.vip.order.domain.entity;

import lombok.Data;

@Data
public class ETeacher {
    private Integer eTeacherId;

    private String eTeacherName;

    private String eTeacherPassword;

    private String etIsDelete;

    private Integer eCampusId;
}