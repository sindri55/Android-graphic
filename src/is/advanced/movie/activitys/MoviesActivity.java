package is.advanced.movie.activitys;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import is.advanced.movie.R;
import is.advanced.movie.models.Global;
import is.advanced.movie.models.Movie;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
public class MoviesActivity extends Activity {

    public Bitmap b;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movies);

        ImageView v = (ImageView) findViewById(R.id.movie);

       Movie m = Global.getInstance().getMovieList().get(0);
       v.setImageBitmap(m.getImage());

        /*ListView listView1 = (ListView) findViewById(R.id.moveiList);
        List<Movie> movieList = Global.getInstance().getMovieList();
        ArrayAdapter<Movie> adapter = new ArrayAdapter<Movie>(this,
                android.R.layout.simple_list_item_1, movieList);
        listView1.setAdapter(adapter);*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.movies_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        Context context = getApplicationContext();
        switch (item.getItemId()) {
            case R.id.action_search:

                CharSequence text = "Hello search!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                return true;
            case R.id.action_settings:

                CharSequence t = "Hello settings!";
                int d = Toast.LENGTH_SHORT;

                Toast to = Toast.makeText(context, t, d);
                to.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}