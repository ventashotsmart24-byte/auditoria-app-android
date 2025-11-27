package com.hpplay.sdk.source.process;

import android.content.Context;
import com.hpplay.sdk.source.api.LelinkPlayerInfo;
import com.hpplay.sdk.source.api.PlayerListenerConstant;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.business.BusinessEntity;
import com.hpplay.sdk.source.business.cloud.RightsManager;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.pass.Parser;
import com.hpplay.sdk.source.pass.bean.ConnectBean;
import com.hpplay.sdk.source.process.LelinkSdkManager;
import com.hpplay.sdk.source.utils.CastUtil;

public class MirrorConnectCallback implements LelinkSdkManager.ConnectCallback {
    private static final String TAG = "MirrorConnectCallback";
    private Context mContext;
    private OutParameter playInfo;
    private LelinkPlayerInfo playerInfo;

    public MirrorConnectCallback(Context context, OutParameter outParameter, LelinkPlayerInfo lelinkPlayerInfo) {
        this.mContext = context;
        this.playInfo = outParameter;
        this.playerInfo = lelinkPlayerInfo;
    }

    public void onConnect(int i10, boolean z10) {
        this.playInfo.currentBrowserInfo = CastUtil.getPreMirrorInfo(this.playerInfo.getLelinkServiceInfo());
        if (this.playInfo.currentBrowserInfo == null) {
            SourceLog.w(TAG, "startMirror ignore,invalid browser info:" + this.playerInfo.getLelinkServiceInfo());
            if (BusinessEntity.getInstance().getListenerDispatcher() != null) {
                BusinessEntity.getInstance().getListenerDispatcher().onError((OutParameter) null, 211000, PlayerListenerConstant.EXTRA_ERROR_MIRROR_INVALID_INPUT);
                return;
            }
            return;
        }
        SourceLog.w(TAG, "startMirror onConnect " + this.playInfo.currentBrowserInfo.getName());
        ConnectBean connectBean = Parser.getInstance().getConnectBean(this.playInfo.currentBrowserInfo.getUid());
        if (connectBean == null || connectBean.mirror != -1) {
            OutParameter outParameter = this.playInfo;
            outParameter.protocol = outParameter.currentBrowserInfo.getType();
            this.playInfo.connectProtocol = i10;
            SourceLog.w(TAG, "startMirror onConnect :" + this.playInfo.protocol + " / " + this.playInfo.connectProtocol);
            this.playInfo.connectSession = ConnectManager.getInstance().getConnectSession(this.playerInfo.getLelinkServiceInfo());
            if (4 == this.playInfo.protocol) {
                boolean hasVipFeature = RightsManager.getInstance().hasVipFeature(this.playInfo.serviceInfo.getUid(), RightsManager.VIP_KEY_LEBO_CLOUDMIRROR);
                SourceLog.w(TAG, "startMirror hasVipFeature:" + hasVipFeature);
                if (!hasVipFeature) {
                    SourceLog.w(TAG, "startMirror igonre, no cloud mirror vip feature");
                    if (BusinessEntity.getInstance().getListenerDispatcher() != null) {
                        BusinessEntity.getInstance().getListenerDispatcher().onError((OutParameter) null, 211000, 211053);
                        return;
                    }
                    return;
                }
                BusinessEntity.getInstance().dispatch(this.mContext, this.playInfo, z10);
                return;
            }
            BusinessEntity.getInstance().dispatch(this.mContext, this.playInfo, z10);
            return;
        }
        SourceLog.w(TAG, "startMirror ignore, sink not support mirror");
        if (BusinessEntity.getInstance().getListenerDispatcher() != null) {
            BusinessEntity.getInstance().getListenerDispatcher().onError((OutParameter) null, 211000, PlayerListenerConstant.EXTRA_ERROR_MIRROR_SINK_UNSUPPORTED);
        }
    }
}
