package com.android.a.a;

import android.app.UiAutomation;
import android.view.accessibility.AccessibilityEvent;
/* loaded from: classes.dex */
class A implements UiAutomation.AccessibilityEventFilter {
    final /* synthetic */ y a;
    final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(y yVar, String str) {
        this.a = yVar;
        this.b = str;
    }

    @Override // android.app.UiAutomation.AccessibilityEventFilter
    public boolean accept(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 2048) {
            return this.b == null || this.b.equals(accessibilityEvent.getPackageName());
        }
        return false;
    }
}
