package e9;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import y8.n0;
import y8.w;

public final class a extends InputStream implements w, n0 {

    /* renamed from: a  reason: collision with root package name */
    public MessageLite f16527a;

    /* renamed from: b  reason: collision with root package name */
    public final Parser f16528b;

    /* renamed from: c  reason: collision with root package name */
    public ByteArrayInputStream f16529c;

    public a(MessageLite messageLite, Parser parser) {
        this.f16527a = messageLite;
        this.f16528b = parser;
    }

    public int a(OutputStream outputStream) {
        MessageLite messageLite = this.f16527a;
        if (messageLite != null) {
            int serializedSize = messageLite.getSerializedSize();
            this.f16527a.writeTo(outputStream);
            this.f16527a = null;
            return serializedSize;
        }
        ByteArrayInputStream byteArrayInputStream = this.f16529c;
        if (byteArrayInputStream == null) {
            return 0;
        }
        int a10 = (int) b.a(byteArrayInputStream, outputStream);
        this.f16529c = null;
        return a10;
    }

    public int available() {
        MessageLite messageLite = this.f16527a;
        if (messageLite != null) {
            return messageLite.getSerializedSize();
        }
        ByteArrayInputStream byteArrayInputStream = this.f16529c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.available();
        }
        return 0;
    }

    public MessageLite b() {
        MessageLite messageLite = this.f16527a;
        if (messageLite != null) {
            return messageLite;
        }
        throw new IllegalStateException("message not available");
    }

    public Parser c() {
        return this.f16528b;
    }

    public int read() {
        if (this.f16527a != null) {
            this.f16529c = new ByteArrayInputStream(this.f16527a.toByteArray());
            this.f16527a = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.f16529c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read();
        }
        return -1;
    }

    public int read(byte[] bArr, int i10, int i11) {
        MessageLite messageLite = this.f16527a;
        if (messageLite != null) {
            int serializedSize = messageLite.getSerializedSize();
            if (serializedSize == 0) {
                this.f16527a = null;
                this.f16529c = null;
                return -1;
            } else if (i11 >= serializedSize) {
                CodedOutputStream newInstance = CodedOutputStream.newInstance(bArr, i10, serializedSize);
                this.f16527a.writeTo(newInstance);
                newInstance.flush();
                newInstance.checkNoSpaceLeft();
                this.f16527a = null;
                this.f16529c = null;
                return serializedSize;
            } else {
                this.f16529c = new ByteArrayInputStream(this.f16527a.toByteArray());
                this.f16527a = null;
            }
        }
        ByteArrayInputStream byteArrayInputStream = this.f16529c;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read(bArr, i10, i11);
        }
        return -1;
    }
}
