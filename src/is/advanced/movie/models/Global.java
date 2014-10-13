package is.advanced.movie.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hannes on 13.10.2014.
 */
public class Global {

    private List<Movie> movieList;

    private static Global mInstance = new Global();

    public static Global getInstance(){return mInstance;}

    public Global(){
        movieList = new ArrayList<Movie>();
        Movie movie1 = new Movie("Bíómynd 1", "2013", "12 ára", "5.5/10  9,907 atkv.", "http://kvikmyndir.is/images/poster/8497_500.jpg");
        List<Showtime> showtimesMovie1 = new ArrayList<Showtime>();
        showtimesMovie1.add(new Showtime("Borgarbíó", new String[]{"22:00", "23:00"}));
        showtimesMovie1.add(new Showtime("Smárabíó", new String[]{"15:00", "20:00", "24:00"}));
        movie1.setShowtimeList(showtimesMovie1);

        Movie movie2 = new Movie("Bíómynd 2", "2014", "16 ára", "8.9/10  9,907 atkv.", "http://kvikmyndir.is/images/poster/8497_500.jpg");
        List<Showtime> showtimesMovie2 = new ArrayList<Showtime>();
        showtimesMovie2.add(new Showtime("Sambíóin Álfabakka", new String[]{"22:00", "23:00"}));
        showtimesMovie2.add(new Showtime("Sambíóin Kringlunni", new String[]{"15:00", "20:00", "24:00"}));
        movie1.setShowtimeList(showtimesMovie2);

        Movie movie3 = new Movie("Bíómynd 3", "2011", "16 ára", "8.9/10  9,907 atkv.", "http://kvikmyndir.is/images/poster/8497_500.jpg");
        List<Showtime> showtimesMovie3 = new ArrayList<Showtime>();
        showtimesMovie3.add(new Showtime("Kúkabíó", new String[]{"22:00", "23:00"}));
        showtimesMovie3.add(new Showtime("Mamma pissa", new String[]{"15:00", "20:00", "24:00"}));
        movie1.setShowtimeList(showtimesMovie3);

        movieList.add(movie1);
        movieList.add(movie2);
    }

    public Global(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
}
