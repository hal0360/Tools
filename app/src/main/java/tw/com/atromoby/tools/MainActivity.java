package tw.com.atromoby.tools;

import android.os.Bundle;
import android.view.View;

import java.util.Locale;

import tw.com.atromoby.utils.LocalIntent;
import tw.com.atromoby.utils.LocalReceiver;
import tw.com.atromoby.widgets.CmdView;
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


        clicked(R.id.bobob, new CmdView() {
            @Override
            public void exec(View v) {
                switchLocale(Locale.TAIWAN);
            }
        });

        String path = "rtmp://demo-stream.wm77.asia/live1/stream1";
         mVideoView = findViewById(R.id.video);
         mVideoView.setVideoPath(path);
         mVideoView.start();


    }

}
