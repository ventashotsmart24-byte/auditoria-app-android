package m6;

import com.mobile.brasiltv.db.SubtitleSettingBean;
import com.mobile.brasiltv.player.TitanPlayerController;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class m1 implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TitanPlayerController f18904a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubtitleSettingBean f18905b;

    public /* synthetic */ m1(TitanPlayerController titanPlayerController, SubtitleSettingBean subtitleSettingBean) {
        this.f18904a = titanPlayerController;
        this.f18905b = subtitleSettingBean;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        TitanPlayerController.m3(this.f18904a, this.f18905b, observableEmitter);
    }
}
