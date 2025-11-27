package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import e1.v;
import e1.w;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;

public class JobInfoScheduler implements WorkScheduler {
    static final String ATTEMPT_NUMBER = "attemptNumber";
    static final String BACKEND_NAME = "backendName";
    static final String EVENT_PRIORITY = "priority";
    static final String EXTRAS = "extras";
    private static final String LOG_TAG = "JobInfoScheduler";
    private final SchedulerConfig config;
    private final Context context;
    private final EventStore eventStore;

    public JobInfoScheduler(Context context2, EventStore eventStore2, SchedulerConfig schedulerConfig) {
        this.context = context2;
        this.eventStore = eventStore2;
        this.config = schedulerConfig;
    }

    private boolean isJobServiceOn(JobScheduler jobScheduler, int i10, int i11) {
        for (Object a10 : jobScheduler.getAllPendingJobs()) {
            JobInfo a11 = w.a(a10);
            int a12 = a11.getExtras().getInt(ATTEMPT_NUMBER);
            if (a11.getId() == i10) {
                if (a12 >= i11) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public int getJobId(TransportContext transportContext) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.context.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(transportContext.getBackendName().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(PriorityMapping.toInt(transportContext.getPriority())).array());
        if (transportContext.getExtras() != null) {
            adler32.update(transportContext.getExtras());
        }
        return (int) adler32.getValue();
    }

    public void schedule(TransportContext transportContext, int i10) {
        schedule(transportContext, i10, false);
    }

    public void schedule(TransportContext transportContext, int i10, boolean z10) {
        ComponentName componentName = new ComponentName(this.context, JobInfoSchedulerService.class);
        JobScheduler a10 = v.a(this.context.getSystemService("jobscheduler"));
        int jobId = getJobId(transportContext);
        if (z10 || !isJobServiceOn(a10, jobId, i10)) {
            long nextCallTime = this.eventStore.getNextCallTime(transportContext);
            JobInfo.Builder configureJob = this.config.configureJob(new JobInfo.Builder(jobId, componentName), transportContext.getPriority(), nextCallTime, i10);
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putInt(ATTEMPT_NUMBER, i10);
            persistableBundle.putString(BACKEND_NAME, transportContext.getBackendName());
            persistableBundle.putInt(EVENT_PRIORITY, PriorityMapping.toInt(transportContext.getPriority()));
            if (transportContext.getExtras() != null) {
                persistableBundle.putString(EXTRAS, Base64.encodeToString(transportContext.getExtras(), 0));
            }
            JobInfo.Builder unused = configureJob.setExtras(persistableBundle);
            Logging.d(LOG_TAG, "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", transportContext, Integer.valueOf(jobId), Long.valueOf(this.config.getScheduleDelay(transportContext.getPriority(), nextCallTime, i10)), Long.valueOf(nextCallTime), Integer.valueOf(i10));
            int unused2 = a10.schedule(configureJob.build());
            return;
        }
        Logging.d(LOG_TAG, "Upload for context %s is already scheduled. Returning...", (Object) transportContext);
    }
}
