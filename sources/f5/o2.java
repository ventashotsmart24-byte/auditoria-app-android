package f5;

import android.widget.CompoundButton;
import com.mobile.brasiltv.activity.PhoneAty;

public final /* synthetic */ class o2 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PhoneAty f16647a;

    public /* synthetic */ o2(PhoneAty phoneAty) {
        this.f16647a = phoneAty;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        PhoneAty.f3(this.f16647a, compoundButton, z10);
    }
}
