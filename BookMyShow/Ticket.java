package BookMyShow;

public class Ticket {
    private String ticketId;
    private Show show;
    private User user;
    private Seat seat;

    public Ticket(User user, Show show, Seat seat) {
        this.show = show;
        this.user = user;
        this.seat = seat;
        ticketId = generateTicketId();
    }

    public String generateTicketId() {
        return "TICKET_" + System.currentTimeMillis(); // Simple implementation
    }

    public String getTicketId() {
        return ticketId;
    }

    public Show getShow() {
        return show;
    }

    public User getUser() {
        return user;
    }

    public Seat getSeat() {
        return seat;
    }
}
