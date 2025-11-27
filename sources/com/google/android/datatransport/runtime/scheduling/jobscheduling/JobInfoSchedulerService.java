package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.util.PriorityMapping;

public class JobInfoSchedulerService extends JobService {
    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onStartJob$0(JobParameters jobParameters) {
        jobFinished(jobParameters, false);
    }

    public boolean onStartJob(JobParameters jobParameters) {
        String a10 = jobParameters.getExtras().getString("backendName");
        String a11 = jobParameters.getExtras().getString("extras");
        int a12 = jobParameters.getExtras().getInt("priority");
        int a13 = jobParameters.getExtras().getInt("attemptNumber");
        TransportRuntime.initialize(getApplicationContext());
        TransportContext.Builder priority = TransportContext.builder().setBackendName(a10).setPriority(PriorityMapping.valueOf(a12));
        if (a11 != null) {
            priority.setExtras(Base64.decode(a11, 0));
        }
        TransportRuntime.getInstance().getUploader().upload(priority.build(), a13, new f(this, jobParameters));
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
