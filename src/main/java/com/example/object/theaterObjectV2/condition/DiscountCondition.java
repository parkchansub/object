package com.example.object.theaterObjectV2.condition;

import com.example.object.theaterObject.condition.DiscountConditionType;
import com.example.object.theaterObjectV2.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);

}
