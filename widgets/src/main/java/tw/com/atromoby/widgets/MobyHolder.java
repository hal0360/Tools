package tw.com.atromoby.widgets;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.Checkable;
import android.widget.Toast;

class MobyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    ItemHolder cHold;
    SparseArray<CmdView> cmds = new SparseArray<>();

    MobyHolder(@NonNull View itemView) {
        super(itemView);
    }


    void alert(String mess){
        Toast.makeText(itemView.getContext(), mess, Toast.LENGTH_LONG).show();
    }

    public final void clicked(int id, CmdView cd){
        findView(id).setOnClickListener(this);
        cmds.put(id,cd);
    }

    public final <T extends View & Checkable> T findView(int rid){
        return itemView.findViewById(rid);
    }

    public final void clicked(View v, CmdView cd){
        v.setOnClickListener(this);
        cmds.put(v.getId(),cd);
    }

    @Override
    public void onClick(View v) {
        cmds.get(v.getId()).exec(v);
    }
}