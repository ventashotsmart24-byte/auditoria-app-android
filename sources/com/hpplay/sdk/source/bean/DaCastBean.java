package com.hpplay.sdk.source.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class DaCastBean implements Parcelable {
    public static final Parcelable.Creator<DaCastBean> CREATOR = new Parcelable.Creator<DaCastBean>() {
        public DaCastBean createFromParcel(Parcel parcel) {
            return new DaCastBean(parcel);
        }

        public DaCastBean[] newArray(int i10) {
            return new DaCastBean[i10];
        }
    };

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
    }

    private DaCastBean(Parcel parcel) {
    }

    public DaCastBean() {
    }
}
