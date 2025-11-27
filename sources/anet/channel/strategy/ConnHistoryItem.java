package anet.channel.strategy;

import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.common.primitives.UnsignedBytes;
import java.io.Serializable;

class ConnHistoryItem implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    byte f3878a = 0;

    /* renamed from: b  reason: collision with root package name */
    long f3879b = 0;

    /* renamed from: c  reason: collision with root package name */
    long f3880c = 0;

    public void a(boolean z10) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - (z10 ? this.f3879b : this.f3880c) > NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS) {
            this.f3878a = (this.f3878a << 1) | (z10 ^ true) ? (byte) 1 : 0;
            if (z10) {
                this.f3879b = currentTimeMillis;
            } else {
                this.f3880c = currentTimeMillis;
            }
        }
    }

    public boolean b() {
        if ((this.f3878a & 1) == 1) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (a() >= 3 && System.currentTimeMillis() - this.f3880c <= 300000) {
            return true;
        }
        return false;
    }

    public boolean d() {
        long j10 = this.f3879b;
        long j11 = this.f3880c;
        if (j10 <= j11) {
            j10 = j11;
        }
        if (j10 == 0 || System.currentTimeMillis() - j10 <= 86400000) {
            return false;
        }
        return true;
    }

    public int a() {
        int i10 = 0;
        for (int i11 = this.f3878a & UnsignedBytes.MAX_VALUE; i11 > 0; i11 >>= 1) {
            i10 += i11 & 1;
        }
        return i10;
    }
}
