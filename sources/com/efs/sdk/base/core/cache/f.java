package com.efs.sdk.base.core.cache;

import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.b.c;
import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.core.util.FileUtil;
import java.io.File;

public final class f implements IFileFilter {
    public final boolean filter(File file) {
        LogDto logDto;
        String name = file.getName();
        if (TextUtils.isEmpty(name) || !name.startsWith(Constants.LOG_TYPE_CODELOGPERF)) {
            logDto = FileUtil.createLogDtoByName(name);
        } else {
            logDto = FileUtil.createCodeLogDtoByName(name);
        }
        if (logDto == null) {
            CacheManager.getInstance().onChangeDtoError(file);
            return true;
        } else if ("wa".equals(logDto.getLogType()) || c.a().a(logDto.getLogType(), file.length())) {
            return false;
        } else {
            return true;
        }
    }

    public final void finish() {
    }

    public final boolean hasTask() {
        return false;
    }

    public final void finish(boolean z10, boolean z11) {
    }
}
