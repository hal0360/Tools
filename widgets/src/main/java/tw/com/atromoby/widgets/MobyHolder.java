package tw.com.atromoby.widgets;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

class MobyHolder  extends RecyclerView.ViewHolder {

    private ItemHolder cHold;

    MobyHolder(@NonNull View itemView) {
        super(itemView);
    }

    void init(ItemHolder holder){
        holder.created(this);
        cHold = holder;
        holder.init();
    }

    void cleaned(){
        cHold.cleanUp();
    }

}