package a;

import a.a;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;

public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f68a = false;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f69b = null;

    /* renamed from: c  reason: collision with root package name */
    public a f70c;

    public class a implements Parcelable.Creator {
        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* renamed from: b */
        public b[] newArray(int i10) {
            return new b[i10];
        }
    }

    /* renamed from: a.b$b  reason: collision with other inner class name */
    public class C0002b extends a.C0000a {
        public C0002b() {
        }

        public void c(int i10, Bundle bundle) {
            b bVar = b.this;
            Handler handler = bVar.f69b;
            if (handler != null) {
                handler.post(new c(i10, bundle));
            } else {
                bVar.a(i10, bundle);
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final int f72a;

        /* renamed from: b  reason: collision with root package name */
        public final Bundle f73b;

        public c(int i10, Bundle bundle) {
            this.f72a = i10;
            this.f73b = bundle;
        }

        public void run() {
            b.this.a(this.f72a, this.f73b);
        }
    }

    public b(Parcel parcel) {
        this.f70c = a.C0000a.i0(parcel.readStrongBinder());
    }

    public void a(int i10, Bundle bundle) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        synchronized (this) {
            if (this.f70c == null) {
                this.f70c = new C0002b();
            }
            parcel.writeStrongBinder(this.f70c.asBinder());
        }
    }
}
