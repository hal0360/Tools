package tw.com.atromoby.tools;

import android.os.Bundle;

import tw.com.atromoby.rtmplayer.IjkVideoView;
import tw.com.atromoby.utils.LocalIntent;
import tw.com.atromoby.utils.LocalReceiver;
import tw.com.atromoby.widgets.RootActivity;

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


        //定义的直播地址
        String path = "rtmp://demo-stream.wm77.asia/live1/stream2";

        //定义IjkVideoView
        //定义的播放按钮的layout，用来加载定义好的播放界面
        // mHudView = findViewById(R.id.hud_view);

        //这里使用的是Demo中提供的AndroidMediaController类控制播放相关操作

        // mMediaController = new AndroidMediaController(this, false);
        //ActionBar actionBar = getSupportActionBar();
        //mMediaController.setSupportActionBar(actionBar);

        mVideoView = findViewById(R.id.player);
        //mVideoView.setMediaController(null);
        // mVideoView.setHudView(mHudView);

        //设置videopath，开始播放
        mVideoView.setVideoPath(path);
        mVideoView.start();


    }

}
