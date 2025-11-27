package com.hpplay.glide.load.model;

import android.os.ParcelFileDescriptor;
import com.hpplay.glide.load.data.DataFetcher;
import java.io.InputStream;

public class ImageVideoModelLoader<A> implements ModelLoader<A, ImageVideoWrapper> {
    private static final String TAG = "IVML";
    private final ModelLoader<A, ParcelFileDescriptor> fileDescriptorLoader;
    private final ModelLoader<A, InputStream> streamLoader;

    public static class ImageVideoFetcher implements DataFetcher<ImageVideoWrapper> {
        private final DataFetcher<ParcelFileDescriptor> fileDescriptorFetcher;
        private final DataFetcher<InputStream> streamFetcher;

        public ImageVideoFetcher(DataFetcher<InputStream> dataFetcher, DataFetcher<ParcelFileDescriptor> dataFetcher2) {
            this.streamFetcher = dataFetcher;
            this.fileDescriptorFetcher = dataFetcher2;
        }

        public void cancel() {
            DataFetcher<InputStream> dataFetcher = this.streamFetcher;
            if (dataFetcher != null) {
                dataFetcher.cancel();
            }
            DataFetcher<ParcelFileDescriptor> dataFetcher2 = this.fileDescriptorFetcher;
            if (dataFetcher2 != null) {
                dataFetcher2.cancel();
            }
        }

        public void cleanup() {
            DataFetcher<InputStream> dataFetcher = this.streamFetcher;
            if (dataFetcher != null) {
                dataFetcher.cleanup();
            }
            DataFetcher<ParcelFileDescriptor> dataFetcher2 = this.fileDescriptorFetcher;
            if (dataFetcher2 != null) {
                dataFetcher2.cleanup();
            }
        }

        public String getId() {
            DataFetcher<InputStream> dataFetcher = this.streamFetcher;
            if (dataFetcher != null) {
                return dataFetcher.getId();
            }
            return this.fileDescriptorFetcher.getId();
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x001e A[SYNTHETIC, Splitter:B:11:0x001e] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.hpplay.glide.load.model.ImageVideoWrapper loadData(com.hpplay.glide.Priority r6) {
            /*
                r5 = this;
                com.hpplay.glide.load.data.DataFetcher<java.io.InputStream> r0 = r5.streamFetcher
                r1 = 2
                java.lang.String r2 = "IVML"
                r3 = 0
                if (r0 == 0) goto L_0x0019
                java.lang.Object r0 = r0.loadData(r6)     // Catch:{ Exception -> 0x000f }
                java.io.InputStream r0 = (java.io.InputStream) r0     // Catch:{ Exception -> 0x000f }
                goto L_0x001a
            L_0x000f:
                r0 = move-exception
                android.util.Log.isLoggable(r2, r1)
                com.hpplay.glide.load.data.DataFetcher<android.os.ParcelFileDescriptor> r4 = r5.fileDescriptorFetcher
                if (r4 == 0) goto L_0x0018
                goto L_0x0019
            L_0x0018:
                throw r0
            L_0x0019:
                r0 = r3
            L_0x001a:
                com.hpplay.glide.load.data.DataFetcher<android.os.ParcelFileDescriptor> r4 = r5.fileDescriptorFetcher
                if (r4 == 0) goto L_0x002e
                java.lang.Object r6 = r4.loadData(r6)     // Catch:{ Exception -> 0x0026 }
                android.os.ParcelFileDescriptor r6 = (android.os.ParcelFileDescriptor) r6     // Catch:{ Exception -> 0x0026 }
                r3 = r6
                goto L_0x002e
            L_0x0026:
                r6 = move-exception
                android.util.Log.isLoggable(r2, r1)
                if (r0 == 0) goto L_0x002d
                goto L_0x002e
            L_0x002d:
                throw r6
            L_0x002e:
                com.hpplay.glide.load.model.ImageVideoWrapper r6 = new com.hpplay.glide.load.model.ImageVideoWrapper
                r6.<init>(r0, r3)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hpplay.glide.load.model.ImageVideoModelLoader.ImageVideoFetcher.loadData(com.hpplay.glide.Priority):com.hpplay.glide.load.model.ImageVideoWrapper");
        }
    }

    public ImageVideoModelLoader(ModelLoader<A, InputStream> modelLoader, ModelLoader<A, ParcelFileDescriptor> modelLoader2) {
        if (modelLoader == null && modelLoader2 == null) {
            throw new NullPointerException("At least one of streamLoader and fileDescriptorLoader must be non null");
        }
        this.streamLoader = modelLoader;
        this.fileDescriptorLoader = modelLoader2;
    }

    public DataFetcher<ImageVideoWrapper> getResourceFetcher(A a10, int i10, int i11) {
        DataFetcher<InputStream> dataFetcher;
        DataFetcher<ParcelFileDescriptor> dataFetcher2;
        ModelLoader<A, InputStream> modelLoader = this.streamLoader;
        if (modelLoader != null) {
            dataFetcher = modelLoader.getResourceFetcher(a10, i10, i11);
        } else {
            dataFetcher = null;
        }
        ModelLoader<A, ParcelFileDescriptor> modelLoader2 = this.fileDescriptorLoader;
        if (modelLoader2 != null) {
            dataFetcher2 = modelLoader2.getResourceFetcher(a10, i10, i11);
        } else {
            dataFetcher2 = null;
        }
        if (dataFetcher == null && dataFetcher2 == null) {
            return null;
        }
        return new ImageVideoFetcher(dataFetcher, dataFetcher2);
    }
}
