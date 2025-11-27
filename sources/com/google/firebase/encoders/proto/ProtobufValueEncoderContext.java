package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ValueEncoderContext;

class ProtobufValueEncoderContext implements ValueEncoderContext {
    private boolean encoded = false;
    private FieldDescriptor field;
    private final ProtobufDataEncoderContext objEncoderCtx;
    private boolean skipDefault = false;

    public ProtobufValueEncoderContext(ProtobufDataEncoderContext protobufDataEncoderContext) {
        this.objEncoderCtx = protobufDataEncoderContext;
    }

    private void checkNotUsed() {
        if (!this.encoded) {
            this.encoded = true;
            return;
        }
        throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
    }

    public ValueEncoderContext add(String str) {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, (Object) str, this.skipDefault);
        return this;
    }

    public void resetContext(FieldDescriptor fieldDescriptor, boolean z10) {
        this.encoded = false;
        this.field = fieldDescriptor;
        this.skipDefault = z10;
    }

    public ValueEncoderContext add(float f10) {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, f10, this.skipDefault);
        return this;
    }

    public ValueEncoderContext add(double d10) {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, d10, this.skipDefault);
        return this;
    }

    public ValueEncoderContext add(int i10) {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, i10, this.skipDefault);
        return this;
    }

    public ValueEncoderContext add(long j10) {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, j10, this.skipDefault);
        return this;
    }

    public ValueEncoderContext add(boolean z10) {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, z10, this.skipDefault);
        return this;
    }

    public ValueEncoderContext add(byte[] bArr) {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, (Object) bArr, this.skipDefault);
        return this;
    }
}
