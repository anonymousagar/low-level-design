package BookMyShow;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // Create some movies
        Movie movie1 = new Movie("Inception", "Sci-Fi", 148);
        Movie movie2 = new Movie("The Dark Knight", "Action", 152);

        // Create a movie manager and add movies
        MovieManager movieManager = new MovieManager();
        movieManager.addMovie(movie1);
        movieManager.addMovie(movie2);


        User user1 = new User("Alice", UserRole.CUSTOMER);
        User user2 = new User("Bob", UserRole.ADMIN);

        TheatreManager theatreManager = new TheatreManager();
        theatreManager.addTheatre(new Theatre("PVR Cinemas", new ArrayList<>()));
        theatreManager.addTheatre(new Theatre("INOX", new ArrayList<>()));
        var pvrScreen1 = new Screen(1, 100);
        var pvrScreen2 = new Screen(2, 150);
        var inoxScreen1 = new Screen(1, 120);
        var inoxScreen2 = new Screen(2, 200);

        theatreManager.addScreenToTheatre("PVR Cinemas", pvrScreen1);
        theatreManager.addScreenToTheatre("PVR Cinemas", pvrScreen2);
        theatreManager.addScreenToTheatre("INOX", inoxScreen1);
        theatreManager.addScreenToTheatre("INOX", inoxScreen2);

        theatreManager.addShowToTheatre("PVR Cinemas", new Show(movie1, "2024-06-01 18:00", pvrScreen1));
        theatreManager.addShowToTheatre("INOX", new Show(movie2, "2024-06-01 20:00", inoxScreen1));

        Ticket ticket = theatreManager.bookTicket("PVR Cinemas",pvrScreen1, "2024-06-01 18:00", user1, 23);
        Ticket ticket2 = theatreManager.bookTicket("INOX", inoxScreen1, "2024-06-01 20:00", user2, 45);

        System.out.println("Ticket booked for " + ticket.getUser().getUserId() + " for movie " + ticket.getShow().getMovieName() + " at seat number " + ticket.getSeat().getSeatNumber());
        System.out.println("Ticket booked for " + ticket2.getUser().getUserId() + " for movie " + ticket2.getShow().getMovieName() + " at seat number " + ticket2.getSeat().getSeatNumber());

    }
}
