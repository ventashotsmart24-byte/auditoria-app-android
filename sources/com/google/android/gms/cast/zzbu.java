package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zzbu implements Parcelable.Creator<MediaInfo> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        MediaMetadata mediaMetadata = null;
        ArrayList<MediaTrack> arrayList = null;
        TextTrackStyle textTrackStyle = null;
        String str3 = null;
        ArrayList<AdBreakInfo> arrayList2 = null;
        ArrayList<AdBreakClipInfo> arrayList3 = null;
        String str4 = null;
        VastAdsRequest vastAdsRequest = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        long j10 = 0;
        long j11 = 0;
        int i10 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 3:
                    i10 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 4:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 5:
                    mediaMetadata = (MediaMetadata) SafeParcelReader.createParcelable(parcel2, readHeader, MediaMetadata.CREATOR);
                    break;
                case 6:
                    j10 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 7:
                    arrayList = SafeParcelReader.createTypedList(parcel2, readHeader, MediaTrack.CREATOR);
                    break;
                case 8:
                    textTrackStyle = (TextTrackStyle) SafeParcelReader.createParcelable(parcel2, readHeader, TextTrackStyle.CREATOR);
                    break;
                case 9:
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 10:
                    arrayList2 = SafeParcelReader.createTypedList(parcel2, readHeader, AdBreakInfo.CREATOR);
                    break;
                case 11:
                    arrayList3 = SafeParcelReader.createTypedList(parcel2, readHeader, AdBreakClipInfo.CREATOR);
                    break;
                case 12:
                    str4 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 13:
                    vastAdsRequest = (VastAdsRequest) SafeParcelReader.createParcelable(parcel2, readHeader, VastAdsRequest.CREATOR);
                    break;
                case 14:
                    j11 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 15:
                    str5 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 16:
                    str6 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 17:
                    str7 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 18:
                    str8 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new MediaInfo(str, i10, str2, mediaMetadata, j10, arrayList, textTrackStyle, str3, arrayList2, arrayList3, str4, vastAdsRequest, j11, str5, str6, str7, str8);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new MediaInfo[i10];
    }
}
