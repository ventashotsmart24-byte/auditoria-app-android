package com.bumptech.glide.load.model;

import a0.e;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.Preconditions;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MultiModelLoader<Model, Data> implements ModelLoader<Model, Data> {
    private final e exceptionListPool;
    private final List<ModelLoader<Model, Data>> modelLoaders;

    public static class MultiFetcher<Data> implements DataFetcher<Data>, DataFetcher.DataCallback<Data> {
        private DataFetcher.DataCallback<? super Data> callback;
        private int currentIndex = 0;
        private List<Throwable> exceptions;
        private final List<DataFetcher<Data>> fetchers;
        private boolean isCancelled;
        private Priority priority;
        private final e throwableListPool;

        public MultiFetcher(List<DataFetcher<Data>> list, e eVar) {
            this.throwableListPool = eVar;
            Preconditions.checkNotEmpty(list);
            this.fetchers = list;
        }

        private void startNextOrFail() {
            if (!this.isCancelled) {
                if (this.currentIndex < this.fetchers.size() - 1) {
                    this.currentIndex++;
                    loadData(this.priority, this.callback);
                    return;
                }
                Preconditions.checkNotNull(this.exceptions);
                this.callback.onLoadFailed(new GlideException("Fetch failed", (List<Throwable>) new ArrayList(this.exceptions)));
            }
        }

        public void cancel() {
            this.isCancelled = true;
            for (DataFetcher<Data> cancel : this.fetchers) {
                cancel.cancel();
            }
        }

        public void cleanup() {
            List<Throwable> list = this.exceptions;
            if (list != null) {
                this.throwableListPool.release(list);
            }
            this.exceptions = null;
            for (DataFetcher<Data> cleanup : this.fetchers) {
                cleanup.cleanup();
            }
        }

        public Class<Data> getDataClass() {
            return this.fetchers.get(0).getDataClass();
        }

        public DataSource getDataSource() {
            return this.fetchers.get(0).getDataSource();
        }

        public void loadData(Priority priority2, DataFetcher.DataCallback<? super Data> dataCallback) {
            this.priority = priority2;
            this.callback = dataCallback;
            this.exceptions = (List) this.throwableListPool.acquire();
            this.fetchers.get(this.currentIndex).loadData(priority2, this);
            if (this.isCancelled) {
                cancel();
            }
        }

        public void onDataReady(Data data) {
            if (data != null) {
                this.callback.onDataReady(data);
            } else {
                startNextOrFail();
            }
        }

        public void onLoadFailed(Exception exc) {
            ((List) Preconditions.checkNotNull(this.exceptions)).add(exc);
            startNextOrFail();
        }
    }

    public MultiModelLoader(List<ModelLoader<Model, Data>> list, e eVar) {
        this.modelLoaders = list;
        this.exceptionListPool = eVar;
    }

    public ModelLoader.LoadData<Data> buildLoadData(Model model, int i10, int i11, Options options) {
        ModelLoader.LoadData buildLoadData;
        int size = this.modelLoaders.size();
        ArrayList arrayList = new ArrayList(size);
        Key key = null;
        for (int i12 = 0; i12 < size; i12++) {
            ModelLoader modelLoader = this.modelLoaders.get(i12);
            if (modelLoader.handles(model) && (buildLoadData = modelLoader.buildLoadData(model, i10, i11, options)) != null) {
                key = buildLoadData.sourceKey;
                arrayList.add(buildLoadData.fetcher);
            }
        }
        if (arrayList.isEmpty() || key == null) {
            return null;
        }
        return new ModelLoader.LoadData<>(key, new MultiFetcher(arrayList, this.exceptionListPool));
    }

    public boolean handles(Model model) {
        for (ModelLoader<Model, Data> handles : this.modelLoaders) {
            if (handles.handles(model)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.modelLoaders.toArray()) + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
