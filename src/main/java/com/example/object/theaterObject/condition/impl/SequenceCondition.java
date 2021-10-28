package com.example.object.theaterObject.condition.impl;

import com.example.object.theaterObject.Screening;
import com.example.object.theaterObject.condition.DiscountCondition;

public class SequenceCondition implements DiscountCondition {

    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
