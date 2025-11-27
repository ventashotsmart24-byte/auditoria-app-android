package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final String f316a;

    /* renamed from: b  reason: collision with root package name */
    public final CharSequence f317b;

    /* renamed from: c  reason: collision with root package name */
    public final CharSequence f318c;

    /* renamed from: d  reason: collision with root package name */
    public final CharSequence f319d;

    /* renamed from: e  reason: collision with root package name */
    public final Bitmap f320e;

    /* renamed from: f  reason: collision with root package name */
    public final Uri f321f;

    /* renamed from: g  reason: collision with root package name */
    public final Bundle f322g;

    /* renamed from: h  reason: collision with root package name */
    public final Uri f323h;

    /* renamed from: i  reason: collision with root package name */
    public MediaDescription f324i;

    public class a implements Parcelable.Creator {
        /* renamed from: a */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            if (Build.VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(parcel);
            }
            return MediaDescriptionCompat.a(MediaDescription.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public MediaDescriptionCompat[] newArray(int i10) {
            return new MediaDescriptionCompat[i10];
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public String f325a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f326b;

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f327c;

        /* renamed from: d  reason: collision with root package name */
        public CharSequence f328d;

        /* renamed from: e  reason: collision with root package name */
        public Bitmap f329e;

        /* renamed from: f  reason: collision with root package name */
        public Uri f330f;

        /* renamed from: g  reason: collision with root package name */
        public Bundle f331g;

        /* renamed from: h  reason: collision with root package name */
        public Uri f332h;

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f325a, this.f326b, this.f327c, this.f328d, this.f329e, this.f330f, this.f331g, this.f332h);
        }

        public b b(CharSequence charSequence) {
            this.f328d = charSequence;
            return this;
        }

        public b c(Bundle bundle) {
            this.f331g = bundle;
            return this;
        }

        public b d(Bitmap bitmap) {
            this.f329e = bitmap;
            return this;
        }

        public b e(Uri uri) {
            this.f330f = uri;
            return this;
        }

        public b f(String str) {
            this.f325a = str;
            return this;
        }

        public b g(Uri uri) {
            this.f332h = uri;
            return this;
        }

        public b h(CharSequence charSequence) {
            this.f327c = charSequence;
            return this;
        }

        public b i(CharSequence charSequence) {
            this.f326b = charSequence;
            return this;
        }
    }

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f316a = str;
        this.f317b = charSequence;
        this.f318c = charSequence2;
        this.f319d = charSequence3;
        this.f320e = bitmap;
        this.f321f = uri;
        this.f322g = bundle;
        this.f323h = uri2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.v4.media.MediaDescriptionCompat a(java.lang.Object r9) {
        /*
            r0 = 0
            if (r9 == 0) goto L_0x0085
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r1 < r2) goto L_0x0085
            android.support.v4.media.MediaDescriptionCompat$b r2 = new android.support.v4.media.MediaDescriptionCompat$b
            r2.<init>()
            android.media.MediaDescription r9 = android.support.v4.media.a.a(r9)
            java.lang.String r3 = r9.getMediaId()
            r2.f(r3)
            java.lang.CharSequence r3 = r9.getTitle()
            r2.i(r3)
            java.lang.CharSequence r3 = r9.getSubtitle()
            r2.h(r3)
            java.lang.CharSequence r3 = r9.getDescription()
            r2.b(r3)
            android.graphics.Bitmap r3 = r9.getIconBitmap()
            r2.d(r3)
            android.net.Uri r3 = r9.getIconUri()
            r2.e(r3)
            android.os.Bundle r3 = r9.getExtras()
            if (r3 == 0) goto L_0x0046
            android.os.Bundle r3 = android.support.v4.media.session.MediaSessionCompat.s(r3)
        L_0x0046:
            java.lang.String r4 = "android.support.v4.media.description.MEDIA_URI"
            if (r3 == 0) goto L_0x0051
            android.os.Parcelable r5 = r3.getParcelable(r4)
            android.net.Uri r5 = (android.net.Uri) r5
            goto L_0x0052
        L_0x0051:
            r5 = r0
        L_0x0052:
            if (r5 == 0) goto L_0x006a
            java.lang.String r6 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r7 = r3.containsKey(r6)
            if (r7 == 0) goto L_0x0064
            int r7 = r3.size()
            r8 = 2
            if (r7 != r8) goto L_0x0064
            goto L_0x006b
        L_0x0064:
            r3.remove(r4)
            r3.remove(r6)
        L_0x006a:
            r0 = r3
        L_0x006b:
            r2.c(r0)
            if (r5 == 0) goto L_0x0074
            r2.g(r5)
            goto L_0x007f
        L_0x0074:
            r0 = 23
            if (r1 < r0) goto L_0x007f
            android.net.Uri r0 = r9.getMediaUri()
            r2.g(r0)
        L_0x007f:
            android.support.v4.media.MediaDescriptionCompat r0 = r2.a()
            r0.f324i = r9
        L_0x0085:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.a(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    public Bitmap b() {
        return this.f320e;
    }

    public Uri c() {
        return this.f321f;
    }

    public Object d() {
        int i10;
        MediaDescription mediaDescription = this.f324i;
        if (mediaDescription != null || (i10 = Build.VERSION.SDK_INT) < 21) {
            return mediaDescription;
        }
        MediaDescription.Builder builder = new MediaDescription.Builder();
        MediaDescription.Builder unused = builder.setMediaId(this.f316a);
        MediaDescription.Builder unused2 = builder.setTitle(this.f317b);
        MediaDescription.Builder unused3 = builder.setSubtitle(this.f318c);
        MediaDescription.Builder unused4 = builder.setDescription(this.f319d);
        MediaDescription.Builder unused5 = builder.setIconBitmap(this.f320e);
        MediaDescription.Builder unused6 = builder.setIconUri(this.f321f);
        Bundle bundle = this.f322g;
        if (i10 < 23 && this.f323h != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.f323h);
        }
        MediaDescription.Builder unused7 = builder.setExtras(bundle);
        if (i10 >= 23) {
            MediaDescription.Builder unused8 = builder.setMediaUri(this.f323h);
        }
        MediaDescription a10 = builder.build();
        this.f324i = a10;
        return a10;
    }

    public int describeContents() {
        return 0;
    }

    public CharSequence e() {
        return this.f318c;
    }

    public CharSequence f() {
        return this.f317b;
    }

    public String toString() {
        return this.f317b + ", " + this.f318c + ", " + this.f319d;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        if (Build.VERSION.SDK_INT < 21) {
            parcel.writeString(this.f316a);
            TextUtils.writeToParcel(this.f317b, parcel, i10);
            TextUtils.writeToParcel(this.f318c, parcel, i10);
            TextUtils.writeToParcel(this.f319d, parcel, i10);
            parcel.writeParcelable(this.f320e, i10);
            parcel.writeParcelable(this.f321f, i10);
            parcel.writeBundle(this.f322g);
            parcel.writeParcelable(this.f323h, i10);
            return;
        }
        a.a(d()).writeToParcel(parcel, i10);
    }

    public MediaDescriptionCompat(Parcel parcel) {
        this.f316a = parcel.readString();
        this.f317b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f318c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f319d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = MediaDescriptionCompat.class.getClassLoader();
        this.f320e = (Bitmap) parcel.readParcelable(classLoader);
        this.f321f = (Uri) parcel.readParcelable(classLoader);
        this.f322g = parcel.readBundle(classLoader);
        this.f323h = (Uri) parcel.readParcelable(classLoader);
    }
}
