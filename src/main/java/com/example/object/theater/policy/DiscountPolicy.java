package com.example.object.theater.policy;

import com.example.object.theater.Money;
import com.example.object.theater.Screening;

public interface DiscountPolicy {

    Money calculateDiscountAmount(Screening screening);
}
