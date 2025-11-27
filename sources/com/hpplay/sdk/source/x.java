package com.hpplay.sdk.source;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.view.MotionEvent;

public interface x extends IInterface {

    public static abstract class a extends Binder implements x {
        private static final String DESCRIPTOR = "com.hpplay.sdk.source.AISinkTouchEventListener";
        static final int TRANSACTION_onTouchEvent = 1;

        /* renamed from: com.hpplay.sdk.source.x$a$a  reason: collision with other inner class name */
        public static class C0182a implements x {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f11892a;

            public C0182a(IBinder iBinder) {
                this.f11892a = iBinder;
            }

            public String a() {
                return a.DESCRIPTOR;
            }

            public IBinder asBinder() {
                return this.f11892a;
            }

            public void onTouchEvent(MotionEvent motionEvent) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (motionEvent != null) {
                        obtain.writeInt(1);
                        motionEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f11892a.transact(1, obtain, obtain2, 0);
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

        public static x asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof x)) {
                return new C0182a(iBinder);
            }
            return (x) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            MotionEvent motionEvent;
            if (i10 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                if (parcel.readInt() != 0) {
                    motionEvent = (MotionEvent) MotionEvent.CREATOR.createFromParcel(parcel);
                } else {
                    motionEvent = null;
                }
                onTouchEvent(motionEvent);
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

    void onTouchEvent(MotionEvent motionEvent);
}
