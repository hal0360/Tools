package tw.com.atromoby.tools;

import android.widget.TextView;

import tw.com.atromoby.widgets.ItemHolder;

public class CarHolder extends ItemHolder {
    private String name;
    public CarHolder(String name) {
        super(R.layout.car_layout);
        this.name = name;
    }

    @Override
    public void init() {
        TextView textView = findView(R.id.nameTxt);
        textView.setText(name);
    }

    @Override
    public void cleanUp() {

    }
}
