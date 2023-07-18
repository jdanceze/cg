package com.android.commands.motifcore;

import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class Z implements an {
    @Override // com.android.commands.motifcore.an
    public C0031z a(AccessibilityNodeInfo accessibilityNodeInfo, List list) {
        if (list.size() == 0) {
            X x = new X();
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            int childCount = accessibilityNodeInfo.getChildCount();
            for (int i = 0; i < childCount; i++) {
                C0031z a = x.a(accessibilityNodeInfo.getChild(i), arrayList);
                if (!a.c()) {
                    return a;
                }
                sb.append(a.a()).append(" ");
            }
            return new C0031z(true, sb.toString());
        }
        return C0022q.a;
    }
}
