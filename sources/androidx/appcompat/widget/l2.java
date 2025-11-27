package androidx.appcompat.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.raizlabs.android.dbflow.sql.language.Operator;
import e0.c;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

public class l2 extends c implements View.OnClickListener {

    /* renamed from: l  reason: collision with root package name */
    public final SearchManager f1266l = ((SearchManager) this.f6448d.getSystemService(FirebaseAnalytics.Event.SEARCH));

    /* renamed from: m  reason: collision with root package name */
    public final SearchView f1267m;

    /* renamed from: n  reason: collision with root package name */
    public final SearchableInfo f1268n;

    /* renamed from: o  reason: collision with root package name */
    public final Context f1269o;

    /* renamed from: p  reason: collision with root package name */
    public final WeakHashMap f1270p;

    /* renamed from: q  reason: collision with root package name */
    public final int f1271q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f1272r = false;

    /* renamed from: s  reason: collision with root package name */
    public int f1273s = 1;

    /* renamed from: t  reason: collision with root package name */
    public ColorStateList f1274t;

    /* renamed from: u  reason: collision with root package name */
    public int f1275u = -1;

    /* renamed from: v  reason: collision with root package name */
    public int f1276v = -1;

    /* renamed from: w  reason: collision with root package name */
    public int f1277w = -1;

    /* renamed from: x  reason: collision with root package name */
    public int f1278x = -1;

    /* renamed from: y  reason: collision with root package name */
    public int f1279y = -1;

    /* renamed from: z  reason: collision with root package name */
    public int f1280z = -1;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f1281a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f1282b;

        /* renamed from: c  reason: collision with root package name */
        public final ImageView f1283c;

        /* renamed from: d  reason: collision with root package name */
        public final ImageView f1284d;

        /* renamed from: e  reason: collision with root package name */
        public final ImageView f1285e;

        public a(View view) {
            this.f1281a = (TextView) view.findViewById(16908308);
            this.f1282b = (TextView) view.findViewById(16908309);
            this.f1283c = (ImageView) view.findViewById(16908295);
            this.f1284d = (ImageView) view.findViewById(16908296);
            this.f1285e = (ImageView) view.findViewById(R$id.edit_query);
        }
    }

    public l2(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), (Cursor) null, true);
        this.f1267m = searchView;
        this.f1268n = searchableInfo;
        this.f1271q = searchView.getSuggestionCommitIconResId();
        this.f1269o = context;
        this.f1270p = weakHashMap;
    }

    public static String o(Cursor cursor, String str) {
        return w(cursor, cursor.getColumnIndex(str));
    }

    public static String w(Cursor cursor, int i10) {
        if (i10 == -1) {
            return null;
        }
        try {
            return cursor.getString(i10);
        } catch (Exception e10) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e10);
            return null;
        }
    }

    public final void A(String str, Drawable drawable) {
        if (drawable != null) {
            this.f1270p.put(str, drawable.getConstantState());
        }
    }

    public final void B(Cursor cursor) {
        Bundle bundle;
        if (cursor != null) {
            bundle = cursor.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            bundle.getBoolean("in_progress");
        }
    }

    public void a(Cursor cursor) {
        if (!this.f1272r) {
            try {
                super.a(cursor);
                if (cursor != null) {
                    this.f1275u = cursor.getColumnIndex("suggest_text_1");
                    this.f1276v = cursor.getColumnIndex("suggest_text_2");
                    this.f1277w = cursor.getColumnIndex("suggest_text_2_url");
                    this.f1278x = cursor.getColumnIndex("suggest_icon_1");
                    this.f1279y = cursor.getColumnIndex("suggest_icon_2");
                    this.f1280z = cursor.getColumnIndex("suggest_flags");
                }
            } catch (Exception e10) {
                Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e10);
            }
        } else if (cursor != null) {
            cursor.close();
        }
    }

    public CharSequence b(Cursor cursor) {
        String o10;
        String o11;
        if (cursor == null) {
            return null;
        }
        String o12 = o(cursor, "suggest_intent_query");
        if (o12 != null) {
            return o12;
        }
        if (this.f1268n.shouldRewriteQueryFromData() && (o11 = o(cursor, "suggest_intent_data")) != null) {
            return o11;
        }
        if (!this.f1268n.shouldRewriteQueryFromText() || (o10 = o(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return o10;
    }

    public Cursor c(CharSequence charSequence) {
        String str;
        if (charSequence == null) {
            str = "";
        } else {
            str = charSequence.toString();
        }
        if (this.f1267m.getVisibility() == 0 && this.f1267m.getWindowVisibility() == 0) {
            try {
                Cursor v10 = v(this.f1268n, str, 50);
                if (v10 != null) {
                    v10.getCount();
                    return v10;
                }
            } catch (RuntimeException unused) {
            }
        }
        return null;
    }

    public void e(View view, Context context, Cursor cursor) {
        int i10;
        CharSequence charSequence;
        a aVar = (a) view.getTag();
        int i11 = this.f1280z;
        if (i11 != -1) {
            i10 = cursor.getInt(i11);
        } else {
            i10 = 0;
        }
        if (aVar.f1281a != null) {
            z(aVar.f1281a, w(cursor, this.f1275u));
        }
        if (aVar.f1282b != null) {
            String w10 = w(cursor, this.f1277w);
            if (w10 != null) {
                charSequence = l(w10);
            } else {
                charSequence = w(cursor, this.f1276v);
            }
            if (TextUtils.isEmpty(charSequence)) {
                TextView textView = aVar.f1281a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f1281a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f1281a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f1281a.setMaxLines(1);
                }
            }
            z(aVar.f1282b, charSequence);
        }
        ImageView imageView = aVar.f1283c;
        if (imageView != null) {
            y(imageView, t(cursor), 4);
        }
        ImageView imageView2 = aVar.f1284d;
        if (imageView2 != null) {
            y(imageView2, u(cursor), 8);
        }
        int i12 = this.f1273s;
        if (i12 == 2 || (i12 == 1 && (i10 & 1) != 0)) {
            aVar.f1285e.setVisibility(0);
            aVar.f1285e.setTag(aVar.f1281a.getText());
            aVar.f1285e.setOnClickListener(this);
            return;
        }
        aVar.f1285e.setVisibility(8);
    }

    public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i10, view, viewGroup);
        } catch (RuntimeException e10) {
            View g10 = g(this.f6448d, this.f6447c, viewGroup);
            if (g10 != null) {
                ((a) g10.getTag()).f1281a.setText(e10.toString());
            }
            return g10;
        }
    }

    public View getView(int i10, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i10, view, viewGroup);
        } catch (RuntimeException e10) {
            View h10 = h(this.f6448d, this.f6447c, viewGroup);
            if (h10 != null) {
                ((a) h10.getTag()).f1281a.setText(e10.toString());
            }
            return h10;
        }
    }

    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        View h10 = super.h(context, cursor, viewGroup);
        h10.setTag(new a(h10));
        ((ImageView) h10.findViewById(R$id.edit_query)).setImageResource(this.f1271q);
        return h10;
    }

    public boolean hasStableIds() {
        return false;
    }

    public final Drawable k(String str) {
        Drawable.ConstantState constantState = (Drawable.ConstantState) this.f1270p.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    public final CharSequence l(CharSequence charSequence) {
        if (this.f1274t == null) {
            TypedValue typedValue = new TypedValue();
            this.f6448d.getTheme().resolveAttribute(R$attr.textColorSearchUrl, typedValue, true);
            this.f1274t = this.f6448d.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan((String) null, 0, 0, this.f1274t, (ColorStateList) null), 0, charSequence.length(), 33);
        return spannableString;
    }

    public final Drawable m(ComponentName componentName) {
        PackageManager packageManager = this.f6448d.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid icon resource ");
            sb.append(iconResource);
            sb.append(" for ");
            sb.append(componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.toString();
            return null;
        }
    }

    public final Drawable n(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        Drawable.ConstantState constantState = null;
        if (this.f1270p.containsKey(flattenToShortString)) {
            Drawable.ConstantState constantState2 = (Drawable.ConstantState) this.f1270p.get(flattenToShortString);
            if (constantState2 == null) {
                return null;
            }
            return constantState2.newDrawable(this.f1269o.getResources());
        }
        Drawable m10 = m(componentName);
        if (m10 != null) {
            constantState = m10.getConstantState();
        }
        this.f1270p.put(flattenToShortString, constantState);
        return m10;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        B(d());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        B(d());
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f1267m.z((CharSequence) tag);
        }
    }

    public final Drawable p(Cursor cursor) {
        Drawable n10 = n(this.f1268n.getSearchActivity());
        if (n10 != null) {
            return n10;
        }
        return this.f6448d.getPackageManager().getDefaultActivityIcon();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002c, code lost:
        throw new java.io.FileNotFoundException("Resource does not exist: " + r7);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.drawable.Drawable q(android.net.Uri r7) {
        /*
            r6 = this;
            java.lang.String r0 = "Error closing icon stream for "
            java.lang.String r1 = "SuggestionsAdapter"
            r2 = 0
            java.lang.String r3 = r7.getScheme()     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r4 = "android.resource"
            boolean r3 = r4.equals(r3)     // Catch:{ FileNotFoundException -> 0x0085 }
            if (r3 == 0) goto L_0x002d
            android.graphics.drawable.Drawable r7 = r6.r(r7)     // Catch:{ NotFoundException -> 0x0016 }
            return r7
        L_0x0016:
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0085 }
            r1.<init>()     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r3 = "Resource does not exist: "
            r1.append(r3)     // Catch:{ FileNotFoundException -> 0x0085 }
            r1.append(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r1 = r1.toString()     // Catch:{ FileNotFoundException -> 0x0085 }
            r0.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0085 }
            throw r0     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x002d:
            android.content.Context r3 = r6.f1269o     // Catch:{ FileNotFoundException -> 0x0085 }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0085 }
            java.io.InputStream r3 = r3.openInputStream(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            if (r3 == 0) goto L_0x006e
            android.graphics.drawable.Drawable r4 = android.graphics.drawable.Drawable.createFromStream(r3, r2)     // Catch:{ all -> 0x0055 }
            r3.close()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0054
        L_0x0041:
            r3 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.<init>()     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.append(r0)     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.append(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r0 = r5.toString()     // Catch:{ FileNotFoundException -> 0x0085 }
            android.util.Log.e(r1, r0, r3)     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x0054:
            return r4
        L_0x0055:
            r4 = move-exception
            r3.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x006d
        L_0x005a:
            r3 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.<init>()     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.append(r0)     // Catch:{ FileNotFoundException -> 0x0085 }
            r5.append(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r0 = r5.toString()     // Catch:{ FileNotFoundException -> 0x0085 }
            android.util.Log.e(r1, r0, r3)     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x006d:
            throw r4     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x006e:
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0085 }
            r1.<init>()     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r3 = "Failed to open "
            r1.append(r3)     // Catch:{ FileNotFoundException -> 0x0085 }
            r1.append(r7)     // Catch:{ FileNotFoundException -> 0x0085 }
            java.lang.String r1 = r1.toString()     // Catch:{ FileNotFoundException -> 0x0085 }
            r0.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0085 }
            throw r0     // Catch:{ FileNotFoundException -> 0x0085 }
        L_0x0085:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Icon not found: "
            r1.append(r3)
            r1.append(r7)
            java.lang.String r7 = ", "
            r1.append(r7)
            java.lang.String r7 = r0.getMessage()
            r1.append(r7)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.l2.q(android.net.Uri):android.graphics.drawable.Drawable");
    }

    public Drawable r(Uri uri) {
        int i10;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.f6448d.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            i10 = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        i10 = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (i10 != 0) {
                        return resourcesForApplication.getDrawable(i10);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        } else {
            throw new FileNotFoundException("No authority: " + uri);
        }
    }

    public final Drawable s(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f1269o.getPackageName() + Operator.Operation.DIVISION + parseInt;
            Drawable k10 = k(str2);
            if (k10 != null) {
                return k10;
            }
            Drawable drawable = p.a.getDrawable(this.f1269o, parseInt);
            A(str2, drawable);
            return drawable;
        } catch (NumberFormatException unused) {
            Drawable k11 = k(str);
            if (k11 != null) {
                return k11;
            }
            Drawable q10 = q(Uri.parse(str));
            A(str, q10);
            return q10;
        } catch (Resources.NotFoundException unused2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Icon resource not found: ");
            sb.append(str);
            return null;
        }
    }

    public final Drawable t(Cursor cursor) {
        int i10 = this.f1278x;
        if (i10 == -1) {
            return null;
        }
        Drawable s10 = s(cursor.getString(i10));
        if (s10 != null) {
            return s10;
        }
        return p(cursor);
    }

    public final Drawable u(Cursor cursor) {
        int i10 = this.f1279y;
        if (i10 == -1) {
            return null;
        }
        return s(cursor.getString(i10));
    }

    public Cursor v(SearchableInfo searchableInfo, String str, int i10) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i10 > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i10));
        }
        return this.f6448d.getContentResolver().query(fragment.build(), (String[]) null, suggestSelection, strArr2, (String) null);
    }

    public void x(int i10) {
        this.f1273s = i10;
    }

    public final void y(ImageView imageView, Drawable drawable, int i10) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i10);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    public final void z(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }
}
