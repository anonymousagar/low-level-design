package PricingStrategy;

public abstract class PricingStrategy {
    public abstract double calculatePrice(Vehicle vehicle, int durationInHours);
}