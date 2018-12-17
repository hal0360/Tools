package tw.com.atromoby.tools;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import tw.com.atromoby.widgets.CmdView;
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

    }

    @Override
    public void onRecycle() {

    }

    @Override
    public void onCreate() {

        Log.e("diff", "called: " + inc);
        inc++;

        TextView textView = findView(R.id.nameTxt);
        textView.setText(name);

        clicked(R.id.avatar, new CmdView() {
            @Override
            public void exec(View v) {
                alert("dick");
            }
        });
    }

}
