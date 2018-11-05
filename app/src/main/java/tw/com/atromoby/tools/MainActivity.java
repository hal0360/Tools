package tw.com.atromoby.tools;

import android.os.Bundle;
import android.view.View;

import tw.com.atromoby.widgets.CmdView;
import tw.com.atromoby.widgets.RootActivity;

public class MainActivity extends RootActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        App.putStr("user", "ron");
        App.putInt("id", 1337);

        clicked(R.id.testButt, new CmdView() {
            @Override
            public void exec(View v) {
                alert(App.getStr("user", "nono") + " " + App.getInt("id", 0));
            }
        });
    }
}
