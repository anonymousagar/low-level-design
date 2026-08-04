package com.parkinglot.model;

import java.time.LocalDateTime;

import com.parkinglot.model.Vehicles.Vehicle;

public class ParkingTicket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot spot;
    private final LocalDateTime issuedAt;

    public ParkingTicket(String ticketId, Vehicle vehicle, ParkingSpot spot) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.spot = spot;
        this.issuedAt = LocalDateTime.now();
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public LocalDateTime getIssuedAt() {
        return issuedAt;
    }

    public long getDurationInHours() {
        LocalDateTime now = LocalDateTime.now();
        return java.time.Duration.between(issuedAt, now).toHours();
    }

    public double calculatePrice() {
        return spot.getPricingStrategy().calculatePrice(getDurationInHours());
    }
}
