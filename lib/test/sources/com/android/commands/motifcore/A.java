package com.android.commands.motifcore;

import android.util.Log;
import java.util.List;
/* loaded from: classes.dex */
class A implements InterfaceC0030y {
    private A() {
    }

    @Override // com.android.commands.motifcore.InterfaceC0030y
    public C0031z a(List list, InterfaceC0024s interfaceC0024s) {
        int c;
        if (list.size() == 2) {
            c = C0022q.c((String) list.get(1));
            if (c < 0) {
                Log.e("MonkeyStub", "Can't find keyname: " + ((String) list.get(1)));
                return C0022q.a;
            }
            interfaceC0024s.a(new C0016k(0, c));
            interfaceC0024s.a(new C0016k(1, c));
            return C0022q.d;
        }
        return C0022q.a;
    }
}
