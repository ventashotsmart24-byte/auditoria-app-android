package com.efs.sdk.base.protocol.file.section;

import com.hpplay.component.common.ParamsMap;

public class TextSection extends AbsSection {
    private String body;

    public TextSection(String str) {
        super(ParamsMap.MirrorParams.MIRROR_DOC_MODE);
        this.name = str;
    }

    public String changeToStr() {
        return getDeclarationLine() + "\n" + this.body + "\n";
    }

    public void setBody(String str) {
        this.body = str;
    }
}
