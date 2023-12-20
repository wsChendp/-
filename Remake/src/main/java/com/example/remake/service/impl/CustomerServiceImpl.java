package com.example.remake.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.remake.entry.CoachPlan;
import com.example.remake.entry.Customer;
import com.example.remake.mapper.CoachMapper;
import com.example.remake.mapper.CoachPlanMapper;
import com.example.remake.mapper.CustomerMapper;
import com.example.remake.mapper.PlanMapper;
import com.example.remake.service.CustomerService;
import com.example.remake.vo.CustomerInsert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DELL
 * @description 针对表【customer】的数据库操作Service实现
 * @createDate 2023-12-15 23:41:50
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer>
        implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private CoachPlanMapper coachPlanMapper;
    @Autowired
    private CoachMapper coachMapper;
    @Autowired
    private PlanMapper planMapper;

    @Override
    public List<Customer> over_age(Integer age) {
        return customerMapper.OverAge(age);
    }

    @Override
    public List<Customer> getHealthPerson() {
        return customerMapper.getHealthPerson();
    }

    @Override
    public List<Customer> getTeenage() {
        return customerMapper.getTeenage();
    }

    @Override
    public int insertCustomerWithCoachPlan(Customer customer, CoachPlan coachPlan) {
        return 0;
    }

//    @Override
//    public int insertCustomerWithCoachPlan(Customer customer, CoachPlan coachPlan) {
//        customerMapper.insertCustomer(customer);
//        coachPlan.setCoachId(customer.getCoachId());
//        coachPlan.setPlanId(customer.getPlanId());
//        coachPlan.setCustomerId(customerMapper.getLastInsertedCustomerId());
//        coachPlanMapper.insertCoachPlan(coachPlan);
//        System.out.println(customer);
//        System.out.println(coachPlan);
//        return 1;
//    }

    @Override
    public Integer deleteCustomer(Integer delCustomer) {
//        这里先解除customer的外键约束
        coachPlanMapper.delByCustomerId(delCustomer);
        return customerMapper.deleteById(delCustomer);
    }

    @Override
    public Integer deleteTeenage(List<Integer> ids) {
        int size = 0;
        for (Integer id : ids) {
            coachPlanMapper.delByCustomerId(id);
            customerMapper.deleteById(id);
            size++;
        }
        return size;
    }

    @Override
    public Integer saveCustomer(CustomerInsert customerInsert) {
        String coachName = customerInsert.getCoachName();
        String level = customerInsert.getLevel();
        Integer coachId = coachMapper.searchCoachId(coachName);
        Integer levelId = planMapper.searchLevel(level);

        if (customerInsert.getId() == null) {
            Customer customer = new Customer();
            customer.setCoachId(coachId);
            customer.setPlanId(levelId);
            customerMapper.insertCustomer(customer);
            Integer customerId = customerMapper.getLastInsertedCustomerId();
            return coachPlanMapper.insertCoachPlan(coachId, levelId, customerId);
        } else {
            UpdateWrapper<Customer> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("id", customerInsert.getId())
                    .set("name", customerInsert.getName())
                    .set("firstname", customerInsert.getFirstname())
                    .set("lastname", customerInsert.getLastname())
                    .set("email", customerInsert.getEmail())
                    .set("phone", customerInsert.getPhone())
                    .set("address", customerInsert.getAddress())
                    .set("birthday", customerInsert.getBirthday())
                    .set("exercisehistory", customerInsert.getExercisehistory())
                    .set("fitness", customerInsert.getFitness())
                    .set("medicalhistory", customerInsert.getMedicalhistory())
                    .set("coach_id", coachId)
                    .set("plan_id", levelId);
                    customerMapper.update(null, updateWrapper);

            // 根据实际需要，调用coachPlanMapper.update方法更新coachPlan表
            UpdateWrapper<CoachPlan> coachPlanUpdateWrapper = new UpdateWrapper<>();


            coachPlanUpdateWrapper.eq("customer_id", customerInsert.getId())
                    .set("plan_id", levelId)
                    .set("coach_id", coachId);
            return coachPlanMapper.update(new CoachPlan(), coachPlanUpdateWrapper);
        }
    }

    @Override
    public List<CustomerInsert> allCustomers() {
        List<Customer> customerList = customerMapper.selectList(null);

        List<CustomerInsert> customerInsertList = new ArrayList<>();

        for (Customer customer : customerList) {
            CustomerInsert customerInsert = new CustomerInsert();
            customerInsert.setId(customer.getId());
            customerInsert.setName(customer.getName());
            customerInsert.setFirstname(customer.getFirstname());
            customerInsert.setLastname(customer.getLastname());
            customerInsert.setAddress(customer.getAddress());
            customerInsert.setPhone(customer.getPhone());
            customerInsert.setEmail(customer.getEmail());
            customerInsert.setBirthday(customer.getBirthday());
            customerInsert.setExercisehistory(customer.getExercisehistory());
            customerInsert.setFitness(customer.getFitness());
            customerInsert.setCoachId(customer.getCoachId());
            customerInsert.setPlanId(customer.getPlanId());
            customerInsert.setMedicalhistory(customer.getMedicalhistory());
            String Coachname = coachMapper.selectName(customerInsert.getCoachId());
            String Plan = planMapper.selectPlan(customerInsert.getPlanId());
            //    得到教练名字
//    得到计划名字
            customerInsert.setCoachName(Coachname);
            customerInsert.setLevel(Plan);
            customerInsertList.add(customerInsert);
        }


        return customerInsertList;
    }
}




