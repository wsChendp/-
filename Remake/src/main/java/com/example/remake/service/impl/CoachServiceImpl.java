package com.example.remake.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.remake.entry.Coach;
import com.example.remake.mapper.CoachMapper;
import com.example.remake.service.CoachService;
import com.example.remake.vo.CCustomerNum;
import com.example.remake.vo.CoachIncome;
import com.example.remake.vo.CustomerFee;
import com.example.remake.vo.IncomePresent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DELL
 * @description 针对表【coach】的数据库操作Service实现
 * @createDate 2023-12-15 23:41:16
 */
@Service
public class CoachServiceImpl extends ServiceImpl<CoachMapper, Coach>
        implements CoachService {
    @Autowired
    private CoachMapper coachMapper;

    @Override
    public List<Coach> searchCoach(String name) {
        return coachMapper.searchCoach();
    }

    @Override
    public List<CCustomerNum> cul_person() {
        return coachMapper.culPerson();
    }

    @Override
    public List<IncomePresent> getCoachIncome() {
        double sum = 0;
        List<CoachIncome> coachIncomes = coachMapper.getCoachIncome();
        double money = 0;
        for (CoachIncome it : coachIncomes) {
            for (CustomerFee ie : it.getCustomerfee()) {
                money += ie.getPrice();
            }
            it.setIncome(money);
            sum += money;
            money = 0;
        }
        List<IncomePresent> incomePresents = new ArrayList<>();
        for (CoachIncome ci : coachIncomes) {
            IncomePresent incomePresent1 = new IncomePresent();
            incomePresent1.setPTLastName(ci.getPTLastName());
            incomePresents.add(incomePresent1);
            for (CustomerFee cf : ci.getCustomerfee()) {
                IncomePresent incomePresent2 = new IncomePresent();
                String ci_FirstName = ci.getPTFirstName();
                String cf_LastName = cf.getLastname();
                String cf_FirstName = cf.getFirstname();
                incomePresent2.setPTFirstName(ci_FirstName);
                incomePresent2.setLastName(cf_LastName);
                incomePresent2.setFirstName(cf_FirstName);
                incomePresent2.setLevel(cf.getLevel());
                incomePresent2.setListNum(cf.getPrice());
                incomePresents.add(incomePresent2);
            }
            IncomePresent incomePresent3 = new IncomePresent();
            incomePresent3.setPTLastName("Sum");
            incomePresent3.setListNum(ci.getIncome());
            incomePresents.add(incomePresent3);
        }
        IncomePresent incomePresent4 = new IncomePresent();
        incomePresent4.setPTLastName("Grand Total");
        incomePresent4.setListNum(sum);
        incomePresents.add(incomePresent4);
        return incomePresents;
    }
}




