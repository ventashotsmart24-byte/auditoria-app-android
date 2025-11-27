package com.titan.thumbnail;

import io.reactivex.functions.Consumer;

public final class ThumbnailRequest$getThumbnail$1<T> implements Consumer<String> {
    final /* synthetic */ String $snapInfoUrl;

    public ThumbnailRequest$getThumbnail$1(String str) {
        this.$snapInfoUrl = str;
    }

    public final void accept(String str) {
        ThumbnailRequest.INSTANCE.request(this.$snapInfoUrl);
    }
}
