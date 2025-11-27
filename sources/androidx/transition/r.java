package androidx.transition;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.n;
import java.util.ArrayList;
import java.util.Iterator;

public class r extends n {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f3260a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public boolean f3261b = true;

    /* renamed from: c  reason: collision with root package name */
    public int f3262c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3263d = false;

    /* renamed from: e  reason: collision with root package name */
    public int f3264e = 0;

    public class a extends o {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f3265a;

        public a(n nVar) {
            this.f3265a = nVar;
        }

        public void d(n nVar) {
            this.f3265a.runAnimators();
            nVar.removeListener(this);
        }
    }

    public static class b extends o {

        /* renamed from: a  reason: collision with root package name */
        public r f3267a;

        public b(r rVar) {
            this.f3267a = rVar;
        }

        public void b(n nVar) {
            r rVar = this.f3267a;
            if (!rVar.f3263d) {
                rVar.start();
                this.f3267a.f3263d = true;
            }
        }

        public void d(n nVar) {
            r rVar = this.f3267a;
            int i10 = rVar.f3262c - 1;
            rVar.f3262c = i10;
            if (i10 == 0) {
                rVar.f3263d = false;
                rVar.end();
            }
            nVar.removeListener(this);
        }
    }

    /* renamed from: A */
    public r removeListener(n.g gVar) {
        return (r) super.removeListener(gVar);
    }

    /* renamed from: B */
    public r removeTarget(int i10) {
        for (int i11 = 0; i11 < this.f3260a.size(); i11++) {
            ((n) this.f3260a.get(i11)).removeTarget(i10);
        }
        return (r) super.removeTarget(i10);
    }

    /* renamed from: C */
    public r removeTarget(View view) {
        for (int i10 = 0; i10 < this.f3260a.size(); i10++) {
            ((n) this.f3260a.get(i10)).removeTarget(view);
        }
        return (r) super.removeTarget(view);
    }

    /* renamed from: D */
    public r removeTarget(Class cls) {
        for (int i10 = 0; i10 < this.f3260a.size(); i10++) {
            ((n) this.f3260a.get(i10)).removeTarget((Class<?>) cls);
        }
        return (r) super.removeTarget((Class<?>) cls);
    }

    /* renamed from: E */
    public r removeTarget(String str) {
        for (int i10 = 0; i10 < this.f3260a.size(); i10++) {
            ((n) this.f3260a.get(i10)).removeTarget(str);
        }
        return (r) super.removeTarget(str);
    }

    /* renamed from: F */
    public r setDuration(long j10) {
        ArrayList arrayList;
        super.setDuration(j10);
        if (this.mDuration >= 0 && (arrayList = this.f3260a) != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((n) this.f3260a.get(i10)).setDuration(j10);
            }
        }
        return this;
    }

    /* renamed from: G */
    public r setInterpolator(TimeInterpolator timeInterpolator) {
        this.f3264e |= 1;
        ArrayList arrayList = this.f3260a;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((n) this.f3260a.get(i10)).setInterpolator(timeInterpolator);
            }
        }
        return (r) super.setInterpolator(timeInterpolator);
    }

    public r H(int i10) {
        if (i10 == 0) {
            this.f3261b = true;
        } else if (i10 == 1) {
            this.f3261b = false;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i10);
        }
        return this;
    }

    /* renamed from: I */
    public r setSceneRoot(ViewGroup viewGroup) {
        super.setSceneRoot(viewGroup);
        int size = this.f3260a.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((n) this.f3260a.get(i10)).setSceneRoot(viewGroup);
        }
        return this;
    }

    /* renamed from: J */
    public r setStartDelay(long j10) {
        return (r) super.setStartDelay(j10);
    }

    public final void K() {
        b bVar = new b(this);
        Iterator it = this.f3260a.iterator();
        while (it.hasNext()) {
            ((n) it.next()).addListener(bVar);
        }
        this.f3262c = this.f3260a.size();
    }

    public void cancel() {
        super.cancel();
        int size = this.f3260a.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((n) this.f3260a.get(i10)).cancel();
        }
    }

    public void captureEndValues(u uVar) {
        if (isValidTarget(uVar.f3272b)) {
            Iterator it = this.f3260a.iterator();
            while (it.hasNext()) {
                n nVar = (n) it.next();
                if (nVar.isValidTarget(uVar.f3272b)) {
                    nVar.captureEndValues(uVar);
                    uVar.f3273c.add(nVar);
                }
            }
        }
    }

    public void capturePropagationValues(u uVar) {
        super.capturePropagationValues(uVar);
        int size = this.f3260a.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((n) this.f3260a.get(i10)).capturePropagationValues(uVar);
        }
    }

    public void captureStartValues(u uVar) {
        if (isValidTarget(uVar.f3272b)) {
            Iterator it = this.f3260a.iterator();
            while (it.hasNext()) {
                n nVar = (n) it.next();
                if (nVar.isValidTarget(uVar.f3272b)) {
                    nVar.captureStartValues(uVar);
                    uVar.f3273c.add(nVar);
                }
            }
        }
    }

    public void createAnimators(ViewGroup viewGroup, v vVar, v vVar2, ArrayList arrayList, ArrayList arrayList2) {
        long startDelay = getStartDelay();
        int size = this.f3260a.size();
        for (int i10 = 0; i10 < size; i10++) {
            n nVar = (n) this.f3260a.get(i10);
            if (startDelay > 0 && (this.f3261b || i10 == 0)) {
                long startDelay2 = nVar.getStartDelay();
                if (startDelay2 > 0) {
                    nVar.setStartDelay(startDelay2 + startDelay);
                } else {
                    nVar.setStartDelay(startDelay);
                }
            }
            nVar.createAnimators(viewGroup, vVar, vVar2, arrayList, arrayList2);
        }
    }

    public n excludeTarget(View view, boolean z10) {
        for (int i10 = 0; i10 < this.f3260a.size(); i10++) {
            ((n) this.f3260a.get(i10)).excludeTarget(view, z10);
        }
        return super.excludeTarget(view, z10);
    }

    public void forceToEnd(ViewGroup viewGroup) {
        super.forceToEnd(viewGroup);
        int size = this.f3260a.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((n) this.f3260a.get(i10)).forceToEnd(viewGroup);
        }
    }

    public void pause(View view) {
        super.pause(view);
        int size = this.f3260a.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((n) this.f3260a.get(i10)).pause(view);
        }
    }

    /* renamed from: r */
    public r addListener(n.g gVar) {
        return (r) super.addListener(gVar);
    }

    public void resume(View view) {
        super.resume(view);
        int size = this.f3260a.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((n) this.f3260a.get(i10)).resume(view);
        }
    }

    public void runAnimators() {
        if (this.f3260a.isEmpty()) {
            start();
            end();
            return;
        }
        K();
        if (!this.f3261b) {
            for (int i10 = 1; i10 < this.f3260a.size(); i10++) {
                ((n) this.f3260a.get(i10 - 1)).addListener(new a((n) this.f3260a.get(i10)));
            }
            n nVar = (n) this.f3260a.get(0);
            if (nVar != null) {
                nVar.runAnimators();
                return;
            }
            return;
        }
        Iterator it = this.f3260a.iterator();
        while (it.hasNext()) {
            ((n) it.next()).runAnimators();
        }
    }

    /* renamed from: s */
    public r addTarget(int i10) {
        for (int i11 = 0; i11 < this.f3260a.size(); i11++) {
            ((n) this.f3260a.get(i11)).addTarget(i10);
        }
        return (r) super.addTarget(i10);
    }

    public void setCanRemoveViews(boolean z10) {
        super.setCanRemoveViews(z10);
        int size = this.f3260a.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((n) this.f3260a.get(i10)).setCanRemoveViews(z10);
        }
    }

    public void setEpicenterCallback(n.f fVar) {
        super.setEpicenterCallback(fVar);
        this.f3264e |= 8;
        int size = this.f3260a.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((n) this.f3260a.get(i10)).setEpicenterCallback(fVar);
        }
    }

    public void setPathMotion(h hVar) {
        super.setPathMotion(hVar);
        this.f3264e |= 4;
        if (this.f3260a != null) {
            for (int i10 = 0; i10 < this.f3260a.size(); i10++) {
                ((n) this.f3260a.get(i10)).setPathMotion(hVar);
            }
        }
    }

    public void setPropagation(q qVar) {
        super.setPropagation(qVar);
        this.f3264e |= 2;
        int size = this.f3260a.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((n) this.f3260a.get(i10)).setPropagation(qVar);
        }
    }

    /* renamed from: t */
    public r addTarget(View view) {
        for (int i10 = 0; i10 < this.f3260a.size(); i10++) {
            ((n) this.f3260a.get(i10)).addTarget(view);
        }
        return (r) super.addTarget(view);
    }

    public String toString(String str) {
        String nVar = super.toString(str);
        for (int i10 = 0; i10 < this.f3260a.size(); i10++) {
            StringBuilder sb = new StringBuilder();
            sb.append(nVar);
            sb.append("\n");
            sb.append(((n) this.f3260a.get(i10)).toString(str + "  "));
            nVar = sb.toString();
        }
        return nVar;
    }

    /* renamed from: u */
    public r addTarget(Class cls) {
        for (int i10 = 0; i10 < this.f3260a.size(); i10++) {
            ((n) this.f3260a.get(i10)).addTarget((Class<?>) cls);
        }
        return (r) super.addTarget((Class<?>) cls);
    }

    /* renamed from: v */
    public r addTarget(String str) {
        for (int i10 = 0; i10 < this.f3260a.size(); i10++) {
            ((n) this.f3260a.get(i10)).addTarget(str);
        }
        return (r) super.addTarget(str);
    }

    public r w(n nVar) {
        x(nVar);
        long j10 = this.mDuration;
        if (j10 >= 0) {
            nVar.setDuration(j10);
        }
        if ((this.f3264e & 1) != 0) {
            nVar.setInterpolator(getInterpolator());
        }
        if ((this.f3264e & 2) != 0) {
            getPropagation();
            nVar.setPropagation((q) null);
        }
        if ((this.f3264e & 4) != 0) {
            nVar.setPathMotion(getPathMotion());
        }
        if ((this.f3264e & 8) != 0) {
            nVar.setEpicenterCallback(getEpicenterCallback());
        }
        return this;
    }

    public final void x(n nVar) {
        this.f3260a.add(nVar);
        nVar.mParent = this;
    }

    public n y(int i10) {
        if (i10 < 0 || i10 >= this.f3260a.size()) {
            return null;
        }
        return (n) this.f3260a.get(i10);
    }

    public int z() {
        return this.f3260a.size();
    }

    public n clone() {
        r rVar = (r) super.clone();
        rVar.f3260a = new ArrayList();
        int size = this.f3260a.size();
        for (int i10 = 0; i10 < size; i10++) {
            rVar.x(((n) this.f3260a.get(i10)).clone());
        }
        return rVar;
    }

    public n excludeTarget(String str, boolean z10) {
        for (int i10 = 0; i10 < this.f3260a.size(); i10++) {
            ((n) this.f3260a.get(i10)).excludeTarget(str, z10);
        }
        return super.excludeTarget(str, z10);
    }

    public n excludeTarget(int i10, boolean z10) {
        for (int i11 = 0; i11 < this.f3260a.size(); i11++) {
            ((n) this.f3260a.get(i11)).excludeTarget(i10, z10);
        }
        return super.excludeTarget(i10, z10);
    }

    public n excludeTarget(Class cls, boolean z10) {
        for (int i10 = 0; i10 < this.f3260a.size(); i10++) {
            ((n) this.f3260a.get(i10)).excludeTarget((Class<?>) cls, z10);
        }
        return super.excludeTarget((Class<?>) cls, z10);
    }
}
