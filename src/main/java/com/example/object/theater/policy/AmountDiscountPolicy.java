package com.example.object.theater.policy;

import com.example.object.theater.Money;
import com.example.object.theater.Screening;
import com.example.object.theater.condition.DiscountCondition;

public class AmountDiscountPolicy extends DiscountPolicy {

    private Money discountAmount;

    public AmountDiscountPolicy(DiscountCondition condition, Money discountAmount) {
        super(condition);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
