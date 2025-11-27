package com.efs.sdk.base.newsharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;

public class SharedPreferencesUtils {
    private static final HashMap<String, SharedPreferencesWrapper> sSpCache = new HashMap<>();

    public static class SharedPreferencesWrapper {
        /* access modifiers changed from: private */
        public volatile SharedPreferences mSharedPreferences;

        private SharedPreferencesWrapper() {
        }
    }

    private static SharedPreferences getNewSharedPreferences(Context context, String str, boolean z10) {
        return getNewSharedPreferences(context, str, z10, false);
    }

    public static File getNewSharedPrefsFile(Context context, String str) {
        String str2 = context.getApplicationInfo().dataDir;
        return new File(str2, "shared_prefs" + File.separatorChar + str + ".sp");
    }

    public static SharedPreferences getSharedPreferences(Context context, String str) {
        return getSharedPreferences(context, str, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00dc, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void handleReplace(android.content.Context r7, java.lang.String r8, boolean r9) {
        /*
            java.lang.Class<com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils> r0 = com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils.class
            monitor-enter(r0)
            if (r7 != 0) goto L_0x0007
            monitor-exit(r0)
            return
        L_0x0007:
            java.lang.String r1 = "sp_replace_flag"
            r2 = 1
            android.content.SharedPreferences r1 = getNewSharedPreferences(r7, r1, r9, r2)     // Catch:{ all -> 0x00dd }
            boolean r3 = r1.contains(r8)     // Catch:{ all -> 0x00dd }
            if (r3 != 0) goto L_0x00db
            android.content.SharedPreferences r9 = getNewSharedPreferences(r7, r8, r9, r2)     // Catch:{ all -> 0x00dd }
            android.content.SharedPreferences$Editor r3 = r9.edit()     // Catch:{ all -> 0x00dd }
            r4 = r9
            com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl r4 = (com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl) r4     // Catch:{ all -> 0x00dd }
            int r4 = r4.getModifyID()     // Catch:{ all -> 0x00dd }
            if (r4 > r2) goto L_0x00d0
            r4 = 0
            android.content.SharedPreferences r7 = r7.getSharedPreferences(r8, r4)     // Catch:{ all -> 0x00dd }
            java.util.Map r7 = r7.getAll()     // Catch:{ all -> 0x00dd }
            java.lang.String r4 = "caisq"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dd }
            java.lang.String r6 = "replace "
            r5.<init>(r6)     // Catch:{ all -> 0x00dd }
            r5.append(r8)     // Catch:{ all -> 0x00dd }
            java.lang.String r6 = "   "
            r5.append(r6)     // Catch:{ all -> 0x00dd }
            int r6 = r7.size()     // Catch:{ all -> 0x00dd }
            r5.append(r6)     // Catch:{ all -> 0x00dd }
            java.lang.String r6 = "   "
            r5.append(r6)     // Catch:{ all -> 0x00dd }
            int r9 = r9.hashCode()     // Catch:{ all -> 0x00dd }
            r5.append(r9)     // Catch:{ all -> 0x00dd }
            java.lang.String r9 = r5.toString()     // Catch:{ all -> 0x00dd }
            android.util.Log.e(r4, r9)     // Catch:{ all -> 0x00dd }
            int r9 = r7.size()     // Catch:{ all -> 0x00dd }
            if (r9 <= 0) goto L_0x00d0
            java.util.Set r7 = r7.entrySet()     // Catch:{ all -> 0x00dd }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x00dd }
        L_0x0067:
            boolean r9 = r7.hasNext()     // Catch:{ all -> 0x00dd }
            if (r9 == 0) goto L_0x00cd
            java.lang.Object r9 = r7.next()     // Catch:{ all -> 0x00dd }
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9     // Catch:{ all -> 0x00dd }
            java.lang.Object r4 = r9.getKey()     // Catch:{ all -> 0x00dd }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x00dd }
            java.lang.Object r9 = r9.getValue()     // Catch:{ all -> 0x00dd }
            if (r4 == 0) goto L_0x0067
            java.lang.String r5 = r4.trim()     // Catch:{ all -> 0x00dd }
            int r5 = r5.length()     // Catch:{ all -> 0x00dd }
            if (r5 <= 0) goto L_0x0067
            if (r9 == 0) goto L_0x0067
            boolean r5 = r9 instanceof java.lang.String     // Catch:{ all -> 0x00dd }
            if (r5 == 0) goto L_0x0095
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x00dd }
            r3.putString(r4, r9)     // Catch:{ all -> 0x00dd }
            goto L_0x0067
        L_0x0095:
            boolean r5 = r9 instanceof java.lang.Long     // Catch:{ all -> 0x00dd }
            if (r5 == 0) goto L_0x00a3
            java.lang.Long r9 = (java.lang.Long) r9     // Catch:{ all -> 0x00dd }
            long r5 = r9.longValue()     // Catch:{ all -> 0x00dd }
            r3.putLong(r4, r5)     // Catch:{ all -> 0x00dd }
            goto L_0x0067
        L_0x00a3:
            boolean r5 = r9 instanceof java.lang.Integer     // Catch:{ all -> 0x00dd }
            if (r5 == 0) goto L_0x00b1
            java.lang.Integer r9 = (java.lang.Integer) r9     // Catch:{ all -> 0x00dd }
            int r9 = r9.intValue()     // Catch:{ all -> 0x00dd }
            r3.putInt(r4, r9)     // Catch:{ all -> 0x00dd }
            goto L_0x0067
        L_0x00b1:
            boolean r5 = r9 instanceof java.lang.Float     // Catch:{ all -> 0x00dd }
            if (r5 == 0) goto L_0x00bf
            java.lang.Float r9 = (java.lang.Float) r9     // Catch:{ all -> 0x00dd }
            float r9 = r9.floatValue()     // Catch:{ all -> 0x00dd }
            r3.putFloat(r4, r9)     // Catch:{ all -> 0x00dd }
            goto L_0x0067
        L_0x00bf:
            boolean r5 = r9 instanceof java.lang.Boolean     // Catch:{ all -> 0x00dd }
            if (r5 == 0) goto L_0x0067
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x00dd }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x00dd }
            r3.putBoolean(r4, r9)     // Catch:{ all -> 0x00dd }
            goto L_0x0067
        L_0x00cd:
            r3.apply()     // Catch:{ all -> 0x00dd }
        L_0x00d0:
            android.content.SharedPreferences$Editor r7 = r1.edit()     // Catch:{ all -> 0x00dd }
            android.content.SharedPreferences$Editor r7 = r7.putBoolean(r8, r2)     // Catch:{ all -> 0x00dd }
            r7.apply()     // Catch:{ all -> 0x00dd }
        L_0x00db:
            monitor-exit(r0)
            return
        L_0x00dd:
            r7 = move-exception
            monitor-exit(r0)
            goto L_0x00e1
        L_0x00e0:
            throw r7
        L_0x00e1:
            goto L_0x00e0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils.handleReplace(android.content.Context, java.lang.String, boolean):void");
    }

    private static Object invokeObjectMethod(Object obj, String str, Class[] clsArr, Object[] objArr) {
        try {
            Method method = obj.getClass().getMethod(str, clsArr);
            method.setAccessible(true);
            return method.invoke(obj, objArr);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static void onDestroy() {
        HashMap<String, SharedPreferencesWrapper> hashMap = sSpCache;
        synchronized (hashMap) {
            if (hashMap.size() > 0) {
                for (SharedPreferencesWrapper access$100 : hashMap.values()) {
                    SharedPreferences access$1002 = access$100.mSharedPreferences;
                    if (access$1002 != null) {
                        ((SharedPreferencesNewImpl) access$1002).onDestroy();
                    }
                }
            }
        }
    }

    private static SharedPreferences getNewSharedPreferences(Context context, String str, boolean z10, boolean z11) {
        SharedPreferencesWrapper sharedPreferencesWrapper;
        HashMap<String, SharedPreferencesWrapper> hashMap = sSpCache;
        synchronized (hashMap) {
            sharedPreferencesWrapper = hashMap.get(str);
            if (sharedPreferencesWrapper == null) {
                sharedPreferencesWrapper = new SharedPreferencesWrapper();
                hashMap.put(str, sharedPreferencesWrapper);
            }
        }
        if (sharedPreferencesWrapper.mSharedPreferences == null) {
            synchronized (sharedPreferencesWrapper) {
                if (sharedPreferencesWrapper.mSharedPreferences == null && sharedPreferencesWrapper.mSharedPreferences == null) {
                    SharedPreferences unused = sharedPreferencesWrapper.mSharedPreferences = new SharedPreferencesNewImpl(getNewSharedPrefsFile(context, str), z10);
                }
            }
        }
        return sharedPreferencesWrapper.mSharedPreferences;
    }

    public static SharedPreferences getSharedPreferences(Context context, String str, boolean z10) {
        return getNewSharedPreferences(context, str, z10);
    }
}
