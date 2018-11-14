package tw.com.atromoby.widgets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ItemsView extends RecyclerView {

    private ItemsView.MobyAdaptor mobyAdaptor;

    public ItemsView(Context context)
    {
        super(context);
        init(context);
    }

    public ItemsView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(context);
    }

    public ItemsView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context){
        mobyAdaptor = new ItemsView.MobyAdaptor(new ArrayList<ItemHolder>());
        setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(context);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        setLayoutManager(llm);
        setAdapter(mobyAdaptor);
    }

    public void add(int pos, ItemHolder item){
        mobyAdaptor.items.add(pos, item);
        mobyAdaptor.notifyItemInserted(pos);
    }

    public void add(int pos, List<ItemHolder> items){
        mobyAdaptor.items.addAll(pos, items);
        mobyAdaptor.notifyItemInserted(pos);
    }

    public void add(ItemHolder item){
        mobyAdaptor.items.add(item);
        mobyAdaptor.notifyItemInserted(mobyAdaptor.items.size() - 1);
    }

    public void add(List<ItemHolder> items){
        mobyAdaptor.items.addAll(items);
        mobyAdaptor.notifyItemInserted(mobyAdaptor.items.size() - 1);
    }

    public void delete(int index){
        mobyAdaptor.items.remove(index);
        mobyAdaptor.notifyItemRemoved(index);
    }

    public void delete(){
        mobyAdaptor.items.clear();
        mobyAdaptor.notifyDataSetChanged();
    }

    public void replace(List<ItemHolder> items){
        mobyAdaptor.items.clear();
        mobyAdaptor.items.addAll(items);
        mobyAdaptor.notifyDataSetChanged();
        scrollToPosition(0);
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
        public void onBindViewHolder(@NonNull MobyHolder holder, int i) {
            ItemHolder itemHolder = items.get(i);
            itemHolder.myHolder = holder;
            holder.cHold = itemHolder;
            itemHolder.onBind();
        }

        @Override
        public int getItemViewType(int position) {
            return items.get(position).rid;
        }

        @NonNull
        @Override
        public MobyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
            return new MobyHolder(view);
        }

        @Override
        public void onViewRecycled (@NonNull MobyHolder holder) {
            holder.cHold.myHolder = null;
            holder.cHold.onClean();
            holder.cHold = null;
        }
    }

}
