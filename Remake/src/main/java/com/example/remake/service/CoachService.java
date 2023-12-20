package com.example.remake.service;

import com.example.remake.entry.Coach;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.remake.vo.CCustomerNum;
import com.example.remake.vo.CoachIncome;
import com.example.remake.vo.IncomePresent;

import java.util.List;

/**
* @author DELL
* @description 针对表【coach】的数据库操作Service
* @createDate 2023-12-15 23:41:16
*/
public interface CoachService extends IService<Coach> {

    List<Coach> searchCoach(String name);

    List<CCustomerNum> cul_person();

    List<IncomePresent> getCoachIncome();
}
