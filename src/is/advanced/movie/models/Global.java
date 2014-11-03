package is.advanced.movie.models;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Global {

    private List<Movie> movieList;
    private ArrayList<String> theaterList = new ArrayList<String>();

    private static Global mInstance = new Global();
    public static Global getInstance(){return mInstance;}

    public Global(){
        movieList = new ArrayList<Movie>();
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public List<Movie> getMovieList(List<String> theaters){
        if(theaters.size() < 1){
            return movieList;
        }

        List<Movie> newMovieList = new ArrayList<Movie>();

        for(int i=0; i<movieList.size(); i++){
            for(int j=0; j<movieList.get(i).getShowtimeList().size(); j++){
                String theater = movieList.get(i).getShowtimeList().get(j).getTheatre();
                if(theaters.contains(theater)){
                    newMovieList.add(movieList.get(i));
                    break;
                }
            }
        }

        return newMovieList;
    }

    public String[] getTheaterArray() {
        for(int i=0; i<movieList.size(); i++){
            for(int j=0; j<movieList.get(i).getShowtimeList().size(); j++){
                String theaterName = movieList.get(i).getShowtimeList().get(j).getTheatre();
                if(!theaterList.contains(theaterName)){
                    theaterList.add(theaterName);
                }
            }
        }

        String[] arr = new String[theaterList.size()];
        for(int i=0; i<theaterList.size(); i++){
            arr[i] = theaterList.get(i);
        }
        return arr;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
}
