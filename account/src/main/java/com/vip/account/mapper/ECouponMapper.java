package com.vip.account.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.vip.account.domain.entity.ECoupon;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ECouponMapper {
    //查看用户优惠券
    @DS("one")
    List<ECoupon> selectCoupon(@Param("parentId") Integer parentId);
    //使用优惠券
    int useCoupon(@Param("couponId")Integer couponId);
}