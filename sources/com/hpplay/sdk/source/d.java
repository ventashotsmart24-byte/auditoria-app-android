package com.hpplay.sdk.source;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.hpplay.sdk.source.bean.CommonResultBean;

public interface d extends IInterface {

    public static abstract class a extends Binder implements d {
        private static final String DESCRIPTOR = "com.hpplay.sdk.source.AICommonListener";
        static final int TRANSACTION_onCallback = 1;

        /* renamed from: com.hpplay.sdk.source.d$a$a  reason: collision with other inner class name */
        public static class C0161a implements d {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f11747a;

            public C0161a(IBinder iBinder) {
                this.f11747a = iBinder;
            }

            public String a() {
                return a.DESCRIPTOR;
            }

            public IBinder asBinder() {
                return this.f11747a;
            }

            public CommonResultBean onCallback(int i10, int i11, String str) {
                CommonResultBean commonResultBean;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeInt(i10);
                    obtain.writeInt(i11);
                    obtain.writeString(str);
                    this.f11747a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        commonResultBean = CommonResultBean.CREATOR.createFromParcel(obtain2);
                    } else {
                        commonResultBean = null;
                    }
                    return commonResultBean;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, DESCRIPTOR);
        }

        public static d asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof d)) {
                return new C0161a(iBinder);
            }
            return (d) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                CommonResultBean onCallback = onCallback(parcel.readInt(), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                if (onCallback != null) {
                    parcel2.writeInt(1);
                    onCallback.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    CommonResultBean onCallback(int i10, int i11, String str);
}
