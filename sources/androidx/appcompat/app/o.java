package androidx.appcompat.app;

public class o {

    /* renamed from: d  reason: collision with root package name */
    public static o f751d;

    /* renamed from: a  reason: collision with root package name */
    public long f752a;

    /* renamed from: b  reason: collision with root package name */
    public long f753b;

    /* renamed from: c  reason: collision with root package name */
    public int f754c;

    public static o b() {
        if (f751d == null) {
            f751d = new o();
        }
        return f751d;
    }

    public void a(long j10, double d10, double d11) {
        float f10 = ((float) (j10 - 946728000000L)) / 8.64E7f;
        float f11 = (0.01720197f * f10) + 6.24006f;
        double d12 = (double) f11;
        Double.isNaN(d12);
        double sin = (Math.sin(d12) * 0.03341960161924362d) + d12 + (Math.sin((double) (2.0f * f11)) * 3.4906598739326E-4d) + (Math.sin((double) (f11 * 3.0f)) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double d13 = (-d11) / 360.0d;
        double d14 = (double) (f10 - 9.0E-4f);
        Double.isNaN(d14);
        double round = (double) (((float) Math.round(d14 - d13)) + 9.0E-4f);
        Double.isNaN(round);
        double sin2 = round + d13 + (Math.sin(d12) * 0.0053d) + (Math.sin(2.0d * sin) * -0.0069d);
        double asin = Math.asin(Math.sin(sin) * Math.sin(0.4092797040939331d));
        double d15 = 0.01745329238474369d * d10;
        double sin3 = (Math.sin(-0.10471975803375244d) - (Math.sin(d15) * Math.sin(asin))) / (Math.cos(d15) * Math.cos(asin));
        if (sin3 >= 1.0d) {
            this.f754c = 1;
            this.f752a = -1;
            this.f753b = -1;
        } else if (sin3 <= -1.0d) {
            this.f754c = 0;
            this.f752a = -1;
            this.f753b = -1;
        } else {
            double acos = (double) ((float) (Math.acos(sin3) / 6.283185307179586d));
            Double.isNaN(acos);
            this.f752a = Math.round((sin2 + acos) * 8.64E7d) + 946728000000L;
            Double.isNaN(acos);
            long round2 = Math.round((sin2 - acos) * 8.64E7d) + 946728000000L;
            this.f753b = round2;
            if (round2 >= j10 || this.f752a <= j10) {
                this.f754c = 1;
            } else {
                this.f754c = 0;
            }
        }
    }
}
