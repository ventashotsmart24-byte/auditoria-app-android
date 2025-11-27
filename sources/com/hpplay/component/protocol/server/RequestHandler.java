package com.hpplay.component.protocol.server;

import android.text.TextUtils;
import com.google.android.gms.cast.MediaError;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.protocol.IMirrorStateListener;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.protocol.NLProtocolBuiler;
import com.hpplay.component.protocol.ProtocolUtils;
import com.hpplay.component.protocol.plist.NSDictionary;
import com.hpplay.component.protocol.plist.PropertyListParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class RequestHandler implements IRequestHandler, Runnable {
    private static final String ERROR = "error";
    private static final String FORCE_STOPED = "force_stopped";
    private static final String KEY_HEADER_EVENT = "POST /heart";
    private static final String KEY_HEADER_HARDBET = "POST /event";
    private static final String KEY_HEADER_PHOTO_STATE = "POST /photo";
    private static final String MIRROR_MODE = "mirrormode";
    private static final String PREEMPT_STOPED = "preempt_stopped";
    private static final String REASON = "reason";
    private static final String SERVER_STOPED = "server_force_stopped";
    private static final String STATE = "state";
    private static final String STOPPED = "stopped";
    private static final String USER_STOPED = "user_stopped";
    private String TAG = "RequestHandler";
    private final Socket mAcceptSocket;
    private String mDeviceIp;
    private final InputStream mInputStream;
    private IMirrorStateListener mLelinkMirrorListener;
    private IRequstManager mRequstManager;

    public RequestHandler(IRequstManager iRequstManager, IMirrorStateListener iMirrorStateListener, InputStream inputStream, Socket socket) {
        this.mInputStream = inputStream;
        this.mAcceptSocket = socket;
        this.mLelinkMirrorListener = iMirrorStateListener;
        this.mRequstManager = iRequstManager;
        this.mDeviceIp = socket.getInetAddress().getHostAddress();
    }

    private void parseMirrorEvent(String str) {
        String str2 = this.TAG;
        CLog.i(str2, "------>" + str);
        if (this.mLelinkMirrorListener != null) {
            try {
                NSDictionary nSDictionary = (NSDictionary) PropertyListParser.parse(str.getBytes());
                if (nSDictionary == null) {
                    return;
                }
                if (nSDictionary.containsKey("state")) {
                    String obj = nSDictionary.objectForKey("state").toString();
                    obj.hashCode();
                    if (!obj.equals("stopped")) {
                        if (obj.equals("error")) {
                            CLog.d(this.TAG, MediaError.ERROR_TYPE_ERROR);
                        }
                    } else if (nSDictionary.containsKey("reason")) {
                        String obj2 = nSDictionary.objectForKey("reason").toString();
                        if (TextUtils.equals(obj2, FORCE_STOPED)) {
                            this.mLelinkMirrorListener.onSinkStop(this.mDeviceIp, ParamsMap.MirrorParams.MIRROR_ERROR_FORCE_STOP);
                        } else if (TextUtils.equals(obj2, "preempt_stopped")) {
                            this.mLelinkMirrorListener.onSinkStop(this.mDeviceIp, ParamsMap.MirrorParams.MIRROR_ERROR_PREEMPT_STOP);
                        } else if (TextUtils.equals(obj2, SERVER_STOPED)) {
                            this.mLelinkMirrorListener.onSinkStop(this.mDeviceIp, ParamsMap.MirrorParams.MIRROR_ERROR_SERVER_STOP);
                        }
                    }
                } else if (nSDictionary.containsKey(MIRROR_MODE)) {
                    String obj3 = nSDictionary.objectForKey(MIRROR_MODE).toString();
                    IMirrorStateListener iMirrorStateListener = this.mLelinkMirrorListener;
                    if (iMirrorStateListener != null) {
                        iMirrorStateListener.onMirrorModeCallback(obj3);
                    }
                }
            } catch (Exception e10) {
                CLog.w(this.TAG, (Throwable) e10);
            }
        }
    }

    public void close() {
        InputStream inputStream = this.mInputStream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e10) {
                CLog.w(this.TAG, (Throwable) e10);
            }
        }
        Socket socket = this.mAcceptSocket;
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e11) {
                CLog.w(this.TAG, (Throwable) e11);
            }
        }
        IRequstManager iRequstManager = this.mRequstManager;
        if (iRequstManager != null) {
            iRequstManager.closed(this);
        }
    }

    public void run() {
        try {
            OutputStream outputStream = this.mAcceptSocket.getOutputStream();
            byte[] bArr = new byte[11];
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i10 = 0;
            loop0:
            while (true) {
                boolean z10 = false;
                while (true) {
                    if (this.mAcceptSocket.isClosed()) {
                        break loop0;
                    }
                    try {
                        i10 = this.mInputStream.read(bArr);
                    } catch (Exception e10) {
                        CLog.w(this.TAG, (Throwable) e10);
                    }
                    if (i10 > 0) {
                        boolean z11 = true;
                        if (bArr.length == 1) {
                            arrayList.add(Byte.valueOf(bArr[0]));
                            if (ProtocolUtils.getProtocolDivide(arrayList)) {
                                int size = arrayList.size();
                                byte[] bArr2 = new byte[size];
                                for (int i11 = 0; i11 < size; i11++) {
                                    bArr2[i11] = ((Byte) arrayList.get(i11)).byteValue();
                                }
                                String str = new String(bArr2);
                                CLog.d("header", "" + str);
                                try {
                                    int contentLength = ProtocolUtils.getContentLength(str);
                                    CLog.d(this.TAG, "contentLength" + contentLength + "");
                                    if (contentLength <= 0 || contentLength >= 2097152) {
                                        bArr = new byte[11];
                                        arrayList.clear();
                                    } else {
                                        bArr = new byte[contentLength];
                                        arrayList.clear();
                                    }
                                } catch (Exception e11) {
                                    CLog.w(this.TAG, (Throwable) e11);
                                    bArr = new byte[11];
                                }
                            }
                        } else if (bArr.length != 11 || z10) {
                            arrayList.clear();
                            try {
                                if (i10 < bArr.length) {
                                    CLog.d(this.TAG, "---------------------->" + bArr.length + "  ----------------   " + i10);
                                    byte[] bArr3 = new byte[i10];
                                    System.arraycopy(bArr, 0, bArr3, 0, i10);
                                    arrayList2.add(bArr3);
                                    int length = bArr.length - i10;
                                    byte[] bArr4 = new byte[length];
                                    if (length != 11) {
                                        z11 = false;
                                    }
                                    bArr = bArr4;
                                    z10 = z11;
                                } else {
                                    int i12 = i10;
                                    for (int i13 = 0; i13 < arrayList2.size(); i13++) {
                                        i12 += ((byte[]) arrayList2.get(i13)).length;
                                    }
                                    byte[] bArr5 = new byte[i12];
                                    int i14 = 0;
                                    for (int i15 = 0; i15 < arrayList2.size(); i15++) {
                                        System.arraycopy(arrayList2.get(i15), 0, bArr5, i14, ((byte[]) arrayList2.get(i15)).length);
                                        i14 += ((byte[]) arrayList2.get(i15)).length;
                                    }
                                    System.arraycopy(bArr, 0, bArr5, i14, i10);
                                    String str2 = new String(bArr5, 0, i12);
                                    CLog.i(this.TAG, str2);
                                    parseMirrorEvent(str2);
                                    outputStream.write(NLProtocolBuiler.RESPONSE_OK.getBytes());
                                    outputStream.close();
                                }
                            } catch (Exception e12) {
                                CLog.w(this.TAG, (Throwable) e12);
                                bArr = new byte[11];
                                arrayList2.clear();
                            }
                        } else {
                            try {
                                arrayList.clear();
                                String str3 = new String(bArr, 0, bArr.length);
                                if (str3.equals(KEY_HEADER_EVENT) || str3.equals(KEY_HEADER_HARDBET) || str3.equals(KEY_HEADER_PHOTO_STATE)) {
                                    for (byte valueOf : bArr) {
                                        arrayList.add(Byte.valueOf(valueOf));
                                    }
                                }
                                CLog.d(this.TAG, str3);
                            } catch (Exception e13) {
                                CLog.w(this.TAG, (Throwable) e13);
                            }
                            bArr = new byte[1];
                        }
                    }
                }
            }
        } catch (Exception e14) {
            try {
                CLog.w(this.TAG, (Throwable) e14);
            } catch (Throwable th) {
                close();
                throw th;
            }
        }
        close();
        return;
    }
}
