package com.hpplay.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.hpplay.glide.load.data.DataFetcher;
import com.hpplay.glide.load.data.MediaStoreThumbFetcher;
import com.hpplay.glide.load.model.ModelLoader;
import java.io.InputStream;

public class MediaStoreStreamLoader implements ModelLoader<Uri, InputStream> {
    private final Context context;
    private final ModelLoader<Uri, InputStream> uriLoader;

    public MediaStoreStreamLoader(Context context2, ModelLoader<Uri, InputStream> modelLoader) {
        this.context = context2;
        this.uriLoader = modelLoader;
    }

    public DataFetcher<InputStream> getResourceFetcher(Uri uri, int i10, int i11) {
        return new MediaStoreThumbFetcher(this.context, uri, this.uriLoader.getResourceFetcher(uri, i10, i11), i10, i11);
    }
}
