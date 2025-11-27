package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.SubtitleManager;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import g5.l3;
import t9.g;
import t9.i;

public final class SubtitleOptionsDialog extends CommonDialog {
    /* access modifiers changed from: private */
    public l3 mAdapter;
    private String optionType;
    private String[] options;
    private String title;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubtitleOptionsDialog(Context context, String str, String[] strArr, String str2, int i10, int i11, g gVar) {
        this(context, str, strArr, str2, (i11 & 16) != 0 ? R.style.SubtitleOptionDialog : i10);
    }

    private final int getIndex() {
        String str = this.optionType;
        int hashCode = str.hashCode();
        if (hashCode != -2091952084) {
            if (hashCode != -2079692355) {
                if (hashCode == -1949434365 && str.equals(SubtitleManager.GLOBAL_SUBTITLE_LANGUAGE)) {
                    return SubtitleManager.INSTANCE.getMGlobalLanguage();
                }
            } else if (str.equals(SubtitleManager.GLOBAL_AUDIO_LANGUAGE)) {
                return SubtitleManager.INSTANCE.getMGlobalAudioLanguage();
            }
        } else if (str.equals(SubtitleManager.GLOBAL_SUBTITLE_SIZE)) {
            return SubtitleManager.INSTANCE.getMGlobalSize();
        }
        return 0;
    }

    public int getDialogHeight() {
        return 450;
    }

    public int getDialogWidth() {
        return 600;
    }

    public int getLayoutId() {
        return R.layout.dialog_subtitle;
    }

    public final String getOptionType() {
        return this.optionType;
    }

    public final String[] getOptions() {
        return this.options;
    }

    public final String getTitle() {
        return this.title;
    }

    public void initListener() {
    }

    public void initView() {
        setCancelable(true);
        ((TextView) findViewById(R$id.mTvTitle)).setText(this.title);
        Context context = getContext();
        i.f(context, f.X);
        l3 l3Var = new l3(context, this.options, new SubtitleOptionsDialog$initView$1(this));
        this.mAdapter = l3Var;
        l3Var.e(getIndex());
        int i10 = R$id.mRvOptions;
        ((RecyclerView) findViewById(i10)).setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        ((RecyclerView) findViewById(i10)).setAdapter(this.mAdapter);
        l3 l3Var2 = this.mAdapter;
        if (l3Var2 != null) {
            l3Var2.notifyDataSetChanged();
        }
    }

    public final void setOptionType(String str) {
        i.g(str, "<set-?>");
        this.optionType = str;
    }

    public final void setOptions(String[] strArr) {
        i.g(strArr, "<set-?>");
        this.options = strArr;
    }

    public final void setTitle(String str) {
        i.g(str, "<set-?>");
        this.title = str;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubtitleOptionsDialog(Context context, String str, String[] strArr, String str2, int i10) {
        super(context, i10);
        i.g(context, f.X);
        i.g(str, "title");
        i.g(strArr, "options");
        i.g(str2, "optionType");
        this.title = str;
        this.options = strArr;
        this.optionType = str2;
    }
}
