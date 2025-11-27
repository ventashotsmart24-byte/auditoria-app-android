package com.efs.sdk.base.core.config;

import android.content.Context;
import android.os.Message;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.efs.sdk.base.observer.IEfsReporterObserver;
import com.efs.sdk.base.processor.action.ILogEncryptAction;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GlobalEnvStruct {

    /* renamed from: a  reason: collision with root package name */
    private String f5193a;

    /* renamed from: b  reason: collision with root package name */
    private String f5194b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5195c = true;
    public long configRefreshDelayMills = 5000;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5196d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5197e = true;

    /* renamed from: f  reason: collision with root package name */
    private boolean f5198f = false;

    /* renamed from: g  reason: collision with root package name */
    private Boolean f5199g = null;

    /* renamed from: h  reason: collision with root package name */
    private boolean f5200h = false;

    /* renamed from: i  reason: collision with root package name */
    private String f5201i;

    /* renamed from: j  reason: collision with root package name */
    private String f5202j = "";

    /* renamed from: k  reason: collision with root package name */
    private String f5203k = "";

    /* renamed from: l  reason: collision with root package name */
    private boolean f5204l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f5205m = false;
    public Context mAppContext;

    /* renamed from: n  reason: collision with root package name */
    private long f5206n = NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS;

    /* renamed from: o  reason: collision with root package name */
    private long f5207o = NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS;

    /* renamed from: p  reason: collision with root package name */
    private Map<String, String> f5208p = new HashMap(5);

    /* renamed from: q  reason: collision with root package name */
    private ILogEncryptAction f5209q;

    /* renamed from: r  reason: collision with root package name */
    private ConcurrentHashMap<Integer, List<ValueCallback<Pair<Message, Message>>>> f5210r = new ConcurrentHashMap<>();

    /* renamed from: s  reason: collision with root package name */
    private List<IEfsReporterObserver> f5211s = new ArrayList(5);

    public void addConfigObserver(IEfsReporterObserver iEfsReporterObserver) {
        if (!this.f5211s.contains(iEfsReporterObserver)) {
            this.f5211s.add(iEfsReporterObserver);
        }
    }

    public void addPublicParams(Map<String, String> map) {
        if (map != null && map.size() > 0) {
            HashMap hashMap = new HashMap(this.f5208p);
            hashMap.putAll(map);
            this.f5208p = hashMap;
        }
    }

    public String getAppid() {
        return this.f5193a;
    }

    public List<ValueCallback<Pair<Message, Message>>> getCallback(int i10) {
        if (!this.f5210r.containsKey(Integer.valueOf(i10)) || this.f5210r.get(Integer.valueOf(i10)) == null) {
            return Collections.emptyList();
        }
        return this.f5210r.get(Integer.valueOf(i10));
    }

    public List<IEfsReporterObserver> getEfsReporterObservers() {
        return this.f5211s;
    }

    public String getLogDid() {
        return this.f5203k;
    }

    public ILogEncryptAction getLogEncryptAction() {
        return this.f5209q;
    }

    public long getLogSendDelayMills() {
        return this.f5206n;
    }

    public long getLogSendIntervalMills() {
        return this.f5207o;
    }

    public String getLogUid() {
        return this.f5202j;
    }

    public Map<String, String> getPublicParamMap() {
        Map<String, String> map = this.f5208p;
        if (map == null) {
            return Collections.emptyMap();
        }
        return map;
    }

    public String getSecret() {
        return this.f5194b;
    }

    public String getUid() {
        return this.f5201i;
    }

    public boolean isDebug() {
        return this.f5198f;
    }

    public boolean isEnablePaBackup() {
        return this.f5196d;
    }

    public boolean isEnableSendLog() {
        return this.f5197e;
    }

    public boolean isEnableWaStat() {
        return this.f5195c;
    }

    public boolean isIntl() {
        return this.f5205m;
    }

    public boolean isOpenCodeLog() {
        return this.f5204l;
    }

    public boolean isPrintLogDetail() {
        return this.f5200h;
    }

    public void registerCallback(int i10, ValueCallback<Pair<Message, Message>> valueCallback) {
        if (valueCallback != null) {
            List list = this.f5210r.get(Integer.valueOf(i10));
            if (list == null) {
                list = new LinkedList();
                this.f5210r.putIfAbsent(Integer.valueOf(i10), list);
            }
            list.add(valueCallback);
        }
    }

    public void setAppid(String str) {
        this.f5193a = str;
    }

    public void setDebug(boolean z10) {
        this.f5198f = z10;
    }

    public void setEnablePaBackup(boolean z10) {
        this.f5196d = z10;
    }

    public void setEnableSendLog(boolean z10) {
        this.f5197e = z10;
    }

    public void setEnableWaStat(boolean z10) {
        this.f5195c = z10;
    }

    public void setIsIntl(boolean z10) {
        this.f5205m = z10;
    }

    public void setLogDid(String str) {
        this.f5203k = str;
    }

    public void setLogEncryptAction(ILogEncryptAction iLogEncryptAction) {
        this.f5209q = iLogEncryptAction;
    }

    public void setLogUid(String str) {
        this.f5202j = str;
    }

    public void setOpenCodeLog(boolean z10) {
        this.f5204l = z10;
    }

    public void setPrintLogDetail(boolean z10) {
        this.f5200h = z10;
    }

    public void setSecret(String str) {
        this.f5194b = str;
    }

    public void setUid(String str) {
        this.f5201i = str;
    }
}
