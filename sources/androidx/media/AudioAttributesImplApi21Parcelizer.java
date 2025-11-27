package androidx.media;

import k0.a;
import y0.b;

public class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(b bVar) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.f2381a = a.a(bVar.r(audioAttributesImplApi21.f2381a, 1));
        audioAttributesImplApi21.f2382b = bVar.p(audioAttributesImplApi21.f2382b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, b bVar) {
        bVar.x(false, false);
        bVar.H(audioAttributesImplApi21.f2381a, 1);
        bVar.F(audioAttributesImplApi21.f2382b, 2);
    }
}
