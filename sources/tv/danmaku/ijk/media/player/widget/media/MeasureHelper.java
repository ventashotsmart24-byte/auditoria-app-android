package tv.danmaku.ijk.media.player.widget.media;

import android.view.View;
import java.lang.ref.WeakReference;

public final class MeasureHelper {
    private int mCurrentAspectRatio = 0;
    private int mMeasuredHeight;
    private int mMeasuredWidth;
    private int mVideoHeight;
    private int mVideoRotationDegree;
    private int mVideoSarDen;
    private int mVideoSarNum;
    private int mVideoWidth;
    private WeakReference<View> mWeakView;

    public MeasureHelper(View view) {
        this.mWeakView = new WeakReference<>(view);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a6, code lost:
        if (r4 != false) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a9, code lost:
        if (r4 != false) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ab, code lost:
        r12 = (int) (r0 / r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00af, code lost:
        r11 = (int) (r3 * r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doMeasure(int r11, int r12) {
        /*
            r10 = this;
            int r0 = r10.mVideoRotationDegree
            r1 = 270(0x10e, float:3.78E-43)
            r2 = 90
            if (r0 == r2) goto L_0x000a
            if (r0 != r1) goto L_0x000d
        L_0x000a:
            r9 = r12
            r12 = r11
            r11 = r9
        L_0x000d:
            int r0 = r10.mVideoWidth
            int r0 = android.view.View.getDefaultSize(r0, r11)
            int r3 = r10.mVideoHeight
            int r3 = android.view.View.getDefaultSize(r3, r12)
            int r4 = r10.mCurrentAspectRatio
            r5 = 3
            if (r4 != r5) goto L_0x0020
            goto L_0x010f
        L_0x0020:
            int r4 = r10.mVideoWidth
            if (r4 <= 0) goto L_0x010d
            int r4 = r10.mVideoHeight
            if (r4 <= 0) goto L_0x010d
            int r0 = android.view.View.MeasureSpec.getMode(r11)
            int r11 = android.view.View.MeasureSpec.getSize(r11)
            int r3 = android.view.View.MeasureSpec.getMode(r12)
            int r12 = android.view.View.MeasureSpec.getSize(r12)
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r4) goto L_0x00b4
            if (r3 != r4) goto L_0x00b4
            float r0 = (float) r11
            float r3 = (float) r12
            float r4 = r0 / r3
            int r5 = r10.mCurrentAspectRatio
            r6 = 5
            r7 = 4
            if (r5 == r7) goto L_0x006d
            if (r5 == r6) goto L_0x005f
            int r1 = r10.mVideoWidth
            float r1 = (float) r1
            int r2 = r10.mVideoHeight
            float r2 = (float) r2
            float r1 = r1 / r2
            int r2 = r10.mVideoSarNum
            if (r2 <= 0) goto L_0x007a
            int r8 = r10.mVideoSarDen
            if (r8 <= 0) goto L_0x007a
            float r2 = (float) r2
            float r1 = r1 * r2
            float r2 = (float) r8
            float r1 = r1 / r2
            goto L_0x007a
        L_0x005f:
            int r8 = r10.mVideoRotationDegree
            if (r8 == r2) goto L_0x006a
            if (r8 != r1) goto L_0x0066
            goto L_0x006a
        L_0x0066:
            r1 = 1068149419(0x3faaaaab, float:1.3333334)
            goto L_0x007a
        L_0x006a:
            r1 = 1061158912(0x3f400000, float:0.75)
            goto L_0x007a
        L_0x006d:
            int r8 = r10.mVideoRotationDegree
            if (r8 == r2) goto L_0x0078
            if (r8 != r1) goto L_0x0074
            goto L_0x0078
        L_0x0074:
            r1 = 1071877689(0x3fe38e39, float:1.7777778)
            goto L_0x007a
        L_0x0078:
            r1 = 1058013184(0x3f100000, float:0.5625)
        L_0x007a:
            r2 = 1
            int r4 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x0081
            r4 = 1
            goto L_0x0082
        L_0x0081:
            r4 = 0
        L_0x0082:
            if (r5 == 0) goto L_0x00a9
            if (r5 == r2) goto L_0x00a6
            if (r5 == r7) goto L_0x00a9
            if (r5 == r6) goto L_0x00a9
            if (r4 == 0) goto L_0x0097
            int r12 = r10.mVideoWidth
            int r11 = java.lang.Math.min(r12, r11)
            float r12 = (float) r11
            float r12 = r12 / r1
            int r12 = (int) r12
            goto L_0x010f
        L_0x0097:
            int r11 = r10.mVideoHeight
            int r11 = java.lang.Math.min(r11, r12)
            float r12 = (float) r11
            float r12 = r12 * r1
            int r12 = (int) r12
            r9 = r12
            r12 = r11
            r11 = r9
            goto L_0x010f
        L_0x00a6:
            if (r4 == 0) goto L_0x00ab
            goto L_0x00af
        L_0x00a9:
            if (r4 == 0) goto L_0x00af
        L_0x00ab:
            float r0 = r0 / r1
            int r12 = (int) r0
            goto L_0x010f
        L_0x00af:
            float r3 = r3 * r1
            int r11 = (int) r3
            goto L_0x010f
        L_0x00b4:
            r1 = 1073741824(0x40000000, float:2.0)
            if (r0 != r1) goto L_0x00d4
            if (r3 != r1) goto L_0x00d4
            int r0 = r10.mVideoWidth
            int r1 = r0 * r12
            int r2 = r10.mVideoHeight
            int r3 = r11 * r2
            if (r1 >= r3) goto L_0x00c9
            int r0 = r0 * r12
            int r11 = r0 / r2
            goto L_0x010f
        L_0x00c9:
            int r1 = r0 * r12
            int r3 = r11 * r2
            if (r1 <= r3) goto L_0x010f
            int r2 = r2 * r11
            int r12 = r2 / r0
            goto L_0x010f
        L_0x00d4:
            if (r0 != r1) goto L_0x00e4
            int r0 = r10.mVideoHeight
            int r0 = r0 * r11
            int r1 = r10.mVideoWidth
            int r0 = r0 / r1
            if (r3 != r4) goto L_0x00e2
            if (r0 <= r12) goto L_0x00e2
            goto L_0x010f
        L_0x00e2:
            r12 = r0
            goto L_0x010f
        L_0x00e4:
            if (r3 != r1) goto L_0x00f4
            int r1 = r10.mVideoWidth
            int r1 = r1 * r12
            int r2 = r10.mVideoHeight
            int r1 = r1 / r2
            if (r0 != r4) goto L_0x00f2
            if (r1 <= r11) goto L_0x00f2
            goto L_0x010f
        L_0x00f2:
            r11 = r1
            goto L_0x010f
        L_0x00f4:
            int r1 = r10.mVideoWidth
            int r2 = r10.mVideoHeight
            if (r3 != r4) goto L_0x0100
            if (r2 <= r12) goto L_0x0100
            int r3 = r12 * r1
            int r3 = r3 / r2
            goto L_0x0102
        L_0x0100:
            r3 = r1
            r12 = r2
        L_0x0102:
            if (r0 != r4) goto L_0x010b
            if (r3 <= r11) goto L_0x010b
            int r2 = r2 * r11
            int r12 = r2 / r1
            goto L_0x010f
        L_0x010b:
            r11 = r3
            goto L_0x010f
        L_0x010d:
            r11 = r0
            r12 = r3
        L_0x010f:
            r10.mMeasuredWidth = r11
            r10.mMeasuredHeight = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tv.danmaku.ijk.media.player.widget.media.MeasureHelper.doMeasure(int, int):void");
    }

    public int getMeasuredHeight() {
        return this.mMeasuredHeight;
    }

    public int getMeasuredWidth() {
        return this.mMeasuredWidth;
    }

    public View getView() {
        WeakReference<View> weakReference = this.mWeakView;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void setAspectRatio(int i10) {
        this.mCurrentAspectRatio = i10;
    }

    public void setVideoRotation(int i10) {
        this.mVideoRotationDegree = i10;
    }

    public void setVideoSampleAspectRatio(int i10, int i11) {
        this.mVideoSarNum = i10;
        this.mVideoSarDen = i11;
    }

    public void setVideoSize(int i10, int i11) {
        this.mVideoWidth = i10;
        this.mVideoHeight = i11;
    }
}
