package com.hpplay.sdk.source.protocol;

import android.app.Activity;
import android.app.Notification;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.hardware.display.VirtualDisplay;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.google.common.base.Ascii;
import com.hpplay.common.utils.ScreenUtil;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.screencupture.IScreenCapture;
import com.hpplay.component.common.screencupture.IScreenCaptureCallbackListener;
import com.hpplay.component.common.utils.ModuleIds;
import com.hpplay.component.modulelinker.api.ModuleLinker;
import com.hpplay.component.screencapture.view.SecondMirrorView;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.bean.WatermarkBean;
import com.hpplay.sdk.source.browse.api.OptionCentral;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.store.Preference;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.Adapter;
import com.hpplay.sdk.source.utils.BitmapUtils;
import com.hpplay.sdk.source.utils.CastUtil;
import com.hpplay.sdk.source.utils.Feature;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.nio.ByteBuffer;

public class CaptureBridge {
    private static final int BITRATE_DEFAULT = 4194304;
    private static final int BITRATE_HIGH = 7340032;
    private static final int BITRATE_LOW = 1048576;
    private static final String TAG = "CaptureBridge";
    public static CaptureBridge mCaptureController;
    private boolean isAdjust;
    /* access modifiers changed from: private */
    public boolean isFirstVideoFrame = true;
    private boolean isInitialize;
    private boolean isReuseDisplay = true;
    /* access modifiers changed from: private */
    public boolean isSupportCloudMultiCast = false;
    /* access modifiers changed from: private */
    public SparseArray<AbsBridge> mAbsBridges = new SparseArray<>();
    private int mBitRate = Integer.MAX_VALUE;
    /* access modifiers changed from: private */
    public ICaptureDispatcher mCaptureDispatcher;
    private IScreenCaptureCallbackListener mCaptureListener = new IScreenCaptureCallbackListener() {
        private boolean needInsertAudio() {
            int audioSwitch = CaptureBridge.this.getAudioSwitch();
            if (CaptureBridge.this.mPlayInfo == null || CaptureBridge.this.mPlayInfo.serviceInfo == null || !CastUtil.isSupportLelinkV2(CaptureBridge.this.mPlayInfo.serviceInfo)) {
                return false;
            }
            if (audioSwitch == 0 || audioSwitch == 1) {
                return true;
            }
            return false;
        }

        public int getFrameType(byte[] bArr) {
            char c10;
            if (bArr[2] == 1) {
                c10 = 3;
            } else {
                c10 = 4;
            }
            return bArr[c10] & Ascii.US;
        }

        public void onAudioDataCallback(byte[] bArr, int i10, int i11, int i12) {
            try {
                if (CaptureBridge.this.mCaptureDispatcher != null) {
                    CaptureBridge.this.mCaptureDispatcher.onAudioDataCallback(bArr, i10, i11, i12);
                    return;
                }
                int size = CaptureBridge.this.mAbsBridges.size();
                if (CaptureBridge.this.isSupportCloudMultiCast) {
                    size = 1;
                }
                for (int i13 = 0; i13 < size; i13++) {
                    ((AbsBridge) CaptureBridge.this.mAbsBridges.valueAt(i13)).sendAudioData(bArr, i10, i11);
                }
            } catch (Exception e10) {
                SourceLog.w(CaptureBridge.TAG, (Throwable) e10);
            }
        }

        public void onInfo(int i10, String str) {
            if (CaptureBridge.this.mCaptureDispatcher != null) {
                CaptureBridge.this.mCaptureDispatcher.onCaptureInfo(i10, str);
                return;
            }
            for (int i11 = 0; i11 < CaptureBridge.this.mAbsBridges.size(); i11++) {
                ((AbsBridge) CaptureBridge.this.mAbsBridges.valueAt(i11)).onInfo(i10, str);
            }
        }

        public void onScreenshot(int i10) {
            if (CaptureBridge.this.mCaptureDispatcher != null) {
                CaptureBridge.this.mCaptureDispatcher.onCaptureScreenshot(i10);
                return;
            }
            for (int i11 = 0; i11 < CaptureBridge.this.mAbsBridges.size(); i11++) {
                ((AbsBridge) CaptureBridge.this.mAbsBridges.valueAt(i11)).screenshot(i10);
            }
        }

        public void onStart(int i10) {
            SourceLog.i(CaptureBridge.TAG, "onStart capture " + i10 + " " + CaptureBridge.this.mPlayInfo.secondMirrorView);
            Preference.getInstance().get(Preference.KEY_MIRROR_SECRET_SWITCH, false);
            if (CaptureBridge.this.mPlayInfo.secondMirrorView != null) {
                CaptureBridge.this.mPlayInfo.secondMirrorView.post(new Runnable() {
                    public void run() {
                        CaptureBridge.this.mScreenCapture.setSecondMirrorView(CaptureBridge.this.mPlayInfo.secondMirrorView);
                    }
                });
            }
            if (CaptureBridge.this.mCaptureDispatcher != null) {
                CaptureBridge.this.mCaptureDispatcher.onCaptureStart(i10);
                return;
            }
            for (int i11 = 0; i11 < CaptureBridge.this.mAbsBridges.size(); i11++) {
                ((AbsBridge) CaptureBridge.this.mAbsBridges.valueAt(i11)).onCaptureStart(i10);
            }
        }

        public void onStop(int i10) {
            SourceLog.i(CaptureBridge.TAG, "onStop capture " + i10);
            if (CaptureBridge.this.mCaptureDispatcher != null) {
                CaptureBridge.this.mCaptureDispatcher.onCaptureStop(i10);
                return;
            }
            for (int i11 = 0; i11 < CaptureBridge.this.mAbsBridges.size(); i11++) {
                ((AbsBridge) CaptureBridge.this.mAbsBridges.valueAt(i11)).onCaptureStop(i10);
            }
        }

        public void onVideoDataCallback(ByteBuffer byteBuffer, int i10, int i11, int i12, long j10) {
            sendNoneAudioData();
            try {
                if (CaptureBridge.this.mCaptureDispatcher != null) {
                    CaptureBridge.this.mCaptureDispatcher.onVideoDataCallback(byteBuffer, i10, i11, i12, j10);
                    return;
                }
                int remaining = byteBuffer.remaining();
                byte[] bArr = new byte[remaining];
                ByteBuffer byteBuffer2 = byteBuffer;
                byteBuffer.get(bArr);
                int size = CaptureBridge.this.mAbsBridges.size();
                if (CaptureBridge.this.isSupportCloudMultiCast) {
                    size = 1;
                }
                for (int i13 = 0; i13 < size; i13++) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(remaining);
                    allocateDirect.put(bArr);
                    allocateDirect.rewind();
                    ((AbsBridge) CaptureBridge.this.mAbsBridges.valueAt(i13)).sendVideoData(allocateDirect, i10, i11, i12, j10);
                }
            } catch (Exception e10) {
                SourceLog.w(CaptureBridge.TAG, (Throwable) e10);
            }
        }

        public void sendNoneAudioData() {
            if (CaptureBridge.this.isFirstVideoFrame) {
                boolean unused = CaptureBridge.this.isFirstVideoFrame = false;
                if (needInsertAudio()) {
                    byte[] bArr = new byte[1];
                    if (CaptureBridge.this.mCaptureDispatcher != null) {
                        CaptureBridge.this.mCaptureDispatcher.onAudioDataCallback(bArr, 0, 1, 1);
                        return;
                    }
                    for (int i10 = 0; i10 < CaptureBridge.this.mAbsBridges.size(); i10++) {
                        ((AbsBridge) CaptureBridge.this.mAbsBridges.valueAt(i10)).sendAudioData(bArr, 0, 1);
                    }
                }
            }
        }
    };
    private Handler mHandler = new Handler(ModuleLinker.getInstance().getContext().getMainLooper());
    private ModuleLinker mModuleLinker;
    /* access modifiers changed from: private */
    public OutParameter mPlayInfo;
    private int mRotation;
    /* access modifiers changed from: private */
    public IScreenCapture mScreenCapture;

    public interface ICaptureDispatcher {
        void onAudioDataCallback(byte[] bArr, int i10, int i11, int i12);

        void onBroken(int i10);

        void onCaptureInfo(int i10, String str);

        void onCaptureScreenshot(int i10);

        void onCaptureStart(int i10);

        void onCaptureStop(int i10);

        boolean onNetworkPoor();

        void onSinkPrepared(int i10, AbsBridge absBridge, int i11, int i12, int i13, int i14, String str);

        void onVideoDataCallback(ByteBuffer byteBuffer, int i10, int i11, int i12, long j10);
    }

    public static synchronized CaptureBridge getInstance() {
        CaptureBridge captureBridge;
        synchronized (CaptureBridge.class) {
            if (mCaptureController == null) {
                mCaptureController = new CaptureBridge();
            }
            captureBridge = mCaptureController;
        }
        return captureBridge;
    }

    private int getNotificationType() {
        int i10 = Preference.getInstance().get(Constant.KEY_MIRROR_NOTIFY_TYPE, -1);
        if (i10 >= 0) {
            return i10;
        }
        return Preference.getInstance().get(Constant.KEY_MIRROR_NOTIFICATION, true) ^ true ? 1 : 0;
    }

    private boolean isExternalAudioSource() {
        return OptionCentral.isEnableExternalAudio();
    }

    private void setInitBitRate() {
        int i10 = this.mPlayInfo.mirrorBitRateLevel;
        if (i10 == 4) {
            this.mScreenCapture.setBitRate(Adapter.adjustBitRate(BITRATE_HIGH));
        } else if (i10 != 6) {
            this.mScreenCapture.setBitRate(Adapter.adjustBitRate(4194304));
        } else {
            this.mScreenCapture.setBitRate(Adapter.adjustBitRate(1048576));
        }
    }

    private void setInitResolution(int i10, int i11) {
        if (OptionCentral.getResolution()[0] <= 0 || OptionCentral.getResolution()[1] <= 0) {
            this.mScreenCapture.setResolution(i10, i11, false);
        } else {
            this.mScreenCapture.setResolution(OptionCentral.getResolution()[0], OptionCentral.getResolution()[1], true);
        }
    }

    private void setWatermarkInfo() {
        boolean z10 = Preference.getInstance().get(Preference.KEY_MIRROR_WATERMARK_SWITCH, false);
        setWatermarkVisible(z10);
        if (z10) {
            Bitmap bitmap = null;
            String str = Preference.getInstance().get(Preference.KEY_MIRROR_WATERMARK_OBJ_JSON_STR, (String) null);
            SourceLog.i(TAG, "setWatermarkInfo watermarkInfoStr:" + str);
            if (TextUtils.isEmpty(str)) {
                SourceLog.w(TAG, "setWatermarkInfo is null return");
                return;
            }
            WatermarkBean formJson = WatermarkBean.formJson(str);
            float f10 = formJson.xPositionRatio;
            float f11 = formJson.yPositionRatio;
            String str2 = formJson.sourcePath;
            int i10 = formJson.sourceId;
            SourceLog.i(TAG, "setWatermarkInfo xPositionRatio:" + f10 + ", yPositionRatio:" + f11 + ", sourceId:" + i10 + ", path:" + str2);
            Rect rect = new Rect();
            if (!TextUtils.isEmpty(str2)) {
                bitmap = BitmapUtils.getBitmapByPath(ModuleLinker.getInstance().getContext(), rect, str2);
            }
            Bitmap bitmapById = (bitmap != null || i10 <= 0) ? bitmap : BitmapUtils.getBitmapById(ModuleLinker.getInstance().getContext(), rect, i10);
            if (bitmapById == null) {
                SourceLog.w(TAG, "setWatermarkInfo can not get the bitmap");
            }
            if (f10 < 0.0f || f11 < 0.0f) {
                f10 = 0.0f;
                f11 = 0.0f;
            }
            setWatermarkInfo(bitmapById, rect, f10 < 0.0f ? 0.0f : f10, f11 < 0.0f ? 0.0f : f11, 0);
        }
    }

    @Deprecated
    public void configCapture(OutParameter outParameter, int i10, int i11, int i12, int i13, String str) {
        int i14;
        if (this.mScreenCapture == null) {
            SourceLog.i(TAG, "configCapture ignore");
            return;
        }
        SourceLog.i(TAG, "configCapture");
        this.mPlayInfo = outParameter;
        if (outParameter.isExpandMirror) {
            this.mScreenCapture.setExpansionScreenInfo(outParameter.expandActivity, outParameter.expandView);
        } else {
            this.mScreenCapture.setExpansionScreenInfo((Activity) null, (View) null);
        }
        this.mScreenCapture.setResolution(i10, i11, false);
        this.mScreenCapture.setFullScreenMode(CastUtil.isFullScreen(outParameter.fullScreenType, outParameter.currentBrowserInfo));
        if (isExternalAudioSource()) {
            i14 = 1;
        } else {
            i14 = getInstance().getAudioCaptureType(this.mPlayInfo);
        }
        setAudioSwitch(i14, i13, this.mPlayInfo.requestAudioFocus, false);
        this.mScreenCapture.setFrameRate(Adapter.adjustFrame(i12));
        int i15 = this.mPlayInfo.mirrorBitRateLevel;
        if (i15 == 4) {
            this.mScreenCapture.setBitRate(Adapter.adjustBitRate(BITRATE_HIGH));
        } else if (i15 != 6) {
            this.mScreenCapture.setBitRate(Adapter.adjustBitRate(4194304));
        } else {
            this.mScreenCapture.setBitRate(Adapter.adjustBitRate(1048576));
        }
        SourceLog.w(TAG, "startScreenCapture expand:" + outParameter.isExpandMirror + " audio:" + i14 + " ");
        this.mScreenCapture.setVideoEncodeType(str);
        this.mScreenCapture.startCapture(outParameter.mirrorIntent);
    }

    public int getAudioCaptureType(OutParameter outParameter) {
        int i10 = outParameter.mirrorAudioType;
        if (i10 == 0) {
            return 0;
        }
        int i11 = 3;
        if (i10 != 2) {
            if (i10 != 3) {
                i11 = 4;
                if (i10 != 4) {
                    return 2;
                }
            }
            return i11;
        } else if (Build.VERSION.SDK_INT >= 29) {
            return 3;
        }
        return 2;
    }

    public int getAudioSwitch() {
        int i10;
        if (isExternalAudioSource()) {
            i10 = 1;
        } else {
            i10 = getInstance().getAudioCaptureType(this.mPlayInfo);
        }
        SourceLog.i(TAG, "getAudioSwitch " + i10);
        return i10;
    }

    public int getBitrate() {
        return this.mBitRate;
    }

    public IScreenCapture getScreenCapture() {
        return this.mScreenCapture;
    }

    public VirtualDisplay getVirtualDisplay() {
        IScreenCapture iScreenCapture = this.mScreenCapture;
        if (iScreenCapture != null) {
            return iScreenCapture.getVirtualDisplay();
        }
        return null;
    }

    public synchronized void init() {
        try {
            if (!this.isInitialize) {
                this.mAbsBridges.clear();
                ModuleLinker instance = ModuleLinker.getInstance();
                this.mModuleLinker = instance;
                IScreenCapture iScreenCapture = (IScreenCapture) instance.loadModule(ModuleIds.CLAZZ_ID897_SCREENCAPTUREIMPL);
                this.mScreenCapture = iScreenCapture;
                iScreenCapture.setFrameCallbackListener(this.mCaptureListener);
                this.isInitialize = true;
                this.isSupportCloudMultiCast = CastUtil.isSupportCloudMultiCast();
                SourceLog.i(TAG, " CaptureBridge init ");
            } else {
                return;
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    public boolean isGroupMirror() {
        if (this.mCaptureDispatcher != null) {
            return true;
        }
        return false;
    }

    public boolean isRunning() {
        IScreenCapture iScreenCapture = this.mScreenCapture;
        if (iScreenCapture == null) {
            return false;
        }
        return iScreenCapture.isRunning();
    }

    public void onBroken(int i10) {
        boolean z10;
        StringBuilder sb = new StringBuilder();
        sb.append("onBroken ");
        if (this.mCaptureDispatcher == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        sb.append(z10);
        SourceLog.i(TAG, sb.toString());
        ICaptureDispatcher iCaptureDispatcher = this.mCaptureDispatcher;
        if (iCaptureDispatcher != null) {
            iCaptureDispatcher.onBroken(i10);
            return;
        }
        SourceLog.i(TAG, "onBroken call stopCapture");
        IScreenCapture iScreenCapture = this.mScreenCapture;
        if (iScreenCapture != null) {
            iScreenCapture.stopCapture();
        }
    }

    public void onError(int i10, int i11) {
        SourceLog.w(TAG, "Mirror onError " + i10 + " errorCode " + i11);
    }

    public boolean onNetworkPoor() {
        SourceLog.i(TAG, "onNetworkPoor");
        ICaptureDispatcher iCaptureDispatcher = this.mCaptureDispatcher;
        if (iCaptureDispatcher == null) {
            return false;
        }
        iCaptureDispatcher.onNetworkPoor();
        return true;
    }

    public void onSinkPrepared(int i10, AbsBridge absBridge, int i11, int i12, int i13, int i14, String str) {
        int i15;
        AbsBridge absBridge2 = absBridge;
        StringBuilder sb = new StringBuilder();
        sb.append("onSinkPrepared Mirror sinkWidth:");
        int i16 = i11;
        sb.append(i11);
        sb.append("  sinkHeight:");
        sb.append(i12);
        sb.append("  sinkFrameRate:");
        sb.append(i13);
        SourceLog.i(TAG, sb.toString());
        ICaptureDispatcher iCaptureDispatcher = this.mCaptureDispatcher;
        if (iCaptureDispatcher != null) {
            iCaptureDispatcher.onSinkPrepared(i10, absBridge, i11, i12, i13, i14, str);
            return;
        }
        setAbsBridges(absBridge.hashCode(), absBridge);
        if (!(absBridge2 instanceof YimBridge) || this.mAbsBridges.size() <= 1) {
            i15 = 0;
        } else {
            i15 = 300;
        }
        this.mHandler.removeCallbacksAndMessages((Object) null);
        final int i17 = i10;
        final int i18 = i11;
        final int i19 = i12;
        final int i20 = i13;
        final int i21 = i14;
        final String str2 = str;
        this.mHandler.postDelayed(new Runnable() {
            public void run() {
                CaptureBridge.this.startScreenCapture(i17, i18, i19, i20, i21, str2);
            }
        }, (long) i15);
    }

    public void pauseEncode(boolean z10) {
        if (this.mScreenCapture == null) {
            SourceLog.i(TAG, "pauseEncode ignore");
            return;
        }
        SourceLog.i(TAG, "pauseEncode ");
        this.mScreenCapture.pauseEncoder(z10);
    }

    public synchronized void release(int i10) {
        SourceLog.i(TAG, "release " + i10);
        this.mAbsBridges.remove(i10);
        SourceLog.w(TAG, "removeAbsBridge " + i10 + " " + this.mAbsBridges.size());
        if (this.mAbsBridges.size() == 0) {
            release();
        } else {
            SourceLog.i(TAG, "release left " + this.mAbsBridges.size());
        }
    }

    public void removeAbsBridge(int i10) {
        this.mAbsBridges.remove(i10);
    }

    public void requestKeyFrame() {
        IScreenCapture iScreenCapture = this.mScreenCapture;
        if (iScreenCapture == null) {
            SourceLog.w(TAG, "requestKeyFrame ignore");
        } else if (Build.VERSION.SDK_INT >= 23) {
            iScreenCapture.requestKeyFrame();
        } else {
            iScreenCapture.resetEncoder();
        }
    }

    public synchronized void resetCaptureEncoder(int i10, int i11, int i12, int i13, int i14, String str) {
        if (!this.isInitialize) {
            SourceLog.i(TAG, "resetCaptureEncoder ignore");
        } else if (this.mScreenCapture == null) {
            SourceLog.i(TAG, " resetCaptureEncoder ignore 2");
        } else {
            SourceLog.i(TAG, " resetCaptureEncoder ");
            setInitResolution(i11, i12);
            IScreenCapture iScreenCapture = this.mScreenCapture;
            OutParameter outParameter = this.mPlayInfo;
            iScreenCapture.setFullScreenMode(CastUtil.isFullScreen(outParameter.fullScreenType, outParameter.currentBrowserInfo));
            int i15 = 1;
            if (i10 == 4) {
                this.mScreenCapture.setMirrorType(2);
                this.mScreenCapture.setFrameInterval(3000);
                this.mScreenCapture.setFrameRate(30);
            } else {
                this.mScreenCapture.setMirrorType(1);
                setInitBitRate();
            }
            IScreenCapture iScreenCapture2 = this.mScreenCapture;
            int audioSwitch = getAudioSwitch();
            if (i10 == 4) {
                i15 = 0;
            }
            iScreenCapture2.setAudioSwitch(audioSwitch, i15, this.mPlayInfo.requestAudioFocus, false);
            this.mScreenCapture.setFrameRate(Adapter.adjustFrame(i13));
            this.mScreenCapture.setVideoEncodeType(str);
            this.mScreenCapture.setBitRate(i14);
            this.mScreenCapture.resetEncoder();
        }
    }

    public void resetEncoder() {
        if (this.mScreenCapture == null) {
            SourceLog.w(TAG, "resetEncoder ignore");
            return;
        }
        SourceLog.i(TAG, "resetEncoder");
        this.mScreenCapture.resetEncoder();
    }

    public void resize(int i10) {
        this.mScreenCapture.resize(i10);
        setDisplayReuse(false);
    }

    public void resumeEncode() {
        if (this.mScreenCapture == null) {
            SourceLog.i(TAG, "resumeEncode ignore");
            return;
        }
        SourceLog.i(TAG, "resumeEncode ");
        this.mScreenCapture.resumeEncoder();
    }

    public void setAbsBridges(int i10, AbsBridge absBridge) {
        this.mAbsBridges.put(i10, absBridge);
        SourceLog.w(TAG, "setAbsBridges " + i10 + " " + this.mAbsBridges.size());
    }

    public void setAudioSwitch(int i10, int i11, boolean z10, boolean z11) {
        IScreenCapture iScreenCapture = this.mScreenCapture;
        if (iScreenCapture != null) {
            iScreenCapture.setAudioSwitch(i10, i11, z10, z11);
        }
    }

    public void setBitRate(int i10, int i11) {
        this.mBitRate = i11;
        IScreenCapture iScreenCapture = this.mScreenCapture;
        if (iScreenCapture != null) {
            iScreenCapture.setBitRate(i11);
        }
    }

    public void setDisplayReuse(boolean z10) {
        this.isReuseDisplay = z10;
        if (this.mScreenCapture == null) {
            SourceLog.w(TAG, "setDisplayReuse ignore");
            return;
        }
        SourceLog.i(TAG, "setDisplayReuse " + z10);
        this.mScreenCapture.disPlayReuse(z10);
    }

    public void setExpansionScreenInfo(Activity activity, View view) {
        IScreenCapture iScreenCapture = this.mScreenCapture;
        if (iScreenCapture != null) {
            iScreenCapture.setExpansionScreenInfo(activity, view);
        }
    }

    public void setFrameRate(int i10, int i11) {
        SourceLog.i(TAG, "setFrameRate " + i11);
        IScreenCapture iScreenCapture = this.mScreenCapture;
        if (iScreenCapture != null) {
            iScreenCapture.setFrameRate(Adapter.adjustFrame(i11));
        }
    }

    public void setICaptureDispatcher(ICaptureDispatcher iCaptureDispatcher) {
        boolean z10;
        StringBuilder sb = new StringBuilder();
        sb.append(" ++++++++++ setICaptureDispatcher : ");
        if (iCaptureDispatcher == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        sb.append(z10);
        SourceLog.i(TAG, sb.toString());
        this.mCaptureDispatcher = iCaptureDispatcher;
    }

    public void setMirrorMode(String str) {
        if (this.mScreenCapture == null) {
            SourceLog.w(TAG, "setMirrorMode ignore");
            return;
        }
        SourceLog.i(TAG, "setMirrorMode " + str);
        this.mScreenCapture.setMirrorMode(str);
    }

    public void setMirrorScreenSecret(boolean z10) {
        SourceLog.i(TAG, "setMirrorScreenSecret status:" + z10);
        if (this.mScreenCapture == null) {
            SourceLog.w(TAG, "setMirrorScreenSecret ignore");
        } else if (!z10) {
            SourceLog.i(TAG, "showMirrorScreen ");
            this.mScreenCapture.showMirrorScreen();
        } else {
            int screenWidth = ScreenUtil.getScreenWidth(ModuleLinker.getInstance().getContext());
            int screenHeight = ScreenUtil.getScreenHeight(ModuleLinker.getInstance().getContext());
            SourceLog.i(TAG, "hideMirrorScreen w:" + screenWidth + ", h:" + screenHeight);
            Bitmap nullBitmap = BitmapUtils.getNullBitmap(Math.min(screenWidth, screenHeight), Math.max(screenWidth, screenHeight));
            this.mScreenCapture.hideMirrorScreen(BitmapUtils.getNullBitmap(Math.max(screenWidth, screenHeight), Math.min(screenWidth, screenHeight)), nullBitmap);
        }
    }

    public void setPlayInfo(OutParameter outParameter) {
        this.mPlayInfo = outParameter;
    }

    public void setResolution(int i10, int i11, int i12) {
        SourceLog.i(TAG, "onResolutionCallback " + i11 + Operator.Operation.DIVISION + i12);
        IScreenCapture iScreenCapture = this.mScreenCapture;
        if (iScreenCapture != null) {
            iScreenCapture.setResolution(i11, i12, false);
        }
    }

    public void setRotation(int i10, boolean z10) {
        this.mRotation = i10;
        this.isAdjust = z10;
        IScreenCapture iScreenCapture = this.mScreenCapture;
        if (iScreenCapture != null) {
            iScreenCapture.setRotation(i10, z10);
        }
    }

    public void setSampleRate(int i10) {
        IScreenCapture iScreenCapture = this.mScreenCapture;
        if (iScreenCapture != null) {
            iScreenCapture.setSampleRate(i10);
        }
    }

    public void setSecondMirrorView(SecondMirrorView secondMirrorView) {
        if (this.mScreenCapture != null) {
            SourceLog.w(TAG, "setSecondMirrorView " + secondMirrorView);
            this.mScreenCapture.setSecondMirrorView(secondMirrorView);
        }
    }

    public void setWatermarkVisible(boolean z10) {
        SourceLog.i(TAG, "setWatermarkVisible visible:" + z10);
        IScreenCapture iScreenCapture = this.mScreenCapture;
        if (iScreenCapture != null) {
            if (z10) {
                iScreenCapture.watermarkVisible();
            } else {
                iScreenCapture.watermarkInvisible();
            }
        }
    }

    public synchronized void startScreenCapture(int i10, int i11, int i12, int i13, int i14, String str) {
        boolean z10;
        if (!this.isInitialize) {
            SourceLog.i(TAG, "startScreenCapture ignore");
            return;
        }
        IScreenCapture iScreenCapture = this.mScreenCapture;
        if (iScreenCapture == null) {
            SourceLog.i(TAG, "startScreenCapture ignore 2");
            return;
        }
        int i15 = 0;
        if (this.mPlayInfo != null) {
            if (!OptionCentral.isOptionalCapture) {
                z10 = true;
            } else {
                z10 = false;
            }
            iScreenCapture.isUseGlSurface(z10);
        }
        if (this.mScreenCapture.isRunning()) {
            SourceLog.i(TAG, "startScreenCapture ignore 3");
            this.mScreenCapture.setFrameRate(15);
            this.mScreenCapture.setBitRate(4194304);
            this.mScreenCapture.resetEncoder();
            return;
        }
        SourceLog.i(TAG, "startScreenCapture");
        this.isFirstVideoFrame = true;
        ParamsMap create = ParamsMap.create();
        try {
            int notificationType = getNotificationType();
            if (notificationType != 1) {
                if (!Preference.getInstance().get(Constant.KEY_MIRROR_NOTIFICATION, false) && !Feature.isLeboApp()) {
                    if (!Feature.isHappyTest()) {
                        SourceLog.i(TAG, "startScreenCapture disable notification");
                        create.putParam(ParamsMap.MirrorParams.KEY_USE_DEFAULT_NOTIFICATION, Boolean.valueOf(Feature.isPhone360()));
                    }
                }
                MirrorNotification mirrorNotification = new MirrorNotification();
                Notification createNotification = mirrorNotification.createNotification(ModuleLinker.getInstance().getContext(), CastUtil.getSinkName(this.mPlayInfo.serviceInfo), notificationType);
                if (createNotification != null) {
                    create.putParam("notification", createNotification);
                    create.putParam(ParamsMap.MirrorParams.KEY_NOTIFICTION_CHANNEL, mirrorNotification.createNotificationChannel(ModuleLinker.getInstance().getContext()));
                    if (Feature.isZTEChannel()) {
                        create.putParam(ParamsMap.MirrorParams.KEY_PID, 110);
                    } else {
                        int i16 = OptionCentral.NOTIFICATION_PID;
                        if (i16 > 0) {
                            create.putParam(ParamsMap.MirrorParams.KEY_PID, Integer.valueOf(i16));
                        }
                    }
                }
                SourceLog.i(TAG, "external pid : " + OptionCentral.NOTIFICATION_PID);
                create.putParam(ParamsMap.MirrorParams.KEY_USE_DEFAULT_NOTIFICATION, Boolean.TRUE);
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
        if (Feature.isPico()) {
            create.putParam(ParamsMap.MirrorParams.KEY_ROTATION_MONITOR, Boolean.FALSE);
        }
        create.putParam("optBitrate", Boolean.valueOf(OptionCentral.isOptBitrate));
        if (!TextUtils.isEmpty(OptionCentral.disPlayName)) {
            create.putParam("displayName", OptionCentral.disPlayName);
        }
        SourceLog.i(TAG, "+++++++++++++++++" + OptionCentral.isOptBitrate + "  " + OptionCentral.disPlayName);
        create.putBoolean(ParamsMap.MirrorParams.KEY_EXTERNAL_VIDEO, OptionCentral.isExternalVideo());
        this.mScreenCapture.init(ModuleLinker.getInstance().getContext(), create);
        OutParameter outParameter = this.mPlayInfo;
        if (outParameter.isExpandMirror) {
            this.mScreenCapture.setExpansionScreenInfo(outParameter.expandActivity, outParameter.expandView);
        }
        setInitResolution(i11, i12);
        IScreenCapture iScreenCapture2 = this.mScreenCapture;
        OutParameter outParameter2 = this.mPlayInfo;
        iScreenCapture2.setFullScreenMode(CastUtil.isFullScreen(outParameter2.fullScreenType, outParameter2.currentBrowserInfo));
        int audioSwitch = getAudioSwitch();
        IScreenCapture iScreenCapture3 = this.mScreenCapture;
        if (i10 != 4) {
            i15 = 1;
        }
        iScreenCapture3.setAudioSwitch(audioSwitch, i15, this.mPlayInfo.requestAudioFocus, isExternalAudioSource());
        this.mScreenCapture.setFrameRate(Adapter.adjustFrame(i13));
        this.mScreenCapture.setVideoEncodeType(str);
        setInitBitRate();
        if (i10 == 4) {
            this.mScreenCapture.setMirrorType(2);
            this.mScreenCapture.setFrameInterval(3000);
        } else {
            this.mScreenCapture.setMirrorType(1);
        }
        this.mScreenCapture.setBitRate(i14);
        SourceLog.w(TAG, "startScreenCapture expand:" + this.mPlayInfo.isExpandMirror + " audio:" + audioSwitch + " isReuseDisplay " + this.isReuseDisplay);
        setWatermarkInfo();
        if (Feature.isPico()) {
            this.mScreenCapture.setCaptureSource(3);
            this.mScreenCapture.setFrameInterval(1);
        }
        int i17 = this.mRotation;
        if (i17 > 0) {
            setRotation(i17, this.isAdjust);
        }
        this.mScreenCapture.startCapture(this.mPlayInfo.mirrorIntent);
    }

    public synchronized boolean stopCapture(int i10) {
        if (this.mScreenCapture == null) {
            SourceLog.w(TAG, "stopCapture ignore " + i10);
            return false;
        } else if (this.mAbsBridges.size() > 1) {
            SourceLog.w(TAG, "stopCapture ignore 2 " + i10);
            return false;
        } else {
            SourceLog.w(TAG, "stopCapture " + i10);
            return this.mScreenCapture.stopCapture();
        }
    }

    public void switchExpansionScreen(boolean z10) {
        if (this.mScreenCapture != null) {
            SourceLog.w(TAG, "switchExpansionScreen " + z10);
            this.mScreenCapture.switchExpansionScreen(z10);
        }
    }

    public void updateH264Data(byte[] bArr, int i10, int i11) {
        IScreenCapture iScreenCapture = this.mScreenCapture;
        if (iScreenCapture != null) {
            iScreenCapture.updateVideoData(bArr, i10, i11);
        }
    }

    public void updatePCMData(int i10, int i11, int i12, byte[] bArr, int i13, int i14) {
        IScreenCapture iScreenCapture = this.mScreenCapture;
        if (iScreenCapture != null) {
            iScreenCapture.updatePCMData(i10, i11, i12, bArr, i13, i14);
        }
    }

    public synchronized void release() {
        SourceLog.i(TAG, "release");
        this.isInitialize = false;
        this.mAbsBridges.clear();
        IScreenCapture iScreenCapture = this.mScreenCapture;
        if (iScreenCapture != null) {
            if (iScreenCapture.isRunning()) {
                this.mScreenCapture.stopCapture();
            }
            this.mScreenCapture.setFrameCallbackListener((IScreenCaptureCallbackListener) null);
            this.mScreenCapture = null;
        }
        ModuleLinker moduleLinker = this.mModuleLinker;
        if (moduleLinker != null) {
            moduleLinker.removeObjOfMemory(ModuleIds.CLAZZ_ID897_SCREENCAPTUREIMPL);
            this.mModuleLinker = null;
        }
    }

    public void setWatermarkInfo(Bitmap bitmap, Rect rect, float f10, float f11, int i10) {
        IScreenCapture iScreenCapture = this.mScreenCapture;
        if (iScreenCapture != null) {
            iScreenCapture.setWatermarkInfo(bitmap, rect, f10, f11, 0);
        }
    }
}
