package j3;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;

public class n implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final char f7174a;

    /* renamed from: b  reason: collision with root package name */
    public final char f7175b;

    /* renamed from: c  reason: collision with root package name */
    public final char f7176c;

    public n() {
        this(ASCIIPropertyListParser.DATE_TIME_FIELD_DELIMITER, ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN, ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
    }

    public static n a() {
        return new n();
    }

    public char b() {
        return this.f7176c;
    }

    public char c() {
        return this.f7175b;
    }

    public char d() {
        return this.f7174a;
    }

    public n(char c10, char c11, char c12) {
        this.f7174a = c10;
        this.f7175b = c11;
        this.f7176c = c12;
    }
}
