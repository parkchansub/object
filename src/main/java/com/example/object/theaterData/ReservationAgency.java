package com.example.object.theaterData;

import com.example.object.theaterObject.Money;

public class ReservationAgency {

    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        boolean discountable = checkDiscountable(screening);
        Money fee = calculateFee(screening, discountable, audienceCount);
        return createReservation(screening, customer, audienceCount, fee);
    }

    private boolean checkDiscountable(Screening screening) {
        return screening.getMovie().getDiscountConditions().stream()
                .anyMatch(condition -> isDiscountable(screening, condition));
    }


    private boolean isDiscountable(Screening screening, DiscountCondition condition) {
        if (condition.getType() == DiscountConditionType.PERIOD) {
            return isSatisfiedByPeriod(screening, condition);
        }
        return isSatifiedBySequence(screening, condition);
    }

    private boolean isSatifiedBySequence(Screening screening, DiscountCondition condition) {
        return condition.getSequence() == screening.getSequence();
    }

    private boolean isSatisfiedByPeriod(Screening screening, DiscountCondition condition) {
        return screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek())
                && condition.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <= 0
                && condition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
    }

    private Money calculateFee(Screening screening, boolean discountable, int audienceCount) {
        if (discountable) {
            return screening.getMovie().getFee()
                    .minus(calculateDiscountedFee(screening.getMovie()))
                    .times(audienceCount);
        }
        return screening.getMovie().getFee().times(audienceCount);
    }

    private Reservation createReservation(Screening screening, Customer customer, int audienceCount, Money fee) {
        return new Reservation(customer, screening, fee, audienceCount);
    }

    private Money calculateDiscountedFee(Movie movie) {
        switch (movie.getMovieType()) {
            case AMOUNT_DISCOUNT:
                return calculateAmountDiscountedFee(movie);
            case PERCENT_DISCOUNT:
                return calculatePercentDiscountedFee(movie);
            case NONE_DISCOUNT:
                return calculateNoneDiscountedFee();
        }
        throw new IllegalArgumentException();
    }

    private Money calculateNoneDiscountedFee() {
        return Money.ZERO;
    }

    private Money calculatePercentDiscountedFee(Movie movie) {
        return movie.getFee().times(movie.getDiscountPercent());
    }

    private Money calculateAmountDiscountedFee(Movie movie) {
        return movie.getDiscountAmount();
    }
}
