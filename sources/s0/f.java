package s0;

import android.database.Cursor;
import android.os.Build;
import com.google.firebase.messaging.Constants;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.umeng.analytics.pro.bt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public final String f9215a;

    /* renamed from: b  reason: collision with root package name */
    public final Map f9216b;

    /* renamed from: c  reason: collision with root package name */
    public final Set f9217c;

    /* renamed from: d  reason: collision with root package name */
    public final Set f9218d;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f9219a;

        /* renamed from: b  reason: collision with root package name */
        public final String f9220b;

        /* renamed from: c  reason: collision with root package name */
        public final int f9221c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f9222d;

        /* renamed from: e  reason: collision with root package name */
        public final int f9223e;

        /* renamed from: f  reason: collision with root package name */
        public final String f9224f;

        /* renamed from: g  reason: collision with root package name */
        public final int f9225g;

        public a(String str, String str2, boolean z10, int i10, String str3, int i11) {
            this.f9219a = str;
            this.f9220b = str2;
            this.f9222d = z10;
            this.f9223e = i10;
            this.f9221c = a(str2);
            this.f9224f = str3;
            this.f9225g = i11;
        }

        public static int a(String str) {
            if (str == null) {
                return 5;
            }
            String upperCase = str.toUpperCase(Locale.US);
            if (upperCase.contains("INT")) {
                return 3;
            }
            if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
                return 2;
            }
            if (upperCase.contains("BLOB")) {
                return 5;
            }
            if (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) {
                return 4;
            }
            return 1;
        }

        public boolean b() {
            if (this.f9223e > 0) {
                return true;
            }
            return false;
        }

        public boolean equals(Object obj) {
            String str;
            String str2;
            String str3;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (Build.VERSION.SDK_INT >= 20) {
                if (this.f9223e != aVar.f9223e) {
                    return false;
                }
            } else if (b() != aVar.b()) {
                return false;
            }
            if (!this.f9219a.equals(aVar.f9219a) || this.f9222d != aVar.f9222d) {
                return false;
            }
            if (this.f9225g == 1 && aVar.f9225g == 2 && (str3 = this.f9224f) != null && !str3.equals(aVar.f9224f)) {
                return false;
            }
            if (this.f9225g == 2 && aVar.f9225g == 1 && (str2 = aVar.f9224f) != null && !str2.equals(this.f9224f)) {
                return false;
            }
            int i10 = this.f9225g;
            if ((i10 == 0 || i10 != aVar.f9225g || ((str = this.f9224f) == null ? aVar.f9224f == null : str.equals(aVar.f9224f))) && this.f9221c == aVar.f9221c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i10;
            int hashCode = ((this.f9219a.hashCode() * 31) + this.f9221c) * 31;
            if (this.f9222d) {
                i10 = 1231;
            } else {
                i10 = 1237;
            }
            return ((hashCode + i10) * 31) + this.f9223e;
        }

        public String toString() {
            return "Column{name='" + this.f9219a + '\'' + ", type='" + this.f9220b + '\'' + ", affinity='" + this.f9221c + '\'' + ", notNull=" + this.f9222d + ", primaryKeyPosition=" + this.f9223e + ", defaultValue='" + this.f9224f + '\'' + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f9226a;

        /* renamed from: b  reason: collision with root package name */
        public final String f9227b;

        /* renamed from: c  reason: collision with root package name */
        public final String f9228c;

        /* renamed from: d  reason: collision with root package name */
        public final List f9229d;

        /* renamed from: e  reason: collision with root package name */
        public final List f9230e;

        public b(String str, String str2, String str3, List list, List list2) {
            this.f9226a = str;
            this.f9227b = str2;
            this.f9228c = str3;
            this.f9229d = Collections.unmodifiableList(list);
            this.f9230e = Collections.unmodifiableList(list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f9226a.equals(bVar.f9226a) && this.f9227b.equals(bVar.f9227b) && this.f9228c.equals(bVar.f9228c) && this.f9229d.equals(bVar.f9229d)) {
                return this.f9230e.equals(bVar.f9230e);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.f9226a.hashCode() * 31) + this.f9227b.hashCode()) * 31) + this.f9228c.hashCode()) * 31) + this.f9229d.hashCode()) * 31) + this.f9230e.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.f9226a + '\'' + ", onDelete='" + this.f9227b + '\'' + ", onUpdate='" + this.f9228c + '\'' + ", columnNames=" + this.f9229d + ", referenceColumnNames=" + this.f9230e + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
        }
    }

    public static class c implements Comparable {

        /* renamed from: a  reason: collision with root package name */
        public final int f9231a;

        /* renamed from: b  reason: collision with root package name */
        public final int f9232b;

        /* renamed from: c  reason: collision with root package name */
        public final String f9233c;

        /* renamed from: d  reason: collision with root package name */
        public final String f9234d;

        public c(int i10, int i11, String str, String str2) {
            this.f9231a = i10;
            this.f9232b = i11;
            this.f9233c = str;
            this.f9234d = str2;
        }

        /* renamed from: a */
        public int compareTo(c cVar) {
            int i10 = this.f9231a - cVar.f9231a;
            if (i10 == 0) {
                return this.f9232b - cVar.f9232b;
            }
            return i10;
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final String f9235a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f9236b;

        /* renamed from: c  reason: collision with root package name */
        public final List f9237c;

        public d(String str, boolean z10, List list) {
            this.f9235a = str;
            this.f9236b = z10;
            this.f9237c = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (this.f9236b != dVar.f9236b || !this.f9237c.equals(dVar.f9237c)) {
                return false;
            }
            if (this.f9235a.startsWith("index_")) {
                return dVar.f9235a.startsWith("index_");
            }
            return this.f9235a.equals(dVar.f9235a);
        }

        public int hashCode() {
            int i10;
            if (this.f9235a.startsWith("index_")) {
                i10 = -1184239155;
            } else {
                i10 = this.f9235a.hashCode();
            }
            return (((i10 * 31) + (this.f9236b ? 1 : 0)) * 31) + this.f9237c.hashCode();
        }

        public String toString() {
            return "Index{name='" + this.f9235a + '\'' + ", unique=" + this.f9236b + ", columns=" + this.f9237c + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
        }
    }

    public f(String str, Map map, Set set, Set set2) {
        Set set3;
        this.f9215a = str;
        this.f9216b = Collections.unmodifiableMap(map);
        this.f9217c = Collections.unmodifiableSet(set);
        if (set2 == null) {
            set3 = null;
        } else {
            set3 = Collections.unmodifiableSet(set2);
        }
        this.f9218d = set3;
    }

    public static f a(t0.b bVar, String str) {
        return new f(str, b(bVar, str), d(bVar, str), f(bVar, str));
    }

    public static Map b(t0.b bVar, String str) {
        boolean z10;
        Cursor B = bVar.B("PRAGMA table_info(`" + str + "`)");
        HashMap hashMap = new HashMap();
        try {
            if (B.getColumnCount() > 0) {
                int columnIndex = B.getColumnIndex("name");
                int columnIndex2 = B.getColumnIndex("type");
                int columnIndex3 = B.getColumnIndex("notnull");
                int columnIndex4 = B.getColumnIndex(com.umeng.analytics.pro.f.S);
                int columnIndex5 = B.getColumnIndex("dflt_value");
                while (B.moveToNext()) {
                    String string = B.getString(columnIndex);
                    String string2 = B.getString(columnIndex2);
                    if (B.getInt(columnIndex3) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    hashMap.put(string, new a(string, string2, z10, B.getInt(columnIndex4), B.getString(columnIndex5), 2));
                }
            }
            return hashMap;
        } finally {
            B.close();
        }
    }

    public static List c(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex(Constants.MessagePayloadKeys.FROM);
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < count; i10++) {
            cursor.moveToPosition(i10);
            arrayList.add(new c(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static Set d(t0.b bVar, String str) {
        HashSet hashSet = new HashSet();
        Cursor B = bVar.B("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndex = B.getColumnIndex("id");
            int columnIndex2 = B.getColumnIndex("seq");
            int columnIndex3 = B.getColumnIndex("table");
            int columnIndex4 = B.getColumnIndex("on_delete");
            int columnIndex5 = B.getColumnIndex("on_update");
            List<c> c10 = c(B);
            int count = B.getCount();
            for (int i10 = 0; i10 < count; i10++) {
                B.moveToPosition(i10);
                if (B.getInt(columnIndex2) == 0) {
                    int i11 = B.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (c cVar : c10) {
                        if (cVar.f9231a == i11) {
                            arrayList.add(cVar.f9233c);
                            arrayList2.add(cVar.f9234d);
                        }
                    }
                    hashSet.add(new b(B.getString(columnIndex3), B.getString(columnIndex4), B.getString(columnIndex5), arrayList, arrayList2));
                }
            }
            return hashSet;
        } finally {
            B.close();
        }
    }

    /* JADX INFO: finally extract failed */
    public static d e(t0.b bVar, String str, boolean z10) {
        Cursor B = bVar.B("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = B.getColumnIndex("seqno");
            int columnIndex2 = B.getColumnIndex("cid");
            int columnIndex3 = B.getColumnIndex("name");
            if (!(columnIndex == -1 || columnIndex2 == -1)) {
                if (columnIndex3 != -1) {
                    TreeMap treeMap = new TreeMap();
                    while (B.moveToNext()) {
                        if (B.getInt(columnIndex2) >= 0) {
                            int i10 = B.getInt(columnIndex);
                            treeMap.put(Integer.valueOf(i10), B.getString(columnIndex3));
                        }
                    }
                    ArrayList arrayList = new ArrayList(treeMap.size());
                    arrayList.addAll(treeMap.values());
                    d dVar = new d(str, z10, arrayList);
                    B.close();
                    return dVar;
                }
            }
            B.close();
            return null;
        } catch (Throwable th) {
            B.close();
            throw th;
        }
    }

    public static Set f(t0.b bVar, String str) {
        Cursor B = bVar.B("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndex = B.getColumnIndex("name");
            int columnIndex2 = B.getColumnIndex("origin");
            int columnIndex3 = B.getColumnIndex("unique");
            if (!(columnIndex == -1 || columnIndex2 == -1)) {
                if (columnIndex3 != -1) {
                    HashSet hashSet = new HashSet();
                    while (B.moveToNext()) {
                        if (bt.aL.equals(B.getString(columnIndex2))) {
                            String string = B.getString(columnIndex);
                            boolean z10 = true;
                            if (B.getInt(columnIndex3) != 1) {
                                z10 = false;
                            }
                            d e10 = e(bVar, string, z10);
                            if (e10 == null) {
                                B.close();
                                return null;
                            }
                            hashSet.add(e10);
                        }
                    }
                    B.close();
                    return hashSet;
                }
            }
            return null;
        } finally {
            B.close();
        }
    }

    public boolean equals(Object obj) {
        Set set;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        String str = this.f9215a;
        if (str == null ? fVar.f9215a != null : !str.equals(fVar.f9215a)) {
            return false;
        }
        Map map = this.f9216b;
        if (map == null ? fVar.f9216b != null : !map.equals(fVar.f9216b)) {
            return false;
        }
        Set set2 = this.f9217c;
        if (set2 == null ? fVar.f9217c != null : !set2.equals(fVar.f9217c)) {
            return false;
        }
        Set set3 = this.f9218d;
        if (set3 == null || (set = fVar.f9218d) == null) {
            return true;
        }
        return set3.equals(set);
    }

    public int hashCode() {
        int i10;
        int i11;
        String str = this.f9215a;
        int i12 = 0;
        if (str != null) {
            i10 = str.hashCode();
        } else {
            i10 = 0;
        }
        int i13 = i10 * 31;
        Map map = this.f9216b;
        if (map != null) {
            i11 = map.hashCode();
        } else {
            i11 = 0;
        }
        int i14 = (i13 + i11) * 31;
        Set set = this.f9217c;
        if (set != null) {
            i12 = set.hashCode();
        }
        return i14 + i12;
    }

    public String toString() {
        return "TableInfo{name='" + this.f9215a + '\'' + ", columns=" + this.f9216b + ", foreignKeys=" + this.f9217c + ", indices=" + this.f9218d + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
