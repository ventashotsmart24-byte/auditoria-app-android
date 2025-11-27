package com.chad.library.adapter.base;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.util.Linkify;
import android.util.SparseArray;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class BaseViewHolder extends RecyclerView.d0 {
    /* access modifiers changed from: private */
    public BaseQuickAdapter adapter;
    Object associatedObject;
    private final LinkedHashSet<Integer> childClickViewIds = new LinkedHashSet<>();
    @Deprecated
    public View convertView;
    private final LinkedHashSet<Integer> itemChildLongClickViewIds = new LinkedHashSet<>();
    private final HashSet<Integer> nestViews = new HashSet<>();
    private final SparseArray<View> views = new SparseArray<>();

    public BaseViewHolder(View view) {
        super(view);
        this.convertView = view;
    }

    /* access modifiers changed from: private */
    public int getClickPosition() {
        if (getLayoutPosition() >= this.adapter.getHeaderLayoutCount()) {
            return getLayoutPosition() - this.adapter.getHeaderLayoutCount();
        }
        return 0;
    }

    public BaseViewHolder addOnClickListener(int... iArr) {
        for (int i10 : iArr) {
            this.childClickViewIds.add(Integer.valueOf(i10));
            View view = getView(i10);
            if (view != null) {
                if (!view.isClickable()) {
                    view.setClickable(true);
                }
                view.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (BaseViewHolder.this.adapter.getOnItemChildClickListener() != null) {
                            BaseViewHolder.this.adapter.getOnItemChildClickListener().onItemChildClick(BaseViewHolder.this.adapter, view, BaseViewHolder.this.getClickPosition());
                        }
                    }
                });
            }
        }
        return this;
    }

    public BaseViewHolder addOnLongClickListener(int... iArr) {
        for (int i10 : iArr) {
            this.itemChildLongClickViewIds.add(Integer.valueOf(i10));
            View view = getView(i10);
            if (view != null) {
                if (!view.isLongClickable()) {
                    view.setLongClickable(true);
                }
                view.setOnLongClickListener(new View.OnLongClickListener() {
                    public boolean onLongClick(View view) {
                        if (BaseViewHolder.this.adapter.getOnItemChildLongClickListener() == null || !BaseViewHolder.this.adapter.getOnItemChildLongClickListener().onItemChildLongClick(BaseViewHolder.this.adapter, view, BaseViewHolder.this.getClickPosition())) {
                            return false;
                        }
                        return true;
                    }
                });
            }
        }
        return this;
    }

    public Object getAssociatedObject() {
        return this.associatedObject;
    }

    public HashSet<Integer> getChildClickViewIds() {
        return this.childClickViewIds;
    }

    @Deprecated
    public View getConvertView() {
        return this.convertView;
    }

    public HashSet<Integer> getItemChildLongClickViewIds() {
        return this.itemChildLongClickViewIds;
    }

    public Set<Integer> getNestViews() {
        return this.nestViews;
    }

    public <T extends View> T getView(int i10) {
        T t10 = (View) this.views.get(i10);
        if (t10 != null) {
            return t10;
        }
        T findViewById = this.itemView.findViewById(i10);
        this.views.put(i10, findViewById);
        return findViewById;
    }

    public BaseViewHolder linkify(int i10) {
        Linkify.addLinks((TextView) getView(i10), 15);
        return this;
    }

    public BaseViewHolder setAdapter(int i10, Adapter adapter2) {
        ((AdapterView) getView(i10)).setAdapter(adapter2);
        return this;
    }

    public BaseViewHolder setAlpha(int i10, float f10) {
        getView(i10).setAlpha(f10);
        return this;
    }

    public void setAssociatedObject(Object obj) {
        this.associatedObject = obj;
    }

    public BaseViewHolder setBackgroundColor(int i10, int i11) {
        getView(i10).setBackgroundColor(i11);
        return this;
    }

    public BaseViewHolder setBackgroundRes(int i10, int i11) {
        getView(i10).setBackgroundResource(i11);
        return this;
    }

    public BaseViewHolder setChecked(int i10, boolean z10) {
        View view = getView(i10);
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(z10);
        }
        return this;
    }

    public BaseViewHolder setEnabled(int i10, boolean z10) {
        getView(i10).setEnabled(z10);
        return this;
    }

    public BaseViewHolder setGone(int i10, boolean z10) {
        int i11;
        View view = getView(i10);
        if (z10) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        view.setVisibility(i11);
        return this;
    }

    public BaseViewHolder setImageBitmap(int i10, Bitmap bitmap) {
        ((ImageView) getView(i10)).setImageBitmap(bitmap);
        return this;
    }

    public BaseViewHolder setImageDrawable(int i10, Drawable drawable) {
        ((ImageView) getView(i10)).setImageDrawable(drawable);
        return this;
    }

    public BaseViewHolder setImageResource(int i10, int i11) {
        ((ImageView) getView(i10)).setImageResource(i11);
        return this;
    }

    public BaseViewHolder setMax(int i10, int i11) {
        ((ProgressBar) getView(i10)).setMax(i11);
        return this;
    }

    public BaseViewHolder setNestView(int... iArr) {
        for (int valueOf : iArr) {
            this.nestViews.add(Integer.valueOf(valueOf));
        }
        addOnClickListener(iArr);
        addOnLongClickListener(iArr);
        return this;
    }

    public BaseViewHolder setOnCheckedChangeListener(int i10, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        ((CompoundButton) getView(i10)).setOnCheckedChangeListener(onCheckedChangeListener);
        return this;
    }

    @Deprecated
    public BaseViewHolder setOnClickListener(int i10, View.OnClickListener onClickListener) {
        getView(i10).setOnClickListener(onClickListener);
        return this;
    }

    @Deprecated
    public BaseViewHolder setOnItemClickListener(int i10, AdapterView.OnItemClickListener onItemClickListener) {
        ((AdapterView) getView(i10)).setOnItemClickListener(onItemClickListener);
        return this;
    }

    public BaseViewHolder setOnItemLongClickListener(int i10, AdapterView.OnItemLongClickListener onItemLongClickListener) {
        ((AdapterView) getView(i10)).setOnItemLongClickListener(onItemLongClickListener);
        return this;
    }

    public BaseViewHolder setOnItemSelectedClickListener(int i10, AdapterView.OnItemSelectedListener onItemSelectedListener) {
        ((AdapterView) getView(i10)).setOnItemSelectedListener(onItemSelectedListener);
        return this;
    }

    @Deprecated
    public BaseViewHolder setOnLongClickListener(int i10, View.OnLongClickListener onLongClickListener) {
        getView(i10).setOnLongClickListener(onLongClickListener);
        return this;
    }

    @Deprecated
    public BaseViewHolder setOnTouchListener(int i10, View.OnTouchListener onTouchListener) {
        getView(i10).setOnTouchListener(onTouchListener);
        return this;
    }

    public BaseViewHolder setProgress(int i10, int i11) {
        ((ProgressBar) getView(i10)).setProgress(i11);
        return this;
    }

    public BaseViewHolder setRating(int i10, float f10) {
        ((RatingBar) getView(i10)).setRating(f10);
        return this;
    }

    public BaseViewHolder setTag(int i10, Object obj) {
        getView(i10).setTag(obj);
        return this;
    }

    public BaseViewHolder setText(int i10, CharSequence charSequence) {
        ((TextView) getView(i10)).setText(charSequence);
        return this;
    }

    public BaseViewHolder setTextColor(int i10, int i11) {
        ((TextView) getView(i10)).setTextColor(i11);
        return this;
    }

    public BaseViewHolder setTypeface(int i10, Typeface typeface) {
        TextView textView = (TextView) getView(i10);
        textView.setTypeface(typeface);
        textView.setPaintFlags(textView.getPaintFlags() | 128);
        return this;
    }

    public BaseViewHolder setVisible(int i10, boolean z10) {
        int i11;
        View view = getView(i10);
        if (z10) {
            i11 = 0;
        } else {
            i11 = 4;
        }
        view.setVisibility(i11);
        return this;
    }

    public BaseViewHolder setAdapter(BaseQuickAdapter baseQuickAdapter) {
        this.adapter = baseQuickAdapter;
        return this;
    }

    public BaseViewHolder setProgress(int i10, int i11, int i12) {
        ProgressBar progressBar = (ProgressBar) getView(i10);
        progressBar.setMax(i12);
        progressBar.setProgress(i11);
        return this;
    }

    public BaseViewHolder setRating(int i10, float f10, int i11) {
        RatingBar ratingBar = (RatingBar) getView(i10);
        ratingBar.setMax(i11);
        ratingBar.setRating(f10);
        return this;
    }

    public BaseViewHolder setTag(int i10, int i11, Object obj) {
        getView(i10).setTag(i11, obj);
        return this;
    }

    public BaseViewHolder setText(int i10, int i11) {
        ((TextView) getView(i10)).setText(i11);
        return this;
    }

    public BaseViewHolder setTypeface(Typeface typeface, int... iArr) {
        for (int view : iArr) {
            TextView textView = (TextView) getView(view);
            textView.setTypeface(typeface);
            textView.setPaintFlags(textView.getPaintFlags() | 128);
        }
        return this;
    }
}
