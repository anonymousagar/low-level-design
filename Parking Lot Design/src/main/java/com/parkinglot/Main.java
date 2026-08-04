package com.parkinglot;

import com.parkinglot.model.Vehicles.Vehicle;
import com.parkinglot.model.Vehicles.VehicleType;
import com.parkinglot.service.ParkingLotService;

public class Main {
    public static void main(String[] args) {
        ParkingLotService service = new ParkingLotService(2, 4);
        Vehicle car = new Vehicle("KA-01-1234", VehicleType.CAR);
        Vehicle bike = new Vehicle("KA-02-9999", VehicleType.BIKE);

        var ticket1 = service.parkVehicle(car);
        var ticket2 = service.parkVehicle(bike);

        System.out.println("Parked car at spot: " + ticket1.getSpot().getSpotId());
        System.out.println("Parked bike at spot: " + ticket2.getSpot().getSpotId());
        System.out.println("Available car spots: " + service.getAvailableSpotCount(VehicleType.CAR));

        var price1 = service.leaveVehicle(ticket1);
        var price2 = service.leaveVehicle(ticket2);

        System.out.println("Car left. Price: " + price1);
        System.out.println("Bike left. Price: " + price2);
    }
}
