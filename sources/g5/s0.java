package g5;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.mobile.brasiltv.db.LiveSubProgram;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.List;
import t9.i;

public final class s0 extends BaseQuickAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final Context f17103a;

    /* renamed from: b  reason: collision with root package name */
    public final a f17104b;

    public interface a {
        void T(int i10);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s0(Context context, a aVar) {
        super(R.layout.adapter_live_sub_list_item, (List) null);
        i.g(context, f.X);
        this.f17103a = context;
        this.f17104b = aVar;
    }

    public static final void c(s0 s0Var, BaseViewHolder baseViewHolder, View view) {
        i.g(s0Var, "this$0");
        i.g(baseViewHolder, "$helper");
        a aVar = s0Var.f17104b;
        if (aVar != null) {
            aVar.T(baseViewHolder.getAdapterPosition());
        }
    }

    /* renamed from: b */
    public void convert(BaseViewHolder baseViewHolder, LiveSubProgram liveSubProgram) {
        i.g(baseViewHolder, "helper");
        i.g(liveSubProgram, PlistBuilder.KEY_ITEM);
        ((ImageView) baseViewHolder.getView(R.id.iv_live_sub)).setOnClickListener(new r0(this, baseViewHolder));
        baseViewHolder.setText((int) R.id.mTvEPG, (CharSequence) liveSubProgram.getChannelName());
        if (TextUtils.isEmpty(liveSubProgram.getProgramName())) {
            baseViewHolder.setText((int) R.id.mEpgInfo, (CharSequence) this.f17103a.getResources().getString(R.string.live_get_show));
        } else {
            StringBuilder sb = new StringBuilder();
            String substring = liveSubProgram.getStartTime().substring(11);
            i.f(substring, "this as java.lang.String).substring(startIndex)");
            sb.append(substring);
            sb.append(ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER);
            String substring2 = liveSubProgram.getEndTime().substring(11);
            i.f(substring2, "this as java.lang.String).substring(startIndex)");
            sb.append(substring2);
            sb.append(' ');
            sb.append(liveSubProgram.getProgramName());
            baseViewHolder.setText((int) R.id.mEpgInfo, (CharSequence) sb.toString());
        }
        baseViewHolder.addOnClickListener(R.id.mLayoutSubItem);
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        i.g(viewGroup, "parent");
        BaseViewHolder onCreateViewHolder = super.onCreateViewHolder(viewGroup, i10);
        i.f(onCreateViewHolder, "super.onCreateViewHolder(parent, viewType)");
        AutoUtils.autoSize(onCreateViewHolder.convertView);
        return onCreateViewHolder;
    }
}
