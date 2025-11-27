package com.efs.sdk.launch;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.efs.sdk.base.EfsReporter;

public class LaunchManager {
    public static final String APP_ATTACH_BASE_CONTEXT = "app_attachBaseContext";
    public static final String APP_CONSTRUCT = "app_<init>";
    public static final String APP_ON_CREATE = "app_onCreate";
    public static final String PAGE_ON_CREATE = "page_onCreate";
    public static final String PAGE_ON_RESUME = "page_onResume";
    public static final String PAGE_ON_RE_START = "page_onReStart";
    public static final String PAGE_ON_START = "page_onStart";
    public static final String PAGE_ON_STOP = "page_onStop";
    public static final String PAGE_ON_WINDOW = "page_on_window";
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static LaunchConfigManager f5351a = null;

    /* renamed from: b  reason: collision with root package name */
    private static Context f5352b = null;

    /* renamed from: c  reason: collision with root package name */
    private static EfsReporter f5353c = null;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static boolean f5354d = false;
    public static boolean isDebug = true;

    public static LaunchConfigManager getLaunchConfigManager() {
        return f5351a;
    }

    public static EfsReporter getReporter() {
        return f5353c;
    }

    public static void init(Context context, final EfsReporter efsReporter) {
        if (context == null || efsReporter == null) {
            try {
                if (isDebug) {
                    Log.e("LaunchManager", "init launch manager error! parameter is null!");
                    return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        final Context applicationContext = context.getApplicationContext();
        if (!c.e(applicationContext)) {
            if (isDebug) {
                Log.e("LaunchManager", "Non main process !");
            }
        } else if (!isInit()) {
            f5352b = context.getApplicationContext();
            f5353c = efsReporter;
            a.a(new Runnable() {
                public final void run() {
                    try {
                        LaunchConfigManager unused = LaunchManager.f5351a = new LaunchConfigManager(applicationContext, efsReporter);
                        boolean unused2 = LaunchManager.f5354d = true;
                        b.a(applicationContext, (String) null);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } else if (isDebug) {
            Log.e("LaunchManager", "invalid init ！");
        }
    }

    public static boolean isInit() {
        return f5354d;
    }

    public static void onTraceApp(Application application, String str, boolean z10) {
        if (application != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (str.equals(APP_ATTACH_BASE_CONTEXT) || Looper.getMainLooper() == Looper.myLooper()) {
                        b.a(str, z10);
                        return;
                    } else if (isDebug) {
                        Log.e("LaunchManager", "Non main thread ！");
                        return;
                    } else {
                        return;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (isDebug) {
            Log.e("LaunchManager", "--->>> onTrace parameter is Illegal !");
        }
    }

    public static void onTraceBegin(Context context, String str, long j10) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    context.getApplicationContext();
                    if (Looper.getMainLooper() != Looper.myLooper()) {
                        if (isDebug) {
                            Log.e("LaunchManager", "Non main thread ！");
                            return;
                        }
                        return;
                    } else if (str.length() <= 10) {
                        b.a(str, j10);
                        return;
                    } else if (isDebug) {
                        Log.e("LaunchManager", "--->>> method name over length !");
                        return;
                    } else {
                        return;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (isDebug) {
            Log.e("LaunchManager", "--->>> onTraceBegin parameter is Illegal !");
        }
    }

    public static void onTraceEnd(Context context, String str, long j10) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    context.getApplicationContext();
                    if (Looper.getMainLooper() != Looper.myLooper()) {
                        if (isDebug) {
                            Log.e("LaunchManager", "Non main thread ！");
                            return;
                        }
                        return;
                    } else if (str.length() <= 10) {
                        b.b(str, j10);
                        return;
                    } else if (isDebug) {
                        Log.e("LaunchManager", "--->>> method name over length !");
                        return;
                    } else {
                        return;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (isDebug) {
            Log.e("LaunchManager", "--->>> onTraceBegin parameter is Illegal !");
        }
    }

    public static void onTracePage(Activity activity, String str, boolean z10) {
        if (activity != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    activity.getApplicationContext();
                    if (Looper.getMainLooper() == Looper.myLooper()) {
                        b.a(activity, str, z10);
                        return;
                    } else if (isDebug) {
                        Log.e("LaunchManager", "Non main thread ！");
                        return;
                    } else {
                        return;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (isDebug) {
            Log.e("LaunchManager", "--->>> onTrace parameter is Illegal !");
        }
    }

    public static void sendLaunchCache(Context context, String str) {
        if (context != null && str != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    b.a(context, str);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
