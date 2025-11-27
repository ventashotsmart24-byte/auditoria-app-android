package g5;

import android.content.Context;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.List;
import mobile.com.requestframe.utils.response.Program;
import t9.i;

public final class k0 extends BaseQuickAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final Context f16962a;

    /* renamed from: b  reason: collision with root package name */
    public final a f16963b;

    /* renamed from: c  reason: collision with root package name */
    public int f16964c = -1;

    public interface a {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k0(Context context, a aVar) {
        super(R.layout.adapter_live_epg_item, (List) null);
        i.g(context, f.X);
        this.f16962a = context;
        this.f16963b = aVar;
    }

    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, Program program) {
        i.g(baseViewHolder, "helper");
        i.g(program, PlistBuilder.KEY_ITEM);
        if (baseViewHolder.getLayoutPosition() == this.f16964c) {
            b(baseViewHolder);
        } else {
            c(baseViewHolder);
        }
        StringBuilder sb = new StringBuilder();
        String substring = program.getStartTime().substring(11, 16);
        i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        sb.append(substring);
        sb.append(ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER);
        String substring2 = program.getEndTime().substring(11, 16);
        i.f(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
        sb.append(substring2);
        baseViewHolder.setText((int) R.id.mTextTime, (CharSequence) sb.toString());
        baseViewHolder.setText((int) R.id.mTextEpgProgram, (CharSequence) program.getProgramName());
        baseViewHolder.addOnClickListener(R.id.mLayoutEpgItem);
    }

    public final void b(BaseViewHolder baseViewHolder) {
        baseViewHolder.setTextColor(R.id.mTextTime, this.f16962a.getResources().getColor(R.color.color_important));
        baseViewHolder.setTextColor(R.id.mTextEpgProgram, this.f16962a.getResources().getColor(R.color.color_important));
        baseViewHolder.setBackgroundColor(R.id.mLayoutEpgItem, this.f16962a.getResources().getColor(R.color.color_161720));
    }

    public final void c(BaseViewHolder baseViewHolder) {
        baseViewHolder.setTextColor(R.id.mTextTime, this.f16962a.getResources().getColor(R.color.color_ffffff));
        baseViewHolder.setTextColor(R.id.mTextEpgProgram, this.f16962a.getResources().getColor(R.color.color_ffffff));
        baseViewHolder.setBackgroundColor(R.id.mLayoutEpgItem, this.f16962a.getResources().getColor(R.color.color_1f202a));
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        i.g(viewGroup, "parent");
        BaseViewHolder onCreateViewHolder = super.onCreateViewHolder(viewGroup, i10);
        i.f(onCreateViewHolder, "super.onCreateViewHolder(parent, viewType)");
        AutoUtils.autoSize(onCreateViewHolder.convertView);
        return onCreateViewHolder;
    }
}
