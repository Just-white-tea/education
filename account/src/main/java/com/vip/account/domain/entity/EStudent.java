package com.vip.account.domain.entity;

import lombok.Data;

@Data
public class EStudent {
    private Integer eStudentId;

    private String eStudentName;

    private String eStudentGrade;

    private Integer esIsDelete;

    private Integer eParentId;
}