package ta;

import java.util.LinkedList;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public String f19616a;

    /* renamed from: b  reason: collision with root package name */
    public LinkedList f19617b;

    public void a(Object obj) {
        if (this.f19617b == null) {
            this.f19617b = new LinkedList();
        }
        this.f19617b.add(obj);
    }

    public Object[] b() {
        LinkedList linkedList = this.f19617b;
        if (linkedList != null) {
            return linkedList.toArray();
        }
        return null;
    }

    public String[] c() {
        LinkedList linkedList = this.f19617b;
        if (linkedList == null) {
            return null;
        }
        String[] strArr = new String[linkedList.size()];
        for (int i10 = 0; i10 < this.f19617b.size(); i10++) {
            strArr[i10] = this.f19617b.get(i10).toString();
        }
        return strArr;
    }

    public String d() {
        return this.f19616a;
    }

    public void e(String str) {
        this.f19616a = str;
    }
}
