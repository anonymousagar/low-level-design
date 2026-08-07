package BookMyShow;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private int screenNumber;
    private Seat[] seats;

    public Screen(int screenNumber, int totalSeats) {
        this.screenNumber = screenNumber;
        this.seats = new Seat[totalSeats];
        for (int i = 0; i < totalSeats; i++) {
            seats[i] = new Seat(i + 1);
        }
    }

    public int getScreenNumber() {
        return screenNumber;
    }

    public Seat[] getSeats() {
        return seats;
    }

}
