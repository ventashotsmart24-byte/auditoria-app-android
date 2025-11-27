package x5;

import android.content.Context;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.business.message.inapp.bean.InAppMsg;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.dialog.CommonDialog;
import com.mobile.brasiltv.view.dialog.DialogManager;
import h9.t;
import java.util.List;
import s9.l;
import t9.i;
import t9.j;
import w5.m;

public abstract class g extends CommonDialog {

    /* renamed from: a  reason: collision with root package name */
    public Context f19773a;

    /* renamed from: b  reason: collision with root package name */
    public InAppMsg f19774b;

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f19775a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(g gVar) {
            super(1);
            this.f19775a = gVar;
        }

        public final void b(List list) {
            i.g(list, "it");
            if (b0.I(list)) {
                m.f19701a.W(this.f19775a.getMContext(), (InAppMsg) list.get(0));
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((List) obj);
            return t.f17319a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(Context context, InAppMsg inAppMsg) {
        super(context, 0, 2, (t9.g) null);
        i.g(context, "mContext");
        i.g(inAppMsg, Constant.KEY_MSG);
        this.f19773a = context;
        this.f19774b = inAppMsg;
    }

    public final InAppMsg a() {
        return this.f19774b;
    }

    public void dismiss() {
        super.dismiss();
        b0.R(this);
        DialogManager.INSTANCE.clearSaveDialog(DialogManager.DIALOG_INAPP_MSG_COUPON_BENEFITS, DialogManager.DIALOG_INAPP_MSG_SERVICE_EFFECT, DialogManager.DIALOG_INAPP_MSG_ORDER_PAY_FAILURE, DialogManager.DIALOG_INAPP_MSG_GET_CASHBACK, DialogManager.DIALOG_INAPP_MSG_ACTIVITY_REMIND);
        m.f19701a.M(new a(this));
    }

    public final Context getMContext() {
        return this.f19773a;
    }

    public void show() {
        super.show();
        m.f19701a.r(this.f19774b);
    }
}
