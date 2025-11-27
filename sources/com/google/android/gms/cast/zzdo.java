package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzdo implements Parcelable.Creator<TextTrackStyle> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        float f10 = 0.0f;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    f10 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 3:
                    i10 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 4:
                    i11 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 5:
                    i12 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 6:
                    i13 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 7:
                    i14 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 8:
                    i15 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 9:
                    i16 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 10:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 11:
                    i17 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 12:
                    i18 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 13:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new TextTrackStyle(f10, i10, i11, i12, i13, i14, i15, i16, str, i17, i18, str2);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new TextTrackStyle[i10];
    }
}
