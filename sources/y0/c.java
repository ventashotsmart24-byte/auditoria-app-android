package y0;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.collection.a;

public class c extends b {

    /* renamed from: d  reason: collision with root package name */
    public final SparseIntArray f9853d;

    /* renamed from: e  reason: collision with root package name */
    public final Parcel f9854e;

    /* renamed from: f  reason: collision with root package name */
    public final int f9855f;

    /* renamed from: g  reason: collision with root package name */
    public final int f9856g;

    /* renamed from: h  reason: collision with root package name */
    public final String f9857h;

    /* renamed from: i  reason: collision with root package name */
    public int f9858i;

    /* renamed from: j  reason: collision with root package name */
    public int f9859j;

    /* renamed from: k  reason: collision with root package name */
    public int f9860k;

    public c(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new a(), new a(), new a());
    }

    public void A(byte[] bArr) {
        if (bArr != null) {
            this.f9854e.writeInt(bArr.length);
            this.f9854e.writeByteArray(bArr);
            return;
        }
        this.f9854e.writeInt(-1);
    }

    public void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f9854e, 0);
    }

    public void E(int i10) {
        this.f9854e.writeInt(i10);
    }

    public void G(Parcelable parcelable) {
        this.f9854e.writeParcelable(parcelable, 0);
    }

    public void I(String str) {
        this.f9854e.writeString(str);
    }

    public void a() {
        int i10 = this.f9858i;
        if (i10 >= 0) {
            int i11 = this.f9853d.get(i10);
            int dataPosition = this.f9854e.dataPosition();
            this.f9854e.setDataPosition(i11);
            this.f9854e.writeInt(dataPosition - i11);
            this.f9854e.setDataPosition(dataPosition);
        }
    }

    public b b() {
        Parcel parcel = this.f9854e;
        int dataPosition = parcel.dataPosition();
        int i10 = this.f9859j;
        if (i10 == this.f9855f) {
            i10 = this.f9856g;
        }
        int i11 = i10;
        return new c(parcel, dataPosition, i11, this.f9857h + "  ", this.f9850a, this.f9851b, this.f9852c);
    }

    public boolean g() {
        if (this.f9854e.readInt() != 0) {
            return true;
        }
        return false;
    }

    public byte[] i() {
        int readInt = this.f9854e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f9854e.readByteArray(bArr);
        return bArr;
    }

    public CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f9854e);
    }

    public boolean m(int i10) {
        while (this.f9859j < this.f9856g) {
            int i11 = this.f9860k;
            if (i11 == i10) {
                return true;
            }
            if (String.valueOf(i11).compareTo(String.valueOf(i10)) > 0) {
                return false;
            }
            this.f9854e.setDataPosition(this.f9859j);
            int readInt = this.f9854e.readInt();
            this.f9860k = this.f9854e.readInt();
            this.f9859j += readInt;
        }
        if (this.f9860k == i10) {
            return true;
        }
        return false;
    }

    public int o() {
        return this.f9854e.readInt();
    }

    public Parcelable q() {
        return this.f9854e.readParcelable(getClass().getClassLoader());
    }

    public String s() {
        return this.f9854e.readString();
    }

    public void w(int i10) {
        a();
        this.f9858i = i10;
        this.f9853d.put(i10, this.f9854e.dataPosition());
        E(0);
        E(i10);
    }

    public void y(boolean z10) {
        this.f9854e.writeInt(z10 ? 1 : 0);
    }

    public c(Parcel parcel, int i10, int i11, String str, a aVar, a aVar2, a aVar3) {
        super(aVar, aVar2, aVar3);
        this.f9853d = new SparseIntArray();
        this.f9858i = -1;
        this.f9860k = -1;
        this.f9854e = parcel;
        this.f9855f = i10;
        this.f9856g = i11;
        this.f9859j = i10;
        this.f9857h = str;
    }
}
