package g5;

import a6.d;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;
import t9.i;

public final class m implements MultiItemEntity {

    /* renamed from: a  reason: collision with root package name */
    public List f16997a;

    public m(List list) {
        i.g(list, "columnList");
        this.f16997a = list;
    }

    public final List a() {
        return this.f16997a;
    }

    public int getItemType() {
        return d.f10667a.b();
    }
}
