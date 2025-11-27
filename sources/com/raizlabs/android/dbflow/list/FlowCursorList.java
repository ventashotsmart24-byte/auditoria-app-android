package com.raizlabs.android.dbflow.list;

import android.database.Cursor;
import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.From;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.queriable.ModelQueriable;
import com.raizlabs.android.dbflow.structure.InstanceAdapter;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.cache.ModelCache;
import com.raizlabs.android.dbflow.structure.cache.ModelLruCache;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FlowCursorList<TModel> implements Iterable<TModel>, IFlowCursorIterator<TModel> {
    public static final int DEFAULT_CACHE_SIZE = 50;
    public static final int MIN_CACHE_SIZE = 20;
    private boolean cacheModels;
    private FlowCursor cursor;
    private final Set<OnCursorRefreshListener<TModel>> cursorRefreshListenerSet;
    private InstanceAdapter<TModel> instanceAdapter;
    private ModelCache<TModel, ?> modelCache;
    private ModelQueriable<TModel> modelQueriable;
    private Class<TModel> table;

    public interface OnCursorRefreshListener<TModel> {
        void onCursorRefreshed(FlowCursorList<TModel> flowCursorList);
    }

    private void throwIfCursorClosed() {
        FlowCursor flowCursor = this.cursor;
        if (flowCursor != null && flowCursor.isClosed()) {
            throw new IllegalStateException("Cursor has been closed for FlowCursorList");
        }
    }

    private void warnEmptyCursor() {
        if (this.cursor == null) {
            FlowLog.log(FlowLog.Level.W, "Cursor was null for FlowCursorList");
        }
    }

    public void addOnCursorRefreshListener(OnCursorRefreshListener<TModel> onCursorRefreshListener) {
        synchronized (this.cursorRefreshListenerSet) {
            this.cursorRefreshListenerSet.add(onCursorRefreshListener);
        }
    }

    public boolean cachingEnabled() {
        return this.cacheModels;
    }

    public void clearCache() {
        if (this.cacheModels) {
            this.modelCache.clear();
        }
    }

    public void close() {
        warnEmptyCursor();
        FlowCursor flowCursor = this.cursor;
        if (flowCursor != null) {
            flowCursor.close();
        }
        this.cursor = null;
    }

    public Cursor cursor() {
        throwIfCursorClosed();
        warnEmptyCursor();
        return this.cursor;
    }

    public List<TModel> getAll() {
        throwIfCursorClosed();
        warnEmptyCursor();
        if (this.cacheModels) {
            ArrayList arrayList = new ArrayList();
            FlowCursorIterator it = iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            return arrayList;
        } else if (this.cursor == null) {
            return new ArrayList();
        } else {
            return FlowManager.getModelAdapter(this.table).getListModelLoader().convertToData(this.cursor, (List) null);
        }
    }

    public long getCount() {
        throwIfCursorClosed();
        warnEmptyCursor();
        FlowCursor flowCursor = this.cursor;
        if (flowCursor != null) {
            return (long) flowCursor.getCount();
        }
        return 0;
    }

    public InstanceAdapter<TModel> getInstanceAdapter() {
        return this.instanceAdapter;
    }

    public TModel getItem(long j10) {
        FlowCursor flowCursor;
        throwIfCursorClosed();
        warnEmptyCursor();
        if (this.cacheModels) {
            TModel tmodel = this.modelCache.get(Long.valueOf(j10));
            if (tmodel != null || (flowCursor = this.cursor) == null || !flowCursor.moveToPosition((int) j10)) {
                return tmodel;
            }
            TModel convertToData = this.instanceAdapter.getSingleModelLoader().convertToData(this.cursor, null, false);
            this.modelCache.addModel(Long.valueOf(j10), convertToData);
            return convertToData;
        }
        FlowCursor flowCursor2 = this.cursor;
        if (flowCursor2 == null || !flowCursor2.moveToPosition((int) j10)) {
            return null;
        }
        return this.instanceAdapter.getSingleModelLoader().convertToData(this.cursor, null, false);
    }

    public ModelAdapter<TModel> getModelAdapter() {
        return (ModelAdapter) this.instanceAdapter;
    }

    public boolean isEmpty() {
        throwIfCursorClosed();
        warnEmptyCursor();
        if (getCount() == 0) {
            return true;
        }
        return false;
    }

    public ModelCache<TModel, ?> modelCache() {
        return this.modelCache;
    }

    public ModelQueriable<TModel> modelQueriable() {
        return this.modelQueriable;
    }

    public Builder<TModel> newBuilder() {
        return new Builder(this.table).modelQueriable(this.modelQueriable).cursor(this.cursor).cacheModels(this.cacheModels).modelCache(this.modelCache);
    }

    public synchronized void refresh() {
        warnEmptyCursor();
        FlowCursor flowCursor = this.cursor;
        if (flowCursor != null) {
            flowCursor.close();
        }
        ModelQueriable<TModel> modelQueriable2 = this.modelQueriable;
        if (modelQueriable2 != null) {
            this.cursor = modelQueriable2.query();
            if (this.cacheModels) {
                this.modelCache.clear();
                setCacheModels(true);
            }
            synchronized (this.cursorRefreshListenerSet) {
                for (OnCursorRefreshListener<TModel> onCursorRefreshed : this.cursorRefreshListenerSet) {
                    onCursorRefreshed.onCursorRefreshed(this);
                }
            }
        } else {
            throw new IllegalStateException("Cannot refresh this FlowCursorList. This list was instantiated from a Cursor. Once closed, we cannot reopen it. Construct a new instance and swap with this instance.");
        }
    }

    public void removeOnCursorRefreshListener(OnCursorRefreshListener<TModel> onCursorRefreshListener) {
        synchronized (this.cursorRefreshListenerSet) {
            this.cursorRefreshListenerSet.remove(onCursorRefreshListener);
        }
    }

    public void setCacheModels(boolean z10) {
        this.cacheModels = z10;
        if (!z10) {
            clearCache();
        }
    }

    public Class<TModel> table() {
        return this.table;
    }

    private FlowCursorList(Builder<TModel> builder) {
        this.cursorRefreshListenerSet = new HashSet();
        this.table = builder.modelClass;
        this.modelQueriable = builder.modelQueriable;
        if (builder.modelQueriable == null) {
            FlowCursor access$200 = builder.cursor;
            this.cursor = access$200;
            if (access$200 == null) {
                From<TModel> from = SQLite.select(new IProperty[0]).from(this.table);
                this.modelQueriable = from;
                this.cursor = from.query();
            }
        } else {
            this.cursor = builder.modelQueriable.query();
        }
        boolean access$300 = builder.cacheModels;
        this.cacheModels = access$300;
        if (access$300) {
            ModelCache<TModel, ?> access$400 = builder.modelCache;
            this.modelCache = access$400;
            if (access$400 == null) {
                this.modelCache = ModelLruCache.newInstance(0);
            }
        }
        this.instanceAdapter = FlowManager.getInstanceAdapter(builder.modelClass);
        setCacheModels(this.cacheModels);
    }

    public FlowCursorIterator<TModel> iterator() {
        return new FlowCursorIterator<>(this);
    }

    public static class Builder<TModel> {
        /* access modifiers changed from: private */
        public boolean cacheModels = true;
        /* access modifiers changed from: private */
        public FlowCursor cursor;
        /* access modifiers changed from: private */
        public ModelCache<TModel, ?> modelCache;
        /* access modifiers changed from: private */
        public final Class<TModel> modelClass;
        /* access modifiers changed from: private */
        public ModelQueriable<TModel> modelQueriable;

        public Builder(Class<TModel> cls) {
            this.modelClass = cls;
        }

        public FlowCursorList<TModel> build() {
            return new FlowCursorList<>(this);
        }

        public Builder<TModel> cacheModels(boolean z10) {
            this.cacheModels = z10;
            return this;
        }

        public Builder<TModel> cursor(Cursor cursor2) {
            if (cursor2 != null) {
                this.cursor = FlowCursor.from(cursor2);
            }
            return this;
        }

        public Builder<TModel> modelCache(ModelCache<TModel, ?> modelCache2) {
            this.modelCache = modelCache2;
            if (modelCache2 != null) {
                cacheModels(true);
            }
            return this;
        }

        public Builder<TModel> modelQueriable(ModelQueriable<TModel> modelQueriable2) {
            this.modelQueriable = modelQueriable2;
            return this;
        }

        public Builder(ModelQueriable<TModel> modelQueriable2) {
            this.modelClass = modelQueriable2.getTable();
            modelQueriable(modelQueriable2);
        }
    }

    public FlowCursorIterator<TModel> iterator(int i10, long j10) {
        return new FlowCursorIterator<>(this, i10, j10);
    }
}
