package NullObject;

public class Vehicle {
    private String name;
    private String type;
    private int tankCapacity;

    public Vehicle(String name, String type, int tankCapacity) {
        this.name = name;
        this.type = type;
        this.tankCapacity = tankCapacity;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getTankCapacity() {
        return tankCapacity;
    }
}
