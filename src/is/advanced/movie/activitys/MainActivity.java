package is.advanced.movie.activitys;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import is.advanced.movie.R;
import is.advanced.movie.fragments.DetailFragment;
import is.advanced.movie.fragments.MasterFragment;

public class MainActivity extends Activity
    implements MasterFragment.OnHeadlineSelectedListener{

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.master2);
    }


    @Override
    public void onArticleSelected(int position) {
        DetailFragment detailFragment = (DetailFragment)
                getFragmentManager().findFragmentById(R.id.article_fragment);

        if (detailFragment != null) {
            detailFragment.updateArticleView(position);
        }
        else{
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("POS", position);
            startActivity(intent);
        }
    }
}
