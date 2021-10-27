package com.example.object.theater;

import com.example.object.theater.condition.DiscountCondition;
import com.example.object.theater.policy.DiscountPolicy;

import java.time.Duration;
import java.util.List;

public class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

    public Money getFee() {
        return fee;
    }

    public DiscountPolicy getDiscountPolicy() {
        return discountPolicy;
    }
}
