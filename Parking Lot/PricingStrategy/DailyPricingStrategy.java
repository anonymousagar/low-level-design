public class DailyPricingStrategy extends PricingStrategy {
    @Override
    public double calculatePrice(int durationInHours) {
        double baseRate = parkingSpot.getBaseRate();
        double vehicleMultiplier = getVehicleMultiplier(vehicle.getType());
        return baseRate * vehicleMultiplier * durationInHours;
    }

    private double getVehicleMultiplier(VehicleType vehicleType) {
        switch (vehicleType) {
            case CAR:
                return 1.0;
            case MOTORCYCLE:
                return 0.5;
            case TRUCK:
                return 1.5;
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + vehicleType);
        }
    }
}