package com.example.remake.controller;

import com.example.remake.entry.CoachPlan;
import com.example.remake.entry.Customer;
import com.example.remake.service.CustomerService;
import com.example.remake.vo.CustomerInsert;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/OverAge")
    public List<Customer> OverAge(@RequestParam Integer age) {
        return customerService.over_age(age);
    }

    @GetMapping("/getHealthPerson")
    public List<Customer> health_person() {
        return customerService.getHealthPerson();
    }

    @GetMapping("/getTeenage")
//    这里应该改成删除的
    public List<Customer> get_teenage() {
        return customerService.getTeenage();
    }

    //    //    这里应该删除的，但是未来方便调试我就没有删了，删的时候要考虑哪些地方有这个数据
//    @PostMapping("/AddNew")
//    public int add_newCustomer(@RequestBody Customer customers){
//        return customerService.save_Customer(customers);
//    }

    @DeleteMapping("/delCustomer")
    public Integer deleteById(@RequestParam("id") Integer delCustomerId) {
        return customerService.deleteCustomer(delCustomerId);
    }
    @PostMapping("/delTeenage")
    public Integer deleteCustomer(@RequestBody List<Integer> ids) {
        customerService.deleteTeenage(ids);
        return ids.size();
    }

    @PostMapping("/Insert")
    public Integer saveUser(@RequestBody CustomerInsert customerInsert) {
        // 在这里编写处理保存用户信息的逻辑
        // 从userForm对象中获取前端发送的用户信息并进行相应的处理

        // 假设保存成功，返回一个成功的响应
        customerService.saveCustomer(customerInsert);
        return 0;
    }
    @GetMapping("/ListAllCustomers")
    public List<CustomerInsert> ListAllCustomers(){
        return customerService.allCustomers();
    }
}
