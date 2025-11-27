package com.taobao.agoo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.taobao.accs.client.a;

public class AgooCommondReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        try {
            context.getPackageName();
            String b10 = a.b();
            intent.setFlags(0);
            intent.setClassName(context, b10);
            com.taobao.accs.a.a.a(context, intent);
        } catch (Throwable unused) {
        }
    }
}
