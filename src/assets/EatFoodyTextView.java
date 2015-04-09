package assets;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;


/**
 * Created by Sindri on 09/04/15.
 */
public class EatFoodyTextView extends TextView {

    public EatFoodyTextView(Context context) {
        super(context);

        applyCustomFont(context);
    }

    public EatFoodyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context);
    }

    public EatFoodyTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("assets/fonts/Roboto-Regular.ttf", context);
        setTypeface(customFont);
    }
}