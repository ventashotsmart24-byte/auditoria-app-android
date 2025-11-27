package com.raizlabs.android.dbflow.list;

import android.database.Cursor;
import java.io.Closeable;

public interface IFlowCursorIterator<TModel> extends Closeable {
    void close();

    Cursor cursor();

    long getCount();

    TModel getItem(long j10);

    FlowCursorIterator<TModel> iterator();

    FlowCursorIterator<TModel> iterator(int i10, long j10);
}
