package d7;

import android.graphics.Bitmap;
import com.google.common.primitives.UnsignedBytes;
import com.google.zxing.LuminanceSource;
import com.mobile.brasiltv.view.RoundedDrawable;

public final class e extends LuminanceSource {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f16370a;

    /* renamed from: b  reason: collision with root package name */
    public final int f16371b;

    /* renamed from: c  reason: collision with root package name */
    public final int f16372c;

    /* renamed from: d  reason: collision with root package name */
    public final int f16373d;

    /* renamed from: e  reason: collision with root package name */
    public final int f16374e;

    public e(byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15) {
        super(i14, i15);
        if (i14 + i12 > i10 || i15 + i13 > i11) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f16370a = bArr;
        this.f16371b = i10;
        this.f16372c = i11;
        this.f16373d = i12;
        this.f16374e = i13;
    }

    public Bitmap a() {
        int width = getWidth();
        int height = getHeight();
        int[] iArr = new int[(width * height)];
        byte[] bArr = this.f16370a;
        int i10 = (this.f16374e * this.f16371b) + this.f16373d;
        for (int i11 = 0; i11 < height; i11++) {
            int i12 = i11 * width;
            for (int i13 = 0; i13 < width; i13++) {
                iArr[i12 + i13] = ((bArr[i10 + i13] & UnsignedBytes.MAX_VALUE) * 65793) | RoundedDrawable.DEFAULT_BORDER_COLOR;
            }
            i10 += this.f16371b;
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return createBitmap;
    }

    public byte[] getMatrix() {
        int width = getWidth();
        int height = getHeight();
        int i10 = this.f16371b;
        if (width == i10 && height == this.f16372c) {
            return this.f16370a;
        }
        int i11 = width * height;
        byte[] bArr = new byte[i11];
        int i12 = (this.f16374e * i10) + this.f16373d;
        if (width == i10) {
            System.arraycopy(this.f16370a, i12, bArr, 0, i11);
            return bArr;
        }
        byte[] bArr2 = this.f16370a;
        for (int i13 = 0; i13 < height; i13++) {
            System.arraycopy(bArr2, i12, bArr, i13 * width, width);
            i12 += this.f16371b;
        }
        return bArr;
    }

    public byte[] getRow(int i10, byte[] bArr) {
        if (i10 < 0 || i10 >= getHeight()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i10);
        }
        int width = getWidth();
        if (bArr == null || bArr.length < width) {
            bArr = new byte[width];
        }
        System.arraycopy(this.f16370a, ((i10 + this.f16374e) * this.f16371b) + this.f16373d, bArr, 0, width);
        return bArr;
    }

    public boolean isCropSupported() {
        return true;
    }
}
