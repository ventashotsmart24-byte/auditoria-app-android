package g5;

import a6.d;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;
import mobile.com.requestframe.utils.response.ChildColumnList;

public final class u1 implements MultiItemEntity {

    /* renamed from: a  reason: collision with root package name */
    public ChildColumnList f17126a;

    /* renamed from: b  reason: collision with root package name */
    public List f17127b;

    public u1(ChildColumnList childColumnList, List list) {
        this.f17126a = childColumnList;
        this.f17127b = list;
    }

    public final ChildColumnList a() {
        return this.f17126a;
    }

    public final List b() {
        return this.f17127b;
    }

    public int getItemType() {
        return d.f10667a.l();
    }
}
