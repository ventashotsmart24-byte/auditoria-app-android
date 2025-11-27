package com.efs.sdk.base.core.util.a;

import com.efs.sdk.base.core.util.concurrent.b;
import com.efs.sdk.base.http.AbsHttpListener;
import com.efs.sdk.base.http.HttpEnv;
import com.efs.sdk.base.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public b f5309a;

    /* renamed from: b  reason: collision with root package name */
    private List<b<HttpResponse>> f5310b;

    public d(String str) {
        b bVar = new b();
        this.f5309a = bVar;
        bVar.f5301a = str;
    }

    public final d a(Map<String, String> map) {
        this.f5309a.f5302b = map;
        return this;
    }

    public final d a(String str, String str2) {
        b bVar = this.f5309a;
        if (bVar.f5306f == null) {
            bVar.f5306f = new HashMap(5);
        }
        this.f5309a.f5306f.put(str, str2);
        return this;
    }

    public final d a(AbsHttpListener absHttpListener) {
        if (this.f5310b == null) {
            this.f5310b = new ArrayList(5);
        }
        this.f5310b.add(absHttpListener);
        return this;
    }

    public final c a() {
        c cVar = new c(this.f5309a);
        List<b<HttpResponse>> list = this.f5310b;
        if (list != null && list.size() > 0) {
            cVar.a(this.f5310b);
        }
        List<b<HttpResponse>> httpListenerList = HttpEnv.getInstance().getHttpListenerList();
        if (httpListenerList != null && httpListenerList.size() > 0) {
            cVar.a(httpListenerList);
        }
        return cVar;
    }
}
