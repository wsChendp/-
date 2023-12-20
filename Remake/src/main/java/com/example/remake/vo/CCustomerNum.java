package com.example.remake.vo;

import com.example.remake.entry.Coach;
import lombok.Data;

@Data
public class CCustomerNum extends Coach {
    int customers_num;
    public CCustomerNum(){
        super();
        this.customers_num = 0;
    }
}
