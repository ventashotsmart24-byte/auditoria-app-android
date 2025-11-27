package com.hpplay.sdk.source;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface r extends IInterface {

    public static abstract class a extends Binder implements r {
        private static final String DESCRIPTOR = "com.hpplay.sdk.source.AIRelevantInfoListener";
        static final int TRANSACTION_onReverseInfoResult = 2;
        static final int TRANSACTION_onSendRelevantInfoResult = 1;

        /* renamed from: com.hpplay.sdk.source.r$a$a  reason: collision with other inner class name */
        public static class C0176a implements r {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f11886a;

            public C0176a(IBinder iBinder) {
                this.f11886a = iBinder;
            }

            public String a() {
                return a.DESCRIPTOR;
            }

            public IBinder asBinder() {
                return this.f11886a;
            }

            public void onReverseInfoResult(int i10, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeInt(i10);
                    obtain.writeString(str);
                    this.f11886a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onSendRelevantInfoResult(int i10, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeInt(i10);
                    obtain.writeString(str);
                    this.f11886a.transact(1, obtain, obtain2, 0);
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

        public static r asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof r)) {
                return new C0176a(iBinder);
            }
            return (r) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onSendRelevantInfoResult(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i10 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onReverseInfoResult(parcel.readInt(), parcel.readString());
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

    void onReverseInfoResult(int i10, String str);

    void onSendRelevantInfoResult(int i10, String str);
}
