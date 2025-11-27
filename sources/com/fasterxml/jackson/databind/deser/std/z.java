package com.fasterxml.jackson.databind.deser.std;

import c3.k;
import c3.n;
import k3.g;
import k3.h;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public class z extends e0 {
    public z() {
        super(StackTraceElement.class);
    }

    public StackTraceElement a(g gVar, String str, String str2, String str3, int i10, String str4, String str5, String str6) {
        return new StackTraceElement(str, str2, str3, i10);
    }

    /* renamed from: b */
    public StackTraceElement deserialize(k kVar, g gVar) {
        int i10;
        n n10 = kVar.n();
        if (n10 == n.START_OBJECT) {
            String str = null;
            String str2 = null;
            String str3 = null;
            String str4 = "";
            String str5 = str4;
            String str6 = str5;
            int i11 = -1;
            while (true) {
                n t02 = kVar.t0();
                if (t02 == n.END_OBJECT) {
                    return a(gVar, str4, str5, str6, i11, str, str2, str3);
                }
                String m10 = kVar.m();
                if ("className".equals(m10)) {
                    str4 = kVar.Y();
                } else if ("classLoaderName".equals(m10)) {
                    str3 = kVar.Y();
                } else if ("fileName".equals(m10)) {
                    str6 = kVar.Y();
                } else if ("lineNumber".equals(m10)) {
                    if (t02.d()) {
                        i10 = kVar.P();
                    } else {
                        i10 = _parseIntPrimitive(kVar, gVar);
                    }
                    i11 = i10;
                } else if ("methodName".equals(m10)) {
                    str5 = kVar.Y();
                } else if (!"nativeMethod".equals(m10)) {
                    if ("moduleName".equals(m10)) {
                        str = kVar.Y();
                    } else if ("moduleVersion".equals(m10)) {
                        str2 = kVar.Y();
                    } else if (!"declaringClass".equals(m10) && !IjkMediaMeta.IJKM_KEY_FORMAT.equals(m10)) {
                        handleUnknownProperty(kVar, gVar, this._valueClass, m10);
                    }
                }
                kVar.D0();
            }
        } else if (n10 != n.START_ARRAY || !gVar.n0(h.UNWRAP_SINGLE_VALUE_ARRAYS)) {
            return (StackTraceElement) gVar.a0(this._valueClass, kVar);
        } else {
            kVar.s0();
            StackTraceElement b10 = deserialize(kVar, gVar);
            if (kVar.s0() != n.END_ARRAY) {
                handleMissingEndArrayForSingle(kVar, gVar);
            }
            return b10;
        }
    }
}
