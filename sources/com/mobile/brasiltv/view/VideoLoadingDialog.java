package com.mobile.brasiltv.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;
import com.msandroid.mobile.R;

public class VideoLoadingDialog extends ProgressDialog {
    private TextView titleView;

    public VideoLoadingDialog(Context context) {
        super(context, R.style.VideoLoadingDialog);
    }

    private void init(Context context) {
        setContentView(R.layout.loading_progress_dialog);
        this.titleView = (TextView) findViewById(R.id.tv_load_dialog);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        getWindow().setAttributes(attributes);
    }

    private void setViewTip(int i10) {
        this.titleView.setText(i10);
    }

    public void canCancel(boolean z10) {
        setCancelable(z10);
        setCanceledOnTouchOutside(z10);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        init(getContext());
    }

    public void show(int i10) {
        super.show();
        setViewTip(i10);
    }
}
