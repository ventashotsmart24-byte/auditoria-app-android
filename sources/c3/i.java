package c3;

import java.io.Serializable;

public class i implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    public static final i f4732f = new i((Object) null, -1, -1, -1, -1);

    /* renamed from: a  reason: collision with root package name */
    public final long f4733a;

    /* renamed from: b  reason: collision with root package name */
    public final long f4734b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4735c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4736d;

    /* renamed from: e  reason: collision with root package name */
    public final transient Object f4737e;

    public i(Object obj, long j10, int i10, int i11) {
        this(obj, -1, j10, i10, i11);
    }

    public final int a(StringBuilder sb, String str) {
        sb.append('\"');
        sb.append(str);
        sb.append('\"');
        return str.length();
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0098  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.StringBuilder b(java.lang.StringBuilder r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f4737e
            if (r0 != 0) goto L_0x000a
            java.lang.String r0 = "UNKNOWN"
            r7.append(r0)
            return r7
        L_0x000a:
            boolean r1 = r0 instanceof java.lang.Class
            if (r1 == 0) goto L_0x0012
            r1 = r0
            java.lang.Class r1 = (java.lang.Class) r1
            goto L_0x0016
        L_0x0012:
            java.lang.Class r1 = r0.getClass()
        L_0x0016:
            java.lang.String r2 = r1.getName()
            java.lang.String r3 = "java."
            boolean r3 = r2.startsWith(r3)
            if (r3 == 0) goto L_0x0027
            java.lang.String r2 = r1.getSimpleName()
            goto L_0x0034
        L_0x0027:
            boolean r1 = r0 instanceof byte[]
            if (r1 == 0) goto L_0x002e
            java.lang.String r2 = "byte[]"
            goto L_0x0034
        L_0x002e:
            boolean r1 = r0 instanceof char[]
            if (r1 == 0) goto L_0x0034
            java.lang.String r2 = "char[]"
        L_0x0034:
            r1 = 40
            r7.append(r1)
            r7.append(r2)
            r1 = 41
            r7.append(r1)
            boolean r1 = r0 instanceof java.lang.CharSequence
            r2 = 500(0x1f4, float:7.0E-43)
            r3 = 0
            java.lang.String r4 = " chars"
            if (r1 == 0) goto L_0x0063
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r1 = r0.length()
            int r2 = java.lang.Math.min(r1, r2)
            java.lang.CharSequence r0 = r0.subSequence(r3, r2)
            java.lang.String r0 = r0.toString()
            int r0 = r6.a(r7, r0)
        L_0x0060:
            int r3 = r1 - r0
            goto L_0x0096
        L_0x0063:
            boolean r1 = r0 instanceof char[]
            if (r1 == 0) goto L_0x0078
            char[] r0 = (char[]) r0
            int r1 = r0.length
            java.lang.String r5 = new java.lang.String
            int r2 = java.lang.Math.min(r1, r2)
            r5.<init>(r0, r3, r2)
            int r0 = r6.a(r7, r5)
            goto L_0x0060
        L_0x0078:
            boolean r1 = r0 instanceof byte[]
            if (r1 == 0) goto L_0x0096
            byte[] r0 = (byte[]) r0
            int r1 = r0.length
            int r1 = java.lang.Math.min(r1, r2)
            java.lang.String r2 = new java.lang.String
            java.lang.String r4 = "UTF-8"
            java.nio.charset.Charset r4 = java.nio.charset.Charset.forName(r4)
            r2.<init>(r0, r3, r1, r4)
            r6.a(r7, r2)
            int r0 = r0.length
            int r3 = r0 - r1
            java.lang.String r4 = " bytes"
        L_0x0096:
            if (r3 <= 0) goto L_0x00a8
            java.lang.String r0 = "[truncated "
            r7.append(r0)
            r7.append(r3)
            r7.append(r4)
            r0 = 93
            r7.append(r0)
        L_0x00a8:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: c3.i.b(java.lang.StringBuilder):java.lang.StringBuilder");
    }

    public long c() {
        return this.f4733a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        Object obj2 = this.f4737e;
        if (obj2 == null) {
            if (iVar.f4737e != null) {
                return false;
            }
        } else if (!obj2.equals(iVar.f4737e)) {
            return false;
        }
        if (this.f4735c == iVar.f4735c && this.f4736d == iVar.f4736d && this.f4734b == iVar.f4734b && c() == iVar.c()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i10;
        Object obj = this.f4737e;
        if (obj == null) {
            i10 = 1;
        } else {
            i10 = obj.hashCode();
        }
        return (((i10 ^ this.f4735c) + this.f4736d) ^ ((int) this.f4734b)) + ((int) this.f4733a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(80);
        sb.append("[Source: ");
        b(sb);
        sb.append("; line: ");
        sb.append(this.f4735c);
        sb.append(", column: ");
        sb.append(this.f4736d);
        sb.append(']');
        return sb.toString();
    }

    public i(Object obj, long j10, long j11, int i10, int i11) {
        this.f4737e = obj;
        this.f4733a = j10;
        this.f4734b = j11;
        this.f4735c = i10;
        this.f4736d = i11;
    }
}
