package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.umeng.analytics.pro.b;

public interface c extends IInterface {

    public static class a implements c {
        public void a(int i10, long j10, boolean z10, float f10, double d10, String str) {
        }

        public IBinder asBinder() {
            return null;
        }

        public void b(b bVar) {
        }

        public void a(b bVar) {
        }
    }

    void a(int i10, long j10, boolean z10, float f10, double d10, String str);

    void a(b bVar);

    void b(b bVar);

    public static abstract class b extends Binder implements c {

        /* renamed from: a  reason: collision with root package name */
        static final int f14015a = 1;

        /* renamed from: b  reason: collision with root package name */
        static final int f14016b = 2;

        /* renamed from: c  reason: collision with root package name */
        static final int f14017c = 3;

        /* renamed from: d  reason: collision with root package name */
        private static final String f14018d = "com.hihonor.cloudservice.oaid.IOAIDService";

        public static class a implements c {

            /* renamed from: a  reason: collision with root package name */
            public static c f14019a;

            /* renamed from: b  reason: collision with root package name */
            private IBinder f14020b;

            public a(IBinder iBinder) {
                this.f14020b = iBinder;
            }

            public String a() {
                return b.f14018d;
            }

            public IBinder asBinder() {
                return this.f14020b;
            }

            public void b(b bVar) {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f14018d);
                    if (bVar != null) {
                        iBinder = bVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (this.f14020b.transact(3, obtain, obtain2, 0) || b.a() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    b.a().b(bVar);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(int i10, long j10, boolean z10, float f10, double d10, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f14018d);
                    int i11 = i10;
                    obtain.writeInt(i10);
                    obtain.writeLong(j10);
                    obtain.writeInt(z10 ? 1 : 0);
                    obtain.writeFloat(f10);
                    obtain.writeDouble(d10);
                    obtain.writeString(str);
                    try {
                        if (this.f14020b.transact(1, obtain, obtain2, 0) || b.a() == null) {
                            obtain2.readException();
                            obtain2.recycle();
                            obtain.recycle();
                            return;
                        }
                        b.a().a(i10, j10, z10, f10, d10, str);
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

            public void a(b bVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f14018d);
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (this.f14020b.transact(2, obtain, obtain2, 0) || b.a() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    b.a().a(bVar);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, f14018d);
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f14018d);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof c)) {
                return new a(iBinder);
            }
            return (c) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            boolean z10;
            if (i10 == 1) {
                parcel.enforceInterface(f14018d);
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
                parcel.enforceInterface(f14018d);
                a(b.C0195b.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i10 == 3) {
                parcel.enforceInterface(f14018d);
                b(b.C0195b.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString(f14018d);
                return true;
            }
        }

        public static boolean a(c cVar) {
            if (a.f14019a != null || cVar == null) {
                return false;
            }
            a.f14019a = cVar;
            return true;
        }

        public static c a() {
            return a.f14019a;
        }
    }
}
