# Parking Lot Low-Level Design

This workspace contains a starter Java project for a parking lot system.

## Structure
- `src/main/java/com/parkinglot/model` – domain entities such as `Vehicle`, `ParkingSpot`, `ParkingFloor`, and `ParkingTicket`
- `src/main/java/com/parkinglot/service` – parking operations and allocation logic
- `src/test/java/com/parkinglot` – a simple smoke test for the service

## Run the sample app
```bash
javac -d out $(find src/main/java -name "*.java")
java -cp out com.parkinglot.Main
```

## Run the smoke test
```bash
javac -cp src/main/java -d out-test $(find src/test/java -name "*.java")
java -cp out-test:out com.parkinglot.ParkingLotServiceTest
```
