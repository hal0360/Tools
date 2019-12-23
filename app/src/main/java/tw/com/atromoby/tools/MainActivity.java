package tw.com.atromoby.tools;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import java.util.Locale;

import tw.com.atromoby.rtmplayer.IjkVideoView;
import tw.com.atromoby.widgets.CmdView;
import tw.com.atromoby.widgets.CollectionsView;
import tw.com.atromoby.widgets.RootActivity;

public class MainActivity extends RootActivity {

    private IjkVideoView mVideoView;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CollectionsView itemsView = findViewById(R.id.iiView);

        itemsView.add(new RecordHolder("sd"));
        itemsView.add(new RecordHolder("sd"));
        itemsView.add(new RecordHolder("sd"));
        RecordHolder recordHolder = new RecordHolder("sd");
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

                switchLocale(Locale.TAIWAN);

            }
        });

/*
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

                if(newState == RecyclerView.SCROLL_STATE_IDLE){
                    final int curPos = itemsView.findScroll();
                    delay(200, new Cmd() {
                        @Override
                        public void exec() {
                            itemsView.scrollTo(curPos);
                        }
                    });
                }

            }
        });
*/




    }

    private void dicky(){

    }

}
