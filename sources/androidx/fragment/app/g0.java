package androidx.fragment.app;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import b0.c1;
import b0.d0;
import b0.r1;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class g0 {

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f2012a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f2013b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ArrayList f2014c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ArrayList f2015d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ArrayList f2016e;

        public a(int i10, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f2012a = i10;
            this.f2013b = arrayList;
            this.f2014c = arrayList2;
            this.f2015d = arrayList3;
            this.f2016e = arrayList4;
        }

        public void run() {
            for (int i10 = 0; i10 < this.f2012a; i10++) {
                c1.J0((View) this.f2013b.get(i10), (String) this.f2014c.get(i10));
                c1.J0((View) this.f2015d.get(i10), (String) this.f2016e.get(i10));
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ArrayList f2018a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Map f2019b;

        public b(ArrayList arrayList, Map map) {
            this.f2018a = arrayList;
            this.f2019b = map;
        }

        public void run() {
            int size = this.f2018a.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = (View) this.f2018a.get(i10);
                String I = c1.I(view);
                if (I != null) {
                    c1.J0(view, g0.i(this.f2019b, I));
                }
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ArrayList f2021a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Map f2022b;

        public c(ArrayList arrayList, Map map) {
            this.f2021a = arrayList;
            this.f2022b = map;
        }

        public void run() {
            int size = this.f2021a.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = (View) this.f2021a.get(i10);
                c1.J0(view, (String) this.f2022b.get(c1.I(view)));
            }
        }
    }

    public static void d(List list, View view) {
        int size = list.size();
        if (!h(list, view, size)) {
            if (c1.I(view) != null) {
                list.add(view);
            }
            for (int i10 = size; i10 < list.size(); i10++) {
                View view2 = (View) list.get(i10);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i11 = 0; i11 < childCount; i11++) {
                        View childAt = viewGroup.getChildAt(i11);
                        if (!h(list, childAt, size) && c1.I(childAt) != null) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    public static boolean h(List list, View view, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (list.get(i11) == view) {
                return true;
            }
        }
        return false;
    }

    public static String i(Map map, String str) {
        for (Map.Entry entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        return null;
    }

    public static boolean l(List list) {
        if (list == null || list.isEmpty()) {
            return true;
        }
        return false;
    }

    public abstract void A(Object obj, ArrayList arrayList, ArrayList arrayList2);

    public abstract Object B(Object obj);

    public abstract void a(Object obj, View view);

    public abstract void b(Object obj, ArrayList arrayList);

    public abstract void c(ViewGroup viewGroup, Object obj);

    public abstract boolean e(Object obj);

    public void f(ArrayList arrayList, View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (r1.a(viewGroup)) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                f(arrayList, viewGroup.getChildAt(i10));
            }
            return;
        }
        arrayList.add(view);
    }

    public abstract Object g(Object obj);

    public void j(Map map, View view) {
        if (view.getVisibility() == 0) {
            String I = c1.I(view);
            if (I != null) {
                map.put(I, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    j(map, viewGroup.getChildAt(i10));
                }
            }
        }
    }

    public void k(View view, Rect rect) {
        if (c1.P(view)) {
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset((float) view.getLeft(), (float) view.getTop());
            ViewParent parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
                view2.getMatrix().mapRect(rectF);
                rectF.offset((float) view2.getLeft(), (float) view2.getTop());
                parent = view2.getParent();
            }
            int[] iArr = new int[2];
            view.getRootView().getLocationOnScreen(iArr);
            rectF.offset((float) iArr[0], (float) iArr[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    public abstract Object m(Object obj, Object obj2, Object obj3);

    public abstract Object n(Object obj, Object obj2, Object obj3);

    public ArrayList o(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view = (View) arrayList.get(i10);
            arrayList2.add(c1.I(view));
            c1.J0(view, (String) null);
        }
        return arrayList2;
    }

    public abstract void p(Object obj, View view);

    public abstract void q(Object obj, ArrayList arrayList, ArrayList arrayList2);

    public abstract void r(Object obj, View view, ArrayList arrayList);

    public void s(ViewGroup viewGroup, ArrayList arrayList, Map map) {
        d0.a(viewGroup, new c(arrayList, map));
    }

    public abstract void t(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3);

    public abstract void u(Object obj, Rect rect);

    public abstract void v(Object obj, View view);

    public void w(Fragment fragment, Object obj, x.b bVar, Runnable runnable) {
        runnable.run();
    }

    public void x(View view, ArrayList arrayList, Map map) {
        d0.a(view, new b(arrayList, map));
    }

    public void y(View view, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Map map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = (View) arrayList.get(i10);
            String I = c1.I(view2);
            arrayList4.add(I);
            if (I != null) {
                c1.J0(view2, (String) null);
                String str = (String) map.get(I);
                int i11 = 0;
                while (true) {
                    if (i11 >= size) {
                        break;
                    } else if (str.equals(arrayList3.get(i11))) {
                        c1.J0((View) arrayList2.get(i11), I);
                        break;
                    } else {
                        i11++;
                    }
                }
            }
        }
        d0.a(view, new a(size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void z(Object obj, View view, ArrayList arrayList);
}
