package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.zzar;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzz implements Parcelable.Creator<zzy> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        double d10 = 0.0d;
        double d11 = 0.0d;
        ApplicationMetadata applicationMetadata = null;
        zzar zzar = null;
        boolean z10 = false;
        int i10 = 0;
        int i11 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    d10 = SafeParcelReader.readDouble(parcel2, readHeader);
                    break;
                case 3:
                    z10 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 4:
                    i10 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 5:
                    applicationMetadata = (ApplicationMetadata) SafeParcelReader.createParcelable(parcel2, readHeader, ApplicationMetadata.CREATOR);
                    break;
                case 6:
                    i11 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 7:
                    zzar = (zzar) SafeParcelReader.createParcelable(parcel2, readHeader, zzar.CREATOR);
                    break;
                case 8:
                    d11 = SafeParcelReader.readDouble(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new zzy(d10, z10, i10, applicationMetadata, i11, zzar, d11);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new zzy[i10];
    }
}
