package Zoomcar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import Zoomcar.Payment.CreditCardPaymentProcessor;
import Zoomcar.Payment.PaymentProcessor;

public class CarRentalService {
    private static CarRentalService instance = new CarRentalService();
    private final Map<String, Vehicle> vehicles;
    private final Map<String, Reservation> reservations;
    private final PaymentProcessor paymentProcessor;

     private CarRentalService() {
        vehicles = new ConcurrentHashMap<>();
        reservations = new ConcurrentHashMap<>();
        paymentProcessor = new CreditCardPaymentProcessor();
    }

    public static CarRentalService getInstance() {
        return instance;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getLicensePlate(), vehicle);
    }

    public void removeVehicle(String licensePlate) {
        vehicles.remove(licensePlate);
    }

    public List<Vehicle> searchVehicles(String make, String model, LocalDate startDate, LocalDate endDate) {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles.values()) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model) && vehicle.isAvailable()) {
                if (isVehicleAvailable(vehicle, startDate, endDate)) {
                    availableVehicles.add(vehicle);
                }
            }
        }
        return availableVehicles;
    }

    private boolean isVehicleAvailable(Vehicle vehicle, LocalDate startDate, LocalDate endDate) {
        for (Reservation reservation : reservations.values()) {
            if (reservation.getVehicle().equals(vehicle)) {
                if (startDate.isBefore(reservation.getEndDate()) && endDate.isAfter(reservation.getStartDate())) {
                    return false;
                }
            }
        }
        return true;
    }

    public synchronized Reservation makeReservation(Customer customer, Vehicle vehicle, LocalDate startDate, LocalDate endDate) {
        if (isVehicleAvailable(vehicle, startDate, endDate)) {
            String reservationId = generateReservationId();
            Reservation reservation = new Reservation(reservationId, customer, vehicle, startDate, endDate);
            reservations.put(reservationId, reservation);
            vehicle.setAvailable(false);
            return reservation;
        }
        return null;
    }

    public synchronized void cancelReservation(String reservationId) {
        Reservation reservation = reservations.remove(reservationId);
        if (reservation != null) {
            reservation.getVehicle().setAvailable(true);
        }
    }

    public boolean processPayment(Reservation reservation) {
        return paymentProcessor.processPayment(reservation.getTotalPrice());
    }

    private String generateReservationId() {
        return "RES" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

}
