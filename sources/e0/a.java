package e0;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import com.umeng.analytics.pro.bx;
import e0.b;

public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f6445a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f6446b;

    /* renamed from: c  reason: collision with root package name */
    public Cursor f6447c;

    /* renamed from: d  reason: collision with root package name */
    public Context f6448d;

    /* renamed from: e  reason: collision with root package name */
    public int f6449e;

    /* renamed from: f  reason: collision with root package name */
    public C0080a f6450f;

    /* renamed from: g  reason: collision with root package name */
    public DataSetObserver f6451g;

    /* renamed from: h  reason: collision with root package name */
    public b f6452h;

    /* renamed from: e0.a$a  reason: collision with other inner class name */
    public class C0080a extends ContentObserver {
        public C0080a() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z10) {
            a.this.i();
        }
    }

    public class b extends DataSetObserver {
        public b() {
        }

        public void onChanged() {
            a aVar = a.this;
            aVar.f6445a = true;
            aVar.notifyDataSetChanged();
        }

        public void onInvalidated() {
            a aVar = a.this;
            aVar.f6445a = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z10) {
        int i10;
        if (z10) {
            i10 = 1;
        } else {
            i10 = 2;
        }
        f(context, cursor, i10);
    }

    public void a(Cursor cursor) {
        Cursor j10 = j(cursor);
        if (j10 != null) {
            j10.close();
        }
    }

    public abstract CharSequence b(Cursor cursor);

    public Cursor d() {
        return this.f6447c;
    }

    public abstract void e(View view, Context context, Cursor cursor);

    public void f(Context context, Cursor cursor, int i10) {
        int i11;
        boolean z10 = false;
        if ((i10 & 1) == 1) {
            i10 |= 2;
            this.f6446b = true;
        } else {
            this.f6446b = false;
        }
        if (cursor != null) {
            z10 = true;
        }
        this.f6447c = cursor;
        this.f6445a = z10;
        this.f6448d = context;
        if (z10) {
            i11 = cursor.getColumnIndexOrThrow(bx.f13988d);
        } else {
            i11 = -1;
        }
        this.f6449e = i11;
        if ((i10 & 2) == 2) {
            this.f6450f = new C0080a();
            this.f6451g = new b();
        } else {
            this.f6450f = null;
            this.f6451g = null;
        }
        if (z10) {
            C0080a aVar = this.f6450f;
            if (aVar != null) {
                cursor.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f6451g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    public int getCount() {
        Cursor cursor;
        if (!this.f6445a || (cursor = this.f6447c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
        if (!this.f6445a) {
            return null;
        }
        this.f6447c.moveToPosition(i10);
        if (view == null) {
            view = g(this.f6448d, this.f6447c, viewGroup);
        }
        e(view, this.f6448d, this.f6447c);
        return view;
    }

    public Filter getFilter() {
        if (this.f6452h == null) {
            this.f6452h = new b(this);
        }
        return this.f6452h;
    }

    public Object getItem(int i10) {
        Cursor cursor;
        if (!this.f6445a || (cursor = this.f6447c) == null) {
            return null;
        }
        cursor.moveToPosition(i10);
        return this.f6447c;
    }

    public long getItemId(int i10) {
        Cursor cursor;
        if (!this.f6445a || (cursor = this.f6447c) == null || !cursor.moveToPosition(i10)) {
            return 0;
        }
        return this.f6447c.getLong(this.f6449e);
    }

    public View getView(int i10, View view, ViewGroup viewGroup) {
        if (!this.f6445a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f6447c.moveToPosition(i10)) {
            if (view == null) {
                view = h(this.f6448d, this.f6447c, viewGroup);
            }
            e(view, this.f6448d, this.f6447c);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i10);
        }
    }

    public abstract View h(Context context, Cursor cursor, ViewGroup viewGroup);

    public void i() {
        Cursor cursor;
        if (this.f6446b && (cursor = this.f6447c) != null && !cursor.isClosed()) {
            this.f6445a = this.f6447c.requery();
        }
    }

    public Cursor j(Cursor cursor) {
        Cursor cursor2 = this.f6447c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0080a aVar = this.f6450f;
            if (aVar != null) {
                cursor2.unregisterContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f6451g;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f6447c = cursor;
        if (cursor != null) {
            C0080a aVar2 = this.f6450f;
            if (aVar2 != null) {
                cursor.registerContentObserver(aVar2);
            }
            DataSetObserver dataSetObserver2 = this.f6451g;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f6449e = cursor.getColumnIndexOrThrow(bx.f13988d);
            this.f6445a = true;
            notifyDataSetChanged();
        } else {
            this.f6449e = -1;
            this.f6445a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}
