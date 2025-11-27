package com.hpplay.a.a.a.a;

import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class c implements Iterable<String> {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, String> f10431a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<b> f10432b = new ArrayList<>();

    public c(Map<String, String> map) {
        String str = map.get("cookie");
        if (str != null) {
            for (String trim : str.split(";")) {
                String[] split = trim.trim().split(Operator.Operation.EQUALS);
                if (split.length == 2) {
                    this.f10431a.put(split[0], split[1]);
                }
            }
        }
    }

    public void a(String str) {
        a(str, "-delete-", -30);
    }

    public String b(String str) {
        return this.f10431a.get(str);
    }

    public Iterator<String> iterator() {
        return this.f10431a.keySet().iterator();
    }

    public void a(b bVar) {
        this.f10432b.add(bVar);
    }

    public void a(String str, String str2, int i10) {
        this.f10432b.add(new b(str, str2, b.a(i10)));
    }

    public void a(com.hpplay.a.a.a.c.c cVar) {
        Iterator<b> it = this.f10432b.iterator();
        while (it.hasNext()) {
            cVar.a(it.next().a());
        }
    }
}
