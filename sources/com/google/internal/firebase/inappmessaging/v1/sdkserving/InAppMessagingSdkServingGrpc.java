package com.google.internal.firebase.inappmessaging.v1.sdkserving;

import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.stub.a;
import io.grpc.stub.b;
import io.grpc.stub.d;
import io.grpc.stub.g;
import io.grpc.stub.i;
import io.grpc.stub.j;
import y8.c;
import y8.d;
import y8.h1;
import y8.i1;
import y8.w0;

public final class InAppMessagingSdkServingGrpc {
    private static final int METHODID_FETCH_ELIGIBLE_CAMPAIGNS = 0;
    public static final String SERVICE_NAME = "google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServing";
    private static volatile w0 getFetchEligibleCampaignsMethod;
    private static volatile i1 serviceDescriptor;

    public static final class InAppMessagingSdkServingBlockingStub extends b {
        public FetchEligibleCampaignsResponse fetchEligibleCampaigns(FetchEligibleCampaignsRequest fetchEligibleCampaignsRequest) {
            return (FetchEligibleCampaignsResponse) g.d(getChannel(), InAppMessagingSdkServingGrpc.getFetchEligibleCampaignsMethod(), getCallOptions(), fetchEligibleCampaignsRequest);
        }

        private InAppMessagingSdkServingBlockingStub(d dVar, c cVar) {
            super(dVar, cVar);
        }

        public InAppMessagingSdkServingBlockingStub build(d dVar, c cVar) {
            return new InAppMessagingSdkServingBlockingStub(dVar, cVar);
        }
    }

    public static final class InAppMessagingSdkServingFutureStub extends io.grpc.stub.c {
        public ListenableFuture<FetchEligibleCampaignsResponse> fetchEligibleCampaigns(FetchEligibleCampaignsRequest fetchEligibleCampaignsRequest) {
            return g.f(getChannel().h(InAppMessagingSdkServingGrpc.getFetchEligibleCampaignsMethod(), getCallOptions()), fetchEligibleCampaignsRequest);
        }

        private InAppMessagingSdkServingFutureStub(d dVar, c cVar) {
            super(dVar, cVar);
        }

        public InAppMessagingSdkServingFutureStub build(d dVar, c cVar) {
            return new InAppMessagingSdkServingFutureStub(dVar, cVar);
        }
    }

    public static abstract class InAppMessagingSdkServingImplBase {
        public final h1 bindService() {
            return h1.a(InAppMessagingSdkServingGrpc.getServiceDescriptor()).a(InAppMessagingSdkServingGrpc.getFetchEligibleCampaignsMethod(), i.a(new MethodHandlers(this, 0))).c();
        }

        public void fetchEligibleCampaigns(FetchEligibleCampaignsRequest fetchEligibleCampaignsRequest, j jVar) {
            i.b(InAppMessagingSdkServingGrpc.getFetchEligibleCampaignsMethod(), jVar);
        }
    }

    public static final class InAppMessagingSdkServingStub extends a {
        public void fetchEligibleCampaigns(FetchEligibleCampaignsRequest fetchEligibleCampaignsRequest, j jVar) {
            g.a(getChannel().h(InAppMessagingSdkServingGrpc.getFetchEligibleCampaignsMethod(), getCallOptions()), fetchEligibleCampaignsRequest, jVar);
        }

        private InAppMessagingSdkServingStub(d dVar, c cVar) {
            super(dVar, cVar);
        }

        public InAppMessagingSdkServingStub build(d dVar, c cVar) {
            return new InAppMessagingSdkServingStub(dVar, cVar);
        }
    }

    private InAppMessagingSdkServingGrpc() {
    }

    public static w0 getFetchEligibleCampaignsMethod() {
        w0 w0Var = getFetchEligibleCampaignsMethod;
        if (w0Var == null) {
            synchronized (InAppMessagingSdkServingGrpc.class) {
                w0Var = getFetchEligibleCampaignsMethod;
                if (w0Var == null) {
                    w0Var = w0.g().f(w0.d.UNARY).b(w0.b(SERVICE_NAME, "FetchEligibleCampaigns")).e(true).c(e9.b.b(FetchEligibleCampaignsRequest.getDefaultInstance())).d(e9.b.b(FetchEligibleCampaignsResponse.getDefaultInstance())).a();
                    getFetchEligibleCampaignsMethod = w0Var;
                }
            }
        }
        return w0Var;
    }

    public static i1 getServiceDescriptor() {
        i1 i1Var = serviceDescriptor;
        if (i1Var == null) {
            synchronized (InAppMessagingSdkServingGrpc.class) {
                i1Var = serviceDescriptor;
                if (i1Var == null) {
                    i1Var = i1.c(SERVICE_NAME).f(getFetchEligibleCampaignsMethod()).g();
                    serviceDescriptor = i1Var;
                }
            }
        }
        return i1Var;
    }

    public static InAppMessagingSdkServingBlockingStub newBlockingStub(d dVar) {
        return (InAppMessagingSdkServingBlockingStub) b.newStub(new d.a() {
            public InAppMessagingSdkServingBlockingStub newStub(y8.d dVar, c cVar) {
                return new InAppMessagingSdkServingBlockingStub(dVar, cVar);
            }
        }, dVar);
    }

    public static InAppMessagingSdkServingFutureStub newFutureStub(y8.d dVar) {
        return (InAppMessagingSdkServingFutureStub) io.grpc.stub.c.newStub(new d.a() {
            public InAppMessagingSdkServingFutureStub newStub(y8.d dVar, c cVar) {
                return new InAppMessagingSdkServingFutureStub(dVar, cVar);
            }
        }, dVar);
    }

    public static InAppMessagingSdkServingStub newStub(y8.d dVar) {
        return (InAppMessagingSdkServingStub) a.newStub(new d.a() {
            public InAppMessagingSdkServingStub newStub(y8.d dVar, c cVar) {
                return new InAppMessagingSdkServingStub(dVar, cVar);
            }
        }, dVar);
    }

    public static final class MethodHandlers<Req, Resp> implements i.a, i.b {
        private final int methodId;
        private final InAppMessagingSdkServingImplBase serviceImpl;

        public MethodHandlers(InAppMessagingSdkServingImplBase inAppMessagingSdkServingImplBase, int i10) {
            this.serviceImpl = inAppMessagingSdkServingImplBase;
            this.methodId = i10;
        }

        public void invoke(Req req, j jVar) {
            if (this.methodId == 0) {
                this.serviceImpl.fetchEligibleCampaigns((FetchEligibleCampaignsRequest) req, jVar);
                return;
            }
            throw new AssertionError();
        }

        public j invoke(j jVar) {
            throw new AssertionError();
        }
    }
}
