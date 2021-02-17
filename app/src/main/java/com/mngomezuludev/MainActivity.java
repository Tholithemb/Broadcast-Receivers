package com.mngomezuludev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    MyReceiver myReceiver = new MyReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {
        super.onStart();
        
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);

        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);

        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);

        this.registerReceiver(myReceiver,intentFilter);


    }


    @Override
    protected void onStop() {
        super.onStop();
        this.unregisterReceiver(myReceiver);
    }
}