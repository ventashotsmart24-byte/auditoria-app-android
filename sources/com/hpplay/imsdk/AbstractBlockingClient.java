package com.hpplay.imsdk;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.common.asyncmanager.AsyncRunnableListener;
import com.hpplay.common.log.LeLog;
import h3.b;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Observable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public abstract class AbstractBlockingClient extends Observable implements Runnable {
    private static short DEFAULT_MESSAGE_SIZE = 8192;
    private final String TAG;
    protected final String appid;
    protected String capability;
    private final int defaultBufferSize;
    private int defaultSocketTimeOut;
    /* access modifiers changed from: private */
    public long heartBeatTimeOut;
    private final AtomicReference<DataInputStream> in;
    private Runnable mHeartRunnable;
    private AsyncTask mHeartTask;
    private OnConnectServerListener mListener;
    private final AtomicReference<DataOutputStream> out;
    protected final int port;
    protected final String server;
    /* access modifiers changed from: private */
    public final AtomicReference<State> state;
    protected final String token;
    protected final String uid;

    public class HeartbeatTask implements Runnable {
        public HeartbeatTask() {
        }

        public void run() {
            while (AbstractBlockingClient.this.state.get() == State.RUNNING) {
                try {
                    Thread.sleep(AbstractBlockingClient.this.heartBeatTimeOut);
                    try {
                        AbstractBlockingClient.this.heartBeatWrite();
                    } catch (Exception e10) {
                        LeLog.w("IM_AbstractBlockingClient", "heartBeatWrite Exception " + e10);
                        AbstractBlockingClient.this.state.set(State.STOPPED);
                    }
                } catch (Exception e11) {
                    LeLog.w("IM_AbstractBlockingClient", "HeartbeatTask Exception " + e11);
                }
            }
            LeLog.w("IM_AbstractBlockingClient", "heartBeatWrite end");
        }
    }

    public enum State {
        STOPPED,
        STOPPING,
        RUNNING
    }

    public AbstractBlockingClient(String str, int i10, String str2, String str3, String str4, String str5) {
        this(str, i10, str2, str3, str4, str5, DEFAULT_MESSAGE_SIZE);
    }

    private void dispatchMsg(String str) {
        if (TextUtils.isEmpty(str)) {
            LeLog.w("IM_AbstractBlockingClient", "dispatchMsg,values is invalid");
            return;
        }
        String[] split = str.split(",");
        try {
            long longValue = Long.valueOf(split[0], 16).longValue();
            LeLog.i("IM_AbstractBlockingClient", "run action: " + longValue);
            messageReceived(longValue, str.substring(split[0].length() + 1));
        } catch (Exception e10) {
            LeLog.w("IM_AbstractBlockingClient", "run analysis msg failed " + e10);
        }
    }

    private int getGameCode(String str) {
        int i10 = 0;
        for (byte b10 : str.getBytes()) {
            i10 += b10;
        }
        return i10;
    }

    private void handlePackageBody(byte[] bArr, int i10) {
        byte[] tail = BruteForceCoding.tail(bArr, 16, i10 - 16);
        long decodeIntBigEndian = BruteForceCoding.decodeIntBigEndian(bArr, 8, 4);
        if (3 == decodeIntBigEndian) {
            heartBeatReceived();
            updateHeartInterval(new String(tail));
        } else if (8 == decodeIntBigEndian) {
            OnConnectServerListener onConnectServerListener = this.mListener;
            if (onConnectServerListener != null) {
                onConnectServerListener.onAuthCallback(new String(tail));
            }
            heartBeat();
        } else if (16 == decodeIntBigEndian) {
            LeLog.i("IM_AbstractBlockingClient", "updateCapabilityWrite replay");
        } else if (decodeIntBigEndian == 17) {
            String str = null;
            try {
                JSONObject jSONObject = new JSONObject(new String(tail));
                str = jSONObject.getString("msgid");
                dispatchMsg(jSONObject.getString("msgBody"));
            } catch (Exception e10) {
                LeLog.w("IM_AbstractBlockingClient", (Throwable) e10);
            }
            if (!TextUtils.isEmpty(str)) {
                ackMsgWrite(18, str);
            }
        } else if (decodeIntBigEndian == 19) {
            LeLog.i("IM_AbstractBlockingClient", "ping msg");
            ackPingMsgWrite(20, BruteForceCoding.decodeIntBigEndian(bArr, 12, 4));
        } else {
            dispatchMsg(new String(tail));
        }
    }

    private void heartBeat() {
        stopHeartBeat();
        if (this.heartBeatTimeOut <= 0) {
            LeLog.w("IM_AbstractBlockingClient", "invalid heart interval " + this.heartBeatTimeOut + "  use default value instead");
            this.heartBeatTimeOut = TimeUnit.SECONDS.toMillis(50);
        }
        LeLog.i("IM_AbstractBlockingClient", "heartBeat after " + this.heartBeatTimeOut);
        this.mHeartRunnable = new HeartbeatTask();
        this.mHeartTask = AsyncManager.getInstance().exeRunnable(this.mHeartRunnable, (AsyncRunnableListener) null);
    }

    private void restart() {
        super.setChanged();
        LeLog.i("IM_AbstractBlockingClient", "restart");
        stopHeartBeat();
        notifyObservers();
    }

    private void stopHeartBeat() {
        LeLog.i("IM_AbstractBlockingClient", "stopHeartBeat " + this.mHeartTask);
        AsyncTask asyncTask = this.mHeartTask;
        if (asyncTask != null) {
            try {
                asyncTask.cancel(true);
            } catch (Exception e10) {
                LeLog.w("IM_AbstractBlockingClient", (Throwable) e10);
            }
            this.mHeartTask = null;
        }
    }

    private void updateHeartInterval(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                int optInt = new JSONObject(str).optInt("h");
                if (optInt > 0) {
                    long millis = TimeUnit.SECONDS.toMillis((long) optInt);
                    if (this.heartBeatTimeOut != millis) {
                        LeLog.i("IM_AbstractBlockingClient", "updateHeartInterval unEqual interval,update heartBeat");
                        this.heartBeatTimeOut = millis;
                        return;
                    }
                    return;
                }
                LeLog.i("IM_AbstractBlockingClient", "updateHeartInterval failed");
            } catch (Exception e10) {
                LeLog.w("IM_AbstractBlockingClient", (Throwable) e10);
            }
        }
    }

    public synchronized Boolean ackMsgWrite(int i10, String str) {
        LeLog.i("IM_AbstractBlockingClient", "ackMsgWrite,msgID " + str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("msgid", str);
            String jSONObject2 = jSONObject.toString();
            byte[] bArr = new byte[16];
            BruteForceCoding.encodeIntBigEndian(bArr, 1, BruteForceCoding.encodeIntBigEndian(bArr, (long) i10, BruteForceCoding.encodeIntBigEndian(bArr, 1, BruteForceCoding.encodeIntBigEndian(bArr, 16, BruteForceCoding.encodeIntBigEndian(bArr, (long) (jSONObject2.getBytes().length + 16), 0, 4), 2), 2), 4), 4);
            this.out.get().write(BruteForceCoding.add(bArr, jSONObject2.getBytes()));
            this.out.get().flush();
            LeLog.i("IM_AbstractBlockingClient", "ackMsgWrite,ok ");
        } catch (Exception e10) {
            LeLog.w("IM_AbstractBlockingClient", (Throwable) e10);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public synchronized Boolean ackPingMsgWrite(int i10, long j10) {
        LeLog.i("IM_AbstractBlockingClient", "ackPingMsgWrite,msgID " + j10);
        try {
            byte[] bArr = new byte[16];
            BruteForceCoding.encodeIntBigEndian(bArr, j10, BruteForceCoding.encodeIntBigEndian(bArr, (long) i10, BruteForceCoding.encodeIntBigEndian(bArr, 1, BruteForceCoding.encodeIntBigEndian(bArr, 16, BruteForceCoding.encodeIntBigEndian(bArr, (long) 16, 0, 4), 2), 2), 4), 4);
            this.out.get().write(bArr);
            this.out.get().flush();
            LeLog.i("IM_AbstractBlockingClient", "ackPingMsgWrite,ok ");
        } catch (Exception e10) {
            LeLog.w("IM_AbstractBlockingClient", (Throwable) e10);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public synchronized Boolean authWrite() {
        String str = this.uid + ";" + this.capability + ";" + this.appid + ";" + this.token;
        byte[] bArr = new byte[16];
        BruteForceCoding.encodeIntBigEndian(bArr, 1, BruteForceCoding.encodeIntBigEndian(bArr, 7, BruteForceCoding.encodeIntBigEndian(bArr, 1, BruteForceCoding.encodeIntBigEndian(bArr, 16, BruteForceCoding.encodeIntBigEndian(bArr, (long) (str.getBytes().length + 16), 0, 4), 2), 2), 4), 4);
        this.out.get().write(BruteForceCoding.add(bArr, str.getBytes()));
        this.out.get().flush();
        return Boolean.TRUE;
    }

    public abstract void connected(boolean z10);

    public abstract void disconnected();

    public int getPort() {
        return this.port;
    }

    public String getServer() {
        return this.server;
    }

    public abstract void heartBeatReceived();

    public synchronized Boolean heartBeatWrite() {
        String str = this.uid;
        byte[] bArr = new byte[16];
        BruteForceCoding.encodeIntBigEndian(bArr, 1, BruteForceCoding.encodeIntBigEndian(bArr, 2, BruteForceCoding.encodeIntBigEndian(bArr, 1, BruteForceCoding.encodeIntBigEndian(bArr, 16, BruteForceCoding.encodeIntBigEndian(bArr, (long) (str.getBytes().length + 16), 0, 4), 2), 2), 4), 4);
        this.out.get().write(BruteForceCoding.add(bArr, str.getBytes()));
        this.out.get().flush();
        return Boolean.TRUE;
    }

    public boolean isRunning() {
        if (this.state.get() == State.RUNNING) {
            return true;
        }
        return false;
    }

    public boolean isStopped() {
        if (this.state.get() == State.STOPPED) {
            return true;
        }
        return false;
    }

    public abstract void messageReceived(long j10, String str);

    public abstract void messageReceived(Long l10, Long l11, Long l12, Long l13, Long l14, String str);

    public abstract void messageReceived(String str);

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x012c, code lost:
        r5 = 0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01a4 A[Catch:{ Exception -> 0x01ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01b4 A[Catch:{ Exception -> 0x01ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01d5 A[SYNTHETIC, Splitter:B:94:0x01d5] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r10 = this;
            java.lang.String r0 = "IM_AbstractBlockingClient"
            r1 = 0
            java.net.Socket r2 = new java.net.Socket     // Catch:{ Exception -> 0x0155, all -> 0x014f }
            java.lang.String r3 = r10.server     // Catch:{ Exception -> 0x0155, all -> 0x014f }
            int r4 = r10.port     // Catch:{ Exception -> 0x0155, all -> 0x014f }
            r2.<init>(r3, r4)     // Catch:{ Exception -> 0x0155, all -> 0x014f }
            int r1 = r10.defaultSocketTimeOut     // Catch:{ Exception -> 0x014d }
            r2.setSoTimeout(r1)     // Catch:{ Exception -> 0x014d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014d }
            r1.<init>()     // Catch:{ Exception -> 0x014d }
            java.lang.String r3 = "run socket:"
            r1.append(r3)     // Catch:{ Exception -> 0x014d }
            java.lang.String r3 = r2.toString()     // Catch:{ Exception -> 0x014d }
            r1.append(r3)     // Catch:{ Exception -> 0x014d }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x014d }
            com.hpplay.common.log.LeLog.i(r0, r1)     // Catch:{ Exception -> 0x014d }
            java.util.concurrent.atomic.AtomicReference<java.io.DataOutputStream> r1 = r10.out     // Catch:{ Exception -> 0x014d }
            java.io.DataOutputStream r3 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x014d }
            java.io.OutputStream r4 = r2.getOutputStream()     // Catch:{ Exception -> 0x014d }
            r3.<init>(r4)     // Catch:{ Exception -> 0x014d }
            r1.set(r3)     // Catch:{ Exception -> 0x014d }
            java.util.concurrent.atomic.AtomicReference<java.io.DataInputStream> r1 = r10.in     // Catch:{ Exception -> 0x014d }
            java.io.DataInputStream r3 = new java.io.DataInputStream     // Catch:{ Exception -> 0x014d }
            java.io.InputStream r4 = r2.getInputStream()     // Catch:{ Exception -> 0x014d }
            r3.<init>(r4)     // Catch:{ Exception -> 0x014d }
            r1.set(r3)     // Catch:{ Exception -> 0x014d }
            java.util.concurrent.atomic.AtomicReference<com.hpplay.imsdk.AbstractBlockingClient$State> r1 = r10.state     // Catch:{ Exception -> 0x014d }
            com.hpplay.imsdk.AbstractBlockingClient$State r3 = com.hpplay.imsdk.AbstractBlockingClient.State.STOPPED     // Catch:{ Exception -> 0x014d }
            com.hpplay.imsdk.AbstractBlockingClient$State r4 = com.hpplay.imsdk.AbstractBlockingClient.State.RUNNING     // Catch:{ Exception -> 0x014d }
            boolean r1 = h3.b.a(r1, r3, r4)     // Catch:{ Exception -> 0x014d }
            if (r1 != 0) goto L_0x006f
            r2.close()     // Catch:{ Exception -> 0x014d }
            java.lang.String r1 = "state is Runing close socket"
            com.hpplay.common.log.LeLog.i(r0, r1)     // Catch:{ Exception -> 0x014d }
            java.util.concurrent.atomic.AtomicReference<com.hpplay.imsdk.AbstractBlockingClient$State> r1 = r10.state     // Catch:{ Exception -> 0x0062 }
            r1.set(r3)     // Catch:{ Exception -> 0x0062 }
            r10.disconnected()     // Catch:{ Exception -> 0x0062 }
            goto L_0x0066
        L_0x0062:
            r1 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.Throwable) r1)
        L_0x0066:
            r2.close()     // Catch:{ Exception -> 0x006a }
            goto L_0x006e
        L_0x006a:
            r1 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.Throwable) r1)
        L_0x006e:
            return
        L_0x006f:
            java.lang.Boolean r1 = r10.authWrite()     // Catch:{ Exception -> 0x014d }
            boolean r1 = r1.booleanValue()     // Catch:{ Exception -> 0x014d }
            if (r1 == 0) goto L_0x0081
            com.hpplay.imsdk.OnConnectServerListener r1 = r10.mListener     // Catch:{ Exception -> 0x014d }
            if (r1 == 0) goto L_0x0088
            r1.onConnectSuccess()     // Catch:{ Exception -> 0x014d }
            goto L_0x0088
        L_0x0081:
            com.hpplay.imsdk.OnConnectServerListener r1 = r10.mListener     // Catch:{ Exception -> 0x014d }
            if (r1 == 0) goto L_0x0088
            r1.onConnectFailed()     // Catch:{ Exception -> 0x014d }
        L_0x0088:
            short r1 = DEFAULT_MESSAGE_SIZE     // Catch:{ Exception -> 0x014d }
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x014d }
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x008f:
            java.util.concurrent.atomic.AtomicReference<com.hpplay.imsdk.AbstractBlockingClient$State> r6 = r10.state     // Catch:{ Exception -> 0x014d }
            java.lang.Object r6 = r6.get()     // Catch:{ Exception -> 0x014d }
            com.hpplay.imsdk.AbstractBlockingClient$State r7 = com.hpplay.imsdk.AbstractBlockingClient.State.RUNNING     // Catch:{ Exception -> 0x014d }
            if (r6 != r7) goto L_0x013a
            java.util.concurrent.atomic.AtomicReference<java.io.DataInputStream> r6 = r10.in     // Catch:{ Exception -> 0x014d }
            java.lang.Object r6 = r6.get()     // Catch:{ Exception -> 0x014d }
            java.io.DataInputStream r6 = (java.io.DataInputStream) r6     // Catch:{ Exception -> 0x014d }
            int r7 = r1.length     // Catch:{ Exception -> 0x014d }
            int r7 = r7 - r4
            int r6 = r6.read(r1, r4, r7)     // Catch:{ Exception -> 0x014d }
            int r4 = r4 + r6
            r7 = -1
            if (r6 != r7) goto L_0x00b8
            java.lang.String r6 = "read packageLength -1"
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.String) r6)     // Catch:{ Exception -> 0x014d }
            java.util.concurrent.atomic.AtomicReference<com.hpplay.imsdk.AbstractBlockingClient$State> r6 = r10.state     // Catch:{ Exception -> 0x014d }
            com.hpplay.imsdk.AbstractBlockingClient$State r7 = com.hpplay.imsdk.AbstractBlockingClient.State.STOPPED     // Catch:{ Exception -> 0x014d }
            r6.set(r7)     // Catch:{ Exception -> 0x014d }
            goto L_0x008f
        L_0x00b8:
            if (r5 > 0) goto L_0x00f6
            r6 = 4
            if (r4 < r6) goto L_0x00f6
            long r5 = com.hpplay.imsdk.BruteForceCoding.decodeIntBigEndian(r1, r3, r6)     // Catch:{ Exception -> 0x014d }
            int r5 = (int) r5     // Catch:{ Exception -> 0x014d }
            short r6 = DEFAULT_MESSAGE_SIZE     // Catch:{ Exception -> 0x014d }
            int r6 = r6 * 40
            if (r5 <= r6) goto L_0x00e7
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014d }
            r1.<init>()     // Catch:{ Exception -> 0x014d }
            java.lang.String r4 = "packageLength msgLength is invalid: "
            r1.append(r4)     // Catch:{ Exception -> 0x014d }
            r1.append(r5)     // Catch:{ Exception -> 0x014d }
            java.lang.String r4 = ",greater than maximum"
            r1.append(r4)     // Catch:{ Exception -> 0x014d }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x014d }
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x014d }
            short r1 = DEFAULT_MESSAGE_SIZE     // Catch:{ Exception -> 0x014d }
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x014d }
            r4 = 0
            goto L_0x012c
        L_0x00e7:
            int r6 = r1.length     // Catch:{ Exception -> 0x014d }
            if (r5 <= r6) goto L_0x00f6
            int r6 = r1.length     // Catch:{ Exception -> 0x014d }
            byte[] r7 = new byte[r6]     // Catch:{ Exception -> 0x014d }
            int r8 = r1.length     // Catch:{ Exception -> 0x014d }
            java.lang.System.arraycopy(r1, r3, r7, r3, r8)     // Catch:{ Exception -> 0x014d }
            byte[] r1 = new byte[r5]     // Catch:{ Exception -> 0x014d }
            java.lang.System.arraycopy(r7, r3, r1, r3, r6)     // Catch:{ Exception -> 0x014d }
        L_0x00f6:
            if (r5 > 0) goto L_0x00f9
            goto L_0x012d
        L_0x00f9:
            if (r4 >= r5) goto L_0x00fc
            goto L_0x012d
        L_0x00fc:
            r10.handlePackageBody(r1, r5)     // Catch:{ Exception -> 0x014d }
            int r4 = r4 - r5
            if (r4 <= 0) goto L_0x0128
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014d }
            r6.<init>()     // Catch:{ Exception -> 0x014d }
            java.lang.String r7 = "packageLength handle next package,left:"
            r6.append(r7)     // Catch:{ Exception -> 0x014d }
            r6.append(r4)     // Catch:{ Exception -> 0x014d }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x014d }
            com.hpplay.common.log.LeLog.i(r0, r6)     // Catch:{ Exception -> 0x014d }
            byte[] r6 = new byte[r4]     // Catch:{ Exception -> 0x014d }
            java.lang.System.arraycopy(r1, r5, r6, r3, r4)     // Catch:{ Exception -> 0x014d }
            short r1 = DEFAULT_MESSAGE_SIZE     // Catch:{ Exception -> 0x014d }
            int r1 = java.lang.Math.max(r1, r4)     // Catch:{ Exception -> 0x014d }
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x014d }
            java.lang.System.arraycopy(r6, r3, r1, r3, r4)     // Catch:{ Exception -> 0x014d }
            r5 = 0
            goto L_0x00b8
        L_0x0128:
            short r1 = DEFAULT_MESSAGE_SIZE     // Catch:{ Exception -> 0x014d }
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x014d }
        L_0x012c:
            r5 = 0
        L_0x012d:
            r6 = 2
            java.lang.Thread.sleep(r6)     // Catch:{ Exception -> 0x0134 }
            goto L_0x008f
        L_0x0134:
            r6 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.Throwable) r6)     // Catch:{ Exception -> 0x014d }
            goto L_0x008f
        L_0x013a:
            java.util.concurrent.atomic.AtomicReference<com.hpplay.imsdk.AbstractBlockingClient$State> r1 = r10.state     // Catch:{ Exception -> 0x0145 }
            com.hpplay.imsdk.AbstractBlockingClient$State r3 = com.hpplay.imsdk.AbstractBlockingClient.State.STOPPED     // Catch:{ Exception -> 0x0145 }
            r1.set(r3)     // Catch:{ Exception -> 0x0145 }
            r10.disconnected()     // Catch:{ Exception -> 0x0145 }
            goto L_0x0149
        L_0x0145:
            r1 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.Throwable) r1)
        L_0x0149:
            r2.close()     // Catch:{ Exception -> 0x0182 }
            goto L_0x0186
        L_0x014d:
            r1 = move-exception
            goto L_0x0159
        L_0x014f:
            r2 = move-exception
            r9 = r2
            r2 = r1
            r1 = r9
            goto L_0x01c4
        L_0x0155:
            r2 = move-exception
            r9 = r2
            r2 = r1
            r1 = r9
        L_0x0159:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c3 }
            r3.<init>()     // Catch:{ all -> 0x01c3 }
            java.lang.String r4 = "Client failure "
            r3.append(r4)     // Catch:{ all -> 0x01c3 }
            r3.append(r1)     // Catch:{ all -> 0x01c3 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x01c3 }
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x01c3 }
            java.util.concurrent.atomic.AtomicReference<com.hpplay.imsdk.AbstractBlockingClient$State> r1 = r10.state     // Catch:{ Exception -> 0x0178 }
            com.hpplay.imsdk.AbstractBlockingClient$State r3 = com.hpplay.imsdk.AbstractBlockingClient.State.STOPPED     // Catch:{ Exception -> 0x0178 }
            r1.set(r3)     // Catch:{ Exception -> 0x0178 }
            r10.disconnected()     // Catch:{ Exception -> 0x0178 }
            goto L_0x017c
        L_0x0178:
            r1 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.Throwable) r1)
        L_0x017c:
            if (r2 == 0) goto L_0x0186
            r2.close()     // Catch:{ Exception -> 0x0182 }
            goto L_0x0186
        L_0x0182:
            r1 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.Throwable) r1)
        L_0x0186:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01ba }
            r1.<init>()     // Catch:{ Exception -> 0x01ba }
            java.lang.String r2 = "restart sRetryCount "
            r1.append(r2)     // Catch:{ Exception -> 0x01ba }
            int r2 = com.hpplay.imsdk.IMEntrance.sRetryCount     // Catch:{ Exception -> 0x01ba }
            r1.append(r2)     // Catch:{ Exception -> 0x01ba }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x01ba }
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x01ba }
            int r1 = com.hpplay.imsdk.IMEntrance.sRetryCount     // Catch:{ Exception -> 0x01ba }
            r2 = 1
            int r1 = r1 + r2
            com.hpplay.imsdk.IMEntrance.sRetryCount = r1     // Catch:{ Exception -> 0x01ba }
            if (r1 == r2) goto L_0x01b4
            r2 = 2
            if (r1 == r2) goto L_0x01ae
            r1 = 60000(0xea60, double:2.9644E-319)
            java.lang.Thread.sleep(r1)     // Catch:{ Exception -> 0x01ba }
            goto L_0x01bf
        L_0x01ae:
            r1 = 30000(0x7530, double:1.4822E-319)
            java.lang.Thread.sleep(r1)     // Catch:{ Exception -> 0x01ba }
            goto L_0x01bf
        L_0x01b4:
            r1 = 15000(0x3a98, double:7.411E-320)
            java.lang.Thread.sleep(r1)     // Catch:{ Exception -> 0x01ba }
            goto L_0x01bf
        L_0x01ba:
            java.lang.String r1 = "restart sleep interrupt"
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.String) r1)
        L_0x01bf:
            r10.restart()
            return
        L_0x01c3:
            r1 = move-exception
        L_0x01c4:
            java.util.concurrent.atomic.AtomicReference<com.hpplay.imsdk.AbstractBlockingClient$State> r3 = r10.state     // Catch:{ Exception -> 0x01cf }
            com.hpplay.imsdk.AbstractBlockingClient$State r4 = com.hpplay.imsdk.AbstractBlockingClient.State.STOPPED     // Catch:{ Exception -> 0x01cf }
            r3.set(r4)     // Catch:{ Exception -> 0x01cf }
            r10.disconnected()     // Catch:{ Exception -> 0x01cf }
            goto L_0x01d3
        L_0x01cf:
            r3 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.Throwable) r3)
        L_0x01d3:
            if (r2 == 0) goto L_0x01dd
            r2.close()     // Catch:{ Exception -> 0x01d9 }
            goto L_0x01dd
        L_0x01d9:
            r2 = move-exception
            com.hpplay.common.log.LeLog.w((java.lang.String) r0, (java.lang.Throwable) r2)
        L_0x01dd:
            goto L_0x01df
        L_0x01de:
            throw r1
        L_0x01df:
            goto L_0x01de
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.imsdk.AbstractBlockingClient.run():void");
    }

    public void setOnConnectListener(OnConnectServerListener onConnectServerListener) {
        this.mListener = onConnectServerListener;
    }

    public boolean stop() {
        boolean z10;
        if (!b.a(this.state, State.RUNNING, State.STOPPING)) {
            return false;
        }
        stopHeartBeat();
        try {
            this.in.get().close();
            z10 = true;
        } catch (Exception e10) {
            LeLog.w("IM_AbstractBlockingClient", (Throwable) e10);
            z10 = false;
        }
        try {
            this.out.get().close();
            return z10;
        } catch (Exception unused) {
            return false;
        }
    }

    public synchronized Boolean updateCapabilityWrite() {
        LeLog.i("IM_AbstractBlockingClient", "updateCapabilityWrite " + this.capability);
        String str = this.uid + ";" + this.capability + ";" + this.appid + ";" + this.token;
        byte[] bArr = new byte[16];
        BruteForceCoding.encodeIntBigEndian(bArr, 1, BruteForceCoding.encodeIntBigEndian(bArr, 15, BruteForceCoding.encodeIntBigEndian(bArr, 1, BruteForceCoding.encodeIntBigEndian(bArr, 16, BruteForceCoding.encodeIntBigEndian(bArr, (long) (str.getBytes().length + 16), 0, 4), 2), 2), 4), 4);
        this.out.get().write(BruteForceCoding.add(bArr, str.getBytes()));
        this.out.get().flush();
        return Boolean.TRUE;
    }

    public AbstractBlockingClient(String str, int i10, String str2, String str3, String str4, String str5, int i11) {
        this.TAG = "IM_AbstractBlockingClient";
        this.state = new AtomicReference<>(State.STOPPED);
        this.heartBeatTimeOut = TimeUnit.SECONDS.toMillis(50);
        this.defaultSocketTimeOut = 180000;
        this.out = new AtomicReference<>();
        this.in = new AtomicReference<>();
        this.server = str;
        this.port = i10;
        this.uid = str2;
        this.capability = str3;
        this.appid = str4;
        this.token = str5;
        this.defaultBufferSize = i11;
    }
}
