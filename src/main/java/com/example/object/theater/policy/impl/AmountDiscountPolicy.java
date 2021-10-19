package com.example.object.theater.policy.impl;

import com.example.object.theater.Money;
import com.example.object.theater.Screening;
import com.example.object.theater.condition.DiscountCondition;
import com.example.object.theater.policy.DefaultDiscountPolicy;

public class AmountDiscountPolicy extends DefaultDiscountPolicy {

    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition ... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
