package com.hpplay.component.protocol;

import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.protocol.encrypt.LelinkEncrypt;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Random;

public class ProtocolCore {
    public static final String BROADCAST_IP_NAME = "255.255.255.255";
    private static final int BROWSE_PORT = 25353;
    private static final int DATA_PACKET_LENGTH = 256;
    public static final String ERR_MSG_DETAIL = "sink is not response";
    private static final int RECEIVE_DATA_PACKET_LENGTH = 2048;
    private static final String TAG = "ProtocolCreater";
    private static final int TCP_KEEP_ALIVE_TIMEOUT = 30000;
    private static final int TCP_READ_DATA_TIMEOUT = 10000;
    private static final int TCP_TIMEOUT = 30000;
    public static boolean USE_LOOPBACK_ADDR = false;
    public static boolean USE_ONLY_IPV4_ADDR = true;
    public static boolean USE_ONLY_IPV6_ADDR = false;
    private static byte[] data = new byte[256];
    private static String ifAddress = "";
    public static final Random random = new Random();
    private static byte[] rcData = new byte[2048];
    public DatagramSocket mBrowseBroadCast;
    private DatagramPacket mBrowsePacket = new DatagramPacket(data, 256);
    public DatagramSocket mBrowseServSocket;
    public int mErrorCode = 0;
    public String mErrorMsg = "unknow";
    public String mIP;
    public ParcelFileDescriptor.AutoCloseInputStream mLocalAutoCloseInputStream;
    public FileDescriptor mLocalFileDescriptor;
    public FileOutputStream mLocalFileOutputStream;
    public ServerSocket mMirrorEventServer;
    public ParcelFileDescriptor mPfd;
    public int mPort;
    public DatagramPacket mReceiverPacket = new DatagramPacket(rcData, 2048);
    public Socket mSocket = null;

    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x000d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void bindLocal(java.net.Socket r3, java.net.InetAddress r4) {
        /*
            r2 = this;
            java.net.InetSocketAddress r0 = new java.net.InetSocketAddress     // Catch:{ Exception -> 0x000d }
            int r1 = getAvailablePort()     // Catch:{ Exception -> 0x000d }
            r0.<init>(r4, r1)     // Catch:{ Exception -> 0x000d }
            r3.bind(r0)     // Catch:{ Exception -> 0x000d }
            goto L_0x0026
        L_0x000d:
            java.net.InetSocketAddress r0 = new java.net.InetSocketAddress     // Catch:{ Exception -> 0x001a }
            int r1 = getAvailablePort()     // Catch:{ Exception -> 0x001a }
            r0.<init>(r4, r1)     // Catch:{ Exception -> 0x001a }
            r3.bind(r0)     // Catch:{ Exception -> 0x001a }
            goto L_0x0026
        L_0x001a:
            java.net.InetSocketAddress r0 = new java.net.InetSocketAddress
            int r1 = getAvailablePort()
            r0.<init>(r4, r1)
            r3.bind(r0)
        L_0x0026:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.component.protocol.ProtocolCore.bindLocal(java.net.Socket, java.net.InetAddress):void");
    }

    public static int getAvailablePort() {
        int i10 = 10090;
        try {
            Random random2 = random;
            i10 = random2.nextInt(1000) + random2.nextInt(10000) + 10000;
            int i11 = i10;
            while (i11 <= 65535) {
                try {
                    new ServerSocket(i11).close();
                    CLog.i(TAG, "get availabel port " + i11);
                    return i11;
                } catch (IOException unused) {
                    i11++;
                }
            }
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
        }
        return i10;
    }

    public static String getHostAddress(int i10) {
        if (hasAssignedInterface()) {
            return getInterface();
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            int i11 = 0;
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (isUsableAddress(nextElement)) {
                            if (i11 >= i10) {
                                return nextElement.getHostAddress();
                            }
                            i11++;
                        }
                    }
                }
            }
            return "";
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
            return "";
        }
    }

    public static final String getInterface() {
        return ifAddress;
    }

    public static int getNHostAddresses() {
        if (hasAssignedInterface()) {
            return 1;
        }
        int i10 = 0;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    if (isUsableAddress(inetAddresses.nextElement())) {
                        i10++;
                    }
                }
            }
        } catch (Exception e10) {
            CLog.d(TAG, (String) null, e10);
        }
        return i10;
    }

    private static boolean hasAssignedInterface() {
        if (ifAddress.length() > 0) {
            return true;
        }
        return false;
    }

    private static boolean isUsableAddress(InetAddress inetAddress) {
        if (!USE_LOOPBACK_ADDR && inetAddress.isLoopbackAddress()) {
            return false;
        }
        if (USE_ONLY_IPV4_ADDR && (inetAddress instanceof Inet6Address)) {
            return false;
        }
        if (!USE_ONLY_IPV6_ADDR || !(inetAddress instanceof Inet4Address)) {
            return true;
        }
        return false;
    }

    private static String matchLocalIp(String str) {
        String str2 = null;
        try {
            String substring = str.substring(0, str.lastIndexOf("."));
            int nHostAddresses = getNHostAddresses();
            if (nHostAddresses < 2) {
                return null;
            }
            for (int i10 = 0; i10 < nHostAddresses; i10++) {
                String hostAddress = getHostAddress(i10);
                if (hostAddress.contains(substring)) {
                    str2 = hostAddress;
                }
                CLog.i(TAG, "check local host ====> " + hostAddress.replace(".", ""));
            }
            return str2;
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
        }
    }

    public boolean checkEncrypt(LelinkEncrypt lelinkEncrypt, String str) {
        LelinkEncrypt lelinkEncrypt2 = lelinkEncrypt;
        String str2 = str;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            long currentTimeMillis2 = System.currentTimeMillis();
            if (!TextUtils.isEmpty(lelinkEncrypt.getSrpPassword())) {
                byte[] interactiveData = interactiveData(lelinkEncrypt.genPlayInfoRequest());
                if (interactiveData == null) {
                    return false;
                }
                CLog.d("dataa2", new String(interactiveData));
                if (!lelinkEncrypt2.parsePlayerInfoResponse(interactiveData)) {
                    return false;
                }
            }
            byte[] interactiveData2 = interactiveData(lelinkEncrypt.genSetupRequest());
            StringBuilder sb = new StringBuilder();
            sb.append("genSetupRequest  ");
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
            sb.append(System.currentTimeMillis() - currentTimeMillis2);
            CLog.i(str2 + "utime", sb.toString());
            if (interactiveData2 == null) {
                return false;
            }
            CLog.d(str2 + "utime", " start parseSetupResponse ");
            if (!lelinkEncrypt2.parseSetupResponse(interactiveData2)) {
                return false;
            }
            CLog.i(str2 + "utime", "parseSetupResponse  " + (System.currentTimeMillis() - currentTimeMillis2));
            long currentTimeMillis4 = System.currentTimeMillis();
            long currentTimeMillis5 = System.currentTimeMillis();
            byte[] genVerrifyM1Request = lelinkEncrypt.genVerrifyM1Request();
            long currentTimeMillis6 = currentTimeMillis3 + (System.currentTimeMillis() - currentTimeMillis5);
            byte[] interactiveData3 = interactiveData(genVerrifyM1Request);
            if (interactiveData3 == null) {
                return false;
            }
            CLog.i(str2 + "utime", "genVerrifyM1Request  " + (System.currentTimeMillis() - currentTimeMillis4));
            long currentTimeMillis7 = System.currentTimeMillis();
            long currentTimeMillis8 = System.currentTimeMillis();
            boolean parseVerifyM1Response = lelinkEncrypt2.parseVerifyM1Response(interactiveData3);
            long currentTimeMillis9 = currentTimeMillis6 + (System.currentTimeMillis() - currentTimeMillis8);
            if (!parseVerifyM1Response) {
                return false;
            }
            CLog.i(str2 + "utime", "parseVerifyM1Response  " + (System.currentTimeMillis() - currentTimeMillis7));
            long currentTimeMillis10 = System.currentTimeMillis();
            long currentTimeMillis11 = System.currentTimeMillis();
            byte[] genVerrifyM2Request = lelinkEncrypt.genVerrifyM2Request();
            long currentTimeMillis12 = currentTimeMillis9 + (System.currentTimeMillis() - currentTimeMillis11);
            byte[] interactiveData4 = interactiveData(genVerrifyM2Request);
            if (interactiveData4 == null) {
                return false;
            }
            boolean parseVerifyM2Response = lelinkEncrypt2.parseVerifyM2Response(interactiveData4);
            CLog.i(str2 + "utime", "parseVerifyM2Response   " + (System.currentTimeMillis() - currentTimeMillis10));
            long currentTimeMillis13 = currentTimeMillis12 + (System.currentTimeMillis() - currentTimeMillis);
            CLog.d(str2 + "utime", "encrypt time -->" + currentTimeMillis13);
            CLog.d(str2 + "utime", "parseVerifyM2Response  " + (System.currentTimeMillis() - currentTimeMillis10));
            CLog.d(str2 + "utime", "net time " + ((System.currentTimeMillis() - currentTimeMillis) - currentTimeMillis13));
            return parseVerifyM2Response;
        } catch (Exception e10) {
            CLog.w(str2, (Throwable) e10);
            return false;
        }
    }

    public void closeBrowseBroadCast() {
        DatagramSocket datagramSocket = this.mBrowseBroadCast;
        if (datagramSocket != null) {
            datagramSocket.close();
        }
    }

    public boolean connectServer() {
        return connectServer(30000);
    }

    public boolean createBroadCast() {
        try {
            DatagramSocket datagramSocket = new DatagramSocket((SocketAddress) null);
            this.mBrowseBroadCast = datagramSocket;
            datagramSocket.setBroadcast(true);
            return true;
        } catch (SocketException e10) {
            CLog.w(TAG, (Throwable) e10);
            return false;
        }
    }

    public boolean createMirrorEventServer(String str, int i10) {
        try {
            ServerSocket serverSocket = new ServerSocket();
            this.mMirrorEventServer = serverSocket;
            serverSocket.setReuseAddress(true);
            if (TextUtils.isEmpty(str)) {
                this.mMirrorEventServer.bind(new InetSocketAddress(i10));
            } else {
                this.mMirrorEventServer.bind(new InetSocketAddress(str, i10));
            }
            return true;
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
            return false;
        }
    }

    public boolean createMirrorSocket(String str, int i10) {
        try {
            String matchLocalIp = matchLocalIp(str);
            this.mSocket = new Socket();
            if (!TextUtils.isEmpty(matchLocalIp)) {
                InetAddress byName = InetAddress.getByName(str);
                InetAddress.getByName(matchLocalIp);
                this.mSocket.connect(new InetSocketAddress(byName, i10), 30000);
            } else {
                this.mSocket.connect(new InetSocketAddress(str, i10), 30000);
            }
            this.mSocket.setSoTimeout(30000);
            this.mSocket.setPerformancePreferences(2, 1, 3);
            this.mSocket.setTrafficClass(24);
            this.mSocket.setPerformancePreferences(0, 1, 2);
            this.mSocket.setReuseAddress(true);
            this.mPfd = ParcelFileDescriptor.fromSocket(this.mSocket);
            this.mLocalAutoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(this.mPfd);
            this.mLocalFileDescriptor = this.mPfd.getFileDescriptor();
            this.mLocalFileOutputStream = new FileOutputStream(this.mLocalFileDescriptor);
            return true;
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
            return false;
        }
    }

    public boolean createUDPServer() {
        try {
            DatagramSocket datagramSocket = new DatagramSocket((SocketAddress) null);
            this.mBrowseServSocket = datagramSocket;
            datagramSocket.setReuseAddress(true);
            this.mBrowseServSocket.bind(new InetSocketAddress(25353));
            return true;
        } catch (SocketException e10) {
            CLog.w(TAG, (Throwable) e10);
            return false;
        }
    }

    public ParcelFileDescriptor.AutoCloseInputStream getInputStream() {
        return this.mLocalAutoCloseInputStream;
    }

    public byte[] interactiveData(byte[]... bArr) {
        int i10;
        ArrayList arrayList = new ArrayList();
        String str = null;
        if (this.mLocalFileOutputStream == null) {
            return null;
        }
        for (byte[] write : bArr) {
            this.mLocalFileOutputStream.write(write);
        }
        this.mLocalFileOutputStream.flush();
        long currentTimeMillis = System.currentTimeMillis();
        byte[] bArr2 = new byte[1];
        byte[] bArr3 = null;
        int i11 = 0;
        while (System.currentTimeMillis() - currentTimeMillis < NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS) {
            if (str != null || this.mLocalAutoCloseInputStream.available() <= 0) {
                i10 = 0;
            } else {
                i10 = this.mLocalAutoCloseInputStream.read(bArr2, 0, 1);
            }
            if (i10 > 0) {
                arrayList.add(Byte.valueOf(bArr2[0]));
                if (ProtocolUtils.getProtocolDivide(arrayList)) {
                    int size = arrayList.size();
                    byte[] bArr4 = new byte[size];
                    for (int i12 = 0; i12 < size; i12++) {
                        bArr4[i12] = ((Byte) arrayList.get(i12)).byteValue();
                    }
                    String str2 = new String(bArr4);
                    int contentLength = ProtocolUtils.getContentLength(str2);
                    byte[] bArr5 = new byte[(size + contentLength)];
                    System.arraycopy(bArr4, 0, bArr5, 0, size);
                    if (contentLength != 0) {
                        int available = this.mLocalAutoCloseInputStream.available();
                        this.mLocalAutoCloseInputStream.read(bArr5, size, available);
                        if (available != contentLength) {
                            int i13 = size + available;
                            bArr3 = bArr5;
                            String str3 = str2;
                            i11 = i13;
                            str = str3;
                        }
                    }
                    return bArr5;
                }
                continue;
            } else if (bArr3 != null) {
                int available2 = this.mLocalAutoCloseInputStream.available();
                this.mLocalAutoCloseInputStream.read(bArr3, i11, available2);
                i11 += available2;
                if (i11 == bArr3.length) {
                    return bArr3;
                }
            } else {
                continue;
            }
        }
        return bArr3;
    }

    public byte[] interactiveDataNoHeader(byte[]... bArr) {
        int i10;
        try {
            ArrayList arrayList = new ArrayList();
            if (this.mLocalFileOutputStream != null) {
                for (byte[] write : bArr) {
                    this.mLocalFileOutputStream.write(write);
                }
                this.mLocalFileOutputStream.flush();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr2 = new byte[1];
                String str = null;
                byte[] bArr3 = null;
                int i11 = 0;
                while (System.currentTimeMillis() - currentTimeMillis < NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS) {
                    if (str != null || this.mLocalAutoCloseInputStream.available() <= 0) {
                        i10 = 0;
                    } else {
                        i10 = this.mLocalAutoCloseInputStream.read(bArr2, 0, 1);
                    }
                    if (i10 > 0 && i11 == 0) {
                        arrayList.add(Byte.valueOf(bArr2[0]));
                        if (ProtocolUtils.getProtocolDivide(arrayList)) {
                            int size = arrayList.size();
                            byte[] bArr4 = new byte[size];
                            for (int i12 = 0; i12 < size; i12++) {
                                bArr4[i12] = ((Byte) arrayList.get(i12)).byteValue();
                            }
                            str = new String(bArr4);
                            int contentLength = ProtocolUtils.getContentLength(str);
                            byte[] bArr5 = new byte[contentLength];
                            if (contentLength != 0) {
                                int available = this.mLocalAutoCloseInputStream.available();
                                this.mLocalAutoCloseInputStream.read(bArr5, 0, available);
                                if (available != contentLength) {
                                    i11 += available;
                                    bArr3 = bArr5;
                                }
                            }
                            return bArr5;
                        }
                        continue;
                    } else if (bArr3 != null) {
                        int available2 = this.mLocalAutoCloseInputStream.available();
                        this.mLocalAutoCloseInputStream.read(bArr3, i11, available2);
                        i11 += available2;
                        if (i11 == bArr3.length) {
                            return bArr3;
                        }
                    } else {
                        continue;
                    }
                }
                return bArr3;
            }
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
        }
        return null;
    }

    public byte[] interactiveEncryptData(byte[]... bArr) {
        byte[] bArr2 = null;
        if (this.mLocalFileOutputStream != null) {
            for (byte[] write : bArr) {
                this.mLocalFileOutputStream.write(write);
            }
            this.mLocalFileOutputStream.flush();
            long currentTimeMillis = System.currentTimeMillis();
            byte[] bArr3 = new byte[4];
            int i10 = 0;
            while (true) {
                if (System.currentTimeMillis() - currentTimeMillis >= NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS) {
                    break;
                } else if (i10 != 0 || this.mLocalAutoCloseInputStream.available() <= 4) {
                    if (i10 > 0 && this.mLocalAutoCloseInputStream.available() >= i10) {
                        this.mLocalAutoCloseInputStream.read(bArr2, 4, i10);
                        break;
                    }
                } else if (this.mLocalAutoCloseInputStream.read(bArr3, 0, 4) > 0) {
                    int bytesToInt = ProtocolUtils.bytesToInt(bArr3);
                    if (bytesToInt == 0 || bytesToInt > 2097152) {
                        break;
                    }
                    i10 = bytesToInt + 16;
                    bArr2 = new byte[(i10 + 4)];
                    System.arraycopy(bArr3, 0, bArr2, 0, 4);
                } else {
                    continue;
                }
            }
        }
        return bArr2;
    }

    public void sendBrowseData() {
        try {
            if (this.mBrowseBroadCast == null) {
                createBroadCast();
            }
            ProtocolBuilder protocolBuilder = new ProtocolBuilder();
            protocolBuilder.setBrowseMgcNum("PTBL");
            protocolBuilder.setBrowseXorkey("0000");
            protocolBuilder.setBrowseInfo(FirebaseAnalytics.Event.SEARCH, String.valueOf(31899), "", "");
            CLog.i(TAG, protocolBuilder.getString(true));
            byte[] protocal = protocolBuilder.getProtocal(true);
            this.mBrowsePacket.setPort(25353);
            this.mBrowsePacket.setData(protocal);
            this.mBrowsePacket.setLength(protocal.length);
            this.mBrowsePacket.setAddress(InetAddress.getByName("255.255.255.255"));
            this.mBrowseBroadCast.send(this.mBrowsePacket);
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
        }
    }

    public boolean tcpCheckTvState(String str, int i10) {
        return tcpCheckTvState(str, i10, 30000);
    }

    public boolean connectServer(int i10) {
        CLog.i(TAG, "========>  connect host  " + this.mIP.replace(".", "") + " port " + this.mPort + "  timeout :" + i10);
        String matchLocalIp = matchLocalIp(this.mIP);
        this.mSocket = new Socket();
        if (!TextUtils.isEmpty(matchLocalIp)) {
            InetAddress byName = InetAddress.getByName(this.mIP);
            bindLocal(this.mSocket, InetAddress.getByName(matchLocalIp));
            this.mSocket.connect(new InetSocketAddress(byName, this.mPort), i10);
        } else {
            this.mSocket.connect(new InetSocketAddress(this.mIP, this.mPort), i10);
        }
        this.mSocket.setReuseAddress(true);
        this.mSocket.setSoTimeout(i10);
        this.mSocket.setPerformancePreferences(0, 1, 2);
        this.mSocket.setKeepAlive(true);
        this.mPfd = ParcelFileDescriptor.fromSocket(this.mSocket);
        this.mLocalAutoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(this.mPfd);
        this.mLocalFileDescriptor = this.mPfd.getFileDescriptor();
        this.mLocalFileOutputStream = new FileOutputStream(this.mLocalFileDescriptor);
        return true;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:16|15|18|19|(2:21|22)|25) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0043, code lost:
        r6 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0078, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0079, code lost:
        com.hpplay.component.common.utils.CLog.w(TAG, (java.lang.Throwable) r7);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0045 */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0068 A[SYNTHETIC, Splitter:B:21:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0074 A[SYNTHETIC, Splitter:B:27:0x0074] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean tcpCheckTvState(java.lang.String r6, int r7, int r8) {
        /*
            r5 = this;
            java.lang.String r0 = "ProtocolCreater"
            r1 = 0
            java.net.Socket r2 = new java.net.Socket     // Catch:{ Exception -> 0x0045 }
            r2.<init>()     // Catch:{ Exception -> 0x0045 }
            r1 = 1
            r2.setReuseAddress(r1)     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            r2.setSoTimeout(r8)     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            java.lang.String r3 = matchLocalIp(r6)     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            if (r4 != 0) goto L_0x002d
            java.net.InetAddress r4 = java.net.InetAddress.getByName(r6)     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            java.net.InetAddress r3 = java.net.InetAddress.getByName(r3)     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            r5.bindLocal(r2, r3)     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            java.net.InetSocketAddress r3 = new java.net.InetSocketAddress     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            r3.<init>(r4, r7)     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            r2.connect(r3, r8)     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            goto L_0x0035
        L_0x002d:
            java.net.InetSocketAddress r3 = new java.net.InetSocketAddress     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            r3.<init>(r6, r7)     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            r2.connect(r3, r8)     // Catch:{ Exception -> 0x0041, all -> 0x003e }
        L_0x0035:
            r2.close()     // Catch:{ IOException -> 0x0039 }
            goto L_0x0071
        L_0x0039:
            r6 = move-exception
            com.hpplay.component.common.utils.CLog.w((java.lang.String) r0, (java.lang.Throwable) r6)
            goto L_0x0071
        L_0x003e:
            r6 = move-exception
            r1 = r2
            goto L_0x0072
        L_0x0041:
            r1 = r2
            goto L_0x0045
        L_0x0043:
            r6 = move-exception
            goto L_0x0072
        L_0x0045:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0043 }
            r7.<init>()     // Catch:{ all -> 0x0043 }
            java.lang.String r8 = "local device : "
            r7.append(r8)     // Catch:{ all -> 0x0043 }
            java.lang.String r8 = "."
            java.lang.String r2 = ""
            java.lang.String r6 = r6.replace(r8, r2)     // Catch:{ all -> 0x0043 }
            r7.append(r6)     // Catch:{ all -> 0x0043 }
            java.lang.String r6 = " is offline"
            r7.append(r6)     // Catch:{ all -> 0x0043 }
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x0043 }
            com.hpplay.component.common.utils.CLog.w((java.lang.String) r0, (java.lang.String) r6)     // Catch:{ all -> 0x0043 }
            if (r1 == 0) goto L_0x0070
            r1.close()     // Catch:{ IOException -> 0x006c }
            goto L_0x0070
        L_0x006c:
            r6 = move-exception
            com.hpplay.component.common.utils.CLog.w((java.lang.String) r0, (java.lang.Throwable) r6)
        L_0x0070:
            r1 = 0
        L_0x0071:
            return r1
        L_0x0072:
            if (r1 == 0) goto L_0x007c
            r1.close()     // Catch:{ IOException -> 0x0078 }
            goto L_0x007c
        L_0x0078:
            r7 = move-exception
            com.hpplay.component.common.utils.CLog.w((java.lang.String) r0, (java.lang.Throwable) r7)
        L_0x007c:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.component.protocol.ProtocolCore.tcpCheckTvState(java.lang.String, int, int):boolean");
    }
}
