package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.y;
import androidx.lifecycle.d;
import java.util.ArrayList;

public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final int[] f1913a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f1914b;

    /* renamed from: c  reason: collision with root package name */
    public final int[] f1915c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f1916d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1917e;

    /* renamed from: f  reason: collision with root package name */
    public final String f1918f;

    /* renamed from: g  reason: collision with root package name */
    public final int f1919g;

    /* renamed from: h  reason: collision with root package name */
    public final int f1920h;

    /* renamed from: i  reason: collision with root package name */
    public final CharSequence f1921i;

    /* renamed from: j  reason: collision with root package name */
    public final int f1922j;

    /* renamed from: k  reason: collision with root package name */
    public final CharSequence f1923k;

    /* renamed from: l  reason: collision with root package name */
    public final ArrayList f1924l;

    /* renamed from: m  reason: collision with root package name */
    public final ArrayList f1925m;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f1926n;

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

    public b(a aVar) {
        int size = aVar.f2173c.size();
        this.f1913a = new int[(size * 5)];
        if (aVar.f2179i) {
            this.f1914b = new ArrayList(size);
            this.f1915c = new int[size];
            this.f1916d = new int[size];
            int i10 = 0;
            int i11 = 0;
            while (i10 < size) {
                y.a aVar2 = (y.a) aVar.f2173c.get(i10);
                int i12 = i11 + 1;
                this.f1913a[i11] = aVar2.f2190a;
                ArrayList arrayList = this.f1914b;
                Fragment fragment = aVar2.f2191b;
                arrayList.add(fragment != null ? fragment.mWho : null);
                int[] iArr = this.f1913a;
                int i13 = i12 + 1;
                iArr[i12] = aVar2.f2192c;
                int i14 = i13 + 1;
                iArr[i13] = aVar2.f2193d;
                int i15 = i14 + 1;
                iArr[i14] = aVar2.f2194e;
                iArr[i15] = aVar2.f2195f;
                this.f1915c[i10] = aVar2.f2196g.ordinal();
                this.f1916d[i10] = aVar2.f2197h.ordinal();
                i10++;
                i11 = i15 + 1;
            }
            this.f1917e = aVar.f2178h;
            this.f1918f = aVar.f2181k;
            this.f1919g = aVar.f1912v;
            this.f1920h = aVar.f2182l;
            this.f1921i = aVar.f2183m;
            this.f1922j = aVar.f2184n;
            this.f1923k = aVar.f2185o;
            this.f1924l = aVar.f2186p;
            this.f1925m = aVar.f2187q;
            this.f1926n = aVar.f2188r;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public a a(o oVar) {
        a aVar = new a(oVar);
        int i10 = 0;
        int i11 = 0;
        while (i10 < this.f1913a.length) {
            y.a aVar2 = new y.a();
            int i12 = i10 + 1;
            aVar2.f2190a = this.f1913a[i10];
            if (o.F0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Instantiate ");
                sb.append(aVar);
                sb.append(" op #");
                sb.append(i11);
                sb.append(" base fragment #");
                sb.append(this.f1913a[i12]);
            }
            String str = (String) this.f1914b.get(i11);
            if (str != null) {
                aVar2.f2191b = oVar.f0(str);
            } else {
                aVar2.f2191b = null;
            }
            aVar2.f2196g = d.c.values()[this.f1915c[i11]];
            aVar2.f2197h = d.c.values()[this.f1916d[i11]];
            int[] iArr = this.f1913a;
            int i13 = i12 + 1;
            int i14 = iArr[i12];
            aVar2.f2192c = i14;
            int i15 = i13 + 1;
            int i16 = iArr[i13];
            aVar2.f2193d = i16;
            int i17 = i15 + 1;
            int i18 = iArr[i15];
            aVar2.f2194e = i18;
            int i19 = iArr[i17];
            aVar2.f2195f = i19;
            aVar.f2174d = i14;
            aVar.f2175e = i16;
            aVar.f2176f = i18;
            aVar.f2177g = i19;
            aVar.f(aVar2);
            i11++;
            i10 = i17 + 1;
        }
        aVar.f2178h = this.f1917e;
        aVar.f2181k = this.f1918f;
        aVar.f1912v = this.f1919g;
        aVar.f2179i = true;
        aVar.f2182l = this.f1920h;
        aVar.f2183m = this.f1921i;
        aVar.f2184n = this.f1922j;
        aVar.f2185o = this.f1923k;
        aVar.f2186p = this.f1924l;
        aVar.f2187q = this.f1925m;
        aVar.f2188r = this.f1926n;
        aVar.v(1);
        return aVar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeIntArray(this.f1913a);
        parcel.writeStringList(this.f1914b);
        parcel.writeIntArray(this.f1915c);
        parcel.writeIntArray(this.f1916d);
        parcel.writeInt(this.f1917e);
        parcel.writeString(this.f1918f);
        parcel.writeInt(this.f1919g);
        parcel.writeInt(this.f1920h);
        TextUtils.writeToParcel(this.f1921i, parcel, 0);
        parcel.writeInt(this.f1922j);
        TextUtils.writeToParcel(this.f1923k, parcel, 0);
        parcel.writeStringList(this.f1924l);
        parcel.writeStringList(this.f1925m);
        parcel.writeInt(this.f1926n ? 1 : 0);
    }

    public b(Parcel parcel) {
        this.f1913a = parcel.createIntArray();
        this.f1914b = parcel.createStringArrayList();
        this.f1915c = parcel.createIntArray();
        this.f1916d = parcel.createIntArray();
        this.f1917e = parcel.readInt();
        this.f1918f = parcel.readString();
        this.f1919g = parcel.readInt();
        this.f1920h = parcel.readInt();
        this.f1921i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1922j = parcel.readInt();
        this.f1923k = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1924l = parcel.createStringArrayList();
        this.f1925m = parcel.createStringArrayList();
        this.f1926n = parcel.readInt() != 0;
    }
}
