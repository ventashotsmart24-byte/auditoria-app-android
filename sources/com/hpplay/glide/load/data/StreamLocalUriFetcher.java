package com.hpplay.glide.load.data;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.InputStream;

public class StreamLocalUriFetcher extends LocalUriFetcher<InputStream> {
    public StreamLocalUriFetcher(Context context, Uri uri) {
        super(context, uri);
    }

    public void close(InputStream inputStream) {
        inputStream.close();
    }

    public InputStream loadResource(Uri uri, ContentResolver contentResolver) {
        return contentResolver.openInputStream(uri);
    }
}
