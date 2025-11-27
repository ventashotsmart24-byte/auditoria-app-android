package com.google.firebase.dynamiclinks.ktx;

import androidx.annotation.Keep;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import i9.i;
import java.util.List;

@Keep
public final class FirebaseDynamicLinksKtxRegistrar implements ComponentRegistrar {
    public List<Component<?>> getComponents() {
        return i.b(LibraryVersionComponent.create(FirebaseDynamicLinksKt.LIBRARY_NAME, "21.1.0"));
    }
}
