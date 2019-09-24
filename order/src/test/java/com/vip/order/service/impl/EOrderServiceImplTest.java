package com.vip.order.service.impl;

import com.vip.order.domain.entity.EOrder;
import com.vip.order.domain.entity.EOrderList;
import com.vip.order.domain.vo.EOrderVo;
import com.vip.order.service.EOrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class EOrderServiceImplTest {

    @Resource
    EOrderService eOrderService;

    @Test
    public void addOrder() {
        EOrder eOrder=new EOrder();
        eOrder.setECampusId(1);
        eOrder.setECouponId(1);
        eOrder.setECourseId(2);
        eOrder.setEOrderPrice(2000.0);
        eOrder.setEParentId(3);
        eOrder.setETeacherId(2);
        List<Integer> stu=new ArrayList<>();
        stu.add(1);
        stu.add(2);
        stu.add(3);
        Integer integer = eOrderService.addOrder(eOrder, stu);
        System.out.println(integer);
    }

    @Test
    public void queryOrder() {
//        List<EOrderVo> eOrderVos = eOrderService.queryOrder(3);
//        for (EOrderVo eOrderVo : eOrderVos) {
//            System.out.println(eOrderVo.getECampusId());
//            System.out.println(eOrderVo.getECouponId());
//            System.out.println(eOrderVo.getEParentId());
//            System.out.println(eOrderVo.toString());
//        }
//        eOrderVos.forEach(eOrderVo -> System.out.println(eOrderVos.toString()));
    }
}