package com.hpplay.sdk.source;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.hpplay.sdk.source.bean.CastBean;

public interface o extends IInterface {

    public static abstract class a extends Binder implements o {
        private static final String DESCRIPTOR = "com.hpplay.sdk.source.AINewPlayListener";
        static final int TRANSACTION_onCompletion = 4;
        static final int TRANSACTION_onError = 9;
        static final int TRANSACTION_onInfo = 7;
        static final int TRANSACTION_onInfo2 = 8;
        static final int TRANSACTION_onLoading = 1;
        static final int TRANSACTION_onPause = 3;
        static final int TRANSACTION_onPositionUpdate = 11;
        static final int TRANSACTION_onSeekComplete = 6;
        static final int TRANSACTION_onStart = 2;
        static final int TRANSACTION_onStop = 5;
        static final int TRANSACTION_onVolumeChanged = 10;

        /* renamed from: com.hpplay.sdk.source.o$a$a  reason: collision with other inner class name */
        public static class C0173a implements o {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f11883a;

            public C0173a(IBinder iBinder) {
                this.f11883a = iBinder;
            }

            public String a() {
                return a.DESCRIPTOR;
            }

            public IBinder asBinder() {
                return this.f11883a;
            }

            public void onCompletion(CastBean castBean, int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (castBean != null) {
                        obtain.writeInt(1);
                        castBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i10);
                    this.f11883a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onError(CastBean castBean, int i10, int i11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (castBean != null) {
                        obtain.writeInt(1);
                        castBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i10);
                    obtain.writeInt(i11);
                    this.f11883a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onInfo(CastBean castBean, int i10, int i11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (castBean != null) {
                        obtain.writeInt(1);
                        castBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i10);
                    obtain.writeInt(i11);
                    this.f11883a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onInfo2(CastBean castBean, int i10, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (castBean != null) {
                        obtain.writeInt(1);
                        castBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i10);
                    obtain.writeString(str);
                    this.f11883a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onLoading(CastBean castBean) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (castBean != null) {
                        obtain.writeInt(1);
                        castBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f11883a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onPause(CastBean castBean) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (castBean != null) {
                        obtain.writeInt(1);
                        castBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f11883a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onPositionUpdate(CastBean castBean, long j10, long j11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (castBean != null) {
                        obtain.writeInt(1);
                        castBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeLong(j10);
                    obtain.writeLong(j11);
                    this.f11883a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onSeekComplete(CastBean castBean, int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (castBean != null) {
                        obtain.writeInt(1);
                        castBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i10);
                    this.f11883a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onStart(CastBean castBean) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (castBean != null) {
                        obtain.writeInt(1);
                        castBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f11883a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onStop(CastBean castBean) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (castBean != null) {
                        obtain.writeInt(1);
                        castBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f11883a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onVolumeChanged(CastBean castBean, float f10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.DESCRIPTOR);
                    if (castBean != null) {
                        obtain.writeInt(1);
                        castBean.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeFloat(f10);
                    this.f11883a.transact(10, obtain, obtain2, 0);
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

        public static o asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof o)) {
                return new C0173a(iBinder);
            }
            return (o) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 != 1598968902) {
                CastBean castBean = null;
                switch (i10) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            castBean = CastBean.CREATOR.createFromParcel(parcel);
                        }
                        onLoading(castBean);
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            castBean = CastBean.CREATOR.createFromParcel(parcel);
                        }
                        onStart(castBean);
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            castBean = CastBean.CREATOR.createFromParcel(parcel);
                        }
                        onPause(castBean);
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            castBean = CastBean.CREATOR.createFromParcel(parcel);
                        }
                        onCompletion(castBean, parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            castBean = CastBean.CREATOR.createFromParcel(parcel);
                        }
                        onStop(castBean);
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            castBean = CastBean.CREATOR.createFromParcel(parcel);
                        }
                        onSeekComplete(castBean, parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            castBean = CastBean.CREATOR.createFromParcel(parcel);
                        }
                        onInfo(castBean, parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            castBean = CastBean.CREATOR.createFromParcel(parcel);
                        }
                        onInfo2(castBean, parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            castBean = CastBean.CREATOR.createFromParcel(parcel);
                        }
                        onError(castBean, parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            castBean = CastBean.CREATOR.createFromParcel(parcel);
                        }
                        onVolumeChanged(castBean, parcel.readFloat());
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            castBean = CastBean.CREATOR.createFromParcel(parcel);
                        }
                        onPositionUpdate(castBean, parcel.readLong(), parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i10, parcel, parcel2, i11);
                }
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    void onCompletion(CastBean castBean, int i10);

    void onError(CastBean castBean, int i10, int i11);

    void onInfo(CastBean castBean, int i10, int i11);

    void onInfo2(CastBean castBean, int i10, String str);

    void onLoading(CastBean castBean);

    void onPause(CastBean castBean);

    void onPositionUpdate(CastBean castBean, long j10, long j11);

    void onSeekComplete(CastBean castBean, int i10);

    void onStart(CastBean castBean);

    void onStop(CastBean castBean);

    void onVolumeChanged(CastBean castBean, float f10);
}
