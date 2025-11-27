package z8;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.util.ArrayDeque;
import java.util.Deque;

public class u extends c {

    /* renamed from: e  reason: collision with root package name */
    public static final f f20971e = new a();

    /* renamed from: f  reason: collision with root package name */
    public static final f f20972f = new b();

    /* renamed from: g  reason: collision with root package name */
    public static final f f20973g = new c();

    /* renamed from: h  reason: collision with root package name */
    public static final f f20974h = new d();

    /* renamed from: i  reason: collision with root package name */
    public static final g f20975i = new e();

    /* renamed from: a  reason: collision with root package name */
    public final Deque f20976a;

    /* renamed from: b  reason: collision with root package name */
    public Deque f20977b;

    /* renamed from: c  reason: collision with root package name */
    public int f20978c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f20979d;

    public class a implements f {
        /* renamed from: b */
        public int a(t1 t1Var, int i10, Void voidR, int i11) {
            return t1Var.readUnsignedByte();
        }
    }

    public class b implements f {
        /* renamed from: b */
        public int a(t1 t1Var, int i10, Void voidR, int i11) {
            t1Var.skipBytes(i10);
            return 0;
        }
    }

    public class c implements f {
        /* renamed from: b */
        public int a(t1 t1Var, int i10, byte[] bArr, int i11) {
            t1Var.C(bArr, i11, i10);
            return i11 + i10;
        }
    }

    public class d implements f {
        /* renamed from: b */
        public int a(t1 t1Var, int i10, ByteBuffer byteBuffer, int i11) {
            int limit = byteBuffer.limit();
            byteBuffer.limit(byteBuffer.position() + i10);
            t1Var.r(byteBuffer);
            byteBuffer.limit(limit);
            return 0;
        }
    }

    public class e implements g {
        /* renamed from: b */
        public int a(t1 t1Var, int i10, OutputStream outputStream, int i11) {
            t1Var.H(outputStream, i10);
            return 0;
        }
    }

    public interface f extends g {
    }

    public interface g {
        int a(t1 t1Var, int i10, Object obj, int i11);
    }

    public u(int i10) {
        this.f20976a = new ArrayDeque(i10);
    }

    public void C(byte[] bArr, int i10, int i11) {
        n(f20973g, i11, bArr, i10);
    }

    public void D() {
        if (this.f20977b == null) {
            this.f20977b = new ArrayDeque(Math.min(this.f20976a.size(), 16));
        }
        while (!this.f20977b.isEmpty()) {
            ((t1) this.f20977b.remove()).close();
        }
        this.f20979d = true;
        t1 t1Var = (t1) this.f20976a.peek();
        if (t1Var != null) {
            t1Var.D();
        }
    }

    public void H(OutputStream outputStream, int i10) {
        m(f20975i, i10, outputStream, 0);
    }

    public void b(t1 t1Var) {
        boolean z10;
        if (!this.f20979d || !this.f20976a.isEmpty()) {
            z10 = false;
        } else {
            z10 = true;
        }
        f(t1Var);
        if (z10) {
            ((t1) this.f20976a.peek()).D();
        }
    }

    public final void c() {
        if (this.f20979d) {
            this.f20977b.add((t1) this.f20976a.remove());
            t1 t1Var = (t1) this.f20976a.peek();
            if (t1Var != null) {
                t1Var.D();
                return;
            }
            return;
        }
        ((t1) this.f20976a.remove()).close();
    }

    public void close() {
        while (!this.f20976a.isEmpty()) {
            ((t1) this.f20976a.remove()).close();
        }
        if (this.f20977b != null) {
            while (!this.f20977b.isEmpty()) {
                ((t1) this.f20977b.remove()).close();
            }
        }
    }

    public final void e() {
        if (((t1) this.f20976a.peek()).h() == 0) {
            c();
        }
    }

    public final void f(t1 t1Var) {
        if (!(t1Var instanceof u)) {
            this.f20976a.add(t1Var);
            this.f20978c += t1Var.h();
            return;
        }
        u uVar = (u) t1Var;
        while (!uVar.f20976a.isEmpty()) {
            this.f20976a.add((t1) uVar.f20976a.remove());
        }
        this.f20978c += uVar.f20978c;
        uVar.f20978c = 0;
        uVar.close();
    }

    public int h() {
        return this.f20978c;
    }

    public t1 j(int i10) {
        t1 t1Var;
        int i11;
        t1 t1Var2;
        if (i10 <= 0) {
            return u1.a();
        }
        a(i10);
        this.f20978c -= i10;
        u uVar = null;
        u uVar2 = null;
        while (true) {
            t1 t1Var3 = (t1) this.f20976a.peek();
            int h10 = t1Var3.h();
            if (h10 > i10) {
                t1Var = t1Var3.j(i10);
                i11 = 0;
            } else {
                if (this.f20979d) {
                    t1Var2 = t1Var3.j(h10);
                    c();
                } else {
                    t1Var2 = (t1) this.f20976a.poll();
                }
                t1 t1Var4 = t1Var2;
                i11 = i10 - h10;
                t1Var = t1Var4;
            }
            if (uVar == null) {
                uVar = t1Var;
            } else {
                if (uVar2 == null) {
                    int i12 = 2;
                    if (i11 != 0) {
                        i12 = Math.min(this.f20976a.size() + 2, 16);
                    }
                    uVar2 = new u(i12);
                    uVar2.b(uVar);
                    uVar = uVar2;
                }
                uVar2.b(t1Var);
            }
            if (i11 <= 0) {
                return uVar;
            }
            i10 = i11;
        }
    }

    public final int m(g gVar, int i10, Object obj, int i11) {
        a(i10);
        if (!this.f20976a.isEmpty()) {
            e();
        }
        while (i10 > 0 && !this.f20976a.isEmpty()) {
            t1 t1Var = (t1) this.f20976a.peek();
            int min = Math.min(i10, t1Var.h());
            i11 = gVar.a(t1Var, min, obj, i11);
            i10 -= min;
            this.f20978c -= min;
            e();
        }
        if (i10 <= 0) {
            return i11;
        }
        throw new AssertionError("Failed executing read operation");
    }

    public boolean markSupported() {
        for (t1 markSupported : this.f20976a) {
            if (!markSupported.markSupported()) {
                return false;
            }
        }
        return true;
    }

    public final int n(f fVar, int i10, Object obj, int i11) {
        try {
            return m(fVar, i10, obj, i11);
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }

    public void r(ByteBuffer byteBuffer) {
        n(f20974h, byteBuffer.remaining(), byteBuffer, 0);
    }

    public int readUnsignedByte() {
        return n(f20971e, 1, (Object) null, 0);
    }

    public void reset() {
        if (this.f20979d) {
            t1 t1Var = (t1) this.f20976a.peek();
            if (t1Var != null) {
                int h10 = t1Var.h();
                t1Var.reset();
                this.f20978c += t1Var.h() - h10;
            }
            while (true) {
                t1 t1Var2 = (t1) this.f20977b.pollLast();
                if (t1Var2 != null) {
                    t1Var2.reset();
                    this.f20976a.addFirst(t1Var2);
                    this.f20978c += t1Var2.h();
                } else {
                    return;
                }
            }
        } else {
            throw new InvalidMarkException();
        }
    }

    public void skipBytes(int i10) {
        n(f20972f, i10, (Object) null, 0);
    }

    public u() {
        this.f20976a = new ArrayDeque();
    }
}
