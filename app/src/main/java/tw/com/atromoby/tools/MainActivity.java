package tw.com.atromoby.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import tw.com.atromoby.utils.LocalIntent;
import tw.com.atromoby.utils.LocalReceiver;
import tw.com.atromoby.widgets.CmdView;
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

        App.putStr("user", "ron");
        App.putInt("id", 1337);

        localReceiver.registerReceiver(this,"test-filt");

        clicked(R.id.testButt, new CmdView() {
            @Override
            public void exec(View v) {
                alert(App.getStr("user", "nono") + " " + App.getInt("id", 0));
            }
        });

        quickStartService(TestService.class);

    }

}
