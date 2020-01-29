package com.example.spp;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import static com.example.spp.App.CHHANEL_ID;

public class MyServices extends Service {
    MediaPlayer mediaPlayer;
    @Override
    public void onCreate() {
        mediaPlayer = MediaPlayer.create(this,R.raw.track_01);
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent intent1=new Intent(this,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent1,0);
        mediaPlayer.start();
                Notification notification=new   NotificationCompat.Builder(this,CHHANEL_ID)
                .setContentTitle("Spp App Services Running")
                .setContentText("Message")
                .setSmallIcon(R.drawable.ic_play_arrow_black_24dp)
                        .setContentIntent(pendingIntent)
                        .build();
                startForeground(1,notification);
        return  START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }
}
