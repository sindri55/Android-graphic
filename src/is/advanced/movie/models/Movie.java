package is.advanced.movie.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hannes on 13.10.2014.
 */
public class Movie {
    private String title;
    private String released;
    private String restricted;
    private String imdb;
    private String image;
    private List<Showtime> showtimeList;

    public Movie(){

    }

    public Movie(String title, String released, String restricted, String imdb, String image) {
        this.title = title;
        this.released = released;
        this.restricted = restricted;
        this.imdb = imdb;
        this.image = image;
        this.showtimeList = new ArrayList<Showtime>();
    }

    public String getTitle() {
        return title;
    }

    public String getReleased() {
        return released;
    }

    public String getRestricted() {
        return restricted;
    }

    public String getImdb() {
        return imdb;
    }

    public String getImage() {
        return image;
    }

    public List<Showtime> getShowtimeList() {
        return showtimeList;
    }

    public void setShowtimeList(List<Showtime> showtimeList) {
        this.showtimeList = showtimeList;
    }
}
