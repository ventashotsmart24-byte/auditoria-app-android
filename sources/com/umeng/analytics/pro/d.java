package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface d extends IInterface {

    public static class a implements d {
        public String a() {
            return null;
        }

        public IBinder asBinder() {
            return null;
        }

        public String b(String str) {
            return null;
        }

        public String a(String str) {
            return null;
        }
    }

    String a();

    String a(String str);

    String b(String str);

    public static abstract class b extends Binder implements d {

        /* renamed from: a  reason: collision with root package name */
        static final int f14093a = 1;

        /* renamed from: b  reason: collision with root package name */
        static final int f14094b = 2;

        /* renamed from: c  reason: collision with root package name */
        static final int f14095c = 3;

        /* renamed from: d  reason: collision with root package name */
        private static final String f14096d = "com.samsung.android.deviceidservice.IDeviceIdService";

        public static class a implements d {

            /* renamed from: a  reason: collision with root package name */
            public static d f14097a;

            /* renamed from: b  reason: collision with root package name */
            private IBinder f14098b;

            public a(IBinder iBinder) {
                this.f14098b = iBinder;
            }

            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f14096d);
                    if (!this.f14098b.transact(1, obtain, obtain2, 0) && b.b() != null) {
                        return b.b().a();
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
                return this.f14098b;
            }

            public String b() {
                return b.f14096d;
            }

            public String b(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f14096d);
                    obtain.writeString(str);
                    if (!this.f14098b.transact(3, obtain, obtain2, 0) && b.b() != null) {
                        return b.b().b(str);
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

            public String a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f14096d);
                    obtain.writeString(str);
                    if (!this.f14098b.transact(2, obtain, obtain2, 0) && b.b() != null) {
                        return b.b().a(str);
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
            attachInterface(this, f14096d);
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f14096d);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof d)) {
                return new a(iBinder);
            }
            return (d) queryLocalInterface;
        }

        public static d b() {
            return a.f14097a;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                parcel.enforceInterface(f14096d);
                String a10 = a();
                parcel2.writeNoException();
                parcel2.writeString(a10);
                return true;
            } else if (i10 == 2) {
                parcel.enforceInterface(f14096d);
                String a11 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a11);
                return true;
            } else if (i10 == 3) {
                parcel.enforceInterface(f14096d);
                String b10 = b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(b10);
                return true;
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString(f14096d);
                return true;
            }
        }

        public static boolean a(d dVar) {
            if (a.f14097a != null || dVar == null) {
                return false;
            }
            a.f14097a = dVar;
            return true;
        }
    }
}
