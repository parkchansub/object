package com.example.object.theaterObject;

import java.time.LocalDateTime;

public class Screening {

    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;



    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        sequence = sequence;
        this.whenScreened = whenScreened;
    }
    /* 1장에서 만든 method
    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, audienceCount, movie.getFee(), this);
    }
    */

    public Reservation reserve(Customer customer, int audienceCount){
        return new Reservation(customer, audienceCount, calculateFee(audienceCount), this);
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }


    public Movie getMovie() {
        return movie;
    }

    public int getSequence() {
        return sequence;
    }

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }

    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    public LocalDateTime getStartTime() {
        return whenScreened;
    }

    public Money getMovieFee() {
        return movie.getFee();
    }


}
