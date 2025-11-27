package androidx.media;

import y0.b;

public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(b bVar) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f2384a = bVar.p(audioAttributesImplBase.f2384a, 1);
        audioAttributesImplBase.f2385b = bVar.p(audioAttributesImplBase.f2385b, 2);
        audioAttributesImplBase.f2386c = bVar.p(audioAttributesImplBase.f2386c, 3);
        audioAttributesImplBase.f2387d = bVar.p(audioAttributesImplBase.f2387d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, b bVar) {
        bVar.x(false, false);
        bVar.F(audioAttributesImplBase.f2384a, 1);
        bVar.F(audioAttributesImplBase.f2385b, 2);
        bVar.F(audioAttributesImplBase.f2386c, 3);
        bVar.F(audioAttributesImplBase.f2387d, 4);
    }
}
