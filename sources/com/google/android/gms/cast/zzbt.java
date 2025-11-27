package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzbt implements Parcelable.Creator<MediaError> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        long j10 = 0;
        String str2 = null;
        Integer num = null;
        String str3 = null;
        while (true) {
            long j11 = j10;
            while (parcel.dataPosition() < validateObjectHeader) {
                int readHeader = SafeParcelReader.readHeader(parcel);
                int fieldId = SafeParcelReader.getFieldId(readHeader);
                if (fieldId == 2) {
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                } else if (fieldId == 3) {
                    j10 = SafeParcelReader.readLong(parcel, readHeader);
                } else if (fieldId == 4) {
                    num = SafeParcelReader.readIntegerObject(parcel, readHeader);
                } else if (fieldId == 5) {
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                } else if (fieldId != 6) {
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                } else {
                    str = SafeParcelReader.createString(parcel, readHeader);
                }
            }
            SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
            return new MediaError(str2, j11, num, str3, CastUtils.jsonStringToJsonObject(str));
        }
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new MediaError[i10];
    }
}
