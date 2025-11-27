package com.google.firebase.inappmessaging.internal;

import com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse;
import io.reactivex.functions.Consumer;
import java.util.Locale;

public final /* synthetic */ class z0 implements Consumer {
    public final void accept(Object obj) {
        Logging.logi(String.format(Locale.US, "Successfully fetched %d messages from backend", new Object[]{Integer.valueOf(((FetchEligibleCampaignsResponse) obj).getMessagesList().size())}));
    }
}
