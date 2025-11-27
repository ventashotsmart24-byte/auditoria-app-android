package com.google.firebase.components;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.dynamicloading.ComponentLoader;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import h3.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public class ComponentRuntime implements ComponentContainer, ComponentLoader {
    private static final Provider<Set<Object>> EMPTY_PROVIDER = new m();
    private final ComponentRegistrarProcessor componentRegistrarProcessor;
    private final Map<Component<?>, Provider<?>> components;
    private final AtomicReference<Boolean> eagerComponentsInitializedWith;
    private final EventBus eventBus;
    private final Map<Qualified<?>, Provider<?>> lazyInstanceMap;
    private final Map<Qualified<?>, LazySet<?>> lazySetMap;
    private final List<Provider<ComponentRegistrar>> unprocessedRegistrarProviders;

    public static final class Builder {
        private final List<Component<?>> additionalComponents = new ArrayList();
        private ComponentRegistrarProcessor componentRegistrarProcessor = ComponentRegistrarProcessor.NOOP;
        private final Executor defaultExecutor;
        private final List<Provider<ComponentRegistrar>> lazyRegistrars = new ArrayList();

        public Builder(Executor executor) {
            this.defaultExecutor = executor;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ ComponentRegistrar lambda$addComponentRegistrar$0(ComponentRegistrar componentRegistrar) {
            return componentRegistrar;
        }

        @CanIgnoreReturnValue
        public Builder addComponent(Component<?> component) {
            this.additionalComponents.add(component);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addComponentRegistrar(ComponentRegistrar componentRegistrar) {
            this.lazyRegistrars.add(new n(componentRegistrar));
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addLazyComponentRegistrars(Collection<Provider<ComponentRegistrar>> collection) {
            this.lazyRegistrars.addAll(collection);
            return this;
        }

        public ComponentRuntime build() {
            return new ComponentRuntime(this.defaultExecutor, this.lazyRegistrars, this.additionalComponents, this.componentRegistrarProcessor);
        }

        @CanIgnoreReturnValue
        public Builder setProcessor(ComponentRegistrarProcessor componentRegistrarProcessor2) {
            this.componentRegistrarProcessor = componentRegistrarProcessor2;
            return this;
        }
    }

    public static Builder builder(Executor executor) {
        return new Builder(executor);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:11|12|37) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r1.remove();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void discoverComponents(java.util.List<com.google.firebase.components.Component<?>> r6) {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            monitor-enter(r5)
            java.util.List<com.google.firebase.inject.Provider<com.google.firebase.components.ComponentRegistrar>> r1 = r5.unprocessedRegistrarProviders     // Catch:{ all -> 0x0098 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0098 }
        L_0x000c:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0098 }
            if (r2 == 0) goto L_0x0031
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0098 }
            com.google.firebase.inject.Provider r2 = (com.google.firebase.inject.Provider) r2     // Catch:{ all -> 0x0098 }
            java.lang.Object r2 = r2.get()     // Catch:{ InvalidRegistrarException -> 0x002d }
            com.google.firebase.components.ComponentRegistrar r2 = (com.google.firebase.components.ComponentRegistrar) r2     // Catch:{ InvalidRegistrarException -> 0x002d }
            if (r2 == 0) goto L_0x000c
            com.google.firebase.components.ComponentRegistrarProcessor r3 = r5.componentRegistrarProcessor     // Catch:{ InvalidRegistrarException -> 0x002d }
            java.util.List r2 = r3.processRegistrar(r2)     // Catch:{ InvalidRegistrarException -> 0x002d }
            r6.addAll(r2)     // Catch:{ InvalidRegistrarException -> 0x002d }
            r1.remove()     // Catch:{ InvalidRegistrarException -> 0x002d }
            goto L_0x000c
        L_0x002d:
            r1.remove()     // Catch:{ all -> 0x0098 }
            goto L_0x000c
        L_0x0031:
            java.util.Map<com.google.firebase.components.Component<?>, com.google.firebase.inject.Provider<?>> r1 = r5.components     // Catch:{ all -> 0x0098 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0098 }
            if (r1 == 0) goto L_0x003d
            com.google.firebase.components.CycleDetector.detect(r6)     // Catch:{ all -> 0x0098 }
            goto L_0x004e
        L_0x003d:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0098 }
            java.util.Map<com.google.firebase.components.Component<?>, com.google.firebase.inject.Provider<?>> r2 = r5.components     // Catch:{ all -> 0x0098 }
            java.util.Set r2 = r2.keySet()     // Catch:{ all -> 0x0098 }
            r1.<init>(r2)     // Catch:{ all -> 0x0098 }
            r1.addAll(r6)     // Catch:{ all -> 0x0098 }
            com.google.firebase.components.CycleDetector.detect(r1)     // Catch:{ all -> 0x0098 }
        L_0x004e:
            java.util.Iterator r1 = r6.iterator()     // Catch:{ all -> 0x0098 }
        L_0x0052:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0098 }
            if (r2 == 0) goto L_0x006e
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0098 }
            com.google.firebase.components.Component r2 = (com.google.firebase.components.Component) r2     // Catch:{ all -> 0x0098 }
            com.google.firebase.components.Lazy r3 = new com.google.firebase.components.Lazy     // Catch:{ all -> 0x0098 }
            com.google.firebase.components.j r4 = new com.google.firebase.components.j     // Catch:{ all -> 0x0098 }
            r4.<init>(r5, r2)     // Catch:{ all -> 0x0098 }
            r3.<init>(r4)     // Catch:{ all -> 0x0098 }
            java.util.Map<com.google.firebase.components.Component<?>, com.google.firebase.inject.Provider<?>> r4 = r5.components     // Catch:{ all -> 0x0098 }
            r4.put(r2, r3)     // Catch:{ all -> 0x0098 }
            goto L_0x0052
        L_0x006e:
            java.util.List r6 = r5.processInstanceComponents(r6)     // Catch:{ all -> 0x0098 }
            r0.addAll(r6)     // Catch:{ all -> 0x0098 }
            java.util.List r6 = r5.processSetComponents()     // Catch:{ all -> 0x0098 }
            r0.addAll(r6)     // Catch:{ all -> 0x0098 }
            r5.processDependencies()     // Catch:{ all -> 0x0098 }
            monitor-exit(r5)     // Catch:{ all -> 0x0098 }
            java.util.Iterator r6 = r0.iterator()
        L_0x0084:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x0094
            java.lang.Object r0 = r6.next()
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            r0.run()
            goto L_0x0084
        L_0x0094:
            r5.maybeInitializeEagerComponents()
            return
        L_0x0098:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0098 }
            goto L_0x009c
        L_0x009b:
            throw r6
        L_0x009c:
            goto L_0x009b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.components.ComponentRuntime.discoverComponents(java.util.List):void");
    }

    private void doInitializeEagerComponents(Map<Component<?>, Provider<?>> map, boolean z10) {
        for (Map.Entry next : map.entrySet()) {
            Component component = (Component) next.getKey();
            Provider provider = (Provider) next.getValue();
            if (component.isAlwaysEager() || (component.isEagerInDefaultApp() && z10)) {
                provider.get();
            }
        }
        this.eventBus.enablePublishingAndFlushPending();
    }

    private static <T> List<T> iterableToList(Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        for (T add : iterable) {
            arrayList.add(add);
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$discoverComponents$0(Component component) {
        return component.getFactory().create(new RestrictedComponentContainer(component, this));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ComponentRegistrar lambda$toProviders$1(ComponentRegistrar componentRegistrar) {
        return componentRegistrar;
    }

    private void maybeInitializeEagerComponents() {
        Boolean bool = this.eagerComponentsInitializedWith.get();
        if (bool != null) {
            doInitializeEagerComponents(this.components, bool.booleanValue());
        }
    }

    private void processDependencies() {
        for (Component next : this.components.keySet()) {
            Iterator<Dependency> it = next.getDependencies().iterator();
            while (true) {
                if (it.hasNext()) {
                    Dependency next2 = it.next();
                    if (next2.isSet() && !this.lazySetMap.containsKey(next2.getInterface())) {
                        this.lazySetMap.put(next2.getInterface(), LazySet.fromCollection(Collections.emptySet()));
                    } else if (this.lazyInstanceMap.containsKey(next2.getInterface())) {
                        continue;
                    } else if (next2.isRequired()) {
                        throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", new Object[]{next, next2.getInterface()}));
                    } else if (!next2.isSet()) {
                        this.lazyInstanceMap.put(next2.getInterface(), OptionalProvider.empty());
                    }
                }
            }
        }
    }

    private List<Runnable> processInstanceComponents(List<Component<?>> list) {
        ArrayList arrayList = new ArrayList();
        for (Component next : list) {
            if (next.isValue()) {
                Provider provider = this.components.get(next);
                for (Qualified qualified : next.getProvidedInterfaces()) {
                    if (!this.lazyInstanceMap.containsKey(qualified)) {
                        this.lazyInstanceMap.put(qualified, provider);
                    } else {
                        arrayList.add(new i((OptionalProvider) this.lazyInstanceMap.get(qualified), provider));
                    }
                }
            }
        }
        return arrayList;
    }

    private List<Runnable> processSetComponents() {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.components.entrySet()) {
            Component component = (Component) next.getKey();
            if (!component.isValue()) {
                Provider provider = (Provider) next.getValue();
                for (Qualified qualified : component.getProvidedInterfaces()) {
                    if (!hashMap.containsKey(qualified)) {
                        hashMap.put(qualified, new HashSet());
                    }
                    ((Set) hashMap.get(qualified)).add(provider);
                }
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (!this.lazySetMap.containsKey(entry.getKey())) {
                this.lazySetMap.put((Qualified) entry.getKey(), LazySet.fromCollection((Collection) entry.getValue()));
            } else {
                LazySet lazySet = this.lazySetMap.get(entry.getKey());
                for (Provider kVar : (Set) entry.getValue()) {
                    arrayList.add(new k(lazySet, kVar));
                }
            }
        }
        return arrayList;
    }

    private static Iterable<Provider<ComponentRegistrar>> toProviders(Iterable<ComponentRegistrar> iterable) {
        ArrayList arrayList = new ArrayList();
        for (ComponentRegistrar lVar : iterable) {
            arrayList.add(new l(lVar));
        }
        return arrayList;
    }

    public /* synthetic */ Object get(Qualified qualified) {
        return f.a(this, qualified);
    }

    public Collection<Component<?>> getAllComponentsForTest() {
        return this.components.keySet();
    }

    public /* synthetic */ Deferred getDeferred(Class cls) {
        return f.c(this, cls);
    }

    public /* synthetic */ Provider getProvider(Class cls) {
        return f.d(this, cls);
    }

    public void initializeAllComponentsForTests() {
        for (Provider<?> provider : this.components.values()) {
            provider.get();
        }
    }

    public void initializeEagerComponents(boolean z10) {
        HashMap hashMap;
        if (b.a(this.eagerComponentsInitializedWith, (Object) null, Boolean.valueOf(z10))) {
            synchronized (this) {
                hashMap = new HashMap(this.components);
            }
            doInitializeEagerComponents(hashMap, z10);
        }
    }

    public /* synthetic */ Set setOf(Qualified qualified) {
        return f.e(this, qualified);
    }

    public /* synthetic */ Provider setOfProvider(Class cls) {
        return f.g(this, cls);
    }

    @Deprecated
    public ComponentRuntime(Executor executor, Iterable<ComponentRegistrar> iterable, Component<?>... componentArr) {
        this(executor, toProviders(iterable), Arrays.asList(componentArr), ComponentRegistrarProcessor.NOOP);
    }

    public /* synthetic */ Object get(Class cls) {
        return f.b(this, cls);
    }

    public <T> Deferred<T> getDeferred(Qualified<T> qualified) {
        Provider<T> provider = getProvider(qualified);
        if (provider == null) {
            return OptionalProvider.empty();
        }
        if (provider instanceof OptionalProvider) {
            return (OptionalProvider) provider;
        }
        return OptionalProvider.of(provider);
    }

    public synchronized <T> Provider<T> getProvider(Qualified<T> qualified) {
        Preconditions.checkNotNull(qualified, "Null interface requested.");
        return this.lazyInstanceMap.get(qualified);
    }

    public /* synthetic */ Set setOf(Class cls) {
        return f.f(this, cls);
    }

    public synchronized <T> Provider<Set<T>> setOfProvider(Qualified<T> qualified) {
        LazySet lazySet = this.lazySetMap.get(qualified);
        if (lazySet != null) {
            return lazySet;
        }
        return EMPTY_PROVIDER;
    }

    private ComponentRuntime(Executor executor, Iterable<Provider<ComponentRegistrar>> iterable, Collection<Component<?>> collection, ComponentRegistrarProcessor componentRegistrarProcessor2) {
        this.components = new HashMap();
        this.lazyInstanceMap = new HashMap();
        this.lazySetMap = new HashMap();
        this.eagerComponentsInitializedWith = new AtomicReference<>();
        EventBus eventBus2 = new EventBus(executor);
        this.eventBus = eventBus2;
        this.componentRegistrarProcessor = componentRegistrarProcessor2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Component.of(eventBus2, EventBus.class, (Class<? super T>[]) new Class[]{Subscriber.class, Publisher.class}));
        arrayList.add(Component.of(this, ComponentLoader.class, (Class<? super T>[]) new Class[0]));
        for (Component next : collection) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        this.unprocessedRegistrarProviders = iterableToList(iterable);
        discoverComponents(arrayList);
    }

    public void discoverComponents() {
        synchronized (this) {
            if (!this.unprocessedRegistrarProviders.isEmpty()) {
                discoverComponents(new ArrayList());
            }
        }
    }
}
