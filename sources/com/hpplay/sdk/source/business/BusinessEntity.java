package com.hpplay.sdk.source.business;

import android.content.Context;
import android.text.TextUtils;
import com.hpplay.sdk.source.api.IDaPlayerListener;
import com.hpplay.sdk.source.api.ILelinkPlayerListener;
import com.hpplay.sdk.source.api.INewPlayerListener;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.business.cloud.AuthSDK;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.mirror.yim.YimMirror;
import com.hpplay.sdk.source.process.ConnectManager;
import com.hpplay.sdk.source.protocol.connect.ConnectBridge;
import com.hpplay.sdk.source.utils.CastUtil;
import com.hpplay.sdk.source.utils.Feature;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BusinessEntity {
    private static int KEEP_SIZE = 1;
    private static final String TAG = "BusinessEntity";
    private static BusinessEntity sInstance;
    private final ConcurrentLinkedQueue<PlayController> mControllers = new ConcurrentLinkedQueue<>();
    private PlayController mLastPlayController;
    private final LelinkPlayerListenerDispatcher mListenerDispatcher = new LelinkPlayerListenerDispatcher();
    private long mPreCastTime = -1;

    private BusinessEntity() {
    }

    private boolean checkSdkUsable() {
        if (AuthSDK.getInstance().checkSdkUsable()) {
            return true;
        }
        SourceLog.w(TAG, "checkSdkUsable auth failed authCode := " + AuthSDK.getInstance().getAuthCode());
        if (this.mListenerDispatcher != null) {
            if (AuthSDK.getInstance().getAuthCode() == -101) {
                this.mListenerDispatcher.onError((OutParameter) null, -1, -2);
            } else {
                this.mListenerDispatcher.onError((OutParameter) null, -1, 0);
            }
        }
        return false;
    }

    private void clearPreCast() {
        int size = (this.mControllers.size() - KEEP_SIZE) + 1;
        Iterator<PlayController> it = this.mControllers.iterator();
        while (it.hasNext()) {
            PlayController next = it.next();
            SourceLog.i(TAG, "clearPreCast " + next.getPlayInfo());
            next.setStopType(1001);
            next.release();
            it.remove();
            size--;
            if (size <= 0) {
                return;
            }
        }
    }

    private void destroyPreCast() {
        if (this.mControllers.size() >= KEEP_SIZE) {
            int size = (this.mControllers.size() - KEEP_SIZE) + 1;
            Iterator<PlayController> it = this.mControllers.iterator();
            while (it.hasNext()) {
                PlayController next = it.next();
                SourceLog.i(TAG, "destroyPreCast " + next.getPlayInfo());
                next.stop(1001);
                next.release();
                it.remove();
                size--;
                if (size <= 0) {
                    return;
                }
            }
        }
    }

    private ConnectBridge getConnectBridge(OutParameter outParameter) {
        LelinkServiceInfo lelinkServiceInfo = outParameter.serviceInfo;
        if (lelinkServiceInfo == null || TextUtils.isEmpty(lelinkServiceInfo.getUid())) {
            return ConnectManager.getInstance().getLastConnectBridge();
        }
        return ConnectManager.getInstance().getConnectBridge(lelinkServiceInfo.getUid());
    }

    public static synchronized BusinessEntity getInstance() {
        BusinessEntity businessEntity;
        synchronized (BusinessEntity.class) {
            synchronized (BusinessEntity.class) {
                if (sInstance == null) {
                    sInstance = new BusinessEntity();
                }
            }
            businessEntity = sInstance;
        }
        return businessEntity;
    }

    private boolean isCurrentDevice(OutParameter outParameter) {
        OutParameter playInfo;
        LelinkServiceInfo lelinkServiceInfo;
        PlayController playController = this.mLastPlayController;
        if (playController == null || (playInfo = playController.getPlayInfo()) == null || (lelinkServiceInfo = playInfo.serviceInfo) == null || !lelinkServiceInfo.equals(outParameter.serviceInfo)) {
            return false;
        }
        return true;
    }

    private boolean isMirroring() {
        OutParameter playInfo;
        PlayController lastPlayController = getInstance().getLastPlayController();
        if (lastPlayController == null || (playInfo = lastPlayController.getPlayInfo()) == null || playInfo.castType != 2) {
            return false;
        }
        return true;
    }

    public void addVolume() {
        if (checkSdkUsable()) {
            PlayController playController = this.mLastPlayController;
            if (playController == null) {
                SourceLog.w(TAG, "addVolume ignore");
            } else {
                playController.addVolume();
            }
        }
    }

    public void appendPlayList(DramaInfoBean[] dramaInfoBeanArr, int i10, int i11, int i12) {
        if (checkSdkUsable()) {
            SourceLog.i(TAG, "appendPlayList " + this.mControllers.size());
            Iterator<PlayController> it = this.mControllers.iterator();
            while (it.hasNext()) {
                it.next().appendPlayList(dramaInfoBeanArr, i10, i11, i12);
            }
        }
    }

    public void clearPlayList() {
        if (checkSdkUsable()) {
            SourceLog.i(TAG, "clearPlayList " + this.mControllers.size());
            Iterator<PlayController> it = this.mControllers.iterator();
            while (it.hasNext()) {
                it.next().clearPlayList();
            }
        }
    }

    public void dispatch(Context context, OutParameter outParameter, boolean z10) {
        dispatch(context, outParameter);
    }

    public void dispatchPlay(Context context, OutParameter outParameter) {
        int i10;
        this.mListenerDispatcher.setCurrentPlayInfo(outParameter);
        if (this.mPreCastTime == -1) {
            i10 = -1;
        } else {
            i10 = (int) (System.currentTimeMillis() - this.mPreCastTime);
        }
        this.mPreCastTime = System.currentTimeMillis();
        PlayController playController = new PlayController(context, outParameter);
        playController.setDataSource(outParameter, i10);
        playController.start();
        playController.setLelinkPlayerListener(this.mListenerDispatcher);
        this.mControllers.add(playController);
        this.mLastPlayController = playController;
    }

    public void enableMultiCast(boolean z10) {
        int i10;
        boolean isSupportCloudMultiCast = CastUtil.isSupportCloudMultiCast();
        if (z10) {
            if (isSupportCloudMultiCast) {
                i10 = Integer.MAX_VALUE;
            } else {
                i10 = 4;
            }
            KEEP_SIZE = i10;
            return;
        }
        KEEP_SIZE = 1;
    }

    public ConcurrentLinkedQueue<PlayController> getControllers() {
        return this.mControllers;
    }

    public PlayController getLastPlayController() {
        return this.mLastPlayController;
    }

    public OutParameter getLastPlayInfo() {
        PlayController lastPlayController = getInstance().getLastPlayController();
        if (lastPlayController == null) {
            return null;
        }
        return lastPlayController.getPlayInfo();
    }

    public int getLastPlayState() {
        PlayController playController;
        if (checkSdkUsable() && (playController = this.mLastPlayController) != null) {
            return playController.getCurrentPlayState();
        }
        return -1;
    }

    public LelinkPlayerListenerDispatcher getListenerDispatcher() {
        return this.mListenerDispatcher;
    }

    public void onAppPause() {
        if (checkSdkUsable()) {
            SourceLog.i(TAG, "onAppPause " + this.mControllers.size());
            Iterator<PlayController> it = this.mControllers.iterator();
            while (it.hasNext()) {
                it.next().onAppPause();
            }
        }
    }

    public void onAppResume() {
        if (checkSdkUsable()) {
            SourceLog.i(TAG, "onAppResume " + this.mControllers.size());
            Iterator<PlayController> it = this.mControllers.iterator();
            while (it.hasNext()) {
                it.next().onAppResume();
            }
        }
    }

    public void onDaResult(OutParameter outParameter, boolean z10) {
        this.mListenerDispatcher.onDaResult(outParameter, z10);
    }

    public void onWifiConnected() {
        Iterator<PlayController> it = this.mControllers.iterator();
        while (it.hasNext()) {
            it.next().onWifiConnected();
        }
    }

    public void pause() {
        if (checkSdkUsable()) {
            SourceLog.i(TAG, "pause " + this.mControllers.size());
            Iterator<PlayController> it = this.mControllers.iterator();
            while (it.hasNext()) {
                it.next().pause();
            }
        }
    }

    public void playDrama(String str) {
        if (checkSdkUsable()) {
            SourceLog.i(TAG, "playDrama " + this.mControllers.size() + " / " + str);
            Iterator<PlayController> it = this.mControllers.iterator();
            while (it.hasNext()) {
                it.next().playDrama(str);
            }
        }
    }

    public void playNextDrama() {
        if (checkSdkUsable()) {
            SourceLog.i(TAG, "playNextDrama " + this.mControllers.size());
            Iterator<PlayController> it = this.mControllers.iterator();
            while (it.hasNext()) {
                it.next().playNextDrama();
            }
        }
    }

    public void playPreDrama() {
        if (checkSdkUsable()) {
            SourceLog.i(TAG, "playPreDrama " + this.mControllers.size());
            Iterator<PlayController> it = this.mControllers.iterator();
            while (it.hasNext()) {
                it.next().playPreDrama();
            }
        }
    }

    public void release() {
        SourceLog.i(TAG, "release");
        try {
            Iterator<PlayController> it = this.mControllers.iterator();
            while (it.hasNext()) {
                it.next().release();
            }
            this.mControllers.clear();
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    public void resume() {
        if (checkSdkUsable()) {
            SourceLog.i(TAG, "resume " + this.mControllers.size());
            Iterator<PlayController> it = this.mControllers.iterator();
            while (it.hasNext()) {
                it.next().resume();
            }
        }
    }

    public void seekTo(int i10) {
        if (checkSdkUsable()) {
            Iterator<PlayController> it = this.mControllers.iterator();
            while (it.hasNext()) {
                it.next().seekTo(i10);
            }
        }
    }

    public void selectAudioTrack(int i10) {
        if (checkSdkUsable()) {
            PlayController playController = this.mLastPlayController;
            if (playController == null) {
                SourceLog.w(TAG, "selectAudioTrack ignore");
            } else {
                playController.selectAudiotrack(i10);
            }
        }
    }

    public void setDaPlayListener(IDaPlayerListener iDaPlayerListener) {
        this.mListenerDispatcher.setDaPlayListener(iDaPlayerListener);
    }

    public void setMirrorScreenSecret(boolean z10) {
        if (checkSdkUsable()) {
            PlayController playController = this.mLastPlayController;
            if (playController == null) {
                SourceLog.w(TAG, "setMirrorScreenSecret ignore");
            } else {
                playController.setMirrorScreenSecret(z10);
            }
        }
    }

    public void setNewPlayerListener(INewPlayerListener iNewPlayerListener) {
        this.mListenerDispatcher.setNewPlayerListener(iNewPlayerListener);
    }

    public void setPlayerListener(ILelinkPlayerListener iLelinkPlayerListener) {
        this.mListenerDispatcher.setPlayerListener(iLelinkPlayerListener);
    }

    public void setVolume(int i10) {
        if (checkSdkUsable()) {
            PlayController playController = this.mLastPlayController;
            if (playController == null) {
                SourceLog.w(TAG, "setVolume ignore");
            } else {
                playController.setVolume(i10);
            }
        }
    }

    public void setWatermarkVisible(boolean z10) {
        if (checkSdkUsable()) {
            PlayController playController = this.mLastPlayController;
            if (playController == null) {
                SourceLog.w(TAG, "setWatermarkVisible ignore");
            } else {
                playController.setWatermarkVisible(z10);
            }
        }
    }

    public void stop(int i10) {
        Iterator<PlayController> it = this.mControllers.iterator();
        while (it.hasNext()) {
            it.next().stop(i10);
        }
        if (Feature.hasCloudMirror()) {
            YimMirror.getInstance().resetMultiCast();
        }
    }

    public void stopWithCallback(int i10) {
        Iterator<PlayController> it = this.mControllers.iterator();
        while (it.hasNext()) {
            it.next().stopWithCallback(i10);
        }
        if (Feature.hasCloudMirror()) {
            YimMirror.getInstance().resetMultiCast();
        }
    }

    public void subVolume() {
        if (checkSdkUsable()) {
            PlayController playController = this.mLastPlayController;
            if (playController == null) {
                SourceLog.w(TAG, "subVolume ignore");
            } else {
                playController.subVolume();
            }
        }
    }

    public void switchLelink() {
        PlayController playController = this.mLastPlayController;
        if (playController != null) {
            playController.doChangeChannel(1);
        }
    }

    public void switchYim() {
        PlayController playController = this.mLastPlayController;
        if (playController != null) {
            playController.doChangeChannel(4);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a4, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void dispatch(final android.content.Context r4, final com.hpplay.sdk.source.bean.OutParameter r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.checkSdkUsable()     // Catch:{ all -> 0x00a5 }
            if (r0 != 0) goto L_0x0010
            java.lang.String r4 = "BusinessEntity"
            java.lang.String r5 = "dispatch ignore"
            com.hpplay.sdk.source.log.SourceLog.i(r4, r5)     // Catch:{ all -> 0x00a5 }
            monitor-exit(r3)
            return
        L_0x0010:
            if (r5 != 0) goto L_0x0014
            monitor-exit(r3)
            return
        L_0x0014:
            java.lang.String r0 = "BusinessEntity"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a5 }
            r1.<init>()     // Catch:{ all -> 0x00a5 }
            java.lang.String r2 = "dispatch "
            r1.append(r2)     // Catch:{ all -> 0x00a5 }
            r1.append(r5)     // Catch:{ all -> 0x00a5 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a5 }
            com.hpplay.sdk.source.log.SourceLog.i(r0, r1)     // Catch:{ all -> 0x00a5 }
            java.lang.String r0 = "BusinessEntity"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a5 }
            r1.<init>()     // Catch:{ all -> 0x00a5 }
            java.lang.String r2 = "dispatch KEEP_SIZE: "
            r1.append(r2)     // Catch:{ all -> 0x00a5 }
            int r2 = KEEP_SIZE     // Catch:{ all -> 0x00a5 }
            r1.append(r2)     // Catch:{ all -> 0x00a5 }
            java.lang.String r2 = ", mControllers:"
            r1.append(r2)     // Catch:{ all -> 0x00a5 }
            java.util.concurrent.ConcurrentLinkedQueue<com.hpplay.sdk.source.business.PlayController> r2 = r3.mControllers     // Catch:{ all -> 0x00a5 }
            int r2 = r2.size()     // Catch:{ all -> 0x00a5 }
            r1.append(r2)     // Catch:{ all -> 0x00a5 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a5 }
            com.hpplay.sdk.source.log.SourceLog.i(r0, r1)     // Catch:{ all -> 0x00a5 }
            com.hpplay.sdk.source.business.LelinkPlayerListenerDispatcher r0 = r3.mListenerDispatcher     // Catch:{ all -> 0x00a5 }
            r0.setCurrentPlayInfo(r5)     // Catch:{ all -> 0x00a5 }
            com.hpplay.sdk.source.protocol.connect.ConnectBridge r0 = r3.getConnectBridge(r5)     // Catch:{ all -> 0x00a5 }
            if (r0 == 0) goto L_0x0081
            com.hpplay.sdk.source.browse.api.LelinkServiceInfo r0 = r5.serviceInfo     // Catch:{ all -> 0x00a5 }
            boolean r0 = com.hpplay.sdk.source.utils.CastUtil.isSupportLelinkV2((com.hpplay.sdk.source.browse.api.LelinkServiceInfo) r0)     // Catch:{ all -> 0x00a5 }
            if (r0 != 0) goto L_0x006b
            com.hpplay.sdk.source.browse.api.LelinkServiceInfo r0 = r5.serviceInfo     // Catch:{ all -> 0x00a5 }
            boolean r0 = com.hpplay.sdk.source.utils.CastUtil.isSupportIM(r0)     // Catch:{ all -> 0x00a5 }
            if (r0 == 0) goto L_0x0081
        L_0x006b:
            int r0 = r5.castType     // Catch:{ all -> 0x00a5 }
            r1 = 2
            if (r0 == r1) goto L_0x0081
            boolean r0 = r3.isMirroring()     // Catch:{ all -> 0x00a5 }
            if (r0 != 0) goto L_0x0081
            boolean r0 = r3.isCurrentDevice(r5)     // Catch:{ all -> 0x00a5 }
            if (r0 != 0) goto L_0x007d
            goto L_0x0081
        L_0x007d:
            r3.clearPreCast()     // Catch:{ all -> 0x00a5 }
            goto L_0x0084
        L_0x0081:
            r3.destroyPreCast()     // Catch:{ all -> 0x00a5 }
        L_0x0084:
            int r0 = r5.castType     // Catch:{ all -> 0x00a5 }
            r1 = 1
            if (r0 != r1) goto L_0x00a0
            int r0 = r5.mimeType     // Catch:{ all -> 0x00a5 }
            r1 = 102(0x66, float:1.43E-43)
            if (r0 != r1) goto L_0x00a0
            com.hpplay.sdk.source.bean.DramaInfoBean[] r0 = r5.urls     // Catch:{ all -> 0x00a5 }
            if (r0 != 0) goto L_0x00a0
            com.hpplay.sdk.source.da.e r0 = com.hpplay.sdk.source.da.e.d()     // Catch:{ all -> 0x00a5 }
            com.hpplay.sdk.source.business.BusinessEntity$1 r1 = new com.hpplay.sdk.source.business.BusinessEntity$1     // Catch:{ all -> 0x00a5 }
            r1.<init>(r4, r5)     // Catch:{ all -> 0x00a5 }
            r0.a((com.hpplay.sdk.source.bean.OutParameter) r5, (com.hpplay.sdk.source.da.m) r1)     // Catch:{ all -> 0x00a5 }
            goto L_0x00a3
        L_0x00a0:
            r3.dispatchPlay(r4, r5)     // Catch:{ all -> 0x00a5 }
        L_0x00a3:
            monitor-exit(r3)
            return
        L_0x00a5:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.business.BusinessEntity.dispatch(android.content.Context, com.hpplay.sdk.source.bean.OutParameter):void");
    }

    public void stop(int i10, LelinkServiceInfo lelinkServiceInfo) {
        if (lelinkServiceInfo != null) {
            try {
                Iterator<PlayController> it = this.mControllers.iterator();
                while (it.hasNext()) {
                    try {
                        PlayController next = it.next();
                        if (lelinkServiceInfo.equals(next.getPlayInfo().serviceInfo)) {
                            next.stop(i10);
                            it.remove();
                        }
                    } catch (Exception e10) {
                        SourceLog.w(TAG, (Throwable) e10);
                    }
                }
            } catch (Exception e11) {
                SourceLog.w(TAG, (Throwable) e11);
            }
        }
    }
}
