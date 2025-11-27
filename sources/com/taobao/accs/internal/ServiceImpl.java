package com.taobao.accs.internal;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.text.TextUtils;
import com.hpplay.cybergarage.http.HTTP;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.data.g;
import com.taobao.accs.net.a;
import com.taobao.accs.net.v;
import com.taobao.accs.ut.a.c;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.k;
import com.taobao.accs.utl.q;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.android.agoo.service.IMessageService;

public class ServiceImpl extends d {

    /* renamed from: b  reason: collision with root package name */
    private Service f13010b = null;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Context f13011c;

    /* renamed from: d  reason: collision with root package name */
    private long f13012d;

    /* renamed from: e  reason: collision with root package name */
    private String f13013e = "unknown";

    /* renamed from: f  reason: collision with root package name */
    private final IMessageService.Stub f13014f = new IMessageService.Stub() {
        public boolean ping() {
            return true;
        }

        public void probe() {
            ALog.d("ServiceImpl", "ReceiverImpl probeTaoBao begin......messageServiceBinder [probe]", new Object[0]);
            ThreadPoolExecutorFactory.execute(new e(this));
        }
    };

    public ServiceImpl(Service service) {
        super(service);
        this.f13010b = service;
        this.f13011c = service.getApplicationContext();
    }

    private void b(Intent intent) {
        Message message;
        Message.ReqType reqType;
        URL url;
        Message buildRequest;
        Intent intent2 = intent;
        int intExtra = intent2.getIntExtra("command", -1);
        ALog.i("ServiceImpl", "handleCommand", "command", Integer.valueOf(intExtra));
        String stringExtra = intent2.getStringExtra(Constants.KEY_PACKAGE_NAME);
        String stringExtra2 = intent2.getStringExtra(Constants.KEY_SERVICE_ID);
        String stringExtra3 = intent2.getStringExtra(Constants.KEY_USER_ID);
        String stringExtra4 = intent2.getStringExtra(Constants.KEY_APP_KEY);
        String stringExtra5 = intent2.getStringExtra(Constants.KEY_CONFIG_TAG);
        String stringExtra6 = intent2.getStringExtra(Constants.KEY_TTID);
        intent2.getStringExtra("sid");
        intent2.getStringExtra(Constants.KEY_ANTI_BRUSH_COOKIE);
        if (intExtra == 201) {
            a(Message.BuildPing(true, 0), true);
            d();
        }
        if (intExtra > 0 && !TextUtils.isEmpty(stringExtra)) {
            a b10 = d.b(this.f13011c, stringExtra5, true);
            if (b10 != null) {
                b10.a();
                if (intExtra != 1) {
                    String str = Constants.KEY_FOUCE_BIND;
                    message = null;
                    if (intExtra == 2) {
                        ALog.e("ServiceImpl", "onHostStartCommand COMMAND_UNBIND_APP", new Object[0]);
                        if (b10.j().d(stringExtra)) {
                            Message buildUnbindApp = Message.buildUnbindApp(b10.b((String) null), stringExtra);
                            ALog.i("ServiceImpl", stringExtra + " isAppUnbinded", new Object[0]);
                            b10.b(buildUnbindApp, 200);
                            return;
                        }
                    } else if (intExtra == 5) {
                        message = Message.buildBindService(b10.b((String) null), stringExtra2);
                    } else if (intExtra == 6) {
                        message = Message.buildUnbindService(stringExtra, stringExtra2);
                    } else if (intExtra == 3) {
                        message = Message.buildBindUser(stringExtra, stringExtra3);
                        if (b10.j().b(stringExtra, stringExtra3) && !intent2.getBooleanExtra(str, false)) {
                            ALog.i("ServiceImpl", stringExtra + Operator.Operation.DIVISION + stringExtra3 + " isUserBinded", new Object[0]);
                            if (message != null) {
                                b10.b(message, 200);
                                return;
                            }
                            return;
                        }
                    } else if (intExtra == 4) {
                        message = Message.buildUnbindUser(stringExtra);
                    } else if (intExtra == 100) {
                        byte[] byteArrayExtra = intent2.getByteArrayExtra("data");
                        String stringExtra7 = intent2.getStringExtra(Constants.KEY_DATA_ID);
                        String stringExtra8 = intent2.getStringExtra("target");
                        String stringExtra9 = intent2.getStringExtra(Constants.KEY_BUSINESSID);
                        String stringExtra10 = intent2.getStringExtra(Constants.KEY_EXT_TAG);
                        try {
                            reqType = (Message.ReqType) intent2.getSerializableExtra(Constants.KEY_SEND_TYPE);
                        } catch (Exception unused) {
                            reqType = null;
                        }
                        if (byteArrayExtra != null) {
                            try {
                                url = new URL("https://" + ((v) b10).p());
                            } catch (MalformedURLException e10) {
                                e10.printStackTrace();
                                url = null;
                            }
                            String str2 = stringExtra5;
                            ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest(stringExtra3, stringExtra2, byteArrayExtra, stringExtra7, stringExtra8, url, stringExtra9);
                            accsRequest.setTag(stringExtra10);
                            if (reqType == null) {
                                buildRequest = Message.buildSendData(b10.b((String) null), str2, b10.f13033i.getStoreId(), this.f13011c, stringExtra, accsRequest, false);
                            } else if (reqType == Message.ReqType.REQ) {
                                buildRequest = Message.buildRequest(this.f13011c, b10.b((String) null), str2, b10.f13033i.getStoreId(), stringExtra, Constants.TARGET_SERVICE_PRE, accsRequest, false);
                            }
                            message = buildRequest;
                        }
                    } else if (intExtra == 106) {
                        intent2.setAction(Constants.ACTION_RECEIVE);
                        intent2.putExtra("command", -1);
                        g.a().b(this.f13011c, intent2);
                        return;
                    }
                } else if (!stringExtra.equals(this.f13011c.getPackageName())) {
                    ALog.e("ServiceImpl", "handleCommand bindapp pkg error", new Object[0]);
                    return;
                } else {
                    String stringExtra11 = intent2.getStringExtra("app_sercet");
                    Context context = this.f13011c;
                    String stringExtra12 = intent2.getStringExtra("appVersion");
                    Context context2 = context;
                    String str3 = stringExtra6;
                    String str4 = Constants.KEY_FOUCE_BIND;
                    message = Message.buildBindApp(context2, stringExtra5, stringExtra4, stringExtra11, stringExtra, str3, stringExtra12);
                    b10.f13025a = str3;
                    if (b10.j().c(stringExtra) && !intent2.getBooleanExtra(str4, false)) {
                        ALog.i("ServiceImpl", stringExtra + " isAppBinded", new Object[0]);
                        b10.b(message, 200);
                        return;
                    }
                }
                if (message != null) {
                    ALog.d("ServiceImpl", "try send message", new Object[0]);
                    if (message.getNetPermanceMonitor() != null) {
                        message.getNetPermanceMonitor().onSend();
                    }
                    b10.b(message, true);
                    return;
                }
                ALog.e("ServiceImpl", "message is null", new Object[0]);
                b10.b(Message.buildParameterError(stringExtra, intExtra), -2);
                return;
            }
            ALog.e("ServiceImpl", "no connection", Constants.KEY_CONFIG_TAG, stringExtra5, "command", Integer.valueOf(intExtra));
        }
    }

    private void c() {
        ConcurrentHashMap<String, a> concurrentHashMap = d.f13019a;
        if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
            for (Map.Entry<String, a> value : d.f13019a.entrySet()) {
                ((a) value.getValue()).b();
            }
        }
    }

    private void d() {
        ConcurrentHashMap<String, a> concurrentHashMap = d.f13019a;
        if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
            for (Map.Entry<String, a> value : d.f13019a.entrySet()) {
                c c10 = ((a) value.getValue()).c();
                if (c10 != null) {
                    c10.f13139h = this.f13012d;
                    c10.a();
                }
            }
        }
    }

    private void e() {
        ConcurrentHashMap<String, a> concurrentHashMap = d.f13019a;
        if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
            for (Map.Entry<String, a> value : d.f13019a.entrySet()) {
                ((a) value.getValue()).e();
            }
        }
    }

    public IBinder onBind(Intent intent) {
        String action = intent.getAction();
        ALog.d("ServiceImpl", "accs probeTaoBao begin......action=" + action, new Object[0]);
        if (TextUtils.isEmpty(action) || !TextUtils.equals(action, "org.agoo.android.intent.action.PING_V4")) {
            return null;
        }
        UTMini.getInstance().commitEvent(66001, "probeChannelService", UtilityImpl.j(this.f13011c), intent.getStringExtra("source"));
        return this.f13014f;
    }

    public void onCreate() {
        super.onCreate();
        a();
    }

    public void onDestroy() {
        super.onDestroy();
        ALog.e("ServiceImpl", "Service onDestroy", new Object[0]);
        UtilityImpl.a(this.f13011c, Constants.SP_KEY_SERVICE_END, System.currentTimeMillis());
        this.f13010b = null;
        this.f13011c = null;
        e();
        Process.killProcess(Process.myPid());
    }

    public boolean onUnbind(Intent intent) {
        return false;
    }

    public int a(Intent intent) {
        String str;
        Bundle extras;
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i("ServiceImpl", "onHostStartCommand", "intent", intent);
        }
        try {
            if (!(!ALog.isPrintLog(ALog.Level.D) || intent == null || (extras = intent.getExtras()) == null)) {
                for (String str2 : extras.keySet()) {
                    ALog.d("ServiceImpl", "onHostStartCommand", "key", str2, " value", extras.get(str2));
                }
            }
            int c10 = q.c();
            if (c10 > 3) {
                ALog.e("ServiceImpl", "onHostStartCommand load SO fail 4 times, don't auto restart", new Object[0]);
                k.a("accs", BaseMonitor.COUNT_POINT_SOFAIL, UtilityImpl.a(c10), 0.0d);
            }
            if (intent == null) {
                str = null;
            } else {
                str = intent.getAction();
            }
            if (TextUtils.isEmpty(str)) {
                b();
                a(false, false);
                com.taobao.accs.client.a.f12918f.incrementAndGet();
                return 2;
            }
            a(intent, str);
            com.taobao.accs.client.a.f12918f.incrementAndGet();
            return 2;
        } catch (Throwable th) {
            com.taobao.accs.client.a.f12918f.incrementAndGet();
            throw th;
        }
    }

    private void a() {
        ALog.d("ServiceImpl", "init start", new Object[0]);
        GlobalClientInfo.getInstance(this.f13011c);
        com.taobao.accs.client.a.f12918f.incrementAndGet();
        this.f13012d = System.currentTimeMillis();
        this.f13013e = UtilityImpl.h(this.f13011c);
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i("ServiceImpl", "init", Constants.KEY_SDK_VERSION, Integer.valueOf(Constants.SDK_VERSION_CODE), "procStart", Integer.valueOf(com.taobao.accs.client.a.f12918f.intValue()));
        }
        UTMini.getInstance().commitEvent(66001, "START", UtilityImpl.h(), "PROXY");
        long k10 = UtilityImpl.k(this.f13011c);
        ALog.d("ServiceImpl", "getServiceAliveTime", "aliveTime", Long.valueOf(k10));
        if (k10 > 20000) {
            k.a("accs", BaseMonitor.COUNT_SERVICE_ALIVE, "", (double) (k10 / 1000));
        }
        UtilityImpl.a(this.f13011c, Constants.SP_KEY_SERVICE_START, System.currentTimeMillis());
        UTMini.getInstance().commitEvent(66001, HTTP.NOTIFY, UtilityImpl.o(this.f13011c));
    }

    private void a(Intent intent, String str) {
        String str2 = str;
        ALog.d("ServiceImpl", "handleAction", "action", str2);
        try {
            if (TextUtils.isEmpty(str) || !"org.agoo.android.intent.action.PING_V4".equals(str2)) {
                Intent intent2 = intent;
            } else {
                String stringExtra = intent.getStringExtra("source");
                ALog.i("ServiceImpl", "org.agoo.android.intent.action.PING_V4,start channel by brothers", "serviceStart", Integer.valueOf(com.taobao.accs.client.a.f12918f.intValue()), "source" + stringExtra);
                k.a("accs", "startChannel", stringExtra, 0.0d);
                if (com.taobao.accs.client.a.c()) {
                    k.a("accs", "createChannel", stringExtra, 0.0d);
                }
            }
            b();
            if (!TextUtils.equals(str2, "android.intent.action.PACKAGE_REMOVED")) {
                if (TextUtils.equals(str2, "android.net.conn.CONNECTIVITY_CHANGE")) {
                    String h10 = UtilityImpl.h(this.f13011c);
                    boolean i10 = UtilityImpl.i(this.f13011c);
                    ALog.i("ServiceImpl", "network change:" + this.f13013e + " to " + h10, new Object[0]);
                    if (i10) {
                        this.f13013e = h10;
                        c();
                        a(true, false);
                        UTMini.getInstance().commitEvent(66001, "CONNECTIVITY_CHANGE", h10, UtilityImpl.h(), "0");
                    }
                    if (h10.equals("unknown")) {
                        c();
                        this.f13013e = h10;
                    }
                } else if (TextUtils.equals(str2, "android.intent.action.BOOT_COMPLETED")) {
                    a(true, false);
                } else if (TextUtils.equals(str2, "android.intent.action.USER_PRESENT")) {
                    ALog.d("ServiceImpl", "action android.intent.action.USER_PRESENT", new Object[0]);
                    a(true, false);
                } else if (str2.equals(Constants.ACTION_COMMAND)) {
                    b(intent);
                } else if (str2.equals(Constants.ACTION_START_FROM_AGOO)) {
                    ALog.i("ServiceImpl", "ACTION_START_FROM_AGOO", new Object[0]);
                }
            }
        } catch (Throwable th) {
            ALog.e("ServiceImpl", "handleAction", th, new Object[0]);
        }
    }

    private synchronized void b() {
        ConcurrentHashMap<String, a> concurrentHashMap = d.f13019a;
        if (concurrentHashMap != null) {
            if (concurrentHashMap.size() != 0) {
                for (Map.Entry next : d.f13019a.entrySet()) {
                    a aVar = (a) next.getValue();
                    if (aVar == null) {
                        ALog.e("ServiceImpl", "tryConnect connection null", "appkey", aVar.i());
                        return;
                    }
                    ALog.i("ServiceImpl", "tryConnect", "appkey", aVar.i(), Constants.KEY_CONFIG_TAG, next.getKey());
                    if (!aVar.l() || !TextUtils.isEmpty(aVar.f13033i.getAppSecret())) {
                        aVar.a();
                    } else {
                        ALog.e("ServiceImpl", "tryConnect secret is null", new Object[0]);
                    }
                }
                return;
            }
        }
        ALog.w("ServiceImpl", "tryConnect no connections", new Object[0]);
    }

    private void a(Message message, boolean z10) {
        ConcurrentHashMap<String, a> concurrentHashMap = d.f13019a;
        if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
            for (Map.Entry<String, a> value : d.f13019a.entrySet()) {
                a aVar = (a) value.getValue();
                if (aVar instanceof com.taobao.accs.net.k) {
                    aVar.a(true, false);
                } else {
                    aVar.b(message, z10);
                }
            }
        }
    }

    private void a(boolean z10, boolean z11) {
        ConcurrentHashMap<String, a> concurrentHashMap = d.f13019a;
        if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
            for (Map.Entry<String, a> value : d.f13019a.entrySet()) {
                a aVar = (a) value.getValue();
                aVar.a(z10, z11);
                ALog.i("ServiceImpl", "ping connection", "appkey", aVar.i());
            }
        }
    }
}
