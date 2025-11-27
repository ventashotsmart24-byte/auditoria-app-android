package anet.channel.util;

import android.net.SSLCertificateSocketFactory;
import com.taobao.accs.common.Constants;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class j extends SSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    private final String f4025a = "awcn.TlsSniSocketFactory";

    /* renamed from: b  reason: collision with root package name */
    private Method f4026b = null;

    /* renamed from: c  reason: collision with root package name */
    private String f4027c;

    public j(String str) {
        this.f4027c = str;
    }

    public Socket createSocket() {
        return null;
    }

    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getSupportedCipherSuites() {
        return new String[0];
    }

    public Socket createSocket(String str, int i10) {
        return null;
    }

    public Socket createSocket(String str, int i10, InetAddress inetAddress, int i11) {
        return null;
    }

    public Socket createSocket(InetAddress inetAddress, int i10) {
        return null;
    }

    public Socket createSocket(InetAddress inetAddress, int i10, InetAddress inetAddress2, int i11) {
        return null;
    }

    public Socket createSocket(Socket socket, String str, int i10, boolean z10) {
        if (this.f4027c == null) {
            this.f4027c = str;
        }
        if (ALog.isPrintLog(1)) {
            ALog.i("awcn.TlsSniSocketFactory", "customized createSocket", (String) null, Constants.KEY_HOST, this.f4027c);
        }
        InetAddress inetAddress = socket.getInetAddress();
        if (z10) {
            socket.close();
        }
        SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
        SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, i10);
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        sSLCertificateSocketFactory.setHostname(sSLSocket, this.f4027c);
        SSLSession session = sSLSocket.getSession();
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.TlsSniSocketFactory", (String) null, (String) null, "SSLSession PeerHost", session.getPeerHost());
        }
        return sSLSocket;
    }
}
