package com.hpplay.glide.load.engine.cache;

import android.util.Log;
import com.hpplay.glide.disklrucache.DiskLruCache;
import com.hpplay.glide.load.Key;
import com.hpplay.glide.load.engine.cache.DiskCache;
import java.io.File;
import java.io.IOException;

public class DiskLruCacheWrapper implements DiskCache {
    private static final int APP_VERSION = 1;
    private static final String TAG = "DiskLruCacheWrapper";
    private static final int VALUE_COUNT = 1;
    private static DiskLruCacheWrapper wrapper;
    private final File directory;
    private DiskLruCache diskLruCache;
    private final int maxSize;
    private final SafeKeyGenerator safeKeyGenerator;
    private final DiskCacheWriteLocker writeLocker = new DiskCacheWriteLocker();

    public DiskLruCacheWrapper(File file, int i10) {
        this.directory = file;
        this.maxSize = i10;
        this.safeKeyGenerator = new SafeKeyGenerator();
    }

    public static synchronized DiskCache get(File file, int i10) {
        DiskLruCacheWrapper diskLruCacheWrapper;
        synchronized (DiskLruCacheWrapper.class) {
            if (wrapper == null) {
                wrapper = new DiskLruCacheWrapper(file, i10);
            }
            diskLruCacheWrapper = wrapper;
        }
        return diskLruCacheWrapper;
    }

    private synchronized DiskLruCache getDiskCache() {
        if (this.diskLruCache == null) {
            this.diskLruCache = DiskLruCache.open(this.directory, 1, 1, (long) this.maxSize);
        }
        return this.diskLruCache;
    }

    private synchronized void resetDiskCache() {
        this.diskLruCache = null;
    }

    public synchronized void clear() {
        try {
            getDiskCache().delete();
            resetDiskCache();
        } catch (IOException unused) {
            boolean isLoggable = Log.isLoggable(TAG, 5);
        }
    }

    public void delete(Key key) {
        try {
            getDiskCache().remove(this.safeKeyGenerator.getSafeKey(key));
        } catch (IOException unused) {
            Log.isLoggable(TAG, 5);
        }
    }

    public void put(Key key, DiskCache.Writer writer) {
        DiskLruCache.Editor edit;
        String safeKey = this.safeKeyGenerator.getSafeKey(key);
        this.writeLocker.acquire(key);
        try {
            edit = getDiskCache().edit(safeKey);
            if (edit != null) {
                if (writer.write(edit.getFile(0))) {
                    edit.commit();
                }
                edit.abortUnlessCommitted();
            }
        } catch (IOException unused) {
            try {
                boolean isLoggable = Log.isLoggable(TAG, 5);
            } catch (Throwable th) {
                this.writeLocker.release(key);
                throw th;
            }
        } catch (Throwable th2) {
            edit.abortUnlessCommitted();
            throw th2;
        }
        this.writeLocker.release(key);
    }

    public File get(Key key) {
        try {
            DiskLruCache.Value value = getDiskCache().get(this.safeKeyGenerator.getSafeKey(key));
            if (value != null) {
                return value.getFile(0);
            }
            return null;
        } catch (IOException unused) {
            Log.isLoggable(TAG, 5);
            return null;
        }
    }
}
