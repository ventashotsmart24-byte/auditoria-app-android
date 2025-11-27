package o;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.app.m;
import androidx.lifecycle.d;
import androidx.lifecycle.g;
import androidx.lifecycle.h;
import androidx.lifecycle.o;
import b0.k;

public abstract class p extends Activity implements g, k.a {
    private androidx.collection.g mExtraDataMap = new androidx.collection.g();
    private h mLifecycleRegistry = new h(this);

    public static class a {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !k.d(decorView, keyEvent)) {
            return k.e(this, decorView, this, keyEvent);
        }
        return true;
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !k.d(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Deprecated
    public <T extends a> T getExtraData(Class<T> cls) {
        m.a(this.mExtraDataMap.get(cls));
        return null;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        o.f(this);
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.mLifecycleRegistry.j(d.c.CREATED);
        super.onSaveInstanceState(bundle);
    }

    @Deprecated
    public void putExtraData(a aVar) {
        throw null;
    }

    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
