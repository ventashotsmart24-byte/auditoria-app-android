package b9;

import java.net.ProtocolException;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final i f11318a;

    /* renamed from: b  reason: collision with root package name */
    public final int f11319b;

    /* renamed from: c  reason: collision with root package name */
    public final String f11320c;

    public j(i iVar, int i10, String str) {
        this.f11318a = iVar;
        this.f11319b = i10;
        this.f11320c = str;
    }

    public static j a(String str) {
        int i10;
        i iVar;
        String str2;
        if (str.startsWith("HTTP/1.")) {
            i10 = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                iVar = i.HTTP_1_0;
            } else if (charAt == 1) {
                iVar = i.HTTP_1_1;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            iVar = i.HTTP_1_0;
            i10 = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        int i11 = i10 + 3;
        if (str.length() >= i11) {
            try {
                int parseInt = Integer.parseInt(str.substring(i10, i11));
                if (str.length() <= i11) {
                    str2 = "";
                } else if (str.charAt(i11) == ' ') {
                    str2 = str.substring(i10 + 4);
                } else {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                return new j(iVar, parseInt, str2);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (this.f11318a == i.HTTP_1_0) {
            str = "HTTP/1.0";
        } else {
            str = "HTTP/1.1";
        }
        sb.append(str);
        sb.append(' ');
        sb.append(this.f11319b);
        if (this.f11320c != null) {
            sb.append(' ');
            sb.append(this.f11320c);
        }
        return sb.toString();
    }
}
