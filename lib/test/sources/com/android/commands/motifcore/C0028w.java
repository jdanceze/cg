package com.android.commands.motifcore;

import java.util.List;
/* renamed from: com.android.commands.motifcore.w  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0028w implements InterfaceC0030y {
    private C0028w() {
    }

    @Override // com.android.commands.motifcore.InterfaceC0030y
    public C0031z a(List list, InterfaceC0024s interfaceC0024s) {
        if (list.size() > 1) {
            String str = (String) list.get(1);
            if ("open".equals(str)) {
                interfaceC0024s.a(new C0011f(true));
                return C0022q.d;
            } else if ("close".equals(str)) {
                interfaceC0024s.a(new C0011f(false));
                return C0022q.d;
            }
        }
        return C0022q.a;
    }
}
