package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.IOException;
import java.util.List;

class SourceGenerator implements DataFetcherGenerator, DataFetcherGenerator.FetcherReadyCallback {
    private static final String TAG = "SourceGenerator";

    /* renamed from: cb  reason: collision with root package name */
    private final DataFetcherGenerator.FetcherReadyCallback f5116cb;
    private volatile Object dataToCache;
    private final DecodeHelper<?> helper;
    private volatile ModelLoader.LoadData<?> loadData;
    private volatile int loadDataListIndex;
    private volatile DataCacheKey originalKey;
    private volatile DataCacheGenerator sourceCacheGenerator;

    public SourceGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.helper = decodeHelper;
        this.f5116cb = fetcherReadyCallback;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00d2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean cacheData(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.String r0 = "SourceGenerator"
            long r1 = com.bumptech.glide.util.LogTime.getLogTime()
            r3 = 0
            com.bumptech.glide.load.engine.DecodeHelper<?> r4 = r11.helper     // Catch:{ all -> 0x00cf }
            com.bumptech.glide.load.data.DataRewinder r4 = r4.getRewinder(r12)     // Catch:{ all -> 0x00cf }
            java.lang.Object r5 = r4.rewindAndGet()     // Catch:{ all -> 0x00cf }
            com.bumptech.glide.load.engine.DecodeHelper<?> r6 = r11.helper     // Catch:{ all -> 0x00cf }
            com.bumptech.glide.load.Encoder r6 = r6.getSourceEncoder(r5)     // Catch:{ all -> 0x00cf }
            com.bumptech.glide.load.engine.DataCacheWriter r7 = new com.bumptech.glide.load.engine.DataCacheWriter     // Catch:{ all -> 0x00cf }
            com.bumptech.glide.load.engine.DecodeHelper<?> r8 = r11.helper     // Catch:{ all -> 0x00cf }
            com.bumptech.glide.load.Options r8 = r8.getOptions()     // Catch:{ all -> 0x00cf }
            r7.<init>(r6, r5, r8)     // Catch:{ all -> 0x00cf }
            com.bumptech.glide.load.engine.DataCacheKey r5 = new com.bumptech.glide.load.engine.DataCacheKey     // Catch:{ all -> 0x00cf }
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r8 = r11.loadData     // Catch:{ all -> 0x00cf }
            com.bumptech.glide.load.Key r8 = r8.sourceKey     // Catch:{ all -> 0x00cf }
            com.bumptech.glide.load.engine.DecodeHelper<?> r9 = r11.helper     // Catch:{ all -> 0x00cf }
            com.bumptech.glide.load.Key r9 = r9.getSignature()     // Catch:{ all -> 0x00cf }
            r5.<init>(r8, r9)     // Catch:{ all -> 0x00cf }
            com.bumptech.glide.load.engine.DecodeHelper<?> r8 = r11.helper     // Catch:{ all -> 0x00cf }
            com.bumptech.glide.load.engine.cache.DiskCache r8 = r8.getDiskCache()     // Catch:{ all -> 0x00cf }
            r8.put(r5, r7)     // Catch:{ all -> 0x00cf }
            r7 = 2
            boolean r7 = android.util.Log.isLoggable(r0, r7)     // Catch:{ all -> 0x00cf }
            java.lang.String r9 = ", data: "
            if (r7 == 0) goto L_0x006a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cf }
            r7.<init>()     // Catch:{ all -> 0x00cf }
            java.lang.String r10 = "Finished encoding source to cache, key: "
            r7.append(r10)     // Catch:{ all -> 0x00cf }
            r7.append(r5)     // Catch:{ all -> 0x00cf }
            r7.append(r9)     // Catch:{ all -> 0x00cf }
            r7.append(r12)     // Catch:{ all -> 0x00cf }
            java.lang.String r10 = ", encoder: "
            r7.append(r10)     // Catch:{ all -> 0x00cf }
            r7.append(r6)     // Catch:{ all -> 0x00cf }
            java.lang.String r6 = ", duration: "
            r7.append(r6)     // Catch:{ all -> 0x00cf }
            double r1 = com.bumptech.glide.util.LogTime.getElapsedMillis(r1)     // Catch:{ all -> 0x00cf }
            r7.append(r1)     // Catch:{ all -> 0x00cf }
        L_0x006a:
            java.io.File r1 = r8.get(r5)     // Catch:{ all -> 0x00cf }
            r2 = 1
            if (r1 == 0) goto L_0x008c
            r11.originalKey = r5     // Catch:{ all -> 0x00cf }
            com.bumptech.glide.load.engine.DataCacheGenerator r12 = new com.bumptech.glide.load.engine.DataCacheGenerator     // Catch:{ all -> 0x00cf }
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r0 = r11.loadData     // Catch:{ all -> 0x00cf }
            com.bumptech.glide.load.Key r0 = r0.sourceKey     // Catch:{ all -> 0x00cf }
            java.util.List r0 = java.util.Collections.singletonList(r0)     // Catch:{ all -> 0x00cf }
            com.bumptech.glide.load.engine.DecodeHelper<?> r1 = r11.helper     // Catch:{ all -> 0x00cf }
            r12.<init>(r0, r1, r11)     // Catch:{ all -> 0x00cf }
            r11.sourceCacheGenerator = r12     // Catch:{ all -> 0x00cf }
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r12 = r11.loadData
            com.bumptech.glide.load.data.DataFetcher<Data> r12 = r12.fetcher
            r12.cleanup()
            return r2
        L_0x008c:
            r1 = 3
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00cf }
            if (r0 == 0) goto L_0x00ad
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cf }
            r0.<init>()     // Catch:{ all -> 0x00cf }
            java.lang.String r1 = "Attempt to write: "
            r0.append(r1)     // Catch:{ all -> 0x00cf }
            com.bumptech.glide.load.engine.DataCacheKey r1 = r11.originalKey     // Catch:{ all -> 0x00cf }
            r0.append(r1)     // Catch:{ all -> 0x00cf }
            r0.append(r9)     // Catch:{ all -> 0x00cf }
            r0.append(r12)     // Catch:{ all -> 0x00cf }
            java.lang.String r12 = " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly..."
            r0.append(r12)     // Catch:{ all -> 0x00cf }
        L_0x00ad:
            com.bumptech.glide.load.engine.DataFetcherGenerator$FetcherReadyCallback r12 = r11.f5116cb     // Catch:{ all -> 0x00cc }
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r0 = r11.loadData     // Catch:{ all -> 0x00cc }
            com.bumptech.glide.load.Key r5 = r0.sourceKey     // Catch:{ all -> 0x00cc }
            java.lang.Object r6 = r4.rewindAndGet()     // Catch:{ all -> 0x00cc }
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r0 = r11.loadData     // Catch:{ all -> 0x00cc }
            com.bumptech.glide.load.data.DataFetcher<Data> r7 = r0.fetcher     // Catch:{ all -> 0x00cc }
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r0 = r11.loadData     // Catch:{ all -> 0x00cc }
            com.bumptech.glide.load.data.DataFetcher<Data> r0 = r0.fetcher     // Catch:{ all -> 0x00cc }
            com.bumptech.glide.load.DataSource r8 = r0.getDataSource()     // Catch:{ all -> 0x00cc }
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r0 = r11.loadData     // Catch:{ all -> 0x00cc }
            com.bumptech.glide.load.Key r9 = r0.sourceKey     // Catch:{ all -> 0x00cc }
            r4 = r12
            r4.onDataFetcherReady(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00cc }
            return r3
        L_0x00cc:
            r12 = move-exception
            r3 = 1
            goto L_0x00d0
        L_0x00cf:
            r12 = move-exception
        L_0x00d0:
            if (r3 != 0) goto L_0x00d9
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r0 = r11.loadData
            com.bumptech.glide.load.data.DataFetcher<Data> r0 = r0.fetcher
            r0.cleanup()
        L_0x00d9:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.SourceGenerator.cacheData(java.lang.Object):boolean");
    }

    private boolean hasNextModelLoader() {
        if (this.loadDataListIndex < this.helper.getLoadData().size()) {
            return true;
        }
        return false;
    }

    private void startNextLoad(final ModelLoader.LoadData<?> loadData2) {
        this.loadData.fetcher.loadData(this.helper.getPriority(), new DataFetcher.DataCallback<Object>() {
            public void onDataReady(Object obj) {
                if (SourceGenerator.this.isCurrentRequest(loadData2)) {
                    SourceGenerator.this.onDataReadyInternal(loadData2, obj);
                }
            }

            public void onLoadFailed(Exception exc) {
                if (SourceGenerator.this.isCurrentRequest(loadData2)) {
                    SourceGenerator.this.onLoadFailedInternal(loadData2, exc);
                }
            }
        });
    }

    public void cancel() {
        ModelLoader.LoadData<?> loadData2 = this.loadData;
        if (loadData2 != null) {
            loadData2.fetcher.cancel();
        }
    }

    public boolean isCurrentRequest(ModelLoader.LoadData<?> loadData2) {
        ModelLoader.LoadData<?> loadData3 = this.loadData;
        if (loadData3 == null || loadData3 != loadData2) {
            return false;
        }
        return true;
    }

    public void onDataFetcherFailed(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        this.f5116cb.onDataFetcherFailed(key, exc, dataFetcher, this.loadData.fetcher.getDataSource());
    }

    public void onDataFetcherReady(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.f5116cb.onDataFetcherReady(key, obj, dataFetcher, this.loadData.fetcher.getDataSource(), key);
    }

    public void onDataReadyInternal(ModelLoader.LoadData<?> loadData2, Object obj) {
        DiskCacheStrategy diskCacheStrategy = this.helper.getDiskCacheStrategy();
        if (obj == null || !diskCacheStrategy.isDataCacheable(loadData2.fetcher.getDataSource())) {
            DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback = this.f5116cb;
            Key key = loadData2.sourceKey;
            DataFetcher<Data> dataFetcher = loadData2.fetcher;
            fetcherReadyCallback.onDataFetcherReady(key, obj, dataFetcher, dataFetcher.getDataSource(), this.originalKey);
            return;
        }
        this.dataToCache = obj;
        this.f5116cb.reschedule();
    }

    public void onLoadFailedInternal(ModelLoader.LoadData<?> loadData2, Exception exc) {
        DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback = this.f5116cb;
        DataCacheKey dataCacheKey = this.originalKey;
        DataFetcher<Data> dataFetcher = loadData2.fetcher;
        fetcherReadyCallback.onDataFetcherFailed(dataCacheKey, exc, dataFetcher, dataFetcher.getDataSource());
    }

    public void reschedule() {
        throw new UnsupportedOperationException();
    }

    public boolean startNext() {
        if (this.dataToCache != null) {
            Object obj = this.dataToCache;
            this.dataToCache = null;
            try {
                if (!cacheData(obj)) {
                    return true;
                }
            } catch (IOException unused) {
                Log.isLoggable(TAG, 3);
            }
        }
        if (this.sourceCacheGenerator != null && this.sourceCacheGenerator.startNext()) {
            return true;
        }
        this.sourceCacheGenerator = null;
        this.loadData = null;
        boolean z10 = false;
        while (!z10 && hasNextModelLoader()) {
            List<ModelLoader.LoadData<?>> loadData2 = this.helper.getLoadData();
            int i10 = this.loadDataListIndex;
            this.loadDataListIndex = i10 + 1;
            this.loadData = loadData2.get(i10);
            if (this.loadData != null && (this.helper.getDiskCacheStrategy().isDataCacheable(this.loadData.fetcher.getDataSource()) || this.helper.hasLoadPath(this.loadData.fetcher.getDataClass()))) {
                startNextLoad(this.loadData);
                z10 = true;
            }
        }
        return z10;
    }
}
