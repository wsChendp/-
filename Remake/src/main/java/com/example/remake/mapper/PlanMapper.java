package com.example.remake.mapper;

import com.example.remake.entry.Plan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author DELL
* @description 针对表【plan】的数据库操作Mapper
* @createDate 2023-12-15 23:41:54
* @Entity com.example.remake.entry.Plan
*/
@Mapper
public interface PlanMapper extends BaseMapper<Plan> {

    Integer searchLevel(String level);

    String selectPlan(Integer planId);
}




