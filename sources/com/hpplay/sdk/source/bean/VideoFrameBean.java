package com.hpplay.sdk.source.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class VideoFrameBean implements Parcelable {
    public static final Parcelable.Creator<VideoFrameBean> CREATOR = new Parcelable.Creator<VideoFrameBean>() {
        public VideoFrameBean createFromParcel(Parcel parcel) {
            return new VideoFrameBean(parcel);
        }

        public VideoFrameBean[] newArray(int i10) {
            return new VideoFrameBean[i10];
        }
    };
    public int height;
    public long pts;
    public int type;
    public int width;

    public VideoFrameBean() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.type);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeLong(this.pts);
    }

    public VideoFrameBean(Parcel parcel) {
        this.type = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.pts = parcel.readLong();
    }
}
