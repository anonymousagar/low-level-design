package BookMyShow;

public class Show {
    private int showId;
    private Movie movie;
    private String showTime;
    private Screen screen;

    public Show(Movie movie, String showTime, Screen screen) {
        this.movie = movie;
        this.showTime = showTime;
        this.screen = screen;
        showId = generateShowId();
    }

    public int getShowId() {
        return showId;
    }

    public int generateShowId() {
        return (int) (Math.random() * 10000); // Simple random ID generation
    }

    public int getShowId() {
        return showId;
    }

    public String getMovieName() {
        return movie.getName();
    }

    public String getShowTime() {
        return showTime;
    }

    public Screen getScreen() {
        return screen;
    }
}
