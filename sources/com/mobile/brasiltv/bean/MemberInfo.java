package com.mobile.brasiltv.bean;

import android.graphics.drawable.Drawable;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.utils.c;
import ma.m;
import t9.i;

public final class MemberInfo {
    public static final MemberInfo INSTANCE = new MemberInfo();
    private static Drawable tempAvatar;

    public static final class Config {
        public static final Config INSTANCE = new Config();
        private static final String SHARED_PWD = "user_pwd";
        private static final String SHARED_USERNAME = "user_name";

        private Config() {
        }

        public final String getSHARED_PWD() {
            return SHARED_PWD;
        }

        public final String getSHARED_USERNAME() {
            return SHARED_USERNAME;
        }
    }

    private MemberInfo() {
    }

    public final String getLastPassword() {
        return App.f6050e.a().j().f();
    }

    public final String getLastUserName() {
        return App.f6050e.a().j().g();
    }

    public final Drawable getTempAvatar() {
        return tempAvatar;
    }

    public final void putPassword(String str, boolean z10) {
        i.g(str, "password");
        if (z10) {
            c j10 = App.f6050e.a().j();
            String c10 = m.c(str);
            i.f(c10, "getMd5(password)");
            j10.q(c10);
            return;
        }
        if (str.length() > 32) {
            str = str.substring(0, 32);
            i.f(str, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        App.f6050e.a().j().q(str);
    }

    public final void putUserName(String str) {
        i.g(str, "name");
        App.f6050e.a().j().r(str);
    }

    public final void setTempAvatar(Drawable drawable) {
        tempAvatar = drawable;
    }
}
