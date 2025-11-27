package io.grpc.stub;

import io.grpc.stub.d;
import io.grpc.stub.g;
import y8.c;
import y8.d;

public abstract class b extends d {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public b(d dVar, c cVar) {
        super(dVar, cVar);
    }

    public static <T extends d> T newStub(d.a aVar, y8.d dVar) {
        return newStub(aVar, dVar, c.f19946k);
    }

    public static <T extends d> T newStub(d.a aVar, y8.d dVar, c cVar) {
        return aVar.newStub(dVar, cVar.s(g.f17437c, g.f.BLOCKING));
    }
}
