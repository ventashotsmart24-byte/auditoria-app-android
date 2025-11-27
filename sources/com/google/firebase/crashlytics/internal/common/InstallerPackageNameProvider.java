package com.google.firebase.crashlytics.internal.common;

import android.content.Context;

class InstallerPackageNameProvider {
    private static final String NO_INSTALLER_PACKAGE_NAME = "";
    private String installerPackageName;

    private static String loadInstallerPackageName(Context context) {
        String installerPackageName2 = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        if (installerPackageName2 == null) {
            return "";
        }
        return installerPackageName2;
    }

    public synchronized String getInstallerPackageName(Context context) {
        String str;
        if (this.installerPackageName == null) {
            this.installerPackageName = loadInstallerPackageName(context);
        }
        if ("".equals(this.installerPackageName)) {
            str = null;
        } else {
            str = this.installerPackageName;
        }
        return str;
    }
}
