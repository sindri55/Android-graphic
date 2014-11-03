package is.advanced.movie.activitys;




import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import is.advanced.movie.R;
import is.advanced.movie.adapters.MovieAdapter;
import is.advanced.movie.fragments.MovieFragment;
import is.advanced.movie.models.Global;
import is.advanced.movie.models.Movie;

public class MainActivity extends FragmentActivity implements View.OnClickListener  {

    List<Movie> movieList = new ArrayList<Movie>();
    TextView textview = null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }


    public void onClick(View view) {


        TheatersAdapter adapter = new TheatersAdapter(getApplicationContext());
        movieList.clear();

        if(textview != null){
            textview.setTextColor(Color.WHITE);
            textview.setBackgroundColor(Color.BLACK);
        }

        switch (view.getId()) {
            case R.id.theatersId1:
              movieList = adapter.getMovies("Smárabíó");
                textview = (TextView) findViewById(R.id.theatersId1);
                break;
            case R.id.theatersId2:
                movieList = adapter.getMovies("Bíó Paradís");
                textview = (TextView) findViewById(R.id.theatersId2);
                break;
            case R.id.theatersId3:
                movieList = adapter.getMovies("Háskólabíó");
                textview = (TextView) findViewById(R.id.theatersId3);
                break;
            case R.id.theatersId4:
                movieList = adapter.getMovies("Laugarásbíó");
                textview = (TextView) findViewById(R.id.theatersId4);
                break;
            case R.id.theatersId5:
                movieList = adapter.getMovies("Sambíóin Egilshöll");
                textview = (TextView) findViewById(R.id.theatersId5);
                break;
            case R.id.theatersId6:
                movieList = adapter.getMovies("Sambíóin Kringlunni");
                textview = (TextView) findViewById(R.id.theatersId6);
                break;
            case R.id.theatersId7:
                movieList = adapter.getMovies("Sambíóin Álfabakka");
                textview = (TextView) findViewById(R.id.theatersId7);
                break;
            case R.id.theatersId8:
                movieList = adapter.getMovies("Borgarbíó");
                textview = (TextView) findViewById(R.id.theatersId8);
                break;
            case R.id.theatersId9:
                movieList = adapter.getMovies("Sambíóin Keflavík");
                textview = (TextView) findViewById(R.id.theatersId9);
                break;
            case R.id.theatersId10:
                movieList = adapter.getMovies("Sambíóin Akureyri");
                textview = (TextView) findViewById(R.id.theatersId10);
                break;
        }

            if(textview != null){
                textview.setTextColor(Color.parseColor("#3399FF"));
                textview.setBackgroundColor(Color.GRAY);
            }

        GridView gridView2 = (GridView) findViewById(R.id.gridview);
        gridView2.setEmptyView(view.findViewById(R.id.gridview));
        gridView2.setAdapter(new MovieAdapter(this, movieList));
    }

}