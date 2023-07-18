package com.android.commands.motifcore;

import android.util.Log;
import java.util.List;
/* loaded from: classes.dex */
class C implements InterfaceC0030y {
    private C() {
    }

    @Override // com.android.commands.motifcore.InterfaceC0030y
    public C0031z a(List list, InterfaceC0024s interfaceC0024s) {
        if (list.size() == 3) {
            try {
                int parseInt = Integer.parseInt((String) list.get(1));
                int parseInt2 = Integer.parseInt((String) list.get(2));
                interfaceC0024s.a(new as(0).a(0, parseInt, parseInt2));
                interfaceC0024s.a(new as(1).a(0, parseInt, parseInt2));
                return C0022q.d;
            } catch (NumberFormatException e) {
                Log.e("MonkeyStub", "Got something that wasn't a number", e);
                return C0022q.a;
            }
        }
        return C0022q.a;
    }
}
