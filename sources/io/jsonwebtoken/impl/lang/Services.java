package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Arrays;
import io.jsonwebtoken.lang.Assert;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class Services {
    private static final List<ClassLoaderAccessor> CLASS_LOADER_ACCESSORS = Arrays.asList(new ClassLoaderAccessor[]{new ClassLoaderAccessor() {
        public ClassLoader getClassLoader() {
            return Thread.currentThread().getContextClassLoader();
        }
    }, new ClassLoaderAccessor() {
        public ClassLoader getClassLoader() {
            return Services.class.getClassLoader();
        }
    }, new ClassLoaderAccessor() {
        public ClassLoader getClassLoader() {
            return ClassLoader.getSystemClassLoader();
        }
    }});
    private static final ConcurrentMap<Class<?>, Object> SERVICES = new ConcurrentHashMap();

    public interface ClassLoaderAccessor {
        ClassLoader getClassLoader();
    }

    private Services() {
    }

    private static <T> T findCached(Class<T> cls) {
        Assert.notNull(cls, "Service interface cannot be null.");
        Object obj = SERVICES.get(cls);
        if (obj != null) {
            return Assert.isInstanceOf(cls, obj, "Unexpected cached service implementation type.");
        }
        return null;
    }

    public static <T> T get(Class<T> cls) {
        T findCached = findCached(cls);
        if (findCached != null) {
            return findCached;
        }
        T loadFirst = loadFirst(cls);
        SERVICES.putIfAbsent(cls, loadFirst);
        return loadFirst;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.Class, java.lang.Class<T>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> T loadFirst(java.lang.Class<T> r3) {
        /*
            java.util.List<io.jsonwebtoken.impl.lang.Services$ClassLoaderAccessor> r0 = CLASS_LOADER_ACCESSORS
            java.util.Iterator r0 = r0.iterator()
        L_0x0006:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0033
            java.lang.Object r1 = r0.next()
            io.jsonwebtoken.impl.lang.Services$ClassLoaderAccessor r1 = (io.jsonwebtoken.impl.lang.Services.ClassLoaderAccessor) r1
            java.lang.ClassLoader r1 = r1.getClassLoader()
            java.util.ServiceLoader r1 = java.util.ServiceLoader.load(r3, r1)
            java.lang.String r2 = "JDK ServiceLoader#load should never return null."
            io.jsonwebtoken.lang.Assert.stateNotNull(r1, r2)
            java.util.Iterator r1 = r1.iterator()
            java.lang.String r2 = "JDK ServiceLoader#iterator() should never return null."
            io.jsonwebtoken.lang.Assert.stateNotNull(r1, r2)
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0006
            java.lang.Object r3 = r1.next()
            return r3
        L_0x0033:
            io.jsonwebtoken.impl.lang.UnavailableImplementationException r0 = new io.jsonwebtoken.impl.lang.UnavailableImplementationException
            r0.<init>(r3)
            goto L_0x003a
        L_0x0039:
            throw r0
        L_0x003a:
            goto L_0x0039
        */
        throw new UnsupportedOperationException("Method not decompiled: io.jsonwebtoken.impl.lang.Services.loadFirst(java.lang.Class):java.lang.Object");
    }

    public static void reload() {
        SERVICES.clear();
    }
}
