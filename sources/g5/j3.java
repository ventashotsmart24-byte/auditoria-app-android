package g5;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import mobile.com.requestframe.utils.response.ChildColumnList;
import t9.i;

public final class j3 {

    /* renamed from: a  reason: collision with root package name */
    public ChildColumnList f16947a;

    /* renamed from: b  reason: collision with root package name */
    public List f16948b;

    public j3(ChildColumnList childColumnList, List list) {
        i.g(childColumnList, "columnData");
        i.g(list, "shelveAssetList");
        this.f16947a = childColumnList;
        this.f16948b = list;
    }

    public final ChildColumnList a() {
        return this.f16947a;
    }

    public final List b() {
        return this.f16948b;
    }

    public final void c(List list) {
        i.g(list, "<set-?>");
        this.f16948b = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j3)) {
            return false;
        }
        j3 j3Var = (j3) obj;
        return i.b(this.f16947a, j3Var.f16947a) && i.b(this.f16948b, j3Var.f16948b);
    }

    public int hashCode() {
        return (this.f16947a.hashCode() * 31) + this.f16948b.hashCode();
    }

    public String toString() {
        return "SpecialItem(columnData=" + this.f16947a + ", shelveAssetList=" + this.f16948b + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
