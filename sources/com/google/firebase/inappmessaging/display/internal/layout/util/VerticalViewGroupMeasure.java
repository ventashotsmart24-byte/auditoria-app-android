package com.google.firebase.inappmessaging.display.internal.layout.util;

import android.view.View;
import com.google.firebase.inappmessaging.display.internal.Logging;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VerticalViewGroupMeasure {

    /* renamed from: h  reason: collision with root package name */
    private int f10239h;
    private List<ViewMeasure> vms;

    /* renamed from: w  reason: collision with root package name */
    private int f10240w;

    public VerticalViewGroupMeasure(int i10, int i11) {
        this.vms = new ArrayList();
        this.f10240w = i10;
        this.f10239h = i11;
    }

    public void add(View view, boolean z10) {
        ViewMeasure viewMeasure = new ViewMeasure(view, z10);
        viewMeasure.setMaxDimens(this.f10240w, this.f10239h);
        this.vms.add(viewMeasure);
    }

    public void allocateSpace(int i10) {
        float f10;
        ArrayList<ViewMeasure> arrayList = new ArrayList<>();
        for (ViewMeasure next : this.vms) {
            if (next.isFlex()) {
                arrayList.add(next);
            }
        }
        Collections.sort(arrayList, new Comparator<ViewMeasure>() {
            public int compare(ViewMeasure viewMeasure, ViewMeasure viewMeasure2) {
                if (viewMeasure.getDesiredHeight() > viewMeasure2.getDesiredHeight()) {
                    return -1;
                }
                return viewMeasure.getDesiredHeight() < viewMeasure2.getDesiredHeight() ? 1 : 0;
            }
        });
        int i11 = 0;
        for (ViewMeasure desiredHeight : arrayList) {
            i11 += desiredHeight.getDesiredHeight();
        }
        int size = arrayList.size();
        if (size < 6) {
            float f11 = 1.0f - (((float) (size - 1)) * 0.2f);
            Logging.logdPair("VVGM (minFrac, maxFrac)", 0.2f, f11);
            float f12 = 0.0f;
            for (ViewMeasure viewMeasure : arrayList) {
                float desiredHeight2 = ((float) viewMeasure.getDesiredHeight()) / ((float) i11);
                if (desiredHeight2 > f11) {
                    f12 += desiredHeight2 - f11;
                    f10 = f11;
                } else {
                    f10 = desiredHeight2;
                }
                if (desiredHeight2 < 0.2f) {
                    float min = Math.min(0.2f - desiredHeight2, f12);
                    f12 -= min;
                    f10 = desiredHeight2 + min;
                }
                Logging.logdPair("\t(desired, granted)", desiredHeight2, f10);
                viewMeasure.setMaxDimens(this.f10240w, (int) (f10 * ((float) i10)));
            }
            return;
        }
        throw new IllegalStateException("VerticalViewGroupMeasure only supports up to 5 children");
    }

    public int getTotalFixedHeight() {
        int i10 = 0;
        for (ViewMeasure next : this.vms) {
            if (!next.isFlex()) {
                i10 += next.getDesiredHeight();
            }
        }
        return i10;
    }

    public int getTotalHeight() {
        int i10 = 0;
        for (ViewMeasure desiredHeight : this.vms) {
            i10 += desiredHeight.getDesiredHeight();
        }
        return i10;
    }

    public List<ViewMeasure> getViews() {
        return this.vms;
    }

    public void reset(int i10, int i11) {
        this.f10240w = i10;
        this.f10239h = i11;
        this.vms = new ArrayList();
    }

    public VerticalViewGroupMeasure() {
        this.vms = new ArrayList();
        this.f10240w = 0;
        this.f10239h = 0;
    }
}
