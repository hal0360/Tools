package tw.com.atromoby.widgets;

import android.app.Dialog;
import android.content.Context;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Checkable;
import android.widget.TextView;

public class Popup implements View.OnClickListener {

    private SparseArray<CmdView> cmds = new SparseArray<>();
    private Dialog dialog;
    private Window window;

    public Popup(Context context, int resource_id){
        dialog = new Dialog(context, R.style.AtromobyDefautDialog);
        setUp(resource_id);
    }

    public Popup(Context context, int resource_id, int style_id){
        dialog = new Dialog(context, style_id);
        setUp(resource_id);
    }

    public final void setTextView(int id, String str){
        TextView txt = findViewById(id);
        txt.setText(str);
    }

    public final String getTextView(int id){
        TextView txt = findViewById(id);
        return txt.getText().toString().trim();
    }

    private void setUp(int id){
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(id);
        window = dialog.getWindow();
        assert window != null;
        window.setGravity(Gravity.CENTER);
    }

    public void clicked(int id, CmdView cd){
        dialog.findViewById(id).setOnClickListener(this);
        cmds.put(id,cd);
    }

    public void clicked(View v, CmdView cd){
        v.setOnClickListener(this);
        cmds.put(v.getId(),cd);
    }

    public void setDimension(double width, double height){
        window.setLayout((int)width, (int)height);
    }

    public void setGravity(int gravity){
        window.setGravity(gravity);
    }

    public void show(){
        dialog.show();
    }

    public <T extends View & Checkable> T findViewById(int id){
        return dialog.findViewById(id);
    }

    public void dismiss(){
        dialog.dismiss();
    }

    public boolean isShowing(){
        return dialog.isShowing();
    }

    @Override
    public void onClick(View v) {
        cmds.get(v.getId()).exec(v);
    }
}
