package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzb implements Parcelable.Creator<AdBreakInfo> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j10 = 0;
        long j11 = 0;
        String str = null;
        String[] strArr = null;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    j10 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 3:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 4:
                    j11 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 5:
                    z10 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 6:
                    strArr = SafeParcelReader.createStringArray(parcel2, readHeader);
                    break;
                case 7:
                    z11 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 8:
                    z12 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new AdBreakInfo(j10, str, j11, z10, strArr, z11, z12);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new AdBreakInfo[i10];
    }
}
