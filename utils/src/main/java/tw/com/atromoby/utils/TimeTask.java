package tw.com.atromoby.utils;

import android.os.CountDownTimer;
import android.os.Handler;

public class TimeTask {
    private Handler handler;
private CountDownTimer countDownTimer;

    public TimeTask(){
        handler = new Handler();
    }

    public void delay(int milsec, final Cmd cmd){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                cmd.exec();
            }
        }, milsec);
    }

    public void countdown(int milsec, final CmdInt cmd){
        countDownTimer = new CountDownTimer(milsec, 1000) {
            public void onTick(long millisUntilFinished) {
                int secRem = (int) (millisUntilFinished/1000);
                cmd.exec(secRem);
            }
            public void onFinish() {
             //   cmd.exec(0);
            }
        }.start();
    }


    public void clear(){
        handler.removeCallbacksAndMessages(null);
        if(countDownTimer != null){
            countDownTimer.cancel();
        }
    }
}
