package com.vip.order.mapper;

import com.vip.order.domain.entity.ETeachPlan;

public interface ETeachPlanMapper {
    int deleteByPrimaryKey(Integer eTeacherId);

    int insert(ETeachPlan record);

    int insertSelective(ETeachPlan record);

    ETeachPlan selectByPrimaryKey(Integer eTeacherId);

    int updateByPrimaryKeySelective(ETeachPlan record);

    int updateByPrimaryKey(ETeachPlan record);
}