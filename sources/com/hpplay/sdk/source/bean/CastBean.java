package com.hpplay.sdk.source.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;

public class CastBean implements Parcelable {
    public static final Parcelable.Creator<CastBean> CREATOR = new Parcelable.Creator<CastBean>() {
        public CastBean createFromParcel(Parcel parcel) {
            return new CastBean(parcel);
        }

        public CastBean[] newArray(int i10) {
            return new CastBean[i10];
        }
    };
    public String dramaID;
    public String errorInfo;
    public LelinkServiceInfo serviceInfo;
    public String url;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.url);
        parcel.writeString(this.dramaID);
        parcel.writeParcelable(this.serviceInfo, i10);
        parcel.writeString(this.errorInfo);
    }

    private CastBean(Parcel parcel) {
        this.url = parcel.readString();
        this.dramaID = parcel.readString();
        this.serviceInfo = (LelinkServiceInfo) parcel.readParcelable(CastBean.class.getClassLoader());
        this.errorInfo = parcel.readString();
    }

    public CastBean() {
    }
}
