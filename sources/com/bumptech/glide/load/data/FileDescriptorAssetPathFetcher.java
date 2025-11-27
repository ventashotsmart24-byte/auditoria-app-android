package com.bumptech.glide.load.data;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;

public class FileDescriptorAssetPathFetcher extends AssetPathFetcher<AssetFileDescriptor> {
    public FileDescriptorAssetPathFetcher(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    public Class<AssetFileDescriptor> getDataClass() {
        return AssetFileDescriptor.class;
    }

    public void close(AssetFileDescriptor assetFileDescriptor) {
        assetFileDescriptor.close();
    }

    public AssetFileDescriptor loadResource(AssetManager assetManager, String str) {
        return assetManager.openFd(str);
    }
}
