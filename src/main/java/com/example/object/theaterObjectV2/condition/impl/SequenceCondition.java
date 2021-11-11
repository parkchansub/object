package com.example.object.theaterObjectV2.condition.impl;

import com.example.object.theaterObjectV2.Screening;
import com.example.object.theaterObjectV2.condition.DiscountCondition;

public class SequenceCondition implements DiscountCondition {
    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    public boolean isSatisfiedBy(Screening screening) {
        return sequence == screening.getSequence();
    }
}
