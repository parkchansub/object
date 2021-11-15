package com.example.object.theaterObjectV2;

import com.example.object.theaterData.DiscountConditionType;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountConditionPast {

    private DiscountConditionType type;
    private int sequence;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;


    public boolean isDiscountable(Screening screening){
        if (type == DiscountConditionType.PERIOD) {
            return isSatisfiedByPeriod(screening);
        }
        return isSatisFiedBySequence(screening);
    }

    private boolean isSatisfiedByPeriod(Screening screening) {
        return dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek())&&
                startTime.compareTo(screening.getWhenScreened().toLocalTime()) <=0 &&
                endTime.compareTo(screening.getWhenScreened().toLocalTime()) >=0;
    }

    private boolean isSatisFiedBySequence(Screening screening) {
        return sequence == screening.getSequence();
    }


}
