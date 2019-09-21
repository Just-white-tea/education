package com.vip.account.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.vip.account.domain.entity.EParent;
import org.apache.ibatis.annotations.Param;

public interface EParentMapper {

    @DS("one")
    EParent selectParent(@Param("eParent")EParent eParent);

    int insertParent(@Param("eParent")EParent eParent);

    int updatePassword(@Param("eParent")EParent eParent);
}