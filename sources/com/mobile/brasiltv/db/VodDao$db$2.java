package com.mobile.brasiltv.db;

import s9.a;
import t9.j;

public final class VodDao$db$2 extends j implements a {
    final /* synthetic */ VodDao this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VodDao$db$2(VodDao vodDao) {
        super(0);
        this.this$0 = vodDao;
    }

    public final ra.a invoke() {
        return ra.a.b(this.this$0.ctx, this.this$0.DATABASE_NAME, this.this$0.DUBUG_MODEL, this.this$0.DB_VERSION, this.this$0);
    }
}
