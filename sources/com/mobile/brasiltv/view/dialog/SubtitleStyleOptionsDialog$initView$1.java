package com.mobile.brasiltv.view.dialog;

import com.mobile.brasiltv.bean.SubtitleManager;
import g5.n3;
import h9.t;
import s9.l;
import t9.i;
import t9.j;

public final class SubtitleStyleOptionsDialog$initView$1 extends j implements l {
    final /* synthetic */ SubtitleStyleOptionsDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubtitleStyleOptionsDialog$initView$1(SubtitleStyleOptionsDialog subtitleStyleOptionsDialog) {
        super(1);
        this.this$0 = subtitleStyleOptionsDialog;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return t.f17319a;
    }

    public final void invoke(int i10) {
        if (i.b(this.this$0.getOptionType(), SubtitleManager.GLOBAL_SUBTITLE_COLOR)) {
            SubtitleManager.INSTANCE.setMGlobalColor(i10);
        }
        n3 access$getMAdapter$p = this.this$0.mAdapter;
        if (access$getMAdapter$p != null) {
            access$getMAdapter$p.e(i10);
        }
        n3 access$getMAdapter$p2 = this.this$0.mAdapter;
        if (access$getMAdapter$p2 != null) {
            access$getMAdapter$p2.notifyDataSetChanged();
        }
        this.this$0.cancel();
    }
}
