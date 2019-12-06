package tw.com.atromoby.widgets;

public abstract class Collection {

    int itemHolderrid;

    public Collection(int resID) {
        itemHolderrid = resID;
    }

    public abstract void onBind(CollectionHolder holder);

    public abstract void onRecycle(CollectionHolder holder);

}
