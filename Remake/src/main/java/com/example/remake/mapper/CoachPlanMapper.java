package com.example.remake.mapper;

import com.example.remake.entry.CoachPlan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author DELL
* @description 针对表【coach_plan】的数据库操作Mapper
* @createDate 2023-12-15 23:41:45
* @Entity com.example.remake.entry.CoachPlan
*/
@Mapper
public interface CoachPlanMapper extends BaseMapper<CoachPlan> {
    Integer delByCustomerId(int delCustomerId);

    Integer insertCoachPlan(int coachId,int LevelId, int customerId);

    Integer updateCoachPlan(Integer coachId, Integer levelId);
}




