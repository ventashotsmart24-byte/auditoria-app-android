package z8;

import androidx.appcompat.app.m;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import y8.p;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f21005a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public volatile p f21006b = p.IDLE;

    public void a(p pVar) {
        Preconditions.checkNotNull(pVar, "newState");
        if (this.f21006b != pVar && this.f21006b != p.SHUTDOWN) {
            this.f21006b = pVar;
            if (!this.f21005a.isEmpty()) {
                ArrayList arrayList = this.f21005a;
                this.f21005a = new ArrayList();
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    m.a(it.next());
                    throw null;
                }
            }
        }
    }
}
