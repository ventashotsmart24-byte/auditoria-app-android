package com.mobile.brasiltv.bean;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.e0;
import com.mobile.brasiltv.view.dialog.GuideDialog;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.utils.AutoUtils;
import t9.i;

public class BaseGuideManager {
    private final String content;
    private final Context context;
    private final GuideDialog.Direction diretion;
    private GuideNextClickListener guideNextClickListener;
    private final String introVersion;
    private final boolean isFullScreen;
    private boolean isLandScreen;
    private final String key;
    private BaseGuideManager next;
    private final String okStr;
    private final View tagerView;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.mobile.brasiltv.view.dialog.GuideDialog$Direction[] r0 = com.mobile.brasiltv.view.dialog.GuideDialog.Direction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.mobile.brasiltv.view.dialog.GuideDialog$Direction r1 = com.mobile.brasiltv.view.dialog.GuideDialog.Direction.TOP_LEFT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.mobile.brasiltv.view.dialog.GuideDialog$Direction r1 = com.mobile.brasiltv.view.dialog.GuideDialog.Direction.DOWN_RIGHT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.mobile.brasiltv.view.dialog.GuideDialog$Direction r1 = com.mobile.brasiltv.view.dialog.GuideDialog.Direction.TOP_RIGHT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.mobile.brasiltv.view.dialog.GuideDialog$Direction r1 = com.mobile.brasiltv.view.dialog.GuideDialog.Direction.DOWN_LEFT     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.bean.BaseGuideManager.WhenMappings.<clinit>():void");
        }
    }

    public BaseGuideManager(Context context2, View view, String str, String str2, GuideDialog.Direction direction, String str3, boolean z10, boolean z11, String str4) {
        i.g(str2, "content");
        i.g(direction, "diretion");
        this.context = context2;
        this.tagerView = view;
        this.key = str;
        this.content = str2;
        this.diretion = direction;
        this.okStr = str3;
        this.isFullScreen = z10;
        this.isLandScreen = z11;
        this.introVersion = str4;
    }

    public final BaseGuideManager addNext(BaseGuideManager baseGuideManager) {
        i.g(baseGuideManager, "next");
        this.next = baseGuideManager;
        return baseGuideManager;
    }

    public final BaseGuideManager addNextRecursion(BaseGuideManager baseGuideManager) {
        i.g(baseGuideManager, "next");
        BaseGuideManager baseGuideManager2 = this;
        while (true) {
            BaseGuideManager baseGuideManager3 = baseGuideManager2.next;
            if (baseGuideManager3 != null) {
                i.d(baseGuideManager3);
                baseGuideManager2 = baseGuideManager3;
            } else {
                baseGuideManager2.next = baseGuideManager;
                return baseGuideManager;
            }
        }
    }

    public void alreadyShow() {
        if (this.key != null) {
            if (this.introVersion == null) {
                e0.f12514a.e(App.f6050e.a(), this.key, false);
            } else {
                e0.f12514a.d(App.f6050e.a(), this.key, this.introVersion);
            }
        }
    }

    public final BaseGuideManager findFirstShow() {
        BaseGuideManager baseGuideManager = this;
        while (baseGuideManager != null && (!baseGuideManager.isShow() || baseGuideManager.key == null || this.context == null)) {
            baseGuideManager = baseGuideManager.next;
        }
        return baseGuideManager;
    }

    public final BaseGuideManager findNextShow() {
        BaseGuideManager baseGuideManager = this.next;
        while (baseGuideManager != null && !baseGuideManager.isShow()) {
            baseGuideManager = baseGuideManager.next;
        }
        return baseGuideManager;
    }

    public final String getContent() {
        return this.content;
    }

    public final Context getContext() {
        return this.context;
    }

    public final GuideDialog.Direction getDiretion() {
        return this.diretion;
    }

    public int getGuideLayoutResId() {
        int i10 = WhenMappings.$EnumSwitchMapping$0[this.diretion.ordinal()];
        if (i10 == 1) {
            return R.layout.layout_guide_top_left;
        }
        if (i10 == 2) {
            return R.layout.layout_guide_down_right;
        }
        if (i10 == 3 || i10 != 4) {
            return R.layout.layout_guide_top_right;
        }
        return R.layout.layout_guide_down_left;
    }

    public final GuideNextClickListener getGuideNextClickListener() {
        return this.guideNextClickListener;
    }

    public final String getIntroVersion() {
        return this.introVersion;
    }

    public final String getKey() {
        return this.key;
    }

    public final BaseGuideManager getNext() {
        return this.next;
    }

    public final String getOkStr() {
        return this.okStr;
    }

    public final View getTagerView() {
        return this.tagerView;
    }

    public final boolean isFullScreen() {
        return this.isFullScreen;
    }

    public final boolean isLandScreen() {
        return this.isLandScreen;
    }

    public boolean isShow() {
        if (this.key == null) {
            return true;
        }
        if (this.introVersion == null) {
            return e0.f12514a.a(App.f6050e.a(), this.key, true);
        }
        return !i.b(e0.c(e0.f12514a, App.f6050e.a(), this.key, (String) null, 4, (Object) null), this.introVersion);
    }

    public final void setGuideNextClickListener(GuideNextClickListener guideNextClickListener2) {
        this.guideNextClickListener = guideNextClickListener2;
    }

    public final void setLandScreen(boolean z10) {
        this.isLandScreen = z10;
    }

    public final void setNext(BaseGuideManager baseGuideManager) {
        this.next = baseGuideManager;
    }

    public final void showGuide() {
        Context context2;
        if (!GuideDialog.Companion.getMIsShowing()) {
            if (!isShow() || (context2 = this.context) == null) {
                BaseGuideManager findFirstShow = findFirstShow();
                GuideNextClickListener guideNextClickListener2 = this.guideNextClickListener;
                if (!(guideNextClickListener2 == null || findFirstShow == null)) {
                    findFirstShow.guideNextClickListener = guideNextClickListener2;
                }
                if (findFirstShow != null) {
                    findFirstShow.showGuide();
                    return;
                }
                return;
            }
            i.e(context2, "null cannot be cast to non-null type android.app.Activity");
            if (!((Activity) context2).isFinishing()) {
                alreadyShow();
                showGuideInner(this.context, this.tagerView);
            }
        }
    }

    public void showGuideInner(Context context2, View view) {
        String str;
        i.g(context2, f.X);
        if (view != null) {
            GuideDialog guideDialog = new GuideDialog(context2);
            guideDialog.setTargetView(view);
            guideDialog.setDirection(this.diretion);
            guideDialog.setFullScreen(this.isFullScreen);
            guideDialog.setLandScreen(this.isLandScreen);
            guideDialog.setContentText(this.content);
            if (b0.K(this.okStr)) {
                String str2 = this.okStr;
                i.d(str2);
                guideDialog.setButtonText(str2);
            } else {
                if (findNextShow() == null) {
                    str = context2.getString(R.string.no_update_ok);
                } else {
                    str = context2.getString(R.string.next_step);
                }
                i.f(str, "if (findNextShow == null….next_step)\n            }");
                guideDialog.setButtonText(str);
            }
            guideDialog.setCustomOffset(0, AutoUtils.getPercentHeightSize(0));
            guideDialog.setCustomGuideView(getGuideLayoutResId());
            guideDialog.setOnButtonClickListener(new BaseGuideManager$showGuideInner$1(this));
            guideDialog.show();
        }
    }

    public final void showNext() {
        boolean z10;
        BaseGuideManager findNextShow = findNextShow();
        GuideNextClickListener guideNextClickListener2 = this.guideNextClickListener;
        if (guideNextClickListener2 != null) {
            String str = this.key;
            if (findNextShow == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            guideNextClickListener2.onGuideNextClick(str, z10);
        }
        GuideNextClickListener guideNextClickListener3 = this.guideNextClickListener;
        if (!(guideNextClickListener3 == null || findNextShow == null)) {
            findNextShow.guideNextClickListener = guideNextClickListener3;
        }
        if (findNextShow != null) {
            findNextShow.showGuide();
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ BaseGuideManager(android.content.Context r14, android.view.View r15, java.lang.String r16, java.lang.String r17, com.mobile.brasiltv.view.dialog.GuideDialog.Direction r18, java.lang.String r19, boolean r20, boolean r21, java.lang.String r22, int r23, t9.g r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 32
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r9 = r2
            goto L_0x000b
        L_0x0009:
            r9 = r19
        L_0x000b:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0012
            r1 = 1
            r10 = 1
            goto L_0x0014
        L_0x0012:
            r10 = r20
        L_0x0014:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x001b
            r1 = 0
            r11 = 0
            goto L_0x001d
        L_0x001b:
            r11 = r21
        L_0x001d:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0023
            r12 = r2
            goto L_0x0025
        L_0x0023:
            r12 = r22
        L_0x0025:
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.bean.BaseGuideManager.<init>(android.content.Context, android.view.View, java.lang.String, java.lang.String, com.mobile.brasiltv.view.dialog.GuideDialog$Direction, java.lang.String, boolean, boolean, java.lang.String, int, t9.g):void");
    }
}
