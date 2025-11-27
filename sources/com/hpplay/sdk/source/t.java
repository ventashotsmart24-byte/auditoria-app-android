package com.hpplay.sdk.source;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.hpplay.sdk.source.bean.PassBean;

public interface t extends IInterface {

    public static abstract class a extends Binder implements t {
        private static final String DESCRIPTOR = "com.hpplay.sdk.source.AISendPassCallback";
        static final int TRANSACTION_onSendPassCallBack = 1;

        /* renamed from: com.hpplay.sdk.source.t$a$a  reason: collision with other inner class name */
        public static class C0178a implements t {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f11888a;

            public C0178a(IBinder iBinder) {
                this.f11888a = iBinder;
            }

            public String a() {
                return a.DESCRIPTOR;
            }

            public IBinder asBinder() {
                return this.f11888a;
            }

            public void onSendPassCallBack(PassBean passBean) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (passBean != null) {
                        obtain.writeInt(1);
                        passBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f11888a.transact(1, obtain, obtain2, 0);
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

        public static t asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof t)) {
                return new C0178a(iBinder);
            }
            return (t) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            PassBean passBean;
            if (i10 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                if (parcel.readInt() != 0) {
                    passBean = PassBean.CREATOR.createFromParcel(parcel);
                } else {
                    passBean = null;
                }
                onSendPassCallBack(passBean);
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

    void onSendPassCallBack(PassBean passBean);
}
