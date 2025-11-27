package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import androidx.room.b;
import java.util.HashMap;

public class MultiInstanceInvalidationService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public int f3024a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap f3025b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final RemoteCallbackList f3026c = new a();

    /* renamed from: d  reason: collision with root package name */
    public final b.a f3027d = new b();

    public class a extends RemoteCallbackList {
        public a() {
        }

        /* renamed from: a */
        public void onCallbackDied(a aVar, Object obj) {
            MultiInstanceInvalidationService.this.f3025b.remove(Integer.valueOf(((Integer) obj).intValue()));
        }
    }

    public class b extends b.a {
        public b() {
        }

        public void b(int i10, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.f3026c) {
                String str = (String) MultiInstanceInvalidationService.this.f3025b.get(Integer.valueOf(i10));
                if (str != null) {
                    int beginBroadcast = MultiInstanceInvalidationService.this.f3026c.beginBroadcast();
                    int i11 = 0;
                    while (i11 < beginBroadcast) {
                        try {
                            int intValue = ((Integer) MultiInstanceInvalidationService.this.f3026c.getBroadcastCookie(i11)).intValue();
                            String str2 = (String) MultiInstanceInvalidationService.this.f3025b.get(Integer.valueOf(intValue));
                            if (i10 != intValue && str.equals(str2)) {
                                try {
                                    ((a) MultiInstanceInvalidationService.this.f3026c.getBroadcastItem(i11)).a(strArr);
                                } catch (RemoteException unused) {
                                }
                            }
                            i11++;
                        } catch (Throwable th) {
                            MultiInstanceInvalidationService.this.f3026c.finishBroadcast();
                            throw th;
                        }
                    }
                    MultiInstanceInvalidationService.this.f3026c.finishBroadcast();
                }
            }
        }

        public int d(a aVar, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.f3026c) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int i10 = multiInstanceInvalidationService.f3024a + 1;
                multiInstanceInvalidationService.f3024a = i10;
                if (multiInstanceInvalidationService.f3026c.register(aVar, Integer.valueOf(i10))) {
                    MultiInstanceInvalidationService.this.f3025b.put(Integer.valueOf(i10), str);
                    return i10;
                }
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.f3024a--;
                return 0;
            }
        }

        public void g0(a aVar, int i10) {
            synchronized (MultiInstanceInvalidationService.this.f3026c) {
                MultiInstanceInvalidationService.this.f3026c.unregister(aVar);
                MultiInstanceInvalidationService.this.f3025b.remove(Integer.valueOf(i10));
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return this.f3027d;
    }
}
