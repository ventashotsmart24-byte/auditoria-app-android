package com.mobile.brasiltv.view.dialog;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hpplay.component.common.ParamsMap;
import com.mobile.brasiltv.R$id;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.autolayout.config.AutoLayoutConifg;
import com.zhy.autolayout.utils.AutoUtils;
import s9.a;
import t9.g;
import t9.i;

public final class GuideDialog extends Dialog {
    public static final Companion Companion = new Companion((g) null);
    /* access modifiers changed from: private */
    public static boolean mIsShowing;
    private final String TAG = GuideDialog.class.getSimpleName();
    private String mButtonText = "";
    private String mContentText = "";
    private View mCustomGuideView;
    private int mCustomGuideViewId;
    private final int[] mCustomOffset = new int[2];
    private Direction mDirection = Direction.DOWN_RIGHT;
    private final Html.ImageGetter mImageGetter;
    private boolean mIsFullScreen;
    private boolean mIsLandScreen;
    private a mListener;
    /* access modifiers changed from: private */
    public final int[] mTargetLocation = new int[2];
    private View mTargetView;
    private View mView;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public static /* synthetic */ void getMIsShowing$annotations() {
        }

        public final boolean getMIsShowing() {
            return GuideDialog.mIsShowing;
        }

        public final void setMIsShowing(boolean z10) {
            GuideDialog.mIsShowing = z10;
        }
    }

    public enum Direction {
        DOWN_RIGHT,
        DOWN_LEFT,
        TOP_RIGHT,
        TOP_LEFT,
        RIGHT,
        LEFT
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|1|2|3|4|5|6|7|8|9|10|11|12|13|15) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.mobile.brasiltv.view.dialog.GuideDialog$Direction[] r0 = com.mobile.brasiltv.view.dialog.GuideDialog.Direction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.mobile.brasiltv.view.dialog.GuideDialog$Direction r1 = com.mobile.brasiltv.view.dialog.GuideDialog.Direction.DOWN_RIGHT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.mobile.brasiltv.view.dialog.GuideDialog$Direction r1 = com.mobile.brasiltv.view.dialog.GuideDialog.Direction.DOWN_LEFT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.mobile.brasiltv.view.dialog.GuideDialog$Direction r1 = com.mobile.brasiltv.view.dialog.GuideDialog.Direction.TOP_RIGHT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.mobile.brasiltv.view.dialog.GuideDialog$Direction r1 = com.mobile.brasiltv.view.dialog.GuideDialog.Direction.TOP_LEFT     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.mobile.brasiltv.view.dialog.GuideDialog$Direction r1 = com.mobile.brasiltv.view.dialog.GuideDialog.Direction.LEFT     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.mobile.brasiltv.view.dialog.GuideDialog$Direction r1 = com.mobile.brasiltv.view.dialog.GuideDialog.Direction.RIGHT     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.view.dialog.GuideDialog.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GuideDialog(Context context) {
        super(context, R.style.guideDialgTheme);
        i.g(context, f.X);
        this.mImageGetter = new b0(context);
    }

    private final void fullScreenImmersive(View view) {
        view.setSystemUiVisibility(5894);
    }

    /* JADX WARNING: type inference failed for: r0v4, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void getCustomViewById() {
        /*
            r6 = this;
            int r0 = r6.mCustomGuideViewId
            r1 = 0
            if (r0 <= 0) goto L_0x0011
            android.content.Context r0 = r6.getContext()
            int r2 = r6.mCustomGuideViewId
            android.view.View r0 = android.view.View.inflate(r0, r2, r1)
            r6.mCustomGuideView = r0
        L_0x0011:
            android.view.View r0 = r6.mCustomGuideView
            if (r0 == 0) goto L_0x008a
            if (r0 == 0) goto L_0x0020
            java.lang.String r2 = "mTvSure"
            android.view.View r0 = r0.findViewWithTag(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x0021
        L_0x0020:
            r0 = r1
        L_0x0021:
            android.view.View r2 = r6.mCustomGuideView
            if (r2 == 0) goto L_0x002e
            java.lang.String r3 = "mTextContent"
            android.view.View r2 = r2.findViewWithTag(r3)
            android.widget.TextView r2 = (android.widget.TextView) r2
            goto L_0x002f
        L_0x002e:
            r2 = r1
        L_0x002f:
            java.lang.String r3 = r6.mButtonText
            int r3 = r3.length()
            r4 = 1
            r5 = 0
            if (r3 <= 0) goto L_0x003b
            r3 = 1
            goto L_0x003c
        L_0x003b:
            r3 = 0
        L_0x003c:
            if (r3 == 0) goto L_0x0046
            if (r0 != 0) goto L_0x0041
            goto L_0x0046
        L_0x0041:
            java.lang.String r3 = r6.mButtonText
            r0.setText(r3)
        L_0x0046:
            java.lang.String r3 = r6.mContentText
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x004f
            goto L_0x0050
        L_0x004f:
            r4 = 0
        L_0x0050:
            if (r4 == 0) goto L_0x005a
            if (r2 != 0) goto L_0x0055
            goto L_0x005a
        L_0x0055:
            java.lang.String r3 = r6.mContentText
            r2.setText(r3)
        L_0x005a:
            if (r0 == 0) goto L_0x0064
            com.mobile.brasiltv.view.dialog.d0 r3 = new com.mobile.brasiltv.view.dialog.d0
            r3.<init>(r6)
            r0.setOnClickListener(r3)
        L_0x0064:
            if (r2 != 0) goto L_0x0067
            goto L_0x0078
        L_0x0067:
            java.lang.CharSequence r0 = r2.getText()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            android.text.Html$ImageGetter r3 = r6.mImageGetter
            android.text.Spanned r0 = android.text.Html.fromHtml(r0, r3, r1)
            r2.setText(r0)
        L_0x0078:
            android.view.View r0 = r6.mCustomGuideView
            if (r0 == 0) goto L_0x0085
            java.lang.String r1 = "mThumbnailArrow"
            android.view.View r0 = r0.findViewWithTag(r1)
            r1 = r0
            android.widget.ImageView r1 = (android.widget.ImageView) r1
        L_0x0085:
            if (r1 == 0) goto L_0x008a
            r6.initThumbnailArrow(r1)
        L_0x008a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.view.dialog.GuideDialog.getCustomViewById():void");
    }

    /* access modifiers changed from: private */
    public static final void getCustomViewById$lambda$3(GuideDialog guideDialog, View view) {
        i.g(guideDialog, "this$0");
        guideDialog.dismiss();
    }

    public static final boolean getMIsShowing() {
        return Companion.getMIsShowing();
    }

    /* access modifiers changed from: private */
    public final void handlerLocation(View view) {
        if (this.mIsFullScreen && !this.mIsLandScreen) {
            int a10 = n5.a.f8310a.a(getContext());
            int[] iArr = this.mTargetLocation;
            iArr[1] = iArr[1] - a10;
        }
        View view2 = this.mTargetView;
        if (view2 != null) {
            view2.setDrawingCacheEnabled(true);
        }
        Bitmap drawingCache = view.getDrawingCache();
        int i10 = R$id.mImgTarget;
        ((ImageView) findViewById(i10)).setImageBitmap(drawingCache);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(view.getWidth(), view.getHeight());
        int[] iArr2 = this.mTargetLocation;
        layoutParams.leftMargin = iArr2[0];
        layoutParams.topMargin = iArr2[1];
        ((ImageView) findViewById(i10)).setLayoutParams(layoutParams);
        initCustomView();
    }

    private final void initCustomView() {
        getCustomViewById();
        View view = this.mCustomGuideView;
        if (view != null) {
            ((AutoRelativeLayout) findViewById(R$id.mLayoutRoot)).addView(view);
            int screenWidth = AutoLayoutConifg.getInstance().getScreenWidth();
            View.MeasureSpec.makeMeasureSpec(screenWidth, Integer.MIN_VALUE);
            view.measure(screenWidth, -1);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            switch (WhenMappings.$EnumSwitchMapping$0[this.mDirection.ordinal()]) {
                case 1:
                    int measuredHeight = this.mTargetLocation[1] - view.getMeasuredHeight();
                    int[] iArr = this.mCustomOffset;
                    layoutParams.topMargin = measuredHeight + iArr[1];
                    layoutParams.rightMargin = iArr[0];
                    layoutParams.addRule(7, ((ImageView) findViewById(R$id.mImgTarget)).getId());
                    break;
                case 2:
                    int measuredHeight2 = this.mTargetLocation[1] - view.getMeasuredHeight();
                    int[] iArr2 = this.mCustomOffset;
                    layoutParams.topMargin = measuredHeight2 + iArr2[1];
                    layoutParams.leftMargin = iArr2[0];
                    layoutParams.addRule(5, ((ImageView) findViewById(R$id.mImgTarget)).getId());
                    break;
                case 3:
                    layoutParams.addRule(3, R.id.mImgTarget);
                    layoutParams.addRule(7, ((ImageView) findViewById(R$id.mImgTarget)).getId());
                    int[] iArr3 = this.mCustomOffset;
                    layoutParams.topMargin = iArr3[1];
                    layoutParams.rightMargin = iArr3[0];
                    break;
                case 4:
                    layoutParams.addRule(3, R.id.mImgTarget);
                    layoutParams.addRule(5, ((ImageView) findViewById(R$id.mImgTarget)).getId());
                    int[] iArr4 = this.mCustomOffset;
                    layoutParams.topMargin = iArr4[1];
                    layoutParams.leftMargin = iArr4[0];
                    break;
                case 5:
                    int[] iArr5 = this.mTargetLocation;
                    layoutParams.topMargin = iArr5[1];
                    layoutParams.leftMargin = (iArr5[0] - view.getMeasuredWidth()) + this.mCustomOffset[1];
                    break;
                case 6:
                    layoutParams.addRule(0, ((ImageView) findViewById(R$id.mImgTarget)).getId());
                    layoutParams.leftMargin = this.mCustomOffset[1];
                    break;
            }
            view.setLayoutParams(layoutParams);
        }
    }

    private final void initGuide() {
        initTargetView();
    }

    private final void initTargetView() {
        View view = this.mTargetView;
        if (view != null) {
            view.getLocationInWindow(this.mTargetLocation);
            int[] iArr = this.mTargetLocation;
            if ((iArr[0] == 0 && iArr[1] == 0) || view.getWidth() == 0) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(new GuideDialog$initTargetView$1$1(view, this));
            } else {
                handlerLocation(view);
            }
        }
    }

    private final void initThumbnailArrow(ImageView imageView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "translationX", new float[]{0.0f, (float) AutoUtils.getPercentHeightSize(70)});
        ofFloat.setDuration(1000);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.start();
        imageView.setOnKeyListener(new e0(ofFloat, this));
    }

    /* access modifiers changed from: private */
    public static final boolean initThumbnailArrow$lambda$5(ObjectAnimator objectAnimator, GuideDialog guideDialog, View view, int i10, KeyEvent keyEvent) {
        i.g(guideDialog, "this$0");
        if (keyEvent.getAction() == 0) {
            if (!(i10 == 4 || i10 == 66)) {
                switch (i10) {
                    case 21:
                    case 22:
                    case 23:
                        break;
                }
            }
            objectAnimator.cancel();
            guideDialog.dismiss();
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static final Drawable mImageGetter$lambda$6(Context context, String str) {
        i.g(context, "$context");
        Drawable drawable = context.getResources().getDrawable(context.getResources().getIdentifier(str, "mipmap", context.getPackageName()));
        drawable.setBounds(0, 0, AutoUtils.getPercentWidthSize(64), AutoUtils.getPercentHeightSize(36));
        return drawable;
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$0(GuideDialog guideDialog, DialogInterface dialogInterface) {
        i.g(guideDialog, "this$0");
        mIsShowing = false;
        a aVar = guideDialog.mListener;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    public static final void setMIsShowing(boolean z10) {
        Companion.setMIsShowing(z10);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_guide_base);
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
        }
        initGuide();
        setOnDismissListener(new c0(this));
    }

    public final void setButtonText(String str) {
        i.g(str, ParamsMap.MirrorParams.MIRROR_DOC_MODE);
        this.mButtonText = str;
    }

    public final void setContentText(String str) {
        i.g(str, ParamsMap.MirrorParams.MIRROR_DOC_MODE);
        this.mContentText = str;
    }

    public final void setCustomGuideView(View view) {
        i.g(view, "view");
        this.mCustomGuideView = view;
    }

    public final void setCustomOffset(int i10, int i11) {
        int[] iArr = this.mCustomOffset;
        iArr[0] = i10;
        iArr[1] = i11;
    }

    public final void setDirection(Direction direction) {
        i.g(direction, "direction");
        this.mDirection = direction;
    }

    public final void setFullScreen(boolean z10) {
        this.mIsFullScreen = z10;
    }

    public final void setLandScreen(boolean z10) {
        this.mIsLandScreen = z10;
    }

    public final void setOnButtonClickListener(a aVar) {
        i.g(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.mListener = aVar;
    }

    public final void setTargetView(View view) {
        i.g(view, "view");
        this.mTargetView = view;
    }

    public void show() {
        View decorView;
        Window window;
        if (this.mIsLandScreen && (window = getWindow()) != null) {
            window.addFlags(8);
        }
        super.show();
        mIsShowing = true;
        if (this.mIsLandScreen) {
            Window window2 = getWindow();
            if (!(window2 == null || (decorView = window2.getDecorView()) == null)) {
                fullScreenImmersive(decorView);
            }
            Window window3 = getWindow();
            if (window3 != null) {
                window3.clearFlags(8);
            }
        }
    }

    public final void setCustomGuideView(int i10) {
        this.mCustomGuideViewId = i10;
    }
}
