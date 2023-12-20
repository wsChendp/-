package com.example.remake.mapper;

import com.example.remake.entry.CoachPlan;
import com.example.remake.entry.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author DELL
* @description 针对表【customer】的数据库操作Mapper
* @createDate 2023-12-15 23:41:50
* @Entity com.example.remake.entry.Customer
*/
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {

    List<Customer> OverAge(Integer age);

    List<Customer> getHealthPerson();

    List<Customer> getTeenage();

    int insertCustomer(Customer customer);

    @Select("SELECT last_value FROM customer_id_seq")
    int getLastInsertedCustomerId();

}




