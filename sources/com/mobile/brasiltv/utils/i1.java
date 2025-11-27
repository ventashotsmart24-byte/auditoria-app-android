package com.mobile.brasiltv.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import c2.d;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.view.dialog.DialogManager;
import com.titans.entity.CdnType;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.MobclickAgent;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import ma.m;
import na.c;
import w6.i;

public abstract class i1 {

    public class a implements Consumer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f12588a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f12589b;

        public a(Context context, String str) {
            this.f12588a = context;
            this.f12589b = str;
        }

        /* renamed from: a */
        public void accept(Long l10) {
            i1.e(this.f12588a, this.f12589b);
        }
    }

    public static void A(Context context, String str, long j10) {
        int intValue = Long.valueOf((System.currentTimeMillis() - j10) / 1000).intValue();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, simpleDateFormat.format(new Date()));
        hashMap.put("channelName", str);
        MobclickAgent.onEventValue(context, "CH_PLAY_LIVE", hashMap, intValue);
    }

    public static void B(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        hashMap.put("apkVersion", e.a(context));
        hashMap.put("deviceModel", Build.MODEL);
        hashMap.put("sysVersion", Build.VERSION.RELEASE);
        MobclickAgent.onEvent(context.getApplicationContext(), "EVENT_NO_KEEP_ACTIVITIES", (Map<String, String>) hashMap);
    }

    public static void C(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("userId", i.f9510g.H());
        bundle.putString("sysVersion", Build.VERSION.RELEASE);
        bundle.putString("deviceModel", Build.MODEL);
        bundle.putString("buttonName", str);
        b(context).logEvent("EVENT_ORDER_CONFIRM", bundle);
    }

    public static void D(Context context, String str, int i10) {
        if (!TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put(AnalyticsConfig.RTD_START_TIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            hashMap.put("recommend_pos", String.valueOf(i10));
            d(context, str, hashMap);
        }
    }

    public static void E(Context context, String str, String str2, String str3, long j10) {
        int intValue = Long.valueOf((System.currentTimeMillis() - j10) / 1000).intValue();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, simpleDateFormat.format(new Date()));
        hashMap.put("channelID", str);
        hashMap.put("channelName", str2);
        hashMap.put("recommendType", str3 + " ," + str2);
        MobclickAgent.onEventValue(context, "CH_PLAY_RECOMMEND", hashMap, intValue);
    }

    public static void F(Context context) {
        Bundle bundle = new Bundle();
        bundle.putString("sysVersion", Build.VERSION.RELEASE);
        bundle.putString("deviceModel", Build.MODEL);
        b(context).logEvent("EVENT_REFRESH_POPULAR_SEARCH", bundle);
    }

    public static void G(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        hashMap.put("sn", i.f9510g.E());
        hashMap.put("deviceModel", Build.MODEL);
        hashMap.put("apkVersion", "6.2.1");
        hashMap.put("sysVersion", Build.VERSION.RELEASE);
        hashMap.put("step", str);
        hashMap.put("info", str2);
        d(context, "EVENT_REVIEW_CODE_NODE", hashMap);
        MobclickAgent.onEvent(context.getApplicationContext(), "EVENT_REVIEW_CODE_NODE", (Map<String, String>) hashMap);
    }

    public static void H(Context context, Uri uri) {
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        hashMap.put("deviceModel", Build.MODEL);
        hashMap.put("apkVersion", "6.2.1");
        hashMap.put("uri", uri.toString());
        d(context, "EVENT_SAVE_SN_URI", hashMap);
        MobclickAgent.onEvent(context.getApplicationContext(), "EVENT_SAVE_SN_URI", (Map<String, String>) hashMap);
    }

    public static void I(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("userId", i.f9510g.H());
        bundle.putString("shareFrom", str);
        b(context).logEvent("EVENT_SHARE_APP_CLICK", bundle);
    }

    public static void J(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("userId", i.f9510g.H());
        bundle.putString("sysVersion", Build.VERSION.RELEASE);
        bundle.putString("deviceModel", Build.MODEL);
        bundle.putString("shortVideoName", str);
        b(context).logEvent("EVENT_SHORT_WATCH_FULL_VIDEO", bundle);
    }

    public static void K(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("userId", i.f9510g.H());
        bundle.putString("bindFrom", str);
        b(context).logEvent("EVENT_TO_BIND_EMAIL_CLICK", bundle);
    }

    public static void L(Context context, String str, String str2, String str3, long j10) {
        int intValue = Long.valueOf((System.currentTimeMillis() - j10) / 1000).intValue();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, simpleDateFormat.format(new Date()));
        hashMap.put("topicName", str + " ," + str3);
        hashMap.put("channelID", str2);
        hashMap.put("channelName", str3);
        MobclickAgent.onEventValue(context, "CH_PLAY_TOPIC", hashMap, intValue);
    }

    public static void M(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("userId", i.f9510g.H());
        bundle.putString("sysVersion", Build.VERSION.RELEASE);
        bundle.putString("deviceModel", Build.MODEL);
        bundle.putString("tag", str);
        b(context).logEvent("EVENT_TV_DEVICE", bundle);
    }

    public static void N(Context context) {
        Bundle bundle = new Bundle();
        bundle.putString("sysVersion", Build.VERSION.RELEASE);
        bundle.putString("deviceModel", Build.MODEL);
        b(context).logEvent("EVENT_VISITOR_CLICK_BIND_TIP", bundle);
    }

    public static void O(Context context, String str, String str2, long j10) {
        int intValue = Long.valueOf((System.currentTimeMillis() - j10) / 1000).intValue();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, simpleDateFormat.format(new Date()));
        hashMap.put("channelID", str);
        hashMap.put("channelName", str2);
        MobclickAgent.onEventValue(context, "CH_PLAY_VOD", hashMap, intValue);
    }

    public static void P(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        hashMap.put("userId", i.f9510g.H());
        hashMap.put("subtitleSwitch", str);
        hashMap.put("audio", str2);
        hashMap.put("apkVersion", e.a(context));
        d(context, "EVENT_CLICK_VOD_SUBTITLE_SWITCH", hashMap);
    }

    public static FirebaseAnalytics b(Context context) {
        return FirebaseAnalytics.getInstance(context.getApplicationContext());
    }

    public static /* synthetic */ void c(Throwable th) {
    }

    public static void d(Context context, String str, HashMap hashMap) {
        MobclickAgent.onEvent(context.getApplicationContext(), str, (Map<String, String>) hashMap);
        Bundle bundle = new Bundle();
        for (Map.Entry entry : hashMap.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        b(context).logEvent(str, bundle);
    }

    public static void e(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        MobclickAgent.onEvent(context.getApplicationContext(), str, (Map<String, String>) hashMap);
    }

    public static void f(Context context, String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("userId", str);
        bundle.putString("sysVersion", Build.VERSION.RELEASE);
        bundle.putString("deviceModel", Build.MODEL);
        bundle.putString("castMode", str2);
        bundle.putString("castDevice", str3);
        b(context).logEvent("EVENT_CAST_COUNT", bundle);
    }

    public static void g(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        d(context, str, hashMap);
    }

    public static void h(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        String str12;
        Bundle bundle = new Bundle();
        bundle.putString("userId", str);
        bundle.putString("sysVersion", Build.VERSION.RELEASE);
        bundle.putString("deviceModel", Build.MODEL);
        bundle.putString("castMode", str2);
        bundle.putString("castDevice", str3);
        bundle.putString("castResourceId", str4);
        b(context).logEvent("EVENT_CAST_FAILURE", bundle);
        if (TextUtils.isDigitsOnly(str9)) {
            str12 = CdnType.INSTANCE.transform(str9);
        } else {
            str12 = str9;
        }
        d.f4594a.h(str7, str10, str8, str12, str6, str5, str11, str2, str3, "", "", "", (HashMap) null);
    }

    public static void i(Context context, String str, String str2, String str3, boolean z10) {
        String str4;
        Bundle bundle = new Bundle();
        bundle.putString("userId", str);
        bundle.putString("sysVersion", Build.VERSION.RELEASE);
        bundle.putString("deviceModel", Build.MODEL);
        bundle.putString("castMode", str2);
        bundle.putString("castDevice", str3);
        if (z10) {
            str4 = "true";
        } else {
            str4 = "false";
        }
        bundle.putString("castStatus", str4);
        b(context).logEvent("EVENT_CAST_LINK", bundle);
    }

    public static void j(Context context, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("userId", str);
        bundle.putString("sysVersion", Build.VERSION.RELEASE);
        bundle.putString("deviceModel", Build.MODEL);
        bundle.putString("castMode", str2);
        b(context).logEvent("EVENT_CAST_MODE", bundle);
    }

    public static void k(Context context, String str, String str2, String str3, long j10) {
        int intValue = Long.valueOf((System.currentTimeMillis() - j10) / 1000).intValue();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, simpleDateFormat.format(new Date()));
        hashMap.put("categoryType", str + " ," + str3);
        hashMap.put("channelID", str2);
        hashMap.put("channelName", str3);
        MobclickAgent.onEventValue(context, "CH_PLAY_CATEGORY_LIST", hashMap, intValue);
    }

    public static void l(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        hashMap.put("userId", i.f9510g.H());
        hashMap.put("apkVersion", e.a(context));
        MobclickAgent.onEvent(context.getApplicationContext(), "EVENT_COUPON_FLOAT_VIEW_CLICK", (Map<String, String>) hashMap);
    }

    public static void m(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", m.e(str));
        MobclickAgent.onEvent(context, "EVENT_EXCHANGE_CODE_ENTRANCE", (Map<String, String>) hashMap);
    }

    public static void n(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        hashMap.put("userId", i.f9510g.H());
        hashMap.put("apkVersion", e.a(context));
        MobclickAgent.onEvent(context.getApplicationContext(), "EVENT_CLICK_PREVIOUS_CHANNEL", (Map<String, String>) hashMap);
    }

    public static void o(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        hashMap.put("userId", i.f9510g.H());
        hashMap.put("apkVersion", e.a(context));
        hashMap.put("vodSearchKey", str);
        d(context, "EVENT_CLICK_VOD_SEARCH", hashMap);
    }

    public static Disposable p(Context context, String str) {
        return Observable.timer(1, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).subscribe(new a(context, str), new h1());
    }

    public static void q(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("apkVersion", e.a(context));
        hashMap.put("deviceModel", Build.MODEL);
        hashMap.put("sysVersion", Build.VERSION.RELEASE);
        hashMap.put("devId", str);
        MobclickAgent.onEvent(context.getApplicationContext(), "EVENT_DONT_INSTALL_GP", (Map<String, String>) hashMap);
    }

    public static void r(Context context, String str, int i10, boolean z10, boolean z11) {
        String str2;
        String str3;
        HashMap hashMap = new HashMap();
        String binaryString = Integer.toBinaryString(i10);
        int length = 3 - binaryString.length();
        while (true) {
            str2 = "0";
            if (length <= 0) {
                break;
            }
            binaryString = str2 + binaryString;
            length--;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_");
        sb.append(binaryString);
        sb.append("_");
        if (z10) {
            str3 = "1";
        } else {
            str3 = str2;
        }
        sb.append(str3);
        sb.append("_");
        if (z11) {
            str2 = "1";
        }
        sb.append(str2);
        hashMap.put("urlPath", sb.toString());
        hashMap.put("isLogin", "" + i10);
        d(context, "EVENT_EMPTY_TOKEN", hashMap);
    }

    public static void s(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        hashMap.put("userId", i.f9510g.H());
        hashMap.put("apkVersion", e.a(context));
        hashMap.put("vodSearchKey", str);
        d(context, "EVENT_ENTER_VOD_PLAY_FROM_SEARCH", hashMap);
    }

    public static void t(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        hashMap.put("userId", i.f9510g.H());
        hashMap.put("apkVersion", e.a(context));
        d(context, "EVENT_ENTER_VOD_SEARCH", hashMap);
    }

    public static void u(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("Tag", str);
        hashMap.put(Constant.KEY_MSG, e.a(context) + ";" + c.f19073a + Build.MODEL + ";" + Build.VERSION.RELEASE + ";" + str);
        MobclickAgent.onEvent(context.getApplicationContext(), "EVENT_REVERSE_TOOL", (Map<String, String>) hashMap);
    }

    public static void v(Context context, String str) {
        String str2;
        if (TextUtils.isEmpty(str) || "1".equals(str)) {
            str2 = "visitor";
        } else if ("2".equals(str)) {
            str2 = DialogManager.DIALOG_EXPIRED;
        } else if ("3".equals(str)) {
            str2 = "experienced";
        } else if ("4".equals(str)) {
            str2 = "members";
        } else {
            str2 = "";
        }
        b(context).setUserProperty("user_identity", str2);
    }

    public static void w(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("userId", i.f9510g.H());
        bundle.putString("sysVersion", Build.VERSION.RELEASE);
        bundle.putString("deviceModel", Build.MODEL);
        bundle.putString("buttonName", str);
        b(context).logEvent("EVENT_GET_PRIORITY_VIP", bundle);
    }

    public static void x(Context context, String str, int i10) {
        HashMap hashMap = new HashMap();
        hashMap.put("apkVersion", e.a(context));
        hashMap.put("deviceModel", Build.MODEL);
        hashMap.put("sysVersion", Build.VERSION.RELEASE);
        hashMap.put("devId", str);
        hashMap.put("gAvailableCode", String.valueOf(i10));
        MobclickAgent.onEvent(context.getApplicationContext(), "EVENT_EXCEPTION_GOOGLE_SERVICE", (Map<String, String>) hashMap);
    }

    public static void y(Context context, String str, String str2, String str3, long j10) {
        int intValue = Long.valueOf((System.currentTimeMillis() - j10) / 1000).intValue();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConfig.RTD_START_TIME, simpleDateFormat.format(new Date()));
        hashMap.put("categoryType", str + " ," + str3);
        hashMap.put("channelID", str2);
        hashMap.put("channelName", str3);
        MobclickAgent.onEventValue(context, "CH_PLAY_HOME", hashMap, intValue);
    }

    public static void z(Context context) {
        Bundle bundle = new Bundle();
        bundle.putString("userId", i.f9510g.H());
        b(context).logEvent("EVENT_LATER_TO_BIND_EMAIL_CLICK", bundle);
    }
}
