package com.hpplay.sdk.source.da;

import android.content.Context;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.log.SourceLog;

public class DaClientImpl implements j {

    /* renamed from: a  reason: collision with root package name */
    private final String f11748a = "DaClientImpl";

    /* renamed from: b  reason: collision with root package name */
    private Context f11749b;

    public DaClientImpl(Context context) {
        this.f11749b = context;
    }

    public void a(Context context) {
        SourceLog.i("DaClientImpl", "init");
    }

    public void b() {
        f.a().d();
    }

    public void c() {
        f.b();
        h.b();
        g.b();
    }

    public void a() {
        SourceLog.i("DaClientImpl", "requestDaConfig");
        f.a().c();
    }

    public void a(OutParameter outParameter, m mVar) {
        LelinkServiceInfo lelinkServiceInfo;
        if (outParameter != null && (lelinkServiceInfo = outParameter.serviceInfo) != null) {
            int appId = lelinkServiceInfo.getAppId();
            SourceLog.i("DaClientImpl", "loadPatchDa loadPatchDa appId :" + appId);
            boolean a10 = a(appId);
            SourceLog.i("DaClientImpl", "loadPatchDa loadPatchDa :" + a10);
            if (a10) {
                f.a().a(this.f11749b, outParameter, mVar);
            } else if (mVar != null) {
                mVar.onDaResult(false, (String) null);
            }
        } else if (mVar != null) {
            mVar.onDaResult(false, (String) null);
        }
    }

    private boolean a(int i10) {
        if (d.a() == 0) {
            return false;
        }
        if (i10 != 0) {
            String valueOf = String.valueOf(i10);
            String[] b10 = d.b();
            if (b10 != null) {
                for (String equals : b10) {
                    if (valueOf.equals(equals)) {
                        return true;
                    }
                }
            }
            return false;
        } else if (d.c() != 0) {
            return true;
        } else {
            return false;
        }
    }

    public void a(OutParameter outParameter) {
        h.a().a(this.f11749b, outParameter);
    }

    public void a(OutParameter outParameter, long j10) {
        h.a().a(this.f11749b, outParameter, j10);
    }
}
