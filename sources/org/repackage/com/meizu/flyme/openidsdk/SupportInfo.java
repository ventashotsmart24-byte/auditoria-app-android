package org.repackage.com.meizu.flyme.openidsdk;

import android.text.TextUtils;

class SupportInfo {

    /* renamed from: a  reason: collision with root package name */
    String f8644a;

    /* renamed from: b  reason: collision with root package name */
    Boolean f8645b;

    public void a(boolean z10) {
        this.f8645b = Boolean.valueOf(z10);
    }

    public void b(String str) {
        this.f8644a = str;
    }

    public boolean a() {
        return this.f8645b != null;
    }

    public boolean b() {
        Boolean bool = this.f8645b;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.f8644a, str);
    }
}
