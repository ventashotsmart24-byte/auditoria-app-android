package anet.channel.monitor;

import anet.channel.util.ALog;

class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f3763a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ long f3764b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ long f3765c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ b f3766d;

    public d(b bVar, long j10, long j11, long j12) {
        this.f3766d = bVar;
        this.f3763a = j10;
        this.f3764b = j11;
        this.f3765c = j12;
    }

    public void run() {
        b.f3747a++;
        b.f3751e += this.f3763a;
        if (b.f3747a == 1) {
            b.f3750d = this.f3764b - this.f3765c;
        }
        int i10 = b.f3747a;
        if (i10 >= 2 && i10 <= 3) {
            long j10 = this.f3765c;
            long j11 = b.f3749c;
            if (j10 >= j11) {
                b.f3750d += this.f3764b - j10;
            } else if (j10 < j11) {
                long j12 = this.f3764b;
                if (j12 >= j11) {
                    long j13 = b.f3750d + (j12 - j10);
                    b.f3750d = j13;
                    b.f3750d = j13 - (b.f3749c - j10);
                }
            }
        }
        b.f3748b = this.f3765c;
        b.f3749c = this.f3764b;
        if (b.f3747a == 3) {
            b.f3755i = (double) ((long) this.f3766d.f3760n.a((double) b.f3751e, (double) b.f3750d));
            b.f3752f++;
            b.b(this.f3766d);
            if (b.f3752f > 30) {
                this.f3766d.f3760n.a();
                b.f3752f = 3;
            }
            double d10 = (b.f3755i * 0.68d) + (b.f3754h * 0.27d) + (b.f3753g * 0.05d);
            b.f3753g = b.f3754h;
            b.f3754h = b.f3755i;
            if (b.f3755i < b.f3753g * 0.65d || b.f3755i > b.f3753g * 2.0d) {
                b.f3755i = d10;
            }
            int i11 = 5;
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.BandWidthSampler", "NetworkSpeed", (String) null, "mKalmanDataSize", Long.valueOf(b.f3751e), "mKalmanTimeUsed", Long.valueOf(b.f3750d), "speed", Double.valueOf(b.f3755i), "mSpeedKalmanCount", Long.valueOf(b.f3752f));
            }
            if (this.f3766d.f3759m > 5 || b.f3752f == 2) {
                a.a().a(b.f3755i);
                int unused = this.f3766d.f3759m = 0;
                b bVar = this.f3766d;
                if (b.f3755i < b.f3756j) {
                    i11 = 1;
                }
                int unused2 = bVar.f3758l = i11;
                ALog.i("awcn.BandWidthSampler", "NetworkSpeed notification!", (String) null, "Send Network quality notification.");
            }
            b.f3750d = 0;
            b.f3751e = 0;
            b.f3747a = 0;
        }
    }
}
