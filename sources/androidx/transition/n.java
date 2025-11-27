package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import b0.c1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class n implements Cloneable {
    static final boolean DBG = false;
    private static final int[] DEFAULT_MATCH_ORDER = {2, 1, 3, 4};
    private static final String LOG_TAG = "Transition";
    private static final int MATCH_FIRST = 1;
    public static final int MATCH_ID = 3;
    private static final String MATCH_ID_STR = "id";
    public static final int MATCH_INSTANCE = 1;
    private static final String MATCH_INSTANCE_STR = "instance";
    public static final int MATCH_ITEM_ID = 4;
    private static final String MATCH_ITEM_ID_STR = "itemId";
    private static final int MATCH_LAST = 4;
    public static final int MATCH_NAME = 2;
    private static final String MATCH_NAME_STR = "name";
    private static final h STRAIGHT_PATH_MOTION = new a();
    private static ThreadLocal<androidx.collection.a> sRunningAnimators = new ThreadLocal<>();
    private ArrayList<Animator> mAnimators = new ArrayList<>();
    boolean mCanRemoveViews = false;
    ArrayList<Animator> mCurrentAnimators = new ArrayList<>();
    long mDuration = -1;
    private v mEndValues = new v();
    private ArrayList<u> mEndValuesList;
    private boolean mEnded = false;
    private f mEpicenterCallback;
    private TimeInterpolator mInterpolator = null;
    private ArrayList<g> mListeners = null;
    private int[] mMatchOrder = DEFAULT_MATCH_ORDER;
    private String mName = getClass().getName();
    private androidx.collection.a mNameOverrides;
    private int mNumInstances = 0;
    r mParent = null;
    private h mPathMotion = STRAIGHT_PATH_MOTION;
    private boolean mPaused = false;
    q mPropagation;
    private ViewGroup mSceneRoot = null;
    private long mStartDelay = -1;
    private v mStartValues = new v();
    private ArrayList<u> mStartValuesList;
    private ArrayList<View> mTargetChildExcludes = null;
    private ArrayList<View> mTargetExcludes = null;
    private ArrayList<Integer> mTargetIdChildExcludes = null;
    private ArrayList<Integer> mTargetIdExcludes = null;
    ArrayList<Integer> mTargetIds = new ArrayList<>();
    private ArrayList<String> mTargetNameExcludes = null;
    private ArrayList<String> mTargetNames = null;
    private ArrayList<Class<?>> mTargetTypeChildExcludes = null;
    private ArrayList<Class<?>> mTargetTypeExcludes = null;
    private ArrayList<Class<?>> mTargetTypes = null;
    ArrayList<View> mTargets = new ArrayList<>();

    public static class a extends h {
        public Path a(float f10, float f11, float f12, float f13) {
            Path path = new Path();
            path.moveTo(f10, f11);
            path.lineTo(f12, f13);
            return path;
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ androidx.collection.a f3222a;

        public b(androidx.collection.a aVar) {
            this.f3222a = aVar;
        }

        public void onAnimationEnd(Animator animator) {
            this.f3222a.remove(animator);
            n.this.mCurrentAnimators.remove(animator);
        }

        public void onAnimationStart(Animator animator) {
            n.this.mCurrentAnimators.add(animator);
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        public void onAnimationEnd(Animator animator) {
            n.this.end();
            animator.removeListener(this);
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public View f3225a;

        /* renamed from: b  reason: collision with root package name */
        public String f3226b;

        /* renamed from: c  reason: collision with root package name */
        public u f3227c;

        /* renamed from: d  reason: collision with root package name */
        public r0 f3228d;

        /* renamed from: e  reason: collision with root package name */
        public n f3229e;

        public d(View view, String str, n nVar, r0 r0Var, u uVar) {
            this.f3225a = view;
            this.f3226b = str;
            this.f3227c = uVar;
            this.f3228d = r0Var;
            this.f3229e = nVar;
        }
    }

    public static class e {
        public static ArrayList a(ArrayList arrayList, Object obj) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            if (!arrayList.contains(obj)) {
                arrayList.add(obj);
            }
            return arrayList;
        }

        public static ArrayList b(ArrayList arrayList, Object obj) {
            if (arrayList == null) {
                return arrayList;
            }
            arrayList.remove(obj);
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList;
        }
    }

    public static abstract class f {
        public abstract Rect a(n nVar);
    }

    public interface g {
        void a(n nVar);

        void b(n nVar);

        void c(n nVar);

        void d(n nVar);

        void e(n nVar);
    }

    public static void b(v vVar, View view, u uVar) {
        vVar.f3274a.put(view, uVar);
        int id = view.getId();
        if (id >= 0) {
            if (vVar.f3275b.indexOfKey(id) >= 0) {
                vVar.f3275b.put(id, (Object) null);
            } else {
                vVar.f3275b.put(id, view);
            }
        }
        String I = c1.I(view);
        if (I != null) {
            if (vVar.f3277d.containsKey(I)) {
                vVar.f3277d.put(I, (Object) null);
            } else {
                vVar.f3277d.put(I, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (vVar.f3276c.h(itemIdAtPosition) >= 0) {
                    View view2 = (View) vVar.f3276c.f(itemIdAtPosition);
                    if (view2 != null) {
                        c1.u0(view2, false);
                        vVar.f3276c.j(itemIdAtPosition, (Object) null);
                        return;
                    }
                    return;
                }
                c1.u0(view, true);
                vVar.f3276c.j(itemIdAtPosition, view);
            }
        }
    }

    public static boolean c(int[] iArr, int i10) {
        int i11 = iArr[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            if (iArr[i12] == i11) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList f(ArrayList arrayList, Object obj, boolean z10) {
        if (obj == null) {
            return arrayList;
        }
        if (z10) {
            return e.a(arrayList, obj);
        }
        return e.b(arrayList, obj);
    }

    public static androidx.collection.a i() {
        androidx.collection.a aVar = sRunningAnimators.get();
        if (aVar != null) {
            return aVar;
        }
        androidx.collection.a aVar2 = new androidx.collection.a();
        sRunningAnimators.set(aVar2);
        return aVar2;
    }

    public static boolean j(int i10) {
        return i10 >= 1 && i10 <= 4;
    }

    public static boolean k(u uVar, u uVar2, String str) {
        Object obj = uVar.f3271a.get(str);
        Object obj2 = uVar2.f3271a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public final void a(androidx.collection.a aVar, androidx.collection.a aVar2) {
        for (int i10 = 0; i10 < aVar.size(); i10++) {
            u uVar = (u) aVar.valueAt(i10);
            if (isValidTarget(uVar.f3272b)) {
                this.mStartValuesList.add(uVar);
                this.mEndValuesList.add((Object) null);
            }
        }
        for (int i11 = 0; i11 < aVar2.size(); i11++) {
            u uVar2 = (u) aVar2.valueAt(i11);
            if (isValidTarget(uVar2.f3272b)) {
                this.mEndValuesList.add(uVar2);
                this.mStartValuesList.add((Object) null);
            }
        }
    }

    public n addListener(g gVar) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(gVar);
        return this;
    }

    public n addTarget(View view) {
        this.mTargets.add(view);
        return this;
    }

    public void animate(Animator animator) {
        if (animator == null) {
            end();
            return;
        }
        if (getDuration() >= 0) {
            animator.setDuration(getDuration());
        }
        if (getStartDelay() >= 0) {
            animator.setStartDelay(getStartDelay() + animator.getStartDelay());
        }
        if (getInterpolator() != null) {
            animator.setInterpolator(getInterpolator());
        }
        animator.addListener(new c());
        animator.start();
    }

    public void cancel() {
        for (int size = this.mCurrentAnimators.size() - 1; size >= 0; size--) {
            this.mCurrentAnimators.get(size).cancel();
        }
        ArrayList<g> arrayList = this.mListeners;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
            int size2 = arrayList2.size();
            for (int i10 = 0; i10 < size2; i10++) {
                ((g) arrayList2.get(i10)).e(this);
            }
        }
    }

    public abstract void captureEndValues(u uVar);

    public void capturePropagationValues(u uVar) {
    }

    public abstract void captureStartValues(u uVar);

    public void captureValues(ViewGroup viewGroup, boolean z10) {
        androidx.collection.a aVar;
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        clearValues(z10);
        if ((this.mTargetIds.size() > 0 || this.mTargets.size() > 0) && (((arrayList = this.mTargetNames) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetTypes) == null || arrayList2.isEmpty()))) {
            for (int i10 = 0; i10 < this.mTargetIds.size(); i10++) {
                View findViewById = viewGroup.findViewById(this.mTargetIds.get(i10).intValue());
                if (findViewById != null) {
                    u uVar = new u(findViewById);
                    if (z10) {
                        captureStartValues(uVar);
                    } else {
                        captureEndValues(uVar);
                    }
                    uVar.f3273c.add(this);
                    capturePropagationValues(uVar);
                    if (z10) {
                        b(this.mStartValues, findViewById, uVar);
                    } else {
                        b(this.mEndValues, findViewById, uVar);
                    }
                }
            }
            for (int i11 = 0; i11 < this.mTargets.size(); i11++) {
                View view = this.mTargets.get(i11);
                u uVar2 = new u(view);
                if (z10) {
                    captureStartValues(uVar2);
                } else {
                    captureEndValues(uVar2);
                }
                uVar2.f3273c.add(this);
                capturePropagationValues(uVar2);
                if (z10) {
                    b(this.mStartValues, view, uVar2);
                } else {
                    b(this.mEndValues, view, uVar2);
                }
            }
        } else {
            d(viewGroup, z10);
        }
        if (!z10 && (aVar = this.mNameOverrides) != null) {
            int size = aVar.size();
            ArrayList arrayList3 = new ArrayList(size);
            for (int i12 = 0; i12 < size; i12++) {
                arrayList3.add(this.mStartValues.f3277d.remove((String) this.mNameOverrides.keyAt(i12)));
            }
            for (int i13 = 0; i13 < size; i13++) {
                View view2 = (View) arrayList3.get(i13);
                if (view2 != null) {
                    this.mStartValues.f3277d.put((String) this.mNameOverrides.valueAt(i13), view2);
                }
            }
        }
    }

    public void clearValues(boolean z10) {
        if (z10) {
            this.mStartValues.f3274a.clear();
            this.mStartValues.f3275b.clear();
            this.mStartValues.f3276c.b();
            return;
        }
        this.mEndValues.f3274a.clear();
        this.mEndValues.f3275b.clear();
        this.mEndValues.f3276c.b();
    }

    public Animator createAnimator(ViewGroup viewGroup, u uVar, u uVar2) {
        return null;
    }

    public void createAnimators(ViewGroup viewGroup, v vVar, v vVar2, ArrayList<u> arrayList, ArrayList<u> arrayList2) {
        int i10;
        boolean z10;
        Animator animator;
        u uVar;
        View view;
        u uVar2;
        Animator animator2;
        androidx.collection.a i11 = i();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i12 = 0;
        while (i12 < size) {
            u uVar3 = arrayList.get(i12);
            u uVar4 = arrayList2.get(i12);
            if (uVar3 != null && !uVar3.f3273c.contains(this)) {
                uVar3 = null;
            }
            if (uVar4 != null && !uVar4.f3273c.contains(this)) {
                uVar4 = null;
            }
            if (!(uVar3 == null && uVar4 == null)) {
                if (uVar3 == null || uVar4 == null || isTransitionRequired(uVar3, uVar4)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    Animator createAnimator = createAnimator(viewGroup, uVar3, uVar4);
                    if (createAnimator != null) {
                        if (uVar4 != null) {
                            View view2 = uVar4.f3272b;
                            String[] transitionProperties = getTransitionProperties();
                            if (transitionProperties != null && transitionProperties.length > 0) {
                                uVar2 = new u(view2);
                                u uVar5 = (u) vVar2.f3274a.get(view2);
                                if (uVar5 != null) {
                                    int i13 = 0;
                                    while (i13 < transitionProperties.length) {
                                        Map map = uVar2.f3271a;
                                        Animator animator3 = createAnimator;
                                        String str = transitionProperties[i13];
                                        map.put(str, uVar5.f3271a.get(str));
                                        i13++;
                                        createAnimator = animator3;
                                        transitionProperties = transitionProperties;
                                    }
                                }
                                Animator animator4 = createAnimator;
                                int size2 = i11.size();
                                int i14 = 0;
                                while (true) {
                                    if (i14 >= size2) {
                                        animator2 = animator4;
                                        break;
                                    }
                                    d dVar = (d) i11.get((Animator) i11.keyAt(i14));
                                    if (dVar.f3227c != null && dVar.f3225a == view2 && dVar.f3226b.equals(getName()) && dVar.f3227c.equals(uVar2)) {
                                        animator2 = null;
                                        break;
                                    }
                                    i14++;
                                }
                            } else {
                                v vVar3 = vVar2;
                                animator2 = createAnimator;
                                uVar2 = null;
                            }
                            view = view2;
                            animator = animator2;
                            uVar = uVar2;
                        } else {
                            v vVar4 = vVar2;
                            view = uVar3.f3272b;
                            animator = createAnimator;
                            uVar = null;
                        }
                        if (animator != null) {
                            i10 = size;
                            d dVar2 = r0;
                            d dVar3 = new d(view, getName(), this, c0.d(viewGroup), uVar);
                            i11.put(animator, dVar2);
                            this.mAnimators.add(animator);
                            i12++;
                            size = i10;
                        }
                        i10 = size;
                        i12++;
                        size = i10;
                    }
                    v vVar5 = vVar2;
                    i10 = size;
                    i12++;
                    size = i10;
                }
            }
            ViewGroup viewGroup2 = viewGroup;
            v vVar52 = vVar2;
            i10 = size;
            i12++;
            size = i10;
        }
        if (sparseIntArray.size() != 0) {
            for (int i15 = 0; i15 < sparseIntArray.size(); i15++) {
                Animator animator5 = this.mAnimators.get(sparseIntArray.keyAt(i15));
                animator5.setStartDelay((((long) sparseIntArray.valueAt(i15)) - Long.MAX_VALUE) + animator5.getStartDelay());
            }
        }
    }

    public final void d(View view, boolean z10) {
        if (view != null) {
            int id = view.getId();
            ArrayList<Integer> arrayList = this.mTargetIdExcludes;
            if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
                ArrayList<View> arrayList2 = this.mTargetExcludes;
                if (arrayList2 == null || !arrayList2.contains(view)) {
                    ArrayList<Class<?>> arrayList3 = this.mTargetTypeExcludes;
                    if (arrayList3 != null) {
                        int size = arrayList3.size();
                        int i10 = 0;
                        while (i10 < size) {
                            if (!this.mTargetTypeExcludes.get(i10).isInstance(view)) {
                                i10++;
                            } else {
                                return;
                            }
                        }
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        u uVar = new u(view);
                        if (z10) {
                            captureStartValues(uVar);
                        } else {
                            captureEndValues(uVar);
                        }
                        uVar.f3273c.add(this);
                        capturePropagationValues(uVar);
                        if (z10) {
                            b(this.mStartValues, view, uVar);
                        } else {
                            b(this.mEndValues, view, uVar);
                        }
                    }
                    if (view instanceof ViewGroup) {
                        ArrayList<Integer> arrayList4 = this.mTargetIdChildExcludes;
                        if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                            ArrayList<View> arrayList5 = this.mTargetChildExcludes;
                            if (arrayList5 == null || !arrayList5.contains(view)) {
                                ArrayList<Class<?>> arrayList6 = this.mTargetTypeChildExcludes;
                                if (arrayList6 != null) {
                                    int size2 = arrayList6.size();
                                    int i11 = 0;
                                    while (i11 < size2) {
                                        if (!this.mTargetTypeChildExcludes.get(i11).isInstance(view)) {
                                            i11++;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                ViewGroup viewGroup = (ViewGroup) view;
                                for (int i12 = 0; i12 < viewGroup.getChildCount(); i12++) {
                                    d(viewGroup.getChildAt(i12), z10);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final ArrayList e(ArrayList arrayList, int i10, boolean z10) {
        if (i10 <= 0) {
            return arrayList;
        }
        if (z10) {
            return e.a(arrayList, Integer.valueOf(i10));
        }
        return e.b(arrayList, Integer.valueOf(i10));
    }

    public void end() {
        int i10 = this.mNumInstances - 1;
        this.mNumInstances = i10;
        if (i10 == 0) {
            ArrayList<g> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((g) arrayList2.get(i11)).d(this);
                }
            }
            for (int i12 = 0; i12 < this.mStartValues.f3276c.m(); i12++) {
                View view = (View) this.mStartValues.f3276c.n(i12);
                if (view != null) {
                    c1.u0(view, false);
                }
            }
            for (int i13 = 0; i13 < this.mEndValues.f3276c.m(); i13++) {
                View view2 = (View) this.mEndValues.f3276c.n(i13);
                if (view2 != null) {
                    c1.u0(view2, false);
                }
            }
            this.mEnded = true;
        }
    }

    public n excludeChildren(View view, boolean z10) {
        this.mTargetChildExcludes = h(this.mTargetChildExcludes, view, z10);
        return this;
    }

    public n excludeTarget(View view, boolean z10) {
        this.mTargetExcludes = h(this.mTargetExcludes, view, z10);
        return this;
    }

    public void forceToEnd(ViewGroup viewGroup) {
        androidx.collection.a i10 = i();
        int size = i10.size();
        if (viewGroup != null && size != 0) {
            r0 d10 = c0.d(viewGroup);
            androidx.collection.a aVar = new androidx.collection.a((androidx.collection.g) i10);
            i10.clear();
            for (int i11 = size - 1; i11 >= 0; i11--) {
                d dVar = (d) aVar.valueAt(i11);
                if (!(dVar.f3225a == null || d10 == null || !d10.equals(dVar.f3228d))) {
                    ((Animator) aVar.keyAt(i11)).end();
                }
            }
        }
    }

    public final ArrayList g(ArrayList arrayList, Class cls, boolean z10) {
        if (cls == null) {
            return arrayList;
        }
        if (z10) {
            return e.a(arrayList, cls);
        }
        return e.b(arrayList, cls);
    }

    public long getDuration() {
        return this.mDuration;
    }

    public Rect getEpicenter() {
        f fVar = this.mEpicenterCallback;
        if (fVar == null) {
            return null;
        }
        return fVar.a(this);
    }

    public f getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    public u getMatchedTransitionValues(View view, boolean z10) {
        ArrayList<u> arrayList;
        ArrayList<u> arrayList2;
        r rVar = this.mParent;
        if (rVar != null) {
            return rVar.getMatchedTransitionValues(view, z10);
        }
        if (z10) {
            arrayList = this.mStartValuesList;
        } else {
            arrayList = this.mEndValuesList;
        }
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            }
            u uVar = arrayList.get(i10);
            if (uVar == null) {
                return null;
            }
            if (uVar.f3272b == view) {
                break;
            }
            i10++;
        }
        if (i10 < 0) {
            return null;
        }
        if (z10) {
            arrayList2 = this.mEndValuesList;
        } else {
            arrayList2 = this.mStartValuesList;
        }
        return arrayList2.get(i10);
    }

    public String getName() {
        return this.mName;
    }

    public h getPathMotion() {
        return this.mPathMotion;
    }

    public q getPropagation() {
        return null;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    public List<String> getTargetNames() {
        return this.mTargetNames;
    }

    public List<Class<?>> getTargetTypes() {
        return this.mTargetTypes;
    }

    public List<View> getTargets() {
        return this.mTargets;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public u getTransitionValues(View view, boolean z10) {
        v vVar;
        r rVar = this.mParent;
        if (rVar != null) {
            return rVar.getTransitionValues(view, z10);
        }
        if (z10) {
            vVar = this.mStartValues;
        } else {
            vVar = this.mEndValues;
        }
        return (u) vVar.f3274a.get(view);
    }

    public final ArrayList h(ArrayList arrayList, View view, boolean z10) {
        if (view == null) {
            return arrayList;
        }
        if (z10) {
            return e.a(arrayList, view);
        }
        return e.b(arrayList, view);
    }

    public boolean isTransitionRequired(u uVar, u uVar2) {
        if (uVar == null || uVar2 == null) {
            return false;
        }
        String[] transitionProperties = getTransitionProperties();
        if (transitionProperties != null) {
            int length = transitionProperties.length;
            int i10 = 0;
            while (i10 < length) {
                if (!k(uVar, uVar2, transitionProperties[i10])) {
                    i10++;
                }
            }
            return false;
        }
        for (String k10 : uVar.f3271a.keySet()) {
            if (k(uVar, uVar2, k10)) {
            }
        }
        return false;
        return true;
    }

    public boolean isValidTarget(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.mTargetIdExcludes;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.mTargetExcludes;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.mTargetTypeExcludes;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (this.mTargetTypeExcludes.get(i10).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.mTargetNameExcludes != null && c1.I(view) != null && this.mTargetNameExcludes.contains(c1.I(view))) {
            return false;
        }
        if ((this.mTargetIds.size() == 0 && this.mTargets.size() == 0 && (((arrayList = this.mTargetTypes) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetNames) == null || arrayList2.isEmpty()))) || this.mTargetIds.contains(Integer.valueOf(id)) || this.mTargets.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.mTargetNames;
        if (arrayList6 != null && arrayList6.contains(c1.I(view))) {
            return true;
        }
        if (this.mTargetTypes != null) {
            for (int i11 = 0; i11 < this.mTargetTypes.size(); i11++) {
                if (this.mTargetTypes.get(i11).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void l(androidx.collection.a aVar, androidx.collection.a aVar2, SparseArray sparseArray, SparseArray sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = (View) sparseArray.valueAt(i10);
            if (view2 != null && isValidTarget(view2) && (view = (View) sparseArray2.get(sparseArray.keyAt(i10))) != null && isValidTarget(view)) {
                u uVar = (u) aVar.get(view2);
                u uVar2 = (u) aVar2.get(view);
                if (!(uVar == null || uVar2 == null)) {
                    this.mStartValuesList.add(uVar);
                    this.mEndValuesList.add(uVar2);
                    aVar.remove(view2);
                    aVar2.remove(view);
                }
            }
        }
    }

    public final void m(androidx.collection.a aVar, androidx.collection.a aVar2) {
        u uVar;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View view = (View) aVar.keyAt(size);
            if (view != null && isValidTarget(view) && (uVar = (u) aVar2.remove(view)) != null && isValidTarget(uVar.f3272b)) {
                this.mStartValuesList.add((u) aVar.removeAt(size));
                this.mEndValuesList.add(uVar);
            }
        }
    }

    public final void n(androidx.collection.a aVar, androidx.collection.a aVar2, androidx.collection.d dVar, androidx.collection.d dVar2) {
        View view;
        int m10 = dVar.m();
        for (int i10 = 0; i10 < m10; i10++) {
            View view2 = (View) dVar.n(i10);
            if (view2 != null && isValidTarget(view2) && (view = (View) dVar2.f(dVar.i(i10))) != null && isValidTarget(view)) {
                u uVar = (u) aVar.get(view2);
                u uVar2 = (u) aVar2.get(view);
                if (!(uVar == null || uVar2 == null)) {
                    this.mStartValuesList.add(uVar);
                    this.mEndValuesList.add(uVar2);
                    aVar.remove(view2);
                    aVar2.remove(view);
                }
            }
        }
    }

    public final void o(androidx.collection.a aVar, androidx.collection.a aVar2, androidx.collection.a aVar3, androidx.collection.a aVar4) {
        View view;
        int size = aVar3.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = (View) aVar3.valueAt(i10);
            if (view2 != null && isValidTarget(view2) && (view = (View) aVar4.get(aVar3.keyAt(i10))) != null && isValidTarget(view)) {
                u uVar = (u) aVar.get(view2);
                u uVar2 = (u) aVar2.get(view);
                if (!(uVar == null || uVar2 == null)) {
                    this.mStartValuesList.add(uVar);
                    this.mEndValuesList.add(uVar2);
                    aVar.remove(view2);
                    aVar2.remove(view);
                }
            }
        }
    }

    public final void p(v vVar, v vVar2) {
        androidx.collection.a aVar = new androidx.collection.a((androidx.collection.g) vVar.f3274a);
        androidx.collection.a aVar2 = new androidx.collection.a((androidx.collection.g) vVar2.f3274a);
        int i10 = 0;
        while (true) {
            int[] iArr = this.mMatchOrder;
            if (i10 < iArr.length) {
                int i11 = iArr[i10];
                if (i11 == 1) {
                    m(aVar, aVar2);
                } else if (i11 == 2) {
                    o(aVar, aVar2, vVar.f3277d, vVar2.f3277d);
                } else if (i11 == 3) {
                    l(aVar, aVar2, vVar.f3275b, vVar2.f3275b);
                } else if (i11 == 4) {
                    n(aVar, aVar2, vVar.f3276c, vVar2.f3276c);
                }
                i10++;
            } else {
                a(aVar, aVar2);
                return;
            }
        }
    }

    public void pause(View view) {
        if (!this.mEnded) {
            androidx.collection.a i10 = i();
            int size = i10.size();
            r0 d10 = c0.d(view);
            for (int i11 = size - 1; i11 >= 0; i11--) {
                d dVar = (d) i10.valueAt(i11);
                if (dVar.f3225a != null && d10.equals(dVar.f3228d)) {
                    a.b((Animator) i10.keyAt(i11));
                }
            }
            ArrayList<g> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size2 = arrayList2.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    ((g) arrayList2.get(i12)).c(this);
                }
            }
            this.mPaused = true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: androidx.transition.u} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void playTransition(android.view.ViewGroup r11) {
        /*
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r10.mStartValuesList = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r10.mEndValuesList = r0
            androidx.transition.v r0 = r10.mStartValues
            androidx.transition.v r1 = r10.mEndValues
            r10.p(r0, r1)
            androidx.collection.a r0 = i()
            int r1 = r0.size()
            androidx.transition.r0 r2 = androidx.transition.c0.d(r11)
            r3 = 1
            int r1 = r1 - r3
        L_0x0023:
            if (r1 < 0) goto L_0x0084
            java.lang.Object r4 = r0.keyAt(r1)
            android.animation.Animator r4 = (android.animation.Animator) r4
            if (r4 == 0) goto L_0x0081
            java.lang.Object r5 = r0.get(r4)
            androidx.transition.n$d r5 = (androidx.transition.n.d) r5
            if (r5 == 0) goto L_0x0081
            android.view.View r6 = r5.f3225a
            if (r6 == 0) goto L_0x0081
            androidx.transition.r0 r6 = r5.f3228d
            boolean r6 = r2.equals(r6)
            if (r6 == 0) goto L_0x0081
            androidx.transition.u r6 = r5.f3227c
            android.view.View r7 = r5.f3225a
            androidx.transition.u r8 = r10.getTransitionValues(r7, r3)
            androidx.transition.u r9 = r10.getMatchedTransitionValues(r7, r3)
            if (r8 != 0) goto L_0x005c
            if (r9 != 0) goto L_0x005c
            androidx.transition.v r9 = r10.mEndValues
            androidx.collection.a r9 = r9.f3274a
            java.lang.Object r7 = r9.get(r7)
            r9 = r7
            androidx.transition.u r9 = (androidx.transition.u) r9
        L_0x005c:
            if (r8 != 0) goto L_0x0060
            if (r9 == 0) goto L_0x006a
        L_0x0060:
            androidx.transition.n r5 = r5.f3229e
            boolean r5 = r5.isTransitionRequired(r6, r9)
            if (r5 == 0) goto L_0x006a
            r5 = 1
            goto L_0x006b
        L_0x006a:
            r5 = 0
        L_0x006b:
            if (r5 == 0) goto L_0x0081
            boolean r5 = r4.isRunning()
            if (r5 != 0) goto L_0x007e
            boolean r5 = r4.isStarted()
            if (r5 == 0) goto L_0x007a
            goto L_0x007e
        L_0x007a:
            r0.remove(r4)
            goto L_0x0081
        L_0x007e:
            r4.cancel()
        L_0x0081:
            int r1 = r1 + -1
            goto L_0x0023
        L_0x0084:
            androidx.transition.v r6 = r10.mStartValues
            androidx.transition.v r7 = r10.mEndValues
            java.util.ArrayList<androidx.transition.u> r8 = r10.mStartValuesList
            java.util.ArrayList<androidx.transition.u> r9 = r10.mEndValuesList
            r4 = r10
            r5 = r11
            r4.createAnimators(r5, r6, r7, r8, r9)
            r10.runAnimators()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.n.playTransition(android.view.ViewGroup):void");
    }

    public final void q(Animator animator, androidx.collection.a aVar) {
        if (animator != null) {
            animator.addListener(new b(aVar));
            animate(animator);
        }
    }

    public n removeListener(g gVar) {
        ArrayList<g> arrayList = this.mListeners;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(gVar);
        if (this.mListeners.size() == 0) {
            this.mListeners = null;
        }
        return this;
    }

    public n removeTarget(View view) {
        this.mTargets.remove(view);
        return this;
    }

    public void resume(View view) {
        if (this.mPaused) {
            if (!this.mEnded) {
                androidx.collection.a i10 = i();
                int size = i10.size();
                r0 d10 = c0.d(view);
                for (int i11 = size - 1; i11 >= 0; i11--) {
                    d dVar = (d) i10.valueAt(i11);
                    if (dVar.f3225a != null && d10.equals(dVar.f3228d)) {
                        a.c((Animator) i10.keyAt(i11));
                    }
                }
                ArrayList<g> arrayList = this.mListeners;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                    int size2 = arrayList2.size();
                    for (int i12 = 0; i12 < size2; i12++) {
                        ((g) arrayList2.get(i12)).a(this);
                    }
                }
            }
            this.mPaused = false;
        }
    }

    public void runAnimators() {
        start();
        androidx.collection.a i10 = i();
        Iterator<Animator> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (i10.containsKey(next)) {
                start();
                q(next, i10);
            }
        }
        this.mAnimators.clear();
        end();
    }

    public void setCanRemoveViews(boolean z10) {
        this.mCanRemoveViews = z10;
    }

    public n setDuration(long j10) {
        this.mDuration = j10;
        return this;
    }

    public void setEpicenterCallback(f fVar) {
        this.mEpicenterCallback = fVar;
    }

    public n setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    public void setMatchOrder(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.mMatchOrder = DEFAULT_MATCH_ORDER;
            return;
        }
        int i10 = 0;
        while (i10 < iArr.length) {
            if (!j(iArr[i10])) {
                throw new IllegalArgumentException("matches contains invalid value");
            } else if (!c(iArr, i10)) {
                i10++;
            } else {
                throw new IllegalArgumentException("matches contains a duplicate value");
            }
        }
        this.mMatchOrder = (int[]) iArr.clone();
    }

    public void setPathMotion(h hVar) {
        if (hVar == null) {
            this.mPathMotion = STRAIGHT_PATH_MOTION;
        } else {
            this.mPathMotion = hVar;
        }
    }

    public void setPropagation(q qVar) {
    }

    public n setSceneRoot(ViewGroup viewGroup) {
        this.mSceneRoot = viewGroup;
        return this;
    }

    public n setStartDelay(long j10) {
        this.mStartDelay = j10;
        return this;
    }

    public void start() {
        if (this.mNumInstances == 0) {
            ArrayList<g> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((g) arrayList2.get(i10)).b(this);
                }
            }
            this.mEnded = false;
        }
        this.mNumInstances++;
    }

    public String toString() {
        return toString("");
    }

    public n addTarget(int i10) {
        if (i10 != 0) {
            this.mTargetIds.add(Integer.valueOf(i10));
        }
        return this;
    }

    public n clone() {
        try {
            n nVar = (n) super.clone();
            nVar.mAnimators = new ArrayList<>();
            nVar.mStartValues = new v();
            nVar.mEndValues = new v();
            nVar.mStartValuesList = null;
            nVar.mEndValuesList = null;
            return nVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public n excludeChildren(int i10, boolean z10) {
        this.mTargetIdChildExcludes = e(this.mTargetIdChildExcludes, i10, z10);
        return this;
    }

    public n excludeTarget(int i10, boolean z10) {
        this.mTargetIdExcludes = e(this.mTargetIdExcludes, i10, z10);
        return this;
    }

    public n removeTarget(int i10) {
        if (i10 != 0) {
            this.mTargetIds.remove(Integer.valueOf(i10));
        }
        return this;
    }

    public String toString(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.mDuration != -1) {
            str2 = str2 + "dur(" + this.mDuration + ") ";
        }
        if (this.mStartDelay != -1) {
            str2 = str2 + "dly(" + this.mStartDelay + ") ";
        }
        if (this.mInterpolator != null) {
            str2 = str2 + "interp(" + this.mInterpolator + ") ";
        }
        if (this.mTargetIds.size() <= 0 && this.mTargets.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.mTargetIds.size() > 0) {
            for (int i10 = 0; i10 < this.mTargetIds.size(); i10++) {
                if (i10 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.mTargetIds.get(i10);
            }
        }
        if (this.mTargets.size() > 0) {
            for (int i11 = 0; i11 < this.mTargets.size(); i11++) {
                if (i11 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.mTargets.get(i11);
            }
        }
        return str3 + ")";
    }

    public n addTarget(String str) {
        if (this.mTargetNames == null) {
            this.mTargetNames = new ArrayList<>();
        }
        this.mTargetNames.add(str);
        return this;
    }

    public n excludeChildren(Class<?> cls, boolean z10) {
        this.mTargetTypeChildExcludes = g(this.mTargetTypeChildExcludes, cls, z10);
        return this;
    }

    public n excludeTarget(String str, boolean z10) {
        this.mTargetNameExcludes = f(this.mTargetNameExcludes, str, z10);
        return this;
    }

    public n removeTarget(String str) {
        ArrayList<String> arrayList = this.mTargetNames;
        if (arrayList != null) {
            arrayList.remove(str);
        }
        return this;
    }

    public n excludeTarget(Class<?> cls, boolean z10) {
        this.mTargetTypeExcludes = g(this.mTargetTypeExcludes, cls, z10);
        return this;
    }

    public n removeTarget(Class<?> cls) {
        ArrayList<Class<?>> arrayList = this.mTargetTypes;
        if (arrayList != null) {
            arrayList.remove(cls);
        }
        return this;
    }

    public n addTarget(Class<?> cls) {
        if (this.mTargetTypes == null) {
            this.mTargetTypes = new ArrayList<>();
        }
        this.mTargetTypes.add(cls);
        return this;
    }
}
