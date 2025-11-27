package com.google.android.gms.internal.cast;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;

public final class zzao {
    public static <R extends Result, T> PendingResult<R> zza(Task<T> task, zzan<R, T> zzan, zzan<R, Status> zzan2) {
        zzam zzam = new zzam(zzan2);
        task.addOnSuccessListener(new zzal(zzam, zzan)).addOnFailureListener(new zzak(zzam, zzan2));
        return zzam;
    }
}
