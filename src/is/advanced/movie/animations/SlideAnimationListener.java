package is.advanced.movie.animations;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridView;
import is.advanced.movie.grids.StaggeredGridView;

/**
 * Created by Hannes on 2.11.2014.
 */
public class SlideAnimationListener implements Animation.AnimationListener {
    private View view;
    private boolean isVisible;

    public SlideAnimationListener(View view, boolean isVisible){
        this.view = view;
        this.isVisible = isVisible;
    }

    @Override
    public void onAnimationStart(Animation animation) {
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if(isVisible){
            this.view.setVisibility(View.GONE);
        } else {
            this.view.setVisibility(View.VISIBLE);
        }

        StaggeredGridView parent = (StaggeredGridView) this.view.getParent().getParent();
        parent.requestLayout();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        // This is called each time the Animation repeats
    }
}
