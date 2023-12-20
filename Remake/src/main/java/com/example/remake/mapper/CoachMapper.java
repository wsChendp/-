package com.example.remake.mapper;

import com.example.remake.entry.Coach;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.remake.entry.Customer;
import com.example.remake.vo.CCustomerNum;
import com.example.remake.vo.CoachIncome;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author DELL
* @description 针对表【coach】的数据库操作Mapper
* @createDate 2023-12-15 23:41:16
* @Entity com.example.remake.entry.Coach
*/
@Mapper
public interface CoachMapper extends BaseMapper<Coach> {

    List<Coach> searchCoach();

    List<CCustomerNum> culPerson();

    List<CoachIncome> getCoachIncome();


    Integer searchCoachId(String coachName);

    String selectName(Integer coachId);
}




