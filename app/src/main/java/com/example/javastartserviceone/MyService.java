package com.example.javastartserviceone;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {

    private MediaPlayer mediaPlayer;
    MyThread thread;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("001", "onStartCommand: ");
        thread = new MyThread();
        thread.start();

        mediaPlayer.start();
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("001", "onCreate: ");
        mediaPlayer = MediaPlayer.create(this, R.raw.cunganh);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
        Log.d("001", "onDestroy: ");
    }


    public class MyThread extends Thread {
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d("001", "run: 111");
            }
        }
    }
}
