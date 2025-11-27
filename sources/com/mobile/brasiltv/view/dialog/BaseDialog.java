package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.c;
import com.msandroid.mobile.R;

public abstract class BaseDialog extends c {
    public BaseDialog(Context context) {
        super(context, R.style.loadDialogTheme);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
