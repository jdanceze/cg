package com.android.commands.motifcore;

import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class ak implements InterfaceC0030y {
    @Override // com.android.commands.motifcore.InterfaceC0030y
    public C0031z a(List list, InterfaceC0024s interfaceC0024s) {
        AccessibilityNodeInfo d;
        String str;
        List subList;
        Map map;
        if (list.size() > 2) {
            String str2 = (String) list.get(1);
            if ("viewid".equals(str2)) {
                try {
                    d = W.b((String) list.get(2));
                    str = (String) list.get(3);
                    subList = list.subList(4, list.size());
                } catch (av e) {
                    return new C0031z(false, e.getMessage());
                }
            } else if (!str2.equals("accessibilityids")) {
                return C0022q.a;
            } else {
                try {
                    d = W.d((String) list.get(2), (String) list.get(3));
                    str = (String) list.get(4);
                    subList = list.subList(5, list.size());
                } catch (NumberFormatException e2) {
                    return C0022q.a;
                }
            }
            if (d == null) {
                return new C0031z(false, "Node with given ID does not exist");
            }
            map = W.c;
            an anVar = (an) map.get(str);
            return anVar != null ? anVar.a(d, subList) : C0022q.a;
        }
        return C0022q.a;
    }
}
