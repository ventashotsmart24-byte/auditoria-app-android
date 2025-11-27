package androidx.media;

import android.os.Build;
import android.util.SparseIntArray;
import androidx.media.AudioAttributesImpl;
import androidx.media.AudioAttributesImplApi21;
import androidx.media.AudioAttributesImplApi26;
import androidx.media.AudioAttributesImplBase;
import y0.d;

public class AudioAttributesCompat implements d {

    /* renamed from: b  reason: collision with root package name */
    public static final SparseIntArray f2376b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f2377c;

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f2378d = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16};

    /* renamed from: a  reason: collision with root package name */
    public AudioAttributesImpl f2379a;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final AudioAttributesImpl.a f2380a;

        public a() {
            if (AudioAttributesCompat.f2377c) {
                this.f2380a = new AudioAttributesImplBase.a();
                return;
            }
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 26) {
                this.f2380a = new AudioAttributesImplApi26.a();
            } else if (i10 >= 21) {
                this.f2380a = new AudioAttributesImplApi21.a();
            } else {
                this.f2380a = new AudioAttributesImplBase.a();
            }
        }

        public AudioAttributesCompat a() {
            return new AudioAttributesCompat(this.f2380a.build());
        }

        public a b(int i10) {
            this.f2380a.a(i10);
            return this;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2376b = sparseIntArray;
        sparseIntArray.put(5, 1);
        sparseIntArray.put(6, 2);
        sparseIntArray.put(7, 2);
        sparseIntArray.put(8, 1);
        sparseIntArray.put(9, 1);
        sparseIntArray.put(10, 1);
    }

    public AudioAttributesCompat() {
    }

    public static int a(boolean z10, int i10, int i11) {
        if ((i10 & 1) == 1) {
            if (z10) {
                return 1;
            }
            return 7;
        } else if ((i10 & 4) != 4) {
            switch (i11) {
                case 0:
                case 1:
                case 12:
                case 14:
                case 16:
                    return 3;
                case 2:
                    return 0;
                case 3:
                    if (z10) {
                        return 0;
                    }
                    return 8;
                case 4:
                    return 4;
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return 5;
                case 6:
                    return 2;
                case 11:
                    return 10;
                case 13:
                    return 1;
                default:
                    if (!z10) {
                        return 3;
                    }
                    throw new IllegalArgumentException("Unknown usage value " + i11 + " in audio attributes");
            }
        } else if (z10) {
            return 0;
        } else {
            return 6;
        }
    }

    public static String b(int i10) {
        switch (i10) {
            case 0:
                return "USAGE_UNKNOWN";
            case 1:
                return "USAGE_MEDIA";
            case 2:
                return "USAGE_VOICE_COMMUNICATION";
            case 3:
                return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
            case 4:
                return "USAGE_ALARM";
            case 5:
                return "USAGE_NOTIFICATION";
            case 6:
                return "USAGE_NOTIFICATION_RINGTONE";
            case 7:
                return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
            case 8:
                return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
            case 9:
                return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
            case 10:
                return "USAGE_NOTIFICATION_EVENT";
            case 11:
                return "USAGE_ASSISTANCE_ACCESSIBILITY";
            case 12:
                return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
            case 13:
                return "USAGE_ASSISTANCE_SONIFICATION";
            case 14:
                return "USAGE_GAME";
            case 16:
                return "USAGE_ASSISTANT";
            default:
                return "unknown usage " + i10;
        }
    }

    public static AudioAttributesCompat c(Object obj) {
        if (f2377c) {
            return null;
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            return new AudioAttributesCompat(new AudioAttributesImplApi26(k0.a.a(obj)));
        }
        if (i10 >= 21) {
            return new AudioAttributesCompat(new AudioAttributesImplApi21(k0.a.a(obj)));
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesCompat)) {
            return false;
        }
        AudioAttributesCompat audioAttributesCompat = (AudioAttributesCompat) obj;
        AudioAttributesImpl audioAttributesImpl = this.f2379a;
        if (audioAttributesImpl != null) {
            return audioAttributesImpl.equals(audioAttributesCompat.f2379a);
        }
        if (audioAttributesCompat.f2379a == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f2379a.hashCode();
    }

    public String toString() {
        return this.f2379a.toString();
    }

    public AudioAttributesCompat(AudioAttributesImpl audioAttributesImpl) {
        this.f2379a = audioAttributesImpl;
    }
}
