package tw.com.atromoby.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
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

    public static void setLocale(Activity context, Locale locale){
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        context.getBaseContext().getResources().updateConfiguration(config, context.getBaseContext().getResources().getDisplayMetrics());
    }

}
