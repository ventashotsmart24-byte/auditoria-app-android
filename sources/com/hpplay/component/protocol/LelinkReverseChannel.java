package com.hpplay.component.protocol;

import com.hpplay.component.common.protocol.ProtocolListener;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.protocol.encrypt.LelinkEncrypt;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class LelinkReverseChannel extends ProtocolCore implements Runnable {
    public static final String ENCRYPT_FAILED = "encrypt_failed";
    private static final String KEY_HEADER_EVENT = "POST /heart";
    private static final String KEY_HEADER_HARDBET = "POST /event";
    private static final String KEY_HEADER_PHOTO_STATE = "POST /photo";
    private static final String TAG = "LelinkReverseChannel";
    private boolean isStop = false;
    private LelinkEncrypt mLelinkEncrypt;
    private byte[] mProtocol;
    private ProtocolListener mProtocolListener;
    private Thread mReceiveThread;
    private byte[] receveData = null;
    private int totalLength = 0;

    public LelinkReverseChannel() {
    }

    private synchronized void closeSocket() {
        if (this.mLocalAutoCloseInputStream != null) {
            try {
                CLog.d(TAG, "----------->closeSender");
                this.mLocalAutoCloseInputStream.close();
            } catch (IOException e10) {
                CLog.w(TAG, (Throwable) e10);
            }
        }
        FileOutputStream fileOutputStream = this.mLocalFileOutputStream;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e11) {
                CLog.w(TAG, (Throwable) e11);
            }
        }
        Socket socket = this.mSocket;
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e12) {
                CLog.w(TAG, (Throwable) e12);
            }
        }
        this.mSocket = null;
        this.mLocalFileOutputStream = null;
        this.mLocalAutoCloseInputStream = null;
    }

    private void sendData() {
        CLog.i(TAG, "----------->> sendData");
        byte[] bArr = new byte[2048];
        try {
            this.mLocalFileOutputStream.write(this.mProtocol);
            this.mLocalFileOutputStream.flush();
            int read = this.mLocalAutoCloseInputStream.read(bArr);
            if (read >= 0) {
                String str = new String(bArr, 0, read);
                ProtocolListener protocolListener = this.mProtocolListener;
                if (protocolListener != null) {
                    protocolListener.onResult(protocolListener.cmdType, str);
                }
            }
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
        }
    }

    private void sendEncryptData() {
        try {
            this.mLocalFileOutputStream.write(this.mLelinkEncrypt.buildEncryptData(this.mProtocol));
            this.mLocalFileOutputStream.flush();
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0031 A[Catch:{ Exception -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parseResponse(byte[] r7) {
        /*
            r6 = this;
            java.lang.String r0 = "LelinkReverseChannel"
            com.hpplay.component.protocol.encrypt.LelinkEncrypt r1 = r6.mLelinkEncrypt     // Catch:{ Exception -> 0x003b }
            byte[] r7 = r1.decryptData(r7)     // Catch:{ Exception -> 0x003b }
            if (r7 == 0) goto L_0x003f
            int r1 = r7.length     // Catch:{ Exception -> 0x003b }
            if (r1 <= 0) goto L_0x003f
            byte[] r1 = com.hpplay.component.protocol.ProtocolUtils.getBody(r7)     // Catch:{ Exception -> 0x003b }
            java.lang.String r2 = "utf-8"
            r3 = 0
            if (r1 == 0) goto L_0x0023
            int r4 = r1.length     // Catch:{ Exception -> 0x003b }
            r5 = 10
            if (r4 >= r5) goto L_0x001c
            goto L_0x0023
        L_0x001c:
            java.lang.String r7 = new java.lang.String     // Catch:{ Exception -> 0x003b }
            int r4 = r1.length     // Catch:{ Exception -> 0x003b }
            r7.<init>(r1, r3, r4, r2)     // Catch:{ Exception -> 0x003b }
            goto L_0x002a
        L_0x0023:
            java.lang.String r1 = new java.lang.String     // Catch:{ Exception -> 0x003b }
            int r4 = r7.length     // Catch:{ Exception -> 0x003b }
            r1.<init>(r7, r3, r4, r2)     // Catch:{ Exception -> 0x003b }
            r7 = r1
        L_0x002a:
            com.hpplay.component.common.utils.CLog.i(r0, r7)     // Catch:{ Exception -> 0x003b }
            com.hpplay.component.common.protocol.ProtocolListener r1 = r6.mProtocolListener     // Catch:{ Exception -> 0x003b }
            if (r1 == 0) goto L_0x003f
            int r2 = r1.cmdType     // Catch:{ Exception -> 0x003b }
            java.lang.String[] r7 = new java.lang.String[]{r7}     // Catch:{ Exception -> 0x003b }
            r1.onResult(r2, r7)     // Catch:{ Exception -> 0x003b }
            goto L_0x003f
        L_0x003b:
            r7 = move-exception
            com.hpplay.component.common.utils.CLog.w((java.lang.String) r0, (java.lang.Throwable) r7)
        L_0x003f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.component.protocol.LelinkReverseChannel.parseResponse(byte[]):void");
    }

    public boolean readEncryptData() {
        try {
            byte[] bArr = new byte[4];
            int available = this.mLocalAutoCloseInputStream.available();
            int i10 = this.totalLength;
            if (i10 != 0) {
                byte[] bArr2 = new byte[available];
                byte[] bArr3 = this.receveData;
                if (available > bArr3.length - i10) {
                    available = bArr3.length - i10;
                    bArr2 = new byte[available];
                }
                this.mLocalAutoCloseInputStream.read(bArr2, 0, available);
                System.arraycopy(bArr2, 0, this.receveData, this.totalLength, bArr2.length);
                int i11 = this.totalLength + available;
                this.totalLength = i11;
                byte[] bArr4 = this.receveData;
                if (i11 == bArr4.length) {
                    parseResponse(bArr4);
                    this.totalLength = 0;
                    this.receveData = null;
                }
            } else if (this.mLocalAutoCloseInputStream.read(bArr, 0, 4) < 0) {
                return true;
            } else {
                int bytesToInt = ProtocolUtils.bytesToInt(bArr);
                if (bytesToInt != 0) {
                    if (bytesToInt <= 2097152) {
                        this.totalLength = 4;
                        byte[] bArr5 = new byte[(bytesToInt + 4 + 16)];
                        this.receveData = bArr5;
                        System.arraycopy(bArr, 0, bArr5, 0, 4);
                    }
                }
                return false;
            }
            return false;
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
            CLog.d(TAG, " startCapture read " + e10.toString());
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:81:0x017e, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x017f, code lost:
        com.hpplay.component.common.utils.CLog.w(TAG, (java.lang.Throwable) r4);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r15 = this;
            java.net.Socket r0 = r15.mSocket
            java.lang.String r1 = "LelinkReverseChannel"
            if (r0 != 0) goto L_0x000e
            r15.connectServer()     // Catch:{ Exception -> 0x000a }
            goto L_0x000e
        L_0x000a:
            r0 = move-exception
            com.hpplay.component.common.utils.CLog.w((java.lang.String) r1, (java.lang.Throwable) r0)
        L_0x000e:
            com.hpplay.component.protocol.encrypt.LelinkEncrypt r0 = r15.mLelinkEncrypt
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0062
            boolean r0 = r15.checkEncrypt(r0, r1)
            if (r0 != 0) goto L_0x002a
            com.hpplay.component.common.protocol.ProtocolListener r0 = r15.mProtocolListener
            if (r0 == 0) goto L_0x0029
            int r1 = r0.cmdType
            java.lang.String r2 = "encrypt_failed"
            java.lang.String[] r2 = new java.lang.String[]{r2}
            r0.onResult(r1, r2)
        L_0x0029:
            return
        L_0x002a:
            r15.sendEncryptData()
            r15.totalLength = r3
            r0 = 0
            r15.receveData = r0
            r15.isStop = r3
        L_0x0034:
            boolean r0 = r15.isStop
            if (r0 != 0) goto L_0x005e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            boolean r4 = r15.isStop
            r0.append(r4)
            java.lang.String r4 = " start read "
            r0.append(r4)
            com.hpplay.component.common.protocol.ProtocolListener r4 = r15.mProtocolListener
            if (r4 != 0) goto L_0x004d
            r4 = 1
            goto L_0x004e
        L_0x004d:
            r4 = 0
        L_0x004e:
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            com.hpplay.component.common.utils.CLog.d(r1, r0)
            boolean r0 = r15.readEncryptData()
            if (r0 == 0) goto L_0x0034
        L_0x005e:
            r15.closeSocket()
            return
        L_0x0062:
            byte[] r0 = r15.mProtocol
            if (r0 == 0) goto L_0x0069
            r15.sendData()
        L_0x0069:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            boolean r4 = r15.isStop
            r0.append(r4)
            java.lang.String r4 = "----------sendReverse---------------"
            r0.append(r4)
            android.os.ParcelFileDescriptor$AutoCloseInputStream r4 = r15.mLocalAutoCloseInputStream
            if (r4 != 0) goto L_0x007e
            r4 = 1
            goto L_0x007f
        L_0x007e:
            r4 = 0
        L_0x007f:
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            com.hpplay.component.common.utils.CLog.d(r1, r0)
            r0 = 11
            byte[] r4 = new byte[r0]
            r15.isStop = r3
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r7 = 0
        L_0x009a:
            r8 = 0
        L_0x009b:
            boolean r9 = r15.isStop
            if (r9 != 0) goto L_0x021f
            android.os.ParcelFileDescriptor$AutoCloseInputStream r9 = r15.mLocalAutoCloseInputStream
            if (r9 != 0) goto L_0x00a4
            goto L_0x009b
        L_0x00a4:
            int r7 = r9.read(r4)     // Catch:{ Exception -> 0x00a9 }
            goto L_0x00ad
        L_0x00a9:
            r9 = move-exception
            com.hpplay.component.common.utils.CLog.w((java.lang.String) r1, (java.lang.Throwable) r9)
        L_0x00ad:
            if (r7 > 0) goto L_0x00b0
            goto L_0x009b
        L_0x00b0:
            int r9 = r4.length
            java.lang.String r10 = "POST /photo"
            if (r9 != r2) goto L_0x0144
            byte r9 = r4[r3]
            java.lang.Byte r9 = java.lang.Byte.valueOf(r9)
            r5.add(r9)
            boolean r9 = com.hpplay.component.protocol.ProtocolUtils.getProtocolDivide(r5)
            if (r9 == 0) goto L_0x009b
            int r4 = r5.size()
            byte[] r9 = new byte[r4]
            r11 = 0
        L_0x00cb:
            if (r11 >= r4) goto L_0x00dc
            java.lang.Object r12 = r5.get(r11)
            java.lang.Byte r12 = (java.lang.Byte) r12
            byte r12 = r12.byteValue()
            r9[r11] = r12
            int r11 = r11 + 1
            goto L_0x00cb
        L_0x00dc:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r11 = ""
            r9.append(r11)
            r9.append(r4)
            java.lang.String r9 = r9.toString()
            java.lang.String r12 = "header"
            com.hpplay.component.common.utils.CLog.d(r12, r9)
            boolean r9 = r4.contains(r10)
            if (r9 == 0) goto L_0x010d
            com.hpplay.component.common.protocol.ProtocolListener r9 = r15.mProtocolListener
            if (r9 == 0) goto L_0x010a
            int r10 = r9.cmdType
            java.lang.String[] r4 = new java.lang.String[]{r4}
            r9.onResult(r10, r4)
        L_0x010a:
            byte[] r4 = new byte[r0]
            goto L_0x009b
        L_0x010d:
            int r4 = com.hpplay.component.protocol.ProtocolUtils.getContentLength(r4)     // Catch:{ Exception -> 0x013c }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013c }
            r9.<init>()     // Catch:{ Exception -> 0x013c }
            java.lang.String r10 = "contentLength"
            r9.append(r10)     // Catch:{ Exception -> 0x013c }
            r9.append(r4)     // Catch:{ Exception -> 0x013c }
            r9.append(r11)     // Catch:{ Exception -> 0x013c }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x013c }
            com.hpplay.component.common.utils.CLog.d(r1, r9)     // Catch:{ Exception -> 0x013c }
            if (r4 <= 0) goto L_0x0135
            r9 = 2097152(0x200000, float:2.938736E-39)
            if (r4 >= r9) goto L_0x0135
            byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x013c }
            r5.clear()     // Catch:{ Exception -> 0x013c }
            goto L_0x009b
        L_0x0135:
            byte[] r4 = new byte[r0]     // Catch:{ Exception -> 0x013c }
            r5.clear()     // Catch:{ Exception -> 0x013c }
            goto L_0x009b
        L_0x013c:
            r4 = move-exception
            com.hpplay.component.common.utils.CLog.w((java.lang.String) r1, (java.lang.Throwable) r4)
            byte[] r4 = new byte[r0]
            goto L_0x009b
        L_0x0144:
            int r9 = r4.length
            if (r9 != r0) goto L_0x0186
            if (r8 != 0) goto L_0x0186
            r5.clear()     // Catch:{ Exception -> 0x017e, all -> 0x017c }
            java.lang.String r9 = new java.lang.String     // Catch:{ Exception -> 0x017e, all -> 0x017c }
            int r11 = r4.length     // Catch:{ Exception -> 0x017e, all -> 0x017c }
            r9.<init>(r4, r3, r11)     // Catch:{ Exception -> 0x017e, all -> 0x017c }
            java.lang.String r11 = "POST /heart"
            boolean r11 = r9.equals(r11)     // Catch:{ Exception -> 0x017e, all -> 0x017c }
            if (r11 != 0) goto L_0x0168
            java.lang.String r11 = "POST /event"
            boolean r11 = r9.equals(r11)     // Catch:{ Exception -> 0x017e, all -> 0x017c }
            if (r11 != 0) goto L_0x0168
            boolean r10 = r9.equals(r10)     // Catch:{ Exception -> 0x017e, all -> 0x017c }
            if (r10 == 0) goto L_0x0178
        L_0x0168:
            r10 = 0
        L_0x0169:
            int r11 = r4.length     // Catch:{ Exception -> 0x017e, all -> 0x017c }
            if (r10 >= r11) goto L_0x0178
            byte r11 = r4[r10]     // Catch:{ Exception -> 0x017e, all -> 0x017c }
            java.lang.Byte r11 = java.lang.Byte.valueOf(r11)     // Catch:{ Exception -> 0x017e, all -> 0x017c }
            r5.add(r11)     // Catch:{ Exception -> 0x017e, all -> 0x017c }
            int r10 = r10 + 1
            goto L_0x0169
        L_0x0178:
            com.hpplay.component.common.utils.CLog.d(r1, r9)     // Catch:{ Exception -> 0x017e, all -> 0x017c }
            goto L_0x0182
        L_0x017c:
            r0 = move-exception
            throw r0
        L_0x017e:
            r4 = move-exception
            com.hpplay.component.common.utils.CLog.w((java.lang.String) r1, (java.lang.Throwable) r4)
        L_0x0182:
            byte[] r4 = new byte[r2]
            goto L_0x009b
        L_0x0186:
            r5.clear()
            int r8 = r4.length     // Catch:{ Exception -> 0x0214 }
            if (r7 >= r8) goto L_0x01bf
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0214 }
            r8.<init>()     // Catch:{ Exception -> 0x0214 }
            java.lang.String r9 = "---------------------->"
            r8.append(r9)     // Catch:{ Exception -> 0x0214 }
            int r9 = r4.length     // Catch:{ Exception -> 0x0214 }
            r8.append(r9)     // Catch:{ Exception -> 0x0214 }
            java.lang.String r9 = "  ----------------   "
            r8.append(r9)     // Catch:{ Exception -> 0x0214 }
            r8.append(r7)     // Catch:{ Exception -> 0x0214 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0214 }
            com.hpplay.component.common.utils.CLog.d(r1, r8)     // Catch:{ Exception -> 0x0214 }
            byte[] r8 = new byte[r7]     // Catch:{ Exception -> 0x0214 }
            java.lang.System.arraycopy(r4, r3, r8, r3, r7)     // Catch:{ Exception -> 0x0214 }
            r6.add(r8)     // Catch:{ Exception -> 0x0214 }
            int r4 = r4.length     // Catch:{ Exception -> 0x0214 }
            int r4 = r4 - r7
            byte[] r8 = new byte[r4]     // Catch:{ Exception -> 0x0214 }
            if (r4 != r0) goto L_0x01b9
            r4 = 1
            goto L_0x01ba
        L_0x01b9:
            r4 = 0
        L_0x01ba:
            r14 = r8
            r8 = r4
            r4 = r14
            goto L_0x009b
        L_0x01bf:
            r9 = r7
            r8 = 0
        L_0x01c1:
            int r10 = r6.size()     // Catch:{ Exception -> 0x0214 }
            if (r8 >= r10) goto L_0x01d2
            java.lang.Object r10 = r6.get(r8)     // Catch:{ Exception -> 0x0214 }
            byte[] r10 = (byte[]) r10     // Catch:{ Exception -> 0x0214 }
            int r10 = r10.length     // Catch:{ Exception -> 0x0214 }
            int r9 = r9 + r10
            int r8 = r8 + 1
            goto L_0x01c1
        L_0x01d2:
            byte[] r8 = new byte[r9]     // Catch:{ Exception -> 0x0214 }
            r10 = 0
            r11 = 0
        L_0x01d6:
            int r12 = r6.size()     // Catch:{ Exception -> 0x0214 }
            if (r10 >= r12) goto L_0x01f5
            java.lang.Object r12 = r6.get(r10)     // Catch:{ Exception -> 0x0214 }
            java.lang.Object r13 = r6.get(r10)     // Catch:{ Exception -> 0x0214 }
            byte[] r13 = (byte[]) r13     // Catch:{ Exception -> 0x0214 }
            int r13 = r13.length     // Catch:{ Exception -> 0x0214 }
            java.lang.System.arraycopy(r12, r3, r8, r11, r13)     // Catch:{ Exception -> 0x0214 }
            java.lang.Object r12 = r6.get(r10)     // Catch:{ Exception -> 0x0214 }
            byte[] r12 = (byte[]) r12     // Catch:{ Exception -> 0x0214 }
            int r12 = r12.length     // Catch:{ Exception -> 0x0214 }
            int r11 = r11 + r12
            int r10 = r10 + 1
            goto L_0x01d6
        L_0x01f5:
            java.lang.System.arraycopy(r4, r3, r8, r11, r7)     // Catch:{ Exception -> 0x0214 }
            java.lang.String r4 = new java.lang.String     // Catch:{ Exception -> 0x0214 }
            r4.<init>(r8, r3, r9)     // Catch:{ Exception -> 0x0214 }
            com.hpplay.component.common.utils.CLog.d(r1, r4)     // Catch:{ Exception -> 0x0214 }
            com.hpplay.component.common.protocol.ProtocolListener r8 = r15.mProtocolListener     // Catch:{ Exception -> 0x0214 }
            if (r8 == 0) goto L_0x020d
            int r9 = r8.cmdType     // Catch:{ Exception -> 0x0214 }
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch:{ Exception -> 0x0214 }
            r8.onResult(r9, r4)     // Catch:{ Exception -> 0x0214 }
        L_0x020d:
            byte[] r4 = new byte[r0]     // Catch:{ Exception -> 0x0214 }
            r6.clear()     // Catch:{ Exception -> 0x0214 }
            goto L_0x009a
        L_0x0214:
            r4 = move-exception
            com.hpplay.component.common.utils.CLog.w((java.lang.String) r1, (java.lang.Throwable) r4)
            byte[] r4 = new byte[r0]
            r6.clear()
            goto L_0x009a
        L_0x021f:
            r15.closeSocket()
            java.lang.String r0 = "----------exit---------------"
            com.hpplay.component.common.utils.CLog.d(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.component.protocol.LelinkReverseChannel.run():void");
    }

    public void setRecevelistenerAndProtocol(ProtocolListener protocolListener, byte[] bArr) {
        this.mProtocolListener = protocolListener;
        this.mProtocol = bArr;
    }

    public void startReceive() {
        if (this.mReceiveThread == null) {
            CLog.d(TAG, "---------------------->startReceive");
            Thread thread = new Thread(this);
            this.mReceiveThread = thread;
            thread.setName("ReverseReceiverThread");
            this.mReceiveThread.start();
        }
    }

    public synchronized void stopReceive() {
        this.isStop = true;
        if (this.mReceiveThread != null) {
            CLog.i(TAG, "---------------------->stopReceive");
            this.mReceiveThread.interrupt();
            this.mReceiveThread = null;
        }
        this.mProtocolListener = null;
        closeSocket();
    }

    public LelinkReverseChannel(String str, int i10) {
        this.mIP = str;
        this.mPort = i10;
        CLog.d(TAG, "create reverse");
    }

    public LelinkReverseChannel(String str, int i10, String str2) {
        this.mIP = str;
        this.mPort = i10;
        LelinkEncrypt lelinkEncrypt = new LelinkEncrypt(str2);
        this.mLelinkEncrypt = lelinkEncrypt;
        lelinkEncrypt.setSrpPassword((String) null);
        CLog.d(TAG, "create reverse");
    }

    public LelinkReverseChannel(String str, int i10, String str2, String str3) {
        this.mIP = str;
        this.mPort = i10;
        LelinkEncrypt lelinkEncrypt = new LelinkEncrypt(str2);
        this.mLelinkEncrypt = lelinkEncrypt;
        lelinkEncrypt.setSrpPassword(str3);
        CLog.d(TAG, "create reverse");
    }
}
