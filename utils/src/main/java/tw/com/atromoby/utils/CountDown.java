package tw.com.atromoby.utils;

import android.os.CountDownTimer;

public class CountDown {
    private CountDownTimer countDownTimer;

    public CountDown(){
    }

    public void start(int milsec, final CmdInt cmd){
        if(countDownTimer != null){
            countDownTimer.cancel();
        }
        countDownTimer = new CountDownTimer(milsec, 1000) {
            public void onTick(long millisUntilFinished) {
                int secRem = (int) (millisUntilFinished/1000);
                cmd.exec(secRem);
            }
            public void onFinish() {
                   cmd.exec(0);
            }
        }.start();
    }


    public void cancel(){
        if(countDownTimer != null){
            countDownTimer.cancel();
        }
    }
}
