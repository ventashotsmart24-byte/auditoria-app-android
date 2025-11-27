package com.hpplay.glide.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public final class ManifestParser {
    private static final String GLIDE_MODULE_VALUE = "GlideModule";
    private static final String TAG = "ManifestParser";
    private final Context context;

    public ManifestParser(Context context2) {
        this.context = context2;
    }

    private static GlideModule parseModule(String str) {
        try {
            Object newInstance = Class.forName(str).newInstance();
            if (!(newInstance instanceof GlideModule)) {
                return null;
            }
            return (GlideModule) newInstance;
        } catch (Exception unused) {
            return null;
        }
    }

    public List<GlideModule> parse() {
        GlideModule parseModule;
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null) {
                for (String str : bundle.keySet()) {
                    if (GLIDE_MODULE_VALUE.equals(applicationInfo.metaData.get(str)) && (parseModule = parseModule(str)) != null) {
                        arrayList.add(parseModule);
                    }
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
