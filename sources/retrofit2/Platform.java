package retrofit2;

import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import retrofit2.CallAdapter;
import retrofit2.Converter;

class Platform {
    private static final Platform PLATFORM = findPlatform();
    private final boolean hasJava8Types;

    public static final class Android extends Platform {

        public static class MainThreadExecutor implements Executor {
            private final Handler handler = new Handler(Looper.getMainLooper());

            public void execute(Runnable runnable) {
                this.handler.post(runnable);
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Android() {
            /*
                r2 = this;
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 24
                if (r0 < r1) goto L_0x0008
                r0 = 1
                goto L_0x0009
            L_0x0008:
                r0 = 0
            L_0x0009:
                r2.<init>(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: retrofit2.Platform.Android.<init>():void");
        }

        public Executor defaultCallbackExecutor() {
            return new MainThreadExecutor();
        }
    }

    public Platform(boolean z10) {
        this.hasJava8Types = z10;
    }

    private static Platform findPlatform() {
        try {
            Class.forName("android.os.Build");
            return new Android();
        } catch (ClassNotFoundException unused) {
            return new Platform(true);
        }
    }

    public static Platform get() {
        return PLATFORM;
    }

    public List<? extends CallAdapter.Factory> defaultCallAdapterFactories(@Nullable Executor executor) {
        DefaultCallAdapterFactory defaultCallAdapterFactory = new DefaultCallAdapterFactory(executor);
        if (!this.hasJava8Types) {
            return Collections.singletonList(defaultCallAdapterFactory);
        }
        return Arrays.asList(new CallAdapter.Factory[]{CompletableFutureCallAdapterFactory.INSTANCE, defaultCallAdapterFactory});
    }

    public int defaultCallAdapterFactoriesSize() {
        if (this.hasJava8Types) {
            return 2;
        }
        return 1;
    }

    @Nullable
    public Executor defaultCallbackExecutor() {
        return null;
    }

    public List<? extends Converter.Factory> defaultConverterFactories() {
        if (this.hasJava8Types) {
            return Collections.singletonList(OptionalConverterFactory.INSTANCE);
        }
        return Collections.emptyList();
    }

    public int defaultConverterFactoriesSize() {
        return this.hasJava8Types ? 1 : 0;
    }

    @Nullable
    public Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, @Nullable Object... objArr) {
        Constructor declaredConstructor = i.a().getDeclaredConstructor(new Class[]{Class.class, Integer.TYPE});
        declaredConstructor.setAccessible(true);
        return j.a(declaredConstructor.newInstance(new Object[]{cls, -1})).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
    }

    public boolean isDefaultMethod(Method method) {
        if (!this.hasJava8Types || !method.isDefault()) {
            return false;
        }
        return true;
    }
}
