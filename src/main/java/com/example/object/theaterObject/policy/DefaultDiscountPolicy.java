package com.example.object.theaterObject.policy;

import com.example.object.theaterObject.Money;
import com.example.object.theaterObject.Screening;
import com.example.object.theaterObject.condition.DiscountCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DefaultDiscountPolicy {

    private List<DiscountCondition> conditions = new ArrayList<>();


    public DefaultDiscountPolicy(DiscountCondition ... conditions) {
        this.conditions = Arrays.asList(conditions);
    }


    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }
        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Screening screening);

    public List<DiscountCondition> getConditions() {
        return conditions;
    }
}
