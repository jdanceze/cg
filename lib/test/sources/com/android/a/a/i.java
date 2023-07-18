package com.android.a.a;

import android.app.UiAutomation;
import android.view.accessibility.AccessibilityEvent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements UiAutomation.AccessibilityEventFilter {
    int a;
    final /* synthetic */ C0003d b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(C0003d c0003d, int i) {
        this.b = c0003d;
        this.a = i;
    }

    @Override // android.app.UiAutomation.AccessibilityEventFilter
    public boolean accept(AccessibilityEvent accessibilityEvent) {
        if ((accessibilityEvent.getEventType() & this.a) != 0) {
            this.a &= accessibilityEvent.getEventType() ^ (-1);
            if (this.a == 0) {
                return true;
            }
        }
        return false;
    }
}
