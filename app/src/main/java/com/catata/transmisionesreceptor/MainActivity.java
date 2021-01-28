package com.catata.transmisionesreceptor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    BroadcastReceiver br;
    IntentFilter filter;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);

        br = new MyBroadcastReceiver(tv);

        filter = new IntentFilter();
        filter.addAction(MyBroadcastReceiver.ACTION);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(br, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(br);
    }
}