package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@ElementTypesAreNonnullByDefault
@Immutable
abstract class AbstractCompositeHashFunction extends AbstractHashFunction {
    private static final long serialVersionUID = 0;
    final HashFunction[] functions;

    public AbstractCompositeHashFunction(HashFunction... hashFunctionArr) {
        for (HashFunction checkNotNull : hashFunctionArr) {
            Preconditions.checkNotNull(checkNotNull);
        }
        this.functions = hashFunctionArr;
    }

    private Hasher fromHashers(final Hasher[] hasherArr) {
        return new Hasher() {
            public HashCode hash() {
                return AbstractCompositeHashFunction.this.makeHash(hasherArr);
            }

            public <T> Hasher putObject(@ParametricNullness T t10, Funnel<? super T> funnel) {
                for (Hasher putObject : hasherArr) {
                    putObject.putObject(t10, funnel);
                }
                return this;
            }

            public Hasher putBoolean(boolean z10) {
                for (Hasher putBoolean : hasherArr) {
                    putBoolean.putBoolean(z10);
                }
                return this;
            }

            public Hasher putByte(byte b10) {
                for (Hasher putByte : hasherArr) {
                    putByte.putByte(b10);
                }
                return this;
            }

            public Hasher putChar(char c10) {
                for (Hasher putChar : hasherArr) {
                    putChar.putChar(c10);
                }
                return this;
            }

            public Hasher putDouble(double d10) {
                for (Hasher putDouble : hasherArr) {
                    putDouble.putDouble(d10);
                }
                return this;
            }

            public Hasher putFloat(float f10) {
                for (Hasher putFloat : hasherArr) {
                    putFloat.putFloat(f10);
                }
                return this;
            }

            public Hasher putInt(int i10) {
                for (Hasher putInt : hasherArr) {
                    putInt.putInt(i10);
                }
                return this;
            }

            public Hasher putLong(long j10) {
                for (Hasher putLong : hasherArr) {
                    putLong.putLong(j10);
                }
                return this;
            }

            public Hasher putShort(short s10) {
                for (Hasher putShort : hasherArr) {
                    putShort.putShort(s10);
                }
                return this;
            }

            public Hasher putString(CharSequence charSequence, Charset charset) {
                for (Hasher putString : hasherArr) {
                    putString.putString(charSequence, charset);
                }
                return this;
            }

            public Hasher putUnencodedChars(CharSequence charSequence) {
                for (Hasher putUnencodedChars : hasherArr) {
                    putUnencodedChars.putUnencodedChars(charSequence);
                }
                return this;
            }

            public Hasher putBytes(byte[] bArr) {
                for (Hasher putBytes : hasherArr) {
                    putBytes.putBytes(bArr);
                }
                return this;
            }

            public Hasher putBytes(byte[] bArr, int i10, int i11) {
                for (Hasher putBytes : hasherArr) {
                    putBytes.putBytes(bArr, i10, i11);
                }
                return this;
            }

            public Hasher putBytes(ByteBuffer byteBuffer) {
                int position = byteBuffer.position();
                for (Hasher putBytes : hasherArr) {
                    Java8Compatibility.position(byteBuffer, position);
                    putBytes.putBytes(byteBuffer);
                }
                return this;
            }
        };
    }

    public abstract HashCode makeHash(Hasher[] hasherArr);

    public Hasher newHasher() {
        int length = this.functions.length;
        Hasher[] hasherArr = new Hasher[length];
        for (int i10 = 0; i10 < length; i10++) {
            hasherArr[i10] = this.functions[i10].newHasher();
        }
        return fromHashers(hasherArr);
    }

    public Hasher newHasher(int i10) {
        Preconditions.checkArgument(i10 >= 0);
        int length = this.functions.length;
        Hasher[] hasherArr = new Hasher[length];
        for (int i11 = 0; i11 < length; i11++) {
            hasherArr[i11] = this.functions[i11].newHasher(i10);
        }
        return fromHashers(hasherArr);
    }
}
