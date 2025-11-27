package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import y0.b;

public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(b bVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f1752a = (IconCompat) bVar.v(remoteActionCompat.f1752a, 1);
        remoteActionCompat.f1753b = bVar.l(remoteActionCompat.f1753b, 2);
        remoteActionCompat.f1754c = bVar.l(remoteActionCompat.f1754c, 3);
        remoteActionCompat.f1755d = (PendingIntent) bVar.r(remoteActionCompat.f1755d, 4);
        remoteActionCompat.f1756e = bVar.h(remoteActionCompat.f1756e, 5);
        remoteActionCompat.f1757f = bVar.h(remoteActionCompat.f1757f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, b bVar) {
        bVar.x(false, false);
        bVar.M(remoteActionCompat.f1752a, 1);
        bVar.D(remoteActionCompat.f1753b, 2);
        bVar.D(remoteActionCompat.f1754c, 3);
        bVar.H(remoteActionCompat.f1755d, 4);
        bVar.z(remoteActionCompat.f1756e, 5);
        bVar.z(remoteActionCompat.f1757f, 6);
    }
}
