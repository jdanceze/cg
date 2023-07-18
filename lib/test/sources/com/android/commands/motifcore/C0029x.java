package com.android.commands.motifcore;

import android.util.Log;
import java.util.List;
/* renamed from: com.android.commands.motifcore.x  reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0029x implements InterfaceC0030y {
    private C0029x() {
    }

    @Override // com.android.commands.motifcore.InterfaceC0030y
    public C0031z a(List list, InterfaceC0024s interfaceC0024s) {
        int c;
        if (list.size() == 3) {
            c = C0022q.c((String) list.get(2));
            if (c < 0) {
                Log.e("MonkeyStub", "Can't find keyname: " + ((String) list.get(2)));
                return C0022q.a;
            }
            Log.d("MonkeyStub", "keycode: " + c);
            int i = "down".equals(list.get(1)) ? 0 : "up".equals(list.get(1)) ? 1 : -1;
            if (i == -1) {
                Log.e("MonkeyStub", "got unknown action.");
                return C0022q.a;
            }
            interfaceC0024s.a(new C0016k(i, c));
            return C0022q.d;
        }
        return C0022q.a;
    }
}
