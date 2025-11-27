package n8;

import com.titan.ranger.bean.Program;
import t9.i;

public final class e implements b {

    /* renamed from: a  reason: collision with root package name */
    public String f19065a;

    /* renamed from: b  reason: collision with root package name */
    public Program f19066b;

    /* renamed from: c  reason: collision with root package name */
    public Program f19067c;

    public Program a() {
        return this.f19067c;
    }

    public void b() {
        this.f19067c = null;
    }

    public void c() {
        this.f19065a = null;
        this.f19066b = null;
    }

    public void d(Program program) {
        i.g(program, "castProgram");
        this.f19067c = program;
    }

    public String e() {
        return this.f19065a;
    }

    public void f(Program program) {
        i.g(program, "program");
        this.f19066b = program;
    }

    public void g(String str) {
        i.g(str, "programCode");
        this.f19065a = str;
    }

    public Program h() {
        return this.f19066b;
    }
}
