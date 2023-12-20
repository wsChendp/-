package com.example.remake.controller;

import com.example.remake.entry.Coach;
import com.example.remake.service.CoachService;
import com.example.remake.vo.CCustomerNum;
import com.example.remake.vo.CoachIncome;
import com.example.remake.vo.IncomePresent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Coach")
public class CoachController {
    @Autowired
    private CoachService coachService;

    @GetMapping("/CulPersonNum")
    public List<CCustomerNum> cul_person(){
        return coachService.cul_person();
    }
    @GetMapping("/SearchCoach")
    public List<Coach> SearchCoach(@RequestParam String name){
        return coachService.searchCoach(name);
    }
    @GetMapping("/CoachIncome")
    public List<IncomePresent> getCoachIncome(){
        return coachService.getCoachIncome();
    }
//    注意这里没有处理教练不存在的情况
}
