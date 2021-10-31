package com.example.object.theaterData;

import com.example.object.theaterObject.Money;

import java.time.LocalDateTime;

public class Screening {

    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Money calculateFee(int accountCount) {

        switch (movie.getMovieType()) {
            case AMOUNT_DISCOUNT:
                if (movie.isDiscountable(whenScreened, sequence)) {
                    return movie.calculateAmountDiscountedFee().times(accountCount);
                }
            case PERCENT_DISCOUNT:
                if (movie.isDiscountable(whenScreened, sequence)) {
                    return movie.calculatePercentDiscountedFee().times(accountCount);
                }
            case NONE_DISCOUNT:
                return movie.calculateNoneDiscountedFee().times(accountCount);
        }
        return movie.calculateNoneDiscountedFee().times(accountCount);
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }

    public void setWhenScreened(LocalDateTime whenScreened) {
        this.whenScreened = whenScreened;
    }
}
