package com.mobile.brasiltv.bean;

import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import i9.j;
import java.util.ArrayList;
import java.util.HashMap;
import t9.i;

public final class SubtitleManager {
    public static final String GLOBAL_AUDIO_LANGUAGE = "global_audio_language";
    public static final String GLOBAL_SUBTITLE_COLOR = "global_subtitle_color";
    public static final String GLOBAL_SUBTITLE_LANGUAGE = "global_subtitle_language";
    public static final String GLOBAL_SUBTITLE_SIZE = "global_subtitle_size";
    public static final String GLOBAL_SUBTITLE_SWITCH = "global_subtitle_switch";
    public static final SubtitleManager INSTANCE = new SubtitleManager();
    public static final int SUBTITLE_COLOR_WHITE = 0;
    public static final int SUBTITLE_COLOR_WHITE_BLACK = 2;
    public static final int SUBTITLE_COLOR_YELLOW = 1;
    public static final int SUBTITLE_LANGUAGE_EN = 1;
    public static final int SUBTITLE_LANGUAGE_ES = 2;
    public static final int SUBTITLE_LANGUAGE_PT = 0;
    public static final int SUBTITLE_SIZE_BIG = 2;
    public static final int SUBTITLE_SIZE_NORMAL = 0;
    public static final int SUBTITLE_SIZE_SMALL = 1;
    private static final Integer[] colorValues;
    private static final Integer[] landscapeSizeValues = {14, 11, 17};
    private static int mGlobalAudioLanguage;
    private static int mGlobalColor;
    private static int mGlobalLanguage;
    private static int mGlobalSize;
    private static boolean mGlobalSwitch = true;
    private static LruCache<String, String> mLruCacheAudioLanguages = new LruCache<>(100);
    private static LruCache<String, Integer> mLruCacheColor = new LruCache<>(100);
    private static HashMap<String, RecordSubtitleInfoBean> mLruCacheLanguages = new HashMap<>();
    private static LruCache<String, Integer> mLruCacheSize = new LruCache<>(100);
    private static LruCache<String, Boolean> mLruCacheSwitch = new LruCache<>(100);
    private static final Integer[] portraitSizeValues = {11, 8, 14};

    static {
        Integer valueOf = Integer.valueOf(R.color.color_important_white);
        colorValues = new Integer[]{valueOf, Integer.valueOf(R.color.color_ffff00), valueOf};
    }

    private SubtitleManager() {
    }

    public final void clearLruCacheSwitch() {
        mLruCacheSwitch.evictAll();
    }

    public final void clearSelectSubtitle() {
        mLruCacheLanguages.clear();
    }

    public final ArrayList<String> getColorList(Context context) {
        i.g(context, f.X);
        String string = context.getResources().getString(R.string.subtitle_color_white);
        i.f(string, "context.resources.getStr…ing.subtitle_color_white)");
        String string2 = context.getResources().getString(R.string.subtitle_color_yellow);
        i.f(string2, "context.resources.getStr…ng.subtitle_color_yellow)");
        return j.c(string, string2);
    }

    public final Integer[] getColorValues() {
        return colorValues;
    }

    public final Integer[] getLandscapeSizeValues() {
        return landscapeSizeValues;
    }

    public final int getMGlobalAudioLanguage() {
        return mGlobalAudioLanguage;
    }

    public final int getMGlobalColor() {
        return mGlobalColor;
    }

    public final int getMGlobalLanguage() {
        return mGlobalLanguage;
    }

    public final int getMGlobalSize() {
        return mGlobalSize;
    }

    public final boolean getMGlobalSwitch() {
        return mGlobalSwitch;
    }

    public final LruCache<String, String> getMLruCacheAudioLanguages() {
        return mLruCacheAudioLanguages;
    }

    public final LruCache<String, Integer> getMLruCacheColor() {
        return mLruCacheColor;
    }

    public final HashMap<String, RecordSubtitleInfoBean> getMLruCacheLanguages() {
        return mLruCacheLanguages;
    }

    public final LruCache<String, Integer> getMLruCacheSize() {
        return mLruCacheSize;
    }

    public final LruCache<String, Boolean> getMLruCacheSwitch() {
        return mLruCacheSwitch;
    }

    public final Integer[] getPortraitSizeValues() {
        return portraitSizeValues;
    }

    public final ArrayList<String> getSizeList(Context context) {
        i.g(context, f.X);
        String string = context.getResources().getString(R.string.subtitle_size_normal);
        i.f(string, "context.resources.getStr…ing.subtitle_size_normal)");
        String string2 = context.getResources().getString(R.string.subtitle_size_small);
        i.f(string2, "context.resources.getStr…ring.subtitle_size_small)");
        String string3 = context.getResources().getString(R.string.subtitle_size_big);
        i.f(string3, "context.resources.getStr…string.subtitle_size_big)");
        return j.c(string, string2, string3);
    }

    public final ArrayList<SubtitleStyleBean> getStyleList(Context context) {
        i.g(context, f.X);
        ArrayList<SubtitleStyleBean> arrayList = new ArrayList<>();
        arrayList.add(0, new SubtitleStyleBean(context.getResources().getColor(R.color.color_important_white), context.getResources().getColor(R.color.color_pop_translucence)));
        arrayList.add(1, new SubtitleStyleBean(context.getResources().getColor(R.color.color_ffaa00), context.getResources().getColor(R.color.color_pop_translucence)));
        arrayList.add(2, new SubtitleStyleBean(context.getResources().getColor(R.color.color_important_white), context.getResources().getColor(R.color.color_191919)));
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0219, code lost:
        if (r1.equals("mkd (t)") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1050:0x13d7, code lost:
        if (r1.equals("chi") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0231, code lost:
        if (r1.equals("scr (b)(d)") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1091:0x149b, code lost:
        if (r1.equals("bod") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1094:0x14a9, code lost:
        return "Bantu";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1129:0x1551, code lost:
        if (r1.equals("baq") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1183:0x1657, code lost:
        if (r1.equals("ara") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1205:0x16bf, code lost:
        if (r1.equals("alb") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1240:0x1765, code lost:
        return "Zulu";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1242:0x176f, code lost:
        if (r1.equals("zh") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1243:0x1773, code lost:
        r3 = r0.getString(com.msandroid.mobile.R.string.audio_zh);
        t9.i.f(r3, "mContext.getString(R.string.audio_zh)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1246:0x178b, code lost:
        return "Zhuang";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1249:0x1799, code lost:
        return "Yoruba";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1252:0x17a7, code lost:
        return "Yiddish";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1255:0x17b5, code lost:
        return "Xhosa";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1258:0x17c3, code lost:
        return "Wolof";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1261:0x17d1, code lost:
        return "Walloon";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1264:0x17df, code lost:
        return "Volapük";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1267:0x17ed, code lost:
        return "Vietnamese";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1270:0x17fb, code lost:
        return "Venda";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1273:0x1809, code lost:
        return "Uzbek";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1276:0x1817, code lost:
        return "Urdu";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1279:0x1825, code lost:
        return "Ukrainian";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1282:0x1833, code lost:
        return "Uighur";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1285:0x1841, code lost:
        return "Tahitian";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1288:0x184f, code lost:
        return "Twi";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1291:0x185d, code lost:
        return "Tatar";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1294:0x186b, code lost:
        return "Tsonga";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1297:0x1879, code lost:
        return "Turkish";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1300:0x1887, code lost:
        return "Tonga (Tonga Islands)";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1303:0x1895, code lost:
        return "Tswana";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1306:0x18a3, code lost:
        return "Tagalog";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1309:0x18b1, code lost:
        return "Turkmen";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0299, code lost:
        if (r1.equals("mao (b)") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1312:0x18bf, code lost:
        return "Tigrinya";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1315:0x18cd, code lost:
        return "Thai";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1318:0x18db, code lost:
        return "Tajik";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1321:0x18e9, code lost:
        return "Telugu";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1324:0x18f7, code lost:
        return "Tamil";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1327:0x1905, code lost:
        return "Swahili (macrolanguage)";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02a3, code lost:
        if (r1.equals("mac (b)") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1330:0x1913, code lost:
        return "Swedish";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1333:0x1921, code lost:
        return "Sundanese";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1336:0x192f, code lost:
        return "Southern Sotho";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1339:0x193d, code lost:
        return "Swati";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1341:0x1947, code lost:
        if (r1.equals("sr") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1343:0x1951, code lost:
        if (r1.equals("sq") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1346:0x195f, code lost:
        return "Somali";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1349:0x196d, code lost:
        return "Shona";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02ad, code lost:
        if (r1.equals("ces (t)") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1352:0x197b, code lost:
        return "Samoan";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1355:0x1989, code lost:
        return "Slovenian";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1357:0x1993, code lost:
        if (r1.equals("sk") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1360:0x19a1, code lost:
        return "Sinhala";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1363:0x19af, code lost:
        return "Sango";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1366:0x19bd, code lost:
        return "Northern Sami";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1369:0x19cb, code lost:
        return "Sindhi";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1372:0x19d9, code lost:
        return "Sardinian";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1375:0x19e7, code lost:
        return "Sanskrit";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1378:0x19f5, code lost:
        return "Kinyarwanda";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1381:0x1a03, code lost:
        return "Russian";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1383:0x1a0d, code lost:
        if (r1.equals("ro") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1387:0x1a1e, code lost:
        return "Rundi";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1390:0x1a2c, code lost:
        return "Romansh";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1393:0x1a3a, code lost:
        return "Quechua";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1395:0x1a44, code lost:
        if (r1.equals("pt") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1396:0x1a48, code lost:
        r3 = r0.getString(com.msandroid.mobile.R.string.language_pt);
        t9.i.f(r3, "mContext.getString(R.string.language_pt)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1399:0x1a60, code lost:
        return "Pushto";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x02c5, code lost:
        if (r1.equals("scc (b)(d)") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1402:0x1a6e, code lost:
        return "Polish";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1405:0x1a7c, code lost:
        return "Pali";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1408:0x1a8a, code lost:
        return "Panjabi";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1411:0x1a98, code lost:
        return "Ossetian";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1414:0x1aa6, code lost:
        return "Oriya";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1417:0x1ab4, code lost:
        return "Oromo";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1420:0x1ac2, code lost:
        return "Ojibwa";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1423:0x1ad0, code lost:
        return "Occitan ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1426:0x1ade, code lost:
        return "Nyanja";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1429:0x1aec, code lost:
        return "Navajo";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1432:0x1afa, code lost:
        return "South Ndebele";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1435:0x1b08, code lost:
        return "Norwegian";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1438:0x1b16, code lost:
        return "Norwegian Nynorsk";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1440:0x1b20, code lost:
        if (r1.equals("nl") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1444:0x1b31, code lost:
        return "Ndonga";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1447:0x1b3f, code lost:
        return "Nepali";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1450:0x1b4d, code lost:
        return "North Ndebele";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1453:0x1b5b, code lost:
        return "Norwegian Bokmål";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1456:0x1b69, code lost:
        return "Nauru";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1458:0x1b73, code lost:
        if (r1.equals("my") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1462:0x1b84, code lost:
        return "Maltese";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1468:0x1baa, code lost:
        return "Marathi";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1471:0x1bb8, code lost:
        return "Moldavian";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1474:0x1bc6, code lost:
        return "Mongolian";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1477:0x1bd4, code lost:
        return "Malayalam";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1479:0x1bde, code lost:
        if (r1.equals("mk") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x02eb, code lost:
        if (r1.equals("gre (b)") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1482:0x1beb, code lost:
        if (r1.equals("mi") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1486:0x1bfc, code lost:
        return "Marshallese";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1489:0x1c0a, code lost:
        return "Malagasy";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1492:0x1c18, code lost:
        return "Latvian";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1495:0x1c26, code lost:
        return "Luba-Katanga";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1498:0x1c34, code lost:
        return "Lithuanian";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x02f5, code lost:
        if (r1.equals("bur (b)") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1501:0x1c42, code lost:
        return "Lao";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1504:0x1c50, code lost:
        return "Lingala";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1507:0x1c5e, code lost:
        return "Limburgan";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1510:0x1c6c, code lost:
        return "Ganda";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1513:0x1c7a, code lost:
        return "Luxembourgish";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1516:0x1c88, code lost:
        return "Latin";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1519:0x1c96, code lost:
        return "Kirghiz";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1522:0x1ca4, code lost:
        return "Cornish";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1525:0x1cb2, code lost:
        return "Komi";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1528:0x1cc0, code lost:
        return "Kurdish";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1531:0x1cce, code lost:
        return "Kashmiri";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1534:0x1cdc, code lost:
        return "Kanuri";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1537:0x1cea, code lost:
        return "Korean";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1540:0x1cf8, code lost:
        return "Kannada";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1543:0x1d06, code lost:
        return "Central Khmer";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1546:0x1d14, code lost:
        return "Kalaallisut";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1549:0x1d22, code lost:
        return "Kazakh";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1552:0x1d30, code lost:
        return "Kuanyama";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1555:0x1d3e, code lost:
        return "Kikuyu";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1558:0x1d4c, code lost:
        return "Kongo";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1563:0x1d64, code lost:
        return "Javanese";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1565:0x1d6e, code lost:
        if (r1.equals("ja") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1566:0x1d72, code lost:
        r3 = r0.getString(com.msandroid.mobile.R.string.audio_jpn);
        t9.i.f(r3, "mContext.getString(R.string.audio_jpn)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1569:0x1d8a, code lost:
        return "Inuktitut";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1571:0x1d94, code lost:
        if (r1.equals("it") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1572:0x1d98, code lost:
        r3 = r0.getString(com.msandroid.mobile.R.string.audio_ita);
        t9.i.f(r3, "mContext.getString(R.string.audio_ita)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1575:0x1db0, code lost:
        return "Icelandic";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1578:0x1dbe, code lost:
        return "Ido";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1581:0x1dcc, code lost:
        return "Inupiaq";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1584:0x1dda, code lost:
        return "Sichuan Yi";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1587:0x1de8, code lost:
        return "Igbo";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1590:0x1df6, code lost:
        return "Interlingue";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1593:0x1e04, code lost:
        return "Indonesian";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1596:0x1e12, code lost:
        return "Interlingua ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1599:0x1e20, code lost:
        return "Herero";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1604:0x1e38, code lost:
        return "Hungarian";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1607:0x1e46, code lost:
        return "Haitian";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1609:0x1e50, code lost:
        if (r1.equals("hr") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0333, code lost:
        if (r1.equals("bod (t)") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1613:0x1e61, code lost:
        return "Hiri Motu";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1615:0x1e6b, code lost:
        if (r1.equals("hi") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1616:0x1e6f, code lost:
        r3 = r0.getString(com.msandroid.mobile.R.string.language_hi);
        t9.i.f(r3, "mContext.getString(R.string.language_hi)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1618:0x1e83, code lost:
        if (r1.equals("he") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1619:0x1e87, code lost:
        r3 = r0.getString(com.msandroid.mobile.R.string.audio_heb);
        t9.i.f(r3, "mContext.getString(R.string.audio_heb)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1622:0x1e9f, code lost:
        return "Hausa";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1625:0x1ead, code lost:
        return "Manx";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1628:0x1ebb, code lost:
        return "Gujarati";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1631:0x1ec9, code lost:
        return "Guarani";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1634:0x1ed7, code lost:
        return "Galician";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1637:0x1ee5, code lost:
        return "Scottish Gaelic";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1640:0x1ef3, code lost:
        return "Irish";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1643:0x1f01, code lost:
        return "Western Frisian";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1645:0x1f0b, code lost:
        if (r1.equals("fr") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1648:0x1f19, code lost:
        return "Faroese";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1651:0x1f27, code lost:
        return "Fijian";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1654:0x1f35, code lost:
        return "Finnish";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1657:0x1f43, code lost:
        return "Fulah";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1659:0x1f4d, code lost:
        if (r1.equals("fa") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1661:0x1f57, code lost:
        if (r1.equals("eu") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1664:0x1f65, code lost:
        return "Estonian";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1666:0x1f6f, code lost:
        if (r1.equals("es") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1667:0x1f73, code lost:
        r3 = r0.getString(com.msandroid.mobile.R.string.language_es);
        t9.i.f(r3, "mContext.getString(R.string.language_es)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1670:0x1f8b, code lost:
        return "Esperanto";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1672:0x1f95, code lost:
        if (r1.equals(com.hpplay.cybergarage.xml.XML.DEFAULT_CONTENT_LANGUAGE) == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1673:0x1f99, code lost:
        r3 = r0.getString(com.msandroid.mobile.R.string.language_en);
        t9.i.f(r3, "mContext.getString(R.string.language_en)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1675:0x1fad, code lost:
        if (r1.equals("el") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1678:0x1fbb, code lost:
        return "Ewe";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1681:0x1fc9, code lost:
        return "Dzongkha";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1684:0x1fd7, code lost:
        return "Dhivehi";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1687:0x1fe5, code lost:
        return "German";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1690:0x1ff3, code lost:
        return "Danish";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1692:0x1ffd, code lost:
        if (r1.equals("cy") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1696:0x200e, code lost:
        return "Chuvash";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1699:0x201c, code lost:
        return "Church Slavic";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1701:0x2026, code lost:
        if (r1.equals("cs") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1705:0x2037, code lost:
        return "Cree";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1708:0x2045, code lost:
        return "Corsican";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1711:0x2053, code lost:
        return "Chamorro";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1714:0x2061, code lost:
        return "Chechen";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1717:0x206f, code lost:
        return "Catalan";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1720:0x207d, code lost:
        return "Bosnian";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1723:0x208b, code lost:
        return "Breton";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1725:0x2095, code lost:
        if (r1.equals("bo") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1728:0x20a3, code lost:
        return "Bengali";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1731:0x20b1, code lost:
        return "Bambara";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1734:0x20bf, code lost:
        return "Bislama";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1739:0x20d7, code lost:
        return "Bulgarian";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1742:0x20e5, code lost:
        return "Belarusian";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1745:0x20f3, code lost:
        return "Bashkir";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1748:0x2101, code lost:
        return "Azerbaijani";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1751:0x210f, code lost:
        return "Aymara";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1754:0x211d, code lost:
        return "Avaric";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1757:0x212b, code lost:
        return "Assamese";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1759:0x2135, code lost:
        if (r1.equals("ar") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1760:0x2139, code lost:
        r3 = r0.getString(com.msandroid.mobile.R.string.audio_ara);
        t9.i.f(r3, "mContext.getString(R.string.audio_ara)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1763:0x2151, code lost:
        return "Aragonese";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1766:0x215f, code lost:
        return "Amharic";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1769:0x216d, code lost:
        return "Akan";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1772:0x217b, code lost:
        return "Afrikaans";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1775:0x2189, code lost:
        return "Avestan";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1778:0x2197, code lost:
        return "Abkhazian";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1781:0x21a5, code lost:
        return "Afar";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1783:0x21af, code lost:
        if (r1.equals("ger (b)") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1784:0x21b3, code lost:
        r3 = r0.getString(com.msandroid.mobile.R.string.audio_ger);
        t9.i.f(r3, "mContext.getString(R.string.audio_ger)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1792:0x21e3, code lost:
        return "Bihari";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1798:0x21ff, code lost:
        return "Berber";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1804:0x221b, code lost:
        return "Baltic";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1806:0x2225, code lost:
        if (r1.equals("baq (b)") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1809:0x2233, code lost:
        return "Bamileke languages";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1812:0x2241, code lost:
        return "Banda languages";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1820:0x2267, code lost:
        if (r1.equals("fre (b)") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1822:0x2271, code lost:
        if (r1.equals("fra (t)") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1823:0x2275, code lost:
        r3 = r0.getString(com.msandroid.mobile.R.string.language_fr);
        t9.i.f(r3, "mContext.getString(R.string.language_fr)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1826:0x228d, code lost:
        return "Australian languages";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1828:0x2297, code lost:
        if (r1.equals("per (b)") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1831:0x22a5, code lost:
        return "Athapascan languages";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1834:0x22b3, code lost:
        return "Artificial";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1837:0x22c1, code lost:
        return "Armenian";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1849:0x22f9, code lost:
        return "Georgian";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1863:0x233b, code lost:
        if (r1.equals("fas (t)") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1869:0x2356, code lost:
        if (r1.equals("tib (b)") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1872:0x2363, code lost:
        if (r1.equals("eus (t)") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1878:0x237e, code lost:
        if (r1.equals("ell (t)") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1884:0x2399, code lost:
        if (r1.equals("srp (t)") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1887:0x23a5, code lost:
        if (r1.equals("sqi (t)") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1899:0x23d5, code lost:
        if (r1.equals("slo (b)") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1901:0x23de, code lost:
        if (r1.equals("slk (t)") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1911:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1912:?, code lost:
        return "Romanian";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1913:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1914:?, code lost:
        return "Dutch";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1915:?, code lost:
        return "Burmese";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1917:?, code lost:
        return "Macedonian";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1918:?, code lost:
        return "Maori";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1919:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1920:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1921:?, code lost:
        return "Croatian";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1922:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1923:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1924:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1925:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1926:?, code lost:
        return "Welsh";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1927:?, code lost:
        return "Czech";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1928:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1929:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1930:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1931:?, code lost:
        return "Persian";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1932:?, code lost:
        return "Tibetan";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1933:?, code lost:
        return "Basque";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1934:?, code lost:
        return "Modern Greek";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1935:?, code lost:
        return "Serbian";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1936:?, code lost:
        return "Albanian";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1937:?, code lost:
        return "Slovak";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x008d, code lost:
        if (r1.equals("nld (t)") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0097, code lost:
        if (r1.equals("dut (b)") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:347:0x06b3, code lost:
        if (r1.equals("spa") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:448:0x0895, code lost:
        if (r1.equals("por") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0141, code lost:
        if (r1.equals("rum (b)") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0159, code lost:
        if (r1.equals("mya (t)") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x017f, code lost:
        if (r1.equals("ron (t)") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:774:0x0ea7, code lost:
        if (r1.equals("jpn") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:781:0x0ec9, code lost:
        if (r1.equals("ita") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a1, code lost:
        if (r1.equals("mri (t)") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01ab, code lost:
        if (r1.equals("cze (b)") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:826:0x0fa3, code lost:
        if (r1.equals("hin") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01b5, code lost:
        if (r1.equals("cym (t)") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:833:0x0fc5, code lost:
        if (r1.equals("heb") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01cd, code lost:
        if (r1.equals("wel (b)") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:890:0x10d5, code lost:
        if (r1.equals("ger") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:920:0x1163, code lost:
        if (r1.equals("fre") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01e5, code lost:
        if (r1.equals("hrv (t)") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:945:0x11db, code lost:
        if (r1.equals("eus") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:954:0x1207, code lost:
        if (r1.equals("eng") == false) goto L_0x23f0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:1906:0x23f0 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getTranslateString(android.content.Context r20, java.lang.String r21) {
        /*
            r19 = this;
            r0 = r20
            r1 = r21
            java.lang.String r2 = "context"
            t9.i.g(r0, r2)
            java.lang.String r2 = "language"
            t9.i.g(r1, r2)
            int r2 = r21.hashCode()
            java.lang.String r3 = "Malay (macrolanguage)"
            java.lang.String r4 = "Romanian"
            java.lang.String r5 = "Dutch"
            java.lang.String r6 = "Burmese"
            java.lang.String r7 = "Macedonian"
            java.lang.String r8 = "Maori"
            java.lang.String r9 = "Croatian"
            java.lang.String r10 = "Welsh"
            java.lang.String r11 = "Czech"
            java.lang.String r12 = "Persian"
            java.lang.String r13 = "Tibetan"
            java.lang.String r14 = "Basque"
            java.lang.String r15 = "Modern Greek"
            java.lang.String r16 = "Serbian"
            java.lang.String r17 = "Albanian"
            java.lang.String r18 = "Slovak"
            switch(r2) {
                case -2128733913: goto L_0x23e4;
                case -2119498641: goto L_0x23d8;
                case -2115805115: goto L_0x23cf;
                case -2092716594: goto L_0x23c3;
                case -2030841152: goto L_0x23b7;
                case -2012699483: goto L_0x23ab;
                case -1978199928: goto L_0x239f;
                case -1943106130: goto L_0x2393;
                case -1928329856: goto L_0x2385;
                case -1658724766: goto L_0x2378;
                case -1548762725: goto L_0x236a;
                case -1394597760: goto L_0x235d;
                case -1326194660: goto L_0x2350;
                case -1141819180: goto L_0x2342;
                case -1079677099: goto L_0x2335;
                case -974927650: goto L_0x2327;
                case -969715399: goto L_0x2319;
                case -966020974: goto L_0x230b;
                case -938050038: goto L_0x22fd;
                case -936202469: goto L_0x22ef;
                case -848796911: goto L_0x22e1;
                case -811198321: goto L_0x22d3;
                case -745957205: goto L_0x22c5;
                case -741074325: goto L_0x22b7;
                case -734609182: goto L_0x22a9;
                case -688433473: goto L_0x229b;
                case -680982356: goto L_0x2291;
                case -649645591: goto L_0x2283;
                case -609604910: goto L_0x226b;
                case -605911384: goto L_0x2261;
                case -603406096: goto L_0x2253;
                case -454125034: goto L_0x2245;
                case -348577869: goto L_0x2237;
                case -343960140: goto L_0x2229;
                case -336572127: goto L_0x221f;
                case -333801068: goto L_0x2211;
                case -324503095: goto L_0x2203;
                case -221131506: goto L_0x21f5;
                case -151147042: goto L_0x21e7;
                case -115850577: goto L_0x21d9;
                case -83198002: goto L_0x21cb;
                case -81351456: goto L_0x21c1;
                case -78580893: goto L_0x21a9;
                case 3104: goto L_0x219b;
                case 3105: goto L_0x218d;
                case 3108: goto L_0x217f;
                case 3109: goto L_0x2171;
                case 3114: goto L_0x2163;
                case 3116: goto L_0x2155;
                case 3117: goto L_0x2147;
                case 3121: goto L_0x212f;
                case 3122: goto L_0x2121;
                case 3125: goto L_0x2113;
                case 3128: goto L_0x2105;
                case 3129: goto L_0x20f7;
                case 3135: goto L_0x20e9;
                case 3139: goto L_0x20db;
                case 3141: goto L_0x20cd;
                case 3142: goto L_0x20c3;
                case 3143: goto L_0x20b5;
                case 3147: goto L_0x20a7;
                case 3148: goto L_0x2099;
                case 3149: goto L_0x208f;
                case 3152: goto L_0x2081;
                case 3153: goto L_0x2073;
                case 3166: goto L_0x2065;
                case 3170: goto L_0x2057;
                case 3173: goto L_0x2049;
                case 3180: goto L_0x203b;
                case 3183: goto L_0x202d;
                case 3184: goto L_0x2020;
                case 3186: goto L_0x2012;
                case 3187: goto L_0x2004;
                case 3190: goto L_0x1ff7;
                case 3197: goto L_0x1fe9;
                case 3201: goto L_0x1fdb;
                case 3218: goto L_0x1fcd;
                case 3222: goto L_0x1fbf;
                case 3232: goto L_0x1fb1;
                case 3239: goto L_0x1fa7;
                case 3241: goto L_0x1f8f;
                case 3242: goto L_0x1f81;
                case 3246: goto L_0x1f69;
                case 3247: goto L_0x1f5b;
                case 3248: goto L_0x1f51;
                case 3259: goto L_0x1f47;
                case 3264: goto L_0x1f39;
                case 3267: goto L_0x1f2b;
                case 3268: goto L_0x1f1d;
                case 3273: goto L_0x1f0f;
                case 3276: goto L_0x1f05;
                case 3283: goto L_0x1ef7;
                case 3290: goto L_0x1ee9;
                case 3293: goto L_0x1edb;
                case 3301: goto L_0x1ecd;
                case 3303: goto L_0x1ebf;
                case 3310: goto L_0x1eb1;
                case 3311: goto L_0x1ea3;
                case 3321: goto L_0x1e95;
                case 3325: goto L_0x1e7d;
                case 3329: goto L_0x1e65;
                case 3335: goto L_0x1e57;
                case 3338: goto L_0x1e4a;
                case 3340: goto L_0x1e3c;
                case 3341: goto L_0x1e2e;
                case 3345: goto L_0x1e24;
                case 3346: goto L_0x1e16;
                case 3352: goto L_0x1e08;
                case 3355: goto L_0x1dfa;
                case 3356: goto L_0x1dec;
                case 3358: goto L_0x1dde;
                case 3360: goto L_0x1dd0;
                case 3362: goto L_0x1dc2;
                case 3366: goto L_0x1db4;
                case 3370: goto L_0x1da6;
                case 3371: goto L_0x1d8e;
                case 3372: goto L_0x1d80;
                case 3383: goto L_0x1d68;
                case 3404: goto L_0x1d5a;
                case 3414: goto L_0x1d50;
                case 3420: goto L_0x1d42;
                case 3422: goto L_0x1d34;
                case 3423: goto L_0x1d26;
                case 3424: goto L_0x1d18;
                case 3425: goto L_0x1d0a;
                case 3426: goto L_0x1cfc;
                case 3427: goto L_0x1cee;
                case 3428: goto L_0x1ce0;
                case 3431: goto L_0x1cd2;
                case 3432: goto L_0x1cc4;
                case 3434: goto L_0x1cb6;
                case 3435: goto L_0x1ca8;
                case 3436: goto L_0x1c9a;
                case 3438: goto L_0x1c8c;
                case 3445: goto L_0x1c7e;
                case 3446: goto L_0x1c70;
                case 3451: goto L_0x1c62;
                case 3453: goto L_0x1c54;
                case 3458: goto L_0x1c46;
                case 3459: goto L_0x1c38;
                case 3464: goto L_0x1c2a;
                case 3465: goto L_0x1c1c;
                case 3466: goto L_0x1c0e;
                case 3482: goto L_0x1c00;
                case 3483: goto L_0x1bf2;
                case 3484: goto L_0x1be5;
                case 3486: goto L_0x1bd8;
                case 3487: goto L_0x1bca;
                case 3489: goto L_0x1bbc;
                case 3490: goto L_0x1bae;
                case 3493: goto L_0x1ba0;
                case 3494: goto L_0x1b88;
                case 3495: goto L_0x1b7a;
                case 3500: goto L_0x1b6d;
                case 3507: goto L_0x1b5f;
                case 3508: goto L_0x1b51;
                case 3510: goto L_0x1b43;
                case 3511: goto L_0x1b35;
                case 3513: goto L_0x1b27;
                case 3518: goto L_0x1b1a;
                case 3520: goto L_0x1b0c;
                case 3521: goto L_0x1afe;
                case 3524: goto L_0x1af0;
                case 3528: goto L_0x1ae2;
                case 3531: goto L_0x1ad4;
                case 3540: goto L_0x1ac6;
                case 3547: goto L_0x1ab8;
                case 3550: goto L_0x1aaa;
                case 3555: goto L_0x1a9c;
                case 3556: goto L_0x1a8e;
                case 3569: goto L_0x1a80;
                case 3577: goto L_0x1a72;
                case 3580: goto L_0x1a64;
                case 3587: goto L_0x1a56;
                case 3588: goto L_0x1a3e;
                case 3620: goto L_0x1a30;
                case 3643: goto L_0x1a22;
                case 3644: goto L_0x1a14;
                case 3645: goto L_0x1a07;
                case 3651: goto L_0x19f9;
                case 3653: goto L_0x19eb;
                case 3662: goto L_0x19dd;
                case 3664: goto L_0x19cf;
                case 3665: goto L_0x19c1;
                case 3666: goto L_0x19b3;
                case 3668: goto L_0x19a5;
                case 3670: goto L_0x1997;
                case 3672: goto L_0x198d;
                case 3673: goto L_0x197f;
                case 3674: goto L_0x1971;
                case 3675: goto L_0x1963;
                case 3676: goto L_0x1955;
                case 3678: goto L_0x194b;
                case 3679: goto L_0x1941;
                case 3680: goto L_0x1933;
                case 3681: goto L_0x1925;
                case 3682: goto L_0x1917;
                case 3683: goto L_0x1909;
                case 3684: goto L_0x18fb;
                case 3693: goto L_0x18ed;
                case 3697: goto L_0x18df;
                case 3699: goto L_0x18d1;
                case 3700: goto L_0x18c3;
                case 3701: goto L_0x18b5;
                case 3703: goto L_0x18a7;
                case 3704: goto L_0x1899;
                case 3706: goto L_0x188b;
                case 3707: goto L_0x187d;
                case 3710: goto L_0x186f;
                case 3711: goto L_0x1861;
                case 3712: goto L_0x1853;
                case 3715: goto L_0x1845;
                case 3717: goto L_0x1837;
                case 3730: goto L_0x1829;
                case 3734: goto L_0x181b;
                case 3741: goto L_0x180d;
                case 3749: goto L_0x17ff;
                case 3759: goto L_0x17f1;
                case 3763: goto L_0x17e3;
                case 3769: goto L_0x17d5;
                case 3786: goto L_0x17c7;
                case 3800: goto L_0x17b9;
                case 3824: goto L_0x17ab;
                case 3856: goto L_0x179d;
                case 3862: goto L_0x178f;
                case 3879: goto L_0x1781;
                case 3886: goto L_0x1769;
                case 3899: goto L_0x175b;
                case 96338: goto L_0x1751;
                case 96362: goto L_0x1747;
                case 96387: goto L_0x1739;
                case 96390: goto L_0x172b;
                case 96414: goto L_0x171d;
                case 96438: goto L_0x170f;
                case 96476: goto L_0x1701;
                case 96483: goto L_0x16f3;
                case 96493: goto L_0x16e9;
                case 96582: goto L_0x16db;
                case 96631: goto L_0x16d1;
                case 96641: goto L_0x16c3;
                case 96663: goto L_0x16b9;
                case 96666: goto L_0x16ab;
                case 96668: goto L_0x169d;
                case 96681: goto L_0x168f;
                case 96700: goto L_0x1685;
                case 96730: goto L_0x1677;
                case 96739: goto L_0x1669;
                case 96786: goto L_0x165b;
                case 96848: goto L_0x1651;
                case 96850: goto L_0x1643;
                case 96854: goto L_0x1639;
                case 96860: goto L_0x162f;
                case 96861: goto L_0x1621;
                case 96863: goto L_0x1613;
                case 96867: goto L_0x1609;
                case 96870: goto L_0x15fb;
                case 96891: goto L_0x15f1;
                case 96898: goto L_0x15e3;
                case 96917: goto L_0x15d9;
                case 96959: goto L_0x15cf;
                case 96972: goto L_0x15c5;
                case 96976: goto L_0x15bb;
                case 97003: goto L_0x15ad;
                case 97077: goto L_0x15a3;
                case 97100: goto L_0x1599;
                case 97285: goto L_0x158f;
                case 97290: goto L_0x1585;
                case 97292: goto L_0x157b;
                case 97293: goto L_0x156d;
                case 97294: goto L_0x1563;
                case 97295: goto L_0x1555;
                case 97298: goto L_0x154b;
                case 97300: goto L_0x153d;
                case 97301: goto L_0x1533;
                case 97415: goto L_0x1525;
                case 97417: goto L_0x151b;
                case 97418: goto L_0x150d;
                case 97419: goto L_0x1503;
                case 97423: goto L_0x14f9;
                case 97513: goto L_0x14eb;
                case 97537: goto L_0x14e1;
                case 97540: goto L_0x14d3;
                case 97543: goto L_0x14c5;
                case 97548: goto L_0x14bb;
                case 97623: goto L_0x14ad;
                case 97704: goto L_0x149f;
                case 97719: goto L_0x1495;
                case 97734: goto L_0x148b;
                case 97809: goto L_0x147d;
                case 97813: goto L_0x1473;
                case 97902: goto L_0x1465;
                case 97908: goto L_0x1457;
                case 97913: goto L_0x144d;
                case 98039: goto L_0x143f;
                case 98246: goto L_0x1431;
                case 98260: goto L_0x1423;
                case 98262: goto L_0x1419;
                case 98368: goto L_0x140b;
                case 98460: goto L_0x1401;
                case 98461: goto L_0x13f3;
                case 98464: goto L_0x13e9;
                case 98466: goto L_0x13db;
                case 98468: goto L_0x13d1;
                case 98470: goto L_0x13c3;
                case 98472: goto L_0x13b5;
                case 98473: goto L_0x13a7;
                case 98474: goto L_0x1399;
                case 98475: goto L_0x138b;
                case 98477: goto L_0x137d;
                case 98480: goto L_0x1373;
                case 98481: goto L_0x1369;
                case 98484: goto L_0x135b;
                case 98692: goto L_0x134d;
                case 98694: goto L_0x1343;
                case 98695: goto L_0x1339;
                case 98774: goto L_0x132f;
                case 98777: goto L_0x1321;
                case 98802: goto L_0x1313;
                case 99214: goto L_0x1305;
                case 99217: goto L_0x12fb;
                case 99221: goto L_0x12ed;
                case 99339: goto L_0x12df;
                case 99341: goto L_0x12d1;
                case 99407: goto L_0x12c3;
                case 99465: goto L_0x12b5;
                case 99473: goto L_0x12ab;
                case 99646: goto L_0x129d;
                case 99763: goto L_0x128f;
                case 99824: goto L_0x1281;
                case 99836: goto L_0x1273;
                case 99843: goto L_0x125b;
                case 99968: goto L_0x124d;
                case 99993: goto L_0x1243;
                case 100328: goto L_0x1235;
                case 100375: goto L_0x1227;
                case 100475: goto L_0x1219;
                case 100529: goto L_0x120b;
                case 100574: goto L_0x1201;
                case 100580: goto L_0x11f3;
                case 100644: goto L_0x11e9;
                case 100742: goto L_0x11df;
                case 100803: goto L_0x11d5;
                case 100851: goto L_0x11cb;
                case 100861: goto L_0x11bd;
                case 101139: goto L_0x11af;
                case 101140: goto L_0x11a5;
                case 101145: goto L_0x1197;
                case 101383: goto L_0x118d;
                case 101385: goto L_0x117f;
                case 101387: goto L_0x1175;
                case 101573: goto L_0x1167;
                case 101657: goto L_0x115d;
                case 101665: goto L_0x114f;
                case 101667: goto L_0x1141;
                case 101670: goto L_0x1133;
                case 101671: goto L_0x1125;
                case 101677: goto L_0x111b;
                case 101757: goto L_0x1111;
                case 101763: goto L_0x1103;
                case 102087: goto L_0x10f5;
                case 102111: goto L_0x10e7;
                case 102118: goto L_0x10d9;
                case 102228: goto L_0x10cf;
                case 102236: goto L_0x10c1;
                case 102346: goto L_0x10b3;
                case 102428: goto L_0x10a9;
                case 102432: goto L_0x109f;
                case 102434: goto L_0x1095;
                case 102449: goto L_0x108b;
                case 102466: goto L_0x107d;
                case 102528: goto L_0x106f;
                case 102534: goto L_0x1061;
                case 102538: goto L_0x1053;
                case 102540: goto L_0x1045;
                case 102615: goto L_0x1037;
                case 102616: goto L_0x1029;
                case 102627: goto L_0x101f;
                case 102667: goto L_0x1011;
                case 102716: goto L_0x1007;
                case 102777: goto L_0x0ff9;
                case 103056: goto L_0x0feb;
                case 103067: goto L_0x0fe1;
                case 103068: goto L_0x0fd7;
                case 103070: goto L_0x0fc9;
                case 103173: goto L_0x0fbf;
                case 103189: goto L_0x0fb5;
                case 103307: goto L_0x0fa7;
                case 103309: goto L_0x0f9d;
                case 103315: goto L_0x0f8f;
                case 103433: goto L_0x0f81;
                case 103434: goto L_0x0f77;
                case 103607: goto L_0x0f69;
                case 103681: goto L_0x0f5f;
                case 103683: goto L_0x0f51;
                case 104040: goto L_0x0f43;
                case 104054: goto L_0x0f39;
                case 104116: goto L_0x0f2f;
                case 104265: goto L_0x0f25;
                case 104339: goto L_0x0f1b;
                case 104354: goto L_0x0f11;
                case 104364: goto L_0x0f03;
                case 104412: goto L_0x0ef9;
                case 104415: goto L_0x0eef;
                case 104419: goto L_0x0ee1;
                case 104484: goto L_0x0ed7;
                case 104578: goto L_0x0ecd;
                case 104598: goto L_0x0ec3;
                case 104991: goto L_0x0eb9;
                case 105015: goto L_0x0eab;
                case 105448: goto L_0x0ea1;
                case 105452: goto L_0x0e93;
                case 105498: goto L_0x0e85;
                case 105931: goto L_0x0e77;
                case 105932: goto L_0x0e69;
                case 105933: goto L_0x0e5b;
                case 105942: goto L_0x0e51;
                case 105943: goto L_0x0e43;
                case 105944: goto L_0x0e39;
                case 105949: goto L_0x0e2f;
                case 105951: goto L_0x0e25;
                case 105953: goto L_0x0e17;
                case 105956: goto L_0x0e0d;
                case 105965: goto L_0x0dff;
                case 106148: goto L_0x0df1;
                case 106160: goto L_0x0de7;
                case 106162: goto L_0x0dd9;
                case 106189: goto L_0x0dcf;
                case 106192: goto L_0x0dc5;
                case 106196: goto L_0x0dbb;
                case 106304: goto L_0x0dad;
                case 106375: goto L_0x0d9f;
                case 106377: goto L_0x0d95;
                case 106378: goto L_0x0d8b;
                case 106382: goto L_0x0d81;
                case 106383: goto L_0x0d73;
                case 106400: goto L_0x0d65;
                case 106460: goto L_0x0d57;
                case 106469: goto L_0x0d49;
                case 106478: goto L_0x0d3b;
                case 106551: goto L_0x0d31;
                case 106563: goto L_0x0d23;
                case 106568: goto L_0x0d19;
                case 106570: goto L_0x0d0b;
                case 106895: goto L_0x0cfd;
                case 106899: goto L_0x0cef;
                case 106904: goto L_0x0ce1;
                case 106906: goto L_0x0cd7;
                case 106911: goto L_0x0ccd;
                case 106913: goto L_0x0cc3;
                case 107041: goto L_0x0cb5;
                case 107152: goto L_0x0cab;
                case 107153: goto L_0x0ca1;
                case 107159: goto L_0x0c97;
                case 107337: goto L_0x0c89;
                case 107351: goto L_0x0c7b;
                case 107506: goto L_0x0c71;
                case 107512: goto L_0x0c63;
                case 107513: goto L_0x0c59;
                case 107518: goto L_0x0c4f;
                case 107520: goto L_0x0c41;
                case 107525: goto L_0x0c33;
                case 107526: goto L_0x0c25;
                case 107530: goto L_0x0c17;
                case 107856: goto L_0x0c09;
                case 107859: goto L_0x0bfb;
                case 107860: goto L_0x0bf1;
                case 107861: goto L_0x0be3;
                case 107863: goto L_0x0bd5;
                case 107864: goto L_0x0bcb;
                case 107866: goto L_0x0bbd;
                case 107870: goto L_0x0bb3;
                case 107871: goto L_0x0ba5;
                case 107951: goto L_0x0b97;
                case 107963: goto L_0x0b89;
                case 107990: goto L_0x0b7b;
                case 108039: goto L_0x0b6d;
                case 108103: goto L_0x0b5f;
                case 108114: goto L_0x0b51;
                case 108119: goto L_0x0b43;
                case 108200: goto L_0x0b39;
                case 108213: goto L_0x0b2f;
                case 108258: goto L_0x0b21;
                case 108264: goto L_0x0b13;
                case 108294: goto L_0x0b05;
                case 108298: goto L_0x0afb;
                case 108300: goto L_0x0af1;
                case 108305: goto L_0x0ae3;
                case 108484: goto L_0x0ad5;
                case 108491: goto L_0x0ac7;
                case 108546: goto L_0x0ab9;
                case 108552: goto L_0x0aab;
                case 108618: goto L_0x0a9d;
                case 108829: goto L_0x0a8f;
                case 108834: goto L_0x0a85;
                case 108835: goto L_0x0a7b;
                case 108856: goto L_0x0a71;
                case 108911: goto L_0x0a67;
                case 108921: goto L_0x0a5d;
                case 108925: goto L_0x0a4f;
                case 108953: goto L_0x0a45;
                case 108960: goto L_0x0a37;
                case 109062: goto L_0x0a29;
                case 109082: goto L_0x0a1b;
                case 109231: goto L_0x0a11;
                case 109249: goto L_0x0a07;
                case 109254: goto L_0x09f9;
                case 109261: goto L_0x09eb;
                case 109265: goto L_0x09e1;
                case 109324: goto L_0x09d3;
                case 109386: goto L_0x09c5;
                case 109498: goto L_0x09b7;
                case 109558: goto L_0x09ad;
                case 109570: goto L_0x099f;
                case 109571: goto L_0x0991;
                case 109572: goto L_0x0983;
                case 109597: goto L_0x0975;
                case 109845: goto L_0x096b;
                case 110062: goto L_0x0961;
                case 110310: goto L_0x0957;
                case 110314: goto L_0x094d;
                case 110333: goto L_0x093f;
                case 110351: goto L_0x0935;
                case 110364: goto L_0x0927;
                case 110742: goto L_0x0919;
                case 110747: goto L_0x090b;
                case 110748: goto L_0x08fd;
                case 110749: goto L_0x08f3;
                case 110751: goto L_0x08e5;
                case 110756: goto L_0x08d7;
                case 110874: goto L_0x08c9;
                case 110966: goto L_0x08bb;
                case 111085: goto L_0x08b1;
                case 111181: goto L_0x08a7;
                case 111183: goto L_0x0899;
                case 111187: goto L_0x088f;
                case 111277: goto L_0x0881;
                case 111374: goto L_0x0877;
                case 112321: goto L_0x086d;
                case 112667: goto L_0x085f;
                case 112673: goto L_0x0851;
                case 112675: goto L_0x0843;
                case 113099: goto L_0x0839;
                case 113104: goto L_0x082b;
                case 113291: goto L_0x0821;
                case 113293: goto L_0x0813;
                case 113296: goto L_0x0809;
                case 113622: goto L_0x07fb;
                case 113625: goto L_0x07f1;
                case 113626: goto L_0x07e3;
                case 113631: goto L_0x07d5;
                case 113632: goto L_0x07cb;
                case 113637: goto L_0x07bd;
                case 113638: goto L_0x07af;
                case 113694: goto L_0x07a1;
                case 113695: goto L_0x0793;
                case 113754: goto L_0x0785;
                case 113805: goto L_0x0777;
                case 113849: goto L_0x0769;
                case 113870: goto L_0x075b;
                case 113880: goto L_0x0751;
                case 113981: goto L_0x0747;
                case 113991: goto L_0x0739;
                case 113995: goto L_0x072f;
                case 114000: goto L_0x0721;
                case 114004: goto L_0x0713;
                case 114005: goto L_0x0709;
                case 114009: goto L_0x06fb;
                case 114022: goto L_0x06f1;
                case 114025: goto L_0x06e7;
                case 114032: goto L_0x06d9;
                case 114059: goto L_0x06cb;
                case 114065: goto L_0x06c1;
                case 114072: goto L_0x06b7;
                case 114084: goto L_0x06ad;
                case 114149: goto L_0x06a3;
                case 114159: goto L_0x0695;
                case 114163: goto L_0x0687;
                case 114199: goto L_0x067d;
                case 114249: goto L_0x066f;
                case 114252: goto L_0x0665;
                case 114257: goto L_0x0657;
                case 114262: goto L_0x0649;
                case 114301: goto L_0x063f;
                case 114305: goto L_0x0635;
                case 114365: goto L_0x0627;
                case 114380: goto L_0x0619;
                case 114587: goto L_0x060f;
                case 114592: goto L_0x0605;
                case 114599: goto L_0x05fb;
                case 114715: goto L_0x05f1;
                case 114716: goto L_0x05e3;
                case 114721: goto L_0x05d5;
                case 114723: goto L_0x05c7;
                case 114776: goto L_0x05bd;
                case 114777: goto L_0x05b3;
                case 114797: goto L_0x05a9;
                case 114834: goto L_0x059b;
                case 114845: goto L_0x0591;
                case 114849: goto L_0x0583;
                case 114901: goto L_0x0575;
                case 114928: goto L_0x0567;
                case 114929: goto L_0x0559;
                case 114959: goto L_0x054b;
                case 115020: goto L_0x053d;
                case 115027: goto L_0x0533;
                case 115053: goto L_0x0525;
                case 115146: goto L_0x0517;
                case 115151: goto L_0x050d;
                case 115152: goto L_0x0503;
                case 115210: goto L_0x04f9;
                case 115212: goto L_0x04eb;
                case 115217: goto L_0x04e1;
                case 115242: goto L_0x04d3;
                case 115270: goto L_0x04c9;
                case 115345: goto L_0x04bb;
                case 115646: goto L_0x04ad;
                case 115727: goto L_0x049f;
                case 115795: goto L_0x0495;
                case 115868: goto L_0x048b;
                case 115914: goto L_0x047d;
                case 115947: goto L_0x046f;
                case 116071: goto L_0x0465;
                case 116317: goto L_0x045b;
                case 116510: goto L_0x044d;
                case 116639: goto L_0x0443;
                case 116754: goto L_0x0439;
                case 116947: goto L_0x042f;
                case 116955: goto L_0x0421;
                case 117474: goto L_0x0413;
                case 117480: goto L_0x0405;
                case 117481: goto L_0x03f7;
                case 117817: goto L_0x03ed;
                case 117908: goto L_0x03e3;
                case 118435: goto L_0x03d5;
                case 118655: goto L_0x03cb;
                case 119399: goto L_0x03bd;
                case 119400: goto L_0x03af;
                case 119636: goto L_0x03a5;
                case 119836: goto L_0x039b;
                case 120361: goto L_0x038d;
                case 120388: goto L_0x037f;
                case 120483: goto L_0x0371;
                case 120563: goto L_0x0367;
                case 120977: goto L_0x035d;
                case 120979: goto L_0x034f;
                case 121082: goto L_0x0341;
                case 38377895: goto L_0x0337;
                case 52230772: goto L_0x032d;
                case 76762939: goto L_0x031f;
                case 115861428: goto L_0x0307;
                case 201840647: goto L_0x02f9;
                case 236934414: goto L_0x02ef;
                case 281592297: goto L_0x02e5;
                case 543543882: goto L_0x02d7;
                case 554626134: goto L_0x02c9;
                case 638230155: goto L_0x02bf;
                case 660831049: goto L_0x02b1;
                case 667295758: goto L_0x02a7;
                case 823104478: goto L_0x029d;
                case 834186730: goto L_0x0293;
                case 835110747: goto L_0x0285;
                case 843421940: goto L_0x027b;
                case 881552227: goto L_0x026d;
                case 918821818: goto L_0x025f;
                case 969287063: goto L_0x0251;
                case 970210584: goto L_0x0243;
                case 979445794: goto L_0x0235;
                case 1010581404: goto L_0x022b;
                case 1036704096: goto L_0x021d;
                case 1110320067: goto L_0x0213;
                case 1114014089: goto L_0x0205;
                case 1115595019: goto L_0x01f7;
                case 1125362112: goto L_0x01e9;
                case 1184796393: goto L_0x01df;
                case 1206365848: goto L_0x01d1;
                case 1231034989: goto L_0x01c7;
                case 1232882186: goto L_0x01b9;
                case 1234337652: goto L_0x01af;
                case 1255578077: goto L_0x01a5;
                case 1315341729: goto L_0x019b;
                case 1336582712: goto L_0x0191;
                case 1364617155: goto L_0x0183;
                case 1376622990: goto L_0x0179;
                case 1405846384: goto L_0x016b;
                case 1445823434: goto L_0x015d;
                case 1508357618: goto L_0x0153;
                case 1520362988: goto L_0x0145;
                case 1547473817: goto L_0x013b;
                case 1556646481: goto L_0x0131;
                case 1627162394: goto L_0x0127;
                case 1715225795: goto L_0x0119;
                case 1716149781: goto L_0x010b;
                case 1836801692: goto L_0x00fd;
                case 1858700890: goto L_0x00ef;
                case 1861471112: goto L_0x00e1;
                case 1910354962: goto L_0x00d3;
                case 1939641863: goto L_0x00c5;
                case 1940236509: goto L_0x00b7;
                case 1942083551: goto L_0x00a9;
                case 1976911578: goto L_0x009b;
                case 2013788818: goto L_0x0091;
                case 2026452899: goto L_0x0087;
                case 2035093060: goto L_0x0079;
                case 2052906071: goto L_0x006b;
                case 2065835024: goto L_0x005d;
                case 2091694015: goto L_0x0053;
                case 2093274883: goto L_0x0045;
                case 2097892829: goto L_0x0037;
                default: goto L_0x0035;
            }
        L_0x0035:
            goto L_0x23f0
        L_0x0037:
            java.lang.String r0 = "sit (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0041
            goto L_0x23f0
        L_0x0041:
            java.lang.String r3 = "Sino-Tibetan (Other)"
            goto L_0x23ef
        L_0x0045:
            java.lang.String r0 = "sio (g)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x004f
            goto L_0x23f0
        L_0x004f:
            java.lang.String r3 = "Siouan languages"
            goto L_0x23ef
        L_0x0053:
            java.lang.String r0 = "isl (t)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1db0
            goto L_0x23f0
        L_0x005d:
            java.lang.String r0 = "iro (g)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0067
            goto L_0x23f0
        L_0x0067:
            java.lang.String r3 = "Iroquoian languages"
            goto L_0x23ef
        L_0x006b:
            java.lang.String r0 = "ira (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0075
            goto L_0x23f0
        L_0x0075:
            java.lang.String r3 = "Iranian (Other)"
            goto L_0x23ef
        L_0x0079:
            java.lang.String r0 = "sgn (g)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0083
            goto L_0x23f0
        L_0x0083:
            java.lang.String r3 = "Sign Languages"
            goto L_0x23ef
        L_0x0087:
            java.lang.String r0 = "nld (t)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1b24
            goto L_0x23f0
        L_0x0091:
            java.lang.String r0 = "dut (b)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1b24
            goto L_0x23f0
        L_0x009b:
            java.lang.String r0 = "sem (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x00a5
            goto L_0x23f0
        L_0x00a5:
            java.lang.String r3 = "Semitic (Other)"
            goto L_0x23ef
        L_0x00a9:
            java.lang.String r0 = "ine (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x00b3
            goto L_0x23f0
        L_0x00b3:
            java.lang.String r3 = "Indo-European"
            goto L_0x23ef
        L_0x00b7:
            java.lang.String r0 = "inc (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x00c1
            goto L_0x23f0
        L_0x00c1:
            java.lang.String r3 = "Indic "
            goto L_0x23ef
        L_0x00c5:
            java.lang.String r0 = "nic (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x00cf
            goto L_0x23f0
        L_0x00cf:
            java.lang.String r3 = "Niger-Kordofanian"
            goto L_0x23ef
        L_0x00d3:
            java.lang.String r0 = "dra (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x00dd
            goto L_0x23f0
        L_0x00dd:
            java.lang.String r3 = "Dravidian"
            goto L_0x23ef
        L_0x00e1:
            java.lang.String r0 = "sal (g)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x00eb
            goto L_0x23f0
        L_0x00eb:
            java.lang.String r3 = "Salishan languages"
            goto L_0x23ef
        L_0x00ef:
            java.lang.String r0 = "sai (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x00f9
            goto L_0x23f0
        L_0x00f9:
            java.lang.String r3 = "South American Indian (Other)"
            goto L_0x23ef
        L_0x00fd:
            java.lang.String r0 = "ijo (c)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0107
            goto L_0x23f0
        L_0x0107:
            java.lang.String r3 = "Ijo languages"
            goto L_0x23ef
        L_0x010b:
            java.lang.String r0 = "nai (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0115
            goto L_0x23f0
        L_0x0115:
            java.lang.String r3 = "North American Indian"
            goto L_0x23ef
        L_0x0119:
            java.lang.String r0 = "nah (c)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0123
            goto L_0x23f0
        L_0x0123:
            java.lang.String r3 = "Nahuatl languages"
            goto L_0x23ef
        L_0x0127:
            java.lang.String r0 = "ice (b)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1db0
            goto L_0x23f0
        L_0x0131:
            java.lang.String r0 = "deu (t)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1fe5
            goto L_0x23f0
        L_0x013b:
            java.lang.String r0 = "rum (b)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1a11
            goto L_0x23f0
        L_0x0145:
            java.lang.String r0 = "myn (g)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x014f
            goto L_0x23f0
        L_0x014f:
            java.lang.String r3 = "Mayan languages"
            goto L_0x23ef
        L_0x0153:
            java.lang.String r0 = "mya (t)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1b77
            goto L_0x23f0
        L_0x015d:
            java.lang.String r0 = "day (c)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0167
            goto L_0x23f0
        L_0x0167:
            java.lang.String r3 = "Land Dayak languages"
            goto L_0x23ef
        L_0x016b:
            java.lang.String r0 = "mun (g)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0175
            goto L_0x23f0
        L_0x0175:
            java.lang.String r3 = "Munda languages"
            goto L_0x23ef
        L_0x0179:
            java.lang.String r0 = "ron (t)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1a11
            goto L_0x23f0
        L_0x0183:
            java.lang.String r0 = "roa (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x018d
            goto L_0x23f0
        L_0x018d:
            java.lang.String r3 = "Romance (Other)"
            goto L_0x23ef
        L_0x0191:
            java.lang.String r0 = "msa (t)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x23ef
            goto L_0x23f0
        L_0x019b:
            java.lang.String r0 = "mri (t)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1bef
            goto L_0x23f0
        L_0x01a5:
            java.lang.String r0 = "cze (b)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x202a
            goto L_0x23f0
        L_0x01af:
            java.lang.String r0 = "cym (t)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2001
            goto L_0x23f0
        L_0x01b9:
            java.lang.String r0 = "wen (g)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x01c3
            goto L_0x23f0
        L_0x01c3:
            java.lang.String r3 = "Sorbian languages"
            goto L_0x23ef
        L_0x01c7:
            java.lang.String r0 = "wel (b)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2001
            goto L_0x23f0
        L_0x01d1:
            java.lang.String r0 = "mno (g)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x01db
            goto L_0x23f0
        L_0x01db:
            java.lang.String r3 = "Manobo languages"
            goto L_0x23ef
        L_0x01df:
            java.lang.String r0 = "hrv (t)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1e54
            goto L_0x23f0
        L_0x01e9:
            java.lang.String r0 = "cus (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x01f3
            goto L_0x23f0
        L_0x01f3:
            java.lang.String r3 = "Cushitic (Other)"
            goto L_0x23ef
        L_0x01f7:
            java.lang.String r0 = "wak (g)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0201
            goto L_0x23f0
        L_0x0201:
            java.lang.String r3 = "Wakashan languages"
            goto L_0x23ef
        L_0x0205:
            java.lang.String r0 = "mkh (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x020f
            goto L_0x23f0
        L_0x020f:
            java.lang.String r3 = "Mon-Khmer (Other)"
            goto L_0x23ef
        L_0x0213:
            java.lang.String r0 = "mkd (t)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1be2
            goto L_0x23f0
        L_0x021d:
            java.lang.String r0 = "crp (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0227
            goto L_0x23f0
        L_0x0227:
            java.lang.String r3 = "Creoles and pidgins"
            goto L_0x23ef
        L_0x022b:
            java.lang.String r0 = "scr (b)(d)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1e54
            goto L_0x23f0
        L_0x0235:
            java.lang.String r0 = "cpp (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x023f
            goto L_0x23f0
        L_0x023f:
            java.lang.String r3 = "Creoles and pidgins, Portuguese-based"
            goto L_0x23ef
        L_0x0243:
            java.lang.String r0 = "cpf (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x024d
            goto L_0x23f0
        L_0x024d:
            java.lang.String r3 = "Creoles and pidgins, French-based"
            goto L_0x23ef
        L_0x0251:
            java.lang.String r0 = "cpe (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x025b
            goto L_0x23f0
        L_0x025b:
            java.lang.String r3 = "Creoles and pidgins, English based"
            goto L_0x23ef
        L_0x025f:
            java.lang.String r0 = "him (c)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0269
            goto L_0x23f0
        L_0x0269:
            java.lang.String r3 = "Himachali"
            goto L_0x23ef
        L_0x026d:
            java.lang.String r0 = "cmc (g)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0277
            goto L_0x23f0
        L_0x0277:
            java.lang.String r3 = "Chamic languages"
            goto L_0x23ef
        L_0x027b:
            java.lang.String r0 = "may (b)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x23ef
            goto L_0x23f0
        L_0x0285:
            java.lang.String r0 = "map (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x028f
            goto L_0x23f0
        L_0x028f:
            java.lang.String r3 = "Austronesian (Other)"
            goto L_0x23ef
        L_0x0293:
            java.lang.String r0 = "mao (b)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1bef
            goto L_0x23f0
        L_0x029d:
            java.lang.String r0 = "mac (b)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1be2
            goto L_0x23f0
        L_0x02a7:
            java.lang.String r0 = "ces (t)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x202a
            goto L_0x23f0
        L_0x02b1:
            java.lang.String r0 = "cel (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x02bb
            goto L_0x23f0
        L_0x02bb:
            java.lang.String r3 = "Celtic"
            goto L_0x23ef
        L_0x02bf:
            java.lang.String r0 = "scc (b)(d)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x239c
            goto L_0x23f0
        L_0x02c9:
            java.lang.String r0 = "cau (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x02d3
            goto L_0x23f0
        L_0x02d3:
            java.lang.String r3 = "Caucasian"
            goto L_0x23ef
        L_0x02d7:
            java.lang.String r0 = "cai (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x02e1
            goto L_0x23f0
        L_0x02e1:
            java.lang.String r3 = "Central American Indian"
            goto L_0x23ef
        L_0x02e5:
            java.lang.String r0 = "gre (b)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2382
            goto L_0x23f0
        L_0x02ef:
            java.lang.String r0 = "bur (b)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1b77
            goto L_0x23f0
        L_0x02f9:
            java.lang.String r0 = "btk (c)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0303
            goto L_0x23f0
        L_0x0303:
            java.lang.String r3 = "Batak languages"
            goto L_0x23ef
        L_0x0307:
            java.lang.String r2 = "zh_HK"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x0311
            goto L_0x23f0
        L_0x0311:
            r1 = 2131821109(0x7f110235, float:1.9274952E38)
            java.lang.String r3 = r0.getString(r1)
            java.lang.String r0 = "mContext.getString(R.string.language_zh_HK)"
            t9.i.f(r3, r0)
            goto L_0x23ef
        L_0x031f:
            java.lang.String r0 = "qaa-qtz"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0329
            goto L_0x23f0
        L_0x0329:
            java.lang.String r3 = "Reserved for local use"
            goto L_0x23ef
        L_0x032d:
            java.lang.String r0 = "bod (t)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x235a
            goto L_0x23f0
        L_0x0337:
            java.lang.String r0 = "bnt (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x14a9
            goto L_0x23f0
        L_0x0341:
            java.lang.String r0 = "zxx"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x034b
            goto L_0x23f0
        L_0x034b:
            java.lang.String r3 = "No linguistic content"
            goto L_0x23ef
        L_0x034f:
            java.lang.String r0 = "zun"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0359
            goto L_0x23f0
        L_0x0359:
            java.lang.String r3 = "Zuni"
            goto L_0x23ef
        L_0x035d:
            java.lang.String r0 = "zul"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1765
            goto L_0x23f0
        L_0x0367:
            java.lang.String r0 = "zha"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x178b
            goto L_0x23f0
        L_0x0371:
            java.lang.String r0 = "zen"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x037b
            goto L_0x23f0
        L_0x037b:
            java.lang.String r3 = "Zenaga"
            goto L_0x23ef
        L_0x037f:
            java.lang.String r0 = "zbl"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0389
            goto L_0x23f0
        L_0x0389:
            java.lang.String r3 = "Blissymbols"
            goto L_0x23ef
        L_0x038d:
            java.lang.String r0 = "zap"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0397
            goto L_0x23f0
        L_0x0397:
            java.lang.String r3 = "Zapotec"
            goto L_0x23ef
        L_0x039b:
            java.lang.String r0 = "yor"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1799
            goto L_0x23f0
        L_0x03a5:
            java.lang.String r0 = "yid"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x17a7
            goto L_0x23f0
        L_0x03af:
            java.lang.String r0 = "yap"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x03b9
            goto L_0x23f0
        L_0x03b9:
            java.lang.String r3 = "Yapese"
            goto L_0x23ef
        L_0x03bd:
            java.lang.String r0 = "yao"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x03c7
            goto L_0x23f0
        L_0x03c7:
            java.lang.String r3 = "Yao"
            goto L_0x23ef
        L_0x03cb:
            java.lang.String r0 = "xho"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x17b5
            goto L_0x23f0
        L_0x03d5:
            java.lang.String r0 = "xal"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x03df
            goto L_0x23f0
        L_0x03df:
            java.lang.String r3 = "Kalmyk"
            goto L_0x23ef
        L_0x03e3:
            java.lang.String r0 = "wol"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x17c3
            goto L_0x23f0
        L_0x03ed:
            java.lang.String r0 = "wln"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x17d1
            goto L_0x23f0
        L_0x03f7:
            java.lang.String r0 = "was"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0401
            goto L_0x23f0
        L_0x0401:
            java.lang.String r3 = "Washo"
            goto L_0x23ef
        L_0x0405:
            java.lang.String r0 = "war"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x040f
            goto L_0x23f0
        L_0x040f:
            java.lang.String r3 = "Waray (Philippines)"
            goto L_0x23ef
        L_0x0413:
            java.lang.String r0 = "wal"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x041d
            goto L_0x23f0
        L_0x041d:
            java.lang.String r3 = "Wolaytta"
            goto L_0x23ef
        L_0x0421:
            java.lang.String r0 = "vot"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x042b
            goto L_0x23f0
        L_0x042b:
            java.lang.String r3 = "Votic"
            goto L_0x23ef
        L_0x042f:
            java.lang.String r0 = "vol"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x17df
            goto L_0x23f0
        L_0x0439:
            java.lang.String r0 = "vie"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x17ed
            goto L_0x23f0
        L_0x0443:
            java.lang.String r0 = "ven"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x17fb
            goto L_0x23f0
        L_0x044d:
            java.lang.String r0 = "vai"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0457
            goto L_0x23f0
        L_0x0457:
            java.lang.String r3 = "Vai"
            goto L_0x23ef
        L_0x045b:
            java.lang.String r0 = "uzb"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1809
            goto L_0x23f0
        L_0x0465:
            java.lang.String r0 = "urd"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1817
            goto L_0x23f0
        L_0x046f:
            java.lang.String r0 = "und"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0479
            goto L_0x23f0
        L_0x0479:
            java.lang.String r3 = "Undetermined"
            goto L_0x23ef
        L_0x047d:
            java.lang.String r0 = "umb"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0487
            goto L_0x23f0
        L_0x0487:
            java.lang.String r3 = "Umbundu"
            goto L_0x23ef
        L_0x048b:
            java.lang.String r0 = "ukr"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1825
            goto L_0x23f0
        L_0x0495:
            java.lang.String r0 = "uig"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1833
            goto L_0x23f0
        L_0x049f:
            java.lang.String r0 = "uga"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x04a9
            goto L_0x23f0
        L_0x04a9:
            java.lang.String r3 = "Ugaritic"
            goto L_0x23ef
        L_0x04ad:
            java.lang.String r0 = "udm"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x04b7
            goto L_0x23f0
        L_0x04b7:
            java.lang.String r3 = "Udmurt"
            goto L_0x23ef
        L_0x04bb:
            java.lang.String r0 = "tyv"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x04c5
            goto L_0x23f0
        L_0x04c5:
            java.lang.String r3 = "Tuvinian"
            goto L_0x23ef
        L_0x04c9:
            java.lang.String r0 = "twi"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x184f
            goto L_0x23f0
        L_0x04d3:
            java.lang.String r0 = "tvl"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x04dd
            goto L_0x23f0
        L_0x04dd:
            java.lang.String r3 = "Tuvalu"
            goto L_0x23ef
        L_0x04e1:
            java.lang.String r0 = "tur"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1879
            goto L_0x23f0
        L_0x04eb:
            java.lang.String r0 = "tum"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x04f5
            goto L_0x23f0
        L_0x04f5:
            java.lang.String r3 = "Tumbuka"
            goto L_0x23ef
        L_0x04f9:
            java.lang.String r0 = "tuk"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x18b1
            goto L_0x23f0
        L_0x0503:
            java.lang.String r0 = "tso"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x186b
            goto L_0x23f0
        L_0x050d:
            java.lang.String r0 = "tsn"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1895
            goto L_0x23f0
        L_0x0517:
            java.lang.String r0 = "tsi"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0521
            goto L_0x23f0
        L_0x0521:
            java.lang.String r3 = "Tsimshian"
            goto L_0x23ef
        L_0x0525:
            java.lang.String r0 = "tpi"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x052f
            goto L_0x23f0
        L_0x052f:
            java.lang.String r3 = "Tok Pisin"
            goto L_0x23ef
        L_0x0533:
            java.lang.String r0 = "ton"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1887
            goto L_0x23f0
        L_0x053d:
            java.lang.String r0 = "tog"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0547
            goto L_0x23f0
        L_0x0547:
            java.lang.String r3 = "Tonga (Nyasa)"
            goto L_0x23ef
        L_0x054b:
            java.lang.String r0 = "tmh"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0555
            goto L_0x23f0
        L_0x0555:
            java.lang.String r3 = "Tamashek"
            goto L_0x23ef
        L_0x0559:
            java.lang.String r0 = "tli"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0563
            goto L_0x23f0
        L_0x0563:
            java.lang.String r3 = "Tlingit"
            goto L_0x23ef
        L_0x0567:
            java.lang.String r0 = "tlh"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0571
            goto L_0x23f0
        L_0x0571:
            java.lang.String r3 = "Klingon"
            goto L_0x23ef
        L_0x0575:
            java.lang.String r0 = "tkl"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x057f
            goto L_0x23f0
        L_0x057f:
            java.lang.String r3 = "Tokelau"
            goto L_0x23ef
        L_0x0583:
            java.lang.String r0 = "tiv"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x058d
            goto L_0x23f0
        L_0x058d:
            java.lang.String r3 = "Tiv"
            goto L_0x23ef
        L_0x0591:
            java.lang.String r0 = "tir"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x18bf
            goto L_0x23f0
        L_0x059b:
            java.lang.String r0 = "tig"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x05a5
            goto L_0x23f0
        L_0x05a5:
            java.lang.String r3 = "Tigre"
            goto L_0x23ef
        L_0x05a9:
            java.lang.String r0 = "tha"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x18cd
            goto L_0x23f0
        L_0x05b3:
            java.lang.String r0 = "tgl"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x18a3
            goto L_0x23f0
        L_0x05bd:
            java.lang.String r0 = "tgk"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x18db
            goto L_0x23f0
        L_0x05c7:
            java.lang.String r0 = "tet"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x05d1
            goto L_0x23f0
        L_0x05d1:
            java.lang.String r3 = "Tetum"
            goto L_0x23ef
        L_0x05d5:
            java.lang.String r0 = "ter"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x05df
            goto L_0x23f0
        L_0x05df:
            java.lang.String r3 = "Tereno"
            goto L_0x23ef
        L_0x05e3:
            java.lang.String r0 = "tem"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x05ed
            goto L_0x23f0
        L_0x05ed:
            java.lang.String r3 = "Timne"
            goto L_0x23ef
        L_0x05f1:
            java.lang.String r0 = "tel"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x18e9
            goto L_0x23f0
        L_0x05fb:
            java.lang.String r0 = "tat"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x185d
            goto L_0x23f0
        L_0x0605:
            java.lang.String r0 = "tam"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x18f7
            goto L_0x23f0
        L_0x060f:
            java.lang.String r0 = "tah"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1841
            goto L_0x23f0
        L_0x0619:
            java.lang.String r0 = "syr"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0623
            goto L_0x23f0
        L_0x0623:
            java.lang.String r3 = "Syriac"
            goto L_0x23ef
        L_0x0627:
            java.lang.String r0 = "syc"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0631
            goto L_0x23f0
        L_0x0631:
            java.lang.String r3 = "Classical Syriac"
            goto L_0x23ef
        L_0x0635:
            java.lang.String r0 = "swe"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1913
            goto L_0x23f0
        L_0x063f:
            java.lang.String r0 = "swa"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1905
            goto L_0x23f0
        L_0x0649:
            java.lang.String r0 = "sux"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0653
            goto L_0x23f0
        L_0x0653:
            java.lang.String r3 = "Sumerian"
            goto L_0x23ef
        L_0x0657:
            java.lang.String r0 = "sus"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0661
            goto L_0x23f0
        L_0x0661:
            java.lang.String r3 = "Susu"
            goto L_0x23ef
        L_0x0665:
            java.lang.String r0 = "sun"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1921
            goto L_0x23f0
        L_0x066f:
            java.lang.String r0 = "suk"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0679
            goto L_0x23f0
        L_0x0679:
            java.lang.String r3 = "Sukuma"
            goto L_0x23ef
        L_0x067d:
            java.lang.String r0 = "ssw"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x193d
            goto L_0x23f0
        L_0x0687:
            java.lang.String r0 = "srr"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0691
            goto L_0x23f0
        L_0x0691:
            java.lang.String r3 = "Serer"
            goto L_0x23ef
        L_0x0695:
            java.lang.String r0 = "srn"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x069f
            goto L_0x23f0
        L_0x069f:
            java.lang.String r3 = "Sranan Tongo"
            goto L_0x23ef
        L_0x06a3:
            java.lang.String r0 = "srd"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x19d9
            goto L_0x23f0
        L_0x06ad:
            java.lang.String r2 = "spa"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x1f73
            goto L_0x23f0
        L_0x06b7:
            java.lang.String r0 = "sot"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x192f
            goto L_0x23f0
        L_0x06c1:
            java.lang.String r0 = "som"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x195f
            goto L_0x23f0
        L_0x06cb:
            java.lang.String r0 = "sog"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x06d5
            goto L_0x23f0
        L_0x06d5:
            java.lang.String r3 = "Sogdian"
            goto L_0x23ef
        L_0x06d9:
            java.lang.String r0 = "snk"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x06e3
            goto L_0x23f0
        L_0x06e3:
            java.lang.String r3 = "Soninke"
            goto L_0x23ef
        L_0x06e7:
            java.lang.String r0 = "snd"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x19cb
            goto L_0x23f0
        L_0x06f1:
            java.lang.String r0 = "sna"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x196d
            goto L_0x23f0
        L_0x06fb:
            java.lang.String r0 = "sms"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0705
            goto L_0x23f0
        L_0x0705:
            java.lang.String r3 = "Skolt Sami"
            goto L_0x23ef
        L_0x0709:
            java.lang.String r0 = "smo"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x197b
            goto L_0x23f0
        L_0x0713:
            java.lang.String r0 = "smn"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x071d
            goto L_0x23f0
        L_0x071d:
            java.lang.String r3 = "Inari Sami"
            goto L_0x23ef
        L_0x0721:
            java.lang.String r0 = "smj"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x072b
            goto L_0x23f0
        L_0x072b:
            java.lang.String r3 = "Lule Sami"
            goto L_0x23ef
        L_0x072f:
            java.lang.String r0 = "sme"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x19bd
            goto L_0x23f0
        L_0x0739:
            java.lang.String r0 = "sma"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0743
            goto L_0x23f0
        L_0x0743:
            java.lang.String r3 = "Southern Sami"
            goto L_0x23ef
        L_0x0747:
            java.lang.String r0 = "slv"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1989
            goto L_0x23f0
        L_0x0751:
            java.lang.String r0 = "sin"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x19a1
            goto L_0x23f0
        L_0x075b:
            java.lang.String r0 = "sid"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0765
            goto L_0x23f0
        L_0x0765:
            java.lang.String r3 = "Sidamo"
            goto L_0x23ef
        L_0x0769:
            java.lang.String r0 = "shn"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0773
            goto L_0x23f0
        L_0x0773:
            java.lang.String r3 = "Shan"
            goto L_0x23ef
        L_0x0777:
            java.lang.String r0 = "sga"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0781
            goto L_0x23f0
        L_0x0781:
            java.lang.String r3 = "Old Irish (to 900)"
            goto L_0x23ef
        L_0x0785:
            java.lang.String r0 = "sel"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x078f
            goto L_0x23f0
        L_0x078f:
            java.lang.String r3 = "Selkup"
            goto L_0x23ef
        L_0x0793:
            java.lang.String r0 = "sco"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x079d
            goto L_0x23f0
        L_0x079d:
            java.lang.String r3 = "Scots"
            goto L_0x23ef
        L_0x07a1:
            java.lang.String r0 = "scn"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x07ab
            goto L_0x23f0
        L_0x07ab:
            java.lang.String r3 = "Sicilian"
            goto L_0x23ef
        L_0x07af:
            java.lang.String r0 = "sat"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x07b9
            goto L_0x23f0
        L_0x07b9:
            java.lang.String r3 = "Santali"
            goto L_0x23ef
        L_0x07bd:
            java.lang.String r0 = "sas"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x07c7
            goto L_0x23f0
        L_0x07c7:
            java.lang.String r3 = "Sasak"
            goto L_0x23ef
        L_0x07cb:
            java.lang.String r0 = "san"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x19e7
            goto L_0x23f0
        L_0x07d5:
            java.lang.String r0 = "sam"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x07df
            goto L_0x23f0
        L_0x07df:
            java.lang.String r3 = "Samaritan Aramaic"
            goto L_0x23ef
        L_0x07e3:
            java.lang.String r0 = "sah"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x07ed
            goto L_0x23f0
        L_0x07ed:
            java.lang.String r3 = "Yakut"
            goto L_0x23ef
        L_0x07f1:
            java.lang.String r0 = "sag"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x19af
            goto L_0x23f0
        L_0x07fb:
            java.lang.String r0 = "sad"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0805
            goto L_0x23f0
        L_0x0805:
            java.lang.String r3 = "Sandawe"
            goto L_0x23ef
        L_0x0809:
            java.lang.String r0 = "rus"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1a03
            goto L_0x23f0
        L_0x0813:
            java.lang.String r0 = "rup"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x081d
            goto L_0x23f0
        L_0x081d:
            java.lang.String r3 = "Macedo Romanian"
            goto L_0x23ef
        L_0x0821:
            java.lang.String r0 = "run"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1a1e
            goto L_0x23f0
        L_0x082b:
            java.lang.String r0 = "rom"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0835
            goto L_0x23f0
        L_0x0835:
            java.lang.String r3 = "Romany"
            goto L_0x23ef
        L_0x0839:
            java.lang.String r0 = "roh"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1a2c
            goto L_0x23f0
        L_0x0843:
            java.lang.String r0 = "rar"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x084d
            goto L_0x23f0
        L_0x084d:
            java.lang.String r3 = "Rarotongan"
            goto L_0x23ef
        L_0x0851:
            java.lang.String r0 = "rap"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x085b
            goto L_0x23f0
        L_0x085b:
            java.lang.String r3 = "Rapanui"
            goto L_0x23ef
        L_0x085f:
            java.lang.String r0 = "raj"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0869
            goto L_0x23f0
        L_0x0869:
            java.lang.String r3 = "Rajasthani"
            goto L_0x23ef
        L_0x086d:
            java.lang.String r0 = "que"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1a3a
            goto L_0x23f0
        L_0x0877:
            java.lang.String r0 = "pus"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1a60
            goto L_0x23f0
        L_0x0881:
            java.lang.String r0 = "pro"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x088b
            goto L_0x23f0
        L_0x088b:
            java.lang.String r3 = "Old Provençal (to 1500)"
            goto L_0x23ef
        L_0x088f:
            java.lang.String r2 = "por"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x1a48
            goto L_0x23f0
        L_0x0899:
            java.lang.String r0 = "pon"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x08a3
            goto L_0x23f0
        L_0x08a3:
            java.lang.String r3 = "Pohnpeian"
            goto L_0x23ef
        L_0x08a7:
            java.lang.String r0 = "pol"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1a6e
            goto L_0x23f0
        L_0x08b1:
            java.lang.String r0 = "pli"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1a7c
            goto L_0x23f0
        L_0x08bb:
            java.lang.String r0 = "phn"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x08c5
            goto L_0x23f0
        L_0x08c5:
            java.lang.String r3 = "Phoenician"
            goto L_0x23ef
        L_0x08c9:
            java.lang.String r0 = "peo"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x08d3
            goto L_0x23f0
        L_0x08d3:
            java.lang.String r3 = "Old Persian (ca. 600-400 B.C.)"
            goto L_0x23ef
        L_0x08d7:
            java.lang.String r0 = "pau"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x08e1
            goto L_0x23f0
        L_0x08e1:
            java.lang.String r3 = "Palauan"
            goto L_0x23ef
        L_0x08e5:
            java.lang.String r0 = "pap"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x08ef
            goto L_0x23f0
        L_0x08ef:
            java.lang.String r3 = "Papiamento"
            goto L_0x23ef
        L_0x08f3:
            java.lang.String r0 = "pan"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1a8a
            goto L_0x23f0
        L_0x08fd:
            java.lang.String r0 = "pam"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0907
            goto L_0x23f0
        L_0x0907:
            java.lang.String r3 = "Pampanga"
            goto L_0x23ef
        L_0x090b:
            java.lang.String r0 = "pal"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0915
            goto L_0x23f0
        L_0x0915:
            java.lang.String r3 = "Pahlavi"
            goto L_0x23ef
        L_0x0919:
            java.lang.String r0 = "pag"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0923
            goto L_0x23f0
        L_0x0923:
            java.lang.String r3 = "Pangasinan"
            goto L_0x23ef
        L_0x0927:
            java.lang.String r0 = "ota"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0931
            goto L_0x23f0
        L_0x0931:
            java.lang.String r3 = "Ottoman Turkish (1500-1928)"
            goto L_0x23ef
        L_0x0935:
            java.lang.String r0 = "oss"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1a98
            goto L_0x23f0
        L_0x093f:
            java.lang.String r0 = "osa"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0949
            goto L_0x23f0
        L_0x0949:
            java.lang.String r3 = "Osage"
            goto L_0x23ef
        L_0x094d:
            java.lang.String r0 = "orm"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1ab4
            goto L_0x23f0
        L_0x0957:
            java.lang.String r0 = "ori"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1aa6
            goto L_0x23f0
        L_0x0961:
            java.lang.String r0 = "oji"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1ac2
            goto L_0x23f0
        L_0x096b:
            java.lang.String r0 = "oci"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1ad0
            goto L_0x23f0
        L_0x0975:
            java.lang.String r0 = "nzi"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x097f
            goto L_0x23f0
        L_0x097f:
            java.lang.String r3 = "Nzima"
            goto L_0x23ef
        L_0x0983:
            java.lang.String r0 = "nyo"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x098d
            goto L_0x23f0
        L_0x098d:
            java.lang.String r3 = "Nyoro"
            goto L_0x23ef
        L_0x0991:
            java.lang.String r0 = "nyn"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x099b
            goto L_0x23f0
        L_0x099b:
            java.lang.String r3 = "Nyankole"
            goto L_0x23ef
        L_0x099f:
            java.lang.String r0 = "nym"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x09a9
            goto L_0x23f0
        L_0x09a9:
            java.lang.String r3 = "Nyamwezi"
            goto L_0x23ef
        L_0x09ad:
            java.lang.String r0 = "nya"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1ade
            goto L_0x23f0
        L_0x09b7:
            java.lang.String r0 = "nwc"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x09c1
            goto L_0x23f0
        L_0x09c1:
            java.lang.String r3 = "Classical Newari"
            goto L_0x23ef
        L_0x09c5:
            java.lang.String r0 = "nso"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x09cf
            goto L_0x23f0
        L_0x09cf:
            java.lang.String r3 = "Pedi"
            goto L_0x23ef
        L_0x09d3:
            java.lang.String r0 = "nqo"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x09dd
            goto L_0x23f0
        L_0x09dd:
            java.lang.String r3 = "N'Ko"
            goto L_0x23ef
        L_0x09e1:
            java.lang.String r0 = "nor"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1b08
            goto L_0x23f0
        L_0x09eb:
            java.lang.String r0 = "non"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x09f5
            goto L_0x23f0
        L_0x09f5:
            java.lang.String r3 = "Old Norse"
            goto L_0x23ef
        L_0x09f9:
            java.lang.String r0 = "nog"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0a03
            goto L_0x23f0
        L_0x0a03:
            java.lang.String r3 = "Nogai"
            goto L_0x23ef
        L_0x0a07:
            java.lang.String r0 = "nob"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1b5b
            goto L_0x23f0
        L_0x0a11:
            java.lang.String r0 = "nno"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1b16
            goto L_0x23f0
        L_0x0a1b:
            java.lang.String r0 = "niu"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0a25
            goto L_0x23f0
        L_0x0a25:
            java.lang.String r3 = "Niuean"
            goto L_0x23ef
        L_0x0a29:
            java.lang.String r0 = "nia"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0a33
            goto L_0x23f0
        L_0x0a33:
            java.lang.String r3 = "Nias"
            goto L_0x23ef
        L_0x0a37:
            java.lang.String r0 = "new"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0a41
            goto L_0x23f0
        L_0x0a41:
            java.lang.String r3 = "Newari"
            goto L_0x23ef
        L_0x0a45:
            java.lang.String r0 = "nep"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1b3f
            goto L_0x23f0
        L_0x0a4f:
            java.lang.String r0 = "nds"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0a59
            goto L_0x23f0
        L_0x0a59:
            java.lang.String r3 = "Low German"
            goto L_0x23ef
        L_0x0a5d:
            java.lang.String r0 = "ndo"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1b31
            goto L_0x23f0
        L_0x0a67:
            java.lang.String r0 = "nde"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1b4d
            goto L_0x23f0
        L_0x0a71:
            java.lang.String r0 = "nbl"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1afa
            goto L_0x23f0
        L_0x0a7b:
            java.lang.String r0 = "nav"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1aec
            goto L_0x23f0
        L_0x0a85:
            java.lang.String r0 = "nau"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1b69
            goto L_0x23f0
        L_0x0a8f:
            java.lang.String r0 = "nap"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0a99
            goto L_0x23f0
        L_0x0a99:
            java.lang.String r3 = "Neapolitan"
            goto L_0x23ef
        L_0x0a9d:
            java.lang.String r0 = "myv"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0aa7
            goto L_0x23f0
        L_0x0aa7:
            java.lang.String r3 = "Erzya"
            goto L_0x23ef
        L_0x0aab:
            java.lang.String r0 = "mwr"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0ab5
            goto L_0x23f0
        L_0x0ab5:
            java.lang.String r3 = "Marwari"
            goto L_0x23ef
        L_0x0ab9:
            java.lang.String r0 = "mwl"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0ac3
            goto L_0x23f0
        L_0x0ac3:
            java.lang.String r3 = "Mirandese"
            goto L_0x23ef
        L_0x0ac7:
            java.lang.String r0 = "mus"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0ad1
            goto L_0x23f0
        L_0x0ad1:
            java.lang.String r3 = "Creek"
            goto L_0x23ef
        L_0x0ad5:
            java.lang.String r0 = "mul"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0adf
            goto L_0x23f0
        L_0x0adf:
            java.lang.String r3 = "Multiple languages"
            goto L_0x23ef
        L_0x0ae3:
            java.lang.String r0 = "mos"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0aed
            goto L_0x23f0
        L_0x0aed:
            java.lang.String r3 = "Mossi"
            goto L_0x23ef
        L_0x0af1:
            java.lang.String r0 = "mon"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1bc6
            goto L_0x23f0
        L_0x0afb:
            java.lang.String r0 = "mol"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1bb8
            goto L_0x23f0
        L_0x0b05:
            java.lang.String r0 = "moh"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0b0f
            goto L_0x23f0
        L_0x0b0f:
            java.lang.String r3 = "Mohawk"
            goto L_0x23ef
        L_0x0b13:
            java.lang.String r0 = "mni"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0b1d
            goto L_0x23f0
        L_0x0b1d:
            java.lang.String r3 = "Manipuri"
            goto L_0x23ef
        L_0x0b21:
            java.lang.String r0 = "mnc"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0b2b
            goto L_0x23f0
        L_0x0b2b:
            java.lang.String r3 = "Manchu"
            goto L_0x23ef
        L_0x0b2f:
            java.lang.String r0 = "mlt"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1b84
            goto L_0x23f0
        L_0x0b39:
            java.lang.String r0 = "mlg"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1c0a
            goto L_0x23f0
        L_0x0b43:
            java.lang.String r0 = "mis"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0b4d
            goto L_0x23f0
        L_0x0b4d:
            java.lang.String r3 = "Uncoded languages"
            goto L_0x23ef
        L_0x0b51:
            java.lang.String r0 = "min"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0b5b
            goto L_0x23f0
        L_0x0b5b:
            java.lang.String r3 = "Minangkabau"
            goto L_0x23ef
        L_0x0b5f:
            java.lang.String r0 = "mic"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0b69
            goto L_0x23f0
        L_0x0b69:
            java.lang.String r3 = "Mi'kmaq"
            goto L_0x23ef
        L_0x0b6d:
            java.lang.String r0 = "mga"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0b77
            goto L_0x23f0
        L_0x0b77:
            java.lang.String r3 = "Middle Irish (900-1200)"
            goto L_0x23ef
        L_0x0b7b:
            java.lang.String r0 = "men"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0b85
            goto L_0x23f0
        L_0x0b85:
            java.lang.String r3 = "Mende (Sierra Leone)"
            goto L_0x23ef
        L_0x0b89:
            java.lang.String r0 = "mdr"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0b93
            goto L_0x23f0
        L_0x0b93:
            java.lang.String r3 = "Mandar"
            goto L_0x23ef
        L_0x0b97:
            java.lang.String r0 = "mdf"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0ba1
            goto L_0x23f0
        L_0x0ba1:
            java.lang.String r3 = "Moksha"
            goto L_0x23ef
        L_0x0ba5:
            java.lang.String r0 = "mas"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0baf
            goto L_0x23f0
        L_0x0baf:
            java.lang.String r3 = "Masai"
            goto L_0x23ef
        L_0x0bb3:
            java.lang.String r0 = "mar"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1baa
            goto L_0x23f0
        L_0x0bbd:
            java.lang.String r0 = "man"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0bc7
            goto L_0x23f0
        L_0x0bc7:
            java.lang.String r3 = "Mandingo"
            goto L_0x23ef
        L_0x0bcb:
            java.lang.String r0 = "mal"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1bd4
            goto L_0x23f0
        L_0x0bd5:
            java.lang.String r0 = "mak"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0bdf
            goto L_0x23f0
        L_0x0bdf:
            java.lang.String r3 = "Makasar"
            goto L_0x23ef
        L_0x0be3:
            java.lang.String r0 = "mai"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0bed
            goto L_0x23f0
        L_0x0bed:
            java.lang.String r3 = "Maithili"
            goto L_0x23ef
        L_0x0bf1:
            java.lang.String r0 = "mah"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1bfc
            goto L_0x23f0
        L_0x0bfb:
            java.lang.String r0 = "mag"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0c05
            goto L_0x23f0
        L_0x0c05:
            java.lang.String r3 = "Magahi"
            goto L_0x23ef
        L_0x0c09:
            java.lang.String r0 = "mad"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0c13
            goto L_0x23f0
        L_0x0c13:
            java.lang.String r3 = "Madurese"
            goto L_0x23ef
        L_0x0c17:
            java.lang.String r0 = "lus"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0c21
            goto L_0x23f0
        L_0x0c21:
            java.lang.String r3 = "Lushai"
            goto L_0x23ef
        L_0x0c25:
            java.lang.String r0 = "luo"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0c2f
            goto L_0x23f0
        L_0x0c2f:
            java.lang.String r3 = "Luo (Kenya and Tanzania)"
            goto L_0x23ef
        L_0x0c33:
            java.lang.String r0 = "lun"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0c3d
            goto L_0x23f0
        L_0x0c3d:
            java.lang.String r3 = "Lunda"
            goto L_0x23ef
        L_0x0c41:
            java.lang.String r0 = "lui"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0c4b
            goto L_0x23f0
        L_0x0c4b:
            java.lang.String r3 = "Luiseno"
            goto L_0x23ef
        L_0x0c4f:
            java.lang.String r0 = "lug"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1c6c
            goto L_0x23f0
        L_0x0c59:
            java.lang.String r0 = "lub"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1c26
            goto L_0x23f0
        L_0x0c63:
            java.lang.String r0 = "lua"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0c6d
            goto L_0x23f0
        L_0x0c6d:
            java.lang.String r3 = "Luba-Lulua"
            goto L_0x23ef
        L_0x0c71:
            java.lang.String r0 = "ltz"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1c7a
            goto L_0x23f0
        L_0x0c7b:
            java.lang.String r0 = "loz"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0c85
            goto L_0x23f0
        L_0x0c85:
            java.lang.String r3 = "Lozi"
            goto L_0x23ef
        L_0x0c89:
            java.lang.String r0 = "lol"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0c93
            goto L_0x23f0
        L_0x0c93:
            java.lang.String r3 = "Mongo"
            goto L_0x23ef
        L_0x0c97:
            java.lang.String r0 = "lit"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1c34
            goto L_0x23f0
        L_0x0ca1:
            java.lang.String r0 = "lin"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1c50
            goto L_0x23f0
        L_0x0cab:
            java.lang.String r0 = "lim"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1c5e
            goto L_0x23f0
        L_0x0cb5:
            java.lang.String r0 = "lez"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0cbf
            goto L_0x23f0
        L_0x0cbf:
            java.lang.String r3 = "Lezghian"
            goto L_0x23ef
        L_0x0cc3:
            java.lang.String r0 = "lav"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1c18
            goto L_0x23f0
        L_0x0ccd:
            java.lang.String r0 = "lat"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1c88
            goto L_0x23f0
        L_0x0cd7:
            java.lang.String r0 = "lao"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1c42
            goto L_0x23f0
        L_0x0ce1:
            java.lang.String r0 = "lam"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0ceb
            goto L_0x23f0
        L_0x0ceb:
            java.lang.String r3 = "Lamba"
            goto L_0x23ef
        L_0x0cef:
            java.lang.String r0 = "lah"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0cf9
            goto L_0x23f0
        L_0x0cf9:
            java.lang.String r3 = "Lahnda"
            goto L_0x23ef
        L_0x0cfd:
            java.lang.String r0 = "lad"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0d07
            goto L_0x23f0
        L_0x0d07:
            java.lang.String r3 = "Ladino"
            goto L_0x23ef
        L_0x0d0b:
            java.lang.String r0 = "kut"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0d15
            goto L_0x23f0
        L_0x0d15:
            java.lang.String r3 = "Kutenai"
            goto L_0x23ef
        L_0x0d19:
            java.lang.String r0 = "kur"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1cc0
            goto L_0x23f0
        L_0x0d23:
            java.lang.String r0 = "kum"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0d2d
            goto L_0x23f0
        L_0x0d2d:
            java.lang.String r3 = "Kumyk"
            goto L_0x23ef
        L_0x0d31:
            java.lang.String r0 = "kua"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1d30
            goto L_0x23f0
        L_0x0d3b:
            java.lang.String r0 = "kru"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0d45
            goto L_0x23f0
        L_0x0d45:
            java.lang.String r3 = "Kurukh"
            goto L_0x23ef
        L_0x0d49:
            java.lang.String r0 = "krl"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0d53
            goto L_0x23f0
        L_0x0d53:
            java.lang.String r3 = "Karelian"
            goto L_0x23ef
        L_0x0d57:
            java.lang.String r0 = "krc"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0d61
            goto L_0x23f0
        L_0x0d61:
            java.lang.String r3 = "Karachay-Balkar"
            goto L_0x23ef
        L_0x0d65:
            java.lang.String r0 = "kpe"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0d6f
            goto L_0x23f0
        L_0x0d6f:
            java.lang.String r3 = "Kpelle"
            goto L_0x23ef
        L_0x0d73:
            java.lang.String r0 = "kos"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0d7d
            goto L_0x23f0
        L_0x0d7d:
            java.lang.String r3 = "Kosraean"
            goto L_0x23ef
        L_0x0d81:
            java.lang.String r0 = "kor"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1cea
            goto L_0x23f0
        L_0x0d8b:
            java.lang.String r0 = "kon"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1d4c
            goto L_0x23f0
        L_0x0d95:
            java.lang.String r0 = "kom"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1cb2
            goto L_0x23f0
        L_0x0d9f:
            java.lang.String r0 = "kok"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0da9
            goto L_0x23f0
        L_0x0da9:
            java.lang.String r3 = "Konkani (macrolanguage)"
            goto L_0x23ef
        L_0x0dad:
            java.lang.String r0 = "kmb"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0db7
            goto L_0x23f0
        L_0x0db7:
            java.lang.String r3 = "Kimbundu"
            goto L_0x23ef
        L_0x0dbb:
            java.lang.String r0 = "kir"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1c96
            goto L_0x23f0
        L_0x0dc5:
            java.lang.String r0 = "kin"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x19f5
            goto L_0x23f0
        L_0x0dcf:
            java.lang.String r0 = "kik"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1d3e
            goto L_0x23f0
        L_0x0dd9:
            java.lang.String r0 = "kho"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0de3
            goto L_0x23f0
        L_0x0de3:
            java.lang.String r3 = "Khotanese"
            goto L_0x23ef
        L_0x0de7:
            java.lang.String r0 = "khm"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1d06
            goto L_0x23f0
        L_0x0df1:
            java.lang.String r0 = "kha"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0dfb
            goto L_0x23f0
        L_0x0dfb:
            java.lang.String r3 = "Khasi"
            goto L_0x23ef
        L_0x0dff:
            java.lang.String r0 = "kbd"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0e09
            goto L_0x23f0
        L_0x0e09:
            java.lang.String r3 = "Kabardian"
            goto L_0x23ef
        L_0x0e0d:
            java.lang.String r0 = "kaz"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1d22
            goto L_0x23f0
        L_0x0e17:
            java.lang.String r0 = "kaw"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0e21
            goto L_0x23f0
        L_0x0e21:
            java.lang.String r3 = "Kawi"
            goto L_0x23ef
        L_0x0e25:
            java.lang.String r0 = "kau"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1cdc
            goto L_0x23f0
        L_0x0e2f:
            java.lang.String r0 = "kas"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1cce
            goto L_0x23f0
        L_0x0e39:
            java.lang.String r0 = "kan"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1cf8
            goto L_0x23f0
        L_0x0e43:
            java.lang.String r0 = "kam"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0e4d
            goto L_0x23f0
        L_0x0e4d:
            java.lang.String r3 = "Kamba (Kenya)"
            goto L_0x23ef
        L_0x0e51:
            java.lang.String r0 = "kal"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1d14
            goto L_0x23f0
        L_0x0e5b:
            java.lang.String r0 = "kac"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0e65
            goto L_0x23f0
        L_0x0e65:
            java.lang.String r3 = "Kachin"
            goto L_0x23ef
        L_0x0e69:
            java.lang.String r0 = "kab"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0e73
            goto L_0x23f0
        L_0x0e73:
            java.lang.String r3 = "Kabyle"
            goto L_0x23ef
        L_0x0e77:
            java.lang.String r0 = "kaa"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0e81
            goto L_0x23f0
        L_0x0e81:
            java.lang.String r3 = "Kara-Kalpak"
            goto L_0x23ef
        L_0x0e85:
            java.lang.String r0 = "jrb"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0e8f
            goto L_0x23f0
        L_0x0e8f:
            java.lang.String r3 = "Judeo-Arabic"
            goto L_0x23ef
        L_0x0e93:
            java.lang.String r0 = "jpr"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0e9d
            goto L_0x23f0
        L_0x0e9d:
            java.lang.String r3 = "Judeo-Persian"
            goto L_0x23ef
        L_0x0ea1:
            java.lang.String r2 = "jpn"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x1d72
            goto L_0x23f0
        L_0x0eab:
            java.lang.String r0 = "jbo"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0eb5
            goto L_0x23f0
        L_0x0eb5:
            java.lang.String r3 = "Lojban"
            goto L_0x23ef
        L_0x0eb9:
            java.lang.String r0 = "jav"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1d64
            goto L_0x23f0
        L_0x0ec3:
            java.lang.String r2 = "ita"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x1d98
            goto L_0x23f0
        L_0x0ecd:
            java.lang.String r0 = "isl"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1db0
            goto L_0x23f0
        L_0x0ed7:
            java.lang.String r0 = "ipk"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1dcc
            goto L_0x23f0
        L_0x0ee1:
            java.lang.String r0 = "inh"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0eeb
            goto L_0x23f0
        L_0x0eeb:
            java.lang.String r3 = "Ingush"
            goto L_0x23ef
        L_0x0eef:
            java.lang.String r0 = "ind"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1e04
            goto L_0x23f0
        L_0x0ef9:
            java.lang.String r0 = "ina"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1e12
            goto L_0x23f0
        L_0x0f03:
            java.lang.String r0 = "ilo"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0f0d
            goto L_0x23f0
        L_0x0f0d:
            java.lang.String r3 = "Iloko"
            goto L_0x23ef
        L_0x0f11:
            java.lang.String r0 = "ile"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1df6
            goto L_0x23f0
        L_0x0f1b:
            java.lang.String r0 = "iku"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1d8a
            goto L_0x23f0
        L_0x0f25:
            java.lang.String r0 = "iii"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1dda
            goto L_0x23f0
        L_0x0f2f:
            java.lang.String r0 = "ido"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1dbe
            goto L_0x23f0
        L_0x0f39:
            java.lang.String r0 = "ibo"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1de8
            goto L_0x23f0
        L_0x0f43:
            java.lang.String r0 = "iba"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0f4d
            goto L_0x23f0
        L_0x0f4d:
            java.lang.String r3 = "Iban"
            goto L_0x23ef
        L_0x0f51:
            java.lang.String r0 = "hup"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0f5b
            goto L_0x23f0
        L_0x0f5b:
            java.lang.String r3 = "Hupa"
            goto L_0x23ef
        L_0x0f5f:
            java.lang.String r0 = "hun"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1e38
            goto L_0x23f0
        L_0x0f69:
            java.lang.String r0 = "hsb"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0f73
            goto L_0x23f0
        L_0x0f73:
            java.lang.String r3 = "Upper Sorbian"
            goto L_0x23ef
        L_0x0f77:
            java.lang.String r0 = "hmo"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1e61
            goto L_0x23f0
        L_0x0f81:
            java.lang.String r0 = "hmn"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0f8b
            goto L_0x23f0
        L_0x0f8b:
            java.lang.String r3 = "Hmong"
            goto L_0x23ef
        L_0x0f8f:
            java.lang.String r0 = "hit"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0f99
            goto L_0x23f0
        L_0x0f99:
            java.lang.String r3 = "Hittite"
            goto L_0x23ef
        L_0x0f9d:
            java.lang.String r2 = "hin"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x1e6f
            goto L_0x23f0
        L_0x0fa7:
            java.lang.String r0 = "hil"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0fb1
            goto L_0x23f0
        L_0x0fb1:
            java.lang.String r3 = "Hiligaynon"
            goto L_0x23ef
        L_0x0fb5:
            java.lang.String r0 = "her"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1e20
            goto L_0x23f0
        L_0x0fbf:
            java.lang.String r2 = "heb"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x1e87
            goto L_0x23f0
        L_0x0fc9:
            java.lang.String r0 = "haw"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0fd3
            goto L_0x23f0
        L_0x0fd3:
            java.lang.String r3 = "Hawaiian"
            goto L_0x23ef
        L_0x0fd7:
            java.lang.String r0 = "hau"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1e9f
            goto L_0x23f0
        L_0x0fe1:
            java.lang.String r0 = "hat"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1e46
            goto L_0x23f0
        L_0x0feb:
            java.lang.String r0 = "hai"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0ff5
            goto L_0x23f0
        L_0x0ff5:
            java.lang.String r3 = "Haida"
            goto L_0x23ef
        L_0x0ff9:
            java.lang.String r0 = "gwi"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1003
            goto L_0x23f0
        L_0x1003:
            java.lang.String r3 = "Gwichʼin"
            goto L_0x23ef
        L_0x1007:
            java.lang.String r0 = "guj"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1ebb
            goto L_0x23f0
        L_0x1011:
            java.lang.String r0 = "gsw"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x101b
            goto L_0x23f0
        L_0x101b:
            java.lang.String r3 = "Swiss German"
            goto L_0x23ef
        L_0x101f:
            java.lang.String r0 = "grn"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1ec9
            goto L_0x23f0
        L_0x1029:
            java.lang.String r0 = "grc"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1033
            goto L_0x23f0
        L_0x1033:
            java.lang.String r3 = "Ancient Greek (to 1453)"
            goto L_0x23ef
        L_0x1037:
            java.lang.String r0 = "grb"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1041
            goto L_0x23f0
        L_0x1041:
            java.lang.String r3 = "Grebo"
            goto L_0x23ef
        L_0x1045:
            java.lang.String r0 = "got"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x104f
            goto L_0x23f0
        L_0x104f:
            java.lang.String r3 = "Gothic"
            goto L_0x23ef
        L_0x1053:
            java.lang.String r0 = "gor"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x105d
            goto L_0x23f0
        L_0x105d:
            java.lang.String r3 = "Gorontalo"
            goto L_0x23ef
        L_0x1061:
            java.lang.String r0 = "gon"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x106b
            goto L_0x23f0
        L_0x106b:
            java.lang.String r3 = "Gondi"
            goto L_0x23ef
        L_0x106f:
            java.lang.String r0 = "goh"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1079
            goto L_0x23f0
        L_0x1079:
            java.lang.String r3 = "Old High German "
            goto L_0x23ef
        L_0x107d:
            java.lang.String r0 = "gmh"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1087
            goto L_0x23f0
        L_0x1087:
            java.lang.String r3 = "Middle High German"
            goto L_0x23ef
        L_0x108b:
            java.lang.String r0 = "glv"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1ead
            goto L_0x23f0
        L_0x1095:
            java.lang.String r0 = "glg"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1ed7
            goto L_0x23f0
        L_0x109f:
            java.lang.String r0 = "gle"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1ef3
            goto L_0x23f0
        L_0x10a9:
            java.lang.String r0 = "gla"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1ee5
            goto L_0x23f0
        L_0x10b3:
            java.lang.String r0 = "gil"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x10bd
            goto L_0x23f0
        L_0x10bd:
            java.lang.String r3 = "Gilbertese"
            goto L_0x23ef
        L_0x10c1:
            java.lang.String r0 = "gez"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x10cb
            goto L_0x23f0
        L_0x10cb:
            java.lang.String r3 = "Geez"
            goto L_0x23ef
        L_0x10cf:
            java.lang.String r2 = "ger"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x21b3
            goto L_0x23f0
        L_0x10d9:
            java.lang.String r0 = "gba"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x10e3
            goto L_0x23f0
        L_0x10e3:
            java.lang.String r3 = "Gbaya"
            goto L_0x23ef
        L_0x10e7:
            java.lang.String r0 = "gay"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x10f1
            goto L_0x23f0
        L_0x10f1:
            java.lang.String r3 = "Gayo"
            goto L_0x23ef
        L_0x10f5:
            java.lang.String r0 = "gaa"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x10ff
            goto L_0x23f0
        L_0x10ff:
            java.lang.String r3 = "Ga"
            goto L_0x23ef
        L_0x1103:
            java.lang.String r0 = "fur"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x110d
            goto L_0x23f0
        L_0x110d:
            java.lang.String r3 = "Friulian"
            goto L_0x23ef
        L_0x1111:
            java.lang.String r0 = "ful"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1f43
            goto L_0x23f0
        L_0x111b:
            java.lang.String r0 = "fry"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1f01
            goto L_0x23f0
        L_0x1125:
            java.lang.String r0 = "frs"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x112f
            goto L_0x23f0
        L_0x112f:
            java.lang.String r3 = "Eastern Frisian"
            goto L_0x23ef
        L_0x1133:
            java.lang.String r0 = "frr"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x113d
            goto L_0x23f0
        L_0x113d:
            java.lang.String r3 = "Northern Frisian"
            goto L_0x23ef
        L_0x1141:
            java.lang.String r0 = "fro"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x114b
            goto L_0x23f0
        L_0x114b:
            java.lang.String r3 = "Old French"
            goto L_0x23ef
        L_0x114f:
            java.lang.String r0 = "frm"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1159
            goto L_0x23f0
        L_0x1159:
            java.lang.String r3 = "Middle French"
            goto L_0x23ef
        L_0x115d:
            java.lang.String r2 = "fre"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x2275
            goto L_0x23f0
        L_0x1167:
            java.lang.String r0 = "fon"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1171
            goto L_0x23f0
        L_0x1171:
            java.lang.String r3 = "Fon"
            goto L_0x23ef
        L_0x1175:
            java.lang.String r0 = "fin"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1f35
            goto L_0x23f0
        L_0x117f:
            java.lang.String r0 = "fil"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1189
            goto L_0x23f0
        L_0x1189:
            java.lang.String r3 = "Filipino"
            goto L_0x23ef
        L_0x118d:
            java.lang.String r0 = "fij"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1f27
            goto L_0x23f0
        L_0x1197:
            java.lang.String r0 = "fat"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x11a1
            goto L_0x23f0
        L_0x11a1:
            java.lang.String r3 = "Fanti"
            goto L_0x23ef
        L_0x11a5:
            java.lang.String r0 = "fao"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1f19
            goto L_0x23f0
        L_0x11af:
            java.lang.String r0 = "fan"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x11b9
            goto L_0x23f0
        L_0x11b9:
            java.lang.String r3 = "Fang"
            goto L_0x23ef
        L_0x11bd:
            java.lang.String r0 = "ewo"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x11c7
            goto L_0x23f0
        L_0x11c7:
            java.lang.String r3 = "Ewondo"
            goto L_0x23ef
        L_0x11cb:
            java.lang.String r0 = "ewe"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1fbb
            goto L_0x23f0
        L_0x11d5:
            java.lang.String r0 = "eus"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2367
            goto L_0x23f0
        L_0x11df:
            java.lang.String r0 = "est"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1f65
            goto L_0x23f0
        L_0x11e9:
            java.lang.String r0 = "epo"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1f8b
            goto L_0x23f0
        L_0x11f3:
            java.lang.String r0 = "enm"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x11fd
            goto L_0x23f0
        L_0x11fd:
            java.lang.String r3 = "Middle English "
            goto L_0x23ef
        L_0x1201:
            java.lang.String r2 = "eng"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x1f99
            goto L_0x23f0
        L_0x120b:
            java.lang.String r0 = "elx"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1215
            goto L_0x23f0
        L_0x1215:
            java.lang.String r3 = "Elamite"
            goto L_0x23ef
        L_0x1219:
            java.lang.String r0 = "eka"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1223
            goto L_0x23f0
        L_0x1223:
            java.lang.String r3 = "Ekajuk"
            goto L_0x23ef
        L_0x1227:
            java.lang.String r0 = "egy"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1231
            goto L_0x23f0
        L_0x1231:
            java.lang.String r3 = "Egyptian"
            goto L_0x23ef
        L_0x1235:
            java.lang.String r0 = "efi"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x123f
            goto L_0x23f0
        L_0x123f:
            java.lang.String r3 = "Efik"
            goto L_0x23ef
        L_0x1243:
            java.lang.String r0 = "dzo"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1fc9
            goto L_0x23f0
        L_0x124d:
            java.lang.String r0 = "dyu"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1257
            goto L_0x23f0
        L_0x1257:
            java.lang.String r3 = "Dyula"
            goto L_0x23ef
        L_0x125b:
            java.lang.String r2 = "dut"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x1265
            goto L_0x23f0
        L_0x1265:
            r1 = 2131820639(0x7f11005f, float:1.9273999E38)
            java.lang.String r3 = r0.getString(r1)
            java.lang.String r0 = "mContext.getString(R.string.audio_dut)"
            t9.i.f(r3, r0)
            goto L_0x23ef
        L_0x1273:
            java.lang.String r0 = "dum"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x127d
            goto L_0x23f0
        L_0x127d:
            java.lang.String r3 = "Middle Dutch"
            goto L_0x23ef
        L_0x1281:
            java.lang.String r0 = "dua"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x128b
            goto L_0x23f0
        L_0x128b:
            java.lang.String r3 = "Duala"
            goto L_0x23ef
        L_0x128f:
            java.lang.String r0 = "dsb"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1299
            goto L_0x23f0
        L_0x1299:
            java.lang.String r3 = "Lower Sorbian"
            goto L_0x23ef
        L_0x129d:
            java.lang.String r0 = "doi"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x12a7
            goto L_0x23f0
        L_0x12a7:
            java.lang.String r3 = "Dogri (macrolanguage)"
            goto L_0x23ef
        L_0x12ab:
            java.lang.String r0 = "div"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1fd7
            goto L_0x23f0
        L_0x12b5:
            java.lang.String r0 = "din"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x12bf
            goto L_0x23f0
        L_0x12bf:
            java.lang.String r3 = "Dinka"
            goto L_0x23ef
        L_0x12c3:
            java.lang.String r0 = "dgr"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x12cd
            goto L_0x23f0
        L_0x12cd:
            java.lang.String r3 = "Dogrib"
            goto L_0x23ef
        L_0x12d1:
            java.lang.String r0 = "den"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x12db
            goto L_0x23f0
        L_0x12db:
            java.lang.String r3 = "Slave"
            goto L_0x23ef
        L_0x12df:
            java.lang.String r0 = "del"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x12e9
            goto L_0x23f0
        L_0x12e9:
            java.lang.String r3 = "Delaware"
            goto L_0x23ef
        L_0x12ed:
            java.lang.String r0 = "dar"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x12f7
            goto L_0x23f0
        L_0x12f7:
            java.lang.String r3 = "Dargwa"
            goto L_0x23ef
        L_0x12fb:
            java.lang.String r0 = "dan"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1ff3
            goto L_0x23f0
        L_0x1305:
            java.lang.String r0 = "dak"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x130f
            goto L_0x23f0
        L_0x130f:
            java.lang.String r3 = "Dakota"
            goto L_0x23ef
        L_0x1313:
            java.lang.String r0 = "csb"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x131d
            goto L_0x23f0
        L_0x131d:
            java.lang.String r3 = "Kashubian"
            goto L_0x23ef
        L_0x1321:
            java.lang.String r0 = "crh"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x132b
            goto L_0x23f0
        L_0x132b:
            java.lang.String r3 = "Crimean Tatar"
            goto L_0x23ef
        L_0x132f:
            java.lang.String r0 = "cre"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2037
            goto L_0x23f0
        L_0x1339:
            java.lang.String r0 = "cos"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2045
            goto L_0x23f0
        L_0x1343:
            java.lang.String r0 = "cor"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1ca4
            goto L_0x23f0
        L_0x134d:
            java.lang.String r0 = "cop"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1357
            goto L_0x23f0
        L_0x1357:
            java.lang.String r3 = "Coptic"
            goto L_0x23ef
        L_0x135b:
            java.lang.String r0 = "chy"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1365
            goto L_0x23f0
        L_0x1365:
            java.lang.String r3 = "Cheyenne"
            goto L_0x23ef
        L_0x1369:
            java.lang.String r0 = "chv"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x200e
            goto L_0x23f0
        L_0x1373:
            java.lang.String r0 = "chu"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x201c
            goto L_0x23f0
        L_0x137d:
            java.lang.String r0 = "chr"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1387
            goto L_0x23f0
        L_0x1387:
            java.lang.String r3 = "Cherokee"
            goto L_0x23ef
        L_0x138b:
            java.lang.String r0 = "chp"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1395
            goto L_0x23f0
        L_0x1395:
            java.lang.String r3 = "Chipewyan"
            goto L_0x23ef
        L_0x1399:
            java.lang.String r0 = "cho"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x13a3
            goto L_0x23f0
        L_0x13a3:
            java.lang.String r3 = "Choctaw"
            goto L_0x23ef
        L_0x13a7:
            java.lang.String r0 = "chn"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x13b1
            goto L_0x23f0
        L_0x13b1:
            java.lang.String r3 = "Chinook jargon"
            goto L_0x23ef
        L_0x13b5:
            java.lang.String r0 = "chm"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x13bf
            goto L_0x23f0
        L_0x13bf:
            java.lang.String r3 = "Mari"
            goto L_0x23ef
        L_0x13c3:
            java.lang.String r0 = "chk"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x13cd
            goto L_0x23f0
        L_0x13cd:
            java.lang.String r3 = "Chuukese"
            goto L_0x23ef
        L_0x13d1:
            java.lang.String r2 = "chi"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x1773
            goto L_0x23f0
        L_0x13db:
            java.lang.String r0 = "chg"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x13e5
            goto L_0x23f0
        L_0x13e5:
            java.lang.String r3 = "Chagatai"
            goto L_0x23ef
        L_0x13e9:
            java.lang.String r0 = "che"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2061
            goto L_0x23f0
        L_0x13f3:
            java.lang.String r0 = "chb"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x13fd
            goto L_0x23f0
        L_0x13fd:
            java.lang.String r3 = "Chibcha"
            goto L_0x23ef
        L_0x1401:
            java.lang.String r0 = "cha"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2053
            goto L_0x23f0
        L_0x140b:
            java.lang.String r0 = "ceb"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1415
            goto L_0x23f0
        L_0x1415:
            java.lang.String r3 = "Cebuano"
            goto L_0x23ef
        L_0x1419:
            java.lang.String r0 = "cat"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x206f
            goto L_0x23f0
        L_0x1423:
            java.lang.String r0 = "car"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x142d
            goto L_0x23f0
        L_0x142d:
            java.lang.String r3 = "Galibi Carib"
            goto L_0x23ef
        L_0x1431:
            java.lang.String r0 = "cad"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x143b
            goto L_0x23f0
        L_0x143b:
            java.lang.String r3 = "Caddo"
            goto L_0x23ef
        L_0x143f:
            java.lang.String r0 = "byn"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1449
            goto L_0x23f0
        L_0x1449:
            java.lang.String r3 = "Bilin"
            goto L_0x23ef
        L_0x144d:
            java.lang.String r0 = "bul"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x20d7
            goto L_0x23f0
        L_0x1457:
            java.lang.String r0 = "bug"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1461
            goto L_0x23f0
        L_0x1461:
            java.lang.String r3 = "Buginese"
            goto L_0x23ef
        L_0x1465:
            java.lang.String r0 = "bua"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x146f
            goto L_0x23f0
        L_0x146f:
            java.lang.String r3 = "Buriat"
            goto L_0x23ef
        L_0x1473:
            java.lang.String r0 = "bre"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x208b
            goto L_0x23f0
        L_0x147d:
            java.lang.String r0 = "bra"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1487
            goto L_0x23f0
        L_0x1487:
            java.lang.String r3 = "Braj"
            goto L_0x23ef
        L_0x148b:
            java.lang.String r0 = "bos"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x207d
            goto L_0x23f0
        L_0x1495:
            java.lang.String r0 = "bod"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x235a
            goto L_0x23f0
        L_0x149f:
            java.lang.String r0 = "bnt"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x14a9
            goto L_0x23f0
        L_0x14a9:
            java.lang.String r3 = "Bantu"
            goto L_0x23ef
        L_0x14ad:
            java.lang.String r0 = "bla"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x14b7
            goto L_0x23f0
        L_0x14b7:
            java.lang.String r3 = "Siksika"
            goto L_0x23ef
        L_0x14bb:
            java.lang.String r0 = "bis"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x20bf
            goto L_0x23f0
        L_0x14c5:
            java.lang.String r0 = "bin"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x14cf
            goto L_0x23f0
        L_0x14cf:
            java.lang.String r3 = "Bini"
            goto L_0x23ef
        L_0x14d3:
            java.lang.String r0 = "bik"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x14dd
            goto L_0x23f0
        L_0x14dd:
            java.lang.String r3 = "Bikol"
            goto L_0x23ef
        L_0x14e1:
            java.lang.String r0 = "bih"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x21e3
            goto L_0x23f0
        L_0x14eb:
            java.lang.String r0 = "bho"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x14f5
            goto L_0x23f0
        L_0x14f5:
            java.lang.String r3 = "Bhojpuri"
            goto L_0x23ef
        L_0x14f9:
            java.lang.String r0 = "ber"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x21ff
            goto L_0x23f0
        L_0x1503:
            java.lang.String r0 = "ben"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x20a3
            goto L_0x23f0
        L_0x150d:
            java.lang.String r0 = "bem"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1517
            goto L_0x23f0
        L_0x1517:
            java.lang.String r3 = "Bemba"
            goto L_0x23ef
        L_0x151b:
            java.lang.String r0 = "bel"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x20e5
            goto L_0x23f0
        L_0x1525:
            java.lang.String r0 = "bej"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x152f
            goto L_0x23f0
        L_0x152f:
            java.lang.String r3 = "Beja"
            goto L_0x23ef
        L_0x1533:
            java.lang.String r0 = "bat"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x221b
            goto L_0x23f0
        L_0x153d:
            java.lang.String r0 = "bas"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1547
            goto L_0x23f0
        L_0x1547:
            java.lang.String r3 = "Basa (Cameroon)"
            goto L_0x23ef
        L_0x154b:
            java.lang.String r0 = "baq"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2367
            goto L_0x23f0
        L_0x1555:
            java.lang.String r0 = "ban"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x155f
            goto L_0x23f0
        L_0x155f:
            java.lang.String r3 = "Balinese"
            goto L_0x23ef
        L_0x1563:
            java.lang.String r0 = "bam"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x20b1
            goto L_0x23f0
        L_0x156d:
            java.lang.String r0 = "bal"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1577
            goto L_0x23f0
        L_0x1577:
            java.lang.String r3 = "Baluchi"
            goto L_0x23ef
        L_0x157b:
            java.lang.String r0 = "bak"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x20f3
            goto L_0x23f0
        L_0x1585:
            java.lang.String r0 = "bai"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2233
            goto L_0x23f0
        L_0x158f:
            java.lang.String r0 = "bad"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2241
            goto L_0x23f0
        L_0x1599:
            java.lang.String r0 = "aze"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2101
            goto L_0x23f0
        L_0x15a3:
            java.lang.String r0 = "aym"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x210f
            goto L_0x23f0
        L_0x15ad:
            java.lang.String r0 = "awa"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x15b7
            goto L_0x23f0
        L_0x15b7:
            java.lang.String r3 = "Awadhi"
            goto L_0x23ef
        L_0x15bb:
            java.lang.String r0 = "ave"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2189
            goto L_0x23f0
        L_0x15c5:
            java.lang.String r0 = "ava"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x211d
            goto L_0x23f0
        L_0x15cf:
            java.lang.String r0 = "aus"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x228d
            goto L_0x23f0
        L_0x15d9:
            java.lang.String r0 = "ath"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x22a5
            goto L_0x23f0
        L_0x15e3:
            java.lang.String r0 = "ast"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x15ed
            goto L_0x23f0
        L_0x15ed:
            java.lang.String r3 = "Asturian"
            goto L_0x23ef
        L_0x15f1:
            java.lang.String r0 = "asm"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x212b
            goto L_0x23f0
        L_0x15fb:
            java.lang.String r0 = "arw"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1605
            goto L_0x23f0
        L_0x1605:
            java.lang.String r3 = "Arawak"
            goto L_0x23ef
        L_0x1609:
            java.lang.String r0 = "art"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x22b3
            goto L_0x23f0
        L_0x1613:
            java.lang.String r0 = "arp"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x161d
            goto L_0x23f0
        L_0x161d:
            java.lang.String r3 = "Arapaho"
            goto L_0x23ef
        L_0x1621:
            java.lang.String r0 = "arn"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x162b
            goto L_0x23f0
        L_0x162b:
            java.lang.String r3 = "Mapudungun"
            goto L_0x23ef
        L_0x162f:
            java.lang.String r0 = "arm"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x22c1
            goto L_0x23f0
        L_0x1639:
            java.lang.String r0 = "arg"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2151
            goto L_0x23f0
        L_0x1643:
            java.lang.String r0 = "arc"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x164d
            goto L_0x23f0
        L_0x164d:
            java.lang.String r3 = "Official Aramaic"
            goto L_0x23ef
        L_0x1651:
            java.lang.String r2 = "ara"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x2139
            goto L_0x23f0
        L_0x165b:
            java.lang.String r0 = "apa"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1665
            goto L_0x23f0
        L_0x1665:
            java.lang.String r3 = "Apache languages"
            goto L_0x23ef
        L_0x1669:
            java.lang.String r0 = "anp"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1673
            goto L_0x23f0
        L_0x1673:
            java.lang.String r3 = "Angika"
            goto L_0x23ef
        L_0x1677:
            java.lang.String r0 = "ang"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1681
            goto L_0x23f0
        L_0x1681:
            java.lang.String r3 = "Old English"
            goto L_0x23ef
        L_0x1685:
            java.lang.String r0 = "amh"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x215f
            goto L_0x23f0
        L_0x168f:
            java.lang.String r0 = "alt"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1699
            goto L_0x23f0
        L_0x1699:
            java.lang.String r3 = "Southern Altai"
            goto L_0x23ef
        L_0x169d:
            java.lang.String r0 = "alg"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x16a7
            goto L_0x23f0
        L_0x16a7:
            java.lang.String r3 = "Algonquian languages"
            goto L_0x23ef
        L_0x16ab:
            java.lang.String r0 = "ale"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x16b5
            goto L_0x23f0
        L_0x16b5:
            java.lang.String r3 = "Aleut"
            goto L_0x23ef
        L_0x16b9:
            java.lang.String r0 = "alb"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x23a8
            goto L_0x23f0
        L_0x16c3:
            java.lang.String r0 = "akk"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x16cd
            goto L_0x23f0
        L_0x16cd:
            java.lang.String r3 = "Akkadian"
            goto L_0x23ef
        L_0x16d1:
            java.lang.String r0 = "aka"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x216d
            goto L_0x23f0
        L_0x16db:
            java.lang.String r0 = "ain"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x16e5
            goto L_0x23f0
        L_0x16e5:
            java.lang.String r3 = "Ainu"
            goto L_0x23ef
        L_0x16e9:
            java.lang.String r0 = "afr"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x217b
            goto L_0x23f0
        L_0x16f3:
            java.lang.String r0 = "afh"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x16fd
            goto L_0x23f0
        L_0x16fd:
            java.lang.String r3 = "Afrihili"
            goto L_0x23ef
        L_0x1701:
            java.lang.String r0 = "afa"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x170b
            goto L_0x23f0
        L_0x170b:
            java.lang.String r3 = "Afro-Asiatic"
            goto L_0x23ef
        L_0x170f:
            java.lang.String r0 = "ady"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1719
            goto L_0x23f0
        L_0x1719:
            java.lang.String r3 = "Adyghe"
            goto L_0x23ef
        L_0x171d:
            java.lang.String r0 = "ada"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1727
            goto L_0x23f0
        L_0x1727:
            java.lang.String r3 = "Adangme"
            goto L_0x23ef
        L_0x172b:
            java.lang.String r0 = "ach"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1735
            goto L_0x23f0
        L_0x1735:
            java.lang.String r3 = "Acoli"
            goto L_0x23ef
        L_0x1739:
            java.lang.String r0 = "ace"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1743
            goto L_0x23f0
        L_0x1743:
            java.lang.String r3 = "Achinese"
            goto L_0x23ef
        L_0x1747:
            java.lang.String r0 = "abk"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2197
            goto L_0x23f0
        L_0x1751:
            java.lang.String r0 = "aar"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x21a5
            goto L_0x23f0
        L_0x175b:
            java.lang.String r0 = "zu"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1765
            goto L_0x23f0
        L_0x1765:
            java.lang.String r3 = "Zulu"
            goto L_0x23ef
        L_0x1769:
            java.lang.String r2 = "zh"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x1773
            goto L_0x23f0
        L_0x1773:
            r1 = 2131820645(0x7f110065, float:1.927401E38)
            java.lang.String r3 = r0.getString(r1)
            java.lang.String r0 = "mContext.getString(R.string.audio_zh)"
            t9.i.f(r3, r0)
            goto L_0x23ef
        L_0x1781:
            java.lang.String r0 = "za"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x178b
            goto L_0x23f0
        L_0x178b:
            java.lang.String r3 = "Zhuang"
            goto L_0x23ef
        L_0x178f:
            java.lang.String r0 = "yo"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1799
            goto L_0x23f0
        L_0x1799:
            java.lang.String r3 = "Yoruba"
            goto L_0x23ef
        L_0x179d:
            java.lang.String r0 = "yi"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x17a7
            goto L_0x23f0
        L_0x17a7:
            java.lang.String r3 = "Yiddish"
            goto L_0x23ef
        L_0x17ab:
            java.lang.String r0 = "xh"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x17b5
            goto L_0x23f0
        L_0x17b5:
            java.lang.String r3 = "Xhosa"
            goto L_0x23ef
        L_0x17b9:
            java.lang.String r0 = "wo"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x17c3
            goto L_0x23f0
        L_0x17c3:
            java.lang.String r3 = "Wolof"
            goto L_0x23ef
        L_0x17c7:
            java.lang.String r0 = "wa"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x17d1
            goto L_0x23f0
        L_0x17d1:
            java.lang.String r3 = "Walloon"
            goto L_0x23ef
        L_0x17d5:
            java.lang.String r0 = "vo"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x17df
            goto L_0x23f0
        L_0x17df:
            java.lang.String r3 = "Volapük"
            goto L_0x23ef
        L_0x17e3:
            java.lang.String r0 = "vi"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x17ed
            goto L_0x23f0
        L_0x17ed:
            java.lang.String r3 = "Vietnamese"
            goto L_0x23ef
        L_0x17f1:
            java.lang.String r0 = "ve"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x17fb
            goto L_0x23f0
        L_0x17fb:
            java.lang.String r3 = "Venda"
            goto L_0x23ef
        L_0x17ff:
            java.lang.String r0 = "uz"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1809
            goto L_0x23f0
        L_0x1809:
            java.lang.String r3 = "Uzbek"
            goto L_0x23ef
        L_0x180d:
            java.lang.String r0 = "ur"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1817
            goto L_0x23f0
        L_0x1817:
            java.lang.String r3 = "Urdu"
            goto L_0x23ef
        L_0x181b:
            java.lang.String r0 = "uk"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1825
            goto L_0x23f0
        L_0x1825:
            java.lang.String r3 = "Ukrainian"
            goto L_0x23ef
        L_0x1829:
            java.lang.String r0 = "ug"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1833
            goto L_0x23f0
        L_0x1833:
            java.lang.String r3 = "Uighur"
            goto L_0x23ef
        L_0x1837:
            java.lang.String r0 = "ty"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1841
            goto L_0x23f0
        L_0x1841:
            java.lang.String r3 = "Tahitian"
            goto L_0x23ef
        L_0x1845:
            java.lang.String r0 = "tw"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x184f
            goto L_0x23f0
        L_0x184f:
            java.lang.String r3 = "Twi"
            goto L_0x23ef
        L_0x1853:
            java.lang.String r0 = "tt"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x185d
            goto L_0x23f0
        L_0x185d:
            java.lang.String r3 = "Tatar"
            goto L_0x23ef
        L_0x1861:
            java.lang.String r0 = "ts"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x186b
            goto L_0x23f0
        L_0x186b:
            java.lang.String r3 = "Tsonga"
            goto L_0x23ef
        L_0x186f:
            java.lang.String r0 = "tr"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1879
            goto L_0x23f0
        L_0x1879:
            java.lang.String r3 = "Turkish"
            goto L_0x23ef
        L_0x187d:
            java.lang.String r0 = "to"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1887
            goto L_0x23f0
        L_0x1887:
            java.lang.String r3 = "Tonga (Tonga Islands)"
            goto L_0x23ef
        L_0x188b:
            java.lang.String r0 = "tn"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1895
            goto L_0x23f0
        L_0x1895:
            java.lang.String r3 = "Tswana"
            goto L_0x23ef
        L_0x1899:
            java.lang.String r0 = "tl"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x18a3
            goto L_0x23f0
        L_0x18a3:
            java.lang.String r3 = "Tagalog"
            goto L_0x23ef
        L_0x18a7:
            java.lang.String r0 = "tk"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x18b1
            goto L_0x23f0
        L_0x18b1:
            java.lang.String r3 = "Turkmen"
            goto L_0x23ef
        L_0x18b5:
            java.lang.String r0 = "ti"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x18bf
            goto L_0x23f0
        L_0x18bf:
            java.lang.String r3 = "Tigrinya"
            goto L_0x23ef
        L_0x18c3:
            java.lang.String r0 = "th"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x18cd
            goto L_0x23f0
        L_0x18cd:
            java.lang.String r3 = "Thai"
            goto L_0x23ef
        L_0x18d1:
            java.lang.String r0 = "tg"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x18db
            goto L_0x23f0
        L_0x18db:
            java.lang.String r3 = "Tajik"
            goto L_0x23ef
        L_0x18df:
            java.lang.String r0 = "te"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x18e9
            goto L_0x23f0
        L_0x18e9:
            java.lang.String r3 = "Telugu"
            goto L_0x23ef
        L_0x18ed:
            java.lang.String r0 = "ta"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x18f7
            goto L_0x23f0
        L_0x18f7:
            java.lang.String r3 = "Tamil"
            goto L_0x23ef
        L_0x18fb:
            java.lang.String r0 = "sw"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1905
            goto L_0x23f0
        L_0x1905:
            java.lang.String r3 = "Swahili (macrolanguage)"
            goto L_0x23ef
        L_0x1909:
            java.lang.String r0 = "sv"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1913
            goto L_0x23f0
        L_0x1913:
            java.lang.String r3 = "Swedish"
            goto L_0x23ef
        L_0x1917:
            java.lang.String r0 = "su"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1921
            goto L_0x23f0
        L_0x1921:
            java.lang.String r3 = "Sundanese"
            goto L_0x23ef
        L_0x1925:
            java.lang.String r0 = "st"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x192f
            goto L_0x23f0
        L_0x192f:
            java.lang.String r3 = "Southern Sotho"
            goto L_0x23ef
        L_0x1933:
            java.lang.String r0 = "ss"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x193d
            goto L_0x23f0
        L_0x193d:
            java.lang.String r3 = "Swati"
            goto L_0x23ef
        L_0x1941:
            java.lang.String r0 = "sr"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x239c
            goto L_0x23f0
        L_0x194b:
            java.lang.String r0 = "sq"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x23a8
            goto L_0x23f0
        L_0x1955:
            java.lang.String r0 = "so"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x195f
            goto L_0x23f0
        L_0x195f:
            java.lang.String r3 = "Somali"
            goto L_0x23ef
        L_0x1963:
            java.lang.String r0 = "sn"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x196d
            goto L_0x23f0
        L_0x196d:
            java.lang.String r3 = "Shona"
            goto L_0x23ef
        L_0x1971:
            java.lang.String r0 = "sm"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x197b
            goto L_0x23f0
        L_0x197b:
            java.lang.String r3 = "Samoan"
            goto L_0x23ef
        L_0x197f:
            java.lang.String r0 = "sl"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1989
            goto L_0x23f0
        L_0x1989:
            java.lang.String r3 = "Slovenian"
            goto L_0x23ef
        L_0x198d:
            java.lang.String r0 = "sk"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x23e1
            goto L_0x23f0
        L_0x1997:
            java.lang.String r0 = "si"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x19a1
            goto L_0x23f0
        L_0x19a1:
            java.lang.String r3 = "Sinhala"
            goto L_0x23ef
        L_0x19a5:
            java.lang.String r0 = "sg"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x19af
            goto L_0x23f0
        L_0x19af:
            java.lang.String r3 = "Sango"
            goto L_0x23ef
        L_0x19b3:
            java.lang.String r0 = "se"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x19bd
            goto L_0x23f0
        L_0x19bd:
            java.lang.String r3 = "Northern Sami"
            goto L_0x23ef
        L_0x19c1:
            java.lang.String r0 = "sd"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x19cb
            goto L_0x23f0
        L_0x19cb:
            java.lang.String r3 = "Sindhi"
            goto L_0x23ef
        L_0x19cf:
            java.lang.String r0 = "sc"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x19d9
            goto L_0x23f0
        L_0x19d9:
            java.lang.String r3 = "Sardinian"
            goto L_0x23ef
        L_0x19dd:
            java.lang.String r0 = "sa"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x19e7
            goto L_0x23f0
        L_0x19e7:
            java.lang.String r3 = "Sanskrit"
            goto L_0x23ef
        L_0x19eb:
            java.lang.String r0 = "rw"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x19f5
            goto L_0x23f0
        L_0x19f5:
            java.lang.String r3 = "Kinyarwanda"
            goto L_0x23ef
        L_0x19f9:
            java.lang.String r0 = "ru"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1a03
            goto L_0x23f0
        L_0x1a03:
            java.lang.String r3 = "Russian"
            goto L_0x23ef
        L_0x1a07:
            java.lang.String r0 = "ro"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1a11
            goto L_0x23f0
        L_0x1a11:
            r3 = r4
            goto L_0x23ef
        L_0x1a14:
            java.lang.String r0 = "rn"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1a1e
            goto L_0x23f0
        L_0x1a1e:
            java.lang.String r3 = "Rundi"
            goto L_0x23ef
        L_0x1a22:
            java.lang.String r0 = "rm"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1a2c
            goto L_0x23f0
        L_0x1a2c:
            java.lang.String r3 = "Romansh"
            goto L_0x23ef
        L_0x1a30:
            java.lang.String r0 = "qu"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1a3a
            goto L_0x23f0
        L_0x1a3a:
            java.lang.String r3 = "Quechua"
            goto L_0x23ef
        L_0x1a3e:
            java.lang.String r2 = "pt"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x1a48
            goto L_0x23f0
        L_0x1a48:
            r1 = 2131821107(0x7f110233, float:1.9274948E38)
            java.lang.String r3 = r0.getString(r1)
            java.lang.String r0 = "mContext.getString(R.string.language_pt)"
            t9.i.f(r3, r0)
            goto L_0x23ef
        L_0x1a56:
            java.lang.String r0 = "ps"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1a60
            goto L_0x23f0
        L_0x1a60:
            java.lang.String r3 = "Pushto"
            goto L_0x23ef
        L_0x1a64:
            java.lang.String r0 = "pl"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1a6e
            goto L_0x23f0
        L_0x1a6e:
            java.lang.String r3 = "Polish"
            goto L_0x23ef
        L_0x1a72:
            java.lang.String r0 = "pi"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1a7c
            goto L_0x23f0
        L_0x1a7c:
            java.lang.String r3 = "Pali"
            goto L_0x23ef
        L_0x1a80:
            java.lang.String r0 = "pa"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1a8a
            goto L_0x23f0
        L_0x1a8a:
            java.lang.String r3 = "Panjabi"
            goto L_0x23ef
        L_0x1a8e:
            java.lang.String r0 = "os"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1a98
            goto L_0x23f0
        L_0x1a98:
            java.lang.String r3 = "Ossetian"
            goto L_0x23ef
        L_0x1a9c:
            java.lang.String r0 = "or"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1aa6
            goto L_0x23f0
        L_0x1aa6:
            java.lang.String r3 = "Oriya"
            goto L_0x23ef
        L_0x1aaa:
            java.lang.String r0 = "om"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1ab4
            goto L_0x23f0
        L_0x1ab4:
            java.lang.String r3 = "Oromo"
            goto L_0x23ef
        L_0x1ab8:
            java.lang.String r0 = "oj"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1ac2
            goto L_0x23f0
        L_0x1ac2:
            java.lang.String r3 = "Ojibwa"
            goto L_0x23ef
        L_0x1ac6:
            java.lang.String r0 = "oc"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1ad0
            goto L_0x23f0
        L_0x1ad0:
            java.lang.String r3 = "Occitan "
            goto L_0x23ef
        L_0x1ad4:
            java.lang.String r0 = "ny"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1ade
            goto L_0x23f0
        L_0x1ade:
            java.lang.String r3 = "Nyanja"
            goto L_0x23ef
        L_0x1ae2:
            java.lang.String r0 = "nv"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1aec
            goto L_0x23f0
        L_0x1aec:
            java.lang.String r3 = "Navajo"
            goto L_0x23ef
        L_0x1af0:
            java.lang.String r0 = "nr"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1afa
            goto L_0x23f0
        L_0x1afa:
            java.lang.String r3 = "South Ndebele"
            goto L_0x23ef
        L_0x1afe:
            java.lang.String r0 = "no"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1b08
            goto L_0x23f0
        L_0x1b08:
            java.lang.String r3 = "Norwegian"
            goto L_0x23ef
        L_0x1b0c:
            java.lang.String r0 = "nn"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1b16
            goto L_0x23f0
        L_0x1b16:
            java.lang.String r3 = "Norwegian Nynorsk"
            goto L_0x23ef
        L_0x1b1a:
            java.lang.String r0 = "nl"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1b24
            goto L_0x23f0
        L_0x1b24:
            r3 = r5
            goto L_0x23ef
        L_0x1b27:
            java.lang.String r0 = "ng"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1b31
            goto L_0x23f0
        L_0x1b31:
            java.lang.String r3 = "Ndonga"
            goto L_0x23ef
        L_0x1b35:
            java.lang.String r0 = "ne"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1b3f
            goto L_0x23f0
        L_0x1b3f:
            java.lang.String r3 = "Nepali"
            goto L_0x23ef
        L_0x1b43:
            java.lang.String r0 = "nd"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1b4d
            goto L_0x23f0
        L_0x1b4d:
            java.lang.String r3 = "North Ndebele"
            goto L_0x23ef
        L_0x1b51:
            java.lang.String r0 = "nb"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1b5b
            goto L_0x23f0
        L_0x1b5b:
            java.lang.String r3 = "Norwegian Bokmål"
            goto L_0x23ef
        L_0x1b5f:
            java.lang.String r0 = "na"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1b69
            goto L_0x23f0
        L_0x1b69:
            java.lang.String r3 = "Nauru"
            goto L_0x23ef
        L_0x1b6d:
            java.lang.String r0 = "my"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1b77
            goto L_0x23f0
        L_0x1b77:
            r3 = r6
            goto L_0x23ef
        L_0x1b7a:
            java.lang.String r0 = "mt"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1b84
            goto L_0x23f0
        L_0x1b84:
            java.lang.String r3 = "Maltese"
            goto L_0x23ef
        L_0x1b88:
            java.lang.String r2 = "ms"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x1b92
            goto L_0x23f0
        L_0x1b92:
            r1 = 2131821106(0x7f110232, float:1.9274946E38)
            java.lang.String r3 = r0.getString(r1)
            java.lang.String r0 = "mContext.getString(R.string.language_ms)"
            t9.i.f(r3, r0)
            goto L_0x23ef
        L_0x1ba0:
            java.lang.String r0 = "mr"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1baa
            goto L_0x23f0
        L_0x1baa:
            java.lang.String r3 = "Marathi"
            goto L_0x23ef
        L_0x1bae:
            java.lang.String r0 = "mo"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1bb8
            goto L_0x23f0
        L_0x1bb8:
            java.lang.String r3 = "Moldavian"
            goto L_0x23ef
        L_0x1bbc:
            java.lang.String r0 = "mn"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1bc6
            goto L_0x23f0
        L_0x1bc6:
            java.lang.String r3 = "Mongolian"
            goto L_0x23ef
        L_0x1bca:
            java.lang.String r0 = "ml"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1bd4
            goto L_0x23f0
        L_0x1bd4:
            java.lang.String r3 = "Malayalam"
            goto L_0x23ef
        L_0x1bd8:
            java.lang.String r0 = "mk"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1be2
            goto L_0x23f0
        L_0x1be2:
            r3 = r7
            goto L_0x23ef
        L_0x1be5:
            java.lang.String r0 = "mi"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1bef
            goto L_0x23f0
        L_0x1bef:
            r3 = r8
            goto L_0x23ef
        L_0x1bf2:
            java.lang.String r0 = "mh"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1bfc
            goto L_0x23f0
        L_0x1bfc:
            java.lang.String r3 = "Marshallese"
            goto L_0x23ef
        L_0x1c00:
            java.lang.String r0 = "mg"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1c0a
            goto L_0x23f0
        L_0x1c0a:
            java.lang.String r3 = "Malagasy"
            goto L_0x23ef
        L_0x1c0e:
            java.lang.String r0 = "lv"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1c18
            goto L_0x23f0
        L_0x1c18:
            java.lang.String r3 = "Latvian"
            goto L_0x23ef
        L_0x1c1c:
            java.lang.String r0 = "lu"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1c26
            goto L_0x23f0
        L_0x1c26:
            java.lang.String r3 = "Luba-Katanga"
            goto L_0x23ef
        L_0x1c2a:
            java.lang.String r0 = "lt"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1c34
            goto L_0x23f0
        L_0x1c34:
            java.lang.String r3 = "Lithuanian"
            goto L_0x23ef
        L_0x1c38:
            java.lang.String r0 = "lo"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1c42
            goto L_0x23f0
        L_0x1c42:
            java.lang.String r3 = "Lao"
            goto L_0x23ef
        L_0x1c46:
            java.lang.String r0 = "ln"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1c50
            goto L_0x23f0
        L_0x1c50:
            java.lang.String r3 = "Lingala"
            goto L_0x23ef
        L_0x1c54:
            java.lang.String r0 = "li"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1c5e
            goto L_0x23f0
        L_0x1c5e:
            java.lang.String r3 = "Limburgan"
            goto L_0x23ef
        L_0x1c62:
            java.lang.String r0 = "lg"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1c6c
            goto L_0x23f0
        L_0x1c6c:
            java.lang.String r3 = "Ganda"
            goto L_0x23ef
        L_0x1c70:
            java.lang.String r0 = "lb"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1c7a
            goto L_0x23f0
        L_0x1c7a:
            java.lang.String r3 = "Luxembourgish"
            goto L_0x23ef
        L_0x1c7e:
            java.lang.String r0 = "la"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1c88
            goto L_0x23f0
        L_0x1c88:
            java.lang.String r3 = "Latin"
            goto L_0x23ef
        L_0x1c8c:
            java.lang.String r0 = "ky"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1c96
            goto L_0x23f0
        L_0x1c96:
            java.lang.String r3 = "Kirghiz"
            goto L_0x23ef
        L_0x1c9a:
            java.lang.String r0 = "kw"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1ca4
            goto L_0x23f0
        L_0x1ca4:
            java.lang.String r3 = "Cornish"
            goto L_0x23ef
        L_0x1ca8:
            java.lang.String r0 = "kv"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1cb2
            goto L_0x23f0
        L_0x1cb2:
            java.lang.String r3 = "Komi"
            goto L_0x23ef
        L_0x1cb6:
            java.lang.String r0 = "ku"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1cc0
            goto L_0x23f0
        L_0x1cc0:
            java.lang.String r3 = "Kurdish"
            goto L_0x23ef
        L_0x1cc4:
            java.lang.String r0 = "ks"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1cce
            goto L_0x23f0
        L_0x1cce:
            java.lang.String r3 = "Kashmiri"
            goto L_0x23ef
        L_0x1cd2:
            java.lang.String r0 = "kr"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1cdc
            goto L_0x23f0
        L_0x1cdc:
            java.lang.String r3 = "Kanuri"
            goto L_0x23ef
        L_0x1ce0:
            java.lang.String r0 = "ko"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1cea
            goto L_0x23f0
        L_0x1cea:
            java.lang.String r3 = "Korean"
            goto L_0x23ef
        L_0x1cee:
            java.lang.String r0 = "kn"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1cf8
            goto L_0x23f0
        L_0x1cf8:
            java.lang.String r3 = "Kannada"
            goto L_0x23ef
        L_0x1cfc:
            java.lang.String r0 = "km"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1d06
            goto L_0x23f0
        L_0x1d06:
            java.lang.String r3 = "Central Khmer"
            goto L_0x23ef
        L_0x1d0a:
            java.lang.String r0 = "kl"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1d14
            goto L_0x23f0
        L_0x1d14:
            java.lang.String r3 = "Kalaallisut"
            goto L_0x23ef
        L_0x1d18:
            java.lang.String r0 = "kk"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1d22
            goto L_0x23f0
        L_0x1d22:
            java.lang.String r3 = "Kazakh"
            goto L_0x23ef
        L_0x1d26:
            java.lang.String r0 = "kj"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1d30
            goto L_0x23f0
        L_0x1d30:
            java.lang.String r3 = "Kuanyama"
            goto L_0x23ef
        L_0x1d34:
            java.lang.String r0 = "ki"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1d3e
            goto L_0x23f0
        L_0x1d3e:
            java.lang.String r3 = "Kikuyu"
            goto L_0x23ef
        L_0x1d42:
            java.lang.String r0 = "kg"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1d4c
            goto L_0x23f0
        L_0x1d4c:
            java.lang.String r3 = "Kongo"
            goto L_0x23ef
        L_0x1d50:
            java.lang.String r0 = "ka"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x22f9
            goto L_0x23f0
        L_0x1d5a:
            java.lang.String r0 = "jv"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1d64
            goto L_0x23f0
        L_0x1d64:
            java.lang.String r3 = "Javanese"
            goto L_0x23ef
        L_0x1d68:
            java.lang.String r2 = "ja"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x1d72
            goto L_0x23f0
        L_0x1d72:
            r1 = 2131820643(0x7f110063, float:1.9274007E38)
            java.lang.String r3 = r0.getString(r1)
            java.lang.String r0 = "mContext.getString(R.string.audio_jpn)"
            t9.i.f(r3, r0)
            goto L_0x23ef
        L_0x1d80:
            java.lang.String r0 = "iu"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1d8a
            goto L_0x23f0
        L_0x1d8a:
            java.lang.String r3 = "Inuktitut"
            goto L_0x23ef
        L_0x1d8e:
            java.lang.String r2 = "it"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x1d98
            goto L_0x23f0
        L_0x1d98:
            r1 = 2131820642(0x7f110062, float:1.9274005E38)
            java.lang.String r3 = r0.getString(r1)
            java.lang.String r0 = "mContext.getString(R.string.audio_ita)"
            t9.i.f(r3, r0)
            goto L_0x23ef
        L_0x1da6:
            java.lang.String r0 = "is"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1db0
            goto L_0x23f0
        L_0x1db0:
            java.lang.String r3 = "Icelandic"
            goto L_0x23ef
        L_0x1db4:
            java.lang.String r0 = "io"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1dbe
            goto L_0x23f0
        L_0x1dbe:
            java.lang.String r3 = "Ido"
            goto L_0x23ef
        L_0x1dc2:
            java.lang.String r0 = "ik"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1dcc
            goto L_0x23f0
        L_0x1dcc:
            java.lang.String r3 = "Inupiaq"
            goto L_0x23ef
        L_0x1dd0:
            java.lang.String r0 = "ii"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1dda
            goto L_0x23f0
        L_0x1dda:
            java.lang.String r3 = "Sichuan Yi"
            goto L_0x23ef
        L_0x1dde:
            java.lang.String r0 = "ig"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1de8
            goto L_0x23f0
        L_0x1de8:
            java.lang.String r3 = "Igbo"
            goto L_0x23ef
        L_0x1dec:
            java.lang.String r0 = "ie"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1df6
            goto L_0x23f0
        L_0x1df6:
            java.lang.String r3 = "Interlingue"
            goto L_0x23ef
        L_0x1dfa:
            java.lang.String r0 = "id"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1e04
            goto L_0x23f0
        L_0x1e04:
            java.lang.String r3 = "Indonesian"
            goto L_0x23ef
        L_0x1e08:
            java.lang.String r0 = "ia"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1e12
            goto L_0x23f0
        L_0x1e12:
            java.lang.String r3 = "Interlingua "
            goto L_0x23ef
        L_0x1e16:
            java.lang.String r0 = "hz"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1e20
            goto L_0x23f0
        L_0x1e20:
            java.lang.String r3 = "Herero"
            goto L_0x23ef
        L_0x1e24:
            java.lang.String r0 = "hy"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x22c1
            goto L_0x23f0
        L_0x1e2e:
            java.lang.String r0 = "hu"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1e38
            goto L_0x23f0
        L_0x1e38:
            java.lang.String r3 = "Hungarian"
            goto L_0x23ef
        L_0x1e3c:
            java.lang.String r0 = "ht"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1e46
            goto L_0x23f0
        L_0x1e46:
            java.lang.String r3 = "Haitian"
            goto L_0x23ef
        L_0x1e4a:
            java.lang.String r0 = "hr"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1e54
            goto L_0x23f0
        L_0x1e54:
            r3 = r9
            goto L_0x23ef
        L_0x1e57:
            java.lang.String r0 = "ho"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1e61
            goto L_0x23f0
        L_0x1e61:
            java.lang.String r3 = "Hiri Motu"
            goto L_0x23ef
        L_0x1e65:
            java.lang.String r2 = "hi"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x1e6f
            goto L_0x23f0
        L_0x1e6f:
            r1 = 2131821105(0x7f110231, float:1.9274944E38)
            java.lang.String r3 = r0.getString(r1)
            java.lang.String r0 = "mContext.getString(R.string.language_hi)"
            t9.i.f(r3, r0)
            goto L_0x23ef
        L_0x1e7d:
            java.lang.String r2 = "he"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x1e87
            goto L_0x23f0
        L_0x1e87:
            r1 = 2131820641(0x7f110061, float:1.9274003E38)
            java.lang.String r3 = r0.getString(r1)
            java.lang.String r0 = "mContext.getString(R.string.audio_heb)"
            t9.i.f(r3, r0)
            goto L_0x23ef
        L_0x1e95:
            java.lang.String r0 = "ha"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1e9f
            goto L_0x23f0
        L_0x1e9f:
            java.lang.String r3 = "Hausa"
            goto L_0x23ef
        L_0x1ea3:
            java.lang.String r0 = "gv"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1ead
            goto L_0x23f0
        L_0x1ead:
            java.lang.String r3 = "Manx"
            goto L_0x23ef
        L_0x1eb1:
            java.lang.String r0 = "gu"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1ebb
            goto L_0x23f0
        L_0x1ebb:
            java.lang.String r3 = "Gujarati"
            goto L_0x23ef
        L_0x1ebf:
            java.lang.String r0 = "gn"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1ec9
            goto L_0x23f0
        L_0x1ec9:
            java.lang.String r3 = "Guarani"
            goto L_0x23ef
        L_0x1ecd:
            java.lang.String r0 = "gl"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1ed7
            goto L_0x23f0
        L_0x1ed7:
            java.lang.String r3 = "Galician"
            goto L_0x23ef
        L_0x1edb:
            java.lang.String r0 = "gd"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1ee5
            goto L_0x23f0
        L_0x1ee5:
            java.lang.String r3 = "Scottish Gaelic"
            goto L_0x23ef
        L_0x1ee9:
            java.lang.String r0 = "ga"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1ef3
            goto L_0x23f0
        L_0x1ef3:
            java.lang.String r3 = "Irish"
            goto L_0x23ef
        L_0x1ef7:
            java.lang.String r0 = "fy"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1f01
            goto L_0x23f0
        L_0x1f01:
            java.lang.String r3 = "Western Frisian"
            goto L_0x23ef
        L_0x1f05:
            java.lang.String r2 = "fr"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x2275
            goto L_0x23f0
        L_0x1f0f:
            java.lang.String r0 = "fo"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1f19
            goto L_0x23f0
        L_0x1f19:
            java.lang.String r3 = "Faroese"
            goto L_0x23ef
        L_0x1f1d:
            java.lang.String r0 = "fj"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1f27
            goto L_0x23f0
        L_0x1f27:
            java.lang.String r3 = "Fijian"
            goto L_0x23ef
        L_0x1f2b:
            java.lang.String r0 = "fi"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1f35
            goto L_0x23f0
        L_0x1f35:
            java.lang.String r3 = "Finnish"
            goto L_0x23ef
        L_0x1f39:
            java.lang.String r0 = "ff"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1f43
            goto L_0x23f0
        L_0x1f43:
            java.lang.String r3 = "Fulah"
            goto L_0x23ef
        L_0x1f47:
            java.lang.String r0 = "fa"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x233f
            goto L_0x23f0
        L_0x1f51:
            java.lang.String r0 = "eu"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2367
            goto L_0x23f0
        L_0x1f5b:
            java.lang.String r0 = "et"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1f65
            goto L_0x23f0
        L_0x1f65:
            java.lang.String r3 = "Estonian"
            goto L_0x23ef
        L_0x1f69:
            java.lang.String r2 = "es"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x1f73
            goto L_0x23f0
        L_0x1f73:
            r1 = 2131821103(0x7f11022f, float:1.927494E38)
            java.lang.String r3 = r0.getString(r1)
            java.lang.String r0 = "mContext.getString(R.string.language_es)"
            t9.i.f(r3, r0)
            goto L_0x23ef
        L_0x1f81:
            java.lang.String r0 = "eo"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1f8b
            goto L_0x23f0
        L_0x1f8b:
            java.lang.String r3 = "Esperanto"
            goto L_0x23ef
        L_0x1f8f:
            java.lang.String r2 = "en"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x1f99
            goto L_0x23f0
        L_0x1f99:
            r1 = 2131821102(0x7f11022e, float:1.9274938E38)
            java.lang.String r3 = r0.getString(r1)
            java.lang.String r0 = "mContext.getString(R.string.language_en)"
            t9.i.f(r3, r0)
            goto L_0x23ef
        L_0x1fa7:
            java.lang.String r0 = "el"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2382
            goto L_0x23f0
        L_0x1fb1:
            java.lang.String r0 = "ee"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1fbb
            goto L_0x23f0
        L_0x1fbb:
            java.lang.String r3 = "Ewe"
            goto L_0x23ef
        L_0x1fbf:
            java.lang.String r0 = "dz"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1fc9
            goto L_0x23f0
        L_0x1fc9:
            java.lang.String r3 = "Dzongkha"
            goto L_0x23ef
        L_0x1fcd:
            java.lang.String r0 = "dv"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1fd7
            goto L_0x23f0
        L_0x1fd7:
            java.lang.String r3 = "Dhivehi"
            goto L_0x23ef
        L_0x1fdb:
            java.lang.String r0 = "de"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1fe5
            goto L_0x23f0
        L_0x1fe5:
            java.lang.String r3 = "German"
            goto L_0x23ef
        L_0x1fe9:
            java.lang.String r0 = "da"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x1ff3
            goto L_0x23f0
        L_0x1ff3:
            java.lang.String r3 = "Danish"
            goto L_0x23ef
        L_0x1ff7:
            java.lang.String r0 = "cy"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2001
            goto L_0x23f0
        L_0x2001:
            r3 = r10
            goto L_0x23ef
        L_0x2004:
            java.lang.String r0 = "cv"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x200e
            goto L_0x23f0
        L_0x200e:
            java.lang.String r3 = "Chuvash"
            goto L_0x23ef
        L_0x2012:
            java.lang.String r0 = "cu"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x201c
            goto L_0x23f0
        L_0x201c:
            java.lang.String r3 = "Church Slavic"
            goto L_0x23ef
        L_0x2020:
            java.lang.String r0 = "cs"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x202a
            goto L_0x23f0
        L_0x202a:
            r3 = r11
            goto L_0x23ef
        L_0x202d:
            java.lang.String r0 = "cr"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2037
            goto L_0x23f0
        L_0x2037:
            java.lang.String r3 = "Cree"
            goto L_0x23ef
        L_0x203b:
            java.lang.String r0 = "co"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2045
            goto L_0x23f0
        L_0x2045:
            java.lang.String r3 = "Corsican"
            goto L_0x23ef
        L_0x2049:
            java.lang.String r0 = "ch"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2053
            goto L_0x23f0
        L_0x2053:
            java.lang.String r3 = "Chamorro"
            goto L_0x23ef
        L_0x2057:
            java.lang.String r0 = "ce"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2061
            goto L_0x23f0
        L_0x2061:
            java.lang.String r3 = "Chechen"
            goto L_0x23ef
        L_0x2065:
            java.lang.String r0 = "ca"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x206f
            goto L_0x23f0
        L_0x206f:
            java.lang.String r3 = "Catalan"
            goto L_0x23ef
        L_0x2073:
            java.lang.String r0 = "bs"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x207d
            goto L_0x23f0
        L_0x207d:
            java.lang.String r3 = "Bosnian"
            goto L_0x23ef
        L_0x2081:
            java.lang.String r0 = "br"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x208b
            goto L_0x23f0
        L_0x208b:
            java.lang.String r3 = "Breton"
            goto L_0x23ef
        L_0x208f:
            java.lang.String r0 = "bo"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x235a
            goto L_0x23f0
        L_0x2099:
            java.lang.String r0 = "bn"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x20a3
            goto L_0x23f0
        L_0x20a3:
            java.lang.String r3 = "Bengali"
            goto L_0x23ef
        L_0x20a7:
            java.lang.String r0 = "bm"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x20b1
            goto L_0x23f0
        L_0x20b1:
            java.lang.String r3 = "Bambara"
            goto L_0x23ef
        L_0x20b5:
            java.lang.String r0 = "bi"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x20bf
            goto L_0x23f0
        L_0x20bf:
            java.lang.String r3 = "Bislama"
            goto L_0x23ef
        L_0x20c3:
            java.lang.String r0 = "bh"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x21e3
            goto L_0x23f0
        L_0x20cd:
            java.lang.String r0 = "bg"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x20d7
            goto L_0x23f0
        L_0x20d7:
            java.lang.String r3 = "Bulgarian"
            goto L_0x23ef
        L_0x20db:
            java.lang.String r0 = "be"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x20e5
            goto L_0x23f0
        L_0x20e5:
            java.lang.String r3 = "Belarusian"
            goto L_0x23ef
        L_0x20e9:
            java.lang.String r0 = "ba"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x20f3
            goto L_0x23f0
        L_0x20f3:
            java.lang.String r3 = "Bashkir"
            goto L_0x23ef
        L_0x20f7:
            java.lang.String r0 = "az"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2101
            goto L_0x23f0
        L_0x2101:
            java.lang.String r3 = "Azerbaijani"
            goto L_0x23ef
        L_0x2105:
            java.lang.String r0 = "ay"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x210f
            goto L_0x23f0
        L_0x210f:
            java.lang.String r3 = "Aymara"
            goto L_0x23ef
        L_0x2113:
            java.lang.String r0 = "av"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x211d
            goto L_0x23f0
        L_0x211d:
            java.lang.String r3 = "Avaric"
            goto L_0x23ef
        L_0x2121:
            java.lang.String r0 = "as"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x212b
            goto L_0x23f0
        L_0x212b:
            java.lang.String r3 = "Assamese"
            goto L_0x23ef
        L_0x212f:
            java.lang.String r2 = "ar"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x2139
            goto L_0x23f0
        L_0x2139:
            r1 = 2131820638(0x7f11005e, float:1.9273997E38)
            java.lang.String r3 = r0.getString(r1)
            java.lang.String r0 = "mContext.getString(R.string.audio_ara)"
            t9.i.f(r3, r0)
            goto L_0x23ef
        L_0x2147:
            java.lang.String r0 = "an"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2151
            goto L_0x23f0
        L_0x2151:
            java.lang.String r3 = "Aragonese"
            goto L_0x23ef
        L_0x2155:
            java.lang.String r0 = "am"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x215f
            goto L_0x23f0
        L_0x215f:
            java.lang.String r3 = "Amharic"
            goto L_0x23ef
        L_0x2163:
            java.lang.String r0 = "ak"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x216d
            goto L_0x23f0
        L_0x216d:
            java.lang.String r3 = "Akan"
            goto L_0x23ef
        L_0x2171:
            java.lang.String r0 = "af"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x217b
            goto L_0x23f0
        L_0x217b:
            java.lang.String r3 = "Afrikaans"
            goto L_0x23ef
        L_0x217f:
            java.lang.String r0 = "ae"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2189
            goto L_0x23f0
        L_0x2189:
            java.lang.String r3 = "Avestan"
            goto L_0x23ef
        L_0x218d:
            java.lang.String r0 = "ab"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2197
            goto L_0x23f0
        L_0x2197:
            java.lang.String r3 = "Abkhazian"
            goto L_0x23ef
        L_0x219b:
            java.lang.String r0 = "aa"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x21a5
            goto L_0x23f0
        L_0x21a5:
            java.lang.String r3 = "Afar"
            goto L_0x23ef
        L_0x21a9:
            java.lang.String r2 = "ger (b)"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x21b3
            goto L_0x23f0
        L_0x21b3:
            r1 = 2131820640(0x7f110060, float:1.9274E38)
            java.lang.String r3 = r0.getString(r1)
            java.lang.String r0 = "mContext.getString(R.string.audio_ger)"
            t9.i.f(r3, r0)
            goto L_0x23ef
        L_0x21c1:
            java.lang.String r0 = "geo (b)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x22f9
            goto L_0x23f0
        L_0x21cb:
            java.lang.String r0 = "gem (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x21d5
            goto L_0x23f0
        L_0x21d5:
            java.lang.String r3 = "Germanic"
            goto L_0x23ef
        L_0x21d9:
            java.lang.String r0 = "bih (c)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x21e3
            goto L_0x23f0
        L_0x21e3:
            java.lang.String r3 = "Bihari"
            goto L_0x23ef
        L_0x21e7:
            java.lang.String r0 = "znd (c)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x21f1
            goto L_0x23f0
        L_0x21f1:
            java.lang.String r3 = "Zande languages"
            goto L_0x23ef
        L_0x21f5:
            java.lang.String r0 = "ber (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x21ff
            goto L_0x23f0
        L_0x21ff:
            java.lang.String r3 = "Berber"
            goto L_0x23ef
        L_0x2203:
            java.lang.String r0 = "pra (g)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x220d
            goto L_0x23f0
        L_0x220d:
            java.lang.String r3 = "Prakrit languages"
            goto L_0x23ef
        L_0x2211:
            java.lang.String r0 = "bat (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x221b
            goto L_0x23f0
        L_0x221b:
            java.lang.String r3 = "Baltic"
            goto L_0x23ef
        L_0x221f:
            java.lang.String r0 = "baq (b)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2367
            goto L_0x23f0
        L_0x2229:
            java.lang.String r0 = "bai (g)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2233
            goto L_0x23f0
        L_0x2233:
            java.lang.String r3 = "Bamileke languages"
            goto L_0x23ef
        L_0x2237:
            java.lang.String r0 = "bad (c)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2241
            goto L_0x23f0
        L_0x2241:
            java.lang.String r3 = "Banda languages"
            goto L_0x23ef
        L_0x2245:
            java.lang.String r0 = "kro (c)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x224f
            goto L_0x23f0
        L_0x224f:
            java.lang.String r3 = "Kru languages"
            goto L_0x23ef
        L_0x2253:
            java.lang.String r0 = "phi (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x225d
            goto L_0x23f0
        L_0x225d:
            java.lang.String r3 = "Philippine (Other)"
            goto L_0x23ef
        L_0x2261:
            java.lang.String r2 = "fre (b)"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x2275
            goto L_0x23f0
        L_0x226b:
            java.lang.String r2 = "fra (t)"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x2275
            goto L_0x23f0
        L_0x2275:
            r1 = 2131821104(0x7f110230, float:1.9274942E38)
            java.lang.String r3 = r0.getString(r1)
            java.lang.String r0 = "mContext.getString(R.string.language_fr)"
            t9.i.f(r3, r0)
            goto L_0x23ef
        L_0x2283:
            java.lang.String r0 = "aus (g)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x228d
            goto L_0x23f0
        L_0x228d:
            java.lang.String r3 = "Australian languages"
            goto L_0x23ef
        L_0x2291:
            java.lang.String r0 = "per (b)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x233f
            goto L_0x23f0
        L_0x229b:
            java.lang.String r0 = "ath (g)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x22a5
            goto L_0x23f0
        L_0x22a5:
            java.lang.String r3 = "Athapascan languages"
            goto L_0x23ef
        L_0x22a9:
            java.lang.String r0 = "art (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x22b3
            goto L_0x23f0
        L_0x22b3:
            java.lang.String r3 = "Artificial"
            goto L_0x23ef
        L_0x22b7:
            java.lang.String r0 = "arm (b)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x22c1
            goto L_0x23f0
        L_0x22c1:
            java.lang.String r3 = "Armenian"
            goto L_0x23ef
        L_0x22c5:
            java.lang.String r0 = "khi (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x22cf
            goto L_0x23f0
        L_0x22cf:
            java.lang.String r3 = "Khoisan (Other)"
            goto L_0x23ef
        L_0x22d3:
            java.lang.String r0 = "paa (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x22dd
            goto L_0x23f0
        L_0x22dd:
            java.lang.String r3 = "Papuan (Other)"
            goto L_0x23ef
        L_0x22e1:
            java.lang.String r0 = "fiu (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x22eb
            goto L_0x23f0
        L_0x22eb:
            java.lang.String r3 = "Finno-Ugrian"
            goto L_0x23ef
        L_0x22ef:
            java.lang.String r0 = "kat (t)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x22f9
            goto L_0x23f0
        L_0x22f9:
            java.lang.String r3 = "Georgian"
            goto L_0x23ef
        L_0x22fd:
            java.lang.String r0 = "kar (c)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2307
            goto L_0x23f0
        L_0x2307:
            java.lang.String r3 = "Karen languages"
            goto L_0x23ef
        L_0x230b:
            java.lang.String r0 = "tut (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2315
            goto L_0x23f0
        L_0x2315:
            java.lang.String r3 = "Altaic (Other)"
            goto L_0x23ef
        L_0x2319:
            java.lang.String r0 = "tup (g)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2323
            goto L_0x23f0
        L_0x2323:
            java.lang.String r3 = "Tupi languages"
            goto L_0x23ef
        L_0x2327:
            java.lang.String r0 = "ypk (g)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2331
            goto L_0x23f0
        L_0x2331:
            java.lang.String r3 = "Yupik languages"
            goto L_0x23ef
        L_0x2335:
            java.lang.String r0 = "fas (t)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x233f
            goto L_0x23f0
        L_0x233f:
            r3 = r12
            goto L_0x23ef
        L_0x2342:
            java.lang.String r0 = "oto (g)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x234c
            goto L_0x23f0
        L_0x234c:
            java.lang.String r3 = "Otomian languages"
            goto L_0x23ef
        L_0x2350:
            java.lang.String r0 = "tib (b)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x235a
            goto L_0x23f0
        L_0x235a:
            r3 = r13
            goto L_0x23ef
        L_0x235d:
            java.lang.String r0 = "eus (t)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2367
            goto L_0x23f0
        L_0x2367:
            r3 = r14
            goto L_0x23ef
        L_0x236a:
            java.lang.String r0 = "tai (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2374
            goto L_0x23f0
        L_0x2374:
            java.lang.String r3 = "Tai (Other)"
            goto L_0x23ef
        L_0x2378:
            java.lang.String r0 = "ell (t)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x2382
            goto L_0x23f0
        L_0x2382:
            r3 = r15
            goto L_0x23ef
        L_0x2385:
            java.lang.String r0 = "ssa (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x238f
            goto L_0x23f0
        L_0x238f:
            java.lang.String r3 = "Nilo-Saharan (Other)"
            goto L_0x23ef
        L_0x2393:
            java.lang.String r0 = "srp (t)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x239c
            goto L_0x23f0
        L_0x239c:
            r3 = r16
            goto L_0x23ef
        L_0x239f:
            java.lang.String r0 = "sqi (t)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x23a8
            goto L_0x23f0
        L_0x23a8:
            r3 = r17
            goto L_0x23ef
        L_0x23ab:
            java.lang.String r0 = "nub (g)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x23b4
            goto L_0x23f0
        L_0x23b4:
            java.lang.String r3 = "Nubian languages"
            goto L_0x23ef
        L_0x23b7:
            java.lang.String r0 = "son (c)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x23c0
            goto L_0x23f0
        L_0x23c0:
            java.lang.String r3 = "Songhai languages"
            goto L_0x23ef
        L_0x23c3:
            java.lang.String r0 = "smi (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x23cc
            goto L_0x23f0
        L_0x23cc:
            java.lang.String r3 = "Sami languages (Other)"
            goto L_0x23ef
        L_0x23cf:
            java.lang.String r0 = "slo (b)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x23e1
            goto L_0x23f0
        L_0x23d8:
            java.lang.String r0 = "slk (t)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x23e1
            goto L_0x23f0
        L_0x23e1:
            r3 = r18
            goto L_0x23ef
        L_0x23e4:
            java.lang.String r0 = "sla (r)"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x23ed
            goto L_0x23f0
        L_0x23ed:
            java.lang.String r3 = "Slavic (Other)"
        L_0x23ef:
            return r3
        L_0x23f0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.bean.SubtitleManager.getTranslateString(android.content.Context, java.lang.String):java.lang.String");
    }

    public final void putSelectSubtitle(String str, int i10, String str2) {
        i.g(str, "key");
        i.g(str2, "subTitleLanguage");
        if (!TextUtils.isEmpty(str) && i10 >= -1) {
            RecordSubtitleInfoBean recordSubtitleInfoBean = mLruCacheLanguages.get(str);
            if (recordSubtitleInfoBean == null) {
                mLruCacheLanguages.put(str, new RecordSubtitleInfoBean(i10, str2));
                return;
            }
            recordSubtitleInfoBean.setSubtitleIndex(i10);
            recordSubtitleInfoBean.setSubTitleLanguage(str2);
        }
    }

    public final void setMGlobalAudioLanguage(int i10) {
        mGlobalAudioLanguage = i10;
    }

    public final void setMGlobalColor(int i10) {
        mGlobalColor = i10;
    }

    public final void setMGlobalLanguage(int i10) {
        mGlobalLanguage = i10;
    }

    public final void setMGlobalSize(int i10) {
        mGlobalSize = i10;
    }

    public final void setMGlobalSwitch(boolean z10) {
        mGlobalSwitch = z10;
    }

    public final void setMLruCacheAudioLanguages(LruCache<String, String> lruCache) {
        i.g(lruCache, "<set-?>");
        mLruCacheAudioLanguages = lruCache;
    }

    public final void setMLruCacheColor(LruCache<String, Integer> lruCache) {
        i.g(lruCache, "<set-?>");
        mLruCacheColor = lruCache;
    }

    public final void setMLruCacheLanguages(HashMap<String, RecordSubtitleInfoBean> hashMap) {
        i.g(hashMap, "<set-?>");
        mLruCacheLanguages = hashMap;
    }

    public final void setMLruCacheSize(LruCache<String, Integer> lruCache) {
        i.g(lruCache, "<set-?>");
        mLruCacheSize = lruCache;
    }

    public final void setMLruCacheSwitch(LruCache<String, Boolean> lruCache) {
        i.g(lruCache, "<set-?>");
        mLruCacheSwitch = lruCache;
    }
}
