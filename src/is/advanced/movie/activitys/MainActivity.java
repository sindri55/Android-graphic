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


    public boolean useMethodOne = false;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) ==
                Configuration.SCREENLAYOUT_SIZE_LARGE) {
            useMethodOne = true;
        }


        setContentView( (useMethodOne) ? R.layout.master : R.layout.master2);

        if ( useMethodOne ) {
            if (findViewById(R.id.fragment_container) != null) {

                if (savedInstanceState != null) {
                    return;
                }

                MasterFragment firstFragment = new MasterFragment();
                firstFragment.setArguments(getIntent().getExtras());

                FragmentManager fragmentManager = getFragmentManager();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.add(R.id.fragment_container, firstFragment);
                fragmentTransaction.commit();

            }
        }
    }

    @Override
    public void onArticleSelected(int position) {
        DetailFragment detailFragment = (DetailFragment)
                getFragmentManager().findFragmentById(R.id.article_fragment);

        if (detailFragment != null) {
            detailFragment.updateArticleView(position);
        } else {
            if ( useMethodOne ) {
                detailFragment = new DetailFragment();
                Bundle args = new Bundle();
                args.putInt(DetailFragment.ARG_POSITION, position);
                detailFragment.setArguments(args);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, detailFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
            else {
                Intent intent = new Intent(this, DetailActivity.class);
                intent.putExtra("POS", position);
                startActivity(intent);
            }
        }
    }


}
