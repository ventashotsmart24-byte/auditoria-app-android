package com.mobile.brasiltv.view.adView;

import android.content.Context;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.advertlib.bean.AdInfo;
import com.advertlib.bean.AdInfoWrapper;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.view.RoundedDrawable;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import d6.b;
import java.util.LinkedHashMap;
import java.util.Map;
import n5.a;
import s1.m;
import s1.q;
import s9.l;
import t9.i;
import w6.i;

public final class BeforeVodAdView extends AutoFrameLayout {
    private final long COUNT_DOWN_TIME;
    private final String KEY_VIP_PLAY_PREFIX;
    private final int MSG_COUNT_DOWN;
    public Map<Integer, View> _$_findViewCache;
    private boolean isCr;
    /* access modifiers changed from: private */
    public AdInfoWrapper mAdInfoWrapper;
    private BeforeVodCallback mBeforeVodCallback;
    private CountDownHandler mCountDownHandler;
    /* access modifiers changed from: private */
    public long mCountDownTime;
    private int mPlayProgress;
    private int mStatusBarHeight;

    public interface BeforeVodCallback {
        void onBack();

        void onCountDownFinished();

        void onFullScreen();
    }

    public final class CountDownHandler extends Handler {
        public CountDownHandler() {
        }

        public void handleMessage(Message message) {
            i.g(message, Constant.KEY_MSG);
            super.handleMessage(message);
            BeforeVodAdView beforeVodAdView = BeforeVodAdView.this;
            beforeVodAdView.mCountDownTime = beforeVodAdView.mCountDownTime - 1;
            if (BeforeVodAdView.this.mCountDownTime == 0) {
                BeforeVodAdView.this.countDownFinished();
            } else {
                BeforeVodAdView.this.updateCountDown();
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BeforeVodAdView(Context context) {
        this(context, (AttributeSet) null);
        i.g(context, f.X);
    }

    private final void adjustFullScreenMargin(int i10, int i11) {
        int i12 = R$id.mIvFullScreen;
        ViewGroup.LayoutParams layoutParams = ((ImageView) _$_findCachedViewById(i12)).getLayoutParams();
        i.e(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.rightMargin = i10;
        layoutParams2.bottomMargin = i11;
        ((ImageView) _$_findCachedViewById(i12)).setLayoutParams(layoutParams2);
    }

    private final void clearCountDown() {
        this.mCountDownTime = 0;
        this.mCountDownHandler.removeMessages(this.MSG_COUNT_DOWN);
    }

    /* access modifiers changed from: private */
    public final void countDownFinished() {
        clearCountDown();
        releaseAd();
        BeforeVodCallback beforeVodCallback = this.mBeforeVodCallback;
        if (beforeVodCallback != null) {
            beforeVodCallback.onCountDownFinished();
        }
    }

    private final boolean handleVipPlayToday() {
        b bVar = b.f6366a;
        if (!bVar.x()) {
            return true;
        }
        String c10 = na.b.c("yyyyMMdd");
        Context context = getContext();
        if (i.b(na.f.f(context, this.KEY_VIP_PLAY_PREFIX + bVar.l(), ""), c10)) {
            return false;
        }
        Context context2 = getContext();
        na.f.k(context2, this.KEY_VIP_PLAY_PREFIX + bVar.l(), c10);
        return true;
    }

    private final void initView(Context context) {
        setBackgroundColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
        LayoutInflater.from(context).inflate(R.layout.layout_before_vod_ad, this, true);
        this.mStatusBarHeight = a.f8310a.a(context);
        int i10 = R$id.mIvBack;
        ViewGroup.LayoutParams layoutParams = ((ImageView) _$_findCachedViewById(i10)).getLayoutParams();
        i.e(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams).topMargin = this.mStatusBarHeight;
        ViewGroup.LayoutParams layoutParams2 = ((TextView) _$_findCachedViewById(R$id.mTvTitle)).getLayoutParams();
        i.e(layoutParams2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams2).topMargin = this.mStatusBarHeight;
        ViewGroup.LayoutParams layoutParams3 = ((AutoLinearLayout) _$_findCachedViewById(R$id.mAllAdFlagWrapper)).getLayoutParams();
        i.e(layoutParams3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams3).topMargin = this.mStatusBarHeight;
        ((ImageView) _$_findCachedViewById(i10)).setOnClickListener(new d(this));
        ((ImageView) _$_findCachedViewById(R$id.mIvFullScreen)).setOnClickListener(new e(this));
        ((AutoLinearLayout) _$_findCachedViewById(R$id.mAllCountDownWrap)).setOnClickListener(new f(this, context));
        ((ImageView) _$_findCachedViewById(R$id.mIvBeforeVodAd)).setOnClickListener(new g(this));
        ((AutoFrameLayout) _$_findCachedViewById(R$id.mAflVideoWrapper)).setOnClickListener(new h(this));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$0(BeforeVodAdView beforeVodAdView, View view) {
        i.g(beforeVodAdView, "this$0");
        BeforeVodCallback beforeVodCallback = beforeVodAdView.mBeforeVodCallback;
        if (beforeVodCallback != null) {
            beforeVodCallback.onBack();
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$1(BeforeVodAdView beforeVodAdView, View view) {
        i.g(beforeVodAdView, "this$0");
        BeforeVodCallback beforeVodCallback = beforeVodAdView.mBeforeVodCallback;
        if (beforeVodCallback != null) {
            beforeVodCallback.onFullScreen();
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$2(BeforeVodAdView beforeVodAdView, Context context, View view) {
        boolean z10;
        i.g(beforeVodAdView, "this$0");
        i.g(context, "$context");
        b bVar = b.f6366a;
        if (bVar.x()) {
            beforeVodAdView.countDownFinished();
        } else if (bVar.y()) {
            f1.f12517a.t(R.string.ads_bind_account);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("beVipUrl:");
            i.c cVar = w6.i.f9510g;
            sb.append(cVar.g());
            b0.U(beforeVodAdView, sb.toString());
            if (cVar.g().length() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                b0.j0(context, cVar.g(), false, true, false, false, 24, (Object) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$3(BeforeVodAdView beforeVodAdView, View view) {
        t9.i.g(beforeVodAdView, "this$0");
        beforeVodAdView.openAdLink(beforeVodAdView.isCr);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$4(BeforeVodAdView beforeVodAdView, View view) {
        t9.i.g(beforeVodAdView, "this$0");
        beforeVodAdView.openAdLink(beforeVodAdView.isCr);
    }

    private final void openAdLink(boolean z10) {
        AdInfo adInfo;
        boolean z11;
        AdInfoWrapper adInfoWrapper = this.mAdInfoWrapper;
        AdInfo adInfo2 = null;
        if (adInfoWrapper != null) {
            adInfo = adInfoWrapper.getAdInfo();
        } else {
            adInfo = null;
        }
        if (adInfo != null) {
            AdInfoWrapper adInfoWrapper2 = this.mAdInfoWrapper;
            if (adInfoWrapper2 != null) {
                adInfo2 = adInfoWrapper2.getAdInfo();
            }
            t9.i.d(adInfo2);
            String action = adInfo2.getAction();
            if (action == null || action.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11 && t9.i.b(adInfo2.getAction_type(), "1")) {
                a6.a aVar = a6.a.f10646a;
                Context context = getContext();
                t9.i.f(context, f.X);
                aVar.t(context, adInfo2.getAction(), z10);
                q qVar = q.f9311a;
                Context context2 = getContext();
                t9.i.f(context2, f.X);
                b bVar = b.f6366a;
                Context context3 = getContext();
                t9.i.f(context3, f.X);
                qVar.h(context2, bVar.m(context3), adInfo2.getMedia_type(), adInfo2);
            } else if (t9.i.b(adInfo2.getAction_type(), CdnType.DIGITAL_TYPE_PCDN)) {
                Context context4 = getContext();
                t9.i.f(context4, f.X);
                b0.m(context4);
            }
        }
    }

    public static /* synthetic */ void openAdLink$default(BeforeVodAdView beforeVodAdView, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        beforeVodAdView.openAdLink(z10);
    }

    private final void pauseVideo() {
        Object tag = ((AutoFrameLayout) _$_findCachedViewById(R$id.mAflVideoWrapper)).getTag();
        if (tag != null) {
            MediaPlayer mediaPlayer = (MediaPlayer) tag;
            this.mPlayProgress = mediaPlayer.getCurrentPosition();
            mediaPlayer.pause();
        }
    }

    private final void playVideo() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setLooping(false);
        mediaPlayer.setOnPreparedListener(new i(this, mediaPlayer));
        mediaPlayer.setOnErrorListener(new j(this));
        SurfaceView surfaceView = new SurfaceView(getContext());
        surfaceView.setZOrderOnTop(false);
        surfaceView.setKeepScreenOn(true);
        surfaceView.getHolder().addCallback(new BeforeVodAdView$playVideo$3(this, mediaPlayer));
        int i10 = R$id.mAflVideoWrapper;
        ((AutoFrameLayout) _$_findCachedViewById(i10)).addView(surfaceView, -1, -1);
        ((AutoFrameLayout) _$_findCachedViewById(i10)).setTag(mediaPlayer);
    }

    /* access modifiers changed from: private */
    public static final void playVideo$lambda$5(BeforeVodAdView beforeVodAdView, MediaPlayer mediaPlayer, MediaPlayer mediaPlayer2) {
        t9.i.g(beforeVodAdView, "this$0");
        t9.i.g(mediaPlayer, "$player");
        int i10 = beforeVodAdView.mPlayProgress;
        if (i10 != 0) {
            mediaPlayer.seekTo(i10);
        }
        mediaPlayer.start();
        beforeVodAdView.clearCountDown();
        beforeVodAdView.mCountDownTime = (long) ((mediaPlayer.getDuration() - beforeVodAdView.mPlayProgress) / 1000);
        beforeVodAdView.updateCountDown();
    }

    /* access modifiers changed from: private */
    public static final boolean playVideo$lambda$6(BeforeVodAdView beforeVodAdView, MediaPlayer mediaPlayer, int i10, int i11) {
        t9.i.g(beforeVodAdView, "this$0");
        beforeVodAdView.countDownFinished();
        return true;
    }

    private final void releaseAd() {
        setVisibility(8);
        releaseVideo();
    }

    private final void releaseVideo() {
        this.mPlayProgress = 0;
        this.mAdInfoWrapper = null;
        int i10 = R$id.mAflVideoWrapper;
        ((AutoFrameLayout) _$_findCachedViewById(i10)).removeAllViews();
        if (((AutoFrameLayout) _$_findCachedViewById(i10)).getTag() != null) {
            Object tag = ((AutoFrameLayout) _$_findCachedViewById(i10)).getTag();
            t9.i.e(tag, "null cannot be cast to non-null type android.media.MediaPlayer");
            ((MediaPlayer) tag).stop();
            Object tag2 = ((AutoFrameLayout) _$_findCachedViewById(i10)).getTag();
            t9.i.e(tag2, "null cannot be cast to non-null type android.media.MediaPlayer");
            ((MediaPlayer) tag2).release();
            ((AutoFrameLayout) _$_findCachedViewById(i10)).setTag((Object) null);
        }
    }

    private final void showUIByOrientation() {
        if (getResources().getConfiguration().orientation == 1) {
            ((ImageView) _$_findCachedViewById(R$id.mIvBack)).setVisibility(8);
            ((TextView) _$_findCachedViewById(R$id.mTvTitle)).setVisibility(8);
            ((ImageView) _$_findCachedViewById(R$id.mIvBeforeVodAd)).setScaleType(ImageView.ScaleType.FIT_XY);
            adjustFullScreenMargin(10, 0);
            return;
        }
        int i10 = R$id.mIvBack;
        ((ImageView) _$_findCachedViewById(i10)).setVisibility(0);
        int i11 = R$id.mTvTitle;
        ((TextView) _$_findCachedViewById(i11)).setVisibility(0);
        ((ImageView) _$_findCachedViewById(R$id.mIvBeforeVodAd)).setScaleType(ImageView.ScaleType.FIT_CENTER);
        adjustFullScreenMargin(20, 20);
        ViewGroup.LayoutParams layoutParams = ((ImageView) _$_findCachedViewById(i10)).getLayoutParams();
        t9.i.e(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams).topMargin = 0;
        ViewGroup.LayoutParams layoutParams2 = ((TextView) _$_findCachedViewById(i11)).getLayoutParams();
        t9.i.e(layoutParams2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams2).topMargin = 0;
        ViewGroup.LayoutParams layoutParams3 = ((AutoLinearLayout) _$_findCachedViewById(R$id.mAllAdFlagWrapper)).getLayoutParams();
        t9.i.e(layoutParams3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams3).topMargin = 0;
    }

    private final void startVideo() {
        Object tag = ((AutoFrameLayout) _$_findCachedViewById(R$id.mAflVideoWrapper)).getTag();
        if (tag != null) {
            ((MediaPlayer) tag).start();
        }
    }

    /* access modifiers changed from: private */
    public final void updateCountDown() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mCountDownTime);
        sb.append('s');
        ((TextView) _$_findCachedViewById(R$id.mTvCountDown)).setText(sb.toString());
        if (b.f6366a.x()) {
            ((TextView) _$_findCachedViewById(R$id.mTvCountDownHint)).setText(getContext().getString(R.string.ads_skip));
        } else {
            ((TextView) _$_findCachedViewById(R$id.mTvCountDownHint)).setText(String.valueOf(getContext().getString(R.string.no_ad_for_vips)));
        }
        this.mCountDownHandler.sendEmptyMessageDelayed(this.MSG_COUNT_DOWN, 1000);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i10) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public void dispatchWindowVisibilityChanged(int i10) {
        super.dispatchWindowVisibilityChanged(i10);
        if (i10 == 8) {
            pauseVideo();
            this.mCountDownHandler.removeMessages(this.MSG_COUNT_DOWN);
        } else if (this.mCountDownTime != 0) {
            startVideo();
            updateCountDown();
        }
    }

    public final void hideBeforeVodAd() {
        setVisibility(8);
        ((ImageView) _$_findCachedViewById(R$id.mIvBeforeVodAd)).setVisibility(8);
        ((AutoFrameLayout) _$_findCachedViewById(R$id.mAflVideoWrapper)).setVisibility(8);
        clearCountDown();
        releaseAd();
    }

    public final boolean isCr() {
        return this.isCr;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        showUIByOrientation();
    }

    public void onDetachedFromWindow() {
        clearCountDown();
        releaseAd();
        super.onDetachedFromWindow();
    }

    public final void setBeforeVodCallback(BeforeVodCallback beforeVodCallback) {
        t9.i.g(beforeVodCallback, "callback");
        this.mBeforeVodCallback = beforeVodCallback;
    }

    public final void setCr(boolean z10) {
        this.isCr = z10;
    }

    public final void setTitle(String str) {
        t9.i.g(str, "title");
        ((TextView) _$_findCachedViewById(R$id.mTvTitle)).setText(str);
    }

    public final void showBeforeVodAd(AdInfoWrapper adInfoWrapper, String str) {
        String str2;
        boolean z10;
        String str3;
        AdInfo adInfo;
        AdInfo adInfo2;
        AdInfoWrapper adInfoWrapper2 = adInfoWrapper;
        t9.i.g(adInfoWrapper2, "adInfoWrapper");
        t9.i.g(str, "adType");
        AdInfo adInfo3 = adInfoWrapper.getAdInfo();
        String str4 = null;
        if (adInfo3 != null) {
            str2 = adInfo3.getUrl();
        } else {
            str2 = null;
        }
        if (str2 == null || str2.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            hideBeforeVodAd();
            this.mAdInfoWrapper = adInfoWrapper2;
            AdInfo adInfo4 = adInfoWrapper.getAdInfo();
            if (adInfo4 != null) {
                str3 = adInfo4.getMedia_type();
            } else {
                str3 = null;
            }
            if (t9.i.b(str3, "picture")) {
                setVisibility(0);
                int i10 = R$id.mIvBeforeVodAd;
                ((ImageView) _$_findCachedViewById(i10)).setVisibility(0);
                showUIByOrientation();
                this.mCountDownTime = this.COUNT_DOWN_TIME;
                updateCountDown();
                m mVar = m.f9270a;
                Context context = getContext();
                t9.i.f(context, f.X);
                ImageView imageView = (ImageView) _$_findCachedViewById(i10);
                t9.i.f(imageView, "mIvBeforeVodAd");
                AdInfoWrapper adInfoWrapper3 = this.mAdInfoWrapper;
                if (adInfoWrapper3 != null) {
                    adInfo2 = adInfoWrapper3.getAdInfo();
                } else {
                    adInfo2 = null;
                }
                m.h0(mVar, context, imageView, str, adInfo2, (Integer) null, (l) null, (Integer) null, false, 0, 496, (Object) null);
                return;
            }
            AdInfoWrapper adInfoWrapper4 = this.mAdInfoWrapper;
            if (!(adInfoWrapper4 == null || (adInfo = adInfoWrapper4.getAdInfo()) == null)) {
                str4 = adInfo.getMedia_type();
            }
            if (t9.i.b(str4, "video")) {
                setVisibility(0);
                ((AutoFrameLayout) _$_findCachedViewById(R$id.mAflVideoWrapper)).setVisibility(0);
                showUIByOrientation();
                playVideo();
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BeforeVodAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        t9.i.g(context, f.X);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BeforeVodAdView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t9.i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
        this.KEY_VIP_PLAY_PREFIX = "key_vip_play_";
        this.MSG_COUNT_DOWN = 1;
        this.COUNT_DOWN_TIME = 5;
        this.mCountDownHandler = new CountDownHandler();
        initView(context);
    }
}
