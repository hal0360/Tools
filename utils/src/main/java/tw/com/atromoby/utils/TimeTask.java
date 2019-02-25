package tw.com.atromoby.utils;

import android.os.Handler;

public class TimeTask {
    private Handler handler;

    public TimeTask(){
        handler = new Handler();
    }

    public void delay(int milSec, final Cmd cmd){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                cmd.exec();
            }
        }, milSec);
    }

    public void loop(int milSec, final Cmd cmd){
        reCur(milSec, cmd);
    }

    private void reCur(final int milSec, final Cmd cmd){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                cmd.exec();
                reCur(milSec,cmd);
            }
        }, milSec);
    }


    public void clear(){
        handler.removeCallbacksAndMessages(null);
    }
}
