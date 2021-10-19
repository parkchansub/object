package com.example.object.theater.policy.impl;

import com.example.object.theater.Money;
import com.example.object.theater.Screening;
import com.example.object.theater.condition.DiscountCondition;
import com.example.object.theater.policy.DefaultDiscountPolicy;

public class PercentDiscountPolicy extends DefaultDiscountPolicy {

    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... discountConditions) {
        super(discountConditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
