package com.mobile.brasiltv.db;

import android.os.Parcel;
import android.os.Parcelable;
import t9.i;

public final class UmengPush$Companion$CREATOR$1 implements Parcelable.Creator<UmengPush> {
    public UmengPush createFromParcel(Parcel parcel) {
        i.g(parcel, "source");
        return new UmengPush(parcel);
    }

    public UmengPush[] newArray(int i10) {
        return new UmengPush[i10];
    }
}
