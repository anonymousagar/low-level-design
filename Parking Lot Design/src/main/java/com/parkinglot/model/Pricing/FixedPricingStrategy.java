package com.parkinglot.model.Pricing;

public class FixedPricingStrategy implements PricingStrategy {
    private final double fixedRate;

    public FixedPricingStrategy(double fixedRate) {
        this.fixedRate = fixedRate;
    }

    @Override
    public double calculatePrice(long durationInHours) {
        return fixedRate;
    }
    
}
