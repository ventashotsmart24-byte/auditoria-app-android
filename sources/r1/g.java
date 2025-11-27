package r1;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

public class g implements Key {

    /* renamed from: a  reason: collision with root package name */
    public final String f9012a;

    /* renamed from: b  reason: collision with root package name */
    public final Key f9013b;

    public g(String str, Key key) {
        this.f9012a = str;
        this.f9013b = key;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f9012a.equals(gVar.f9012a) && this.f9013b.equals(gVar.f9013b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f9012a.hashCode() * 31) + this.f9013b.hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(this.f9012a.getBytes(Key.CHARSET));
        this.f9013b.updateDiskCacheKey(messageDigest);
    }
}
