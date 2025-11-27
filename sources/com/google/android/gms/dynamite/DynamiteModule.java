package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public final class DynamiteModule {
    @KeepForSdk
    public static final int LOCAL = -1;
    @KeepForSdk
    public static final int NONE = 0;
    @KeepForSdk
    public static final int NO_SELECTION = 0;
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzi();
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzj();
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzk();
    @KeepForSdk
    public static final VersionPolicy PREFER_LOCAL = new zzg();
    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE = new zzf();
    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzh();
    @KeepForSdk
    public static final int REMOTE = 1;
    public static final VersionPolicy zza = new zzl();
    @GuardedBy("DynamiteModule.class")
    private static Boolean zzb = null;
    @GuardedBy("DynamiteModule.class")
    private static String zzc = null;
    @GuardedBy("DynamiteModule.class")
    private static boolean zzd = false;
    @GuardedBy("DynamiteModule.class")
    private static int zze = -1;
    @GuardedBy("DynamiteModule.class")
    private static Boolean zzf;
    private static final ThreadLocal zzg = new ThreadLocal();
    private static final ThreadLocal zzh = new zzd();
    private static final VersionPolicy.IVersions zzi = new zze();
    @GuardedBy("DynamiteModule.class")
    private static zzq zzk;
    @GuardedBy("DynamiteModule.class")
    private static zzr zzl;
    private final Context zzj;

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        @GuardedBy("DynamiteLoaderClassLoader.class")
        public static ClassLoader sClassLoader;
    }

    @KeepForSdk
    public static class LoadingException extends Exception {
        public /* synthetic */ LoadingException(String str, zzp zzp) {
            super(str);
        }

        public /* synthetic */ LoadingException(String str, Throwable th, zzp zzp) {
            super(str, th);
        }
    }

    public interface VersionPolicy {

        @KeepForSdk
        public interface IVersions {
            int zza(Context context, String str);

            int zzb(Context context, String str, boolean z10);
        }

        @KeepForSdk
        public static class SelectionResult {
            @KeepForSdk
            public int localVersion = 0;
            @KeepForSdk
            public int remoteVersion = 0;
            @KeepForSdk
            public int selection = 0;
        }

        @KeepForSdk
        SelectionResult selectModule(Context context, String str, IVersions iVersions);
    }

    private DynamiteModule(Context context) {
        Preconditions.checkNotNull(context);
        this.zzj = context;
    }

    @KeepForSdk
    public static int getLocalVersion(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            Class<?> loadClass = classLoader.loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (Objects.equal(declaredField.get((Object) null), str)) {
                return declaredField2.getInt((Object) null);
            }
            String valueOf = String.valueOf(declaredField.get((Object) null));
            Log.e("DynamiteModule", "Module descriptor id '" + valueOf + "' didn't match expected id '" + str + "'");
            return 0;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Local module descriptor class for ");
            sb.append(str);
            sb.append(" not found.");
            return 0;
        } catch (Exception e10) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e10.getMessage())));
            return 0;
        }
    }

    @KeepForSdk
    public static int getRemoteVersion(Context context, String str) {
        return zza(context, str, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:159:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x02a9  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x02b6  */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.dynamite.DynamiteModule load(android.content.Context r18, com.google.android.gms.dynamite.DynamiteModule.VersionPolicy r19, java.lang.String r20) {
        /*
            r1 = r18
            r2 = r19
            r3 = r20
            java.lang.ThreadLocal r0 = zzg
            java.lang.Object r4 = r0.get()
            com.google.android.gms.dynamite.zzn r4 = (com.google.android.gms.dynamite.zzn) r4
            com.google.android.gms.dynamite.zzn r5 = new com.google.android.gms.dynamite.zzn
            r6 = 0
            r5.<init>(r6)
            r0.set(r5)
            java.lang.ThreadLocal r7 = zzh
            java.lang.Object r8 = r7.get()
            java.lang.Long r8 = (java.lang.Long) r8
            long r8 = r8.longValue()
            r10 = 0
            long r12 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x029d }
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x029d }
            r7.set(r12)     // Catch:{ all -> 0x029d }
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$IVersions r12 = zzi     // Catch:{ all -> 0x029d }
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$SelectionResult r12 = r2.selectModule(r1, r3, r12)     // Catch:{ all -> 0x029d }
            int r13 = r12.localVersion     // Catch:{ all -> 0x029d }
            int r14 = r12.remoteVersion     // Catch:{ all -> 0x029d }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x029d }
            r15.<init>()     // Catch:{ all -> 0x029d }
            java.lang.String r6 = "Considering local module "
            r15.append(r6)     // Catch:{ all -> 0x029d }
            r15.append(r3)     // Catch:{ all -> 0x029d }
            java.lang.String r6 = ":"
            r15.append(r6)     // Catch:{ all -> 0x029d }
            r15.append(r13)     // Catch:{ all -> 0x029d }
            java.lang.String r6 = " and remote module "
            r15.append(r6)     // Catch:{ all -> 0x029d }
            r15.append(r3)     // Catch:{ all -> 0x029d }
            java.lang.String r6 = ":"
            r15.append(r6)     // Catch:{ all -> 0x029d }
            r15.append(r14)     // Catch:{ all -> 0x029d }
            int r6 = r12.selection     // Catch:{ all -> 0x029d }
            if (r6 == 0) goto L_0x0268
            r13 = -1
            if (r6 != r13) goto L_0x006b
            int r6 = r12.localVersion     // Catch:{ all -> 0x029d }
            if (r6 == 0) goto L_0x0268
            r6 = -1
        L_0x006b:
            r14 = 1
            if (r6 != r14) goto L_0x0072
            int r15 = r12.remoteVersion     // Catch:{ all -> 0x029d }
            if (r15 == 0) goto L_0x0268
        L_0x0072:
            if (r6 != r13) goto L_0x0092
            com.google.android.gms.dynamite.DynamiteModule r1 = zzc(r1, r3)     // Catch:{ all -> 0x029d }
            int r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r2 != 0) goto L_0x0080
            r7.remove()
            goto L_0x0087
        L_0x0080:
            java.lang.Long r2 = java.lang.Long.valueOf(r8)
            r7.set(r2)
        L_0x0087:
            android.database.Cursor r2 = r5.zza
            if (r2 == 0) goto L_0x008e
            r2.close()
        L_0x008e:
            r0.set(r4)
            return r1
        L_0x0092:
            if (r6 != r14) goto L_0x0250
            int r15 = r12.remoteVersion     // Catch:{ LoadingException -> 0x01fa }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r16 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r16)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            boolean r17 = zzf(r18)     // Catch:{ all -> 0x01de }
            if (r17 == 0) goto L_0x01d5
            java.lang.Boolean r17 = zzb     // Catch:{ all -> 0x01de }
            monitor-exit(r16)     // Catch:{ all -> 0x01de }
            if (r17 == 0) goto L_0x01cc
            boolean r16 = r17.booleanValue()     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            r14 = 2
            if (r16 == 0) goto L_0x013c
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            r13.<init>()     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            java.lang.String r6 = "Selected remote version of "
            r13.append(r6)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            r13.append(r3)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            java.lang.String r6 = ", version >= "
            r13.append(r6)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            r13.append(r15)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r6 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r6)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            com.google.android.gms.dynamite.zzr r13 = zzl     // Catch:{ all -> 0x0139 }
            monitor-exit(r6)     // Catch:{ all -> 0x0139 }
            if (r13 == 0) goto L_0x0130
            java.lang.Object r6 = r0.get()     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            com.google.android.gms.dynamite.zzn r6 = (com.google.android.gms.dynamite.zzn) r6     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            if (r6 == 0) goto L_0x0127
            android.database.Cursor r10 = r6.zza     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            if (r10 == 0) goto L_0x0127
            android.content.Context r10 = r18.getApplicationContext()     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            android.database.Cursor r6 = r6.zza     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            r11 = 0
            com.google.android.gms.dynamic.ObjectWrapper.wrap(r11)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r11 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r11)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            int r2 = zze     // Catch:{ all -> 0x0124 }
            if (r2 < r14) goto L_0x00e7
            r14 = 1
            goto L_0x00e8
        L_0x00e7:
            r14 = 0
        L_0x00e8:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r14)     // Catch:{ all -> 0x0124 }
            monitor-exit(r11)     // Catch:{ all -> 0x0124 }
            boolean r2 = r2.booleanValue()     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            if (r2 == 0) goto L_0x0100
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            com.google.android.gms.dynamic.IObjectWrapper r6 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r6)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            com.google.android.gms.dynamic.IObjectWrapper r2 = r13.zzf(r2, r3, r15, r6)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            goto L_0x010c
        L_0x0100:
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            com.google.android.gms.dynamic.IObjectWrapper r6 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r6)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            com.google.android.gms.dynamic.IObjectWrapper r2 = r13.zze(r2, r3, r15, r6)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
        L_0x010c:
            java.lang.Object r2 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r2)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            android.content.Context r2 = (android.content.Context) r2     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            if (r2 == 0) goto L_0x011b
            com.google.android.gms.dynamite.DynamiteModule r6 = new com.google.android.gms.dynamite.DynamiteModule     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            r6.<init>(r2)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            goto L_0x019e
        L_0x011b:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            java.lang.String r2 = "Failed to get module context"
            r6 = 0
            r0.<init>(r2, r6)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            throw r0     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
        L_0x0124:
            r0 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x0124 }
            throw r0     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
        L_0x0127:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            java.lang.String r2 = "No result cursor"
            r6 = 0
            r0.<init>(r2, r6)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            throw r0     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
        L_0x0130:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            java.lang.String r2 = "DynamiteLoaderV2 was not cached."
            r6 = 0
            r0.<init>(r2, r6)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            throw r0     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
        L_0x0139:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0139 }
            throw r0     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
        L_0x013c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            r2.<init>()     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            java.lang.String r6 = "Selected remote version of "
            r2.append(r6)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            r2.append(r3)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            java.lang.String r6 = ", version >= "
            r2.append(r6)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            r2.append(r15)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            com.google.android.gms.dynamite.zzq r2 = zzg(r18)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            if (r2 == 0) goto L_0x01c3
            int r6 = r2.zze()     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            r10 = 3
            if (r6 < r10) goto L_0x017e
            java.lang.Object r6 = r0.get()     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            com.google.android.gms.dynamite.zzn r6 = (com.google.android.gms.dynamite.zzn) r6     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            if (r6 == 0) goto L_0x0175
            com.google.android.gms.dynamic.IObjectWrapper r10 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r18)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            android.database.Cursor r6 = r6.zza     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            com.google.android.gms.dynamic.IObjectWrapper r6 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r6)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            com.google.android.gms.dynamic.IObjectWrapper r2 = r2.zzi(r10, r3, r15, r6)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            goto L_0x0191
        L_0x0175:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            java.lang.String r2 = "No cached result cursor holder"
            r6 = 0
            r0.<init>(r2, r6)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            throw r0     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
        L_0x017e:
            if (r6 != r14) goto L_0x0189
            com.google.android.gms.dynamic.IObjectWrapper r6 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r18)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            com.google.android.gms.dynamic.IObjectWrapper r2 = r2.zzj(r6, r3, r15)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            goto L_0x0191
        L_0x0189:
            com.google.android.gms.dynamic.IObjectWrapper r6 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r18)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            com.google.android.gms.dynamic.IObjectWrapper r2 = r2.zzh(r6, r3, r15)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
        L_0x0191:
            java.lang.Object r2 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r2)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            if (r2 == 0) goto L_0x01ba
            com.google.android.gms.dynamite.DynamiteModule r6 = new com.google.android.gms.dynamite.DynamiteModule     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            android.content.Context r2 = (android.content.Context) r2     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            r6.<init>(r2)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
        L_0x019e:
            r1 = 0
            int r3 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x01a8
            r7.remove()
            goto L_0x01af
        L_0x01a8:
            java.lang.Long r1 = java.lang.Long.valueOf(r8)
            r7.set(r1)
        L_0x01af:
            android.database.Cursor r1 = r5.zza
            if (r1 == 0) goto L_0x01b6
            r1.close()
        L_0x01b6:
            r0.set(r4)
            return r6
        L_0x01ba:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            java.lang.String r2 = "Failed to load remote module."
            r6 = 0
            r0.<init>(r2, r6)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            throw r0     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
        L_0x01c3:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            java.lang.String r2 = "Failed to create IDynamiteLoader."
            r6 = 0
            r0.<init>(r2, r6)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            throw r0     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
        L_0x01cc:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            java.lang.String r2 = "Failed to determine which loading route to use."
            r6 = 0
            r0.<init>(r2, r6)     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
            throw r0     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
        L_0x01d5:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x01de }
            java.lang.String r2 = "Remote loading disabled"
            r6 = 0
            r0.<init>(r2, r6)     // Catch:{ all -> 0x01de }
            throw r0     // Catch:{ all -> 0x01de }
        L_0x01de:
            r0 = move-exception
            monitor-exit(r16)     // Catch:{ all -> 0x01de }
            throw r0     // Catch:{ RemoteException -> 0x01f0, LoadingException -> 0x01ee, all -> 0x01e1 }
        L_0x01e1:
            r0 = move-exception
            com.google.android.gms.common.util.CrashUtils.addDynamiteErrorToDropBox(r1, r0)     // Catch:{ all -> 0x0299 }
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r2 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x0299 }
            java.lang.String r6 = "Failed to load remote module."
            r7 = 0
            r2.<init>(r6, r0, r7)     // Catch:{ all -> 0x0299 }
            throw r2     // Catch:{ all -> 0x0299 }
        L_0x01ee:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0299 }
        L_0x01f0:
            r0 = move-exception
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r2 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x0299 }
            java.lang.String r6 = "Failed to load remote module."
            r7 = 0
            r2.<init>(r6, r0, r7)     // Catch:{ all -> 0x0299 }
            throw r2     // Catch:{ all -> 0x0299 }
        L_0x01fa:
            r0 = move-exception
            java.lang.String r2 = r0.getMessage()     // Catch:{  }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{  }
            r6.<init>()     // Catch:{  }
            java.lang.String r7 = "Failed to load remote module: "
            r6.append(r7)     // Catch:{  }
            r6.append(r2)     // Catch:{  }
            int r2 = r12.localVersion     // Catch:{  }
            if (r2 == 0) goto L_0x0247
            com.google.android.gms.dynamite.zzo r6 = new com.google.android.gms.dynamite.zzo     // Catch:{  }
            r7 = 0
            r6.<init>(r2, r7)     // Catch:{  }
            r2 = r19
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$SelectionResult r2 = r2.selectModule(r1, r3, r6)     // Catch:{  }
            int r2 = r2.selection     // Catch:{  }
            r6 = -1
            if (r2 != r6) goto L_0x0247
            com.google.android.gms.dynamite.DynamiteModule r0 = zzc(r1, r3)     // Catch:{  }
            r1 = 0
            int r3 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x0231
            java.lang.ThreadLocal r1 = zzh
            r1.remove()
            goto L_0x023a
        L_0x0231:
            java.lang.ThreadLocal r1 = zzh
            java.lang.Long r2 = java.lang.Long.valueOf(r8)
            r1.set(r2)
        L_0x023a:
            android.database.Cursor r1 = r5.zza
            if (r1 == 0) goto L_0x0241
            r1.close()
        L_0x0241:
            java.lang.ThreadLocal r1 = zzg
            r1.set(r4)
            return r0
        L_0x0247:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r1 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{  }
            java.lang.String r2 = "Remote load failed. No local fallback found."
            r3 = 0
            r1.<init>(r2, r0, r3)     // Catch:{  }
            throw r1     // Catch:{  }
        L_0x0250:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{  }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{  }
            r1.<init>()     // Catch:{  }
            java.lang.String r2 = "VersionPolicy returned invalid code:"
            r1.append(r2)     // Catch:{  }
            r1.append(r6)     // Catch:{  }
            java.lang.String r1 = r1.toString()     // Catch:{  }
            r2 = 0
            r0.<init>(r1, r2)     // Catch:{  }
            throw r0     // Catch:{  }
        L_0x0268:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{  }
            int r1 = r12.localVersion     // Catch:{  }
            int r2 = r12.remoteVersion     // Catch:{  }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{  }
            r6.<init>()     // Catch:{  }
            java.lang.String r7 = "No acceptable module "
            r6.append(r7)     // Catch:{  }
            r6.append(r3)     // Catch:{  }
            java.lang.String r3 = " found. Local version is "
            r6.append(r3)     // Catch:{  }
            r6.append(r1)     // Catch:{  }
            java.lang.String r1 = " and remote version is "
            r6.append(r1)     // Catch:{  }
            r6.append(r2)     // Catch:{  }
            java.lang.String r1 = "."
            r6.append(r1)     // Catch:{  }
            java.lang.String r1 = r6.toString()     // Catch:{  }
            r2 = 0
            r0.<init>(r1, r2)     // Catch:{  }
            throw r0     // Catch:{  }
        L_0x0299:
            r0 = move-exception
            r1 = 0
            goto L_0x029f
        L_0x029d:
            r0 = move-exception
            r1 = r10
        L_0x029f:
            int r3 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x02a9
            java.lang.ThreadLocal r1 = zzh
            r1.remove()
            goto L_0x02b2
        L_0x02a9:
            java.lang.ThreadLocal r1 = zzh
            java.lang.Long r2 = java.lang.Long.valueOf(r8)
            r1.set(r2)
        L_0x02b2:
            android.database.Cursor r1 = r5.zza
            if (r1 == 0) goto L_0x02b9
            r1.close()
        L_0x02b9:
            java.lang.ThreadLocal r1 = zzg
            r1.set(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.load(android.content.Context, com.google.android.gms.dynamite.DynamiteModule$VersionPolicy, java.lang.String):com.google.android.gms.dynamite.DynamiteModule");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:31:0x0056=Splitter:B:31:0x0056, B:50:0x009a=Splitter:B:50:0x009a, B:17:0x003b=Splitter:B:17:0x003b} */
    public static int zza(android.content.Context r10, java.lang.String r11, boolean r12) {
        /*
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r0 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r0)     // Catch:{ all -> 0x0192 }
            java.lang.Boolean r1 = zzb     // Catch:{ all -> 0x018f }
            r2 = 0
            r3 = 0
            if (r1 != 0) goto L_0x00cf
            android.content.Context r1 = r10.getApplicationContext()     // Catch:{ ClassNotFoundException -> 0x00b9, IllegalAccessException -> 0x00b7, NoSuchFieldException -> 0x00b5 }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00b9, IllegalAccessException -> 0x00b7, NoSuchFieldException -> 0x00b5 }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader> r4 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class
            java.lang.String r4 = r4.getName()     // Catch:{ ClassNotFoundException -> 0x00b9, IllegalAccessException -> 0x00b7, NoSuchFieldException -> 0x00b5 }
            java.lang.Class r1 = r1.loadClass(r4)     // Catch:{ ClassNotFoundException -> 0x00b9, IllegalAccessException -> 0x00b7, NoSuchFieldException -> 0x00b5 }
            java.lang.String r4 = "sClassLoader"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r4)     // Catch:{ ClassNotFoundException -> 0x00b9, IllegalAccessException -> 0x00b7, NoSuchFieldException -> 0x00b5 }
            java.lang.Class r4 = r1.getDeclaringClass()     // Catch:{ ClassNotFoundException -> 0x00b9, IllegalAccessException -> 0x00b7, NoSuchFieldException -> 0x00b5 }
            monitor-enter(r4)     // Catch:{ ClassNotFoundException -> 0x00b9, IllegalAccessException -> 0x00b7, NoSuchFieldException -> 0x00b5 }
            java.lang.Object r5 = r1.get(r2)     // Catch:{ all -> 0x00b2 }
            java.lang.ClassLoader r5 = (java.lang.ClassLoader) r5     // Catch:{ all -> 0x00b2 }
            java.lang.ClassLoader r6 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00b2 }
            if (r5 != r6) goto L_0x0036
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00b2 }
            goto L_0x00b0
        L_0x0036:
            if (r5 == 0) goto L_0x003f
            zzd(r5)     // Catch:{ LoadingException -> 0x003b }
        L_0x003b:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00b2 }
            goto L_0x00b0
        L_0x003f:
            boolean r5 = zzf(r10)     // Catch:{ all -> 0x00b2 }
            if (r5 != 0) goto L_0x0048
            monitor-exit(r4)     // Catch:{ all -> 0x00b2 }
            monitor-exit(r0)     // Catch:{ all -> 0x018f }
            return r3
        L_0x0048:
            boolean r5 = zzd     // Catch:{ all -> 0x00b2 }
            if (r5 != 0) goto L_0x00a7
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00b2 }
            boolean r6 = r5.equals(r2)     // Catch:{ all -> 0x00b2 }
            if (r6 == 0) goto L_0x0055
            goto L_0x00a7
        L_0x0055:
            r6 = 1
            int r6 = zzb(r10, r11, r12, r6)     // Catch:{ LoadingException -> 0x009d }
            java.lang.String r7 = zzc     // Catch:{ LoadingException -> 0x009d }
            if (r7 == 0) goto L_0x009a
            boolean r7 = r7.isEmpty()     // Catch:{ LoadingException -> 0x009d }
            if (r7 == 0) goto L_0x0065
            goto L_0x009a
        L_0x0065:
            java.lang.ClassLoader r7 = com.google.android.gms.dynamite.zzb.zza()     // Catch:{ LoadingException -> 0x009d }
            if (r7 == 0) goto L_0x006c
            goto L_0x008f
        L_0x006c:
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ LoadingException -> 0x009d }
            r8 = 29
            if (r7 < r8) goto L_0x0081
            dalvik.system.DelegateLastClassLoader r7 = new dalvik.system.DelegateLastClassLoader     // Catch:{ LoadingException -> 0x009d }
            java.lang.String r8 = zzc     // Catch:{ LoadingException -> 0x009d }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ LoadingException -> 0x009d }
            java.lang.ClassLoader r9 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x009d }
            r7.<init>(r8, r9)     // Catch:{ LoadingException -> 0x009d }
            goto L_0x008f
        L_0x0081:
            com.google.android.gms.dynamite.zzc r7 = new com.google.android.gms.dynamite.zzc     // Catch:{ LoadingException -> 0x009d }
            java.lang.String r8 = zzc     // Catch:{ LoadingException -> 0x009d }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ LoadingException -> 0x009d }
            java.lang.ClassLoader r9 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x009d }
            r7.<init>(r8, r9)     // Catch:{ LoadingException -> 0x009d }
        L_0x008f:
            zzd(r7)     // Catch:{ LoadingException -> 0x009d }
            r1.set(r2, r7)     // Catch:{ LoadingException -> 0x009d }
            zzb = r5     // Catch:{ LoadingException -> 0x009d }
            monitor-exit(r4)     // Catch:{ all -> 0x00b2 }
            monitor-exit(r0)     // Catch:{ all -> 0x018f }
            return r6
        L_0x009a:
            monitor-exit(r4)     // Catch:{ all -> 0x00b2 }
            monitor-exit(r0)     // Catch:{ all -> 0x018f }
            return r6
        L_0x009d:
            java.lang.ClassLoader r5 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00b2 }
            r1.set(r2, r5)     // Catch:{ all -> 0x00b2 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00b2 }
            goto L_0x00b0
        L_0x00a7:
            java.lang.ClassLoader r5 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00b2 }
            r1.set(r2, r5)     // Catch:{ all -> 0x00b2 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00b2 }
        L_0x00b0:
            monitor-exit(r4)     // Catch:{ all -> 0x00b2 }
            goto L_0x00cd
        L_0x00b2:
            r1 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00b2 }
            throw r1     // Catch:{ ClassNotFoundException -> 0x00b9, IllegalAccessException -> 0x00b7, NoSuchFieldException -> 0x00b5 }
        L_0x00b5:
            r1 = move-exception
            goto L_0x00ba
        L_0x00b7:
            r1 = move-exception
            goto L_0x00ba
        L_0x00b9:
            r1 = move-exception
        L_0x00ba:
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x018f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x018f }
            r4.<init>()     // Catch:{ all -> 0x018f }
            java.lang.String r5 = "Failed to load module via V2: "
            r4.append(r5)     // Catch:{ all -> 0x018f }
            r4.append(r1)     // Catch:{ all -> 0x018f }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x018f }
        L_0x00cd:
            zzb = r1     // Catch:{ all -> 0x018f }
        L_0x00cf:
            monitor-exit(r0)     // Catch:{ all -> 0x018f }
            boolean r0 = r1.booleanValue()     // Catch:{ all -> 0x0192 }
            if (r0 == 0) goto L_0x00ee
            int r10 = zzb(r10, r11, r12, r3)     // Catch:{ LoadingException -> 0x00db }
            return r10
        L_0x00db:
            r11 = move-exception
            java.lang.String r11 = r11.getMessage()     // Catch:{ all -> 0x0192 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0192 }
            r12.<init>()     // Catch:{ all -> 0x0192 }
            java.lang.String r0 = "Failed to retrieve remote module version: "
            r12.append(r0)     // Catch:{ all -> 0x0192 }
            r12.append(r11)     // Catch:{ all -> 0x0192 }
            return r3
        L_0x00ee:
            com.google.android.gms.dynamite.zzq r4 = zzg(r10)     // Catch:{ all -> 0x0192 }
            if (r4 != 0) goto L_0x00f6
            goto L_0x0186
        L_0x00f6:
            int r0 = r4.zze()     // Catch:{ RemoteException -> 0x016e }
            r1 = 3
            if (r0 < r1) goto L_0x0157
            java.lang.ThreadLocal r0 = zzg     // Catch:{ RemoteException -> 0x016e }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x016e }
            com.google.android.gms.dynamite.zzn r0 = (com.google.android.gms.dynamite.zzn) r0     // Catch:{ RemoteException -> 0x016e }
            if (r0 == 0) goto L_0x0111
            android.database.Cursor r0 = r0.zza     // Catch:{ RemoteException -> 0x016e }
            if (r0 == 0) goto L_0x0111
            int r3 = r0.getInt(r3)     // Catch:{ RemoteException -> 0x016e }
            goto L_0x0186
        L_0x0111:
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x016e }
            java.lang.ThreadLocal r0 = zzh     // Catch:{ RemoteException -> 0x016e }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x016e }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ RemoteException -> 0x016e }
            long r8 = r0.longValue()     // Catch:{ RemoteException -> 0x016e }
            r6 = r11
            r7 = r12
            com.google.android.gms.dynamic.IObjectWrapper r11 = r4.zzk(r5, r6, r7, r8)     // Catch:{ RemoteException -> 0x016e }
            java.lang.Object r11 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r11)     // Catch:{ RemoteException -> 0x016e }
            android.database.Cursor r11 = (android.database.Cursor) r11     // Catch:{ RemoteException -> 0x016e }
            if (r11 == 0) goto L_0x0151
            boolean r12 = r11.moveToFirst()     // Catch:{ RemoteException -> 0x014e, all -> 0x014b }
            if (r12 != 0) goto L_0x0136
            goto L_0x0151
        L_0x0136:
            int r12 = r11.getInt(r3)     // Catch:{ RemoteException -> 0x014e, all -> 0x014b }
            if (r12 <= 0) goto L_0x0143
            boolean r0 = zze(r11)     // Catch:{ RemoteException -> 0x014e, all -> 0x014b }
            if (r0 == 0) goto L_0x0143
            goto L_0x0144
        L_0x0143:
            r2 = r11
        L_0x0144:
            if (r2 == 0) goto L_0x0149
            r2.close()     // Catch:{ all -> 0x0192 }
        L_0x0149:
            r3 = r12
            goto L_0x0186
        L_0x014b:
            r12 = move-exception
            r2 = r11
            goto L_0x0189
        L_0x014e:
            r12 = move-exception
            r2 = r11
            goto L_0x0170
        L_0x0151:
            if (r11 == 0) goto L_0x0186
            r11.close()     // Catch:{ all -> 0x0192 }
            goto L_0x0186
        L_0x0157:
            r1 = 2
            if (r0 != r1) goto L_0x0163
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x016e }
            int r3 = r4.zzg(r0, r11, r12)     // Catch:{ RemoteException -> 0x016e }
            goto L_0x0186
        L_0x0163:
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x016e }
            int r3 = r4.zzf(r0, r11, r12)     // Catch:{ RemoteException -> 0x016e }
            goto L_0x0186
        L_0x016c:
            r12 = r11
            goto L_0x0189
        L_0x016e:
            r11 = move-exception
            r12 = r11
        L_0x0170:
            java.lang.String r11 = r12.getMessage()     // Catch:{ all -> 0x0187 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0187 }
            r12.<init>()     // Catch:{ all -> 0x0187 }
            java.lang.String r0 = "Failed to retrieve remote module version: "
            r12.append(r0)     // Catch:{ all -> 0x0187 }
            r12.append(r11)     // Catch:{ all -> 0x0187 }
            if (r2 == 0) goto L_0x0186
            r2.close()     // Catch:{ all -> 0x0192 }
        L_0x0186:
            return r3
        L_0x0187:
            r11 = move-exception
            goto L_0x016c
        L_0x0189:
            if (r2 == 0) goto L_0x018e
            r2.close()     // Catch:{ all -> 0x0192 }
        L_0x018e:
            throw r12     // Catch:{ all -> 0x0192 }
        L_0x018f:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x018f }
            throw r11     // Catch:{ all -> 0x0192 }
        L_0x0192:
            r11 = move-exception
            com.google.android.gms.common.util.CrashUtils.addDynamiteErrorToDropBox(r10, r11)
            goto L_0x0198
        L_0x0197:
            throw r11
        L_0x0198:
            goto L_0x0197
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zza(android.content.Context, java.lang.String, boolean):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b5 A[Catch:{ all -> 0x00be }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b6 A[Catch:{ all -> 0x00be }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00c2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzb(android.content.Context r10, java.lang.String r11, boolean r12, boolean r13) {
        /*
            r0 = 0
            java.lang.ThreadLocal r1 = zzh     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            long r1 = r1.longValue()     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            java.lang.String r10 = "api_force_staging"
            java.lang.String r4 = "api"
            r9 = 1
            if (r9 == r12) goto L_0x0019
            r10 = r4
        L_0x0019:
            android.net.Uri$Builder r12 = new android.net.Uri$Builder     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            r12.<init>()     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            java.lang.String r4 = "content"
            android.net.Uri$Builder r12 = r12.scheme(r4)     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            java.lang.String r4 = "com.google.android.gms.chimera"
            android.net.Uri$Builder r12 = r12.authority(r4)     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            android.net.Uri$Builder r10 = r12.path(r10)     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            android.net.Uri$Builder r10 = r10.appendPath(r11)     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            java.lang.String r11 = "requestStartTime"
            java.lang.String r12 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            android.net.Uri$Builder r10 = r10.appendQueryParameter(r11, r12)     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            android.net.Uri r4 = r10.build()     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00ae, all -> 0x00ab }
            if (r10 == 0) goto L_0x00a3
            boolean r11 = r10.moveToFirst()     // Catch:{ Exception -> 0x009b }
            if (r11 == 0) goto L_0x00a3
            r11 = 0
            int r12 = r10.getInt(r11)     // Catch:{ Exception -> 0x009b }
            if (r12 <= 0) goto L_0x008e
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r1 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r1)     // Catch:{ Exception -> 0x009b }
            r2 = 2
            java.lang.String r2 = r10.getString(r2)     // Catch:{ all -> 0x008b }
            zzc = r2     // Catch:{ all -> 0x008b }
            java.lang.String r2 = "loaderVersion"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x008b }
            if (r2 < 0) goto L_0x006f
            int r2 = r10.getInt(r2)     // Catch:{ all -> 0x008b }
            zze = r2     // Catch:{ all -> 0x008b }
        L_0x006f:
            java.lang.String r2 = "disableStandaloneDynamiteLoader2"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x008b }
            if (r2 < 0) goto L_0x0082
            int r2 = r10.getInt(r2)     // Catch:{ all -> 0x008b }
            if (r2 == 0) goto L_0x007e
            goto L_0x007f
        L_0x007e:
            r9 = 0
        L_0x007f:
            zzd = r9     // Catch:{ all -> 0x008b }
            r11 = r9
        L_0x0082:
            monitor-exit(r1)     // Catch:{ all -> 0x008b }
            boolean r1 = zze(r10)     // Catch:{ Exception -> 0x009b }
            if (r1 == 0) goto L_0x008e
            r10 = r0
            goto L_0x008e
        L_0x008b:
            r11 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x008b }
            throw r11     // Catch:{ Exception -> 0x009b }
        L_0x008e:
            if (r13 == 0) goto L_0x009d
            if (r11 != 0) goto L_0x0093
            goto L_0x009d
        L_0x0093:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r11 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x009b }
            java.lang.String r12 = "forcing fallback to container DynamiteLoader impl"
            r11.<init>(r12, r0)     // Catch:{ Exception -> 0x009b }
            throw r11     // Catch:{ Exception -> 0x009b }
        L_0x009b:
            r11 = move-exception
            goto L_0x00b1
        L_0x009d:
            if (r10 == 0) goto L_0x00a2
            r10.close()
        L_0x00a2:
            return r12
        L_0x00a3:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r11 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x009b }
            java.lang.String r12 = "Failed to connect to dynamite module ContentResolver."
            r11.<init>(r12, r0)     // Catch:{ Exception -> 0x009b }
            throw r11     // Catch:{ Exception -> 0x009b }
        L_0x00ab:
            r10 = move-exception
            r11 = r10
            goto L_0x00c0
        L_0x00ae:
            r10 = move-exception
            r11 = r10
            r10 = r0
        L_0x00b1:
            boolean r12 = r11 instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException     // Catch:{ all -> 0x00be }
            if (r12 == 0) goto L_0x00b6
            throw r11     // Catch:{ all -> 0x00be }
        L_0x00b6:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r12 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x00be }
            java.lang.String r13 = "V2 version check failed"
            r12.<init>(r13, r11, r0)     // Catch:{ all -> 0x00be }
            throw r12     // Catch:{ all -> 0x00be }
        L_0x00be:
            r11 = move-exception
            r0 = r10
        L_0x00c0:
            if (r0 == 0) goto L_0x00c5
            r0.close()
        L_0x00c5:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzb(android.content.Context, java.lang.String, boolean, boolean):int");
    }

    private static DynamiteModule zzc(Context context, String str) {
        "Selected local version of ".concat(String.valueOf(str));
        return new DynamiteModule(context.getApplicationContext());
    }

    @GuardedBy("DynamiteModule.class")
    private static void zzd(ClassLoader classLoader) {
        zzr zzr;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzr = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzr) {
                    zzr = (zzr) queryLocalInterface;
                } else {
                    zzr = new zzr(iBinder);
                }
            }
            zzl = zzr;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e10) {
            throw new LoadingException("Failed to instantiate dynamite loader", e10, (zzp) null);
        }
    }

    private static boolean zze(Cursor cursor) {
        zzn zzn = (zzn) zzg.get();
        if (zzn == null || zzn.zza != null) {
            return false;
        }
        zzn.zza = cursor;
        return true;
    }

    @GuardedBy("DynamiteModule.class")
    private static boolean zzf(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals((Object) null) || bool.equals(zzf)) {
            return true;
        }
        boolean z10 = false;
        if (zzf == null) {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 10000000) == 0 && resolveContentProvider != null && "com.google.android.gms".equals(resolveContentProvider.packageName)) {
                z10 = true;
            }
            Boolean valueOf = Boolean.valueOf(z10);
            zzf = valueOf;
            z10 = valueOf.booleanValue();
            if (z10 && resolveContentProvider != null && (applicationInfo = resolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                zzd = true;
            }
        }
        if (!z10) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z10;
    }

    private static zzq zzg(Context context) {
        zzq zzq;
        synchronized (DynamiteModule.class) {
            zzq zzq2 = zzk;
            if (zzq2 != null) {
                return zzq2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzq = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    if (queryLocalInterface instanceof zzq) {
                        zzq = (zzq) queryLocalInterface;
                    } else {
                        zzq = new zzq(iBinder);
                    }
                }
                if (zzq != null) {
                    zzk = zzq;
                    return zzq;
                }
            } catch (Exception e10) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e10.getMessage());
            }
        }
        return null;
    }

    @KeepForSdk
    public Context getModuleContext() {
        return this.zzj;
    }

    @KeepForSdk
    public IBinder instantiate(String str) {
        try {
            return (IBinder) this.zzj.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e10) {
            throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(str)), e10, (zzp) null);
        }
    }
}
