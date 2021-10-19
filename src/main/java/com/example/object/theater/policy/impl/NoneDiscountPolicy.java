package com.example.object.theater.policy.impl;

import com.example.object.theater.Money;
import com.example.object.theater.Screening;
import com.example.object.theater.policy.DiscountPolicy;

public class NoneDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
