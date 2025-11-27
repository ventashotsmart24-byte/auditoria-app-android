package com.mobile.brasiltv.view;

import android.content.Context;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;

public class MoreTextView extends AutoLinearLayout {
    private static final int LIMIT_LINES = 1000;
    /* access modifiers changed from: private */
    public boolean isFoldUp;
    /* access modifiers changed from: private */
    public String mLessStr;
    /* access modifiers changed from: private */
    public int mMaxLine;
    /* access modifiers changed from: private */
    public String mText;
    /* access modifiers changed from: private */
    public TextView mTvContent;
    /* access modifiers changed from: private */
    public TextView mTvMore;

    public MoreTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public void setEllipsis() {
        Layout layout = this.mTvContent.getLayout();
        if (layout != null) {
            boolean z10 = true;
            int ellipsisCount = layout.getEllipsisCount(this.mTvContent.getLineCount() - 1);
            int i10 = 0;
            if (this.mTvContent.getLineCount() <= this.mTvContent.getMaxLines() && ellipsisCount == 0) {
                z10 = false;
            }
            this.isFoldUp = z10;
            TextView textView = this.mTvMore;
            if (!z10) {
                i10 = 8;
            }
            textView.setVisibility(i10);
            this.mTvMore.setText(R.string.view_more);
            if (z10) {
                String str = this.mText;
                int lineEnd = new StaticLayout(str, 0, str.length(), this.mTvContent.getPaint(), this.mTvContent.getMeasuredWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true).getLineEnd(2);
                if (lineEnd > 210) {
                    lineEnd = 210;
                }
                subStringWithText(this.mTvContent, this.mText, lineEnd - 6, this.mTvMore.getText().toString());
                setMoreMargin();
            }
        }
    }

    /* access modifiers changed from: private */
    public void setMoreMargin() {
        if (this.isFoldUp) {
            AutoLinearLayout.LayoutParams layoutParams = new AutoLinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = -AutoUtils.getPercentHeightSize(36);
            layoutParams.gravity = 5;
            this.mTvMore.setLayoutParams(layoutParams);
            return;
        }
        AutoLinearLayout.LayoutParams layoutParams2 = new AutoLinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = 0;
        layoutParams2.gravity = 5;
        this.mTvMore.setLayoutParams(layoutParams2);
    }

    private void subStringWithText(TextView textView, String str, int i10, String str2) {
        while (true) {
            String substring = str.substring(0, i10);
            textView.setText(substring + "...." + str2);
            Layout layout = textView.getLayout();
            if (layout.getEllipsisCount(layout.getLineCount() - 1) > 0) {
                i10 -= 2;
            } else {
                String str3 = substring + "...";
                this.mLessStr = str3;
                textView.setText(str3);
                return;
            }
        }
    }

    public void setMaxLine(int i10) {
        this.mMaxLine = i10;
        this.mTvContent.setMaxLines(i10);
    }

    public void setMoreText(String str) {
        this.mText = str;
        if (TextUtils.isEmpty(str)) {
            this.mTvMore.setVisibility(8);
            return;
        }
        this.mTvContent.setText(str);
        this.mTvContent.post(new Runnable() {
            public void run() {
                MoreTextView.this.setEllipsis();
            }
        });
    }

    public MoreTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MoreTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mMaxLine = 3;
        this.isFoldUp = false;
        this.mText = "";
        this.mLessStr = "";
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.layout_more_text, this, true);
        TextView textView = (TextView) findViewById(R.id.tv_content);
        this.mTvContent = textView;
        textView.setMaxLines(this.mMaxLine);
        TextView textView2 = (TextView) findViewById(R.id.tv_more);
        this.mTvMore = textView2;
        textView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (MoreTextView.this.isFoldUp) {
                    MoreTextView.this.mTvMore.setText(R.string.pack_up);
                    MoreTextView.this.mTvContent.setMaxLines(1000);
                    MoreTextView.this.mTvContent.setText(MoreTextView.this.mText);
                } else {
                    MoreTextView.this.mTvMore.setText(R.string.view_more);
                    MoreTextView.this.mTvContent.setMaxLines(MoreTextView.this.mMaxLine);
                    MoreTextView.this.mTvContent.setText(MoreTextView.this.mLessStr);
                }
                MoreTextView moreTextView = MoreTextView.this;
                moreTextView.isFoldUp = !moreTextView.isFoldUp;
                MoreTextView.this.setMoreMargin();
            }
        });
    }
}
