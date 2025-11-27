package g5;

import a6.d;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import t9.i;

public final class f3 implements MultiItemEntity {

    /* renamed from: a  reason: collision with root package name */
    public String f16912a;

    /* renamed from: b  reason: collision with root package name */
    public final String f16913b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f16914c;

    public f3(String str, String str2, boolean z10) {
        i.g(str, "adUnitId");
        this.f16912a = str;
        this.f16913b = str2;
        this.f16914c = z10;
    }

    public final String a() {
        return this.f16913b;
    }

    public final String b() {
        return this.f16912a;
    }

    public final boolean c() {
        return this.f16914c;
    }

    public int getItemType() {
        return d.f10667a.k();
    }
}
