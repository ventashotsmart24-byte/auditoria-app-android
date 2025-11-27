package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f434a;

    /* renamed from: b  reason: collision with root package name */
    public int f435b;

    /* renamed from: c  reason: collision with root package name */
    public int f436c;

    /* renamed from: d  reason: collision with root package name */
    public int f437d;

    /* renamed from: e  reason: collision with root package name */
    public int f438e;

    public class a implements Parcelable.Creator {
        /* renamed from: a */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        /* renamed from: b */
        public ParcelableVolumeInfo[] newArray(int i10) {
            return new ParcelableVolumeInfo[i10];
        }
    }

    public ParcelableVolumeInfo(int i10, int i11, int i12, int i13, int i14) {
        this.f434a = i10;
        this.f435b = i11;
        this.f436c = i12;
        this.f437d = i13;
        this.f438e = i14;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f434a);
        parcel.writeInt(this.f436c);
        parcel.writeInt(this.f437d);
        parcel.writeInt(this.f438e);
        parcel.writeInt(this.f435b);
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f434a = parcel.readInt();
        this.f436c = parcel.readInt();
        this.f437d = parcel.readInt();
        this.f438e = parcel.readInt();
        this.f435b = parcel.readInt();
    }
}
