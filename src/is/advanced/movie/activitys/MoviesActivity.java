package is.advanced.movie.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import is.advanced.movie.R;
import is.advanced.movie.models.Global;
import is.advanced.movie.models.Movie;
import java.util.*;
public class MoviesActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movies);

        ListView listView1 = (ListView) findViewById(R.id.moveiList);

        List<Movie> movieList = Global.getInstance().getMovieList();

        ArrayAdapter<Movie> adapter = new ArrayAdapter<Movie>(this,
                android.R.layout.simple_list_item_1, movieList);

        listView1.setAdapter(adapter);


    }

}
