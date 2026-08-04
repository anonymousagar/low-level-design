package com.parkinglot.service;

import com.parkinglot.model.ParkingFloor;
import com.parkinglot.model.ParkingSpot;
import com.parkinglot.model.ParkingTicket;
import com.parkinglot.model.Vehicles.Vehicle;
import com.parkinglot.model.Vehicles.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotService {
    private final List<ParkingFloor> floors;

    public ParkingLotService(int numberOfFloors, int spotsPerFloor) {
        this.floors = new ArrayList<>();
        for (int i = 1; i <= numberOfFloors; i++) {
            this.floors.add(new ParkingFloor(i, spotsPerFloor));
        }
    }

    public ParkingTicket parkVehicle(Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            ParkingSpot spot = floor.findAvailableSpot(vehicle.getType());
            if (spot != null) {
                spot.occupy(vehicle);
                return new ParkingTicket("T-" + System.nanoTime(), vehicle, spot);
            }
        }
        throw new IllegalStateException("No available parking spot for vehicle: " + vehicle.getPlateNumber());
    }

    public double leaveVehicle(ParkingTicket ticket) {
        if (ticket == null || ticket.getSpot() == null) {
            return 0.0;
        }
        ticket.getSpot().release();
        return ticket.calculatePrice();
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public int getAvailableSpotCount(VehicleType vehicleType) {
        int count = 0;
        for (ParkingFloor floor : floors) {
            for (ParkingSpot spot : floor.getSpots()) {
                if (!spot.isOccupied() && spot.getType() == vehicleType) {
                    count++;
                }
            }
        }
        return count;
    }
}
