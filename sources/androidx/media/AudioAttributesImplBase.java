package androidx.media;

import android.util.Log;
import androidx.media.AudioAttributesImpl;
import java.util.Arrays;

public class AudioAttributesImplBase implements AudioAttributesImpl {

    /* renamed from: a  reason: collision with root package name */
    public int f2384a;

    /* renamed from: b  reason: collision with root package name */
    public int f2385b;

    /* renamed from: c  reason: collision with root package name */
    public int f2386c;

    /* renamed from: d  reason: collision with root package name */
    public int f2387d;

    public static class a implements AudioAttributesImpl.a {

        /* renamed from: a  reason: collision with root package name */
        public int f2388a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f2389b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f2390c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f2391d = -1;

        public final a b(int i10) {
            switch (i10) {
                case 0:
                    this.f2389b = 1;
                    break;
                case 1:
                    break;
                case 2:
                    this.f2389b = 4;
                    break;
                case 3:
                    this.f2389b = 2;
                    break;
                case 4:
                    this.f2389b = 4;
                    break;
                case 5:
                    this.f2389b = 4;
                    break;
                case 6:
                    this.f2389b = 1;
                    this.f2390c |= 4;
                    break;
                case 7:
                    this.f2390c = 1 | this.f2390c;
                    break;
                case 8:
                    this.f2389b = 4;
                    break;
                case 9:
                    this.f2389b = 4;
                    break;
                case 10:
                    this.f2389b = 1;
                    break;
                default:
                    Log.e("AudioAttributesCompat", "Invalid stream type " + i10 + " for AudioAttributesCompat");
                    break;
            }
            this.f2389b = 4;
            this.f2388a = AudioAttributesImplBase.e(i10);
            return this;
        }

        public AudioAttributesImpl build() {
            return new AudioAttributesImplBase(this.f2389b, this.f2390c, this.f2388a, this.f2391d);
        }

        /* renamed from: c */
        public a a(int i10) {
            if (i10 != 10) {
                this.f2391d = i10;
                return b(i10);
            }
            throw new IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
        }
    }

    public AudioAttributesImplBase() {
        this.f2384a = 0;
        this.f2385b = 0;
        this.f2386c = 0;
        this.f2387d = -1;
    }

    public static int e(int i10) {
        switch (i10) {
            case 0:
                return 2;
            case 1:
            case 7:
                return 13;
            case 2:
                return 6;
            case 3:
                return 1;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 2;
            case 8:
                return 3;
            case 10:
                return 11;
            default:
                return 0;
        }
    }

    public int a() {
        return this.f2385b;
    }

    public int b() {
        int i10 = this.f2386c;
        int c10 = c();
        if (c10 == 6) {
            i10 |= 4;
        } else if (c10 == 7) {
            i10 |= 1;
        }
        return i10 & 273;
    }

    public int c() {
        int i10 = this.f2387d;
        if (i10 != -1) {
            return i10;
        }
        return AudioAttributesCompat.a(false, this.f2386c, this.f2384a);
    }

    public int d() {
        return this.f2384a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        if (this.f2385b == audioAttributesImplBase.a() && this.f2386c == audioAttributesImplBase.b() && this.f2384a == audioAttributesImplBase.d() && this.f2387d == audioAttributesImplBase.f2387d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2385b), Integer.valueOf(this.f2386c), Integer.valueOf(this.f2384a), Integer.valueOf(this.f2387d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f2387d != -1) {
            sb.append(" stream=");
            sb.append(this.f2387d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.b(this.f2384a));
        sb.append(" content=");
        sb.append(this.f2385b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f2386c).toUpperCase());
        return sb.toString();
    }

    public AudioAttributesImplBase(int i10, int i11, int i12, int i13) {
        this.f2385b = i10;
        this.f2386c = i11;
        this.f2384a = i12;
        this.f2387d = i13;
    }
}
