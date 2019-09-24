package com.vip.order.domain.vo;

import com.vip.order.domain.entity.EOrder;
import com.vip.order.domain.entity.EOrderList;
import lombok.Data;

import java.util.List;

@Data
public class EOrderVo extends EOrder {
    private List<EOrderList> eOrderList;
}
