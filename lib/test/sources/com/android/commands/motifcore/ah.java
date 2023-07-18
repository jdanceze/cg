package com.android.commands.motifcore;

import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;
/* loaded from: classes.dex */
public class ah implements an {
    @Override // com.android.commands.motifcore.an
    public C0031z a(AccessibilityNodeInfo accessibilityNodeInfo, List list) {
        return list.size() == 0 ? accessibilityNodeInfo.isPassword() ? new C0031z(false, "Node contains a password") : accessibilityNodeInfo.getText() == null ? new C0031z(true, "") : new C0031z(true, accessibilityNodeInfo.getText().toString()) : C0022q.a;
    }
}
