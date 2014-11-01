package is.advanced.movie.activitys;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
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

public class FlashActivity extends Activity
        implements SeekBar.OnSeekBarChangeListener {

    private Global mGlobals = Global.getInstance();

    List<Movie> l = new ArrayList<Movie>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);

        if(!isNetworkAvailable())
        {
            Intent i = new Intent(getApplicationContext(),ErrorActivity.class);
            startActivity(i);
            finish();
        }

        final Context c = this;
        Handler h = new Handler(){
            @Override
            public void handleMessage(Message m){

                if(Global.getInstance().getMovieList() == null)
                {
                    Intent i = new Intent(c,ErrorActivity.class);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Intent i = new Intent(c, MainActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }

            }
        };

        new GetData(c,h).execute("http://apis.is/cinema");

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

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
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
