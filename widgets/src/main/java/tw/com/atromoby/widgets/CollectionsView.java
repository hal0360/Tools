package tw.com.atromoby.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class CollectionsView extends RecyclerView {

    private CollectionsView.CollectionAdaptor mobyAdaptor;

    public CollectionsView(Context context) {
        super(context);
    }

    public CollectionsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mobyAdaptor = new CollectionsView.CollectionAdaptor(new ArrayList<Collection>());
        setAdapter(mobyAdaptor);
    }

    public void refresh(int pos) {
        mobyAdaptor.notifyItemChanged(pos);
    }

    public void add(int pos, Collection collection) {
        mobyAdaptor.collections.add(pos, collection);
        mobyAdaptor.notifyItemInserted(pos);
    }

    public void add(int pos, List<? extends Collection> collections) {
        mobyAdaptor.collections.addAll(pos, collections);
        mobyAdaptor.notifyItemInserted(pos);
    }

    public void add(Collection collection) {
        mobyAdaptor.collections.add(collection);
        mobyAdaptor.notifyItemInserted(mobyAdaptor.collections.size() - 1);
    }

    public void add(List<? extends Collection> collections) {
        mobyAdaptor.collections.addAll(collections);
        mobyAdaptor.notifyItemInserted(mobyAdaptor.collections.size() - 1);
    }

    public void delete(int index) {
        mobyAdaptor.collections.remove(index);
        mobyAdaptor.notifyItemRemoved(index);
    }
/*
    public void scrollTo(int pos) {
        smoothScrollToPosition(pos);
    }


    public int findScroll() {
        return ((LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition();
    }*/

    public void delete() {
        mobyAdaptor.collections.clear();
        mobyAdaptor.notifyDataSetChanged();
    }

    public void replace(List<? extends Collection> collections) {
        mobyAdaptor.collections.clear();
        mobyAdaptor.collections.addAll(collections);
        mobyAdaptor.notifyDataSetChanged();
        scrollToPosition(0);
    }

    public List<Collection> getCollections() {
        return mobyAdaptor.collections;
    }

    public void refresh() {
        mobyAdaptor.notifyDataSetChanged();
    }

    private class CollectionAdaptor extends RecyclerView.Adapter<CollectionHolder> {

        List<Collection> collections;

        CollectionAdaptor(List<Collection> collections) {
            this.collections = collections;
        }

        @Override
        public int getItemCount() {
            return collections.size();
        }

        @Override
        public void onBindViewHolder(CollectionHolder holder, int i) {
            Collection collection = collections.get(i);
            collection.onBind(holder);
        }

        @Override
        public int getItemViewType(int position) {
            return collections.get(position).itemHolderrid;
        }


        @Override
        public CollectionHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
            return new CollectionHolder(view);
        }

        @Override
        public void onViewRecycled(CollectionHolder holder) {
            int hPos = holder.getAdapterPosition();
            if (hPos >= 0) {
                Collection collection = collections.get(hPos);
                collection.onRecycle(holder);
            }
        }
    }

}


