package org.repackage.com.vivo.identifier;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.cybergarage.soap.SOAP;
import com.taobao.accs.common.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class IdentifierIdClient {
    private static int A = 13;
    private static IdentifierIdObserver B = null;
    private static IdentifierIdObserver C = null;
    private static IdentifierIdObserver D = null;
    private static IdentifierIdObserver E = null;
    private static HandlerThread F = null;
    private static Handler G = null;
    /* access modifiers changed from: private */
    public static String H = null;
    /* access modifiers changed from: private */
    public static String I = null;
    /* access modifiers changed from: private */
    public static String J = null;
    /* access modifiers changed from: private */
    public static String K = null;
    /* access modifiers changed from: private */
    public static String L = null;
    /* access modifiers changed from: private */
    public static String M = null;
    private static String N = null;
    private static volatile IdentifierIdClient O = null;
    /* access modifiers changed from: private */
    public static volatile DataBaseOperation P = null;
    /* access modifiers changed from: private */
    public static int R = 0;
    /* access modifiers changed from: private */
    public static int S = 0;
    /* access modifiers changed from: private */
    public static int T = 0;
    /* access modifiers changed from: private */
    public static int U = 0;
    /* access modifiers changed from: private */
    public static int V = 0;
    /* access modifiers changed from: private */
    public static int W = 0;
    /* access modifiers changed from: private */
    public static int X = 0;
    /* access modifiers changed from: private */
    public static int Y = 0;
    /* access modifiers changed from: private */
    public static int Z = 0;

    /* renamed from: a  reason: collision with root package name */
    public static final String f8696a = "persist.sys.identifierid";
    /* access modifiers changed from: private */

    /* renamed from: aa  reason: collision with root package name */
    public static int f8697aa = 0;
    /* access modifiers changed from: private */

    /* renamed from: ab  reason: collision with root package name */
    public static int f8698ab = 0;
    /* access modifiers changed from: private */
    public static int ac = 0;

    /* renamed from: b  reason: collision with root package name */
    private static final String f8699b = "VMS_SDK_Client";

    /* renamed from: c  reason: collision with root package name */
    private static final String f8700c = "content://com.vivo.vms.IdProvider/IdentifierId";

    /* renamed from: d  reason: collision with root package name */
    private static final String f8701d = "persist.sys.identifierid.supported";

    /* renamed from: e  reason: collision with root package name */
    private static final String f8702e = "com.vivo.vms";

    /* renamed from: f  reason: collision with root package name */
    private static final String f8703f = "appid";

    /* renamed from: g  reason: collision with root package name */
    private static final String f8704g = "type";

    /* renamed from: h  reason: collision with root package name */
    private static final String f8705h = "OAID";

    /* renamed from: i  reason: collision with root package name */
    private static final String f8706i = "VAID";

    /* renamed from: j  reason: collision with root package name */
    private static final String f8707j = "OAIDSTATUS";
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static Object f8708k = new Object();

    /* renamed from: l  reason: collision with root package name */
    private static final int f8709l = 0;

    /* renamed from: m  reason: collision with root package name */
    private static final int f8710m = 1;

    /* renamed from: n  reason: collision with root package name */
    private static final int f8711n = 2;

    /* renamed from: o  reason: collision with root package name */
    private static final int f8712o = 3;

    /* renamed from: p  reason: collision with root package name */
    private static final int f8713p = 4;

    /* renamed from: q  reason: collision with root package name */
    private static final int f8714q = 5;

    /* renamed from: r  reason: collision with root package name */
    private static final int f8715r = 6;

    /* renamed from: s  reason: collision with root package name */
    private static final int f8716s = 7;

    /* renamed from: t  reason: collision with root package name */
    private static final int f8717t = 8;

    /* renamed from: u  reason: collision with root package name */
    private static final int f8718u = 9;

    /* renamed from: v  reason: collision with root package name */
    private static final int f8719v = 10;

    /* renamed from: w  reason: collision with root package name */
    private static final int f8720w = 11;

    /* renamed from: x  reason: collision with root package name */
    private static final int f8721x = 2000;

    /* renamed from: y  reason: collision with root package name */
    private static Context f8722y = null;

    /* renamed from: z  reason: collision with root package name */
    private static boolean f8723z = false;
    private final int Q = c(f8722y);

    private IdentifierIdClient() {
        D();
        P = new DataBaseOperation(f8722y);
    }

    private void C() {
        Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(new Runnable() {
            public void run() {
                if (IdentifierIdClient.R + IdentifierIdClient.S + IdentifierIdClient.X + IdentifierIdClient.f8697aa + IdentifierIdClient.T + IdentifierIdClient.U + IdentifierIdClient.Z + IdentifierIdClient.f8697aa + IdentifierIdClient.V + IdentifierIdClient.W + IdentifierIdClient.f8698ab + IdentifierIdClient.ac > 0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("oaid", IdentifierIdClient.this.a(IdentifierIdClient.R, IdentifierIdClient.S, IdentifierIdClient.X, IdentifierIdClient.Y));
                    contentValues.put("vaid", IdentifierIdClient.this.a(IdentifierIdClient.T, IdentifierIdClient.U, IdentifierIdClient.Z, IdentifierIdClient.f8697aa));
                    contentValues.put("aaid", IdentifierIdClient.this.a(IdentifierIdClient.V, IdentifierIdClient.W, IdentifierIdClient.f8698ab, IdentifierIdClient.ac));
                    IdentifierIdClient.P.a(7, "vivo", new ContentValues[]{contentValues});
                    int unused = IdentifierIdClient.R = IdentifierIdClient.S = IdentifierIdClient.T = IdentifierIdClient.U = IdentifierIdClient.V = IdentifierIdClient.W = 0;
                    int unused2 = IdentifierIdClient.X = IdentifierIdClient.Y = IdentifierIdClient.Z = IdentifierIdClient.f8697aa = IdentifierIdClient.f8698ab = IdentifierIdClient.ac = 0;
                }
            }
        }, 600, 600, TimeUnit.SECONDS);
    }

    private static void D() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        F = handlerThread;
        handlerThread.start();
        G = new Handler(F.getLooper()) {
            public void handleMessage(Message message) {
                if (message.what == 11) {
                    int i10 = message.getData().getInt("type");
                    try {
                        String a10 = IdentifierIdClient.P.a(i10, message.getData().getString("appid"));
                        if (i10 == 0) {
                            String unused = IdentifierIdClient.H = a10;
                            IdentifierIdClient.c(8, IdentifierIdClient.H);
                        } else if (i10 == 1) {
                            if (a10 != null) {
                                String unused2 = IdentifierIdClient.I = a10;
                            } else {
                                Log.e(IdentifierIdClient.f8699b, "get vaid failed");
                            }
                            IdentifierIdClient.c(9, IdentifierIdClient.I);
                        } else if (i10 == 2) {
                            if (a10 != null) {
                                String unused3 = IdentifierIdClient.J = a10;
                            } else {
                                Log.e(IdentifierIdClient.f8699b, "get aaid failed");
                            }
                            IdentifierIdClient.c(10, IdentifierIdClient.J);
                        } else if (i10 != 3) {
                            if (i10 == 4) {
                                String unused4 = IdentifierIdClient.L = a10;
                            } else if (i10 == 5) {
                                if (a10 != null) {
                                    String unused5 = IdentifierIdClient.M = a10;
                                } else {
                                    Log.e(IdentifierIdClient.f8699b, "get guid failed");
                                }
                            }
                        } else if (a10 != null) {
                            String unused6 = IdentifierIdClient.K = a10;
                        } else {
                            Log.e(IdentifierIdClient.f8699b, "get udid failed");
                        }
                    } catch (Exception e10) {
                        Log.e(IdentifierIdClient.f8699b, "readException:" + e10.toString());
                    }
                    synchronized (IdentifierIdClient.f8708k) {
                        IdentifierIdClient.f8708k.notify();
                    }
                    return;
                }
                Log.e(IdentifierIdClient.f8699b, "message type valid");
            }
        };
    }

    private static void E() {
        boolean z10;
        if ("1".equals(a(f8701d, "0")) || "1".equals(a(f8696a, "0"))) {
            z10 = true;
        } else {
            z10 = false;
        }
        f8723z = z10;
    }

    public String g() {
        String str = J;
        if (str != null) {
            c(2, str);
            return J;
        }
        e(2, "vivo");
        if (D == null) {
            a(f8722y, 2, "vivo");
        }
        c(2, J);
        return J;
    }

    public String h() {
        String str = J;
        if (str != null) {
            c(2, str);
            return J;
        }
        d(2, "vivo");
        if (D == null) {
            a(f8722y, 2, "vivo");
        }
        c(2, J);
        return J;
    }

    public String i() {
        e(4, (String) null);
        return L;
    }

    public String j() {
        String str = M;
        if (str != null) {
            return str;
        }
        e(5, "vivo");
        return M;
    }

    public String k() {
        String str = M;
        if (str != null) {
            return str;
        }
        d(5, "vivo");
        return M;
    }

    private static int c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(f8702e, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public String d() {
        String str = H;
        if (str != null) {
            c(0, str);
            return H;
        }
        d(0, (String) null);
        if (B == null) {
            a(f8722y, 0, (String) null);
        }
        c(0, H);
        return H;
    }

    public String e() {
        String str = I;
        if (str != null) {
            c(1, str);
            return I;
        }
        e(1, "vivo");
        if (C == null) {
            a(f8722y, 1, "vivo");
        }
        c(1, I);
        return I;
    }

    public String f() {
        String str = I;
        if (str != null) {
            c(1, str);
            return I;
        }
        d(1, "vivo");
        if (C == null) {
            a(f8722y, 1, "vivo");
        }
        c(1, I);
        return I;
    }

    /* access modifiers changed from: private */
    public String a(int i10, int i11, int i12, int i13) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i10);
        stringBuffer.append(",");
        stringBuffer.append(i11);
        stringBuffer.append(";");
        stringBuffer.append(i12);
        stringBuffer.append(",");
        stringBuffer.append(i13);
        return stringBuffer.toString();
    }

    public static IdentifierIdClient b(Context context) {
        if (!a()) {
            return null;
        }
        return a(context);
    }

    public static IdentifierIdClient a(Context context) {
        if (f8722y == null) {
            if (context == null) {
                return null;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            f8722y = context;
        }
        if (O == null) {
            synchronized (IdentifierIdClient.class) {
                if (O == null) {
                    O = new IdentifierIdClient();
                    O.C();
                }
            }
        }
        return O;
    }

    public String b() {
        String str = K;
        if (str != null) {
            return str;
        }
        e(3, (String) null);
        return K;
    }

    public String c() {
        String str = H;
        if (str != null) {
            c(0, str);
            return H;
        }
        e(0, (String) null);
        if (B == null) {
            a(f8722y, 0, (String) null);
        }
        c(0, H);
        return H;
    }

    public List b(List<String> list) {
        if (this.Q < A) {
            return null;
        }
        if (list == null || list.size() == 0) {
            Log.e(f8699b, "List is null when delete OAIDBLACK");
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < list.size(); i10++) {
                String[] split = list.get(i10).split(SOAP.DELIM);
                if (split.length == 2) {
                    arrayList.add(Boolean.valueOf(P.a(6, "vivo", split[0], split[1])));
                }
            }
            return arrayList;
        } catch (Exception unused) {
            Log.e(f8699b, "delete OAIDBLACK failure");
            return null;
        }
    }

    private void d(int i10, String str) {
        a(i10, str);
    }

    private void e(int i10, String str) {
        synchronized (f8708k) {
            a(i10, str);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                f8708k.wait(2000);
            } catch (InterruptedException unused) {
                Log.e(f8699b, "queryId: lock error");
            }
            int i11 = ((SystemClock.uptimeMillis() - uptimeMillis) > 2000 ? 1 : ((SystemClock.uptimeMillis() - uptimeMillis) == 2000 ? 0 : -1));
        }
    }

    public static boolean a() {
        if (!f8723z) {
            E();
        }
        return f8723z;
    }

    /* access modifiers changed from: private */
    public static void c(int i10, String str) {
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    switch (i10) {
                        case 8:
                            if (str == null) {
                                Y++;
                                return;
                            } else {
                                X++;
                                return;
                            }
                        case 9:
                            if (str == null) {
                                f8697aa++;
                                return;
                            } else {
                                Z++;
                                return;
                            }
                        case 10:
                            if (str == null) {
                                ac++;
                                return;
                            } else {
                                f8698ab++;
                                return;
                            }
                        default:
                            return;
                    }
                } else if (str == null) {
                    W++;
                } else {
                    V++;
                }
            } else if (str == null) {
                U++;
            } else {
                T++;
            }
        } else if (str == null) {
            S++;
        } else {
            R++;
        }
    }

    public boolean a(List<String> list) {
        if (this.Q < A) {
            return false;
        }
        if (list == null || list.size() == 0) {
            Log.e(f8699b, "List is null when insert OAIDBLACK");
            return false;
        }
        try {
            ContentValues[] contentValuesArr = new ContentValues[list.size()];
            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
            for (int i10 = 0; i10 < list.size(); i10++) {
                ContentValues contentValues = new ContentValues();
                String[] split = list.get(i10).split(SOAP.DELIM);
                if (split.length != 2) {
                    return false;
                }
                String str = split[0];
                String str2 = split[1];
                contentValues.put(Constants.KEY_PACKAGE_NAME, str);
                contentValues.put(ParamsMap.DeviceParams.KEY_UID, str2);
                contentValues.put("value", format);
                contentValuesArr[i10] = contentValues;
            }
            return P.a(6, "vivo", contentValuesArr);
        } catch (Exception unused) {
            Log.e(f8699b, "insert OAIDBLACK failure");
            return false;
        }
    }

    public void a(int i10, String str) {
        Message obtainMessage = G.obtainMessage();
        obtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i10);
        if (i10 == 1 || i10 == 2 || i10 == 6) {
            bundle.putString("appid", str);
        }
        obtainMessage.setData(bundle);
        G.sendMessage(obtainMessage);
    }

    private static String a(String str, String str2) {
        Class<String> cls = String.class;
        try {
            Class<?> cls2 = Class.forName("android.os.SystemProperties");
            return (String) cls2.getMethod("get", new Class[]{cls, cls}).invoke(cls2, new Object[]{str, "0"});
        } catch (Exception e10) {
            Log.e(f8699b, "getProperty: invoke is error" + e10.getMessage());
        } catch (Throwable unused) {
        }
        return str2;
    }

    private static synchronized void a(Context context, int i10, String str) {
        synchronized (IdentifierIdClient.class) {
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        if (D == null) {
                            D = new IdentifierIdObserver(O, 2, str);
                            ContentResolver contentResolver = context.getContentResolver();
                            contentResolver.registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/" + context.getPackageName()), false, D);
                        }
                    }
                } else if (C == null) {
                    C = new IdentifierIdObserver(O, 1, str);
                    ContentResolver contentResolver2 = context.getContentResolver();
                    contentResolver2.registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, C);
                }
            } else if (B == null) {
                B = new IdentifierIdObserver(O, 0, (String) null);
                context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, B);
            }
        }
    }
}
