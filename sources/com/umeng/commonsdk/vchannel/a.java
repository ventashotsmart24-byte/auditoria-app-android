package com.umeng.commonsdk.vchannel;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f15146a = "https://pslog.umeng.com";

    /* renamed from: b  reason: collision with root package name */
    public static String f15147b = "https://pslog.umeng.com/";

    /* renamed from: c  reason: collision with root package name */
    public static String f15148c = "explog";

    /* renamed from: d  reason: collision with root package name */
    public static final String f15149d = "analytics";

    /* renamed from: e  reason: collision with root package name */
    public static final String f15150e = "ekv";

    /* renamed from: f  reason: collision with root package name */
    public static final String f15151f = "id";

    /* renamed from: g  reason: collision with root package name */
    public static final String f15152g = "ts";

    /* renamed from: h  reason: collision with root package name */
    public static final String f15153h = "ds";

    /* renamed from: i  reason: collision with root package name */
    public static final String f15154i = "pn";

    /* renamed from: j  reason: collision with root package name */
    public static String f15155j = "";

    static {
        String str = "SUB" + System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(String.format("%0" + (32 - str.length()) + "d", new Object[]{0}));
        f15155j = sb.toString();
    }
}
