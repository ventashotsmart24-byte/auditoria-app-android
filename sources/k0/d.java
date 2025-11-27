package k0;

import android.media.session.MediaSessionManager;
import android.os.Build;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public e f7217a;

    public d(String str, int i10, int i11) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f7217a = new i(str, i10, i11);
        } else {
            this.f7217a = new j(str, i10, i11);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        return this.f7217a.equals(((d) obj).f7217a);
    }

    public int hashCode() {
        return this.f7217a.hashCode();
    }

    public d(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        this.f7217a = new i(remoteUserInfo);
    }
}
