package com.hpplay.component.protocol.mirror;

import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.protocol.IMirrorController;
import com.hpplay.component.common.protocol.IMirrorStateListener;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.protocol.mirror.MirrorEventReceiver;
import java.nio.ByteBuffer;

public class MirrorControllerImp extends IMirrorController {
    private static final String TAG = "MirrorControllerImp";
    private IMirrorStateListener mListener;
    private MirrorEventReceiver mMirrorEventReceiver;
    /* access modifiers changed from: private */
    public MirrorProtocolTask mMirrorProtocolTask;
    MirrorEventReceiver.MirrorServStartListener mirrorEventReceiver = new MirrorEventReceiver.MirrorServStartListener() {
        public void onStart(MirrorEventReceiver mirrorEventReceiver) {
            if (MirrorControllerImp.this.mMirrorProtocolTask != null) {
                MirrorControllerImp.this.mMirrorProtocolTask.setRtspListener(mirrorEventReceiver.genMirrorStateListener());
                MirrorControllerImp.this.mMirrorProtocolTask.setMirrorEventPort(mirrorEventReceiver.getMirrorEventPort());
                MirrorControllerImp.this.mMirrorProtocolTask.start();
            }
        }
    };

    private void stopMirrorEventServ() {
        MirrorEventReceiver mirrorEventReceiver2 = this.mMirrorEventReceiver;
        if (mirrorEventReceiver2 != null) {
            mirrorEventReceiver2.setMirrorServStartListener((MirrorEventReceiver.MirrorServStartListener) null);
            this.mMirrorEventReceiver.stopServer();
            this.mMirrorEventReceiver = null;
        }
    }

    public void sendAudioData(byte[] bArr, int i10, int i11) {
        MirrorProtocolTask mirrorProtocolTask = this.mMirrorProtocolTask;
        if (mirrorProtocolTask != null) {
            mirrorProtocolTask.sendAudioData(bArr, i10, i11);
        }
    }

    public void sendVideoData(ByteBuffer byteBuffer, int i10, long j10) {
        MirrorProtocolTask mirrorProtocolTask = this.mMirrorProtocolTask;
        if (mirrorProtocolTask != null) {
            mirrorProtocolTask.sendVideoData(byteBuffer, i10, j10);
        }
    }

    public void setAdjustResolution(boolean z10) {
        MirrorProtocolTask mirrorProtocolTask = this.mMirrorProtocolTask;
        if (mirrorProtocolTask != null) {
            mirrorProtocolTask.setAdjustResolution(z10);
        }
    }

    public void setAutoBitrate(boolean z10) {
        MirrorProtocolTask mirrorProtocolTask = this.mMirrorProtocolTask;
        if (mirrorProtocolTask != null) {
            mirrorProtocolTask.setAutoBitrate(z10);
        }
    }

    public void setMirrorMode(String str) {
        MirrorProtocolTask mirrorProtocolTask = this.mMirrorProtocolTask;
        if (mirrorProtocolTask != null) {
            mirrorProtocolTask.setMirrorMode(str);
        }
    }

    public void setMirrorProtocolInfos(ParamsMap paramsMap) {
        MirrorProtocolTask mirrorProtocolTask = this.mMirrorProtocolTask;
        if (mirrorProtocolTask != null) {
            mirrorProtocolTask.stopMirror();
        }
        this.mMirrorProtocolTask = new MirrorProtocolTask(paramsMap);
    }

    public void setSendDataTimeout(int i10) {
        MirrorProtocolTask mirrorProtocolTask = this.mMirrorProtocolTask;
        if (mirrorProtocolTask != null) {
            mirrorProtocolTask.setSendDataTimeout(i10);
        }
    }

    public void startGetSinkInfos(IMirrorStateListener iMirrorStateListener) {
        this.mListener = iMirrorStateListener;
        if (this.mMirrorEventReceiver != null) {
            stopMirrorEventServ();
        }
        CLog.i(TAG, "  startGetSinkInfos  ");
        if (this.mMirrorEventReceiver == null) {
            MirrorEventReceiver mirrorEventReceiver2 = new MirrorEventReceiver(this.mListener, false);
            this.mMirrorEventReceiver = mirrorEventReceiver2;
            mirrorEventReceiver2.setMirrorServStartListener(this.mirrorEventReceiver);
            this.mMirrorEventReceiver.startServer();
        }
    }

    public void stopMirror() {
        try {
            MirrorProtocolTask mirrorProtocolTask = this.mMirrorProtocolTask;
            if (mirrorProtocolTask != null) {
                mirrorProtocolTask.stopMirror();
                this.mMirrorProtocolTask = null;
            }
            stopMirrorEventServ();
            this.mListener = null;
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
        }
    }

    public void switchWLANChannel(int i10) {
        MirrorProtocolTask mirrorProtocolTask = this.mMirrorProtocolTask;
        if (mirrorProtocolTask != null) {
            mirrorProtocolTask.switchWLANChannel(i10);
        }
    }
}
