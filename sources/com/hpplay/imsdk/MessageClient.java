package com.hpplay.imsdk;

import com.hpplay.common.log.LeLog;

public class MessageClient extends AbstractBlockingClient {
    private final String TAG = "IM_MessageClient";
    private OnReceiveMessageListener mMsgReceiver;

    public MessageClient(String str, int i10, String str2, String str3, String str4, String str5) {
        super(str, i10, str2, str3, str4, str5);
    }

    public void connected(boolean z10) {
        LeLog.i("IM_MessageClient", "connected");
    }

    public void disconnected() {
    }

    public void heartBeatReceived() {
        LeLog.i("IM_MessageClient", "heartBeatReceived");
    }

    public void messageReceived(Long l10, Long l11, Long l12, Long l13, Long l14, String str) {
    }

    public void setMsgReceiver(OnReceiveMessageListener onReceiveMessageListener) {
        this.mMsgReceiver = onReceiveMessageListener;
    }

    public void messageReceived(String str) {
    }

    public void messageReceived(long j10, String str) {
        OnReceiveMessageListener onReceiveMessageListener = this.mMsgReceiver;
        if (onReceiveMessageListener != null) {
            onReceiveMessageListener.onMsg(j10, str);
        }
    }
}
