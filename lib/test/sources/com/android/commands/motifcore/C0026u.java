package com.android.commands.motifcore;

import java.util.List;
import java.util.Map;
/* renamed from: com.android.commands.motifcore.u  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0026u implements InterfaceC0030y {
    private C0026u() {
    }

    @Override // com.android.commands.motifcore.InterfaceC0030y
    public C0031z a(List list, InterfaceC0024s interfaceC0024s) {
        Map map;
        if (list.size() > 3) {
            if (!((String) list.get(1)).equals("screenchange")) {
                return C0022q.a;
            }
            long parseLong = Long.parseLong((String) list.get(2));
            map = C0022q.e;
            InterfaceC0030y interfaceC0030y = (InterfaceC0030y) map.get(list.get(3));
            if (interfaceC0030y != null) {
                C0027v unused = C0022q.k = new C0027v(1, interfaceC0030y.a(list.subList(3, list.size()), interfaceC0024s), parseLong);
                return C0022q.d;
            }
        }
        return C0022q.a;
    }
}
