package com.dcs.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

public final class V1Bean {

    /* renamed from: s  reason: collision with root package name */
    private String f5119s;
    private int status;

    public V1Bean(String str, int i10) {
        i.g(str, "s");
        this.f5119s = str;
        this.status = i10;
    }

    public static /* synthetic */ V1Bean copy$default(V1Bean v1Bean, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = v1Bean.f5119s;
        }
        if ((i11 & 2) != 0) {
            i10 = v1Bean.status;
        }
        return v1Bean.copy(str, i10);
    }

    public final String component1() {
        return this.f5119s;
    }

    public final int component2() {
        return this.status;
    }

    public final V1Bean copy(String str, int i10) {
        i.g(str, "s");
        return new V1Bean(str, i10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof V1Bean)) {
            return false;
        }
        V1Bean v1Bean = (V1Bean) obj;
        return i.b(this.f5119s, v1Bean.f5119s) && this.status == v1Bean.status;
    }

    public final String getS() {
        return this.f5119s;
    }

    public final int getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (this.f5119s.hashCode() * 31) + this.status;
    }

    public final void setS(String str) {
        i.g(str, "<set-?>");
        this.f5119s = str;
    }

    public final void setStatus(int i10) {
        this.status = i10;
    }

    public String toString() {
        return "V1Bean(s=" + this.f5119s + ", status=" + this.status + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
