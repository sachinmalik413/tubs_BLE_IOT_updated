package co.aurasphere.bluepair;

import android.app.Application;

import com.clj.fastble.BleManager;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        BleManager.getInstance().init(this);


    }
}
