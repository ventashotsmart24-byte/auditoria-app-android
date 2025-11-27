package com.hpplay.glide.load.engine.cache;

import android.content.Context;
import com.hpplay.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

public final class ExternalCacheDiskCacheFactory extends DiskLruCacheFactory {
    public ExternalCacheDiskCacheFactory(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public ExternalCacheDiskCacheFactory(Context context, int i10) {
        this(context, "image_manager_disk_cache", i10);
    }

    public ExternalCacheDiskCacheFactory(final Context context, final String str, int i10) {
        super((DiskLruCacheFactory.CacheDirectoryGetter) new DiskLruCacheFactory.CacheDirectoryGetter() {
            public File getCacheDirectory() {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir == null) {
                    return null;
                }
                if (str != null) {
                    return new File(externalCacheDir, str);
                }
                return externalCacheDir;
            }
        }, i10);
    }
}
