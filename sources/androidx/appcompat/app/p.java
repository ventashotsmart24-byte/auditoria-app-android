package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import java.util.Calendar;
import p.m;

public class p {

    /* renamed from: d  reason: collision with root package name */
    public static p f755d;

    /* renamed from: a  reason: collision with root package name */
    public final Context f756a;

    /* renamed from: b  reason: collision with root package name */
    public final LocationManager f757b;

    /* renamed from: c  reason: collision with root package name */
    public final a f758c = new a();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f759a;

        /* renamed from: b  reason: collision with root package name */
        public long f760b;

        /* renamed from: c  reason: collision with root package name */
        public long f761c;

        /* renamed from: d  reason: collision with root package name */
        public long f762d;

        /* renamed from: e  reason: collision with root package name */
        public long f763e;

        /* renamed from: f  reason: collision with root package name */
        public long f764f;
    }

    public p(Context context, LocationManager locationManager) {
        this.f756a = context;
        this.f757b = locationManager;
    }

    public static p a(Context context) {
        if (f755d == null) {
            Context applicationContext = context.getApplicationContext();
            f755d = new p(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f755d;
    }

    public final Location b() {
        Location location;
        Location location2 = null;
        if (m.b(this.f756a, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            location = c("network");
        } else {
            location = null;
        }
        if (m.b(this.f756a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location2 = c("gps");
        }
        if (location2 == null || location == null) {
            if (location2 != null) {
                return location2;
            }
            return location;
        } else if (location2.getTime() > location.getTime()) {
            return location2;
        } else {
            return location;
        }
    }

    public final Location c(String str) {
        try {
            if (this.f757b.isProviderEnabled(str)) {
                return this.f757b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean d() {
        a aVar = this.f758c;
        if (e()) {
            return aVar.f759a;
        }
        Location b10 = b();
        if (b10 != null) {
            f(b10);
            return aVar.f759a;
        }
        int i10 = Calendar.getInstance().get(11);
        if (i10 < 6 || i10 >= 22) {
            return true;
        }
        return false;
    }

    public final boolean e() {
        if (this.f758c.f764f > System.currentTimeMillis()) {
            return true;
        }
        return false;
    }

    public final void f(Location location) {
        boolean z10;
        long j10;
        long j11;
        a aVar = this.f758c;
        long currentTimeMillis = System.currentTimeMillis();
        o b10 = o.b();
        o oVar = b10;
        oVar.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j12 = b10.f752a;
        oVar.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        if (b10.f754c == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        long j13 = b10.f753b;
        long j14 = b10.f752a;
        long j15 = j12;
        long j16 = j14;
        long j17 = 86400000 + currentTimeMillis;
        long j18 = j13;
        boolean z11 = z10;
        b10.a(j17, location.getLatitude(), location.getLongitude());
        long j19 = b10.f753b;
        if (j18 == -1 || j16 == -1) {
            j10 = 43200000 + currentTimeMillis;
        } else {
            if (currentTimeMillis > j16) {
                j11 = 0 + j19;
            } else if (currentTimeMillis > j18) {
                j11 = 0 + j16;
            } else {
                j11 = 0 + j18;
            }
            j10 = j11 + 60000;
        }
        aVar.f759a = z11;
        aVar.f760b = j15;
        aVar.f761c = j18;
        aVar.f762d = j16;
        aVar.f763e = j19;
        aVar.f764f = j10;
    }
}
