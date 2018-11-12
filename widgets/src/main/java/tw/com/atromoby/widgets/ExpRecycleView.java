package tw.com.atromoby.widgets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ExpRecycleView extends RecyclerView {

    public Context context;
    private ExpRecycleView.MyAdaptor myAdaptor;
    public ViewGroup tempVG;
    public static final SparseArray<Provider> holders = new SparseArray<>();

    public ExpRecycleView(Context context)
    {
        super(context);
        this.context = context;
    }

    public ExpRecycleView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        this.context = context;
    }

    public ExpRecycleView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
    }

    /*
    public void init(List<Item> items){
        myAdaptor = new ExpRecycleView.MyAdaptor(items);
        setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(context);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        setLayoutManager(llm);
        setAdapter(myAdaptor);
    }

    public void add(int pos, Item item){
        myAdaptor.items.add(pos, item);
        myAdaptor.notifyItemInserted(pos);
    }

    public void delete(int index){
        myAdaptor.items.remove(index);
        myAdaptor.notifyItemRemoved(index);
    }*/



    private ExpRecycleView getThis(){
        return this;
    }

    private class MyAdaptor extends RecyclerView.Adapter<MobyHolder>{

        public List<CollectHolder> items;

        public MyAdaptor(List<CollectHolder> items) {
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
            MobyHolder holder = new MobyHolder(view);
            return holder;
        }

        @Override
        public void onViewDetachedFromWindow(@NonNull MobyHolder holder) {

        }

        @Override
        public void onViewRecycled (@NonNull MobyHolder holder) {
         
        }
    }

}
