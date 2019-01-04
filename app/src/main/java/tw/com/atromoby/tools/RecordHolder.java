package tw.com.atromoby.tools;

import android.util.Log;
import android.widget.TextView;

import tw.com.atromoby.widgets.ItemHolder;

public class RecordHolder extends ItemHolder {

    private String name;
    private int inc = 0;

    public RecordHolder(String n) {
        super(R.layout.record_layout);
        name  = n;
    }

    @Override
    public void onBind() {

        TextView textView = findViewById(R.id.nameTxt);
        textView.setText(name);

      //  TextView textView = findViewById(R.id.nameTxt);
        //   textView.setText(name);

    }

    @Override
    public void onRecycle() {
        Log.e("diff", "called: " + inc);
    }


}
