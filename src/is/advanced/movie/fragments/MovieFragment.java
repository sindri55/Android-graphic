package is.advanced.movie.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import is.advanced.movie.R;
import is.advanced.movie.adapters.MovieAdapter;
import is.advanced.movie.grids.StaggeredGridView;
import is.advanced.movie.models.Global;
import is.advanced.movie.models.Movie;

public class MovieFragment extends Fragment{

    public final static String ARG_POSITION = "position";
    int mCurrentPosition = -1;
    StaggeredGridView stgv;
    MovieAdapter mAdapter;
    List<Movie> movieList = Global.getInstance().getMovieList();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movies, container, false);

        stgv = (StaggeredGridView) view.findViewById(R.id.stgv);

        int margin = getResources().getDimensionPixelSize(R.dimen.stgv_margin);

        stgv.setItemMargin(margin);
        stgv.setPadding(margin, 0, margin, 0);

        mAdapter = new MovieAdapter(this.getActivity(), movieList);
        stgv.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the current article selection in case we need to recreate the fragment
        outState.putInt(ARG_POSITION, mCurrentPosition);
    }
}
