package com.android.commands.motifcore;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;
/* loaded from: classes.dex */
public class ad implements an {
    @Override // com.android.commands.motifcore.an
    public C0031z a(AccessibilityNodeInfo accessibilityNodeInfo, List list) {
        if (list.size() == 0) {
            Rect rect = new Rect();
            accessibilityNodeInfo.getBoundsInScreen(rect);
            StringBuilder sb = new StringBuilder();
            sb.append(rect.left).append(" ").append(rect.top);
            sb.append(" ").append(rect.right - rect.left).append(" ");
            sb.append(rect.bottom - rect.top);
            return new C0031z(true, sb.toString());
        }
        return C0022q.a;
    }
}
