package l6;

import io.reactivex.functions.Predicate;
import s9.l;

public final /* synthetic */ class k implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f18492a;

    public /* synthetic */ k(l lVar) {
        this.f18492a = lVar;
    }

    public final boolean test(Object obj) {
        return l.q(this.f18492a, obj);
    }
}
