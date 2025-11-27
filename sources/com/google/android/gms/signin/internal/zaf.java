package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;

public final class zaf extends zaa {
    public zaf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void zae(int i10) {
        Parcel zaa = zaa();
        zaa.writeInt(i10);
        zac(7, zaa);
    }

    public final void zaf(IAccountAccessor iAccountAccessor, int i10, boolean z10) {
        Parcel zaa = zaa();
        zac.zae(zaa, iAccountAccessor);
        zaa.writeInt(i10);
        zac.zac(zaa, z10);
        zac(9, zaa);
    }

    public final void zag(zai zai, zae zae) {
        Parcel zaa = zaa();
        zac.zad(zaa, zai);
        zac.zae(zaa, zae);
        zac(12, zaa);
    }
}
