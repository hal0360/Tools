package tw.com.atromoby.widgets;

import android.view.View;
import android.widget.Checkable;

public abstract class ItemHolder{

    int rid;
    MobyHolder myHolder;

    public ItemHolder(int resID){
        rid = resID;
    }

    public abstract void onBind();

    public abstract void onClean();

    protected final void clicked(View v, CmdView cd){
        v.setOnClickListener(myHolder);
        myHolder.cmds.put(v.getId(),cd);
    }

    protected final <T extends View & Checkable> T findView(int Rid){
        return myHolder.itemView.findViewById(Rid);
    }

    protected final void clicked(int id, CmdView cd){
        findView(id).setOnClickListener(myHolder);
        myHolder.cmds.put(id,cd);
    }

    protected final void alert(String message){
        myHolder.alert(message);
    }

}
