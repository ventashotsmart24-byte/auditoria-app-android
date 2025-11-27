package f5;

import android.webkit.DownloadListener;
import com.mobile.brasiltv.activity.WebViewAty;

public final /* synthetic */ class g6 implements DownloadListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WebViewAty f16592a;

    public /* synthetic */ g6(WebViewAty webViewAty) {
        this.f16592a = webViewAty;
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
        WebViewAty.J3(this.f16592a, str, str2, str3, str4, j10);
    }
}
