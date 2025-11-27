package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import ba.t;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.i1;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import java.util.Arrays;
import s9.l;
import t9.g;
import t9.i;
import t9.z;

public final class PriorityVipDialog extends CommonDialog {
    private int authDays;
    private l onReceiveCallback;
    private Type type;

    public enum Type {
        QUALIFICATIONS,
        RECEIVE
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PriorityVipDialog(Context context, Type type2, int i10, l lVar) {
        super(context, 0, 2, (g) null);
        i.g(context, f.X);
        i.g(type2, "type");
        this.type = type2;
        this.authDays = i10;
        this.onReceiveCallback = lVar;
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$0(PriorityVipDialog priorityVipDialog, View view) {
        i.g(priorityVipDialog, "this$0");
        if (priorityVipDialog.type == Type.QUALIFICATIONS) {
            i1.w(priorityVipDialog.getContext(), "Use");
            l lVar = priorityVipDialog.onReceiveCallback;
            if (lVar != null) {
                lVar.invoke(priorityVipDialog);
                return;
            }
            return;
        }
        priorityVipDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$1(PriorityVipDialog priorityVipDialog, View view) {
        i.g(priorityVipDialog, "this$0");
        i1.w(priorityVipDialog.getContext(), "Next time");
        priorityVipDialog.dismiss();
    }

    public final int getAuthDays() {
        return this.authDays;
    }

    public int getDialogHeight() {
        return -2;
    }

    public int getDialogWidth() {
        return 600;
    }

    public int getLayoutId() {
        return R.layout.dialog_priority_vip;
    }

    public final l getOnReceiveCallback() {
        return this.onReceiveCallback;
    }

    public final Type getType() {
        return this.type;
    }

    public void initListener() {
        ((Button) findViewById(R$id.mBtnConfirm)).setOnClickListener(new u0(this));
        ((Button) findViewById(R$id.mBtnCancel)).setOnClickListener(new v0(this));
    }

    public void initView() {
        if (this.type == Type.QUALIFICATIONS) {
            z zVar = z.f19601a;
            String string = getContext().getString(R.string.advance_enjoy_vip_basic_content);
            i.f(string, "context.getString(R.stri…_enjoy_vip_basic_content)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.authDays)}, 1));
            i.f(format, "format(format, *args)");
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(new UnderlineSpan(), t.y(spannableString, ".", 0, false, 6, (Object) null) + 2, spannableString.length(), 17);
            ((TextView) findViewById(R$id.mTvContentFirst)).setText(spannableString);
            ((Button) findViewById(R$id.mBtnConfirm)).setText(getContext().getString(R.string.advance_enjoy_vip_use));
            ((Button) findViewById(R$id.mBtnCancel)).setVisibility(0);
        } else {
            z zVar2 = z.f19601a;
            String string2 = getContext().getString(R.string.advance_enjoy_vip_obtained_content);
            i.f(string2, "context.getString(R.stri…joy_vip_obtained_content)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(this.authDays)}, 1));
            i.f(format2, "format(format, *args)");
            SpannableString spannableString2 = new SpannableString(format2);
            spannableString2.setSpan(new UnderlineSpan(), t.y(spannableString2, ".", 0, false, 6, (Object) null) + 2, spannableString2.length(), 17);
            ((TextView) findViewById(R$id.mTvContentFirst)).setText(spannableString2);
            ((Button) findViewById(R$id.mBtnConfirm)).setText(getContext().getString(R.string.common_ok));
            ((Button) findViewById(R$id.mBtnCancel)).setVisibility(8);
        }
        int i10 = R$id.mTvContentSecond;
        ((TextView) findViewById(i10)).setText(getContext().getString(R.string.advance_enjoy_vip_standard_content));
        SpannableString spannableString3 = new SpannableString(getContext().getString(R.string.advance_enjoy_vip_help));
        spannableString3.setSpan(new PriorityVipDialog$initView$1(this), 0, spannableString3.length(), 33);
        ((TextView) findViewById(i10)).append(spannableString3);
        ((TextView) findViewById(i10)).setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void setAuthDays(int i10) {
        this.authDays = i10;
    }

    public final void setOnReceiveCallback(l lVar) {
        this.onReceiveCallback = lVar;
    }

    public final void setType(Type type2) {
        i.g(type2, "<set-?>");
        this.type = type2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PriorityVipDialog(Context context, Type type2, int i10, l lVar, int i11, g gVar) {
        this(context, type2, i10, (i11 & 8) != 0 ? null : lVar);
    }
}
