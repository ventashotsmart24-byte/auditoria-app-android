package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import y0.c;
import y0.d;

public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final d f3290a;

    public static class a implements Parcelable.Creator {
        /* renamed from: a */
        public ParcelImpl createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }

        /* renamed from: b */
        public ParcelImpl[] newArray(int i10) {
            return new ParcelImpl[i10];
        }
    }

    public ParcelImpl(d dVar) {
        this.f3290a = dVar;
    }

    public d a() {
        return this.f3290a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        new c(parcel).L(this.f3290a);
    }

    public ParcelImpl(Parcel parcel) {
        this.f3290a = new c(parcel).u();
    }
}
