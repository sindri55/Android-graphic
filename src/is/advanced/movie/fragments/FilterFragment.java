package is.advanced.movie.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import is.advanced.movie.R;
import is.advanced.movie.models.Global;

/**
 * Created by Hannes on 13.10.2014.
 */
public class FilterFragment extends Fragment {

    Global mGlobal = Global.getInstance();
    OnMovieSelectedListener mListener;
    GridView gridView;

    public interface OnMovieSelectedListener extends AbsListView.MultiChoiceModeListener {
        public void onTheaterSelected( int position );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.filter_fragment, container, false);

        gridView = (GridView) view.findViewById(R.id.fragment_container);

        gridView.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.filter_list_item, mGlobal.getTheaterArray()));

        return view;
    }

    @Override
    public void onAttach( Activity activity ) {
        super.onAttach( activity );

        try {
            mListener = (OnMovieSelectedListener) activity;
        }
        catch ( ClassCastException e ) {
            throw new ClassCastException( activity.toString() + "ooops" );
        }
    }
}
