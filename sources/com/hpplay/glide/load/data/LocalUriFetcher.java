package com.hpplay.glide.load.data;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.hpplay.glide.Priority;
import java.io.IOException;

public abstract class LocalUriFetcher<T> implements DataFetcher<T> {
    private static final String TAG = "LocalUriFetcher";
    private final Context context;
    private T data;
    private final Uri uri;

    public LocalUriFetcher(Context context2, Uri uri2) {
        this.context = context2.getApplicationContext();
        this.uri = uri2;
    }

    public void cancel() {
    }

    public void cleanup() {
        T t10 = this.data;
        if (t10 != null) {
            try {
                close(t10);
            } catch (IOException unused) {
                Log.isLoggable(TAG, 2);
            }
        }
    }

    public abstract void close(T t10);

    public String getId() {
        return this.uri.toString();
    }

    public final T loadData(Priority priority) {
        T loadResource = loadResource(this.uri, this.context.getContentResolver());
        this.data = loadResource;
        return loadResource;
    }

    public abstract T loadResource(Uri uri2, ContentResolver contentResolver);
}
