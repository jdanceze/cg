package com.android.commands.motifcore;

import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;
/* loaded from: classes.dex */
public class al implements an {
    @Override // com.android.commands.motifcore.an
    public C0031z a(AccessibilityNodeInfo accessibilityNodeInfo, List list) {
        boolean performAction;
        if (list.size() == 1) {
            if (Boolean.valueOf((String) list.get(0)).booleanValue()) {
                performAction = accessibilityNodeInfo.performAction(1);
            } else if (Boolean.valueOf((String) list.get(0)).booleanValue()) {
                return C0022q.a;
            } else {
                performAction = accessibilityNodeInfo.performAction(2);
            }
            return new C0031z(performAction);
        }
        return C0022q.a;
    }
}
