package androidx.customview.widget;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public abstract class b {

    public interface a {
        void a(Object obj, Rect rect);
    }

    /* renamed from: androidx.customview.widget.b$b  reason: collision with other inner class name */
    public interface C0026b {
        Object a(Object obj, int i10);

        int b(Object obj);
    }

    public static class c implements Comparator {

        /* renamed from: a  reason: collision with root package name */
        public final Rect f1826a = new Rect();

        /* renamed from: b  reason: collision with root package name */
        public final Rect f1827b = new Rect();

        /* renamed from: c  reason: collision with root package name */
        public final boolean f1828c;

        /* renamed from: d  reason: collision with root package name */
        public final a f1829d;

        public c(boolean z10, a aVar) {
            this.f1828c = z10;
            this.f1829d = aVar;
        }

        public int compare(Object obj, Object obj2) {
            Rect rect = this.f1826a;
            Rect rect2 = this.f1827b;
            this.f1829d.a(obj, rect);
            this.f1829d.a(obj2, rect2);
            int i10 = rect.top;
            int i11 = rect2.top;
            if (i10 < i11) {
                return -1;
            }
            if (i10 > i11) {
                return 1;
            }
            int i12 = rect.left;
            int i13 = rect2.left;
            if (i12 < i13) {
                if (this.f1828c) {
                    return 1;
                }
                return -1;
            } else if (i12 <= i13) {
                int i14 = rect.bottom;
                int i15 = rect2.bottom;
                if (i14 < i15) {
                    return -1;
                }
                if (i14 > i15) {
                    return 1;
                }
                int i16 = rect.right;
                int i17 = rect2.right;
                if (i16 < i17) {
                    if (this.f1828c) {
                        return 1;
                    }
                    return -1;
                } else if (i16 <= i17) {
                    return 0;
                } else {
                    if (this.f1828c) {
                        return -1;
                    }
                    return 1;
                }
            } else if (this.f1828c) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public static boolean a(int i10, Rect rect, Rect rect2, Rect rect3) {
        boolean b10 = b(i10, rect, rect2);
        if (b(i10, rect, rect3) || !b10) {
            return false;
        }
        if (j(i10, rect, rect3) && i10 != 17 && i10 != 66 && k(i10, rect, rect2) >= m(i10, rect, rect3)) {
            return false;
        }
        return true;
    }

    public static boolean b(int i10, Rect rect, Rect rect2) {
        if (i10 != 17) {
            if (i10 != 33) {
                if (i10 != 66) {
                    if (i10 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            if (rect2.right < rect.left || rect2.left > rect.right) {
                return false;
            }
            return true;
        }
        if (rect2.bottom < rect.top || rect2.top > rect.bottom) {
            return false;
        }
        return true;
    }

    public static Object c(Object obj, C0026b bVar, a aVar, Object obj2, Rect rect, int i10) {
        Rect rect2 = new Rect(rect);
        if (i10 == 17) {
            rect2.offset(rect.width() + 1, 0);
        } else if (i10 == 33) {
            rect2.offset(0, rect.height() + 1);
        } else if (i10 == 66) {
            rect2.offset(-(rect.width() + 1), 0);
        } else if (i10 == 130) {
            rect2.offset(0, -(rect.height() + 1));
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        int b10 = bVar.b(obj);
        Rect rect3 = new Rect();
        Object obj3 = null;
        for (int i11 = 0; i11 < b10; i11++) {
            Object a10 = bVar.a(obj, i11);
            if (a10 != obj2) {
                aVar.a(a10, rect3);
                if (h(i10, rect, rect3, rect2)) {
                    rect2.set(rect3);
                    obj3 = a10;
                }
            }
        }
        return obj3;
    }

    public static Object d(Object obj, C0026b bVar, a aVar, Object obj2, int i10, boolean z10, boolean z11) {
        int b10 = bVar.b(obj);
        ArrayList arrayList = new ArrayList(b10);
        for (int i11 = 0; i11 < b10; i11++) {
            arrayList.add(bVar.a(obj, i11));
        }
        Collections.sort(arrayList, new c(z10, aVar));
        if (i10 == 1) {
            return f(obj2, arrayList, z11);
        }
        if (i10 == 2) {
            return e(obj2, arrayList, z11);
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    }

    public static Object e(Object obj, ArrayList arrayList, boolean z10) {
        int i10;
        int size = arrayList.size();
        if (obj == null) {
            i10 = -1;
        } else {
            i10 = arrayList.lastIndexOf(obj);
        }
        int i11 = i10 + 1;
        if (i11 < size) {
            return arrayList.get(i11);
        }
        if (!z10 || size <= 0) {
            return null;
        }
        return arrayList.get(0);
    }

    public static Object f(Object obj, ArrayList arrayList, boolean z10) {
        int i10;
        int size = arrayList.size();
        if (obj == null) {
            i10 = size;
        } else {
            i10 = arrayList.indexOf(obj);
        }
        int i11 = i10 - 1;
        if (i11 >= 0) {
            return arrayList.get(i11);
        }
        if (!z10 || size <= 0) {
            return null;
        }
        return arrayList.get(size - 1);
    }

    public static int g(int i10, int i11) {
        return (i10 * 13 * i10) + (i11 * i11);
    }

    public static boolean h(int i10, Rect rect, Rect rect2, Rect rect3) {
        if (!i(rect, rect2, i10)) {
            return false;
        }
        if (!i(rect, rect3, i10) || a(i10, rect, rect2, rect3)) {
            return true;
        }
        if (!a(i10, rect, rect3, rect2) && g(k(i10, rect, rect2), o(i10, rect, rect2)) < g(k(i10, rect, rect3), o(i10, rect, rect3))) {
            return true;
        }
        return false;
    }

    public static boolean i(Rect rect, Rect rect2, int i10) {
        if (i10 == 17) {
            int i11 = rect.right;
            int i12 = rect2.right;
            if ((i11 > i12 || rect.left >= i12) && rect.left > rect2.left) {
                return true;
            }
            return false;
        } else if (i10 == 33) {
            int i13 = rect.bottom;
            int i14 = rect2.bottom;
            if ((i13 > i14 || rect.top >= i14) && rect.top > rect2.top) {
                return true;
            }
            return false;
        } else if (i10 == 66) {
            int i15 = rect.left;
            int i16 = rect2.left;
            if ((i15 < i16 || rect.right <= i16) && rect.right < rect2.right) {
                return true;
            }
            return false;
        } else if (i10 == 130) {
            int i17 = rect.top;
            int i18 = rect2.top;
            if ((i17 < i18 || rect.bottom <= i18) && rect.bottom < rect2.bottom) {
                return true;
            }
            return false;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    public static boolean j(int i10, Rect rect, Rect rect2) {
        if (i10 != 17) {
            if (i10 != 33) {
                if (i10 != 66) {
                    if (i10 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    } else if (rect.bottom <= rect2.top) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (rect.right <= rect2.left) {
                    return true;
                } else {
                    return false;
                }
            } else if (rect.top >= rect2.bottom) {
                return true;
            } else {
                return false;
            }
        } else if (rect.left >= rect2.right) {
            return true;
        } else {
            return false;
        }
    }

    public static int k(int i10, Rect rect, Rect rect2) {
        return Math.max(0, l(i10, rect, rect2));
    }

    public static int l(int i10, Rect rect, Rect rect2) {
        int i11;
        int i12;
        if (i10 == 17) {
            i11 = rect.left;
            i12 = rect2.right;
        } else if (i10 == 33) {
            i11 = rect.top;
            i12 = rect2.bottom;
        } else if (i10 == 66) {
            i11 = rect2.left;
            i12 = rect.right;
        } else if (i10 == 130) {
            i11 = rect2.top;
            i12 = rect.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return i11 - i12;
    }

    public static int m(int i10, Rect rect, Rect rect2) {
        return Math.max(1, n(i10, rect, rect2));
    }

    public static int n(int i10, Rect rect, Rect rect2) {
        int i11;
        int i12;
        if (i10 == 17) {
            i11 = rect.left;
            i12 = rect2.left;
        } else if (i10 == 33) {
            i11 = rect.top;
            i12 = rect2.top;
        } else if (i10 == 66) {
            i11 = rect2.right;
            i12 = rect.right;
        } else if (i10 == 130) {
            i11 = rect2.bottom;
            i12 = rect.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return i11 - i12;
    }

    public static int o(int i10, Rect rect, Rect rect2) {
        if (i10 != 17) {
            if (i10 != 33) {
                if (i10 != 66) {
                    if (i10 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs((rect.left + (rect.width() / 2)) - (rect2.left + (rect2.width() / 2)));
        }
        return Math.abs((rect.top + (rect.height() / 2)) - (rect2.top + (rect2.height() / 2)));
    }
}
