package tw.com.atromoby.tools;

import android.view.View;
import android.widget.TextView;

import tw.com.atromoby.widgets.CmdView;
import tw.com.atromoby.widgets.ItemHolder;

public class RecordHolder extends ItemHolder {

    private String name;

    public RecordHolder(String n) {
        super(R.layout.record_layout);
        name  = n;
    }

    @Override
    public void onBind() {
        TextView textView = findView(R.id.nameTxt);
        textView.setText(name);

        clicked(R.id.avatar, new CmdView() {
            @Override
            public void exec(View v) {
                alert("ape skull " + name);
            }
        });
    }

    @Override
    public void onClean() {

    }
}
