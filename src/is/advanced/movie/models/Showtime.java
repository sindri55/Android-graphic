package is.advanced.movie.models;

/**
 * Created by Hannes on 13.10.2014.
 */
public class Showtime {
    private String theatre;
    private String[] schedule;

    public Showtime() {
    }

    public Showtime(String theatre, String[] schedule) {
        this.theatre = theatre;
        this.schedule = schedule;
    }

    public String getTheatre() {
        return theatre;
    }

    public String[] getSchedule() {
        return schedule;
    }
}
