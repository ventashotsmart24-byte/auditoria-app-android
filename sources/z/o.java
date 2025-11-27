package z;

import a0.c;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;

public abstract class o implements Spannable {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final TextPaint f9898a;

        /* renamed from: b  reason: collision with root package name */
        public final TextDirectionHeuristic f9899b;

        /* renamed from: c  reason: collision with root package name */
        public final int f9900c;

        /* renamed from: d  reason: collision with root package name */
        public final int f9901d;

        /* renamed from: e  reason: collision with root package name */
        public final PrecomputedText.Params f9902e;

        /* renamed from: z.o$a$a  reason: collision with other inner class name */
        public static class C0137a {

            /* renamed from: a  reason: collision with root package name */
            public final TextPaint f9903a;

            /* renamed from: b  reason: collision with root package name */
            public TextDirectionHeuristic f9904b;

            /* renamed from: c  reason: collision with root package name */
            public int f9905c;

            /* renamed from: d  reason: collision with root package name */
            public int f9906d;

            public C0137a(TextPaint textPaint) {
                this.f9903a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.f9905c = 1;
                    this.f9906d = 1;
                } else {
                    this.f9906d = 0;
                    this.f9905c = 0;
                }
                this.f9904b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }

            public a a() {
                return new a(this.f9903a, this.f9904b, this.f9905c, this.f9906d);
            }

            public C0137a b(int i10) {
                this.f9905c = i10;
                return this;
            }

            public C0137a c(int i10) {
                this.f9906d = i10;
                return this;
            }

            public C0137a d(TextDirectionHeuristic textDirectionHeuristic) {
                this.f9904b = textDirectionHeuristic;
                return this;
            }
        }

        public a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i10, int i11) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f9902e = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i10).setHyphenationFrequency(i11).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.f9902e = null;
            }
            this.f9898a = textPaint;
            this.f9899b = textDirectionHeuristic;
            this.f9900c = i10;
            this.f9901d = i11;
        }

        public boolean a(a aVar) {
            int i10 = Build.VERSION.SDK_INT;
            if ((i10 >= 23 && (this.f9900c != aVar.b() || this.f9901d != aVar.c())) || this.f9898a.getTextSize() != aVar.e().getTextSize() || this.f9898a.getTextScaleX() != aVar.e().getTextScaleX() || this.f9898a.getTextSkewX() != aVar.e().getTextSkewX()) {
                return false;
            }
            if ((i10 >= 21 && (this.f9898a.getLetterSpacing() != aVar.e().getLetterSpacing() || !TextUtils.equals(this.f9898a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()))) || this.f9898a.getFlags() != aVar.e().getFlags()) {
                return false;
            }
            if (i10 >= 24) {
                if (!this.f9898a.getTextLocales().equals(aVar.e().getTextLocales())) {
                    return false;
                }
            } else if (!this.f9898a.getTextLocale().equals(aVar.e().getTextLocale())) {
                return false;
            }
            if (this.f9898a.getTypeface() == null) {
                if (aVar.e().getTypeface() != null) {
                    return false;
                }
                return true;
            } else if (!this.f9898a.getTypeface().equals(aVar.e().getTypeface())) {
                return false;
            } else {
                return true;
            }
        }

        public int b() {
            return this.f9900c;
        }

        public int c() {
            return this.f9901d;
        }

        public TextDirectionHeuristic d() {
            return this.f9899b;
        }

        public TextPaint e() {
            return this.f9898a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (a(aVar) && this.f9899b == aVar.d()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 24) {
                return c.b(Float.valueOf(this.f9898a.getTextSize()), Float.valueOf(this.f9898a.getTextScaleX()), Float.valueOf(this.f9898a.getTextSkewX()), Float.valueOf(this.f9898a.getLetterSpacing()), Integer.valueOf(this.f9898a.getFlags()), this.f9898a.getTextLocales(), this.f9898a.getTypeface(), Boolean.valueOf(this.f9898a.isElegantTextHeight()), this.f9899b, Integer.valueOf(this.f9900c), Integer.valueOf(this.f9901d));
            } else if (i10 >= 21) {
                return c.b(Float.valueOf(this.f9898a.getTextSize()), Float.valueOf(this.f9898a.getTextScaleX()), Float.valueOf(this.f9898a.getTextSkewX()), Float.valueOf(this.f9898a.getLetterSpacing()), Integer.valueOf(this.f9898a.getFlags()), this.f9898a.getTextLocale(), this.f9898a.getTypeface(), Boolean.valueOf(this.f9898a.isElegantTextHeight()), this.f9899b, Integer.valueOf(this.f9900c), Integer.valueOf(this.f9901d));
            } else {
                return c.b(Float.valueOf(this.f9898a.getTextSize()), Float.valueOf(this.f9898a.getTextScaleX()), Float.valueOf(this.f9898a.getTextSkewX()), Integer.valueOf(this.f9898a.getFlags()), this.f9898a.getTextLocale(), this.f9898a.getTypeface(), this.f9899b, Integer.valueOf(this.f9900c), Integer.valueOf(this.f9901d));
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f9898a.getTextSize());
            sb.append(", textScaleX=" + this.f9898a.getTextScaleX());
            sb.append(", textSkewX=" + this.f9898a.getTextSkewX());
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 21) {
                sb.append(", letterSpacing=" + this.f9898a.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.f9898a.isElegantTextHeight());
            }
            if (i10 >= 24) {
                sb.append(", textLocale=" + this.f9898a.getTextLocales());
            } else {
                sb.append(", textLocale=" + this.f9898a.getTextLocale());
            }
            sb.append(", typeface=" + this.f9898a.getTypeface());
            if (i10 >= 26) {
                sb.append(", variationSettings=" + this.f9898a.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f9899b);
            sb.append(", breakStrategy=" + this.f9900c);
            sb.append(", hyphenationFrequency=" + this.f9901d);
            sb.append("}");
            return sb.toString();
        }

        public a(PrecomputedText.Params params) {
            this.f9898a = params.getTextPaint();
            this.f9899b = params.getTextDirection();
            this.f9900c = params.getBreakStrategy();
            this.f9901d = params.getHyphenationFrequency();
            this.f9902e = Build.VERSION.SDK_INT < 29 ? null : params;
        }
    }
}
