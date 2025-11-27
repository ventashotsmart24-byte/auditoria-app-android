package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.e;
import androidx.appcompat.widget.f1;
import androidx.appcompat.widget.g;
import androidx.appcompat.widget.h;
import androidx.appcompat.widget.i;
import androidx.appcompat.widget.l;
import androidx.appcompat.widget.n;
import androidx.appcompat.widget.o2;
import androidx.appcompat.widget.q;
import androidx.appcompat.widget.q0;
import androidx.appcompat.widget.r;
import androidx.appcompat.widget.u;
import androidx.appcompat.widget.v;
import androidx.appcompat.widget.x;
import b0.c1;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import g.d;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class AppCompatViewInflater {
    private static final String LOG_TAG = "AppCompatViewInflater";
    private static final String[] sClassPrefixList = {"android.widget.", "android.view.", "android.webkit."};
    private static final Map<String, Constructor<? extends View>> sConstructorMap = new androidx.collection.a();
    private static final Class<?>[] sConstructorSignature = {Context.class, AttributeSet.class};
    private static final int[] sOnClickAttrs = {16843375};
    private final Object[] mConstructorArgs = new Object[2];

    public static class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final View f646a;

        /* renamed from: b  reason: collision with root package name */
        public final String f647b;

        /* renamed from: c  reason: collision with root package name */
        public Method f648c;

        /* renamed from: d  reason: collision with root package name */
        public Context f649d;

        public a(View view, String str) {
            this.f646a = view;
            this.f647b = str;
        }

        public final void a(Context context, String str) {
            String str2;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.f647b, new Class[]{View.class})) != null) {
                        this.f648c = method;
                        this.f649d = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                if (context instanceof ContextWrapper) {
                    context = ((ContextWrapper) context).getBaseContext();
                } else {
                    context = null;
                }
            }
            int id = this.f646a.getId();
            if (id == -1) {
                str2 = "";
            } else {
                str2 = " with id '" + this.f646a.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.f647b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f646a.getClass() + str2);
        }

        public void onClick(View view) {
            if (this.f648c == null) {
                a(this.f646a.getContext(), this.f647b);
            }
            try {
                this.f648c.invoke(this.f649d, new Object[]{view});
            } catch (IllegalAccessException e10) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e10);
            } catch (InvocationTargetException e11) {
                throw new IllegalStateException("Could not execute method for android:onClick", e11);
            }
        }
    }

    public static Context d(Context context, AttributeSet attributeSet, boolean z10, boolean z11) {
        int i10;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.N, 0, 0);
        if (z10) {
            i10 = obtainStyledAttributes.getResourceId(R$styleable.View_android_theme, 0);
        } else {
            i10 = 0;
        }
        if (z11 && i10 == 0) {
            i10 = obtainStyledAttributes.getResourceId(R$styleable.View_theme, 0);
        }
        obtainStyledAttributes.recycle();
        if (i10 == 0) {
            return context;
        }
        if (!(context instanceof d) || ((d) context).c() != i10) {
            return new d(context, i10);
        }
        return context;
    }

    public final void a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if ((context instanceof ContextWrapper) && c1.L(view)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, sOnClickAttrs);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new a(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    public final View b(Context context, String str, String str2) {
        String str3;
        Map<String, Constructor<? extends View>> map = sConstructorMap;
        Constructor<? extends U> constructor = map.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(sConstructorSignature);
            map.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.mConstructorArgs);
    }

    public final View c(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue((String) null, Name.LABEL);
        }
        try {
            Object[] objArr = this.mConstructorArgs;
            objArr[0] = context;
            objArr[1] = attributeSet;
            if (-1 == str.indexOf(46)) {
                int i10 = 0;
                while (true) {
                    String[] strArr = sClassPrefixList;
                    if (i10 < strArr.length) {
                        View b10 = b(context, str, strArr[i10]);
                        if (b10 != null) {
                            return b10;
                        }
                        i10++;
                    } else {
                        Object[] objArr2 = this.mConstructorArgs;
                        objArr2[0] = null;
                        objArr2[1] = null;
                        return null;
                    }
                }
            } else {
                View b11 = b(context, str, (String) null);
                Object[] objArr3 = this.mConstructorArgs;
                objArr3[0] = null;
                objArr3[1] = null;
                return b11;
            }
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr4 = this.mConstructorArgs;
            objArr4[0] = null;
            objArr4[1] = null;
        }
    }

    public e createAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new e(context, attributeSet);
    }

    public g createButton(Context context, AttributeSet attributeSet) {
        return new g(context, attributeSet);
    }

    public h createCheckBox(Context context, AttributeSet attributeSet) {
        return new h(context, attributeSet);
    }

    public i createCheckedTextView(Context context, AttributeSet attributeSet) {
        return new i(context, attributeSet);
    }

    public l createEditText(Context context, AttributeSet attributeSet) {
        return new l(context, attributeSet);
    }

    public n createImageButton(Context context, AttributeSet attributeSet) {
        return new n(context, attributeSet);
    }

    public q createImageView(Context context, AttributeSet attributeSet) {
        return new q(context, attributeSet);
    }

    public r createMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new r(context, attributeSet);
    }

    public u createRadioButton(Context context, AttributeSet attributeSet) {
        return new u(context, attributeSet);
    }

    public v createRatingBar(Context context, AttributeSet attributeSet) {
        return new v(context, attributeSet);
    }

    public AppCompatSeekBar createSeekBar(Context context, AttributeSet attributeSet) {
        return new AppCompatSeekBar(context, attributeSet);
    }

    public x createSpinner(Context context, AttributeSet attributeSet) {
        return new x(context, attributeSet);
    }

    public q0 createTextView(Context context, AttributeSet attributeSet) {
        return new q0(context, attributeSet);
    }

    public f1 createToggleButton(Context context, AttributeSet attributeSet) {
        return new f1(context, attributeSet);
    }

    public View createView(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    public final void e(View view, String str) {
        if (view == null) {
            throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
        }
    }

    public final View createView(View view, String str, Context context, AttributeSet attributeSet, boolean z10, boolean z11, boolean z12, boolean z13) {
        View view2;
        Context context2 = (!z10 || view == null) ? context : view.getContext();
        if (z11 || z12) {
            context2 = d(context2, attributeSet, z11, z12);
        }
        if (z13) {
            context2 = o2.b(context2);
        }
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    c10 = 2;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    c10 = 3;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    c10 = 4;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    c10 = 5;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    c10 = 6;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    c10 = 7;
                    break;
                }
                break;
            case 799298502:
                if (str.equals("ToggleButton")) {
                    c10 = 8;
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    c10 = 9;
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    c10 = 10;
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    c10 = 11;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    c10 = 12;
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    c10 = ASCIIPropertyListParser.WHITESPACE_CARRIAGE_RETURN;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                view2 = createRatingBar(context2, attributeSet);
                e(view2, str);
                break;
            case 1:
                view2 = createCheckedTextView(context2, attributeSet);
                e(view2, str);
                break;
            case 2:
                view2 = createMultiAutoCompleteTextView(context2, attributeSet);
                e(view2, str);
                break;
            case 3:
                view2 = createTextView(context2, attributeSet);
                e(view2, str);
                break;
            case 4:
                view2 = createImageButton(context2, attributeSet);
                e(view2, str);
                break;
            case 5:
                view2 = createSeekBar(context2, attributeSet);
                e(view2, str);
                break;
            case 6:
                view2 = createSpinner(context2, attributeSet);
                e(view2, str);
                break;
            case 7:
                view2 = createRadioButton(context2, attributeSet);
                e(view2, str);
                break;
            case 8:
                view2 = createToggleButton(context2, attributeSet);
                e(view2, str);
                break;
            case 9:
                view2 = createImageView(context2, attributeSet);
                e(view2, str);
                break;
            case 10:
                view2 = createAutoCompleteTextView(context2, attributeSet);
                e(view2, str);
                break;
            case 11:
                view2 = createCheckBox(context2, attributeSet);
                e(view2, str);
                break;
            case 12:
                view2 = createEditText(context2, attributeSet);
                e(view2, str);
                break;
            case 13:
                view2 = createButton(context2, attributeSet);
                e(view2, str);
                break;
            default:
                view2 = createView(context2, str, attributeSet);
                break;
        }
        if (view2 == null && context != context2) {
            view2 = c(context2, str, attributeSet);
        }
        if (view2 != null) {
            a(view2, attributeSet);
        }
        return view2;
    }
}
