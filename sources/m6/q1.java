package m6;

import com.mobile.brasiltv.db.AudioSettingBean;
import com.mobile.brasiltv.player.TitanPlayerController;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class q1 implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TitanPlayerController f18921a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioSettingBean f18922b;

    public /* synthetic */ q1(TitanPlayerController titanPlayerController, AudioSettingBean audioSettingBean) {
        this.f18921a = titanPlayerController;
        this.f18922b = audioSettingBean;
    }

    public final void subscribe(ObservableEmitter observableEmitter) {
        TitanPlayerController.g3(this.f18921a, this.f18922b, observableEmitter);
    }
}
