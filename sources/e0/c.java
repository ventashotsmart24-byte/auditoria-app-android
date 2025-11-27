package e0;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class c extends a {

    /* renamed from: i  reason: collision with root package name */
    public int f6456i;

    /* renamed from: j  reason: collision with root package name */
    public int f6457j;

    /* renamed from: k  reason: collision with root package name */
    public LayoutInflater f6458k;

    public c(Context context, int i10, Cursor cursor, boolean z10) {
        super(context, cursor, z10);
        this.f6457j = i10;
        this.f6456i = i10;
        this.f6458k = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f6458k.inflate(this.f6457j, viewGroup, false);
    }

    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f6458k.inflate(this.f6456i, viewGroup, false);
    }
}
