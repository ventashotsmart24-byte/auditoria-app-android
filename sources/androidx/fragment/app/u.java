package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class u implements Parcelable {
    public static final Parcelable.Creator<u> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final String f2140a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2141b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f2142c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2143d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2144e;

    /* renamed from: f  reason: collision with root package name */
    public final String f2145f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f2146g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f2147h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f2148i;

    /* renamed from: j  reason: collision with root package name */
    public final Bundle f2149j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f2150k;

    /* renamed from: l  reason: collision with root package name */
    public final int f2151l;

    /* renamed from: m  reason: collision with root package name */
    public Bundle f2152m;

    public class a implements Parcelable.Creator {
        /* renamed from: a */
        public u createFromParcel(Parcel parcel) {
            return new u(parcel);
        }

        /* renamed from: b */
        public u[] newArray(int i10) {
            return new u[i10];
        }
    }

    public u(Fragment fragment) {
        this.f2140a = fragment.getClass().getName();
        this.f2141b = fragment.mWho;
        this.f2142c = fragment.mFromLayout;
        this.f2143d = fragment.mFragmentId;
        this.f2144e = fragment.mContainerId;
        this.f2145f = fragment.mTag;
        this.f2146g = fragment.mRetainInstance;
        this.f2147h = fragment.mRemoving;
        this.f2148i = fragment.mDetached;
        this.f2149j = fragment.mArguments;
        this.f2150k = fragment.mHidden;
        this.f2151l = fragment.mMaxState.ordinal();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f2140a);
        sb.append(" (");
        sb.append(this.f2141b);
        sb.append(")}:");
        if (this.f2142c) {
            sb.append(" fromLayout");
        }
        if (this.f2144e != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f2144e));
        }
        String str = this.f2145f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f2145f);
        }
        if (this.f2146g) {
            sb.append(" retainInstance");
        }
        if (this.f2147h) {
            sb.append(" removing");
        }
        if (this.f2148i) {
            sb.append(" detached");
        }
        if (this.f2150k) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f2140a);
        parcel.writeString(this.f2141b);
        parcel.writeInt(this.f2142c ? 1 : 0);
        parcel.writeInt(this.f2143d);
        parcel.writeInt(this.f2144e);
        parcel.writeString(this.f2145f);
        parcel.writeInt(this.f2146g ? 1 : 0);
        parcel.writeInt(this.f2147h ? 1 : 0);
        parcel.writeInt(this.f2148i ? 1 : 0);
        parcel.writeBundle(this.f2149j);
        parcel.writeInt(this.f2150k ? 1 : 0);
        parcel.writeBundle(this.f2152m);
        parcel.writeInt(this.f2151l);
    }

    public u(Parcel parcel) {
        this.f2140a = parcel.readString();
        this.f2141b = parcel.readString();
        boolean z10 = true;
        this.f2142c = parcel.readInt() != 0;
        this.f2143d = parcel.readInt();
        this.f2144e = parcel.readInt();
        this.f2145f = parcel.readString();
        this.f2146g = parcel.readInt() != 0;
        this.f2147h = parcel.readInt() != 0;
        this.f2148i = parcel.readInt() != 0;
        this.f2149j = parcel.readBundle();
        this.f2150k = parcel.readInt() == 0 ? false : z10;
        this.f2152m = parcel.readBundle();
        this.f2151l = parcel.readInt();
    }
}
