package com.vip.order.controller;


import com.vip.order.domain.entity.EOrder;
import com.vip.order.domain.vo.EOrderAll;
import com.vip.order.domain.vo.EOrderVo;
import com.vip.order.service.EOrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    EOrderService eOrderService;

    @RequestMapping("/add")
    public Integer addOrder(EOrder eOrder, List<Integer> studentId){
        Integer row=0;
        try {
            row = eOrderService.addOrder(eOrder, studentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }
    @RequestMapping("/query")
    public EOrderAll queryOrder(Integer parentId){
        EOrderAll eOrderAll = eOrderService.queryOrder(parentId);
        return eOrderAll;
    }
}
