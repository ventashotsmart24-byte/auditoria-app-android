package com.taobao.accs.net;

import android.text.TextUtils;
import anet.channel.IAuth;
import anet.channel.RequestCb;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.RequestStatistic;
import com.taobao.accs.net.k;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import java.util.List;
import java.util.Map;

class u implements RequestCb {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IAuth.AuthCallback f13095a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ k.a f13096b;

    public u(k.a aVar, IAuth.AuthCallback authCallback) {
        this.f13096b = aVar;
        this.f13095a = authCallback;
    }

    public void onDataReceive(ByteArray byteArray, boolean z10) {
    }

    public void onFinish(int i10, String str, RequestStatistic requestStatistic) {
        if (i10 < 0) {
            ALog.e(this.f13096b.f13073c, "auth onFinish", "statusCode", Integer.valueOf(i10));
            this.f13095a.onAuthFail(i10, "onFinish auth fail");
        }
    }

    public void onResponseCode(int i10, Map<String, List<String>> map) {
        ALog.e(this.f13096b.f13073c, BaseMonitor.ALARM_POINT_AUTH, "httpStatusCode", Integer.valueOf(i10));
        if (i10 == 200) {
            this.f13095a.onAuthSuccess();
            if (this.f13096b.f13074d instanceof k) {
                ((k) this.f13096b.f13074d).o();
            }
        } else {
            this.f13095a.onAuthFail(i10, "auth fail");
        }
        Map<String, String> a10 = UtilityImpl.a(map);
        ALog.d(this.f13096b.f13073c, BaseMonitor.ALARM_POINT_AUTH, "header", a10);
        String str = a10.get("x-at");
        if (!TextUtils.isEmpty(str)) {
            this.f13096b.f13074d.f13035k = str;
        }
    }
}
