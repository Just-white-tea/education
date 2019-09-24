package com.vip.order.service;

import com.vip.order.domain.entity.EOrder;
import com.vip.order.domain.entity.EOrderList;
import com.vip.order.domain.vo.EOrderAll;
import com.vip.order.domain.vo.EOrderVo;

import java.util.List;

public interface EOrderService {
    //增加订单
    Integer addOrder(EOrder eOrder, List<Integer> studentId);
    //查询订单
    EOrderAll queryOrder(Integer parentId);
}
