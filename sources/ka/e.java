package ka;

import ma.p;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

public class e extends ResponseBody {

    /* renamed from: c  reason: collision with root package name */
    public ResponseBody f18239c;

    /* renamed from: d  reason: collision with root package name */
    public d f18240d;

    /* renamed from: e  reason: collision with root package name */
    public BufferedSource f18241e;

    public class a extends ForwardingSource {

        /* renamed from: a  reason: collision with root package name */
        public long f18242a = 0;

        public a(Source source) {
            super(source);
        }

        public long read(Buffer buffer, long j10) {
            long j11;
            long read = super.read(buffer, j10);
            long j12 = this.f18242a;
            if (read != -1) {
                j11 = read;
            } else {
                j11 = 0;
            }
            this.f18242a = j12 + j11;
            p.b("download", "read: " + ((int) ((this.f18242a * 100) / e.this.f18239c.contentLength())));
            if (!(e.this.f18240d == null || read == -1)) {
                e.this.f18240d.b((int) this.f18242a);
                if (this.f18242a == e.this.f18239c.contentLength()) {
                    e.this.f18240d.a();
                }
            }
            return read;
        }
    }

    public e(ResponseBody responseBody, d dVar) {
        this.f18239c = responseBody;
        this.f18240d = dVar;
        dVar.d(responseBody.contentLength());
    }

    public final Source c(Source source) {
        return new a(source);
    }

    public long contentLength() {
        return this.f18239c.contentLength();
    }

    public MediaType contentType() {
        return this.f18239c.contentType();
    }

    public BufferedSource source() {
        if (this.f18241e == null) {
            this.f18241e = Okio.buffer(c(this.f18239c.source()));
        }
        return this.f18241e;
    }
}
