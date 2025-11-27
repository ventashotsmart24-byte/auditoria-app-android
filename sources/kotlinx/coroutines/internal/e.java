package kotlinx.coroutines.internal;

import ca.c0;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import k9.f;

public final class e implements c0 {

    /* renamed from: a  reason: collision with root package name */
    public final f f18259a;

    public e(f fVar) {
        this.f18259a = fVar;
    }

    public f d() {
        return this.f18259a;
    }

    public String toString() {
        return "CoroutineScope(coroutineContext=" + d() + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
