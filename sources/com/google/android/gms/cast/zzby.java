package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzby implements Parcelable.Creator<MediaLoadRequestData> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        MediaInfo mediaInfo = null;
        MediaQueueData mediaQueueData = null;
        Boolean bool = null;
        long[] jArr = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        long j10 = 0;
        long j11 = 0;
        double d10 = 0.0d;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    mediaInfo = (MediaInfo) SafeParcelReader.createParcelable(parcel2, readHeader, MediaInfo.CREATOR);
                    break;
                case 3:
                    mediaQueueData = (MediaQueueData) SafeParcelReader.createParcelable(parcel2, readHeader, MediaQueueData.CREATOR);
                    break;
                case 4:
                    bool = SafeParcelReader.readBooleanObject(parcel2, readHeader);
                    break;
                case 5:
                    j10 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 6:
                    d10 = SafeParcelReader.readDouble(parcel2, readHeader);
                    break;
                case 7:
                    jArr = SafeParcelReader.createLongArray(parcel2, readHeader);
                    break;
                case 8:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 9:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 10:
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 11:
                    str4 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 12:
                    str5 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 13:
                    j11 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new MediaLoadRequestData(mediaInfo, mediaQueueData, bool, j10, d10, jArr, str, str2, str3, str4, str5, j11);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new MediaLoadRequestData[i10];
    }
}
