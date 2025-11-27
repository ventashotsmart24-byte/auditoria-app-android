package com.raizlabs.android.dbflow.runtime;

public interface TableNotifierRegister {
    boolean isSubscribed();

    <T> void register(Class<T> cls);

    void setListener(OnTableChangedListener onTableChangedListener);

    <T> void unregister(Class<T> cls);

    void unregisterAll();
}
