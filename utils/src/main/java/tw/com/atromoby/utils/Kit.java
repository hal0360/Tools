package tw.com.atromoby.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


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




}
