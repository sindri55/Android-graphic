package is.advanced.movie.data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import is.advanced.movie.activitys.MoviesActivity;
import is.advanced.movie.models.Global;
import is.advanced.movie.models.Movie;
import is.advanced.movie.models.Showtime;
import org.json.JSONArray;
import org.json.JSONObject;

public class GetData  extends AsyncTask<String, String, List<Movie>> {

    public List<Movie> movieList = new ArrayList<Movie>();
    public int temp = 0;
    Context context;
    Handler handler;

    public GetData(Context c,Handler h){
       this.context = c;
       this.handler = h;
    }
    @Override
    protected List<Movie> doInBackground(String... uri) {

        String inputLine;
        StringBuilder response = new StringBuilder();
        try{

            URL obj = new URL(uri[0]);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));

            while ((inputLine = in.readLine()) != null)
            {
                response.append(inputLine);
            }
            in.close();

        }
        catch (Exception e){
            System.out.println("Could not get data ");
        }

        try{

            JSONObject json = new JSONObject(response.toString());
            JSONArray j = json.getJSONArray("results");

            for(int i = 0; i < j.length(); i++)
            {
                JSONObject movies = j.getJSONObject(i);
                String title = (String) movies.get("title");
                String released = (String) movies.get("released");
                String restricted = (String) movies.get("restricted");
                String imdb = (String) movies.get("imdb");
                String image = (String) movies.get("image");

                JSONArray showtimes = movies.getJSONArray("showtimes");

                List<Showtime> showtimeList = new ArrayList<Showtime>();

                for(int y = 0; y < showtimes.length(); y++)
                {

                    JSONObject showtime = showtimes.getJSONObject(y);
                    String theater = (String) showtime.get("theater");

                    List<String> scheduleList = new ArrayList<String>();

                    JSONArray scheduleArr = showtime.getJSONArray("schedule");

                    for(int x = 0; x < scheduleArr.length(); x++)
                    {
                        scheduleList.add(scheduleArr.getString(x));
                    }

                    Showtime showtimeForMovie = new Showtime(theater,scheduleList);
                    showtimeList.add(showtimeForMovie);

                }






                URL u = new URL(image);
                Bitmap bmp = BitmapFactory.decodeStream(u.openConnection().getInputStream());

                Movie movie = new Movie(title,released,restricted,imdb,bmp,showtimeList);
                movieList.add(movie);

            }

        }
        catch(Exception e){
            System.out.println("Error reading Json");
        }
        return movieList;
    }

    @Override
    protected void onPostExecute(List<Movie> result) {
        super.onPostExecute(result);

        Global.getInstance().setMovieList(result);
        handler.sendEmptyMessage(42);
    }
 }