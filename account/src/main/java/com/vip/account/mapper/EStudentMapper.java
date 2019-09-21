package com.vip.account.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.vip.account.domain.entity.EStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EStudentMapper {


    //查看学员
    @DS("one")
    List<EStudent> selectStudent(@Param("student")EStudent student);
    //新增学员
    int insertStudent(@Param("student")EStudent student);
    //删除学员
    int deleteStudent(@Param("eStudentId") Integer eStudentId);
}