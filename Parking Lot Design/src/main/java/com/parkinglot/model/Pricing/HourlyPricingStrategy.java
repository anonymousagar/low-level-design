package com.parkinglot.model.Pricing;

public class HourlyPricingStrategy implements PricingStrategy {
    private final double hourlyRate;

    public HourlyPricingStrategy(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculatePrice(long durationInHours) {
        return hourlyRate * durationInHours;
    }
    
}
