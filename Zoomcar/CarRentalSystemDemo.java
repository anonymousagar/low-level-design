package Zoomcar;


import java.time.LocalDate;
import java.util.List;

public class CarRentalSystemDemo {
    public static void run() {
        CarRentalService carRentalService = CarRentalService.getInstance();

        // Add vehicles to the rental system
        carRentalService.addVehicle(new Vehicle("Toyota", "Camry", 2022, "ABC123", 50.0));
        carRentalService.addVehicle(new Vehicle("Honda", "Civic", 2021, "XYZ789", 45.0));
        carRentalService.addVehicle(new Vehicle("Ford", "Mustang", 2023, "DEF456", 80.0));

        // Create customers
        Customer customer1 = new Customer("John Doe", "john@example.com", "DL1234");

        // Make reservations
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(3);
        List<Vehicle> availableVehicles = carRentalService.searchVehicles("Toyota", "Camry", startDate, endDate);
        if (!availableVehicles.isEmpty()) {
            Vehicle selectedVehicle = availableVehicles.getFirst();
            Reservation reservation = carRentalService.makeReservation(customer1, selectedVehicle, startDate, endDate);
            if (reservation != null) {
                boolean paymentSuccess = carRentalService.processPayment(reservation);
                if (paymentSuccess) {
                    System.out.println("Reservation successful. Reservation ID: " + reservation.getReservationId());
                } else {
                    System.out.println("Payment failed. Reservation canceled.");
                    carRentalService.cancelReservation(reservation.getReservationId());
                }
            } else {
                System.out.println("Selected vehicle is not available for the given dates.");
            }
        } else {
            System.out.println("No available vehicles found for the given criteria.");
        }
    }
}
