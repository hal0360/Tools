package tw.com.atromoby.widgets;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.Toast;

class MobyHolder extends RecyclerView.ViewHolder{

    ItemHolder cHold;

    MobyHolder(@NonNull View itemView) {
        super(itemView);
    }


    void alert(String mess){
        Toast.makeText(itemView.getContext(), mess, Toast.LENGTH_LONG).show();
    }
}