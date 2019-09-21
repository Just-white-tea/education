package com.vip.account.service;


import com.vip.account.domain.entity.EParent;
import com.vip.account.domain.entity.EStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountService {
    //家长用户登录
    EParent parentLogin(String eParentName ,String eParentPassword);
    //查询学员
    List<EStudent> selectStuent(Integer eStudentId, Integer eParentId,String eStudentName);
    //新增学员
    int insertStudent(String eStudentName,String eStudentGrade,Integer eParentId);
    //删除学员
    int deleteStudent(Integer eStudentId);
    //查看优惠券
    List selectCoupon(Integer eParentId);
    //使用优惠券
    int useCoupon(Integer couponId);
    //家长修改密码
    int resetPassword(Integer eParentId, String oldPassword,String newPassword);
    //家长注册
    int parentRegister( String eParentName, String eParentPassword,String eParentPhone);
}
