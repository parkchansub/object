package com.example.object.theaterObjectV2;


import com.example.object.theaterObject.Money;

public class Reservation {

    private Customer customer;
    private int audienceCount;
    private Money fee;
    private Screening screening;

    public Reservation(Customer customer, int audienceCount, Money fee, Screening screening) {
        this.customer = customer;
        this.audienceCount = audienceCount;
        this.fee = fee;
        this.screening = screening;
    }
}
