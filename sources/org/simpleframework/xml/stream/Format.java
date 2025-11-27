package org.simpleframework.xml.stream;

public class Format {
    private final int indent;
    private final String prolog;
    private final Style style;
    private final Verbosity verbosity;

    public Format() {
        this(3);
    }

    public int getIndent() {
        return this.indent;
    }

    public String getProlog() {
        return this.prolog;
    }

    public Style getStyle() {
        return this.style;
    }

    public Verbosity getVerbosity() {
        return this.verbosity;
    }

    public Format(int i10) {
        this(i10, (String) null, (Style) new IdentityStyle());
    }

    public Format(String str) {
        this(3, str);
    }

    public Format(int i10, String str) {
        this(i10, str, (Style) new IdentityStyle());
    }

    public Format(Verbosity verbosity2) {
        this(3, verbosity2);
    }

    public Format(int i10, Verbosity verbosity2) {
        this(i10, (Style) new IdentityStyle(), verbosity2);
    }

    public Format(Style style2) {
        this(3, style2);
    }

    public Format(Style style2, Verbosity verbosity2) {
        this(3, style2, verbosity2);
    }

    public Format(int i10, Style style2) {
        this(i10, (String) null, style2);
    }

    public Format(int i10, Style style2, Verbosity verbosity2) {
        this(i10, (String) null, style2, verbosity2);
    }

    public Format(int i10, String str, Style style2) {
        this(i10, str, style2, Verbosity.HIGH);
    }

    public Format(int i10, String str, Style style2, Verbosity verbosity2) {
        this.verbosity = verbosity2;
        this.prolog = str;
        this.indent = i10;
        this.style = style2;
    }
}
