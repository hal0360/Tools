package tw.com.atromoby.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

public abstract class LocalReceiver {

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            LocalIntent localIntent = (LocalIntent) intent;
            LocalReceiver.this.onReceive(localIntent);
        }
    };

    public abstract void onReceive(LocalIntent localIntent);

    public BroadcastReceiver getReceiver(){
        return mReceiver;
    }

    public void registerReceiver(Context context, String filterString){
        LocalBroadcastManager.getInstance(context).registerReceiver(
                mReceiver, new IntentFilter(filterString));
    }

    public void unregisterReceiver(Context context){
        LocalBroadcastManager.getInstance(context).unregisterReceiver(
                mReceiver);
    }

    public static void send(Context context, LocalIntent localIntent){
        LocalBroadcastManager.getInstance(context).sendBroadcast(localIntent);
    }

}
