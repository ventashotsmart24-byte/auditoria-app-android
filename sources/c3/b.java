package c3;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.raizlabs.android.dbflow.sql.language.Operator;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f4681a;

    /* renamed from: b  reason: collision with root package name */
    public static final a f4682b;

    /* renamed from: c  reason: collision with root package name */
    public static final a f4683c;

    /* renamed from: d  reason: collision with root package name */
    public static final a f4684d;

    static {
        a aVar = new a("MIME", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, (char) ASCIIPropertyListParser.DICTIONARY_ASSIGN_TOKEN, 76);
        f4681a = aVar;
        f4682b = new a(aVar, "MIME-NO-LINEFEEDS", Integer.MAX_VALUE);
        f4683c = new a(aVar, "PEM", true, (char) ASCIIPropertyListParser.DICTIONARY_ASSIGN_TOKEN, 64);
        StringBuilder sb = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
        sb.setCharAt(sb.indexOf(Operator.Operation.PLUS), ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER);
        sb.setCharAt(sb.indexOf(Operator.Operation.DIVISION), '_');
        f4684d = new a("MODIFIED-FOR-URL", sb.toString(), false, 0, Integer.MAX_VALUE);
    }

    public static a a() {
        return f4682b;
    }
}
