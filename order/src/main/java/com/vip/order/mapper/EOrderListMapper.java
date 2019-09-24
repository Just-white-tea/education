package com.vip.order.mapper;

import com.vip.order.domain.entity.EOrderList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EOrderListMapper {
    //增加订单学员信息
    Integer addOrderStu(@Param("orderId") Integer OrderId,@Param("studentId") List<Integer> studentId);
}