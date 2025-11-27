package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.a;
import android.support.v4.media.session.b;
import android.util.Log;
import androidx.media.AudioAttributesCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import o.o;

public final class MediaControllerCompat {

    /* renamed from: a  reason: collision with root package name */
    public final b f344a;

    /* renamed from: b  reason: collision with root package name */
    public final MediaSessionCompat.Token f345b;

    /* renamed from: c  reason: collision with root package name */
    public final ConcurrentHashMap f346c = new ConcurrentHashMap();

    public static class MediaControllerImplApi21 implements b {

        /* renamed from: a  reason: collision with root package name */
        public final MediaController f347a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f348b = new Object();

        /* renamed from: c  reason: collision with root package name */
        public final List f349c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        public HashMap f350d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        public final MediaSessionCompat.Token f351e;

        public static class ExtraBinderRequestResultReceiver extends ResultReceiver {

            /* renamed from: a  reason: collision with root package name */
            public WeakReference f352a;

            public ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21) {
                super((Handler) null);
                this.f352a = new WeakReference(mediaControllerImplApi21);
            }

            public void onReceiveResult(int i10, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = (MediaControllerImplApi21) this.f352a.get();
                if (mediaControllerImplApi21 != null && bundle != null) {
                    synchronized (mediaControllerImplApi21.f348b) {
                        mediaControllerImplApi21.f351e.d(b.a.i0(o.a(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                        mediaControllerImplApi21.f351e.e(y0.a.b(bundle, "android.support.v4.media.session.SESSION_TOKEN2"));
                        mediaControllerImplApi21.f();
                    }
                }
            }
        }

        public static class a extends a.c {
            public a(a aVar) {
                super(aVar);
            }

            public void G(ParcelableVolumeInfo parcelableVolumeInfo) {
                throw new AssertionError();
            }

            public void P(Bundle bundle) {
                throw new AssertionError();
            }

            public void W(CharSequence charSequence) {
                throw new AssertionError();
            }

            public void l(List list) {
                throw new AssertionError();
            }

            public void t() {
                throw new AssertionError();
            }

            public void v(MediaMetadataCompat mediaMetadataCompat) {
                throw new AssertionError();
            }
        }

        public MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) {
            this.f351e = token;
            this.f347a = new MediaController(context, n.a(token.c()));
            if (token.a() == null) {
                g();
            }
        }

        public final void a(a aVar) {
            this.f347a.unregisterCallback(aVar.f353a);
            synchronized (this.f348b) {
                if (this.f351e.a() != null) {
                    try {
                        a aVar2 = (a) this.f350d.remove(aVar);
                        if (aVar2 != null) {
                            aVar.f355c = null;
                            this.f351e.a().R(aVar2);
                        }
                    } catch (RemoteException e10) {
                        Log.e("MediaControllerCompat", "Dead object in unregisterCallback.", e10);
                    }
                } else {
                    this.f349c.remove(aVar);
                }
            }
        }

        public PendingIntent b() {
            return this.f347a.getSessionActivity();
        }

        public e c() {
            return new f(this.f347a.getTransportControls());
        }

        public final void d(a aVar, Handler handler) {
            this.f347a.registerCallback(aVar.f353a, handler);
            synchronized (this.f348b) {
                if (this.f351e.a() != null) {
                    a aVar2 = new a(aVar);
                    this.f350d.put(aVar, aVar2);
                    aVar.f355c = aVar2;
                    try {
                        this.f351e.a().H(aVar2);
                        aVar.m(13, (Object) null, (Bundle) null);
                    } catch (RemoteException e10) {
                        Log.e("MediaControllerCompat", "Dead object in registerCallback.", e10);
                    }
                } else {
                    aVar.f355c = null;
                    this.f349c.add(aVar);
                }
            }
        }

        public PlaybackStateCompat e() {
            if (this.f351e.a() != null) {
                try {
                    return this.f351e.a().e();
                } catch (RemoteException e10) {
                    Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", e10);
                }
            }
            PlaybackState a10 = this.f347a.getPlaybackState();
            if (a10 != null) {
                return PlaybackStateCompat.a(a10);
            }
            return null;
        }

        public void f() {
            if (this.f351e.a() != null) {
                for (a aVar : this.f349c) {
                    a aVar2 = new a(aVar);
                    this.f350d.put(aVar, aVar2);
                    aVar.f355c = aVar2;
                    try {
                        this.f351e.a().H(aVar2);
                        aVar.m(13, (Object) null, (Bundle) null);
                    } catch (RemoteException e10) {
                        Log.e("MediaControllerCompat", "Dead object in registerCallback.", e10);
                    }
                }
                this.f349c.clear();
            }
        }

        public final void g() {
            h("android.support.v4.media.session.command.GET_EXTRA_BINDER", (Bundle) null, new ExtraBinderRequestResultReceiver(this));
        }

        public MediaMetadataCompat getMetadata() {
            MediaMetadata a10 = this.f347a.getMetadata();
            if (a10 != null) {
                return MediaMetadataCompat.b(a10);
            }
            return null;
        }

        public void h(String str, Bundle bundle, ResultReceiver resultReceiver) {
            this.f347a.sendCommand(str, bundle, resultReceiver);
        }
    }

    public static abstract class a implements IBinder.DeathRecipient {

        /* renamed from: a  reason: collision with root package name */
        public final MediaController.Callback f353a;

        /* renamed from: b  reason: collision with root package name */
        public b f354b;

        /* renamed from: c  reason: collision with root package name */
        public a f355c;

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$a$a  reason: collision with other inner class name */
        public static class C0005a extends MediaController.Callback {

            /* renamed from: a  reason: collision with root package name */
            public final WeakReference f356a;

            public C0005a(a aVar) {
                this.f356a = new WeakReference(aVar);
            }

            public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
                a aVar = (a) this.f356a.get();
                if (aVar != null) {
                    aVar.a(new d(playbackInfo.getPlaybackType(), AudioAttributesCompat.c(playbackInfo.getAudioAttributes()), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume()));
                }
            }

            public void onExtrasChanged(Bundle bundle) {
                MediaSessionCompat.c(bundle);
                a aVar = (a) this.f356a.get();
                if (aVar != null) {
                    aVar.c(bundle);
                }
            }

            public void onMetadataChanged(MediaMetadata mediaMetadata) {
                a aVar = (a) this.f356a.get();
                if (aVar != null) {
                    aVar.d(MediaMetadataCompat.b(mediaMetadata));
                }
            }

            public void onPlaybackStateChanged(PlaybackState playbackState) {
                a aVar = (a) this.f356a.get();
                if (aVar != null && aVar.f355c == null) {
                    aVar.e(PlaybackStateCompat.a(playbackState));
                }
            }

            public void onQueueChanged(List list) {
                a aVar = (a) this.f356a.get();
                if (aVar != null) {
                    aVar.f(MediaSessionCompat.QueueItem.b(list));
                }
            }

            public void onQueueTitleChanged(CharSequence charSequence) {
                a aVar = (a) this.f356a.get();
                if (aVar != null) {
                    aVar.g(charSequence);
                }
            }

            public void onSessionDestroyed() {
                a aVar = (a) this.f356a.get();
                if (aVar != null) {
                    aVar.i();
                }
            }

            public void onSessionEvent(String str, Bundle bundle) {
                MediaSessionCompat.c(bundle);
                a aVar = (a) this.f356a.get();
                if (aVar == null) {
                    return;
                }
                if (aVar.f355c == null || Build.VERSION.SDK_INT >= 23) {
                    aVar.j(str, bundle);
                }
            }
        }

        public class b extends Handler {

            /* renamed from: a  reason: collision with root package name */
            public boolean f357a = false;

            public b(Looper looper) {
                super(looper);
            }

            public void handleMessage(Message message) {
                if (this.f357a) {
                    switch (message.what) {
                        case 1:
                            Bundle data = message.getData();
                            MediaSessionCompat.c(data);
                            a.this.j((String) message.obj, data);
                            return;
                        case 2:
                            a.this.e((PlaybackStateCompat) message.obj);
                            return;
                        case 3:
                            a.this.d((MediaMetadataCompat) message.obj);
                            return;
                        case 4:
                            a.this.a((d) message.obj);
                            return;
                        case 5:
                            a.this.f((List) message.obj);
                            return;
                        case 6:
                            a.this.g((CharSequence) message.obj);
                            return;
                        case 7:
                            Bundle bundle = (Bundle) message.obj;
                            MediaSessionCompat.c(bundle);
                            a.this.c(bundle);
                            return;
                        case 8:
                            a.this.i();
                            return;
                        case 9:
                            a.this.h(((Integer) message.obj).intValue());
                            return;
                        case 11:
                            a.this.b(((Boolean) message.obj).booleanValue());
                            return;
                        case 12:
                            a.this.l(((Integer) message.obj).intValue());
                            return;
                        case 13:
                            a.this.k();
                            return;
                        default:
                            return;
                    }
                }
            }
        }

        public static class c extends a.C0007a {

            /* renamed from: a  reason: collision with root package name */
            public final WeakReference f359a;

            public c(a aVar) {
                this.f359a = new WeakReference(aVar);
            }

            public void G(ParcelableVolumeInfo parcelableVolumeInfo) {
                d dVar;
                a aVar = (a) this.f359a.get();
                if (aVar != null) {
                    if (parcelableVolumeInfo != null) {
                        dVar = new d(parcelableVolumeInfo.f434a, parcelableVolumeInfo.f435b, parcelableVolumeInfo.f436c, parcelableVolumeInfo.f437d, parcelableVolumeInfo.f438e);
                    } else {
                        dVar = null;
                    }
                    aVar.m(4, dVar, (Bundle) null);
                }
            }

            public void P(Bundle bundle) {
                a aVar = (a) this.f359a.get();
                if (aVar != null) {
                    aVar.m(7, bundle, (Bundle) null);
                }
            }

            public void T(boolean z10) {
                a aVar = (a) this.f359a.get();
                if (aVar != null) {
                    aVar.m(11, Boolean.valueOf(z10), (Bundle) null);
                }
            }

            public void V(boolean z10) {
            }

            public void W(CharSequence charSequence) {
                a aVar = (a) this.f359a.get();
                if (aVar != null) {
                    aVar.m(6, charSequence, (Bundle) null);
                }
            }

            public void Z(int i10) {
                a aVar = (a) this.f359a.get();
                if (aVar != null) {
                    aVar.m(9, Integer.valueOf(i10), (Bundle) null);
                }
            }

            public void h0(PlaybackStateCompat playbackStateCompat) {
                a aVar = (a) this.f359a.get();
                if (aVar != null) {
                    aVar.m(2, playbackStateCompat, (Bundle) null);
                }
            }

            public void k() {
                a aVar = (a) this.f359a.get();
                if (aVar != null) {
                    aVar.m(13, (Object) null, (Bundle) null);
                }
            }

            public void l(List list) {
                a aVar = (a) this.f359a.get();
                if (aVar != null) {
                    aVar.m(5, list, (Bundle) null);
                }
            }

            public void onEvent(String str, Bundle bundle) {
                a aVar = (a) this.f359a.get();
                if (aVar != null) {
                    aVar.m(1, str, bundle);
                }
            }

            public void t() {
                a aVar = (a) this.f359a.get();
                if (aVar != null) {
                    aVar.m(8, (Object) null, (Bundle) null);
                }
            }

            public void v(MediaMetadataCompat mediaMetadataCompat) {
                a aVar = (a) this.f359a.get();
                if (aVar != null) {
                    aVar.m(3, mediaMetadataCompat, (Bundle) null);
                }
            }

            public void z(int i10) {
                a aVar = (a) this.f359a.get();
                if (aVar != null) {
                    aVar.m(12, Integer.valueOf(i10), (Bundle) null);
                }
            }
        }

        public a() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.f353a = new C0005a(this);
                return;
            }
            this.f353a = null;
            this.f355c = new c(this);
        }

        public void a(d dVar) {
        }

        public void b(boolean z10) {
        }

        public void binderDied() {
            m(8, (Object) null, (Bundle) null);
        }

        public void c(Bundle bundle) {
        }

        public abstract void d(MediaMetadataCompat mediaMetadataCompat);

        public void e(PlaybackStateCompat playbackStateCompat) {
        }

        public void f(List list) {
        }

        public void g(CharSequence charSequence) {
        }

        public void h(int i10) {
        }

        public abstract void i();

        public void j(String str, Bundle bundle) {
        }

        public void k() {
        }

        public void l(int i10) {
        }

        public void m(int i10, Object obj, Bundle bundle) {
            b bVar = this.f354b;
            if (bVar != null) {
                Message obtainMessage = bVar.obtainMessage(i10, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }

        public void n(Handler handler) {
            if (handler == null) {
                b bVar = this.f354b;
                if (bVar != null) {
                    bVar.f357a = false;
                    bVar.removeCallbacksAndMessages((Object) null);
                    this.f354b = null;
                    return;
                }
                return;
            }
            b bVar2 = new b(handler.getLooper());
            this.f354b = bVar2;
            bVar2.f357a = true;
        }
    }

    public interface b {
        void a(a aVar);

        PendingIntent b();

        e c();

        void d(a aVar, Handler handler);

        PlaybackStateCompat e();

        MediaMetadataCompat getMetadata();
    }

    public static class c implements b {

        /* renamed from: a  reason: collision with root package name */
        public b f360a;

        /* renamed from: b  reason: collision with root package name */
        public e f361b;

        public c(MediaSessionCompat.Token token) {
            this.f360a = b.a.i0((IBinder) token.c());
        }

        public void a(a aVar) {
            if (aVar != null) {
                try {
                    this.f360a.R(aVar.f355c);
                    this.f360a.asBinder().unlinkToDeath(aVar, 0);
                } catch (RemoteException e10) {
                    Log.e("MediaControllerCompat", "Dead object in unregisterCallback.", e10);
                }
            } else {
                throw new IllegalArgumentException("callback may not be null.");
            }
        }

        public PendingIntent b() {
            try {
                return this.f360a.i();
            } catch (RemoteException e10) {
                Log.e("MediaControllerCompat", "Dead object in getSessionActivity.", e10);
                return null;
            }
        }

        public e c() {
            if (this.f361b == null) {
                this.f361b = new g(this.f360a);
            }
            return this.f361b;
        }

        public void d(a aVar, Handler handler) {
            if (aVar != null) {
                try {
                    this.f360a.asBinder().linkToDeath(aVar, 0);
                    this.f360a.H(aVar.f355c);
                    aVar.m(13, (Object) null, (Bundle) null);
                } catch (RemoteException e10) {
                    Log.e("MediaControllerCompat", "Dead object in registerCallback.", e10);
                    aVar.m(8, (Object) null, (Bundle) null);
                }
            } else {
                throw new IllegalArgumentException("callback may not be null.");
            }
        }

        public PlaybackStateCompat e() {
            try {
                return this.f360a.e();
            } catch (RemoteException e10) {
                Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", e10);
                return null;
            }
        }

        public MediaMetadataCompat getMetadata() {
            try {
                return this.f360a.getMetadata();
            } catch (RemoteException e10) {
                Log.e("MediaControllerCompat", "Dead object in getMetadata.", e10);
                return null;
            }
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final int f362a;

        /* renamed from: b  reason: collision with root package name */
        public final AudioAttributesCompat f363b;

        /* renamed from: c  reason: collision with root package name */
        public final int f364c;

        /* renamed from: d  reason: collision with root package name */
        public final int f365d;

        /* renamed from: e  reason: collision with root package name */
        public final int f366e;

        public d(int i10, int i11, int i12, int i13, int i14) {
            this(i10, new AudioAttributesCompat.a().b(i11).a(), i12, i13, i14);
        }

        public d(int i10, AudioAttributesCompat audioAttributesCompat, int i11, int i12, int i13) {
            this.f362a = i10;
            this.f363b = audioAttributesCompat;
            this.f364c = i11;
            this.f365d = i12;
            this.f366e = i13;
        }
    }

    public static abstract class e {
        public abstract void a();

        public abstract void b();

        public abstract void c();
    }

    public static class f extends e {

        /* renamed from: a  reason: collision with root package name */
        public final MediaController.TransportControls f367a;

        public f(MediaController.TransportControls transportControls) {
            this.f367a = transportControls;
        }

        public void a() {
            this.f367a.pause();
        }

        public void b() {
            this.f367a.play();
        }

        public void c() {
            this.f367a.stop();
        }
    }

    public static class g extends e {

        /* renamed from: a  reason: collision with root package name */
        public b f368a;

        public g(b bVar) {
            this.f368a = bVar;
        }

        public void a() {
            try {
                this.f368a.pause();
            } catch (RemoteException e10) {
                Log.e("MediaControllerCompat", "Dead object in pause.", e10);
            }
        }

        public void b() {
            try {
                this.f368a.a0();
            } catch (RemoteException e10) {
                Log.e("MediaControllerCompat", "Dead object in play.", e10);
            }
        }

        public void c() {
            try {
                this.f368a.stop();
            } catch (RemoteException e10) {
                Log.e("MediaControllerCompat", "Dead object in stop.", e10);
            }
        }
    }

    public MediaControllerCompat(Context context, MediaSessionCompat mediaSessionCompat) {
        if (mediaSessionCompat != null) {
            MediaSessionCompat.Token f10 = mediaSessionCompat.f();
            this.f345b = f10;
            if (Build.VERSION.SDK_INT >= 21) {
                this.f344a = new MediaControllerImplApi21(context, f10);
            } else {
                this.f344a = new c(f10);
            }
        } else {
            throw new IllegalArgumentException("session must not be null");
        }
    }

    public MediaMetadataCompat a() {
        return this.f344a.getMetadata();
    }

    public PlaybackStateCompat b() {
        return this.f344a.e();
    }

    public PendingIntent c() {
        return this.f344a.b();
    }

    public e d() {
        return this.f344a.c();
    }

    public void e(a aVar) {
        f(aVar, (Handler) null);
    }

    public void f(a aVar, Handler handler) {
        if (aVar == null) {
            throw new IllegalArgumentException("callback must not be null");
        } else if (this.f346c.putIfAbsent(aVar, Boolean.TRUE) == null) {
            if (handler == null) {
                handler = new Handler();
            }
            aVar.n(handler);
            this.f344a.d(aVar, handler);
        }
    }

    public void g(a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("callback must not be null");
        } else if (this.f346c.remove(aVar) != null) {
            try {
                this.f344a.a(aVar);
            } finally {
                aVar.n((Handler) null);
            }
        }
    }

    public MediaControllerCompat(Context context, MediaSessionCompat.Token token) {
        if (token != null) {
            this.f345b = token;
            if (Build.VERSION.SDK_INT >= 21) {
                this.f344a = new MediaControllerImplApi21(context, token);
            } else {
                this.f344a = new c(token);
            }
        } else {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
    }
}
