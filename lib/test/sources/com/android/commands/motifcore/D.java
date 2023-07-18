package com.android.commands.motifcore;

import android.util.Log;
import java.util.List;
/* loaded from: classes.dex */
class D implements InterfaceC0030y {
    private D() {
    }

    @Override // com.android.commands.motifcore.InterfaceC0030y
    public C0031z a(List list, InterfaceC0024s interfaceC0024s) {
        if (list.size() == 4) {
            String str = (String) list.get(1);
            try {
                int parseInt = Integer.parseInt((String) list.get(2));
                int parseInt2 = Integer.parseInt((String) list.get(3));
                int i = "down".equals(str) ? 0 : "up".equals(str) ? 1 : "move".equals(str) ? 2 : -1;
                if (i == -1) {
                    Log.e("MonkeyStub", "Got a bad action: " + str);
                    return C0022q.a;
                }
                interfaceC0024s.a(new as(i).a(0, parseInt, parseInt2));
                return C0022q.d;
            } catch (NumberFormatException e) {
                Log.e("MonkeyStub", "Got something that wasn't a number", e);
                return C0022q.a;
            }
        }
        return C0022q.a;
    }
}
