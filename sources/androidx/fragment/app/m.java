package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R$styleable;

public class m implements LayoutInflater.Factory2 {

    /* renamed from: a  reason: collision with root package name */
    public final o f2070a;

    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v f2071a;

        public a(v vVar) {
            this.f2071a = vVar;
        }

        public void onViewAttachedToWindow(View view) {
            Fragment k10 = this.f2071a.k();
            this.f2071a.m();
            j0.n((ViewGroup) k10.mView.getParent(), m.this.f2070a).j();
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    public m(o oVar) {
        this.f2070a = oVar;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        v vVar;
        if (i.class.getName().equals(str)) {
            return new i(context, attributeSet, this.f2070a);
        }
        Fragment fragment = null;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue((String) null, Name.LABEL);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f1862d);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(R$styleable.Fragment_android_name);
        }
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.Fragment_android_id, -1);
        String string = obtainStyledAttributes.getString(R$styleable.Fragment_android_tag);
        obtainStyledAttributes.recycle();
        if (attributeValue == null || !k.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        if (resourceId != -1) {
            fragment = this.f2070a.g0(resourceId);
        }
        if (fragment == null && string != null) {
            fragment = this.f2070a.h0(string);
        }
        if (fragment == null && id != -1) {
            fragment = this.f2070a.g0(id);
        }
        if (fragment == null) {
            fragment = this.f2070a.q0().a(context.getClassLoader(), attributeValue);
            fragment.mFromLayout = true;
            fragment.mFragmentId = resourceId != 0 ? resourceId : id;
            fragment.mContainerId = id;
            fragment.mTag = string;
            fragment.mInLayout = true;
            o oVar = this.f2070a;
            fragment.mFragmentManager = oVar;
            fragment.mHost = oVar.t0();
            fragment.onInflate(this.f2070a.t0().f(), attributeSet, fragment.mSavedFragmentState);
            vVar = this.f2070a.g(fragment);
            if (o.F0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Fragment ");
                sb.append(fragment);
                sb.append(" has been inflated via the <fragment> tag: id=0x");
                sb.append(Integer.toHexString(resourceId));
            }
        } else if (!fragment.mInLayout) {
            fragment.mInLayout = true;
            o oVar2 = this.f2070a;
            fragment.mFragmentManager = oVar2;
            fragment.mHost = oVar2.t0();
            fragment.onInflate(this.f2070a.t0().f(), attributeSet, fragment.mSavedFragmentState);
            vVar = this.f2070a.v(fragment);
            if (o.F0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Retained Fragment ");
                sb2.append(fragment);
                sb2.append(" has been re-attached via the <fragment> tag: id=0x");
                sb2.append(Integer.toHexString(resourceId));
            }
        } else {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
        }
        fragment.mContainer = (ViewGroup) view;
        vVar.m();
        vVar.j();
        View view2 = fragment.mView;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (fragment.mView.getTag() == null) {
                fragment.mView.setTag(string);
            }
            fragment.mView.addOnAttachStateChangeListener(new a(vVar));
            return fragment.mView;
        }
        throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
    }
}
