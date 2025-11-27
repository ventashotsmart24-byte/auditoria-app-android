package t9;

import java.io.Serializable;

public abstract class j implements h, Serializable {
    private final int arity;

    public j(int i10) {
        this.arity = i10;
    }

    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String g10 = x.g(this);
        i.f(g10, "renderLambdaToString(this)");
        return g10;
    }
}
