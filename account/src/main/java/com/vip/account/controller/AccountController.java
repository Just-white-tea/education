package com.vip.account.controller;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.vip.account.domain.entity.EParent;
import com.vip.account.domain.entity.EStudent;
import com.vip.account.service.AccountService;
import com.vip.account.utils.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/account")
@Slf4j
public class AccountController {

    @Resource
    AccountService accountService;



    @DS("one")
    @GetMapping("/parentLogin")
    public EParent parentLogin(String eParentName ,String eParentPassword){
        return accountService.parentLogin(eParentName,eParentPassword);
    }
    @PostMapping("/parentRegister")
    public int parentRegister(String eParentName, String eParentPassword,String eParentPhone){
        return accountService.parentRegister(eParentName, eParentPassword, eParentPhone);
    }
    @PostMapping("/resetPassword")
    public int resetPassword(Integer eParentId, String oldPassword,String newPassword){
        return accountService.resetPassword(eParentId, oldPassword, newPassword);
    }

    @DS("one")
    @GetMapping("/selectStudent")
    public List<EStudent> selectStudent(
            @RequestParam(value = "eStudentId",required = false)Integer eStudentId,
            @RequestParam(value = "eParentId" ,required = false)Integer eParentId,
            @RequestParam(value = "eStudentName" ,required = false)String eStudentName
    ){
        return accountService.selectStuent(eStudentId,eParentId,eStudentName);
    }

    @PostMapping("/deleteStudent")
    public int deleteStudent(Integer eStudentId){
        return accountService.deleteStudent(eStudentId);
    }

    @PostMapping("/insertStudent")
    public int insertStudent(String eStudentName,String eStudentGrade,Integer eParentId){
        return accountService.insertStudent( eStudentName, eStudentGrade, eParentId);
    }

    //查看优惠券
    @DS("one")
    @GetMapping("/selectCoupon")
    public List selectCoupon(Integer eParentId){
        return accountService.selectCoupon(eParentId);
    }
    //使用优惠券
    @PostMapping("/useCoupon")
    public int useCoupon(Integer couponId){
        return accountService.useCoupon(couponId);
    }

}
