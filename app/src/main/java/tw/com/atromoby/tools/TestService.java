package tw.com.atromoby.tools;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;


public class TestService extends Service {
    public TestService() {
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return Service.START_STICKY;
    }
}
