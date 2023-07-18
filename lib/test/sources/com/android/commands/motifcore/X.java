package com.android.commands.motifcore;

import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.reflect.Field;
import java.util.List;
/* loaded from: classes.dex */
public class X implements an {
    @Override // com.android.commands.motifcore.an
    public C0031z a(AccessibilityNodeInfo accessibilityNodeInfo, List list) {
        if (list.size() == 0) {
            try {
                Field declaredField = accessibilityNodeInfo.getClass().getDeclaredField("mAccessibilityViewId");
                declaredField.setAccessible(true);
                return new C0031z(true, accessibilityNodeInfo.getWindowId() + " " + ((Integer) declaredField.get(accessibilityNodeInfo)).intValue());
            } catch (IllegalAccessException e) {
                return new C0031z(false, "Access exception");
            } catch (NoSuchFieldException e2) {
                return new C0031z(false, "Node with given ID does not exist");
            }
        }
        return C0022q.a;
    }
}
