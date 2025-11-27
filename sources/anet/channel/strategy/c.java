package anet.channel.strategy;

import anet.channel.util.HttpConstant;
import java.util.concurrent.ConcurrentHashMap;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f3916a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private boolean f3917b = true;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static c f3918a = new c();

        private a() {
        }
    }

    public void a(boolean z10) {
        this.f3917b = z10;
    }

    public void b(String str) {
        this.f3916a.put(str, HttpConstant.HTTP);
    }

    public String a(String str) {
        if (!this.f3917b) {
            return null;
        }
        String str2 = this.f3916a.get(str);
        if (str2 != null) {
            return str2;
        }
        this.f3916a.put(str, "https");
        return "https";
    }
}
