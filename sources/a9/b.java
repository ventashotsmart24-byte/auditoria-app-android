package a9;

import a9.j;
import c9.c;
import c9.i;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.ByteString;

public final class b implements c {

    /* renamed from: d  reason: collision with root package name */
    public static final Logger f10737d = Logger.getLogger(i.class.getName());

    /* renamed from: a  reason: collision with root package name */
    public final a f10738a;

    /* renamed from: b  reason: collision with root package name */
    public final c f10739b;

    /* renamed from: c  reason: collision with root package name */
    public final j f10740c = new j(Level.FINE, i.class);

    public interface a {
        void h(Throwable th);
    }

    public b(a aVar, c cVar) {
        this.f10738a = (a) Preconditions.checkNotNull(aVar, "transportExceptionHandler");
        this.f10739b = (c) Preconditions.checkNotNull(cVar, "frameWriter");
    }

    public static Level a(Throwable th) {
        if (th.getClass().equals(IOException.class)) {
            return Level.FINE;
        }
        return Level.INFO;
    }

    public void F(i iVar) {
        this.f10740c.i(j.a.OUTBOUND, iVar);
        try {
            this.f10739b.F(iVar);
        } catch (IOException e10) {
            this.f10738a.h(e10);
        }
    }

    public void K(boolean z10, boolean z11, int i10, int i11, List list) {
        try {
            this.f10739b.K(z10, z11, i10, i11, list);
        } catch (IOException e10) {
            this.f10738a.h(e10);
        }
    }

    public void close() {
        try {
            this.f10739b.close();
        } catch (IOException e10) {
            f10737d.log(a(e10), "Failed closing connection", e10);
        }
    }

    public void connectionPreface() {
        try {
            this.f10739b.connectionPreface();
        } catch (IOException e10) {
            this.f10738a.h(e10);
        }
    }

    public void d(int i10, c9.a aVar) {
        this.f10740c.h(j.a.OUTBOUND, i10, aVar);
        try {
            this.f10739b.d(i10, aVar);
        } catch (IOException e10) {
            this.f10738a.h(e10);
        }
    }

    public void data(boolean z10, int i10, Buffer buffer, int i11) {
        this.f10740c.b(j.a.OUTBOUND, i10, buffer.buffer(), i11, z10);
        try {
            this.f10739b.data(z10, i10, buffer, i11);
        } catch (IOException e10) {
            this.f10738a.h(e10);
        }
    }

    public void flush() {
        try {
            this.f10739b.flush();
        } catch (IOException e10) {
            this.f10738a.h(e10);
        }
    }

    public void g(i iVar) {
        this.f10740c.j(j.a.OUTBOUND);
        try {
            this.f10739b.g(iVar);
        } catch (IOException e10) {
            this.f10738a.h(e10);
        }
    }

    public int maxDataLength() {
        return this.f10739b.maxDataLength();
    }

    public void o(int i10, c9.a aVar, byte[] bArr) {
        this.f10740c.c(j.a.OUTBOUND, i10, aVar, ByteString.of(bArr));
        try {
            this.f10739b.o(i10, aVar, bArr);
            this.f10739b.flush();
        } catch (IOException e10) {
            this.f10738a.h(e10);
        }
    }

    public void ping(boolean z10, int i10, int i11) {
        if (z10) {
            this.f10740c.f(j.a.OUTBOUND, (4294967295L & ((long) i11)) | (((long) i10) << 32));
        } else {
            this.f10740c.e(j.a.OUTBOUND, (4294967295L & ((long) i11)) | (((long) i10) << 32));
        }
        try {
            this.f10739b.ping(z10, i10, i11);
        } catch (IOException e10) {
            this.f10738a.h(e10);
        }
    }

    public void windowUpdate(int i10, long j10) {
        this.f10740c.k(j.a.OUTBOUND, i10, j10);
        try {
            this.f10739b.windowUpdate(i10, j10);
        } catch (IOException e10) {
            this.f10738a.h(e10);
        }
    }
}
