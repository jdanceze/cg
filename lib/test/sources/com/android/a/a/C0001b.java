package com.android.a.a;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;
/* renamed from: com.android.a.a.b  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0001b {
    C0001b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Rect a(AccessibilityNodeInfo accessibilityNodeInfo, int i, int i2) {
        if (accessibilityNodeInfo == null) {
            return null;
        }
        Rect rect = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect);
        Rect rect2 = new Rect();
        rect2.top = 0;
        rect2.left = 0;
        rect2.right = i;
        rect2.bottom = i2;
        rect.intersect(rect2);
        return rect;
    }
}
