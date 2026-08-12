package NullObject;

public class Application {
    public static void main(String[] args) {
        System.out.println("Welcome to the Vehicle Rental System!");
        String vehicleType = "Bike"; // Simulating user input for vehicle type
        Vehicle vehicle = VehicleFactory.getVehicle(vehicleType);
        System.out.println("Vehicle Name: " + vehicle.getName());               
        System.out.println("Vehicle Type: " + vehicle.getType());               
        System.out.println("Tank Capacity: " + vehicle.getTankCapacity());               

    }
}
