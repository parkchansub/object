package com.example.object.theaterObjectV2;


import com.example.object.theaterObject.Money;
import com.example.object.theaterObjectV2.condition.DiscountCondition;
import com.example.object.theaterObjectV2.condition.impl.PeriodCondition;
import com.example.object.theaterObjectV2.condition.impl.SequenceCondition;

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

    private List<PeriodCondition> periodConditions;
    private List<SequenceCondition> sequenceConditions;


    public boolean isDiscountable(Screening screening){
        return discountConditions.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }



    public Money calculateMovieFee(Screening screening) {
        if(isDiscountable(screening)){
            return fee.minus(calculateDiscountAmount());
        }
        return fee;
    }



    private Money calculateDiscountAmount() {
        switch (movieType) {
            case AMOUNT_DISCOUNT:
                return calculateAmountDiscountAmount();
            case PERCENT_DISCOUNT:
                return calculatePercentDiscountAmount();
            case NONE_DISCOUNT:
                return calculateNoneDiscountAmount();
        }
        throw new IllegalStateException();
    }


    private Money calculateAmountDiscountAmount() {
        return discountAmount;
    }

    private Money calculatePercentDiscountAmount() {
        return fee.times(discountPercent);
    }

    private Money calculateNoneDiscountAmount() {
        return Money.ZERO;
    }

    public Money getFee() {
        return fee;
    }

    public List<DiscountCondition> getDiscountConditions() {
        return discountConditions;
    }
}
