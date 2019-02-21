package tw.com.atromoby.utils;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class Anime implements Animation.AnimationListener {

    private boolean repeat = false;
    private View view;
    private Animation animation;

    public Anime(int rid){
        animation = AnimationUtils.loadAnimation(view.getContext(), rid);
        animation.setAnimationListener(this);
    }

    public void start(View view, boolean repeat){
        this.view = view;
        this.repeat = repeat;
        view.clearAnimation();
        view.startAnimation(animation);
    }

    public void start(View view){
        this.view = view;
        view.clearAnimation();
        view.startAnimation(animation);
    }

    public void clear(){
        animation.setAnimationListener(null);
        if(view != null){
            view.clearAnimation();
        }
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animat) {
        if(repeat && view != null){
            view.startAnimation(animation);
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
