package is.advanced.movie.fragments;


import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import java.util.List;

import is.advanced.movie.R;
import is.advanced.movie.activitys.MovieAdapter;
import is.advanced.movie.models.Global;
import is.advanced.movie.models.Movie;

public class MovieFragment extends Fragment{

    public final static String ARG_POSITION = "position";
    int mCurrentPosition = -1;
    List<Movie> movieList = Global.getInstance().getMovieList();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movies, container, false);


        GridView gridView = (GridView) view.findViewById(R.id.gridview);
        gridView.setAdapter(new MovieAdapter(getActivity(), movieList));



/*        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Toast.makeText(getActivity(), "hello", Toast.LENGTH_SHORT).show();
            }
        });

*/
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the current article selection in case we need to recreate the fragment
        outState.putInt(ARG_POSITION, mCurrentPosition);
    }
}
