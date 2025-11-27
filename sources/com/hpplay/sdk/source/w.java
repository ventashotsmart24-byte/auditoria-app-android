package com.hpplay.sdk.source;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.view.KeyEvent;

public interface w extends IInterface {

    public static abstract class a extends Binder implements w {
        private static final String DESCRIPTOR = "com.hpplay.sdk.source.AISinkKeyEventListener";
        static final int TRANSACTION_onKeyEvent = 1;

        /* renamed from: com.hpplay.sdk.source.w$a$a  reason: collision with other inner class name */
        public static class C0181a implements w {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f11891a;

            public C0181a(IBinder iBinder) {
                this.f11891a = iBinder;
            }

            public String a() {
                return a.DESCRIPTOR;
            }

            public IBinder asBinder() {
                return this.f11891a;
            }

            public void onKeyEvent(KeyEvent keyEvent) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (keyEvent != null) {
                        obtain.writeInt(1);
                        keyEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f11891a.transact(1, obtain, obtain2, 0);
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

        public static w asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof w)) {
                return new C0181a(iBinder);
            }
            return (w) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            KeyEvent keyEvent;
            if (i10 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                if (parcel.readInt() != 0) {
                    keyEvent = (KeyEvent) KeyEvent.CREATOR.createFromParcel(parcel);
                } else {
                    keyEvent = null;
                }
                onKeyEvent(keyEvent);
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

    void onKeyEvent(KeyEvent keyEvent);
}
