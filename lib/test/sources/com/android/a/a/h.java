package com.android.a.a;

import android.app.UiAutomation;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements UiAutomation.AccessibilityEventFilter {
    List a;
    int b;
    final /* synthetic */ C0003d c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(C0003d c0003d, int i, List list) {
        this.c = c0003d;
        this.b = i;
        this.a = list;
    }

    @Override // android.app.UiAutomation.AccessibilityEventFilter
    public boolean accept(AccessibilityEvent accessibilityEvent) {
        if ((accessibilityEvent.getEventType() & this.b) != 0) {
            this.a.add(AccessibilityEvent.obtain(accessibilityEvent));
            return false;
        }
        return false;
    }
}
