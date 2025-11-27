package com.mobile.brasiltv.view.dialog;

import android.app.Dialog;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.utils.b0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import na.f;
import t9.i;

public final class DialogManager {
    public static final String DIALOG_AD = "ad";
    public static final String DIALOG_BLACK_LIST = "black_list";
    public static final String DIALOG_EXPIRED = "expired";
    public static final String DIALOG_FORCE_BIND = "force_bind";
    public static final String DIALOG_INAPP_MSG_ACTIVITY_REMIND = "activity_remind";
    public static final String DIALOG_INAPP_MSG_COUPON_BENEFITS = "coupon_benefits";
    public static final String DIALOG_INAPP_MSG_GET_CASHBACK = "cashback";
    public static final String DIALOG_INAPP_MSG_ORDER_PAY_FAILURE = "order_pay_failure";
    public static final String DIALOG_INAPP_MSG_SERVICE_EFFECT = "service_effect";
    public static final String DIALOG_LOGIN_NO_EFFECT = "login_no_effect";
    public static final String DIALOG_NEW_BIND = "new_bind";
    public static final String DIALOG_NOTICE = "notice";
    public static final String DIALOG_NO_KEEP_ACTIVITIES = "no_keep_activities";
    public static final String DIALOG_OPEN_NOTIFY = "open_notify";
    public static final String DIALOG_REMOTE_LOGIN = "remote_login";
    public static final String DIALOG_TRIAL_END = "trial_end";
    public static final String DIALOG_UPDATE = "update";
    public static final String DIALOG_VERSION_FORBIDDEN = "version_forbidden";
    public static final DialogManager INSTANCE = new DialogManager();
    private static HashMap<String, List<Dialog>> dialogMap = new HashMap<>();
    private static boolean isDialogShowing;

    private DialogManager() {
    }

    private final void addDialog(Dialog dialog, String str) {
        List list = dialogMap.get(str);
        if (list == null) {
            list = new ArrayList();
        }
        list.add(dialog);
        dialogMap.put(str, list);
    }

    private final boolean isEmptyCacheDialog() {
        if (dialogMap.isEmpty()) {
            return true;
        }
        Set<String> keySet = dialogMap.keySet();
        i.f(keySet, "dialogMap.keys");
        for (String str : keySet) {
            if (b0.I(dialogMap.get(str))) {
                return false;
            }
        }
        return true;
    }

    private final boolean showByDialogType(String str) {
        boolean z10;
        List list = dialogMap.get(str);
        boolean z11 = false;
        if (list == null || list.isEmpty()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return false;
        }
        ((Dialog) list.get(0)).show();
        list.remove(0);
        if (list.isEmpty()) {
            z11 = true;
        }
        if (z11) {
            dialogMap.remove(str);
        }
        return true;
    }

    private final void showByPriorityLevel() {
        if (!showByDialogType(DIALOG_NO_KEEP_ACTIVITIES) && !showByDialogType(DIALOG_OPEN_NOTIFY) && !showByDialogType(DIALOG_VERSION_FORBIDDEN) && !showByDialogType(DIALOG_UPDATE) && !showByDialogType(DIALOG_FORCE_BIND) && !showByDialogType(DIALOG_NOTICE) && !showByDialogType(DIALOG_REMOTE_LOGIN) && !showByDialogType(DIALOG_LOGIN_NO_EFFECT) && !showByDialogType(DIALOG_BLACK_LIST) && !showByDialogType(DIALOG_EXPIRED) && !showByDialogType(DIALOG_TRIAL_END)) {
            if (showByDialogType(DIALOG_NEW_BIND)) {
                f.i(App.f6050e.a(), "keyShowGiftDaysDialog", false);
            } else if (!showByDialogType("ad") && !showByDialogType(DIALOG_INAPP_MSG_ACTIVITY_REMIND) && !showByDialogType(DIALOG_INAPP_MSG_COUPON_BENEFITS) && !showByDialogType(DIALOG_INAPP_MSG_GET_CASHBACK) && !showByDialogType(DIALOG_INAPP_MSG_SERVICE_EFFECT)) {
                showByDialogType(DIALOG_INAPP_MSG_ORDER_PAY_FAILURE);
            }
        }
    }

    public final void clear() {
        dialogMap.clear();
    }

    public final void clearSaveDialog(String... strArr) {
        i.g(strArr, "dialogTypes");
        for (String str : strArr) {
            if (b0.I(dialogMap.get(str))) {
                dialogMap.remove(str);
            }
        }
    }

    public final void dismissAndShowNext(Dialog dialog) {
        i.g(dialog, "dialog");
        dialog.dismiss();
        showNext(dialog);
    }

    public final boolean hasDialogSaved(String str) {
        i.g(str, "dialogType");
        if (b0.I(dialogMap.get(str))) {
            return true;
        }
        return false;
    }

    public final boolean isDialogShowing() {
        return isDialogShowing;
    }

    public final void reset() {
        isDialogShowing = false;
    }

    public final void showByManager(Dialog dialog, String str) {
        i.g(dialog, "dialog");
        i.g(str, "priorityLevel");
        if (isDialogShowing || !isEmptyCacheDialog()) {
            addDialog(dialog, str);
            return;
        }
        dialog.show();
        isDialogShowing = true;
        if (i.b(str, DIALOG_NEW_BIND)) {
            f.i(dialog.getContext(), "keyShowGiftDaysDialog", false);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0031, code lost:
        if (r4.isEmpty() == true) goto L_0x0035;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void showNext(android.app.Dialog r4) {
        /*
            r3 = this;
            java.lang.String r0 = "dialog"
            t9.i.g(r4, r0)
            boolean r4 = r4 instanceof com.mobile.brasiltv.view.BlackListDialog
            r0 = 0
            if (r4 == 0) goto L_0x003c
            java.util.HashMap<java.lang.String, java.util.List<android.app.Dialog>> r4 = dialogMap
            java.lang.String r1 = "black_list"
            java.lang.Object r4 = r4.get(r1)
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = com.mobile.brasiltv.utils.b0.I(r4)
            if (r4 == 0) goto L_0x003c
            java.util.HashMap<java.lang.String, java.util.List<android.app.Dialog>> r4 = dialogMap
            java.lang.Object r4 = r4.get(r1)
            java.util.List r4 = (java.util.List) r4
            if (r4 == 0) goto L_0x002a
            java.lang.Object r2 = r4.remove(r0)
            android.app.Dialog r2 = (android.app.Dialog) r2
        L_0x002a:
            if (r4 == 0) goto L_0x0034
            boolean r4 = r4.isEmpty()
            r2 = 1
            if (r4 != r2) goto L_0x0034
            goto L_0x0035
        L_0x0034:
            r2 = 0
        L_0x0035:
            if (r2 == 0) goto L_0x003c
            java.util.HashMap<java.lang.String, java.util.List<android.app.Dialog>> r4 = dialogMap
            r4.remove(r1)
        L_0x003c:
            boolean r4 = r3.isEmptyCacheDialog()
            if (r4 == 0) goto L_0x0045
            isDialogShowing = r0
            goto L_0x0048
        L_0x0045:
            r3.showByPriorityLevel()
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.view.dialog.DialogManager.showNext(android.app.Dialog):void");
    }
}
