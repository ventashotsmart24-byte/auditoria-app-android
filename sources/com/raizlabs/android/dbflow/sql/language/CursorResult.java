package com.raizlabs.android.dbflow.sql.language;

import android.database.Cursor;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.list.FlowCursorIterator;
import com.raizlabs.android.dbflow.list.IFlowCursorIterator;
import com.raizlabs.android.dbflow.structure.InstanceAdapter;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;
import java.util.ArrayList;
import java.util.List;

public class CursorResult<TModel> implements IFlowCursorIterator<TModel> {
    private FlowCursor cursor;
    private final InstanceAdapter<TModel> retrievalAdapter;

    public CursorResult(Class<TModel> cls, Cursor cursor2) {
        if (cursor2 != null) {
            this.cursor = FlowCursor.from(cursor2);
        }
        this.retrievalAdapter = FlowManager.getInstanceAdapter(cls);
    }

    public void close() {
        FlowCursor flowCursor = this.cursor;
        if (flowCursor != null) {
            flowCursor.close();
        }
    }

    public Cursor cursor() {
        return this.cursor;
    }

    public long getCount() {
        FlowCursor flowCursor = this.cursor;
        if (flowCursor == null) {
            return 0;
        }
        return (long) flowCursor.getCount();
    }

    public TModel getItem(long j10) {
        FlowCursor flowCursor = this.cursor;
        if (flowCursor == null || !flowCursor.moveToPosition((int) j10)) {
            return null;
        }
        return this.retrievalAdapter.getSingleModelLoader().convertToData(this.cursor, null, false);
    }

    public FlowCursorIterator<TModel> iterator() {
        return new FlowCursorIterator<>(this);
    }

    public void swapCursor(FlowCursor flowCursor) {
        FlowCursor flowCursor2 = this.cursor;
        if (flowCursor2 != null && !flowCursor2.isClosed()) {
            this.cursor.close();
        }
        this.cursor = flowCursor;
    }

    public <TCustom> List<TCustom> toCustomList(Class<TCustom> cls) {
        if (this.cursor != null) {
            return FlowManager.getQueryModelAdapter(cls).getListModelLoader().convertToData(this.cursor, (List) null);
        }
        return new ArrayList();
    }

    public <TCustom> List<TCustom> toCustomListClose(Class<TCustom> cls) {
        List<TCustom> list;
        if (this.cursor != null) {
            list = FlowManager.getQueryModelAdapter(cls).getListModelLoader().load(this.cursor);
        } else {
            list = new ArrayList<>();
        }
        close();
        return list;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.Class<TCustom>, java.lang.Class] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <TCustom> TCustom toCustomModel(java.lang.Class<TCustom> r3) {
        /*
            r2 = this;
            com.raizlabs.android.dbflow.structure.database.FlowCursor r0 = r2.cursor
            r1 = 0
            if (r0 == 0) goto L_0x0013
            com.raizlabs.android.dbflow.structure.QueryModelAdapter r3 = com.raizlabs.android.dbflow.config.FlowManager.getQueryModelAdapter(r3)
            com.raizlabs.android.dbflow.sql.queriable.SingleModelLoader r3 = r3.getSingleModelLoader()
            com.raizlabs.android.dbflow.structure.database.FlowCursor r0 = r2.cursor
            java.lang.Object r1 = r3.convertToData(r0, r1)
        L_0x0013:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.raizlabs.android.dbflow.sql.language.CursorResult.toCustomModel(java.lang.Class):java.lang.Object");
    }

    public <TCustom> TCustom toCustomModelClose(Class<TCustom> cls) {
        TCustom tcustom;
        if (this.cursor != null) {
            tcustom = FlowManager.getQueryModelAdapter(cls).getSingleModelLoader().load(this.cursor);
        } else {
            tcustom = null;
        }
        close();
        return tcustom;
    }

    public List<TModel> toList() {
        if (this.cursor != null) {
            return this.retrievalAdapter.getListModelLoader().convertToData(this.cursor, (List) null);
        }
        return new ArrayList();
    }

    public List<TModel> toListClose() {
        List<TModel> list;
        if (this.cursor != null) {
            list = this.retrievalAdapter.getListModelLoader().load(this.cursor);
        } else {
            list = new ArrayList<>();
        }
        close();
        return list;
    }

    public TModel toModel() {
        if (this.cursor != null) {
            return this.retrievalAdapter.getSingleModelLoader().convertToData(this.cursor, null);
        }
        return null;
    }

    public TModel toModelClose() {
        TModel tmodel;
        if (this.cursor != null) {
            tmodel = this.retrievalAdapter.getSingleModelLoader().load(this.cursor);
        } else {
            tmodel = null;
        }
        close();
        return tmodel;
    }

    public FlowCursorIterator<TModel> iterator(int i10, long j10) {
        return new FlowCursorIterator<>(this, i10, j10);
    }
}
