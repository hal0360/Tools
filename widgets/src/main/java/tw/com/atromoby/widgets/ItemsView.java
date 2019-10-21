package tw.com.atromoby.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ItemsView extends RecyclerView {

    private ItemsView.MobyAdaptor mobyAdaptor;

    public ItemsView(Context context) {
        super(context);
    }

    public ItemsView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        mobyAdaptor = new ItemsView.MobyAdaptor(new ArrayList<ItemHolder>());
        setAdapter(mobyAdaptor);
    }

    public void refresh(int pos) {
        mobyAdaptor.notifyItemChanged(pos);
    }

    public void add(int pos, ItemHolder item){
        mobyAdaptor.items.add(pos, item);
        mobyAdaptor.notifyItemInserted(pos);
    }

    public void add(int pos, List<? extends ItemHolder> items){
        mobyAdaptor.items.addAll(pos, items);
        mobyAdaptor.notifyItemInserted(pos);
    }

    public void add(ItemHolder item){
        mobyAdaptor.items.add(item);
        mobyAdaptor.notifyItemInserted(mobyAdaptor.items.size() - 1);
    }

    public void add(List<? extends ItemHolder> items){
        mobyAdaptor.items.addAll(items);
        mobyAdaptor.notifyItemInserted(mobyAdaptor.items.size() - 1);
    }

    public void delete(int index){
        mobyAdaptor.items.remove(index);
        mobyAdaptor.notifyItemRemoved(index);
    }

    public void clean(){
        for(ItemHolder holder: mobyAdaptor.items){
            holder.onRecycle();
        }
    }

    public void scrollTo(int pos){
        smoothScrollToPosition(pos);
    }

    public int findScroll() {
       return  ((LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition();
    }

    public void delete(){
        mobyAdaptor.items.clear();
        mobyAdaptor.notifyDataSetChanged();
    }

    public void replace(List<? extends ItemHolder> items){
        mobyAdaptor.items.clear();
        mobyAdaptor.items.addAll(items);
        mobyAdaptor.notifyDataSetChanged();
        scrollToPosition(0);
    }

    public void refresh(){
        mobyAdaptor.notifyDataSetChanged();
    }

    private class MobyAdaptor extends RecyclerView.Adapter<MobyHolder>{

        public List<ItemHolder> items;

        MobyAdaptor(List<ItemHolder> items) {
            this.items = items;
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        @Override
        public void onBindViewHolder(@NonNull final MobyHolder holder, final int i) {
            ItemHolder itemHolder = items.get(i);
            itemHolder.position = holder.getAdapterPosition();
            itemHolder.myHolder = holder;
            itemHolder.onBind();
        }

        @Override
        public int getItemViewType(int position) {
            return items.get(position).itemHolderrid;
        }

        @NonNull
        @Override
        public MobyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
            return new MobyHolder(view);
        }

        @Override
        public void onViewRecycled (@NonNull MobyHolder holder) {
            int hPos = holder.getAdapterPosition();
            if(hPos >= 0){
                ItemHolder iHold = items.get(holder.getAdapterPosition());
                iHold.myHolder = null;
                iHold.onRecycle();
            }
        }
    }

}
