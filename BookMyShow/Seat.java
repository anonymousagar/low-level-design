package BookMyShow;

public class Seat {
    private int seatNumber;
    private boolean isBooked;
    private String bookedByUserId; // Optional: To track which user booked the seat

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.isBooked = false;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void bookSeat(User user) {
        if (!isBooked) {
            isBooked = true;
            bookedByUserId = user.getUserId();
        } else {
            throw new IllegalStateException("Seat " + seatNumber + " is already booked.");
        }
    }
}
