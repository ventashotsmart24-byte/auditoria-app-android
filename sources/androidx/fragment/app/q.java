package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.o;
import java.util.ArrayList;

public final class q implements Parcelable {
    public static final Parcelable.Creator<q> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f2124a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList f2125b;

    /* renamed from: c  reason: collision with root package name */
    public b[] f2126c;

    /* renamed from: d  reason: collision with root package name */
    public int f2127d;

    /* renamed from: e  reason: collision with root package name */
    public String f2128e = null;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList f2129f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public ArrayList f2130g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public ArrayList f2131h;

    public class a implements Parcelable.Creator {
        /* renamed from: a */
        public q createFromParcel(Parcel parcel) {
            return new q(parcel);
        }

        /* renamed from: b */
        public q[] newArray(int i10) {
            return new q[i10];
        }
    }

    public q() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeTypedList(this.f2124a);
        parcel.writeStringList(this.f2125b);
        parcel.writeTypedArray(this.f2126c, i10);
        parcel.writeInt(this.f2127d);
        parcel.writeString(this.f2128e);
        parcel.writeStringList(this.f2129f);
        parcel.writeTypedList(this.f2130g);
        parcel.writeTypedList(this.f2131h);
    }

    public q(Parcel parcel) {
        this.f2124a = parcel.createTypedArrayList(u.CREATOR);
        this.f2125b = parcel.createStringArrayList();
        this.f2126c = (b[]) parcel.createTypedArray(b.CREATOR);
        this.f2127d = parcel.readInt();
        this.f2128e = parcel.readString();
        this.f2129f = parcel.createStringArrayList();
        this.f2130g = parcel.createTypedArrayList(Bundle.CREATOR);
        this.f2131h = parcel.createTypedArrayList(o.l.CREATOR);
    }
}
