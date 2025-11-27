package m9;

import kotlin.coroutines.Continuation;
import t9.h;
import t9.i;
import t9.x;

public abstract class j extends c implements h {

    /* renamed from: a  reason: collision with root package name */
    public final int f18990a;

    public j(int i10, Continuation continuation) {
        super(continuation);
        this.f18990a = i10;
    }

    public int getArity() {
        return this.f18990a;
    }

    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String f10 = x.f(this);
        i.f(f10, "renderLambdaToString(this)");
        return f10;
    }
}
