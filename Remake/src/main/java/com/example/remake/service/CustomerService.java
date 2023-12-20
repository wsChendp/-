package com.example.remake.service;

import com.example.remake.entry.CoachPlan;
import com.example.remake.entry.Customer;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.remake.vo.CustomerInsert;

import java.util.List;

/**
* @author DELL
* @description 针对表【customer】的数据库操作Service
* @createDate 2023-12-15 23:41:50
*/
public interface CustomerService extends IService<Customer> {
    List<Customer> over_age(Integer age);

    List<Customer> getHealthPerson();

    List<Customer> getTeenage();

    int insertCustomerWithCoachPlan(Customer customer, CoachPlan coachPlan);

    Integer deleteCustomer(Integer delCustomer);

    Integer deleteTeenage(List<Integer> ids);

    Integer saveCustomer(CustomerInsert customerInsert);

    List<CustomerInsert> allCustomers();
}
