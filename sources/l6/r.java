package l6;

import java.util.Comparator;
import mobile.com.requestframe.utils.response.ExchangeCodeItem;

public final /* synthetic */ class r implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s f18580a;

    public /* synthetic */ r(s sVar) {
        this.f18580a = sVar;
    }

    public final int compare(Object obj, Object obj2) {
        return s.o(this.f18580a, (ExchangeCodeItem) obj, (ExchangeCodeItem) obj2);
    }
}
