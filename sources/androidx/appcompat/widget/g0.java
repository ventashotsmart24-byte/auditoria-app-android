package androidx.appcompat.widget;

import a0.h;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

public final class g0 {

    /* renamed from: a  reason: collision with root package name */
    public TextView f1238a;

    /* renamed from: b  reason: collision with root package name */
    public TextClassifier f1239b;

    public g0(TextView textView) {
        this.f1238a = (TextView) h.d(textView);
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f1239b;
        if (textClassifier != null) {
            return textClassifier;
        }
        TextClassificationManager a10 = d0.a(this.f1238a.getContext().getSystemService(c0.a()));
        if (a10 != null) {
            return a10.getTextClassifier();
        }
        return TextClassifier.NO_OP;
    }

    public void b(TextClassifier textClassifier) {
        this.f1239b = textClassifier;
    }
}
