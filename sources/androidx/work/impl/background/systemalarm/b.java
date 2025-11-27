package androidx.work.impl.background.systemalarm;

import a1.k;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.background.systemalarm.d;
import f1.c;
import f1.d;
import j1.p;
import java.util.ArrayList;
import java.util.List;

public class b {

    /* renamed from: e  reason: collision with root package name */
    public static final String f3418e = k.f("ConstraintsCmdHandler");

    /* renamed from: a  reason: collision with root package name */
    public final Context f3419a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3420b;

    /* renamed from: c  reason: collision with root package name */
    public final d f3421c;

    /* renamed from: d  reason: collision with root package name */
    public final d f3422d;

    public b(Context context, int i10, d dVar) {
        this.f3419a = context;
        this.f3420b = i10;
        this.f3421c = dVar;
        this.f3422d = new d(context, dVar.f(), (c) null);
    }

    public void a() {
        List<p> c10 = this.f3421c.g().n().B().c();
        ConstraintProxy.a(this.f3419a, c10);
        this.f3422d.d(c10);
        ArrayList<p> arrayList = new ArrayList<>(c10.size());
        long currentTimeMillis = System.currentTimeMillis();
        for (p pVar : c10) {
            String str = pVar.f7089a;
            if (currentTimeMillis >= pVar.a() && (!pVar.b() || this.f3422d.c(str))) {
                arrayList.add(pVar);
            }
        }
        for (p pVar2 : arrayList) {
            String str2 = pVar2.f7089a;
            Intent b10 = a.b(this.f3419a, str2);
            k.c().a(f3418e, String.format("Creating a delay_met command for workSpec with id (%s)", new Object[]{str2}), new Throwable[0]);
            d dVar = this.f3421c;
            dVar.k(new d.b(dVar, b10, this.f3420b));
        }
        this.f3422d.e();
    }
}
