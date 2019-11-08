package tw.com.atromoby.tools;

import android.os.Bundle;
import android.view.View;

import tw.com.atromoby.rtmplayer.IjkVideoView;
import tw.com.atromoby.widgets.Cmd;
import tw.com.atromoby.widgets.CmdView;
import tw.com.atromoby.widgets.RootActivity;

public class Main2Activity extends RootActivity {

    private IjkVideoView video;
    StupidPopup popup;

   // private static IMediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String path = "rtmp://wmvdo.nicejj.cn/live1/stream1";

         popup = new StupidPopup();



        video = findViewById(R.id.my_player);
        video.setVideoPath(path);
        video.start();

        /*
        delay(10000, new Cmd() {
            @Override
            public void exec() {
                video.stopPlayback();
                video.setVideoPath("rtmp://wmvdo.c2h6.cn/ytb01-1/stream1");
                video.start();
            }
        });*/


        clicked(R.id.bb_butt, new CmdView() {
            @Override
            public void exec(View v) {
                showPopup(popup);
            }
        });


    }


    @Override
    public void onResume() {
        super.onResume();


        delay(5000, new Cmd() {
            @Override
            public void exec() {
                popup.dismiss();
            }
        });

    }
}
