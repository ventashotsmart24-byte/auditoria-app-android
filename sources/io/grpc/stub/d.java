package io.grpc.stub;

import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import y8.b;
import y8.c;
import y8.h;
import y8.j;
import y8.t;

public abstract class d {
    private final c callOptions;
    private final y8.d channel;

    public interface a {
        d newStub(y8.d dVar, c cVar);
    }

    public d(y8.d dVar, c cVar) {
        this.channel = (y8.d) Preconditions.checkNotNull(dVar, "channel");
        this.callOptions = (c) Preconditions.checkNotNull(cVar, "callOptions");
    }

    public abstract d build(y8.d dVar, c cVar);

    public final c getCallOptions() {
        return this.callOptions;
    }

    public final y8.d getChannel() {
        return this.channel;
    }

    public final d withCallCredentials(b bVar) {
        return build(this.channel, this.callOptions.l(bVar));
    }

    @Deprecated
    public final d withChannel(y8.d dVar) {
        return build(dVar, this.callOptions);
    }

    public final d withCompression(String str) {
        return build(this.channel, this.callOptions.m(str));
    }

    public final d withDeadline(@Nullable t tVar) {
        return build(this.channel, this.callOptions.n(tVar));
    }

    public final d withDeadlineAfter(long j10, TimeUnit timeUnit) {
        return build(this.channel, this.callOptions.o(j10, timeUnit));
    }

    public final d withExecutor(Executor executor) {
        return build(this.channel, this.callOptions.p(executor));
    }

    public final d withInterceptors(h... hVarArr) {
        return build(j.b(this.channel, hVarArr), this.callOptions);
    }

    public final d withMaxInboundMessageSize(int i10) {
        return build(this.channel, this.callOptions.q(i10));
    }

    public final d withMaxOutboundMessageSize(int i10) {
        return build(this.channel, this.callOptions.r(i10));
    }

    public final <T> d withOption(c.C0296c cVar, T t10) {
        return build(this.channel, this.callOptions.s(cVar, t10));
    }

    public final d withWaitForReady() {
        return build(this.channel, this.callOptions.u());
    }
}
