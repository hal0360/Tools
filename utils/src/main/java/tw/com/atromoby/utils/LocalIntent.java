package tw.com.atromoby.utils;

import android.content.Intent;

public class LocalIntent extends Intent {
    public LocalIntent(String filter, Object object){
        super(filter);
        putObject(object);
    }

    public void putObject(Object object){
        putExtra("objJsonStrAtromobyRonLu",Json.to(object));
    }

    public <T> T getObject(Class<T> tClass){
        String objStr = getStringExtra("objJsonStrAtromobyRonLu");
        return Json.from(objStr, tClass);
    }
}
