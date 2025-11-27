package anet.channel;

import android.text.TextUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class c {

    /* renamed from: a  reason: collision with root package name */
    Map<String, Integer> f3632a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    Map<String, SessionInfo> f3633b = new ConcurrentHashMap();

    public void a(SessionInfo sessionInfo) {
        if (sessionInfo == null) {
            throw new NullPointerException("info is null");
        } else if (!TextUtils.isEmpty(sessionInfo.host)) {
            this.f3633b.put(sessionInfo.host, sessionInfo);
        } else {
            throw new IllegalArgumentException("host cannot be null or empty");
        }
    }

    public SessionInfo b(String str) {
        return this.f3633b.get(str);
    }

    public int c(String str) {
        Integer num;
        synchronized (this.f3632a) {
            num = this.f3632a.get(str);
        }
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public SessionInfo a(String str) {
        return this.f3633b.remove(str);
    }

    public Collection<SessionInfo> a() {
        return this.f3633b.values();
    }

    public void a(String str, int i10) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f3632a) {
                this.f3632a.put(str, Integer.valueOf(i10));
            }
            return;
        }
        throw new IllegalArgumentException("host cannot be null or empty");
    }
}
