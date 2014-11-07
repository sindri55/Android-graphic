package is.advanced.movie.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

        String restricted = mMovieList.get(position).getRestricted();
        TextView restrictedView = (TextView) mInflater.inflate(R.layout.showtime_details, holder.show_times_container, false);
        restrictedView.setText(mMovieList.get(position).getRestricted());
        if(restricted.contains("Öllum")){
            restrictedView.setTextColor(mContext.getResources().getColor(R.color.restricted_none));
        }
        else if (restricted.contains("12")){
            restrictedView.setTextColor(mContext.getResources().getColor(R.color.restricted_12));
        }
        else {
            restrictedView.setTextColor(mContext.getResources().getColor(R.color.restricted_16));
        }
        holder.show_times_container.addView(restrictedView);

        if(mMovieList.get(position).getImdb().length() > 1){
            TextView imdb = (TextView) mInflater.inflate(R.layout.showtime_details, holder.show_times_container, false);
            imdb.setText("Imdb: " + mMovieList.get(position).getImdb().split(" ")[0]);
            holder.show_times_container.addView(imdb);
        }

        List<Showtime> showtimeList = mMovieList.get(position).getShowtimeList();
        for(int j=0; j<showtimeList.size(); j++){
            TextView theaterName = (TextView) mInflater.inflate(R.layout.showtime_theater, holder.show_times_container, false);
            theaterName.setText(showtimeList.get(j).getTheatre());
            holder.show_times_container.addView(theaterName);

            CustomGridView showtimeGrid = (CustomGridView) mInflater.inflate(R.layout.showtime_grid, holder.show_times_container, false);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext,
                    R.layout.showtime_time, showtimeList.get(j).getScheduleArray());
            showtimeGrid.setAdapter(adapter);

            holder.show_times_container.addView(showtimeGrid);
        }

        if(mMovieList.get(position).getImdbLink().length() > 1){
            Button imdbButton = (Button) mInflater.inflate(R.layout.showtime_imdb_button, holder.show_times_container, false);
            externalLink externalLink = new externalLink();
            externalLink.url = mMovieList.get(position).getImdbLink();
            imdbButton.setTag(externalLink);
            imdbButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    externalLink externalLink = (externalLink) v.getTag();

                    Uri uri = Uri.parse(externalLink.url);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    mContext.startActivity(intent);
                }
            });

            holder.show_times_container.addView(imdbButton);
        }

        if(mMovieList.get(position).getTrailerLink() != null && mMovieList.get(position).getTrailerLink().length() > 1){
            Button trailerbutton = (Button) mInflater.inflate(R.layout.showtime_imdb_button, holder.show_times_container, false);
            trailerbutton.setText("Skoða Trailer");
            externalLink trailerLink = new externalLink();
            trailerLink.url = mMovieList.get(position).getTrailerLink();
            trailerbutton.setTag(trailerLink);
            trailerbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    externalLink externalLink = (externalLink) v.getTag();

                    Uri uri = Uri.parse(externalLink.url);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    mContext.startActivity(intent);
                }
            });

            holder.show_times_container.addView(trailerbutton);
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

    public class externalLink {
        public String url;
    }
}