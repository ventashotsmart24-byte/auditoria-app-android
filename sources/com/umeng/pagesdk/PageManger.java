package com.umeng.pagesdk;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.efs.sdk.base.EfsReporter;

public class PageManger {
    public static final String TAG = "PageManger";

    /* renamed from: a  reason: collision with root package name */
    private static Context f16129a = null;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f16130b = false;

    /* renamed from: c  reason: collision with root package name */
    private static EfsReporter f16131c = null;

    /* renamed from: d  reason: collision with root package name */
    private static PageConfigManger f16132d = null;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f16133e = true;

    /* renamed from: f  reason: collision with root package name */
    private static float f16134f = 0.0f;
    public static boolean isDebug = true;

    public static Context getApplicationContext() {
        return f16129a;
    }

    public static PageConfigManger getPageConfigManger() {
        return f16132d;
    }

    public static float getRefreshRate() {
        return f16134f;
    }

    public static EfsReporter getReporter() {
        return f16131c;
    }

    public static void init(Context context, EfsReporter efsReporter) {
        if (context == null || efsReporter == null) {
            try {
                if (isDebug) {
                    Log.e(TAG, "init page manager error! parameter is null!");
                    return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (!isInit()) {
            f16129a = context.getApplicationContext();
            f16131c = efsReporter;
            f16132d = new PageConfigManger(context, efsReporter);
            f16130b = true;
        } else if (isDebug) {
            Log.e(TAG, "invalid init ！");
        }
    }

    public static boolean isControlMainThread() {
        return f16133e;
    }

    public static boolean isInit() {
        return f16130b;
    }

    public static void onTracePageBegin(Activity activity, String str) {
        try {
            onTracePageBegin(activity, str, false);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void onTracePageEnd(Activity activity, String str) {
        try {
            onTracePageEnd(activity, str, false);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setControlMainThread(boolean z10) {
        f16133e = z10;
    }

    public static void onTracePageBegin(Activity activity, String str, boolean z10) {
        if (activity != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (z10 || (!str.equals("onCreate") && !str.equals("onStart") && !str.equals("onResume") && !str.equals("onPause"))) {
                        if (str.length() <= 10) {
                            if (f16133e && !e.a(activity.getApplicationContext()) && isDebug) {
                                Log.e(TAG, "tracePageBegin. Non main process !");
                            }
                            String name = activity.getClass().getName();
                            if (f16134f <= 0.0f) {
                                f16134f = Build.VERSION.SDK_INT >= 30 ? activity.getDisplay().getRefreshRate() : activity.getWindowManager().getDefaultDisplay().getRefreshRate();
                            }
                            d.a(name, str, z10);
                            return;
                        } else if (isDebug) {
                            Log.e(TAG, "tracePageBegin. method name is " + str + "method name over length !");
                            return;
                        } else {
                            return;
                        }
                    } else if (isDebug) {
                        Log.e(TAG, "tracePageBegin. parameter illegality!");
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
            Log.e(TAG, "tracePageBegin. parameter null!");
        }
    }

    public static void onTracePageEnd(Activity activity, String str, boolean z10) {
        if (activity != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (z10 || (!str.equals("onCreate") && !str.equals("onStart") && !str.equals("onResume") && !str.equals("onPause"))) {
                        if (str.length() <= 10) {
                            if (f16133e && !e.a(activity.getApplicationContext()) && isDebug) {
                                Log.e(TAG, "tracePageBegin. Non main process !");
                            }
                            d.b(activity.getClass().getName(), str, z10);
                            return;
                        } else if (isDebug) {
                            Log.e(TAG, "tracePageEnd. method name is " + str + "method name over length !");
                            return;
                        } else {
                            return;
                        }
                    } else if (isDebug) {
                        Log.e(TAG, "tracePageEnd. parameter illegality!");
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
            Log.e(TAG, "tracePageEnd. parameter null!");
        }
    }
}
