package tw.com.atromoby.widgets;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

public class FragDialog extends Dialog {
    public FragDialog(Context context, int rid) {
        super(context, rid);
    }

    public void setGravity(int gravity) {
        assert getWindow() != null;
        getWindow().setGravity(gravity);
    }

    public void setLayout(int width, int height) {
        assert getWindow() != null;
        getWindow().setLayout(width, height);
    }

    public void clicked(int id, final CmdView cd) {
        findViewById(id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cd.exec(v);
            }
        });
    }

    public void clicked(View v, final CmdView cd) {
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cd.exec(v);
            }
        });
    }
}
