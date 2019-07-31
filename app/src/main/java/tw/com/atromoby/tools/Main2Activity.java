package tw.com.atromoby.tools;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import java.util.Locale;

import tw.com.atromoby.rtmplayer.IjkVideoView;
import tw.com.atromoby.utils.Json;
import tw.com.atromoby.widgets.Cmd;
import tw.com.atromoby.widgets.RootActivity;

public class Main2Activity extends RootActivity {

    private IjkVideoView video;

   // private static IMediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
/*
        String path = "rtmp://wmvdo.c2h6.cn/ytb01-1/stream1";
        video = findViewById(R.id.my_player);

        video.setVideoPath(path);
        video.start();

        delay(10000, new Cmd() {
            @Override
            public void exec() {
                video.stopPlayback();
                video.setVideoPath("rtmp://wmvdo.c2h6.cn/ytb01-1/stream1");
                video.start();
            }
        });
*/
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
