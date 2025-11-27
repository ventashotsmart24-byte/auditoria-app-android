package com.umeng.message.proguard;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.j;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.message.PushAgent;
import com.umeng.message.common.UPLog;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

public final class k {
    private static void a(final Context context, final String str) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                UPLog.e("SelfCheck", str);
                Toast.makeText(context, str, 1).show();
            }
        });
    }

    public static boolean a(Context context) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z20;
        Class<JSONObject> cls = JSONObject.class;
        Class<String> cls2 = String.class;
        Method method = null;
        Class<UMEnvelopeBuild> cls3 = UMEnvelopeBuild.class;
        try {
            boolean z21 = UMEnvelopeBuild.transmissionSendFlag;
        } catch (Throwable unused) {
            cls3 = null;
        }
        if (cls3 == null) {
            UPLog.e("SelfCheck", "--->>> common sdk版本不匹配，请确认！<<<--- ");
        } else {
            try {
                method = cls3.getDeclaredMethod("buildEnvelopeWithExtHeader", new Class[]{Context.class, cls, cls, cls2, cls2, cls2});
            } catch (Throwable unused2) {
            }
            if (method == null) {
                UPLog.e("SelfCheck", "--->>> common sdk版本不匹配，请确认！<<<--- ");
            }
        }
        try {
            if (TextUtils.isEmpty(PushAgent.getInstance(context).getMessageAppkey())) {
                a(context, "please set umeng appkey!");
                return false;
            } else if (TextUtils.isEmpty(PushAgent.getInstance(context).getMessageSecret())) {
                a(context, "please set umeng message secret!");
                return false;
            } else {
                Intent intent = new Intent();
                intent.setPackage(context.getPackageName());
                intent.setAction(Constants.ACTION_START_SERVICE);
                Iterator<ResolveInfo> it = context.getPackageManager().queryIntentServices(intent, 64).iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().serviceInfo.name.equals(j.channelService)) {
                            z10 = true;
                            break;
                        }
                    } else {
                        z10 = false;
                        break;
                    }
                }
                if (!z10) {
                    a(context, "please check ChannelService in AndroidManifest!");
                    return false;
                }
                Intent intent2 = new Intent();
                intent2.setPackage(context.getPackageName());
                intent2.setAction("com.taobao.accs.intent.action.ELECTION");
                Iterator<ResolveInfo> it2 = context.getPackageManager().queryIntentServices(intent2, 64).iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (it2.next().serviceInfo.name.equals(j.channelService)) {
                            z11 = true;
                            break;
                        }
                    } else {
                        z11 = false;
                        break;
                    }
                }
                if (!z11) {
                    a(context, "please check ChannelService in AndroidManifest!");
                    return false;
                }
                Intent intent3 = new Intent();
                intent3.setPackage(context.getPackageName());
                intent3.setAction(Constants.ACTION_RECEIVE);
                Iterator<ResolveInfo> it3 = context.getPackageManager().queryIntentServices(intent3, 64).iterator();
                while (true) {
                    if (it3.hasNext()) {
                        if (it3.next().serviceInfo.name.equals(j.msgService)) {
                            z12 = true;
                            break;
                        }
                    } else {
                        z12 = false;
                        break;
                    }
                }
                if (!z12) {
                    a(context, "please check MsgDistributeService in AndroidManifest!");
                    return false;
                }
                Intent intent4 = new Intent();
                intent4.setPackage(context.getPackageName());
                intent4.setAction(Constants.ACTION_RECEIVE);
                Iterator<ResolveInfo> it4 = context.getPackageManager().queryIntentServices(intent4, 64).iterator();
                while (true) {
                    if (it4.hasNext()) {
                        if (it4.next().serviceInfo.name.equals("org.android.agoo.accs.AgooService")) {
                            z13 = true;
                            break;
                        }
                    } else {
                        z13 = false;
                        break;
                    }
                }
                if (!z13) {
                    a(context, "Please check AgooService in AndroidManifest!");
                    return false;
                }
                Intent intent5 = new Intent();
                intent5.setPackage(context.getPackageName());
                intent5.setAction(AgooConstants.INTENT_FROM_AGOO_MESSAGE);
                Iterator<ResolveInfo> it5 = context.getPackageManager().queryIntentServices(intent5, 64).iterator();
                while (true) {
                    if (it5.hasNext()) {
                        if (it5.next().serviceInfo.name.equals("com.umeng.message.component.UmengIntentService")) {
                            z14 = true;
                            break;
                        }
                    } else {
                        z14 = false;
                        break;
                    }
                }
                if (!z14) {
                    a(context, "Please check UmengIntentService in AndroidManifest!");
                    return false;
                }
                Intent intent6 = new Intent();
                intent6.setClassName(context.getPackageName(), "com.umeng.message.component.UmengNotificationReceiver");
                Iterator<ResolveInfo> it6 = context.getPackageManager().queryBroadcastReceivers(intent6, 65536).iterator();
                while (true) {
                    if (!it6.hasNext()) {
                        z15 = false;
                        break;
                    }
                    ResolveInfo next = it6.next();
                    if (next.activityInfo.name.equals("com.umeng.message.component.UmengNotificationReceiver") && TextUtils.equals(next.activityInfo.processName, context.getPackageName())) {
                        z15 = true;
                        break;
                    }
                }
                if (!z15) {
                    a(context, "please check UmengNotificationReceiver in AndroidManifest!");
                    return false;
                }
                Intent intent7 = new Intent("com.umeng.message.action");
                intent7.setPackage(context.getPackageName());
                Iterator<ResolveInfo> it7 = context.getPackageManager().queryIntentServices(intent7, 64).iterator();
                while (true) {
                    if (!it7.hasNext()) {
                        z16 = false;
                        break;
                    }
                    ResolveInfo next2 = it7.next();
                    if (next2.serviceInfo.name.equals("com.umeng.message.component.UmengMessageHandlerService") && TextUtils.equals(context.getPackageName(), next2.serviceInfo.processName)) {
                        z16 = true;
                        break;
                    }
                }
                if (!z16) {
                    a(context, "please check UmengMessageHandlerService in AndroidManifest!");
                    return false;
                }
                Intent intent8 = new Intent();
                intent8.setPackage(context.getPackageName());
                intent8.setAction(AgooConstants.BINDER_MSGRECEIVER_ACTION);
                Iterator<ResolveInfo> it8 = context.getPackageManager().queryIntentServices(intent8, 64).iterator();
                while (true) {
                    if (it8.hasNext()) {
                        if (it8.next().serviceInfo.name.equals("com.umeng.message.component.UmengMessageReceiverService")) {
                            z17 = true;
                            break;
                        }
                    } else {
                        z17 = false;
                        break;
                    }
                }
                if (!z17) {
                    a(context, "please check UmengMessageReceiverService in AndroidManifest!");
                    return false;
                }
                String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                if (strArr != null) {
                    z20 = false;
                    z19 = false;
                    z18 = false;
                    for (String str : strArr) {
                        if ("android.permission.INTERNET".equals(str)) {
                            z19 = true;
                        } else if ("android.permission.ACCESS_WIFI_STATE".equals(str)) {
                            z18 = true;
                        } else if ("android.permission.ACCESS_NETWORK_STATE".equals(str)) {
                            z20 = true;
                        }
                    }
                } else {
                    z20 = false;
                    z19 = false;
                    z18 = false;
                }
                if (!(z19 && z18 && z20)) {
                    a(context, "please add required permission in AndroidManifest!");
                    return false;
                }
                return true;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
