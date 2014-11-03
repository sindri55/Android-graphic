package is.advanced.movie.adapters;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import is.advanced.movie.R;
import is.advanced.movie.models.Movie;
import is.advanced.movie.models.Showtime;

import java.util.List;

/**
 * Created by Hannes on 1.11.2014.
 */
public class ShowtimeAdapter extends BaseAdapter {
    LayoutInflater inflater;
    Context context;
    List<Showtime> showtimeList;

    public ShowtimeAdapter(Context contextt, List<Showtime> objects) {
        inflater = LayoutInflater.from(contextt);
        context = contextt;
        showtimeList = objects;
    }

    @Override
    public int getCount() {
        return showtimeList.size();
    }

    @Override
    public Object getItem(int position) {
        return showtimeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View showtimeView;

        LayoutInflater i = LayoutInflater.from(parent.getContext());
        showtimeView = i.inflate(R.layout.showtimes, null);

        TextView theaterName = (TextView) showtimeView.findViewById(R.id.theater_name);
        theaterName.setText(showtimeList.get(position).getTheatre());
        //GridView showtimes = (GridView) showtimeView.findViewById(R.id.show_times);
        //showtimes.setAdapter(new ArrayAdapter<String>(this.context, R.layout.showtimes_grid ,showtimeList.get(position).getSchedule()));

        return showtimeView;
    }
}
