package com.android.commands.motifcore;

import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ae implements an {
    @Override // com.android.commands.motifcore.an
    public C0031z a(AccessibilityNodeInfo accessibilityNodeInfo, List list) {
        if (list.size() == 0) {
            AccessibilityNodeInfo parent = accessibilityNodeInfo.getParent();
            return parent == null ? new C0031z(false, "Given node has no parent") : new X().a(parent, new ArrayList());
        }
        return C0022q.a;
    }
}
