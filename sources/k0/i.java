package k0;

import android.media.session.MediaSessionManager;

public final class i extends j {

    /* renamed from: d  reason: collision with root package name */
    public final MediaSessionManager.RemoteUserInfo f7218d;

    public i(String str, int i10, int i11) {
        super(str, i10, i11);
        this.f7218d = new MediaSessionManager.RemoteUserInfo(str, i10, i11);
    }

    public i(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        super(remoteUserInfo.getPackageName(), remoteUserInfo.getPid(), remoteUserInfo.getUid());
        this.f7218d = remoteUserInfo;
    }
}
