package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zzci implements Parcelable.Creator<MediaStatus> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        MediaInfo mediaInfo = null;
        long[] jArr = null;
        String str = null;
        ArrayList<MediaQueueItem> arrayList = null;
        AdBreakStatus adBreakStatus = null;
        VideoInfo videoInfo = null;
        MediaLiveSeekableRange mediaLiveSeekableRange = null;
        MediaQueueData mediaQueueData = null;
        long j10 = 0;
        long j11 = 0;
        long j12 = 0;
        double d10 = 0.0d;
        double d11 = 0.0d;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        boolean z10 = false;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        boolean z11 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    mediaInfo = (MediaInfo) SafeParcelReader.createParcelable(parcel2, readHeader, MediaInfo.CREATOR);
                    break;
                case 3:
                    j10 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 4:
                    i10 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 5:
                    d10 = SafeParcelReader.readDouble(parcel2, readHeader);
                    break;
                case 6:
                    i11 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 7:
                    i12 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 8:
                    j11 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 9:
                    j12 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 10:
                    d11 = SafeParcelReader.readDouble(parcel2, readHeader);
                    break;
                case 11:
                    z10 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 12:
                    jArr = SafeParcelReader.createLongArray(parcel2, readHeader);
                    break;
                case 13:
                    i13 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 14:
                    i14 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 15:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 16:
                    i15 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 17:
                    arrayList = SafeParcelReader.createTypedList(parcel2, readHeader, MediaQueueItem.CREATOR);
                    break;
                case 18:
                    z11 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 19:
                    adBreakStatus = (AdBreakStatus) SafeParcelReader.createParcelable(parcel2, readHeader, AdBreakStatus.CREATOR);
                    break;
                case 20:
                    videoInfo = (VideoInfo) SafeParcelReader.createParcelable(parcel2, readHeader, VideoInfo.CREATOR);
                    break;
                case 21:
                    mediaLiveSeekableRange = (MediaLiveSeekableRange) SafeParcelReader.createParcelable(parcel2, readHeader, MediaLiveSeekableRange.CREATOR);
                    break;
                case 22:
                    mediaQueueData = (MediaQueueData) SafeParcelReader.createParcelable(parcel2, readHeader, MediaQueueData.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new MediaStatus(mediaInfo, j10, i10, d10, i11, i12, j11, j12, d11, z10, jArr, i13, i14, str, i15, arrayList, z11, adBreakStatus, videoInfo, mediaLiveSeekableRange, mediaQueueData);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new MediaStatus[i10];
    }
}
