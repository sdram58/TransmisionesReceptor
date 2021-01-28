package com.catata.transmisionesreceptor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "MyBroadcastReceiver";
    public static final String ACTION = "com.catata.transmisiones.MainActivity.ACTION_RECEIVER";
    public static final String EXTRA = "com.catata.transmisiones.MainActivity.RECEIVER_EXTRA";

    private TextView tv;
    public MyBroadcastReceiver(TextView tv){
        super();
        this.tv = tv;

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isMyReceiver = ACTION.equals(intent.getAction());
        if(isMyReceiver){
            tv.setText("has enviado " + intent.getStringExtra(EXTRA));
            //Toast.makeText(context, "has enviado " + intent.getStringExtra(EXTRA), Toast.LENGTH_LONG).show();
        } else{
            StringBuilder sb = new StringBuilder();
            sb.append("Action: " + intent.getAction() + "\n");
            sb.append("URI: " + intent.toUri(Intent.URI_INTENT_SCHEME).toString() + "\n");
            String log = sb.toString();
            Log.d(TAG, log);
            Toast.makeText(context, log, Toast.LENGTH_LONG).show();
        }

    }
}