package com.example.object.theater.condition;

import com.example.object.theater.Screening;

public interface DiscountCondition {

    boolean isSatisfiedBy(Screening screening);

}
