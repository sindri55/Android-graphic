package is.advanced.movie.activitys;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Toast;
import is.advanced.movie.R;
import is.advanced.movie.data.GetData;
import java.util.*;

import is.advanced.movie.fragments.DetailFragment;
import is.advanced.movie.fragments.FilterFragment;
import is.advanced.movie.fragments.MasterFragment;
import is.advanced.movie.models.Global;
import is.advanced.movie.models.Movie;

public class MainActivity extends Activity
    implements SeekBar.OnSeekBarChangeListener {

    private Global mGlobals = Global.getInstance();


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.master2);

        new GetData().execute("http://apis.is/cinema");

        // all the data is in the models but I have
        // yet to find a way to let the activitys know the async task
        // is finished

/*        List<Movie> l = new ArrayList<Movie>();
        l = mGlobals.getMovieList();

        System.out.println(l.size() + "**************************************");

        for(Movie m : l){
            System.out.println(m.getTitle() +"**********");
        } */

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }



//    @Override
//    public void onArticleSelected(int position) {
//        DetailFragment detailFragment = (DetailFragment)
//                getFragmentManager().findFragmentById(R.id.article_fragment);
//
//        if (detailFragment != null) {
//            detailFragment.updateArticleView(position);
//        }
//        else{
//            Intent intent = new Intent(this, DetailActivity.class);
//            intent.putExtra("POS", position);
//            startActivity(intent);
//        }
//    }
}
