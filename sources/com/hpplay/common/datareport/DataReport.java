package com.hpplay.common.datareport;

import android.content.Context;
import android.text.TextUtils;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.common.asyncmanager.AsyncRunnableListener;
import com.hpplay.common.log.LeLog;
import com.hpplay.common.perfume.CTCipher;
import com.hpplay.cybergarage.xml.XML;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class DataReport {
    /* access modifiers changed from: private */
    public static final String TAG = "DataReport";
    private static DataReport instance;
    private final int MAX_SEMAPHORE = 5;
    private final int MAX_TASK_SIZE = 50;
    /* access modifiers changed from: private */
    public CTCipher mCTCipher;
    /* access modifiers changed from: private */
    public AtomicInteger mSemaphore = new AtomicInteger(5);
    private ArrayList<ReportRunnable> mTaskList = new ArrayList<>();

    public static abstract class ReportRunnable implements Runnable {
        public ReportBean reportBean;
    }

    private DataReport() {
    }

    private void addTask(ReportBean reportBean, final boolean z10) {
        while (this.mTaskList.size() > 50) {
            this.mTaskList.remove(0);
        }
        AnonymousClass1 r02 = new ReportRunnable() {
            public void run() {
                if (!TextUtils.isEmpty(this.reportBean.httpParameter.in.params) && !TextUtils.isEmpty(this.reportBean.encryptVersion) && DataReport.this.mCTCipher != null) {
                    String str = this.reportBean.httpParameter.in.params;
                    try {
                        str = DataReport.this.mCTCipher.encrypt(str);
                    } catch (Exception e10) {
                        LeLog.w(DataReport.TAG, (Throwable) e10);
                    }
                    AsyncHttpParameter.In in = this.reportBean.httpParameter.in;
                    if (in.requestMethod == 0) {
                        try {
                            str = URLEncoder.encode(str, XML.CHARSET_UTF8);
                        } catch (Exception e11) {
                            LeLog.w(DataReport.TAG, (Throwable) e11);
                        }
                        AsyncHttpParameter.In in2 = this.reportBean.httpParameter.in;
                        in2.params = "v=" + this.reportBean.encryptVersion + "&s=" + str;
                    } else {
                        String str2 = in.requestUrl;
                        if (!TextUtils.isEmpty(str2)) {
                            if (str2.endsWith(Operator.Operation.EMPTY_PARAM)) {
                                StringBuilder sb = new StringBuilder();
                                AsyncHttpParameter.In in3 = this.reportBean.httpParameter.in;
                                sb.append(in3.requestUrl);
                                sb.append("v=");
                                sb.append(this.reportBean.encryptVersion);
                                in3.requestUrl = sb.toString();
                            } else {
                                StringBuilder sb2 = new StringBuilder();
                                AsyncHttpParameter.In in4 = this.reportBean.httpParameter.in;
                                sb2.append(in4.requestUrl);
                                sb2.append("?v=");
                                sb2.append(this.reportBean.encryptVersion);
                                in4.requestUrl = sb2.toString();
                            }
                        }
                        if (z10) {
                            try {
                                str = URLEncoder.encode(str, XML.CHARSET_UTF8);
                            } catch (Exception e12) {
                                LeLog.w(DataReport.TAG, (Throwable) e12);
                            }
                        }
                        this.reportBean.httpParameter.in.params = str;
                    }
                }
                AsyncManager instance = AsyncManager.getInstance();
                ReportBean reportBean = this.reportBean;
                instance.exeHttpTask(reportBean.httpParameter, reportBean.listener);
                DataReport.this.mSemaphore.set(Math.min(5, DataReport.this.mSemaphore.incrementAndGet()));
                DataReport.this.exeTask();
            }
        };
        r02.reportBean = reportBean;
        try {
            this.mTaskList.add(r02);
        } catch (Exception e10) {
            String str = TAG;
            LeLog.w(str, "addTask " + e10);
        }
        exeTask();
    }

    /* access modifiers changed from: private */
    public void exeTask() {
        if (this.mTaskList.size() > 0 && this.mSemaphore.get() > 0) {
            this.mSemaphore.getAndDecrement();
            try {
                AsyncManager.getInstance().exeRunnable(this.mTaskList.remove(0), (AsyncRunnableListener) null);
            } catch (Exception e10) {
                LeLog.w(TAG, (Throwable) e10);
                exeTask();
            }
        } else if (this.mTaskList.size() == 0) {
            this.mSemaphore.set(5);
        }
    }

    public static void initDataReport(Context context, String str) {
        initLocalInstance(context.getApplicationContext(), str);
    }

    private static synchronized void initLocalInstance(Context context, String str) {
        synchronized (DataReport.class) {
            synchronized (DataReport.class) {
                if (instance == null) {
                    instance = new DataReport();
                }
                instance.setEncrypt(str);
            }
        }
    }

    public static void onDataReport(ReportBean reportBean) {
        onDataReport(reportBean, false);
    }

    private void setEncrypt(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mCTCipher = new CTCipher(str);
        }
    }

    public static void onDataReport(ReportBean reportBean, boolean z10) {
        DataReport dataReport = instance;
        if (dataReport == null) {
            LeLog.w(TAG, "onDataReport ignore,must call initDataReport first");
        } else {
            dataReport.addTask(reportBean, z10);
        }
    }
}
