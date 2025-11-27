package com.mobile.brasiltv.view.dialog.feedback;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ba.s;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.mobile.brasiltv.view.dialog.feedback.FeedBackDialog;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import d6.b;
import g5.c;
import g5.z;
import h9.t;
import java.util.ArrayList;
import mobile.com.requestframe.utils.response.QuestionBean;
import s9.l;
import t9.i;

public final class FeedbackHolder extends BaseFeedbackHodler implements TextWatcher {
    /* access modifiers changed from: private */
    public EditText etDes;
    /* access modifiers changed from: private */
    public EditText etFeedbackEmail;
    private View footerView;
    private View headView;
    /* access modifiers changed from: private */
    public boolean isRequest;
    /* access modifiers changed from: private */
    public z mAdapter;
    private c mEmailSuffixListAdapter;
    /* access modifiers changed from: private */
    public boolean mIsShow;
    private ImageView mIvFeedBackClear;
    /* access modifiers changed from: private */
    public AutoLinearLayout mLlDes;
    /* access modifiers changed from: private */
    public AutoLinearLayout mLlFeedBackEmail;
    /* access modifiers changed from: private */
    public RecyclerView mRvFeedBackList;
    private TextView mTvFeedbackSbumit = ((TextView) this.footerView.findViewById(R.id.mTvFeedbackSbumit));
    private String name;
    /* access modifiers changed from: private */
    public TextView tvError;
    private TextView tvName;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedbackHolder(String str, RecyclerView recyclerView, IFeedbackView iFeedbackView) {
        super(recyclerView, iFeedbackView);
        i.g(str, "name");
        i.g(recyclerView, "recyclerView");
        i.g(iFeedbackView, "dialog");
        this.name = str;
        View inflate = LayoutInflater.from(getHost().getContext()).inflate(R.layout.item_feedback_item_head, (ViewGroup) null);
        i.f(inflate, "from(host.getContext()).…_feedback_item_head,null)");
        this.headView = inflate;
        View inflate2 = LayoutInflater.from(getHost().getContext()).inflate(R.layout.item_feedback_item_footer, (ViewGroup) null);
        i.f(inflate2, "from(host.getContext()).…eedback_item_footer,null)");
        this.footerView = inflate2;
        z zVar = new z();
        this.mAdapter = zVar;
        zVar.addHeaderView(this.headView);
        this.mAdapter.addFooterView(this.footerView);
        recyclerView.setLayoutManager(new LinearLayoutManagerWrapper(getHost().getContext()));
        recyclerView.setAdapter(this.mAdapter);
        View findViewById = this.headView.findViewById(R.id.tvName);
        i.f(findViewById, "headView.findViewById(R.id.tvName)");
        TextView textView = (TextView) findViewById;
        this.tvName = textView;
        textView.setText(this.name);
        View findViewById2 = this.footerView.findViewById(R.id.tvError);
        i.f(findViewById2, "footerView.findViewById(R.id.tvError)");
        this.tvError = (TextView) findViewById2;
        View findViewById3 = this.footerView.findViewById(R.id.etFeedbackDes);
        i.f(findViewById3, "footerView.findViewById(R.id.etFeedbackDes)");
        this.etDes = (EditText) findViewById3;
        View findViewById4 = this.footerView.findViewById(R.id.etFeedbackEmail);
        i.f(findViewById4, "footerView.findViewById(R.id.etFeedbackEmail)");
        this.etFeedbackEmail = (EditText) findViewById4;
        View findViewById5 = this.footerView.findViewById(R.id.mIvFeedBackClear);
        i.f(findViewById5, "footerView.findViewById(R.id.mIvFeedBackClear)");
        this.mIvFeedBackClear = (ImageView) findViewById5;
        View findViewById6 = this.footerView.findViewById(R.id.llDes);
        i.f(findViewById6, "footerView.findViewById(R.id.llDes)");
        this.mLlDes = (AutoLinearLayout) findViewById6;
        this.mAdapter.e(new l(this) {
            final /* synthetic */ FeedbackHolder this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return t.f17319a;
            }

            public final void invoke(boolean z10) {
                this.this$0.tvError.setVisibility(4);
                int i10 = 0;
                this.this$0.mLlDes.setVisibility(z10 ? 0 : 8);
                EditText access$getEtDes$p = this.this$0.etDes;
                if (!z10) {
                    i10 = 8;
                }
                access$getEtDes$p.setVisibility(i10);
                this.this$0.checkSubmitBnt();
            }
        });
        this.mEmailSuffixListAdapter = new c(getHost().getContext());
        View findViewById7 = this.footerView.findViewById(R.id.mLlFeedBackEmail);
        i.f(findViewById7, "footerView.findViewById(R.id.mLlFeedBackEmail)");
        this.mLlFeedBackEmail = (AutoLinearLayout) findViewById7;
        View findViewById8 = this.footerView.findViewById(R.id.mRvFeedBackList);
        i.f(findViewById8, "footerView.findViewById(R.id.mRvFeedBackList)");
        RecyclerView recyclerView2 = (RecyclerView) findViewById8;
        this.mRvFeedBackList = recyclerView2;
        recyclerView2.setLayoutManager(new LinearLayoutManagerWrapper(getHost().getContext()));
        this.mRvFeedBackList.setAdapter(this.mEmailSuffixListAdapter);
        this.etDes.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ FeedbackHolder this$0;

            {
                this.this$0 = r1;
            }

            public void afterTextChanged(Editable editable) {
                this.this$0.checkSubmitBnt();
            }

            public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            }

            public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            }
        });
        this.etFeedbackEmail.addTextChangedListener(this);
        this.etFeedbackEmail.setOnEditorActionListener(new d(this));
        b bVar = b.f6366a;
        if (bVar.b()) {
            this.etFeedbackEmail.setText(w6.i.f9510g.m());
        } else {
            String i10 = bVar.i(getHost().getContext());
            if (i10 != null) {
                this.etFeedbackEmail.setText(i10);
            }
        }
        TextView textView2 = this.mTvFeedbackSbumit;
        if (textView2 != null) {
            textView2.setOnClickListener(new e(this));
        }
        this.mEmailSuffixListAdapter.f(new c.a(this) {
            final /* synthetic */ FeedbackHolder this$0;

            {
                this.this$0 = r1;
            }

            public void onClick(String str) {
                i.g(str, "mEmailString");
                this.this$0.etFeedbackEmail.setText(str);
                this.this$0.etFeedbackEmail.setSelection(str.length());
                this.this$0.mRvFeedBackList.setVisibility(8);
                this.this$0.mLlFeedBackEmail.setVisibility(8);
            }
        });
        this.etFeedbackEmail.setOnFocusChangeListener(new f(this));
        this.mIvFeedBackClear.setOnClickListener(new g(this));
    }

    /* access modifiers changed from: private */
    public static final boolean _init_$lambda$0(FeedbackHolder feedbackHolder, TextView textView, int i10, KeyEvent keyEvent) {
        i.g(feedbackHolder, "this$0");
        if (i10 != 6) {
            return false;
        }
        feedbackHolder.getHost().editActionDone();
        return false;
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$2(FeedbackHolder feedbackHolder, View view) {
        i.g(feedbackHolder, "this$0");
        feedbackHolder.submit();
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$3(FeedbackHolder feedbackHolder, View view, boolean z10) {
        i.g(feedbackHolder, "this$0");
        if (!z10) {
            feedbackHolder.mRvFeedBackList.setVisibility(8);
            feedbackHolder.mLlFeedBackEmail.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$4(FeedbackHolder feedbackHolder, View view) {
        i.g(feedbackHolder, "this$0");
        feedbackHolder.etFeedbackEmail.setText("");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0042, code lost:
        if (r0 != false) goto L_0x0046;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void checkSubmitBnt() {
        /*
            r3 = this;
            android.widget.EditText r0 = r3.etFeedbackEmail
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            java.lang.CharSequence r0 = ba.t.W(r0)
            java.lang.String r0 = r0.toString()
            int r0 = r0.length()
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto L_0x001c
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            if (r0 == 0) goto L_0x0045
            android.widget.EditText r0 = r3.etDes
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0046
            android.widget.EditText r0 = r3.etDes
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            java.lang.CharSequence r0 = ba.t.W(r0)
            java.lang.String r0 = r0.toString()
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0041
            r0 = 1
            goto L_0x0042
        L_0x0041:
            r0 = 0
        L_0x0042:
            if (r0 == 0) goto L_0x0045
            goto L_0x0046
        L_0x0045:
            r1 = 0
        L_0x0046:
            android.widget.TextView r0 = r3.mTvFeedbackSbumit
            if (r0 != 0) goto L_0x004b
            goto L_0x004e
        L_0x004b:
            r0.setEnabled(r1)
        L_0x004e:
            boolean r0 = r3.mIsShow
            if (r0 == 0) goto L_0x0059
            com.mobile.brasiltv.view.dialog.feedback.IFeedbackView r0 = r3.getHost()
            r0.submitBntEnable(r1)
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.view.dialog.feedback.FeedbackHolder.checkSubmitBnt():void");
    }

    private final void performFiltering(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("performFiltering : ");
        sb.append(str);
        if (!TextUtils.isEmpty(str) && ba.t.o(str, "@", false, 2, (Object) null)) {
            String str2 = str;
            if (ba.t.y(str2, "@", 0, false, 6, (Object) null) == ba.t.D(str2, "@", 0, false, 6, (Object) null)) {
                FeedBackDialog.Companion companion = FeedBackDialog.Companion;
                if (companion.getMEmailSuffixList().size() == 0) {
                    companion.getMEmailSuffixList().add("@gmail.com");
                }
                if (s.e(str, "@", false, 2, (Object) null)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("prefix.endsWith : ");
                    sb2.append(str);
                    sb2.append(" ;");
                    sb2.append(companion.getMEmailSuffixList());
                    sb2.append(";mRvFeedBackList:");
                    sb2.append(this.mRvFeedBackList.getVisibility());
                    c cVar = this.mEmailSuffixListAdapter;
                    String substring = str.substring(0, str.length() - 1);
                    i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    cVar.g(substring);
                    this.mEmailSuffixListAdapter.e(companion.getMEmailSuffixList());
                    this.mRvFeedBackList.setVisibility(0);
                    this.mLlFeedBackEmail.setVisibility(0);
                    return;
                }
                String lowerCase = str.toLowerCase();
                i.f(lowerCase, "this as java.lang.String).toLowerCase()");
                String[] strArr = (String[]) ba.t.M(lowerCase, new String[]{"@"}, false, 0, 6, (Object) null).toArray(new String[0]);
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
                    this.mRvFeedBackList.setVisibility(8);
                    this.mLlFeedBackEmail.setVisibility(8);
                    return;
                }
                this.mEmailSuffixListAdapter.g(strArr[0]);
                this.mEmailSuffixListAdapter.e(arrayList);
                this.mRvFeedBackList.setBackgroundDrawable(getContentView().getContext().getResources().getDrawable(R.drawable.bg_associate_email));
                this.mRvFeedBackList.setVisibility(0);
                this.mLlFeedBackEmail.setVisibility(0);
                return;
            }
        }
        this.mRvFeedBackList.setVisibility(8);
        this.mLlFeedBackEmail.setVisibility(8);
    }

    private final void showHint(int i10) {
        String str;
        this.tvError.setVisibility(0);
        TextView textView = this.tvError;
        Context context = getHost().getContext();
        if (context == null || (str = context.getString(i10)) == null) {
            str = "";
        }
        textView.setText(str);
    }

    private final void submit() {
        String str;
        if (this.etDes.getVisibility() == 0) {
            str = ba.t.W(this.etDes.getText().toString()).toString();
            if (str.length() > 2000) {
                showHint(R.string.text_too_long);
                return;
            }
        } else {
            str = "";
        }
        String obj = ba.t.W(this.etFeedbackEmail.getText().toString()).toString();
        if (b0.J(obj)) {
            showHint(R.string.email_empty);
        } else if (!j1.i(obj)) {
            showHint(R.string.email_incorrect);
        } else {
            QuestionBean d10 = this.mAdapter.d();
            if (d10 != null) {
                submitFeedback(obj, d10, str);
            }
            getHost().submitSuc();
        }
    }

    private final void submitFeedback(String str, QuestionBean questionBean, String str2) {
        String str3;
        b.f6366a.z(getHost().getContext(), str);
        w6.i b10 = w6.i.f9510g.b();
        String type = getHost().getType();
        String str4 = this.name;
        Integer typeId = questionBean.getTypeId();
        if (typeId != null) {
            str3 = typeId.toString();
        } else {
            str3 = null;
        }
        b10.r2(type, str4, str, str3, String.valueOf(questionBean.getQuestionId()), str2).subscribe(new FeedbackHolder$submitFeedback$1());
    }

    public void afterTextChanged(Editable editable) {
        String obj = ba.t.W(this.etFeedbackEmail.getText().toString()).toString();
        if (TextUtils.isEmpty(obj)) {
            this.mIvFeedBackClear.setVisibility(8);
        } else {
            this.mIvFeedBackClear.setVisibility(0);
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
        this.mIsShow = false;
    }

    public final String getName() {
        return this.name;
    }

    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
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
        if (this.mAdapter.getData().size() > 0) {
            super.show(z10);
        } else if (z10) {
            getHost().showLoading(true);
            if (!this.isRequest) {
                this.isRequest = true;
                w6.i.f9510g.b().T1(getHost().getType()).subscribe(new FeedbackHolder$show$1(this));
            }
        } else {
            super.show(z10);
        }
    }
}
