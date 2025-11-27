package e7;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.google.zxing.Result;
import com.mobile.brasiltv.activity.ScanLoginActivity;
import com.msandroid.mobile.R;
import d7.c;
import java.util.Vector;

public final class a extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final ScanLoginActivity f16503a;

    /* renamed from: b  reason: collision with root package name */
    public final d f16504b;

    /* renamed from: c  reason: collision with root package name */
    public C0219a f16505c = C0219a.f16507b;

    /* renamed from: e7.a$a  reason: collision with other inner class name */
    public enum C0219a {
        PREVIEW,
        f16507b,
        DONE
    }

    public a(ScanLoginActivity scanLoginActivity, Vector vector, String str) {
        this.f16503a = scanLoginActivity;
        d dVar = new d(scanLoginActivity, vector, str, new f7.a(scanLoginActivity.V2()));
        this.f16504b = dVar;
        dVar.start();
        c.c().j();
        b();
    }

    public void a() {
        this.f16505c = C0219a.DONE;
        c.c().k();
        Message.obtain(this.f16504b.a(), R.id.quit).sendToTarget();
        try {
            this.f16504b.join();
        } catch (InterruptedException unused) {
        }
        removeMessages(R.id.decode_succeeded);
        removeMessages(R.id.decode_failed);
        removeMessages(R.id.restart_preview);
    }

    public final void b() {
        if (this.f16505c == C0219a.f16507b) {
            this.f16505c = C0219a.PREVIEW;
            c.c().i(this.f16504b.a(), R.id.decode);
            c.c().h(this, R.id.auto_focus);
            this.f16503a.T2();
        }
    }

    public void handleMessage(Message message) {
        Bitmap bitmap;
        switch (message.what) {
            case R.id.auto_focus:
                if (this.f16505c == C0219a.PREVIEW) {
                    c.c().h(this, R.id.auto_focus);
                    return;
                }
                return;
            case R.id.decode_failed:
                this.f16505c = C0219a.PREVIEW;
                c.c().i(this.f16504b.a(), R.id.decode);
                return;
            case R.id.decode_succeeded:
                this.f16505c = C0219a.f16507b;
                Bundle data = message.getData();
                if (data == null) {
                    bitmap = null;
                } else {
                    bitmap = (Bitmap) data.getParcelable("barcode_bitmap");
                }
                this.f16503a.W2((Result) message.obj, bitmap);
                return;
            case R.id.launch_product_query:
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String) message.obj));
                intent.addFlags(524288);
                if (this.f16503a.getPackageManager().resolveActivity(intent, 0) != null) {
                    this.f16503a.startActivity(intent);
                    return;
                }
                return;
            case R.id.restart_preview:
                b();
                return;
            case R.id.return_scan_result:
                this.f16503a.setResult(-1, (Intent) message.obj);
                this.f16503a.finish();
                return;
            default:
                return;
        }
    }
}
