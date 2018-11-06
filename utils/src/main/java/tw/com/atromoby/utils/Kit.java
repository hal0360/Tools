package tw.com.atromoby.utils;

import android.content.Context;
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

}
