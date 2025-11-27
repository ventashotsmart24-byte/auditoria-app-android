package com.hpplay.sdk.source.b;

import com.hpplay.sdk.source.api.INewPlayerListener;
import com.hpplay.sdk.source.bean.CastBean;
import com.hpplay.sdk.source.log.SourceLog;
import java.util.ArrayList;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11576a = "CastManager";

    /* renamed from: b  reason: collision with root package name */
    private static a f11577b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final List<INewPlayerListener> f11578c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final INewPlayerListener f11579d = new INewPlayerListener() {
        public void onCompletion(CastBean castBean, int i10) {
            for (INewPlayerListener onCompletion : a.this.f11578c) {
                onCompletion.onCompletion(castBean, i10);
            }
        }

        public void onError(CastBean castBean, int i10, int i11) {
            SourceLog.i(a.f11576a, "onError what:" + i10 + " extra:" + i11);
            for (INewPlayerListener onError : a.this.f11578c) {
                onError.onError(castBean, i10, i11);
            }
        }

        public void onInfo(CastBean castBean, int i10, int i11) {
            for (INewPlayerListener onInfo : a.this.f11578c) {
                onInfo.onInfo(castBean, i10, i11);
            }
        }

        public void onLoading(CastBean castBean) {
            for (INewPlayerListener onLoading : a.this.f11578c) {
                onLoading.onLoading(castBean);
            }
        }

        public void onPause(CastBean castBean) {
            for (INewPlayerListener onPause : a.this.f11578c) {
                onPause.onPause(castBean);
            }
        }

        public void onPositionUpdate(CastBean castBean, long j10, long j11) {
            for (INewPlayerListener onPositionUpdate : a.this.f11578c) {
                onPositionUpdate.onPositionUpdate(castBean, j10, j11);
            }
        }

        public void onSeekComplete(CastBean castBean, int i10) {
            for (INewPlayerListener onSeekComplete : a.this.f11578c) {
                onSeekComplete.onSeekComplete(castBean, i10);
            }
        }

        public void onStart(CastBean castBean) {
            for (INewPlayerListener onStart : a.this.f11578c) {
                onStart.onStart(castBean);
            }
        }

        public void onStop(CastBean castBean) {
            for (INewPlayerListener onStop : a.this.f11578c) {
                onStop.onStop(castBean);
            }
        }

        public void onVolumeChanged(CastBean castBean, float f10) {
            for (INewPlayerListener onVolumeChanged : a.this.f11578c) {
                onVolumeChanged.onVolumeChanged(castBean, f10);
            }
        }

        public void onInfo(CastBean castBean, int i10, String str) {
            for (INewPlayerListener onInfo : a.this.f11578c) {
                onInfo.onInfo(castBean, i10, str);
            }
        }
    };

    private a() {
    }

    public INewPlayerListener b() {
        return this.f11579d;
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            synchronized (a.class) {
                if (f11577b == null) {
                    f11577b = new a();
                }
            }
            aVar = f11577b;
        }
        return aVar;
    }

    public void b(INewPlayerListener iNewPlayerListener) {
        this.f11578c.remove(iNewPlayerListener);
    }

    public void a(INewPlayerListener iNewPlayerListener) {
        this.f11578c.add(iNewPlayerListener);
    }
}
