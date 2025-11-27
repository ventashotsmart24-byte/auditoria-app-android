package androidx.activity.result;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

public final class e implements Parcelable {
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final IntentSender f532a;

    /* renamed from: b  reason: collision with root package name */
    public final Intent f533b;

    /* renamed from: c  reason: collision with root package name */
    public final int f534c;

    /* renamed from: d  reason: collision with root package name */
    public final int f535d;

    public class a implements Parcelable.Creator {
        /* renamed from: a */
        public e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        /* renamed from: b */
        public e[] newArray(int i10) {
            return new e[i10];
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public IntentSender f536a;

        /* renamed from: b  reason: collision with root package name */
        public Intent f537b;

        /* renamed from: c  reason: collision with root package name */
        public int f538c;

        /* renamed from: d  reason: collision with root package name */
        public int f539d;

        public b(IntentSender intentSender) {
            this.f536a = intentSender;
        }

        public e a() {
            return new e(this.f536a, this.f537b, this.f538c, this.f539d);
        }

        public b b(Intent intent) {
            this.f537b = intent;
            return this;
        }

        public b c(int i10, int i11) {
            this.f539d = i10;
            this.f538c = i11;
            return this;
        }
    }

    public e(IntentSender intentSender, Intent intent, int i10, int i11) {
        this.f532a = intentSender;
        this.f533b = intent;
        this.f534c = i10;
        this.f535d = i11;
    }

    public Intent a() {
        return this.f533b;
    }

    public int b() {
        return this.f534c;
    }

    public int c() {
        return this.f535d;
    }

    public IntentSender d() {
        return this.f532a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f532a, i10);
        parcel.writeParcelable(this.f533b, i10);
        parcel.writeInt(this.f534c);
        parcel.writeInt(this.f535d);
    }

    public e(Parcel parcel) {
        this.f532a = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.f533b = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.f534c = parcel.readInt();
        this.f535d = parcel.readInt();
    }
}
