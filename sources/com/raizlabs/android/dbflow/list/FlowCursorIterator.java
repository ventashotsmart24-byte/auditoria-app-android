package com.raizlabs.android.dbflow.list;

import android.database.Cursor;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;

public class FlowCursorIterator<TModel> implements ListIterator<TModel>, AutoCloseable {
    private long count;
    private final IFlowCursorIterator<TModel> cursorList;
    private long reverseIndex;
    private long startingCount;

    public FlowCursorIterator(IFlowCursorIterator<TModel> iFlowCursorIterator) {
        this(iFlowCursorIterator, 0, iFlowCursorIterator.getCount());
    }

    private void checkSizes() {
        if (this.startingCount != this.cursorList.getCount()) {
            throw new ConcurrentModificationException("Cannot change Cursor data during iteration.");
        }
    }

    public void add(TModel tmodel) {
        throw new UnsupportedOperationException("Cursor Iterator: Cannot add a model in the iterator");
    }

    public void close() {
        this.cursorList.close();
    }

    public boolean hasNext() {
        checkSizes();
        if (this.reverseIndex > 0) {
            return true;
        }
        return false;
    }

    public boolean hasPrevious() {
        checkSizes();
        if (this.reverseIndex < this.count) {
            return true;
        }
        return false;
    }

    public TModel next() {
        checkSizes();
        TModel item = this.cursorList.getItem(this.count - this.reverseIndex);
        this.reverseIndex--;
        return item;
    }

    public int nextIndex() {
        return (int) (this.reverseIndex + 1);
    }

    public TModel previous() {
        checkSizes();
        TModel item = this.cursorList.getItem(this.count - this.reverseIndex);
        this.reverseIndex++;
        return item;
    }

    public int previousIndex() {
        return (int) this.reverseIndex;
    }

    public void remove() {
        throw new UnsupportedOperationException("Cursor Iterator: cannot remove from an active Iterator ");
    }

    public void set(TModel tmodel) {
        throw new UnsupportedOperationException("Cursor Iterator: cannot set on an active Iterator ");
    }

    public FlowCursorIterator(IFlowCursorIterator<TModel> iFlowCursorIterator, int i10) {
        this(iFlowCursorIterator, i10, iFlowCursorIterator.getCount() - ((long) i10));
    }

    public FlowCursorIterator(IFlowCursorIterator<TModel> iFlowCursorIterator, int i10, long j10) {
        this.cursorList = iFlowCursorIterator;
        this.count = j10;
        Cursor cursor = iFlowCursorIterator.cursor();
        if (cursor != null) {
            if (this.count > ((long) (cursor.getCount() - i10))) {
                this.count = (long) (cursor.getCount() - i10);
            }
            cursor.moveToPosition(i10 - 1);
            this.startingCount = iFlowCursorIterator.getCount();
            long j11 = this.count - ((long) i10);
            this.reverseIndex = j11;
            if (j11 < 0) {
                this.reverseIndex = 0;
            }
        }
    }
}
