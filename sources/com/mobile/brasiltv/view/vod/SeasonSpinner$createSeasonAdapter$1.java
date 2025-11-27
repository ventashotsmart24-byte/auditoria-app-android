package com.mobile.brasiltv.view.vod;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.msandroid.mobile.R;
import java.util.List;
import mobile.com.requestframe.utils.response.ProgramSeason;
import t9.i;

public final class SeasonSpinner$createSeasonAdapter$1 extends ArrayAdapter<ProgramSeason> {
    private LayoutInflater inflater = LayoutInflater.from(getContext());
    final /* synthetic */ SeasonSpinner this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SeasonSpinner$createSeasonAdapter$1(List<ProgramSeason> list, SeasonSpinner seasonSpinner, Context context) {
        super(context, R.layout.item_pop_season, list);
        this.this$0 = seasonSpinner;
    }

    public View getView(int i10, View view, ViewGroup viewGroup) {
        boolean z10;
        i.g(viewGroup, "parent");
        if (view == null) {
            LayoutInflater layoutInflater = this.inflater;
            if (layoutInflater != null) {
                view = layoutInflater.inflate(R.layout.item_pop_season, viewGroup, false);
            } else {
                view = null;
            }
        }
        i.d(view);
        View findViewById = view.findViewById(R.id.tv_season);
        i.f(findViewById, "view!!.findViewById(R.id.tv_season)");
        TextView textView = (TextView) findViewById;
        AbsSeasonAdapter access$getMSeasonAdapter$p = this.this$0.mSeasonAdapter;
        if (access$getMSeasonAdapter$p != null) {
            access$getMSeasonAdapter$p.update(textView, (ProgramSeason) getItem(i10));
        }
        View findViewById2 = view.findViewById(R.id.iv_selector);
        i.f(findViewById2, "view.findViewById(R.id.iv_selector)");
        ImageView imageView = (ImageView) findViewById2;
        AbsSeasonAdapter access$getMSeasonAdapter$p2 = this.this$0.mSeasonAdapter;
        if (access$getMSeasonAdapter$p2 == null || i10 != access$getMSeasonAdapter$p2.getSelectedIndex()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            imageView.setImageResource(R.drawable.ic_season_checked);
        } else {
            imageView.setImageResource(0);
        }
        return view;
    }
}
