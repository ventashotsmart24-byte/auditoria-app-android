package com.taobao.accs.net;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.taobao.accs.client.GlobalConfig;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import java.util.Calendar;

class e extends g {

    /* renamed from: c  reason: collision with root package name */
    private PendingIntent f13048c;

    /* renamed from: d  reason: collision with root package name */
    private AlarmManager f13049d;

    public e(Context context) {
        super(context);
    }

    public void a(int i10) {
        int i11;
        if (GlobalConfig.isAlarmHeartbeatEnable()) {
            if (this.f13049d == null) {
                this.f13049d = (AlarmManager) this.f13053a.getSystemService("alarm");
            }
            if (this.f13049d == null) {
                ALog.e("AlarmHeartBeatMgr", "setInner null", new Object[0]);
                return;
            }
            if (this.f13048c == null) {
                Intent intent = new Intent();
                intent.setPackage(this.f13053a.getPackageName());
                intent.addFlags(32);
                intent.setAction(Constants.ACTION_COMMAND);
                intent.putExtra("command", 201);
                if (Build.VERSION.SDK_INT >= 23) {
                    i11 = 67108864;
                } else {
                    i11 = 0;
                }
                this.f13048c = PendingIntent.getBroadcast(this.f13053a, 0, intent, i11);
            }
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(System.currentTimeMillis());
            instance.add(13, i10);
            this.f13049d.set(0, instance.getTimeInMillis(), this.f13048c);
        }
    }
}
