package com.mobile.brasiltv.view.input;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.msandroid.mobile.R;
import java.util.ArrayList;
import t9.i;

public final class EmailPrefixInputView$createEmailSuffixAdapter$1 extends ArrayAdapter<String> {
    private LayoutInflater inflater = LayoutInflater.from(getContext());
    final /* synthetic */ EmailPrefixInputView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EmailPrefixInputView$createEmailSuffixAdapter$1(EmailPrefixInputView emailPrefixInputView, Context context, ArrayList<String> arrayList) {
        super(context, R.layout.item_popup_email_suffix, arrayList);
        this.this$0 = emailPrefixInputView;
    }

    public View getView(int i10, View view, ViewGroup viewGroup) {
        i.g(viewGroup, "parent");
        if (view == null) {
            LayoutInflater layoutInflater = this.inflater;
            if (layoutInflater != null) {
                view = layoutInflater.inflate(R.layout.item_popup_email_suffix, viewGroup, false);
            } else {
                view = null;
            }
        }
        String str = (String) getItem(i10);
        if (str == null) {
            str = "";
        }
        i.d(view);
        View findViewById = view.findViewById(R.id.tv_email_suffix);
        i.f(findViewById, "view!!.findViewById(R.id.tv_email_suffix)");
        TextView textView = (TextView) findViewById;
        textView.setText(str);
        View findViewById2 = view.findViewById(R.id.iv_selector);
        i.f(findViewById2, "view.findViewById(R.id.iv_selector)");
        ImageView imageView = (ImageView) findViewById2;
        if (i10 == this.this$0.mEmailSuffixSelectedIndex) {
            textView.setTextColor(getContext().getResources().getColor(R.color.color_important));
            imageView.setImageResource(R.drawable.ic_green_gou);
        } else {
            textView.setTextColor(getContext().getResources().getColor(R.color.color_ffffff));
            imageView.setImageResource(0);
        }
        return view;
    }
}
