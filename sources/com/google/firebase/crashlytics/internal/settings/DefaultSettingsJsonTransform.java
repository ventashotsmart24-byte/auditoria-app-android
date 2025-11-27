package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.Settings;
import org.json.JSONObject;

class DefaultSettingsJsonTransform implements SettingsJsonTransform {
    public static Settings defaultSettings(CurrentTimeProvider currentTimeProvider) {
        return new Settings(((long) 3600000) + currentTimeProvider.getCurrentTimeMillis(), new Settings.SessionData(8, 4), new Settings.FeatureFlagData(true, false, false), 0, 3600, 10.0d, 1.2d, 60);
    }

    public Settings buildFromJson(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject) {
        return defaultSettings(currentTimeProvider);
    }
}
