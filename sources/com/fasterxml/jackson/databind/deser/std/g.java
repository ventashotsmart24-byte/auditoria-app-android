package com.fasterxml.jackson.databind.deser.std;

import c3.k;
import c4.f;
import java.nio.ByteBuffer;

public class g extends e0 {
    public g() {
        super(ByteBuffer.class);
    }

    /* renamed from: a */
    public ByteBuffer deserialize(k kVar, k3.g gVar) {
        return ByteBuffer.wrap(kVar.u());
    }

    /* renamed from: b */
    public ByteBuffer deserialize(k kVar, k3.g gVar, ByteBuffer byteBuffer) {
        d4.g gVar2 = new d4.g(byteBuffer);
        kVar.w0(gVar.M(), gVar2);
        gVar2.close();
        return byteBuffer;
    }

    public f logicalType() {
        return f.Binary;
    }
}
