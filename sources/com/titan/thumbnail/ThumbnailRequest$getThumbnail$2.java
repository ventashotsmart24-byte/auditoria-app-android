package com.titan.thumbnail;

import io.reactivex.functions.Consumer;

public final class ThumbnailRequest$getThumbnail$2<T> implements Consumer<Throwable> {
    public static final ThumbnailRequest$getThumbnail$2 INSTANCE = new ThumbnailRequest$getThumbnail$2();

    public final void accept(Throwable th) {
        th.printStackTrace();
    }
}
