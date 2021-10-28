package com.example.object.theaterObject.policy.impl;

import com.example.object.theaterObject.Money;
import com.example.object.theaterObject.Screening;
import com.example.object.theaterObject.condition.DiscountCondition;
import com.example.object.theaterObject.policy.DefaultDiscountPolicy;

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
