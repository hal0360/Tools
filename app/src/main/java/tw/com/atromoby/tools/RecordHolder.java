package tw.com.atromoby.tools;

import android.widget.TextView;

import tw.com.atromoby.utils.CmdInt;
import tw.com.atromoby.utils.CountDown;
import tw.com.atromoby.widgets.Collection;
import tw.com.atromoby.widgets.CollectionHolder;

public class RecordHolder extends Collection {

    public String name;
    private int inc = 0;
    public CountDown countDownTimer;

    public RecordHolder(String n) {
        super(R.layout.record_layout);
        name  = n;
        countDownTimer = new CountDown();
    }


    @Override
    public void onBind(CollectionHolder holder) {

        countDownTimer = new CountDown();
        final TextView textView = holder.findViewById(R.id.nameTxt);
        countDownTimer.start(7000,new CmdInt(){
            @Override
            public void exec(int i) {
                textView.setText(i + " dfd" );
            }

        });

    }

    @Override
    public void onRecycle(CollectionHolder holder) {

    }
}
