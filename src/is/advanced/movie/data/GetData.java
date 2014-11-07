package is.advanced.movie.data;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;

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

        responseString = "{\"results\":[{\"title\":\"Interstellar\",\"released\":\"2014\",\"restricted\":\"12 ára\",\"imdb\":\"9.2/10  26,242 atkv.\",\"imdbLink\":\"http://www.imdb.com/title/tt0816692\",\"image\":\"http://kvikmyndir.is/images/poster/8708_500.jpg\",\"showtimes\":[{\"theater\":\"Smárabíó\",\"schedule\":[\"17:30 (LÚX )\",\"17:30\",\"21:00\",\"21:00 (LÚX )\",\"22:00\"]},{\"theater\":\"Sambíóin Álfabakka\",\"schedule\":[\"17:00 (P)\",\"18:00 (A)\",\"20:30 (1)\",\"20:30 (P)\",\"22:00 (A)\"]},{\"theater\":\"Sambíóin Kringlunni\",\"schedule\":[\"18:30 (1)\",\"21:00 (2)\",\"22:00 (1)\"]},{\"theater\":\"Sambíóin Egilshöll\",\"schedule\":[\"18:00 (2)\",\"20:00 (1)\",\"21:30 (2)\",\"22:20 (3)\"]},{\"theater\":\"Sambíóin Akureyri\",\"schedule\":[\"18:30 (B)\",\"20:30 (A)\",\"22:00 (B)\"]},{\"theater\":\"Sambíóin Keflavík\",\"schedule\":[\"20:00 (1)\",\"22:20 (2)\"]}]},{\"title\":\"Nightcrawler\",\"released\":\"2014\",\"restricted\":\"16 ára\",\"imdb\":\"8.3/10  11,663 atkv.\",\"imdbLink\":\"http://www.imdb.com/title/tt2872718\",\"image\":\"http://kvikmyndir.is/images/poster/9570_500.jpg\",\"showtimes\":[{\"theater\":\"Háskólabíó\",\"schedule\":[\"17:30\",\"20:00\"]},{\"theater\":\"Borgarbíó\",\"schedule\":[\"20:00\",\"22:15\"]},{\"theater\":\"Laugarásbíó\",\"schedule\":[\"17:00\",\"20:00\",\"22:30\"]}]},{\"title\":\"Algjör Sveppi og Gói bjargar málunum\",\"released\":\"2014\",\"restricted\":\"Öllum leyfð\",\"imdb\":\"\",\"imdbLink\":\"\",\"image\":\"http://kvikmyndir.is/images/poster/sveppi-1411838014.jpg\",\"showtimes\":[{\"theater\":\"Sambíóin Álfabakka\",\"schedule\":[\"15:40 (A)\",\"15:50 (1)\",\"18:10 (1)\",\"20:00 (3)\"]},{\"theater\":\"Sambíóin Kringlunni\",\"schedule\":[\"16:00 (1)\",\"18:40 (2)\"]},{\"theater\":\"Sambíóin Egilshöll\",\"schedule\":[\"17:40 (1)\"]},{\"theater\":\"Sambíóin Akureyri\",\"schedule\":[\"18:00 (A)\"]},{\"theater\":\"Sambíóin Keflavík\",\"schedule\":[\"17:50 (1)\",\"20:00 (2)\"]}]},{\"title\":\"Grafir og Bein\",\"released\":\"2014\",\"restricted\":\"16 ára\",\"imdb\":\"\",\"imdbLink\":\"\",\"image\":\"http://kvikmyndir.is/images/poster/grafir-1408652380.jpg\",\"showtimes\":[{\"theater\":\"Smárabíó\",\"schedule\":[\"17:45\",\"20:00\"]},{\"theater\":\"Háskólabíó\",\"schedule\":[\"20:00\",\"22:30\"]},{\"theater\":\"Borgarbíó\",\"schedule\":[\"18:00\",\"20:00\"]},{\"theater\":\"Laugarásbíó\",\"schedule\":[\"18:00\"]}]},{\"title\":\"John Wick\",\"released\":\"2014\",\"restricted\":\"16 ára\",\"imdb\":\"8.0/10  16,315 atkv.\",\"imdbLink\":\"http://www.imdb.com/title/tt2911666\",\"image\":\"http://kvikmyndir.is/images/poster/9536_500.jpg\",\"showtimes\":[{\"theater\":\"Borgarbíó\",\"schedule\":[\"22:00\"]},{\"theater\":\"Laugarásbíó\",\"schedule\":[\"17:50\",\"20:00\",\"22:10\"]},{\"theater\":\"Sambíóin Álfabakka\",\"schedule\":[\"20:00 (2)\",\"22:20 (2)\"]},{\"theater\":\"Sambíóin Egilshöll\",\"schedule\":[\"17:40 (3)\",\"20:00 (3)\",\"22:40 (4)\"]}]},{\"title\":\"Fury\",\"released\":\"2014\",\"restricted\":\"16 ára\",\"imdb\":\"8.1/10  40,713 atkv.\",\"imdbLink\":\"http://www.imdb.com/title/tt2713180\",\"image\":\"http://kvikmyndir.is/images/poster/9300_500.jpg\",\"showtimes\":[{\"theater\":\"Smárabíó\",\"schedule\":[\"20:00\",\"22:50\"]},{\"theater\":\"Háskólabíó\",\"schedule\":[\"21:00\"]}]},{\"title\":\"The Rewrite\",\"released\":\"2014\",\"restricted\":\"7 ára\",\"imdb\":\"5.8/10  294 atkv.\",\"imdbLink\":\"http://www.imdb.com/title/tt2509850\",\"image\":\"http://kvikmyndir.is/images/poster/9535_500.jpg\",\"showtimes\":[{\"theater\":\"Sambíóin Álfabakka\",\"schedule\":[\"17:40 (B)\",\"20:00 (B)\",\"22:20 (B)\"]}]},{\"title\":\"Borgríki II - Blóð hraustra manna\",\"released\":\"2014\",\"restricted\":\"16 ára\",\"imdb\":\"\",\"imdbLink\":\"\",\"image\":\"http://kvikmyndir.is/images/poster/1231660_1526541197561600_5593401874453074783_n-1412173590.jpg\",\"showtimes\":[{\"theater\":\"Smárabíó\",\"schedule\":[\"17:45\",\"20:00\"]},{\"theater\":\"Háskólabíó\",\"schedule\":[\"18:45\",\"22:10\"]},{\"theater\":\"Borgarbíó\",\"schedule\":[\"18:00\"]},{\"theater\":\"Laugarásbíó\",\"schedule\":[\"20:00\",\"22:10\"]}]},{\"title\":\"The Boxtrolls\",\"released\":\"2014\",\"restricted\":\"Öllum leyfð\",\"imdb\":\"7.2/10  5,714 atkv.\",\"imdbLink\":\"http://www.imdb.com/title/tt0787474\",\"image\":\"http://kvikmyndir.is/images/poster/8748_500.jpg\",\"showtimes\":[{\"theater\":\"Smárabíó\",\"schedule\":[\"15:30\"]},{\"theater\":\"Laugarásbíó\",\"schedule\":[\"15:50 (2D )\"]},{\"theater\":\"Sambíóin Álfabakka\",\"schedule\":[\"15:40 (ÍSL TAL 3)\",\"17:50 (ÍSL TAL 3)\"]},{\"theater\":\"Sambíóin Keflavík\",\"schedule\":[\"17:50 (ÍSL TAL 2)\"]}]},{\"title\":\"The Judge\",\"released\":\"2014\",\"restricted\":\"7 ára\",\"imdb\":\"7.7/10  18,938 atkv.\",\"imdbLink\":\"http://www.imdb.com/title/tt1872194\",\"image\":\"http://kvikmyndir.is/images/poster/9299_500.jpg\",\"showtimes\":[{\"theater\":\"Sambíóin Kringlunni\",\"schedule\":[\"22:20 (3)\"]},{\"theater\":\"Sambíóin Egilshöll\",\"schedule\":[\"20:00 (4)\"]}]},{\"title\":\"Alexander and the Terrible, Horrible, No Good, Very Bad Day\",\"released\":\"2014\",\"restricted\":\"Öllum leyfð\",\"imdb\":\"6.5/10  2,811 atkv.\",\"imdbLink\":\"http://www.imdb.com/title/tt1698641\",\"image\":\"http://kvikmyndir.is/images/poster/9534_500.jpg\",\"showtimes\":[{\"theater\":\"Sambíóin Álfabakka\",\"schedule\":[\"15:40 (B)\"]},{\"theater\":\"Sambíóin Egilshöll\",\"schedule\":[\"18:00 (4)\"]}]},{\"title\":\"Gone Girl\",\"released\":\"2014\",\"restricted\":\"16 ára\",\"imdb\":\"8.5/10  105,196 atkv.\",\"imdbLink\":\"http://www.imdb.com/title/tt2267998\",\"image\":\"http://kvikmyndir.is/images/poster/9297_500.jpg\",\"showtimes\":[{\"theater\":\"Smárabíó\",\"schedule\":[\"17:00\",\"22:10\"]},{\"theater\":\"Háskólabíó\",\"schedule\":[\"21:15\"]}]},{\"title\":\"Annabelle\",\"released\":\"2014\",\"restricted\":\"16 ára\",\"imdb\":\"5.7/10  29,225 atkv.\",\"imdbLink\":\"http://www.imdb.com/title/tt3322940\",\"image\":\"http://kvikmyndir.is/images/poster/9533_500.jpg\",\"showtimes\":[{\"theater\":\"Sambíóin Álfabakka\",\"schedule\":[\"22:20 (3)\"]}]},{\"title\":\"Smáheimar: Dalur týndu mauranna\",\"released\":\"2014\",\"restricted\":\"Öllum leyfð\",\"imdb\":\"7.1/10  2,257 atkv.\",\"imdbLink\":\"http://www.imdb.com/title/tt2368672\",\"image\":\"http://kvikmyndir.is/images/poster/minuscule-1411766048.jpg\",\"showtimes\":[{\"theater\":\"Smárabíó\",\"schedule\":[\"15:30\"]},{\"theater\":\"Laugarásbíó\",\"schedule\":[\"15:50\"]}]},{\"title\":\"Afinn\",\"released\":\"2014\",\"restricted\":\"Öllum leyfð\",\"imdb\":\"\",\"imdbLink\":\"\",\"image\":\"http://kvikmyndir.is/images/poster/afinn_bio_final-1405031688.jpeg\",\"showtimes\":[{\"theater\":\"Sambíóin Álfabakka\",\"schedule\":[\"17:40 (2)\"]},{\"theater\":\"Sambíóin Kringlunni\",\"schedule\":[\"15:20 (3)\",\"17:40 (3)\",\"20:00 (3)\"]}]},{\"title\":\"Töfrahúsið\",\"released\":\"2013\",\"restricted\":\"Öllum leyfð\",\"imdb\":\"6.3/10  1,612 atkv.\",\"imdbLink\":\"http://www.imdb.com/title/tt3148834\",\"image\":\"http://kvikmyndir.is/images/poster/tfflasdf-1409057505.jpg\",\"showtimes\":[{\"theater\":\"Sambíóin Álfabakka\",\"schedule\":[\"15:40 (ÍSL TAL 2)\"]}]},{\"title\":\"Björk: Biophilia Live\",\"released\":\"2014\",\"restricted\":\"Öllum leyfð\",\"imdb\":\"7.8/10  148 atkv.\",\"imdbLink\":\"http://www.imdb.com/title/tt3626442\",\"image\":\"http://kvikmyndir.is/images/poster/9449_500.jpg\",\"showtimes\":[{\"theater\":\"Bíó Paradís\",\"schedule\":[\"18:00\"]}]}]}";

//        try {
//            response = httpclient.execute(new HttpGet(uri[0]));
//            StatusLine statusLine = response.getStatusLine();
//            if(statusLine.getStatusCode() == HttpStatus.SC_OK){
//                ByteArrayOutputStream out = new ByteArrayOutputStream();
//                response.getEntity().writeTo(out);
//                out.close();
//                responseString = out.toString();
//            } else{
//                //Closes the connection.
//                response.getEntity().getContent().close();
//                throw new IOException(statusLine.getReasonPhrase());
//            }
//        } catch (ClientProtocolException e) {
//
//        } catch (IOException e) {
//
//        }

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
                        if(scheduleArr.getString(x).contains("LÚX")){
                            scheduleList.add(scheduleArr.getString(x).replace("LÚX", "L"));
                        }
                        else {
                            scheduleList.add(scheduleArr.getString(x));
                        }
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