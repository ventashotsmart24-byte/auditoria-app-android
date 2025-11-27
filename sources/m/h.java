package m;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public List f7757a;

    /* renamed from: b  reason: collision with root package name */
    public int f7758b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f7759c = -1;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7760d = false;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f7761e = {-1, -1};

    /* renamed from: f  reason: collision with root package name */
    public List f7762f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public List f7763g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public HashSet f7764h = new HashSet();

    /* renamed from: i  reason: collision with root package name */
    public HashSet f7765i = new HashSet();

    /* renamed from: j  reason: collision with root package name */
    public List f7766j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public List f7767k = new ArrayList();

    public h(List list) {
        this.f7757a = list;
    }

    public void a(f fVar, int i10) {
        if (i10 == 0) {
            this.f7764h.add(fVar);
        } else if (i10 == 1) {
            this.f7765i.add(fVar);
        }
    }

    public List b(int i10) {
        if (i10 == 0) {
            return this.f7762f;
        }
        if (i10 == 1) {
            return this.f7763g;
        }
        return null;
    }

    public Set c(int i10) {
        if (i10 == 0) {
            return this.f7764h;
        }
        if (i10 == 1) {
            return this.f7765i;
        }
        return null;
    }

    public List d() {
        if (!this.f7766j.isEmpty()) {
            return this.f7766j;
        }
        int size = this.f7757a.size();
        for (int i10 = 0; i10 < size; i10++) {
            f fVar = (f) this.f7757a.get(i10);
            if (!fVar.f7717i0) {
                e((ArrayList) this.f7766j, fVar);
            }
        }
        this.f7767k.clear();
        this.f7767k.addAll(this.f7757a);
        this.f7767k.removeAll(this.f7766j);
        return this.f7766j;
    }

    public final void e(ArrayList arrayList, f fVar) {
        f fVar2;
        if (!fVar.f7721k0) {
            arrayList.add(fVar);
            fVar.f7721k0 = true;
            if (!fVar.L()) {
                if (fVar instanceof j) {
                    j jVar = (j) fVar;
                    int i10 = jVar.f7775w0;
                    for (int i11 = 0; i11 < i10; i11++) {
                        e(arrayList, jVar.f7774v0[i11]);
                    }
                }
                for (e eVar : fVar.C) {
                    e eVar2 = eVar.f7674d;
                    if (!(eVar2 == null || (fVar2 = eVar2.f7672b) == fVar.u())) {
                        e(arrayList, fVar2);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(m.f r7) {
        /*
            r6 = this;
            boolean r0 = r7.f7717i0
            if (r0 == 0) goto L_0x00d6
            boolean r0 = r7.L()
            if (r0 == 0) goto L_0x000b
            return
        L_0x000b:
            m.e r0 = r7.f7742w
            m.e r0 = r0.f7674d
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0015
            r3 = 1
            goto L_0x0016
        L_0x0015:
            r3 = 0
        L_0x0016:
            if (r3 == 0) goto L_0x0019
            goto L_0x001d
        L_0x0019:
            m.e r0 = r7.f7740u
            m.e r0 = r0.f7674d
        L_0x001d:
            if (r0 == 0) goto L_0x0041
            m.f r4 = r0.f7672b
            boolean r5 = r4.f7719j0
            if (r5 != 0) goto L_0x0028
            r6.f(r4)
        L_0x0028:
            m.e$d r4 = r0.f7673c
            m.e$d r5 = m.e.d.RIGHT
            if (r4 != r5) goto L_0x0038
            m.f r0 = r0.f7672b
            int r4 = r0.K
            int r0 = r0.D()
            int r4 = r4 + r0
            goto L_0x0042
        L_0x0038:
            m.e$d r5 = m.e.d.LEFT
            if (r4 != r5) goto L_0x0041
            m.f r0 = r0.f7672b
            int r4 = r0.K
            goto L_0x0042
        L_0x0041:
            r4 = 0
        L_0x0042:
            if (r3 == 0) goto L_0x004c
            m.e r0 = r7.f7742w
            int r0 = r0.d()
            int r4 = r4 - r0
            goto L_0x0058
        L_0x004c:
            m.e r0 = r7.f7740u
            int r0 = r0.d()
            int r3 = r7.D()
            int r0 = r0 + r3
            int r4 = r4 + r0
        L_0x0058:
            int r0 = r7.D()
            int r0 = r4 - r0
            r7.f0(r0, r4)
            m.e r0 = r7.f7744y
            m.e r0 = r0.f7674d
            if (r0 == 0) goto L_0x0083
            m.f r2 = r0.f7672b
            boolean r3 = r2.f7719j0
            if (r3 != 0) goto L_0x0070
            r6.f(r2)
        L_0x0070:
            m.f r0 = r0.f7672b
            int r2 = r0.L
            int r0 = r0.U
            int r2 = r2 + r0
            int r0 = r7.U
            int r2 = r2 - r0
            int r0 = r7.H
            int r0 = r0 + r2
            r7.t0(r2, r0)
            r7.f7719j0 = r1
            return
        L_0x0083:
            m.e r0 = r7.f7743x
            m.e r0 = r0.f7674d
            if (r0 == 0) goto L_0x008a
            r2 = 1
        L_0x008a:
            if (r2 == 0) goto L_0x008d
            goto L_0x0091
        L_0x008d:
            m.e r0 = r7.f7741v
            m.e r0 = r0.f7674d
        L_0x0091:
            if (r0 == 0) goto L_0x00b5
            m.f r3 = r0.f7672b
            boolean r5 = r3.f7719j0
            if (r5 != 0) goto L_0x009c
            r6.f(r3)
        L_0x009c:
            m.e$d r3 = r0.f7673c
            m.e$d r5 = m.e.d.BOTTOM
            if (r3 != r5) goto L_0x00ad
            m.f r0 = r0.f7672b
            int r3 = r0.L
            int r0 = r0.r()
            int r4 = r3 + r0
            goto L_0x00b5
        L_0x00ad:
            m.e$d r5 = m.e.d.TOP
            if (r3 != r5) goto L_0x00b5
            m.f r0 = r0.f7672b
            int r4 = r0.L
        L_0x00b5:
            if (r2 == 0) goto L_0x00bf
            m.e r0 = r7.f7743x
            int r0 = r0.d()
            int r4 = r4 - r0
            goto L_0x00cb
        L_0x00bf:
            m.e r0 = r7.f7741v
            int r0 = r0.d()
            int r2 = r7.r()
            int r0 = r0 + r2
            int r4 = r4 + r0
        L_0x00cb:
            int r0 = r7.r()
            int r0 = r4 - r0
            r7.t0(r0, r4)
            r7.f7719j0 = r1
        L_0x00d6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m.h.f(m.f):void");
    }

    public void g() {
        int size = this.f7767k.size();
        for (int i10 = 0; i10 < size; i10++) {
            f((f) this.f7767k.get(i10));
        }
    }

    public h(List list, boolean z10) {
        this.f7757a = list;
        this.f7760d = z10;
    }
}
