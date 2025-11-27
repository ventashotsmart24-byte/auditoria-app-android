package k6;

import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import ba.s;
import com.google.gson.GsonBuilder;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.mobile.brasiltv.bean.event.UpdateMineViewEvent;
import com.mobile.brasiltv.utils.b0;
import com.msandroid.mobile.R;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.f;
import f5.c;
import i6.j0;
import io.reactivex.disposables.Disposable;
import java.util.List;
import mobile.com.requestframe.utils.bean.ResultException;
import mobile.com.requestframe.utils.response.AuthInfo;
import mobile.com.requestframe.utils.response.ExchangeData;
import mobile.com.requestframe.utils.response.ExchangeResult;
import t9.i;

public final class q2 implements l5.a {

    /* renamed from: a  reason: collision with root package name */
    public final c f18027a;

    /* renamed from: b  reason: collision with root package name */
    public final j0 f18028b;

    /* renamed from: c  reason: collision with root package name */
    public Disposable f18029c;

    public static final class a extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q2 f18030a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f18031b;

        public a(q2 q2Var, String str) {
            this.f18030a = q2Var;
            this.f18031b = str;
        }

        /* renamed from: f */
        public void onNext(ExchangeResult exchangeResult) {
            boolean z10;
            List<AuthInfo> authInfoList;
            i.g(exchangeResult, "t");
            ExchangeData data = exchangeResult.getData();
            if (data == null || (authInfoList = data.getAuthInfoList()) == null || authInfoList.isEmpty()) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                xa.c.c().m(new UpdateMineViewEvent());
            }
            this.f18030a.p().showLoading(false);
            this.f18030a.p().S1();
        }

        public void onError(Throwable th) {
            i.g(th, "e");
            super.onError(th);
            if (th instanceof ResultException) {
                ResultException resultException = (ResultException) th;
                if (!TextUtils.isEmpty(resultException.getErrorData())) {
                    q2 q2Var = this.f18030a;
                    String returnCode = resultException.getReturnCode();
                    i.f(returnCode, "e.returnCode");
                    String errorData = resultException.getErrorData();
                    i.f(errorData, "e.errorData");
                    q2Var.l(returnCode, errorData, this.f18031b);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            i.g(disposable, "d");
            super.onSubscribe(disposable);
            this.f18030a.f18029c = disposable;
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            this.f18030a.p().showLoading(false);
            if (b0.T(str, "50010") || b0.T(str, "50011") || b0.T(str, "50012") || b0.T(str, "50014")) {
                q2.m(this.f18030a, str, (String) null, (String) null, 6, (Object) null);
            }
        }
    }

    public q2(c cVar, j0 j0Var) {
        i.g(cVar, f.X);
        i.g(j0Var, "view");
        this.f18027a = cVar;
        this.f18028b = j0Var;
    }

    public static /* synthetic */ void m(q2 q2Var, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        if ((i10 & 4) != 0) {
            str3 = "";
        }
        q2Var.l(str, str2, str3);
    }

    public void e() {
    }

    public void g() {
    }

    public void j() {
        Disposable disposable;
        Disposable disposable2 = this.f18029c;
        boolean z10 = false;
        if (disposable2 != null && !disposable2.isDisposed()) {
            z10 = true;
        }
        if (z10 && (disposable = this.f18029c) != null) {
            disposable.dispose();
        }
        this.f18029c = null;
    }

    public void k(String str) {
        i.g(str, "exchangeCode");
        String o10 = o(str);
        if (TextUtils.isEmpty(o10)) {
            this.f18028b.o2(R.string.redemption_please_exchange_code);
        } else if (o10.length() != 16) {
            this.f18028b.o2(R.string.redemption_input_correct_code);
        } else {
            this.f18028b.showLoading(true);
            w6.i.f9510g.b().a1(o10).compose(this.f18027a.O1()).subscribe(new a(this, str));
        }
    }

    public final void l(String str, String str2, String str3) {
        if (b0.T(str, "50010") || b0.T(str, "50011") || b0.T(str, "50012") || b0.T(str, "50014")) {
            j0.a.a(this.f18028b, "-1", (ExchangeData) null, (String) null, 6, (Object) null);
            return;
        }
        this.f18028b.W(str, (ExchangeData) new GsonBuilder().disableHtmlEscaping().create().fromJson(str2, ExchangeData.class), str3);
        i.b(str, "aaa40002");
    }

    public final void n(EditText editText, TextWatcher textWatcher) {
        i.g(editText, "edit");
        i.g(textWatcher, "textWatcher");
        editText.removeTextChangedListener(textWatcher);
        String j10 = s.j(s.j(editText.getText().toString(), " ", "", false, 4, (Object) null), Operator.Operation.MINUS, "", false, 4, (Object) null);
        String str = "";
        int i10 = 0;
        for (int i11 = 0; i11 < j10.length(); i11++) {
            char charAt = j10.charAt(i11);
            i10++;
            if (i10 % 4 == 0) {
                str = str + charAt + ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER;
            } else {
                str = str + charAt;
            }
        }
        editText.setText(str);
        editText.addTextChangedListener(textWatcher);
    }

    public final String o(String str) {
        i.g(str, Constants.KEY_HTTP_CODE);
        return s.j(s.j(str, " ", "", false, 4, (Object) null), Operator.Operation.MINUS, "", false, 4, (Object) null);
    }

    public final j0 p() {
        return this.f18028b;
    }
}
