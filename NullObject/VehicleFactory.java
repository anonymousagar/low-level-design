package NullObject;

public class VehicleFactory {
    public static Vehicle getVehicle(String type) {
        if (type.equalsIgnoreCase("Car")) {
            return new Car();
        } else {
            return new NullVehicle();
        }
    }
}
