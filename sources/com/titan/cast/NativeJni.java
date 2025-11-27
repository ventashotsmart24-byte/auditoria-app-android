package com.titan.cast;

import android.content.Context;
import com.core.sysopt.so.SoOptimizer;
import com.google.gson.Gson;
import com.hpplay.component.common.dlna.IDLNAController;
import com.titan.cast.bean.CastMedia;
import com.titan.cast.bean.CastResult;
import com.titan.cast.bean.Device;
import h9.t;
import java.util.HashMap;
import t9.g;
import t9.i;

public final class NativeJni {

    /* renamed from: b  reason: collision with root package name */
    public static final a f13319b = new a((g) null);

    /* renamed from: c  reason: collision with root package name */
    public static NativeJni f13320c;

    /* renamed from: d  reason: collision with root package name */
    public static Gson f13321d;

    /* renamed from: a  reason: collision with root package name */
    public final String f13322a = "CastNativeJni";

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final NativeJni a() {
            if (NativeJni.f13320c == null) {
                synchronized (NativeJni.class) {
                    if (NativeJni.f13320c == null) {
                        NativeJni.f13320c = new NativeJni();
                        NativeJni.f13321d = new Gson();
                        NativeJni a10 = NativeJni.f13320c;
                        i.d(a10);
                        a10.e();
                    }
                    t tVar = t.f17319a;
                }
            }
            return NativeJni.f13320c;
        }
    }

    static {
        try {
            System.loadLibrary("cast-jni");
        } catch (UnsatisfiedLinkError e10) {
            e10.printStackTrace();
            try {
                SoOptimizer.class.getDeclaredMethod("reloadLibrary", new Class[0]).invoke((Object) null, new Object[]{"cast-jni"});
            } catch (Exception e11) {
                throw new RuntimeException(e11);
            }
        }
    }

    private final native String Call(String str, String str2);

    public final String d() {
        CastResult castResult;
        String Call = Call("GetVersion", "{}");
        Gson gson = f13321d;
        if (gson == null || (castResult = (CastResult) gson.fromJson(Call, CastResult.class)) == null) {
            return null;
        }
        return castResult.getRes();
    }

    public final void e() {
        String str;
        CastResult castResult;
        Context a10 = g8.a.f6838a.a();
        i.d(a10);
        String absolutePath = a10.getDir("cast-dlna", 0).getAbsolutePath();
        HashMap hashMap = new HashMap();
        i.f(absolutePath, "castPath");
        hashMap.put("work_path", absolutePath);
        Gson gson = f13321d;
        String str2 = null;
        if (gson != null) {
            str = gson.toJson((Object) hashMap);
        } else {
            str = null;
        }
        if (str != null) {
            str2 = Call("Init", str);
        }
        Gson gson2 = f13321d;
        if (gson2 != null && (castResult = (CastResult) gson2.fromJson(str2, CastResult.class)) != null) {
            castResult.getErr();
        }
    }

    public final Integer f(String str) {
        CastResult castResult;
        i.g(str, "session");
        String Call = Call(IDLNAController.PAUSE, e8.a.f16526a.e(str));
        Gson gson = f13321d;
        if (gson == null || (castResult = (CastResult) gson.fromJson(Call, CastResult.class)) == null) {
            return null;
        }
        return Integer.valueOf(castResult.getErr());
    }

    public final Integer g(String str) {
        CastResult castResult;
        i.g(str, "session");
        String Call = Call(IDLNAController.RESUME, e8.a.f16526a.e(str));
        Gson gson = f13321d;
        if (gson == null || (castResult = (CastResult) gson.fromJson(Call, CastResult.class)) == null) {
            return null;
        }
        return Integer.valueOf(castResult.getErr());
    }

    public final Integer h() {
        CastResult castResult;
        String Call = Call("StartDiscovery", "{}");
        Gson gson = f13321d;
        if (gson == null || (castResult = (CastResult) gson.fromJson(Call, CastResult.class)) == null) {
            return null;
        }
        return Integer.valueOf(castResult.getErr());
    }

    public final Integer i(String str, long j10) {
        CastResult castResult;
        i.g(str, "session");
        String Call = Call("SeekTo", e8.a.f16526a.b(str, j10));
        Gson gson = f13321d;
        if (gson == null || (castResult = (CastResult) gson.fromJson(Call, CastResult.class)) == null) {
            return null;
        }
        return Integer.valueOf(castResult.getErr());
    }

    public final Integer j(Device device) {
        String str;
        CastResult castResult;
        i.g(device, "deviceInfo");
        Gson gson = f13321d;
        if (gson != null) {
            str = gson.toJson((Object) device);
        } else {
            str = null;
        }
        String Call = Call("SelectDevice", e8.a.f16526a.c(str));
        Gson gson2 = f13321d;
        if (gson2 == null || (castResult = (CastResult) gson2.fromJson(Call, CastResult.class)) == null) {
            return null;
        }
        return Integer.valueOf(castResult.getErr());
    }

    public final Integer k(String str) {
        CastResult castResult;
        i.g(str, "envJson");
        String Call = Call("SetEnv", e8.a.f16526a.a(str));
        Gson gson = f13321d;
        if (gson == null || (castResult = (CastResult) gson.fromJson(Call, CastResult.class)) == null) {
            return null;
        }
        return Integer.valueOf(castResult.getErr());
    }

    public final Integer l(String str, CastMedia castMedia, String str2) {
        String str3;
        CastResult castResult;
        i.g(str, "session");
        i.g(castMedia, "media");
        i.g(str2, "extra");
        Gson gson = f13321d;
        if (gson != null) {
            str3 = gson.toJson((Object) castMedia);
        } else {
            str3 = null;
        }
        String Call = Call("StartPlay", e8.a.f16526a.d(str, str3, str2));
        Gson gson2 = f13321d;
        if (gson2 == null || (castResult = (CastResult) gson2.fromJson(Call, CastResult.class)) == null) {
            return null;
        }
        return Integer.valueOf(castResult.getErr());
    }

    public final Integer m(String str) {
        CastResult castResult;
        i.g(str, "session");
        String Call = Call("StopPlay", e8.a.f16526a.e(str));
        Gson gson = f13321d;
        if (gson == null || (castResult = (CastResult) gson.fromJson(Call, CastResult.class)) == null) {
            return null;
        }
        return Integer.valueOf(castResult.getErr());
    }

    public final Integer n() {
        CastResult castResult;
        String Call = Call("StopDiscovery", "{}");
        Gson gson = f13321d;
        if (gson == null || (castResult = (CastResult) gson.fromJson(Call, CastResult.class)) == null) {
            return null;
        }
        return Integer.valueOf(castResult.getErr());
    }
}
