package anet.channel.monitor;

class e {

    /* renamed from: a  reason: collision with root package name */
    private long f3767a = 0;

    /* renamed from: b  reason: collision with root package name */
    private double f3768b;

    /* renamed from: c  reason: collision with root package name */
    private double f3769c;

    /* renamed from: d  reason: collision with root package name */
    private double f3770d;

    /* renamed from: e  reason: collision with root package name */
    private double f3771e;

    /* renamed from: f  reason: collision with root package name */
    private double f3772f;

    /* renamed from: g  reason: collision with root package name */
    private double f3773g;

    /* renamed from: h  reason: collision with root package name */
    private double f3774h;

    /* renamed from: i  reason: collision with root package name */
    private double f3775i = 0.0d;

    /* renamed from: j  reason: collision with root package name */
    private double f3776j = 0.0d;

    /* renamed from: k  reason: collision with root package name */
    private double f3777k = 0.0d;

    public double a(double d10, double d11) {
        char c10;
        double d12 = d10 / d11;
        if (d12 >= 8.0d) {
            long j10 = this.f3767a;
            if (j10 == 0) {
                this.f3775i = d12;
                this.f3774h = d12;
                this.f3770d = d12 * 0.1d;
                this.f3769c = 0.02d * d12;
                this.f3771e = 0.1d * d12 * d12;
            } else if (j10 == 1) {
                this.f3776j = d12;
                this.f3774h = d12;
            } else {
                double d13 = this.f3776j;
                double d14 = d12 - d13;
                this.f3775i = d13;
                this.f3776j = d12;
                double d15 = d12 / 0.95d;
                this.f3768b = d15;
                this.f3773g = d15 - (this.f3774h * 0.95d);
                double sqrt = Math.sqrt(this.f3770d);
                double d16 = this.f3773g;
                if (d16 >= 4.0d * sqrt) {
                    this.f3773g = (d16 * 0.75d) + (sqrt * 2.0d);
                    c10 = 1;
                } else if (d16 <= -4.0d * sqrt) {
                    this.f3773g = (sqrt * -1.0d) + (d16 * 0.75d);
                    c10 = 2;
                } else {
                    c10 = 0;
                }
                double d17 = this.f3773g;
                double min = Math.min(Math.max(Math.abs((this.f3770d * 1.05d) - ((0.0025d * d17) * d17)), this.f3770d * 0.8d), this.f3770d * 1.25d);
                this.f3770d = min;
                double d18 = this.f3771e;
                double d19 = d18 / ((0.9025d * d18) + min);
                this.f3772f = d19;
                double d20 = this.f3774h + (1.0526315789473684d * d14) + (d19 * this.f3773g);
                this.f3774h = d20;
                if (c10 == 1) {
                    this.f3774h = Math.min(d20, this.f3768b);
                } else if (c10 == 2) {
                    this.f3774h = Math.max(d20, this.f3768b);
                }
                this.f3771e = (1.0d - (0.95d * this.f3772f)) * (this.f3771e + this.f3769c);
            }
            double d21 = this.f3774h;
            if (d21 < 0.0d) {
                double d22 = this.f3776j * 0.7d;
                this.f3777k = d22;
                this.f3774h = d22;
            } else {
                this.f3777k = d21;
            }
            return this.f3777k;
        } else if (this.f3767a != 0) {
            return this.f3777k;
        } else {
            this.f3777k = d12;
            return d12;
        }
    }

    public void a() {
        this.f3767a = 0;
        this.f3777k = 0.0d;
    }
}
