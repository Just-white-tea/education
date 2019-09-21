package com.vip.account.service.impl;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.vip.account.domain.entity.EParent;
import com.vip.account.domain.entity.EStudent;
import com.vip.account.mapper.ECouponMapper;
import com.vip.account.mapper.EParentMapper;
import com.vip.account.mapper.EStudentMapper;
import com.vip.account.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    EParentMapper eParentMapper;
    @Resource
    EStudentMapper eStudentMapper;
    @Resource
    ECouponMapper eCouponMapper;


    //家长登录
    @Override
    @DS("one")
    public EParent parentLogin(String eParentName ,String eParentPassword){
        EParent eParent =new EParent();
        eParent.setEParentName(eParentName);
        EParent parent= eParentMapper.selectParent(eParent);
        if(eParentPassword.equals(parent.getEParentPassword())){
            return parent;
        } else {
            return null;
        }
    }

    //家长注册
    @Override
    public int parentRegister(String eParentName, String eParentPassword,String eParentPhone){
        EParent eParent =new EParent();
        eParent.setEParentName(eParentName);
        eParent.setEParentPassword(eParentPassword);
        eParent.setEParentPhone(eParentPhone);
        EParent text =eParentMapper.selectParent(eParent);
        if (text == null) {
            return eParentMapper.insertParent(eParent);
        }else {
            return 0;
        }
    }
    //家长修改密码
    @Override
    public int resetPassword(Integer eParentId, String oldPassword,String newPassword){
        EParent eParent =new EParent();
        eParent.setEParentId(eParentId);

        if (oldPassword.equals(eParentMapper.selectParent(eParent).getEParentPassword())) {
            eParent.setEParentPassword(newPassword);
            return eParentMapper.updatePassword(eParent);
        }else {
            return 0;
        }
    }

    //查询学员
    @Override
    @DS("one")
    public List<EStudent> selectStuent(Integer eStudentId,Integer eParentId,String eStudentName){
        EStudent eStudent = new EStudent();
        if(eStudentId !=null){
            eStudent.setEStudentId(eStudentId);
        }else if (eParentId!=null){
            eStudent.setEParentId(eParentId);
        }else if (eStudentName!=null){
            eStudent.setEStudentName(eStudentName);
        }
        return eStudentMapper.selectStudent(eStudent);
    }

    //新增学员
    @Override
    public int insertStudent(String eStudentName,String eStudentGrade,Integer eParentId){
        EStudent student =new EStudent();
        student.setEParentId(eParentId);
        student.setEStudentName(eStudentName);
        student.setEStudentGrade(eStudentGrade);
        List text =eStudentMapper.selectStudent(student);
        if(text == null){
            eStudentMapper.insertStudent(student);
            return 1;
        }else {
            return 0;
        }
    }
    //删除学员
    @Override
    public int deleteStudent(Integer eStudentId){
        return eStudentMapper.deleteStudent(eStudentId);
    }
    //查看优惠券
    @Override
    @DS("one")
    public List selectCoupon(Integer eParentId){
        return eCouponMapper.selectCoupon(eParentId);
    }
    //使用优惠券
    @Override
    public int useCoupon(Integer couponId){
        return eCouponMapper.useCoupon(couponId);
    }

}
