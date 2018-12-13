package tw.com.atromoby.widgets;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;

public abstract class ItemHolder implements View.OnClickListener{

    int rid;
    boolean alreadyRunned = false;
    MobyHolder myHolder;
    SparseArray<CmdView> cmds = new SparseArray<>();

    public ItemHolder(int resID){
        rid = resID;
    }

    public abstract void onBind();

    public abstract void onRecycle();

    public abstract void onCreate();

    public final void setTextView(int id, String str){
        TextView txt = findView(id);
        txt.setText(str);
    }

    public final String getTextView(int id){
        TextView txt = findView(id);
        return txt.getText().toString().trim();
    }

    public final void clicked(View v, CmdView cd){
        v.setOnClickListener(this);
        cmds.put(v.getId(),cd);
    }

    public final Context getContex(){
        return myHolder.itemView.getContext();
    }

    public final <T extends View & Checkable> T findView(int Rid){
        return myHolder.itemView.findViewById(Rid);
    }

    public final void clicked(int id, CmdView cd){
        findView(id).setOnClickListener(this);
        cmds.put(id,cd);
    }

    @Override
    public void onClick(View v) {
        cmds.get(v.getId()).exec(v);
    }

    public final void alert(String message){
        myHolder.alert(message);
    }

}
