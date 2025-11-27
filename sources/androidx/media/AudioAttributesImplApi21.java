package androidx.media;

import android.media.AudioAttributes;
import androidx.media.AudioAttributesImpl;

public class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* renamed from: a  reason: collision with root package name */
    public AudioAttributes f2381a;

    /* renamed from: b  reason: collision with root package name */
    public int f2382b;

    public static class a implements AudioAttributesImpl.a {

        /* renamed from: a  reason: collision with root package name */
        public final AudioAttributes.Builder f2383a = new AudioAttributes.Builder();

        /* renamed from: b */
        public a a(int i10) {
            AudioAttributes.Builder unused = this.f2383a.setLegacyStreamType(i10);
            return this;
        }

        public AudioAttributesImpl build() {
            return new AudioAttributesImplApi21(this.f2383a.build());
        }
    }

    public AudioAttributesImplApi21() {
        this.f2382b = -1;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplApi21)) {
            return false;
        }
        return this.f2381a.equals(((AudioAttributesImplApi21) obj).f2381a);
    }

    public int hashCode() {
        return this.f2381a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f2381a;
    }

    public AudioAttributesImplApi21(AudioAttributes audioAttributes) {
        this(audioAttributes, -1);
    }

    public AudioAttributesImplApi21(AudioAttributes audioAttributes, int i10) {
        this.f2381a = audioAttributes;
        this.f2382b = i10;
    }
}
