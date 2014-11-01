package is.advanced.movie.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import is.advanced.movie.R;

/**
 * Created by Hannes on 13.10.2014.
 */
public class FilterFragment extends Fragment {

    SeekBar.OnSeekBarChangeListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       // View rootView = inflater.inflate(R.layout.fragment_filter, container, false);

        return null;
    }

    @Override
    public void onAttach( Activity activity ) {
        super.onAttach( activity );

        try {
            mListener = (SeekBar.OnSeekBarChangeListener) activity;
        }
        catch ( ClassCastException e ) {
            throw new ClassCastException( activity.toString() + "ooops" );
        }
    }
}
