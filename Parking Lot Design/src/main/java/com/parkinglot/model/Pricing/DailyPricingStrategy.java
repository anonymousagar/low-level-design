package com.parkinglot.model.Pricing;

public class DailyPricingStrategy implements PricingStrategy {
    private final double dailyRate;

    public DailyPricingStrategy(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculatePrice(long durationInHours) {
        long durationInDays = (durationInHours + 23) / 24; // Round up to the nearest day
        return dailyRate * durationInDays;
    }
}
