package com.hpplay.glide.load.model.stream;

import android.content.Context;
import android.text.TextUtils;
import com.hpplay.glide.Glide;
import com.hpplay.glide.load.data.DataFetcher;
import com.hpplay.glide.load.model.GlideUrl;
import com.hpplay.glide.load.model.Headers;
import com.hpplay.glide.load.model.ModelCache;
import com.hpplay.glide.load.model.ModelLoader;
import java.io.InputStream;

public abstract class BaseGlideUrlLoader<T> implements StreamModelLoader<T> {
    private final ModelLoader<GlideUrl, InputStream> concreteLoader;
    private final ModelCache<T, GlideUrl> modelCache;

    public BaseGlideUrlLoader(Context context) {
        this(context, (ModelCache) null);
    }

    public Headers getHeaders(T t10, int i10, int i11) {
        return Headers.DEFAULT;
    }

    public DataFetcher<InputStream> getResourceFetcher(T t10, int i10, int i11) {
        GlideUrl glideUrl;
        ModelCache<T, GlideUrl> modelCache2 = this.modelCache;
        if (modelCache2 != null) {
            glideUrl = modelCache2.get(t10, i10, i11);
        } else {
            glideUrl = null;
        }
        if (glideUrl == null) {
            String url = getUrl(t10, i10, i11);
            if (TextUtils.isEmpty(url)) {
                return null;
            }
            GlideUrl glideUrl2 = new GlideUrl(url, getHeaders(t10, i10, i11));
            ModelCache<T, GlideUrl> modelCache3 = this.modelCache;
            if (modelCache3 != null) {
                modelCache3.put(t10, i10, i11, glideUrl2);
            }
            glideUrl = glideUrl2;
        }
        return this.concreteLoader.getResourceFetcher(glideUrl, i10, i11);
    }

    public abstract String getUrl(T t10, int i10, int i11);

    public BaseGlideUrlLoader(Context context, ModelCache<T, GlideUrl> modelCache2) {
        this((ModelLoader<GlideUrl, InputStream>) Glide.buildModelLoader(GlideUrl.class, InputStream.class, context), modelCache2);
    }

    public BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        this(modelLoader, (ModelCache) null);
    }

    public BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader, ModelCache<T, GlideUrl> modelCache2) {
        this.concreteLoader = modelLoader;
        this.modelCache = modelCache2;
    }
}
