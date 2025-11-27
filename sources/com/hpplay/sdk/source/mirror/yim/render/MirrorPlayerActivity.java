package com.hpplay.sdk.source.mirror.yim.render;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hpplay.sdk.source.api.MirrorFrameCallback;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.business.cloud.SourceDataReport;
import com.hpplay.sdk.source.cloud.mirror.youme.OnCloudMirrorListener;
import com.hpplay.sdk.source.cloud.mirror.youme.YimConfigBean;
import com.hpplay.sdk.source.mirror.yim.YimMirror;
import com.hpplay.sdk.source.process.ConnectManager;
import com.hpplay.sdk.source.protocol.connect.ConnectBridge;
import com.hpplay.sdk.source.utils.CastUtil;
import com.hpplay.sdk.source.utils.CreateUtil;
import com.mobile.brasiltv.view.RoundedDrawable;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.youme.voiceengine.api;
import com.youme.voiceengine.video.EglBase;
import com.youme.voiceengine.video.RendererCommon;
import com.youme.voiceengine.video.SurfaceViewRenderer;
import tv.danmaku.ijk.media.player.IMediaPlayer;

public class MirrorPlayerActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public static final String f11852a = "session";

    /* renamed from: b  reason: collision with root package name */
    public static final String f11853b = "uri";

    /* renamed from: c  reason: collision with root package name */
    public static final String f11854c = "room_id_key";

    /* renamed from: d  reason: collision with root package name */
    public static final String f11855d = "uid_key";

    /* renamed from: e  reason: collision with root package name */
    private static final String f11856e = "MirrorPlayerActivity";
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public SurfaceViewRenderer f11857f;

    /* renamed from: g  reason: collision with root package name */
    private YimMirror f11858g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public b f11859h;

    /* renamed from: i  reason: collision with root package name */
    private String f11860i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public OutParameter f11861j;

    /* renamed from: k  reason: collision with root package name */
    private String f11862k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public RelativeLayout f11863l;

    /* renamed from: m  reason: collision with root package name */
    private RelativeLayout f11864m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public LinearLayout f11865n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public boolean f11866o = true;

    /* renamed from: p  reason: collision with root package name */
    private View.OnClickListener f11867p = new View.OnClickListener() {
        public void onClick(View view) {
            MirrorPlayerActivity.this.finish();
        }
    };

    /* renamed from: q  reason: collision with root package name */
    private MirrorFrameCallback f11868q = new MirrorFrameCallback() {
        public void onVideoFrameCallback(String str, byte[] bArr, int i10, int i11, int i12, int i13, long j10) {
            if (MirrorPlayerActivity.this.f11859h != null) {
                if (MirrorPlayerActivity.this.f11857f.getVisibility() == 4) {
                    MirrorPlayerActivity.this.runOnUiThread(new Runnable() {
                        public void run() {
                            MirrorPlayerActivity.this.f11857f.setVisibility(0);
                            MirrorPlayerActivity.this.f11863l.setBackgroundColor(0);
                        }
                    });
                }
                MirrorPlayerActivity.this.f11859h.a(str, bArr, i10, i11, i12, i13, j10);
                if (MirrorPlayerActivity.this.f11866o) {
                    boolean unused = MirrorPlayerActivity.this.f11866o = false;
                    SourceDataReport.getInstance().onStartPullYoumeStream(MirrorPlayerActivity.this.f11861j);
                }
            }
        }

        public void onVideoFrameCallbackGLES(String str, int i10, int i11, float[] fArr, int i12, int i13, long j10) {
            if (MirrorPlayerActivity.this.f11859h != null) {
                MirrorPlayerActivity.this.f11859h.a(str, i10, i11, fArr, i12, i13, j10);
            }
        }

        public void onVideoFrameMixed(byte[] bArr, int i10, int i11, int i12, int i13, long j10) {
            if (MirrorPlayerActivity.this.f11859h != null) {
                MirrorPlayerActivity.this.f11859h.a(bArr, i10, i11, i12, i13, j10);
            }
        }

        public void onVideoFrameMixedGLES(int i10, int i11, float[] fArr, int i12, int i13, long j10) {
            if (MirrorPlayerActivity.this.f11859h != null) {
                MirrorPlayerActivity.this.f11859h.a(i10, i11, fArr, i12, i13, j10);
            }
        }

        public int onVideoRenderFilterCallback(int i10, int i11, int i12, int i13, int i14) {
            return 0;
        }
    };

    /* renamed from: r  reason: collision with root package name */
    private Animator.AnimatorListener f11869r = new Animator.AnimatorListener() {
        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            if (MirrorPlayerActivity.this.f11865n != null) {
                MirrorPlayerActivity.this.f11865n.setVisibility(4);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.a((Context) this);
        ViewGroup.LayoutParams layoutParams = ((ViewGroup) findViewById(16908290)).getLayoutParams();
        RelativeLayout relativeLayout = new RelativeLayout(getApplicationContext());
        RelativeLayout relativeLayout2 = new RelativeLayout(getApplicationContext());
        this.f11864m = relativeLayout2;
        layoutParams.width = -1;
        layoutParams.height = -1;
        relativeLayout2.setBackgroundColor(-1);
        this.f11864m.setLayoutParams(layoutParams);
        relativeLayout.addView(this.f11864m);
        this.f11863l = new RelativeLayout(getApplicationContext());
        this.f11863l.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView(this.f11863l);
        setContentView(relativeLayout);
        SurfaceViewRenderer surfaceViewRenderer = new SurfaceViewRenderer(getApplicationContext());
        this.f11857f = surfaceViewRenderer;
        surfaceViewRenderer.init(EglBase.createContext(api.sharedEGLContext()), (RendererCommon.RendererEvents) null);
        this.f11857f.setScalingType(RendererCommon.ScalingType.SCALE_ASPECT_FIT);
        this.f11857f.setMirror(false);
        this.f11857f.setVisibility(4);
        this.f11864m.addView(this.f11857f, new RelativeLayout.LayoutParams(-1, -1));
        a();
    }

    public void onDestroy() {
        super.onDestroy();
        SurfaceViewRenderer surfaceViewRenderer = this.f11857f;
        if (surfaceViewRenderer != null) {
            surfaceViewRenderer.release();
        }
        YimMirror yimMirror = this.f11858g;
        if (yimMirror != null) {
            yimMirror.release();
            this.f11858g.setVideoFrameCallback((MirrorFrameCallback) null);
        }
        SourceDataReport.getInstance().onStopPullYoumeStream(this.f11861j);
    }

    public void onResume() {
        super.onResume();
        if (this.f11865n == null) {
            Drawable a10 = a.a((Context) this, "cm_bg");
            if (a10 != null) {
                this.f11864m.setBackground(a10);
            }
            b();
        } else if (!TextUtils.isEmpty(this.f11862k) && this.f11858g != null) {
            if (this.f11862k.contains(Operator.Operation.MINUS)) {
                this.f11862k = this.f11862k.replace(Operator.Operation.MINUS, "n");
            }
            this.f11858g.maskVideoByUserId(this.f11862k, false);
        }
    }

    public void onStop() {
        super.onStop();
        if (!TextUtils.isEmpty(this.f11862k) && this.f11858g != null) {
            if (this.f11862k.contains(Operator.Operation.MINUS)) {
                this.f11862k = this.f11862k.replace(Operator.Operation.MINUS, "n");
            }
            this.f11858g.maskVideoByUserId(this.f11862k, true);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return super.onTouchEvent(motionEvent);
        }
        c();
        return true;
    }

    private void b() {
        Drawable a10 = a.a((Context) this, "mirror_off");
        this.f11865n = new LinearLayout(this);
        a.a((int) RoundedDrawable.DEFAULT_BORDER_COLOR, 30);
        this.f11865n.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a.a(1080), a.a(450));
        layoutParams.addRule(12);
        layoutParams.setMargins(a.a(8), 0, a.a(8), 0);
        this.f11865n.setLayoutParams(layoutParams);
        this.f11865n.setBackground(a.a((int) RoundedDrawable.DEFAULT_BORDER_COLOR, 30));
        Button button = new Button(getApplicationContext());
        if (a10 != null) {
            button.setBackground(a10);
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a.a(180), a.a(180));
        layoutParams2.topMargin = a.b(60);
        layoutParams2.gravity = 1;
        button.setLayoutParams(layoutParams2);
        button.setOnClickListener(this.f11867p);
        this.f11865n.addView(button);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        TextView textView = new TextView(getApplicationContext());
        textView.setText("结束投屏");
        textView.setTextSize((float) a.a(12));
        textView.setTextColor(-1);
        layoutParams3.topMargin = a.a(10);
        layoutParams3.gravity = 1;
        textView.setLayoutParams(layoutParams3);
        this.f11865n.addView(textView);
        this.f11865n.setVisibility(4);
        this.f11863l.addView(this.f11865n);
    }

    private void c() {
        int a10 = a.a(450);
        LinearLayout linearLayout = this.f11865n;
        if (linearLayout == null) {
            b();
        } else if (linearLayout.getVisibility() == 0) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.f11865n, "translationY", new float[]{0.0f, (float) a10}).setDuration(300);
            duration.addListener(this.f11869r);
            duration.start();
            return;
        } else {
            this.f11865n.setVisibility(0);
        }
        ObjectAnimator.ofFloat(this.f11865n, "translationY", new float[]{(float) a10, 0.0f}).setDuration(300).start();
    }

    private void a() {
        this.f11858g = YimMirror.getInstance();
        this.f11860i = getIntent().getStringExtra(f11854c);
        this.f11862k = getIntent().getStringExtra(f11855d);
        String stringExtra = getIntent().getStringExtra("session");
        String stringExtra2 = getIntent().getStringExtra("uri");
        OutParameter outParameter = new OutParameter();
        this.f11861j = outParameter;
        outParameter.roomID = this.f11860i;
        outParameter.castType = 2;
        outParameter.mimeType = 102;
        outParameter.session = stringExtra;
        outParameter.urlID = stringExtra2;
        outParameter.protocol = 4;
        ConnectBridge connectBridge = ConnectManager.getInstance().getConnectBridge(this.f11862k);
        if (!(connectBridge == null || connectBridge.getServiceInfo() == null)) {
            this.f11861j.connectSession = connectBridge.getConnectSession();
            this.f11861j.serviceInfo = connectBridge.getServiceInfo();
            OutParameter outParameter2 = this.f11861j;
            outParameter2.currentBrowserInfo = CastUtil.getBrowserInfo(outParameter2.serviceInfo, 4);
        }
        if (this.f11858g.isInitOK()) {
            this.f11858g.release();
        }
        YimConfigBean yimConfigBean = new YimConfigBean();
        yimConfigBean.roomID = this.f11860i;
        yimConfigBean.userID = CreateUtil.createYimUserID();
        this.f11858g.initSink(getApplicationContext());
        this.f11858g.login(yimConfigBean);
        this.f11859h = new b(this.f11857f);
        this.f11858g.setVideoFrameCallback(this.f11868q);
        this.f11858g.addCloudMirrorListener(new OnCloudMirrorListener() {
            public void a(int i10, Object... objArr) {
                boolean z10;
                if (i10 == 1) {
                    int intValue = Integer.valueOf(objArr[0].toString()).intValue();
                    if (intValue == -1) {
                        MirrorPlayerActivity.this.finish();
                    }
                    SourceDataReport instance = SourceDataReport.getInstance();
                    OutParameter e10 = MirrorPlayerActivity.this.f11861j;
                    if (intValue == 1) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    instance.onYimInit(IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE, e10, z10, (String) null, (String) null);
                } else if (i10 != 2) {
                    if (i10 == 3) {
                        MirrorPlayerActivity.this.finish();
                    }
                } else if (Integer.valueOf(objArr[0].toString()).intValue() == -1) {
                    MirrorPlayerActivity.this.finish();
                }
            }
        });
    }
}
