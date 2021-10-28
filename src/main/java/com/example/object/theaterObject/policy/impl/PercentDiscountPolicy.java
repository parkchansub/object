package com.example.object.theaterObject.policy.impl;

import com.example.object.theaterObject.Money;
import com.example.object.theaterObject.Screening;
import com.example.object.theaterObject.condition.DiscountCondition;
import com.example.object.theaterObject.policy.DefaultDiscountPolicy;

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
