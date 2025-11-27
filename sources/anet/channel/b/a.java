package anet.channel.b;

import androidx.appcompat.app.m;
import anet.channel.util.ALog;
import anet.channel.util.StringUtils;
import com.hpplay.logwriter.b;
import com.taobao.alivfssdk.cache.AVFSCache;
import com.taobao.alivfssdk.cache.AVFSCacheConfig;
import com.taobao.alivfssdk.cache.AVFSCacheManager;
import com.taobao.alivfssdk.cache.IAVFSCache;
import n1.a;

public class a implements n1.a {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f3623a = false;

    /* renamed from: b  reason: collision with root package name */
    private static Object f3624b;

    /* renamed from: c  reason: collision with root package name */
    private static Object f3625c;

    /* renamed from: d  reason: collision with root package name */
    private static Object f3626d;

    static {
        try {
            Class.forName("com.taobao.alivfssdk.cache.AVFSCacheManager");
            f3624b = new b();
            f3625c = new c();
            f3626d = new d();
        } catch (ClassNotFoundException unused) {
            ALog.w("anet.AVFSCacheImpl", "no alivfs sdk!", (String) null, new Object[0]);
        }
    }

    private IAVFSCache b() {
        AVFSCache cacheForModule = AVFSCacheManager.getInstance().cacheForModule("networksdk.httpcache");
        if (cacheForModule != null) {
            return cacheForModule.getFileCache();
        }
        return null;
    }

    public void a() {
        AVFSCache cacheForModule;
        if (f3623a && (cacheForModule = AVFSCacheManager.getInstance().cacheForModule("networksdk.httpcache")) != null) {
            AVFSCacheConfig aVFSCacheConfig = new AVFSCacheConfig();
            aVFSCacheConfig.limitSize = Long.valueOf(b.f10579a);
            aVFSCacheConfig.fileMemMaxSize = 1048576;
            cacheForModule.moduleConfig(aVFSCacheConfig);
        }
    }

    public void clear() {
        if (f3623a) {
            try {
                IAVFSCache b10 = b();
                if (b10 != null) {
                    b10.removeAllObject((IAVFSCache.OnAllObjectRemoveCallback) f3626d);
                }
            } catch (Exception e10) {
                ALog.e("anet.AVFSCacheImpl", "clear cache failed", (String) null, e10, new Object[0]);
            }
        }
    }

    public a.C0106a get(String str) {
        if (!f3623a) {
            return null;
        }
        try {
            IAVFSCache b10 = b();
            if (b10 != null) {
                m.a(b10.objectForKey(StringUtils.md5ToHex(str)));
                return null;
            }
        } catch (Exception e10) {
            ALog.e("anet.AVFSCacheImpl", "get cache failed", (String) null, e10, new Object[0]);
        }
        return null;
    }

    public void put(String str, a.C0106a aVar) {
        if (f3623a) {
            try {
                IAVFSCache b10 = b();
                if (b10 != null) {
                    b10.setObjectForKey(StringUtils.md5ToHex(str), aVar, (IAVFSCache.OnObjectSetCallback) f3624b);
                }
            } catch (Exception e10) {
                ALog.e("anet.AVFSCacheImpl", "put cache failed", (String) null, e10, new Object[0]);
            }
        }
    }

    public void remove(String str) {
        if (f3623a) {
            try {
                IAVFSCache b10 = b();
                if (b10 != null) {
                    b10.removeObjectForKey(StringUtils.md5ToHex(str), (IAVFSCache.OnObjectRemoveCallback) f3625c);
                }
            } catch (Exception e10) {
                ALog.e("anet.AVFSCacheImpl", "remove cache failed", (String) null, e10, new Object[0]);
            }
        }
    }
}
