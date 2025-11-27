package com.umeng.message.proguard;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.umeng.message.proguard.bx;

public final class cv implements bx.f {

    /* renamed from: a  reason: collision with root package name */
    public Uri f15693a;

    /* renamed from: b  reason: collision with root package name */
    public SurfaceHolder f15694b;

    /* renamed from: c  reason: collision with root package name */
    int f15695c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f15696d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f15697e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f15698f;

    /* renamed from: g  reason: collision with root package name */
    public int f15699g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f15700h;

    /* renamed from: i  reason: collision with root package name */
    public long f15701i;

    /* renamed from: j  reason: collision with root package name */
    public int f15702j;

    /* renamed from: k  reason: collision with root package name */
    public int f15703k;

    /* renamed from: l  reason: collision with root package name */
    public bx.e f15704l;

    /* renamed from: m  reason: collision with root package name */
    private MediaPlayer f15705m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f15706n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f15707o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f15708p;

    /* renamed from: q  reason: collision with root package name */
    private long f15709q;

    private void d(int i10) {
        MediaPlayer mediaPlayer = this.f15705m;
        if (mediaPlayer != null) {
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    mediaPlayer.seekTo((long) i10, 3);
                } else {
                    mediaPlayer.seekTo(i10);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void f() {
        MediaPlayer mediaPlayer = this.f15705m;
        if (mediaPlayer != null) {
            try {
                if (this.f15696d) {
                    mediaPlayer.setVolume(0.0f, 0.0f);
                } else {
                    mediaPlayer.setVolume(1.0f, 1.0f);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void g() {
        if (this.f15693a == null) {
            ce.a("VideoPlayer", "init uri null!");
            return;
        }
        SurfaceHolder surfaceHolder = this.f15694b;
        if (surfaceHolder == null) {
            ce.a("VideoPlayer", "init surfaceHolder null!");
            this.f15708p = true;
            return;
        }
        try {
            Surface surface = surfaceHolder.getSurface();
            if (!surface.isValid()) {
                ce.a("VideoPlayer", "init surface not valid!");
                this.f15708p = true;
                return;
            }
            MediaPlayer mediaPlayer = this.f15705m;
            if (mediaPlayer == null) {
                this.f15705m = new MediaPlayer();
            } else {
                mediaPlayer.reset();
            }
            this.f15705m.setAudioStreamType(3);
            this.f15705m.setDataSource(this.f15693a.getPath());
            f();
            this.f15705m.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                public final boolean onInfo(MediaPlayer mediaPlayer, int i10, int i11) {
                    ce.a("VideoPlayer", "onInfo what:" + i10 + " extra:" + i11);
                    return false;
                }
            });
            this.f15705m.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public final void onCompletion(MediaPlayer mediaPlayer) {
                    try {
                        bx.e eVar = cv.this.f15704l;
                        if (eVar != null) {
                            eVar.d();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    try {
                        cv cvVar = cv.this;
                        int i10 = cvVar.f15699g;
                        cvVar.f15695c = i10;
                        cvVar.c(i10);
                        cv cvVar2 = cv.this;
                        cvVar2.f15695c = 0;
                        if (cvVar2.f15697e) {
                            mediaPlayer.start();
                            cv cvVar3 = cv.this;
                            cvVar3.b(cvVar3.f15695c);
                            return;
                        }
                        mediaPlayer.seekTo(0);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            });
            this.f15705m.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                public final boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
                    ce.d("VideoPlayer", "onError what:" + i10 + " extra:" + i11);
                    try {
                        cv.this.a(false);
                        bx.e eVar = cv.this.f15704l;
                        if (eVar != null) {
                            eVar.a("media player error, what:" + i10 + " extra:" + i11);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    return false;
                }
            });
            this.f15705m.setVideoScalingMode(1);
            this.f15705m.setSurface(surface);
            this.f15705m.setScreenOnWhilePlaying(true);
            this.f15705m.setLooping(false);
            this.f15705m.setOnPreparedListener((MediaPlayer.OnPreparedListener) null);
            this.f15705m.prepare();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final synchronized void a() {
        try {
            g();
            if (this.f15705m != null) {
                d(this.f15695c);
                ce.a("VideoPlayer", "preview position:" + this.f15695c);
                if (this.f15708p) {
                    c();
                    this.f15708p = false;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final synchronized boolean b() {
        if (!this.f15706n) {
            c();
        }
        return !this.f15706n;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void c() {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 1
            r1 = 0
            boolean r2 = r6.f15707o     // Catch:{ all -> 0x004b }
            if (r2 != 0) goto L_0x004f
            boolean r2 = r6.f15706n     // Catch:{ all -> 0x004b }
            if (r2 == 0) goto L_0x004f
            android.media.MediaPlayer r2 = r6.f15705m     // Catch:{ all -> 0x004b }
            if (r2 == 0) goto L_0x004f
            boolean r2 = r2.isPlaying()     // Catch:{ all -> 0x004b }
            if (r2 != 0) goto L_0x004f
            android.media.MediaPlayer r2 = r6.f15705m     // Catch:{ all -> 0x004b }
            r2.start()     // Catch:{ all -> 0x004b }
            r6.f15706n = r1     // Catch:{ all -> 0x004b }
            android.media.MediaPlayer r2 = r6.f15705m     // Catch:{ all -> 0x004b }
            int r2 = r2.getCurrentPosition()     // Catch:{ all -> 0x004b }
            r6.f15695c = r2     // Catch:{ all -> 0x004b }
            java.lang.String r2 = "VideoPlayer"
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch:{ all -> 0x004b }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x004b }
            java.lang.String r5 = "start position:"
            r4.<init>(r5)     // Catch:{ all -> 0x004b }
            int r5 = r6.f15695c     // Catch:{ all -> 0x004b }
            r4.append(r5)     // Catch:{ all -> 0x004b }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x004b }
            r3[r1] = r4     // Catch:{ all -> 0x004b }
            com.umeng.message.proguard.ce.a(r2, r3)     // Catch:{ all -> 0x004b }
            int r2 = r6.f15695c     // Catch:{ all -> 0x004b }
            r6.b((int) r2)     // Catch:{ all -> 0x004b }
            com.umeng.message.proguard.bx$e r2 = r6.f15704l     // Catch:{ all -> 0x004b }
            if (r2 == 0) goto L_0x0049
            r2.b()     // Catch:{ all -> 0x004b }
        L_0x0049:
            monitor-exit(r6)
            return
        L_0x004b:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ all -> 0x00a3 }
        L_0x004f:
            android.media.MediaPlayer r2 = r6.f15705m     // Catch:{ all -> 0x0097 }
            if (r2 == 0) goto L_0x005d
            boolean r2 = r2.isPlaying()     // Catch:{ all -> 0x0097 }
            if (r2 == 0) goto L_0x005d
            r6.f15707o = r1     // Catch:{ all -> 0x00a3 }
            monitor-exit(r6)
            return
        L_0x005d:
            r6.g()     // Catch:{ all -> 0x0097 }
            android.media.MediaPlayer r2 = r6.f15705m     // Catch:{ all -> 0x0097 }
            if (r2 == 0) goto L_0x0093
            int r2 = r6.f15695c     // Catch:{ all -> 0x0097 }
            r6.d(r2)     // Catch:{ all -> 0x0097 }
            java.lang.String r2 = "VideoPlayer"
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x0097 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0097 }
            java.lang.String r4 = "start position:"
            r3.<init>(r4)     // Catch:{ all -> 0x0097 }
            int r4 = r6.f15695c     // Catch:{ all -> 0x0097 }
            r3.append(r4)     // Catch:{ all -> 0x0097 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0097 }
            r0[r1] = r3     // Catch:{ all -> 0x0097 }
            com.umeng.message.proguard.ce.a(r2, r0)     // Catch:{ all -> 0x0097 }
            android.media.MediaPlayer r0 = r6.f15705m     // Catch:{ all -> 0x0097 }
            r0.start()     // Catch:{ all -> 0x0097 }
            int r0 = r6.f15695c     // Catch:{ all -> 0x0097 }
            r6.b((int) r0)     // Catch:{ all -> 0x0097 }
            com.umeng.message.proguard.bx$e r0 = r6.f15704l     // Catch:{ all -> 0x0097 }
            if (r0 == 0) goto L_0x0093
            r0.b()     // Catch:{ all -> 0x0097 }
        L_0x0093:
            r6.f15707o = r1     // Catch:{ all -> 0x00a3 }
            monitor-exit(r6)
            return
        L_0x0097:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x009f }
            r6.f15707o = r1     // Catch:{ all -> 0x00a3 }
            monitor-exit(r6)
            return
        L_0x009f:
            r0 = move-exception
            r6.f15707o = r1     // Catch:{ all -> 0x00a3 }
            throw r0     // Catch:{ all -> 0x00a3 }
        L_0x00a3:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.cv.c():void");
    }

    public final int e() {
        MediaPlayer mediaPlayer = this.f15705m;
        if (mediaPlayer != null) {
            try {
                this.f15695c = mediaPlayer.getCurrentPosition();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this.f15695c;
    }

    public final void b(boolean z10) {
        this.f15696d = z10;
        f();
    }

    public final synchronized void b(int i10) {
        this.f15700h = true;
        this.f15709q = (long) i10;
    }

    public final boolean d() {
        MediaPlayer mediaPlayer = this.f15705m;
        if (mediaPlayer == null) {
            return false;
        }
        try {
            return mediaPlayer.isPlaying();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final synchronized void a(boolean z10) {
        try {
            if (this.f15705m != null) {
                c(z10);
                this.f15705m.release();
            }
        } catch (Throwable th) {
            this.f15705m = null;
            throw th;
        }
        this.f15705m = null;
        this.f15707o = false;
        this.f15706n = false;
    }

    public final synchronized void a(int i10) {
        if (d()) {
            c(i10);
            b(i10);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void c(boolean r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 1
            r4.f15707o = r0     // Catch:{ all -> 0x0045 }
            android.media.MediaPlayer r1 = r4.f15705m     // Catch:{ all -> 0x0045 }
            if (r1 == 0) goto L_0x0043
            int r2 = r1.getCurrentPosition()     // Catch:{ all -> 0x003f }
            r4.f15695c = r2     // Catch:{ all -> 0x003f }
            r1.stop()     // Catch:{ all -> 0x003f }
            java.lang.String r1 = "VideoPlayer"
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x003f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x003f }
            java.lang.String r3 = "stop position:"
            r2.<init>(r3)     // Catch:{ all -> 0x003f }
            int r3 = r4.f15695c     // Catch:{ all -> 0x003f }
            r2.append(r3)     // Catch:{ all -> 0x003f }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x003f }
            r3 = 0
            r0[r3] = r2     // Catch:{ all -> 0x003f }
            com.umeng.message.proguard.ce.a(r1, r0)     // Catch:{ all -> 0x003f }
            int r0 = r4.f15695c     // Catch:{ all -> 0x003f }
            r4.c((int) r0)     // Catch:{ all -> 0x003f }
            boolean r0 = r4.f15706n     // Catch:{ all -> 0x003f }
            if (r0 != 0) goto L_0x003d
            if (r5 == 0) goto L_0x003d
            com.umeng.message.proguard.bx$e r5 = r4.f15704l     // Catch:{ all -> 0x003f }
            if (r5 == 0) goto L_0x003d
            r5.c()     // Catch:{ all -> 0x003f }
        L_0x003d:
            monitor-exit(r4)
            return
        L_0x003f:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ all -> 0x0045 }
        L_0x0043:
            monitor-exit(r4)
            return
        L_0x0045:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.cv.c(boolean):void");
    }

    public final synchronized void c(int i10) {
        long j10 = this.f15709q;
        if (j10 >= 0) {
            this.f15701i += ((long) i10) - j10;
        }
        this.f15709q = -1;
    }
}
