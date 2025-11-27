package w9;

import java.util.Random;

public abstract class a extends c {
    public int b() {
        return d().nextInt();
    }

    public int c(int i10) {
        return d().nextInt(i10);
    }

    public abstract Random d();
}
