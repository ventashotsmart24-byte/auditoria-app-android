package z8;

import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.ArrayList;

public final class w0 {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f21007a = new ArrayList();

    public w0 a(Object obj) {
        this.f21007a.add(String.valueOf(obj));
        return this;
    }

    public w0 b(String str, Object obj) {
        ArrayList arrayList = this.f21007a;
        arrayList.add(str + Operator.Operation.EQUALS + obj);
        return this;
    }

    public String toString() {
        return this.f21007a.toString();
    }
}
