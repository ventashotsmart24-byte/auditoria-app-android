package org.android.spdy;

import android.content.Context;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class SpdyAgent {
    public static final int ACCS_ONLINE_SERVER = 1;
    public static final int ACCS_TEST_SERVER = 0;
    private static final boolean HAVE_CLOSE = false;
    private static final int KB32 = 32768;
    private static final int KB8 = 8192;
    private static final int MAX_SPDY_SESSION_COUNT = 50;
    private static final int MB5 = 5242880;
    static final int MODE_QUIC = 256;
    static final int SPDY_CUSTOM_CONTROL_FRAME_RECV = 4106;
    static final int SPDY_DATA_CHUNK_RECV = 4097;
    static final int SPDY_DATA_RECV = 4098;
    static final int SPDY_DATA_SEND = 4099;
    static final int SPDY_PING_RECV = 4101;
    static final int SPDY_REQUEST_RECV = 4102;
    static final int SPDY_SESSION_CLOSE = 4103;
    static final int SPDY_SESSION_CREATE = 4096;
    static final int SPDY_SESSION_FAILED_ERROR = 4105;
    static final int SPDY_STREAM_CLOSE = 4100;
    static final int SPDY_STREAM_RESPONSE_RECV = 4104;
    private static final String TNET_SO_VERSION = "tnet-3.1.14";
    private static Object domainHashLock = new Object();
    private static HashMap<String, Integer> domainHashMap = new HashMap<>();
    public static volatile boolean enableDebug = false;
    public static volatile boolean enableTimeGaurd = false;
    private static volatile SpdyAgent gSingleInstance = null;
    private static volatile boolean loadSucc = false;
    private static Object lock = new Object();

    /* renamed from: r  reason: collision with root package name */
    private static final Lock f8626r;
    private static final ReentrantReadWriteLock rwLock;
    private static int totalDomain = 0;

    /* renamed from: w  reason: collision with root package name */
    private static final Lock f8627w;
    private AccsSSLCallback accsSSLCallback;
    private long agentNativePtr;
    private AtomicBoolean closed = new AtomicBoolean();
    private String proxyPassword = null;
    private String proxyUsername = null;
    private HashMap<String, SpdySession> sessionMgr = new HashMap<>(5);
    private LinkedList<SpdySession> sessionQueue = new LinkedList<>();

    static {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        rwLock = reentrantReadWriteLock;
        f8626r = reentrantReadWriteLock.readLock();
        f8627w = reentrantReadWriteLock.writeLock();
    }

    private SpdyAgent(Context context, SpdyVersion spdyVersion, SpdySessionKind spdySessionKind, AccsSSLCallback accsSSLCallback2) {
        try {
            SoInstallMgrSdk.init(context);
            loadSucc = SoInstallMgrSdk.initSo(TNET_SO_VERSION, 1);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            this.agentNativePtr = initAgent(spdyVersion.getInt(), spdySessionKind.getint(), SslVersion.SLIGHT_VERSION_V1.getint());
            this.accsSSLCallback = accsSSLCallback2;
        } catch (UnsatisfiedLinkError e10) {
            e10.printStackTrace();
        }
        this.closed.set(false);
    }

    public static void InvlidCharJudge(byte[] bArr, byte[] bArr2) {
        for (int i10 = 0; i10 < bArr.length; i10++) {
            byte b10 = bArr[i10];
            if ((b10 & UnsignedBytes.MAX_VALUE) < 32 || (b10 & UnsignedBytes.MAX_VALUE) > 126) {
                bArr[i10] = 63;
            }
        }
        for (int i11 = 0; i11 < bArr2.length; i11++) {
            byte b11 = bArr2[i11];
            if ((b11 & UnsignedBytes.MAX_VALUE) < 32 || (b11 & UnsignedBytes.MAX_VALUE) > 126) {
                bArr2[i11] = 63;
            }
        }
    }

    private void agentIsOpen() {
        if (!this.closed.get()) {
            checkLoadSo();
            return;
        }
        throw new SpdyErrorException("SPDY_JNI_ERR_ASYNC_CLOSE", (int) TnetStatusCode.TNET_JNI_ERR_ASYNC_CLOSE);
    }

    private void bioPingRecvCallback(SpdySession spdySession, int i10) {
        spduLog.Logi("tnet-jni", "[bioPingRecvCallback] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[bioPingRecvCallback] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[bioPingRecvCallback] - session.intenalcb is null");
        } else {
            intenalcb.bioPingRecvCallback(spdySession, i10);
        }
    }

    private void checkLoadSo() {
        if (!loadSucc) {
            try {
                synchronized (lock) {
                    if (!loadSucc) {
                        loadSucc = SoInstallMgrSdk.initSo(TNET_SO_VERSION, 1);
                        this.agentNativePtr = initAgent(0, 0, 0);
                    } else {
                        return;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            return;
        }
        if (!loadSucc) {
            throw new SpdyErrorException("TNET_JNI_ERR_LOAD_SO_FAIL", (int) TnetStatusCode.TNET_JNI_ERR_LOAD_SO_FAIL);
        }
    }

    public static boolean checkLoadSucc() {
        return loadSucc;
    }

    private native int closeSessionN(long j10);

    public static int configIpStackMode(int i10) {
        spduLog.Logi("tnet-jni", "[configIpStackMode] - " + i10);
        return configIpStackModeN(i10);
    }

    private static native int configIpStackModeN(int i10);

    private native int configLogFileN(String str, int i10, int i11);

    private native int configLogFileN(String str, int i10, int i11, int i12);

    private static void crashReporter(int i10) {
    }

    private native long createSessionN(long j10, SpdySession spdySession, int i10, byte[] bArr, char c10, byte[] bArr2, char c11, byte[] bArr3, byte[] bArr4, Object obj, int i11, int i12, int i13, byte[] bArr5);

    public static byte[] dataproviderToByteArray(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider) {
        byte[] bArr;
        headJudge(spdyRequest.getHeaders());
        if (spdyDataProvider == null) {
            return null;
        }
        String mapBodyToString = mapBodyToString(spdyDataProvider.postBody);
        if (mapBodyToString != null) {
            bArr = mapBodyToString.getBytes();
        } else {
            bArr = spdyDataProvider.data;
        }
        if (bArr == null || bArr.length < MB5) {
            return bArr;
        }
        throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM:total=" + bArr.length, (int) TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
    }

    private native int freeAgent(long j10);

    private int getDomainHashIndex(String str) {
        Integer num;
        synchronized (domainHashLock) {
            num = domainHashMap.get(str);
            if (num == null) {
                HashMap<String, Integer> hashMap = domainHashMap;
                int i10 = totalDomain + 1;
                totalDomain = i10;
                hashMap.put(str, Integer.valueOf(i10));
                num = Integer.valueOf(totalDomain);
            }
        }
        return num.intValue();
    }

    public static SpdyAgent getInstance(Context context, SpdyVersion spdyVersion, SpdySessionKind spdySessionKind) {
        if (gSingleInstance == null) {
            synchronized (lock) {
                if (gSingleInstance == null) {
                    gSingleInstance = new SpdyAgent(context, spdyVersion, spdySessionKind, (AccsSSLCallback) null);
                }
            }
        }
        return gSingleInstance;
    }

    private void getPerformance(SpdySession spdySession, SslPermData sslPermData) {
    }

    private byte[] getSSLMeta(SpdySession spdySession) {
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[getSSLMeta] - session is null");
            return null;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb != null) {
            return intenalcb.getSSLMeta(spdySession);
        }
        spduLog.Logi("tnet-jni", "[getSSLMeta] - session.intenalcb is null");
        return null;
    }

    private byte[] getSSLPublicKey(int i10, byte[] bArr) {
        AccsSSLCallback accsSSLCallback2 = this.accsSSLCallback;
        if (accsSSLCallback2 != null) {
            return accsSSLCallback2.getSSLPublicKey(i10, bArr);
        }
        spduLog.Logd("tnet-jni", "[getSSLPublicKey] - accsSSLCallback is null.");
        return null;
    }

    private native long getSession(long j10, byte[] bArr, char c10);

    public static void headJudge(Map<String, String> map) {
        if (map != null) {
            int i10 = 0;
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                String str2 = (String) next.getValue();
                InvlidCharJudge(str.getBytes(), str2.getBytes());
                i10 += str.length() + 1 + str2.length();
                securityCheck(i10, str2.length());
            }
        }
    }

    private native long initAgent(int i10, int i11, int i12);

    @Deprecated
    public static void inspect(String str) {
    }

    private native void logFileCloseN();

    private native void logFileFlushN();

    public static String mapBodyToString(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        if (map == null) {
            return null;
        }
        int i10 = 0;
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            String str2 = (String) next.getValue();
            sb.append(str);
            sb.append(ASCIIPropertyListParser.DICTIONARY_ASSIGN_TOKEN);
            sb.append(str2);
            sb.append('&');
            i10 += str.length() + 1 + str2.length();
            tableListJudge(i10);
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public static String[] mapToByteArray(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        String[] strArr = new String[(map.size() * 2)];
        int i10 = 0;
        for (Map.Entry next : map.entrySet()) {
            strArr[i10] = (String) next.getKey();
            strArr[i10 + 1] = (String) next.getValue();
            i10 += 2;
        }
        return strArr;
    }

    private int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[putSSLMeta] - session is null");
            return -1;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb != null) {
            return intenalcb.putSSLMeta(spdySession, bArr);
        }
        spduLog.Logi("tnet-jni", "[putSSLMeta] - session.intenalcb is null");
        return -1;
    }

    public static void securityCheck(int i10, int i11) {
        if (i10 >= 32768) {
            throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM:total=" + i10, (int) TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
        } else if (i11 >= 8192) {
            throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM:value=" + i11, (int) TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
        }
    }

    private native int setConTimeout(long j10, int i10);

    private native int setSessionKind(long j10, int i10);

    private void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i10, int i11) {
        spduLog.Logi("tnet-jni", "[spdyCustomControlFrameFailCallback] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyCustomControlFrameFailCallback] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyCustomControlFrameFailCallback] - session.intenalcb is null");
        } else {
            intenalcb.spdyCustomControlFrameFailCallback(spdySession, obj, i10, i11);
        }
    }

    private void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i10, int i11, int i12, int i13, byte[] bArr) {
        spduLog.Logi("tnet-jni", "[spdyCustomControlFrameRecvCallback] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyCustomControlFrameRecvCallback] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyCustomControlFrameRecvCallback] - session.intenalcb is null");
        } else {
            intenalcb.spdyCustomControlFrameRecvCallback(spdySession, obj, i10, i11, i12, i13, bArr);
        }
    }

    private void spdyDataChunkRecvCB(SpdySession spdySession, boolean z10, int i10, SpdyByteArray spdyByteArray, int i11) {
        spduLog.Logi("tnet-jni", "[spdyDataChunkRecvCB] - ");
        long j10 = ((long) i10) & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyDataChunkRecvCB] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyDataChunkRecvCB] - session.intenalcb is null");
        } else {
            intenalcb.spdyDataChunkRecvCB(spdySession, z10, j10, spdyByteArray, i11);
        }
    }

    private void spdyDataRecvCallback(SpdySession spdySession, boolean z10, int i10, int i11, int i12) {
        spduLog.Logi("tnet-jni", "[spdyDataRecvCallback] - ");
        long j10 = ((long) i10) & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyDataRecvCallback] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyDataRecvCallback] - session.intenalcb is null");
        } else {
            intenalcb.spdyDataRecvCallback(spdySession, z10, j10, i11, i12);
        }
    }

    private void spdyDataSendCallback(SpdySession spdySession, boolean z10, int i10, int i11, int i12) {
        long j10 = 4294967295L & ((long) i10);
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyDataSendCallback] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyDataSendCallback] - session.intenalcb is null");
        } else {
            intenalcb.spdyDataSendCallback(spdySession, z10, j10, i11, i12);
        }
    }

    private void spdyPingRecvCallback(SpdySession spdySession, int i10, Object obj) {
        spduLog.Logi("tnet-jni", "[spdyPingRecvCallback] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyPingRecvCallback] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyPingRecvCallback] - session.intenalcb is null");
        } else {
            intenalcb.spdyPingRecvCallback(spdySession, (long) i10, obj);
        }
    }

    private void spdyRequestRecvCallback(SpdySession spdySession, int i10, int i11) {
        long j10 = ((long) i10) & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyRequestRecvCallback] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyRequestRecvCallback] - session.intenalcb is null");
        } else {
            intenalcb.spdyRequestRecvCallback(spdySession, j10, i11);
        }
    }

    private void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i10) {
        spduLog.Logi("tnet-jni", "[spdySessionCloseCallback] - errorCode = " + i10);
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdySessionCloseCallback] - session is null");
        } else {
            try {
                Intenalcb intenalcb = spdySession.intenalcb;
                if (intenalcb == null) {
                    spduLog.Logi("tnet-jni", "[spdySessionCloseCallback] - session.intenalcb is null");
                } else {
                    intenalcb.spdySessionCloseCallback(spdySession, obj, superviseConnectInfo, i10);
                }
            } finally {
                spdySession.cleanUp();
            }
        }
        spdySession.releasePptr();
    }

    private void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        spduLog.Logi("tnet-jni", "[spdySessionConnectCB] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdySessionConnectCB] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdySessionConnectCB] - session.intenalcb is null");
        } else {
            intenalcb.spdySessionConnectCB(spdySession, superviseConnectInfo);
        }
    }

    private void spdySessionFailedError(SpdySession spdySession, int i10, Object obj) {
        spduLog.Logi("tnet-jni", "[spdySessionFailedError] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdySessionFailedError] - session is null");
        } else {
            try {
                Intenalcb intenalcb = spdySession.intenalcb;
                if (intenalcb == null) {
                    spduLog.Logi("tnet-jni", "[spdySessionFailedError] - session.intenalcb is null");
                } else {
                    intenalcb.spdySessionFailedError(spdySession, i10, obj);
                }
            } finally {
                spdySession.cleanUp();
            }
        }
        spdySession.releasePptr();
    }

    private void spdySessionOnWritable(SpdySession spdySession, Object obj, int i10) {
        spduLog.Logi("tnet-jni", "[spdySessionOnWritable] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdySessionOnWritable] - session is null");
            return;
        }
        try {
            Intenalcb intenalcb = spdySession.intenalcb;
            if (intenalcb == null) {
                spduLog.Logi("tnet-jni", "[spdySessionOnWritable] - session.intenalcb is null");
            } else {
                intenalcb.spdySessionOnWritable(spdySession, obj, i10);
            }
        } catch (Throwable th) {
            spduLog.Loge("tnet-jni", "[spdySessionOnWritable] - exception:" + th);
        }
    }

    private void spdyStreamCloseCallback(SpdySession spdySession, int i10, int i11, int i12, SuperviseData superviseData) {
        spduLog.Logi("tnet-jni", "[spdyStreamCloseCallback] - ");
        long j10 = ((long) i10) & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyStreamCloseCallback] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyStreamCloseCallback] - session.intenalcb is null");
        } else {
            intenalcb.spdyStreamCloseCallback(spdySession, j10, i11, i12, superviseData);
        }
    }

    private void spdyStreamResponseRecv(SpdySession spdySession, int i10, String[] strArr, int i11) {
        spduLog.Logi("tnet-jni", "[spdyStreamResponseRecv] - ");
        Map<String, List<String>> stringArrayToMap = stringArrayToMap(strArr);
        long j10 = ((long) i10) & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyStreamResponseRecv] - session is null");
            return;
        }
        Intenalcb intenalcb = spdySession.intenalcb;
        if (intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyStreamResponseRecv] - session.intenalcb is null");
        } else {
            intenalcb.spdyOnStreamResponse(spdySession, j10, stringArrayToMap, i11);
        }
    }

    public static Map<String, List<String>> stringArrayToMap(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        HashMap hashMap = new HashMap(5);
        int i10 = 0;
        while (true) {
            int i11 = i10 + 2;
            if (i11 <= strArr.length) {
                String str = strArr[i10];
                if (str == null) {
                    break;
                }
                int i12 = i10 + 1;
                if (strArr[i12] == null) {
                    break;
                }
                List list = (List) hashMap.get(str);
                if (list == null) {
                    list = new ArrayList(1);
                    hashMap.put(strArr[i10], list);
                }
                list.add(strArr[i12]);
                i10 = i11;
            } else {
                return hashMap;
            }
        }
        return null;
    }

    public static void tableListJudge(int i10) {
        if (i10 >= MB5) {
            throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM:total=" + i10, (int) TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
        }
    }

    public void clearSpdySession(String str, String str2, int i10) {
        if (str != null) {
            Lock lock2 = f8627w;
            lock2.lock();
            try {
                HashMap<String, SpdySession> hashMap = this.sessionMgr;
                hashMap.remove(str + str2 + i10);
                lock2.unlock();
            } catch (Throwable th) {
                f8627w.unlock();
                throw th;
            }
        }
    }

    public void close() {
    }

    public int closeSession(long j10) {
        return closeSessionN(j10);
    }

    public int configLogFile(String str, int i10, int i11) {
        if (loadSucc) {
            return configLogFileN(str, i10, i11);
        }
        return -1;
    }

    @Deprecated
    public SpdySession createSession(String str, Object obj, SessionCb sessionCb, int i10) {
        return createSession(str, "", obj, sessionCb, (SslCertcb) null, i10, 0);
    }

    public HashMap<String, SpdySession> getAllSession() {
        return this.sessionMgr;
    }

    public void logFileClose() {
        if (loadSucc) {
            logFileFlushN();
            logFileCloseN();
        }
    }

    public void logFileFlush() {
        if (loadSucc) {
            logFileFlushN();
        }
    }

    public void removeSession(SpdySession spdySession) {
        Lock lock2 = f8627w;
        lock2.lock();
        try {
            this.sessionQueue.remove(spdySession);
            lock2.unlock();
        } catch (Throwable th) {
            f8627w.unlock();
            throw th;
        }
    }

    public void setAccsSslCallback(AccsSSLCallback accsSSLCallback2) {
        spduLog.Logi("tnet-jni", "[setAccsSslCallback] - " + accsSSLCallback2.getClass());
        this.accsSSLCallback = accsSSLCallback2;
    }

    @Deprecated
    public int setConnectTimeOut(int i10) {
        agentIsOpen();
        try {
            return setConTimeout(this.agentNativePtr, i10);
        } catch (UnsatisfiedLinkError e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public void setProxyUsernamePassword(String str, String str2) {
        this.proxyUsername = str;
        this.proxyPassword = str2;
    }

    @Deprecated
    public int setSessionKind(SpdySessionKind spdySessionKind) {
        agentIsOpen();
        try {
            return setSessionKind(this.agentNativePtr, spdySessionKind.getint());
        } catch (UnsatisfiedLinkError e10) {
            e10.printStackTrace();
            return -1;
        }
    }

    @Deprecated
    public SpdySession submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Object obj2, Spdycb spdycb, SessionCb sessionCb, SslCertcb sslCertcb, int i10) {
        SpdySession createSession = createSession(spdyRequest.getAuthority(), spdyRequest.getDomain(), obj, sessionCb, sslCertcb, i10, 0, spdyRequest.getConnectionTimeoutMs());
        SpdyRequest spdyRequest2 = spdyRequest;
        SpdyDataProvider spdyDataProvider2 = spdyDataProvider;
        Object obj3 = obj2;
        Spdycb spdycb2 = spdycb;
        createSession.submitRequest(spdyRequest, spdyDataProvider, obj2, spdycb);
        return createSession;
    }

    @Deprecated
    public void switchAccsServer(int i10) {
    }

    public int configLogFile(String str, int i10, int i11, int i12) {
        if (loadSucc) {
            return configLogFileN(str, i10, i11, i12);
        }
        return -1;
    }

    @Deprecated
    public SpdySession createSession(String str, String str2, Object obj, SessionCb sessionCb, int i10) {
        return createSession(str, str2, obj, sessionCb, (SslCertcb) null, i10, 0);
    }

    @Deprecated
    public SpdySession createSession(String str, Object obj, SessionCb sessionCb, SslCertcb sslCertcb, int i10) {
        return createSession(str, "", obj, sessionCb, sslCertcb, i10, 0);
    }

    @Deprecated
    public SpdySession submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Object obj2, Spdycb spdycb, SessionCb sessionCb, SslCertcb sslCertcb, int i10, int i11) {
        SpdySession createSession = createSession(spdyRequest.getAuthority(), spdyRequest.getDomain(), obj, sessionCb, sslCertcb, i10, i11, spdyRequest.getConnectionTimeoutMs());
        SpdyRequest spdyRequest2 = spdyRequest;
        SpdyDataProvider spdyDataProvider2 = spdyDataProvider;
        Object obj3 = obj2;
        Spdycb spdycb2 = spdycb;
        createSession.submitRequest(spdyRequest, spdyDataProvider, obj2, spdycb);
        return createSession;
    }

    public SpdySession createSession(SessionInfo sessionInfo) {
        return createSession(sessionInfo.getAuthority(), sessionInfo.getDomain(), sessionInfo.getSessonUserData(), sessionInfo.getSessionCb(), (SslCertcb) null, sessionInfo.getMode(), sessionInfo.getPubKeySeqNum(), sessionInfo.getConnectionTimeoutMs(), sessionInfo.getCertHost());
    }

    @Deprecated
    public SpdySession createSession(String str, String str2, Object obj, SessionCb sessionCb, SslCertcb sslCertcb, int i10, int i11) {
        return createSession(str, str2, obj, sessionCb, sslCertcb, i10, i11, -1);
    }

    public SpdySession submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Object obj2, Spdycb spdycb, SessionCb sessionCb, int i10, int i11) {
        return submitRequest(spdyRequest, spdyDataProvider, obj, obj2, spdycb, sessionCb, (SslCertcb) null, i10, i11);
    }

    public SpdySession createSession(String str, String str2, Object obj, SessionCb sessionCb, SslCertcb sslCertcb, int i10, int i11, int i12) {
        return createSession(str, str2, obj, sessionCb, sslCertcb, i10, i11, i12, (String) null);
    }

    @Deprecated
    public SpdySession submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Object obj2, Spdycb spdycb, SessionCb sessionCb, int i10) {
        return submitRequest(spdyRequest, spdyDataProvider, obj, obj2, spdycb, sessionCb, (SslCertcb) null, i10);
    }

    @Deprecated
    public static SpdyAgent getInstance(Context context, SpdyVersion spdyVersion, SpdySessionKind spdySessionKind, AccsSSLCallback accsSSLCallback2) {
        if (gSingleInstance == null) {
            synchronized (lock) {
                if (gSingleInstance == null) {
                    gSingleInstance = new SpdyAgent(context, spdyVersion, spdySessionKind, accsSSLCallback2);
                }
            }
        }
        return gSingleInstance;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0188 A[Catch:{ all -> 0x013c }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x018d A[Catch:{ all -> 0x013c }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0192 A[Catch:{ all -> 0x013c }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.android.spdy.SpdySession createSession(java.lang.String r25, java.lang.String r26, java.lang.Object r27, org.android.spdy.SessionCb r28, org.android.spdy.SslCertcb r29, int r30, int r31, int r32, java.lang.String r33) {
        /*
            r24 = this;
            r15 = r24
            r0 = r25
            r14 = r26
            r13 = r30
            if (r0 == 0) goto L_0x01fc
            java.lang.String r1 = "/"
            java.lang.String[] r1 = r0.split(r1)
            r12 = 0
            r2 = r1[r12]
            r3 = 58
            int r2 = r2.lastIndexOf(r3)
            r3 = r1[r12]
            java.lang.String r11 = r3.substring(r12, r2)
            r3 = r1[r12]
            r10 = 1
            int r2 = r2 + r10
            java.lang.String r16 = r3.substring(r2)
            java.lang.String r2 = "0.0.0.0"
            byte[] r2 = r2.getBytes()
            int r3 = r1.length
            if (r3 == r10) goto L_0x004b
            r1 = r1[r10]
            java.lang.String r2 = ":"
            java.lang.String[] r1 = r1.split(r2)
            r2 = r1[r12]
            byte[] r2 = r2.getBytes()
            r1 = r1[r10]
            int r1 = java.lang.Integer.parseInt(r1)
            char r1 = (char) r1
            r9 = r0
            r18 = r1
            r17 = r2
            goto L_0x0061
        L_0x004b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r3 = "/0.0.0.0:0"
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r9 = r1
            r17 = r2
            r18 = 0
        L_0x0061:
            r24.agentIsOpen()
            java.util.concurrent.locks.Lock r1 = f8626r
            r1.lock()
            java.util.HashMap<java.lang.String, org.android.spdy.SpdySession> r2 = r15.sessionMgr     // Catch:{ all -> 0x01f4 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f4 }
            r3.<init>()     // Catch:{ all -> 0x01f4 }
            r3.append(r9)     // Catch:{ all -> 0x01f4 }
            r3.append(r14)     // Catch:{ all -> 0x01f4 }
            r3.append(r13)     // Catch:{ all -> 0x01f4 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01f4 }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x01f4 }
            org.android.spdy.SpdySession r2 = (org.android.spdy.SpdySession) r2     // Catch:{ all -> 0x01f4 }
            java.util.HashMap<java.lang.String, org.android.spdy.SpdySession> r3 = r15.sessionMgr     // Catch:{ all -> 0x01f4 }
            int r3 = r3.size()     // Catch:{ all -> 0x01f4 }
            r4 = 50
            if (r3 < r4) goto L_0x008f
            r3 = 1
            goto L_0x0090
        L_0x008f:
            r3 = 0
        L_0x0090:
            r1.unlock()
            if (r3 != 0) goto L_0x01e9
            if (r2 == 0) goto L_0x009b
            r2.increRefCount()
            return r2
        L_0x009b:
            java.util.concurrent.locks.Lock r1 = f8627w
            r1.lock()
            r19 = 0
            java.util.HashMap<java.lang.String, org.android.spdy.SpdySession> r1 = r15.sessionMgr     // Catch:{ all -> 0x00bd }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bd }
            r2.<init>()     // Catch:{ all -> 0x00bd }
            r2.append(r9)     // Catch:{ all -> 0x00bd }
            r2.append(r14)     // Catch:{ all -> 0x00bd }
            r2.append(r13)     // Catch:{ all -> 0x00bd }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00bd }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x00bd }
            org.android.spdy.SpdySession r1 = (org.android.spdy.SpdySession) r1     // Catch:{ all -> 0x00bd }
            goto L_0x00c0
        L_0x00bd:
            r1 = r19
        L_0x00c0:
            if (r1 == 0) goto L_0x00cb
            java.util.concurrent.locks.Lock r0 = f8627w
            r0.unlock()
            r1.increRefCount()
            return r1
        L_0x00cb:
            org.android.spdy.SpdySession r8 = new org.android.spdy.SpdySession     // Catch:{ all -> 0x01e1 }
            r2 = 0
            r1 = r8
            r4 = r24
            r5 = r9
            r6 = r26
            r7 = r28
            r28 = r8
            r8 = r30
            r20 = r9
            r9 = r31
            r21 = 1
            r10 = r27
            r1.<init>(r2, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x01e1 }
            if (r33 != 0) goto L_0x00eb
            r22 = r19
            goto L_0x00f1
        L_0x00eb:
            byte[] r1 = r33.getBytes()     // Catch:{ all -> 0x01e1 }
            r22 = r1
        L_0x00f1:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e1 }
            r1.<init>()     // Catch:{ all -> 0x01e1 }
            r1.append(r14)     // Catch:{ all -> 0x01e1 }
            r1.append(r13)     // Catch:{ all -> 0x01e1 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01e1 }
            int r5 = r15.getDomainHashIndex(r1)     // Catch:{ all -> 0x01e1 }
            java.lang.String r1 = r15.proxyUsername     // Catch:{ all -> 0x01e1 }
            if (r1 == 0) goto L_0x0141
            java.lang.String r1 = r15.proxyPassword     // Catch:{ all -> 0x013c }
            if (r1 == 0) goto L_0x0141
            long r2 = r15.agentNativePtr     // Catch:{ all -> 0x013c }
            byte[] r6 = r11.getBytes()     // Catch:{ all -> 0x013c }
            int r1 = java.lang.Integer.parseInt(r16)     // Catch:{ all -> 0x013c }
            char r7 = (char) r1     // Catch:{ all -> 0x013c }
            java.lang.String r1 = r15.proxyUsername     // Catch:{ all -> 0x013c }
            byte[] r10 = r1.getBytes()     // Catch:{ all -> 0x013c }
            java.lang.String r1 = r15.proxyPassword     // Catch:{ all -> 0x013c }
            byte[] r11 = r1.getBytes()     // Catch:{ all -> 0x013c }
            r1 = r24
            r4 = r28
            r8 = r17
            r9 = r18
            r23 = 0
            r12 = r27
            r13 = r30
            r14 = r31
            r15 = r32
            r16 = r22
            long r1 = r1.createSessionN(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x013c }
            goto L_0x0168
        L_0x013c:
            r0 = move-exception
            r1 = r24
            goto L_0x01e3
        L_0x0141:
            r23 = 0
            r15 = r24
            long r2 = r15.agentNativePtr     // Catch:{ all -> 0x01e1 }
            byte[] r6 = r11.getBytes()     // Catch:{ all -> 0x01e1 }
            int r1 = java.lang.Integer.parseInt(r16)     // Catch:{ all -> 0x01e1 }
            char r7 = (char) r1
            r10 = 0
            r11 = 0
            r1 = r24
            r4 = r28
            r8 = r17
            r9 = r18
            r12 = r27
            r13 = r30
            r14 = r31
            r15 = r32
            r16 = r22
            long r1 = r1.createSessionN(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x013c }
        L_0x0168:
            java.lang.String r3 = "tnet-jni"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x013c }
            r4.<init>()     // Catch:{ all -> 0x013c }
            java.lang.String r5 = " create new session: "
            r4.append(r5)     // Catch:{ all -> 0x013c }
            r4.append(r0)     // Catch:{ all -> 0x013c }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x013c }
            org.android.spdy.spduLog.Logi(r3, r0)     // Catch:{ all -> 0x013c }
            r3 = 1
            long r5 = r1 & r3
            r7 = 0
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x018d
            long r0 = r1 >> r21
            int r12 = (int) r0     // Catch:{ all -> 0x013c }
            r1 = r7
            goto L_0x018e
        L_0x018d:
            r12 = 0
        L_0x018e:
            int r0 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x01be
            r0 = r28
            r0.setSessionNativePtr(r1)     // Catch:{ all -> 0x013c }
            r1 = r24
            java.util.HashMap<java.lang.String, org.android.spdy.SpdySession> r2 = r1.sessionMgr     // Catch:{ all -> 0x01df }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01df }
            r3.<init>()     // Catch:{ all -> 0x01df }
            r4 = r20
            r3.append(r4)     // Catch:{ all -> 0x01df }
            r4 = r26
            r3.append(r4)     // Catch:{ all -> 0x01df }
            r4 = r30
            r3.append(r4)     // Catch:{ all -> 0x01df }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01df }
            r2.put(r3, r0)     // Catch:{ all -> 0x01df }
            java.util.LinkedList<org.android.spdy.SpdySession> r2 = r1.sessionQueue     // Catch:{ all -> 0x01df }
            r2.add(r0)     // Catch:{ all -> 0x01df }
            r19 = r0
            goto L_0x01c2
        L_0x01be:
            r1 = r24
            if (r12 != 0) goto L_0x01c8
        L_0x01c2:
            java.util.concurrent.locks.Lock r0 = f8627w
            r0.unlock()
            return r19
        L_0x01c8:
            org.android.spdy.SpdyErrorException r0 = new org.android.spdy.SpdyErrorException     // Catch:{ all -> 0x01df }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01df }
            r2.<init>()     // Catch:{ all -> 0x01df }
            java.lang.String r3 = "create session error: "
            r2.append(r3)     // Catch:{ all -> 0x01df }
            r2.append(r12)     // Catch:{ all -> 0x01df }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01df }
            r0.<init>((java.lang.String) r2, (int) r12)     // Catch:{ all -> 0x01df }
            throw r0     // Catch:{ all -> 0x01df }
        L_0x01df:
            r0 = move-exception
            goto L_0x01e3
        L_0x01e1:
            r0 = move-exception
            r1 = r15
        L_0x01e3:
            java.util.concurrent.locks.Lock r2 = f8627w
            r2.unlock()
            throw r0
        L_0x01e9:
            r1 = r15
            org.android.spdy.SpdyErrorException r0 = new org.android.spdy.SpdyErrorException
            java.lang.String r2 = "SPDY_SESSION_EXCEED_MAXED: session count exceed max"
            r3 = -1105(0xfffffffffffffbaf, float:NaN)
            r0.<init>((java.lang.String) r2, (int) r3)
            throw r0
        L_0x01f4:
            r0 = move-exception
            r1 = r15
            java.util.concurrent.locks.Lock r2 = f8626r
            r2.unlock()
            throw r0
        L_0x01fc:
            r1 = r15
            org.android.spdy.SpdyErrorException r0 = new org.android.spdy.SpdyErrorException
            java.lang.String r2 = "SPDY_JNI_ERR_INVALID_PARAM"
            r3 = -1102(0xfffffffffffffbb2, float:NaN)
            r0.<init>((java.lang.String) r2, (int) r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.spdy.SpdyAgent.createSession(java.lang.String, java.lang.String, java.lang.Object, org.android.spdy.SessionCb, org.android.spdy.SslCertcb, int, int, int, java.lang.String):org.android.spdy.SpdySession");
    }
}
