package com.hpplay.sdk.source.pass.sinktouch;

import java.util.Arrays;

class EventBytes {
    private static final int MAX_LEN = 128;
    private byte[] mBuffer = new byte[128];
    private int mCurrentLen = 0;

    /* JADX WARNING: Removed duplicated region for block: B:6:0x001a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int append(byte[] r7, int r8, int r9) {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            int r2 = r6.mCurrentLen
            r3 = 4
            if (r2 >= r3) goto L_0x0018
            if (r1 >= r9) goto L_0x0018
            byte[] r3 = r6.mBuffer
            int r4 = r8 + r1
            byte r4 = r7[r4]
            r3[r2] = r4
            int r2 = r2 + 1
            r6.mCurrentLen = r2
            int r1 = r1 + 1
            goto L_0x0002
        L_0x0018:
            if (r2 >= r3) goto L_0x001b
            return r0
        L_0x001b:
            byte[] r3 = r6.mBuffer
            r4 = 3
            byte r4 = r3[r4]
            int r5 = r2 + -4
            int r4 = r4 - r5
            int r8 = r8 + r1
            int r9 = r9 - r1
            if (r9 >= 0) goto L_0x0028
            return r0
        L_0x0028:
            if (r4 < r9) goto L_0x0033
            java.lang.System.arraycopy(r7, r8, r3, r2, r9)
            int r7 = r6.mCurrentLen
            int r7 = r7 + r9
            r6.mCurrentLen = r7
            return r0
        L_0x0033:
            java.lang.System.arraycopy(r7, r8, r3, r2, r4)
            int r7 = r6.mCurrentLen
            int r7 = r7 + r4
            r6.mCurrentLen = r7
            int r9 = r9 - r4
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.pass.sinktouch.EventBytes.append(byte[], int, int):int");
    }

    public byte[] getData() {
        return Arrays.copyOf(this.mBuffer, this.mCurrentLen);
    }

    public boolean isFillUp() {
        int i10 = this.mCurrentLen;
        if (i10 >= 4 && this.mBuffer[3] == i10 - 4) {
            return true;
        }
        return false;
    }

    public void reset() {
        Arrays.fill(this.mBuffer, (byte) 0);
        this.mCurrentLen = 0;
    }
}
