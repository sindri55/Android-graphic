package is.advanced.movie.activitys;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import is.advanced.movie.R;
import is.advanced.movie.models.Movie;

/*
 * Created by Sindri on 14/10/14.
 */
public class MovieAdapter extends BaseAdapter {

    LayoutInflater inflater;
    Context context;
    List<Movie> movieList;

    public MovieAdapter(Context contextt, List<Movie> objects) {
        inflater = LayoutInflater.from(contextt);
        context = contextt;
        movieList = objects;
    }

    public int getCount(){
        return movieList.size();

    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View gridView;


            LayoutInflater i = LayoutInflater.from(parent.getContext());
            gridView = i.inflate(R.layout.grid_element,null);

            TextView title = (TextView) gridView.findViewById(R.id.movieTitleId);
            ImageView imageView = (ImageView) gridView.findViewById(R.id.movieImageId);
            TextView imdb = (TextView) gridView.findViewById(R.id.imdbId);

            String imdb_[] = movieList.get(position).getImdb().split("\\s");

            title.setText(movieList.get(position).getTitle());
            imageView.setImageBitmap((movieList.get(position).getImage()));
            imdb.setText(imdb_[0]);

        return gridView;
    }
}
