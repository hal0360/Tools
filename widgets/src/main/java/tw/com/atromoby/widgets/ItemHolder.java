package tw.com.atromoby.widgets;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;

public abstract class ItemHolder{

    int rid;
    MobyHolder myHolder;

    public ItemHolder(int resID){
        rid = resID;
    }

    public abstract void onBind();

    public abstract void onClean();

    public final void setTextView(int id, String str){
        TextView txt = findView(id);
        txt.setText(str);
    }

    public final String getTextView(int id){
        TextView txt = findView(id);
        return txt.getText().toString();
    }

    public final void clicked(View v, CmdView cd){
        v.setOnClickListener(myHolder);
        myHolder.cmds.put(v.getId(),cd);
    }

    public final Context getContex(){
        return myHolder.itemView.getContext();
    }

    public final <T extends View & Checkable> T findView(int Rid){
        return myHolder.itemView.findViewById(Rid);
    }

    public final void clicked(int id, CmdView cd){
        findView(id).setOnClickListener(myHolder);
        myHolder.cmds.put(id,cd);
    }

    public final void alert(String message){
        myHolder.alert(message);
    }

}
