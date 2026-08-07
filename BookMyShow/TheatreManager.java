package BookMyShow;

import java.util.ArrayList;
import java.util.List;

public class TheatreManager {
    private List<Theatre> theatres = new ArrayList<>();

    public void addTheatre(Theatre theatre) {
        theatres.add(theatre);
    }

    public List<Theatre> getTheatres() {
        return theatres;
    }

    public void removeTheatre(Theatre theatre) {
        theatres.remove(theatre);
    }
    
    public void addScreenToTheatre(String theatreName, Screen screen) {
        for (Theatre theatre : theatres) {
            if (theatre.getName().equals(theatreName)) {
                theatre.getScreens().add(screen);
                return;
            }
        }
        throw new IllegalArgumentException("Theatre not found: " + theatreName);
    }

    public void addShowToTheatre(String theatreName, Show show) {
        Theatre currentTheatre = null;
        for (Theatre theatre : theatres) {
            if (theatre.getName().equals(theatreName)) {
                currentTheatre = theatre;
            }
        }

        if (currentTheatre == null) {
            throw new IllegalArgumentException("Theatre not found: " + theatreName);
        }
        
        currentTheatre.addShow(show);
    }


    public Ticket bookTicket(String theatreName , Screen screen, String showTime, User user, int seatNumber){
        Theatre theatreToBook = null;
        for (Theatre t : theatres) {
            if (t.getName().equals(theatreName)) {
                theatreToBook = t;
                break;
            }
        }
        if (theatreToBook == null) {
            throw new IllegalArgumentException("Theatre not found: " + theatreName);
        }
        // Continue with ticket booking logic...
        for (Show show : theatreToBook.getShows()) {
            if (show.getShowTime().equals(showTime) && show.getScreen().getScreenNumber() == screen.getScreenNumber()) {
                Seat[] seats = show.getScreen().getSeats();
                if (seatNumber < 1 || seatNumber > seats.length) {
                    throw new IllegalArgumentException("Invalid seat number: " + seatNumber);
                }
                Seat seatToBook = seats[seatNumber - 1];
                if (seatToBook.isBooked()) {
                    throw new IllegalArgumentException("Seat already booked: " + seatNumber);
                }
                seatToBook.bookSeat(user);
                return new Ticket(user, show, seatToBook);
            }
        }
        return new Ticket(user, null, null);

    }
}
