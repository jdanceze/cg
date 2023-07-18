package com.android.commands.motifcore;

import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;
/* loaded from: classes.dex */
public class ag implements an {
    @Override // com.android.commands.motifcore.an
    public C0031z a(AccessibilityNodeInfo accessibilityNodeInfo, List list) {
        return list.size() == 0 ? new C0031z(true, Boolean.toString(accessibilityNodeInfo.isSelected())) : C0022q.a;
    }
}
