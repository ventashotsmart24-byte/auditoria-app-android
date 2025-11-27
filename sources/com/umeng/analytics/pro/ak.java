package com.umeng.analytics.pro;

import android.text.TextUtils;
import java.util.ArrayList;

public class ak {

    /* renamed from: a  reason: collision with root package name */
    private String f13723a = "";

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<al> f13724b = new ArrayList<>();

    public ak(String str) {
        this.f13723a = str;
        if (!TextUtils.isEmpty(str)) {
            a();
        }
    }

    private void a() {
        try {
            if (this.f13723a.contains(",")) {
                for (String str : this.f13723a.split(",")) {
                    if (!TextUtils.isEmpty(str)) {
                        String trim = str.trim();
                        if (this.f13724b != null) {
                            this.f13724b.add(new al(trim));
                        }
                    }
                }
                return;
            }
            String str2 = this.f13723a;
            if (!TextUtils.isEmpty(str2)) {
                String trim2 = str2.trim();
                if (this.f13724b != null) {
                    this.f13724b.add(new al(trim2));
                }
            }
        } catch (Throwable unused) {
        }
    }

    public boolean a(int i10) {
        try {
            ArrayList<al> arrayList = this.f13724b;
            if (arrayList == null) {
                return false;
            }
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                al alVar = this.f13724b.get(i11);
                if (alVar != null && alVar.a(i10)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
