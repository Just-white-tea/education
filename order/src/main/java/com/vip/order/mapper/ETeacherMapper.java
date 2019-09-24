package com.vip.order.mapper;

import com.vip.order.domain.entity.ETeacher;

public interface ETeacherMapper {
    int deleteByPrimaryKey(Integer eTeacherId);

    int insert(ETeacher record);

    int insertSelective(ETeacher record);

    ETeacher selectByPrimaryKey(Integer eTeacherId);

    int updateByPrimaryKeySelective(ETeacher record);

    int updateByPrimaryKey(ETeacher record);
}