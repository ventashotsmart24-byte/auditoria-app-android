package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

public class MediaBrowserCompat$MediaItem implements Parcelable {
    public static final Parcelable.Creator<MediaBrowserCompat$MediaItem> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final int f314a;

    /* renamed from: b  reason: collision with root package name */
    public final MediaDescriptionCompat f315b;

    public class a implements Parcelable.Creator {
        /* renamed from: a */
        public MediaBrowserCompat$MediaItem createFromParcel(Parcel parcel) {
            return new MediaBrowserCompat$MediaItem(parcel);
        }

        /* renamed from: b */
        public MediaBrowserCompat$MediaItem[] newArray(int i10) {
            return new MediaBrowserCompat$MediaItem[i10];
        }
    }

    public MediaBrowserCompat$MediaItem(Parcel parcel) {
        this.f314a = parcel.readInt();
        this.f315b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "MediaItem{" + "mFlags=" + this.f314a + ", mDescription=" + this.f315b + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f314a);
        this.f315b.writeToParcel(parcel, i10);
    }
}
