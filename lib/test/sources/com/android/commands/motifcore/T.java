package com.android.commands.motifcore;

import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class T implements InterfaceC0030y {
    @Override // com.android.commands.motifcore.InterfaceC0030y
    public C0031z a(List list, InterfaceC0024s interfaceC0024s) {
        Map map;
        map = H.a;
        Set<String> keySet = map.keySet();
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : keySet) {
            stringBuffer.append(str).append(" ");
        }
        return new C0031z(true, stringBuffer.toString());
    }
}
