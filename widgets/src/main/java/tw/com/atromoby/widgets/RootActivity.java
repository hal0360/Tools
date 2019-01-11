package tw.com.atromoby.widgets;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public abstract class RootActivity extends AppCompatActivity implements View.OnClickListener{

    private final SparseArray<CmdView> cmds = new SparseArray<>();
    private Handler handler;
    private static Locale locale = Locale.US;

    public void switchLocale(Locale loc){
        locale = loc;
        recreate();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        Context context = MyContextWrap.wrap(newBase, locale);
        super.attachBaseContext(context);
    }

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        handler = new Handler();
    }


    public final void clicked(int id, CmdView cd){
        findViewById(id).setOnClickListener(this);
        cmds.put(id,cd);
    }

    public final void setTextView(int id, String str){
        TextView txt = findViewById(id);
        txt.setText(str);
    }

    public final String getTextView(int id){
        TextView txt = findViewById(id);
        return txt.getText().toString();
    }

    public final void delay(int milsec, final Cmd cmd){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                cmd.exec();
            }
        }, milsec);
    }

    public final void clicked(View v, CmdView cd){
        v.setOnClickListener(this);
        cmds.put(v.getId(),cd);
    }

    public final void pushActivity(Class<? extends AppCompatActivity> actClass){
        Intent intent = new Intent(this, actClass);
        startActivity(intent);
    }

    public final void pushActivity(Class<? extends AppCompatActivity> actClass, int anime){
        Intent intent = new Intent(this, actClass);
        startActivity(intent);
        switch (anime) {
            case 1:
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                break;
            case 2:
                overridePendingTransition(R.anim.slide_up,R.anim.slide_down);
                break;
        }
    }

    public final void treeObserve(final View view, final CmdView cmdView){
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                cmdView.exec(view);
            }
        });
    }

    public final void quickStartService(Class<? extends Service> serviceClass){
        startService(new Intent(this, serviceClass));
    }

    public final void quickStopService(Class<? extends Service> serviceClass){
        stopService(new Intent(this, serviceClass));
    }

    public void alert(String mess){
        Toast.makeText(this, mess, Toast.LENGTH_LONG).show();
    }

    public final void toActivity(Class<? extends AppCompatActivity> actClass){
        Intent intent = new Intent(this, actClass);
        startActivity(intent);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 500);
    }

    public final void toActivity(Class<? extends AppCompatActivity> actClass, int anime){
        Intent intent = new Intent(this, actClass);
        startActivity(intent);
        switch (anime) {
            case 1:
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                break;
            case 2:
                overridePendingTransition(R.anim.slide_up,R.anim.slide_down);
                break;
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 500);
    }

    @Override
    public void onClick(View v) {
        cmds.get(v.getId()).exec(v);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
