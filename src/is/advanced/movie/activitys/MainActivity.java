package is.advanced.movie.activitys;




import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.*;
import android.widget.Button;
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


    ArrayList<String> selected = new ArrayList<String>();
    Global mGlobal = Global.getInstance();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }


    public void onClick(View view) {
        TextView theaterNameView = (TextView) view;
        String theaterName = theaterNameView.getText().toString();


        if(!selected.contains(theaterName)){
            selected.add(theaterName);
            theaterNameView.setBackgroundColor(getResources().getColor(R.color.movie_pressed_color));
        }
        else {
            selected.remove(theaterName);
            theaterNameView.setBackgroundColor(getResources().getColor(R.color.movie_normal_color));
        }

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