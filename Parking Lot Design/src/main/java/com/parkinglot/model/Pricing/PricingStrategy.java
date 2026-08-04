package com.parkinglot.model.Pricing;

public interface PricingStrategy {

    double calculatePrice(long durationInHours);
}