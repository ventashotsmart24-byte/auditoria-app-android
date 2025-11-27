package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.hpplay.cybergarage.soap.SOAP;
import com.mobile.brasiltv.view.RoundedDrawable;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import s.h;
import s.i;

public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k  reason: collision with root package name */
    public static final PorterDuff.Mode f1764k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with root package name */
    public int f1765a;

    /* renamed from: b  reason: collision with root package name */
    public Object f1766b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f1767c;

    /* renamed from: d  reason: collision with root package name */
    public Parcelable f1768d;

    /* renamed from: e  reason: collision with root package name */
    public int f1769e;

    /* renamed from: f  reason: collision with root package name */
    public int f1770f;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f1771g;

    /* renamed from: h  reason: collision with root package name */
    public PorterDuff.Mode f1772h;

    /* renamed from: i  reason: collision with root package name */
    public String f1773i;

    /* renamed from: j  reason: collision with root package name */
    public String f1774j;

    public IconCompat() {
        this.f1765a = -1;
        this.f1767c = null;
        this.f1768d = null;
        this.f1769e = 0;
        this.f1770f = 0;
        this.f1771g = null;
        this.f1772h = f1764k;
        this.f1773i = null;
    }

    public static Bitmap b(Bitmap bitmap, boolean z10) {
        int min = (int) (((float) Math.min(bitmap.getWidth(), bitmap.getHeight())) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f10 = (float) min;
        float f11 = 0.5f * f10;
        float f12 = 0.9166667f * f11;
        if (z10) {
            float f13 = 0.010416667f * f10;
            paint.setColor(0);
            paint.setShadowLayer(f13, 0.0f, f10 * 0.020833334f, 1023410176);
            canvas.drawCircle(f11, f11, f12, paint);
            paint.setShadowLayer(f13, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f11, f11, f12, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((float) ((-(bitmap.getWidth() - min)) / 2), (float) ((-(bitmap.getHeight() - min)) / 2));
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f11, f11, f12, paint);
        canvas.setBitmap((Bitmap) null);
        return createBitmap;
    }

    public static IconCompat c(Bitmap bitmap) {
        if (bitmap != null) {
            IconCompat iconCompat = new IconCompat(1);
            iconCompat.f1766b = bitmap;
            return iconCompat;
        }
        throw new IllegalArgumentException("Bitmap must not be null.");
    }

    public static IconCompat d(Context context, int i10) {
        if (context != null) {
            return e(context.getResources(), context.getPackageName(), i10);
        }
        throw new IllegalArgumentException("Context must not be null.");
    }

    public static IconCompat e(Resources resources, String str, int i10) {
        if (str == null) {
            throw new IllegalArgumentException("Package must not be null.");
        } else if (i10 != 0) {
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.f1769e = i10;
            if (resources != null) {
                try {
                    iconCompat.f1766b = resources.getResourceName(i10);
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            } else {
                iconCompat.f1766b = str;
            }
            iconCompat.f1774j = str;
            return iconCompat;
        } else {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
    }

    public static int h(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e10) {
            Log.e("IconCompat", "Unable to get icon resource", e10);
            return 0;
        } catch (InvocationTargetException e11) {
            Log.e("IconCompat", "Unable to get icon resource", e11);
            return 0;
        } catch (NoSuchMethodException e12) {
            Log.e("IconCompat", "Unable to get icon resource", e12);
            return 0;
        }
    }

    public static String j(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e10) {
            Log.e("IconCompat", "Unable to get icon package", e10);
            return null;
        } catch (InvocationTargetException e11) {
            Log.e("IconCompat", "Unable to get icon package", e11);
            return null;
        } catch (NoSuchMethodException e12) {
            Log.e("IconCompat", "Unable to get icon package", e12);
            return null;
        }
    }

    public static Resources k(Context context, String str) {
        if ("android".equals(str)) {
            return Resources.getSystem();
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 8192);
            if (applicationInfo != null) {
                return packageManager.getResourcesForApplication(applicationInfo);
            }
            return null;
        } catch (PackageManager.NameNotFoundException e10) {
            Log.e("IconCompat", String.format("Unable to find pkg=%s for icon", new Object[]{str}), e10);
            return null;
        }
    }

    public static int m(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getType();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getType", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e10) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e10);
            return -1;
        } catch (InvocationTargetException e11) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e11);
            return -1;
        } catch (NoSuchMethodException e12) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e12);
            return -1;
        }
    }

    public static Uri o(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getUri();
        }
        try {
            return (Uri) icon.getClass().getMethod("getUri", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e10) {
            Log.e("IconCompat", "Unable to get icon uri", e10);
            return null;
        } catch (InvocationTargetException e11) {
            Log.e("IconCompat", "Unable to get icon uri", e11);
            return null;
        } catch (NoSuchMethodException e12) {
            Log.e("IconCompat", "Unable to get icon uri", e12);
            return null;
        }
    }

    public static String w(int i10) {
        switch (i10) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public void a(Context context) {
        Object obj;
        if (this.f1765a == 2 && (obj = this.f1766b) != null) {
            String str = (String) obj;
            if (str.contains(SOAP.DELIM)) {
                String str2 = str.split(SOAP.DELIM, -1)[1];
                String str3 = str2.split(Operator.Operation.DIVISION, -1)[0];
                String str4 = str2.split(Operator.Operation.DIVISION, -1)[1];
                String str5 = str.split(SOAP.DELIM, -1)[0];
                if (!"0_resource_name_obfuscated".equals(str4)) {
                    String i10 = i();
                    int identifier = k(context, i10).getIdentifier(str4, str3, str5);
                    if (this.f1769e != identifier) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Id has changed for ");
                        sb.append(i10);
                        sb.append(" ");
                        sb.append(str);
                        this.f1769e = identifier;
                    }
                }
            }
        }
    }

    public Bitmap f() {
        int i10 = this.f1765a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            Object obj = this.f1766b;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        } else if (i10 == 1) {
            return (Bitmap) this.f1766b;
        } else {
            if (i10 == 5) {
                return b((Bitmap) this.f1766b, true);
            }
            throw new IllegalStateException("called getBitmap() on " + this);
        }
    }

    public int g() {
        int i10 = this.f1765a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            return h(i.a(this.f1766b));
        }
        if (i10 == 2) {
            return this.f1769e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String i() {
        int i10 = this.f1765a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            return j(i.a(this.f1766b));
        }
        if (i10 != 2) {
            throw new IllegalStateException("called getResPackage() on " + this);
        } else if (TextUtils.isEmpty(this.f1774j)) {
            return ((String) this.f1766b).split(SOAP.DELIM, -1)[0];
        } else {
            return this.f1774j;
        }
    }

    public int l() {
        int i10 = this.f1765a;
        if (i10 != -1 || Build.VERSION.SDK_INT < 23) {
            return i10;
        }
        return m(i.a(this.f1766b));
    }

    public Uri n() {
        int i10 = this.f1765a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            return o(i.a(this.f1766b));
        }
        if (i10 == 4 || i10 == 6) {
            return Uri.parse((String) this.f1766b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public InputStream p(Context context) {
        Uri n10 = n();
        String scheme = n10.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(n10);
            } catch (Exception unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to load image from URI: ");
                sb.append(n10);
                return null;
            }
        } else {
            try {
                return new FileInputStream(new File((String) this.f1766b));
            } catch (FileNotFoundException unused2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to load image from path: ");
                sb2.append(n10);
                return null;
            }
        }
    }

    public Drawable q(Context context) {
        a(context);
        if (Build.VERSION.SDK_INT >= 23) {
            return v(context).loadDrawable(context);
        }
        Drawable r10 = r(context);
        if (!(r10 == null || (this.f1771g == null && this.f1772h == f1764k))) {
            r10.mutate();
            h.o(r10, this.f1771g);
            h.p(r10, this.f1772h);
        }
        return r10;
    }

    public final Drawable r(Context context) {
        switch (this.f1765a) {
            case 1:
                return new BitmapDrawable(context.getResources(), (Bitmap) this.f1766b);
            case 2:
                String i10 = i();
                if (TextUtils.isEmpty(i10)) {
                    i10 = context.getPackageName();
                }
                try {
                    return q.h.d(k(context, i10), this.f1769e, context.getTheme());
                } catch (RuntimeException e10) {
                    Log.e("IconCompat", String.format("Unable to load resource 0x%08x from pkg=%s", new Object[]{Integer.valueOf(this.f1769e), this.f1766b}), e10);
                    break;
                }
            case 3:
                return new BitmapDrawable(context.getResources(), BitmapFactory.decodeByteArray((byte[]) this.f1766b, this.f1769e, this.f1770f));
            case 4:
                InputStream p10 = p(context);
                if (p10 != null) {
                    return new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(p10));
                }
                break;
            case 5:
                return new BitmapDrawable(context.getResources(), b((Bitmap) this.f1766b, false));
            case 6:
                InputStream p11 = p(context);
                if (p11 != null) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        return new AdaptiveIconDrawable((Drawable) null, new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(p11)));
                    }
                    return new BitmapDrawable(context.getResources(), b(BitmapFactory.decodeStream(p11), false));
                }
                break;
        }
        return null;
    }

    public void s() {
        this.f1772h = PorterDuff.Mode.valueOf(this.f1773i);
        switch (this.f1765a) {
            case -1:
                Parcelable parcelable = this.f1768d;
                if (parcelable != null) {
                    this.f1766b = parcelable;
                    return;
                }
                throw new IllegalArgumentException("Invalid icon");
            case 1:
            case 5:
                Parcelable parcelable2 = this.f1768d;
                if (parcelable2 != null) {
                    this.f1766b = parcelable2;
                    return;
                }
                byte[] bArr = this.f1767c;
                this.f1766b = bArr;
                this.f1765a = 3;
                this.f1769e = 0;
                this.f1770f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f1767c, Charset.forName("UTF-16"));
                this.f1766b = str;
                if (this.f1765a == 2 && this.f1774j == null) {
                    this.f1774j = str.split(SOAP.DELIM, -1)[0];
                    return;
                }
                return;
            case 3:
                this.f1766b = this.f1767c;
                return;
            default:
                return;
        }
    }

    public void t(boolean z10) {
        this.f1773i = this.f1772h.name();
        switch (this.f1765a) {
            case -1:
                if (!z10) {
                    this.f1768d = (Parcelable) this.f1766b;
                    return;
                }
                throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
            case 1:
            case 5:
                if (z10) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ((Bitmap) this.f1766b).compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.f1767c = byteArrayOutputStream.toByteArray();
                    return;
                }
                this.f1768d = (Parcelable) this.f1766b;
                return;
            case 2:
                this.f1767c = ((String) this.f1766b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f1767c = (byte[]) this.f1766b;
                return;
            case 4:
            case 6:
                this.f1767c = this.f1766b.toString().getBytes(Charset.forName("UTF-16"));
                return;
            default:
                return;
        }
    }

    public String toString() {
        if (this.f1765a == -1) {
            return String.valueOf(this.f1766b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(w(this.f1765a));
        switch (this.f1765a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f1766b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f1766b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f1774j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", new Object[]{Integer.valueOf(g())}));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f1769e);
                if (this.f1770f != 0) {
                    sb.append(" off=");
                    sb.append(this.f1770f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f1766b);
                break;
        }
        if (this.f1771g != null) {
            sb.append(" tint=");
            sb.append(this.f1771g);
        }
        if (this.f1772h != f1764k) {
            sb.append(" mode=");
            sb.append(this.f1772h);
        }
        sb.append(")");
        return sb.toString();
    }

    public Icon u() {
        return v((Context) null);
    }

    public Icon v(Context context) {
        Icon icon;
        switch (this.f1765a) {
            case -1:
                return i.a(this.f1766b);
            case 1:
                icon = Icon.createWithBitmap((Bitmap) this.f1766b);
                break;
            case 2:
                icon = Icon.createWithResource(i(), this.f1769e);
                break;
            case 3:
                icon = Icon.createWithData((byte[]) this.f1766b, this.f1769e, this.f1770f);
                break;
            case 4:
                icon = Icon.createWithContentUri((String) this.f1766b);
                break;
            case 5:
                if (Build.VERSION.SDK_INT < 26) {
                    icon = Icon.createWithBitmap(b((Bitmap) this.f1766b, false));
                    break;
                } else {
                    icon = Icon.createWithAdaptiveBitmap((Bitmap) this.f1766b);
                    break;
                }
            case 6:
                int i10 = Build.VERSION.SDK_INT;
                if (i10 >= 30) {
                    icon = Icon.createWithAdaptiveBitmapContentUri(n());
                    break;
                } else if (context != null) {
                    InputStream p10 = p(context);
                    if (p10 != null) {
                        if (i10 < 26) {
                            icon = Icon.createWithBitmap(b(BitmapFactory.decodeStream(p10), false));
                            break;
                        } else {
                            icon = Icon.createWithAdaptiveBitmap(BitmapFactory.decodeStream(p10));
                            break;
                        }
                    } else {
                        throw new IllegalStateException("Cannot load adaptive icon from uri: " + n());
                    }
                } else {
                    throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + n());
                }
            default:
                throw new IllegalArgumentException("Unknown type");
        }
        ColorStateList colorStateList = this.f1771g;
        if (colorStateList != null) {
            Icon unused = icon.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = this.f1772h;
        if (mode != f1764k) {
            Icon unused2 = icon.setTintMode(mode);
        }
        return icon;
    }

    public IconCompat(int i10) {
        this.f1767c = null;
        this.f1768d = null;
        this.f1769e = 0;
        this.f1770f = 0;
        this.f1771g = null;
        this.f1772h = f1764k;
        this.f1773i = null;
        this.f1765a = i10;
    }
}
