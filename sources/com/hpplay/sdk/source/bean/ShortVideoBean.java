package com.hpplay.sdk.source.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class ShortVideoBean implements Parcelable {
    public static final Parcelable.Creator<ShortVideoBean> CREATOR = new Parcelable.Creator<ShortVideoBean>() {
        public ShortVideoBean createFromParcel(Parcel parcel) {
            return new ShortVideoBean(parcel);
        }

        public ShortVideoBean[] newArray(int i10) {
            return new ShortVideoBean[i10];
        }
    };
    public String imgUrl;
    public String key;

    public ShortVideoBean(Parcel parcel) {
        this.key = parcel.readString();
        this.imgUrl = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.key);
        parcel.writeString(this.imgUrl);
    }
}
