package tw.com.atromoby.widgets;

import android.util.SparseArray;
import android.view.View;
import android.widget.Checkable;
import android.widget.Toast;


public abstract class ItemHolder implements View.OnClickListener{

    private SparseArray<CmdView> cmds = new SparseArray<>();
    private int rid;
    private MobyHolder myHolder;

    public ItemHolder(int resID){
        rid = resID;
    }

    int getResID(){
        return rid;
    }

    final void created(MobyHolder disHolder){
        myHolder = disHolder;
    }

    public abstract void init();

    public abstract void cleanUp();

    protected final void clicked(View v, CmdView cd){
        v.setOnClickListener(this);
        cmds.put(v.getId(),cd);
    }

    protected final <T extends View & Checkable> T findView(int Rid){
        return myHolder.itemView.findViewById(Rid);
    }

    protected final void clicked(int id, CmdView cd){
        findView(id).setOnClickListener(this);
        cmds.put(id,cd);
    }

    protected void alert(String mess){
        Toast.makeText(myHolder.itemView.getContext(), mess, Toast.LENGTH_LONG).show();
    }

    @Override
    public final void onClick(View v) {
        cmds.get(v.getId()).exec(v);
    }
}
