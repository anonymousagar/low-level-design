package BookMyShow;

import java.util.ArrayList;
import java.util.List;

public class MovieManager {
    private List<Movie> movies = new ArrayList<>();

    public List<Movie> getMovies() {
        return movies;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }
}
