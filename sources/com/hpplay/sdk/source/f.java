package com.hpplay.sdk.source;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface f extends IInterface {

    public static abstract class a extends Binder implements f {
        private static final String DESCRIPTOR = "com.hpplay.sdk.source.AICreatePinCodeListener";
        static final int TRANSACTION_onCreatePinCode = 1;

        /* renamed from: com.hpplay.sdk.source.f$a$a  reason: collision with other inner class name */
        public static class C0164a implements f {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f11822a;

            public C0164a(IBinder iBinder) {
                this.f11822a = iBinder;
            }

            public String a() {
                return a.DESCRIPTOR;
            }

            public IBinder asBinder() {
                return this.f11822a;
            }

            public void onCreatePinCode(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeString(str);
                    this.f11822a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, DESCRIPTOR);
        }

        public static f asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof f)) {
                return new C0164a(iBinder);
            }
            return (f) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onCreatePinCode(parcel.readString());
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

    void onCreatePinCode(String str);
}
