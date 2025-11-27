package com.hpplay.sdk.source.da;

import android.content.Context;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.business.BusinessEntity;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.CreateUtil;
import java.util.HashMap;
import java.util.Map;

public class e implements j {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11784a = "DaManager";

    /* renamed from: b  reason: collision with root package name */
    private static e f11785b;

    /* renamed from: c  reason: collision with root package name */
    private OutParameter f11786c;

    /* renamed from: d  reason: collision with root package name */
    private j f11787d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, String> f11788e = new HashMap();

    private e() {
    }

    public static synchronized e d() {
        e eVar;
        synchronized (e.class) {
            synchronized (e.class) {
                if (f11785b == null) {
                    f11785b = new e();
                }
                eVar = f11785b;
            }
        }
        return eVar;
    }

    public void a(Context context) {
        j a10 = b.a(context);
        this.f11787d = a10;
        if (a10 == null) {
            SourceLog.w(f11784a, "init error");
        } else {
            a10.a(context);
        }
    }

    public void b(Context context) {
        OutParameter outParameter = this.f11786c;
        if (outParameter != null) {
            outParameter.pushType = 2;
            BusinessEntity.getInstance().dispatchPlay(context, this.f11786c);
            this.f11786c = null;
        }
    }

    public void c() {
        f11785b = null;
        this.f11788e.clear();
        j jVar = this.f11787d;
        if (jVar != null) {
            jVar.c();
        }
    }

    public void a() {
        j jVar = this.f11787d;
        if (jVar != null) {
            jVar.a();
        }
    }

    public void b() {
        j jVar = this.f11787d;
        if (jVar != null) {
            jVar.b();
        }
    }

    public void a(OutParameter outParameter, m mVar) {
        b();
        j jVar = this.f11787d;
        if (jVar != null) {
            jVar.a(outParameter, mVar);
        } else if (mVar != null) {
            mVar.onDaResult(false, (String) null);
        }
    }

    public void a(Context context, OutParameter outParameter, String str) {
        this.f11786c = outParameter;
        OutParameter clone = outParameter.clone();
        clone.setUrl(str);
        String createPushUri = CreateUtil.createPushUri(clone.getPlayUrl());
        clone.urlID = createPushUri;
        clone.pushType = 1;
        this.f11788e.put(outParameter.session, createPushUri);
        BusinessEntity.getInstance().dispatchPlay(context, clone);
    }

    public String a(String str) {
        return this.f11788e.get(str);
    }

    public void a(OutParameter outParameter) {
        j jVar = this.f11787d;
        if (jVar != null) {
            jVar.a(outParameter);
        }
    }

    public void a(OutParameter outParameter, long j10) {
        j jVar = this.f11787d;
        if (jVar != null) {
            jVar.a(outParameter, j10);
        }
    }
}
