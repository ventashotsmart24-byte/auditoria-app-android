package com.taobao.accs.client;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.taobao.accs.IAgooAppReceiver;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.ILoginInfo;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.android.agoo.common.AgooConstants;

@Keep
public class GlobalClientInfo {
    public static final String AGOO_SERVICE_ID = "agooSend";

    /* renamed from: a  reason: collision with root package name */
    public static Context f12899a = null;

    /* renamed from: b  reason: collision with root package name */
    public static IAgooAppReceiver f12900b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f12901c = null;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f12902d = false;

    /* renamed from: e  reason: collision with root package name */
    private static final String f12903e = "com.taobao.accs.client.GlobalClientInfo";

    /* renamed from: f  reason: collision with root package name */
    private static volatile GlobalClientInfo f12904f;

    /* renamed from: l  reason: collision with root package name */
    private static Map<String, String> f12905l = new ConcurrentHashMap();

    /* renamed from: m  reason: collision with root package name */
    private static Map<String, Map<String, String>> f12906m = new ConcurrentHashMap();

    /* renamed from: g  reason: collision with root package name */
    private ConcurrentHashMap<String, ILoginInfo> f12907g;

    /* renamed from: h  reason: collision with root package name */
    private ConcurrentHashMap<String, IAppReceiver> f12908h;

    /* renamed from: i  reason: collision with root package name */
    private ActivityManager f12909i;

    /* renamed from: j  reason: collision with root package name */
    private ConnectivityManager f12910j;

    /* renamed from: k  reason: collision with root package name */
    private PackageInfo f12911k;

    /* renamed from: n  reason: collision with root package name */
    private Map<String, AccsDataListener> f12912n = new ConcurrentHashMap();

    static {
        f12905l.put(AGOO_SERVICE_ID, "org.android.agoo.accs.AgooService");
        f12905l.put(AgooConstants.AGOO_SERVICE_AGOOACK, "org.android.agoo.accs.AgooService");
        f12905l.put("agooTokenReport", "org.android.agoo.accs.AgooService");
    }

    private GlobalClientInfo(Context context) {
        Context context2 = getContext();
        f12899a = context2;
        if (context2 == null && context != null) {
            f12899a = context.getApplicationContext();
        }
        ThreadPoolExecutorFactory.execute(new c(this));
    }

    private void a(String str, Map<String, String> map) {
        if (map != null) {
            if (f12906m.get(str) == null) {
                f12906m.put(str, new ConcurrentHashMap());
            }
            f12906m.get(str).putAll(map);
        }
    }

    public static Context getContext() {
        return f12899a;
    }

    @Keep
    public static GlobalClientInfo getInstance(Context context) {
        if (f12904f == null) {
            synchronized (GlobalClientInfo.class) {
                if (f12904f == null) {
                    f12904f = new GlobalClientInfo(context);
                }
            }
        }
        return f12904f;
    }

    public void clearLoginInfoImpl() {
        this.f12907g = null;
    }

    public ActivityManager getActivityManager() {
        if (this.f12909i == null) {
            this.f12909i = (ActivityManager) f12899a.getSystemService("activity");
        }
        return this.f12909i;
    }

    public Map<String, String> getAllService(String str) {
        if (f12906m.get(str) == null || f12906m.get(str).isEmpty()) {
            return null;
        }
        return f12906m.get(str);
    }

    public Map<String, IAppReceiver> getAppReceiver() {
        return this.f12908h;
    }

    public ConnectivityManager getConnectivityManager() {
        if (this.f12910j == null) {
            this.f12910j = (ConnectivityManager) f12899a.getSystemService("connectivity");
        }
        return this.f12910j;
    }

    public AccsDataListener getListener(String str) {
        return this.f12912n.get(str);
    }

    public String getNick(String str) {
        ILoginInfo iLoginInfo;
        ConcurrentHashMap<String, ILoginInfo> concurrentHashMap = this.f12907g;
        if (concurrentHashMap == null || (iLoginInfo = concurrentHashMap.get(str)) == null) {
            return null;
        }
        return iLoginInfo.getNick();
    }

    public PackageInfo getPackageInfo() {
        try {
            if (this.f12911k == null) {
                this.f12911k = f12899a.getPackageManager().getPackageInfo(f12899a.getPackageName(), 0);
            }
        } catch (Throwable th) {
            ALog.e("GlobalClientInfo", "getPackageInfo", th, new Object[0]);
        }
        return this.f12911k;
    }

    public String getService(String str) {
        return f12905l.get(str);
    }

    public String getSid(String str) {
        ILoginInfo iLoginInfo;
        ConcurrentHashMap<String, ILoginInfo> concurrentHashMap = this.f12907g;
        if (concurrentHashMap == null || (iLoginInfo = concurrentHashMap.get(str)) == null) {
            return null;
        }
        return iLoginInfo.getSid();
    }

    public String getUserId(String str) {
        ILoginInfo iLoginInfo;
        ConcurrentHashMap<String, ILoginInfo> concurrentHashMap = this.f12907g;
        if (concurrentHashMap == null || (iLoginInfo = concurrentHashMap.get(str)) == null) {
            return null;
        }
        return iLoginInfo.getUserId();
    }

    public void registerAllRemoteService(String str, Map<String, String> map) {
        if (f12906m.get(str) == null) {
            f12906m.put(str, new ConcurrentHashMap());
        }
        f12906m.get(str).putAll(map);
    }

    public void registerListener(String str, AccsAbstractDataListener accsAbstractDataListener) {
        registerListener(str, (AccsDataListener) accsAbstractDataListener);
    }

    @Keep
    public void registerRemoteListener(String str, AccsDataListener accsDataListener) {
        this.f12912n.put(str, accsDataListener);
    }

    public void registerRemoteService(String str, String str2) {
        f12905l.put(str, str2);
    }

    public void registerService(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            f12905l.put(str, str2);
        }
    }

    public void setAppReceiver(String str, IAppReceiver iAppReceiver) {
        if (iAppReceiver == null) {
            return;
        }
        if (iAppReceiver instanceof IAgooAppReceiver) {
            f12900b = (IAgooAppReceiver) iAppReceiver;
            return;
        }
        if (this.f12908h == null) {
            this.f12908h = new ConcurrentHashMap<>(2);
        }
        this.f12908h.put(str, iAppReceiver);
        a(str, iAppReceiver.getAllServices());
    }

    public void setLoginInfoImpl(String str, ILoginInfo iLoginInfo) {
        if (this.f12907g == null) {
            this.f12907g = new ConcurrentHashMap<>(1);
        }
        if (iLoginInfo != null) {
            this.f12907g.put(str, iLoginInfo);
        }
    }

    @Keep
    public void setRemoteAgooAppReceiver(IAgooAppReceiver iAgooAppReceiver) {
        f12900b = iAgooAppReceiver;
    }

    @Keep
    public void setRemoteAppReceiver(String str, IAppReceiver iAppReceiver) {
        if (this.f12908h == null) {
            this.f12908h = new ConcurrentHashMap<>(2);
        }
        this.f12908h.put(str, iAppReceiver);
        a(str, iAppReceiver.getAllServices());
    }

    public void unRegisterService(String str) {
        if (!TextUtils.isEmpty(str)) {
            f12905l.remove(str);
        }
    }

    public void unregisterListener(String str) {
        this.f12912n.remove(str);
    }

    public void unregisterRemoteListener(String str) {
        this.f12912n.remove(str);
    }

    public void unregisterRemoteService(String str) {
        f12905l.remove(str);
    }

    public String getService(String str, String str2) {
        if (f12906m.get(str) != null) {
            return (String) f12906m.get(str).get(str2);
        }
        return null;
    }

    public void registerListener(String str, AccsDataListener accsDataListener) {
        if (!TextUtils.isEmpty(str) && accsDataListener != null) {
            this.f12912n.put(str, accsDataListener);
        }
    }
}
