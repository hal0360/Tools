package tw.com.atromoby.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
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
        init(context, null);
    }

    public ItemsView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(context, attrs);
    }

    public ItemsView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        assert attrs != null;
        init(context, attrs);
    }

    /*
    public void init(int direction, ArrayList<ItemHolder> itemHolders){
        mobyAdaptor = new ItemsView.MobyAdaptor(new ArrayList<ItemHolder>());
        setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(context);
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        setLayoutManager(llm);
        setAdapter(mobyAdaptor);
    }*/

    private void init(Context context, AttributeSet attrs){
        mobyAdaptor = new ItemsView.MobyAdaptor(new ArrayList<ItemHolder>());
        setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(context);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.ItemsView,
                0, 0);
        int type = 0;

        try {
            type = a.getInt(R.styleable.ItemsView_direction, 0);
        } catch (Exception e) {
            Log.e("ItemsView", "There was an error loading attributes.");
        } finally {
            a.recycle();
        }
        if(type == 0)  {
            llm.setOrientation(LinearLayoutManager.VERTICAL);
        }else{
            llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        }

        setLayoutManager(llm);
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
            ItemHolder iHold = items.get(holder.getAdapterPosition());
            iHold.myHolder = null;
            iHold.onRecycle();
        }
    }

}
