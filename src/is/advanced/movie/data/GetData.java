package is.advanced.movie.data;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Handler;
import is.advanced.movie.R;
import is.advanced.movie.activitys.ErrorActivity;
import is.advanced.movie.models.Global;
import is.advanced.movie.models.Movie;
import is.advanced.movie.models.Showtime;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONObject;

public class GetData  extends AsyncTask<String, String, List<Movie>> {

    public List<Movie> movieList = new ArrayList<Movie>();
    Context context;
    Handler handler;
    public Bitmap bmp;
    long startTime = System.nanoTime();

    public GetData(Context c,Handler h){
        this.context = c;
        this.handler = h;
    }

    @Override
    protected List<Movie> doInBackground(String... uri) {

        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response;
        String responseString = null;

        try {
            response = httpclient.execute(new HttpGet(uri[0]));
            StatusLine statusLine = response.getStatusLine();
            if(statusLine.getStatusCode() == HttpStatus.SC_OK){
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                response.getEntity().writeTo(out);
                out.close();
                responseString = out.toString();
            } else{
                //Closes the connection.
                response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
            }
        } catch (ClientProtocolException e) {

        } catch (IOException e) {

        }

        try{

            JSONObject json = new JSONObject(responseString);
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

                try {

                    URL u = new URL(image);
                    bmp = BitmapFactory.decodeStream(u.openConnection().getInputStream());
                    Movie movie = new Movie(title, released, restricted, imdb, bmp, showtimeList);
                    movieList.add(movie);

                }
                catch (Exception e)
                {
                    System.out.println("error reading image");
                    Bitmap icon = BitmapFactory.decodeResource(context.getResources(),R.drawable.noimage);
                    Movie movie = new Movie(title, released, restricted, imdb, icon, showtimeList);
                    movieList.add(movie);
                }
                long elapsedTime = (System.nanoTime() - startTime) / 100000000;


                if(elapsedTime >= 100)
                {
                   i = j.length();
                   movieList = null;
                }
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