package com.hpplay.sdk.source;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import java.util.List;

public interface p extends IInterface {

    public static abstract class a extends Binder implements p {
        private static final String DESCRIPTOR = "com.hpplay.sdk.source.AIOnLineCheckListener";
        static final int TRANSACTION_onResult = 1;

        /* renamed from: com.hpplay.sdk.source.p$a$a  reason: collision with other inner class name */
        public static class C0174a implements p {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f11884a;

            public C0174a(IBinder iBinder) {
                this.f11884a = iBinder;
            }

            public String a() {
                return a.DESCRIPTOR;
            }

            public IBinder asBinder() {
                return this.f11884a;
            }

            public void onResult(int i10, List<LelinkServiceInfo> list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeInt(i10);
                    obtain.writeTypedList(list);
                    this.f11884a.transact(1, obtain, obtain2, 0);
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

        public static p asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof p)) {
                return new C0174a(iBinder);
            }
            return (p) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onResult(parcel.readInt(), parcel.createTypedArrayList(LelinkServiceInfo.CREATOR));
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

    void onResult(int i10, List<LelinkServiceInfo> list);
}
