package com.example.object.theater.condition.impl;

import com.example.object.theater.Screening;
import com.example.object.theater.condition.DiscountCondition;

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
