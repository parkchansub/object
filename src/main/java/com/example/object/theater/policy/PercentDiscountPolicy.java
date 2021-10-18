package com.example.object.theater.policy;

import com.example.object.theater.Money;
import com.example.object.theater.Screening;
import com.example.object.theater.condition.DiscountCondition;

public class PercentDiscountPolicy extends DiscountPolicy{

    private double percent;

    public PercentDiscountPolicy(DiscountCondition discountCondition, double percent) {
        super(discountCondition);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
