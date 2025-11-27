package com.mobile.brasiltv.view.dialog;

import android.app.Dialog;

public interface ICommonAlertCallback {
    void onCancel(Dialog dialog);

    void onConfirm(Dialog dialog);
}
