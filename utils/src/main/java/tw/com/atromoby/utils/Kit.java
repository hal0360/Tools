package tw.com.atromoby.utils;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Kit {

    public static void alert(Context context, String mss){
        Toast.makeText(context, mss, Toast.LENGTH_LONG).show();
    }

    public static <T> List<T> filter(List<T> tList, Filt<T> filter){
        List<T> newList = new ArrayList<>();
        for(T t: tList){
            if(filter.exec(t)){
                newList.add(t);
            }
        }
        return newList;
    }

    public static void treeObserve(final View view, final CmdView cmdView){
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                cmdView.exec(view);
            }
        });
    }

    public static int color(String colorStr){
        return Color.parseColor(colorStr);
    }

}
