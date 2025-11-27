package com.hpplay.sdk.source;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.hpplay.sdk.source.bean.DaCastBean;

public interface h extends IInterface {

    public static abstract class a extends Binder implements h {
        private static final String DESCRIPTOR = "com.hpplay.sdk.source.AIDaPlayListener";
        static final int TRANSACTION_onLoading = 2;
        static final int TRANSACTION_onResult = 1;
        static final int TRANSACTION_onStart = 3;
        static final int TRANSACTION_onStop = 4;

        /* renamed from: com.hpplay.sdk.source.h$a$a  reason: collision with other inner class name */
        public static class C0166a implements h {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f11824a;

            public C0166a(IBinder iBinder) {
                this.f11824a = iBinder;
            }

            public String a() {
                return a.DESCRIPTOR;
            }

            public IBinder asBinder() {
                return this.f11824a;
            }

            public void onLoading(DaCastBean daCastBean) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (daCastBean != null) {
                        obtain.writeInt(1);
                        daCastBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f11824a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onResult(DaCastBean daCastBean, boolean z10) {
                int i10;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (daCastBean != null) {
                        obtain.writeInt(1);
                        daCastBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (z10) {
                        i10 = 1;
                    } else {
                        i10 = 0;
                    }
                    obtain.writeInt(i10);
                    this.f11824a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onStart(DaCastBean daCastBean) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (daCastBean != null) {
                        obtain.writeInt(1);
                        daCastBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f11824a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onStop(DaCastBean daCastBean) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (daCastBean != null) {
                        obtain.writeInt(1);
                        daCastBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f11824a.transact(4, obtain, obtain2, 0);
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

        public static h asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof h)) {
                return new C0166a(iBinder);
            }
            return (h) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            boolean z10;
            DaCastBean daCastBean = null;
            if (i10 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                if (parcel.readInt() != 0) {
                    daCastBean = DaCastBean.CREATOR.createFromParcel(parcel);
                }
                if (parcel.readInt() != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                onResult(daCastBean, z10);
                parcel2.writeNoException();
                return true;
            } else if (i10 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                if (parcel.readInt() != 0) {
                    daCastBean = DaCastBean.CREATOR.createFromParcel(parcel);
                }
                onLoading(daCastBean);
                parcel2.writeNoException();
                return true;
            } else if (i10 == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                if (parcel.readInt() != 0) {
                    daCastBean = DaCastBean.CREATOR.createFromParcel(parcel);
                }
                onStart(daCastBean);
                parcel2.writeNoException();
                return true;
            } else if (i10 == 4) {
                parcel.enforceInterface(DESCRIPTOR);
                if (parcel.readInt() != 0) {
                    daCastBean = DaCastBean.CREATOR.createFromParcel(parcel);
                }
                onStop(daCastBean);
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

    void onLoading(DaCastBean daCastBean);

    void onResult(DaCastBean daCastBean, boolean z10);

    void onStart(DaCastBean daCastBean);

    void onStop(DaCastBean daCastBean);
}
