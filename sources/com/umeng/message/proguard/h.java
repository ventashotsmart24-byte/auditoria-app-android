package com.umeng.message.proguard;

import android.content.Context;
import android.net.Uri;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static String f15957a;

    public static Uri a(Context context) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("content");
        builder.authority(f(context));
        builder.path("MsgAlias");
        return builder.build();
    }

    public static Uri b(Context context) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("content");
        builder.authority(f(context));
        builder.path("MsgAliasDeleteAll");
        return builder.build();
    }

    public static Uri c(Context context) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("content");
        builder.authority(f(context));
        builder.path("sp");
        return builder.build();
    }

    public static Uri d(Context context) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("content");
        builder.authority(f(context));
        builder.path("MsgLogStores");
        return builder.build();
    }

    public static Uri e(Context context) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("content");
        builder.authority(f(context));
        builder.path("InAppLogStores");
        return builder.build();
    }

    public static String f(Context context) {
        if (f15957a == null) {
            f15957a = context.getPackageName() + ".umeng.message";
        }
        return f15957a;
    }
}
