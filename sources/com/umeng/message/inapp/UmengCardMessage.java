package com.umeng.message.inapp;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.firebase.messaging.Constants;
import com.hpplay.sdk.source.common.global.Constant;
import com.umeng.message.entity.UInAppMessage;
import com.umeng.message.proguard.a;
import com.umeng.message.proguard.aj;
import com.umeng.message.proguard.bo;
import com.umeng.message.proguard.br;
import com.umeng.message.proguard.f;
import org.json.JSONObject;

public final class UmengCardMessage extends DialogFragment {

    /* renamed from: b  reason: collision with root package name */
    private static final String f15255b = "com.umeng.message.inapp.UmengCardMessage";

    /* renamed from: a  reason: collision with root package name */
    public IUmengInAppMsgCloseCallback f15256a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Activity f15257c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public UInAppMessage f15258d;

    /* renamed from: e  reason: collision with root package name */
    private String f15259e;

    /* renamed from: f  reason: collision with root package name */
    private Bitmap f15260f;

    /* renamed from: g  reason: collision with root package name */
    private ViewGroup f15261g;

    /* renamed from: h  reason: collision with root package name */
    private int f15262h;

    /* renamed from: i  reason: collision with root package name */
    private int f15263i;

    /* renamed from: j  reason: collision with root package name */
    private int f15264j;

    /* renamed from: k  reason: collision with root package name */
    private int f15265k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public UInAppHandler f15266l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f15267m = false;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public boolean f15268n = false;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public boolean f15269o = false;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public boolean f15270p = false;

    /* renamed from: q  reason: collision with root package name */
    private String[] f15271q = {"18", "16", "16"};

    public final void onConfigurationChanged(Configuration configuration) {
        RelativeLayout.LayoutParams layoutParams;
        super.onConfigurationChanged(configuration);
        if (this.f15261g != null) {
            if (configuration.orientation == 1) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-2, -1);
            }
            int a10 = bo.a(30.0f);
            int a11 = bo.a(15.0f);
            layoutParams.setMargins(a10, a11, a10, a11);
            layoutParams.addRule(13);
            this.f15261g.setLayoutParams(layoutParams);
        }
    }

    public final void onCreate(Bundle bundle) {
        String[] strArr;
        super.onCreate(bundle);
        setStyle(2, 16973830);
        setRetainInstance(true);
        try {
            this.f15257c = getActivity();
            Bundle arguments = getArguments();
            this.f15258d = new UInAppMessage(new JSONObject(arguments.getString(Constant.KEY_MSG)));
            this.f15259e = arguments.getString(Constants.ScionAnalytics.PARAM_LABEL);
            byte[] byteArray = arguments.getByteArray("bitmapByte");
            if (byteArray != null) {
                this.f15260f = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            }
            this.f15266l = InAppMessageManager.getInstance(this.f15257c).getInAppHandler();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        int i10 = this.f15258d.msg_type;
        if (i10 == 5 || i10 == 6) {
            String a10 = InAppMessageManager.getInstance(this.f15257c).a("KEY_PLAIN_TEXT_SIZE", "");
            if (!TextUtils.isEmpty(a10)) {
                strArr = a10.split(",");
            } else {
                strArr = null;
            }
            if (strArr != null) {
                this.f15271q = strArr;
            }
        }
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.requestWindowFeature(1);
        return onCreateDialog;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Rect rect;
        RelativeLayout.LayoutParams layoutParams;
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            rect = new Rect();
            window.getDecorView().getWindowVisibleDisplayFrame(rect);
            int height = rect.height() - bo.a(65.0f);
            this.f15263i = height;
            double d10 = (double) height;
            Double.isNaN(d10);
            this.f15262h = (int) (d10 * 1.2d);
            int width = rect.width() - bo.a(70.0f);
            this.f15264j = width;
            this.f15265k = (width / 2) * 3;
        } else {
            rect = null;
        }
        int i10 = this.f15258d.msg_type;
        if (i10 == 2 || i10 == 3) {
            RelativeLayout relativeLayout = new RelativeLayout(this.f15257c);
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.setBackgroundColor(Color.parseColor("#33000000"));
            if (getResources().getConfiguration().orientation == 1) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            } else if (this.f15258d.msg_type == 2) {
                layoutParams = new RelativeLayout.LayoutParams(this.f15262h, this.f15263i);
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-2, -1);
            }
            int a10 = bo.a(30.0f);
            int a11 = bo.a(15.0f);
            layoutParams.setMargins(a10, a11, a10, a11);
            layoutParams.addRule(13);
            FrameLayout frameLayout = new FrameLayout(this.f15257c);
            this.f15261g = frameLayout;
            frameLayout.setLayoutParams(layoutParams);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            int a12 = bo.a(12.0f);
            layoutParams2.setMargins(a12, a12, a12, a12);
            ImageView imageView = new ImageView(this.f15257c);
            imageView.setLayoutParams(layoutParams2);
            imageView.setAdjustViewBounds(true);
            imageView.setId(f.a());
            imageView.setImageBitmap(this.f15260f);
            this.f15261g.addView(imageView);
            int a13 = bo.a(24.0f);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(a13, a13, 5);
            br brVar = new br(this.f15257c);
            brVar.setLayoutParams(layoutParams3);
            this.f15261g.addView(brVar);
            relativeLayout.addView(this.f15261g);
            imageView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    boolean unused = UmengCardMessage.this.f15268n = true;
                    if (!TextUtils.equals("none", UmengCardMessage.this.f15258d.action_type)) {
                        UmengCardMessage.this.f15266l.handleInAppMessage(UmengCardMessage.this.f15257c, UmengCardMessage.this.f15258d, 16);
                        UmengCardMessage.this.dismiss();
                    }
                }
            });
            brVar.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    boolean unused = UmengCardMessage.this.f15270p = true;
                    UmengCardMessage.this.dismiss();
                }
            });
            return relativeLayout;
        } else if (i10 == 4) {
            View inflate = layoutInflater.inflate(a.a("umeng_custom_card_message"), viewGroup, false);
            ImageView imageView2 = (ImageView) inflate.findViewById(a.b("umeng_card_message_image"));
            imageView2.setImageBitmap(this.f15260f);
            imageView2.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    boolean unused = UmengCardMessage.this.f15268n = true;
                    if (!TextUtils.equals("none", UmengCardMessage.this.f15258d.action_type)) {
                        UmengCardMessage.this.f15266l.handleInAppMessage(UmengCardMessage.this.f15257c, UmengCardMessage.this.f15258d, 16);
                        UmengCardMessage.this.dismiss();
                    }
                }
            });
            ((Button) inflate.findViewById(a.b("umeng_card_message_ok"))).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    boolean unused = UmengCardMessage.this.f15269o = true;
                    if (!TextUtils.equals("none", UmengCardMessage.this.f15258d.action_type)) {
                        UmengCardMessage.this.f15266l.handleInAppMessage(UmengCardMessage.this.f15257c, UmengCardMessage.this.f15258d, 19);
                        UmengCardMessage.this.dismiss();
                    }
                }
            });
            ((Button) inflate.findViewById(a.b("umeng_card_message_close"))).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    boolean unused = UmengCardMessage.this.f15270p = true;
                    UmengCardMessage.this.dismiss();
                }
            });
            return inflate;
        } else if ((i10 != 5 && i10 != 6) || rect == null) {
            return null;
        } else {
            RelativeLayout relativeLayout2 = new RelativeLayout(this.f15257c);
            relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout2.setBackgroundColor(Color.parseColor("#33000000"));
            if (getResources().getConfiguration().orientation == 1) {
                int width2 = rect.width() - bo.a(70.0f);
                this.f15264j = width2;
                if (this.f15258d.msg_type == 5) {
                    this.f15265k = (width2 / 6) * 5;
                } else {
                    this.f15265k = (width2 / 2) * 3;
                }
            } else {
                int height2 = rect.height() - bo.a(65.0f);
                this.f15265k = height2;
                this.f15264j = (height2 / 5) * 6;
            }
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(this.f15264j, this.f15265k);
            layoutParams4.addRule(13);
            LinearLayout linearLayout = new LinearLayout(this.f15257c);
            linearLayout.setLayoutParams(layoutParams4);
            linearLayout.setGravity(1);
            linearLayout.setOrientation(1);
            linearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
            int a14 = bo.a(20.0f);
            layoutParams5.setMargins(a14, a14, a14, a14);
            TextView textView = new TextView(this.f15257c);
            textView.setLayoutParams(layoutParams5);
            textView.setGravity(17);
            textView.setText(this.f15258d.title);
            textView.setSingleLine(true);
            textView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            textView.setTextSize((float) Integer.parseInt(this.f15271q[0]));
            textView.setTextColor(Color.parseColor("#000000"));
            linearLayout.addView(textView);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, 0);
            layoutParams6.setMargins(a14, 0, a14, 0);
            layoutParams6.weight = 1.0f;
            ScrollView scrollView = new ScrollView(this.f15257c);
            scrollView.setLayoutParams(layoutParams6);
            scrollView.setScrollBarStyle(16777216);
            scrollView.setVerticalScrollBarEnabled(false);
            TextView textView2 = new TextView(this.f15257c);
            textView2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            textView2.setText(this.f15258d.content);
            textView2.setTextSize((float) Integer.parseInt(this.f15271q[1]));
            textView2.setTextColor(Color.parseColor("#000000"));
            scrollView.addView(textView2);
            linearLayout.addView(scrollView);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setStroke(bo.a(1.0f), Color.parseColor("#D8D8D8"));
            gradientDrawable.setCornerRadius(20.0f);
            gradientDrawable.setColor(-1);
            LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, bo.a(35.0f));
            layoutParams7.setMargins(a14, bo.a(30.0f), a14, a14);
            TextView textView3 = new TextView(this.f15257c);
            textView3.setLayoutParams(layoutParams7);
            textView3.setGravity(17);
            textView3.setBackgroundColor(Color.parseColor("#FFFFFF"));
            textView3.setText(this.f15258d.button_text);
            textView3.setSingleLine(true);
            textView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            textView3.setTextSize((float) Integer.parseInt(this.f15271q[2]));
            textView3.setTextColor(Color.parseColor("#000000"));
            textView3.setBackgroundDrawable(gradientDrawable);
            linearLayout.addView(textView3);
            relativeLayout2.addView(linearLayout);
            textView3.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    boolean unused = UmengCardMessage.this.f15268n = true;
                    UmengCardMessage.this.f15266l.handleInAppMessage(UmengCardMessage.this.f15257c, UmengCardMessage.this.f15258d, 18);
                    UmengCardMessage.this.dismiss();
                }
            });
            return relativeLayout2;
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        aj a10 = aj.a((Context) this.f15257c);
        UInAppMessage uInAppMessage = this.f15258d;
        a10.a(uInAppMessage.msg_id, uInAppMessage.msg_type, 0, this.f15268n ? 1 : 0, 0, 0, this.f15270p ? 1 : 0, 0, this.f15269o ? 1 : 0);
        this.f15270p = false;
        this.f15268n = false;
        this.f15269o = false;
        this.f15267m = false;
        IUmengInAppMsgCloseCallback iUmengInAppMsgCloseCallback = this.f15256a;
        if (iUmengInAppMsgCloseCallback != null) {
            iUmengInAppMsgCloseCallback.onClose();
        }
    }

    public final void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage((Message) null);
        }
        super.onDestroyView();
    }

    public final void onStart() {
        super.onStart();
        if (!this.f15267m) {
            aj a10 = aj.a((Context) this.f15257c);
            UInAppMessage uInAppMessage = this.f15258d;
            a10.a(uInAppMessage.msg_id, uInAppMessage.msg_type, 1, 0, 0, 0, 0, 0, 0);
        }
        this.f15267m = true;
    }
}
