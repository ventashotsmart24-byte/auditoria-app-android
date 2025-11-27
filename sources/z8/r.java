package z8;

import y8.k1;
import y8.v0;

public interface r extends i2 {

    public enum a {
        PROCESSED,
        REFUSED,
        DROPPED,
        MISCARRIED
    }

    void b(v0 v0Var);

    void c(k1 k1Var, a aVar, v0 v0Var);
}
