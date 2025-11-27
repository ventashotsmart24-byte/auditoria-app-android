package n6;

import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.msandroid.mobile.R;
import mobile.com.requestframe.utils.response.SimpleProgramList;
import t9.i;

public final class d extends a {
    public d() {
        super(R.layout.adapter_select_tv_program);
    }

    /* renamed from: d */
    public void convert(BaseViewHolder baseViewHolder, SimpleProgramList simpleProgramList) {
        i.g(baseViewHolder, "helper");
        i.g(simpleProgramList, PlistBuilder.KEY_ITEM);
        baseViewHolder.setText((int) R.id.text_set, (CharSequence) String.valueOf(simpleProgramList.getSeriesNumber()));
        if (simpleProgramList.isPlayed()) {
            baseViewHolder.setVisible(R.id.text_set, false);
            baseViewHolder.setVisible(R.id.img_play, true);
            baseViewHolder.convertView.setSelected(true);
            return;
        }
        baseViewHolder.setVisible(R.id.text_set, true);
        baseViewHolder.setVisible(R.id.img_play, false);
        baseViewHolder.convertView.setSelected(false);
    }
}
