package is.advanced.movie.activitys;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import is.advanced.movie.R;
import is.advanced.movie.fragments.Ipsum;

public class DetailActivity extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        Intent intent = getIntent();
        Integer pos = intent.getIntExtra( "POS", -1 );

        TextView textView = (TextView) findViewById( R.id.article);
        textView.setText( Ipsum.Articles[pos]);

    }
}
