package com.google.android.gms.internal.p001authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.google.android.gms.internal.auth-api.zzc  reason: invalid package */
public class zzc implements IInterface {
    private final IBinder zzc;
    private final String zzd;

    public zzc(IBinder iBinder, String str) {
        this.zzc = iBinder;
        this.zzd = str;
    }

    public IBinder asBinder() {
        return this.zzc;
    }

    public final Parcel obtainAndWriteInterfaceToken() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzd);
        return obtain;
    }

    public final void transactAndReadExceptionReturnVoid(int i10, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.zzc.transact(i10, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
