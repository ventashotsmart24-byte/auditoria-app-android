package com.hpplay.sdk.source;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.hpplay.sdk.source.bean.ReceiverProperties;

public interface q extends IInterface {

    public static abstract class a extends Binder implements q {
        private static final String DESCRIPTOR = "com.hpplay.sdk.source.AIReceiverPropertiesCallback";
        static final int TRANSACTION_callback = 1;

        /* renamed from: com.hpplay.sdk.source.q$a$a  reason: collision with other inner class name */
        public static class C0175a implements q {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f11885a;

            public C0175a(IBinder iBinder) {
                this.f11885a = iBinder;
            }

            public String a() {
                return a.DESCRIPTOR;
            }

            public IBinder asBinder() {
                return this.f11885a;
            }

            public void callback(ReceiverProperties receiverProperties) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (receiverProperties != null) {
                        obtain.writeInt(1);
                        receiverProperties.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f11885a.transact(1, obtain, obtain2, 0);
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

        public static q asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof q)) {
                return new C0175a(iBinder);
            }
            return (q) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            ReceiverProperties receiverProperties;
            if (i10 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                if (parcel.readInt() != 0) {
                    receiverProperties = ReceiverProperties.CREATOR.createFromParcel(parcel);
                } else {
                    receiverProperties = null;
                }
                callback(receiverProperties);
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

    void callback(ReceiverProperties receiverProperties);
}
