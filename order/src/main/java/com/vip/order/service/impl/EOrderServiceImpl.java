package com.vip.order.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.vip.order.domain.entity.EOrder;
import com.vip.order.domain.entity.EOrderList;
import com.vip.order.domain.vo.EOrderAll;
import com.vip.order.domain.vo.EOrderVo;
import com.vip.order.mapper.EOrderListMapper;
import com.vip.order.mapper.EOrderMapper;
import com.vip.order.service.EOrderService;
import com.vip.order.utils.NetMessage;
import lombok.Builder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Builder
public class EOrderServiceImpl implements EOrderService {
    @Resource
    EOrderMapper eOrderMapper;
    @Resource
    EOrderListMapper eOrderListMapper;

    @Override
    public Integer addOrder(EOrder eOrder, List<Integer> studentId) {
        Integer orderRow = eOrderMapper.addEOrder(eOrder);
        //获取主键
        int orderId=eOrder.getEOrderId();
        //添加订单学员表
        Integer stuRow = eOrderListMapper.addOrderStu(orderId, studentId);
        if (orderRow>0&stuRow>0){
            return 200;
        }else {
            return 401;
        }
    }

    @Override
    @DS("one")
    public EOrderAll queryOrder(Integer parentId) {
        List<EOrderVo> eOrderVos = eOrderMapper.queryOrder(parentId);
        Map<String,String> map=new HashMap<>();
        map.put("eStudentId","1");
        String url="http://10.3.135.53:8080/account/selectStudent";
        String netMessage = NetMessage.getNetMessage(url, map);
        String estudentName = NetMessage.getJsonArrayMes(netMessage, "estudentName");
        EOrderAll query = EOrderAll.query(eOrderVos, estudentName);
        if (eOrderVos!=null){
            return query;
        }
        return null;
    }
}
