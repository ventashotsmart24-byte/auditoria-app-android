package com.google.firebase.inappmessaging.internal;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProxyAnalyticsConnector implements AnalyticsConnector {
    private volatile Object instance;

    public static class ProxyAnalyticsConnectorHandle implements AnalyticsConnector.AnalyticsConnectorHandle {
        private static final Object UNREGISTERED = new Object();
        private Set<String> eventNames;
        private volatile Object instance;

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener, Provider provider) {
            if (this.instance != UNREGISTERED) {
                AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener = ((AnalyticsConnector) provider.get()).registerAnalyticsConnectorListener(str, analyticsConnectorListener);
                this.instance = registerAnalyticsConnectorListener;
                synchronized (this) {
                    if (!this.eventNames.isEmpty()) {
                        registerAnalyticsConnectorListener.registerEventNames(this.eventNames);
                        this.eventNames = new HashSet();
                    }
                }
            }
        }

        public void registerEventNames(Set<String> set) {
            Object obj = this.instance;
            if (obj != UNREGISTERED) {
                if (obj != null) {
                    ((AnalyticsConnector.AnalyticsConnectorHandle) obj).registerEventNames(set);
                    return;
                }
                synchronized (this) {
                    this.eventNames.addAll(set);
                }
            }
        }

        public void unregister() {
            Object obj = this.instance;
            Object obj2 = UNREGISTERED;
            if (obj != obj2) {
                if (obj != null) {
                    ((AnalyticsConnector.AnalyticsConnectorHandle) obj).unregister();
                }
                this.instance = obj2;
                synchronized (this) {
                    this.eventNames.clear();
                }
            }
        }

        public void unregisterEventNames() {
            Object obj = this.instance;
            if (obj != UNREGISTERED) {
                if (obj != null) {
                    ((AnalyticsConnector.AnalyticsConnectorHandle) obj).unregisterEventNames();
                    return;
                }
                synchronized (this) {
                    this.eventNames.clear();
                }
            }
        }

        private ProxyAnalyticsConnectorHandle(String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener, Deferred<AnalyticsConnector> deferred) {
            this.eventNames = new HashSet();
            deferred.whenAvailable(new z1(this, str, analyticsConnectorListener));
        }
    }

    public ProxyAnalyticsConnector(Deferred<AnalyticsConnector> deferred) {
        this.instance = deferred;
        deferred.whenAvailable(new y1(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Provider provider) {
        this.instance = provider.get();
    }

    private AnalyticsConnector safeGet() {
        Object obj = this.instance;
        if (obj instanceof AnalyticsConnector) {
            return (AnalyticsConnector) obj;
        }
        return null;
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
    }

    public List<AnalyticsConnector.ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        return Collections.emptyList();
    }

    public int getMaxUserProperties(String str) {
        return 0;
    }

    public Map<String, Object> getUserProperties(boolean z10) {
        return Collections.emptyMap();
    }

    public void logEvent(String str, String str2, Bundle bundle) {
        AnalyticsConnector safeGet = safeGet();
        if (safeGet != null) {
            safeGet.logEvent(str, str2, bundle);
        }
    }

    public AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener(String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        Object obj = this.instance;
        if (obj instanceof AnalyticsConnector) {
            return ((AnalyticsConnector) obj).registerAnalyticsConnectorListener(str, analyticsConnectorListener);
        }
        return new ProxyAnalyticsConnectorHandle(str, analyticsConnectorListener, (Deferred) obj);
    }

    public void setConditionalUserProperty(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
    }

    public void setUserProperty(String str, String str2, Object obj) {
        AnalyticsConnector safeGet = safeGet();
        if (safeGet != null) {
            safeGet.setUserProperty(str, str2, obj);
        }
    }
}
