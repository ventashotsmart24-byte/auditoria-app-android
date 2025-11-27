package com.hpplay.sdk.source;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface i extends IInterface {

    public static abstract class a extends Binder implements i {
        private static final String DESCRIPTOR = "com.hpplay.sdk.source.AIDebugAVListener";
        static final int TRANSACTION_onAudioCallback = 1;
        static final int TRANSACTION_onVideoCallback = 2;

        /* renamed from: com.hpplay.sdk.source.i$a$a  reason: collision with other inner class name */
        public static class C0167a implements i {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f11825a;

            public C0167a(IBinder iBinder) {
                this.f11825a = iBinder;
            }

            public String a() {
                return a.DESCRIPTOR;
            }

            public IBinder asBinder() {
                return this.f11825a;
            }

            public void onAudioCallback(long j10, int i10, int i11, int i12, byte[] bArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeLong(j10);
                    obtain.writeInt(i10);
                    obtain.writeInt(i11);
                    obtain.writeInt(i12);
                    obtain.writeByteArray(bArr);
                    this.f11825a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onVideoCallback(long j10, int i10, int i11, int i12, byte[] bArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    obtain.writeLong(j10);
                    obtain.writeInt(i10);
                    obtain.writeInt(i11);
                    obtain.writeInt(i12);
                    obtain.writeByteArray(bArr);
                    this.f11825a.transact(2, obtain, obtain2, 0);
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

        public static i asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof i)) {
                return new C0167a(iBinder);
            }
            return (i) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            int i12 = i10;
            Parcel parcel3 = parcel;
            if (i12 == 1) {
                Parcel parcel4 = parcel2;
                parcel3.enforceInterface(DESCRIPTOR);
                onAudioCallback(parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.createByteArray());
                parcel2.writeNoException();
                return true;
            } else if (i12 == 2) {
                Parcel parcel5 = parcel2;
                parcel3.enforceInterface(DESCRIPTOR);
                onVideoCallback(parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.createByteArray());
                parcel2.writeNoException();
                return true;
            } else if (i12 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    void onAudioCallback(long j10, int i10, int i11, int i12, byte[] bArr);

    void onVideoCallback(long j10, int i10, int i11, int i12, byte[] bArr);
}
