package o;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class l1 implements Iterable {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f8359a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final Context f8360b;

    public interface a {
        Intent getSupportParentActivityIntent();
    }

    public l1(Context context) {
        this.f8360b = context;
    }

    public static l1 d(Context context) {
        return new l1(context);
    }

    public l1 a(Intent intent) {
        this.f8359a.add(intent);
        return this;
    }

    public l1 b(Activity activity) {
        Intent intent;
        if (activity instanceof a) {
            intent = ((a) activity).getSupportParentActivityIntent();
        } else {
            intent = null;
        }
        if (intent == null) {
            intent = q.a(activity);
        }
        if (intent != null) {
            ComponentName component = intent.getComponent();
            if (component == null) {
                component = intent.resolveActivity(this.f8360b.getPackageManager());
            }
            c(component);
            a(intent);
        }
        return this;
    }

    public l1 c(ComponentName componentName) {
        int size = this.f8359a.size();
        try {
            Intent b10 = q.b(this.f8360b, componentName);
            while (b10 != null) {
                this.f8359a.add(size, b10);
                b10 = q.b(this.f8360b, b10.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e10) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e10);
        }
    }

    public PendingIntent e(int i10, int i11) {
        return f(i10, i11, (Bundle) null);
    }

    public PendingIntent f(int i10, int i11, Bundle bundle) {
        if (!this.f8359a.isEmpty()) {
            ArrayList arrayList = this.f8359a;
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            return PendingIntent.getActivities(this.f8360b, i10, intentArr, i11, bundle);
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
    }

    public void g() {
        h((Bundle) null);
    }

    public void h(Bundle bundle) {
        if (!this.f8359a.isEmpty()) {
            ArrayList arrayList = this.f8359a;
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            if (!p.a.startActivities(this.f8360b, intentArr, bundle)) {
                Intent intent = new Intent(intentArr[intentArr.length - 1]);
                intent.addFlags(268435456);
                this.f8360b.startActivity(intent);
                return;
            }
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }

    public Iterator iterator() {
        return this.f8359a.iterator();
    }
}
