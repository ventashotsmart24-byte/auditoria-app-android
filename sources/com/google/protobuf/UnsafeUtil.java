package com.google.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class UnsafeUtil {
    private static final long BOOLEAN_ARRAY_BASE_OFFSET;
    private static final long BOOLEAN_ARRAY_INDEX_SCALE;
    private static final long BUFFER_ADDRESS_OFFSET = fieldOffset(bufferAddressField());
    private static final int BYTE_ARRAY_ALIGNMENT;
    static final long BYTE_ARRAY_BASE_OFFSET;
    private static final long DOUBLE_ARRAY_BASE_OFFSET;
    private static final long DOUBLE_ARRAY_INDEX_SCALE;
    private static final long FLOAT_ARRAY_BASE_OFFSET;
    private static final long FLOAT_ARRAY_INDEX_SCALE;
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = supportsUnsafeArrayOperations();
    private static final boolean HAS_UNSAFE_BYTEBUFFER_OPERATIONS = supportsUnsafeByteBufferOperations();
    private static final long INT_ARRAY_BASE_OFFSET;
    private static final long INT_ARRAY_INDEX_SCALE;
    private static final boolean IS_ANDROID_32 = determineAndroidSupportByAddressSize(Integer.TYPE);
    private static final boolean IS_ANDROID_64 = determineAndroidSupportByAddressSize(Long.TYPE);
    static final boolean IS_BIG_ENDIAN;
    private static final long LONG_ARRAY_BASE_OFFSET;
    private static final long LONG_ARRAY_INDEX_SCALE;
    private static final MemoryAccessor MEMORY_ACCESSOR = getMemoryAccessor();
    private static final Class<?> MEMORY_CLASS = Android.getMemoryClass();
    private static final long OBJECT_ARRAY_BASE_OFFSET;
    private static final long OBJECT_ARRAY_INDEX_SCALE;
    private static final int STRIDE = 8;
    private static final int STRIDE_ALIGNMENT_MASK = 7;
    private static final Unsafe UNSAFE = getUnsafe();

    public static final class Android32MemoryAccessor extends MemoryAccessor {
        private static final long SMALL_ADDRESS_MASK = -1;

        public Android32MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        private static int smallAddress(long j10) {
            return (int) (j10 & -1);
        }

        public void copyMemory(long j10, byte[] bArr, long j11, long j12) {
            throw new UnsupportedOperationException();
        }

        public boolean getBoolean(Object obj, long j10) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                return UnsafeUtil.getBooleanBigEndian(obj, j10);
            }
            return UnsafeUtil.getBooleanLittleEndian(obj, j10);
        }

        public byte getByte(Object obj, long j10) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                return UnsafeUtil.getByteBigEndian(obj, j10);
            }
            return UnsafeUtil.getByteLittleEndian(obj, j10);
        }

        public double getDouble(Object obj, long j10) {
            return Double.longBitsToDouble(getLong(obj, j10));
        }

        public float getFloat(Object obj, long j10) {
            return Float.intBitsToFloat(getInt(obj, j10));
        }

        public int getInt(long j10) {
            throw new UnsupportedOperationException();
        }

        public long getLong(long j10) {
            throw new UnsupportedOperationException();
        }

        public Object getStaticObject(Field field) {
            try {
                return field.get((Object) null);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        public void putBoolean(Object obj, long j10, boolean z10) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putBooleanBigEndian(obj, j10, z10);
            } else {
                UnsafeUtil.putBooleanLittleEndian(obj, j10, z10);
            }
        }

        public void putByte(Object obj, long j10, byte b10) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putByteBigEndian(obj, j10, b10);
            } else {
                UnsafeUtil.putByteLittleEndian(obj, j10, b10);
            }
        }

        public void putDouble(Object obj, long j10, double d10) {
            putLong(obj, j10, Double.doubleToLongBits(d10));
        }

        public void putFloat(Object obj, long j10, float f10) {
            putInt(obj, j10, Float.floatToIntBits(f10));
        }

        public void putInt(long j10, int i10) {
            throw new UnsupportedOperationException();
        }

        public void putLong(long j10, long j11) {
            throw new UnsupportedOperationException();
        }

        public boolean supportsUnsafeByteBufferOperations() {
            return false;
        }

        public void copyMemory(byte[] bArr, long j10, long j11, long j12) {
            throw new UnsupportedOperationException();
        }

        public byte getByte(long j10) {
            throw new UnsupportedOperationException();
        }

        public void putByte(long j10, byte b10) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class Android64MemoryAccessor extends MemoryAccessor {
        public Android64MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        public void copyMemory(long j10, byte[] bArr, long j11, long j12) {
            throw new UnsupportedOperationException();
        }

        public boolean getBoolean(Object obj, long j10) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                return UnsafeUtil.getBooleanBigEndian(obj, j10);
            }
            return UnsafeUtil.getBooleanLittleEndian(obj, j10);
        }

        public byte getByte(Object obj, long j10) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                return UnsafeUtil.getByteBigEndian(obj, j10);
            }
            return UnsafeUtil.getByteLittleEndian(obj, j10);
        }

        public double getDouble(Object obj, long j10) {
            return Double.longBitsToDouble(getLong(obj, j10));
        }

        public float getFloat(Object obj, long j10) {
            return Float.intBitsToFloat(getInt(obj, j10));
        }

        public int getInt(long j10) {
            throw new UnsupportedOperationException();
        }

        public long getLong(long j10) {
            throw new UnsupportedOperationException();
        }

        public Object getStaticObject(Field field) {
            try {
                return field.get((Object) null);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        public void putBoolean(Object obj, long j10, boolean z10) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putBooleanBigEndian(obj, j10, z10);
            } else {
                UnsafeUtil.putBooleanLittleEndian(obj, j10, z10);
            }
        }

        public void putByte(Object obj, long j10, byte b10) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putByteBigEndian(obj, j10, b10);
            } else {
                UnsafeUtil.putByteLittleEndian(obj, j10, b10);
            }
        }

        public void putDouble(Object obj, long j10, double d10) {
            putLong(obj, j10, Double.doubleToLongBits(d10));
        }

        public void putFloat(Object obj, long j10, float f10) {
            putInt(obj, j10, Float.floatToIntBits(f10));
        }

        public void putInt(long j10, int i10) {
            throw new UnsupportedOperationException();
        }

        public void putLong(long j10, long j11) {
            throw new UnsupportedOperationException();
        }

        public boolean supportsUnsafeByteBufferOperations() {
            return false;
        }

        public void copyMemory(byte[] bArr, long j10, long j11, long j12) {
            throw new UnsupportedOperationException();
        }

        public byte getByte(long j10) {
            throw new UnsupportedOperationException();
        }

        public void putByte(long j10, byte b10) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class JvmMemoryAccessor extends MemoryAccessor {
        public JvmMemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        public void copyMemory(long j10, byte[] bArr, long j11, long j12) {
            this.unsafe.copyMemory((Object) null, j10, bArr, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + j11, j12);
        }

        public boolean getBoolean(Object obj, long j10) {
            return this.unsafe.getBoolean(obj, j10);
        }

        public byte getByte(Object obj, long j10) {
            return this.unsafe.getByte(obj, j10);
        }

        public double getDouble(Object obj, long j10) {
            return this.unsafe.getDouble(obj, j10);
        }

        public float getFloat(Object obj, long j10) {
            return this.unsafe.getFloat(obj, j10);
        }

        public int getInt(long j10) {
            return this.unsafe.getInt(j10);
        }

        public long getLong(long j10) {
            return this.unsafe.getLong(j10);
        }

        public Object getStaticObject(Field field) {
            return getObject(this.unsafe.staticFieldBase(field), this.unsafe.staticFieldOffset(field));
        }

        public void putBoolean(Object obj, long j10, boolean z10) {
            this.unsafe.putBoolean(obj, j10, z10);
        }

        public void putByte(Object obj, long j10, byte b10) {
            this.unsafe.putByte(obj, j10, b10);
        }

        public void putDouble(Object obj, long j10, double d10) {
            this.unsafe.putDouble(obj, j10, d10);
        }

        public void putFloat(Object obj, long j10, float f10) {
            this.unsafe.putFloat(obj, j10, f10);
        }

        public void putInt(long j10, int i10) {
            this.unsafe.putInt(j10, i10);
        }

        public void putLong(long j10, long j11) {
            this.unsafe.putLong(j10, j11);
        }

        public boolean supportsUnsafeArrayOperations() {
            Class<Object> cls = Object.class;
            if (!super.supportsUnsafeArrayOperations()) {
                return false;
            }
            try {
                Class<?> cls2 = this.unsafe.getClass();
                Class cls3 = Long.TYPE;
                cls2.getMethod("getByte", new Class[]{cls, cls3});
                cls2.getMethod("putByte", new Class[]{cls, cls3, Byte.TYPE});
                cls2.getMethod("getBoolean", new Class[]{cls, cls3});
                cls2.getMethod("putBoolean", new Class[]{cls, cls3, Boolean.TYPE});
                cls2.getMethod("getFloat", new Class[]{cls, cls3});
                cls2.getMethod("putFloat", new Class[]{cls, cls3, Float.TYPE});
                cls2.getMethod("getDouble", new Class[]{cls, cls3});
                cls2.getMethod("putDouble", new Class[]{cls, cls3, Double.TYPE});
                return true;
            } catch (Throwable th) {
                UnsafeUtil.logMissingMethod(th);
                return false;
            }
        }

        public boolean supportsUnsafeByteBufferOperations() {
            Class<Object> cls = Object.class;
            if (!super.supportsUnsafeByteBufferOperations()) {
                return false;
            }
            try {
                Class<?> cls2 = this.unsafe.getClass();
                Class cls3 = Long.TYPE;
                cls2.getMethod("getByte", new Class[]{cls3});
                cls2.getMethod("putByte", new Class[]{cls3, Byte.TYPE});
                cls2.getMethod("getInt", new Class[]{cls3});
                cls2.getMethod("putInt", new Class[]{cls3, Integer.TYPE});
                cls2.getMethod("getLong", new Class[]{cls3});
                cls2.getMethod("putLong", new Class[]{cls3, cls3});
                cls2.getMethod("copyMemory", new Class[]{cls3, cls3, cls3});
                cls2.getMethod("copyMemory", new Class[]{cls, cls3, cls, cls3, cls3});
                return true;
            } catch (Throwable th) {
                UnsafeUtil.logMissingMethod(th);
                return false;
            }
        }

        public void copyMemory(byte[] bArr, long j10, long j11, long j12) {
            this.unsafe.copyMemory(bArr, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + j10, (Object) null, j11, j12);
        }

        public byte getByte(long j10) {
            return this.unsafe.getByte(j10);
        }

        public void putByte(long j10, byte b10) {
            this.unsafe.putByte(j10, b10);
        }
    }

    public static abstract class MemoryAccessor {
        Unsafe unsafe;

        public MemoryAccessor(Unsafe unsafe2) {
            this.unsafe = unsafe2;
        }

        public final int arrayBaseOffset(Class<?> cls) {
            return this.unsafe.arrayBaseOffset(cls);
        }

        public final int arrayIndexScale(Class<?> cls) {
            return this.unsafe.arrayIndexScale(cls);
        }

        public abstract void copyMemory(long j10, byte[] bArr, long j11, long j12);

        public abstract void copyMemory(byte[] bArr, long j10, long j11, long j12);

        public abstract boolean getBoolean(Object obj, long j10);

        public abstract byte getByte(long j10);

        public abstract byte getByte(Object obj, long j10);

        public abstract double getDouble(Object obj, long j10);

        public abstract float getFloat(Object obj, long j10);

        public abstract int getInt(long j10);

        public final int getInt(Object obj, long j10) {
            return this.unsafe.getInt(obj, j10);
        }

        public abstract long getLong(long j10);

        public final long getLong(Object obj, long j10) {
            return this.unsafe.getLong(obj, j10);
        }

        public final Object getObject(Object obj, long j10) {
            return this.unsafe.getObject(obj, j10);
        }

        public abstract Object getStaticObject(Field field);

        public final long objectFieldOffset(Field field) {
            return this.unsafe.objectFieldOffset(field);
        }

        public abstract void putBoolean(Object obj, long j10, boolean z10);

        public abstract void putByte(long j10, byte b10);

        public abstract void putByte(Object obj, long j10, byte b10);

        public abstract void putDouble(Object obj, long j10, double d10);

        public abstract void putFloat(Object obj, long j10, float f10);

        public abstract void putInt(long j10, int i10);

        public final void putInt(Object obj, long j10, int i10) {
            this.unsafe.putInt(obj, j10, i10);
        }

        public abstract void putLong(long j10, long j11);

        public final void putLong(Object obj, long j10, long j11) {
            this.unsafe.putLong(obj, j10, j11);
        }

        public final void putObject(Object obj, long j10, Object obj2) {
            this.unsafe.putObject(obj, j10, obj2);
        }

        public boolean supportsUnsafeArrayOperations() {
            Class<Class> cls = Class.class;
            Class<Object> cls2 = Object.class;
            Unsafe unsafe2 = this.unsafe;
            if (unsafe2 == null) {
                return false;
            }
            try {
                Class<?> cls3 = unsafe2.getClass();
                cls3.getMethod("objectFieldOffset", new Class[]{Field.class});
                cls3.getMethod("arrayBaseOffset", new Class[]{cls});
                cls3.getMethod("arrayIndexScale", new Class[]{cls});
                Class cls4 = Long.TYPE;
                cls3.getMethod("getInt", new Class[]{cls2, cls4});
                cls3.getMethod("putInt", new Class[]{cls2, cls4, Integer.TYPE});
                cls3.getMethod("getLong", new Class[]{cls2, cls4});
                cls3.getMethod("putLong", new Class[]{cls2, cls4, cls4});
                cls3.getMethod("getObject", new Class[]{cls2, cls4});
                cls3.getMethod("putObject", new Class[]{cls2, cls4, cls2});
                return true;
            } catch (Throwable th) {
                UnsafeUtil.logMissingMethod(th);
                return false;
            }
        }

        public boolean supportsUnsafeByteBufferOperations() {
            Unsafe unsafe2 = this.unsafe;
            if (unsafe2 == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe2.getClass();
                cls.getMethod("objectFieldOffset", new Class[]{Field.class});
                cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
                if (UnsafeUtil.bufferAddressField() == null) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                UnsafeUtil.logMissingMethod(th);
                return false;
            }
        }
    }

    static {
        boolean z10;
        long arrayBaseOffset = (long) arrayBaseOffset(byte[].class);
        BYTE_ARRAY_BASE_OFFSET = arrayBaseOffset;
        Class<boolean[]> cls = boolean[].class;
        BOOLEAN_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls);
        BOOLEAN_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls);
        Class<int[]> cls2 = int[].class;
        INT_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls2);
        INT_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls2);
        Class<long[]> cls3 = long[].class;
        LONG_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls3);
        LONG_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls3);
        Class<float[]> cls4 = float[].class;
        FLOAT_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls4);
        FLOAT_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls4);
        Class<double[]> cls5 = double[].class;
        DOUBLE_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls5);
        DOUBLE_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls5);
        Class<Object[]> cls6 = Object[].class;
        OBJECT_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls6);
        OBJECT_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls6);
        BYTE_ARRAY_ALIGNMENT = (int) (arrayBaseOffset & 7);
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            z10 = true;
        } else {
            z10 = false;
        }
        IS_BIG_ENDIAN = z10;
    }

    private UnsafeUtil() {
    }

    public static long addressOffset(ByteBuffer byteBuffer) {
        return MEMORY_ACCESSOR.getLong(byteBuffer, BUFFER_ADDRESS_OFFSET);
    }

    public static <T> T allocateInstance(Class<T> cls) {
        try {
            return UNSAFE.allocateInstance(cls);
        } catch (InstantiationException e10) {
            throw new IllegalStateException(e10);
        }
    }

    private static int arrayBaseOffset(Class<?> cls) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            return MEMORY_ACCESSOR.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int arrayIndexScale(Class<?> cls) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            return MEMORY_ACCESSOR.arrayIndexScale(cls);
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static Field bufferAddressField() {
        Field field;
        Class<Buffer> cls = Buffer.class;
        if (Android.isOnAndroidDevice() && (field = field(cls, "effectiveDirectAddress")) != null) {
            return field;
        }
        Field field2 = field(cls, "address");
        if (field2 == null || field2.getType() != Long.TYPE) {
            return null;
        }
        return field2;
    }

    public static void copyMemory(byte[] bArr, long j10, long j11, long j12) {
        MEMORY_ACCESSOR.copyMemory(bArr, j10, j11, j12);
    }

    public static boolean determineAndroidSupportByAddressSize(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!Android.isOnAndroidDevice()) {
            return false;
        }
        try {
            Class<?> cls3 = MEMORY_CLASS;
            Class cls4 = Boolean.TYPE;
            cls3.getMethod("peekLong", new Class[]{cls, cls4});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, cls4});
            Class cls5 = Integer.TYPE;
            cls3.getMethod("pokeInt", new Class[]{cls, cls5, cls4});
            cls3.getMethod("peekInt", new Class[]{cls, cls4});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, cls5, cls5});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, cls5, cls5});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Field field(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static long fieldOffset(Field field) {
        MemoryAccessor memoryAccessor;
        if (field == null || (memoryAccessor = MEMORY_ACCESSOR) == null) {
            return -1;
        }
        return memoryAccessor.objectFieldOffset(field);
    }

    private static int firstDifferingByteIndexNativeEndian(long j10, long j11) {
        int i10;
        if (IS_BIG_ENDIAN) {
            i10 = Long.numberOfLeadingZeros(j10 ^ j11);
        } else {
            i10 = Long.numberOfTrailingZeros(j10 ^ j11);
        }
        return i10 >> 3;
    }

    public static boolean getBoolean(Object obj, long j10) {
        return MEMORY_ACCESSOR.getBoolean(obj, j10);
    }

    /* access modifiers changed from: private */
    public static boolean getBooleanBigEndian(Object obj, long j10) {
        if (getByteBigEndian(obj, j10) != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static boolean getBooleanLittleEndian(Object obj, long j10) {
        if (getByteLittleEndian(obj, j10) != 0) {
            return true;
        }
        return false;
    }

    public static byte getByte(Object obj, long j10) {
        return MEMORY_ACCESSOR.getByte(obj, j10);
    }

    /* access modifiers changed from: private */
    public static byte getByteBigEndian(Object obj, long j10) {
        return (byte) ((getInt(obj, -4 & j10) >>> ((int) (((j10 ^ -1) & 3) << 3))) & 255);
    }

    /* access modifiers changed from: private */
    public static byte getByteLittleEndian(Object obj, long j10) {
        return (byte) ((getInt(obj, -4 & j10) >>> ((int) ((j10 & 3) << 3))) & 255);
    }

    public static double getDouble(Object obj, long j10) {
        return MEMORY_ACCESSOR.getDouble(obj, j10);
    }

    public static float getFloat(Object obj, long j10) {
        return MEMORY_ACCESSOR.getFloat(obj, j10);
    }

    public static int getInt(Object obj, long j10) {
        return MEMORY_ACCESSOR.getInt(obj, j10);
    }

    public static long getLong(Object obj, long j10) {
        return MEMORY_ACCESSOR.getLong(obj, j10);
    }

    private static MemoryAccessor getMemoryAccessor() {
        Unsafe unsafe = UNSAFE;
        if (unsafe == null) {
            return null;
        }
        if (!Android.isOnAndroidDevice()) {
            return new JvmMemoryAccessor(unsafe);
        }
        if (IS_ANDROID_64) {
            return new Android64MemoryAccessor(unsafe);
        }
        if (IS_ANDROID_32) {
            return new Android32MemoryAccessor(unsafe);
        }
        return null;
    }

    public static Object getObject(Object obj, long j10) {
        return MEMORY_ACCESSOR.getObject(obj, j10);
    }

    public static Object getStaticObject(Field field) {
        return MEMORY_ACCESSOR.getStaticObject(field);
    }

    public static Unsafe getUnsafe() {
        try {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() {
                public Unsafe run() {
                    Class<Unsafe> cls = Unsafe.class;
                    for (Field field : cls.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get((Object) null);
                        if (cls.isInstance(obj)) {
                            return cls.cast(obj);
                        }
                    }
                    return null;
                }
            });
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean hasUnsafeArrayOperations() {
        return HAS_UNSAFE_ARRAY_OPERATIONS;
    }

    public static boolean hasUnsafeByteBufferOperations() {
        return HAS_UNSAFE_BYTEBUFFER_OPERATIONS;
    }

    public static boolean isAndroid64() {
        return IS_ANDROID_64;
    }

    /* access modifiers changed from: private */
    public static void logMissingMethod(Throwable th) {
        Logger logger = Logger.getLogger(UnsafeUtil.class.getName());
        Level level = Level.WARNING;
        logger.log(level, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static int mismatch(byte[] bArr, int i10, byte[] bArr2, int i11, int i12) {
        if (i10 < 0 || i11 < 0 || i12 < 0 || i10 + i12 > bArr.length || i11 + i12 > bArr2.length) {
            throw new IndexOutOfBoundsException();
        }
        int i13 = 0;
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            int i14 = (BYTE_ARRAY_ALIGNMENT + i10) & 7;
            while (i13 < i12 && (i14 & 7) != 0) {
                if (bArr[i10 + i13] != bArr2[i11 + i13]) {
                    return i13;
                }
                i13++;
                i14++;
            }
            int i15 = ((i12 - i13) & -8) + i13;
            while (i13 < i15) {
                long j10 = BYTE_ARRAY_BASE_OFFSET;
                long j11 = (long) i13;
                long j12 = getLong((Object) bArr, ((long) i10) + j10 + j11);
                long j13 = getLong((Object) bArr2, j10 + ((long) i11) + j11);
                if (j12 != j13) {
                    return i13 + firstDifferingByteIndexNativeEndian(j12, j13);
                }
                i13 += 8;
            }
        }
        while (i13 < i12) {
            if (bArr[i10 + i13] != bArr2[i11 + i13]) {
                return i13;
            }
            i13++;
        }
        return -1;
    }

    public static long objectFieldOffset(Field field) {
        return MEMORY_ACCESSOR.objectFieldOffset(field);
    }

    public static void putBoolean(Object obj, long j10, boolean z10) {
        MEMORY_ACCESSOR.putBoolean(obj, j10, z10);
    }

    /* access modifiers changed from: private */
    public static void putBooleanBigEndian(Object obj, long j10, boolean z10) {
        putByteBigEndian(obj, j10, z10 ? (byte) 1 : 0);
    }

    /* access modifiers changed from: private */
    public static void putBooleanLittleEndian(Object obj, long j10, boolean z10) {
        putByteLittleEndian(obj, j10, z10 ? (byte) 1 : 0);
    }

    public static void putByte(Object obj, long j10, byte b10) {
        MEMORY_ACCESSOR.putByte(obj, j10, b10);
    }

    /* access modifiers changed from: private */
    public static void putByteBigEndian(Object obj, long j10, byte b10) {
        long j11 = -4 & j10;
        int i10 = ((((int) j10) ^ -1) & 3) << 3;
        putInt(obj, j11, ((255 & b10) << i10) | (getInt(obj, j11) & ((255 << i10) ^ -1)));
    }

    /* access modifiers changed from: private */
    public static void putByteLittleEndian(Object obj, long j10, byte b10) {
        long j11 = -4 & j10;
        int i10 = (((int) j10) & 3) << 3;
        putInt(obj, j11, ((255 & b10) << i10) | (getInt(obj, j11) & ((255 << i10) ^ -1)));
    }

    public static void putDouble(Object obj, long j10, double d10) {
        MEMORY_ACCESSOR.putDouble(obj, j10, d10);
    }

    public static void putFloat(Object obj, long j10, float f10) {
        MEMORY_ACCESSOR.putFloat(obj, j10, f10);
    }

    public static void putInt(Object obj, long j10, int i10) {
        MEMORY_ACCESSOR.putInt(obj, j10, i10);
    }

    public static void putLong(Object obj, long j10, long j11) {
        MEMORY_ACCESSOR.putLong(obj, j10, j11);
    }

    public static void putObject(Object obj, long j10, Object obj2) {
        MEMORY_ACCESSOR.putObject(obj, j10, obj2);
    }

    private static boolean supportsUnsafeArrayOperations() {
        MemoryAccessor memoryAccessor = MEMORY_ACCESSOR;
        if (memoryAccessor == null) {
            return false;
        }
        return memoryAccessor.supportsUnsafeArrayOperations();
    }

    private static boolean supportsUnsafeByteBufferOperations() {
        MemoryAccessor memoryAccessor = MEMORY_ACCESSOR;
        if (memoryAccessor == null) {
            return false;
        }
        return memoryAccessor.supportsUnsafeByteBufferOperations();
    }

    public static void copyMemory(long j10, byte[] bArr, long j11, long j12) {
        MEMORY_ACCESSOR.copyMemory(j10, bArr, j11, j12);
    }

    public static boolean getBoolean(boolean[] zArr, long j10) {
        return MEMORY_ACCESSOR.getBoolean(zArr, BOOLEAN_ARRAY_BASE_OFFSET + (j10 * BOOLEAN_ARRAY_INDEX_SCALE));
    }

    public static byte getByte(byte[] bArr, long j10) {
        return MEMORY_ACCESSOR.getByte(bArr, BYTE_ARRAY_BASE_OFFSET + j10);
    }

    public static double getDouble(double[] dArr, long j10) {
        return MEMORY_ACCESSOR.getDouble(dArr, DOUBLE_ARRAY_BASE_OFFSET + (j10 * DOUBLE_ARRAY_INDEX_SCALE));
    }

    public static float getFloat(float[] fArr, long j10) {
        return MEMORY_ACCESSOR.getFloat(fArr, FLOAT_ARRAY_BASE_OFFSET + (j10 * FLOAT_ARRAY_INDEX_SCALE));
    }

    public static int getInt(int[] iArr, long j10) {
        return MEMORY_ACCESSOR.getInt(iArr, INT_ARRAY_BASE_OFFSET + (j10 * INT_ARRAY_INDEX_SCALE));
    }

    public static long getLong(long[] jArr, long j10) {
        return MEMORY_ACCESSOR.getLong(jArr, LONG_ARRAY_BASE_OFFSET + (j10 * LONG_ARRAY_INDEX_SCALE));
    }

    public static Object getObject(Object[] objArr, long j10) {
        return MEMORY_ACCESSOR.getObject(objArr, OBJECT_ARRAY_BASE_OFFSET + (j10 * OBJECT_ARRAY_INDEX_SCALE));
    }

    public static void putBoolean(boolean[] zArr, long j10, boolean z10) {
        MEMORY_ACCESSOR.putBoolean(zArr, BOOLEAN_ARRAY_BASE_OFFSET + (j10 * BOOLEAN_ARRAY_INDEX_SCALE), z10);
    }

    public static void putByte(byte[] bArr, long j10, byte b10) {
        MEMORY_ACCESSOR.putByte(bArr, BYTE_ARRAY_BASE_OFFSET + j10, b10);
    }

    public static void putDouble(double[] dArr, long j10, double d10) {
        MEMORY_ACCESSOR.putDouble(dArr, (j10 * DOUBLE_ARRAY_INDEX_SCALE) + DOUBLE_ARRAY_BASE_OFFSET, d10);
    }

    public static void putFloat(float[] fArr, long j10, float f10) {
        MEMORY_ACCESSOR.putFloat(fArr, FLOAT_ARRAY_BASE_OFFSET + (j10 * FLOAT_ARRAY_INDEX_SCALE), f10);
    }

    public static void putInt(int[] iArr, long j10, int i10) {
        MEMORY_ACCESSOR.putInt(iArr, INT_ARRAY_BASE_OFFSET + (j10 * INT_ARRAY_INDEX_SCALE), i10);
    }

    public static void putLong(long[] jArr, long j10, long j11) {
        MEMORY_ACCESSOR.putLong(jArr, (j10 * LONG_ARRAY_INDEX_SCALE) + LONG_ARRAY_BASE_OFFSET, j11);
    }

    public static void putObject(Object[] objArr, long j10, Object obj) {
        MEMORY_ACCESSOR.putObject(objArr, OBJECT_ARRAY_BASE_OFFSET + (j10 * OBJECT_ARRAY_INDEX_SCALE), obj);
    }

    public static void copyMemory(byte[] bArr, long j10, byte[] bArr2, long j11, long j12) {
        System.arraycopy(bArr, (int) j10, bArr2, (int) j11, (int) j12);
    }

    public static byte getByte(long j10) {
        return MEMORY_ACCESSOR.getByte(j10);
    }

    public static int getInt(long j10) {
        return MEMORY_ACCESSOR.getInt(j10);
    }

    public static long getLong(long j10) {
        return MEMORY_ACCESSOR.getLong(j10);
    }

    public static void putByte(long j10, byte b10) {
        MEMORY_ACCESSOR.putByte(j10, b10);
    }

    public static void putInt(long j10, int i10) {
        MEMORY_ACCESSOR.putInt(j10, i10);
    }

    public static void putLong(long j10, long j11) {
        MEMORY_ACCESSOR.putLong(j10, j11);
    }
}
