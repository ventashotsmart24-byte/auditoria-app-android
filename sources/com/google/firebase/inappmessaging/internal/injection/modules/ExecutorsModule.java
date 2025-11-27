package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import java.util.concurrent.Executor;
import javax.inject.Singleton;

@Module
public class ExecutorsModule {
    private final Executor backgroundExecutor;
    private final Executor blockingExecutor;
    private final Executor lightWeightExecutor;

    public ExecutorsModule(@Lightweight Executor executor, @Background Executor executor2, @Blocking Executor executor3) {
        this.lightWeightExecutor = executor;
        this.backgroundExecutor = executor2;
        this.blockingExecutor = executor3;
    }

    @Singleton
    @Background
    @Provides
    public Executor providesBackgroundExecutor() {
        return this.backgroundExecutor;
    }

    @Singleton
    @Blocking
    @Provides
    public Executor providesBlockingExecutor() {
        return this.blockingExecutor;
    }

    @Singleton
    @Lightweight
    @Provides
    public Executor providesLightWeightExecutor() {
        return this.lightWeightExecutor;
    }
}
