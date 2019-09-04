package tw.com.atromoby.widgets;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;

public abstract class ItemHolder{

    int itemHolderrid;
    MobyHolder myHolder;
    public int position;

    public ItemHolder(int resID){
        itemHolderrid = resID;
    }

    public abstract void onBind();

    public abstract void onRecycle();

    public final void setTextView(int id, String str){
        TextView txt = findViewById(id);
        txt.setText(str);
    }

    public final String getTextView(int id){
        TextView txt = findViewById(id);
        return txt.getText().toString().trim();
    }


    public final void clicked(View v, CmdView cd){
        myHolder.clicked(v,cd);
    }

    public final Context getContex(){
        return myHolder.itemView.getContext();
    }

    public final boolean isPortrait() {
        int orientation = myHolder.itemView.getContext().getResources().getConfiguration().orientation;
        return orientation != Configuration.ORIENTATION_LANDSCAPE;
    }

    protected final <T extends View & Checkable> T findViewById(int rid){
        return myHolder.findView(rid);
    }

    public final void clicked(int id, CmdView cd){
        myHolder.clicked(id,cd);
    }

    public final void alert(String message){
        myHolder.alert(message);
    }

}
