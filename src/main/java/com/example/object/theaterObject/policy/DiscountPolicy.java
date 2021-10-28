package com.example.object.theaterObject.policy;

import com.example.object.theaterObject.Money;
import com.example.object.theaterObject.Screening;

public interface DiscountPolicy {

    Money calculateDiscountAmount(Screening screening);
}
