package com.fasterxml.jackson.databind.ser.std;

import c3.h;
import java.nio.ByteBuffer;
import k3.c0;
import k3.j;
import u3.f;

public class g extends h0 {
    public g() {
        super(ByteBuffer.class);
    }

    public void acceptJsonFormatVisitor(f fVar, j jVar) {
        fVar.g(jVar);
    }

    /* renamed from: c */
    public void serialize(ByteBuffer byteBuffer, h hVar, c0 c0Var) {
        if (byteBuffer.hasArray()) {
            int position = byteBuffer.position();
            hVar.T(byteBuffer.array(), byteBuffer.arrayOffset() + position, byteBuffer.limit() - position);
            return;
        }
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        if (asReadOnlyBuffer.position() > 0) {
            ByteBuffer byteBuffer2 = (ByteBuffer) asReadOnlyBuffer.rewind();
        }
        d4.f fVar = new d4.f(asReadOnlyBuffer);
        hVar.Q(fVar, asReadOnlyBuffer.remaining());
        fVar.close();
    }
}
