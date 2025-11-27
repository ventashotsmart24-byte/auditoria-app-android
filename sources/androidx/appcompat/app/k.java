package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.d;

public class k extends d {
    public Dialog onCreateDialog(Bundle bundle) {
        return new j(getContext(), getTheme());
    }

    public void setupDialog(Dialog dialog, int i10) {
        if (dialog instanceof j) {
            j jVar = (j) dialog;
            if (!(i10 == 1 || i10 == 2)) {
                if (i10 == 3) {
                    dialog.getWindow().addFlags(24);
                } else {
                    return;
                }
            }
            jVar.supportRequestWindowFeature(1);
            return;
        }
        super.setupDialog(dialog, i10);
    }
}
