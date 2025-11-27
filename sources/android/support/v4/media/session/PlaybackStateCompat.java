package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final int f439a;

    /* renamed from: b  reason: collision with root package name */
    public final long f440b;

    /* renamed from: c  reason: collision with root package name */
    public final long f441c;

    /* renamed from: d  reason: collision with root package name */
    public final float f442d;

    /* renamed from: e  reason: collision with root package name */
    public final long f443e;

    /* renamed from: f  reason: collision with root package name */
    public final int f444f;

    /* renamed from: g  reason: collision with root package name */
    public final CharSequence f445g;

    /* renamed from: h  reason: collision with root package name */
    public final long f446h;

    /* renamed from: i  reason: collision with root package name */
    public List f447i;

    /* renamed from: j  reason: collision with root package name */
    public final long f448j;

    /* renamed from: k  reason: collision with root package name */
    public final Bundle f449k;

    /* renamed from: l  reason: collision with root package name */
    public PlaybackState f450l;

    public class a implements Parcelable.Creator {
        /* renamed from: a */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        /* renamed from: b */
        public PlaybackStateCompat[] newArray(int i10) {
            return new PlaybackStateCompat[i10];
        }
    }

    public PlaybackStateCompat(int i10, long j10, long j11, float f10, long j12, int i11, CharSequence charSequence, long j13, List list, long j14, Bundle bundle) {
        this.f439a = i10;
        this.f440b = j10;
        this.f441c = j11;
        this.f442d = f10;
        this.f443e = j12;
        this.f444f = i11;
        this.f445g = charSequence;
        this.f446h = j13;
        this.f447i = new ArrayList(list);
        this.f448j = j14;
        this.f449k = bundle;
    }

    public static PlaybackStateCompat a(Object obj) {
        ArrayList arrayList;
        Bundle bundle = null;
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        PlaybackState a10 = u.a(obj);
        List<Object> a11 = a10.getCustomActions();
        if (a11 != null) {
            ArrayList arrayList2 = new ArrayList(a11.size());
            for (Object a12 : a11) {
                arrayList2.add(CustomAction.a(a12));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        if (Build.VERSION.SDK_INT >= 22) {
            bundle = a10.getExtras();
            MediaSessionCompat.c(bundle);
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(a10.getState(), a10.getPosition(), a10.getBufferedPosition(), a10.getPlaybackSpeed(), a10.getActions(), 0, a10.getErrorMessage(), a10.getLastPositionUpdateTime(), arrayList, a10.getActiveQueueItemId(), bundle);
        playbackStateCompat.f450l = a10;
        return playbackStateCompat;
    }

    public long b() {
        return this.f443e;
    }

    public long c() {
        return this.f446h;
    }

    public float d() {
        return this.f442d;
    }

    public int describeContents() {
        return 0;
    }

    public Object e() {
        if (this.f450l == null && Build.VERSION.SDK_INT >= 21) {
            PlaybackState.Builder builder = new PlaybackState.Builder();
            PlaybackState.Builder unused = builder.setState(this.f439a, this.f440b, this.f442d, this.f446h);
            PlaybackState.Builder unused2 = builder.setBufferedPosition(this.f441c);
            PlaybackState.Builder unused3 = builder.setActions(this.f443e);
            PlaybackState.Builder unused4 = builder.setErrorMessage(this.f445g);
            for (CustomAction b10 : this.f447i) {
                PlaybackState.Builder unused5 = builder.addCustomAction(s0.a(b10.b()));
            }
            PlaybackState.Builder unused6 = builder.setActiveQueueItemId(this.f448j);
            if (Build.VERSION.SDK_INT >= 22) {
                PlaybackState.Builder unused7 = builder.setExtras(this.f449k);
            }
            this.f450l = builder.build();
        }
        return this.f450l;
    }

    public long f() {
        return this.f440b;
    }

    public int g() {
        return this.f439a;
    }

    public String toString() {
        return "PlaybackState {" + "state=" + this.f439a + ", position=" + this.f440b + ", buffered position=" + this.f441c + ", speed=" + this.f442d + ", updated=" + this.f446h + ", actions=" + this.f443e + ", error code=" + this.f444f + ", error message=" + this.f445g + ", custom actions=" + this.f447i + ", active item id=" + this.f448j + "}";
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f439a);
        parcel.writeLong(this.f440b);
        parcel.writeFloat(this.f442d);
        parcel.writeLong(this.f446h);
        parcel.writeLong(this.f441c);
        parcel.writeLong(this.f443e);
        TextUtils.writeToParcel(this.f445g, parcel, i10);
        parcel.writeTypedList(this.f447i);
        parcel.writeLong(this.f448j);
        parcel.writeBundle(this.f449k);
        parcel.writeInt(this.f444f);
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final List f456a;

        /* renamed from: b  reason: collision with root package name */
        public int f457b;

        /* renamed from: c  reason: collision with root package name */
        public long f458c;

        /* renamed from: d  reason: collision with root package name */
        public long f459d;

        /* renamed from: e  reason: collision with root package name */
        public float f460e;

        /* renamed from: f  reason: collision with root package name */
        public long f461f;

        /* renamed from: g  reason: collision with root package name */
        public int f462g;

        /* renamed from: h  reason: collision with root package name */
        public CharSequence f463h;

        /* renamed from: i  reason: collision with root package name */
        public long f464i;

        /* renamed from: j  reason: collision with root package name */
        public long f465j;

        /* renamed from: k  reason: collision with root package name */
        public Bundle f466k;

        public b() {
            this.f456a = new ArrayList();
            this.f465j = -1;
        }

        public PlaybackStateCompat a() {
            return new PlaybackStateCompat(this.f457b, this.f458c, this.f459d, this.f460e, this.f461f, this.f462g, this.f463h, this.f464i, this.f456a, this.f465j, this.f466k);
        }

        public b b(long j10) {
            this.f461f = j10;
            return this;
        }

        public b c(int i10, long j10, float f10) {
            return d(i10, j10, f10, SystemClock.elapsedRealtime());
        }

        public b d(int i10, long j10, float f10, long j11) {
            this.f457b = i10;
            this.f458c = j10;
            this.f464i = j11;
            this.f460e = f10;
            return this;
        }

        public b(PlaybackStateCompat playbackStateCompat) {
            ArrayList arrayList = new ArrayList();
            this.f456a = arrayList;
            this.f465j = -1;
            this.f457b = playbackStateCompat.f439a;
            this.f458c = playbackStateCompat.f440b;
            this.f460e = playbackStateCompat.f442d;
            this.f464i = playbackStateCompat.f446h;
            this.f459d = playbackStateCompat.f441c;
            this.f461f = playbackStateCompat.f443e;
            this.f462g = playbackStateCompat.f444f;
            this.f463h = playbackStateCompat.f445g;
            List list = playbackStateCompat.f447i;
            if (list != null) {
                arrayList.addAll(list);
            }
            this.f465j = playbackStateCompat.f448j;
            this.f466k = playbackStateCompat.f449k;
        }
    }

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public final String f451a;

        /* renamed from: b  reason: collision with root package name */
        public final CharSequence f452b;

        /* renamed from: c  reason: collision with root package name */
        public final int f453c;

        /* renamed from: d  reason: collision with root package name */
        public final Bundle f454d;

        /* renamed from: e  reason: collision with root package name */
        public PlaybackState.CustomAction f455e;

        public class a implements Parcelable.Creator {
            /* renamed from: a */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            /* renamed from: b */
            public CustomAction[] newArray(int i10) {
                return new CustomAction[i10];
            }
        }

        public CustomAction(String str, CharSequence charSequence, int i10, Bundle bundle) {
            this.f451a = str;
            this.f452b = charSequence;
            this.f453c = i10;
            this.f454d = bundle;
        }

        public static CustomAction a(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            PlaybackState.CustomAction a10 = s0.a(obj);
            Bundle a11 = a10.getExtras();
            MediaSessionCompat.c(a11);
            CustomAction customAction = new CustomAction(a10.getAction(), a10.getName(), a10.getIcon(), a11);
            customAction.f455e = a10;
            return customAction;
        }

        public Object b() {
            PlaybackState.CustomAction customAction = this.f455e;
            if (customAction != null || Build.VERSION.SDK_INT < 21) {
                return customAction;
            }
            PlaybackState.CustomAction.Builder builder = new PlaybackState.CustomAction.Builder(this.f451a, this.f452b, this.f453c);
            PlaybackState.CustomAction.Builder unused = builder.setExtras(this.f454d);
            return builder.build();
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + this.f452b + ", mIcon=" + this.f453c + ", mExtras=" + this.f454d;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f451a);
            TextUtils.writeToParcel(this.f452b, parcel, i10);
            parcel.writeInt(this.f453c);
            parcel.writeBundle(this.f454d);
        }

        public CustomAction(Parcel parcel) {
            this.f451a = parcel.readString();
            this.f452b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f453c = parcel.readInt();
            this.f454d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.f439a = parcel.readInt();
        this.f440b = parcel.readLong();
        this.f442d = parcel.readFloat();
        this.f446h = parcel.readLong();
        this.f441c = parcel.readLong();
        this.f443e = parcel.readLong();
        this.f445g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f447i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f448j = parcel.readLong();
        this.f449k = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f444f = parcel.readInt();
    }
}
