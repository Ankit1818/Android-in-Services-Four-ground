package com.example.spp;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {
    public  static final String CHHANEL_ID = "Spp App Is Runing";

    @Override
    public void onCreate() {
        super.onCreate();

        createnotification();
    }
   private void createnotification(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel services=new NotificationChannel(CHHANEL_ID,"App App", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(services);
        }
    }
}

