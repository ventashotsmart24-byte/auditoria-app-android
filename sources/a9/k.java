package a9;

import anet.channel.strategy.dispatch.DispatchConstants;
import b9.g;
import b9.h;
import b9.i;
import b9.l;
import com.google.common.base.Preconditions;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import z8.q0;

public class k {

    /* renamed from: b  reason: collision with root package name */
    public static final Logger f10863b;

    /* renamed from: c  reason: collision with root package name */
    public static final h f10864c = h.e();

    /* renamed from: d  reason: collision with root package name */
    public static k f10865d;

    /* renamed from: a  reason: collision with root package name */
    public final h f10866a;

    public static final class a extends k {

        /* renamed from: e  reason: collision with root package name */
        public static final g f10867e;

        /* renamed from: f  reason: collision with root package name */
        public static final g f10868f;

        /* renamed from: g  reason: collision with root package name */
        public static final g f10869g;

        /* renamed from: h  reason: collision with root package name */
        public static final g f10870h;

        /* renamed from: i  reason: collision with root package name */
        public static final g f10871i;

        /* renamed from: j  reason: collision with root package name */
        public static final g f10872j;

        /* renamed from: k  reason: collision with root package name */
        public static final Method f10873k;

        /* renamed from: l  reason: collision with root package name */
        public static final Method f10874l;

        /* renamed from: m  reason: collision with root package name */
        public static final Method f10875m;

        /* renamed from: n  reason: collision with root package name */
        public static final Method f10876n;

        /* renamed from: o  reason: collision with root package name */
        public static final Method f10877o;

        /* renamed from: p  reason: collision with root package name */
        public static final Method f10878p;

        /* renamed from: q  reason: collision with root package name */
        public static final Constructor f10879q;

        static {
            Method method;
            Method method2;
            Method method3;
            Method method4;
            Method method5;
            Method method6;
            Method method7;
            Method method8;
            Class<?> cls;
            Class<SSLParameters> cls2 = SSLParameters.class;
            Class<SSLSocket> cls3 = SSLSocket.class;
            Class cls4 = Boolean.TYPE;
            Constructor<?> constructor = null;
            f10867e = new g((Class) null, "setUseSessionTickets", cls4);
            Class<String> cls5 = String.class;
            f10868f = new g((Class) null, "setHostname", cls5);
            Class<byte[]> cls6 = byte[].class;
            f10869g = new g(cls6, "getAlpnSelectedProtocol", new Class[0]);
            f10870h = new g((Class) null, "setAlpnProtocols", cls6);
            f10871i = new g(cls6, "getNpnSelectedProtocol", new Class[0]);
            f10872j = new g((Class) null, "setNpnProtocols", cls6);
            try {
                method4 = cls2.getMethod("setApplicationProtocols", new Class[]{String[].class});
                try {
                    method3 = cls2.getMethod("getApplicationProtocols", new Class[0]);
                } catch (ClassNotFoundException e10) {
                    e = e10;
                    method8 = null;
                    method7 = method3;
                    method = method2;
                    k.f10863b.log(Level.FINER, "Failed to find Android 10.0+ APIs", e);
                    method5 = null;
                    f10875m = method4;
                    f10876n = method3;
                    f10877o = method2;
                    f10873k = method;
                    f10874l = method5;
                    method6 = cls2.getMethod("setServerNames", new Class[]{List.class});
                    try {
                        constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(new Class[]{cls5});
                    } catch (ClassNotFoundException e11) {
                        e = e11;
                        k.f10863b.log(Level.FINER, "Failed to find Android 7.0+ APIs", e);
                        f10878p = method6;
                        f10879q = constructor;
                    } catch (NoSuchMethodException e12) {
                        e = e12;
                        k.f10863b.log(Level.FINER, "Failed to find Android 7.0+ APIs", e);
                        f10878p = method6;
                        f10879q = constructor;
                    }
                    f10878p = method6;
                    f10879q = constructor;
                } catch (NoSuchMethodException e13) {
                    e = e13;
                    method3 = null;
                    method2 = method3;
                    method = method2;
                    k.f10863b.log(Level.FINER, "Failed to find Android 10.0+ APIs", e);
                    method5 = null;
                    f10875m = method4;
                    f10876n = method3;
                    f10877o = method2;
                    f10873k = method;
                    f10874l = method5;
                    method6 = cls2.getMethod("setServerNames", new Class[]{List.class});
                    constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(new Class[]{cls5});
                    f10878p = method6;
                    f10879q = constructor;
                }
                try {
                    method2 = cls3.getMethod("getApplicationProtocol", new Class[0]);
                    try {
                        cls = Class.forName("android.net.ssl.SSLSockets");
                        method = cls.getMethod("isSupportedSocket", new Class[]{cls3});
                    } catch (ClassNotFoundException e14) {
                        e = e14;
                        method = null;
                        k.f10863b.log(Level.FINER, "Failed to find Android 10.0+ APIs", e);
                        method5 = null;
                        f10875m = method4;
                        f10876n = method3;
                        f10877o = method2;
                        f10873k = method;
                        f10874l = method5;
                        method6 = cls2.getMethod("setServerNames", new Class[]{List.class});
                        constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(new Class[]{cls5});
                        f10878p = method6;
                        f10879q = constructor;
                    } catch (NoSuchMethodException e15) {
                        e = e15;
                        method = null;
                        k.f10863b.log(Level.FINER, "Failed to find Android 10.0+ APIs", e);
                        method5 = null;
                        f10875m = method4;
                        f10876n = method3;
                        f10877o = method2;
                        f10873k = method;
                        f10874l = method5;
                        method6 = cls2.getMethod("setServerNames", new Class[]{List.class});
                        constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(new Class[]{cls5});
                        f10878p = method6;
                        f10879q = constructor;
                    }
                    try {
                        method5 = cls.getMethod("setUseSessionTickets", new Class[]{cls3, cls4});
                    } catch (ClassNotFoundException e16) {
                        e = e16;
                        k.f10863b.log(Level.FINER, "Failed to find Android 10.0+ APIs", e);
                        method5 = null;
                        f10875m = method4;
                        f10876n = method3;
                        f10877o = method2;
                        f10873k = method;
                        f10874l = method5;
                        method6 = cls2.getMethod("setServerNames", new Class[]{List.class});
                        constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(new Class[]{cls5});
                        f10878p = method6;
                        f10879q = constructor;
                    } catch (NoSuchMethodException e17) {
                        e = e17;
                        k.f10863b.log(Level.FINER, "Failed to find Android 10.0+ APIs", e);
                        method5 = null;
                        f10875m = method4;
                        f10876n = method3;
                        f10877o = method2;
                        f10873k = method;
                        f10874l = method5;
                        method6 = cls2.getMethod("setServerNames", new Class[]{List.class});
                        constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(new Class[]{cls5});
                        f10878p = method6;
                        f10879q = constructor;
                    }
                } catch (ClassNotFoundException e18) {
                    e = e18;
                    method7 = null;
                    method = method2;
                    k.f10863b.log(Level.FINER, "Failed to find Android 10.0+ APIs", e);
                    method5 = null;
                    f10875m = method4;
                    f10876n = method3;
                    f10877o = method2;
                    f10873k = method;
                    f10874l = method5;
                    method6 = cls2.getMethod("setServerNames", new Class[]{List.class});
                    constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(new Class[]{cls5});
                    f10878p = method6;
                    f10879q = constructor;
                } catch (NoSuchMethodException e19) {
                    e = e19;
                    method2 = null;
                    method = method2;
                    k.f10863b.log(Level.FINER, "Failed to find Android 10.0+ APIs", e);
                    method5 = null;
                    f10875m = method4;
                    f10876n = method3;
                    f10877o = method2;
                    f10873k = method;
                    f10874l = method5;
                    method6 = cls2.getMethod("setServerNames", new Class[]{List.class});
                    constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(new Class[]{cls5});
                    f10878p = method6;
                    f10879q = constructor;
                }
            } catch (ClassNotFoundException e20) {
                e = e20;
                method4 = null;
                method8 = null;
                method7 = method3;
                method = method2;
                k.f10863b.log(Level.FINER, "Failed to find Android 10.0+ APIs", e);
                method5 = null;
                f10875m = method4;
                f10876n = method3;
                f10877o = method2;
                f10873k = method;
                f10874l = method5;
                method6 = cls2.getMethod("setServerNames", new Class[]{List.class});
                constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(new Class[]{cls5});
                f10878p = method6;
                f10879q = constructor;
            } catch (NoSuchMethodException e21) {
                e = e21;
                method4 = null;
                method3 = null;
                method2 = method3;
                method = method2;
                k.f10863b.log(Level.FINER, "Failed to find Android 10.0+ APIs", e);
                method5 = null;
                f10875m = method4;
                f10876n = method3;
                f10877o = method2;
                f10873k = method;
                f10874l = method5;
                method6 = cls2.getMethod("setServerNames", new Class[]{List.class});
                constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(new Class[]{cls5});
                f10878p = method6;
                f10879q = constructor;
            }
            f10875m = method4;
            f10876n = method3;
            f10877o = method2;
            f10873k = method;
            f10874l = method5;
            try {
                method6 = cls2.getMethod("setServerNames", new Class[]{List.class});
                constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(new Class[]{cls5});
            } catch (ClassNotFoundException e22) {
                e = e22;
                method6 = null;
                k.f10863b.log(Level.FINER, "Failed to find Android 7.0+ APIs", e);
                f10878p = method6;
                f10879q = constructor;
            } catch (NoSuchMethodException e23) {
                e = e23;
                method6 = null;
                k.f10863b.log(Level.FINER, "Failed to find Android 7.0+ APIs", e);
                f10878p = method6;
                f10879q = constructor;
            }
            f10878p = method6;
            f10879q = constructor;
        }

        public a(h hVar) {
            super(hVar);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.Object[]} */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00dc, code lost:
            r9 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e2, code lost:
            throw new java.lang.RuntimeException(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ea, code lost:
            r9 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f0, code lost:
            throw new java.lang.RuntimeException(r9);
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0049 A[Catch:{ InvocationTargetException -> 0x007a, IllegalAccessException -> 0x00ea, InstantiationException -> 0x00dc, IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }] */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x005d A[Catch:{ InvocationTargetException -> 0x007a, IllegalAccessException -> 0x00ea, InstantiationException -> 0x00dc, IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00ac A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00ad  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00dc A[ExcHandler: InstantiationException (r9v3 'e' java.lang.InstantiationException A[CUSTOM_DECLARE]), Splitter:B:2:0x000c] */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x00ea A[ExcHandler: IllegalAccessException (r9v1 'e' java.lang.IllegalAccessException A[CUSTOM_DECLARE]), Splitter:B:2:0x000c] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c(javax.net.ssl.SSLSocket r9, java.lang.String r10, java.util.List r11) {
            /*
                r8 = this;
                java.lang.String[] r0 = a9.k.i(r11)
                javax.net.ssl.SSLParameters r1 = r9.getSSLParameters()
                r2 = 1
                r3 = 0
                if (r10 == 0) goto L_0x0066
                boolean r4 = a9.k.g(r10)     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                if (r4 == 0) goto L_0x0066
                java.lang.reflect.Method r4 = f10873k     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                if (r4 == 0) goto L_0x0036
                java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                r5[r3] = r9     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                r6 = 0
                java.lang.Object r4 = r4.invoke(r6, r5)     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                boolean r4 = r4.booleanValue()     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                if (r4 == 0) goto L_0x0036
                java.lang.reflect.Method r4 = f10874l     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                r5 = 2
                java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                r5[r3] = r9     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                r5[r2] = r7     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                r4.invoke(r6, r5)     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                goto L_0x0041
            L_0x0036:
                b9.g r4 = f10867e     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                r5[r3] = r6     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                r4.e(r9, r5)     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
            L_0x0041:
                java.lang.reflect.Method r4 = f10878p     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                if (r4 == 0) goto L_0x005d
                java.lang.reflect.Constructor r5 = f10879q     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                if (r5 == 0) goto L_0x005d
                java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                r7[r3] = r10     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                java.lang.Object r10 = r5.newInstance(r7)     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                java.util.List r10 = java.util.Collections.singletonList(r10)     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                r6[r3] = r10     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                r4.invoke(r1, r6)     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                goto L_0x0066
            L_0x005d:
                b9.g r4 = f10868f     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                r5[r3] = r10     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                r4.e(r9, r5)     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
            L_0x0066:
                java.lang.reflect.Method r10 = f10877o     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                if (r10 == 0) goto L_0x0090
                java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ InvocationTargetException -> 0x007a, IllegalAccessException -> 0x00ea, InstantiationException -> 0x00dc }
                r10.invoke(r9, r4)     // Catch:{ InvocationTargetException -> 0x007a, IllegalAccessException -> 0x00ea, InstantiationException -> 0x00dc }
                java.lang.reflect.Method r10 = f10875m     // Catch:{ InvocationTargetException -> 0x007a, IllegalAccessException -> 0x00ea, InstantiationException -> 0x00dc }
                java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ InvocationTargetException -> 0x007a, IllegalAccessException -> 0x00ea, InstantiationException -> 0x00dc }
                r4[r3] = r0     // Catch:{ InvocationTargetException -> 0x007a, IllegalAccessException -> 0x00ea, InstantiationException -> 0x00dc }
                r10.invoke(r1, r4)     // Catch:{ InvocationTargetException -> 0x007a, IllegalAccessException -> 0x00ea, InstantiationException -> 0x00dc }
                r10 = 1
                goto L_0x0091
            L_0x007a:
                r10 = move-exception
                java.lang.Throwable r4 = r10.getTargetException()     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                boolean r4 = r4 instanceof java.lang.UnsupportedOperationException     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                if (r4 == 0) goto L_0x008f
                java.util.logging.Logger r10 = a9.k.f10863b     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                java.util.logging.Level r4 = java.util.logging.Level.FINER     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                java.lang.String r5 = "setApplicationProtocol unsupported, will try old methods"
                r10.log(r4, r5)     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                goto L_0x0090
            L_0x008f:
                throw r10     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
            L_0x0090:
                r10 = 0
            L_0x0091:
                r9.setSSLParameters(r1)     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                if (r10 == 0) goto L_0x00ad
                java.lang.reflect.Method r10 = f10876n     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                if (r10 == 0) goto L_0x00ad
                javax.net.ssl.SSLParameters r1 = r9.getSSLParameters()     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                java.lang.Object r10 = r10.invoke(r1, r4)     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                java.lang.String[] r10 = (java.lang.String[]) r10     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                boolean r10 = java.util.Arrays.equals(r0, r10)     // Catch:{ IllegalAccessException -> 0x00ea, InvocationTargetException -> 0x00e3, InstantiationException -> 0x00dc }
                if (r10 == 0) goto L_0x00ad
                return
            L_0x00ad:
                java.lang.Object[] r10 = new java.lang.Object[r2]
                byte[] r11 = b9.h.b(r11)
                r10[r3] = r11
                b9.h r11 = r8.f10866a
                b9.h$h r11 = r11.i()
                b9.h$h r0 = b9.h.C0150h.ALPN_AND_NPN
                if (r11 != r0) goto L_0x00c4
                b9.g r11 = f10870h
                r11.f(r9, r10)
            L_0x00c4:
                b9.h r11 = r8.f10866a
                b9.h$h r11 = r11.i()
                b9.h$h r0 = b9.h.C0150h.NONE
                if (r11 == r0) goto L_0x00d4
                b9.g r11 = f10872j
                r11.f(r9, r10)
                return
            L_0x00d4:
                java.lang.RuntimeException r9 = new java.lang.RuntimeException
                java.lang.String r10 = "We can not do TLS handshake on this Android version, please install the Google Play Services Dynamic Security Provider to use TLS"
                r9.<init>(r10)
                throw r9
            L_0x00dc:
                r9 = move-exception
                java.lang.RuntimeException r10 = new java.lang.RuntimeException
                r10.<init>(r9)
                throw r10
            L_0x00e3:
                r9 = move-exception
                java.lang.RuntimeException r10 = new java.lang.RuntimeException
                r10.<init>(r9)
                throw r10
            L_0x00ea:
                r9 = move-exception
                java.lang.RuntimeException r10 = new java.lang.RuntimeException
                r10.<init>(r9)
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: a9.k.a.c(javax.net.ssl.SSLSocket, java.lang.String, java.util.List):void");
        }

        public String f(SSLSocket sSLSocket) {
            Method method = f10877o;
            if (method != null) {
                try {
                    return (String) method.invoke(sSLSocket, new Object[0]);
                } catch (IllegalAccessException e10) {
                    throw new RuntimeException(e10);
                } catch (InvocationTargetException e11) {
                    if (e11.getTargetException() instanceof UnsupportedOperationException) {
                        k.f10863b.log(Level.FINER, "Socket unsupported for getApplicationProtocol, will try old methods");
                    } else {
                        throw new RuntimeException(e11);
                    }
                }
            }
            if (this.f10866a.i() == h.C0150h.ALPN_AND_NPN) {
                try {
                    byte[] bArr = (byte[]) f10869g.f(sSLSocket, new Object[0]);
                    if (bArr != null) {
                        return new String(bArr, l.f11329b);
                    }
                } catch (Exception e12) {
                    k.f10863b.log(Level.FINE, "Failed calling getAlpnSelectedProtocol()", e12);
                }
            }
            if (this.f10866a.i() == h.C0150h.NONE) {
                return null;
            }
            try {
                byte[] bArr2 = (byte[]) f10871i.f(sSLSocket, new Object[0]);
                if (bArr2 != null) {
                    return new String(bArr2, l.f11329b);
                }
                return null;
            } catch (Exception e13) {
                k.f10863b.log(Level.FINE, "Failed calling getNpnSelectedProtocol()", e13);
                return null;
            }
        }

        public String h(SSLSocket sSLSocket, String str, List list) {
            String f10 = f(sSLSocket);
            if (f10 == null) {
                return k.super.h(sSLSocket, str, list);
            }
            return f10;
        }
    }

    static {
        Class<k> cls = k.class;
        f10863b = Logger.getLogger(cls.getName());
        f10865d = d(cls.getClassLoader());
    }

    public k(h hVar) {
        this.f10866a = (h) Preconditions.checkNotNull(hVar, DispatchConstants.PLATFORM);
    }

    public static k d(ClassLoader classLoader) {
        boolean z10;
        try {
            classLoader.loadClass("com.android.org.conscrypt.OpenSSLSocketImpl");
        } catch (ClassNotFoundException e10) {
            f10863b.log(Level.FINE, "Unable to find Conscrypt. Skipping", e10);
            try {
                classLoader.loadClass("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
            } catch (ClassNotFoundException e11) {
                f10863b.log(Level.FINE, "Unable to find any OpenSSLSocketImpl. Skipping", e11);
                z10 = false;
            }
        }
        z10 = true;
        if (z10) {
            return new a(f10864c);
        }
        return new k(f10864c);
    }

    public static k e() {
        return f10865d;
    }

    public static boolean g(String str) {
        if (str.contains("_")) {
            return false;
        }
        try {
            q0.c(str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public static String[] i(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((i) it.next()).toString());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public void c(SSLSocket sSLSocket, String str, List list) {
        this.f10866a.c(sSLSocket, str, list);
    }

    public String f(SSLSocket sSLSocket) {
        return this.f10866a.h(sSLSocket);
    }

    public String h(SSLSocket sSLSocket, String str, List list) {
        if (list != null) {
            c(sSLSocket, str, list);
        }
        try {
            sSLSocket.startHandshake();
            String f10 = f(sSLSocket);
            if (f10 != null) {
                return f10;
            }
            throw new RuntimeException("TLS ALPN negotiation failed with protocols: " + list);
        } finally {
            this.f10866a.a(sSLSocket);
        }
    }
}
