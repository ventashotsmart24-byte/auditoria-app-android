package androidx.media;

import y0.b;

public class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(b bVar) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.f2379a = (AudioAttributesImpl) bVar.v(audioAttributesCompat.f2379a, 1);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, b bVar) {
        bVar.x(false, false);
        bVar.M(audioAttributesCompat.f2379a, 1);
    }
}
