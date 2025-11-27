package f5;

import android.graphics.drawable.Drawable;
import android.widget.RadioGroup;
import com.mobile.brasiltv.activity.SettingLanguageAty;

public final /* synthetic */ class s4 implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SettingLanguageAty f16679a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Drawable f16680b;

    public /* synthetic */ s4(SettingLanguageAty settingLanguageAty, Drawable drawable) {
        this.f16679a = settingLanguageAty;
        this.f16680b = drawable;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i10) {
        SettingLanguageAty.U2(this.f16679a, this.f16680b, radioGroup, i10);
    }
}
