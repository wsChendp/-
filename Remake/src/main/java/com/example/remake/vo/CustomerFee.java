package com.example.remake.vo;

import com.example.remake.entry.Customer;
import lombok.Data;

@Data
public class CustomerFee extends Customer {
    double price;
    String level;
}
