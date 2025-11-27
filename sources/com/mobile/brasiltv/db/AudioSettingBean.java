package com.mobile.brasiltv.db;

import java.io.Serializable;
import sa.a;
import sa.e;
import t9.i;

@e(name = "audio_setting")
public final class AudioSettingBean implements Serializable {
    private String audioLanguage = "";
    private String contentId = "";
    @a(column = "id")
    private int id;

    public final String getAudioLanguage() {
        return this.audioLanguage;
    }

    public final String getContentId() {
        return this.contentId;
    }

    public final int getId() {
        return this.id;
    }

    public final void setAudioLanguage(String str) {
        i.g(str, "<set-?>");
        this.audioLanguage = str;
    }

    public final void setContentId(String str) {
        i.g(str, "<set-?>");
        this.contentId = str;
    }

    public final void setId(int i10) {
        this.id = i10;
    }
}
