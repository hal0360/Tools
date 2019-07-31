package tw.com.atromoby.tools;

import android.util.Log;
import android.widget.TextView;

import tw.com.atromoby.utils.CmdInt;
import tw.com.atromoby.utils.CountDown;
import tw.com.atromoby.widgets.ItemHolder;

public class RecordHolder extends ItemHolder {

    public String name;
    private int inc = 0;
    public CountDown countDownTimer;

    public RecordHolder(String n) {
        super(R.layout.record_layout);
        name  = n;
        countDownTimer = new CountDown();
    }

    @Override
    public void onBind() {

        countDownTimer = new CountDown();
        final TextView textView = findViewById(R.id.nameTxt);
        countDownTimer.start(7000,new CmdInt(){
            @Override
            public void exec(int i) {
                textView.setText(i + " dfd" );
            }

        });




      //  TextView textView = findViewById(R.id.nameTxt);
        //   textView.setText(name);

    }

    @Override
    public void onRecycle() {
        Log.e("diff", "called: " + inc);
    }


}
