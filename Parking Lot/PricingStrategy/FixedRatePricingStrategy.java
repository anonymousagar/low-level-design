public class FixedRatePricingStrategy extends PricingStrategy {
    private double fixedRate;

    public FixedRatePricingStrategy(double fixedRate) {
        this.fixedRate = fixedRate;
    }

    @Override
    public double calculatePrice(int durationInHours) {
        return fixedRate;
    }
}