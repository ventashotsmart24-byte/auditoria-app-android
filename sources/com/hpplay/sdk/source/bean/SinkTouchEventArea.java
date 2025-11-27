package com.hpplay.sdk.source.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class SinkTouchEventArea implements Parcelable {
    public static final Parcelable.Creator<SinkTouchEventArea> CREATOR = new Parcelable.Creator<SinkTouchEventArea>() {
        public SinkTouchEventArea createFromParcel(Parcel parcel) {
            return new SinkTouchEventArea(parcel);
        }

        public SinkTouchEventArea[] newArray(int i10) {
            return new SinkTouchEventArea[i10];
        }
    };
    public final int height;
    public final int width;

    public SinkTouchEventArea(int i10, int i11) {
        this.width = i10;
        this.height = i11;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
    }

    public SinkTouchEventArea(Parcel parcel) {
        this.width = parcel.readInt();
        this.height = parcel.readInt();
    }
}
