package com.mobile.brasiltv.view.dialog;

import com.mobile.brasiltv.bean.SubtitleManager;
import g5.l3;
import h9.t;
import s9.l;
import t9.j;

public final class SubtitleOptionsDialog$initView$1 extends j implements l {
    final /* synthetic */ SubtitleOptionsDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubtitleOptionsDialog$initView$1(SubtitleOptionsDialog subtitleOptionsDialog) {
        super(1);
        this.this$0 = subtitleOptionsDialog;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return t.f17319a;
    }

    public final void invoke(int i10) {
        String optionType = this.this$0.getOptionType();
        int hashCode = optionType.hashCode();
        if (hashCode != -2091952084) {
            if (hashCode != -2079692355) {
                if (hashCode == -1949434365 && optionType.equals(SubtitleManager.GLOBAL_SUBTITLE_LANGUAGE)) {
                    SubtitleManager.INSTANCE.setMGlobalLanguage(i10);
                }
            } else if (optionType.equals(SubtitleManager.GLOBAL_AUDIO_LANGUAGE)) {
                SubtitleManager.INSTANCE.setMGlobalAudioLanguage(i10);
            }
        } else if (optionType.equals(SubtitleManager.GLOBAL_SUBTITLE_SIZE)) {
            SubtitleManager.INSTANCE.setMGlobalSize(i10);
        }
        l3 access$getMAdapter$p = this.this$0.mAdapter;
        if (access$getMAdapter$p != null) {
            access$getMAdapter$p.e(i10);
        }
        l3 access$getMAdapter$p2 = this.this$0.mAdapter;
        if (access$getMAdapter$p2 != null) {
            access$getMAdapter$p2.notifyDataSetChanged();
        }
        this.this$0.cancel();
    }
}
