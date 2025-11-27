package g5;

import a6.d;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;
import t9.i;

public final class s1 implements MultiItemEntity {

    /* renamed from: a  reason: collision with root package name */
    public String f17105a;

    /* renamed from: b  reason: collision with root package name */
    public int f17106b;

    /* renamed from: c  reason: collision with root package name */
    public List f17107c;

    public s1(String str, int i10, List list) {
        i.g(list, "recommendList");
        this.f17105a = str;
        this.f17106b = i10;
        this.f17107c = list;
    }

    public final String a() {
        return this.f17105a;
    }

    public final int b() {
        return this.f17106b;
    }

    public final List c() {
        return this.f17107c;
    }

    public int getItemType() {
        return d.f10667a.e();
    }
}
