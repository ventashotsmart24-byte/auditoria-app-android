package androidx.fragment.app;

import androidx.lifecycle.v;
import androidx.lifecycle.w;
import androidx.lifecycle.x;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class r extends v {

    /* renamed from: j  reason: collision with root package name */
    public static final w.b f2132j = new a();

    /* renamed from: c  reason: collision with root package name */
    public final HashMap f2133c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final HashMap f2134d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final HashMap f2135e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public final boolean f2136f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2137g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2138h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f2139i = false;

    public class a implements w.b {
        public v a(Class cls) {
            return new r(true);
        }
    }

    public r(boolean z10) {
        this.f2136f = z10;
    }

    public static r j(x xVar) {
        return (r) new w(xVar, f2132j).a(r.class);
    }

    public void d() {
        if (o.F0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("onCleared called for ");
            sb.append(this);
        }
        this.f2137g = true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r.class != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        if (!this.f2133c.equals(rVar.f2133c) || !this.f2134d.equals(rVar.f2134d) || !this.f2135e.equals(rVar.f2135e)) {
            return false;
        }
        return true;
    }

    public void f(Fragment fragment) {
        if (this.f2139i) {
            o.F0(2);
        } else if (!this.f2133c.containsKey(fragment.mWho)) {
            this.f2133c.put(fragment.mWho, fragment);
            if (o.F0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Updating retained Fragments: Added ");
                sb.append(fragment);
            }
        }
    }

    public void g(Fragment fragment) {
        if (o.F0(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Clearing non-config state for ");
            sb.append(fragment);
        }
        r rVar = (r) this.f2134d.get(fragment.mWho);
        if (rVar != null) {
            rVar.d();
            this.f2134d.remove(fragment.mWho);
        }
        x xVar = (x) this.f2135e.get(fragment.mWho);
        if (xVar != null) {
            xVar.a();
            this.f2135e.remove(fragment.mWho);
        }
    }

    public Fragment h(String str) {
        return (Fragment) this.f2133c.get(str);
    }

    public int hashCode() {
        return (((this.f2133c.hashCode() * 31) + this.f2134d.hashCode()) * 31) + this.f2135e.hashCode();
    }

    public r i(Fragment fragment) {
        r rVar = (r) this.f2134d.get(fragment.mWho);
        if (rVar != null) {
            return rVar;
        }
        r rVar2 = new r(this.f2136f);
        this.f2134d.put(fragment.mWho, rVar2);
        return rVar2;
    }

    public Collection k() {
        return new ArrayList(this.f2133c.values());
    }

    public x l(Fragment fragment) {
        x xVar = (x) this.f2135e.get(fragment.mWho);
        if (xVar != null) {
            return xVar;
        }
        x xVar2 = new x();
        this.f2135e.put(fragment.mWho, xVar2);
        return xVar2;
    }

    public boolean m() {
        return this.f2137g;
    }

    public void n(Fragment fragment) {
        boolean z10;
        if (this.f2139i) {
            o.F0(2);
            return;
        }
        if (this.f2133c.remove(fragment.mWho) != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 && o.F0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Updating retained Fragments: Removed ");
            sb.append(fragment);
        }
    }

    public void o(boolean z10) {
        this.f2139i = z10;
    }

    public boolean p(Fragment fragment) {
        if (!this.f2133c.containsKey(fragment.mWho)) {
            return true;
        }
        if (this.f2136f) {
            return this.f2137g;
        }
        return !this.f2138h;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.f2133c.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.f2134d.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.f2135e.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(ASCIIPropertyListParser.ARRAY_END_TOKEN);
        return sb.toString();
    }
}
