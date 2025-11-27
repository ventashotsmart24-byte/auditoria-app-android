package y4;

import java.io.Serializable;

public class b implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public int f19911a;

    /* renamed from: b  reason: collision with root package name */
    public int f19912b;

    /* renamed from: c  reason: collision with root package name */
    public String f19913c;

    /* renamed from: d  reason: collision with root package name */
    public String f19914d;

    /* renamed from: e  reason: collision with root package name */
    public String f19915e;

    /* renamed from: f  reason: collision with root package name */
    public long f19916f;

    /* renamed from: g  reason: collision with root package name */
    public long f19917g;

    /* renamed from: h  reason: collision with root package name */
    public long f19918h;

    public b(int i10, String str, String str2, String str3, long j10, long j11) {
        this.f19911a = str.hashCode() + i10;
        this.f19912b = i10;
        this.f19913c = str;
        this.f19914d = str2;
        this.f19915e = str3;
        this.f19916f = j10;
        this.f19917g = j11;
    }

    public String a() {
        return this.f19915e;
    }

    public String b() {
        return this.f19913c;
    }

    public long c() {
        return this.f19917g;
    }

    public int d() {
        return this.f19911a;
    }

    public long e() {
        return this.f19918h;
    }

    public long f() {
        return this.f19916f;
    }

    public int g() {
        return this.f19912b;
    }

    public String h() {
        return this.f19914d;
    }

    public void i(String str) {
        this.f19913c = str;
    }

    public void j(long j10) {
        this.f19917g = j10;
    }

    public void k(int i10) {
        this.f19911a = i10;
    }

    public void l(long j10) {
        this.f19918h = j10;
    }

    public void m(long j10) {
        this.f19916f = j10;
    }

    public void n(int i10) {
        this.f19912b = i10;
    }

    public void o(String str) {
        this.f19914d = str;
    }

    public b() {
    }
}
