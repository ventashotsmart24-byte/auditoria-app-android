package com.umeng.commonsdk.statistics.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

public class a {

    /* renamed from: com.umeng.commonsdk.statistics.common.a$a  reason: collision with other inner class name */
    public static final class C0203a {

        /* renamed from: a  reason: collision with root package name */
        private final String f14907a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f14908b;

        public C0203a(String str, boolean z10) {
            this.f14907a = str;
            this.f14908b = z10;
        }

        /* access modifiers changed from: private */
        public String b() {
            return this.f14907a;
        }

        public boolean a() {
            return this.f14908b;
        }
    }

    public static final class b implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        boolean f14909a;

        /* renamed from: b  reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f14910b;

        private b() {
            this.f14909a = false;
            this.f14910b = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() {
            if (!this.f14909a) {
                this.f14909a = true;
                return this.f14910b.take();
            }
            throw new IllegalStateException();
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f14910b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static String a(Context context) {
        try {
            C0203a c10 = c(context);
            if (c10 != null && !c10.a()) {
                return c10.b();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static String b(Context context) {
        try {
            C0203a c10 = c(context);
            if (c10 == null) {
                return null;
            }
            return c10.b();
        } catch (Exception unused) {
            return null;
        }
    }

    private static C0203a c(Context context) {
        if (Looper.myLooper() == Looper.getMainLooper() || com.umeng.commonsdk.utils.b.a().a(context, "com.android.vending", 0) == null) {
            return null;
        }
        b bVar = new b();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, bVar, 1)) {
            try {
                c cVar = new c(bVar.a());
                boolean a10 = cVar.a(true);
                String str = "";
                if (!a10) {
                    str = cVar.a();
                }
                C0203a aVar = new C0203a(str, a10);
                context.unbindService(bVar);
                return aVar;
            } catch (Exception e10) {
                throw e10;
            } catch (Throwable th) {
                context.unbindService(bVar);
                throw th;
            }
        } else {
            throw new IOException("Google Play connection failed");
        }
    }

    public static final class c implements IInterface {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f14911a;

        public c(IBinder iBinder) {
            this.f14911a = iBinder;
        }

        public String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f14911a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public IBinder asBinder() {
            return this.f14911a;
        }

        public boolean a(boolean z10) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z11 = true;
                obtain.writeInt(z10 ? 1 : 0);
                this.f14911a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z11 = false;
                }
                return z11;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }
}
