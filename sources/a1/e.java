package a1;

import android.app.Notification;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final int f108a;

    /* renamed from: b  reason: collision with root package name */
    public final int f109b;

    /* renamed from: c  reason: collision with root package name */
    public final Notification f110c;

    public e(int i10, Notification notification, int i11) {
        this.f108a = i10;
        this.f110c = notification;
        this.f109b = i11;
    }

    public int a() {
        return this.f109b;
    }

    public Notification b() {
        return this.f110c;
    }

    public int c() {
        return this.f108a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f108a == eVar.f108a && this.f109b == eVar.f109b) {
            return this.f110c.equals(eVar.f110c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f108a * 31) + this.f109b) * 31) + this.f110c.hashCode();
    }

    public String toString() {
        return "ForegroundInfo{" + "mNotificationId=" + this.f108a + ", mForegroundServiceType=" + this.f109b + ", mNotification=" + this.f110c + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
