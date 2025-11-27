package k;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import java.util.ArrayList;
import o.o;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final Intent f7210a;

    /* renamed from: b  reason: collision with root package name */
    public final Bundle f7211b;

    /* renamed from: k.a$a  reason: collision with other inner class name */
    public static final class C0094a {

        /* renamed from: a  reason: collision with root package name */
        public final Intent f7212a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList f7213b;

        /* renamed from: c  reason: collision with root package name */
        public Bundle f7214c;

        /* renamed from: d  reason: collision with root package name */
        public ArrayList f7215d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f7216e;

        public C0094a() {
            this((b) null);
        }

        public a a() {
            ArrayList arrayList = this.f7213b;
            if (arrayList != null) {
                this.f7212a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList arrayList2 = this.f7215d;
            if (arrayList2 != null) {
                this.f7212a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.f7212a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f7216e);
            return new a(this.f7212a, this.f7214c);
        }

        public C0094a(b bVar) {
            Intent intent = new Intent("android.intent.action.VIEW");
            this.f7212a = intent;
            this.f7213b = null;
            this.f7214c = null;
            this.f7215d = null;
            this.f7216e = true;
            Bundle bundle = new Bundle();
            o.b(bundle, "android.support.customtabs.extra.SESSION", (IBinder) null);
            intent.putExtras(bundle);
        }
    }

    public a(Intent intent, Bundle bundle) {
        this.f7210a = intent;
        this.f7211b = bundle;
    }

    public void a(Context context, Uri uri) {
        this.f7210a.setData(uri);
        p.a.startActivity(context, this.f7210a, this.f7211b);
    }
}
