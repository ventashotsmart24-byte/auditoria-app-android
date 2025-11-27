package com.umeng.analytics.process;

import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DBFileTraversalUtil {

    /* renamed from: a  reason: collision with root package name */
    private static ExecutorService f14463a = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static FileLockUtil f14464b = new FileLockUtil();

    public interface a {
        void a();
    }

    public static void traverseDBFiles(String str, final FileLockCallback fileLockCallback, final a aVar) {
        final File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            f14463a.execute(new Runnable() {
                public void run() {
                    try {
                        for (File file : file.listFiles()) {
                            if (file.getName().endsWith(a.f14486d)) {
                                DBFileTraversalUtil.f14464b.doFileOperateion(file, fileLockCallback);
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> file: " + file.getName());
                            }
                        }
                        a aVar = aVar;
                        if (aVar != null) {
                            aVar.a();
                        }
                    } catch (Throwable unused) {
                    }
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> end *** ");
                }
            });
        }
    }
}
