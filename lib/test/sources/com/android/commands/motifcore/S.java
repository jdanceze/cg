package com.android.commands.motifcore;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class S implements InterfaceC0030y {
    @Override // com.android.commands.motifcore.InterfaceC0030y
    public C0031z a(List list, InterfaceC0024s interfaceC0024s) {
        Map map;
        if (list.size() == 2) {
            map = H.a;
            V v = (V) map.get(list.get(1));
            return v == null ? new C0031z(false, "unknown var") : new C0031z(true, v.a());
        }
        return C0022q.a;
    }
}
