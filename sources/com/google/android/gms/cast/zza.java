package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zza implements Parcelable.Creator<AdBreakClipInfo> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        VastAdsRequest vastAdsRequest = null;
        long j10 = 0;
        long j11 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 3:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 4:
                    j10 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 5:
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 6:
                    str4 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 7:
                    str5 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 8:
                    str6 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 9:
                    str7 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 10:
                    str8 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 11:
                    j11 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 12:
                    str9 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 13:
                    vastAdsRequest = (VastAdsRequest) SafeParcelReader.createParcelable(parcel2, readHeader, VastAdsRequest.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new AdBreakClipInfo(str, str2, j10, str3, str4, str5, str6, str7, str8, j11, str9, vastAdsRequest);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new AdBreakClipInfo[i10];
    }
}
