package v0;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.startup.InitializationProvider;
import androidx.startup.R$string;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import w0.b;

public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f9464d;

    /* renamed from: e  reason: collision with root package name */
    public static final Object f9465e = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final Map f9466a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final Set f9467b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public final Context f9468c;

    public a(Context context) {
        this.f9468c = context.getApplicationContext();
    }

    public static a c(Context context) {
        if (f9464d == null) {
            synchronized (f9465e) {
                if (f9464d == null) {
                    f9464d = new a(context);
                }
            }
        }
        return f9464d;
    }

    public void a() {
        try {
            b.a("Startup");
            Bundle bundle = this.f9468c.getPackageManager().getProviderInfo(new ComponentName(this.f9468c.getPackageName(), InitializationProvider.class.getName()), 128).metaData;
            String string = this.f9468c.getString(R$string.androidx_startup);
            if (bundle != null) {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, (String) null))) {
                        Class<?> cls = Class.forName(str);
                        if (b.class.isAssignableFrom(cls)) {
                            this.f9467b.add(cls);
                            b(cls, hashSet);
                        }
                    }
                }
            }
            b.b();
        } catch (PackageManager.NameNotFoundException | ClassNotFoundException e10) {
            throw new c(e10);
        } catch (Throwable th) {
            b.b();
            throw th;
        }
    }

    public Object b(Class cls, Set set) {
        Object obj;
        synchronized (f9465e) {
            if (b.d()) {
                try {
                    b.a(cls.getSimpleName());
                } catch (Throwable th) {
                    b.b();
                    throw th;
                }
            }
            if (!set.contains(cls)) {
                if (!this.f9466a.containsKey(cls)) {
                    set.add(cls);
                    b bVar = (b) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    List<Class> dependencies = bVar.dependencies();
                    if (!dependencies.isEmpty()) {
                        for (Class cls2 : dependencies) {
                            if (!this.f9466a.containsKey(cls2)) {
                                b(cls2, set);
                            }
                        }
                    }
                    obj = bVar.a(this.f9468c);
                    set.remove(cls);
                    this.f9466a.put(cls, obj);
                } else {
                    obj = this.f9466a.get(cls);
                }
                b.b();
            } else {
                throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", new Object[]{cls.getName()}));
            }
        }
        return obj;
    }
}
