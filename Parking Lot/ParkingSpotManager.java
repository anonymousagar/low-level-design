import java.util.List;

public class ParkingSpotManager {
    List<ParkingSpot> parkingSpots;

    public ParkingSpotManager(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public void addParkingSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
    }

    public void removeParkingSpot(ParkingSpot spot) {
        parkingSpots.remove(spot);
    }

    public ParkingSpot findParkingSpot(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpots) {
            if (!spot.isOccupied() && spot.getVehicleType() == vehicle.getVehicleType()) {
                return spot;
            }
        }
        return null; // No available spot found
    }

    public void occupySpot(ParkingSpot spot) {
        spot.occupySpot();
    }

    public void vacateSpot(ParkingSpot spot) {
        spot.vacateSpot();
    }
}