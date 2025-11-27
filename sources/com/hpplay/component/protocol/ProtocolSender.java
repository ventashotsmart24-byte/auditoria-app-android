package com.hpplay.component.protocol;

import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.dlna.IDLNAController;
import com.hpplay.component.common.protocol.ProtocolListener;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.common.utils.ModuleIds;
import com.hpplay.component.modulelinker.api.ModuleLinker;
import com.hpplay.component.protocol.encrypt.LelinkEncrypt;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import org.json.JSONObject;

public class ProtocolSender extends ProtocolCore {
    private static final String CMD_CONNECT = "connect";
    private static final int MAX_RETRY_COUNT = 1;
    private static final String TAG = "ProtocolSender";
    /* access modifiers changed from: private */
    public final ProtocolQueue mProtocolQueues = new ProtocolQueue();
    /* access modifiers changed from: private */
    public int mRetryCount;
    private SocketThread mSocketThread;

    public class SocketThread extends Thread {
        private LelinkEncrypt lelinkEncrypt;
        private IDLNAController mDlnaController;
        private ModuleLinker mModuleLinker;
        private boolean mStartListen = true;
        private ProtocolListener socketConnectListener;
        private int type;

        public SocketThread(ProtocolListener protocolListener, int i10) {
            this.socketConnectListener = protocolListener;
            this.type = i10;
            setName(ProtocolSender.TAG);
        }

        private void DLNAHandle() {
            try {
                CLog.i(ProtocolSender.TAG, " start DLNA Handle ... ");
                while (this.mStartListen) {
                    try {
                        ProtocolInfo next = ProtocolSender.this.mProtocolQueues.next();
                        if (TextUtils.equals(new String(next.getProtocolData()[0]), "connect")) {
                            this.mStartListen = connectDLNA(next);
                            CLog.i(ProtocolSender.TAG, " connect result " + this.mStartListen);
                        } else {
                            String[] sendAction = this.mDlnaController.sendAction(new String(next.getProtocolData()[0]));
                            if (next.getProtocolListener() != null) {
                                next.getProtocolListener().onResult(next.getProtocolListener().cmdType, sendAction);
                            }
                        }
                    } catch (Exception e10) {
                        CLog.w(ProtocolSender.TAG, (Throwable) e10);
                    }
                }
            } catch (Exception e11) {
                CLog.w(ProtocolSender.TAG, (Throwable) e11);
            }
            CLog.i(ProtocolSender.TAG, "   DLNA Handle exit... ");
            this.mStartListen = false;
        }

        /* access modifiers changed from: private */
        public void closeSender() {
            FileOutputStream fileOutputStream = ProtocolSender.this.mLocalFileOutputStream;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e10) {
                    CLog.w(ProtocolSender.TAG, (Throwable) e10);
                }
            }
            ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = ProtocolSender.this.mLocalAutoCloseInputStream;
            if (autoCloseInputStream != null) {
                try {
                    autoCloseInputStream.close();
                } catch (IOException e11) {
                    CLog.w(ProtocolSender.TAG, (Throwable) e11);
                }
            }
            Socket socket = ProtocolSender.this.mSocket;
            if (socket != null) {
                try {
                    socket.close();
                    CLog.d(ProtocolSender.TAG, ProtocolSender.this.mSocket.isClosed() + "");
                } catch (IOException e12) {
                    CLog.w(ProtocolSender.TAG, (Throwable) e12);
                }
            }
            ProtocolSender protocolSender = ProtocolSender.this;
            protocolSender.mSocket = null;
            protocolSender.mLocalFileOutputStream = null;
            protocolSender.mLocalAutoCloseInputStream = null;
            IDLNAController iDLNAController = this.mDlnaController;
            if (iDLNAController != null) {
                iDLNAController.close();
                this.mDlnaController = null;
            }
            ModuleLinker moduleLinker = this.mModuleLinker;
            if (moduleLinker != null) {
                moduleLinker.removeObjOfMemory(ModuleIds.CLAZZ_ID1184_DLNACONTROLLERIMP);
                this.mModuleLinker = null;
            }
        }

        private boolean connectDLNA(ProtocolInfo protocolInfo) {
            try {
                closeSender();
                ModuleLinker newInstance = ModuleLinker.getNewInstance();
                this.mModuleLinker = newInstance;
                this.mDlnaController = (IDLNAController) newInstance.loadModule(ModuleIds.CLAZZ_ID1184_DLNACONTROLLERIMP);
                String str = new String(protocolInfo.getProtocolData()[1]);
                String str2 = new String(protocolInfo.getProtocolData()[2]);
                IDLNAController iDLNAController = (IDLNAController) this.mModuleLinker.loadModule(ModuleIds.CLAZZ_ID1184_DLNACONTROLLERIMP);
                this.mDlnaController = iDLNAController;
                boolean connect = iDLNAController.connect(str, str2, this.socketConnectListener);
                if (!connect) {
                    ProtocolSender protocolSender = ProtocolSender.this;
                    protocolSender.mErrorCode = ParamsMap.PushParams.PUSH_ERROR_DLNA_GETSERVICE;
                    protocolSender.mErrorMsg = "the DLNA locatio is invalid " + str;
                    protocolInfo.setProtocolListener(this.socketConnectListener);
                    resultCallback(protocolInfo, "failed");
                } else if (connect) {
                    ProtocolListener protocolListener = this.socketConnectListener;
                    protocolListener.onResult(protocolListener.cmdType, "successful");
                }
                return connect;
            } catch (Exception e10) {
                CLog.w(ProtocolSender.TAG, (Throwable) e10);
                return false;
            }
        }

        private boolean connectLelink(ProtocolInfo protocolInfo) {
            Exception exc;
            boolean z10;
            int i10;
            closeSender();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                z10 = ProtocolSender.this.connectServer();
                exc = null;
            } catch (Exception e10) {
                exc = e10;
                CLog.w(ProtocolSender.TAG, (Throwable) exc);
                z10 = false;
            }
            CLog.i(ProtocolSender.TAG, "create local socket " + z10 + "  connected time " + (System.currentTimeMillis() - currentTimeMillis) + "   hashCode " + hashCode());
            if (z10) {
                if (protocolInfo.getProtocolData().length > 1) {
                    String str = new String(protocolInfo.getProtocolData()[1]);
                    String str2 = new String(protocolInfo.getProtocolData()[2]);
                    LelinkEncrypt lelinkEncrypt2 = new LelinkEncrypt(str);
                    this.lelinkEncrypt = lelinkEncrypt2;
                    lelinkEncrypt2.setSrpPassword(str2);
                }
                if (this.lelinkEncrypt != null) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    this.mStartListen = ProtocolSender.this.checkEncrypt(this.lelinkEncrypt, ProtocolSender.TAG);
                    CLog.d(ProtocolSender.TAG, (System.currentTimeMillis() - currentTimeMillis2) + "   " + this.mStartListen + " thread name " + Thread.currentThread().getName());
                }
                ProtocolListener protocolListener = this.socketConnectListener;
                if (protocolListener != null) {
                    lelinkConnectStateCallback(this.lelinkEncrypt, protocolListener);
                }
                return true;
            }
            if (exc != null) {
                ProtocolSender protocolSender = ProtocolSender.this;
                if (this.lelinkEncrypt == null) {
                    i10 = ParamsMap.PushParams.PUSH_ERROR_LELINK_V1_CODE;
                } else {
                    i10 = ParamsMap.PushParams.PUSH_ERROR_LELINK_V2_CODE;
                }
                protocolSender.mErrorCode = i10;
                protocolSender.mErrorMsg = CLog.getExceptionStr(exc);
                protocolInfo.setProtocolListener(this.socketConnectListener);
                try {
                    resultCallback(protocolInfo, "failed");
                    return false;
                } catch (Exception e11) {
                    CLog.w(ProtocolSender.TAG, (Throwable) e11);
                }
            }
            ProtocolListener protocolListener2 = this.socketConnectListener;
            if (protocolListener2 != null) {
                protocolListener2.onResult(protocolListener2.cmdType, "failed");
            }
            return false;
        }

        private void lelinkConnectStateCallback(LelinkEncrypt lelinkEncrypt2, ProtocolListener protocolListener) {
            if (this.mStartListen) {
                protocolListener.onResult(protocolListener.cmdType, "successful");
            } else if (lelinkEncrypt2.getEncryptState().equals("failed")) {
                protocolListener.onResult(protocolListener.cmdType, "encrypt_failed");
            } else if (lelinkEncrypt2.getEncryptState().equals(ProtocolBuilder.LELINK_AUTH_ERROR)) {
                protocolListener.onResult(protocolListener.cmdType, ProtocolBuilder.LELINK_AUTH_ERROR);
            } else if (lelinkEncrypt2.getEncryptState().equals(ProtocolBuilder.LELINK_UNSUPPORT_PREEMPT)) {
                protocolListener.onResult(protocolListener.cmdType, ProtocolBuilder.LELINK_UNSUPPORT_PREEMPT);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b0, code lost:
            com.hpplay.component.common.utils.CLog.w(com.hpplay.component.protocol.ProtocolSender.TAG, "InterruptedException thread exit ...");
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void lelinkHandle() {
            /*
                r6 = this;
            L_0x0000:
                boolean r0 = r6.mStartListen
                r1 = 0
                if (r0 == 0) goto L_0x00b7
                com.hpplay.component.protocol.ProtocolSender r0 = com.hpplay.component.protocol.ProtocolSender.this     // Catch:{ Exception -> 0x00b0 }
                com.hpplay.component.protocol.ProtocolQueue r0 = r0.mProtocolQueues     // Catch:{ Exception -> 0x00b0 }
                com.hpplay.component.protocol.ProtocolInfo r0 = r0.next()     // Catch:{ Exception -> 0x00b0 }
                java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x00b0 }
                byte[][] r3 = r0.getProtocolData()     // Catch:{ Exception -> 0x00b0 }
                r3 = r3[r1]     // Catch:{ Exception -> 0x00b0 }
                r2.<init>(r3)     // Catch:{ Exception -> 0x00b0 }
                java.lang.String r3 = "connect"
                boolean r2 = android.text.TextUtils.equals(r2, r3)     // Catch:{ Exception -> 0x00b0 }
                if (r2 == 0) goto L_0x0029
                boolean r0 = r6.connectLelink(r0)     // Catch:{ Exception -> 0x00b0 }
                r6.mStartListen = r0     // Catch:{ Exception -> 0x00b0 }
                goto L_0x0000
            L_0x0029:
                com.hpplay.component.protocol.encrypt.LelinkEncrypt r2 = r6.lelinkEncrypt     // Catch:{ Exception -> 0x00b0 }
                r3 = 1
                java.lang.String r4 = "failed"
                if (r2 == 0) goto L_0x0070
                java.lang.String r2 = r6.lelinkV2SendData(r2, r0)     // Catch:{ Exception -> 0x005e }
                boolean r5 = r2.equals(r4)     // Catch:{ Exception -> 0x005e }
                if (r5 == 0) goto L_0x0058
                com.hpplay.component.protocol.ProtocolSender r5 = com.hpplay.component.protocol.ProtocolSender.this     // Catch:{ Exception -> 0x005e }
                int r5 = r5.mRetryCount     // Catch:{ Exception -> 0x005e }
                if (r5 >= r3) goto L_0x0058
                com.hpplay.component.protocol.ProtocolSender r2 = com.hpplay.component.protocol.ProtocolSender.this     // Catch:{ Exception -> 0x005e }
                com.hpplay.component.protocol.ProtocolSender.access$108(r2)     // Catch:{ Exception -> 0x005e }
                com.hpplay.component.protocol.ProtocolSender r2 = com.hpplay.component.protocol.ProtocolSender.this     // Catch:{ Exception -> 0x005e }
                com.hpplay.component.protocol.ProtocolQueue r2 = r2.mProtocolQueues     // Catch:{ Exception -> 0x005e }
                r2.enqueue(r0)     // Catch:{ Exception -> 0x005e }
                java.lang.String r2 = "IPushHandler"
                java.lang.String r3 = "========RESULT_FAILED========"
                com.hpplay.component.common.utils.CLog.i(r2, r3)     // Catch:{ Exception -> 0x005e }
                goto L_0x0000
            L_0x0058:
                com.hpplay.component.protocol.ProtocolSender r3 = com.hpplay.component.protocol.ProtocolSender.this     // Catch:{ Exception -> 0x005e }
                int unused = r3.mRetryCount = r1     // Catch:{ Exception -> 0x005e }
                goto L_0x0097
            L_0x005e:
                r2 = move-exception
                com.hpplay.component.protocol.ProtocolSender r3 = com.hpplay.component.protocol.ProtocolSender.this     // Catch:{ Exception -> 0x00b0 }
                r5 = 120103102(0x728a0be, float:1.2686153E-34)
                r3.mErrorCode = r5     // Catch:{ Exception -> 0x00b0 }
                java.lang.String r2 = com.hpplay.component.common.utils.CLog.getExceptionStr(r2)     // Catch:{ Exception -> 0x00b0 }
                r3.mErrorMsg = r2     // Catch:{ Exception -> 0x00b0 }
                r6.resultCallback(r0, r4)     // Catch:{ Exception -> 0x00b0 }
                goto L_0x00b7
            L_0x0070:
                com.hpplay.component.common.protocol.ProtocolListener r2 = r0.getProtocolListener()     // Catch:{ Exception -> 0x00b0 }
                if (r2 == 0) goto L_0x0093
                com.hpplay.component.common.protocol.ProtocolListener r2 = r0.getProtocolListener()     // Catch:{ Exception -> 0x00b0 }
                boolean r2 = r2 instanceof com.hpplay.component.protocol.DataReceiveListener     // Catch:{ Exception -> 0x00b0 }
                if (r2 == 0) goto L_0x0093
                com.hpplay.component.protocol.ProtocolSender r2 = com.hpplay.component.protocol.ProtocolSender.this     // Catch:{ Exception -> 0x00b0 }
                byte[][] r4 = r0.getProtocolData()     // Catch:{ Exception -> 0x00b0 }
                byte[] r2 = r2.interactiveDataNoHeader(r4)     // Catch:{ Exception -> 0x00b0 }
                com.hpplay.component.common.protocol.ProtocolListener r0 = r0.getProtocolListener()     // Catch:{ Exception -> 0x00b0 }
                com.hpplay.component.protocol.DataReceiveListener r0 = (com.hpplay.component.protocol.DataReceiveListener) r0     // Catch:{ Exception -> 0x00b0 }
                r0.onDataResult(r3, r2)     // Catch:{ Exception -> 0x00b0 }
                goto L_0x0000
            L_0x0093:
                java.lang.String r2 = r6.lelinkV1SendData(r0)     // Catch:{ Exception -> 0x009c }
            L_0x0097:
                r6.resultCallback(r0, r2)     // Catch:{ Exception -> 0x00b0 }
                goto L_0x0000
            L_0x009c:
                r2 = move-exception
                com.hpplay.component.protocol.ProtocolSender r3 = com.hpplay.component.protocol.ProtocolSender.this     // Catch:{ Exception -> 0x00b0 }
                r5 = 120103101(0x728a0bd, float:1.2686152E-34)
                r3.mErrorCode = r5     // Catch:{ Exception -> 0x00b0 }
                com.hpplay.component.protocol.ProtocolSender r3 = com.hpplay.component.protocol.ProtocolSender.this     // Catch:{ Exception -> 0x00b0 }
                java.lang.String r2 = com.hpplay.component.common.utils.CLog.getExceptionStr(r2)     // Catch:{ Exception -> 0x00b0 }
                r3.mErrorMsg = r2     // Catch:{ Exception -> 0x00b0 }
                r6.resultCallback(r0, r4)     // Catch:{ Exception -> 0x00b0 }
                goto L_0x00b7
            L_0x00b0:
                java.lang.String r0 = "ProtocolSender"
                java.lang.String r2 = "InterruptedException thread exit ..."
                com.hpplay.component.common.utils.CLog.w((java.lang.String) r0, (java.lang.String) r2)
            L_0x00b7:
                r6.mStartListen = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hpplay.component.protocol.ProtocolSender.SocketThread.lelinkHandle():void");
        }

        private String lelinkV1SendData(ProtocolInfo protocolInfo) {
            byte[] interactiveData = ProtocolSender.this.interactiveData(protocolInfo.getProtocolData());
            if (interactiveData != null && interactiveData.length != 0) {
                return new String(interactiveData);
            }
            ProtocolSender protocolSender = ProtocolSender.this;
            protocolSender.mErrorCode = ParamsMap.PushParams.PUSH_ERROR_LELINK_V1_CODE;
            protocolSender.mErrorMsg = ProtocolCore.ERR_MSG_DETAIL;
            return "failed";
        }

        private String lelinkV2SendData(LelinkEncrypt lelinkEncrypt2, ProtocolInfo protocolInfo) {
            byte[] bArr;
            long currentTimeMillis = System.currentTimeMillis();
            byte[] buildEncryptData = lelinkEncrypt2.buildEncryptData(protocolInfo.getProtocolData());
            String str = new String(protocolInfo.getProtocolData()[0]).split("\r\n")[0];
            byte[] bArr2 = null;
            if (buildEncryptData != null) {
                bArr = ProtocolSender.this.interactiveEncryptData(buildEncryptData);
            } else {
                bArr = null;
            }
            if (System.currentTimeMillis() - currentTimeMillis > 1000) {
                CLog.i(ProtocolSender.TAG, "============= timeout===> " + (System.currentTimeMillis() - currentTimeMillis) + " " + str + "  " + hashCode());
            }
            if (bArr == null || bArr.length == 0) {
                CLog.i(ProtocolSender.TAG, " request failed  " + (System.currentTimeMillis() - currentTimeMillis) + "====hashCode==== " + hashCode() + "  " + str + "    hashCode  " + hashCode());
                ProtocolSender protocolSender = ProtocolSender.this;
                protocolSender.mErrorCode = ParamsMap.PushParams.PUSH_ERROR_LELINK_V2_CODE;
                protocolSender.mErrorMsg = ProtocolCore.ERR_MSG_DETAIL;
                return "failed";
            }
            try {
                bArr2 = lelinkEncrypt2.decryptData(bArr);
            } catch (Exception e10) {
                ProtocolSender.this.mErrorCode = ParamsMap.PushParams.PUSH_ERROR_LELINK_V2_CODE;
                ProtocolSender.this.mErrorMsg = CLog.getExceptionStr(e10);
                CLog.w(ProtocolSender.TAG, (Throwable) e10);
            }
            if (bArr2 != null) {
                return new String(bArr2);
            }
            return "failed";
        }

        private void resultCallback(ProtocolInfo protocolInfo, String str) {
            String str2;
            if (protocolInfo.getProtocolListener() != null) {
                if (protocolInfo.getProtocolListener().cmdType == 1 || (protocolInfo.getProtocolListener().cmdType == 11 && str.equals("failed"))) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("errMsg", ProtocolSender.this.mErrorMsg);
                    jSONObject.put("errCode", ProtocolSender.this.mErrorCode);
                    str2 = jSONObject.toString();
                } else {
                    str2 = null;
                }
                protocolInfo.getProtocolListener().onResult(protocolInfo.getProtocolListener().cmdType, str, str2);
            }
        }

        public void clearCallbackListener() {
            this.socketConnectListener = null;
            this.mStartListen = false;
            LelinkEncrypt lelinkEncrypt2 = this.lelinkEncrypt;
            if (lelinkEncrypt2 != null) {
                lelinkEncrypt2.release();
                this.lelinkEncrypt = null;
            }
        }

        public int getType() {
            return this.type;
        }

        public boolean isStartListen() {
            return this.mStartListen;
        }

        public void run() {
            super.run();
            CLog.i(ProtocolSender.TAG, "protocol run  ");
            this.mStartListen = true;
            if (3 == this.type) {
                DLNAHandle();
            } else {
                lelinkHandle();
            }
            ProtocolSender.this.release();
        }
    }

    public static /* synthetic */ int access$108(ProtocolSender protocolSender) {
        int i10 = protocolSender.mRetryCount;
        protocolSender.mRetryCount = i10 + 1;
        return i10;
    }

    public boolean isConnect() {
        SocketThread socketThread = this.mSocketThread;
        if (socketThread != null) {
            return socketThread.isStartListen();
        }
        return false;
    }

    public void protocolEnqueue(ProtocolListener protocolListener, byte[]... bArr) {
        ProtocolInfo protocolInfo = new ProtocolInfo();
        protocolInfo.setProtocolData(bArr);
        protocolInfo.setProtocolListener(protocolListener);
        try {
            this.mProtocolQueues.enqueue(protocolInfo);
        } catch (InterruptedException e10) {
            CLog.w(TAG, (Throwable) e10);
        }
    }

    public synchronized void release() {
        long currentTimeMillis = System.currentTimeMillis();
        SocketThread socketThread = this.mSocketThread;
        if (socketThread != null) {
            socketThread.clearCallbackListener();
            this.mSocketThread.interrupt();
            this.mSocketThread.closeSender();
            this.mSocketThread = null;
        }
        this.mProtocolQueues.release();
        CLog.i(TAG, "closeSender  ==== >hashCode " + hashCode() + "   close time " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void setConnectInfo(String str, int i10) {
        this.mIP = str;
        this.mPort = i10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0010, code lost:
        if (r0.getType() != r6) goto L_0x0012;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008a A[Catch:{ Exception -> 0x009b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void startConnect(java.lang.String r4, java.lang.String r5, int r6, com.hpplay.component.common.protocol.ProtocolListener r7) {
        /*
            r3 = this;
            boolean r0 = r3.isConnect()     // Catch:{ Exception -> 0x009b }
            java.lang.String r1 = "pushlink"
            if (r0 == 0) goto L_0x0012
            com.hpplay.component.protocol.ProtocolSender$SocketThread r0 = r3.mSocketThread     // Catch:{ Exception -> 0x009b }
            if (r0 == 0) goto L_0x0039
            int r0 = r0.getType()     // Catch:{ Exception -> 0x009b }
            if (r0 == r6) goto L_0x0039
        L_0x0012:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009b }
            r0.<init>()     // Catch:{ Exception -> 0x009b }
            java.lang.String r2 = "reconnect    "
            r0.append(r2)     // Catch:{ Exception -> 0x009b }
            com.hpplay.component.protocol.ProtocolQueue r2 = r3.mProtocolQueues     // Catch:{ Exception -> 0x009b }
            int r2 = r2.queueSize()     // Catch:{ Exception -> 0x009b }
            r0.append(r2)     // Catch:{ Exception -> 0x009b }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x009b }
            com.hpplay.component.common.utils.CLog.i(r1, r0)     // Catch:{ Exception -> 0x009b }
            r3.release()     // Catch:{ Exception -> 0x009b }
            com.hpplay.component.protocol.ProtocolSender$SocketThread r0 = new com.hpplay.component.protocol.ProtocolSender$SocketThread     // Catch:{ Exception -> 0x009b }
            r0.<init>(r7, r6)     // Catch:{ Exception -> 0x009b }
            r3.mSocketThread = r0     // Catch:{ Exception -> 0x009b }
            r0.start()     // Catch:{ Exception -> 0x009b }
        L_0x0039:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009b }
            r7.<init>()     // Catch:{ Exception -> 0x009b }
            java.lang.String r0 = "startConnect  type: "
            r7.append(r0)     // Catch:{ Exception -> 0x009b }
            r7.append(r6)     // Catch:{ Exception -> 0x009b }
            java.lang.String r6 = "   "
            r7.append(r6)     // Catch:{ Exception -> 0x009b }
            com.hpplay.component.protocol.ProtocolQueue r6 = r3.mProtocolQueues     // Catch:{ Exception -> 0x009b }
            int r6 = r6.queueSize()     // Catch:{ Exception -> 0x009b }
            r7.append(r6)     // Catch:{ Exception -> 0x009b }
            java.lang.String r6 = r7.toString()     // Catch:{ Exception -> 0x009b }
            com.hpplay.component.common.utils.CLog.i(r1, r6)     // Catch:{ Exception -> 0x009b }
            com.hpplay.component.protocol.ProtocolInfo r6 = new com.hpplay.component.protocol.ProtocolInfo     // Catch:{ Exception -> 0x009b }
            r6.<init>()     // Catch:{ Exception -> 0x009b }
            boolean r7 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x009b }
            java.lang.String r0 = "connect"
            r1 = 0
            r2 = 1
            if (r7 != 0) goto L_0x008a
            r7 = 3
            byte[][] r7 = new byte[r7][]     // Catch:{ Exception -> 0x009b }
            byte[] r0 = r0.getBytes()     // Catch:{ Exception -> 0x009b }
            r7[r1] = r0     // Catch:{ Exception -> 0x009b }
            byte[] r4 = r4.getBytes()     // Catch:{ Exception -> 0x009b }
            r7[r2] = r4     // Catch:{ Exception -> 0x009b }
            if (r5 != 0) goto L_0x0082
            java.lang.String r4 = ""
            byte[] r4 = r4.getBytes()     // Catch:{ Exception -> 0x009b }
            goto L_0x0086
        L_0x0082:
            byte[] r4 = r5.getBytes()     // Catch:{ Exception -> 0x009b }
        L_0x0086:
            r5 = 2
            r7[r5] = r4     // Catch:{ Exception -> 0x009b }
            goto L_0x0092
        L_0x008a:
            byte[][] r7 = new byte[r2][]     // Catch:{ Exception -> 0x009b }
            byte[] r4 = r0.getBytes()     // Catch:{ Exception -> 0x009b }
            r7[r1] = r4     // Catch:{ Exception -> 0x009b }
        L_0x0092:
            r6.setProtocolData(r7)     // Catch:{ Exception -> 0x009b }
            com.hpplay.component.protocol.ProtocolQueue r4 = r3.mProtocolQueues     // Catch:{ Exception -> 0x009b }
            r4.enqueue(r6)     // Catch:{ Exception -> 0x009b }
            goto L_0x00a1
        L_0x009b:
            r4 = move-exception
            java.lang.String r5 = "ProtocolSender"
            com.hpplay.component.common.utils.CLog.w((java.lang.String) r5, (java.lang.Throwable) r4)
        L_0x00a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.component.protocol.ProtocolSender.startConnect(java.lang.String, java.lang.String, int, com.hpplay.component.common.protocol.ProtocolListener):void");
    }
}
