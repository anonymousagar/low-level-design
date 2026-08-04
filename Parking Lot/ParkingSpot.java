public class ParkingSpot {
    private int spotNumber;
    private VehicleType vehicleType;
    private boolean isOccupied;
    private PricingStrategy pricingStrategy;

    public ParkingSpot(int spotNumber, VehicleType vehicleType, PricingStrategy pricingStrategy) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
        this.pricingStrategy = pricingStrategy;
        this.isOccupied = false;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void occupySpot() {
        isOccupied = true;
    }

    public void vacateSpot() {
        isOccupied = false;
    }
}