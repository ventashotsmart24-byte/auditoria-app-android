package anet.channel.request;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.OutputStream;

public class ByteArrayEntry implements BodyEntry {
    public static final Parcelable.Creator<ByteArrayEntry> CREATOR = new a();
    /* access modifiers changed from: private */
    public byte[] bytes;
    /* access modifiers changed from: private */
    public String contentType;
    /* access modifiers changed from: private */
    public int count;
    /* access modifiers changed from: private */
    public int offset;

    public /* synthetic */ ByteArrayEntry(a aVar) {
        this();
    }

    public int describeContents() {
        return 0;
    }

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public int writeTo(OutputStream outputStream) {
        outputStream.write(this.bytes, this.offset, this.count);
        return this.count;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.bytes.length);
        parcel.writeByteArray(this.bytes);
        parcel.writeInt(this.offset);
        parcel.writeInt(this.count);
        parcel.writeString(this.contentType);
    }

    public ByteArrayEntry(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public ByteArrayEntry(byte[] bArr, int i10, int i11) {
        this.contentType = null;
        this.bytes = bArr;
        this.offset = i10;
        this.count = i11;
    }

    private ByteArrayEntry() {
        this.offset = 0;
        this.count = 0;
        this.contentType = null;
    }
}
