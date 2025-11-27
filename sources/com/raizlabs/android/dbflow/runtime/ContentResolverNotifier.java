package com.raizlabs.android.dbflow.runtime;

import android.database.ContentObserver;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.SqlUtils;
import com.raizlabs.android.dbflow.sql.language.SQLOperator;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.ModelAdapter;

public class ContentResolverNotifier implements ModelNotifier {
    private final String contentAuthority;

    public static class FlowContentTableNotifierRegister implements TableNotifierRegister {
        private final FlowContentObserver flowContentObserver;
        private final OnTableChangedListener internalContentChangeListener;
        /* access modifiers changed from: private */
        public OnTableChangedListener tableChangedListener;

        public FlowContentTableNotifierRegister(String str) {
            AnonymousClass1 r02 = new OnTableChangedListener() {
                public void onTableChanged(Class<?> cls, BaseModel.Action action) {
                    if (FlowContentTableNotifierRegister.this.tableChangedListener != null) {
                        FlowContentTableNotifierRegister.this.tableChangedListener.onTableChanged(cls, action);
                    }
                }
            };
            this.internalContentChangeListener = r02;
            FlowContentObserver flowContentObserver2 = new FlowContentObserver(str);
            this.flowContentObserver = flowContentObserver2;
            flowContentObserver2.addOnTableChangedListener(r02);
        }

        public boolean isSubscribed() {
            return !this.flowContentObserver.isSubscribed();
        }

        public <T> void register(Class<T> cls) {
            this.flowContentObserver.registerForContentChanges(FlowManager.getContext(), (Class<?>) cls);
        }

        public void setListener(OnTableChangedListener onTableChangedListener) {
            this.tableChangedListener = onTableChangedListener;
        }

        public <T> void unregister(Class<T> cls) {
            this.flowContentObserver.unregisterForContentChanges(FlowManager.getContext());
        }

        public void unregisterAll() {
            this.flowContentObserver.removeTableChangedListener(this.internalContentChangeListener);
            this.tableChangedListener = null;
        }
    }

    public ContentResolverNotifier(String str) {
        this.contentAuthority = str;
    }

    public TableNotifierRegister newRegister() {
        return new FlowContentTableNotifierRegister(this.contentAuthority);
    }

    public <T> void notifyModelChanged(T t10, ModelAdapter<T> modelAdapter, BaseModel.Action action) {
        if (FlowContentObserver.shouldNotify()) {
            FlowManager.getContext().getContentResolver().notifyChange(SqlUtils.getNotificationUri(this.contentAuthority, (Class<?>) modelAdapter.getModelClass(), action, (Iterable<SQLOperator>) modelAdapter.getPrimaryConditionClause(t10).getConditions()), (ContentObserver) null, true);
        }
    }

    public <T> void notifyTableChanged(Class<T> cls, BaseModel.Action action) {
        if (FlowContentObserver.shouldNotify()) {
            FlowManager.getContext().getContentResolver().notifyChange(SqlUtils.getNotificationUri(this.contentAuthority, (Class<?>) cls, action, (SQLOperator[]) null), (ContentObserver) null, true);
        }
    }
}
