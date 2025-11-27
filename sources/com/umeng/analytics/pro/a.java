package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface a extends IInterface {

    /* renamed from: com.umeng.analytics.pro.a$a  reason: collision with other inner class name */
    public static class C0193a implements a {
        public String a(String str) {
            return null;
        }

        public IBinder asBinder() {
            return null;
        }

        public String b() {
            return null;
        }

        public String c(String str) {
            return null;
        }

        public String d(String str) {
            return null;
        }

        public String e(String str) {
            return null;
        }

        public boolean a() {
            return false;
        }

        public String b(String str) {
            return null;
        }
    }

    String a(String str);

    boolean a();

    String b();

    String b(String str);

    String c(String str);

    String d(String str);

    String e(String str);

    public static abstract class b extends Binder implements a {

        /* renamed from: a  reason: collision with root package name */
        static final int f13691a = 1;

        /* renamed from: b  reason: collision with root package name */
        static final int f13692b = 2;

        /* renamed from: c  reason: collision with root package name */
        static final int f13693c = 3;

        /* renamed from: d  reason: collision with root package name */
        static final int f13694d = 4;

        /* renamed from: e  reason: collision with root package name */
        static final int f13695e = 5;

        /* renamed from: f  reason: collision with root package name */
        static final int f13696f = 6;

        /* renamed from: g  reason: collision with root package name */
        static final int f13697g = 7;

        /* renamed from: h  reason: collision with root package name */
        private static final String f13698h = "com.coolpad.deviceidsupport.IDeviceIdManager";

        /* renamed from: com.umeng.analytics.pro.a$b$a  reason: collision with other inner class name */
        public static class C0194a implements a {

            /* renamed from: a  reason: collision with root package name */
            public static a f13699a;

            /* renamed from: b  reason: collision with root package name */
            private IBinder f13700b;

            public C0194a(IBinder iBinder) {
                this.f13700b = iBinder;
            }

            public String a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f13698h);
                    obtain.writeString(str);
                    if (!this.f13700b.transact(1, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().a(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f13700b;
            }

            public String b(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f13698h);
                    obtain.writeString(str);
                    if (!this.f13700b.transact(2, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().b(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String c() {
                return b.f13698h;
            }

            public String d(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f13698h);
                    obtain.writeString(str);
                    if (!this.f13700b.transact(4, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().d(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String e(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f13698h);
                    obtain.writeString(str);
                    if (!this.f13700b.transact(5, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().e(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String c(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f13698h);
                    obtain.writeString(str);
                    if (!this.f13700b.transact(3, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().c(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f13698h);
                    boolean z10 = false;
                    if (!this.f13700b.transact(6, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().a();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z10 = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z10;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f13698h);
                    if (!this.f13700b.transact(7, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().b();
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, f13698h);
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f13698h);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0194a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public static a c() {
            return C0194a.f13699a;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 != 1598968902) {
                switch (i10) {
                    case 1:
                        parcel.enforceInterface(f13698h);
                        String a10 = a(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(a10);
                        return true;
                    case 2:
                        parcel.enforceInterface(f13698h);
                        String b10 = b(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(b10);
                        return true;
                    case 3:
                        parcel.enforceInterface(f13698h);
                        String c10 = c(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(c10);
                        return true;
                    case 4:
                        parcel.enforceInterface(f13698h);
                        String d10 = d(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(d10);
                        return true;
                    case 5:
                        parcel.enforceInterface(f13698h);
                        String e10 = e(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(e10);
                        return true;
                    case 6:
                        parcel.enforceInterface(f13698h);
                        boolean a11 = a();
                        parcel2.writeNoException();
                        parcel2.writeInt(a11 ? 1 : 0);
                        return true;
                    case 7:
                        parcel.enforceInterface(f13698h);
                        String b11 = b();
                        parcel2.writeNoException();
                        parcel2.writeString(b11);
                        return true;
                    default:
                        return super.onTransact(i10, parcel, parcel2, i11);
                }
            } else {
                parcel2.writeString(f13698h);
                return true;
            }
        }

        public static boolean a(a aVar) {
            if (C0194a.f13699a != null || aVar == null) {
                return false;
            }
            C0194a.f13699a = aVar;
            return true;
        }
    }
}
