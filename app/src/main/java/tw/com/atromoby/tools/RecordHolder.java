package tw.com.atromoby.tools;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import tw.com.atromoby.utils.Anime;
import tw.com.atromoby.widgets.CmdView;
import tw.com.atromoby.widgets.ItemHolder;

public class RecordHolder extends ItemHolder {

    private String name;
    private int inc = 0;

    public RecordHolder(String n) {
        super(R.layout.record_layout);
        name  = n;
    }

    @Override
    public void onBind() {

        ImageView ham = findViewById(R.id.avatar);


        clicked(R.id.avatar, new CmdView() {
            @Override
            public void exec(View v) {
                ImageView ham = findViewById(R.id.avatar);
                Anime anime = new Anime(ham, R.anim.bounce);
                anime.start(true);
            }
        });
    }

    @Override
    public void onRecycle() {
        Log.e("diff", "called: " + inc);
    }

    @Override
    public void onCreate() {

       // Log.e("diff", "called: " + inc);
      //  inc++;

        TextView textView = findViewById(R.id.nameTxt);
        textView.setText(name);


    }

}
