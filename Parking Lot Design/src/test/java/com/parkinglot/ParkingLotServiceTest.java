package com.parkinglot;

import com.parkinglot.model.Vehicles.Vehicle;
import com.parkinglot.model.Vehicles.VehicleType;
import com.parkinglot.service.ParkingLotService;

public class ParkingLotServiceTest {
    public static void main(String[] args) {
        ParkingLotService service = new ParkingLotService(1, 3);
        Vehicle car = new Vehicle("ABC-123", VehicleType.CAR);
        var ticket = service.parkVehicle(car);

        if (ticket == null || ticket.getSpot() == null) {
            throw new IllegalStateException("Parking ticket was not created");
        }

        if (service.leaveVehicle(ticket) <= 0) {
            throw new IllegalStateException("Vehicle could not be removed");
        }

        System.out.println("ParkingLotServiceTest passed");
    }
}
