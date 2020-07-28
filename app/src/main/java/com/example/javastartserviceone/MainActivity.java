package com.example.javastartserviceone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//https://viblo.asia/p/tim-hieu-ve-service-trong-android-phan-1-LzD5d00O5jY
//https://viblo.asia/p/tim-hieu-ve-service-trong-android-phan-2-RnB5pGO6lPG

// so sánh service vs thread ...
//https://androidcoban.com/sanh-thread-handler-asynctask-service-intentservice.html
public class MainActivity extends AppCompatActivity {

    Button btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStop = findViewById(R.id.btn_stop);

        final Intent intent = new Intent(MainActivity.this, MyService.class);
        startService(intent);

        //  stopService(intent);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent);
            }
        });
    }
}
