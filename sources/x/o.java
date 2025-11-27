package x;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class o {

    public static class a implements Parcelable.ClassLoaderCreator {

        /* renamed from: a  reason: collision with root package name */
        public final p f9550a;

        public a(p pVar) {
            this.f9550a = pVar;
        }

        public Object createFromParcel(Parcel parcel) {
            return this.f9550a.createFromParcel(parcel, (ClassLoader) null);
        }

        public Object[] newArray(int i10) {
            return this.f9550a.newArray(i10);
        }

        public Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return this.f9550a.createFromParcel(parcel, classLoader);
        }
    }

    public static Parcelable.Creator a(p pVar) {
        return new a(pVar);
    }
}
