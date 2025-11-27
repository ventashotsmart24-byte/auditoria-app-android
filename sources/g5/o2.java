package g5;

import a6.d;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.io.Serializable;
import java.util.List;
import mobile.com.requestframe.utils.response.ChildColumnList;

public final class o2 extends f1 implements MultiItemEntity, Serializable {
    public o2(ChildColumnList childColumnList, List list, int i10) {
        super(childColumnList, list, i10);
    }

    public int getItemType() {
        return d.f10667a.d();
    }
}
