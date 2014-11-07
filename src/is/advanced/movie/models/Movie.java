package is.advanced.movie.models;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;


public class Movie {
    private String title;
    private String released;
    private String restricted;
    private String imdb;
    private String imdbLink;
    private Bitmap image;
    private String trailerLink;
    private List<Showtime> showtimeList;

    public Movie(){
    }

    public Movie(String title, String released, String restricted, String imdb, String imdbLink, Bitmap image,List<Showtime> showtimeList) {

        this.title = title;
        this.released = released;
        this.restricted = restricted;
        this.imdb = imdb;
        this.imdbLink = imdbLink;
        this.image = image;
        this.showtimeList = showtimeList;

    }
    public void setImage(Bitmap b){
        this.image = b;
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
    public String getImdbLink() {
        return imdbLink;
    }
    public void setImdbLink(String imdbLink) {
        this.imdbLink = imdbLink;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public void setRestricted(String restricted) {
        this.restricted = restricted;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public String getTrailerLink() {
        return trailerLink;
    }

    public void setTrailerLink(String trailerLink) {
        this.trailerLink = trailerLink;
    }
}