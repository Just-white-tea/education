package com.vip.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vip.order.domain.entity.EOrder;
import com.vip.order.domain.vo.EOrderVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EOrderMapper extends BaseMapper<EOrder> {
    //增加订单
    Integer addEOrder(@Param("eOrder") EOrder eOrder);
    //查询订单
    List<EOrderVo>queryOrder(@Param("parentId") Integer parentId);

}