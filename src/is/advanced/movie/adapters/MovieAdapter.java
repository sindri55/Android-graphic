package is.advanced.movie.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;
import is.advanced.movie.R;
import is.advanced.movie.animations.SlideAnimationListener;
import is.advanced.movie.grids.CustomGridView;
import is.advanced.movie.models.Movie;
import is.advanced.movie.models.Showtime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hannes on 2.11.2014.
 */
public class MovieAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Movie> mMovieList;
    private LayoutInflater mInflater;

    public MovieAdapter(Context context, List<Movie> movies) {
        mContext = context;
        mMovieList = (ArrayList) movies;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mMovieList == null ? 0 : mMovieList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            Holder holder = new Holder();

            view = View.inflate(mContext, R.layout.movies_grid, null);
            holder.moviePoster = (ImageView) view.findViewById(R.id.movie_poster);
            holder.movieTitle = (TextView) view.findViewById(R.id.movie_title);
            holder.show_times_container = (LinearLayout) view.findViewById(R.id.show_times_container);

            view.setTag(holder);
        } else {
            view = convertView;
        }

        Holder holder = (Holder) view.getTag();

        List<Showtime> showtimeList = mMovieList.get(position).getShowtimeList();
        for(int j=0; j<showtimeList.size(); j++){
            TextView theaterName = (TextView) mInflater.inflate(R.layout.showtime_theater, holder.show_times_container, false);
            theaterName.setText(showtimeList.get(j).getTheatre());
            holder.show_times_container.addView(theaterName);

            CustomGridView showtimeGrid = (CustomGridView) mInflater.inflate(R.layout.showtime_grid, holder.show_times_container, false);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext,
                    R.layout.showtime_time, showtimeList.get(j).getScheduleArray());
            showtimeGrid.setAdapter(adapter);
//            for(int k=0; k<showtimeList.get(j).getSchedule().size(); k++){
//                TextView showTime = (TextView) mInflater.inflate(R.layout.showtime_time, holder.show_times_container, false);
//                showTime.setText(showtimeList.get(j).getSchedule().get(k));
//                showtimeGrid.addView(showTime);
//            }
//
//            holder.show_times_container.addView(showtimeGrid);
            holder.show_times_container.addView(showtimeGrid);
        }

        /**
         * StaggeredGridView has bugs dealing with child TouchEvent
         * You must deal TouchEvent in the child view itself
         **/
        holder.moviePoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewGroup parent = (ViewGroup) v.getParent().getParent();
                LinearLayout showTimesContainer = (LinearLayout) parent.findViewById(R.id.show_times_container);

                if(showTimesContainer.getVisibility() == View.VISIBLE){
                    Animation slideUp = AnimationUtils.loadAnimation(showTimesContainer.getContext(), R.anim.slide_up);
                    slideUp.setAnimationListener(new SlideAnimationListener(showTimesContainer, true));
                    showTimesContainer.startAnimation(slideUp);
                }
                else {
                    showTimesContainer.setVisibility(View.VISIBLE);
                    Animation slideDown = AnimationUtils.loadAnimation(showTimesContainer.getContext(), R.anim.slide_down);
                    slideDown.setAnimationListener(new SlideAnimationListener(showTimesContainer, false));
                    showTimesContainer.startAnimation(slideDown);
                }
            }
        });

        holder.movieTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewGroup parent = (ViewGroup) v.getParent().getParent();
                LinearLayout showTimesContainer = (LinearLayout) parent.findViewById(R.id.show_times_container);

                if(showTimesContainer.getVisibility() == View.VISIBLE){
                    Animation slideUp = AnimationUtils.loadAnimation(showTimesContainer.getContext(), R.anim.slide_up);
                    slideUp.setAnimationListener(new SlideAnimationListener(showTimesContainer, true));
                    showTimesContainer.startAnimation(slideUp);
                }
                else {
                    showTimesContainer.setVisibility(View.VISIBLE);
                    Animation slideDown = AnimationUtils.loadAnimation(showTimesContainer.getContext(), R.anim.slide_down);
                    slideDown.setAnimationListener(new SlideAnimationListener(showTimesContainer, false));
                    showTimesContainer.startAnimation(slideDown);
                }
            }
        });

        holder.movieTitle.setText(mMovieList.get(position).getTitle());
        holder.moviePoster.setImageBitmap(mMovieList.get(position).getImage());

        return view;
    }

    public class Holder {
        public ImageView moviePoster;
        public TextView movieTitle;
        public LinearLayout show_times_container;
    }
}