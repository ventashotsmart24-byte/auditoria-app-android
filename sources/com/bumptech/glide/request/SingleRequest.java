package com.bumptech.glide.request;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.GlideTrace;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.List;
import java.util.concurrent.Executor;

public final class SingleRequest<R> implements Request, SizeReadyCallback, ResourceCallback {
    private static final String GLIDE_TAG = "Glide";
    private static final boolean IS_VERBOSE_LOGGABLE = Log.isLoggable(TAG, 2);
    private static final String TAG = "GlideRequest";
    private final TransitionFactory<? super R> animationFactory;
    private final Executor callbackExecutor;
    private final Context context;
    private int cookie;
    private volatile Engine engine;
    private Drawable errorDrawable;
    private Drawable fallbackDrawable;
    private final GlideContext glideContext;
    private int height;
    private boolean isCallingCallbacks;
    private Engine.LoadStatus loadStatus;
    private final Object model;
    private final int overrideHeight;
    private final int overrideWidth;
    private Drawable placeholderDrawable;
    private final Priority priority;
    private final RequestCoordinator requestCoordinator;
    private final List<RequestListener<R>> requestListeners;
    private final Object requestLock;
    private final BaseRequestOptions<?> requestOptions;
    private RuntimeException requestOrigin;
    private Resource<R> resource;
    private long startTime;
    private final StateVerifier stateVerifier;
    private Status status;
    private final String tag;
    private final Target<R> target;
    private final RequestListener<R> targetListener;
    private final Class<R> transcodeClass;
    private int width;

    public enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    private SingleRequest(Context context2, GlideContext glideContext2, Object obj, Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i10, int i11, Priority priority2, Target<R> target2, RequestListener<R> requestListener, List<RequestListener<R>> list, RequestCoordinator requestCoordinator2, Engine engine2, TransitionFactory<? super R> transitionFactory, Executor executor) {
        String str;
        if (IS_VERBOSE_LOGGABLE) {
            str = String.valueOf(super.hashCode());
        } else {
            str = null;
        }
        this.tag = str;
        this.stateVerifier = StateVerifier.newInstance();
        this.requestLock = obj;
        this.context = context2;
        this.glideContext = glideContext2;
        this.model = obj2;
        this.transcodeClass = cls;
        this.requestOptions = baseRequestOptions;
        this.overrideWidth = i10;
        this.overrideHeight = i11;
        this.priority = priority2;
        this.target = target2;
        this.targetListener = requestListener;
        this.requestListeners = list;
        this.requestCoordinator = requestCoordinator2;
        this.engine = engine2;
        this.animationFactory = transitionFactory;
        this.callbackExecutor = executor;
        this.status = Status.PENDING;
        if (this.requestOrigin == null && glideContext2.getExperiments().isEnabled(GlideBuilder.LogRequestOrigins.class)) {
            this.requestOrigin = new RuntimeException("Glide request origin trace");
        }
    }

    private void assertNotCallingCallbacks() {
        if (this.isCallingCallbacks) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    private boolean canNotifyCleared() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        if (requestCoordinator2 == null || requestCoordinator2.canNotifyCleared(this)) {
            return true;
        }
        return false;
    }

    private boolean canNotifyStatusChanged() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        if (requestCoordinator2 == null || requestCoordinator2.canNotifyStatusChanged(this)) {
            return true;
        }
        return false;
    }

    private boolean canSetResource() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        if (requestCoordinator2 == null || requestCoordinator2.canSetImage(this)) {
            return true;
        }
        return false;
    }

    private void cancel() {
        assertNotCallingCallbacks();
        this.stateVerifier.throwIfRecycled();
        this.target.removeCallback(this);
        Engine.LoadStatus loadStatus2 = this.loadStatus;
        if (loadStatus2 != null) {
            loadStatus2.cancel();
            this.loadStatus = null;
        }
    }

    private void experimentalNotifyRequestStarted(Object obj) {
        List<RequestListener<R>> list = this.requestListeners;
        if (list != null) {
            for (RequestListener next : list) {
                if (next instanceof ExperimentalRequestListener) {
                    ((ExperimentalRequestListener) next).onRequestStarted(obj);
                }
            }
        }
    }

    private Drawable getErrorDrawable() {
        if (this.errorDrawable == null) {
            Drawable errorPlaceholder = this.requestOptions.getErrorPlaceholder();
            this.errorDrawable = errorPlaceholder;
            if (errorPlaceholder == null && this.requestOptions.getErrorId() > 0) {
                this.errorDrawable = loadDrawable(this.requestOptions.getErrorId());
            }
        }
        return this.errorDrawable;
    }

    private Drawable getFallbackDrawable() {
        if (this.fallbackDrawable == null) {
            Drawable fallbackDrawable2 = this.requestOptions.getFallbackDrawable();
            this.fallbackDrawable = fallbackDrawable2;
            if (fallbackDrawable2 == null && this.requestOptions.getFallbackId() > 0) {
                this.fallbackDrawable = loadDrawable(this.requestOptions.getFallbackId());
            }
        }
        return this.fallbackDrawable;
    }

    private Drawable getPlaceholderDrawable() {
        if (this.placeholderDrawable == null) {
            Drawable placeholderDrawable2 = this.requestOptions.getPlaceholderDrawable();
            this.placeholderDrawable = placeholderDrawable2;
            if (placeholderDrawable2 == null && this.requestOptions.getPlaceholderId() > 0) {
                this.placeholderDrawable = loadDrawable(this.requestOptions.getPlaceholderId());
            }
        }
        return this.placeholderDrawable;
    }

    private boolean isFirstReadyResource() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        if (requestCoordinator2 == null || !requestCoordinator2.getRoot().isAnyResourceSet()) {
            return true;
        }
        return false;
    }

    private Drawable loadDrawable(int i10) {
        Resources.Theme theme;
        if (this.requestOptions.getTheme() != null) {
            theme = this.requestOptions.getTheme();
        } else {
            theme = this.context.getTheme();
        }
        return DrawableDecoderCompat.getDrawable(this.context, i10, theme);
    }

    private void logV(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" this: ");
        sb.append(this.tag);
    }

    private static int maybeApplySizeMultiplier(int i10, float f10) {
        if (i10 == Integer.MIN_VALUE) {
            return i10;
        }
        return Math.round(f10 * ((float) i10));
    }

    private void notifyRequestCoordinatorLoadFailed() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        if (requestCoordinator2 != null) {
            requestCoordinator2.onRequestFailed(this);
        }
    }

    private void notifyRequestCoordinatorLoadSucceeded() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        if (requestCoordinator2 != null) {
            requestCoordinator2.onRequestSuccess(this);
        }
    }

    public static <R> SingleRequest<R> obtain(Context context2, GlideContext glideContext2, Object obj, Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i10, int i11, Priority priority2, Target<R> target2, RequestListener<R> requestListener, List<RequestListener<R>> list, RequestCoordinator requestCoordinator2, Engine engine2, TransitionFactory<? super R> transitionFactory, Executor executor) {
        return new SingleRequest(context2, glideContext2, obj, obj2, cls, baseRequestOptions, i10, i11, priority2, target2, requestListener, list, requestCoordinator2, engine2, transitionFactory, executor);
    }

    private void setErrorPlaceholder() {
        Drawable drawable;
        if (canNotifyStatusChanged()) {
            if (this.model == null) {
                drawable = getFallbackDrawable();
            } else {
                drawable = null;
            }
            if (drawable == null) {
                drawable = getErrorDrawable();
            }
            if (drawable == null) {
                drawable = getPlaceholderDrawable();
            }
            this.target.onLoadFailed(drawable);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00aa, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void begin() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.requestLock
            monitor-enter(r0)
            r5.assertNotCallingCallbacks()     // Catch:{ all -> 0x00b3 }
            com.bumptech.glide.util.pool.StateVerifier r1 = r5.stateVerifier     // Catch:{ all -> 0x00b3 }
            r1.throwIfRecycled()     // Catch:{ all -> 0x00b3 }
            long r1 = com.bumptech.glide.util.LogTime.getLogTime()     // Catch:{ all -> 0x00b3 }
            r5.startTime = r1     // Catch:{ all -> 0x00b3 }
            java.lang.Object r1 = r5.model     // Catch:{ all -> 0x00b3 }
            if (r1 != 0) goto L_0x003c
            int r1 = r5.overrideWidth     // Catch:{ all -> 0x00b3 }
            int r2 = r5.overrideHeight     // Catch:{ all -> 0x00b3 }
            boolean r1 = com.bumptech.glide.util.Util.isValidDimensions(r1, r2)     // Catch:{ all -> 0x00b3 }
            if (r1 == 0) goto L_0x0027
            int r1 = r5.overrideWidth     // Catch:{ all -> 0x00b3 }
            r5.width = r1     // Catch:{ all -> 0x00b3 }
            int r1 = r5.overrideHeight     // Catch:{ all -> 0x00b3 }
            r5.height = r1     // Catch:{ all -> 0x00b3 }
        L_0x0027:
            android.graphics.drawable.Drawable r1 = r5.getFallbackDrawable()     // Catch:{ all -> 0x00b3 }
            if (r1 != 0) goto L_0x002f
            r1 = 5
            goto L_0x0030
        L_0x002f:
            r1 = 3
        L_0x0030:
            com.bumptech.glide.load.engine.GlideException r2 = new com.bumptech.glide.load.engine.GlideException     // Catch:{ all -> 0x00b3 }
            java.lang.String r3 = "Received null model"
            r2.<init>(r3)     // Catch:{ all -> 0x00b3 }
            r5.onLoadFailed(r2, r1)     // Catch:{ all -> 0x00b3 }
            monitor-exit(r0)     // Catch:{ all -> 0x00b3 }
            return
        L_0x003c:
            com.bumptech.glide.request.SingleRequest$Status r2 = r5.status     // Catch:{ all -> 0x00b3 }
            com.bumptech.glide.request.SingleRequest$Status r3 = com.bumptech.glide.request.SingleRequest.Status.RUNNING     // Catch:{ all -> 0x00b3 }
            if (r2 == r3) goto L_0x00ab
            com.bumptech.glide.request.SingleRequest$Status r4 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE     // Catch:{ all -> 0x00b3 }
            if (r2 != r4) goto L_0x0050
            com.bumptech.glide.load.engine.Resource<R> r1 = r5.resource     // Catch:{ all -> 0x00b3 }
            com.bumptech.glide.load.DataSource r2 = com.bumptech.glide.load.DataSource.MEMORY_CACHE     // Catch:{ all -> 0x00b3 }
            r3 = 0
            r5.onResourceReady(r1, r2, r3)     // Catch:{ all -> 0x00b3 }
            monitor-exit(r0)     // Catch:{ all -> 0x00b3 }
            return
        L_0x0050:
            r5.experimentalNotifyRequestStarted(r1)     // Catch:{ all -> 0x00b3 }
            java.lang.String r1 = "GlideRequest"
            int r1 = com.bumptech.glide.util.pool.GlideTrace.beginSectionAsync(r1)     // Catch:{ all -> 0x00b3 }
            r5.cookie = r1     // Catch:{ all -> 0x00b3 }
            com.bumptech.glide.request.SingleRequest$Status r1 = com.bumptech.glide.request.SingleRequest.Status.WAITING_FOR_SIZE     // Catch:{ all -> 0x00b3 }
            r5.status = r1     // Catch:{ all -> 0x00b3 }
            int r2 = r5.overrideWidth     // Catch:{ all -> 0x00b3 }
            int r4 = r5.overrideHeight     // Catch:{ all -> 0x00b3 }
            boolean r2 = com.bumptech.glide.util.Util.isValidDimensions(r2, r4)     // Catch:{ all -> 0x00b3 }
            if (r2 == 0) goto L_0x0071
            int r2 = r5.overrideWidth     // Catch:{ all -> 0x00b3 }
            int r4 = r5.overrideHeight     // Catch:{ all -> 0x00b3 }
            r5.onSizeReady(r2, r4)     // Catch:{ all -> 0x00b3 }
            goto L_0x0076
        L_0x0071:
            com.bumptech.glide.request.target.Target<R> r2 = r5.target     // Catch:{ all -> 0x00b3 }
            r2.getSize(r5)     // Catch:{ all -> 0x00b3 }
        L_0x0076:
            com.bumptech.glide.request.SingleRequest$Status r2 = r5.status     // Catch:{ all -> 0x00b3 }
            if (r2 == r3) goto L_0x007c
            if (r2 != r1) goto L_0x008b
        L_0x007c:
            boolean r1 = r5.canNotifyStatusChanged()     // Catch:{ all -> 0x00b3 }
            if (r1 == 0) goto L_0x008b
            com.bumptech.glide.request.target.Target<R> r1 = r5.target     // Catch:{ all -> 0x00b3 }
            android.graphics.drawable.Drawable r2 = r5.getPlaceholderDrawable()     // Catch:{ all -> 0x00b3 }
            r1.onLoadStarted(r2)     // Catch:{ all -> 0x00b3 }
        L_0x008b:
            boolean r1 = IS_VERBOSE_LOGGABLE     // Catch:{ all -> 0x00b3 }
            if (r1 == 0) goto L_0x00a9
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b3 }
            r1.<init>()     // Catch:{ all -> 0x00b3 }
            java.lang.String r2 = "finished run method in "
            r1.append(r2)     // Catch:{ all -> 0x00b3 }
            long r2 = r5.startTime     // Catch:{ all -> 0x00b3 }
            double r2 = com.bumptech.glide.util.LogTime.getElapsedMillis(r2)     // Catch:{ all -> 0x00b3 }
            r1.append(r2)     // Catch:{ all -> 0x00b3 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00b3 }
            r5.logV(r1)     // Catch:{ all -> 0x00b3 }
        L_0x00a9:
            monitor-exit(r0)     // Catch:{ all -> 0x00b3 }
            return
        L_0x00ab:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00b3 }
            java.lang.String r2 = "Cannot restart a running request"
            r1.<init>(r2)     // Catch:{ all -> 0x00b3 }
            throw r1     // Catch:{ all -> 0x00b3 }
        L_0x00b3:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00b3 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.begin():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0038, code lost:
        if (r1 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
        r5.engine.release(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clear() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.requestLock
            monitor-enter(r0)
            r5.assertNotCallingCallbacks()     // Catch:{ all -> 0x0040 }
            com.bumptech.glide.util.pool.StateVerifier r1 = r5.stateVerifier     // Catch:{ all -> 0x0040 }
            r1.throwIfRecycled()     // Catch:{ all -> 0x0040 }
            com.bumptech.glide.request.SingleRequest$Status r1 = r5.status     // Catch:{ all -> 0x0040 }
            com.bumptech.glide.request.SingleRequest$Status r2 = com.bumptech.glide.request.SingleRequest.Status.CLEARED     // Catch:{ all -> 0x0040 }
            if (r1 != r2) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x0040 }
            return
        L_0x0013:
            r5.cancel()     // Catch:{ all -> 0x0040 }
            com.bumptech.glide.load.engine.Resource<R> r1 = r5.resource     // Catch:{ all -> 0x0040 }
            r3 = 0
            if (r1 == 0) goto L_0x001e
            r5.resource = r3     // Catch:{ all -> 0x0040 }
            goto L_0x001f
        L_0x001e:
            r1 = r3
        L_0x001f:
            boolean r3 = r5.canNotifyCleared()     // Catch:{ all -> 0x0040 }
            if (r3 == 0) goto L_0x002e
            com.bumptech.glide.request.target.Target<R> r3 = r5.target     // Catch:{ all -> 0x0040 }
            android.graphics.drawable.Drawable r4 = r5.getPlaceholderDrawable()     // Catch:{ all -> 0x0040 }
            r3.onLoadCleared(r4)     // Catch:{ all -> 0x0040 }
        L_0x002e:
            java.lang.String r3 = "GlideRequest"
            int r4 = r5.cookie     // Catch:{ all -> 0x0040 }
            com.bumptech.glide.util.pool.GlideTrace.endSectionAsync(r3, r4)     // Catch:{ all -> 0x0040 }
            r5.status = r2     // Catch:{ all -> 0x0040 }
            monitor-exit(r0)     // Catch:{ all -> 0x0040 }
            if (r1 == 0) goto L_0x003f
            com.bumptech.glide.load.engine.Engine r0 = r5.engine
            r0.release(r1)
        L_0x003f:
            return
        L_0x0040:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0040 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.clear():void");
    }

    public Object getLock() {
        this.stateVerifier.throwIfRecycled();
        return this.requestLock;
    }

    public boolean isAnyResourceSet() {
        boolean z10;
        synchronized (this.requestLock) {
            if (this.status == Status.COMPLETE) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    public boolean isCleared() {
        boolean z10;
        synchronized (this.requestLock) {
            if (this.status == Status.CLEARED) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    public boolean isComplete() {
        boolean z10;
        synchronized (this.requestLock) {
            if (this.status == Status.COMPLETE) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    public boolean isEquivalentTo(Request request) {
        int i10;
        int i11;
        Object obj;
        Class<R> cls;
        BaseRequestOptions<?> baseRequestOptions;
        Priority priority2;
        int i12;
        int i13;
        int i14;
        Object obj2;
        Class<R> cls2;
        BaseRequestOptions<?> baseRequestOptions2;
        Priority priority3;
        int i15;
        Request request2 = request;
        if (!(request2 instanceof SingleRequest)) {
            return false;
        }
        synchronized (this.requestLock) {
            i10 = this.overrideWidth;
            i11 = this.overrideHeight;
            obj = this.model;
            cls = this.transcodeClass;
            baseRequestOptions = this.requestOptions;
            priority2 = this.priority;
            List<RequestListener<R>> list = this.requestListeners;
            if (list != null) {
                i12 = list.size();
            } else {
                i12 = 0;
            }
        }
        SingleRequest singleRequest = (SingleRequest) request2;
        synchronized (singleRequest.requestLock) {
            i13 = singleRequest.overrideWidth;
            i14 = singleRequest.overrideHeight;
            obj2 = singleRequest.model;
            cls2 = singleRequest.transcodeClass;
            baseRequestOptions2 = singleRequest.requestOptions;
            priority3 = singleRequest.priority;
            List<RequestListener<R>> list2 = singleRequest.requestListeners;
            if (list2 != null) {
                i15 = list2.size();
            } else {
                i15 = 0;
            }
        }
        if (i10 == i13 && i11 == i14 && Util.bothModelsNullEquivalentOrEquals(obj, obj2) && cls.equals(cls2) && Util.bothBaseRequestOptionsNullEquivalentOrEquals(baseRequestOptions, baseRequestOptions2) && priority2 == priority3 && i12 == i15) {
            return true;
        }
        return false;
    }

    public boolean isRunning() {
        boolean z10;
        synchronized (this.requestLock) {
            Status status2 = this.status;
            if (status2 != Status.RUNNING) {
                if (status2 != Status.WAITING_FOR_SIZE) {
                    z10 = false;
                }
            }
            z10 = true;
        }
        return z10;
    }

    public void onLoadFailed(GlideException glideException) {
        onLoadFailed(glideException, 5);
    }

    public void onResourceReady(Resource<?> resource2, DataSource dataSource, boolean z10) {
        this.stateVerifier.throwIfRecycled();
        Resource<?> resource3 = null;
        try {
            synchronized (this.requestLock) {
                try {
                    this.loadStatus = null;
                    if (resource2 == null) {
                        onLoadFailed(new GlideException("Expected to receive a Resource<R> with an object of " + this.transcodeClass + " inside, but instead got null."));
                        return;
                    }
                    Object obj = resource2.get();
                    if (obj != null) {
                        if (this.transcodeClass.isAssignableFrom(obj.getClass())) {
                            if (!canSetResource()) {
                                try {
                                    this.resource = null;
                                    this.status = Status.COMPLETE;
                                    GlideTrace.endSectionAsync(TAG, this.cookie);
                                    this.engine.release(resource2);
                                    return;
                                } catch (Throwable th) {
                                    resource3 = resource2;
                                    th = th;
                                    throw th;
                                }
                            } else {
                                onResourceReady(resource2, obj, dataSource, z10);
                                return;
                            }
                        }
                    }
                    this.resource = null;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Expected to receive an object of ");
                    sb.append(this.transcodeClass);
                    sb.append(" but instead got ");
                    sb.append(obj != null ? obj.getClass() : "");
                    sb.append("{");
                    sb.append(obj);
                    sb.append("} inside Resource{");
                    sb.append(resource2);
                    sb.append("}.");
                    sb.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                    onLoadFailed(new GlideException(sb.toString()));
                    this.engine.release(resource2);
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            }
        } catch (Throwable th3) {
            if (resource3 != null) {
                this.engine.release(resource3);
            }
            throw th3;
        }
    }

    public void onSizeReady(int i10, int i11) {
        Object obj;
        this.stateVerifier.throwIfRecycled();
        Object obj2 = this.requestLock;
        synchronized (obj2) {
            try {
                boolean z10 = IS_VERBOSE_LOGGABLE;
                if (z10) {
                    logV("Got onSizeReady in " + LogTime.getElapsedMillis(this.startTime));
                }
                if (this.status == Status.WAITING_FOR_SIZE) {
                    Status status2 = Status.RUNNING;
                    this.status = status2;
                    float sizeMultiplier = this.requestOptions.getSizeMultiplier();
                    this.width = maybeApplySizeMultiplier(i10, sizeMultiplier);
                    this.height = maybeApplySizeMultiplier(i11, sizeMultiplier);
                    if (z10) {
                        logV("finished setup for calling load in " + LogTime.getElapsedMillis(this.startTime));
                    }
                    Status status3 = status2;
                    boolean z11 = z10;
                    Status status4 = status3;
                    obj = obj2;
                    try {
                        this.loadStatus = this.engine.load(this.glideContext, this.model, this.requestOptions.getSignature(), this.width, this.height, this.requestOptions.getResourceClass(), this.transcodeClass, this.priority, this.requestOptions.getDiskCacheStrategy(), this.requestOptions.getTransformations(), this.requestOptions.isTransformationRequired(), this.requestOptions.isScaleOnlyOrNoTransform(), this.requestOptions.getOptions(), this.requestOptions.isMemoryCacheable(), this.requestOptions.getUseUnlimitedSourceGeneratorsPool(), this.requestOptions.getUseAnimationPool(), this.requestOptions.getOnlyRetrieveFromCache(), this, this.callbackExecutor);
                        if (this.status != status4) {
                            this.loadStatus = null;
                        }
                        if (z11) {
                            logV("finished onSizeReady in " + LogTime.getElapsedMillis(this.startTime));
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                obj = obj2;
                throw th;
            }
        }
    }

    public void pause() {
        synchronized (this.requestLock) {
            if (isRunning()) {
                clear();
            }
        }
    }

    public String toString() {
        Object obj;
        Class<R> cls;
        synchronized (this.requestLock) {
            obj = this.model;
            cls = this.transcodeClass;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + cls + "]";
    }

    /* JADX INFO: finally extract failed */
    private void onLoadFailed(GlideException glideException, int i10) {
        boolean z10;
        this.stateVerifier.throwIfRecycled();
        synchronized (this.requestLock) {
            glideException.setOrigin(this.requestOrigin);
            int logLevel = this.glideContext.getLogLevel();
            if (logLevel <= i10) {
                StringBuilder sb = new StringBuilder();
                sb.append("Load failed for [");
                sb.append(this.model);
                sb.append("] with dimensions [");
                sb.append(this.width);
                sb.append("x");
                sb.append(this.height);
                sb.append("]");
                if (logLevel <= 4) {
                    glideException.logRootCauses(GLIDE_TAG);
                }
            }
            this.loadStatus = null;
            this.status = Status.FAILED;
            notifyRequestCoordinatorLoadFailed();
            boolean z11 = true;
            this.isCallingCallbacks = true;
            try {
                List<RequestListener<R>> list = this.requestListeners;
                if (list != null) {
                    z10 = false;
                    for (RequestListener<R> onLoadFailed : list) {
                        z10 |= onLoadFailed.onLoadFailed(glideException, this.model, this.target, isFirstReadyResource());
                    }
                } else {
                    z10 = false;
                }
                RequestListener<R> requestListener = this.targetListener;
                if (requestListener == null || !requestListener.onLoadFailed(glideException, this.model, this.target, isFirstReadyResource())) {
                    z11 = false;
                }
                if (!z10 && !z11) {
                    setErrorPlaceholder();
                }
                this.isCallingCallbacks = false;
                GlideTrace.endSectionAsync(TAG, this.cookie);
            } catch (Throwable th) {
                this.isCallingCallbacks = false;
                throw th;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00c8 A[Catch:{ all -> 0x00df }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void onResourceReady(com.bumptech.glide.load.engine.Resource<R> r16, R r17, com.bumptech.glide.load.DataSource r18, boolean r19) {
        /*
            r15 = this;
            r1 = r15
            r0 = r18
            boolean r9 = r15.isFirstReadyResource()
            com.bumptech.glide.request.SingleRequest$Status r2 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE
            r1.status = r2
            r2 = r16
            r1.resource = r2
            com.bumptech.glide.GlideContext r2 = r1.glideContext
            int r2 = r2.getLogLevel()
            r3 = 3
            if (r2 > r3) goto L_0x0066
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Finished loading "
            r2.append(r3)
            java.lang.Class r3 = r17.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            java.lang.String r3 = " from "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r3 = " for "
            r2.append(r3)
            java.lang.Object r3 = r1.model
            r2.append(r3)
            java.lang.String r3 = " with size ["
            r2.append(r3)
            int r3 = r1.width
            r2.append(r3)
            java.lang.String r3 = "x"
            r2.append(r3)
            int r3 = r1.height
            r2.append(r3)
            java.lang.String r3 = "] in "
            r2.append(r3)
            long r3 = r1.startTime
            double r3 = com.bumptech.glide.util.LogTime.getElapsedMillis(r3)
            r2.append(r3)
            java.lang.String r3 = " ms"
            r2.append(r3)
        L_0x0066:
            r15.notifyRequestCoordinatorLoadSucceeded()
            r10 = 1
            r1.isCallingCallbacks = r10
            r11 = 0
            java.util.List<com.bumptech.glide.request.RequestListener<R>> r2 = r1.requestListeners     // Catch:{ all -> 0x00df }
            if (r2 == 0) goto L_0x00ae
            java.util.Iterator r12 = r2.iterator()     // Catch:{ all -> 0x00df }
            r8 = 0
        L_0x0076:
            boolean r2 = r12.hasNext()     // Catch:{ all -> 0x00df }
            if (r2 == 0) goto L_0x00af
            java.lang.Object r2 = r12.next()     // Catch:{ all -> 0x00df }
            r13 = r2
            com.bumptech.glide.request.RequestListener r13 = (com.bumptech.glide.request.RequestListener) r13     // Catch:{ all -> 0x00df }
            java.lang.Object r4 = r1.model     // Catch:{ all -> 0x00df }
            com.bumptech.glide.request.target.Target<R> r5 = r1.target     // Catch:{ all -> 0x00df }
            r2 = r13
            r3 = r17
            r6 = r18
            r7 = r9
            boolean r2 = r2.onResourceReady(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00df }
            r14 = r8 | r2
            boolean r2 = r13 instanceof com.bumptech.glide.request.ExperimentalRequestListener     // Catch:{ all -> 0x00df }
            if (r2 == 0) goto L_0x00ac
            r2 = r13
            com.bumptech.glide.request.ExperimentalRequestListener r2 = (com.bumptech.glide.request.ExperimentalRequestListener) r2     // Catch:{ all -> 0x00df }
            java.lang.Object r4 = r1.model     // Catch:{ all -> 0x00df }
            com.bumptech.glide.request.target.Target<R> r5 = r1.target     // Catch:{ all -> 0x00df }
            r3 = r17
            r6 = r18
            r7 = r9
            r8 = r19
            boolean r2 = r2.onResourceReady(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00df }
            r2 = r2 | r14
            r8 = r2
            goto L_0x0076
        L_0x00ac:
            r8 = r14
            goto L_0x0076
        L_0x00ae:
            r8 = 0
        L_0x00af:
            com.bumptech.glide.request.RequestListener<R> r2 = r1.targetListener     // Catch:{ all -> 0x00df }
            if (r2 == 0) goto L_0x00c3
            java.lang.Object r4 = r1.model     // Catch:{ all -> 0x00df }
            com.bumptech.glide.request.target.Target<R> r5 = r1.target     // Catch:{ all -> 0x00df }
            r3 = r17
            r6 = r18
            r7 = r9
            boolean r2 = r2.onResourceReady(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00df }
            if (r2 == 0) goto L_0x00c3
            goto L_0x00c4
        L_0x00c3:
            r10 = 0
        L_0x00c4:
            r2 = r8 | r10
            if (r2 != 0) goto L_0x00d5
            com.bumptech.glide.request.transition.TransitionFactory<? super R> r2 = r1.animationFactory     // Catch:{ all -> 0x00df }
            com.bumptech.glide.request.transition.Transition r0 = r2.build(r0, r9)     // Catch:{ all -> 0x00df }
            com.bumptech.glide.request.target.Target<R> r2 = r1.target     // Catch:{ all -> 0x00df }
            r3 = r17
            r2.onResourceReady(r3, r0)     // Catch:{ all -> 0x00df }
        L_0x00d5:
            r1.isCallingCallbacks = r11
            java.lang.String r0 = "GlideRequest"
            int r2 = r1.cookie
            com.bumptech.glide.util.pool.GlideTrace.endSectionAsync(r0, r2)
            return
        L_0x00df:
            r0 = move-exception
            r1.isCallingCallbacks = r11
            goto L_0x00e4
        L_0x00e3:
            throw r0
        L_0x00e4:
            goto L_0x00e3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.onResourceReady(com.bumptech.glide.load.engine.Resource, java.lang.Object, com.bumptech.glide.load.DataSource, boolean):void");
    }
}
