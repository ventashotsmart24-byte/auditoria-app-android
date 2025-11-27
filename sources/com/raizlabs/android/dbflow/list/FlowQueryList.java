package com.raizlabs.android.dbflow.list;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.raizlabs.android.dbflow.StringUtils;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.list.FlowCursorList;
import com.raizlabs.android.dbflow.runtime.FlowContentObserver;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.queriable.ModelQueriable;
import com.raizlabs.android.dbflow.structure.InstanceAdapter;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.cache.ModelCache;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.ProcessModelTransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class FlowQueryList<TModel> extends FlowContentObserver implements List<TModel>, IFlowCursorIterator<TModel> {
    private static final Handler REFRESH_HANDLER = new Handler(Looper.myLooper());
    /* access modifiers changed from: private */
    public boolean changeInTransaction;
    private final ProcessModelTransaction.ProcessModel<TModel> deleteModel;
    /* access modifiers changed from: private */
    public final Transaction.Error errorCallback;
    private final FlowCursorList<TModel> internalCursorList;
    private final Transaction.Error internalErrorCallback;
    private final Transaction.Success internalSuccessCallback;
    /* access modifiers changed from: private */
    public boolean pendingRefresh;
    private final Runnable refreshRunnable;
    private final ProcessModelTransaction.ProcessModel<TModel> saveModel;
    /* access modifiers changed from: private */
    public final Transaction.Success successCallback;
    private boolean transact;
    private final ProcessModelTransaction.ProcessModel<TModel> updateModel;

    public static class Builder<TModel> {
        /* access modifiers changed from: private */
        public boolean cacheModels;
        /* access modifiers changed from: private */
        public boolean changeInTransaction;
        /* access modifiers changed from: private */
        public String contentAuthority;
        /* access modifiers changed from: private */
        public Cursor cursor;
        /* access modifiers changed from: private */
        public Transaction.Error error;
        /* access modifiers changed from: private */
        public ModelCache<TModel, ?> modelCache;
        /* access modifiers changed from: private */
        public ModelQueriable<TModel> modelQueriable;
        /* access modifiers changed from: private */
        public Transaction.Success success;
        /* access modifiers changed from: private */
        public final Class<TModel> table;
        /* access modifiers changed from: private */
        public boolean transact;

        public FlowQueryList<TModel> build() {
            return new FlowQueryList<>(this);
        }

        public Builder<TModel> cacheModels(boolean z10) {
            this.cacheModels = z10;
            return this;
        }

        public Builder<TModel> changeInTransaction(boolean z10) {
            this.changeInTransaction = z10;
            return this;
        }

        public Builder<TModel> contentAuthority(String str) {
            this.contentAuthority = str;
            return this;
        }

        public Builder<TModel> cursor(Cursor cursor2) {
            this.cursor = cursor2;
            return this;
        }

        public Builder<TModel> error(Transaction.Error error2) {
            this.error = error2;
            return this;
        }

        public Builder<TModel> modelCache(ModelCache<TModel, ?> modelCache2) {
            this.modelCache = modelCache2;
            return this;
        }

        public Builder<TModel> modelQueriable(ModelQueriable<TModel> modelQueriable2) {
            this.modelQueriable = modelQueriable2;
            return this;
        }

        public Builder<TModel> success(Transaction.Success success2) {
            this.success = success2;
            return this;
        }

        public Builder<TModel> transact(boolean z10) {
            this.transact = z10;
            return this;
        }

        private Builder(FlowCursorList<TModel> flowCursorList) {
            this.cacheModels = true;
            this.table = flowCursorList.table();
            this.cursor = flowCursorList.cursor();
            this.cacheModels = flowCursorList.cachingEnabled();
            this.modelQueriable = flowCursorList.modelQueriable();
            this.modelCache = flowCursorList.modelCache();
        }

        public Builder(Class<TModel> cls) {
            this.cacheModels = true;
            this.table = cls;
        }

        public Builder(ModelQueriable<TModel> modelQueriable2) {
            this(modelQueriable2.getTable());
            modelQueriable(modelQueriable2);
        }
    }

    public void add(int i10, TModel tmodel) {
        add(tmodel);
    }

    public boolean addAll(int i10, Collection<? extends TModel> collection) {
        return addAll(collection);
    }

    public void addOnCursorRefreshListener(FlowCursorList.OnCursorRefreshListener<TModel> onCursorRefreshListener) {
        this.internalCursorList.addOnCursorRefreshListener(onCursorRefreshListener);
    }

    public boolean changeInTransaction() {
        return this.changeInTransaction;
    }

    public void clear() {
        Transaction build = FlowManager.getDatabaseForTable(this.internalCursorList.table()).beginTransactionAsync(new QueryTransaction.Builder(SQLite.delete().from(this.internalCursorList.table())).build()).error(this.internalErrorCallback).success(this.internalSuccessCallback).build();
        if (this.transact) {
            build.execute();
        } else {
            build.executeSync();
        }
    }

    public void close() {
        this.internalCursorList.close();
    }

    public boolean contains(Object obj) {
        if (obj == null || !this.internalCursorList.table().isAssignableFrom(obj.getClass())) {
            return false;
        }
        return this.internalCursorList.getInstanceAdapter().exists(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        boolean z10 = !collection.isEmpty();
        if (!z10) {
            return z10;
        }
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return z10;
    }

    public Cursor cursor() {
        return this.internalCursorList.cursor();
    }

    public FlowCursorList<TModel> cursorList() {
        return this.internalCursorList;
    }

    public void endTransactionAndNotify() {
        if (this.changeInTransaction) {
            this.changeInTransaction = false;
            refresh();
        }
        super.endTransactionAndNotify();
    }

    public Transaction.Error error() {
        return this.errorCallback;
    }

    public TModel get(int i10) {
        return this.internalCursorList.getItem((long) i10);
    }

    public List<TModel> getCopy() {
        return this.internalCursorList.getAll();
    }

    public long getCount() {
        return this.internalCursorList.getCount();
    }

    public InstanceAdapter<TModel> getInstanceAdapter() {
        return this.internalCursorList.getInstanceAdapter();
    }

    public TModel getItem(long j10) {
        return this.internalCursorList.getItem(j10);
    }

    public ModelAdapter<TModel> getModelAdapter() {
        return this.internalCursorList.getModelAdapter();
    }

    public int indexOf(Object obj) {
        throw new UnsupportedOperationException("We cannot determine which index in the table this item exists at efficiently");
    }

    public boolean isEmpty() {
        return this.internalCursorList.isEmpty();
    }

    public int lastIndexOf(Object obj) {
        throw new UnsupportedOperationException("We cannot determine which index in the table this item exists at efficiently");
    }

    public ListIterator<TModel> listIterator() {
        return new FlowCursorIterator(this);
    }

    public Builder<TModel> newBuilder() {
        return new Builder(this.internalCursorList).success(this.successCallback).error(this.errorCallback).changeInTransaction(this.changeInTransaction).transact(this.transact);
    }

    public void onChange(boolean z10) {
        super.onChange(z10);
        if (!this.isInTransaction) {
            refreshAsync();
        } else {
            this.changeInTransaction = true;
        }
    }

    public void refresh() {
        this.internalCursorList.refresh();
    }

    public void refreshAsync() {
        synchronized (this) {
            if (!this.pendingRefresh) {
                this.pendingRefresh = true;
                REFRESH_HANDLER.post(this.refreshRunnable);
            }
        }
    }

    public void registerForContentChanges(Context context) {
        super.registerForContentChanges(context, (Class<?>) this.internalCursorList.table());
    }

    public TModel remove(int i10) {
        TModel item = this.internalCursorList.getItem((long) i10);
        Transaction build = FlowManager.getDatabaseForTable(this.internalCursorList.table()).beginTransactionAsync(new ProcessModelTransaction.Builder(this.deleteModel).add(item).build()).error(this.internalErrorCallback).success(this.internalSuccessCallback).build();
        if (this.transact) {
            build.execute();
        } else {
            build.executeSync();
        }
        return item;
    }

    public boolean removeAll(Collection<?> collection) {
        Transaction build = FlowManager.getDatabaseForTable(this.internalCursorList.table()).beginTransactionAsync(new ProcessModelTransaction.Builder(this.deleteModel).addAll(collection).build()).error(this.internalErrorCallback).success(this.internalSuccessCallback).build();
        if (this.transact) {
            build.execute();
            return true;
        }
        build.executeSync();
        return true;
    }

    public void removeOnCursorRefreshListener(FlowCursorList.OnCursorRefreshListener<TModel> onCursorRefreshListener) {
        this.internalCursorList.removeOnCursorRefreshListener(onCursorRefreshListener);
    }

    public boolean retainAll(Collection<?> collection) {
        List<TModel> all = this.internalCursorList.getAll();
        all.removeAll(collection);
        Transaction build = FlowManager.getDatabaseForTable(this.internalCursorList.table()).beginTransactionAsync(new ProcessModelTransaction.Builder(all, this.deleteModel).build()).error(this.internalErrorCallback).success(this.internalSuccessCallback).build();
        if (this.transact) {
            build.execute();
            return true;
        }
        build.executeSync();
        return true;
    }

    public TModel set(int i10, TModel tmodel) {
        return set(tmodel);
    }

    public int size() {
        return (int) this.internalCursorList.getCount();
    }

    public List<TModel> subList(int i10, int i11) {
        return this.internalCursorList.getAll().subList(i10, i11);
    }

    public Transaction.Success success() {
        return this.successCallback;
    }

    public Object[] toArray() {
        return this.internalCursorList.getAll().toArray();
    }

    public boolean transact() {
        return this.transact;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private FlowQueryList(Builder<TModel> builder) {
        super(StringUtils.isNotNullOrEmpty(builder.contentAuthority) ? builder.contentAuthority : FlowManager.DEFAULT_AUTHORITY);
        this.transact = false;
        this.changeInTransaction = false;
        this.pendingRefresh = false;
        this.saveModel = new ProcessModelTransaction.ProcessModel<TModel>() {
            public void processModel(TModel tmodel, DatabaseWrapper databaseWrapper) {
                FlowQueryList.this.getModelAdapter().save(tmodel);
            }
        };
        this.updateModel = new ProcessModelTransaction.ProcessModel<TModel>() {
            public void processModel(TModel tmodel, DatabaseWrapper databaseWrapper) {
                FlowQueryList.this.getModelAdapter().update(tmodel);
            }
        };
        this.deleteModel = new ProcessModelTransaction.ProcessModel<TModel>() {
            public void processModel(TModel tmodel, DatabaseWrapper databaseWrapper) {
                FlowQueryList.this.getModelAdapter().delete(tmodel);
            }
        };
        this.internalErrorCallback = new Transaction.Error() {
            public void onError(Transaction transaction, Throwable th) {
                if (FlowQueryList.this.errorCallback != null) {
                    FlowQueryList.this.errorCallback.onError(transaction, th);
                }
            }
        };
        this.internalSuccessCallback = new Transaction.Success() {
            public void onSuccess(Transaction transaction) {
                if (!FlowQueryList.this.isInTransaction) {
                    FlowQueryList.this.refreshAsync();
                } else {
                    boolean unused = FlowQueryList.this.changeInTransaction = true;
                }
                if (FlowQueryList.this.successCallback != null) {
                    FlowQueryList.this.successCallback.onSuccess(transaction);
                }
            }
        };
        this.refreshRunnable = new Runnable() {
            public void run() {
                synchronized (this) {
                    boolean unused = FlowQueryList.this.pendingRefresh = false;
                }
                FlowQueryList.this.refresh();
            }
        };
        this.transact = builder.transact;
        this.changeInTransaction = builder.changeInTransaction;
        this.successCallback = builder.success;
        this.errorCallback = builder.error;
        this.internalCursorList = new FlowCursorList.Builder(builder.table).cursor(builder.cursor).cacheModels(builder.cacheModels).modelQueriable(builder.modelQueriable).modelCache(builder.modelCache).build();
    }

    public boolean add(TModel tmodel) {
        if (tmodel == null) {
            return false;
        }
        Transaction build = FlowManager.getDatabaseForTable(this.internalCursorList.table()).beginTransactionAsync(new ProcessModelTransaction.Builder(this.saveModel).add(tmodel).build()).error(this.internalErrorCallback).success(this.internalSuccessCallback).build();
        if (this.transact) {
            build.execute();
            return true;
        }
        build.executeSync();
        return true;
    }

    public boolean addAll(Collection<? extends TModel> collection) {
        Transaction build = FlowManager.getDatabaseForTable(this.internalCursorList.table()).beginTransactionAsync(new ProcessModelTransaction.Builder(this.saveModel).addAll(collection).build()).error(this.internalErrorCallback).success(this.internalSuccessCallback).build();
        if (this.transact) {
            build.execute();
            return true;
        }
        build.executeSync();
        return true;
    }

    public FlowCursorIterator<TModel> iterator() {
        return new FlowCursorIterator<>(this);
    }

    public ListIterator<TModel> listIterator(int i10) {
        return new FlowCursorIterator(this, i10);
    }

    public void registerForContentChanges(Context context, Class<?> cls) {
        throw new RuntimeException("This method is not to be used in the FlowQueryList. We should only ever receive notifications for one class here. Call registerForContentChanges(Context) instead");
    }

    public TModel set(TModel tmodel) {
        Transaction build = FlowManager.getDatabaseForTable(this.internalCursorList.table()).beginTransactionAsync(new ProcessModelTransaction.Builder(this.updateModel).add(tmodel).build()).error(this.internalErrorCallback).success(this.internalSuccessCallback).build();
        if (this.transact) {
            build.execute();
        } else {
            build.executeSync();
        }
        return tmodel;
    }

    public FlowCursorIterator<TModel> iterator(int i10, long j10) {
        return new FlowCursorIterator<>(this, i10, j10);
    }

    public <T> T[] toArray(T[] tArr) {
        return this.internalCursorList.getAll().toArray(tArr);
    }

    public void onChange(boolean z10, Uri uri) {
        super.onChange(z10, uri);
        if (!this.isInTransaction) {
            refreshAsync();
        } else {
            this.changeInTransaction = true;
        }
    }

    public boolean remove(Object obj) {
        if (!this.internalCursorList.table().isAssignableFrom(obj.getClass())) {
            return false;
        }
        Transaction build = FlowManager.getDatabaseForTable(this.internalCursorList.table()).beginTransactionAsync(new ProcessModelTransaction.Builder(this.deleteModel).add(obj).build()).error(this.internalErrorCallback).success(this.internalSuccessCallback).build();
        if (this.transact) {
            build.execute();
        } else {
            build.executeSync();
        }
        return true;
    }
}
