package com.umeng.innner.umcrash;

import android.os.Looper;
import java.util.HashMap;
import java.util.Map;

public class UMCrashUtil {
    private static final int MAX_THREAD_TRACE_LENGTH = 20480;
    private static final String TAG = "UMCrashUtil";

    public static Map<String, String> getAllThreadTraces() {
        HashMap hashMap = new HashMap();
        try {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            if (allStackTraces == null) {
                return null;
            }
            Thread thread = Looper.getMainLooper().getThread();
            if (!allStackTraces.containsKey(thread)) {
                allStackTraces.put(thread, thread.getStackTrace());
            }
            long id = Thread.currentThread().getId();
            StringBuilder sb = new StringBuilder();
            for (Map.Entry next : allStackTraces.entrySet()) {
                if (id != ((Thread) next.getKey()).getId()) {
                    int i10 = 0;
                    sb.setLength(0);
                    if (!(next.getValue() == null || ((StackTraceElement[]) next.getValue()).length == 0)) {
                        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) next.getValue();
                        int length = stackTraceElementArr.length;
                        while (true) {
                            if (i10 >= length) {
                                break;
                            }
                            StackTraceElement stackTraceElement = stackTraceElementArr[i10];
                            if (sb.length() >= MAX_THREAD_TRACE_LENGTH) {
                                sb.append("\n[Stack trace size must be less than :");
                                sb.append(MAX_THREAD_TRACE_LENGTH);
                                sb.append("!]");
                                break;
                            }
                            sb.append("  at ");
                            sb.append(stackTraceElement.toString());
                            sb.append("\n");
                            i10++;
                        }
                        hashMap.put(((Thread) next.getKey()).getName() + "(" + ((Thread) next.getKey()).getId() + ")", sb.toString());
                    }
                }
            }
            return hashMap;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
