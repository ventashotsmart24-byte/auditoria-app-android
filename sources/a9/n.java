package a9;

import b9.b;
import b9.f;
import b9.i;
import com.google.common.base.Preconditions;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public abstract class n {

    /* renamed from: a  reason: collision with root package name */
    public static final List f10881a = Collections.unmodifiableList(Arrays.asList(new i[]{i.HTTP_2}));

    public static String a(String str) {
        if (!str.startsWith("[") || !str.endsWith("]")) {
            return str;
        }
        return str.substring(1, str.length() - 1);
    }

    public static SSLSocket b(SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, Socket socket, String str, int i10, b bVar) {
        List list;
        Preconditions.checkNotNull(sSLSocketFactory, "sslSocketFactory");
        Preconditions.checkNotNull(socket, "socket");
        Preconditions.checkNotNull(bVar, "spec");
        SSLSocket sSLSocket = (SSLSocket) sSLSocketFactory.createSocket(socket, str, i10, true);
        bVar.c(sSLSocket, false);
        k e10 = k.e();
        if (bVar.f()) {
            list = f10881a;
        } else {
            list = null;
        }
        String h10 = e10.h(sSLSocket, str, list);
        List list2 = f10881a;
        boolean contains = list2.contains(i.a(h10));
        Preconditions.checkState(contains, "Only " + list2 + " are supported, but negotiated protocol is %s", (Object) h10);
        if (hostnameVerifier == null) {
            hostnameVerifier = f.f11282a;
        }
        if (hostnameVerifier.verify(a(str), sSLSocket.getSession())) {
            return sSLSocket;
        }
        throw new SSLPeerUnverifiedException("Cannot verify hostname: " + str);
    }
}
