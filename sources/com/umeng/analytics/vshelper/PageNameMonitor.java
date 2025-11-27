package com.umeng.analytics.vshelper;

public class PageNameMonitor implements a {
    private static String currentActivity;
    private static String currentCustomPage;
    private static Object lock = new Object();

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final PageNameMonitor f14505a = new PageNameMonitor();

        private a() {
        }
    }

    public static PageNameMonitor getInstance() {
        return a.f14505a;
    }

    public void activityPause(String str) {
        synchronized (lock) {
            currentActivity = null;
        }
    }

    public void activityResume(String str) {
        synchronized (lock) {
            currentActivity = str;
        }
    }

    public void customPageBegin(String str) {
        synchronized (lock) {
            currentCustomPage = str;
        }
    }

    public void customPageEnd(String str) {
        synchronized (lock) {
            currentCustomPage = null;
        }
    }

    public String getCurrenPageName() {
        synchronized (lock) {
            String str = currentCustomPage;
            if (str != null) {
                return str;
            }
            String str2 = currentActivity;
            if (str2 != null) {
                return str2;
            }
            return null;
        }
    }

    public String getCurrentActivityName() {
        String str;
        synchronized (lock) {
            str = currentActivity;
        }
        return str;
    }

    private PageNameMonitor() {
    }
}
