package com.hpplay.glide.load.resource.gif;

import com.hpplay.glide.Priority;
import com.hpplay.glide.gifdecoder.GifDecoder;
import com.hpplay.glide.load.data.DataFetcher;
import com.hpplay.glide.load.model.ModelLoader;

class GifFrameModelLoader implements ModelLoader<GifDecoder, GifDecoder> {

    public static class GifFrameDataFetcher implements DataFetcher<GifDecoder> {
        private final GifDecoder decoder;

        public GifFrameDataFetcher(GifDecoder gifDecoder) {
            this.decoder = gifDecoder;
        }

        public void cancel() {
        }

        public void cleanup() {
        }

        public String getId() {
            return String.valueOf(this.decoder.getCurrentFrameIndex());
        }

        public GifDecoder loadData(Priority priority) {
            return this.decoder;
        }
    }

    public DataFetcher<GifDecoder> getResourceFetcher(GifDecoder gifDecoder, int i10, int i11) {
        return new GifFrameDataFetcher(gifDecoder);
    }
}
