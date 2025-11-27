package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.proto.Protobuf;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.lang.annotation.Annotation;

public final class AtProtobuf {
    private Protobuf.IntEncoding intEncoding = Protobuf.IntEncoding.DEFAULT;
    private int tag;

    public static final class ProtobufImpl implements Protobuf {
        private final Protobuf.IntEncoding intEncoding;
        private final int tag;

        public ProtobufImpl(int i10, Protobuf.IntEncoding intEncoding2) {
            this.tag = i10;
            this.intEncoding = intEncoding2;
        }

        public Class<? extends Annotation> annotationType() {
            return Protobuf.class;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Protobuf)) {
                return false;
            }
            Protobuf protobuf = (Protobuf) obj;
            if (this.tag != protobuf.tag() || !this.intEncoding.equals(protobuf.intEncoding())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (14552422 ^ this.tag) + (this.intEncoding.hashCode() ^ 2041407134);
        }

        public Protobuf.IntEncoding intEncoding() {
            return this.intEncoding;
        }

        public int tag() {
            return this.tag;
        }

        public String toString() {
            return "@com.google.firebase.encoders.proto.Protobuf" + ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN + "tag=" + this.tag + "intEncoding=" + this.intEncoding + ASCIIPropertyListParser.ARRAY_END_TOKEN;
        }
    }

    public static AtProtobuf builder() {
        return new AtProtobuf();
    }

    public Protobuf build() {
        return new ProtobufImpl(this.tag, this.intEncoding);
    }

    public AtProtobuf intEncoding(Protobuf.IntEncoding intEncoding2) {
        this.intEncoding = intEncoding2;
        return this;
    }

    public AtProtobuf tag(int i10) {
        this.tag = i10;
        return this;
    }
}
