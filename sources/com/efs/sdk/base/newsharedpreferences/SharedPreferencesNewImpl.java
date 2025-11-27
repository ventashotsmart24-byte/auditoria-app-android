package com.efs.sdk.base.newsharedpreferences;

import android.content.SharedPreferences;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class SharedPreferencesNewImpl implements SharedPreferences {
    private static final String BACKUP_FILE_SUFFIX = ".bak";
    private static final int CONTENT_LENGTH_LOST = 1;
    private static final int CONTENT_OVER_SIZE = 7;
    private static final int DATA_TYPE_ERROR = 8;
    private static final int DATA_TYPE_INVALID = 9;
    private static final long DELAY_TIME_TO_SAVE = 1000;
    private static final byte FINISH_MARK = 18;
    private static final int FINISH_MARK_LENGTH = 1;
    private static final int ID_LENGTH = 4;
    private static final int INIT_EXCEPTION = 10;
    private static final int LOAD_BAK_FILE = 12;
    private static final int MAPPED_BUFFER_ERROR = 4;
    private static final int MAX_HANDLERTHREAD = 3;
    private static final long MAX_LOCK_FILE_TIME = 10000;
    private static final int MAX_NUM = Integer.MAX_VALUE;
    private static final int MAX_TRY_TIME = 6;
    private static final int MIN_INCREASE_LENGTH = 1024;
    private static final int MODIFY_ID_LOST = 2;
    private static final int OTHER_EXCEPTION = 11;
    private static final String TAG = "SharedPreferencesNew";
    private static final long TRY_RELOAD_INTERVAL = 60;
    private static final int TRY_SAVE_TIME_DELAY = 2000;
    private static final int TYPE_CAST_EXCEPTION = 13;
    private static final int VALUE_LOST = 3;
    private static final Object mFileMonitorSyncObj = new Object();
    private static HandlerThread[] mHandlerThreadPool = new HandlerThread[3];
    private static final int mSaveMessageID = 21310;
    private static ExecutorService sCachedThreadPool = Executors.newCachedThreadPool();
    /* access modifiers changed from: private */
    public String mBackupFilePath;
    private int mCurTryTime;
    private Vector<SharedPreferences.Editor> mEditorList;
    private OnSharedPreferenceErrorListener mErrorListener;
    private File mFile;
    private FileChannel mFileChannel;
    private FileMonitor mFileMonitor;
    private Handler mHandler;
    private boolean mIsSaving;
    /* access modifiers changed from: private */
    public final ArrayList<SharedPreferences.OnSharedPreferenceChangeListener> mListeners;
    private boolean mLoaded;
    private final LinkedHashMap<String, Object> mMap;
    private MappedByteBuffer mMappedByteBuffer;
    private int mModifyErrorCnt;
    /* access modifiers changed from: private */
    public int mModifyID;
    private RunnableEx mSaveRunnable;
    private final Object mSyncObj;
    private final Object mSyncSaveObj;
    private final Runnable mTryReloadRunnable;
    private long mTryReloadStartTime;

    public static class ByteFloatUtils {
        private ByteFloatUtils() {
        }

        public static float bytesToFloat(byte[] bArr) {
            return ByteBuffer.wrap(bArr).getFloat();
        }

        public static byte[] floatToBytes(float f10) {
            return ByteBuffer.allocate(4).putFloat(f10).array();
        }
    }

    public static class ByteIntUtils {
        private ByteIntUtils() {
        }

        public static int bytesToInt(byte[] bArr) {
            return ByteBuffer.wrap(bArr).getInt();
        }

        public static byte[] intToBytes(int i10) {
            return ByteBuffer.allocate(4).putInt(i10).array();
        }
    }

    public static class ByteLongUtils {
        private ByteLongUtils() {
        }

        public static long bytesToLong(byte[] bArr) {
            return ByteBuffer.wrap(bArr).getLong();
        }

        public static byte[] longToBytes(long j10) {
            return ByteBuffer.allocate(8).putLong(j10).array();
        }
    }

    public final class EditorImpl implements SharedPreferences.Editor {
        private boolean mClear;
        private HashMap<String, Object> mModified = new HashMap<>();

        public EditorImpl() {
        }

        public final void apply() {
            SharedPreferencesNewImpl.this.save(this, false, false, true);
        }

        public final SharedPreferences.Editor clear() {
            synchronized (this) {
                this.mClear = true;
            }
            return this;
        }

        public final boolean commit() {
            SharedPreferencesNewImpl.this.save(this, false, true, false);
            return true;
        }

        public final boolean doClear() {
            boolean z10;
            synchronized (this) {
                z10 = this.mClear;
                this.mClear = false;
            }
            return z10;
        }

        public final HashMap<String, Object> getAll() {
            HashMap<String, Object> hashMap;
            synchronized (this) {
                hashMap = this.mModified;
            }
            return hashMap;
        }

        public final SharedPreferences.Editor putBoolean(String str, boolean z10) {
            synchronized (this) {
                this.mModified.put(str, Boolean.valueOf(z10));
            }
            return this;
        }

        public final SharedPreferences.Editor putFloat(String str, float f10) {
            synchronized (this) {
                this.mModified.put(str, Float.valueOf(f10));
            }
            return this;
        }

        public final SharedPreferences.Editor putInt(String str, int i10) {
            synchronized (this) {
                this.mModified.put(str, Integer.valueOf(i10));
            }
            return this;
        }

        public final SharedPreferences.Editor putLong(String str, long j10) {
            synchronized (this) {
                this.mModified.put(str, Long.valueOf(j10));
            }
            return this;
        }

        public final SharedPreferences.Editor putString(String str, String str2) {
            synchronized (this) {
                this.mModified.put(str, str2);
            }
            return this;
        }

        public final SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            throw new RuntimeException("putStringSet is not supported!");
        }

        public final SharedPreferences.Editor remove(String str) {
            synchronized (this) {
                this.mModified.put(str, (Object) null);
            }
            return this;
        }
    }

    public final class FileMonitor extends FileObserver {
        public FileMonitor(String str, int i10) {
            super(str, i10);
        }

        public final void onEvent(int i10, String str) {
            if (SharedPreferencesNewImpl.this.mListeners.size() > 0) {
                SharedPreferencesNewImpl.this.tryReload();
            } else {
                stopWatching();
            }
        }
    }

    public interface OnSharedPreferenceErrorListener {
        void onError(String str, int i10, long j10);
    }

    public static abstract class RunnableEx implements Runnable {
        private Object mArg;

        public Object getArg() {
            return this.mArg;
        }

        public void setArg(Object obj) {
            this.mArg = obj;
        }
    }

    public class SUPPORTED_TYPE {
        static final byte TYPE_BOOLEAN = 4;
        static final byte TYPE_FLOAT = 2;
        static final byte TYPE_INT = 1;
        static final byte TYPE_LONG = 3;
        static final byte TYPE_STRING = 5;

        private SUPPORTED_TYPE() {
        }
    }

    static {
        for (int i10 = 0; i10 < 3; i10++) {
            mHandlerThreadPool[i10] = new HandlerThread("newsp".concat(String.valueOf(i10)));
            mHandlerThreadPool[i10].start();
        }
    }

    public SharedPreferencesNewImpl(File file) {
        this(file, 0, (OnSharedPreferenceErrorListener) null, false);
    }

    private MappedByteBuffer allocBuffer(int i10) {
        int i11;
        MappedByteBuffer mappedByteBuffer = this.mMappedByteBuffer;
        if (mappedByteBuffer != null) {
            i11 = mappedByteBuffer.position();
        } else {
            i11 = 0;
        }
        try {
            this.mMappedByteBuffer = this.mFileChannel.map(FileChannel.MapMode.READ_WRITE, 0, (long) i10);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        MappedByteBuffer mappedByteBuffer2 = this.mMappedByteBuffer;
        if (mappedByteBuffer2 != null) {
            mappedByteBuffer2.position(i11);
        }
        return this.mMappedByteBuffer;
    }

    private void awaitLoadedLocked() {
        if (!this.mLoaded) {
            synchronized (this) {
                while (!this.mLoaded) {
                    try {
                        wait();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
        tryReload();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.nio.channels.FileChannel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void backup() {
        /*
            r10 = this;
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x0036 }
            java.lang.String r2 = r10.mBackupFilePath     // Catch:{ all -> 0x0036 }
            r1.<init>(r2)     // Catch:{ all -> 0x0036 }
            boolean r2 = r1.exists()     // Catch:{ all -> 0x0036 }
            if (r2 != 0) goto L_0x0011
            r1.createNewFile()     // Catch:{ all -> 0x0036 }
        L_0x0011:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x0036 }
            r2.<init>(r1)     // Catch:{ all -> 0x0036 }
            java.nio.channels.FileChannel r0 = r2.getChannel()     // Catch:{ all -> 0x0030 }
            java.nio.channels.FileChannel r3 = r10.mFileChannel     // Catch:{ all -> 0x0030 }
            r4 = 0
            java.nio.MappedByteBuffer r1 = r10.mMappedByteBuffer     // Catch:{ all -> 0x0030 }
            int r1 = r1.capacity()     // Catch:{ all -> 0x0030 }
            long r6 = (long) r1     // Catch:{ all -> 0x0030 }
            r8 = r0
            r3.transferTo(r4, r6, r8)     // Catch:{ all -> 0x0030 }
            r10.safeClose(r2)
            r10.safeClose(r0)
            return
        L_0x0030:
            r1 = move-exception
            r9 = r1
            r1 = r0
            r0 = r2
            r2 = r9
            goto L_0x0039
        L_0x0036:
            r1 = move-exception
            r2 = r1
            r1 = r0
        L_0x0039:
            r2.printStackTrace()     // Catch:{ all -> 0x0043 }
            r10.safeClose(r0)
            r10.safeClose(r1)
            return
        L_0x0043:
            r2 = move-exception
            r10.safeClose(r0)
            r10.safeClose(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.backup():void");
    }

    private byte getBCCCode(byte[] bArr) {
        byte b10 = 0;
        for (byte b11 : bArr) {
            b10 = (byte) (b10 ^ b11);
        }
        return b10;
    }

    private byte[] getBytes(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            if (obj instanceof String) {
                return ((String) obj).getBytes();
            }
            if (obj instanceof Boolean) {
                int i10 = 1;
                byte[] bArr = new byte[1];
                if (!((Boolean) obj).booleanValue()) {
                    i10 = 0;
                }
                bArr[0] = (byte) i10;
                return bArr;
            } else if (obj instanceof Float) {
                return ByteFloatUtils.floatToBytes(((Float) obj).floatValue());
            } else {
                if (obj instanceof Integer) {
                    return ByteIntUtils.intToBytes(((Integer) obj).intValue());
                }
                if (obj instanceof Long) {
                    return ByteLongUtils.longToBytes(((Long) obj).longValue());
                }
                return null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0054, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005e, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getContentLength() {
        /*
            r7 = this;
            java.nio.MappedByteBuffer r0 = r7.mMappedByteBuffer
            r1 = -1
            if (r0 == 0) goto L_0x0062
            java.nio.channels.FileChannel r0 = r7.mFileChannel
            if (r0 != 0) goto L_0x000a
            goto L_0x0062
        L_0x000a:
            java.lang.Object r0 = r7.mSyncObj
            monitor-enter(r0)
            java.nio.MappedByteBuffer r2 = r7.mMappedByteBuffer     // Catch:{ all -> 0x005f }
            r3 = 0
            r2.position(r3)     // Catch:{ all -> 0x005f }
            r2 = 4
            byte[] r3 = new byte[r2]     // Catch:{ all -> 0x005f }
            java.nio.MappedByteBuffer r4 = r7.mMappedByteBuffer     // Catch:{ all -> 0x005f }
            r7.safeBufferGet(r4, r3)     // Catch:{ all -> 0x005f }
            int r4 = com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.ByteIntUtils.bytesToInt(r3)     // Catch:{ all -> 0x005f }
            java.nio.MappedByteBuffer r5 = r7.mMappedByteBuffer     // Catch:{ all -> 0x005f }
            r5.position(r2)     // Catch:{ all -> 0x005f }
            java.nio.MappedByteBuffer r2 = r7.mMappedByteBuffer     // Catch:{ all -> 0x005f }
            byte r2 = r2.get()     // Catch:{ all -> 0x005f }
            r5 = 18
            if (r2 == r5) goto L_0x0034
            byte r3 = r7.getMaskByte(r3)     // Catch:{ all -> 0x005f }
            if (r2 != r3) goto L_0x0036
        L_0x0034:
            if (r4 >= 0) goto L_0x0055
        L_0x0036:
            com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl$OnSharedPreferenceErrorListener r2 = r7.mErrorListener     // Catch:{ all -> 0x005f }
            if (r2 == 0) goto L_0x0053
            java.io.File r3 = r7.mFile     // Catch:{ all -> 0x005f }
            if (r3 == 0) goto L_0x0043
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x005f }
            goto L_0x0044
        L_0x0043:
            r3 = 0
        L_0x0044:
            java.io.File r4 = r7.mFile     // Catch:{ all -> 0x005f }
            if (r4 == 0) goto L_0x004d
            long r4 = r4.length()     // Catch:{ all -> 0x005f }
            goto L_0x004f
        L_0x004d:
            r4 = 0
        L_0x004f:
            r6 = 1
            r2.onError(r3, r6, r4)     // Catch:{ all -> 0x005f }
        L_0x0053:
            monitor-exit(r0)     // Catch:{ all -> 0x005f }
            return r1
        L_0x0055:
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r4 <= r1) goto L_0x005d
            r4 = 2147483647(0x7fffffff, float:NaN)
        L_0x005d:
            monitor-exit(r0)     // Catch:{ all -> 0x005f }
            return r4
        L_0x005f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005f }
            throw r1
        L_0x0062:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.getContentLength():int");
    }

    private Pair<Integer, byte[][]> getDataBytes() {
        byte[][] bArr;
        ArrayList arrayList;
        synchronized (this.mMap) {
            bArr = new byte[(this.mMap.size() * 5)][];
            arrayList = new ArrayList(this.mMap.entrySet());
            this.mEditorList.clear();
        }
        int i10 = 0;
        int i11 = 0;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Map.Entry entry = (Map.Entry) arrayList.get(size);
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (!(str == null || str.trim().length() <= 0 || value == null)) {
                byte[] bytes = str.getBytes();
                byte[] intToBytes = ByteIntUtils.intToBytes(bytes.length);
                bArr[i11] = intToBytes;
                bArr[i11 + 1] = bytes;
                int length = i10 + intToBytes.length + bytes.length;
                byte[] bytes2 = getBytes(value);
                byte[] intToBytes2 = ByteIntUtils.intToBytes(bytes2.length);
                bArr[i11 + 2] = intToBytes2;
                bArr[i11 + 3] = bytes2;
                bArr[i11 + 4] = new byte[]{(byte) getObjectType(value)};
                i10 = length + intToBytes2.length + bytes2.length + 1;
                i11 += 5;
            }
        }
        return new Pair<>(Integer.valueOf(i10), bArr);
    }

    private HandlerThread getHandlerThread() {
        int nextInt = new Random().nextInt();
        if (nextInt < 0) {
            nextInt = -nextInt;
        }
        return mHandlerThreadPool[nextInt % 3];
    }

    private byte getMaskByte(byte[] bArr) {
        return getBCCCode(bArr);
    }

    private Object getObjectByType(byte[] bArr, int i10) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        if (i10 == 5) {
            try {
                return new String(bArr);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        } else {
            boolean z10 = true;
            if (i10 == 4) {
                if (bArr[0] != 1) {
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            } else if (i10 == 2) {
                return Float.valueOf(ByteFloatUtils.bytesToFloat(bArr));
            } else {
                if (i10 == 1) {
                    return Integer.valueOf(ByteIntUtils.bytesToInt(bArr));
                }
                if (i10 == 3) {
                    return Long.valueOf(ByteLongUtils.bytesToLong(bArr));
                }
                return null;
            }
        }
    }

    private int getObjectType(Object obj) {
        if (obj instanceof String) {
            return 5;
        }
        if (obj instanceof Boolean) {
            return 4;
        }
        if (obj instanceof Float) {
            return 2;
        }
        if (obj instanceof Integer) {
            return 1;
        }
        if (obj instanceof Long) {
            return 3;
        }
        return 0;
    }

    private Pair<byte[], Integer> getOneString(byte[] bArr, int i10) {
        int i11;
        byte[] bArr2;
        byte[] bArr3 = new byte[4];
        System.arraycopy(bArr, i10, bArr3, 0, 4);
        int i12 = i10 + 4;
        byte b10 = bArr[i12];
        if (b10 == 18 || b10 == getMaskByte(bArr3)) {
            int i13 = i12 + 1;
            int bytesToInt = ByteIntUtils.bytesToInt(bArr3);
            if (bytesToInt < 0 || (i11 = i13 + bytesToInt) >= bArr.length || bytesToInt > Integer.MAX_VALUE) {
                throw new Exception("length string is invalid");
            }
            if (bytesToInt != 0) {
                bArr2 = new byte[bytesToInt];
                System.arraycopy(bArr, i13, bArr2, 0, bytesToInt);
                byte b11 = bArr[i11];
                if (b11 == 18 || b11 == getMaskByte(bArr2)) {
                    i13 = i11;
                } else {
                    throw new Exception("Stored bytes' finish mark missing");
                }
            } else {
                bArr2 = null;
            }
            return new Pair<>(bArr2, Integer.valueOf(i13 + 1));
        }
        throw new Exception("length string's finish mark missing");
    }

    private int increaseModifyID() {
        int i10 = (this.mModifyID + 1) % Integer.MAX_VALUE;
        this.mModifyID = i10;
        return i10;
    }

    private boolean initBuffer() {
        boolean z10 = true;
        if (this.mMappedByteBuffer != null) {
            return true;
        }
        try {
            if (!this.mFile.exists()) {
                this.mFile.getParentFile().mkdirs();
                this.mFile.createNewFile();
                z10 = new File(this.mBackupFilePath).exists();
            } else if (this.mFile.length() == 0) {
                OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                if (onSharedPreferenceErrorListener != null) {
                    onSharedPreferenceErrorListener.onError(this.mFile.getAbsolutePath(), 4, this.mFile.length());
                }
                z10 = false;
            }
            this.mFileChannel = new RandomAccessFile(this.mFile, "rw").getChannel();
            allocBuffer(10);
            if (z10) {
                return z10;
            }
            initFileHeader();
            return z10;
        } catch (Exception e10) {
            e10.printStackTrace();
            OnSharedPreferenceErrorListener onSharedPreferenceErrorListener2 = this.mErrorListener;
            if (onSharedPreferenceErrorListener2 != null) {
                onSharedPreferenceErrorListener2.onError(this.mFile.getAbsolutePath() + " " + e10.getCause(), 10, -1);
            }
            return false;
        }
    }

    private void initFileHeader() {
        if (this.mMappedByteBuffer != null) {
            byte[] bArr = new byte[10];
            byte[] intToBytes = ByteIntUtils.intToBytes(0);
            System.arraycopy(intToBytes, 0, bArr, 0, 4);
            bArr[4] = getMaskByte(intToBytes);
            byte[] intToBytes2 = ByteIntUtils.intToBytes(0);
            System.arraycopy(intToBytes2, 0, bArr, 5, 4);
            bArr[9] = getMaskByte(intToBytes2);
            this.mMappedByteBuffer.position(0);
            this.mMappedByteBuffer.put(bArr);
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x00a8 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x00c7 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:87:0x00d6 */
    /* JADX WARNING: Removed duplicated region for block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x00ec A[SYNTHETIC, Splitter:B:97:0x00ec] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void load(boolean r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = 1
            if (r9 == 0) goto L_0x0006
            r2 = r0
            goto L_0x000a
        L_0x0006:
            java.nio.channels.FileLock r2 = r8.lockFile(r1)
        L_0x000a:
            if (r2 != 0) goto L_0x0015
            if (r9 == 0) goto L_0x000f
            goto L_0x0015
        L_0x000f:
            if (r9 != 0) goto L_0x0014
            r8.loadFromBakFile()
        L_0x0014:
            return
        L_0x0015:
            r9 = 0
            r8.reallocBuffer()     // Catch:{ OutOfMemoryError -> 0x00c7, all -> 0x00a8 }
            java.nio.MappedByteBuffer r3 = r8.mMappedByteBuffer     // Catch:{ OutOfMemoryError -> 0x00c7, all -> 0x00a8 }
            if (r3 == 0) goto L_0x008b
            int r3 = r3.capacity()     // Catch:{ OutOfMemoryError -> 0x00c7, all -> 0x00a8 }
            if (r3 != 0) goto L_0x0024
            goto L_0x008b
        L_0x0024:
            int r3 = r8.getContentLength()     // Catch:{ OutOfMemoryError -> 0x00c7, all -> 0x00a8 }
            long r3 = (long) r3
            r5 = 10
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 > 0) goto L_0x004c
            boolean r9 = r8.parseBytesIntoMap(r0, r1)     // Catch:{ Exception -> 0x0034 }
            goto L_0x0038
        L_0x0034:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0038:
            if (r9 == 0) goto L_0x003e
            int r9 = r8.mModifyID
            if (r9 >= 0) goto L_0x0041
        L_0x003e:
            r8.loadFromBakFile()
        L_0x0041:
            if (r2 == 0) goto L_0x004b
            r2.release()     // Catch:{ Exception -> 0x0047 }
            goto L_0x004b
        L_0x0047:
            r9 = move-exception
            r9.printStackTrace()
        L_0x004b:
            return
        L_0x004c:
            int r5 = r8.getModifyID()     // Catch:{ OutOfMemoryError -> 0x00c7, all -> 0x00a8 }
            r8.mModifyID = r5     // Catch:{ OutOfMemoryError -> 0x00c7, all -> 0x00a8 }
            if (r5 <= 0) goto L_0x006c
            java.lang.Object r5 = r8.mSyncObj     // Catch:{ OutOfMemoryError -> 0x00c7, all -> 0x00a8 }
            monitor-enter(r5)     // Catch:{ OutOfMemoryError -> 0x00c7, all -> 0x00a8 }
            java.nio.MappedByteBuffer r6 = r8.mMappedByteBuffer     // Catch:{ all -> 0x0069 }
            r7 = 10
            r6.position(r7)     // Catch:{ all -> 0x0069 }
            int r4 = (int) r3     // Catch:{ all -> 0x0069 }
            int r4 = r4 - r7
            byte[] r0 = new byte[r4]     // Catch:{ all -> 0x0069 }
            java.nio.MappedByteBuffer r3 = r8.mMappedByteBuffer     // Catch:{ all -> 0x0069 }
            r8.safeBufferGet(r3, r0)     // Catch:{ all -> 0x0069 }
            monitor-exit(r5)     // Catch:{ all -> 0x0069 }
            goto L_0x006c
        L_0x0069:
            r3 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0069 }
            throw r3     // Catch:{ OutOfMemoryError -> 0x00c7, all -> 0x00a8 }
        L_0x006c:
            boolean r9 = r8.parseBytesIntoMap(r0, r1)     // Catch:{ Exception -> 0x0071 }
            goto L_0x0075
        L_0x0071:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0075:
            if (r9 == 0) goto L_0x007d
            if (r0 != 0) goto L_0x0080
            int r9 = r8.mModifyID
            if (r9 >= 0) goto L_0x0080
        L_0x007d:
            r8.loadFromBakFile()
        L_0x0080:
            if (r2 == 0) goto L_0x008a
            r2.release()     // Catch:{ Exception -> 0x0086 }
            goto L_0x008a
        L_0x0086:
            r9 = move-exception
            r9.printStackTrace()
        L_0x008a:
            return
        L_0x008b:
            boolean r9 = r8.parseBytesIntoMap(r0, r1)     // Catch:{ Exception -> 0x0090 }
            goto L_0x0094
        L_0x0090:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0094:
            if (r9 == 0) goto L_0x009a
            int r9 = r8.mModifyID
            if (r9 >= 0) goto L_0x009d
        L_0x009a:
            r8.loadFromBakFile()
        L_0x009d:
            if (r2 == 0) goto L_0x00a7
            r2.release()     // Catch:{ Exception -> 0x00a3 }
            goto L_0x00a7
        L_0x00a3:
            r9 = move-exception
            r9.printStackTrace()
        L_0x00a7:
            return
        L_0x00a8:
            boolean r9 = r8.parseBytesIntoMap(r0, r1)     // Catch:{ Exception -> 0x00ad }
            goto L_0x00b1
        L_0x00ad:
            r1 = move-exception
            r1.printStackTrace()
        L_0x00b1:
            if (r9 == 0) goto L_0x00b9
            if (r0 != 0) goto L_0x00bc
            int r9 = r8.mModifyID
            if (r9 >= 0) goto L_0x00bc
        L_0x00b9:
            r8.loadFromBakFile()
        L_0x00bc:
            if (r2 == 0) goto L_0x00c6
            r2.release()     // Catch:{ Exception -> 0x00c2 }
            goto L_0x00c6
        L_0x00c2:
            r9 = move-exception
            r9.printStackTrace()
        L_0x00c6:
            return
        L_0x00c7:
            java.io.File r3 = r8.mFile     // Catch:{ all -> 0x00d6 }
            r3.delete()     // Catch:{ all -> 0x00d6 }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x00d6 }
            java.lang.String r4 = r8.mBackupFilePath     // Catch:{ all -> 0x00d6 }
            r3.<init>(r4)     // Catch:{ all -> 0x00d6 }
            r3.delete()     // Catch:{ all -> 0x00d6 }
        L_0x00d6:
            boolean r9 = r8.parseBytesIntoMap(r0, r1)     // Catch:{ Exception -> 0x00db }
            goto L_0x00df
        L_0x00db:
            r1 = move-exception
            r1.printStackTrace()
        L_0x00df:
            if (r9 == 0) goto L_0x00e7
            if (r0 != 0) goto L_0x00ea
            int r9 = r8.mModifyID
            if (r9 >= 0) goto L_0x00ea
        L_0x00e7:
            r8.loadFromBakFile()
        L_0x00ea:
            if (r2 == 0) goto L_0x00f4
            r2.release()     // Catch:{ Exception -> 0x00f0 }
            goto L_0x00f4
        L_0x00f0:
            r9 = move-exception
            r9.printStackTrace()
        L_0x00f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.load(boolean):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r4v0, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r4v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0096 A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean loadFromBakFile() {
        /*
            r14 = this;
            java.lang.String r0 = "#"
            r1 = 12
            r2 = 0
            r3 = 1
            r4 = 0
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch:{ all -> 0x0081 }
            java.lang.String r6 = r14.mBackupFilePath     // Catch:{ all -> 0x0081 }
            java.lang.String r7 = "r"
            r5.<init>(r6, r7)     // Catch:{ all -> 0x0081 }
            r6 = 4
            byte[] r7 = new byte[r6]     // Catch:{ all -> 0x007c }
            r5.read(r7, r2, r6)     // Catch:{ all -> 0x007c }
            int r6 = com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.ByteIntUtils.bytesToInt(r7)     // Catch:{ all -> 0x007c }
            r7 = 10
            if (r6 > r7) goto L_0x002a
            r14.safeClose(r5)
            r14.parseBytesIntoMap(r4, r2)     // Catch:{ Exception -> 0x0025 }
            goto L_0x0029
        L_0x0025:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0029:
            return r2
        L_0x002a:
            r8 = 2147483647(0x7fffffff, float:NaN)
            if (r6 <= r8) goto L_0x0032
            r6 = 2147483647(0x7fffffff, float:NaN)
        L_0x0032:
            long r8 = (long) r6
            long r10 = r5.length()     // Catch:{ all -> 0x007c }
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 <= 0) goto L_0x0040
            long r8 = r5.length()     // Catch:{ all -> 0x007c }
            int r6 = (int) r8     // Catch:{ all -> 0x007c }
        L_0x0040:
            int r6 = r6 - r7
            byte[] r4 = new byte[r6]     // Catch:{ all -> 0x007c }
            r7 = 10
            r5.seek(r7)     // Catch:{ all -> 0x007c }
            r5.read(r4)     // Catch:{ all -> 0x007c }
            r14.safeClose(r5)
            boolean r3 = r14.parseBytesIntoMap(r4, r2)     // Catch:{ Exception -> 0x0053 }
            goto L_0x0057
        L_0x0053:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0057:
            com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl$OnSharedPreferenceErrorListener r2 = r14.mErrorListener
            if (r2 == 0) goto L_0x00bc
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r14.mBackupFilePath
            r4.append(r5)
            r4.append(r0)
            java.lang.String r5 = ""
            r4.append(r5)
            r4.append(r0)
            r4.append(r3)
            java.lang.String r0 = r4.toString()
            long r4 = (long) r6
            r2.onError(r0, r1, r4)
            goto L_0x00bc
        L_0x007c:
            r6 = move-exception
            r13 = r5
            r5 = r4
            r4 = r13
            goto L_0x0083
        L_0x0081:
            r6 = move-exception
            r5 = r4
        L_0x0083:
            r6.printStackTrace()     // Catch:{ all -> 0x00bd }
            r14.safeClose(r4)
            boolean r3 = r14.parseBytesIntoMap(r5, r2)     // Catch:{ Exception -> 0x008e }
            goto L_0x0092
        L_0x008e:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0092:
            com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl$OnSharedPreferenceErrorListener r4 = r14.mErrorListener
            if (r4 == 0) goto L_0x00bc
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = r14.mBackupFilePath
            r7.append(r8)
            r7.append(r0)
            java.lang.Throwable r6 = r6.getCause()
            r7.append(r6)
            r7.append(r0)
            r7.append(r3)
            java.lang.String r0 = r7.toString()
            if (r5 != 0) goto L_0x00b7
            goto L_0x00b8
        L_0x00b7:
            int r2 = r5.length
        L_0x00b8:
            long r5 = (long) r2
            r4.onError(r0, r1, r5)
        L_0x00bc:
            return r3
        L_0x00bd:
            r7 = move-exception
            r14.safeClose(r4)
            boolean r3 = r14.parseBytesIntoMap(r5, r2)     // Catch:{ Exception -> 0x00c6 }
            goto L_0x00ca
        L_0x00c6:
            r4 = move-exception
            r4.printStackTrace()
        L_0x00ca:
            com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl$OnSharedPreferenceErrorListener r4 = r14.mErrorListener
            if (r4 == 0) goto L_0x00f4
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = r14.mBackupFilePath
            r8.append(r9)
            r8.append(r0)
            java.lang.Throwable r6 = r6.getCause()
            r8.append(r6)
            r8.append(r0)
            r8.append(r3)
            java.lang.String r0 = r8.toString()
            if (r5 != 0) goto L_0x00ef
            goto L_0x00f0
        L_0x00ef:
            int r2 = r5.length
        L_0x00f0:
            long r2 = (long) r2
            r4.onError(r0, r1, r2)
        L_0x00f4:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.loadFromBakFile():boolean");
    }

    /* access modifiers changed from: private */
    public void loadFromDiskLocked() {
        if (!this.mLoaded) {
            load(false);
            this.mLoaded = true;
            notifyAll();
        }
    }

    private FileLock lockFile(boolean z10) {
        FileChannel fileChannel = this.mFileChannel;
        FileLock fileLock = null;
        if (fileChannel == null) {
            return null;
        }
        if (z10) {
            long uptimeMillis = SystemClock.uptimeMillis();
            while (fileLock == null) {
                try {
                    fileLock = this.mFileChannel.tryLock();
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                if (fileLock == null) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                }
                if (SystemClock.uptimeMillis() - uptimeMillis > 10000) {
                    return fileLock;
                }
            }
            return fileLock;
        }
        try {
            return fileChannel.tryLock();
        } catch (Exception e12) {
            e12.printStackTrace();
            return null;
        }
    }

    private boolean merge(SharedPreferences.Editor editor, Map map, boolean z10) {
        if (editor == null) {
            return false;
        }
        EditorImpl editorImpl = (EditorImpl) editor;
        boolean doClear = editorImpl.doClear();
        if (doClear) {
            map.clear();
            this.mEditorList.clear();
        }
        HashMap<String, Object> all = editorImpl.getAll();
        if (all.size() != 0) {
            synchronized (editor) {
                for (Map.Entry next : all.entrySet()) {
                    String str = (String) next.getKey();
                    Object value = next.getValue();
                    if (value == null) {
                        map.remove(str);
                    } else {
                        if (map.containsKey(str)) {
                            map.remove(str);
                        }
                        map.put(str, value);
                    }
                    if (!z10) {
                        notifyDataChanged(str);
                    }
                }
            }
            return true;
        } else if (doClear) {
            return true;
        } else {
            return false;
        }
    }

    private void mergeWhenReload() {
        synchronized (this.mMap) {
            if (this.mEditorList.size() > 0) {
                Iterator<SharedPreferences.Editor> it = this.mEditorList.iterator();
                while (it.hasNext()) {
                    merge(it.next(), this.mMap, true);
                }
            }
        }
    }

    private void notifyDataChanged(String str) {
        if (this.mListeners.size() > 0) {
            for (int i10 = 0; i10 < this.mListeners.size(); i10++) {
                SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = this.mListeners.get(i10);
                if (onSharedPreferenceChangeListener != null) {
                    onSharedPreferenceChangeListener.onSharedPreferenceChanged(this, str);
                }
            }
        }
    }

    private byte[] obtainTotalBytes() {
        String str;
        Pair<Integer, byte[][]> dataBytes = getDataBytes();
        int intValue = ((Integer) dataBytes.first).intValue() + 10 + (((byte[][]) dataBytes.second).length * 1);
        if (intValue > Integer.MAX_VALUE) {
            intValue = Integer.MAX_VALUE;
        }
        byte[] bArr = new byte[intValue];
        byte[] intToBytes = ByteIntUtils.intToBytes(intValue);
        System.arraycopy(intToBytes, 0, bArr, 0, intToBytes.length);
        int length = intToBytes.length + 0;
        bArr[length] = getMaskByte(intToBytes);
        int i10 = length + 1;
        byte[] intToBytes2 = ByteIntUtils.intToBytes(increaseModifyID());
        System.arraycopy(intToBytes2, 0, bArr, i10, intToBytes2.length);
        int length2 = i10 + intToBytes2.length;
        bArr[length2] = getMaskByte(intToBytes2);
        int i11 = length2 + 1;
        byte[][] bArr2 = (byte[][]) dataBytes.second;
        int length3 = bArr2.length;
        int i12 = 0;
        while (true) {
            if (i12 >= length3) {
                break;
            }
            byte[] bArr3 = bArr2[i12];
            if (bArr3 != null) {
                if (bArr3.length + i11 + 1 <= Integer.MAX_VALUE) {
                    System.arraycopy(bArr3, 0, bArr, i11, bArr3.length);
                    int length4 = i11 + bArr3.length;
                    bArr[length4] = getMaskByte(bArr3);
                    i11 = length4 + 1;
                } else {
                    StringBuilder sb = new StringBuilder("Write too much data in ");
                    File file = this.mFile;
                    String str2 = null;
                    if (file != null) {
                        str = file.getAbsolutePath();
                    } else {
                        str = null;
                    }
                    sb.append(str);
                    Log.e(TAG, sb.toString());
                    OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                    if (onSharedPreferenceErrorListener != null) {
                        File file2 = this.mFile;
                        if (file2 != null) {
                            str2 = file2.getAbsolutePath();
                        }
                        onSharedPreferenceErrorListener.onError(str2, 7, -1);
                    }
                }
            }
            i12++;
        }
        return bArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00f5, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00f7, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean parseBytesIntoMap(byte[] r13, boolean r14) {
        /*
            r12 = this;
            java.util.LinkedHashMap<java.lang.String, java.lang.Object> r0 = r12.mMap
            monitor-enter(r0)
            r1 = 0
            if (r14 == 0) goto L_0x0011
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap     // Catch:{ all -> 0x000e }
            java.util.LinkedHashMap<java.lang.String, java.lang.Object> r3 = r12.mMap     // Catch:{ all -> 0x000e }
            r2.<init>(r3)     // Catch:{ all -> 0x000e }
            goto L_0x0012
        L_0x000e:
            r13 = move-exception
            goto L_0x00f8
        L_0x0011:
            r2 = r1
        L_0x0012:
            if (r14 == 0) goto L_0x001d
            int r3 = r12.mModifyID     // Catch:{ all -> 0x000e }
            if (r3 <= 0) goto L_0x001d
            java.util.LinkedHashMap<java.lang.String, java.lang.Object> r3 = r12.mMap     // Catch:{ all -> 0x000e }
            r3.clear()     // Catch:{ all -> 0x000e }
        L_0x001d:
            r3 = 1
            if (r13 == 0) goto L_0x00f6
            int r4 = r13.length     // Catch:{ all -> 0x000e }
            if (r4 != 0) goto L_0x0025
            goto L_0x00f6
        L_0x0025:
            r4 = 0
            r5 = 0
            r6 = 1
        L_0x0028:
            int r7 = r13.length     // Catch:{ all -> 0x000e }
            if (r5 >= r7) goto L_0x00ea
            android.util.Pair r5 = r12.getOneString(r13, r5)     // Catch:{ Exception -> 0x00bb }
            java.lang.Object r7 = r5.second     // Catch:{ Exception -> 0x00bb }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ Exception -> 0x00bb }
            int r7 = r7.intValue()     // Catch:{ Exception -> 0x00bb }
            android.util.Pair r7 = r12.getOneString(r13, r7)     // Catch:{ Exception -> 0x00bb }
            java.lang.Object r8 = r7.second     // Catch:{ Exception -> 0x00bb }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ Exception -> 0x00bb }
            int r8 = r8.intValue()     // Catch:{ Exception -> 0x00bb }
            byte r9 = r13[r8]     // Catch:{ Exception -> 0x00bb }
            int r8 = r8 + 1
            byte r10 = r13[r8]     // Catch:{ Exception -> 0x00bb }
            int r8 = r8 + 1
            r11 = 18
            if (r10 == r11) goto L_0x0070
            byte[] r11 = new byte[r3]     // Catch:{ Exception -> 0x00bb }
            r11[r4] = r9     // Catch:{ Exception -> 0x00bb }
            byte r11 = r12.getMaskByte(r11)     // Catch:{ Exception -> 0x00bb }
            if (r10 == r11) goto L_0x0070
            com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl$OnSharedPreferenceErrorListener r3 = r12.mErrorListener     // Catch:{ Exception -> 0x00bb }
            if (r3 == 0) goto L_0x00eb
            java.io.File r5 = r12.mFile     // Catch:{ Exception -> 0x00bb }
            if (r5 == 0) goto L_0x0066
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ Exception -> 0x00bb }
            goto L_0x0067
        L_0x0066:
            r5 = r1
        L_0x0067:
            int r6 = r13.length     // Catch:{ Exception -> 0x00bb }
            long r6 = (long) r6     // Catch:{ Exception -> 0x00bb }
            r8 = 8
            r3.onError(r5, r8, r6)     // Catch:{ Exception -> 0x00bb }
            goto L_0x00eb
        L_0x0070:
            boolean r10 = r12.checkTypeValid(r9)     // Catch:{ Exception -> 0x00bb }
            if (r10 != 0) goto L_0x008e
            com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl$OnSharedPreferenceErrorListener r5 = r12.mErrorListener     // Catch:{ Exception -> 0x00bb }
            if (r5 == 0) goto L_0x008b
            java.io.File r6 = r12.mFile     // Catch:{ Exception -> 0x00bb }
            if (r6 == 0) goto L_0x0083
            java.lang.String r6 = r6.getAbsolutePath()     // Catch:{ Exception -> 0x00bb }
            goto L_0x0084
        L_0x0083:
            r6 = r1
        L_0x0084:
            int r7 = r13.length     // Catch:{ Exception -> 0x00bb }
            long r9 = (long) r7     // Catch:{ Exception -> 0x00bb }
            r7 = 9
            r5.onError(r6, r7, r9)     // Catch:{ Exception -> 0x00bb }
        L_0x008b:
            r5 = r8
            r6 = 0
            goto L_0x0028
        L_0x008e:
            java.lang.Object r7 = r7.first     // Catch:{ Exception -> 0x00bb }
            byte[] r7 = (byte[]) r7     // Catch:{ Exception -> 0x00bb }
            java.lang.Object r7 = r12.getObjectByType(r7, r9)     // Catch:{ Exception -> 0x00bb }
            java.lang.Object r5 = r5.first     // Catch:{ Exception -> 0x00bb }
            if (r5 == 0) goto L_0x00b8
            r9 = r5
            byte[] r9 = (byte[]) r9     // Catch:{ Exception -> 0x00bb }
            int r9 = r9.length     // Catch:{ Exception -> 0x00bb }
            if (r9 <= 0) goto L_0x00b8
            if (r7 == 0) goto L_0x00b8
            java.lang.String r9 = new java.lang.String     // Catch:{ Exception -> 0x00bb }
            byte[] r5 = (byte[]) r5     // Catch:{ Exception -> 0x00bb }
            r9.<init>(r5)     // Catch:{ Exception -> 0x00bb }
            if (r14 != 0) goto L_0x00b3
            java.util.LinkedHashMap<java.lang.String, java.lang.Object> r5 = r12.mMap     // Catch:{ Exception -> 0x00bb }
            boolean r5 = r5.containsKey(r9)     // Catch:{ Exception -> 0x00bb }
            if (r5 != 0) goto L_0x00b8
        L_0x00b3:
            java.util.LinkedHashMap<java.lang.String, java.lang.Object> r5 = r12.mMap     // Catch:{ Exception -> 0x00bb }
            r5.put(r9, r7)     // Catch:{ Exception -> 0x00bb }
        L_0x00b8:
            r5 = r8
            goto L_0x0028
        L_0x00bb:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x000e }
            com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl$OnSharedPreferenceErrorListener r5 = r12.mErrorListener     // Catch:{ all -> 0x000e }
            if (r5 == 0) goto L_0x00eb
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x000e }
            r6.<init>()     // Catch:{ all -> 0x000e }
            java.io.File r7 = r12.mFile     // Catch:{ all -> 0x000e }
            if (r7 == 0) goto L_0x00d0
            java.lang.String r1 = r7.getAbsolutePath()     // Catch:{ all -> 0x000e }
        L_0x00d0:
            r6.append(r1)     // Catch:{ all -> 0x000e }
            java.lang.String r1 = "#"
            r6.append(r1)     // Catch:{ all -> 0x000e }
            java.lang.Throwable r1 = r3.getCause()     // Catch:{ all -> 0x000e }
            r6.append(r1)     // Catch:{ all -> 0x000e }
            java.lang.String r1 = r6.toString()     // Catch:{ all -> 0x000e }
            int r13 = r13.length     // Catch:{ all -> 0x000e }
            long r6 = (long) r13     // Catch:{ all -> 0x000e }
            r13 = 3
            r5.onError(r1, r13, r6)     // Catch:{ all -> 0x000e }
            goto L_0x00eb
        L_0x00ea:
            r4 = r6
        L_0x00eb:
            if (r4 != 0) goto L_0x00f4
            if (r14 == 0) goto L_0x00f4
            java.util.LinkedHashMap<java.lang.String, java.lang.Object> r13 = r12.mMap     // Catch:{ all -> 0x000e }
            r13.putAll(r2)     // Catch:{ all -> 0x000e }
        L_0x00f4:
            monitor-exit(r0)     // Catch:{ all -> 0x000e }
            return r4
        L_0x00f6:
            monitor-exit(r0)     // Catch:{ all -> 0x000e }
            return r3
        L_0x00f8:
            monitor-exit(r0)     // Catch:{ all -> 0x000e }
            goto L_0x00fb
        L_0x00fa:
            throw r13
        L_0x00fb:
            goto L_0x00fa
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.parseBytesIntoMap(byte[], boolean):boolean");
    }

    private void reallocBuffer() {
        if (this.mMappedByteBuffer != null) {
            synchronized (this.mSyncObj) {
                try {
                    int contentLength = getContentLength();
                    if (contentLength > this.mMappedByteBuffer.capacity()) {
                        allocBuffer(contentLength + 1024);
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }
    }

    private boolean safeBufferGet(MappedByteBuffer mappedByteBuffer, byte[] bArr) {
        if (mappedByteBuffer == null || bArr == null || bArr.length == 0) {
            return false;
        }
        Arrays.fill(bArr, (byte) 0);
        int position = mappedByteBuffer.position();
        if (position + bArr.length > mappedByteBuffer.capacity()) {
            return false;
        }
        mappedByteBuffer.get(bArr);
        return true;
    }

    private void safeBufferPut(MappedByteBuffer mappedByteBuffer, byte[] bArr) {
        if (mappedByteBuffer != null && bArr != null && bArr.length != 0) {
            if (mappedByteBuffer.position() + bArr.length >= mappedByteBuffer.capacity()) {
                mappedByteBuffer = allocBuffer(mappedByteBuffer.position() + bArr.length + 1024);
            }
            mappedByteBuffer.put(bArr);
        }
    }

    private void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0024, code lost:
        if (r6 == false) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0026, code lost:
        saveInner(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0029, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002a, code lost:
        if (r7 == false) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002c, code lost:
        r6 = 1000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002f, code lost:
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0031, code lost:
        r3.mSaveRunnable.setArg(java.lang.Boolean.valueOf(r5));
        r4 = android.os.Message.obtain(r3.mHandler, r3.mSaveRunnable);
        r4.what = mSaveMessageID;
        r3.mHandler.sendMessageDelayed(r4, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void save(android.content.SharedPreferences.Editor r4, boolean r5, boolean r6, boolean r7) {
        /*
            r3 = this;
            if (r4 != 0) goto L_0x0003
            return
        L_0x0003:
            java.util.LinkedHashMap<java.lang.String, java.lang.Object> r0 = r3.mMap
            monitor-enter(r0)
            r1 = 0
            r3.mCurTryTime = r1     // Catch:{ all -> 0x004c }
            java.util.LinkedHashMap<java.lang.String, java.lang.Object> r2 = r3.mMap     // Catch:{ all -> 0x004c }
            boolean r2 = r3.merge(r4, r2, r1)     // Catch:{ all -> 0x004c }
            if (r2 != 0) goto L_0x001b
            java.util.Vector<android.content.SharedPreferences$Editor> r2 = r3.mEditorList     // Catch:{ all -> 0x004c }
            int r2 = r2.size()     // Catch:{ all -> 0x004c }
            if (r2 != 0) goto L_0x001c
            monitor-exit(r0)     // Catch:{ all -> 0x004c }
            return
        L_0x001b:
            r1 = 1
        L_0x001c:
            if (r1 == 0) goto L_0x0023
            java.util.Vector<android.content.SharedPreferences$Editor> r1 = r3.mEditorList     // Catch:{ all -> 0x004c }
            r1.add(r4)     // Catch:{ all -> 0x004c }
        L_0x0023:
            monitor-exit(r0)     // Catch:{ all -> 0x004c }
            if (r6 == 0) goto L_0x002a
            r3.saveInner(r5)
            return
        L_0x002a:
            if (r7 == 0) goto L_0x002f
            r6 = 1000(0x3e8, double:4.94E-321)
            goto L_0x0031
        L_0x002f:
            r6 = 0
        L_0x0031:
            com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl$RunnableEx r4 = r3.mSaveRunnable
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            r4.setArg(r5)
            android.os.Handler r4 = r3.mHandler
            com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl$RunnableEx r5 = r3.mSaveRunnable
            android.os.Message r4 = android.os.Message.obtain(r4, r5)
            r5 = 21310(0x533e, float:2.9862E-41)
            r4.what = r5
            android.os.Handler r5 = r3.mHandler
            r5.sendMessageDelayed(r4, r6)
            return
        L_0x004c:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004c }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.save(android.content.SharedPreferences$Editor, boolean, boolean, boolean):void");
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public void saveInner(final boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.mSyncSaveObj
            monitor-enter(r0)
            r1 = 0
            java.nio.channels.FileLock r2 = r7.lockFile(r1)     // Catch:{ all -> 0x008a }
            if (r2 == 0) goto L_0x0073
            r3 = 1
            r7.mIsSaving = r3     // Catch:{ all -> 0x004b }
            boolean r3 = r7.tryReloadWhenSave()     // Catch:{ all -> 0x004b }
            if (r3 == 0) goto L_0x001a
            r7.mergeWhenReload()     // Catch:{ all -> 0x004b }
            r3 = 0
            r7.notifyDataChanged(r3)     // Catch:{ all -> 0x004b }
        L_0x001a:
            java.util.LinkedHashMap<java.lang.String, java.lang.Object> r3 = r7.mMap     // Catch:{ all -> 0x004b }
            monitor-enter(r3)     // Catch:{ all -> 0x004b }
            java.util.Vector<android.content.SharedPreferences$Editor> r4 = r7.mEditorList     // Catch:{ all -> 0x0048 }
            int r4 = r4.size()     // Catch:{ all -> 0x0048 }
            if (r4 > 0) goto L_0x0032
            monitor-exit(r3)     // Catch:{ all -> 0x0048 }
            r2.release()     // Catch:{ IOException -> 0x002a }
            goto L_0x002e
        L_0x002a:
            r8 = move-exception
            r8.printStackTrace()     // Catch:{ all -> 0x008a }
        L_0x002e:
            r7.mIsSaving = r1     // Catch:{ all -> 0x008a }
            monitor-exit(r0)     // Catch:{ all -> 0x008a }
            return
        L_0x0032:
            monitor-exit(r3)     // Catch:{ all -> 0x0048 }
            byte[] r3 = r7.obtainTotalBytes()     // Catch:{ all -> 0x004b }
            r7.saveToMappedBuffer(r3, r8)     // Catch:{ all -> 0x004b }
            r7.backup()     // Catch:{ all -> 0x004b }
            r2.release()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0045
        L_0x0041:
            r8 = move-exception
            r8.printStackTrace()     // Catch:{ all -> 0x008a }
        L_0x0045:
            r7.mIsSaving = r1     // Catch:{ all -> 0x008a }
            goto L_0x0088
        L_0x0048:
            r8 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0048 }
            throw r8     // Catch:{ all -> 0x004b }
        L_0x004b:
            r8 = move-exception
            r8.printStackTrace()     // Catch:{ all -> 0x0067 }
            com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl$OnSharedPreferenceErrorListener r3 = r7.mErrorListener     // Catch:{ all -> 0x0067 }
            if (r3 == 0) goto L_0x005e
            java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x0067 }
            r4 = 11
            r5 = -1
            r3.onError(r8, r4, r5)     // Catch:{ all -> 0x0067 }
        L_0x005e:
            r2.release()     // Catch:{ IOException -> 0x0062 }
            goto L_0x0045
        L_0x0062:
            r8 = move-exception
            r8.printStackTrace()     // Catch:{ all -> 0x008a }
            goto L_0x0045
        L_0x0067:
            r8 = move-exception
            r2.release()     // Catch:{ IOException -> 0x006c }
            goto L_0x0070
        L_0x006c:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ all -> 0x008a }
        L_0x0070:
            r7.mIsSaving = r1     // Catch:{ all -> 0x008a }
            throw r8     // Catch:{ all -> 0x008a }
        L_0x0073:
            int r1 = r7.mCurTryTime     // Catch:{ all -> 0x008a }
            int r2 = r1 + 1
            r7.mCurTryTime = r2     // Catch:{ all -> 0x008a }
            r2 = 6
            if (r1 >= r2) goto L_0x0088
            android.os.Handler r1 = r7.mHandler     // Catch:{ all -> 0x008a }
            com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl$3 r2 = new com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl$3     // Catch:{ all -> 0x008a }
            r2.<init>(r8)     // Catch:{ all -> 0x008a }
            r3 = 2000(0x7d0, double:9.88E-321)
            r1.postDelayed(r2, r3)     // Catch:{ all -> 0x008a }
        L_0x0088:
            monitor-exit(r0)     // Catch:{ all -> 0x008a }
            return
        L_0x008a:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008a }
            goto L_0x008e
        L_0x008d:
            throw r8
        L_0x008e:
            goto L_0x008d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.saveInner(boolean):void");
    }

    private void saveToMappedBuffer(byte[] bArr, boolean z10) {
        synchronized (this.mSyncObj) {
            this.mMappedByteBuffer.position(0);
            safeBufferPut(this.mMappedByteBuffer, bArr);
            if (z10) {
                this.mMappedByteBuffer.force();
            }
        }
    }

    private void startLoadFromDisk(boolean z10) {
        synchronized (this) {
            this.mLoaded = false;
        }
        AnonymousClass5 r02 = new Runnable() {
            public void run() {
                synchronized (SharedPreferencesNewImpl.this) {
                    SharedPreferencesNewImpl.this.loadFromDiskLocked();
                }
            }
        };
        if (z10) {
            r02.run();
        } else {
            sCachedThreadPool.execute(r02);
        }
    }

    /* access modifiers changed from: private */
    public void tryReload() {
        if (SystemClock.uptimeMillis() - this.mTryReloadStartTime > 60) {
            this.mTryReloadStartTime = SystemClock.uptimeMillis();
            this.mHandler.removeCallbacks(this.mTryReloadRunnable);
            this.mHandler.post(this.mTryReloadRunnable);
        }
    }

    private boolean tryReloadWhenSave() {
        int modifyID = getModifyID();
        if (modifyID <= 0 || modifyID == this.mModifyID) {
            return false;
        }
        load(true);
        return true;
    }

    public final boolean checkTypeValid(byte b10) {
        return b10 == 4 || b10 == 2 || b10 == 1 || b10 == 3 || b10 == 5;
    }

    public final boolean contains(String str) {
        boolean containsKey;
        awaitLoadedLocked();
        synchronized (this.mMap) {
            containsKey = this.mMap.containsKey(str);
        }
        return containsKey;
    }

    public final SharedPreferences.Editor edit() {
        awaitLoadedLocked();
        return new EditorImpl();
    }

    public final Map<String, ?> getAll() {
        HashMap hashMap;
        awaitLoadedLocked();
        synchronized (this.mMap) {
            hashMap = new HashMap(this.mMap);
        }
        return hashMap;
    }

    public final boolean getBoolean(String str, boolean z10) {
        String str2;
        long j10;
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                Boolean bool = (Boolean) this.mMap.get(str);
                if (bool != null) {
                    z10 = bool.booleanValue();
                }
            } catch (ClassCastException e10) {
                OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                if (onSharedPreferenceErrorListener != null) {
                    StringBuilder sb = new StringBuilder();
                    File file = this.mFile;
                    if (file != null) {
                        str2 = file.getAbsolutePath();
                    } else {
                        str2 = null;
                    }
                    sb.append(str2);
                    sb.append("#");
                    sb.append(str);
                    sb.append(e10);
                    String sb2 = sb.toString();
                    File file2 = this.mFile;
                    if (file2 != null) {
                        j10 = file2.length();
                    } else {
                        j10 = 0;
                    }
                    onSharedPreferenceErrorListener.onError(sb2, 13, j10);
                }
                return z10;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    public final float getFloat(String str, float f10) {
        String str2;
        long j10;
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                Float f11 = (Float) this.mMap.get(str);
                if (f11 != null) {
                    f10 = f11.floatValue();
                }
            } catch (ClassCastException e10) {
                OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                if (onSharedPreferenceErrorListener != null) {
                    StringBuilder sb = new StringBuilder();
                    File file = this.mFile;
                    if (file != null) {
                        str2 = file.getAbsolutePath();
                    } else {
                        str2 = null;
                    }
                    sb.append(str2);
                    sb.append("#");
                    sb.append(str);
                    sb.append(e10);
                    String sb2 = sb.toString();
                    File file2 = this.mFile;
                    if (file2 != null) {
                        j10 = file2.length();
                    } else {
                        j10 = 0;
                    }
                    onSharedPreferenceErrorListener.onError(sb2, 13, j10);
                }
                return f10;
            } catch (Throwable th) {
                throw th;
            }
        }
        return f10;
    }

    public final int getInt(String str, int i10) {
        String str2;
        long j10;
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                Integer num = (Integer) this.mMap.get(str);
                if (num != null) {
                    i10 = num.intValue();
                }
            } catch (ClassCastException e10) {
                OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                if (onSharedPreferenceErrorListener != null) {
                    StringBuilder sb = new StringBuilder();
                    File file = this.mFile;
                    if (file != null) {
                        str2 = file.getAbsolutePath();
                    } else {
                        str2 = null;
                    }
                    sb.append(str2);
                    sb.append("#");
                    sb.append(str);
                    sb.append(e10);
                    String sb2 = sb.toString();
                    File file2 = this.mFile;
                    if (file2 != null) {
                        j10 = file2.length();
                    } else {
                        j10 = 0;
                    }
                    onSharedPreferenceErrorListener.onError(sb2, 13, j10);
                }
                return i10;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i10;
    }

    public final long getLong(String str, long j10) {
        String str2;
        long j11;
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                Long l10 = (Long) this.mMap.get(str);
                if (l10 != null) {
                    j10 = l10.longValue();
                }
            } catch (ClassCastException e10) {
                OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                if (onSharedPreferenceErrorListener != null) {
                    StringBuilder sb = new StringBuilder();
                    File file = this.mFile;
                    if (file != null) {
                        str2 = file.getAbsolutePath();
                    } else {
                        str2 = null;
                    }
                    sb.append(str2);
                    sb.append("#");
                    sb.append(str);
                    sb.append(e10);
                    String sb2 = sb.toString();
                    File file2 = this.mFile;
                    if (file2 != null) {
                        j11 = file2.length();
                    } else {
                        j11 = 0;
                    }
                    onSharedPreferenceErrorListener.onError(sb2, 13, j11);
                }
                return j10;
            } catch (Throwable th) {
                throw th;
            }
        }
        return j10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005b, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int getModifyID() {
        /*
            r7 = this;
            java.nio.MappedByteBuffer r0 = r7.mMappedByteBuffer
            r1 = -1
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.lang.Object r0 = r7.mSyncObj
            monitor-enter(r0)
            java.nio.MappedByteBuffer r2 = r7.mMappedByteBuffer     // Catch:{ all -> 0x005e }
            r3 = 5
            r2.position(r3)     // Catch:{ all -> 0x005e }
            r2 = 4
            byte[] r2 = new byte[r2]     // Catch:{ all -> 0x005e }
            java.nio.MappedByteBuffer r3 = r7.mMappedByteBuffer     // Catch:{ all -> 0x005e }
            r7.safeBufferGet(r3, r2)     // Catch:{ all -> 0x005e }
            int r3 = com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.ByteIntUtils.bytesToInt(r2)     // Catch:{ all -> 0x005e }
            java.nio.MappedByteBuffer r4 = r7.mMappedByteBuffer     // Catch:{ all -> 0x005e }
            r5 = 9
            r4.position(r5)     // Catch:{ all -> 0x005e }
            java.nio.MappedByteBuffer r4 = r7.mMappedByteBuffer     // Catch:{ all -> 0x005e }
            byte r4 = r4.get()     // Catch:{ all -> 0x005e }
            r5 = 18
            if (r4 == r5) goto L_0x0032
            byte r2 = r7.getMaskByte(r2)     // Catch:{ all -> 0x005e }
            if (r4 != r2) goto L_0x0034
        L_0x0032:
            if (r3 >= 0) goto L_0x005c
        L_0x0034:
            int r2 = r7.mModifyErrorCnt     // Catch:{ all -> 0x005e }
            int r2 = r2 + 1
            r7.mModifyErrorCnt = r2     // Catch:{ all -> 0x005e }
            r3 = 3
            if (r2 >= r3) goto L_0x005a
            com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl$OnSharedPreferenceErrorListener r2 = r7.mErrorListener     // Catch:{ all -> 0x005e }
            if (r2 == 0) goto L_0x005a
            java.io.File r3 = r7.mFile     // Catch:{ all -> 0x005e }
            if (r3 == 0) goto L_0x004a
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x005e }
            goto L_0x004b
        L_0x004a:
            r3 = 0
        L_0x004b:
            java.io.File r4 = r7.mFile     // Catch:{ all -> 0x005e }
            if (r4 == 0) goto L_0x0054
            long r4 = r4.length()     // Catch:{ all -> 0x005e }
            goto L_0x0056
        L_0x0054:
            r4 = 0
        L_0x0056:
            r6 = 2
            r2.onError(r3, r6, r4)     // Catch:{ all -> 0x005e }
        L_0x005a:
            monitor-exit(r0)     // Catch:{ all -> 0x005e }
            return r1
        L_0x005c:
            monitor-exit(r0)     // Catch:{ all -> 0x005e }
            return r3
        L_0x005e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005e }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.getModifyID():int");
    }

    public final String getString(String str, String str2) {
        String str3;
        long j10;
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                String str4 = (String) this.mMap.get(str);
                if (str4 != null) {
                    str2 = str4;
                }
            } catch (ClassCastException e10) {
                OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                if (onSharedPreferenceErrorListener != null) {
                    StringBuilder sb = new StringBuilder();
                    File file = this.mFile;
                    if (file != null) {
                        str3 = file.getAbsolutePath();
                    } else {
                        str3 = null;
                    }
                    sb.append(str3);
                    sb.append("#");
                    sb.append(str);
                    sb.append(e10);
                    String sb2 = sb.toString();
                    File file2 = this.mFile;
                    if (file2 != null) {
                        j10 = file2.length();
                    } else {
                        j10 = 0;
                    }
                    onSharedPreferenceErrorListener.onError(sb2, 13, j10);
                }
                return str2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    public final Set<String> getStringSet(String str, Set<String> set) {
        throw new RuntimeException("putStringSet is not supported!");
    }

    public final void onDestroy() {
        if (this.mIsSaving || this.mHandler.hasMessages(mSaveMessageID)) {
            saveInner(false);
        }
    }

    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (onSharedPreferenceChangeListener != null) {
            synchronized (this.mListeners) {
                this.mListeners.add(onSharedPreferenceChangeListener);
                if (this.mFileMonitor == null) {
                    try {
                        File file = new File(this.mBackupFilePath);
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                    this.mFileMonitor = new FileMonitor(this.mBackupFilePath, 2);
                }
            }
            synchronized (mFileMonitorSyncObj) {
                this.mFileMonitor.startWatching();
            }
        }
    }

    public final void setSharedPreferenceErrorListener(OnSharedPreferenceErrorListener onSharedPreferenceErrorListener) {
        this.mErrorListener = onSharedPreferenceErrorListener;
    }

    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (onSharedPreferenceChangeListener != null) {
            synchronized (this.mListeners) {
                this.mListeners.remove(onSharedPreferenceChangeListener);
                if (this.mFileMonitor != null && this.mListeners.size() <= 0) {
                    this.mFileMonitor.stopWatching();
                }
            }
        }
    }

    public SharedPreferencesNewImpl(File file, boolean z10) {
        this(file, 0, (OnSharedPreferenceErrorListener) null, z10);
    }

    public SharedPreferencesNewImpl(File file, OnSharedPreferenceErrorListener onSharedPreferenceErrorListener) {
        this(file, 0, onSharedPreferenceErrorListener, false);
    }

    public SharedPreferencesNewImpl(File file, int i10, OnSharedPreferenceErrorListener onSharedPreferenceErrorListener) {
        this(file, i10, onSharedPreferenceErrorListener, false);
    }

    public SharedPreferencesNewImpl(File file, int i10, OnSharedPreferenceErrorListener onSharedPreferenceErrorListener, boolean z10) {
        this.mMap = new LinkedHashMap<>();
        this.mListeners = new ArrayList<>();
        this.mLoaded = true;
        this.mSyncObj = new Object();
        this.mSyncSaveObj = new Object();
        this.mEditorList = new Vector<>();
        this.mIsSaving = false;
        this.mTryReloadRunnable = new Runnable() {
            public void run() {
                int modifyID = SharedPreferencesNewImpl.this.getModifyID();
                if (modifyID > 0 && modifyID != SharedPreferencesNewImpl.this.mModifyID) {
                    SharedPreferencesNewImpl.this.saveInner(false);
                }
            }
        };
        this.mSaveRunnable = new RunnableEx() {
            public void run() {
                SharedPreferencesNewImpl.this.saveInner(((Boolean) getArg()).booleanValue());
            }
        };
        this.mErrorListener = onSharedPreferenceErrorListener;
        this.mHandler = new Handler(getHandlerThread().getLooper());
        this.mFile = file;
        this.mBackupFilePath = file.getAbsolutePath() + BACKUP_FILE_SUFFIX;
        if (initBuffer()) {
            startLoadFromDisk(z10);
        }
        this.mHandler.post(new Runnable() {
            public void run() {
                try {
                    File file = new File(SharedPreferencesNewImpl.this.mBackupFilePath);
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        });
    }
}
