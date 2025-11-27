package androidx.activity.result;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0011a();

    /* renamed from: a  reason: collision with root package name */
    public final int f530a;

    /* renamed from: b  reason: collision with root package name */
    public final Intent f531b;

    /* renamed from: androidx.activity.result.a$a  reason: collision with other inner class name */
    public class C0011a implements Parcelable.Creator {
        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* renamed from: b */
        public a[] newArray(int i10) {
            return new a[i10];
        }
    }

    public a(int i10, Intent intent) {
        this.f530a = i10;
        this.f531b = intent;
    }

    public static String c(int i10) {
        if (i10 == -1) {
            return "RESULT_OK";
        }
        if (i10 != 0) {
            return String.valueOf(i10);
        }
        return "RESULT_CANCELED";
    }

    public Intent a() {
        return this.f531b;
    }

    public int b() {
        return this.f530a;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + c(this.f530a) + ", data=" + this.f531b + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        int i11;
        parcel.writeInt(this.f530a);
        if (this.f531b == null) {
            i11 = 0;
        } else {
            i11 = 1;
        }
        parcel.writeInt(i11);
        Intent intent = this.f531b;
        if (intent != null) {
            intent.writeToParcel(parcel, i10);
        }
    }

    public a(Parcel parcel) {
        this.f530a = parcel.readInt();
        this.f531b = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
