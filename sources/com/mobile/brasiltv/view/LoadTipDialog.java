package com.mobile.brasiltv.view;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.msandroid.mobile.R;

public class LoadTipDialog extends Dialog {
    private Context context;
    private TextView mDialogCancel = ((TextView) findViewById(R.id.dialog_cancel));
    private TextView mDialogContent = ((TextView) findViewById(R.id.dialog_content));
    private TextView mDialogSubmit = ((TextView) findViewById(R.id.dialog_submit));
    private View mLine = findViewById(R.id.dialog_line);

    public LoadTipDialog(Context context2, int i10) {
        super(context2, R.style.OptionDialog);
        setContentView(R.layout.dialog_load_tip);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.dimAmount = 0.5f;
        getWindow().setAttributes(attributes);
        getWindow().addFlags(2);
        getWindow().getAttributes().gravity = 17;
        this.context = context2;
        this.mDialogContent.setText(i10);
        setCanceledOnTouchOutside(false);
    }

    public LoadTipDialog hideCancelBtn() {
        this.mDialogCancel.setVisibility(8);
        this.mLine.setVisibility(8);
        return this;
    }

    public LoadTipDialog setBtnText(int i10) {
        this.mDialogSubmit.setText(i10);
        return this;
    }

    public LoadTipDialog setListener(View.OnClickListener onClickListener) {
        this.mDialogCancel.setOnClickListener(onClickListener);
        this.mDialogSubmit.setOnClickListener(onClickListener);
        return this;
    }
}
