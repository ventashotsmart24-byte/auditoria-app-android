package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzcg implements Parcelable.Creator<MediaQueueItem> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        MediaInfo mediaInfo = null;
        long[] jArr = null;
        String str = null;
        double d10 = 0.0d;
        double d11 = 0.0d;
        double d12 = 0.0d;
        int i10 = 0;
        boolean z10 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    mediaInfo = (MediaInfo) SafeParcelReader.createParcelable(parcel2, readHeader, MediaInfo.CREATOR);
                    break;
                case 3:
                    i10 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 4:
                    z10 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 5:
                    d10 = SafeParcelReader.readDouble(parcel2, readHeader);
                    break;
                case 6:
                    d11 = SafeParcelReader.readDouble(parcel2, readHeader);
                    break;
                case 7:
                    d12 = SafeParcelReader.readDouble(parcel2, readHeader);
                    break;
                case 8:
                    jArr = SafeParcelReader.createLongArray(parcel2, readHeader);
                    break;
                case 9:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new MediaQueueItem(mediaInfo, i10, z10, d10, d11, d12, jArr, str);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new MediaQueueItem[i10];
    }
}
