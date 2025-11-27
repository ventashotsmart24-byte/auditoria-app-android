package x;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.cybergarage.xml.XML;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

public final class h implements i {

    /* renamed from: c  reason: collision with root package name */
    public static final Locale[] f9543c = new Locale[0];

    /* renamed from: d  reason: collision with root package name */
    public static final Locale f9544d = new Locale(XML.DEFAULT_CONTENT_LANGUAGE, "XA");

    /* renamed from: e  reason: collision with root package name */
    public static final Locale f9545e = new Locale("ar", "XB");

    /* renamed from: f  reason: collision with root package name */
    public static final Locale f9546f = g.b("en-Latn");

    /* renamed from: a  reason: collision with root package name */
    public final Locale[] f9547a;

    /* renamed from: b  reason: collision with root package name */
    public final String f9548b;

    public h(Locale... localeArr) {
        if (localeArr.length == 0) {
            this.f9547a = f9543c;
            this.f9548b = "";
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        int i10 = 0;
        while (i10 < localeArr.length) {
            Locale locale = localeArr[i10];
            if (locale != null) {
                if (!hashSet.contains(locale)) {
                    Locale locale2 = (Locale) locale.clone();
                    arrayList.add(locale2);
                    b(sb, locale2);
                    if (i10 < localeArr.length - 1) {
                        sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
                    }
                    hashSet.add(locale2);
                }
                i10++;
            } else {
                throw new NullPointerException("list[" + i10 + "] is null");
            }
        }
        this.f9547a = (Locale[]) arrayList.toArray(new Locale[arrayList.size()]);
        this.f9548b = sb.toString();
    }

    public static void b(StringBuilder sb, Locale locale) {
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (country != null && !country.isEmpty()) {
            sb.append(ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER);
            sb.append(locale.getCountry());
        }
    }

    public Object a() {
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        Locale[] localeArr = ((h) obj).f9547a;
        if (this.f9547a.length != localeArr.length) {
            return false;
        }
        int i10 = 0;
        while (true) {
            Locale[] localeArr2 = this.f9547a;
            if (i10 >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i10].equals(localeArr[i10])) {
                return false;
            }
            i10++;
        }
    }

    public Locale get(int i10) {
        if (i10 >= 0) {
            Locale[] localeArr = this.f9547a;
            if (i10 < localeArr.length) {
                return localeArr[i10];
            }
        }
        return null;
    }

    public int hashCode() {
        int i10 = 1;
        int i11 = 0;
        while (true) {
            Locale[] localeArr = this.f9547a;
            if (i11 >= localeArr.length) {
                return i10;
            }
            i10 = (i10 * 31) + localeArr[i11].hashCode();
            i11++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i10 = 0;
        while (true) {
            Locale[] localeArr = this.f9547a;
            if (i10 < localeArr.length) {
                sb.append(localeArr[i10]);
                if (i10 < this.f9547a.length - 1) {
                    sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
                }
                i10++;
            } else {
                sb.append("]");
                return sb.toString();
            }
        }
    }
}
