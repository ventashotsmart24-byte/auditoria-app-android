package com.hpplay.sdk.source;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;

public interface v extends IInterface {

    public static abstract class a extends Binder implements v {
        private static final String DESCRIPTOR = "com.hpplay.sdk.source.AIServiceInfoParseListener";
        static final int TRANSACTION_onParseResult = 1;

        /* renamed from: com.hpplay.sdk.source.v$a$a  reason: collision with other inner class name */
        public static class C0180a implements v {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f11890a;

            public C0180a(IBinder iBinder) {
                this.f11890a = iBinder;
            }

            public String a() {
                return a.DESCRIPTOR;
            }

            public IBinder asBinder() {
                return this.f11890a;
            }

            public void onParseResult(int i10, LelinkServiceInfo lelinkServiceInfo) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeInt(i10);
                    if (lelinkServiceInfo != null) {
                        obtain.writeInt(1);
                        lelinkServiceInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f11890a.transact(1, obtain, obtain2, 0);
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

        public static v asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof v)) {
                return new C0180a(iBinder);
            }
            return (v) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            LelinkServiceInfo lelinkServiceInfo;
            if (i10 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                int readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    lelinkServiceInfo = LelinkServiceInfo.CREATOR.createFromParcel(parcel);
                } else {
                    lelinkServiceInfo = null;
                }
                onParseResult(readInt, lelinkServiceInfo);
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

    void onParseResult(int i10, LelinkServiceInfo lelinkServiceInfo);
}
