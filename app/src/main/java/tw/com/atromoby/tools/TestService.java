package tw.com.atromoby.tools;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import tw.com.atromoby.utils.LocalIntent;
import tw.com.atromoby.utils.LocalReceiver;


public class TestService extends Service {
    public TestService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Testy testy = new Testy("missing link", 1223);
        LocalIntent in = new LocalIntent("test-filt", testy);
        in.putExtra("nuke", "bomb");
        LocalReceiver.send(this,in);
        return Service.START_STICKY;
    }
}
