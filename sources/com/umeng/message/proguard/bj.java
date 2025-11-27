package com.umeng.message.proguard;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.umeng.message.api.UPushThirdTokenCallback;
import com.umeng.message.common.UPLog;

public final class bj {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static Boolean f15512a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static int f15513b;

    /* renamed from: c  reason: collision with root package name */
    private static final Handler f15514c = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            int i10 = message.what;
            if (1 == i10) {
                bj.a(message.arg1);
                removeMessages(2);
                Message obtainMessage = obtainMessage(2);
                obtainMessage.obj = message.obj;
                message.obj = null;
                sendMessageDelayed(obtainMessage, 500);
            } else if (2 == i10) {
                final int b10 = bj.f15513b;
                int unused = bj.f15513b = 0;
                final Context context = (Context) message.obj;
                message.obj = null;
                if (context != null) {
                    b.c(new Runnable() {
                        public final void run() {
                            String str;
                            int i10;
                            if (bj.f15512a == null || bj.f15512a.booleanValue()) {
                                try {
                                    ComponentName a10 = bj.a(context);
                                    if (a10 == null) {
                                        Boolean unused = bj.f15512a = Boolean.FALSE;
                                        return;
                                    }
                                    Uri parse = Uri.parse("content://com.huawei.android.launcher.settings/badge/");
                                    try {
                                        str = context.getContentResolver().getType(parse);
                                    } catch (Throwable unused2) {
                                        str = null;
                                    }
                                    if (TextUtils.isEmpty(str)) {
                                        parse = Uri.parse("content://com.hihonor.android.launcher.settings/badge/");
                                        str = context.getContentResolver().getType(parse);
                                    }
                                    if (str == null) {
                                        Boolean unused3 = bj.f15512a = Boolean.FALSE;
                                        return;
                                    }
                                    UPLog.i("Badge", "hw changeBadgeNum:", Integer.valueOf(b10));
                                    Bundle bundle = new Bundle();
                                    bundle.putString(Constants.KEY_PACKAGE, a10.getPackageName());
                                    bundle.putString(Name.LABEL, a10.getClassName());
                                    Bundle call = context.getContentResolver().call(parse, "getbadgeNumber", (String) null, bundle);
                                    if (call != null) {
                                        i10 = call.getInt("badgenumber", 0);
                                    } else {
                                        i10 = 0;
                                    }
                                    int max = Math.max(0, b10 + i10);
                                    if (i10 != max) {
                                        bundle.putInt("badgenumber", max);
                                        context.getContentResolver().call(parse, "change_badge", (String) null, bundle);
                                    }
                                    UPLog.i("Badge", "hw changeBadgeNum cur:", Integer.valueOf(max), "last:", Integer.valueOf(i10));
                                    Boolean unused4 = bj.f15512a = Boolean.TRUE;
                                } catch (Throwable unused5) {
                                    Boolean unused6 = bj.f15512a = Boolean.FALSE;
                                }
                            }
                        }
                    });
                }
            }
        }
    };

    public static /* synthetic */ int a(int i10) {
        int i11 = f15513b + i10;
        f15513b = i11;
        return i11;
    }

    public static void b(Context context, int i10) {
        Boolean bool = f15512a;
        if (bool == null || bool.booleanValue()) {
            String str = Build.MANUFACTURER;
            if ("huawei".equalsIgnoreCase(str) || UPushThirdTokenCallback.TYPE_HONOR.equalsIgnoreCase(str)) {
                Handler handler = f15514c;
                Message obtainMessage = handler.obtainMessage(1);
                obtainMessage.arg1 = i10;
                obtainMessage.obj = context;
                handler.sendMessage(obtainMessage);
            }
        }
    }

    public static void a(final Context context, final int i10) {
        Boolean bool = f15512a;
        if (bool == null || bool.booleanValue()) {
            String str = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str)) {
                if ("oppo".equalsIgnoreCase(str)) {
                    b.b(new Runnable() {
                        public final void run() {
                            if (bj.f15512a == null || bj.f15512a.booleanValue()) {
                                try {
                                    Bundle bundle = new Bundle();
                                    bundle.putInt("app_badge_count", i10);
                                    context.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", (String) null, bundle);
                                    UPLog.i("Badge", "oppo setBadgeNum:", Integer.valueOf(i10));
                                    Boolean unused = bj.f15512a = Boolean.TRUE;
                                } catch (Throwable unused2) {
                                    Boolean unused3 = bj.f15512a = Boolean.FALSE;
                                }
                            }
                        }
                    });
                } else if ("vivo".equalsIgnoreCase(str)) {
                    b.b(new Runnable() {
                        public final void run() {
                            if (bj.f15512a == null || bj.f15512a.booleanValue()) {
                                try {
                                    ComponentName a10 = bj.a(context);
                                    if (a10 == null) {
                                        Boolean unused = bj.f15512a = Boolean.FALSE;
                                        return;
                                    }
                                    Intent intent = new Intent();
                                    intent.setAction("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
                                    intent.putExtra(Constants.KEY_PACKAGE_NAME, a10.getPackageName());
                                    intent.putExtra("className", a10.getClassName());
                                    intent.putExtra("notificationNum", i10);
                                    if (Build.VERSION.SDK_INT >= 26) {
                                        intent.addFlags(16777216);
                                    }
                                    context.sendBroadcast(intent);
                                    UPLog.i("Badge", "vivo setBadgeNum:", Integer.valueOf(i10));
                                    Boolean unused2 = bj.f15512a = Boolean.TRUE;
                                } catch (Throwable unused3) {
                                    Boolean unused4 = bj.f15512a = Boolean.FALSE;
                                }
                            }
                        }
                    });
                } else if ("huawei".equalsIgnoreCase(str) || UPushThirdTokenCallback.TYPE_HONOR.equalsIgnoreCase(str)) {
                    b.b(new Runnable() {
                        public final void run() {
                            String str;
                            if (bj.f15512a == null || bj.f15512a.booleanValue()) {
                                try {
                                    Uri parse = Uri.parse("content://com.huawei.android.launcher.settings/badge/");
                                    try {
                                        str = context.getContentResolver().getType(parse);
                                    } catch (Throwable unused) {
                                        str = null;
                                    }
                                    if (TextUtils.isEmpty(str)) {
                                        parse = Uri.parse("content://com.hihonor.android.launcher.settings/badge/");
                                        str = context.getContentResolver().getType(parse);
                                    }
                                    if (str == null) {
                                        Boolean unused2 = bj.f15512a = Boolean.FALSE;
                                        return;
                                    }
                                    ComponentName a10 = bj.a(context);
                                    if (a10 == null) {
                                        Boolean unused3 = bj.f15512a = Boolean.FALSE;
                                        return;
                                    }
                                    Bundle bundle = new Bundle();
                                    bundle.putString(Constants.KEY_PACKAGE, a10.getPackageName());
                                    bundle.putString(Name.LABEL, a10.getClassName());
                                    bundle.putInt("badgenumber", i10);
                                    context.getContentResolver().call(parse, "change_badge", (String) null, bundle);
                                    UPLog.i("Badge", "hw setBadgeNum:", Integer.valueOf(i10));
                                    Boolean unused4 = bj.f15512a = Boolean.TRUE;
                                } catch (Throwable unused5) {
                                    Boolean unused6 = bj.f15512a = Boolean.FALSE;
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    public static /* synthetic */ ComponentName a(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage != null) {
            return launchIntentForPackage.getComponent();
        }
        return null;
    }
}
