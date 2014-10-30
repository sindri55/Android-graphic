package is.advanced.movie.models;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;


public class Global {

    private List<Movie> movieList;

    private static Global mInstance = new Global();

    public static Global getInstance(){return mInstance;}

    public Global(){
        movieList = new ArrayList<Movie>();
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
