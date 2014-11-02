package is.advanced.movie.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import is.advanced.movie.R;

public class ErrorActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.error);

    }

    public void reload(View v){

        final Button button = (Button) findViewById(R.id.reloadButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),FlashActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}