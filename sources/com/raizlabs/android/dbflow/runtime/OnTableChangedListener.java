package com.raizlabs.android.dbflow.runtime;

import com.raizlabs.android.dbflow.structure.BaseModel;

public interface OnTableChangedListener {
    void onTableChanged(Class<?> cls, BaseModel.Action action);
}
