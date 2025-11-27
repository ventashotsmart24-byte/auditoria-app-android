package com.hpplay.sdk.source;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface a extends IInterface {

    /* renamed from: com.hpplay.sdk.source.a$a  reason: collision with other inner class name */
    public static abstract class C0156a extends Binder implements a {
        private static final String DESCRIPTOR = "com.hpplay.sdk.source.AIAuthListener";
        static final int TRANSACTION_onAuthFailed = 2;
        static final int TRANSACTION_onAuthSuccess = 1;

        /* renamed from: com.hpplay.sdk.source.a$a$a  reason: collision with other inner class name */
        public static class C0158a implements a {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f11575a;

            public C0158a(IBinder iBinder) {
                this.f11575a = iBinder;
            }

            public String a() {
                return C0156a.DESCRIPTOR;
            }

            public IBinder asBinder() {
                return this.f11575a;
            }

            public void onAuthFailed(int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(C0156a.DESCRIPTOR);
                    obtain.writeInt(i10);
                    this.f11575a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onAuthSuccess(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(C0156a.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f11575a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0156a() {
            attachInterface(this, DESCRIPTOR);
        }

        public static a asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0158a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onAuthSuccess(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i10 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onAuthFailed(parcel.readInt());
                parcel2.writeNoException();
                return true;
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    void onAuthFailed(int i10);

    void onAuthSuccess(String str, String str2);
}
