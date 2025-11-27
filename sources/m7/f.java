package m7;

import android.app.Notification;
import android.content.Context;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.message.UTrack;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.entity.UMessage;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7907a = "f";

    /* renamed from: b  reason: collision with root package name */
    public static Context f7908b;

    /* renamed from: c  reason: collision with root package name */
    public static b f7909c;

    /* renamed from: d  reason: collision with root package name */
    public static e f7910d;

    public interface d {
        void a(PushAgent pushAgent, String str);

        void b(PushAgent pushAgent);

        void c(PushAgent pushAgent, String str, String str2);
    }

    public class a extends UmengMessageHandler {
        public void dealWithCustomMessage(Context context, UMessage uMessage) {
            UTrack.getInstance(context.getApplicationContext()).trackMsgClick(uMessage);
            f.f7909c.a(f.f7908b, uMessage);
            e eVar = f.f7910d;
            if (eVar != null) {
                eVar.a(context, uMessage);
            }
        }

        public void dealWithNotificationMessage(Context context, UMessage uMessage) {
            f.f7909c.b(f.f7908b, uMessage);
            e eVar = f.f7910d;
            if (eVar != null) {
                eVar.b(context, uMessage);
            }
        }

        public Notification getNotification(Context context, UMessage uMessage) {
            e eVar = f.f7910d;
            if (eVar != null) {
                return eVar.c(context, uMessage);
            }
            return super.getNotification(context, uMessage);
        }

        public void handleMessage(Context context, UMessage uMessage) {
            e eVar = f.f7910d;
            if (eVar != null) {
                eVar.d(context, uMessage);
            }
            super.handleMessage(context, uMessage);
        }
    }

    public class b extends UmengMessageHandler {
    }

    public class c implements IUmengRegisterCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f18975a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PushAgent f18976b;

        public c(d dVar, PushAgent pushAgent) {
            this.f18975a = dVar;
            this.f18976b = pushAgent;
        }

        public void onFailure(String str, String str2) {
            String unused = f.f7907a;
            StringBuilder sb = new StringBuilder();
            sb.append("register failed: ");
            sb.append(str);
            sb.append(" ");
            sb.append(str2);
            d dVar = this.f18975a;
            if (dVar != null) {
                dVar.c(this.f18976b, str, str2);
            }
        }

        public void onSuccess(String str) {
            String unused = f.f7907a;
            StringBuilder sb = new StringBuilder();
            sb.append("device token: ");
            sb.append(str);
            d dVar = this.f18975a;
            if (dVar != null) {
                dVar.a(this.f18976b, str);
            }
        }
    }

    public static void b(Context context, String str, String str2, a aVar, String str3, d dVar, String str4) {
        f7908b = context.getApplicationContext();
        f7909c = new b();
        f(f7908b);
        UMConfigure.init(f7908b, str, str2, aVar.b(), str3);
        c(f7908b, dVar, str4);
    }

    public static void c(Context context, d dVar, String str) {
        PushAgent instance = PushAgent.getInstance(context);
        if (str != null) {
            instance.setResourcePackageName(str);
        }
        if (dVar != null) {
            dVar.b(instance);
        }
        instance.setNotificationPlaySound(2);
        instance.setMessageHandler(new a());
        instance.setNotificationClickHandler(new b());
        instance.register(new c(dVar, instance));
    }

    public static void d(Context context) {
        f7908b = context.getApplicationContext();
    }

    public static void e(e eVar) {
        f7910d = eVar;
    }

    public static void f(Context context) {
        int b10 = n7.b.b(context);
        if (n7.a.c(context) != b10) {
            n7.a.a(context);
            n7.a.f(context, b10);
        }
    }
}
