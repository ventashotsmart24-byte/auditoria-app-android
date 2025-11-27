package j3;

import c3.n;
import java.util.ArrayList;
import java.util.List;

public class k extends j {

    /* renamed from: d  reason: collision with root package name */
    public final c3.k[] f7168d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f7169e;

    /* renamed from: f  reason: collision with root package name */
    public int f7170f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7171g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(boolean z10, c3.k[] kVarArr) {
        super(kVarArr[0]);
        boolean z11 = false;
        this.f7169e = z10;
        if (z10 && this.f7167c.h0()) {
            z11 = true;
        }
        this.f7171g = z11;
        this.f7168d = kVarArr;
        this.f7170f = 1;
    }

    public static k F0(boolean z10, c3.k kVar, c3.k kVar2) {
        boolean z11 = kVar instanceof k;
        if (z11 || (kVar2 instanceof k)) {
            ArrayList arrayList = new ArrayList();
            if (z11) {
                ((k) kVar).E0(arrayList);
            } else {
                arrayList.add(kVar);
            }
            if (kVar2 instanceof k) {
                ((k) kVar2).E0(arrayList);
            } else {
                arrayList.add(kVar2);
            }
            return new k(z10, (c3.k[]) arrayList.toArray(new c3.k[arrayList.size()]));
        }
        return new k(z10, new c3.k[]{kVar, kVar2});
    }

    public c3.k D0() {
        if (this.f7167c.n() != n.START_OBJECT && this.f7167c.n() != n.START_ARRAY) {
            return this;
        }
        int i10 = 1;
        while (true) {
            n s02 = s0();
            if (s02 == null) {
                return this;
            }
            if (s02.g()) {
                i10++;
            } else if (s02.f() && i10 - 1 == 0) {
                return this;
            }
        }
    }

    public void E0(List list) {
        int length = this.f7168d.length;
        for (int i10 = this.f7170f - 1; i10 < length; i10++) {
            c3.k kVar = this.f7168d[i10];
            if (kVar instanceof k) {
                ((k) kVar).E0(list);
            } else {
                list.add(kVar);
            }
        }
    }

    public n G0() {
        n s02;
        do {
            int i10 = this.f7170f;
            c3.k[] kVarArr = this.f7168d;
            if (i10 >= kVarArr.length) {
                return null;
            }
            this.f7170f = i10 + 1;
            c3.k kVar = kVarArr[i10];
            this.f7167c = kVar;
            if (this.f7169e && kVar.h0()) {
                return this.f7167c.I();
            }
            s02 = this.f7167c.s0();
        } while (s02 == null);
        return s02;
    }

    public boolean H0() {
        int i10 = this.f7170f;
        c3.k[] kVarArr = this.f7168d;
        if (i10 >= kVarArr.length) {
            return false;
        }
        this.f7170f = i10 + 1;
        this.f7167c = kVarArr[i10];
        return true;
    }

    public void close() {
        do {
            this.f7167c.close();
        } while (H0());
    }

    public n s0() {
        c3.k kVar = this.f7167c;
        if (kVar == null) {
            return null;
        }
        if (this.f7171g) {
            this.f7171g = false;
            return kVar.n();
        }
        n s02 = kVar.s0();
        if (s02 == null) {
            return G0();
        }
        return s02;
    }
}
