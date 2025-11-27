package com.mobile.brasiltv.view.dialog.feedback;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import ba.t;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.j1;
import com.msandroid.mobile.R;
import d6.b;
import h9.g;
import h9.h;
import t9.i;

public final class CastFeedBackHolder extends BaseFeedbackHodler implements View.OnClickListener, TextWatcher {
    private final g etDes$delegate = h.b(new CastFeedBackHolder$etDes$2(this));
    private final g etEmail$delegate = h.b(new CastFeedBackHolder$etEmail$2(this));
    private final g mTvSubmit$delegate = h.b(new CastFeedBackHolder$mTvSubmit$2(this));
    private final g tvError$delegate = h.b(new CastFeedBackHolder$tvError$2(this));

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CastFeedBackHolder(View view, IFeedbackView iFeedbackView) {
        super(view, iFeedbackView);
        i.g(view, "content");
        i.g(iFeedbackView, "dialog");
        getMTvSubmit().setOnClickListener(this);
        getEtDes().addTextChangedListener(this);
        getEtEmail().addTextChangedListener(this);
        b bVar = b.f6366a;
        if (bVar.b()) {
            getEtEmail().setText(w6.i.f9510g.m());
            return;
        }
        String i10 = bVar.i(getHost().getContext());
        if (i10 != null) {
            getEtEmail().setText(i10);
        }
    }

    private final EditText getEtDes() {
        return (EditText) this.etDes$delegate.getValue();
    }

    private final EditText getEtEmail() {
        return (EditText) this.etEmail$delegate.getValue();
    }

    private final TextView getMTvSubmit() {
        return (TextView) this.mTvSubmit$delegate.getValue();
    }

    private final TextView getTvError() {
        return (TextView) this.tvError$delegate.getValue();
    }

    private final void submitFeedback(String str, String str2) {
        b.f6366a.z(getHost().getContext(), str);
        w6.i.f9510g.b().r2(getHost().getType(), "", str, (String) null, (String) null, str2).subscribe(new CastFeedBackHolder$submitFeedback$1());
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    public void clickSubmit() {
    }

    public void dialogCancel() {
    }

    public void onClick(View view) {
        boolean z10;
        String string;
        String string2;
        i.g(view, "v");
        if (i.b(view, getMTvSubmit())) {
            String obj = t.W(getEtEmail().getText().toString()).toString();
            if (obj.length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            String str = "";
            if (z10) {
                getTvError().setVisibility(0);
                TextView tvError = getTvError();
                Context context = getHost().getContext();
                if (!(context == null || (string2 = context.getString(R.string.email_empty)) == null)) {
                    str = string2;
                }
                tvError.setText(str);
            } else if (!j1.i(obj)) {
                getTvError().setVisibility(0);
                TextView tvError2 = getTvError();
                Context context2 = getHost().getContext();
                if (!(context2 == null || (string = context2.getString(R.string.email_incorrect)) == null)) {
                    str = string;
                }
                tvError2.setText(str);
            } else {
                submitFeedback(obj, t.W(getEtDes().getText().toString()).toString());
                getHost().submitSuc();
            }
        }
    }

    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        boolean z10;
        getTvError().setVisibility(4);
        TextView mTvSubmit = getMTvSubmit();
        if (!b0.K(getEtDes().getText()) || !b0.K(getEtEmail().getText())) {
            z10 = false;
        } else {
            z10 = true;
        }
        mTvSubmit.setEnabled(z10);
    }

    public void show(boolean z10) {
        super.show(z10);
    }
}
