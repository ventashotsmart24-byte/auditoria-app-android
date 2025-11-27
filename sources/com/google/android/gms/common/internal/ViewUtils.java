package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class ViewUtils {
    private ViewUtils() {
    }

    @KeepForSdk
    public static String getXmlAttributeString(String str, String str2, Context context, AttributeSet attributeSet, boolean z10, boolean z11, String str3) {
        String str4;
        if (attributeSet == null) {
            str4 = null;
        } else {
            str4 = attributeSet.getAttributeValue(str, str2);
        }
        if (str4 != null && str4.startsWith("@string/") && z10) {
            String substring = str4.substring(8);
            String packageName = context.getPackageName();
            TypedValue typedValue = new TypedValue();
            try {
                Resources resources = context.getResources();
                resources.getValue(packageName + ":string/" + substring, typedValue, true);
            } catch (Resources.NotFoundException unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("Could not find resource for ");
                sb.append(str2);
                sb.append(": ");
                sb.append(str4);
            }
            CharSequence charSequence = typedValue.string;
            if (charSequence != null) {
                str4 = charSequence.toString();
            } else {
                String obj = typedValue.toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Resource ");
                sb2.append(str2);
                sb2.append(" was not a string: ");
                sb2.append(obj);
            }
        }
        if (z11 && str4 == null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Required XML attribute \"");
            sb3.append(str2);
            sb3.append("\" missing");
        }
        return str4;
    }
}
