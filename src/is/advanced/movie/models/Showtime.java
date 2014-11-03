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

    public String[] getScheduleArray(){
        String[] arr = new String[this.schedule.size()];
        for(int i=0; i<schedule.size(); i++){
            arr[i] = this.schedule.get(i);
        }

        return arr;
    }

    @Override
    public String toString() {
        return "Showtime{" +
                "theatre='" + theatre + '\'' +
                ", schedule=" + schedule +
                '}';
    }
}

