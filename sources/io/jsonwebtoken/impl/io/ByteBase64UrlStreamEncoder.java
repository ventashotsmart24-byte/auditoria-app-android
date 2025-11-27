package io.jsonwebtoken.impl.io;

import io.jsonwebtoken.io.Encoder;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Strings;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class ByteBase64UrlStreamEncoder implements Encoder<OutputStream, OutputStream> {
    private final Encoder<byte[], String> delegate;

    public static class TranslatingOutputStream extends FilteredOutputStream {
        private final Encoder<byte[], String> delegate;
        private final OutputStream dst;

        public TranslatingOutputStream(OutputStream outputStream, Encoder<byte[], String> encoder) {
            super(new ByteArrayOutputStream());
            this.dst = outputStream;
            this.delegate = encoder;
        }

        public void close() {
            this.dst.write(Strings.utf8((CharSequence) this.delegate.encode(((ByteArrayOutputStream) this.out).toByteArray())));
            this.dst.flush();
            this.dst.close();
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Object, io.jsonwebtoken.io.Encoder<byte[], java.lang.String>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ByteBase64UrlStreamEncoder(io.jsonwebtoken.io.Encoder<byte[], java.lang.String> r2) {
        /*
            r1 = this;
            r1.<init>()
            java.lang.String r0 = "delegate cannot be null."
            java.lang.Object r2 = io.jsonwebtoken.lang.Assert.notNull(r2, r0)
            io.jsonwebtoken.io.Encoder r2 = (io.jsonwebtoken.io.Encoder) r2
            r1.delegate = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.io.ByteBase64UrlStreamEncoder.<init>(io.jsonwebtoken.io.Encoder):void");
    }

    public OutputStream encode(OutputStream outputStream) {
        Assert.notNull(outputStream, "outputStream cannot be null.");
        return new TranslatingOutputStream(outputStream, this.delegate);
    }
}
