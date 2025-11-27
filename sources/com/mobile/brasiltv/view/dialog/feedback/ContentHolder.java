package com.mobile.brasiltv.view.dialog.feedback;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ba.s;
import ba.t;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.mobile.brasiltv.view.dialog.feedback.FeedBackDialog;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import d6.b;
import g5.c;
import h9.g;
import h9.h;
import java.util.ArrayList;
import t9.i;

public final class ContentHolder extends BaseFeedbackHodler implements View.OnClickListener, TextWatcher {
    private final g etContentTitle$delegate = h.b(new ContentHolder$etContentTitle$2(this));
    private final g etDes$delegate = h.b(new ContentHolder$etDes$2(this));
    private final g etEmail$delegate = h.b(new ContentHolder$etEmail$2(this));
    private final g ivTitleEdit$delegate = h.b(new ContentHolder$ivTitleEdit$2(this));
    private final g mEmailAdapter$delegate;
    private boolean mIsShow;
    private final g mIvContentClear$delegate = h.b(new ContentHolder$mIvContentClear$2(this));
    private final g mLlRecyclerEmail$delegate = h.b(new ContentHolder$mLlRecyclerEmail$2(this));
    private final g mRvCompleteList$delegate = h.b(new ContentHolder$mRvCompleteList$2(this));
    private final g mTvSubmit$delegate = h.b(new ContentHolder$mTvSubmit$2(this));
    private String name;
    private final g tvContentTitle$delegate = h.b(new ContentHolder$tvContentTitle$2(this));
    private final g tvError$delegate = h.b(new ContentHolder$tvError$2(this));

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContentHolder(String str, View view, IFeedbackView iFeedbackView) {
        super(view, iFeedbackView);
        i.g(str, "name");
        i.g(view, "content");
        i.g(iFeedbackView, "dialog");
        this.name = str;
        this.mEmailAdapter$delegate = h.b(new ContentHolder$mEmailAdapter$2(view));
        getMRvCompleteList().setLayoutManager(new LinearLayoutManagerWrapper(view.getContext()));
        getMRvCompleteList().setAdapter(getMEmailAdapter());
        getIvTitleEdit().setOnClickListener(this);
        TextView mTvSubmit = getMTvSubmit();
        if (mTvSubmit != null) {
            mTvSubmit.setOnClickListener(this);
        }
        getEtContentTitle().addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ ContentHolder this$0;

            {
                this.this$0 = r1;
            }

            public void afterTextChanged(Editable editable) {
                this.this$0.getTvError().setVisibility(4);
                this.this$0.checkSubmitBnt();
            }

            public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            }

            public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            }
        });
        getEtDes().addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ ContentHolder this$0;

            {
                this.this$0 = r1;
            }

            public void afterTextChanged(Editable editable) {
                this.this$0.getTvError().setVisibility(4);
                this.this$0.checkSubmitBnt();
            }

            public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            }

            public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            }
        });
        getEtEmail().addTextChangedListener(this);
        getEtEmail().setOnEditorActionListener(new a(this));
        getTvContentTitle().setText(this.name);
        b bVar = b.f6366a;
        if (bVar.b()) {
            getEtEmail().setText(w6.i.f9510g.m());
        } else {
            String i10 = bVar.i(getHost().getContext());
            if (i10 != null) {
                getEtEmail().setText(i10);
            }
        }
        getMEmailAdapter().f(new c.a(this) {
            final /* synthetic */ ContentHolder this$0;

            {
                this.this$0 = r1;
            }

            public void onClick(String str) {
                i.g(str, "mEmailString");
                this.this$0.getEtEmail().setText(str);
                this.this$0.getEtEmail().setSelection(str.length());
                this.this$0.getMRvCompleteList().setVisibility(8);
                this.this$0.getMLlRecyclerEmail().setVisibility(8);
            }
        });
        getEtEmail().setOnFocusChangeListener(new b(this));
        getMIvContentClear().setOnClickListener(new c(this));
    }

    /* access modifiers changed from: private */
    public static final boolean _init_$lambda$0(ContentHolder contentHolder, TextView textView, int i10, KeyEvent keyEvent) {
        i.g(contentHolder, "this$0");
        if (i10 != 6) {
            return false;
        }
        contentHolder.getHost().editActionDone();
        return false;
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$2(ContentHolder contentHolder, View view, boolean z10) {
        i.g(contentHolder, "this$0");
        if (!z10) {
            contentHolder.getMRvCompleteList().setVisibility(8);
            contentHolder.getMLlRecyclerEmail().setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$3(ContentHolder contentHolder, View view) {
        i.g(contentHolder, "this$0");
        contentHolder.getEtEmail().setText("");
    }

    /* access modifiers changed from: private */
    public final void checkSubmitBnt() {
        boolean z10;
        if (!b0.K(getEtDes().getText()) || !b0.K(getEtEmail().getText()) || (getEtContentTitle().getVisibility() == 0 && !b0.K(getEtContentTitle().getText()))) {
            z10 = false;
        } else {
            z10 = true;
        }
        TextView mTvSubmit = getMTvSubmit();
        if (mTvSubmit != null) {
            mTvSubmit.setEnabled(z10);
        }
        if (this.mIsShow) {
            getHost().submitBntEnable(z10);
        }
    }

    private final EditText getEtContentTitle() {
        return (EditText) this.etContentTitle$delegate.getValue();
    }

    private final EditText getEtDes() {
        return (EditText) this.etDes$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final EditText getEtEmail() {
        return (EditText) this.etEmail$delegate.getValue();
    }

    private final ImageView getIvTitleEdit() {
        return (ImageView) this.ivTitleEdit$delegate.getValue();
    }

    private final c getMEmailAdapter() {
        return (c) this.mEmailAdapter$delegate.getValue();
    }

    private final ImageView getMIvContentClear() {
        return (ImageView) this.mIvContentClear$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final AutoLinearLayout getMLlRecyclerEmail() {
        return (AutoLinearLayout) this.mLlRecyclerEmail$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final RecyclerView getMRvCompleteList() {
        return (RecyclerView) this.mRvCompleteList$delegate.getValue();
    }

    private final TextView getMTvSubmit() {
        return (TextView) this.mTvSubmit$delegate.getValue();
    }

    private final TextView getTvContentTitle() {
        return (TextView) this.tvContentTitle$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final TextView getTvError() {
        return (TextView) this.tvError$delegate.getValue();
    }

    private final void performFiltering(String str) {
        if (!TextUtils.isEmpty(str) && t.o(str, "@", false, 2, (Object) null)) {
            String str2 = str;
            if (t.y(str2, "@", 0, false, 6, (Object) null) == t.D(str2, "@", 0, false, 6, (Object) null)) {
                FeedBackDialog.Companion companion = FeedBackDialog.Companion;
                if (companion.getMEmailSuffixList().size() == 0) {
                    companion.getMEmailSuffixList().add("@gmail.com");
                }
                if (s.e(str, "@", false, 2, (Object) null)) {
                    c mEmailAdapter = getMEmailAdapter();
                    String substring = str.substring(0, str.length() - 1);
                    i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    mEmailAdapter.g(substring);
                    getMEmailAdapter().e(companion.getMEmailSuffixList());
                    getMRvCompleteList().setVisibility(0);
                    getMLlRecyclerEmail().setVisibility(0);
                    return;
                }
                String lowerCase = str.toLowerCase();
                i.f(lowerCase, "this as java.lang.String).toLowerCase()");
                String[] strArr = (String[]) t.M(lowerCase, new String[]{"@"}, false, 0, 6, (Object) null).toArray(new String[0]);
                String str3 = '@' + strArr[1];
                int size = companion.getMEmailSuffixList().size();
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < size; i10++) {
                    String str4 = FeedBackDialog.Companion.getMEmailSuffixList().get(i10);
                    i.f(str4, "mEmailSuffixList[i]");
                    String str5 = str4;
                    String lowerCase2 = str5.toLowerCase();
                    i.f(lowerCase2, "this as java.lang.String).toLowerCase()");
                    if (s.l(lowerCase2, str3, false, 2, (Object) null)) {
                        arrayList.add(str5);
                    }
                }
                if (arrayList.isEmpty()) {
                    getMRvCompleteList().setVisibility(8);
                    getMLlRecyclerEmail().setVisibility(8);
                    return;
                }
                getMEmailAdapter().g(strArr[0]);
                getMEmailAdapter().e(arrayList);
                getMRvCompleteList().setBackgroundDrawable(getContentView().getContext().getResources().getDrawable(R.drawable.bg_associate_email));
                getMRvCompleteList().setVisibility(0);
                getMLlRecyclerEmail().setVisibility(0);
                return;
            }
        }
        getMRvCompleteList().setVisibility(8);
        getMLlRecyclerEmail().setVisibility(8);
    }

    private final void submit() {
        String str;
        boolean z10;
        String string;
        String string2;
        String string3;
        if (getEtContentTitle().getVisibility() == 0) {
            Editable text = getEtContentTitle().getText();
            i.f(text, "etContentTitle.text");
            str = t.W(text).toString();
        } else {
            CharSequence text2 = getTvContentTitle().getText();
            i.f(text2, "tvContentTitle.text");
            str = t.W(text2).toString();
        }
        boolean z11 = true;
        if (str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        String str2 = "";
        if (z10) {
            getTvError().setVisibility(0);
            TextView tvError = getTvError();
            Context context = getHost().getContext();
            if (!(context == null || (string3 = context.getString(R.string.content_title_empty)) == null)) {
                str2 = string3;
            }
            tvError.setText(str2);
            return;
        }
        String obj = t.W(getEtEmail().getText().toString()).toString();
        if (obj.length() != 0) {
            z11 = false;
        }
        if (z11) {
            getTvError().setVisibility(0);
            TextView tvError2 = getTvError();
            Context context2 = getHost().getContext();
            if (!(context2 == null || (string2 = context2.getString(R.string.email_empty)) == null)) {
                str2 = string2;
            }
            tvError2.setText(str2);
        } else if (!j1.i(obj)) {
            getTvError().setVisibility(0);
            TextView tvError3 = getTvError();
            Context context3 = getHost().getContext();
            if (!(context3 == null || (string = context3.getString(R.string.email_incorrect)) == null)) {
                str2 = string;
            }
            tvError3.setText(str2);
        } else {
            submitFeedback(obj, t.W(getEtDes().getText().toString()).toString());
            getHost().submitSuc();
        }
    }

    private final void submitFeedback(String str, String str2) {
        b.f6366a.z(getHost().getContext(), str);
        w6.i.f9510g.b().r2("4", this.name, str, (String) null, (String) null, str2).subscribe(new ContentHolder$submitFeedback$1());
    }

    public void afterTextChanged(Editable editable) {
        String obj = t.W(getEtEmail().getText().toString()).toString();
        if (TextUtils.isEmpty(obj)) {
            getMIvContentClear().setVisibility(8);
        } else {
            getMIvContentClear().setVisibility(0);
        }
        performFiltering(obj);
    }

    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    public void clickSubmit() {
        if (this.mIsShow) {
            submit();
        }
    }

    public void dialogCancel() {
    }

    public final String getName() {
        return this.name;
    }

    public void onClick(View view) {
        Object obj;
        i.g(view, "v");
        if (i.b(view, getIvTitleEdit())) {
            getTvContentTitle().setVisibility(8);
            getIvTitleEdit().setVisibility(8);
            getEtContentTitle().setVisibility(0);
            getEtContentTitle().setText(getTvContentTitle().getText().toString());
            getEtContentTitle().setSelection(getEtContentTitle().getText().toString().length());
            getEtContentTitle().requestFocus();
            Context context = getHost().getContext();
            if (context != null) {
                obj = context.getSystemService("input_method");
            } else {
                obj = null;
            }
            i.e(obj, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) obj).showSoftInput(getEtContentTitle(), 1);
        } else if (i.b(view, getMTvSubmit())) {
            submit();
        }
    }

    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        getTvError().setVisibility(4);
        checkSubmitBnt();
    }

    public final void setName(String str) {
        i.g(str, "<set-?>");
        this.name = str;
    }

    public void show(boolean z10) {
        this.mIsShow = z10;
        if (z10) {
            checkSubmitBnt();
        }
        super.show(z10);
    }
}
