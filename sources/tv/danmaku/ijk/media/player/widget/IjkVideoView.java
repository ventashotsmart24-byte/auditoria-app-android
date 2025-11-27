package tv.danmaku.ijk.media.player.widget;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.MediaController;
import java.lang.reflect.Field;
import java.util.Locale;
import java.util.Map;
import tv.danmaku.ijk.media.player.AndroidMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkTimedText;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;
import tv.danmaku.ijk.media.player.widget.media.IMediaController;
import tv.danmaku.ijk.media.player.widget.media.IRenderView;
import tv.danmaku.ijk.media.player.widget.media.IjkInitManager;
import tv.danmaku.ijk.media.player.widget.media.MediaPlayerCompat;

public class IjkVideoView extends FrameLayout implements MediaController.MediaPlayerControl {
    public static final int RENDER_NONE = 0;
    public static final int RENDER_SURFACE_VIEW = 1;
    public static final int RENDER_TEXTURE_VIEW = 2;
    private static final int STATE_ERROR = -1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PAUSED = 4;
    private static final int STATE_PLAYBACK_COMPLETED = 6;
    private static final int STATE_PLAYING = 3;
    private static final int STATE_PREPARED = 2;
    private static final int STATE_PREPARING = 1;
    private static final int STATE_STOP = 5;
    /* access modifiers changed from: private */
    public String TAG = "IjkVideoView";
    private boolean isIjkPlay = false;
    private Context mAppContext;
    private IMediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener = new IMediaPlayer.OnBufferingUpdateListener() {
        public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i10, long j10) {
            int unused = IjkVideoView.this.mCurrentBufferPercentage = i10;
        }
    };
    private boolean mCanPause = true;
    private boolean mCanSeekBack = true;
    private boolean mCanSeekForward = true;
    private IMediaPlayer.OnCompletionListener mCompletionListener = new IMediaPlayer.OnCompletionListener() {
        public void onCompletion(IMediaPlayer iMediaPlayer) {
            int unused = IjkVideoView.this.mCurrentState = 6;
            int unused2 = IjkVideoView.this.mTargetState = 6;
            if (IjkVideoView.this.mMediaController != null) {
                IjkVideoView.this.mMediaController.hide();
            }
            if (IjkVideoView.this.mOnCompletionListener != null) {
                IjkVideoView.this.mOnCompletionListener.onCompletion(IjkVideoView.this.mMediaPlayer);
            }
        }
    };
    private int mCurrentAspectRatio = 0;
    /* access modifiers changed from: private */
    public int mCurrentBufferPercentage;
    private int mCurrentRender = 1;
    /* access modifiers changed from: private */
    public int mCurrentState = 0;
    private IMediaPlayer.OnErrorListener mErrorListener = new IMediaPlayer.OnErrorListener() {
        public boolean onError(IMediaPlayer iMediaPlayer, int i10, int i11) {
            String unused = IjkVideoView.this.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Error: ");
            sb.append(i10);
            sb.append(",");
            sb.append(i11);
            int unused2 = IjkVideoView.this.mCurrentState = -1;
            int unused3 = IjkVideoView.this.mTargetState = -1;
            if (IjkVideoView.this.mMediaController != null) {
                IjkVideoView.this.mMediaController.hide();
            }
            if (IjkVideoView.this.mOnErrorListener != null && IjkVideoView.this.mOnErrorListener.onError(IjkVideoView.this.mMediaPlayer, i10, i11)) {
                return true;
            }
            IjkVideoView.this.getWindowToken();
            return true;
        }
    };
    private Map<String, String> mHeaders;
    private IMediaPlayer.OnInfoListener mInfoListener = new IMediaPlayer.OnInfoListener() {
        public boolean onInfo(IMediaPlayer iMediaPlayer, int i10, int i11) {
            if (IjkVideoView.this.mOnInfoListener != null) {
                IjkVideoView.this.mOnInfoListener.onInfo(iMediaPlayer, i10, i11);
            }
            String unused = IjkVideoView.this.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(" arg1 ");
            sb.append(i10);
            sb.append("  this : ");
            sb.append(this);
            if (i10 == 3) {
                String unused2 = IjkVideoView.this.TAG;
                if (IjkVideoView.this.mTargetState != 4 || IjkVideoView.this.mCurrentState == IjkVideoView.this.mTargetState) {
                    return true;
                }
                IjkVideoView.this.pause();
                return true;
            } else if (i10 == 901) {
                String unused3 = IjkVideoView.this.TAG;
                return true;
            } else if (i10 == 902) {
                String unused4 = IjkVideoView.this.TAG;
                return true;
            } else if (i10 == 10001) {
                int unused5 = IjkVideoView.this.mVideoRotationDegree = i11;
                String unused6 = IjkVideoView.this.TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("MEDIA_INFO_VIDEO_ROTATION_CHANGED: ");
                sb2.append(i11);
                if (IjkVideoView.this.mRenderView == null) {
                    return true;
                }
                IjkVideoView.this.mRenderView.setVideoRotation(i11);
                return true;
            } else if (i10 != 10002) {
                switch (i10) {
                    case 700:
                        String unused7 = IjkVideoView.this.TAG;
                        return true;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_START:
                        String unused8 = IjkVideoView.this.TAG;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("MEDIA_INFO_BUFFERING_START:");
                        sb3.append(this);
                        return true;
                    case IMediaPlayer.MEDIA_INFO_BUFFERING_END:
                        if (IjkVideoView.this.mTargetState == 4 && IjkVideoView.this.mCurrentState != IjkVideoView.this.mTargetState) {
                            IjkVideoView.this.pause();
                        }
                        String unused9 = IjkVideoView.this.TAG;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("MEDIA_INFO_BUFFERING_END: mTargetState ");
                        sb4.append(IjkVideoView.this.mTargetState);
                        sb4.append("  mCurrentState ");
                        sb4.append(IjkVideoView.this.mCurrentState);
                        sb4.append("   ");
                        sb4.append(this);
                        return true;
                    case IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH:
                        String unused10 = IjkVideoView.this.TAG;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("MEDIA_INFO_NETWORK_BANDWIDTH: ");
                        sb5.append(i11);
                        return true;
                    default:
                        switch (i10) {
                            case 800:
                                String unused11 = IjkVideoView.this.TAG;
                                return true;
                            case IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE:
                                String unused12 = IjkVideoView.this.TAG;
                                return true;
                            case IMediaPlayer.MEDIA_INFO_METADATA_UPDATE:
                                String unused13 = IjkVideoView.this.TAG;
                                return true;
                            default:
                                return true;
                        }
                }
            } else {
                String unused14 = IjkVideoView.this.TAG;
                return true;
            }
        }
    };
    /* access modifiers changed from: private */
    public IMediaController mMediaController;
    /* access modifiers changed from: private */
    public IMediaPlayer mMediaPlayer = null;
    /* access modifiers changed from: private */
    public IMediaPlayer.OnCompletionListener mOnCompletionListener;
    /* access modifiers changed from: private */
    public IMediaPlayer.OnErrorListener mOnErrorListener;
    /* access modifiers changed from: private */
    public IMediaPlayer.OnInfoListener mOnInfoListener;
    /* access modifiers changed from: private */
    public IMediaPlayer.OnPreparedListener mOnPreparedListener;
    private IMediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
    private IMediaPlayer.OnTimedTextListener mOnTimedTextListener = new IMediaPlayer.OnTimedTextListener() {
        public void onTimedText(IMediaPlayer iMediaPlayer, IjkTimedText ijkTimedText) {
        }
    };
    IMediaPlayer.OnPreparedListener mPreparedListener = new IMediaPlayer.OnPreparedListener() {
        public void onPrepared(IMediaPlayer iMediaPlayer) {
            int unused = IjkVideoView.this.mCurrentState = 2;
            if (IjkVideoView.this.mOnPreparedListener != null) {
                IjkVideoView.this.mOnPreparedListener.onPrepared(IjkVideoView.this.mMediaPlayer);
            }
            if (IjkVideoView.this.mMediaController != null) {
                IjkVideoView.this.mMediaController.setEnabled(true);
            }
            int unused2 = IjkVideoView.this.mVideoWidth = iMediaPlayer.getVideoWidth();
            int unused3 = IjkVideoView.this.mVideoHeight = iMediaPlayer.getVideoHeight();
            int access$900 = IjkVideoView.this.mSeekWhenPrepared;
            if (access$900 != 0) {
                IjkVideoView.this.seekTo(access$900);
            }
            IjkVideoView.this.mMediaPlayer.getMediaInfo();
            if (IjkVideoView.this.mVideoWidth == 0 || IjkVideoView.this.mVideoHeight == 0) {
                if (IjkVideoView.this.mTargetState == 3) {
                    IjkVideoView.this.start();
                }
            } else if (IjkVideoView.this.mRenderView != null) {
                IjkVideoView.this.mRenderView.setVideoSize(IjkVideoView.this.mVideoWidth, IjkVideoView.this.mVideoHeight);
                IjkVideoView.this.mRenderView.setVideoSampleAspectRatio(IjkVideoView.this.mVideoSarNum, IjkVideoView.this.mVideoSarDen);
                if (IjkVideoView.this.mRenderView.shouldWaitForResize() && (IjkVideoView.this.mSurfaceWidth != IjkVideoView.this.mVideoWidth || IjkVideoView.this.mSurfaceHeight != IjkVideoView.this.mVideoHeight)) {
                    return;
                }
                if (IjkVideoView.this.mTargetState == 3) {
                    IjkVideoView.this.start();
                    if (IjkVideoView.this.mMediaController != null) {
                        IjkVideoView.this.mMediaController.show();
                    }
                } else if (IjkVideoView.this.isPlaying()) {
                } else {
                    if ((access$900 != 0 || IjkVideoView.this.getCurrentPosition() > 0) && IjkVideoView.this.mMediaController != null) {
                        IjkVideoView.this.mMediaController.show(0);
                    }
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public IRenderView mRenderView;
    IRenderView.IRenderCallback mSHCallback = new IRenderView.IRenderCallback() {
        public void onSurfaceChanged(IRenderView.ISurfaceHolder iSurfaceHolder, int i10, int i11, int i12) {
            boolean z10;
            if (iSurfaceHolder.getRenderView() != IjkVideoView.this.mRenderView) {
                Log.e(IjkVideoView.this.TAG, "onSurfaceChanged: unmatched render callback\n");
                return;
            }
            int unused = IjkVideoView.this.mSurfaceWidth = i11;
            int unused2 = IjkVideoView.this.mSurfaceHeight = i12;
            boolean z11 = true;
            if (IjkVideoView.this.mTargetState == 3) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (IjkVideoView.this.mRenderView.shouldWaitForResize() && !(IjkVideoView.this.mVideoWidth == i11 && IjkVideoView.this.mVideoHeight == i12)) {
                z11 = false;
            }
            if (IjkVideoView.this.mMediaPlayer != null && z10 && z11) {
                if (IjkVideoView.this.mSeekWhenPrepared != 0) {
                    IjkVideoView ijkVideoView = IjkVideoView.this;
                    ijkVideoView.seekTo(ijkVideoView.mSeekWhenPrepared);
                }
                IjkVideoView.this.start();
            }
        }

        public void onSurfaceCreated(IRenderView.ISurfaceHolder iSurfaceHolder, int i10, int i11) {
            if (iSurfaceHolder.getRenderView() != IjkVideoView.this.mRenderView) {
                Log.e(IjkVideoView.this.TAG, "onSurfaceCreated: unmatched render callback\n");
                return;
            }
            IjkVideoView.this.surfaceCreated();
            IRenderView.ISurfaceHolder unused = IjkVideoView.this.mSurfaceHolder = iSurfaceHolder;
            if (IjkVideoView.this.mMediaPlayer != null) {
                IjkVideoView ijkVideoView = IjkVideoView.this;
                ijkVideoView.bindSurfaceHolder(ijkVideoView.mMediaPlayer, iSurfaceHolder);
                return;
            }
            IjkVideoView.this.openVideo();
        }

        public void onSurfaceDestroyed(IRenderView.ISurfaceHolder iSurfaceHolder) {
            if (iSurfaceHolder.getRenderView() != IjkVideoView.this.mRenderView) {
                Log.e(IjkVideoView.this.TAG, "onSurfaceDestroyed: unmatched render callback\n");
                return;
            }
            IRenderView.ISurfaceHolder unused = IjkVideoView.this.mSurfaceHolder = null;
            IjkVideoView.this.releaseWithoutStop();
        }
    };
    private IMediaPlayer.OnSeekCompleteListener mSeekCompleteListener = new IMediaPlayer.OnSeekCompleteListener() {
        public void onSeekComplete(IMediaPlayer iMediaPlayer) {
        }
    };
    /* access modifiers changed from: private */
    public int mSeekWhenPrepared;
    IMediaPlayer.OnVideoSizeChangedListener mSizeChangedListener = new IMediaPlayer.OnVideoSizeChangedListener() {
        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i10, int i11, int i12, int i13) {
            int unused = IjkVideoView.this.mVideoWidth = iMediaPlayer.getVideoWidth();
            int unused2 = IjkVideoView.this.mVideoHeight = iMediaPlayer.getVideoHeight();
            int unused3 = IjkVideoView.this.mVideoSarNum = iMediaPlayer.getVideoSarNum();
            int unused4 = IjkVideoView.this.mVideoSarDen = iMediaPlayer.getVideoSarDen();
            if (IjkVideoView.this.mVideoWidth != 0 && IjkVideoView.this.mVideoHeight != 0) {
                if (IjkVideoView.this.mRenderView != null) {
                    IjkVideoView.this.mRenderView.setVideoSize(IjkVideoView.this.mVideoWidth, IjkVideoView.this.mVideoHeight);
                    IjkVideoView.this.mRenderView.setVideoSampleAspectRatio(IjkVideoView.this.mVideoSarNum, IjkVideoView.this.mVideoSarDen);
                }
                IjkVideoView.this.requestLayout();
            }
        }
    };
    /* access modifiers changed from: private */
    public int mSurfaceHeight;
    /* access modifiers changed from: private */
    public IRenderView.ISurfaceHolder mSurfaceHolder = null;
    /* access modifiers changed from: private */
    public int mSurfaceWidth;
    /* access modifiers changed from: private */
    public int mTargetState = 0;
    private Uri mUri;
    /* access modifiers changed from: private */
    public int mVideoHeight;
    /* access modifiers changed from: private */
    public int mVideoRotationDegree;
    /* access modifiers changed from: private */
    public int mVideoSarDen;
    /* access modifiers changed from: private */
    public int mVideoSarNum;
    /* access modifiers changed from: private */
    public int mVideoWidth;

    public IjkVideoView(Context context) {
        super(context);
        initVideoView(context);
    }

    private void attachMediaController() {
        IMediaController iMediaController;
        View view;
        if (this.mMediaPlayer != null && (iMediaController = this.mMediaController) != null) {
            iMediaController.setMediaPlayer(this);
            if (getParent() instanceof View) {
                view = (View) getParent();
            } else {
                view = this;
            }
            this.mMediaController.setAnchorView(view);
            this.mMediaController.setEnabled(isInPlaybackState());
        }
    }

    /* access modifiers changed from: private */
    public void bindSurfaceHolder(IMediaPlayer iMediaPlayer, IRenderView.ISurfaceHolder iSurfaceHolder) {
        if (iMediaPlayer != null) {
            if (iSurfaceHolder == null) {
                iMediaPlayer.setDisplay((SurfaceHolder) null);
            } else {
                iSurfaceHolder.bindToMediaPlayer(iMediaPlayer);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: tv.danmaku.ijk.media.player.AndroidMediaPlayer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: tv.danmaku.ijk.media.player.AndroidMediaPlayer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: tv.danmaku.ijk.media.player.IjkMediaPlayer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: tv.danmaku.ijk.media.player.AndroidMediaPlayer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: tv.danmaku.ijk.media.player.AndroidMediaPlayer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private tv.danmaku.ijk.media.player.IMediaPlayer createPlayer() {
        /*
            r9 = this;
            android.net.Uri r0 = r9.mUri
            if (r0 == 0) goto L_0x007c
            boolean r0 = r9.isIjkPlay
            if (r0 == 0) goto L_0x0076
            tv.danmaku.ijk.media.player.IjkMediaPlayer r0 = new tv.danmaku.ijk.media.player.IjkMediaPlayer
            r0.<init>()
            r1 = 6
            tv.danmaku.ijk.media.player.IjkMediaPlayer.native_setLogLevel(r1)
            java.lang.String r1 = "mediacodec"
            r2 = 4
            r3 = 1
            r0.setOption((int) r2, (java.lang.String) r1, (long) r3)
            java.lang.String r1 = "opensles"
            r5 = 0
            r0.setOption((int) r2, (java.lang.String) r1, (long) r5)
            java.lang.String r1 = "overlay-format"
            r7 = 842225234(0x32335652, double:4.16114554E-315)
            r0.setOption((int) r2, (java.lang.String) r1, (long) r7)
            java.lang.String r1 = "http-detect-range-support"
            r7 = 1
            r0.setOption((int) r7, (java.lang.String) r1, (long) r5)
            java.lang.String r1 = "skip_loop_filter"
            r5 = 48
            r8 = 2
            r0.setOption((int) r8, (java.lang.String) r1, (long) r5)
            java.lang.String r1 = "live-streaming"
            r0.setOption((int) r2, (java.lang.String) r1, (long) r3)
            java.lang.String r1 = "delay-optimization"
            r0.setOption((int) r2, (java.lang.String) r1, (long) r3)
            java.lang.String r1 = "start-on-prepared"
            r0.setOption((int) r2, (java.lang.String) r1, (long) r3)
            java.lang.String r1 = "timeout"
            r5 = 20000(0x4e20, double:9.8813E-320)
            r0.setOption((int) r2, (java.lang.String) r1, (long) r5)
            java.lang.String r1 = "get-av-frame-timeout"
            r0.setOption((int) r2, (java.lang.String) r1, (long) r5)
            java.lang.String r1 = "cache-buffer-duration"
            r5 = 2000(0x7d0, double:9.88E-321)
            r0.setOption((int) r2, (java.lang.String) r1, (long) r5)
            java.lang.String r1 = "max-cache-buffer-duration"
            r5 = 4000(0xfa0, double:1.9763E-320)
            r0.setOption((int) r2, (java.lang.String) r1, (long) r5)
            java.lang.String r1 = "analyzemaxduration"
            r5 = 100
            r0.setOption((int) r7, (java.lang.String) r1, (long) r5)
            java.lang.String r1 = "flush_packets"
            r0.setOption((int) r7, (java.lang.String) r1, (long) r3)
            java.lang.String r1 = "framedrop"
            r0.setOption((int) r2, (java.lang.String) r1, (long) r3)
            java.lang.String r1 = "render-wait-start"
            r0.setOption((int) r2, (java.lang.String) r1, (long) r3)
            goto L_0x007d
        L_0x0076:
            tv.danmaku.ijk.media.player.AndroidMediaPlayer r0 = new tv.danmaku.ijk.media.player.AndroidMediaPlayer
            r0.<init>()
            goto L_0x007d
        L_0x007c:
            r0 = 0
        L_0x007d:
            r1 = 0
            r0.setLooping(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tv.danmaku.ijk.media.player.widget.IjkVideoView.createPlayer():tv.danmaku.ijk.media.player.IMediaPlayer");
    }

    private void initRenders() {
        this.mCurrentRender = 1;
        setRender(1);
    }

    private void initVideoView(Context context) {
        this.mAppContext = context.getApplicationContext();
        initRenders();
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mCurrentState = 0;
        this.mTargetState = 0;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00c9, code lost:
        r3 = new java.lang.StringBuilder();
        r3.append("Unable to open content: ");
        r3.append(r9.mUri);
        r9.mCurrentState = -1;
        r9.mTargetState = -1;
        r9.mErrorListener.onError(r9.mMediaPlayer, 1, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00e2, code lost:
        r3 = new java.lang.StringBuilder();
        r3.append("Unable to open content: ");
        r3.append(r9.mUri);
        r9.mCurrentState = -1;
        r9.mTargetState = -1;
        r9.mErrorListener.onError(r9.mMediaPlayer, 1, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00fb, code lost:
        r3 = new java.lang.StringBuilder();
        r3.append("Unable to open content: ");
        r3.append(r9.mUri);
        r9.mCurrentState = -1;
        r9.mTargetState = -1;
        r9.mErrorListener.onError(r9.mMediaPlayer, 1, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void openVideo() {
        /*
            r9 = this;
            java.lang.String r0 = "Unable to open content: "
            android.net.Uri r1 = r9.mUri
            if (r1 == 0) goto L_0x0113
            tv.danmaku.ijk.media.player.widget.media.IRenderView$ISurfaceHolder r1 = r9.mSurfaceHolder
            if (r1 != 0) goto L_0x000c
            goto L_0x0113
        L_0x000c:
            r1 = 0
            r9.release(r1)
            android.content.Context r2 = r9.mAppContext
            java.lang.String r3 = "audio"
            java.lang.Object r2 = r2.getSystemService(r3)
            android.media.AudioManager r2 = (android.media.AudioManager) r2
            r3 = 0
            r4 = 3
            r5 = 1
            r2.requestAudioFocus(r3, r4, r5)
            r2 = -1
            tv.danmaku.ijk.media.player.IMediaPlayer r3 = r9.createPlayer()     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            r9.mMediaPlayer = r3     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            tv.danmaku.ijk.media.player.IMediaPlayer$OnPreparedListener r6 = r9.mPreparedListener     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            r3.setOnPreparedListener(r6)     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            tv.danmaku.ijk.media.player.IMediaPlayer r3 = r9.mMediaPlayer     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            tv.danmaku.ijk.media.player.IMediaPlayer$OnVideoSizeChangedListener r6 = r9.mSizeChangedListener     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            r3.setOnVideoSizeChangedListener(r6)     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            tv.danmaku.ijk.media.player.IMediaPlayer r3 = r9.mMediaPlayer     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            tv.danmaku.ijk.media.player.IMediaPlayer$OnCompletionListener r6 = r9.mCompletionListener     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            r3.setOnCompletionListener(r6)     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            tv.danmaku.ijk.media.player.IMediaPlayer r3 = r9.mMediaPlayer     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            tv.danmaku.ijk.media.player.IMediaPlayer$OnErrorListener r6 = r9.mErrorListener     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            r3.setOnErrorListener(r6)     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            tv.danmaku.ijk.media.player.IMediaPlayer r3 = r9.mMediaPlayer     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            tv.danmaku.ijk.media.player.IMediaPlayer$OnInfoListener r6 = r9.mInfoListener     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            r3.setOnInfoListener(r6)     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            tv.danmaku.ijk.media.player.IMediaPlayer r3 = r9.mMediaPlayer     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            tv.danmaku.ijk.media.player.IMediaPlayer$OnBufferingUpdateListener r6 = r9.mBufferingUpdateListener     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            r3.setOnBufferingUpdateListener(r6)     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            tv.danmaku.ijk.media.player.IMediaPlayer r3 = r9.mMediaPlayer     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            tv.danmaku.ijk.media.player.IMediaPlayer$OnSeekCompleteListener r6 = r9.mSeekCompleteListener     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            r3.setOnSeekCompleteListener(r6)     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            tv.danmaku.ijk.media.player.IMediaPlayer r3 = r9.mMediaPlayer     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            tv.danmaku.ijk.media.player.IMediaPlayer$OnTimedTextListener r6 = r9.mOnTimedTextListener     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            r3.setOnTimedTextListener(r6)     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            tv.danmaku.ijk.media.player.IMediaPlayer r3 = r9.mMediaPlayer     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            r3.setLooping(r1)     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            r9.mCurrentBufferPercentage = r1     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            android.net.Uri r3 = r9.mUri     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            java.lang.String r3 = r3.getScheme()     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            r7 = 23
            if (r6 < r7) goto L_0x009a
            boolean r6 = android.text.TextUtils.isEmpty(r3)     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            if (r6 != 0) goto L_0x007e
            java.lang.String r6 = "file"
            boolean r3 = r3.equalsIgnoreCase(r6)     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            if (r3 == 0) goto L_0x009a
        L_0x007e:
            tv.danmaku.ijk.media.player.IMediaPlayer r3 = r9.mMediaPlayer     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            boolean r3 = r3 instanceof tv.danmaku.ijk.media.player.IjkMediaPlayer     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            if (r3 == 0) goto L_0x009a
            tv.danmaku.ijk.media.player.widget.media.FileMediaDataSource r3 = new tv.danmaku.ijk.media.player.widget.media.FileMediaDataSource     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            java.io.File r6 = new java.io.File     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            android.net.Uri r7 = r9.mUri     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            r6.<init>(r7)     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            r3.<init>(r6)     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            tv.danmaku.ijk.media.player.IMediaPlayer r6 = r9.mMediaPlayer     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            r6.setDataSource((tv.danmaku.ijk.media.player.misc.IMediaDataSource) r3)     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            goto L_0x00a5
        L_0x009a:
            tv.danmaku.ijk.media.player.IMediaPlayer r3 = r9.mMediaPlayer     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            android.content.Context r6 = r9.mAppContext     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            android.net.Uri r7 = r9.mUri     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            java.util.Map<java.lang.String, java.lang.String> r8 = r9.mHeaders     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            r3.setDataSource(r6, r7, r8)     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
        L_0x00a5:
            r9.reflectSubTitleService()     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            tv.danmaku.ijk.media.player.IMediaPlayer r3 = r9.mMediaPlayer     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            tv.danmaku.ijk.media.player.widget.media.IRenderView$ISurfaceHolder r6 = r9.mSurfaceHolder     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            r9.bindSurfaceHolder(r3, r6)     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            tv.danmaku.ijk.media.player.IMediaPlayer r3 = r9.mMediaPlayer     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            r3.setAudioStreamType(r4)     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            tv.danmaku.ijk.media.player.IMediaPlayer r3 = r9.mMediaPlayer     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            r3.setScreenOnWhilePlaying(r5)     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            r9.startPrepare()     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            tv.danmaku.ijk.media.player.IMediaPlayer r3 = r9.mMediaPlayer     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            r3.prepareAsync()     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            r9.mCurrentState = r5     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            r9.attachMediaController()     // Catch:{ IOException -> 0x00fb, IllegalArgumentException -> 0x00e2, IllegalStateException -> 0x00c9, all -> 0x00c7 }
            goto L_0x0113
        L_0x00c7:
            r0 = move-exception
            throw r0
        L_0x00c9:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            android.net.Uri r0 = r9.mUri
            r3.append(r0)
            r9.mCurrentState = r2
            r9.mTargetState = r2
            tv.danmaku.ijk.media.player.IMediaPlayer$OnErrorListener r0 = r9.mErrorListener
            tv.danmaku.ijk.media.player.IMediaPlayer r2 = r9.mMediaPlayer
            r0.onError(r2, r5, r1)
            goto L_0x0113
        L_0x00e2:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            android.net.Uri r0 = r9.mUri
            r3.append(r0)
            r9.mCurrentState = r2
            r9.mTargetState = r2
            tv.danmaku.ijk.media.player.IMediaPlayer$OnErrorListener r0 = r9.mErrorListener
            tv.danmaku.ijk.media.player.IMediaPlayer r2 = r9.mMediaPlayer
            r0.onError(r2, r5, r1)
            goto L_0x0113
        L_0x00fb:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            android.net.Uri r0 = r9.mUri
            r3.append(r0)
            r9.mCurrentState = r2
            r9.mTargetState = r2
            tv.danmaku.ijk.media.player.IMediaPlayer$OnErrorListener r0 = r9.mErrorListener
            tv.danmaku.ijk.media.player.IMediaPlayer r2 = r9.mMediaPlayer
            r0.onError(r2, r5, r1)
        L_0x0113:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tv.danmaku.ijk.media.player.widget.IjkVideoView.openVideo():void");
    }

    private void reflectSubTitleService() {
        if (Build.VERSION.SDK_INT == 19) {
            try {
                IMediaPlayer iMediaPlayer = this.mMediaPlayer;
                if (iMediaPlayer instanceof AndroidMediaPlayer) {
                    Field declaredField = ((AndroidMediaPlayer) iMediaPlayer).getInternalMediaPlayer().getClass().getDeclaredField("subTitleService");
                    declaredField.setAccessible(true);
                    declaredField.set(((AndroidMediaPlayer) this.mMediaPlayer).getInternalMediaPlayer(), (Object) null);
                }
            } catch (Exception unused) {
            }
        }
    }

    private void toggleMediaControlsVisiblity() {
        if (this.mMediaController.isShowing()) {
            this.mMediaController.hide();
        } else {
            this.mMediaController.show();
        }
    }

    public boolean canPause() {
        return this.mCanPause;
    }

    public boolean canSeekBackward() {
        return this.mCanSeekBack;
    }

    public boolean canSeekForward() {
        return this.mCanSeekForward;
    }

    public void deselectTrack(int i10) {
        MediaPlayerCompat.deselectTrack(this.mMediaPlayer, i10);
    }

    public int getAudioSessionId() {
        return 0;
    }

    public int getBufferPercentage() {
        if (this.mMediaPlayer != null) {
            return this.mCurrentBufferPercentage;
        }
        return 0;
    }

    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return (int) this.mMediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        if (isInPlaybackState()) {
            return (int) this.mMediaPlayer.getDuration();
        }
        return -1;
    }

    public IMediaPlayer getMediaPlayer() {
        return this.mMediaPlayer;
    }

    public int getSelectedTrack(int i10) {
        return MediaPlayerCompat.getSelectedTrack(this.mMediaPlayer, i10);
    }

    public ITrackInfo[] getTrackInfo() {
        IMediaPlayer iMediaPlayer = this.mMediaPlayer;
        if (iMediaPlayer == null) {
            return null;
        }
        return iMediaPlayer.getTrackInfo();
    }

    public boolean isInPlaybackState() {
        int i10;
        if (this.mMediaPlayer == null || (i10 = this.mCurrentState) == -1 || i10 == 0 || i10 == 1 || i10 == 5) {
            return false;
        }
        return true;
    }

    public boolean isPlaying() {
        if (!isInPlaybackState() || !this.mMediaPlayer.isPlaying()) {
            return false;
        }
        return true;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        IjkInitManager.getInstance().initIjk();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        IjkInitManager.getInstance().endIjk();
    }

    public void pause() {
        if (isInPlaybackState() && this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
            this.mCurrentState = 4;
        }
        this.mTargetState = 4;
    }

    public void release(boolean z10) {
        IMediaPlayer iMediaPlayer = this.mMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.setDisplay((SurfaceHolder) null);
            this.mMediaPlayer.reset();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            this.mCurrentState = 0;
            if (z10) {
                this.mTargetState = 0;
            }
            ((AudioManager) this.mAppContext.getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
        }
    }

    public void releaseWithoutStop() {
        IMediaPlayer iMediaPlayer = this.mMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.setDisplay((SurfaceHolder) null);
        }
    }

    public void seekTo(int i10) {
        if (isInPlaybackState()) {
            this.mMediaPlayer.seekTo((long) i10);
            this.mSeekWhenPrepared = 0;
            startSeekto(i10);
            return;
        }
        this.mSeekWhenPrepared = i10;
    }

    public void selectTrack(int i10) {
        MediaPlayerCompat.selectTrack(this.mMediaPlayer, i10);
    }

    public void setAspectRatio(int i10) {
        this.mCurrentAspectRatio = i10;
        IRenderView iRenderView = this.mRenderView;
        if (iRenderView != null) {
            iRenderView.setAspectRatio(i10);
        }
    }

    public void setMediaController(IMediaController iMediaController) {
        IMediaController iMediaController2 = this.mMediaController;
        if (iMediaController2 != null) {
            iMediaController2.hide();
        }
        this.mMediaController = iMediaController;
        attachMediaController();
    }

    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    public void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
    }

    public void setPlayMode(boolean z10) {
        this.isIjkPlay = z10;
    }

    public void setRender(int i10) {
        if (i10 == 0) {
            setRenderView((IRenderView) null);
        } else if (i10 == 1) {
            setRenderView(new SurfaceRenderView(getContext()));
        } else if (i10 != 2) {
            Log.e(this.TAG, String.format(Locale.getDefault(), "invalid render %d\n", new Object[]{Integer.valueOf(i10)}));
        } else {
            TextureRenderView textureRenderView = new TextureRenderView(getContext());
            if (this.mMediaPlayer != null) {
                textureRenderView.getSurfaceHolder().bindToMediaPlayer(this.mMediaPlayer);
                textureRenderView.setVideoSize(this.mMediaPlayer.getVideoWidth(), this.mMediaPlayer.getVideoHeight());
                textureRenderView.setVideoSampleAspectRatio(this.mMediaPlayer.getVideoSarNum(), this.mMediaPlayer.getVideoSarDen());
                textureRenderView.setAspectRatio(this.mCurrentAspectRatio);
            }
            setRenderView(textureRenderView);
        }
    }

    public void setRenderView(IRenderView iRenderView) {
        int i10;
        int i11;
        if (this.mRenderView != null) {
            IMediaPlayer iMediaPlayer = this.mMediaPlayer;
            if (iMediaPlayer != null) {
                iMediaPlayer.setDisplay((SurfaceHolder) null);
            }
            View view = this.mRenderView.getView();
            this.mRenderView.removeRenderCallback(this.mSHCallback);
            this.mRenderView = null;
            removeView(view);
        }
        if (iRenderView != null) {
            this.mRenderView = iRenderView;
            iRenderView.setAspectRatio(this.mCurrentAspectRatio);
            int i12 = this.mVideoWidth;
            if (i12 > 0 && (i11 = this.mVideoHeight) > 0) {
                iRenderView.setVideoSize(i12, i11);
            }
            int i13 = this.mVideoSarNum;
            if (i13 > 0 && (i10 = this.mVideoSarDen) > 0) {
                iRenderView.setVideoSampleAspectRatio(i13, i10);
            }
            View view2 = this.mRenderView.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            addView(view2);
            this.mRenderView.addRenderCallback(this.mSHCallback);
            this.mRenderView.setVideoRotation(this.mVideoRotationDegree);
        }
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        setVideoURI(uri, (Map<String, String>) null);
    }

    public void start() {
        if (isInPlaybackState()) {
            this.mMediaPlayer.start();
            this.mCurrentState = 3;
        }
        this.mTargetState = 3;
    }

    public void startPrepare() {
    }

    public void startSeekto(int i10) {
    }

    public void stopPlayback() {
        IMediaPlayer iMediaPlayer = this.mMediaPlayer;
        if (iMediaPlayer != null) {
            iMediaPlayer.stop();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            this.mCurrentState = 0;
            this.mTargetState = 0;
            ((AudioManager) this.mAppContext.getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
        }
    }

    public void surfaceCreated() {
    }

    public void suspend() {
        release(false);
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        this.mUri = uri;
        this.mHeaders = map;
        this.mSeekWhenPrepared = 0;
        initRenders();
        openVideo();
        requestLayout();
        invalidate();
    }

    public IjkVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initVideoView(context);
    }

    public IjkVideoView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        initVideoView(context);
    }

    public IjkVideoView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        initVideoView(context);
    }
}
