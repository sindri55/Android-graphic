package is.advanced.movie.activitys;




import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import is.advanced.movie.R;
import is.advanced.movie.adapters.MovieAdapter;
import is.advanced.movie.fragments.FilterFragment;
import is.advanced.movie.fragments.MovieFragment;
import is.advanced.movie.grids.StaggeredGridView;
import is.advanced.movie.models.Global;
import is.advanced.movie.models.Movie;

public class MainActivity extends FragmentActivity
        implements FilterFragment.OnMovieSelectedListener {

//    List<Movie> movieList = new ArrayList<Movie>();
//    TextView textview = null;
    ArrayList<String> selected = new ArrayList<String>();
    Global mGlobal = Global.getInstance();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

//        if (findViewById(R.id.filter_fragment) != null) {
//
//            if (savedInstanceState != null) {
//                return;
//            }
//
//            FilterFragment firstFragment = new FilterFragment();
//            firstFragment.setArguments(getIntent().getExtras());
//            FragmentManager fragmentManager = getFragmentManager();
//            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//            fragmentTransaction.add(R.id.filter_fragment, firstFragment);
//            fragmentTransaction.commit();
//        }
    }


    public void onClick(View view) {
        //TheatersAdapter adapter = new TheatersAdapter(getApplicationContext());
        //movieList.clear();

        TextView theaterNameView = (TextView) view;
        String theaterName = theaterNameView.getText().toString();

        if(!selected.contains(theaterName)){
            selected.add(theaterName);
            theaterNameView.setBackgroundColor(getResources().getColor(R.color.selected_movie_name_background_color));
        }
        else {
            selected.remove(theaterName);
            theaterNameView.setBackgroundColor(getResources().getColor(R.color.normal_movie_name_background_color));
        }

        //movieList = mGlobal.getMovieList(selected);

//        switch (view.getId()) {
//            case R.id.theatersId1:
//              movieList = adapter.getMovies("Smárabíó");
//                textview = (TextView) findViewById(R.id.theatersId1);
//                break;
//            case R.id.theatersId2:
//                movieList = adapter.getMovies("Bíó Paradís");
//                textview = (TextView) findViewById(R.id.theatersId2);
//                break;
//            case R.id.theatersId3:
//                movieList = adapter.getMovies("Háskólabíó");
//                textview = (TextView) findViewById(R.id.theatersId3);
//                break;
//            case R.id.theatersId4:
//                movieList = adapter.getMovies("Laugarásbíó");
//                textview = (TextView) findViewById(R.id.theatersId4);
//                break;
//            case R.id.theatersId5:
//                movieList = adapter.getMovies("Sambíóin Egilshöll");
//                textview = (TextView) findViewById(R.id.theatersId5);
//                break;
//            case R.id.theatersId6:
//                movieList = adapter.getMovies("Sambíóin Kringlunni");
//                textview = (TextView) findViewById(R.id.theatersId6);
//                break;
//            case R.id.theatersId7:
//                movieList = adapter.getMovies("Sambíóin Álfabakka");
//                textview = (TextView) findViewById(R.id.theatersId7);
//                break;
//            case R.id.theatersId8:
//                movieList = adapter.getMovies("Borgarbíó");
//                textview = (TextView) findViewById(R.id.theatersId8);
//                break;
//            case R.id.theatersId9:
//                movieList = adapter.getMovies("Sambíóin Keflavík");
//                textview = (TextView) findViewById(R.id.theatersId9);
//                break;
//            case R.id.theatersId10:
//                movieList = adapter.getMovies("Sambíóin Akureyri");
//                textview = (TextView) findViewById(R.id.theatersId10);
//                break;
//        }
//
//            if(textview != null){
//                textview.setTextColor(Color.parseColor("#3399FF"));
//                textview.setBackgroundColor(Color.GRAY);
//            }

        StaggeredGridView stgv = (StaggeredGridView) findViewById(R.id.stgv);

        int margin = getResources().getDimensionPixelSize(R.dimen.stgv_margin);

        stgv.setItemMargin(margin);
        stgv.setPadding(margin, 0, margin, 0);

        MovieAdapter movieAdapter = new MovieAdapter(this, mGlobal.getMovieList(selected));
        stgv.setAdapter(movieAdapter);

        movieAdapter.notifyDataSetChanged();
    }

    @Override
    public void onTheaterSelected(int position) {
        int bla = 4;
//        FilterFragment filterFragment = (FilterFragment)
//                getFragmentManager().findFragmentById(R.id.article_fragment);
//
//        if(filterFragment != null){
//            filterFragment.updateArticleView(position);
//        }
    }

    @Override
    public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
        int bla = position;
        View view = mode.getCustomView();
        view.setBackgroundColor(Color.GRAY);
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        return true;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

    }
}