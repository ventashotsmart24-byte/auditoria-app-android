package com.hpplay.sdk.source.da;

import android.content.Context;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.da.a.a;
import com.hpplay.sdk.source.log.SourceLog;
import java.util.List;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11812a = "DaReportProcessor";

    /* renamed from: b  reason: collision with root package name */
    private static h f11813b;

    public static synchronized h a() {
        h hVar;
        synchronized (h.class) {
            if (f11813b == null) {
                f11813b = new h();
            }
            hVar = f11813b;
        }
        return hVar;
    }

    public static void b() {
        f11813b = null;
    }

    public void a(Context context, OutParameter outParameter) {
        if (outParameter != null) {
            a.C0162a a10 = f.a().a(outParameter.session);
            if (a10 == null) {
                SourceLog.i(f11812a, "onDaStart ignore , daData is null");
                return;
            }
            g.a().b(outParameter, a10.f11762c, String.valueOf(1), a10.f11763d, true, "");
            List<String> list = a10.f11764e;
            if (list != null) {
                for (String a11 : list) {
                    g.a().a(context, a11, false, 0, a10.f11760a);
                }
            }
        }
    }

    public void a(Context context, OutParameter outParameter, long j10) {
        if (outParameter != null) {
            a.C0162a a10 = f.a().a(outParameter.session);
            if (a10 == null) {
                SourceLog.i(f11812a, "onDaEnd ignore , daData is null");
                return;
            }
            g.a().c(outParameter, a10.f11762c, String.valueOf(1), a10.f11763d, true, "");
            int i10 = ((int) j10) * 1000;
            if (i10 <= 0) {
                SourceLog.i(f11812a, "onDaEnd ignore , duration: " + i10);
                return;
            }
            List<String> list = a10.f11765f;
            if (list != null) {
                for (String a11 : list) {
                    g.a().a(context, a11, true, i10, a10.f11760a);
                }
            }
        }
    }
}
