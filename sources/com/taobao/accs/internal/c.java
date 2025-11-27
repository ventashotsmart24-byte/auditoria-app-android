package com.taobao.accs.internal;

import androidx.annotation.Keep;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.base.AccsConnectStateListener;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.data.Message;
import com.taobao.accs.net.a;
import com.taobao.accs.net.k;

@Keep
public class c implements com.taobao.accs.c {

    /* renamed from: a  reason: collision with root package name */
    private a f13018a;

    public c(String str) {
        this.f13018a = new k(GlobalClientInfo.f12899a, 1, str);
    }

    public void a() {
        this.f13018a.a();
    }

    public void b() {
        this.f13018a.k();
    }

    public String c() {
        return this.f13018a.i();
    }

    public String d() {
        return this.f13018a.f13033i.getAppSecret();
    }

    public boolean e(String str) {
        return this.f13018a.j().c(str);
    }

    public boolean f(String str) {
        return this.f13018a.j().d(str);
    }

    public void a(boolean z10, boolean z11) {
        this.f13018a.a(z10, z11);
    }

    public String b(String str) {
        return this.f13018a.b(str);
    }

    public void c(String str) {
        this.f13018a.f13025a = str;
    }

    public void d(String str) {
        this.f13018a.f13026b = str;
    }

    public String e() {
        return this.f13018a.f13033i.getStoreId();
    }

    public boolean f() {
        return this.f13018a.m();
    }

    public boolean a(String str) {
        return this.f13018a.a(str);
    }

    public void b(AccsConnectStateListener accsConnectStateListener) {
        this.f13018a.b(accsConnectStateListener);
    }

    public void a(Message message, int i10) {
        this.f13018a.b(message, i10);
    }

    public void a(Message message, boolean z10) {
        this.f13018a.b(message, z10);
    }

    public void a(AccsClientConfig accsClientConfig) {
        a aVar = this.f13018a;
        if (aVar instanceof k) {
            ((k) aVar).a(accsClientConfig);
        }
    }

    public boolean a(String str, String str2) {
        return this.f13018a.j().b(str, str2);
    }

    public void a(AccsConnectStateListener accsConnectStateListener) {
        this.f13018a.a(accsConnectStateListener);
    }
}
