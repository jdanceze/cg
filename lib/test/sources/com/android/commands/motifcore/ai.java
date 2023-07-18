package com.android.commands.motifcore;

import android.view.accessibility.AccessibilityInteractionClient;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ai implements InterfaceC0030y {
    @Override // com.android.commands.motifcore.InterfaceC0030y
    public C0031z a(List list, InterfaceC0024s interfaceC0024s) {
        if (list.size() == 2) {
            int connectionId = W.a.getConnectionId();
            List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = AccessibilityInteractionClient.getInstance().findAccessibilityNodeInfosByText(connectionId, -1, AccessibilityNodeInfo.ROOT_NODE_ID, (String) list.get(1));
            X x = new X();
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
                C0031z a = x.a(accessibilityNodeInfo, arrayList);
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
