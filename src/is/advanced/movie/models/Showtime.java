package is.advanced.movie.models;
import java.util.List;

public class Showtime {

    private String theatre;
    private List<String> schedule;

    public Showtime() {
    }

    public Showtime(String theatre, List<String> schedule) {
        this.theatre = theatre;
        this.schedule = schedule;
    }

    public String getTheatre() {
        return theatre;
    }

    public List<String> getSchedule() {
        return schedule;
    }

    @Override
    public String toString() {
        return "Showtime{" +
                "theatre='" + theatre + '\'' +
                ", schedule=" + schedule +
                '}';
    }
}

