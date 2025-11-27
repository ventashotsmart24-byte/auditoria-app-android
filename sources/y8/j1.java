package y8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

public abstract class j1 {

    public class a implements Comparator {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f20032a;

        public a(b bVar) {
            this.f20032a = bVar;
        }

        public int compare(Object obj, Object obj2) {
            int b10 = this.f20032a.b(obj) - this.f20032a.b(obj2);
            if (b10 != 0) {
                return b10;
            }
            return obj.getClass().getName().compareTo(obj2.getClass().getName());
        }
    }

    public interface b {
        boolean a(Object obj);

        int b(Object obj);
    }

    public static Object a(Class cls, Class cls2) {
        try {
            return cls2.asSubclass(cls).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassCastException unused) {
            return null;
        } catch (Throwable th) {
            throw new ServiceConfigurationError(String.format("Provider %s could not be instantiated %s", new Object[]{cls2.getName(), th}), th);
        }
    }

    public static Iterable b(Class cls, Iterable iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Object a10 = a(cls, (Class) it.next());
            if (a10 != null) {
                arrayList.add(a10);
            }
        }
        return arrayList;
    }

    public static Iterable c(Class cls, ClassLoader classLoader) {
        ServiceLoader load = ServiceLoader.load(cls, classLoader);
        if (!load.iterator().hasNext()) {
            return ServiceLoader.load(cls);
        }
        return load;
    }

    public static boolean d(ClassLoader classLoader) {
        try {
            Class.forName("android.app.Application", false, classLoader);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static List e(Class cls, Iterable iterable, ClassLoader classLoader, b bVar) {
        Iterable iterable2;
        if (d(classLoader)) {
            iterable2 = b(cls, iterable);
        } else {
            iterable2 = c(cls, classLoader);
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : iterable2) {
            if (bVar.a(next)) {
                arrayList.add(next);
            }
        }
        Collections.sort(arrayList, Collections.reverseOrder(new a(bVar)));
        return Collections.unmodifiableList(arrayList);
    }
}
