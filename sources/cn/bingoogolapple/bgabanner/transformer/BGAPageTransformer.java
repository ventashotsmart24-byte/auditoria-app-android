package cn.bingoogolapple.bgabanner.transformer;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

public abstract class BGAPageTransformer implements ViewPager.k {

    /* renamed from: cn.bingoogolapple.bgabanner.transformer.BGAPageTransformer$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cn$bingoogolapple$bgabanner$transformer$TransitionEffect;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|(3:25|26|28)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                cn.bingoogolapple.bgabanner.transformer.TransitionEffect[] r0 = cn.bingoogolapple.bgabanner.transformer.TransitionEffect.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$cn$bingoogolapple$bgabanner$transformer$TransitionEffect = r0
                cn.bingoogolapple.bgabanner.transformer.TransitionEffect r1 = cn.bingoogolapple.bgabanner.transformer.TransitionEffect.Default     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$cn$bingoogolapple$bgabanner$transformer$TransitionEffect     // Catch:{ NoSuchFieldError -> 0x001d }
                cn.bingoogolapple.bgabanner.transformer.TransitionEffect r1 = cn.bingoogolapple.bgabanner.transformer.TransitionEffect.Alpha     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$cn$bingoogolapple$bgabanner$transformer$TransitionEffect     // Catch:{ NoSuchFieldError -> 0x0028 }
                cn.bingoogolapple.bgabanner.transformer.TransitionEffect r1 = cn.bingoogolapple.bgabanner.transformer.TransitionEffect.Rotate     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$cn$bingoogolapple$bgabanner$transformer$TransitionEffect     // Catch:{ NoSuchFieldError -> 0x0033 }
                cn.bingoogolapple.bgabanner.transformer.TransitionEffect r1 = cn.bingoogolapple.bgabanner.transformer.TransitionEffect.Cube     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$cn$bingoogolapple$bgabanner$transformer$TransitionEffect     // Catch:{ NoSuchFieldError -> 0x003e }
                cn.bingoogolapple.bgabanner.transformer.TransitionEffect r1 = cn.bingoogolapple.bgabanner.transformer.TransitionEffect.Flip     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$cn$bingoogolapple$bgabanner$transformer$TransitionEffect     // Catch:{ NoSuchFieldError -> 0x0049 }
                cn.bingoogolapple.bgabanner.transformer.TransitionEffect r1 = cn.bingoogolapple.bgabanner.transformer.TransitionEffect.Accordion     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$cn$bingoogolapple$bgabanner$transformer$TransitionEffect     // Catch:{ NoSuchFieldError -> 0x0054 }
                cn.bingoogolapple.bgabanner.transformer.TransitionEffect r1 = cn.bingoogolapple.bgabanner.transformer.TransitionEffect.ZoomFade     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$cn$bingoogolapple$bgabanner$transformer$TransitionEffect     // Catch:{ NoSuchFieldError -> 0x0060 }
                cn.bingoogolapple.bgabanner.transformer.TransitionEffect r1 = cn.bingoogolapple.bgabanner.transformer.TransitionEffect.Fade     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$cn$bingoogolapple$bgabanner$transformer$TransitionEffect     // Catch:{ NoSuchFieldError -> 0x006c }
                cn.bingoogolapple.bgabanner.transformer.TransitionEffect r1 = cn.bingoogolapple.bgabanner.transformer.TransitionEffect.ZoomCenter     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$cn$bingoogolapple$bgabanner$transformer$TransitionEffect     // Catch:{ NoSuchFieldError -> 0x0078 }
                cn.bingoogolapple.bgabanner.transformer.TransitionEffect r1 = cn.bingoogolapple.bgabanner.transformer.TransitionEffect.ZoomStack     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$cn$bingoogolapple$bgabanner$transformer$TransitionEffect     // Catch:{ NoSuchFieldError -> 0x0084 }
                cn.bingoogolapple.bgabanner.transformer.TransitionEffect r1 = cn.bingoogolapple.bgabanner.transformer.TransitionEffect.Stack     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$cn$bingoogolapple$bgabanner$transformer$TransitionEffect     // Catch:{ NoSuchFieldError -> 0x0090 }
                cn.bingoogolapple.bgabanner.transformer.TransitionEffect r1 = cn.bingoogolapple.bgabanner.transformer.TransitionEffect.Depth     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$cn$bingoogolapple$bgabanner$transformer$TransitionEffect     // Catch:{ NoSuchFieldError -> 0x009c }
                cn.bingoogolapple.bgabanner.transformer.TransitionEffect r1 = cn.bingoogolapple.bgabanner.transformer.TransitionEffect.Zoom     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.bingoogolapple.bgabanner.transformer.BGAPageTransformer.AnonymousClass1.<clinit>():void");
        }
    }

    public static BGAPageTransformer getPageTransformer(TransitionEffect transitionEffect) {
        switch (AnonymousClass1.$SwitchMap$cn$bingoogolapple$bgabanner$transformer$TransitionEffect[transitionEffect.ordinal()]) {
            case 1:
                return new DefaultPageTransformer();
            case 2:
                return new AlphaPageTransformer();
            case 3:
                return new RotatePageTransformer();
            case 4:
                return new CubePageTransformer();
            case 5:
                return new FlipPageTransformer();
            case 6:
                return new AccordionPageTransformer();
            case 7:
                return new ZoomFadePageTransformer();
            case 8:
                return new FadePageTransformer();
            case 9:
                return new ZoomCenterPageTransformer();
            case 10:
                return new ZoomStackPageTransformer();
            case 11:
                return new StackPageTransformer();
            case 12:
                return new DepthPageTransformer();
            case 13:
                return new ZoomPageTransformer();
            default:
                return new DefaultPageTransformer();
        }
    }

    public abstract void handleInvisiblePage(View view, float f10);

    public abstract void handleLeftPage(View view, float f10);

    public abstract void handleRightPage(View view, float f10);

    public void transformPage(View view, float f10) {
        if (f10 < -1.0f) {
            handleInvisiblePage(view, f10);
        } else if (f10 <= 0.0f) {
            handleLeftPage(view, f10);
        } else if (f10 <= 1.0f) {
            handleRightPage(view, f10);
        } else {
            handleInvisiblePage(view, f10);
        }
    }
}
