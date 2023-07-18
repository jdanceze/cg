package com.android.commands.motifcore;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import java.util.List;
/* loaded from: classes.dex */
class F implements InterfaceC0030y {
    private F() {
    }

    @Override // com.android.commands.motifcore.InterfaceC0030y
    public C0031z a(List list, InterfaceC0024s interfaceC0024s) {
        if (list.size() == 2) {
            for (KeyEvent keyEvent : KeyCharacterMap.load(-1).getEvents(((String) list.get(1)).toString().toCharArray())) {
                interfaceC0024s.a(new C0016k(keyEvent));
            }
            return C0022q.d;
        }
        return C0022q.a;
    }
}
