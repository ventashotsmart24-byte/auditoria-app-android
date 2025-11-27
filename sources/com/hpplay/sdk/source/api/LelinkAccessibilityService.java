package com.hpplay.sdk.source.api;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.accessibilityservice.GestureDescription;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Path;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.hpplay.common.utils.ScreenUtil;
import com.hpplay.sdk.source.bean.PathEventInfo;
import com.hpplay.sdk.source.log.SourceLog;

public class LelinkAccessibilityService extends AccessibilityService {
    private static final String TAG = "LelinkAccessibilityService";
    static Handler handler = null;
    public static LelinkAccessibilityService lelinkAccessibilityService = null;
    private static volatile String mForegroundPackageName = "";
    private int mScreenHeight;
    private int mScreenWidth;

    public static boolean isForeground(Context context) {
        if (TextUtils.isEmpty(mForegroundPackageName) || context == null) {
            return false;
        }
        return mForegroundPackageName.equals(context.getApplicationContext().getPackageName());
    }

    public static boolean isServiceStart(Context context) {
        for (AccessibilityServiceInfo next : ((AccessibilityManager) context.getSystemService("accessibility")).getEnabledAccessibilityServiceList(-1)) {
            if (next.getId() != null && next.getId().contains(LelinkAccessibilityService.class.getName()) && next.getId().contains(context.getPackageName())) {
                return true;
            }
        }
        mForegroundPackageName = "";
        return false;
    }

    public static void startMove() {
        handler.sendEmptyMessageDelayed(0, 4000);
    }

    public void clickOnScreen(float f10, float f11, int i10, AccessibilityService.GestureResultCallback gestureResultCallback) {
        Path path = new Path();
        path.moveTo(f10, f11);
        gestureOnScreen(path, 0, (long) i10, gestureResultCallback);
    }

    public void gestureOnScreen(Path path, long j10, long j11, AccessibilityService.GestureResultCallback gestureResultCallback) {
        if (Build.VERSION.SDK_INT >= 24) {
            if (j11 > GestureDescription.getMaxGestureDuration()) {
                j11 = GestureDescription.getMaxGestureDuration();
            }
            long j12 = j11;
            GestureDescription.Builder builder = new GestureDescription.Builder();
            GestureDescription.Builder unused = builder.addStroke(new GestureDescription.StrokeDescription(path, j10, j12));
            boolean unused2 = dispatchGesture(builder.build(), gestureResultCallback, (Handler) null);
        }
    }

    public void moveOnScreen(PathEventInfo pathEventInfo, AccessibilityService.GestureResultCallback gestureResultCallback) {
        try {
            SourceLog.i(TAG, "moveOnScreen pathEventInfo.getStartRatioX():" + pathEventInfo.getStartRatioX() + ",pathEventInfo.getStartRatioY():" + pathEventInfo.getStartRatioY() + ",pathEventInfo.getTargetRatioX():" + pathEventInfo.getTargetRatioX() + ",pathEventInfo.getTargetRatioY():" + pathEventInfo.getTargetRatioY() + ",mScreenWidth:" + this.mScreenWidth + ",mScreenHeight:" + this.mScreenHeight);
            Path path = new Path();
            float startRatioX = pathEventInfo.getStartRatioX() * ((float) this.mScreenWidth);
            float startRatioY = pathEventInfo.getStartRatioY() * ((float) this.mScreenHeight);
            float targetRatioX = pathEventInfo.getTargetRatioX() * ((float) this.mScreenWidth);
            float targetRatioY = pathEventInfo.getTargetRatioY() * ((float) this.mScreenHeight);
            SourceLog.i(TAG, "moveOnScreen startX:" + startRatioX + "  startY:" + startRatioY + "   targetX " + targetRatioX + " targetY  " + targetRatioY);
            path.moveTo(startRatioX, startRatioY);
            path.lineTo(targetRatioX, targetRatioY);
            gestureOnScreen(path, 0, (long) pathEventInfo.getDuration(), gestureResultCallback);
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        try {
            if (lelinkAccessibilityService == null) {
                lelinkAccessibilityService = this;
            }
            if (accessibilityEvent.getEventType() == 32 && !TextUtils.isEmpty(accessibilityEvent.getPackageName())) {
                mForegroundPackageName = accessibilityEvent.getPackageName() + "";
            }
            if (this.mScreenWidth == 0) {
                this.mScreenWidth = ScreenUtil.getRelScreenSize(getApplicationContext())[0];
                this.mScreenHeight = ScreenUtil.getRelScreenSize(getApplicationContext())[1];
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        int i10;
        int i11;
        super.onConfigurationChanged(configuration);
        SourceLog.i(TAG, "onConfigurationChanged orientation:" + configuration.orientation);
        int i12 = ScreenUtil.getRelScreenSize(getApplicationContext())[0];
        int i13 = ScreenUtil.getRelScreenSize(getApplicationContext())[1];
        if (configuration.orientation == 2) {
            if (i12 > i13) {
                i11 = i12;
            } else {
                i11 = i13;
            }
            this.mScreenWidth = i11;
            if (i12 > i13) {
                i12 = i13;
            }
            this.mScreenHeight = i12;
            return;
        }
        if (i12 > i13) {
            i10 = i13;
        } else {
            i10 = i12;
        }
        this.mScreenWidth = i10;
        if (i12 <= i13) {
            i12 = i13;
        }
        this.mScreenHeight = i12;
    }

    public void onInterrupt() {
        SourceLog.i(TAG, "onInterrupt");
    }

    public void onServiceConnected() {
        super.onServiceConnected();
        SourceLog.i(TAG, "onServiceConnected: ");
    }

    public boolean onUnbind(Intent intent) {
        SourceLog.i(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }
}
