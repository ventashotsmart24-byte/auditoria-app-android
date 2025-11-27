package g5;

import a6.d;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;
import t9.i;

public final class l implements MultiItemEntity {

    /* renamed from: a  reason: collision with root package name */
    public String f16981a;

    /* renamed from: b  reason: collision with root package name */
    public int f16982b;

    /* renamed from: c  reason: collision with root package name */
    public List f16983c;

    public l(String str, int i10, List list) {
        i.g(list, "recommendList");
        this.f16981a = str;
        this.f16982b = i10;
        this.f16983c = list;
    }

    public final String a() {
        return this.f16981a;
    }

    public final int b() {
        return this.f16982b;
    }

    public final List c() {
        return this.f16983c;
    }

    public int getItemType() {
        return d.f10667a.a();
    }
}
