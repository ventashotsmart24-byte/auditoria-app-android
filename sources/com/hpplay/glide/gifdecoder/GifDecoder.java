package com.hpplay.glide.gifdecoder;

import android.graphics.Bitmap;
import com.google.common.primitives.UnsignedBytes;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;

public class GifDecoder {
    private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    private static final int DISPOSAL_BACKGROUND = 2;
    private static final int DISPOSAL_NONE = 1;
    private static final int DISPOSAL_PREVIOUS = 3;
    private static final int DISPOSAL_UNSPECIFIED = 0;
    private static final int INITIAL_FRAME_POINTER = -1;
    private static final int MAX_STACK_SIZE = 4096;
    private static final int NULL_CODE = -1;
    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OK = 0;
    public static final int STATUS_OPEN_ERROR = 2;
    public static final int STATUS_PARTIAL_DECODE = 3;
    private static final String TAG = "GifDecoder";
    private int[] act;
    private BitmapProvider bitmapProvider;
    private final byte[] block = new byte[256];
    private byte[] data;
    private int framePointer;
    private GifHeader header;
    private byte[] mainPixels;
    private int[] mainScratch;
    private GifHeaderParser parser;
    private byte[] pixelStack;
    private short[] prefix;
    private Bitmap previousImage;
    private ByteBuffer rawData;
    private boolean savePrevious;
    private int status;
    private byte[] suffix;

    public interface BitmapProvider {
        Bitmap obtain(int i10, int i11, Bitmap.Config config);

        void release(Bitmap bitmap);
    }

    public GifDecoder(BitmapProvider bitmapProvider2) {
        this.bitmapProvider = bitmapProvider2;
        this.header = new GifHeader();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v6, resolved type: byte} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=short, code=int, for r1v20, types: [short] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0137 A[LOOP:4: B:57:0x0135->B:58:0x0137, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void decodeBitmapData(com.hpplay.glide.gifdecoder.GifFrame r28) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            if (r1 == 0) goto L_0x000d
            java.nio.ByteBuffer r2 = r0.rawData
            int r3 = r1.bufferFrameStart
            r2.position(r3)
        L_0x000d:
            if (r1 != 0) goto L_0x0016
            com.hpplay.glide.gifdecoder.GifHeader r1 = r0.header
            int r2 = r1.width
            int r1 = r1.height
            goto L_0x001a
        L_0x0016:
            int r2 = r1.iw
            int r1 = r1.ih
        L_0x001a:
            int r2 = r2 * r1
            byte[] r1 = r0.mainPixels
            if (r1 == 0) goto L_0x0023
            int r1 = r1.length
            if (r1 >= r2) goto L_0x0027
        L_0x0023:
            byte[] r1 = new byte[r2]
            r0.mainPixels = r1
        L_0x0027:
            short[] r1 = r0.prefix
            r3 = 4096(0x1000, float:5.74E-42)
            if (r1 != 0) goto L_0x0031
            short[] r1 = new short[r3]
            r0.prefix = r1
        L_0x0031:
            byte[] r1 = r0.suffix
            if (r1 != 0) goto L_0x0039
            byte[] r1 = new byte[r3]
            r0.suffix = r1
        L_0x0039:
            byte[] r1 = r0.pixelStack
            if (r1 != 0) goto L_0x0043
            r1 = 4097(0x1001, float:5.741E-42)
            byte[] r1 = new byte[r1]
            r0.pixelStack = r1
        L_0x0043:
            int r1 = r27.read()
            r4 = 1
            int r5 = r4 << r1
            int r6 = r5 + 1
            int r7 = r5 + 2
            int r1 = r1 + r4
            int r8 = r4 << r1
            int r8 = r8 - r4
            r9 = 0
            r10 = 0
        L_0x0054:
            if (r10 >= r5) goto L_0x0062
            short[] r11 = r0.prefix
            r11[r10] = r9
            byte[] r11 = r0.suffix
            byte r12 = (byte) r10
            r11[r10] = r12
            int r10 = r10 + 1
            goto L_0x0054
        L_0x0062:
            r10 = -1
            r19 = r1
            r17 = r7
            r18 = r8
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r20 = -1
            r21 = 0
            r22 = 0
        L_0x0076:
            if (r11 >= r2) goto L_0x016e
            r9 = 3
            if (r12 != 0) goto L_0x0086
            int r12 = r27.readBlock()
            if (r12 > 0) goto L_0x0085
            r0.status = r9
            goto L_0x016e
        L_0x0085:
            r13 = 0
        L_0x0086:
            byte[] r3 = r0.block
            byte r3 = r3[r13]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << r14
            int r15 = r15 + r3
            int r14 = r14 + 8
            int r13 = r13 + r4
            int r12 = r12 + r10
            r3 = r17
            r4 = r19
            r23 = r20
            r24 = r21
        L_0x009a:
            if (r14 < r4) goto L_0x0158
            r10 = r15 & r18
            int r15 = r15 >> r4
            int r14 = r14 - r4
            if (r10 != r5) goto L_0x00aa
            r4 = r1
            r3 = r7
            r18 = r8
            r10 = -1
            r23 = -1
            goto L_0x009a
        L_0x00aa:
            if (r10 <= r3) goto L_0x00af
            r0.status = r9
            goto L_0x00b1
        L_0x00af:
            if (r10 != r6) goto L_0x00bf
        L_0x00b1:
            r17 = r3
            r19 = r4
            r20 = r23
            r21 = r24
            r3 = 4096(0x1000, float:5.74E-42)
            r4 = 1
            r9 = 0
            r10 = -1
            goto L_0x0076
        L_0x00bf:
            r19 = r1
            r9 = r23
            r1 = -1
            if (r9 != r1) goto L_0x00db
            byte[] r9 = r0.pixelStack
            int r21 = r22 + 1
            byte[] r1 = r0.suffix
            byte r1 = r1[r10]
            r9[r22] = r1
            r23 = r10
            r24 = r23
            r1 = r19
            r22 = r21
            r9 = 3
            r10 = -1
            goto L_0x009a
        L_0x00db:
            if (r10 < r3) goto L_0x00ec
            byte[] r1 = r0.pixelStack
            int r21 = r22 + 1
            r25 = r6
            r6 = r24
            byte r6 = (byte) r6
            r1[r22] = r6
            r1 = r9
            r22 = r21
            goto L_0x00ef
        L_0x00ec:
            r25 = r6
            r1 = r10
        L_0x00ef:
            if (r1 < r5) goto L_0x0106
            byte[] r6 = r0.pixelStack
            int r21 = r22 + 1
            r24 = r5
            byte[] r5 = r0.suffix
            byte r5 = r5[r1]
            r6[r22] = r5
            short[] r5 = r0.prefix
            short r1 = r5[r1]
            r22 = r21
            r5 = r24
            goto L_0x00ef
        L_0x0106:
            r24 = r5
            byte[] r5 = r0.suffix
            byte r1 = r5[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte[] r6 = r0.pixelStack
            int r21 = r22 + 1
            r26 = r7
            byte r7 = (byte) r1
            r6[r22] = r7
            r6 = 4096(0x1000, float:5.74E-42)
            if (r3 >= r6) goto L_0x0131
            short[] r6 = r0.prefix
            short r9 = (short) r9
            r6[r3] = r9
            r5[r3] = r7
            int r3 = r3 + 1
            r5 = r3 & r18
            if (r5 != 0) goto L_0x0131
            r5 = 4096(0x1000, float:5.74E-42)
            if (r3 >= r5) goto L_0x0133
            int r4 = r4 + 1
            int r18 = r18 + r3
            goto L_0x0133
        L_0x0131:
            r5 = 4096(0x1000, float:5.74E-42)
        L_0x0133:
            r22 = r21
        L_0x0135:
            if (r22 <= 0) goto L_0x0148
            int r22 = r22 + -1
            byte[] r6 = r0.mainPixels
            int r7 = r16 + 1
            byte[] r9 = r0.pixelStack
            byte r9 = r9[r22]
            r6[r16] = r9
            int r11 = r11 + 1
            r16 = r7
            goto L_0x0135
        L_0x0148:
            r23 = r10
            r5 = r24
            r6 = r25
            r7 = r26
            r9 = 3
            r10 = -1
            r24 = r1
            r1 = r19
            goto L_0x009a
        L_0x0158:
            r25 = r6
            r9 = r23
            r6 = r24
            r17 = r3
            r19 = r4
            r21 = r6
            r20 = r9
            r6 = r25
            r3 = 4096(0x1000, float:5.74E-42)
            r4 = 1
            r9 = 0
            goto L_0x0076
        L_0x016e:
            r1 = r16
        L_0x0170:
            if (r1 >= r2) goto L_0x017a
            byte[] r3 = r0.mainPixels
            r4 = 0
            r3[r1] = r4
            int r1 = r1 + 1
            goto L_0x0170
        L_0x017a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.glide.gifdecoder.GifDecoder.decodeBitmapData(com.hpplay.glide.gifdecoder.GifFrame):void");
    }

    private GifHeaderParser getHeaderParser() {
        if (this.parser == null) {
            this.parser = new GifHeaderParser();
        }
        return this.parser;
    }

    private Bitmap getNextBitmap() {
        BitmapProvider bitmapProvider2 = this.bitmapProvider;
        GifHeader gifHeader = this.header;
        int i10 = gifHeader.width;
        int i11 = gifHeader.height;
        Bitmap.Config config = BITMAP_CONFIG;
        Bitmap obtain = bitmapProvider2.obtain(i10, i11, config);
        if (obtain == null) {
            GifHeader gifHeader2 = this.header;
            obtain = Bitmap.createBitmap(gifHeader2.width, gifHeader2.height, config);
        }
        setAlpha(obtain);
        return obtain;
    }

    private int readBlock() {
        int read = read();
        int i10 = 0;
        if (read > 0) {
            while (i10 < read) {
                int i11 = read - i10;
                try {
                    this.rawData.get(this.block, i10, i11);
                    i10 += i11;
                } catch (Exception unused) {
                    this.status = 1;
                }
            }
        }
        return i10;
    }

    private static void setAlpha(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x009a A[EDGE_INSN: B:53:0x009a->B:42:0x009a ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap setPixels(com.hpplay.glide.gifdecoder.GifFrame r18, com.hpplay.glide.gifdecoder.GifFrame r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            com.hpplay.glide.gifdecoder.GifHeader r3 = r0.header
            int r12 = r3.width
            int r13 = r3.height
            int[] r14 = r0.mainScratch
            r15 = 3
            r16 = 0
            r11 = 2
            if (r2 == 0) goto L_0x0038
            int r2 = r2.dispose
            if (r2 <= 0) goto L_0x0038
            if (r2 != r11) goto L_0x0026
            boolean r2 = r1.transparency
            if (r2 != 0) goto L_0x0021
            int r2 = r3.bgColor
            goto L_0x0022
        L_0x0021:
            r2 = 0
        L_0x0022:
            java.util.Arrays.fill(r14, r2)
            goto L_0x0038
        L_0x0026:
            if (r2 != r15) goto L_0x0038
            android.graphics.Bitmap r4 = r0.previousImage
            if (r4 == 0) goto L_0x0038
            r6 = 0
            r8 = 0
            r9 = 0
            r5 = r14
            r7 = r12
            r10 = r12
            r2 = 2
            r11 = r13
            r4.getPixels(r5, r6, r7, r8, r9, r10, r11)
            goto L_0x0039
        L_0x0038:
            r2 = 2
        L_0x0039:
            r17.decodeBitmapData(r18)
            r11 = 1
            r3 = 8
            r4 = 0
            r5 = 0
            r6 = 1
        L_0x0042:
            int r7 = r1.ih
            if (r4 >= r7) goto L_0x009a
            boolean r8 = r1.interlace
            if (r8 == 0) goto L_0x0060
            if (r5 < r7) goto L_0x005d
            int r6 = r6 + 1
            r7 = 4
            if (r6 == r2) goto L_0x005c
            if (r6 == r15) goto L_0x0059
            if (r6 == r7) goto L_0x0056
            goto L_0x005d
        L_0x0056:
            r3 = 2
            r5 = 1
            goto L_0x005d
        L_0x0059:
            r3 = 4
            r5 = 2
            goto L_0x005d
        L_0x005c:
            r5 = 4
        L_0x005d:
            int r7 = r5 + r3
            goto L_0x0062
        L_0x0060:
            r7 = r5
            r5 = r4
        L_0x0062:
            int r8 = r1.iy
            int r5 = r5 + r8
            com.hpplay.glide.gifdecoder.GifHeader r8 = r0.header
            int r9 = r8.height
            if (r5 >= r9) goto L_0x0094
            int r8 = r8.width
            int r5 = r5 * r8
            int r9 = r1.ix
            int r9 = r9 + r5
            int r10 = r1.iw
            int r2 = r9 + r10
            int r15 = r5 + r8
            if (r15 >= r2) goto L_0x007c
            int r2 = r5 + r8
        L_0x007c:
            int r10 = r10 * r4
        L_0x007e:
            if (r9 >= r2) goto L_0x0094
            byte[] r5 = r0.mainPixels
            int r8 = r10 + 1
            byte r5 = r5[r10]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int[] r10 = r0.act
            r5 = r10[r5]
            if (r5 == 0) goto L_0x0090
            r14[r9] = r5
        L_0x0090:
            int r9 = r9 + 1
            r10 = r8
            goto L_0x007e
        L_0x0094:
            int r4 = r4 + 1
            r5 = r7
            r2 = 2
            r15 = 3
            goto L_0x0042
        L_0x009a:
            boolean r2 = r0.savePrevious
            if (r2 == 0) goto L_0x00ba
            int r1 = r1.dispose
            if (r1 == 0) goto L_0x00a4
            if (r1 != r11) goto L_0x00ba
        L_0x00a4:
            android.graphics.Bitmap r1 = r0.previousImage
            if (r1 != 0) goto L_0x00ae
            android.graphics.Bitmap r1 = r17.getNextBitmap()
            r0.previousImage = r1
        L_0x00ae:
            android.graphics.Bitmap r4 = r0.previousImage
            r6 = 0
            r8 = 0
            r9 = 0
            r5 = r14
            r7 = r12
            r10 = r12
            r11 = r13
            r4.setPixels(r5, r6, r7, r8, r9, r10, r11)
        L_0x00ba:
            android.graphics.Bitmap r1 = r17.getNextBitmap()
            r6 = 0
            r8 = 0
            r9 = 0
            r4 = r1
            r5 = r14
            r7 = r12
            r10 = r12
            r11 = r13
            r4.setPixels(r5, r6, r7, r8, r9, r10, r11)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.glide.gifdecoder.GifDecoder.setPixels(com.hpplay.glide.gifdecoder.GifFrame, com.hpplay.glide.gifdecoder.GifFrame):android.graphics.Bitmap");
    }

    public void advance() {
        this.framePointer = (this.framePointer + 1) % this.header.frameCount;
    }

    public void clear() {
        this.header = null;
        this.data = null;
        this.mainPixels = null;
        this.mainScratch = null;
        Bitmap bitmap = this.previousImage;
        if (bitmap != null) {
            this.bitmapProvider.release(bitmap);
        }
        this.previousImage = null;
        this.rawData = null;
    }

    public int getCurrentFrameIndex() {
        return this.framePointer;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getDelay(int i10) {
        if (i10 >= 0) {
            GifHeader gifHeader = this.header;
            if (i10 < gifHeader.frameCount) {
                return gifHeader.frames.get(i10).delay;
            }
        }
        return -1;
    }

    public int getFrameCount() {
        return this.header.frameCount;
    }

    public int getHeight() {
        return this.header.height;
    }

    public int getLoopCount() {
        return this.header.loopCount;
    }

    public int getNextDelay() {
        int i10;
        if (this.header.frameCount <= 0 || (i10 = this.framePointer) < 0) {
            return -1;
        }
        return getDelay(i10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009c, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b5, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.graphics.Bitmap getNextFrame() {
        /*
            r9 = this;
            monitor-enter(r9)
            com.hpplay.glide.gifdecoder.GifHeader r0 = r9.header     // Catch:{ all -> 0x00b6 }
            int r0 = r0.frameCount     // Catch:{ all -> 0x00b6 }
            r1 = 3
            r2 = 1
            if (r0 <= 0) goto L_0x000d
            int r0 = r9.framePointer     // Catch:{ all -> 0x00b6 }
            if (r0 >= 0) goto L_0x0032
        L_0x000d:
            java.lang.String r0 = TAG     // Catch:{ all -> 0x00b6 }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00b6 }
            if (r0 == 0) goto L_0x0030
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b6 }
            r0.<init>()     // Catch:{ all -> 0x00b6 }
            java.lang.String r3 = "unable to decode frame, frameCount="
            r0.append(r3)     // Catch:{ all -> 0x00b6 }
            com.hpplay.glide.gifdecoder.GifHeader r3 = r9.header     // Catch:{ all -> 0x00b6 }
            int r3 = r3.frameCount     // Catch:{ all -> 0x00b6 }
            r0.append(r3)     // Catch:{ all -> 0x00b6 }
            java.lang.String r3 = " framePointer="
            r0.append(r3)     // Catch:{ all -> 0x00b6 }
            int r3 = r9.framePointer     // Catch:{ all -> 0x00b6 }
            r0.append(r3)     // Catch:{ all -> 0x00b6 }
        L_0x0030:
            r9.status = r2     // Catch:{ all -> 0x00b6 }
        L_0x0032:
            int r0 = r9.status     // Catch:{ all -> 0x00b6 }
            r3 = 0
            if (r0 == r2) goto L_0x009d
            r4 = 2
            if (r0 != r4) goto L_0x003b
            goto L_0x009d
        L_0x003b:
            r0 = 0
            r9.status = r0     // Catch:{ all -> 0x00b6 }
            com.hpplay.glide.gifdecoder.GifHeader r4 = r9.header     // Catch:{ all -> 0x00b6 }
            java.util.List<com.hpplay.glide.gifdecoder.GifFrame> r4 = r4.frames     // Catch:{ all -> 0x00b6 }
            int r5 = r9.framePointer     // Catch:{ all -> 0x00b6 }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ all -> 0x00b6 }
            com.hpplay.glide.gifdecoder.GifFrame r4 = (com.hpplay.glide.gifdecoder.GifFrame) r4     // Catch:{ all -> 0x00b6 }
            int r5 = r9.framePointer     // Catch:{ all -> 0x00b6 }
            int r5 = r5 - r2
            if (r5 < 0) goto L_0x005a
            com.hpplay.glide.gifdecoder.GifHeader r6 = r9.header     // Catch:{ all -> 0x00b6 }
            java.util.List<com.hpplay.glide.gifdecoder.GifFrame> r6 = r6.frames     // Catch:{ all -> 0x00b6 }
            java.lang.Object r5 = r6.get(r5)     // Catch:{ all -> 0x00b6 }
            com.hpplay.glide.gifdecoder.GifFrame r5 = (com.hpplay.glide.gifdecoder.GifFrame) r5     // Catch:{ all -> 0x00b6 }
            goto L_0x005b
        L_0x005a:
            r5 = r3
        L_0x005b:
            int[] r6 = r4.lct     // Catch:{ all -> 0x00b6 }
            if (r6 != 0) goto L_0x0066
            com.hpplay.glide.gifdecoder.GifHeader r6 = r9.header     // Catch:{ all -> 0x00b6 }
            int[] r6 = r6.gct     // Catch:{ all -> 0x00b6 }
            r9.act = r6     // Catch:{ all -> 0x00b6 }
            goto L_0x0072
        L_0x0066:
            r9.act = r6     // Catch:{ all -> 0x00b6 }
            com.hpplay.glide.gifdecoder.GifHeader r6 = r9.header     // Catch:{ all -> 0x00b6 }
            int r7 = r6.bgIndex     // Catch:{ all -> 0x00b6 }
            int r8 = r4.transIndex     // Catch:{ all -> 0x00b6 }
            if (r7 != r8) goto L_0x0072
            r6.bgColor = r0     // Catch:{ all -> 0x00b6 }
        L_0x0072:
            boolean r6 = r4.transparency     // Catch:{ all -> 0x00b6 }
            if (r6 == 0) goto L_0x007f
            int[] r6 = r9.act     // Catch:{ all -> 0x00b6 }
            int r7 = r4.transIndex     // Catch:{ all -> 0x00b6 }
            r8 = r6[r7]     // Catch:{ all -> 0x00b6 }
            r6[r7] = r0     // Catch:{ all -> 0x00b6 }
            r0 = r8
        L_0x007f:
            int[] r6 = r9.act     // Catch:{ all -> 0x00b6 }
            if (r6 != 0) goto L_0x008d
            java.lang.String r0 = TAG     // Catch:{ all -> 0x00b6 }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00b6 }
            r9.status = r2     // Catch:{ all -> 0x00b6 }
            monitor-exit(r9)
            return r3
        L_0x008d:
            android.graphics.Bitmap r1 = r9.setPixels(r4, r5)     // Catch:{ all -> 0x00b6 }
            boolean r2 = r4.transparency     // Catch:{ all -> 0x00b6 }
            if (r2 == 0) goto L_0x009b
            int[] r2 = r9.act     // Catch:{ all -> 0x00b6 }
            int r3 = r4.transIndex     // Catch:{ all -> 0x00b6 }
            r2[r3] = r0     // Catch:{ all -> 0x00b6 }
        L_0x009b:
            monitor-exit(r9)
            return r1
        L_0x009d:
            java.lang.String r0 = TAG     // Catch:{ all -> 0x00b6 }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00b6 }
            if (r0 == 0) goto L_0x00b4
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b6 }
            r0.<init>()     // Catch:{ all -> 0x00b6 }
            java.lang.String r1 = "Unable to decode frame, status="
            r0.append(r1)     // Catch:{ all -> 0x00b6 }
            int r1 = r9.status     // Catch:{ all -> 0x00b6 }
            r0.append(r1)     // Catch:{ all -> 0x00b6 }
        L_0x00b4:
            monitor-exit(r9)
            return r3
        L_0x00b6:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.glide.gifdecoder.GifDecoder.getNextFrame():android.graphics.Bitmap");
    }

    public int getStatus() {
        return this.status;
    }

    public int getWidth() {
        return this.header.width;
    }

    public int read(InputStream inputStream, int i10) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i10 > 0 ? i10 + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr, 0, 16384);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                read(byteArrayOutputStream.toByteArray());
            } catch (IOException unused) {
            }
        } else {
            this.status = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused2) {
            }
        }
        return this.status;
    }

    public void resetFrameIndex() {
        this.framePointer = -1;
    }

    public void setData(GifHeader gifHeader, byte[] bArr) {
        this.header = gifHeader;
        this.data = bArr;
        this.status = 0;
        this.framePointer = -1;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.rawData = wrap;
        wrap.rewind();
        this.rawData.order(ByteOrder.LITTLE_ENDIAN);
        this.savePrevious = false;
        Iterator<GifFrame> it = gifHeader.frames.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().dispose == 3) {
                    this.savePrevious = true;
                    break;
                }
            } else {
                break;
            }
        }
        int i10 = gifHeader.width;
        int i11 = gifHeader.height;
        this.mainPixels = new byte[(i10 * i11)];
        this.mainScratch = new int[(i10 * i11)];
    }

    public int read(byte[] bArr) {
        this.data = bArr;
        this.header = getHeaderParser().setData(bArr).parseHeader();
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.rawData = wrap;
            wrap.rewind();
            this.rawData.order(ByteOrder.LITTLE_ENDIAN);
            GifHeader gifHeader = this.header;
            int i10 = gifHeader.width;
            int i11 = gifHeader.height;
            this.mainPixels = new byte[(i10 * i11)];
            this.mainScratch = new int[(i10 * i11)];
            this.savePrevious = false;
            Iterator<GifFrame> it = gifHeader.frames.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().dispose == 3) {
                        this.savePrevious = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return this.status;
    }

    private int read() {
        try {
            return this.rawData.get() & UnsignedBytes.MAX_VALUE;
        } catch (Exception unused) {
            this.status = 1;
            return 0;
        }
    }
}
