package com.example.object.theaterObject.condition;

import com.example.object.theaterObject.Screening;

public interface DiscountCondition {

    boolean isSatisfiedBy(Screening screening);

}
