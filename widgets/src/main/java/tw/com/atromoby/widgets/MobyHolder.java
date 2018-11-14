package tw.com.atromoby.widgets;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.Toast;

class MobyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    ItemHolder cHold;
    SparseArray<CmdView> cmds = new SparseArray<>();

    MobyHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void onClick(View v) {
        cmds.get(v.getId()).exec(v);
    }

    void alert(String mess){
        Toast.makeText(itemView.getContext(), mess, Toast.LENGTH_LONG).show();
    }
}