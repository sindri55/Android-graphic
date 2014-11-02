package is.advanced.movie.activitys;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import is.advanced.movie.R;
import is.advanced.movie.fragments.TheatersFragment;
import is.advanced.movie.models.Global;
import is.advanced.movie.models.Movie;
import is.advanced.movie.models.Showtime;

public class TheatersAdapter extends ArrayAdapter<String> {

    Context context;
    String theaters[];
    List<Movie> movieList = Global.getInstance().getMovieList();
    List<Movie> newMovieList = new ArrayList<Movie>();




    public TheatersAdapter(Context context) {
        super(context, 0 );

        this.context = context;

    }


    public List<Movie> getMovies(String theatherName){

        for(int i=0; i<movieList.size(); i++){
            for(int j=0; j < movieList.get(i).getShowtimeList().size(); j++){

                if (movieList.get(i).getShowtimeList().get(j).getTheatre().equals(theatherName)){
                    newMovieList.add(movieList.get(i));
                }
            }
        }
        return newMovieList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

            view = new View(context);

            TextView textView = (TextView) view.findViewById(R.id.theatersId1);
            textView.setText(Arrays.toString(theaters[position].getBytes()));


        return view;
    }
}
