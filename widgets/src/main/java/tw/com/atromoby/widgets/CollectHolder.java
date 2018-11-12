package tw.com.atromoby.widgets;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

public abstract class CollectHolder {

    private int rid;
    private MobyHolder myHolder;
    public static final SparseArray<Provider> holders = new SparseArray<>();

    public CollectHolder(int resID){
        rid = resID;
        //holders.put(rid, new MobyHolder());
    }

    public int getResID(){
        return rid;
    }

    public void creation(ViewGroup viewGroup){
        myHolder = new MobyHolder(viewGroup);
    }

    public abstract void created();




}
