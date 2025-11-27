package com.umeng.logsdk;

import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.cache.CacheManager;
import com.efs.sdk.base.core.cache.IFileFilter;
import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.core.util.FileUtil;
import com.efs.sdk.base.core.util.Log;
import java.io.File;
import java.util.List;

public class UploadFileFilterCodeLog implements IFileFilter {

    /* renamed from: a  reason: collision with root package name */
    private ULogConfigManager f15178a;

    /* renamed from: b  reason: collision with root package name */
    private b f15179b;

    /* renamed from: c  reason: collision with root package name */
    private String f15180c;

    /* renamed from: d  reason: collision with root package name */
    private int f15181d = -1;

    /* renamed from: e  reason: collision with root package name */
    private String f15182e;

    /* renamed from: f  reason: collision with root package name */
    private int f15183f = -1;

    /* renamed from: g  reason: collision with root package name */
    private long f15184g;

    /* renamed from: h  reason: collision with root package name */
    private long f15185h;

    private void a() {
        Log.i("UploadFileFilterCodeLog", "reset task.");
        this.f15179b = null;
        this.f15180c = null;
        this.f15181d = -1;
        this.f15182e = null;
        this.f15183f = -1;
        this.f15184g = 0;
        this.f15185h = 0;
    }

    public boolean filter(File file) {
        StringBuilder sb;
        String sb2;
        StringBuilder sb3;
        List<b> taskList;
        boolean z10 = false;
        if (this.f15179b == null) {
            ULogConfigManager uLogConfigManager = ULogManager.getULogConfigManager();
            this.f15178a = uLogConfigManager;
            if (uLogConfigManager != null && (taskList = uLogConfigManager.getTaskList()) != null && !taskList.isEmpty()) {
                int i10 = 0;
                while (true) {
                    if (i10 >= taskList.size()) {
                        break;
                    }
                    b bVar = taskList.get(i10);
                    this.f15179b = bVar;
                    if (bVar != null) {
                        int i11 = bVar.f15204b;
                        this.f15181d = i11;
                        if (i11 == 0) {
                            this.f15180c = bVar.f15203a;
                            this.f15182e = bVar.f15206d;
                            this.f15183f = bVar.f15205c;
                            this.f15184g = bVar.f15207e;
                            this.f15185h = bVar.f15208f;
                            break;
                        }
                        a();
                    }
                    i10++;
                }
            }
        }
        if (this.f15179b != null && this.f15181d == 0) {
            Log.i("UploadFileFilterCodeLog", this.f15180c + ", " + this.f15182e + ", " + this.f15183f + ", " + this.f15184g + ", " + this.f15185h);
            String name = file.getName();
            LogDto createLogDtoByName = (TextUtils.isEmpty(name) || !name.startsWith(Constants.LOG_TYPE_CODELOGPERF)) ? FileUtil.createLogDtoByName(name) : FileUtil.createCodeLogDtoByName(name);
            if (createLogDtoByName == null) {
                CacheManager.getInstance().onChangeDtoError(file);
                return true;
            }
            long beginTime = createLogDtoByName.getBeginTime();
            createLogDtoByName.getEndTime();
            String did = createLogDtoByName.getDid();
            String uid = createLogDtoByName.getUid();
            if (beginTime < this.f15184g || beginTime > this.f15185h) {
                sb = new StringBuilder("time is ");
                sb.append(beginTime >= this.f15184g);
                sb.append(", is ");
                if (beginTime <= this.f15185h) {
                    z10 = true;
                }
                sb.append(z10);
                sb2 = sb.toString();
            } else {
                Log.i("UploadFileFilterCodeLog", "task target type is " + this.f15183f);
                int i12 = this.f15183f;
                if (i12 == 1) {
                    if (TextUtils.isEmpty(this.f15182e) || TextUtils.isEmpty(did) || !this.f15182e.equals(did)) {
                        sb2 = "taskTarget is " + this.f15182e + ", did is " + did;
                    } else {
                        sb3 = new StringBuilder("task is ");
                    }
                } else if (i12 == 0) {
                    if (TextUtils.isEmpty(this.f15182e) || TextUtils.isEmpty(uid) || !this.f15182e.equals(uid)) {
                        sb = new StringBuilder("taskTarget is ");
                        sb.append(this.f15182e);
                        sb.append(", uid is ");
                        sb.append(uid);
                        sb2 = sb.toString();
                    } else {
                        sb3 = new StringBuilder("task is ");
                    }
                }
                sb3.append(this.f15180c);
                sb3.append(", target is ");
                sb3.append(this.f15182e);
                sb3.append(", file time is ");
                sb3.append(beginTime);
                Log.i("UploadFileFilterCodeLog", sb3.toString());
                return false;
            }
            Log.i("UploadFileFilterCodeLog", sb2);
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0033, code lost:
        if (r0 != null) goto L_0x0041;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void finish() {
        /*
            r6 = this;
            java.lang.String r0 = "clear task."
            java.lang.String r1 = "UploadFileFilterCodeLog"
            com.efs.sdk.base.core.util.Log.i((java.lang.String) r1, (java.lang.String) r0)
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "taskEndTime is "
            r0.<init>(r4)
            long r4 = r6.f15185h
            r0.append(r4)
            java.lang.String r4 = ", current time is "
            r0.append(r4)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.efs.sdk.base.core.util.Log.i((java.lang.String) r1, (java.lang.String) r0)
            long r4 = r6.f15185h
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0036
            java.lang.String r0 = "future task. not remove."
            com.efs.sdk.base.core.util.Log.i((java.lang.String) r1, (java.lang.String) r0)
            com.umeng.logsdk.ULogConfigManager r0 = r6.f15178a
            if (r0 == 0) goto L_0x0046
            goto L_0x0041
        L_0x0036:
            com.umeng.logsdk.ULogConfigManager r0 = r6.f15178a
            if (r0 == 0) goto L_0x0046
            java.lang.String r1 = r6.f15180c
            r0.reMoveTaskFroSP(r1)
            com.umeng.logsdk.ULogConfigManager r0 = r6.f15178a
        L_0x0041:
            com.umeng.logsdk.b r1 = r6.f15179b
            r0.removeTask(r1)
        L_0x0046:
            r6.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.logsdk.UploadFileFilterCodeLog.finish():void");
    }

    public boolean hasTask() {
        List<b> taskList;
        ULogConfigManager uLogConfigManager = ULogManager.getULogConfigManager();
        if (uLogConfigManager == null || (taskList = uLogConfigManager.getTaskList()) == null || taskList.isEmpty()) {
            return false;
        }
        for (int i10 = 0; i10 < taskList.size(); i10++) {
            b bVar = taskList.get(i10);
            if (bVar != null && bVar.f15204b == 0) {
                return true;
            }
        }
        return false;
    }

    public void finish(boolean z10, boolean z11) {
    }
}
