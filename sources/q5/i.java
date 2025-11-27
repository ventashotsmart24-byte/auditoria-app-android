package q5;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.BitmapFactory;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.f;
import java.util.List;
import o.i1;
import o.s;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final i f19305a = new i();

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f19306b = {"channel_system", "channel_activity", "channel_content", "channel_upgrade"};

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f19307c = {"System message", "Activity message", "Content message", "Upgrade message"};

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f19308d = {"System message", "Activity message", "Content message", "Upgrade message"};

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f19309e = {"channel_upgrade"};

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f19310f = {"Upgrade message"};

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f19311g = {"Upgrade message"};

    /* renamed from: h  reason: collision with root package name */
    public static int f19312h = 1;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f19313a;

        /* renamed from: b  reason: collision with root package name */
        public int f19314b;

        /* renamed from: c  reason: collision with root package name */
        public Context f19315c;

        /* renamed from: d  reason: collision with root package name */
        public String f19316d = "";

        /* renamed from: e  reason: collision with root package name */
        public int f19317e;

        /* renamed from: f  reason: collision with root package name */
        public Intent f19318f;

        /* renamed from: g  reason: collision with root package name */
        public int f19319g;

        /* renamed from: h  reason: collision with root package name */
        public String f19320h = "";

        /* renamed from: i  reason: collision with root package name */
        public String f19321i = "";

        /* renamed from: j  reason: collision with root package name */
        public int f19322j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f19323k = true;

        /* renamed from: l  reason: collision with root package name */
        public String f19324l = "event";

        /* renamed from: m  reason: collision with root package name */
        public boolean f19325m = true;

        /* renamed from: n  reason: collision with root package name */
        public boolean f19326n = true;

        public final Notification a() {
            return i.f19305a.h(this);
        }

        public final boolean b() {
            return this.f19325m;
        }

        public final String c() {
            return this.f19324l;
        }

        public final String d() {
            return this.f19316d;
        }

        public final String e() {
            return this.f19321i;
        }

        public final Context f() {
            return this.f19315c;
        }

        public final int g() {
            return this.f19314b;
        }

        public final Intent h() {
            return this.f19318f;
        }

        public final int i() {
            return this.f19319g;
        }

        public final boolean j() {
            return this.f19326n;
        }

        public final int k() {
            return this.f19317e;
        }

        public final boolean l() {
            return this.f19323k;
        }

        public final int m() {
            return this.f19322j;
        }

        public final String n() {
            return this.f19320h;
        }

        public final boolean o() {
            return this.f19313a;
        }

        public final a p(boolean z10) {
            this.f19325m = z10;
            return this;
        }

        public final a q(String str) {
            t9.i.g(str, "category");
            this.f19324l = str;
            return this;
        }

        public final a r(int i10) {
            this.f19316d = i.f19305a.i(i10);
            return this;
        }

        public final a s(Context context) {
            t9.i.g(context, f.X);
            this.f19315c = context;
            return this;
        }

        public final a t(int i10) {
            this.f19314b = i10;
            return this;
        }

        public final a u(boolean z10) {
            this.f19313a = z10;
            return this;
        }

        public final a v(int i10) {
            this.f19319g = i10;
            return this;
        }

        public final a w(boolean z10) {
            this.f19326n = z10;
            return this;
        }

        public final a x(int i10) {
            this.f19322j = i10;
            return this;
        }
    }

    public final void c(Context context, int i10) {
        t9.i.g(context, f.X);
        Object systemService = context.getSystemService("notification");
        t9.i.e(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).cancel(i10);
    }

    public final void d(Context context, String str, String[] strArr, String[] strArr2, String[] strArr3) {
        Object systemService = context.getSystemService("notification");
        t9.i.e(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (notificationManager.getNotificationChannel(strArr[i10]) == null) {
                NotificationChannel notificationChannel = new NotificationChannel(strArr[i10], strArr2[i10], 3);
                notificationChannel.setGroup(str);
                notificationChannel.setDescription(strArr3[i10]);
                notificationChannel.enableLights(true);
                notificationChannel.setLightColor(-16711936);
                notificationChannel.setShowBadge(true);
                notificationChannel.setSound((Uri) null, (AudioAttributes) null);
                notificationChannel.setImportance(3);
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }

    public final void e(Context context, String str, String str2) {
        Object systemService = context.getSystemService("notification");
        t9.i.e(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        List a10 = notificationManager.getNotificationChannelGroups();
        int size = a10.size();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                break;
            } else if (TextUtils.equals(f.a(a10.get(i10)).getId(), str)) {
                z10 = true;
                break;
            } else {
                i10++;
            }
        }
        if (!z10) {
            notificationManager.createNotificationChannelGroup(new NotificationChannelGroup(str, str2));
        }
    }

    public final void f(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            e(context, "message_group", "Message Box");
            Context context2 = context;
            d(context2, "message_group", f19306b, f19307c, f19308d);
            e(context, "upgrade_group", "Upgrade");
            d(context2, "upgrade_group", f19309e, f19310f, f19311g);
        }
    }

    public final int g() {
        int i10 = f19312h + 1;
        f19312h = i10;
        return i10;
    }

    public final Notification h(a aVar) {
        s.e eVar;
        PendingIntent pendingIntent;
        Context f10 = aVar.f();
        if (f10 == null) {
            return null;
        }
        if (!TextUtils.isEmpty(aVar.d())) {
            f(f10);
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 26) {
                eVar = new s.e(f10, aVar.d());
            } else {
                eVar = new s.e(f10).z(1);
            }
            s.e y10 = eVar.m(-1).A(aVar.l()).H(System.currentTimeMillis()).k(aVar.c()).j(aVar.b()).y(aVar.j());
            if (!TextUtils.isEmpty(aVar.n())) {
                y10 = y10.p(aVar.n());
            }
            if (!TextUtils.isEmpty(aVar.e())) {
                y10 = y10.o(aVar.e());
            }
            Intent h10 = aVar.h();
            if (h10 != null) {
                if (i10 >= 31) {
                    pendingIntent = PendingIntent.getActivity(f10, aVar.k(), h10, 33554432);
                    t9.i.f(pendingIntent, "getActivity(context, bui…ndingIntent.FLAG_MUTABLE)");
                } else {
                    pendingIntent = PendingIntent.getActivity(f10, aVar.k(), h10, 134217728);
                    t9.i.f(pendingIntent, "getActivity(context, bui…tent.FLAG_UPDATE_CURRENT)");
                }
                y10 = y10.n(pendingIntent);
            }
            if (aVar.i() != 0) {
                y10 = y10.u(BitmapFactory.decodeResource(f10.getResources(), aVar.i()));
            }
            if (aVar.m() != 0) {
                y10 = y10.B(aVar.m());
            }
            if (aVar.o() && aVar.g() != 0) {
                y10.q(new RemoteViews(f10.getPackageName(), aVar.g()));
            }
            return y10.c();
        }
        throw new IllegalArgumentException("require not-null channelId params.");
    }

    public final String i(int i10) {
        if (i10 == 1) {
            return f19306b[0];
        }
        if (i10 == 2) {
            return f19306b[1];
        }
        if (i10 == 3) {
            return f19306b[2];
        }
        if (i10 == 4) {
            return f19309e[0];
        }
        throw new UnsupportedOperationException("NotificationHelper: unsupported this type.");
    }

    public final boolean j(Context context) {
        t9.i.g(context, f.X);
        i1 b10 = i1.b(context);
        t9.i.f(b10, "from(context)");
        if (Build.VERSION.SDK_INT < 26) {
            return b10.a();
        }
        if (b10.c() != 0) {
            return true;
        }
        return false;
    }

    public final void k(Context context, Notification notification, int i10) {
        t9.i.g(context, f.X);
        t9.i.g(notification, "notification");
        Object systemService = context.getSystemService("notification");
        t9.i.e(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).notify(i10, notification);
    }

    public final void l(Context context) {
        String str;
        String str2;
        String str3;
        Integer num;
        ApplicationInfo applicationInfo;
        String str4;
        try {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 26) {
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                if (context != null) {
                    str4 = context.getPackageName();
                } else {
                    str4 = null;
                }
                intent.putExtra("android.provider.extra.APP_PACKAGE", str4);
                if (context != null) {
                    context.startActivity(intent);
                }
            } else if (i10 >= 21) {
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                if (context != null) {
                    str3 = context.getPackageName();
                } else {
                    str3 = null;
                }
                intent.putExtra("app_package", str3);
                if (context == null || (applicationInfo = context.getApplicationInfo()) == null) {
                    num = null;
                } else {
                    num = Integer.valueOf(applicationInfo.uid);
                }
                intent.putExtra("app_uid", num);
                if (context != null) {
                    context.startActivity(intent);
                }
            } else {
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.addCategory("android.intent.category.DEFAULT");
                StringBuilder sb = new StringBuilder();
                sb.append("package:");
                if (context != null) {
                    str2 = context.getPackageName();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                intent.setData(Uri.parse(sb.toString()));
                if (context != null) {
                    context.startActivity(intent);
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            if (e10 instanceof ActivityNotFoundException) {
                Intent intent2 = new Intent();
                intent2.addFlags(268435456);
                intent2.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                if (context != null) {
                    str = context.getPackageName();
                } else {
                    str = null;
                }
                intent2.setData(Uri.fromParts(Constants.KEY_PACKAGE, str, (String) null));
                if (context != null) {
                    context.startActivity(intent2);
                }
            }
        }
    }
}
