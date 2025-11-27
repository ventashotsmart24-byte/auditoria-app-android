package com.uc.crashsdk;

import android.os.Bundle;
import android.webkit.ValueCallback;
import com.uc.crashsdk.a.a;
import com.uc.crashsdk.a.g;
import com.uc.crashsdk.export.ICrashClient;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static ICrashClient f13556a = null;

    /* renamed from: b  reason: collision with root package name */
    private static int f13557b = 3;

    /* renamed from: c  reason: collision with root package name */
    private static volatile List<ValueCallback<Bundle>> f13558c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile List<ValueCallback<Bundle>> f13559d;

    /* renamed from: e  reason: collision with root package name */
    private static volatile List<ValueCallback<Bundle>> f13560e;

    /* renamed from: f  reason: collision with root package name */
    private static volatile List<ValueCallback<Bundle>> f13561f;

    /* renamed from: g  reason: collision with root package name */
    private static final Object f13562g = new Object();

    public static void a(ICrashClient iCrashClient) {
        f13556a = iCrashClient;
    }

    public static boolean b(ValueCallback<Bundle> valueCallback) {
        if (f13559d == null) {
            synchronized (f13562g) {
                if (f13559d == null) {
                    f13559d = new ArrayList();
                }
            }
        }
        synchronized (f13559d) {
            if (f13559d.size() >= f13557b) {
                return false;
            }
            f13559d.add(valueCallback);
            return true;
        }
    }

    public static boolean c(ValueCallback<Bundle> valueCallback) {
        if (f13560e == null) {
            synchronized (f13562g) {
                if (f13560e == null) {
                    f13560e = new ArrayList();
                }
            }
        }
        synchronized (f13560e) {
            if (f13560e.size() >= f13557b) {
                return false;
            }
            f13560e.add(valueCallback);
            return true;
        }
    }

    public static boolean d(ValueCallback<Bundle> valueCallback) {
        if (f13561f == null) {
            synchronized (f13562g) {
                if (f13561f == null) {
                    f13561f = new ArrayList();
                }
            }
        }
        synchronized (f13561f) {
            if (f13561f.size() >= f13557b) {
                return false;
            }
            f13561f.add(valueCallback);
            return true;
        }
    }

    public static void a(String str, String str2, String str3) {
        if (g.a(str)) {
            a.a("crashsdk", "onLogGenerated file name is null!", (Throwable) null);
            return;
        }
        boolean equals = e.h().equals(str2);
        if (f13556a != null) {
            File file = new File(str);
            if (equals) {
                try {
                    f13556a.onLogGenerated(file, str3);
                } catch (Throwable th) {
                    g.a(th);
                }
            } else {
                f13556a.onClientProcessLogGenerated(str2, file, str3);
            }
        }
        List<ValueCallback<Bundle>> list = f13558c;
        if (!equals) {
            list = f13559d;
        }
        if (list != null) {
            synchronized (list) {
                for (ValueCallback next : list) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putString("filePathName", str);
                        if (!equals) {
                            bundle.putString("processName", str2);
                        }
                        bundle.putString("logType", str3);
                        next.onReceiveValue(bundle);
                    } catch (Throwable th2) {
                        g.a(th2);
                    }
                }
            }
        }
    }

    public static File a(File file) {
        ICrashClient iCrashClient = f13556a;
        if (iCrashClient != null) {
            try {
                return iCrashClient.onBeforeUploadLog(file);
            } catch (Throwable th) {
                g.a(th);
            }
        }
        return file;
    }

    public static void a(boolean z10) {
        ICrashClient iCrashClient = f13556a;
        if (iCrashClient != null) {
            try {
                iCrashClient.onCrashRestarting(z10);
            } catch (Throwable th) {
                g.a(th);
            }
        }
        if (f13560e != null) {
            synchronized (f13560e) {
                for (ValueCallback next : f13560e) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("isJava", z10);
                        next.onReceiveValue(bundle);
                    } catch (Throwable th2) {
                        g.a(th2);
                    }
                }
            }
        }
    }

    public static void a(String str, int i10, int i11) {
        ICrashClient iCrashClient = f13556a;
        if (iCrashClient != null) {
            iCrashClient.onAddCrashStats(str, i10, i11);
        }
        if (f13561f != null) {
            synchronized (f13561f) {
                for (ValueCallback next : f13561f) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putString("processName", str);
                        bundle.putInt("key", i10);
                        bundle.putInt("count", i11);
                        next.onReceiveValue(bundle);
                    } catch (Throwable th) {
                        g.a(th);
                    }
                }
            }
        }
    }

    public static String a(String str, boolean z10) {
        ICrashClient iCrashClient = f13556a;
        return iCrashClient != null ? iCrashClient.onGetCallbackInfo(str, z10) : "";
    }

    public static boolean a(ValueCallback<Bundle> valueCallback) {
        if (f13558c == null) {
            synchronized (f13562g) {
                if (f13558c == null) {
                    f13558c = new ArrayList();
                }
            }
        }
        synchronized (f13558c) {
            if (f13558c.size() >= f13557b) {
                return false;
            }
            f13558c.add(valueCallback);
            return true;
        }
    }
}
