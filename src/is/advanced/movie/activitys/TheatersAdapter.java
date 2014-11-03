package is.advanced.movie.activitys;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

import is.advanced.movie.R;

/**
 * Created by Sindri on 30/10/14.
 */
public class TheatersAdapter extends ArrayAdapter<String> {

    Context context;
    String theaters[];

    public TheatersAdapter(Context context, String[] theaters) {
        super(context, 0 ,theaters);

        this.context = context;
        this.theaters = theaters;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;

        if (convertView == null) {

            view = new View(context);

            TextView textView = (TextView) view.findViewById(R.id.theatersId1);
            textView.setText(Arrays.toString(theaters[position].getBytes()));
        }else {
            view = (View) convertView;
        }
        return view;
    }

}
