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

import java.util.List;

public class ItemsView extends RecyclerView {

    private Context context;
    private ItemsView.MobyAdaptor mobyAdaptor;

    public ItemsView(Context context)
    {
        super(context);
        this.context = context;
    }

    public ItemsView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        this.context = context;
    }

    public ItemsView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
    }


    public void init(List<ItemHolder> items){
        mobyAdaptor = new ItemsView.MobyAdaptor(items);
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

    public void delete(int index){
        mobyAdaptor.items.remove(index);
        mobyAdaptor.notifyItemRemoved(index);

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
            holder.init(items.get(i));
        }

        @Override
        public int getItemViewType(int position) {
            return items.get(position).getResID();
        }

        @NonNull
        @Override
        public MobyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
            return new MobyHolder(view);
        }

        @Override
        public void onViewRecycled (@NonNull MobyHolder holder) {
            holder.cleaned();
        }
    }

}
