package com.efs.sdk.base.core.util.a;

import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.concurrent.c;
import com.efs.sdk.base.http.HttpEnv;
import com.efs.sdk.base.http.HttpResponse;
import java.io.File;
import java.util.Map;

public final class b implements c<HttpResponse> {

    /* renamed from: a  reason: collision with root package name */
    String f5301a;

    /* renamed from: b  reason: collision with root package name */
    Map<String, String> f5302b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f5303c;

    /* renamed from: d  reason: collision with root package name */
    public File f5304d;

    /* renamed from: e  reason: collision with root package name */
    public String f5305e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f5306f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5307g = false;

    public final /* synthetic */ Object a() {
        String str = this.f5305e;
        str.hashCode();
        if (str.equals("get")) {
            return HttpEnv.getInstance().getHttpUtil().get(this.f5301a, this.f5302b);
        }
        if (!str.equals("post")) {
            Log.e("efs.util.http", "request not support method '" + this.f5305e + "'");
            return null;
        }
        byte[] bArr = this.f5303c;
        if (bArr == null || bArr.length <= 0) {
            return HttpEnv.getInstance().getHttpUtil().post(this.f5301a, this.f5302b, this.f5304d);
        }
        if (this.f5307g) {
            return HttpEnv.getInstance().getHttpUtil().postAsFile(this.f5301a, this.f5302b, this.f5303c);
        }
        return HttpEnv.getInstance().getHttpUtil().post(this.f5301a, this.f5302b, this.f5303c);
    }
}
