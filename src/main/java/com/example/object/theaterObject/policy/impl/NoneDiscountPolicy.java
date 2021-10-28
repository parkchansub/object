package com.example.object.theaterObject.policy.impl;

import com.example.object.theaterObject.Money;
import com.example.object.theaterObject.Screening;
import com.example.object.theaterObject.policy.DiscountPolicy;

public class NoneDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
