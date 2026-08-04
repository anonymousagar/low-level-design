package ParkingLot;
import Vehicle.*;

public class ParkingLot{
    public static void main(String[] args) {
        Vehicle car = new Car("ABC123");
        Vehicle bike = new Bike("XYZ789");

        PricingStrategy hourlyPricingStrategy = new HourlyPricingStrategy();

        double carPrice = hourlyPricingStrategy.calculatePrice(3);
        double bikePrice = hourlyPricingStrategy.calculatePrice(2);

        System.out.println("Car Price for 3 hours: $" + carPrice);
        System.out.println("Bike Price for 2 hours: $" + bikePrice);
    }

}