package com.vip.order.domain.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EOrderAll {
    private List<EOrderVo> eOrderVo;
    private String estudentName;

    public static EOrderAll query(List<EOrderVo> eOrderVo,String estudentName){
        return new EOrderAllBuilder()
                .eOrderVo(eOrderVo)
                .estudentName(estudentName)
                .build();
    }
}
