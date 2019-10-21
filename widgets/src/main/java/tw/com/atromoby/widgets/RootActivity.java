package tw.com.atromoby.widgets;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;

public abstract class RootActivity extends AppCompatActivity implements View.OnClickListener{

    private final SparseArray<CmdView> cmds = new SparseArray<>();
    private Handler handler;
    public static Locale locale = Locale.US;

    public void switchLocale(Locale loc){
        locale = loc;
        recreate();
    }

    public Locale getLocale(){
        return locale;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        Context context = MyContextWrap.wrap(newBase, locale);
        super.attachBaseContext(context);
    }

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        handler = new Handler();
    }

    public final void clicked(int id, CmdView cd) {
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

    public final void delay(int milsec, final Cmd cmd) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                cmd.exec();
            }
        }, milsec);
    }

    public final void cancelDelays() {
        handler.removeCallbacksAndMessages(null);
    }

    public final void clicked(View v, CmdView cd){
        v.setOnClickListener(this);
        cmds.put(v.getId(),cd);
    }

    public final boolean isPortrait() {
        int orientation = getResources().getConfiguration().orientation;
        return orientation != Configuration.ORIENTATION_LANDSCAPE;
    }

    public final void pushActivity(Class<? extends AppCompatActivity> actClass){
        Intent intent = new Intent(this, actClass);
        startActivity(intent);
    }

    public final void pushActivity(Class<? extends AppCompatActivity> actClass, int val) {
        Intent intent = new Intent(this, actClass);
        intent.putExtra("AtromoRootActVal", val);
        startActivity(intent);
    }

    public final void pushActivity(Class<? extends AppCompatActivity> actClass, String val){
        Intent intent = new Intent(this, actClass);
        intent.putExtra("AtromoRootActVal", val);
        startActivity(intent);
    }


/*
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
    }*/

    public final void treeObserve(final View view, final CmdView cmdView) {
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
        finish();
    }

    public final void toActivity(Class<? extends AppCompatActivity> actClass, int val) {
        Intent intent = new Intent(this, actClass);
        intent.putExtra("AtromoRootActVal", val);
        startActivity(intent);
        finish();
    }

    public final void toActivity(Class<? extends AppCompatActivity> actClass, String val){
        Intent intent = new Intent(this, actClass);
        intent.putExtra("AtromoRootActVal", val);
        startActivity(intent);
        finish();
    }

    public final int getPassedInt(){
        Bundle bundle = getIntent().getExtras();
        if(bundle!= null){
           return bundle.getInt("AtromoRootActVal");
        }else{
            return 0;
        }
    }

    public final String getPassedStr(){
        Bundle bundle = getIntent().getExtras();
        if(bundle!= null){
            return bundle.getString("AtromoRootActVal");
        }else{
            return null;
        }
    }

    /*
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
    }*/

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
