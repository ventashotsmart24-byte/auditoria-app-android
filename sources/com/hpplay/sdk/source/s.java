package com.hpplay.sdk.source;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface s extends IInterface {

    public static abstract class a extends Binder implements s {
        private static final String DESCRIPTOR = "com.hpplay.sdk.source.AISearchBannerDataCallback";
        static final int TRANSACTION_onBannerData = 1;

        /* renamed from: com.hpplay.sdk.source.s$a$a  reason: collision with other inner class name */
        public static class C0177a implements s {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f11887a;

            public C0177a(IBinder iBinder) {
                this.f11887a = iBinder;
            }

            public String a() {
                return a.DESCRIPTOR;
            }

            public IBinder asBinder() {
                return this.f11887a;
            }

            public void onBannerData(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeString(str);
                    this.f11887a.transact(1, obtain, obtain2, 0);
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

        public static s asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof s)) {
                return new C0177a(iBinder);
            }
            return (s) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onBannerData(parcel.readString());
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

    void onBannerData(String str);
}
