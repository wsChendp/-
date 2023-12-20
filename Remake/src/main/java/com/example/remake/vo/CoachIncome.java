package com.example.remake.vo;

import com.example.remake.entry.Coach;
import lombok.Data;

import java.util.List;

@Data
public class CoachIncome extends Coach {
    String PTFirstName;
    String PTLastName;
    double income;
    List<CustomerFee> customerfee;

    //    这路是非常出生的树，实际上应该开一个用户的，这里为了方便这样创建
    public CoachIncome() {
        super();
        this.income = 0;
    }
}
