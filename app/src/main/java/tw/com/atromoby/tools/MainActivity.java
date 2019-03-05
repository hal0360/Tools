package tw.com.atromoby.tools;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import tw.com.atromoby.utils.LocalIntent;
import tw.com.atromoby.utils.LocalReceiver;
import tw.com.atromoby.utils.TimeTask;
import tw.com.atromoby.widgets.Cmd;
import tw.com.atromoby.widgets.CmdView;
import tw.com.atromoby.widgets.CmdInt;
import tw.com.atromoby.widgets.ItemsView;
import tw.com.atromoby.widgets.RootActivity;
import tw.com.atromoby.rtmplayer.IjkVideoView;
import tw.com.atromoby.widgets.SpinList;

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

    @SuppressLint("ClickableViewAccessibility")
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
              //  itemsView.smoothScrollToPosition(14);
                    alert(itemsView.findScroll() + "");
            }
        });


        delay(1000, new Cmd() {
            @Override
            public void exec() {
                itemsView.scrollTo(4);
            }
        });


        itemsView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                switch (newState) {
                    case RecyclerView.SCROLL_STATE_IDLE:
                        Log.e("SCROLL", "stopped.");
                        break;
                    case RecyclerView.SCROLL_STATE_DRAGGING:
                        Log.e("SCROLL", "drag.");
                        break;
                    case RecyclerView.SCROLL_STATE_SETTLING:
                        Log.e("SCROLL", "settling.");
                        break;

                }

                /*
                delay(200, new Cmd() {
                    @Override
                    public void exec() {
                        itemsView.scrollTo(iis);
                    }
                });*/

            }
        });


        SpinList spinList = findViewById(R.id.spinner);
        List<String> strings = new ArrayList<>();
        strings.add("apple");
        strings.add("orange");
        strings.add("pineapple");
        strings.add("kiwi fruit");
        spinList.init(strings);

        spinList.setColor("#00FFFF");

        spinList.selected(new CmdInt() {
            @Override
            public void exec(int i) {
                alert("no. " + i);
            }
        });



    }

}
