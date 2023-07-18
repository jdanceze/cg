package com.android.commands.motifcore;

import android.util.Log;
import java.util.List;
/* loaded from: classes.dex */
class B implements InterfaceC0030y {
    private B() {
    }

    @Override // com.android.commands.motifcore.InterfaceC0030y
    public C0031z a(List list, InterfaceC0024s interfaceC0024s) {
        if (list.size() == 2) {
            String str = (String) list.get(1);
            try {
                interfaceC0024s.a(new ar(Integer.parseInt(str)));
                return C0022q.d;
            } catch (NumberFormatException e) {
                Log.e("MonkeyStub", "Not a number: " + str, e);
                return C0022q.a;
            }
        }
        return C0022q.a;
    }
}
