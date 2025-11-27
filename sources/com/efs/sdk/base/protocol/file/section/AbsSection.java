package com.efs.sdk.base.protocol.file.section;

public abstract class AbsSection {
    public static final String SEP_LINE_BREAK = "linebreak";
    public static final String SEP_ORIGIN_LINE_BREAK = "\n";
    String name = "";
    String sep = "";
    String type;
    String version = "1.0";

    public AbsSection(String str) {
        this.type = str;
    }

    public abstract String changeToStr();

    public String getDeclarationLine() {
        return "section:" + this.name + "," + this.type + "," + this.version + "," + this.sep;
    }

    public void setSep(String str) {
        if (str.equals("\n")) {
            this.sep = SEP_LINE_BREAK;
        } else {
            this.sep = str;
        }
    }
}
