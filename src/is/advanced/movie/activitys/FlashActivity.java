package is.advanced.movie.activitys;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;
import is.advanced.movie.R;
import is.advanced.movie.data.GetData;


public class FlashActivity extends Activity implements SeekBar.OnSeekBarChangeListener {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);

        View mContentView;
        mContentView = findViewById(R.id.content);

        // Initially hide the content view.
        mContentView.setVisibility(View.GONE);

        final Context c = this;
        Handler h = new Handler() {
            @Override
            public void handleMessage(Message m) {

                Intent i = new Intent(c, MainActivity.class);
                startActivity(i);
                finish();

            }
        };

        new GetData(c, h).execute("http://apis.is/cinema");
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}