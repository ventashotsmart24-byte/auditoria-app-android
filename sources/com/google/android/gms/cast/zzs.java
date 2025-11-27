package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zzs implements Parcelable.Creator<CastDevice> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        ArrayList<WebImage> arrayList = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        byte[] bArr = null;
        String str9 = null;
        int i10 = 0;
        int i11 = 0;
        int i12 = -1;
        int i13 = 0;
        boolean z10 = false;
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
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 5:
                    str4 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 6:
                    str5 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 7:
                    i10 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 8:
                    arrayList = SafeParcelReader.createTypedList(parcel2, readHeader, WebImage.CREATOR);
                    break;
                case 9:
                    i11 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 10:
                    i12 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 11:
                    str6 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 12:
                    str7 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 13:
                    i13 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 14:
                    str8 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 15:
                    bArr = SafeParcelReader.createByteArray(parcel2, readHeader);
                    break;
                case 16:
                    str9 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 17:
                    z10 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new CastDevice(str, str2, str3, str4, str5, i10, arrayList, i11, i12, str6, str7, i13, str8, bArr, str9, z10);
    }

    public final /* synthetic */ Object[] newArray(int i10) {
        return new CastDevice[i10];
    }
}
