package a9;

import c9.a;
import c9.i;
import com.google.common.base.Preconditions;
import java.util.List;
import okio.Buffer;

public abstract class c implements c9.c {

    /* renamed from: a  reason: collision with root package name */
    public final c9.c f10741a;

    public c(c9.c cVar) {
        this.f10741a = (c9.c) Preconditions.checkNotNull(cVar, "delegate");
    }

    public void F(i iVar) {
        this.f10741a.F(iVar);
    }

    public void K(boolean z10, boolean z11, int i10, int i11, List list) {
        this.f10741a.K(z10, z11, i10, i11, list);
    }

    public void close() {
        this.f10741a.close();
    }

    public void connectionPreface() {
        this.f10741a.connectionPreface();
    }

    public void d(int i10, a aVar) {
        this.f10741a.d(i10, aVar);
    }

    public void data(boolean z10, int i10, Buffer buffer, int i11) {
        this.f10741a.data(z10, i10, buffer, i11);
    }

    public void flush() {
        this.f10741a.flush();
    }

    public void g(i iVar) {
        this.f10741a.g(iVar);
    }

    public int maxDataLength() {
        return this.f10741a.maxDataLength();
    }

    public void o(int i10, a aVar, byte[] bArr) {
        this.f10741a.o(i10, aVar, bArr);
    }

    public void ping(boolean z10, int i10, int i11) {
        this.f10741a.ping(z10, i10, i11);
    }

    public void windowUpdate(int i10, long j10) {
        this.f10741a.windowUpdate(i10, j10);
    }
}
