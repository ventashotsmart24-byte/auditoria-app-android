package com.umeng.message.inapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.entity.UInAppMessage;

public class UmengInAppClickHandler implements UInAppHandler {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15278a = "com.umeng.message.inapp.UmengInAppClickHandler";

    /* renamed from: b  reason: collision with root package name */
    private String f15279b = null;

    /* renamed from: c  reason: collision with root package name */
    private String f15280c = null;

    /* renamed from: d  reason: collision with root package name */
    private String f15281d = null;

    public final void handleInAppMessage(Activity activity, UInAppMessage uInAppMessage, int i10) {
        switch (i10) {
            case 16:
                this.f15279b = uInAppMessage.action_type;
                this.f15280c = uInAppMessage.action_activity;
                this.f15281d = uInAppMessage.action_url;
                break;
            case 17:
                this.f15279b = uInAppMessage.bottom_action_type;
                this.f15280c = uInAppMessage.bottom_action_activity;
                this.f15281d = uInAppMessage.bottom_action_url;
                break;
            case 18:
                this.f15279b = uInAppMessage.plainTextActionType;
                this.f15280c = uInAppMessage.plainTextActivity;
                this.f15281d = uInAppMessage.plainTextUrl;
                break;
            case 19:
                this.f15279b = uInAppMessage.customButtonActionType;
                this.f15280c = uInAppMessage.customButtonActivity;
                this.f15281d = uInAppMessage.customButtonUrl;
                break;
        }
        if (TextUtils.isEmpty(this.f15279b)) {
            return;
        }
        if (TextUtils.equals("go_activity", this.f15279b)) {
            openActivity(activity, this.f15280c);
        } else if (TextUtils.equals("go_url", this.f15279b)) {
            openUrl(activity, this.f15281d);
        } else {
            TextUtils.equals("go_app", this.f15279b);
        }
    }

    public void openActivity(Activity activity, String str) {
        if (str != null) {
            try {
                if (!TextUtils.isEmpty(str.trim())) {
                    UMLog.mutlInfo(f15278a, 2, "打开Activity: ".concat(str));
                    Intent intent = new Intent();
                    intent.setClassName(activity, str);
                    intent.setFlags(536870912);
                    activity.startActivity(intent);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public void openUrl(Activity activity, String str) {
        if (str != null) {
            try {
                if (!TextUtils.isEmpty(str.trim())) {
                    UMLog.mutlInfo(f15278a, 2, "打开链接: ".concat(str));
                    activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }
}
