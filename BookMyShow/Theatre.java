package BookMyShow;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private List<Screen> screens;
    private List<Show> shows = new ArrayList<>();
    private String name;

    public Theatre(String name, List<Screen> screens) {
        this.name = name;
        this.screens = screens;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public String getName() {
        return name;
    }

    public void addScreen(Screen screen) {
        screens.add(screen);
    }   

    public void addShow(Show show) {
        shows.add(show);
    }

    public List<Show> getShows() {
        return shows;
    }
}
