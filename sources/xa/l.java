package xa;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.lang.reflect.Method;
import org.greenrobot.eventbus.ThreadMode;

public class l {

    /* renamed from: a  reason: collision with root package name */
    public final Method f9782a;

    /* renamed from: b  reason: collision with root package name */
    public final ThreadMode f9783b;

    /* renamed from: c  reason: collision with root package name */
    public final Class f9784c;

    /* renamed from: d  reason: collision with root package name */
    public final int f9785d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f9786e;

    /* renamed from: f  reason: collision with root package name */
    public String f9787f;

    public l(Method method, Class cls, ThreadMode threadMode, int i10, boolean z10) {
        this.f9782a = method;
        this.f9783b = threadMode;
        this.f9784c = cls;
        this.f9785d = i10;
        this.f9786e = z10;
    }

    public final synchronized void a() {
        if (this.f9787f == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f9782a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f9782a.getName());
            sb.append(ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN);
            sb.append(this.f9784c.getName());
            this.f9787f = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        a();
        l lVar = (l) obj;
        lVar.a();
        return this.f9787f.equals(lVar.f9787f);
    }

    public int hashCode() {
        return this.f9782a.hashCode();
    }
}
