package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;

public final class MediaMetadataCompat implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR = new a();

    /* renamed from: d  reason: collision with root package name */
    public static final androidx.collection.a f333d;

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f334e = {"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f335f = {"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART"};

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f336g = {"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI"};

    /* renamed from: a  reason: collision with root package name */
    public final Bundle f337a;

    /* renamed from: b  reason: collision with root package name */
    public MediaMetadata f338b;

    /* renamed from: c  reason: collision with root package name */
    public MediaDescriptionCompat f339c;

    public class a implements Parcelable.Creator {
        /* renamed from: a */
        public MediaMetadataCompat createFromParcel(Parcel parcel) {
            return new MediaMetadataCompat(parcel);
        }

        /* renamed from: b */
        public MediaMetadataCompat[] newArray(int i10) {
            return new MediaMetadataCompat[i10];
        }
    }

    static {
        androidx.collection.a aVar = new androidx.collection.a();
        f333d = aVar;
        aVar.put("android.media.metadata.TITLE", 1);
        aVar.put("android.media.metadata.ARTIST", 1);
        aVar.put("android.media.metadata.DURATION", 0);
        aVar.put("android.media.metadata.ALBUM", 1);
        aVar.put("android.media.metadata.AUTHOR", 1);
        aVar.put("android.media.metadata.WRITER", 1);
        aVar.put("android.media.metadata.COMPOSER", 1);
        aVar.put("android.media.metadata.COMPILATION", 1);
        aVar.put("android.media.metadata.DATE", 1);
        aVar.put("android.media.metadata.YEAR", 0);
        aVar.put("android.media.metadata.GENRE", 1);
        aVar.put("android.media.metadata.TRACK_NUMBER", 0);
        aVar.put("android.media.metadata.NUM_TRACKS", 0);
        aVar.put("android.media.metadata.DISC_NUMBER", 0);
        aVar.put("android.media.metadata.ALBUM_ARTIST", 1);
        aVar.put("android.media.metadata.ART", 2);
        aVar.put("android.media.metadata.ART_URI", 1);
        aVar.put("android.media.metadata.ALBUM_ART", 2);
        aVar.put("android.media.metadata.ALBUM_ART_URI", 1);
        aVar.put("android.media.metadata.USER_RATING", 3);
        aVar.put("android.media.metadata.RATING", 3);
        aVar.put("android.media.metadata.DISPLAY_TITLE", 1);
        aVar.put("android.media.metadata.DISPLAY_SUBTITLE", 1);
        aVar.put("android.media.metadata.DISPLAY_DESCRIPTION", 1);
        aVar.put("android.media.metadata.DISPLAY_ICON", 2);
        aVar.put("android.media.metadata.DISPLAY_ICON_URI", 1);
        aVar.put("android.media.metadata.MEDIA_ID", 1);
        aVar.put("android.media.metadata.BT_FOLDER_TYPE", 0);
        aVar.put("android.media.metadata.MEDIA_URI", 1);
        aVar.put("android.media.metadata.ADVERTISEMENT", 0);
        aVar.put("android.media.metadata.DOWNLOAD_STATUS", 0);
    }

    public MediaMetadataCompat(Bundle bundle) {
        Bundle bundle2 = new Bundle(bundle);
        this.f337a = bundle2;
        MediaSessionCompat.c(bundle2);
    }

    public static MediaMetadataCompat b(Object obj) {
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        u.a(obj).writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        MediaMetadataCompat createFromParcel = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        createFromParcel.f338b = u.a(obj);
        return createFromParcel;
    }

    public boolean a(String str) {
        return this.f337a.containsKey(str);
    }

    public Bitmap c(String str) {
        try {
            return (Bitmap) this.f337a.getParcelable(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public Bundle d() {
        return new Bundle(this.f337a);
    }

    public int describeContents() {
        return 0;
    }

    public MediaDescriptionCompat e() {
        Uri uri;
        Bitmap bitmap;
        Uri uri2;
        MediaDescriptionCompat mediaDescriptionCompat = this.f339c;
        if (mediaDescriptionCompat != null) {
            return mediaDescriptionCompat;
        }
        String h10 = h("android.media.metadata.MEDIA_ID");
        CharSequence[] charSequenceArr = new CharSequence[3];
        CharSequence i10 = i("android.media.metadata.DISPLAY_TITLE");
        if (TextUtils.isEmpty(i10)) {
            int i11 = 0;
            int i12 = 0;
            while (i11 < 3) {
                String[] strArr = f334e;
                if (i12 >= strArr.length) {
                    break;
                }
                int i13 = i12 + 1;
                CharSequence i14 = i(strArr[i12]);
                if (!TextUtils.isEmpty(i14)) {
                    charSequenceArr[i11] = i14;
                    i11++;
                }
                i12 = i13;
            }
        } else {
            charSequenceArr[0] = i10;
            charSequenceArr[1] = i("android.media.metadata.DISPLAY_SUBTITLE");
            charSequenceArr[2] = i("android.media.metadata.DISPLAY_DESCRIPTION");
        }
        int i15 = 0;
        while (true) {
            String[] strArr2 = f335f;
            uri = null;
            if (i15 >= strArr2.length) {
                bitmap = null;
                break;
            }
            bitmap = c(strArr2[i15]);
            if (bitmap != null) {
                break;
            }
            i15++;
        }
        int i16 = 0;
        while (true) {
            String[] strArr3 = f336g;
            if (i16 >= strArr3.length) {
                uri2 = null;
                break;
            }
            String h11 = h(strArr3[i16]);
            if (!TextUtils.isEmpty(h11)) {
                uri2 = Uri.parse(h11);
                break;
            }
            i16++;
        }
        String h12 = h("android.media.metadata.MEDIA_URI");
        if (!TextUtils.isEmpty(h12)) {
            uri = Uri.parse(h12);
        }
        MediaDescriptionCompat.b bVar = new MediaDescriptionCompat.b();
        bVar.f(h10);
        bVar.i(charSequenceArr[0]);
        bVar.h(charSequenceArr[1]);
        bVar.b(charSequenceArr[2]);
        bVar.d(bitmap);
        bVar.e(uri2);
        bVar.g(uri);
        Bundle bundle = new Bundle();
        if (this.f337a.containsKey("android.media.metadata.BT_FOLDER_TYPE")) {
            bundle.putLong("android.media.extra.BT_FOLDER_TYPE", f("android.media.metadata.BT_FOLDER_TYPE"));
        }
        if (this.f337a.containsKey("android.media.metadata.DOWNLOAD_STATUS")) {
            bundle.putLong("android.media.extra.DOWNLOAD_STATUS", f("android.media.metadata.DOWNLOAD_STATUS"));
        }
        if (!bundle.isEmpty()) {
            bVar.c(bundle);
        }
        MediaDescriptionCompat a10 = bVar.a();
        this.f339c = a10;
        return a10;
    }

    public long f(String str) {
        return this.f337a.getLong(str, 0);
    }

    public Object g() {
        if (this.f338b == null && Build.VERSION.SDK_INT >= 21) {
            Parcel obtain = Parcel.obtain();
            writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            this.f338b = u.a(MediaMetadata.CREATOR.createFromParcel(obtain));
            obtain.recycle();
        }
        return this.f338b;
    }

    public String h(String str) {
        CharSequence charSequence = this.f337a.getCharSequence(str);
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public CharSequence i(String str) {
        return this.f337a.getCharSequence(str);
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeBundle(this.f337a);
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Bundle f340a;

        public b() {
            this.f340a = new Bundle();
        }

        public MediaMetadataCompat a() {
            return new MediaMetadataCompat(this.f340a);
        }

        public b b(String str, Bitmap bitmap) {
            androidx.collection.a aVar = MediaMetadataCompat.f333d;
            if (!aVar.containsKey(str) || ((Integer) aVar.get(str)).intValue() == 2) {
                this.f340a.putParcelable(str, bitmap);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a Bitmap");
        }

        public b c(String str, long j10) {
            androidx.collection.a aVar = MediaMetadataCompat.f333d;
            if (!aVar.containsKey(str) || ((Integer) aVar.get(str)).intValue() == 0) {
                this.f340a.putLong(str, j10);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a long");
        }

        public b d(String str, String str2) {
            androidx.collection.a aVar = MediaMetadataCompat.f333d;
            if (!aVar.containsKey(str) || ((Integer) aVar.get(str)).intValue() == 1) {
                this.f340a.putCharSequence(str, str2);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a String");
        }

        public final Bitmap e(Bitmap bitmap, int i10) {
            float f10 = (float) i10;
            float min = Math.min(f10 / ((float) bitmap.getWidth()), f10 / ((float) bitmap.getHeight()));
            return Bitmap.createScaledBitmap(bitmap, (int) (((float) bitmap.getWidth()) * min), (int) (((float) bitmap.getHeight()) * min), true);
        }

        public b(MediaMetadataCompat mediaMetadataCompat) {
            Bundle bundle = new Bundle(mediaMetadataCompat.f337a);
            this.f340a = bundle;
            MediaSessionCompat.c(bundle);
        }

        public b(MediaMetadataCompat mediaMetadataCompat, int i10) {
            this(mediaMetadataCompat);
            for (String str : this.f340a.keySet()) {
                Object obj = this.f340a.get(str);
                if (obj instanceof Bitmap) {
                    Bitmap bitmap = (Bitmap) obj;
                    if (bitmap.getHeight() > i10 || bitmap.getWidth() > i10) {
                        b(str, e(bitmap, i10));
                    }
                }
            }
        }
    }

    public MediaMetadataCompat(Parcel parcel) {
        this.f337a = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
    }
}
