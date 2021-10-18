package com.example.object.theater;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Screening {

    private Movie movie;
    private int Sequence;
    private LocalDateTime whenScreened;



    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        Sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, audienceCount, movie.getFee(), this);
    }


    public Movie getMovie() {
        return movie;
    }

    public int getSequence() {
        return Sequence;
    }

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }

    public boolean isSequence(int sequence) {
        return false;
    }

    public LocalDateTime getStartTime() {
        return whenScreened;
    }

    public Money getMovieFee() {
        return movie.getFee();
    }


}
