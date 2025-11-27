package androidx.media;

import k0.a;
import y0.b;

public class AudioAttributesImplApi26Parcelizer {
    public static AudioAttributesImplApi26 read(b bVar) {
        AudioAttributesImplApi26 audioAttributesImplApi26 = new AudioAttributesImplApi26();
        audioAttributesImplApi26.f2381a = a.a(bVar.r(audioAttributesImplApi26.f2381a, 1));
        audioAttributesImplApi26.f2382b = bVar.p(audioAttributesImplApi26.f2382b, 2);
        return audioAttributesImplApi26;
    }

    public static void write(AudioAttributesImplApi26 audioAttributesImplApi26, b bVar) {
        bVar.x(false, false);
        bVar.H(audioAttributesImplApi26.f2381a, 1);
        bVar.F(audioAttributesImplApi26.f2382b, 2);
    }
}
