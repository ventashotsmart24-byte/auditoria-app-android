package j3;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public int f7166a;

    public i(int i10) {
        this.f7166a = i10;
    }

    public static i a(h[] hVarArr) {
        if (hVarArr.length <= 31) {
            int i10 = 0;
            for (h hVar : hVarArr) {
                if (hVar.a()) {
                    i10 |= hVar.b();
                }
            }
            return new i(i10);
        }
        throw new IllegalArgumentException(String.format("Can not use type `%s` with JacksonFeatureSet: too many entries (%d > 31)", new Object[]{hVarArr[0].getClass().getName(), Integer.valueOf(hVarArr.length)}));
    }

    public boolean b(h hVar) {
        if ((hVar.b() & this.f7166a) != 0) {
            return true;
        }
        return false;
    }

    public i c(h hVar) {
        int b10 = hVar.b() | this.f7166a;
        if (b10 == this.f7166a) {
            return this;
        }
        return new i(b10);
    }
}
