package com.example.remake.vo;

import com.example.remake.entry.Customer;
import lombok.Data;

@Data
public class CustomerInsert extends Customer{
    String Level;
    String coachName;
}
