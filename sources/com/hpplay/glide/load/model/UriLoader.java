package com.hpplay.glide.load.model;

import android.content.Context;
import android.net.Uri;
import anet.channel.util.HttpConstant;
import com.hpplay.glide.load.data.DataFetcher;

public abstract class UriLoader<T> implements ModelLoader<Uri, T> {
    private final Context context;
    private final ModelLoader<GlideUrl, T> urlLoader;

    public UriLoader(Context context2, ModelLoader<GlideUrl, T> modelLoader) {
        this.context = context2;
        this.urlLoader = modelLoader;
    }

    private static boolean isLocalUri(String str) {
        if ("file".equals(str) || "content".equals(str) || "android.resource".equals(str)) {
            return true;
        }
        return false;
    }

    public abstract DataFetcher<T> getAssetPathFetcher(Context context2, String str);

    public abstract DataFetcher<T> getLocalUriFetcher(Context context2, Uri uri);

    public final DataFetcher<T> getResourceFetcher(Uri uri, int i10, int i11) {
        String scheme = uri.getScheme();
        if (isLocalUri(scheme)) {
            if (!AssetUriParser.isAssetUri(uri)) {
                return getLocalUriFetcher(this.context, uri);
            }
            return getAssetPathFetcher(this.context, AssetUriParser.toAssetPath(uri));
        } else if (this.urlLoader == null || (!HttpConstant.HTTP.equals(scheme) && !"https".equals(scheme))) {
            return null;
        } else {
            return this.urlLoader.getResourceFetcher(new GlideUrl(uri.toString()), i10, i11);
        }
    }
}
