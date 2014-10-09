package is.advanced.movie.fragments;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MasterFragment extends ListFragment  {

    OnHeadlineSelectedListener mListener;

    public interface OnHeadlineSelectedListener {
        public void onArticleSelected( int position );
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create an array adapter for the list view, using the Ipsum headlines array
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_activated_1, Ipsum.Headlines));
    }
    @Override
    public void onAttach( Activity activity ) {
        super.onAttach( activity );

        try {
            mListener = (OnHeadlineSelectedListener) activity;
        }
        catch ( ClassCastException e ) {
            throw new ClassCastException( activity.toString() + "ooops" );
        }
    }

    @Override
    public void onListItemClick( ListView l, View v, int position, long id ) {
        mListener.onArticleSelected( position );
        getListView().setItemChecked( position, true );
    }

    @Override
    public void onStart() {
        super.onStart();
        getListView().setChoiceMode( ListView.CHOICE_MODE_SINGLE );
    }
}
