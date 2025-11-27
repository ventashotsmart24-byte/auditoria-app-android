package com.mobile.brasiltv.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;
import h9.g;
import h9.h;
import java.util.ArrayList;
import t9.i;

public final class DropDownPop extends PopupWindow {
    private Context context;
    private final g mAdapter$delegate = h.b(new DropDownPop$mAdapter$2(this));
    private ListView mListView;
    private OnItemClickListener mListener;

    public static final class MyAdapter extends BaseAdapter {
        private Context context;
        private ArrayList<SwitchAccountBean> mData = new ArrayList<>();
        private OnItemClickListener mListener;
        private int mSelection;

        public MyAdapter(Context context2) {
            i.g(context2, f.X);
            this.context = context2;
        }

        /* access modifiers changed from: private */
        public static final void getView$lambda$0(MyAdapter myAdapter, int i10, TextView textView, SwitchAccountBean switchAccountBean, View view) {
            i.g(myAdapter, "this$0");
            i.g(textView, "$textView");
            i.g(switchAccountBean, "$bean");
            OnItemClickListener onItemClickListener = myAdapter.mListener;
            if (onItemClickListener != null) {
                onItemClickListener.onItemRemoveClick(i10, textView.getText().toString(), switchAccountBean);
            }
        }

        public final Context getContext() {
            return this.context;
        }

        public int getCount() {
            return this.mData.size();
        }

        public final ArrayList<SwitchAccountBean> getData() {
            return this.mData;
        }

        public Object getItem(int i10) {
            SwitchAccountBean switchAccountBean = this.mData.get(i10);
            i.f(switchAccountBean, "mData[position]");
            return switchAccountBean;
        }

        public long getItemId(int i10) {
            return (long) i10;
        }

        public final OnItemClickListener getMListener() {
            return this.mListener;
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x008f, code lost:
            if (r3.equals("4") == false) goto L_0x00c7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0098, code lost:
            if (r3.equals("3") == false) goto L_0x00c7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x009b, code lost:
            r0.setImageResource(com.msandroid.mobile.R.mipmap.ic_spinner_type_phone);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x00b8, code lost:
            if (r3.equals("1") == false) goto L_0x00c7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00bb, code lost:
            r0.setImageResource(com.msandroid.mobile.R.mipmap.ic_spinner_type_id);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x007d, code lost:
            if (r3.equals(com.titans.entity.CdnType.DIGITAL_TYPE_PEERSTAR) == false) goto L_0x00c7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0086, code lost:
            if (r3.equals(com.titans.entity.CdnType.DIGITAL_TYPE_PCDN) == false) goto L_0x00c7;
         */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0145  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.view.View getView(int r8, android.view.View r9, android.view.ViewGroup r10) {
            /*
                r7 = this;
                java.util.ArrayList<com.mobile.brasiltv.db.SwitchAccountBean> r9 = r7.mData
                java.lang.Object r9 = r9.get(r8)
                java.lang.String r10 = "mData[position]"
                t9.i.f(r9, r10)
                com.mobile.brasiltv.db.SwitchAccountBean r9 = (com.mobile.brasiltv.db.SwitchAccountBean) r9
                com.zhy.autolayout.AutoLinearLayout r10 = new com.zhy.autolayout.AutoLinearLayout
                android.content.Context r0 = r7.context
                r10.<init>(r0)
                android.widget.AbsListView$LayoutParams r0 = new android.widget.AbsListView$LayoutParams
                r1 = 88
                int r1 = com.zhy.autolayout.utils.AutoUtils.getPercentWidthSize(r1)
                r2 = -1
                r0.<init>(r2, r1)
                r1 = 16
                r10.setGravity(r1)
                r10.setLayoutParams(r0)
                android.widget.ImageView r0 = new android.widget.ImageView
                android.content.Context r3 = r7.context
                r0.<init>(r3)
                com.zhy.autolayout.AutoLinearLayout$LayoutParams r3 = new com.zhy.autolayout.AutoLinearLayout$LayoutParams
                r4 = 58
                int r5 = com.zhy.autolayout.utils.AutoUtils.getPercentWidthSize(r4)
                int r4 = com.zhy.autolayout.utils.AutoUtils.getPercentHeightSize(r4)
                r3.<init>((int) r5, (int) r4)
                r4 = 20
                int r4 = com.zhy.autolayout.utils.AutoUtils.getPercentWidthSize(r4)
                r3.leftMargin = r4
                int r4 = com.zhy.autolayout.utils.AutoUtils.getPercentWidthSize(r1)
                r3.rightMargin = r4
                r0.setLayoutParams(r3)
                r10.addView(r0)
                java.lang.String r3 = r9.getAccountType()
                int r4 = r3.hashCode()
                r5 = -1240244679(0xffffffffb6135e39, float:-2.1959552E-6)
                r6 = 2131623966(0x7f0e001e, float:1.8875098E38)
                if (r4 == r5) goto L_0x00bf
                switch(r4) {
                    case 49: goto L_0x00b2;
                    case 50: goto L_0x00a2;
                    case 51: goto L_0x0092;
                    case 52: goto L_0x0089;
                    case 53: goto L_0x0080;
                    case 54: goto L_0x0077;
                    case 55: goto L_0x0067;
                    default: goto L_0x0065;
                }
            L_0x0065:
                goto L_0x00c7
            L_0x0067:
                java.lang.String r4 = "7"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x0070
                goto L_0x00c7
            L_0x0070:
                r3 = 2131623968(0x7f0e0020, float:1.8875102E38)
                r0.setImageResource(r3)
                goto L_0x00d1
            L_0x0077:
                java.lang.String r4 = "6"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x00bb
                goto L_0x00c7
            L_0x0080:
                java.lang.String r4 = "5"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x009b
                goto L_0x00c7
            L_0x0089:
                java.lang.String r4 = "4"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x009b
                goto L_0x00c7
            L_0x0092:
                java.lang.String r4 = "3"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x009b
                goto L_0x00c7
            L_0x009b:
                r3 = 2131623967(0x7f0e001f, float:1.88751E38)
                r0.setImageResource(r3)
                goto L_0x00d1
            L_0x00a2:
                java.lang.String r4 = "2"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x00ab
                goto L_0x00c7
            L_0x00ab:
                r3 = 2131623964(0x7f0e001c, float:1.8875094E38)
                r0.setImageResource(r3)
                goto L_0x00d1
            L_0x00b2:
                java.lang.String r4 = "1"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x00bb
                goto L_0x00c7
            L_0x00bb:
                r0.setImageResource(r6)
                goto L_0x00d1
            L_0x00bf:
                java.lang.String r4 = "google"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L_0x00cb
            L_0x00c7:
                r0.setImageResource(r6)
                goto L_0x00d1
            L_0x00cb:
                r3 = 2131623965(0x7f0e001d, float:1.8875096E38)
                r0.setImageResource(r3)
            L_0x00d1:
                android.widget.TextView r0 = new android.widget.TextView
                android.content.Context r3 = r7.context
                r0.<init>(r3)
                r0.setSingleLine()
                android.content.Context r3 = r7.context
                android.content.res.Resources r3 = r3.getResources()
                r4 = 2131099926(0x7f060116, float:1.781222E38)
                int r3 = r3.getColor(r4)
                r0.setTextColor(r3)
                r0.setGravity(r1)
                android.text.TextUtils$TruncateAt r1 = android.text.TextUtils.TruncateAt.END
                r0.setEllipsize(r1)
                r1 = 32
                int r3 = com.zhy.autolayout.utils.AutoUtils.getPercentWidthSize(r1)
                float r3 = (float) r3
                r4 = 0
                r0.setTextSize(r4, r3)
                com.zhy.autolayout.AutoLinearLayout$LayoutParams r3 = new com.zhy.autolayout.AutoLinearLayout$LayoutParams
                r3.<init>((int) r4, (int) r2)
                r2 = 1065353216(0x3f800000, float:1.0)
                r3.weight = r2
                r0.setLayoutParams(r3)
                r10.addView(r0)
                java.lang.String r2 = r9.getShowName()
                r0.setText(r2)
                android.widget.ImageView r2 = new android.widget.ImageView
                android.content.Context r3 = r7.context
                r2.<init>(r3)
                r3 = 2131231385(0x7f080299, float:1.807885E38)
                r2.setImageResource(r3)
                com.zhy.autolayout.AutoLinearLayout$LayoutParams r3 = new com.zhy.autolayout.AutoLinearLayout$LayoutParams
                r5 = 40
                int r6 = com.zhy.autolayout.utils.AutoUtils.getPercentWidthSize(r5)
                int r5 = com.zhy.autolayout.utils.AutoUtils.getPercentHeightSize(r5)
                r3.<init>((int) r6, (int) r5)
                int r5 = com.zhy.autolayout.utils.AutoUtils.getPercentWidthSize(r1)
                r3.leftMargin = r5
                int r1 = com.zhy.autolayout.utils.AutoUtils.getPercentWidthSize(r1)
                r3.rightMargin = r1
                r2.setLayoutParams(r3)
                boolean r1 = r9.isLogged()
                if (r1 == 0) goto L_0x0147
                r4 = 8
            L_0x0147:
                r2.setVisibility(r4)
                r10.addView(r2)
                com.mobile.brasiltv.view.i r1 = new com.mobile.brasiltv.view.i
                r1.<init>(r7, r8, r0, r9)
                r2.setOnClickListener(r1)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.view.DropDownPop.MyAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
        }

        public final void setContext(Context context2) {
            i.g(context2, "<set-?>");
            this.context = context2;
        }

        public final void setData(ArrayList<SwitchAccountBean> arrayList) {
            i.g(arrayList, "data");
            this.mData.clear();
            this.mData.addAll(arrayList);
            notifyDataSetChanged();
        }

        public final void setMListener(OnItemClickListener onItemClickListener) {
            this.mListener = onItemClickListener;
        }

        public final void setSelection(int i10) {
            this.mSelection = i10;
            notifyDataSetChanged();
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int i10, SwitchAccountBean switchAccountBean);

        void onItemRemoveClick(int i10, String str, SwitchAccountBean switchAccountBean);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DropDownPop(Context context2) {
        super(context2);
        i.g(context2, f.X);
        this.context = context2;
        initView();
    }

    private final MyAdapter getMAdapter() {
        return (MyAdapter) this.mAdapter$delegate.getValue();
    }

    private final void initView() {
        setFocusable(true);
        setBackgroundDrawable(new BitmapDrawable());
        setWidth(AutoUtils.getPercentWidthSize(660));
        setHeight(-2);
        ListView listView = new ListView(this.context);
        this.mListView = listView;
        listView.setFocusable(true);
        AutoLinearLayout.LayoutParams layoutParams = new AutoLinearLayout.LayoutParams(-1, -2);
        ListView listView2 = this.mListView;
        ListView listView3 = null;
        if (listView2 == null) {
            i.w("mListView");
            listView2 = null;
        }
        listView2.setLayoutParams(layoutParams);
        ListView listView4 = this.mListView;
        if (listView4 == null) {
            i.w("mListView");
            listView4 = null;
        }
        listView4.setBackgroundResource(R.drawable.bg_associate_email);
        ListView listView5 = this.mListView;
        if (listView5 == null) {
            i.w("mListView");
            listView5 = null;
        }
        listView5.setDividerHeight(0);
        ListView listView6 = this.mListView;
        if (listView6 == null) {
            i.w("mListView");
            listView6 = null;
        }
        setContentView(listView6);
        ListView listView7 = this.mListView;
        if (listView7 == null) {
            i.w("mListView");
            listView7 = null;
        }
        listView7.setAdapter(getMAdapter());
        ListView listView8 = this.mListView;
        if (listView8 == null) {
            i.w("mListView");
        } else {
            listView3 = listView8;
        }
        listView3.setOnItemClickListener(new h(this));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$0(DropDownPop dropDownPop, AdapterView adapterView, View view, int i10, long j10) {
        i.g(dropDownPop, "this$0");
        OnItemClickListener onItemClickListener = dropDownPop.mListener;
        if (onItemClickListener != null) {
            SwitchAccountBean switchAccountBean = dropDownPop.getMAdapter().getData().get(i10);
            i.f(switchAccountBean, "mAdapter.getData()[position]");
            onItemClickListener.onItemClick(i10, switchAccountBean);
        }
        dropDownPop.dismiss();
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context2) {
        i.g(context2, "<set-?>");
        this.context = context2;
    }

    public final void setData(ArrayList<SwitchAccountBean> arrayList) {
        i.g(arrayList, "data");
        getMAdapter().setData(arrayList);
    }

    public final void setItemClickListener(OnItemClickListener onItemClickListener) {
        i.g(onItemClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.mListener = onItemClickListener;
        getMAdapter().setMListener(onItemClickListener);
    }
}
