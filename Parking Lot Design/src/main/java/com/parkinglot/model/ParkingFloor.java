package com.parkinglot.model;

import java.util.ArrayList;
import java.util.List;

import com.parkinglot.model.Pricing.FixedPricingStrategy;
import com.parkinglot.model.Pricing.HourlyPricingStrategy;
import com.parkinglot.model.Vehicles.VehicleType;

public class ParkingFloor {
    private final int floorNumber;
    private final List<ParkingSpot> spots;

    public ParkingFloor(int floorNumber, int numberOfSpots) {
        this.floorNumber = floorNumber;
        this.spots = new ArrayList<>();
        for (int i = 1; i <= numberOfSpots; i++) {
            this.spots.add(new ParkingSpot(i, i % 2 == 0 ? VehicleType.BIKE : VehicleType.CAR, new FixedPricingStrategy(2.0)));
        }
    }

    public ParkingSpot findAvailableSpot(VehicleType vehicleType) {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied() && spot.getType() == vehicleType) {
                return spot;
            }
        }
        return null;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }
}
