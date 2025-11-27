package b9;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.PrivilegedExceptionAction;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import okio.Buffer;

public class h {

    /* renamed from: b  reason: collision with root package name */
    public static final Logger f11287b = Logger.getLogger(h.class.getName());

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f11288c = {"com.google.android.gms.org.conscrypt.OpenSSLProvider", "org.conscrypt.OpenSSLProvider", "com.android.org.conscrypt.OpenSSLProvider", "org.apache.harmony.xnet.provider.jsse.OpenSSLProvider", "com.google.android.libraries.stitch.sslguard.SslGuardProvider"};

    /* renamed from: d  reason: collision with root package name */
    public static final h f11289d = d();

    /* renamed from: a  reason: collision with root package name */
    public final Provider f11290a;

    public class a implements PrivilegedExceptionAction {
        /* renamed from: a */
        public Method run() {
            return SSLEngine.class.getMethod("getApplicationProtocol", new Class[0]);
        }
    }

    public class b implements PrivilegedExceptionAction {
        /* renamed from: a */
        public Method run() {
            return SSLParameters.class.getMethod("setApplicationProtocols", new Class[]{String[].class});
        }
    }

    public class c implements PrivilegedExceptionAction {
        /* renamed from: a */
        public Method run() {
            return SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);
        }
    }

    public static class d extends h {

        /* renamed from: e  reason: collision with root package name */
        public final g f11291e;

        /* renamed from: f  reason: collision with root package name */
        public final g f11292f;

        /* renamed from: g  reason: collision with root package name */
        public final Method f11293g;

        /* renamed from: h  reason: collision with root package name */
        public final Method f11294h;

        /* renamed from: i  reason: collision with root package name */
        public final g f11295i;

        /* renamed from: j  reason: collision with root package name */
        public final g f11296j;

        /* renamed from: k  reason: collision with root package name */
        public final C0150h f11297k;

        public d(g gVar, g gVar2, Method method, Method method2, g gVar3, g gVar4, Provider provider, C0150h hVar) {
            super(provider);
            this.f11291e = gVar;
            this.f11292f = gVar2;
            this.f11293g = method;
            this.f11294h = method2;
            this.f11295i = gVar3;
            this.f11296j = gVar4;
            this.f11297k = hVar;
        }

        public void c(SSLSocket sSLSocket, String str, List list) {
            if (str != null) {
                this.f11291e.e(sSLSocket, Boolean.TRUE);
                this.f11292f.e(sSLSocket, str);
            }
            if (this.f11296j.g(sSLSocket)) {
                this.f11296j.f(sSLSocket, h.b(list));
            }
        }

        public String h(SSLSocket sSLSocket) {
            byte[] bArr;
            if (this.f11295i.g(sSLSocket) && (bArr = (byte[]) this.f11295i.f(sSLSocket, new Object[0])) != null) {
                return new String(bArr, l.f11329b);
            }
            return null;
        }

        public C0150h i() {
            return this.f11297k;
        }
    }

    public static class e extends h {

        /* renamed from: e  reason: collision with root package name */
        public final Method f11298e;

        /* renamed from: f  reason: collision with root package name */
        public final Method f11299f;

        public /* synthetic */ e(Provider provider, Method method, Method method2, a aVar) {
            this(provider, method, method2);
        }

        public void c(SSLSocket sSLSocket, String str, List list) {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                i iVar = (i) it.next();
                if (iVar != i.HTTP_1_0) {
                    arrayList.add(iVar.toString());
                }
            }
            try {
                this.f11298e.invoke(sSLParameters, new Object[]{arrayList.toArray(new String[arrayList.size()])});
                sSLSocket.setSSLParameters(sSLParameters);
            } catch (IllegalAccessException e10) {
                throw new RuntimeException(e10);
            } catch (InvocationTargetException e11) {
                throw new RuntimeException(e11);
            }
        }

        public String h(SSLSocket sSLSocket) {
            try {
                return (String) this.f11299f.invoke(sSLSocket, new Object[0]);
            } catch (IllegalAccessException e10) {
                throw new RuntimeException(e10);
            } catch (InvocationTargetException e11) {
                throw new RuntimeException(e11);
            }
        }

        public C0150h i() {
            return C0150h.ALPN_AND_NPN;
        }

        public e(Provider provider, Method method, Method method2) {
            super(provider);
            this.f11298e = method;
            this.f11299f = method2;
        }
    }

    public static class f extends h {

        /* renamed from: e  reason: collision with root package name */
        public final Method f11300e;

        /* renamed from: f  reason: collision with root package name */
        public final Method f11301f;

        /* renamed from: g  reason: collision with root package name */
        public final Method f11302g;

        /* renamed from: h  reason: collision with root package name */
        public final Class f11303h;

        /* renamed from: i  reason: collision with root package name */
        public final Class f11304i;

        public f(Method method, Method method2, Method method3, Class cls, Class cls2, Provider provider) {
            super(provider);
            this.f11300e = method;
            this.f11301f = method2;
            this.f11302g = method3;
            this.f11303h = cls;
            this.f11304i = cls2;
        }

        public void a(SSLSocket sSLSocket) {
            try {
                this.f11302g.invoke((Object) null, new Object[]{sSLSocket});
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e10) {
                h.f11287b.log(Level.FINE, "Failed to remove SSLSocket from Jetty ALPN", e10);
            }
        }

        public void c(SSLSocket sSLSocket, String str, List list) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                i iVar = (i) list.get(i10);
                if (iVar != i.HTTP_1_0) {
                    arrayList.add(iVar.toString());
                }
            }
            try {
                Object newProxyInstance = Proxy.newProxyInstance(h.class.getClassLoader(), new Class[]{this.f11303h, this.f11304i}, new g(arrayList));
                this.f11300e.invoke((Object) null, new Object[]{sSLSocket, newProxyInstance});
            } catch (InvocationTargetException e10) {
                throw new AssertionError(e10);
            } catch (IllegalAccessException e11) {
                throw new AssertionError(e11);
            }
        }

        public String h(SSLSocket sSLSocket) {
            try {
                g gVar = (g) Proxy.getInvocationHandler(this.f11301f.invoke((Object) null, new Object[]{sSLSocket}));
                if (!gVar.f11306b && gVar.f11307c == null) {
                    h.f11287b.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                    return null;
                } else if (gVar.f11306b) {
                    return null;
                } else {
                    return gVar.f11307c;
                }
            } catch (InvocationTargetException unused) {
                throw new AssertionError();
            } catch (IllegalAccessException unused2) {
                throw new AssertionError();
            }
        }

        public C0150h i() {
            return C0150h.ALPN_AND_NPN;
        }
    }

    public static class g implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        public final List f11305a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f11306b;

        /* renamed from: c  reason: collision with root package name */
        public String f11307c;

        public g(List list) {
            this.f11305a = list;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = l.f11328a;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f11306b = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f11305a;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1) {
                    Object obj2 = objArr[0];
                    if (obj2 instanceof List) {
                        List list = (List) obj2;
                        int size = list.size();
                        for (int i10 = 0; i10 < size; i10++) {
                            if (this.f11305a.contains(list.get(i10))) {
                                String str = (String) list.get(i10);
                                this.f11307c = str;
                                return str;
                            }
                        }
                        String str2 = (String) this.f11305a.get(0);
                        this.f11307c = str2;
                        return str2;
                    }
                }
                if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                }
                this.f11307c = (String) objArr[0];
                return null;
            }
        }
    }

    /* renamed from: b9.h$h  reason: collision with other inner class name */
    public enum C0150h {
        ALPN_AND_NPN,
        NPN,
        NONE
    }

    public h(Provider provider) {
        this.f11290a = provider;
    }

    public static byte[] b(List list) {
        Buffer buffer = new Buffer();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            i iVar = (i) list.get(i10);
            if (iVar != i.HTTP_1_0) {
                buffer.writeByte(iVar.toString().length());
                buffer.writeUtf8(iVar.toString());
            }
        }
        return buffer.readByteArray();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0098  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static b9.h d() {
        /*
            java.lang.Class<java.net.Socket> r0 = java.net.Socket.class
            java.lang.Class<javax.net.ssl.SSLSocket> r1 = javax.net.ssl.SSLSocket.class
            java.security.Provider r9 = f()
            r2 = 1
            r3 = 0
            r4 = 0
            if (r9 == 0) goto L_0x00a5
            b9.g r1 = new b9.g
            java.lang.Class[] r5 = new java.lang.Class[r2]
            java.lang.Class r6 = java.lang.Boolean.TYPE
            r5[r4] = r6
            java.lang.String r6 = "setUseSessionTickets"
            r1.<init>(r3, r6, r5)
            b9.g r5 = new b9.g
            java.lang.Class[] r6 = new java.lang.Class[r2]
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r6[r4] = r7
            java.lang.String r7 = "setHostname"
            r5.<init>(r3, r7, r6)
            b9.g r7 = new b9.g
            java.lang.String r6 = "getAlpnSelectedProtocol"
            java.lang.Class[] r8 = new java.lang.Class[r4]
            java.lang.Class<byte[]> r10 = byte[].class
            r7.<init>(r10, r6, r8)
            b9.g r8 = new b9.g
            java.lang.Class[] r6 = new java.lang.Class[r2]
            r6[r4] = r10
            java.lang.String r10 = "setAlpnProtocols"
            r8.<init>(r3, r10, r6)
            java.lang.String r6 = "android.net.TrafficStats"
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x005b }
            java.lang.String r10 = "tagSocket"
            java.lang.Class[] r11 = new java.lang.Class[r2]     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x005b }
            r11[r4] = r0     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x005b }
            java.lang.reflect.Method r10 = r6.getMethod(r10, r11)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x005b }
            java.lang.String r11 = "untagSocket"
            java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0059 }
            r2[r4] = r0     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0059 }
            java.lang.reflect.Method r0 = r6.getMethod(r11, r2)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0059 }
            r6 = r0
            goto L_0x005e
        L_0x0059:
            goto L_0x005d
        L_0x005b:
            r10 = r3
        L_0x005d:
            r6 = r3
        L_0x005e:
            java.lang.String r0 = r9.getName()
            java.lang.String r2 = "GmsCore_OpenSSL"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0098
            java.lang.String r0 = r9.getName()
            java.lang.String r2 = "Conscrypt"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0098
            java.lang.String r0 = r9.getName()
            java.lang.String r2 = "Ssl_Guard"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0083
            goto L_0x0098
        L_0x0083:
            boolean r0 = k()
            if (r0 == 0) goto L_0x008c
            b9.h$h r0 = b9.h.C0150h.ALPN_AND_NPN
            goto L_0x009a
        L_0x008c:
            boolean r0 = j()
            if (r0 == 0) goto L_0x0095
            b9.h$h r0 = b9.h.C0150h.NPN
            goto L_0x009a
        L_0x0095:
            b9.h$h r0 = b9.h.C0150h.NONE
            goto L_0x009a
        L_0x0098:
            b9.h$h r0 = b9.h.C0150h.ALPN_AND_NPN
        L_0x009a:
            b9.h$d r11 = new b9.h$d
            r2 = r11
            r3 = r1
            r4 = r5
            r5 = r10
            r10 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r11
        L_0x00a5:
            javax.net.ssl.SSLContext r0 = javax.net.ssl.SSLContext.getDefault()     // Catch:{ NoSuchAlgorithmException -> 0x015c }
            java.security.Provider r0 = r0.getProvider()     // Catch:{ NoSuchAlgorithmException -> 0x015c }
            java.lang.String r5 = "TLS"
            javax.net.ssl.SSLContext r5 = javax.net.ssl.SSLContext.getInstance(r5, r0)     // Catch:{ IllegalAccessException | InvocationTargetException | KeyManagementException | NoSuchAlgorithmException | PrivilegedActionException -> 0x00e6 }
            r5.init(r3, r3, r3)     // Catch:{ IllegalAccessException | InvocationTargetException | KeyManagementException | NoSuchAlgorithmException | PrivilegedActionException -> 0x00e6 }
            javax.net.ssl.SSLEngine r5 = r5.createSSLEngine()     // Catch:{ IllegalAccessException | InvocationTargetException | KeyManagementException | NoSuchAlgorithmException | PrivilegedActionException -> 0x00e6 }
            b9.h$a r6 = new b9.h$a     // Catch:{ IllegalAccessException | InvocationTargetException | KeyManagementException | NoSuchAlgorithmException | PrivilegedActionException -> 0x00e6 }
            r6.<init>()     // Catch:{ IllegalAccessException | InvocationTargetException | KeyManagementException | NoSuchAlgorithmException | PrivilegedActionException -> 0x00e6 }
            java.lang.Object r6 = java.security.AccessController.doPrivileged(r6)     // Catch:{ IllegalAccessException | InvocationTargetException | KeyManagementException | NoSuchAlgorithmException | PrivilegedActionException -> 0x00e6 }
            java.lang.reflect.Method r6 = (java.lang.reflect.Method) r6     // Catch:{ IllegalAccessException | InvocationTargetException | KeyManagementException | NoSuchAlgorithmException | PrivilegedActionException -> 0x00e6 }
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ IllegalAccessException | InvocationTargetException | KeyManagementException | NoSuchAlgorithmException | PrivilegedActionException -> 0x00e6 }
            r6.invoke(r5, r7)     // Catch:{ IllegalAccessException | InvocationTargetException | KeyManagementException | NoSuchAlgorithmException | PrivilegedActionException -> 0x00e6 }
            b9.h$b r5 = new b9.h$b     // Catch:{ IllegalAccessException | InvocationTargetException | KeyManagementException | NoSuchAlgorithmException | PrivilegedActionException -> 0x00e6 }
            r5.<init>()     // Catch:{ IllegalAccessException | InvocationTargetException | KeyManagementException | NoSuchAlgorithmException | PrivilegedActionException -> 0x00e6 }
            java.lang.Object r5 = java.security.AccessController.doPrivileged(r5)     // Catch:{ IllegalAccessException | InvocationTargetException | KeyManagementException | NoSuchAlgorithmException | PrivilegedActionException -> 0x00e6 }
            java.lang.reflect.Method r5 = (java.lang.reflect.Method) r5     // Catch:{ IllegalAccessException | InvocationTargetException | KeyManagementException | NoSuchAlgorithmException | PrivilegedActionException -> 0x00e6 }
            b9.h$c r6 = new b9.h$c     // Catch:{ IllegalAccessException | InvocationTargetException | KeyManagementException | NoSuchAlgorithmException | PrivilegedActionException -> 0x00e6 }
            r6.<init>()     // Catch:{ IllegalAccessException | InvocationTargetException | KeyManagementException | NoSuchAlgorithmException | PrivilegedActionException -> 0x00e6 }
            java.lang.Object r6 = java.security.AccessController.doPrivileged(r6)     // Catch:{ IllegalAccessException | InvocationTargetException | KeyManagementException | NoSuchAlgorithmException | PrivilegedActionException -> 0x00e6 }
            java.lang.reflect.Method r6 = (java.lang.reflect.Method) r6     // Catch:{ IllegalAccessException | InvocationTargetException | KeyManagementException | NoSuchAlgorithmException | PrivilegedActionException -> 0x00e6 }
            b9.h$e r7 = new b9.h$e     // Catch:{ IllegalAccessException | InvocationTargetException | KeyManagementException | NoSuchAlgorithmException | PrivilegedActionException -> 0x00e6 }
            r7.<init>(r0, r5, r6, r3)     // Catch:{ IllegalAccessException | InvocationTargetException | KeyManagementException | NoSuchAlgorithmException | PrivilegedActionException -> 0x00e6 }
            return r7
        L_0x00e6:
            java.lang.String r3 = "org.eclipse.jetty.alpn.ALPN"
            java.lang.String r5 = "org.eclipse.jetty.alpn.ALPN"
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0156 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0156 }
            r6.<init>()     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0156 }
            r6.append(r3)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0156 }
            java.lang.String r7 = "$Provider"
            r6.append(r7)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0156 }
            java.lang.String r6 = r6.toString()     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0156 }
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0156 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0156 }
            r7.<init>()     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0156 }
            r7.append(r3)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0156 }
            java.lang.String r8 = "$ClientProvider"
            r7.append(r8)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0156 }
            java.lang.String r7 = r7.toString()     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0156 }
            java.lang.Class r9 = java.lang.Class.forName(r7)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0156 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0156 }
            r7.<init>()     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0156 }
            r7.append(r3)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0156 }
            java.lang.String r3 = "$ServerProvider"
            r7.append(r3)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0156 }
            java.lang.String r3 = r7.toString()     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0156 }
            java.lang.Class r10 = java.lang.Class.forName(r3)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0156 }
            java.lang.String r3 = "put"
            r7 = 2
            java.lang.Class[] r7 = new java.lang.Class[r7]     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0156 }
            r7[r4] = r1     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0156 }
            r7[r2] = r6     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0156 }
            java.lang.reflect.Method r6 = r5.getMethod(r3, r7)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0156 }
            java.lang.String r3 = "get"
            java.lang.Class[] r7 = new java.lang.Class[r2]     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0156 }
            r7[r4] = r1     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0156 }
            java.lang.reflect.Method r7 = r5.getMethod(r3, r7)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0156 }
            java.lang.String r3 = "remove"
            java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0156 }
            r2[r4] = r1     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0156 }
            java.lang.reflect.Method r8 = r5.getMethod(r3, r2)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0156 }
            b9.h$f r1 = new b9.h$f     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0156 }
            r5 = r1
            r11 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x0156 }
            return r1
        L_0x0156:
            b9.h r1 = new b9.h
            r1.<init>(r0)
            return r1
        L_0x015c:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b9.h.d():b9.h");
    }

    public static h e() {
        return f11289d;
    }

    public static Provider f() {
        for (Provider provider : Security.getProviders()) {
            for (String str : f11288c) {
                if (str.equals(provider.getClass().getName())) {
                    f11287b.log(Level.FINE, "Found registered provider {0}", str);
                    return provider;
                }
            }
        }
        f11287b.log(Level.WARNING, "Unable to find Conscrypt");
        return null;
    }

    public static boolean j() {
        try {
            h.class.getClassLoader().loadClass("android.app.ActivityOptions");
            return true;
        } catch (ClassNotFoundException e10) {
            f11287b.log(Level.FINE, "Can't find class", e10);
            return false;
        }
    }

    public static boolean k() {
        try {
            h.class.getClassLoader().loadClass("android.net.Network");
            return true;
        } catch (ClassNotFoundException e10) {
            f11287b.log(Level.FINE, "Can't find class", e10);
            return false;
        }
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void c(SSLSocket sSLSocket, String str, List list) {
    }

    public Provider g() {
        return this.f11290a;
    }

    public String h(SSLSocket sSLSocket) {
        return null;
    }

    public C0150h i() {
        return C0150h.NONE;
    }
}
