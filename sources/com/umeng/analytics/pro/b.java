package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface b extends IInterface {

    public static class a implements b {
        public void a(int i10, long j10, boolean z10, float f10, double d10, String str) {
        }

        public IBinder asBinder() {
            return null;
        }

        public void a(int i10, Bundle bundle) {
        }
    }

    void a(int i10, long j10, boolean z10, float f10, double d10, String str);

    void a(int i10, Bundle bundle);

    /* renamed from: com.umeng.analytics.pro.b$b  reason: collision with other inner class name */
    public static abstract class C0195b extends Binder implements b {

        /* renamed from: a  reason: collision with root package name */
        static final int f13815a = 1;

        /* renamed from: b  reason: collision with root package name */
        static final int f13816b = 2;

        /* renamed from: c  reason: collision with root package name */
        private static final String f13817c = "com.hihonor.cloudservice.oaid.IOAIDCallBack";

        /* renamed from: com.umeng.analytics.pro.b$b$a */
        public static class a implements b {

            /* renamed from: a  reason: collision with root package name */
            public static b f13818a;

            /* renamed from: b  reason: collision with root package name */
            private IBinder f13819b;

            public a(IBinder iBinder) {
                this.f13819b = iBinder;
            }

            public String a() {
                return C0195b.f13817c;
            }

            public IBinder asBinder() {
                return this.f13819b;
            }

            public void a(int i10, long j10, boolean z10, float f10, double d10, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(C0195b.f13817c);
                    int i11 = i10;
                    obtain.writeInt(i10);
                    obtain.writeLong(j10);
                    obtain.writeInt(z10 ? 1 : 0);
                    obtain.writeFloat(f10);
                    obtain.writeDouble(d10);
                    obtain.writeString(str);
                    try {
                        if (this.f13819b.transact(1, obtain, obtain2, 0) || C0195b.a() == null) {
                            obtain2.readException();
                            obtain2.recycle();
                            obtain.recycle();
                            return;
                        }
                        C0195b.a().a(i10, j10, z10, f10, d10, str);
                        obtain2.recycle();
                        obtain.recycle();
                    } catch (Throwable th) {
                        th = th;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            public void a(int i10, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(C0195b.f13817c);
                    obtain.writeInt(i10);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.f13819b.transact(2, obtain, obtain2, 0) || C0195b.a() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    C0195b.a().a(i10, bundle);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0195b() {
            attachInterface(this, f13817c);
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f13817c);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                return new a(iBinder);
            }
            return (b) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            boolean z10;
            Bundle bundle;
            if (i10 == 1) {
                parcel.enforceInterface(f13817c);
                int readInt = parcel.readInt();
                long readLong = parcel.readLong();
                if (parcel.readInt() != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                a(readInt, readLong, z10, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i10 == 2) {
                parcel.enforceInterface(f13817c);
                int readInt2 = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle = null;
                }
                a(readInt2, bundle);
                parcel2.writeNoException();
                return true;
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString(f13817c);
                return true;
            }
        }

        public static boolean a(b bVar) {
            if (a.f13818a != null || bVar == null) {
                return false;
            }
            a.f13818a = bVar;
            return true;
        }

        public static b a() {
            return a.f13818a;
        }
    }
}
