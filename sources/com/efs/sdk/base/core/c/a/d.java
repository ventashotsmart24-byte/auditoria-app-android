package com.efs.sdk.base.core.c.a;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.c.b;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.processor.action.ILogEncryptAction;

public final class d extends a {

    /* renamed from: b  reason: collision with root package name */
    private ILogEncryptAction f5173b;

    public d() {
        if (ControllerCenter.getGlobalEnvStruct().getLogEncryptAction() == null) {
            this.f5173b = new b();
        } else {
            this.f5173b = ControllerCenter.getGlobalEnvStruct().getLogEncryptAction();
        }
    }

    public final void a(LogDto logDto) {
        boolean z10 = true;
        if (!logDto.isDe() && !"wa".equals(logDto.getLogType()) && Constants.LOG_TYPE_CODELOGPERF.equals(logDto.getLogType()) && 1 != logDto.getLogBodyType()) {
            z10 = false;
        }
        if (z10) {
            b(logDto);
            return;
        }
        byte[] encrypt = this.f5173b.encrypt(ControllerCenter.getGlobalEnvStruct().getSecret(), logDto.getData());
        if (encrypt != null) {
            logDto.setData(encrypt);
            logDto.setDe(this.f5173b.getDeVal());
        }
        b(logDto);
    }
}
