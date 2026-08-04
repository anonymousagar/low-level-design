package com.parkinglot.model;

import com.parkinglot.model.Pricing.PricingStrategy;
import com.parkinglot.model.Vehicles.Vehicle;
import com.parkinglot.model.Vehicles.VehicleType;

public class ParkingSpot {
    private final int spotId;
    private final VehicleType type;
    private boolean occupied;
    private Vehicle vehicle;
    private PricingStrategy pricingStrategy;

    public ParkingSpot(int spotId, VehicleType type, PricingStrategy pricingStrategy) {
        this.spotId = spotId;
        this.type = type;
        this.occupied = false;
        this.vehicle = null;
        this.pricingStrategy = pricingStrategy;
    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public VehicleType getType() {
        return type;
    }

    public int getSpotId() {
        return spotId;
    }

    public void occupy(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.occupied = true;
    }

    public void release() {
        this.vehicle = null;
        this.occupied = false;
    }
}
