package com.hpplay.sdk.source.pass.sinktouch;

import android.graphics.PointF;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.hpplay.common.utils.ScreenUtil;
import com.hpplay.sdk.source.bean.SinkTouchEvent;
import com.hpplay.sdk.source.bean.SinkTouchEventArea;
import com.hpplay.sdk.source.bean.SinkTouchPointerInfo;
import com.hpplay.sdk.source.utils.AppContextUtils;
import com.umeng.analytics.pro.q;
import java.util.HashMap;
import java.util.Map;

class SinkTouchEventTransformer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "SinkTouchEventTransform";
    private static boolean hasDownEvent = false;
    private static long sDownTime;
    private static final Map<Integer, PointF> sPrePointers = new HashMap();
    private static int scaleCount = 0;

    private static int calculateAngle(double d10, double d11, double d12, double d13) {
        double d14 = d12 - d10;
        double d15 = d13 - d11;
        if (d14 == 0.0d) {
            if (d15 > 0.0d) {
                return 90;
            }
            return 270;
        } else if (d15 != 0.0d) {
            int atan = (int) ((Math.atan(d15 / d14) * 180.0d) / 3.141592653589793d);
            if (d14 > 0.0d && d15 > 0.0d) {
                return atan;
            }
            if (d14 < 0.0d && d15 > 0.0d) {
                return atan + 180;
            }
            if (d14 < 0.0d && d15 < 0.0d) {
                return atan + 180;
            }
            if (d14 <= 0.0d || d15 >= 0.0d) {
                return 0;
            }
            return atan + 360;
        } else if (d14 >= 0.0d) {
            return 0;
        } else {
            return 180;
        }
    }

    private static PointF calculateCenterXY(SinkTouchPointerInfo[] sinkTouchPointerInfoArr) {
        double d10 = 0.0d;
        double d11 = 0.0d;
        for (SinkTouchPointerInfo sinkTouchPointerInfo : sinkTouchPointerInfoArr) {
            PointF calculatePoint = calculatePoint((double) sinkTouchPointerInfo.ratioX, (double) sinkTouchPointerInfo.ratioY);
            double d12 = (double) calculatePoint.x;
            Double.isNaN(d12);
            d10 += d12;
            double d13 = (double) calculatePoint.y;
            Double.isNaN(d13);
            d11 += d13;
        }
        double length = (double) sinkTouchPointerInfoArr.length;
        Double.isNaN(length);
        double length2 = (double) sinkTouchPointerInfoArr.length;
        Double.isNaN(length2);
        return new PointF((float) (d10 / length), (float) (d11 / length2));
    }

    private static PointF calculatePoint(double d10, double d11) {
        double d12;
        double d13;
        SinkTouchEventArea touchEventArea = SinkTouchEventMonitor.getInstance().getTouchEventArea();
        if (touchEventArea == null) {
            int[] relScreenSize = ScreenUtil.getRelScreenSize(AppContextUtils.getInstance().getAppContext());
            double d14 = (double) relScreenSize[0];
            Double.isNaN(d14);
            d13 = d14 * d10;
            d12 = (double) relScreenSize[1];
            Double.isNaN(d12);
        } else {
            double d15 = (double) touchEventArea.width;
            Double.isNaN(d15);
            d13 = d15 * d10;
            d12 = (double) touchEventArea.height;
            Double.isNaN(d12);
        }
        return new PointF((float) d13, (float) (d12 * d11));
    }

    private static boolean isScaleGesture(SinkTouchPointerInfo[] sinkTouchPointerInfoArr) {
        SinkTouchPointerInfo[] sinkTouchPointerInfoArr2 = sinkTouchPointerInfoArr;
        if (sinkTouchPointerInfoArr2.length == 1) {
            return false;
        }
        int[] iArr = new int[sinkTouchPointerInfoArr2.length];
        int i10 = 0;
        int i11 = 0;
        for (SinkTouchPointerInfo sinkTouchPointerInfo : sinkTouchPointerInfoArr2) {
            PointF pointF = sPrePointers.get(Integer.valueOf(sinkTouchPointerInfo.pointerId));
            if (pointF != null) {
                PointF calculatePoint = calculatePoint((double) sinkTouchPointerInfo.ratioX, (double) sinkTouchPointerInfo.ratioY);
                iArr[i10] = calculateAngle((double) pointF.x, (double) pointF.y, (double) calculatePoint.x, (double) calculatePoint.y);
                i11++;
                i10++;
            }
        }
        int i12 = 0;
        while (i12 < i11) {
            int i13 = i12 + 1;
            for (int i14 = i13; i14 < i11; i14++) {
                int abs = Math.abs(iArr[i12] - iArr[i14]);
                if (abs > 120 && abs < 240) {
                    return true;
                }
            }
            i12 = i13;
        }
        return false;
    }

    public static void transformEvent(SinkTouchEvent sinkTouchEvent) {
        transformPointerEvent(sinkTouchEvent.pointerInfos);
    }

    private static void transformPointerEvent(SinkTouchPointerInfo[] sinkTouchPointerInfoArr) {
        PointF pointF;
        int i10;
        SinkTouchPointerInfo[] sinkTouchPointerInfoArr2 = sinkTouchPointerInfoArr;
        if (sinkTouchPointerInfoArr2.length > 0) {
            MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[sinkTouchPointerInfoArr2.length];
            MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[sinkTouchPointerInfoArr2.length];
            if (SinkTouchEventMonitor.getInstance().getTouchScaleModulus() > 1.0f && scaleCount < 2 && isScaleGesture(sinkTouchPointerInfoArr)) {
                scaleCount++;
            }
            if (scaleCount >= 2) {
                pointF = calculateCenterXY(sinkTouchPointerInfoArr);
            } else {
                pointF = null;
            }
            int i11 = sinkTouchPointerInfoArr2[0].actionType;
            int length = sinkTouchPointerInfoArr2.length;
            int i12 = 0;
            int i13 = 0;
            while (true) {
                if (i12 >= length) {
                    break;
                }
                SinkTouchPointerInfo sinkTouchPointerInfo = sinkTouchPointerInfoArr2[i12];
                PointF calculatePoint = calculatePoint((double) sinkTouchPointerInfo.ratioX, (double) sinkTouchPointerInfo.ratioY);
                MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
                if (scaleCount >= 2) {
                    float f10 = calculatePoint.x;
                    pointerCoords.x = f10 + ((f10 - pointF.x) * SinkTouchEventMonitor.getInstance().getTouchScaleModulus());
                    float f11 = calculatePoint.y;
                    pointerCoords.y = f11 + ((f11 - pointF.y) * SinkTouchEventMonitor.getInstance().getTouchScaleModulus());
                } else {
                    pointerCoords.x = calculatePoint.x;
                    pointerCoords.y = calculatePoint.y;
                }
                pointerCoordsArr[i13] = pointerCoords;
                MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
                int i14 = sinkTouchPointerInfo.pointerId;
                pointerProperties.id = i14;
                pointerProperties.toolType = 1;
                pointerPropertiesArr[i13] = pointerProperties;
                if (sinkTouchPointerInfo.actionType == 0 || !hasDownEvent) {
                    Map<Integer, PointF> map = sPrePointers;
                    map.clear();
                    scaleCount = 0;
                    sDownTime = SystemClock.uptimeMillis();
                    hasDownEvent = true;
                    map.put(Integer.valueOf(sinkTouchPointerInfo.pointerId), calculatePoint);
                    i11 = 0;
                } else {
                    sPrePointers.put(Integer.valueOf(i14), calculatePoint);
                    i13++;
                    i12++;
                }
            }
            if (i11 == 1) {
                hasDownEvent = false;
            }
            if (sinkTouchPointerInfoArr2.length > 1) {
                i10 = (65280 | i11) & ((sinkTouchPointerInfoArr2[0].activePointerId << 8) | 255);
            } else {
                i10 = i11;
            }
            SinkTouchEventDispatcher.getInstance().notifyTouchEvent(MotionEvent.obtain(sDownTime, SystemClock.uptimeMillis(), i10, sinkTouchPointerInfoArr2.length, pointerPropertiesArr, pointerCoordsArr, 0, 0, 1.0f, 1.0f, 8, 0, q.a.f14389b, 2));
        }
    }
}
