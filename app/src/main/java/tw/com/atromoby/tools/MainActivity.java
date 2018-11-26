package tw.com.atromoby.tools;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import tw.com.atromoby.utils.LocalIntent;
import tw.com.atromoby.utils.LocalReceiver;
import tw.com.atromoby.widgets.ItemsView;
import tw.com.atromoby.widgets.RootActivity;

public class MainActivity extends RootActivity {

    private LocalReceiver localReceiver = new LocalReceiver() {
        @Override
        public void onReceive(LocalIntent localIntent) {
            Testy testy = localIntent.getObject(Testy.class);
            alert(testy.ape + testy.skull);
            alert(localIntent.getStringExtra("nuke"));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ItemsView items = findViewById(R.id.recycleView);
        items.add(new RecordHolder("Ron"));
        items.add(new CarHolder("jack"));
        items.add(new RecordHolder("lu"));
        items.add(new RecordHolder("han"));
        items.add(new RecordHolder("Ron"));
        items.add(new CarHolder("jack"));
        items.add(new RecordHolder("lu"));
        items.add(new RecordHolder("han"));
        items.add(new RecordHolder("Ron"));
        items.add(new CarHolder("jack"));
        items.add(new RecordHolder("lu"));
        items.add(new RecordHolder("han"));
        items.add(new RecordHolder("cake"));
        items.add(new CarHolder("jack"));
        items.add(new RecordHolder("lu"));
        items.add(new RecordHolder("han"));
        items.add(new RecordHolder("Ron"));
        items.add(new CarHolder("blue"));
        items.add(new RecordHolder("lu"));
        items.add(new RecordHolder("han"));
        items.add(new RecordHolder("han"));
        items.add(new RecordHolder("Ron"));
        items.add(new CarHolder("blue"));
        items.add(new RecordHolder("lu"));
        items.add(new RecordHolder("han"));


    }

}
