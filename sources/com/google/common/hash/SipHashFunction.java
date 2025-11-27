package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@Immutable
final class SipHashFunction extends AbstractHashFunction implements Serializable {
    static final HashFunction SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    private static final long serialVersionUID = 0;

    /* renamed from: c  reason: collision with root package name */
    private final int f10086c;

    /* renamed from: d  reason: collision with root package name */
    private final int f10087d;

    /* renamed from: k0  reason: collision with root package name */
    private final long f10088k0;

    /* renamed from: k1  reason: collision with root package name */
    private final long f10089k1;

    public static final class SipHasher extends AbstractStreamingHasher {
        private static final int CHUNK_SIZE = 8;

        /* renamed from: b  reason: collision with root package name */
        private long f10090b = 0;

        /* renamed from: c  reason: collision with root package name */
        private final int f10091c;

        /* renamed from: d  reason: collision with root package name */
        private final int f10092d;
        private long finalM = 0;

        /* renamed from: v0  reason: collision with root package name */
        private long f10093v0;

        /* renamed from: v1  reason: collision with root package name */
        private long f10094v1;

        /* renamed from: v2  reason: collision with root package name */
        private long f10095v2;

        /* renamed from: v3  reason: collision with root package name */
        private long f10096v3;

        public SipHasher(int i10, int i11, long j10, long j11) {
            super(8);
            this.f10091c = i10;
            this.f10092d = i11;
            this.f10093v0 = 8317987319222330741L ^ j10;
            this.f10094v1 = 7237128888997146477L ^ j11;
            this.f10095v2 = 7816392313619706465L ^ j10;
            this.f10096v3 = 8387220255154660723L ^ j11;
        }

        private void processM(long j10) {
            this.f10096v3 ^= j10;
            sipRound(this.f10091c);
            this.f10093v0 = j10 ^ this.f10093v0;
        }

        private void sipRound(int i10) {
            for (int i11 = 0; i11 < i10; i11++) {
                long j10 = this.f10093v0;
                long j11 = this.f10094v1;
                this.f10093v0 = j10 + j11;
                this.f10095v2 += this.f10096v3;
                this.f10094v1 = Long.rotateLeft(j11, 13);
                long rotateLeft = Long.rotateLeft(this.f10096v3, 16);
                long j12 = this.f10094v1;
                long j13 = this.f10093v0;
                this.f10094v1 = j12 ^ j13;
                this.f10096v3 = rotateLeft ^ this.f10095v2;
                long rotateLeft2 = Long.rotateLeft(j13, 32);
                long j14 = this.f10095v2;
                long j15 = this.f10094v1;
                this.f10095v2 = j14 + j15;
                this.f10093v0 = rotateLeft2 + this.f10096v3;
                this.f10094v1 = Long.rotateLeft(j15, 17);
                long rotateLeft3 = Long.rotateLeft(this.f10096v3, 21);
                long j16 = this.f10094v1;
                long j17 = this.f10095v2;
                this.f10094v1 = j16 ^ j17;
                this.f10096v3 = rotateLeft3 ^ this.f10093v0;
                this.f10095v2 = Long.rotateLeft(j17, 32);
            }
        }

        public HashCode makeHash() {
            long j10 = this.finalM ^ (this.f10090b << 56);
            this.finalM = j10;
            processM(j10);
            this.f10095v2 ^= 255;
            sipRound(this.f10092d);
            return HashCode.fromLong(((this.f10093v0 ^ this.f10094v1) ^ this.f10095v2) ^ this.f10096v3);
        }

        public void process(ByteBuffer byteBuffer) {
            this.f10090b += 8;
            processM(byteBuffer.getLong());
        }

        public void processRemaining(ByteBuffer byteBuffer) {
            this.f10090b += (long) byteBuffer.remaining();
            int i10 = 0;
            while (byteBuffer.hasRemaining()) {
                this.finalM ^= (((long) byteBuffer.get()) & 255) << i10;
                i10 += 8;
            }
        }
    }

    public SipHashFunction(int i10, int i11, long j10, long j11) {
        boolean z10;
        boolean z11 = true;
        if (i10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkArgument(z10, "The number of SipRound iterations (c=%s) during Compression must be positive.", i10);
        Preconditions.checkArgument(i11 <= 0 ? false : z11, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i11);
        this.f10086c = i10;
        this.f10087d = i11;
        this.f10088k0 = j10;
        this.f10089k1 = j11;
    }

    public int bits() {
        return 64;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof SipHashFunction)) {
            return false;
        }
        SipHashFunction sipHashFunction = (SipHashFunction) obj;
        if (this.f10086c == sipHashFunction.f10086c && this.f10087d == sipHashFunction.f10087d && this.f10088k0 == sipHashFunction.f10088k0 && this.f10089k1 == sipHashFunction.f10089k1) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (int) ((((long) ((SipHashFunction.class.hashCode() ^ this.f10086c) ^ this.f10087d)) ^ this.f10088k0) ^ this.f10089k1);
    }

    public Hasher newHasher() {
        return new SipHasher(this.f10086c, this.f10087d, this.f10088k0, this.f10089k1);
    }

    public String toString() {
        int i10 = this.f10086c;
        int i11 = this.f10087d;
        long j10 = this.f10088k0;
        long j11 = this.f10089k1;
        StringBuilder sb = new StringBuilder(81);
        sb.append("Hashing.sipHash");
        sb.append(i10);
        sb.append(i11);
        sb.append("(");
        sb.append(j10);
        sb.append(", ");
        sb.append(j11);
        sb.append(")");
        return sb.toString();
    }
}
