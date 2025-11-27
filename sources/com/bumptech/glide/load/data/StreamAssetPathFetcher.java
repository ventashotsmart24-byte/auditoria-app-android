package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import java.io.InputStream;

public class StreamAssetPathFetcher extends AssetPathFetcher<InputStream> {
    public StreamAssetPathFetcher(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    public void close(InputStream inputStream) {
        inputStream.close();
    }

    public InputStream loadResource(AssetManager assetManager, String str) {
        return assetManager.open(str);
    }
}
