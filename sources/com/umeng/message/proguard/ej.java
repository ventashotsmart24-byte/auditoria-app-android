package com.umeng.message.proguard;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public final class ej extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: a  reason: collision with root package name */
    public cv f15923a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f15924b;

    public ej(Context context) {
        super(context);
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        holder.setFormat(-3);
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ce.a("SurfaceView", "onAttachedToWindow");
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ce.a("SurfaceView", "onDetachedFromWindow");
    }

    public final void setVideoPlayer(cv cvVar) {
        this.f15923a = cvVar;
        if (cvVar != null) {
            cvVar.f15694b = getHolder();
        }
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
        ce.a("SurfaceView", "surfaceChanged format:" + i10 + " width:" + i11 + " height:" + i12);
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        ce.a("SurfaceView", "surfaceCreated");
        if (this.f15924b) {
            this.f15924b = true;
            cv cvVar = this.f15923a;
            if (cvVar != null) {
                cvVar.c();
                return;
            }
            return;
        }
        cv cvVar2 = this.f15923a;
        if (cvVar2 != null) {
            cvVar2.a();
        }
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        ce.a("SurfaceView", "surfaceDestroyed playing:", Boolean.valueOf(this.f15924b));
        cv cvVar = this.f15923a;
        if (cvVar != null) {
            boolean d10 = cvVar.d();
            this.f15924b = d10;
            this.f15923a.a(d10);
        }
    }
}
