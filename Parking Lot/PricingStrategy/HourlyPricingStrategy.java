public class HourlyPricingStrategy extends PricingStrategy {
    private double hourlyRate;

    public HourlyPricingStrategy(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculatePrice(int durationInHours) {
        return hourlyRate * durationInHours;
    }
}