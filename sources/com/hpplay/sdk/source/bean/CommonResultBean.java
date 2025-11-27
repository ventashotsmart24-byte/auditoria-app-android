package com.hpplay.sdk.source.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class CommonResultBean implements Parcelable {
    public static final Parcelable.Creator<CommonResultBean> CREATOR = new Parcelable.Creator<CommonResultBean>() {
        public CommonResultBean createFromParcel(Parcel parcel) {
            return new CommonResultBean(parcel);
        }

        public CommonResultBean[] newArray(int i10) {
            return new CommonResultBean[i10];
        }
    };
    public int event;
    public String json;
    public int listener;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.listener);
        parcel.writeInt(this.event);
        parcel.writeString(this.json);
    }

    private CommonResultBean(Parcel parcel) {
        this.listener = parcel.readInt();
        this.event = parcel.readInt();
        this.json = parcel.readString();
    }

    public CommonResultBean() {
    }
}
