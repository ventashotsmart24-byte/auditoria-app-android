package com.hpplay.component.protocol.connection;

import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.protocol.IConnector;
import com.hpplay.component.common.protocol.ProtocolListener;
import com.hpplay.component.common.utils.CLog;

public class ConnectorImp extends IConnector {
    private static final String TAG = "ConnectorImp";
    private ConnectTask mConnectTask;
    private Thread mConnectThread;

    public void checkConnection(ProtocolListener protocolListener) {
        CLog.i(TAG, "checkConnection ~~~~");
        ConnectTask connectTask = this.mConnectTask;
        if (connectTask != null) {
            connectTask.checkConnection(protocolListener);
        }
    }

    public void connect(ParamsMap paramsMap, ProtocolListener protocolListener) {
        CLog.i(TAG, "connect ~~~~");
        ConnectTask connectTask = new ConnectTask();
        this.mConnectTask = connectTask;
        connectTask.connect(paramsMap, protocolListener);
        Thread thread = new Thread(this.mConnectTask);
        this.mConnectThread = thread;
        thread.start();
    }

    public void disConnect() {
        CLog.i(TAG, "disConnect");
        ConnectTask connectTask = this.mConnectTask;
        if (connectTask != null) {
            connectTask.setProtocolListener((ProtocolListener) null);
            this.mConnectTask.disConnect();
        }
        Thread thread = this.mConnectThread;
        if (thread != null) {
            thread.interrupt();
            this.mConnectThread = null;
        }
    }

    public String getConnectSessionId() {
        ConnectTask connectTask = this.mConnectTask;
        if (connectTask != null) {
            return connectTask.getConnectSessionId();
        }
        return "";
    }

    public void onAppPause() {
        ConnectTask connectTask = this.mConnectTask;
        if (connectTask != null) {
            connectTask.onAppPause();
        }
    }

    public void onAppResume() {
        ConnectTask connectTask = this.mConnectTask;
        if (connectTask != null) {
            connectTask.onAppResume();
        }
    }

    public boolean sendPassthroughData(int i10, String str, String str2, ProtocolListener protocolListener) {
        ConnectTask connectTask = this.mConnectTask;
        if (connectTask == null) {
            return false;
        }
        return connectTask.sendPassthroughData(i10, str, str2, protocolListener);
    }
}
