package com.hpplay.sdk.source;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface g extends IInterface {

    public static abstract class a extends Binder implements g {
        private static final String DESCRIPTOR = "com.hpplay.sdk.source.AICreateShortUrlListener";
        static final int TRANSACTION_onCreateShortUrl = 1;

        /* renamed from: com.hpplay.sdk.source.g$a$a  reason: collision with other inner class name */
        public static class C0165a implements g {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f11823a;

            public C0165a(IBinder iBinder) {
                this.f11823a = iBinder;
            }

            public String a() {
                return a.DESCRIPTOR;
            }

            public IBinder asBinder() {
                return this.f11823a;
            }

            public void onCreateShortUrl(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeString(str);
                    this.f11823a.transact(1, obtain, obtain2, 0);
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

        public static g asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof g)) {
                return new C0165a(iBinder);
            }
            return (g) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onCreateShortUrl(parcel.readString());
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

    void onCreateShortUrl(String str);
}
