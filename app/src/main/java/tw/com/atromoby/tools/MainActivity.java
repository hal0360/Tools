package tw.com.atromoby.tools;

import android.os.Bundle;
import android.view.View;

import java.util.Locale;

import tw.com.atromoby.utils.LocalIntent;
import tw.com.atromoby.utils.LocalReceiver;
import tw.com.atromoby.widgets.CmdView;
import tw.com.atromoby.widgets.ItemsView;
import tw.com.atromoby.widgets.RootActivity;

import tw.com.atromoby.rtmplayer.IjkVideoView;

public class MainActivity extends RootActivity {

    private IjkVideoView mVideoView;

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


        final ItemsView itemsView = findViewById(R.id.iiView);
        itemsView.add(new RecordHolder("sd"));
        itemsView.add(new RecordHolder("sd"));
        itemsView.add(new RecordHolder("sd"));
        final RecordHolder recordHolder = new RecordHolder("sd");
        itemsView.add(recordHolder);
        itemsView.add(new RecordHolder("sd"));
        itemsView.add(new RecordHolder("sd"));
        itemsView.add(new RecordHolder("sd"));
        itemsView.add(new RecordHolder("sd"));
        itemsView.add(new RecordHolder("sd"));
        itemsView.add(new RecordHolder("sd"));
        itemsView.add(new RecordHolder("sd"));
        itemsView.add(new RecordHolder("sd"));
        itemsView.add(new RecordHolder("sd"));
        itemsView.add(new RecordHolder("sd"));
        itemsView.add(new RecordHolder("sd"));
        itemsView.add(new RecordHolder("sd"));
        itemsView.add(new RecordHolder("sd"));
        itemsView.add(new RecordHolder("sd"));
        itemsView.add(new RecordHolder("sd"));
        itemsView.add(new RecordHolder("sd"));
        itemsView.add(new RecordHolder("sd"));
        itemsView.add(new RecordHolder("sd"));
        itemsView.add(new RecordHolder("sd"));
        itemsView.add(new RecordHolder("sd"));
        itemsView.add(new RecordHolder("sd"));
        itemsView.add(new RecordHolder("sd"));
        itemsView.add(new RecordHolder("sd"));
        itemsView.add(new RecordHolder("sd"));
        itemsView.add(new RecordHolder("sd"));


        clicked(R.id.enButt, new CmdView() {
            @Override
            public void exec(View v) {
                itemsView.smoothScrollToPosition(14);

            }
        });
    }

}
