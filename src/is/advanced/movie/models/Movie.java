package is.advanced.movie.models;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;


public class Movie {
    private String title;
    private String released;
    private String restricted;
    private String imdb;
    private Bitmap image;
    private List<Showtime> showtimeList;

    public Movie(){
    }

    public Movie(String title, String released, String restricted, String imdb, Bitmap image,List<Showtime> showtimeList) {

        this.title = title;
        this.released = released;
        this.restricted = restricted;
        this.imdb = imdb;
        this.image = image;
        this.showtimeList = showtimeList;

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
    public Bitmap getImage() {
        return image;
    }
    public List<Showtime> getShowtimeList() {
        return showtimeList;
    }

    public void setShowtimeList(List<Showtime> showtimeList) {
        this.showtimeList = showtimeList;
    }
    @Override
    public String toString() {
        return "Movie{" +
                "showtimeList=" + showtimeList +
                ", image='" + image + '\'' +
                ", imdb='" + imdb + '\'' +
                ", restricted='" + restricted + '\'' +
                ", released='" + released + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}