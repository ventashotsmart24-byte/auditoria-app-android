package g5;

import a6.d;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;
import mobile.com.requestframe.utils.response.ChildColumnList;

public final class n implements MultiItemEntity {

    /* renamed from: a  reason: collision with root package name */
    public ChildColumnList f17006a;

    /* renamed from: b  reason: collision with root package name */
    public List f17007b;

    /* renamed from: c  reason: collision with root package name */
    public int f17008c;

    public n(ChildColumnList childColumnList, List list, int i10) {
        this.f17006a = childColumnList;
        this.f17007b = list;
        this.f17008c = i10;
    }

    public final ChildColumnList a() {
        return this.f17006a;
    }

    public final int b() {
        return this.f17008c;
    }

    public final List c() {
        return this.f17007b;
    }

    public final void d(List list) {
        this.f17007b = list;
    }

    public int getItemType() {
        return d.f10667a.c();
    }
}
