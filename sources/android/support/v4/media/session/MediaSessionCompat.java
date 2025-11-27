package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.RemoteControlClient;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.media.session.b;
import android.support.v4.media.u;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k0.l;

public class MediaSessionCompat {

    /* renamed from: d  reason: collision with root package name */
    public static int f369d;

    /* renamed from: a  reason: collision with root package name */
    public final c f370a;

    /* renamed from: b  reason: collision with root package name */
    public final MediaControllerCompat f371b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f372c;

    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public ResultReceiver f376a;

        public class a implements Parcelable.Creator {
            /* renamed from: a */
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            /* renamed from: b */
            public ResultReceiverWrapper[] newArray(int i10) {
                return new ResultReceiverWrapper[i10];
            }
        }

        public ResultReceiverWrapper(Parcel parcel) {
            this.f376a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            this.f376a.writeToParcel(parcel, i10);
        }
    }

    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public final Object f377a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f378b;

        /* renamed from: c  reason: collision with root package name */
        public b f379c;

        /* renamed from: d  reason: collision with root package name */
        public y0.d f380d;

        public class a implements Parcelable.Creator {
            /* renamed from: a */
            public Token createFromParcel(Parcel parcel) {
                Object obj;
                if (Build.VERSION.SDK_INT >= 21) {
                    obj = parcel.readParcelable((ClassLoader) null);
                } else {
                    obj = parcel.readStrongBinder();
                }
                return new Token(obj);
            }

            /* renamed from: b */
            public Token[] newArray(int i10) {
                return new Token[i10];
            }
        }

        public Token(Object obj) {
            this(obj, (b) null, (y0.d) null);
        }

        public b a() {
            b bVar;
            synchronized (this.f377a) {
                bVar = this.f379c;
            }
            return bVar;
        }

        public y0.d b() {
            y0.d dVar;
            synchronized (this.f377a) {
                dVar = this.f380d;
            }
            return dVar;
        }

        public Object c() {
            return this.f378b;
        }

        public void d(b bVar) {
            synchronized (this.f377a) {
                this.f379c = bVar;
            }
        }

        public int describeContents() {
            return 0;
        }

        public void e(y0.d dVar) {
            synchronized (this.f377a) {
                this.f380d = dVar;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            Object obj2 = this.f378b;
            if (obj2 != null) {
                Object obj3 = token.f378b;
                if (obj3 == null) {
                    return false;
                }
                return obj2.equals(obj3);
            } else if (token.f378b == null) {
                return true;
            } else {
                return false;
            }
        }

        public int hashCode() {
            Object obj = this.f378b;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public void writeToParcel(Parcel parcel, int i10) {
            if (Build.VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.f378b, i10);
            } else {
                parcel.writeStrongBinder((IBinder) this.f378b);
            }
        }

        public Token(Object obj, b bVar, y0.d dVar) {
            this.f377a = new Object();
            this.f378b = obj;
            this.f379c = bVar;
            this.f380d = dVar;
        }
    }

    public class a extends b {
        public a() {
        }
    }

    public static abstract class b {
        final MediaSession.Callback mCallbackFwk;
        a mCallbackHandler;
        final Object mLock = new Object();
        private boolean mMediaPlayPausePendingOnHandler;
        WeakReference<c> mSessionImpl;

        public class a extends Handler {
            public a(Looper looper) {
                super(looper);
            }

            public void handleMessage(Message message) {
                c cVar;
                b bVar;
                a aVar;
                if (message.what == 1) {
                    synchronized (b.this.mLock) {
                        cVar = b.this.mSessionImpl.get();
                        bVar = b.this;
                        aVar = bVar.mCallbackHandler;
                    }
                    if (cVar != null && bVar == cVar.k() && aVar != null) {
                        cVar.d((k0.d) message.obj);
                        b.this.handleMediaPlayPauseIfPendingOnHandler(cVar, aVar);
                        cVar.d((k0.d) null);
                    }
                }
            }
        }

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$b$b  reason: collision with other inner class name */
        public class C0006b extends MediaSession.Callback {
            public C0006b() {
            }

            public final void a(c cVar) {
                cVar.d((k0.d) null);
            }

            public final f b() {
                f fVar;
                synchronized (b.this.mLock) {
                    fVar = (f) b.this.mSessionImpl.get();
                }
                if (b.this == fVar.k()) {
                    return fVar;
                }
                return null;
            }

            public final void c(c cVar) {
                if (Build.VERSION.SDK_INT < 28) {
                    String h10 = cVar.h();
                    if (TextUtils.isEmpty(h10)) {
                        h10 = "android.media.session.MediaController";
                    }
                    cVar.d(new k0.d(h10, -1, -1));
                }
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: android.support.v4.media.session.MediaSessionCompat$QueueItem} */
            /* JADX WARNING: type inference failed for: r2v0 */
            /* JADX WARNING: type inference failed for: r2v4, types: [android.os.IBinder] */
            /* JADX WARNING: type inference failed for: r2v6 */
            /* JADX WARNING: type inference failed for: r2v7 */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onCommand(java.lang.String r6, android.os.Bundle r7, android.os.ResultReceiver r8) {
                /*
                    r5 = this;
                    android.support.v4.media.session.MediaSessionCompat$f r0 = r5.b()
                    if (r0 != 0) goto L_0x0007
                    return
                L_0x0007:
                    android.support.v4.media.session.MediaSessionCompat.c(r7)
                    r5.c(r0)
                    java.lang.String r1 = "android.support.v4.media.session.command.GET_EXTRA_BINDER"
                    boolean r1 = r6.equals(r1)     // Catch:{ BadParcelableException -> 0x00b8 }
                    r2 = 0
                    if (r1 == 0) goto L_0x003e
                    android.os.Bundle r6 = new android.os.Bundle     // Catch:{ BadParcelableException -> 0x00b8 }
                    r6.<init>()     // Catch:{ BadParcelableException -> 0x00b8 }
                    android.support.v4.media.session.MediaSessionCompat$Token r7 = r0.g()     // Catch:{ BadParcelableException -> 0x00b8 }
                    android.support.v4.media.session.b r1 = r7.a()     // Catch:{ BadParcelableException -> 0x00b8 }
                    java.lang.String r3 = "android.support.v4.media.session.EXTRA_BINDER"
                    if (r1 != 0) goto L_0x0028
                    goto L_0x002c
                L_0x0028:
                    android.os.IBinder r2 = r1.asBinder()     // Catch:{ BadParcelableException -> 0x00b8 }
                L_0x002c:
                    o.o.b(r6, r3, r2)     // Catch:{ BadParcelableException -> 0x00b8 }
                    java.lang.String r1 = "android.support.v4.media.session.SESSION_TOKEN2"
                    y0.d r7 = r7.b()     // Catch:{ BadParcelableException -> 0x00b8 }
                    y0.a.c(r6, r1, r7)     // Catch:{ BadParcelableException -> 0x00b8 }
                    r7 = 0
                    r8.send(r7, r6)     // Catch:{ BadParcelableException -> 0x00b8 }
                    goto L_0x00bf
                L_0x003e:
                    java.lang.String r1 = "android.support.v4.media.session.command.ADD_QUEUE_ITEM"
                    boolean r1 = r6.equals(r1)     // Catch:{ BadParcelableException -> 0x00b8 }
                    java.lang.String r3 = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"
                    if (r1 == 0) goto L_0x0054
                    android.support.v4.media.session.MediaSessionCompat$b r6 = android.support.v4.media.session.MediaSessionCompat.b.this     // Catch:{ BadParcelableException -> 0x00b8 }
                    android.os.Parcelable r7 = r7.getParcelable(r3)     // Catch:{ BadParcelableException -> 0x00b8 }
                    android.support.v4.media.MediaDescriptionCompat r7 = (android.support.v4.media.MediaDescriptionCompat) r7     // Catch:{ BadParcelableException -> 0x00b8 }
                    r6.onAddQueueItem(r7)     // Catch:{ BadParcelableException -> 0x00b8 }
                    goto L_0x00bf
                L_0x0054:
                    java.lang.String r1 = "android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT"
                    boolean r1 = r6.equals(r1)     // Catch:{ BadParcelableException -> 0x00b8 }
                    java.lang.String r4 = "android.support.v4.media.session.command.ARGUMENT_INDEX"
                    if (r1 == 0) goto L_0x006e
                    android.support.v4.media.session.MediaSessionCompat$b r6 = android.support.v4.media.session.MediaSessionCompat.b.this     // Catch:{ BadParcelableException -> 0x00b8 }
                    android.os.Parcelable r8 = r7.getParcelable(r3)     // Catch:{ BadParcelableException -> 0x00b8 }
                    android.support.v4.media.MediaDescriptionCompat r8 = (android.support.v4.media.MediaDescriptionCompat) r8     // Catch:{ BadParcelableException -> 0x00b8 }
                    int r7 = r7.getInt(r4)     // Catch:{ BadParcelableException -> 0x00b8 }
                    r6.onAddQueueItem(r8, r7)     // Catch:{ BadParcelableException -> 0x00b8 }
                    goto L_0x00bf
                L_0x006e:
                    java.lang.String r1 = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM"
                    boolean r1 = r6.equals(r1)     // Catch:{ BadParcelableException -> 0x00b8 }
                    if (r1 == 0) goto L_0x0082
                    android.support.v4.media.session.MediaSessionCompat$b r6 = android.support.v4.media.session.MediaSessionCompat.b.this     // Catch:{ BadParcelableException -> 0x00b8 }
                    android.os.Parcelable r7 = r7.getParcelable(r3)     // Catch:{ BadParcelableException -> 0x00b8 }
                    android.support.v4.media.MediaDescriptionCompat r7 = (android.support.v4.media.MediaDescriptionCompat) r7     // Catch:{ BadParcelableException -> 0x00b8 }
                    r6.onRemoveQueueItem(r7)     // Catch:{ BadParcelableException -> 0x00b8 }
                    goto L_0x00bf
                L_0x0082:
                    java.lang.String r1 = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT"
                    boolean r1 = r6.equals(r1)     // Catch:{ BadParcelableException -> 0x00b8 }
                    if (r1 == 0) goto L_0x00b2
                    java.util.List r6 = r0.f393h     // Catch:{ BadParcelableException -> 0x00b8 }
                    if (r6 == 0) goto L_0x00bf
                    r6 = -1
                    int r6 = r7.getInt(r4, r6)     // Catch:{ BadParcelableException -> 0x00b8 }
                    if (r6 < 0) goto L_0x00a6
                    java.util.List r7 = r0.f393h     // Catch:{ BadParcelableException -> 0x00b8 }
                    int r7 = r7.size()     // Catch:{ BadParcelableException -> 0x00b8 }
                    if (r6 >= r7) goto L_0x00a6
                    java.util.List r7 = r0.f393h     // Catch:{ BadParcelableException -> 0x00b8 }
                    java.lang.Object r6 = r7.get(r6)     // Catch:{ BadParcelableException -> 0x00b8 }
                    r2 = r6
                    android.support.v4.media.session.MediaSessionCompat$QueueItem r2 = (android.support.v4.media.session.MediaSessionCompat.QueueItem) r2     // Catch:{ BadParcelableException -> 0x00b8 }
                L_0x00a6:
                    if (r2 == 0) goto L_0x00bf
                    android.support.v4.media.session.MediaSessionCompat$b r6 = android.support.v4.media.session.MediaSessionCompat.b.this     // Catch:{ BadParcelableException -> 0x00b8 }
                    android.support.v4.media.MediaDescriptionCompat r7 = r2.c()     // Catch:{ BadParcelableException -> 0x00b8 }
                    r6.onRemoveQueueItem(r7)     // Catch:{ BadParcelableException -> 0x00b8 }
                    goto L_0x00bf
                L_0x00b2:
                    android.support.v4.media.session.MediaSessionCompat$b r1 = android.support.v4.media.session.MediaSessionCompat.b.this     // Catch:{ BadParcelableException -> 0x00b8 }
                    r1.onCommand(r6, r7, r8)     // Catch:{ BadParcelableException -> 0x00b8 }
                    goto L_0x00bf
                L_0x00b8:
                    java.lang.String r6 = "MediaSessionCompat"
                    java.lang.String r7 = "Could not unparcel the extra data."
                    android.util.Log.e(r6, r7)
                L_0x00bf:
                    r5.a(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.b.C0006b.onCommand(java.lang.String, android.os.Bundle, android.os.ResultReceiver):void");
            }

            public void onCustomAction(String str, Bundle bundle) {
                f b10 = b();
                if (b10 != null) {
                    MediaSessionCompat.c(bundle);
                    c(b10);
                    try {
                        if (str.equals("android.support.v4.media.session.action.PLAY_FROM_URI")) {
                            Bundle bundle2 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                            MediaSessionCompat.c(bundle2);
                            b.this.onPlayFromUri((Uri) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI"), bundle2);
                        } else if (str.equals("android.support.v4.media.session.action.PREPARE")) {
                            b.this.onPrepare();
                        } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID")) {
                            String string = bundle.getString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID");
                            Bundle bundle3 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                            MediaSessionCompat.c(bundle3);
                            b.this.onPrepareFromMediaId(string, bundle3);
                        } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_SEARCH")) {
                            String string2 = bundle.getString("android.support.v4.media.session.action.ARGUMENT_QUERY");
                            Bundle bundle4 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                            MediaSessionCompat.c(bundle4);
                            b.this.onPrepareFromSearch(string2, bundle4);
                        } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_URI")) {
                            Bundle bundle5 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                            MediaSessionCompat.c(bundle5);
                            b.this.onPrepareFromUri((Uri) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI"), bundle5);
                        } else if (str.equals("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED")) {
                            b.this.onSetCaptioningEnabled(bundle.getBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED"));
                        } else if (str.equals("android.support.v4.media.session.action.SET_REPEAT_MODE")) {
                            b.this.onSetRepeatMode(bundle.getInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE"));
                        } else if (str.equals("android.support.v4.media.session.action.SET_SHUFFLE_MODE")) {
                            b.this.onSetShuffleMode(bundle.getInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE"));
                        } else if (str.equals("android.support.v4.media.session.action.SET_RATING")) {
                            Bundle bundle6 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                            MediaSessionCompat.c(bundle6);
                            b.this.onSetRating((RatingCompat) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_RATING"), bundle6);
                        } else if (str.equals("android.support.v4.media.session.action.SET_PLAYBACK_SPEED")) {
                            b.this.onSetPlaybackSpeed(bundle.getFloat("android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED", 1.0f));
                        } else {
                            b.this.onCustomAction(str, bundle);
                        }
                    } catch (BadParcelableException unused) {
                        Log.e("MediaSessionCompat", "Could not unparcel the data.");
                    }
                    a(b10);
                }
            }

            public void onFastForward() {
                f b10 = b();
                if (b10 != null) {
                    c(b10);
                    b.this.onFastForward();
                    a(b10);
                }
            }

            public boolean onMediaButtonEvent(Intent intent) {
                f b10 = b();
                if (b10 == null) {
                    return false;
                }
                c(b10);
                boolean onMediaButtonEvent = b.this.onMediaButtonEvent(intent);
                a(b10);
                if (onMediaButtonEvent || super.onMediaButtonEvent(intent)) {
                    return true;
                }
                return false;
            }

            public void onPause() {
                f b10 = b();
                if (b10 != null) {
                    c(b10);
                    b.this.onPause();
                    a(b10);
                }
            }

            public void onPlay() {
                f b10 = b();
                if (b10 != null) {
                    c(b10);
                    b.this.onPlay();
                    a(b10);
                }
            }

            public void onPlayFromMediaId(String str, Bundle bundle) {
                f b10 = b();
                if (b10 != null) {
                    MediaSessionCompat.c(bundle);
                    c(b10);
                    b.this.onPlayFromMediaId(str, bundle);
                    a(b10);
                }
            }

            public void onPlayFromSearch(String str, Bundle bundle) {
                f b10 = b();
                if (b10 != null) {
                    MediaSessionCompat.c(bundle);
                    c(b10);
                    b.this.onPlayFromSearch(str, bundle);
                    a(b10);
                }
            }

            public void onPlayFromUri(Uri uri, Bundle bundle) {
                f b10 = b();
                if (b10 != null) {
                    MediaSessionCompat.c(bundle);
                    c(b10);
                    b.this.onPlayFromUri(uri, bundle);
                    a(b10);
                }
            }

            public void onPrepare() {
                f b10 = b();
                if (b10 != null) {
                    c(b10);
                    b.this.onPrepare();
                    a(b10);
                }
            }

            public void onPrepareFromMediaId(String str, Bundle bundle) {
                f b10 = b();
                if (b10 != null) {
                    MediaSessionCompat.c(bundle);
                    c(b10);
                    b.this.onPrepareFromMediaId(str, bundle);
                    a(b10);
                }
            }

            public void onPrepareFromSearch(String str, Bundle bundle) {
                f b10 = b();
                if (b10 != null) {
                    MediaSessionCompat.c(bundle);
                    c(b10);
                    b.this.onPrepareFromSearch(str, bundle);
                    a(b10);
                }
            }

            public void onPrepareFromUri(Uri uri, Bundle bundle) {
                f b10 = b();
                if (b10 != null) {
                    MediaSessionCompat.c(bundle);
                    c(b10);
                    b.this.onPrepareFromUri(uri, bundle);
                    a(b10);
                }
            }

            public void onRewind() {
                f b10 = b();
                if (b10 != null) {
                    c(b10);
                    b.this.onRewind();
                    a(b10);
                }
            }

            public void onSeekTo(long j10) {
                f b10 = b();
                if (b10 != null) {
                    c(b10);
                    b.this.onSeekTo(j10);
                    a(b10);
                }
            }

            public void onSetPlaybackSpeed(float f10) {
                f b10 = b();
                if (b10 != null) {
                    c(b10);
                    b.this.onSetPlaybackSpeed(f10);
                    a(b10);
                }
            }

            public void onSetRating(Rating rating) {
                f b10 = b();
                if (b10 != null) {
                    c(b10);
                    b.this.onSetRating(RatingCompat.a(rating));
                    a(b10);
                }
            }

            public void onSkipToNext() {
                f b10 = b();
                if (b10 != null) {
                    c(b10);
                    b.this.onSkipToNext();
                    a(b10);
                }
            }

            public void onSkipToPrevious() {
                f b10 = b();
                if (b10 != null) {
                    c(b10);
                    b.this.onSkipToPrevious();
                    a(b10);
                }
            }

            public void onSkipToQueueItem(long j10) {
                f b10 = b();
                if (b10 != null) {
                    c(b10);
                    b.this.onSkipToQueueItem(j10);
                    a(b10);
                }
            }

            public void onStop() {
                f b10 = b();
                if (b10 != null) {
                    c(b10);
                    b.this.onStop();
                    a(b10);
                }
            }
        }

        public b() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.mCallbackFwk = new C0006b();
            } else {
                this.mCallbackFwk = null;
            }
            this.mSessionImpl = new WeakReference<>((Object) null);
        }

        public void handleMediaPlayPauseIfPendingOnHandler(c cVar, Handler handler) {
            long j10;
            boolean z10;
            boolean z11;
            if (this.mMediaPlayPausePendingOnHandler) {
                boolean z12 = false;
                this.mMediaPlayPausePendingOnHandler = false;
                handler.removeMessages(1);
                PlaybackStateCompat e10 = cVar.e();
                if (e10 == null) {
                    j10 = 0;
                } else {
                    j10 = e10.b();
                }
                if (e10 == null || e10.g() != 3) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if ((516 & j10) != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if ((j10 & 514) != 0) {
                    z12 = true;
                }
                if (z10 && z12) {
                    onPause();
                } else if (!z10 && z11) {
                    onPlay();
                }
            }
        }

        public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        }

        public void onCustomAction(String str, Bundle bundle) {
        }

        public void onFastForward() {
        }

        public boolean onMediaButtonEvent(Intent intent) {
            c cVar;
            a aVar;
            KeyEvent keyEvent;
            long j10;
            if (Build.VERSION.SDK_INT >= 27) {
                return false;
            }
            synchronized (this.mLock) {
                cVar = this.mSessionImpl.get();
                aVar = this.mCallbackHandler;
            }
            if (cVar == null || aVar == null || (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) == null || keyEvent.getAction() != 0) {
                return false;
            }
            k0.d o10 = cVar.o();
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 79 || keyCode == 85) {
                if (keyEvent.getRepeatCount() != 0) {
                    handleMediaPlayPauseIfPendingOnHandler(cVar, aVar);
                } else if (this.mMediaPlayPausePendingOnHandler) {
                    aVar.removeMessages(1);
                    this.mMediaPlayPausePendingOnHandler = false;
                    PlaybackStateCompat e10 = cVar.e();
                    if (e10 == null) {
                        j10 = 0;
                    } else {
                        j10 = e10.b();
                    }
                    if ((j10 & 32) != 0) {
                        onSkipToNext();
                    }
                } else {
                    this.mMediaPlayPausePendingOnHandler = true;
                    aVar.sendMessageDelayed(aVar.obtainMessage(1, o10), (long) ViewConfiguration.getDoubleTapTimeout());
                }
                return true;
            }
            handleMediaPlayPauseIfPendingOnHandler(cVar, aVar);
            return false;
        }

        public void onPause() {
        }

        public void onPlay() {
        }

        public void onPlayFromMediaId(String str, Bundle bundle) {
        }

        public void onPlayFromSearch(String str, Bundle bundle) {
        }

        public void onPlayFromUri(Uri uri, Bundle bundle) {
        }

        public void onPrepare() {
        }

        public void onPrepareFromMediaId(String str, Bundle bundle) {
        }

        public void onPrepareFromSearch(String str, Bundle bundle) {
        }

        public void onPrepareFromUri(Uri uri, Bundle bundle) {
        }

        public void onRemoveQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        @Deprecated
        public void onRemoveQueueItemAt(int i10) {
        }

        public void onRewind() {
        }

        public void onSeekTo(long j10) {
        }

        public void onSetCaptioningEnabled(boolean z10) {
        }

        public void onSetPlaybackSpeed(float f10) {
        }

        public void onSetRating(RatingCompat ratingCompat) {
        }

        public void onSetRepeatMode(int i10) {
        }

        public void onSetShuffleMode(int i10) {
        }

        public void onSkipToNext() {
        }

        public void onSkipToPrevious() {
        }

        public void onSkipToQueueItem(long j10) {
        }

        public void onStop() {
        }

        public void setSessionImpl(c cVar, Handler handler) {
            synchronized (this.mLock) {
                this.mSessionImpl = new WeakReference<>(cVar);
                a aVar = this.mCallbackHandler;
                a aVar2 = null;
                if (aVar != null) {
                    aVar.removeCallbacksAndMessages((Object) null);
                }
                if (cVar != null) {
                    if (handler != null) {
                        aVar2 = new a(handler.getLooper());
                    }
                }
                this.mCallbackHandler = aVar2;
            }
        }

        public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i10) {
        }

        public void onSetRating(RatingCompat ratingCompat, Bundle bundle) {
        }
    }

    public interface c {
        void a(l lVar);

        void b(b bVar, Handler handler);

        void c(MediaMetadataCompat mediaMetadataCompat);

        void d(k0.d dVar);

        PlaybackStateCompat e();

        void f(PlaybackStateCompat playbackStateCompat);

        Token g();

        String h();

        void i(PendingIntent pendingIntent);

        boolean isActive();

        void j(int i10);

        b k();

        void l(PendingIntent pendingIntent);

        Object m();

        void n(boolean z10);

        k0.d o();

        void release();
    }

    public static class d extends i {
        public static boolean G = true;

        public class a implements RemoteControlClient.OnPlaybackPositionUpdateListener {
            public a() {
            }

            public void onPlaybackPositionUpdate(long j10) {
                d.this.u(18, -1, -1, Long.valueOf(j10), (Bundle) null);
            }
        }

        public d(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, y0.d dVar, Bundle bundle) {
            super(context, str, componentName, pendingIntent, dVar, bundle);
        }

        public void A(PlaybackStateCompat playbackStateCompat) {
            long f10 = playbackStateCompat.f();
            float d10 = playbackStateCompat.d();
            long c10 = playbackStateCompat.c();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (playbackStateCompat.g() == 3) {
                long j10 = 0;
                if (f10 > 0) {
                    if (c10 > 0) {
                        j10 = elapsedRealtime - c10;
                        if (d10 > 0.0f && d10 != 1.0f) {
                            j10 = (long) (((float) j10) * d10);
                        }
                    }
                    f10 += j10;
                }
            }
            this.f411j.setPlaybackState(s(playbackStateCompat.g()), f10, d10);
        }

        public void C(PendingIntent pendingIntent, ComponentName componentName) {
            if (G) {
                this.f410i.unregisterMediaButtonEventReceiver(pendingIntent);
            } else {
                super.C(pendingIntent, componentName);
            }
        }

        public void b(b bVar, Handler handler) {
            super.b(bVar, handler);
            if (bVar == null) {
                this.f411j.setPlaybackPositionUpdateListener((RemoteControlClient.OnPlaybackPositionUpdateListener) null);
                return;
            }
            this.f411j.setPlaybackPositionUpdateListener(new a());
        }

        public int t(long j10) {
            int t10 = super.t(j10);
            if ((j10 & 256) != 0) {
                return t10 | 256;
            }
            return t10;
        }

        public void v(PendingIntent pendingIntent, ComponentName componentName) {
            if (G) {
                try {
                    this.f410i.registerMediaButtonEventReceiver(pendingIntent);
                } catch (NullPointerException unused) {
                    G = false;
                }
            }
            if (!G) {
                super.v(pendingIntent, componentName);
            }
        }
    }

    public static class e extends d {

        public class a implements RemoteControlClient.OnMetadataUpdateListener {
            public a() {
            }

            public void onMetadataUpdate(int i10, Object obj) {
                if (i10 == 268435457 && (obj instanceof Rating)) {
                    e.this.u(19, -1, -1, RatingCompat.a(obj), (Bundle) null);
                }
            }
        }

        public e(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, y0.d dVar, Bundle bundle) {
            super(context, str, componentName, pendingIntent, dVar, bundle);
        }

        public void b(b bVar, Handler handler) {
            super.b(bVar, handler);
            if (bVar == null) {
                this.f411j.setMetadataUpdateListener((RemoteControlClient.OnMetadataUpdateListener) null);
                return;
            }
            this.f411j.setMetadataUpdateListener(new a());
        }

        public RemoteControlClient.MetadataEditor q(Bundle bundle) {
            long j10;
            RemoteControlClient.MetadataEditor q10 = super.q(bundle);
            PlaybackStateCompat playbackStateCompat = this.f421t;
            if (playbackStateCompat == null) {
                j10 = 0;
            } else {
                j10 = playbackStateCompat.b();
            }
            if ((j10 & 128) != 0) {
                q10.addEditableKey(268435457);
            }
            if (bundle == null) {
                return q10;
            }
            if (bundle.containsKey("android.media.metadata.YEAR")) {
                q10.putLong(8, bundle.getLong("android.media.metadata.YEAR"));
            }
            if (bundle.containsKey("android.media.metadata.RATING")) {
                q10.putObject(101, bundle.getParcelable("android.media.metadata.RATING"));
            }
            if (bundle.containsKey("android.media.metadata.USER_RATING")) {
                q10.putObject(268435457, bundle.getParcelable("android.media.metadata.USER_RATING"));
            }
            return q10;
        }

        public int t(long j10) {
            int t10 = super.t(j10);
            if ((j10 & 128) != 0) {
                return t10 | 512;
            }
            return t10;
        }
    }

    public static class f implements c {

        /* renamed from: a  reason: collision with root package name */
        public final MediaSession f386a;

        /* renamed from: b  reason: collision with root package name */
        public final Token f387b;

        /* renamed from: c  reason: collision with root package name */
        public final Object f388c = new Object();

        /* renamed from: d  reason: collision with root package name */
        public Bundle f389d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f390e = false;

        /* renamed from: f  reason: collision with root package name */
        public final RemoteCallbackList f391f = new RemoteCallbackList();

        /* renamed from: g  reason: collision with root package name */
        public PlaybackStateCompat f392g;

        /* renamed from: h  reason: collision with root package name */
        public List f393h;

        /* renamed from: i  reason: collision with root package name */
        public MediaMetadataCompat f394i;

        /* renamed from: j  reason: collision with root package name */
        public int f395j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f396k;

        /* renamed from: l  reason: collision with root package name */
        public int f397l;

        /* renamed from: m  reason: collision with root package name */
        public int f398m;

        /* renamed from: n  reason: collision with root package name */
        public b f399n;

        /* renamed from: o  reason: collision with root package name */
        public k0.d f400o;

        public class a extends b.a {
            public a() {
            }

            public void A(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                throw new AssertionError();
            }

            public void B() {
                throw new AssertionError();
            }

            public void C(long j10) {
                throw new AssertionError();
            }

            public void D(boolean z10) {
            }

            public void E(int i10) {
                throw new AssertionError();
            }

            public String F() {
                throw new AssertionError();
            }

            public void H(a aVar) {
                if (!f.this.f390e) {
                    f.this.f391f.register(aVar, new k0.d("android.media.session.MediaController", Binder.getCallingPid(), Binder.getCallingUid()));
                }
            }

            public void I(RatingCompat ratingCompat) {
                throw new AssertionError();
            }

            public void J(int i10, int i11, String str) {
                throw new AssertionError();
            }

            public void K(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            public boolean L() {
                throw new AssertionError();
            }

            public void M(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            public void N(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public void O() {
                throw new AssertionError();
            }

            public CharSequence Q() {
                throw new AssertionError();
            }

            public void R(a aVar) {
                f.this.f391f.unregister(aVar);
            }

            public void S() {
                throw new AssertionError();
            }

            public void U(float f10) {
                throw new AssertionError();
            }

            public void X(int i10, int i11, String str) {
                throw new AssertionError();
            }

            public void Y(boolean z10) {
                throw new AssertionError();
            }

            public void a0() {
                throw new AssertionError();
            }

            public List b0() {
                return null;
            }

            public void c0(int i10) {
                throw new AssertionError();
            }

            public long d0() {
                throw new AssertionError();
            }

            public PlaybackStateCompat e() {
                f fVar = f.this;
                return MediaSessionCompat.g(fVar.f392g, fVar.f394i);
            }

            public int e0() {
                return f.this.f397l;
            }

            public void f(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public ParcelableVolumeInfo f0() {
                throw new AssertionError();
            }

            public boolean g() {
                return false;
            }

            public Bundle getExtras() {
                throw new AssertionError();
            }

            public MediaMetadataCompat getMetadata() {
                throw new AssertionError();
            }

            public String getTag() {
                throw new AssertionError();
            }

            public void h(Uri uri, Bundle bundle) {
                throw new AssertionError();
            }

            public PendingIntent i() {
                throw new AssertionError();
            }

            public int j() {
                return f.this.f395j;
            }

            public void m(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public Bundle n() {
                if (f.this.f389d == null) {
                    return null;
                }
                return new Bundle(f.this.f389d);
            }

            public void next() {
                throw new AssertionError();
            }

            public void o(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public void p(String str, Bundle bundle) {
                throw new AssertionError();
            }

            public void pause() {
                throw new AssertionError();
            }

            public void previous() {
                throw new AssertionError();
            }

            public void q(Uri uri, Bundle bundle) {
                throw new AssertionError();
            }

            public boolean r(KeyEvent keyEvent) {
                throw new AssertionError();
            }

            public void s(RatingCompat ratingCompat, Bundle bundle) {
                throw new AssertionError();
            }

            public void seekTo(long j10) {
                throw new AssertionError();
            }

            public void stop() {
                throw new AssertionError();
            }

            public void u(MediaDescriptionCompat mediaDescriptionCompat, int i10) {
                throw new AssertionError();
            }

            public int w() {
                return f.this.f398m;
            }

            public void x(int i10) {
                throw new AssertionError();
            }

            public boolean y() {
                return f.this.f396k;
            }
        }

        public f(MediaSession mediaSession, y0.d dVar, Bundle bundle) {
            this.f386a = mediaSession;
            this.f387b = new Token(mediaSession.getSessionToken(), new a(), dVar);
            this.f389d = bundle;
            p(3);
        }

        public void a(l lVar) {
            this.f386a.setPlaybackToRemote(a0.a(lVar.d()));
        }

        public void b(b bVar, Handler handler) {
            MediaSession.Callback callback;
            synchronized (this.f388c) {
                this.f399n = bVar;
                MediaSession mediaSession = this.f386a;
                if (bVar == null) {
                    callback = null;
                } else {
                    callback = bVar.mCallbackFwk;
                }
                mediaSession.setCallback(callback, handler);
                if (bVar != null) {
                    bVar.setSessionImpl(this, handler);
                }
            }
        }

        public void c(MediaMetadataCompat mediaMetadataCompat) {
            MediaMetadata mediaMetadata;
            this.f394i = mediaMetadataCompat;
            MediaSession mediaSession = this.f386a;
            if (mediaMetadataCompat == null) {
                mediaMetadata = null;
            } else {
                mediaMetadata = u.a(mediaMetadataCompat.g());
            }
            mediaSession.setMetadata(mediaMetadata);
        }

        public void d(k0.d dVar) {
            synchronized (this.f388c) {
                this.f400o = dVar;
            }
        }

        public PlaybackStateCompat e() {
            return this.f392g;
        }

        public void f(PlaybackStateCompat playbackStateCompat) {
            PlaybackState playbackState;
            this.f392g = playbackStateCompat;
            for (int beginBroadcast = this.f391f.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((a) this.f391f.getBroadcastItem(beginBroadcast)).h0(playbackStateCompat);
                } catch (RemoteException unused) {
                }
            }
            this.f391f.finishBroadcast();
            MediaSession mediaSession = this.f386a;
            if (playbackStateCompat == null) {
                playbackState = null;
            } else {
                playbackState = u.a(playbackStateCompat.e());
            }
            mediaSession.setPlaybackState(playbackState);
        }

        public Token g() {
            return this.f387b;
        }

        public String h() {
            if (Build.VERSION.SDK_INT < 24) {
                return null;
            }
            try {
                return (String) this.f386a.getClass().getMethod("getCallingPackage", new Class[0]).invoke(this.f386a, new Object[0]);
            } catch (Exception e10) {
                Log.e("MediaSessionCompat", "Cannot execute MediaSession.getCallingPackage()", e10);
                return null;
            }
        }

        public void i(PendingIntent pendingIntent) {
            this.f386a.setSessionActivity(pendingIntent);
        }

        public boolean isActive() {
            return this.f386a.isActive();
        }

        public void j(int i10) {
            AudioAttributes.Builder builder = new AudioAttributes.Builder();
            AudioAttributes.Builder unused = builder.setLegacyStreamType(i10);
            this.f386a.setPlaybackToLocal(builder.build());
        }

        public b k() {
            b bVar;
            synchronized (this.f388c) {
                bVar = this.f399n;
            }
            return bVar;
        }

        public void l(PendingIntent pendingIntent) {
            this.f386a.setMediaButtonReceiver(pendingIntent);
        }

        public Object m() {
            return null;
        }

        public void n(boolean z10) {
            this.f386a.setActive(z10);
        }

        public k0.d o() {
            k0.d dVar;
            synchronized (this.f388c) {
                dVar = this.f400o;
            }
            return dVar;
        }

        public void p(int i10) {
            this.f386a.setFlags(i10 | 1 | 2);
        }

        public void release() {
            this.f390e = true;
            this.f391f.kill();
            this.f386a.setCallback((MediaSession.Callback) null);
            this.f386a.release();
        }
    }

    public static class g extends f {
        public g(MediaSession mediaSession, y0.d dVar, Bundle bundle) {
            super(mediaSession, dVar, bundle);
        }

        public void d(k0.d dVar) {
        }

        public final k0.d o() {
            return new k0.d(this.f386a.getCurrentControllerInfo());
        }
    }

    public static class h extends g {
        public h(MediaSession mediaSession, y0.d dVar, Bundle bundle) {
            super(mediaSession, dVar, bundle);
        }
    }

    public static class i implements c {
        public int A;
        public Bundle B;
        public int C;
        public int D;
        public l E;
        public l.c F = new a();

        /* renamed from: a  reason: collision with root package name */
        public final Context f402a;

        /* renamed from: b  reason: collision with root package name */
        public final ComponentName f403b;

        /* renamed from: c  reason: collision with root package name */
        public final PendingIntent f404c;

        /* renamed from: d  reason: collision with root package name */
        public final c f405d;

        /* renamed from: e  reason: collision with root package name */
        public final Token f406e;

        /* renamed from: f  reason: collision with root package name */
        public final String f407f;

        /* renamed from: g  reason: collision with root package name */
        public final Bundle f408g;

        /* renamed from: h  reason: collision with root package name */
        public final String f409h;

        /* renamed from: i  reason: collision with root package name */
        public final AudioManager f410i;

        /* renamed from: j  reason: collision with root package name */
        public final RemoteControlClient f411j;

        /* renamed from: k  reason: collision with root package name */
        public final Object f412k = new Object();

        /* renamed from: l  reason: collision with root package name */
        public final RemoteCallbackList f413l = new RemoteCallbackList();

        /* renamed from: m  reason: collision with root package name */
        public d f414m;

        /* renamed from: n  reason: collision with root package name */
        public boolean f415n = false;

        /* renamed from: o  reason: collision with root package name */
        public boolean f416o = false;

        /* renamed from: p  reason: collision with root package name */
        public volatile b f417p;

        /* renamed from: q  reason: collision with root package name */
        public k0.d f418q;

        /* renamed from: r  reason: collision with root package name */
        public int f419r = 3;

        /* renamed from: s  reason: collision with root package name */
        public MediaMetadataCompat f420s;

        /* renamed from: t  reason: collision with root package name */
        public PlaybackStateCompat f421t;

        /* renamed from: u  reason: collision with root package name */
        public PendingIntent f422u;

        /* renamed from: v  reason: collision with root package name */
        public List f423v;

        /* renamed from: w  reason: collision with root package name */
        public CharSequence f424w;

        /* renamed from: x  reason: collision with root package name */
        public int f425x;

        /* renamed from: y  reason: collision with root package name */
        public boolean f426y;

        /* renamed from: z  reason: collision with root package name */
        public int f427z;

        public class a extends l.c {
            public a() {
            }

            public void a(l lVar) {
                if (i.this.E == lVar) {
                    i iVar = i.this;
                    i.this.z(new ParcelableVolumeInfo(iVar.C, iVar.D, lVar.c(), lVar.b(), lVar.a()));
                }
            }
        }

        public static final class b {

            /* renamed from: a  reason: collision with root package name */
            public final String f429a;

            /* renamed from: b  reason: collision with root package name */
            public final Bundle f430b;

            /* renamed from: c  reason: collision with root package name */
            public final ResultReceiver f431c;

            public b(String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.f429a = str;
                this.f430b = bundle;
                this.f431c = resultReceiver;
            }
        }

        public class c extends b.a {
            public c() {
            }

            public void A(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                ResultReceiver resultReceiver;
                if (resultReceiverWrapper == null) {
                    resultReceiver = null;
                } else {
                    resultReceiver = resultReceiverWrapper.f376a;
                }
                m0(1, new b(str, bundle, resultReceiver));
            }

            public void B() {
                k0(17);
            }

            public void C(long j10) {
                m0(11, Long.valueOf(j10));
            }

            public void D(boolean z10) {
            }

            public void E(int i10) {
                l0(30, i10);
            }

            public String F() {
                return i.this.f407f;
            }

            public void H(a aVar) {
                if (i.this.f415n) {
                    try {
                        aVar.t();
                    } catch (Exception unused) {
                    }
                } else {
                    i.this.f413l.register(aVar, new k0.d(i.this.r(Binder.getCallingUid()), Binder.getCallingPid(), Binder.getCallingUid()));
                }
            }

            public void I(RatingCompat ratingCompat) {
                m0(19, ratingCompat);
            }

            public void J(int i10, int i11, String str) {
                i.this.B(i10, i11);
            }

            public void K(MediaDescriptionCompat mediaDescriptionCompat) {
                m0(27, mediaDescriptionCompat);
            }

            public boolean L() {
                return true;
            }

            public void M(MediaDescriptionCompat mediaDescriptionCompat) {
                m0(25, mediaDescriptionCompat);
            }

            public void N(String str, Bundle bundle) {
                o0(5, str, bundle);
            }

            public void O() {
                k0(3);
            }

            public CharSequence Q() {
                return i.this.f424w;
            }

            public void R(a aVar) {
                i.this.f413l.unregister(aVar);
            }

            public void S() {
                k0(16);
            }

            public void U(float f10) {
                m0(32, Float.valueOf(f10));
            }

            public void X(int i10, int i11, String str) {
                i.this.p(i10, i11);
            }

            public void Y(boolean z10) {
                m0(29, Boolean.valueOf(z10));
            }

            public void a0() {
                k0(7);
            }

            public List b0() {
                List list;
                synchronized (i.this.f412k) {
                    list = i.this.f423v;
                }
                return list;
            }

            public void c0(int i10) {
                l0(23, i10);
            }

            public long d0() {
                long j10;
                synchronized (i.this.f412k) {
                    j10 = (long) i.this.f419r;
                }
                return j10;
            }

            public PlaybackStateCompat e() {
                PlaybackStateCompat playbackStateCompat;
                MediaMetadataCompat mediaMetadataCompat;
                synchronized (i.this.f412k) {
                    i iVar = i.this;
                    playbackStateCompat = iVar.f421t;
                    mediaMetadataCompat = iVar.f420s;
                }
                return MediaSessionCompat.g(playbackStateCompat, mediaMetadataCompat);
            }

            public int e0() {
                return i.this.f427z;
            }

            public void f(String str, Bundle bundle) {
                o0(20, str, bundle);
            }

            public ParcelableVolumeInfo f0() {
                int i10;
                int i11;
                int i12;
                int i13;
                int i14;
                synchronized (i.this.f412k) {
                    i iVar = i.this;
                    i10 = iVar.C;
                    i11 = iVar.D;
                    l lVar = iVar.E;
                    i12 = 2;
                    if (i10 == 2) {
                        int c10 = lVar.c();
                        int b10 = lVar.b();
                        i13 = lVar.a();
                        i14 = b10;
                        i12 = c10;
                    } else {
                        i14 = iVar.f410i.getStreamMaxVolume(i11);
                        i13 = i.this.f410i.getStreamVolume(i11);
                    }
                }
                return new ParcelableVolumeInfo(i10, i11, i12, i14, i13);
            }

            public boolean g() {
                return false;
            }

            public Bundle getExtras() {
                Bundle bundle;
                synchronized (i.this.f412k) {
                    bundle = i.this.B;
                }
                return bundle;
            }

            public MediaMetadataCompat getMetadata() {
                return i.this.f420s;
            }

            public String getTag() {
                return i.this.f409h;
            }

            public void h(Uri uri, Bundle bundle) {
                o0(6, uri, bundle);
            }

            public PendingIntent i() {
                PendingIntent pendingIntent;
                synchronized (i.this.f412k) {
                    pendingIntent = i.this.f422u;
                }
                return pendingIntent;
            }

            public int j() {
                return i.this.f425x;
            }

            public void k0(int i10) {
                i.this.u(i10, 0, 0, (Object) null, (Bundle) null);
            }

            public void l0(int i10, int i11) {
                i.this.u(i10, i11, 0, (Object) null, (Bundle) null);
            }

            public void m(String str, Bundle bundle) {
                o0(4, str, bundle);
            }

            public void m0(int i10, Object obj) {
                i.this.u(i10, 0, 0, obj, (Bundle) null);
            }

            public Bundle n() {
                if (i.this.f408g == null) {
                    return null;
                }
                return new Bundle(i.this.f408g);
            }

            public void n0(int i10, Object obj, int i11) {
                i.this.u(i10, i11, 0, obj, (Bundle) null);
            }

            public void next() {
                k0(14);
            }

            public void o(String str, Bundle bundle) {
                o0(8, str, bundle);
            }

            public void o0(int i10, Object obj, Bundle bundle) {
                i.this.u(i10, 0, 0, obj, bundle);
            }

            public void p(String str, Bundle bundle) {
                o0(9, str, bundle);
            }

            public void pause() {
                k0(12);
            }

            public void previous() {
                k0(15);
            }

            public void q(Uri uri, Bundle bundle) {
                o0(10, uri, bundle);
            }

            public boolean r(KeyEvent keyEvent) {
                m0(21, keyEvent);
                return true;
            }

            public void s(RatingCompat ratingCompat, Bundle bundle) {
                o0(31, ratingCompat, bundle);
            }

            public void seekTo(long j10) {
                m0(18, Long.valueOf(j10));
            }

            public void stop() {
                k0(13);
            }

            public void u(MediaDescriptionCompat mediaDescriptionCompat, int i10) {
                n0(26, mediaDescriptionCompat, i10);
            }

            public int w() {
                return i.this.A;
            }

            public void x(int i10) {
                l0(28, i10);
            }

            public boolean y() {
                return i.this.f426y;
            }
        }

        public class d extends Handler {
            public d(Looper looper) {
                super(looper);
            }

            public final void a(KeyEvent keyEvent, b bVar) {
                long j10;
                if (keyEvent != null && keyEvent.getAction() == 0) {
                    PlaybackStateCompat playbackStateCompat = i.this.f421t;
                    if (playbackStateCompat == null) {
                        j10 = 0;
                    } else {
                        j10 = playbackStateCompat.b();
                    }
                    int keyCode = keyEvent.getKeyCode();
                    if (keyCode != 126) {
                        if (keyCode != 127) {
                            switch (keyCode) {
                                case 86:
                                    if ((j10 & 1) != 0) {
                                        bVar.onStop();
                                        return;
                                    }
                                    return;
                                case 87:
                                    if ((j10 & 32) != 0) {
                                        bVar.onSkipToNext();
                                        return;
                                    }
                                    return;
                                case 88:
                                    if ((j10 & 16) != 0) {
                                        bVar.onSkipToPrevious();
                                        return;
                                    }
                                    return;
                                case 89:
                                    if ((j10 & 8) != 0) {
                                        bVar.onRewind();
                                        return;
                                    }
                                    return;
                                case 90:
                                    if ((j10 & 64) != 0) {
                                        bVar.onFastForward();
                                        return;
                                    }
                                    return;
                                default:
                                    return;
                            }
                        } else if ((j10 & 2) != 0) {
                            bVar.onPause();
                        }
                    } else if ((j10 & 4) != 0) {
                        bVar.onPlay();
                    }
                }
            }

            public void handleMessage(Message message) {
                QueueItem queueItem;
                b bVar = i.this.f417p;
                if (bVar != null) {
                    Bundle data = message.getData();
                    MediaSessionCompat.c(data);
                    i.this.d(new k0.d(data.getString("data_calling_pkg"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid")));
                    Bundle bundle = data.getBundle("data_extras");
                    MediaSessionCompat.c(bundle);
                    try {
                        switch (message.what) {
                            case 1:
                                b bVar2 = (b) message.obj;
                                bVar.onCommand(bVar2.f429a, bVar2.f430b, bVar2.f431c);
                                break;
                            case 2:
                                i.this.p(message.arg1, 0);
                                break;
                            case 3:
                                bVar.onPrepare();
                                break;
                            case 4:
                                bVar.onPrepareFromMediaId((String) message.obj, bundle);
                                break;
                            case 5:
                                bVar.onPrepareFromSearch((String) message.obj, bundle);
                                break;
                            case 6:
                                bVar.onPrepareFromUri((Uri) message.obj, bundle);
                                break;
                            case 7:
                                bVar.onPlay();
                                break;
                            case 8:
                                bVar.onPlayFromMediaId((String) message.obj, bundle);
                                break;
                            case 9:
                                bVar.onPlayFromSearch((String) message.obj, bundle);
                                break;
                            case 10:
                                bVar.onPlayFromUri((Uri) message.obj, bundle);
                                break;
                            case 11:
                                bVar.onSkipToQueueItem(((Long) message.obj).longValue());
                                break;
                            case 12:
                                bVar.onPause();
                                break;
                            case 13:
                                bVar.onStop();
                                break;
                            case 14:
                                bVar.onSkipToNext();
                                break;
                            case 15:
                                bVar.onSkipToPrevious();
                                break;
                            case 16:
                                bVar.onFastForward();
                                break;
                            case 17:
                                bVar.onRewind();
                                break;
                            case 18:
                                bVar.onSeekTo(((Long) message.obj).longValue());
                                break;
                            case 19:
                                bVar.onSetRating((RatingCompat) message.obj);
                                break;
                            case 20:
                                bVar.onCustomAction((String) message.obj, bundle);
                                break;
                            case 21:
                                KeyEvent keyEvent = (KeyEvent) message.obj;
                                Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                                intent.putExtra("android.intent.extra.KEY_EVENT", keyEvent);
                                if (!bVar.onMediaButtonEvent(intent)) {
                                    a(keyEvent, bVar);
                                    break;
                                }
                                break;
                            case 22:
                                i.this.B(message.arg1, 0);
                                break;
                            case 23:
                                bVar.onSetRepeatMode(message.arg1);
                                break;
                            case 25:
                                bVar.onAddQueueItem((MediaDescriptionCompat) message.obj);
                                break;
                            case 26:
                                bVar.onAddQueueItem((MediaDescriptionCompat) message.obj, message.arg1);
                                break;
                            case 27:
                                bVar.onRemoveQueueItem((MediaDescriptionCompat) message.obj);
                                break;
                            case 28:
                                List list = i.this.f423v;
                                if (list != null) {
                                    int i10 = message.arg1;
                                    if (i10 < 0 || i10 >= list.size()) {
                                        queueItem = null;
                                    } else {
                                        queueItem = (QueueItem) i.this.f423v.get(message.arg1);
                                    }
                                    if (queueItem != null) {
                                        bVar.onRemoveQueueItem(queueItem.c());
                                        break;
                                    }
                                }
                                break;
                            case 29:
                                bVar.onSetCaptioningEnabled(((Boolean) message.obj).booleanValue());
                                break;
                            case 30:
                                bVar.onSetShuffleMode(message.arg1);
                                break;
                            case 31:
                                bVar.onSetRating((RatingCompat) message.obj, bundle);
                                break;
                            case 32:
                                bVar.onSetPlaybackSpeed(((Float) message.obj).floatValue());
                                break;
                        }
                    } finally {
                        i.this.d((k0.d) null);
                    }
                }
            }
        }

        public i(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, y0.d dVar, Bundle bundle) {
            if (componentName != null) {
                this.f402a = context;
                this.f407f = context.getPackageName();
                this.f408g = bundle;
                this.f410i = (AudioManager) context.getSystemService("audio");
                this.f409h = str;
                this.f403b = componentName;
                this.f404c = pendingIntent;
                c cVar = new c();
                this.f405d = cVar;
                this.f406e = new Token(cVar, (b) null, dVar);
                this.f425x = 0;
                this.C = 1;
                this.D = 3;
                this.f411j = new RemoteControlClient(pendingIntent);
                return;
            }
            throw new IllegalArgumentException("MediaButtonReceiver component may not be null");
        }

        public abstract void A(PlaybackStateCompat playbackStateCompat);

        public void B(int i10, int i11) {
            if (this.C == 2) {
                l lVar = this.E;
                if (lVar != null) {
                    lVar.f(i10);
                    return;
                }
                return;
            }
            this.f410i.setStreamVolume(this.D, i10, i11);
        }

        public void C(PendingIntent pendingIntent, ComponentName componentName) {
            this.f410i.unregisterMediaButtonEventReceiver(componentName);
        }

        public void D() {
            if (this.f416o) {
                v(this.f404c, this.f403b);
                this.f410i.registerRemoteControlClient(this.f411j);
                c(this.f420s);
                f(this.f421t);
                return;
            }
            C(this.f404c, this.f403b);
            this.f411j.setPlaybackState(0);
            this.f410i.unregisterRemoteControlClient(this.f411j);
        }

        public void a(l lVar) {
            if (lVar != null) {
                l lVar2 = this.E;
                if (lVar2 != null) {
                    lVar2.g((l.c) null);
                }
                this.C = 2;
                this.E = lVar;
                z(new ParcelableVolumeInfo(this.C, this.D, this.E.c(), this.E.b(), this.E.a()));
                lVar.g(this.F);
                return;
            }
            throw new IllegalArgumentException("volumeProvider may not be null");
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0030  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(android.support.v4.media.session.MediaSessionCompat.b r5, android.os.Handler r6) {
            /*
                r4 = this;
                java.lang.Object r0 = r4.f412k
                monitor-enter(r0)
                android.support.v4.media.session.MediaSessionCompat$i$d r1 = r4.f414m     // Catch:{ all -> 0x0037 }
                r2 = 0
                if (r1 == 0) goto L_0x000b
                r1.removeCallbacksAndMessages(r2)     // Catch:{ all -> 0x0037 }
            L_0x000b:
                if (r5 == 0) goto L_0x001a
                if (r6 != 0) goto L_0x0010
                goto L_0x001a
            L_0x0010:
                android.support.v4.media.session.MediaSessionCompat$i$d r1 = new android.support.v4.media.session.MediaSessionCompat$i$d     // Catch:{ all -> 0x0037 }
                android.os.Looper r3 = r6.getLooper()     // Catch:{ all -> 0x0037 }
                r1.<init>(r3)     // Catch:{ all -> 0x0037 }
                goto L_0x001b
            L_0x001a:
                r1 = r2
            L_0x001b:
                r4.f414m = r1     // Catch:{ all -> 0x0037 }
                android.support.v4.media.session.MediaSessionCompat$b r1 = r4.f417p     // Catch:{ all -> 0x0037 }
                if (r1 == r5) goto L_0x002a
                android.support.v4.media.session.MediaSessionCompat$b r1 = r4.f417p     // Catch:{ all -> 0x0037 }
                if (r1 == 0) goto L_0x002a
                android.support.v4.media.session.MediaSessionCompat$b r1 = r4.f417p     // Catch:{ all -> 0x0037 }
                r1.setSessionImpl(r2, r2)     // Catch:{ all -> 0x0037 }
            L_0x002a:
                r4.f417p = r5     // Catch:{ all -> 0x0037 }
                android.support.v4.media.session.MediaSessionCompat$b r5 = r4.f417p     // Catch:{ all -> 0x0037 }
                if (r5 == 0) goto L_0x0035
                android.support.v4.media.session.MediaSessionCompat$b r5 = r4.f417p     // Catch:{ all -> 0x0037 }
                r5.setSessionImpl(r4, r6)     // Catch:{ all -> 0x0037 }
            L_0x0035:
                monitor-exit(r0)     // Catch:{ all -> 0x0037 }
                return
            L_0x0037:
                r5 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0037 }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.MediaSessionCompat.i.b(android.support.v4.media.session.MediaSessionCompat$b, android.os.Handler):void");
        }

        public void c(MediaMetadataCompat mediaMetadataCompat) {
            Bundle bundle;
            if (mediaMetadataCompat != null) {
                mediaMetadataCompat = new MediaMetadataCompat.b(mediaMetadataCompat, MediaSessionCompat.f369d).a();
            }
            synchronized (this.f412k) {
                this.f420s = mediaMetadataCompat;
            }
            w(mediaMetadataCompat);
            if (this.f416o) {
                if (mediaMetadataCompat == null) {
                    bundle = null;
                } else {
                    bundle = mediaMetadataCompat.d();
                }
                q(bundle).apply();
            }
        }

        public void d(k0.d dVar) {
            synchronized (this.f412k) {
                this.f418q = dVar;
            }
        }

        public PlaybackStateCompat e() {
            PlaybackStateCompat playbackStateCompat;
            synchronized (this.f412k) {
                playbackStateCompat = this.f421t;
            }
            return playbackStateCompat;
        }

        public void f(PlaybackStateCompat playbackStateCompat) {
            synchronized (this.f412k) {
                this.f421t = playbackStateCompat;
            }
            y(playbackStateCompat);
            if (this.f416o) {
                if (playbackStateCompat == null) {
                    this.f411j.setPlaybackState(0);
                    this.f411j.setTransportControlFlags(0);
                    return;
                }
                A(playbackStateCompat);
                this.f411j.setTransportControlFlags(t(playbackStateCompat.b()));
            }
        }

        public Token g() {
            return this.f406e;
        }

        public String h() {
            return null;
        }

        public void i(PendingIntent pendingIntent) {
            synchronized (this.f412k) {
                this.f422u = pendingIntent;
            }
        }

        public boolean isActive() {
            return this.f416o;
        }

        public void j(int i10) {
            l lVar = this.E;
            if (lVar != null) {
                lVar.g((l.c) null);
            }
            this.D = i10;
            this.C = 1;
            int i11 = this.C;
            int i12 = this.D;
            z(new ParcelableVolumeInfo(i11, i12, 2, this.f410i.getStreamMaxVolume(i12), this.f410i.getStreamVolume(this.D)));
        }

        public b k() {
            b bVar;
            synchronized (this.f412k) {
                bVar = this.f417p;
            }
            return bVar;
        }

        public void l(PendingIntent pendingIntent) {
        }

        public Object m() {
            return null;
        }

        public void n(boolean z10) {
            if (z10 != this.f416o) {
                this.f416o = z10;
                D();
            }
        }

        public k0.d o() {
            k0.d dVar;
            synchronized (this.f412k) {
                dVar = this.f418q;
            }
            return dVar;
        }

        public void p(int i10, int i11) {
            if (this.C == 2) {
                l lVar = this.E;
                if (lVar != null) {
                    lVar.e(i10);
                    return;
                }
                return;
            }
            this.f410i.adjustStreamVolume(this.D, i10, i11);
        }

        public RemoteControlClient.MetadataEditor q(Bundle bundle) {
            RemoteControlClient.MetadataEditor editMetadata = this.f411j.editMetadata(true);
            if (bundle == null) {
                return editMetadata;
            }
            if (bundle.containsKey("android.media.metadata.ART")) {
                Bitmap bitmap = (Bitmap) bundle.getParcelable("android.media.metadata.ART");
                if (bitmap != null) {
                    bitmap = bitmap.copy(bitmap.getConfig(), false);
                }
                editMetadata.putBitmap(100, bitmap);
            } else if (bundle.containsKey("android.media.metadata.ALBUM_ART")) {
                Bitmap bitmap2 = (Bitmap) bundle.getParcelable("android.media.metadata.ALBUM_ART");
                if (bitmap2 != null) {
                    bitmap2 = bitmap2.copy(bitmap2.getConfig(), false);
                }
                editMetadata.putBitmap(100, bitmap2);
            }
            if (bundle.containsKey("android.media.metadata.ALBUM")) {
                editMetadata.putString(1, bundle.getString("android.media.metadata.ALBUM"));
            }
            if (bundle.containsKey("android.media.metadata.ALBUM_ARTIST")) {
                editMetadata.putString(13, bundle.getString("android.media.metadata.ALBUM_ARTIST"));
            }
            if (bundle.containsKey("android.media.metadata.ARTIST")) {
                editMetadata.putString(2, bundle.getString("android.media.metadata.ARTIST"));
            }
            if (bundle.containsKey("android.media.metadata.AUTHOR")) {
                editMetadata.putString(3, bundle.getString("android.media.metadata.AUTHOR"));
            }
            if (bundle.containsKey("android.media.metadata.COMPILATION")) {
                editMetadata.putString(15, bundle.getString("android.media.metadata.COMPILATION"));
            }
            if (bundle.containsKey("android.media.metadata.COMPOSER")) {
                editMetadata.putString(4, bundle.getString("android.media.metadata.COMPOSER"));
            }
            if (bundle.containsKey("android.media.metadata.DATE")) {
                editMetadata.putString(5, bundle.getString("android.media.metadata.DATE"));
            }
            if (bundle.containsKey("android.media.metadata.DISC_NUMBER")) {
                editMetadata.putLong(14, bundle.getLong("android.media.metadata.DISC_NUMBER"));
            }
            if (bundle.containsKey("android.media.metadata.DURATION")) {
                editMetadata.putLong(9, bundle.getLong("android.media.metadata.DURATION"));
            }
            if (bundle.containsKey("android.media.metadata.GENRE")) {
                editMetadata.putString(6, bundle.getString("android.media.metadata.GENRE"));
            }
            if (bundle.containsKey("android.media.metadata.TITLE")) {
                editMetadata.putString(7, bundle.getString("android.media.metadata.TITLE"));
            }
            if (bundle.containsKey("android.media.metadata.TRACK_NUMBER")) {
                editMetadata.putLong(0, bundle.getLong("android.media.metadata.TRACK_NUMBER"));
            }
            if (bundle.containsKey("android.media.metadata.WRITER")) {
                editMetadata.putString(11, bundle.getString("android.media.metadata.WRITER"));
            }
            return editMetadata;
        }

        public String r(int i10) {
            String nameForUid = this.f402a.getPackageManager().getNameForUid(i10);
            if (TextUtils.isEmpty(nameForUid)) {
                return "android.media.session.MediaController";
            }
            return nameForUid;
        }

        public void release() {
            this.f416o = false;
            this.f415n = true;
            D();
            x();
            b((b) null, (Handler) null);
        }

        public int s(int i10) {
            switch (i10) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                case 8:
                    return 8;
                case 7:
                    return 9;
                case 9:
                    return 7;
                case 10:
                case 11:
                    return 6;
                default:
                    return -1;
            }
        }

        public int t(long j10) {
            int i10 = (1 & j10) != 0 ? 32 : 0;
            if ((2 & j10) != 0) {
                i10 |= 16;
            }
            if ((4 & j10) != 0) {
                i10 |= 4;
            }
            if ((8 & j10) != 0) {
                i10 |= 2;
            }
            if ((16 & j10) != 0) {
                i10 |= 1;
            }
            if ((32 & j10) != 0) {
                i10 |= 128;
            }
            if ((64 & j10) != 0) {
                i10 |= 64;
            }
            return (j10 & 512) != 0 ? i10 | 8 : i10;
        }

        public void u(int i10, int i11, int i12, Object obj, Bundle bundle) {
            synchronized (this.f412k) {
                d dVar = this.f414m;
                if (dVar != null) {
                    Message obtainMessage = dVar.obtainMessage(i10, i11, i12, obj);
                    Bundle bundle2 = new Bundle();
                    int callingUid = Binder.getCallingUid();
                    bundle2.putInt("data_calling_uid", callingUid);
                    bundle2.putString("data_calling_pkg", r(callingUid));
                    int callingPid = Binder.getCallingPid();
                    if (callingPid > 0) {
                        bundle2.putInt("data_calling_pid", callingPid);
                    } else {
                        bundle2.putInt("data_calling_pid", -1);
                    }
                    if (bundle != null) {
                        bundle2.putBundle("data_extras", bundle);
                    }
                    obtainMessage.setData(bundle2);
                    obtainMessage.sendToTarget();
                }
            }
        }

        public void v(PendingIntent pendingIntent, ComponentName componentName) {
            this.f410i.registerMediaButtonEventReceiver(componentName);
        }

        public final void w(MediaMetadataCompat mediaMetadataCompat) {
            for (int beginBroadcast = this.f413l.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((a) this.f413l.getBroadcastItem(beginBroadcast)).v(mediaMetadataCompat);
                } catch (RemoteException unused) {
                }
            }
            this.f413l.finishBroadcast();
        }

        public final void x() {
            for (int beginBroadcast = this.f413l.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((a) this.f413l.getBroadcastItem(beginBroadcast)).t();
                } catch (RemoteException unused) {
                }
            }
            this.f413l.finishBroadcast();
            this.f413l.kill();
        }

        public final void y(PlaybackStateCompat playbackStateCompat) {
            for (int beginBroadcast = this.f413l.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((a) this.f413l.getBroadcastItem(beginBroadcast)).h0(playbackStateCompat);
                } catch (RemoteException unused) {
                }
            }
            this.f413l.finishBroadcast();
        }

        public void z(ParcelableVolumeInfo parcelableVolumeInfo) {
            for (int beginBroadcast = this.f413l.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((a) this.f413l.getBroadcastItem(beginBroadcast)).G(parcelableVolumeInfo);
                } catch (RemoteException unused) {
                }
            }
            this.f413l.finishBroadcast();
        }
    }

    public interface j {
        void a();
    }

    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent) {
        this(context, str, componentName, pendingIntent, (Bundle) null);
    }

    public static void c(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    public static PlaybackStateCompat g(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat) {
        long j10;
        if (playbackStateCompat == null) {
            return playbackStateCompat;
        }
        long j11 = -1;
        if (playbackStateCompat.f() == -1) {
            return playbackStateCompat;
        }
        if (playbackStateCompat.g() != 3 && playbackStateCompat.g() != 4 && playbackStateCompat.g() != 5) {
            return playbackStateCompat;
        }
        long c10 = playbackStateCompat.c();
        if (c10 <= 0) {
            return playbackStateCompat;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long d10 = ((long) (playbackStateCompat.d() * ((float) (elapsedRealtime - c10)))) + playbackStateCompat.f();
        if (mediaMetadataCompat != null && mediaMetadataCompat.a("android.media.metadata.DURATION")) {
            j11 = mediaMetadataCompat.f("android.media.metadata.DURATION");
        }
        if (j11 >= 0 && d10 > j11) {
            j10 = j11;
        } else if (d10 < 0) {
            j10 = 0;
        } else {
            j10 = d10;
        }
        return new PlaybackStateCompat.b(playbackStateCompat).d(playbackStateCompat.g(), j10, playbackStateCompat.d(), elapsedRealtime).a();
    }

    public static Bundle s(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        c(bundle);
        try {
            bundle.isEmpty();
            return bundle;
        } catch (BadParcelableException unused) {
            Log.e("MediaSessionCompat", "Could not unparcel the data.");
            return null;
        }
    }

    public void a(j jVar) {
        if (jVar != null) {
            this.f372c.add(jVar);
            return;
        }
        throw new IllegalArgumentException("Listener may not be null");
    }

    public final MediaSession b(Context context, String str, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 29) {
            return new MediaSession(context, str, bundle);
        }
        return new MediaSession(context, str);
    }

    public MediaControllerCompat d() {
        return this.f371b;
    }

    public Object e() {
        return this.f370a.m();
    }

    public Token f() {
        return this.f370a.g();
    }

    public boolean h() {
        return this.f370a.isActive();
    }

    public void i() {
        this.f370a.release();
    }

    public void j(j jVar) {
        if (jVar != null) {
            this.f372c.remove(jVar);
            return;
        }
        throw new IllegalArgumentException("Listener may not be null");
    }

    public void k(boolean z10) {
        this.f370a.n(z10);
        Iterator it = this.f372c.iterator();
        while (it.hasNext()) {
            ((j) it.next()).a();
        }
    }

    public void l(b bVar) {
        m(bVar, (Handler) null);
    }

    public void m(b bVar, Handler handler) {
        if (bVar == null) {
            this.f370a.b((b) null, (Handler) null);
            return;
        }
        c cVar = this.f370a;
        if (handler == null) {
            handler = new Handler();
        }
        cVar.b(bVar, handler);
    }

    public void n(MediaMetadataCompat mediaMetadataCompat) {
        this.f370a.c(mediaMetadataCompat);
    }

    public void o(PlaybackStateCompat playbackStateCompat) {
        this.f370a.f(playbackStateCompat);
    }

    public void p(int i10) {
        this.f370a.j(i10);
    }

    public void q(l lVar) {
        if (lVar != null) {
            this.f370a.a(lVar);
            return;
        }
        throw new IllegalArgumentException("volumeProvider may not be null!");
    }

    public void r(PendingIntent pendingIntent) {
        this.f370a.i(pendingIntent);
    }

    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, Bundle bundle) {
        this(context, str, componentName, pendingIntent, bundle, (y0.d) null);
    }

    public MediaSessionCompat(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, Bundle bundle, y0.d dVar) {
        this.f372c = new ArrayList();
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        } else if (!TextUtils.isEmpty(str)) {
            ComponentName a10 = componentName == null ? m0.a.a(context) : componentName;
            if (a10 != null && pendingIntent == null) {
                Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                intent.setComponent(a10);
                pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
            }
            PendingIntent pendingIntent2 = pendingIntent;
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 21) {
                MediaSession b10 = b(context, str, bundle);
                if (i10 >= 29) {
                    this.f370a = new h(b10, dVar, bundle);
                } else if (i10 >= 28) {
                    this.f370a = new g(b10, dVar, bundle);
                } else {
                    this.f370a = new f(b10, dVar, bundle);
                }
                m(new a(), new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()));
                this.f370a.l(pendingIntent2);
            } else {
                this.f370a = new e(context, str, a10, pendingIntent2, dVar, bundle);
            }
            this.f371b = new MediaControllerCompat(context, this);
            if (f369d == 0) {
                f369d = (int) (TypedValue.applyDimension(1, 320.0f, context.getResources().getDisplayMetrics()) + 0.5f);
            }
        } else {
            throw new IllegalArgumentException("tag must not be null or empty");
        }
    }

    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public final MediaDescriptionCompat f373a;

        /* renamed from: b  reason: collision with root package name */
        public final long f374b;

        /* renamed from: c  reason: collision with root package name */
        public MediaSession.QueueItem f375c;

        public class a implements Parcelable.Creator {
            /* renamed from: a */
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            /* renamed from: b */
            public QueueItem[] newArray(int i10) {
                return new QueueItem[i10];
            }
        }

        public QueueItem(MediaSession.QueueItem queueItem, MediaDescriptionCompat mediaDescriptionCompat, long j10) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null");
            } else if (j10 != -1) {
                this.f373a = mediaDescriptionCompat;
                this.f374b = j10;
                this.f375c = queueItem;
            } else {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
        }

        public static QueueItem a(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            MediaSession.QueueItem a10 = k0.a(obj);
            return new QueueItem(a10, MediaDescriptionCompat.a(a10.getDescription()), a10.getQueueId());
        }

        public static List b(List list) {
            if (list == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object a10 : list) {
                arrayList.add(a(a10));
            }
            return arrayList;
        }

        public MediaDescriptionCompat c() {
            return this.f373a;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f373a + ", Id=" + this.f374b + " }";
        }

        public void writeToParcel(Parcel parcel, int i10) {
            this.f373a.writeToParcel(parcel, i10);
            parcel.writeLong(this.f374b);
        }

        public QueueItem(Parcel parcel) {
            this.f373a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f374b = parcel.readLong();
        }
    }
}
